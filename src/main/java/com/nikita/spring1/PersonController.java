package com.nikita.spring1;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nikita.spring.model.Person;
import com.nikita.spring.service.PersonService;
import java.util.Random;

@Controller
public class PersonController {

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService ps;

    /*public String generateOTP() {
		Random random = new Random();
		String id = String.format("%04d", random.nextInt(10000));
		return id;
	}
     */
   /* @RequestMapping(value = "/authenticate2", method = RequestMethod.GET)
    public ModelAndView viewPage(@ModelAttribute("person") Person person) {
        ModelAndView mav = new ModelAndView("Person");
        List<Person> listPerson = ps.displayAll();
        mav.addObject("plist", listPerson);
        mav.setViewName("Person");
        return mav;
    }*/

    public void setPersonService(PersonService ps) {
        this.ps = ps;
    }
    
    

    @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
    public ModelAndView confirmpassword() 
    {
      return new ModelAndView("ChnagePassword");
		
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editpersonByadmin(HttpServletRequest request) {
        int Id = Integer.parseInt(request.getParameter("Id"));
        ModelAndView mav = new ModelAndView("edit");
        Person person = ps.getpersonById(Id);
        mav.addObject("person", person);
        return mav;

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@ModelAttribute Person person, @RequestParam String fname, HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> map) {
        ModelAndView modelAndView = new ModelAndView("Person");

        if (fname != null) {
            List<Person> listPerson = ps.searchByName(fname);
            map.put("person", person);
            map.put("plist", listPerson);

        }

        modelAndView.setViewName("Person");

        return modelAndView;

    }

    public String temp_otp = "";

    @RequestMapping(value = "/add", params = "action1", method = RequestMethod.GET)
    public ModelAndView personadd1(@ModelAttribute("Person") Person p) {

        temp_otp = ps.generateOtp();
        demo(temp_otp);

        // personadd2(p, temp_otp);
        PersonController pc = new PersonController();
        pc.sendMail(p.getEmail(), temp_otp, "confirm message");

        ModelAndView mav = new ModelAndView("Person");
        List<Person> listPerson = ps.displayAll();
        mav.addObject("plist", listPerson);
        mav.setViewName("Person");

        return mav;

        // sendMail
    }

    public String temp_3 = null;

    public void demo(String temp_otp2) {
        this.temp_3 = temp_otp2;
    }

    @RequestMapping(value = "/add", params = "action2", method = RequestMethod.GET)
    public ModelAndView personadd2(@ModelAttribute("Person") Person p) {

        if (p.getOTP().equals(temp_3)) {
            if (p.getId() == null || p.getId() == 0) {
                // new employee, add it
                ps.addPerson(p);
            }
            PersonController pc = new PersonController();
            pc.sendMail(p.getEmail(), "Person is added successfully", "confirm message");

            ModelAndView mav = new ModelAndView("Person");
            List<Person> listPerson = ps.displayAll();
            mav.addObject("plist", listPerson);
            mav.setViewName("Person");

            // String returnVal = "successful";
            return mav;

        } else {
            return new ModelAndView("invalid");
        }

        // sendMail
    }

    public String sendMail(String to, String message, String subject) {
        final Person p = new Person();
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pawarvihan5@gmail.com", "vihan@454");
            }
        });

        Message message1 = new MimeMessage(session);
        try {

            message1.setFrom(new InternetAddress("test@gmail.com"));
            message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message1.setSubject(subject);
            message1.setText(message);
            Transport.send(message1);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "Person";

    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
    public ModelAndView editEmployee(@ModelAttribute Person person) {
//        int personId = Integer.parseInt(request.getParameter("id"));
//        Person employee = ps.getPersonID(personId);
        ps.updateP(person);


        String message = "Person was successfully edited.";

        return new ModelAndView("succseful");
    }
// for delete the person details

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView persondelete(HttpServletRequest request) {
        int Id = Integer.parseInt(request.getParameter("Id"));
        this.ps.delete(Id);
        ModelAndView mav = new ModelAndView("Person");
        List<Person> listPerson = ps.displayAll();
        mav.addObject("plist", listPerson);
        mav.setViewName("Person");
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView updateperson(@ModelAttribute Person person) {

        ps.updateP(person);
        String message = "Person was successfully edited.";
        ModelAndView mav = new ModelAndView("Person");
        mav.addObject("message", message);
        List<Person> listPerson = ps.displayAll();
        mav.addObject("plist", listPerson);
        mav.setViewName("Person");

        return mav;

    }

}
