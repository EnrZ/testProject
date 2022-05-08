package org.launchcode.testProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParams(@RequestParam String name) {
       //this method expects a query parameter called name(bc of requestparam), name has to match
        return "Hello, " + name + "!";
    }

    //The past method is one way to create a dynamic request handler

//    @GetMapping("venus/{orbiter}")
//    @ResponseBody
//    public String venusOrbiter(@PathVariable String orbiter){
//        return orbiter + " currently orbits Venus.";
//
//}

    //http://localhost:8080/form name='name' works bc of the helloWithQueryParams method
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'hello'>" + //tells it to submit a request to /hello
                "<input type = 'text' name ='name'>" +
                "<input type = 'submit' value = 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
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


}
