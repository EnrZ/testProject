package org.launchcode.testProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//every controller we make needs a new controller annotation
@Controller
public class HelloController {

    //create first controller handler method

    //responsebody tells springboot that this  method will return plain text http response

    //Handles request at path /hello

    //highlight ctrl + / to comment out

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }


    //http://localhost:8080/hello?name=_____________
    //Create a handler that handles request of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParams(@RequestParam String name, Model model) {
        //Model model added to params to send dynamic variable to
       //this method expects a query parameter called name(bc of requestparam), name has to match
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model){
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    //The past method is one way to create a dynamic request handler

//    @GetMapping("venus/{orbiter}")
//    @ResponseBody
//    public String venusOrbiter(@PathVariable String orbiter){
//        return orbiter + " currently orbits Venus.";
//
//}


    //making it a template with thymeleaf so long string with html no longer needed
    //http://localhost:8080/form name='name' works bc of the helloWithQueryParams method
    @GetMapping("form")
    public String helloForm() {
        return "form"; //@ResponseBody no longer needed after using templates, this connects the method to form.html
    }


    @GetMapping("hellolang")
    @ResponseBody
    public static String createMessage(@RequestParam String name, String languages) {
        //this method expects a query parameter called name(bc of requestparam), name has to match
        String diffLangHello = "";
        if (languages.equals("eng")) {
             diffLangHello = "Hello";
        } else if (languages.equals("alb")) {
             diffLangHello = "Përshëndetje";
        } else if (languages.equals("fre")) {
            diffLangHello = "Bonjour";
        }  else if (languages.equals("spa")) {
            diffLangHello = "Hola";
        }
        else if (languages.equals("chi")) {
                diffLangHello = "Nǐ hǎo";
    }
        String template = String.format("%s, %s!",diffLangHello, name);
    return template;
    }

    //http://localhost:8080/greeting
    @GetMapping("greeting")
    @ResponseBody
    public String greet() {
        return "<html>" +
                "<body>" +
                "<form action = 'hellolang'>" + //tells it to submit a request to /hello
                "<input type = 'text' name ='name'>" +
                "<select name=\"languages\">" +
                "<option value=\"eng\">English</option>" +
                "<option value=\"alb\">Albanian</option>" +
                "<option value=\"fre\">French</option>" +
                "<option value=\"spa\">Spanish</option>" +
                "<option value=\"chi\">Chinese</option>" +
                "<input type = 'submit' value = 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Javascript");
        model.addAttribute(("names"), names);
        return "hello-list";
    }


}
