<<<<<<< HEAD
package com.learning.BasicAttempts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
// hya class chya varti jr RequestMapping("/admin") lihila tr te tikda tasa reflect hota /admin/home -
// this is then used in context-mapping
public class TestController {
    // here GetMapping("/home") can also work
    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    // here GetMapping("/home") can also work
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/products")
    @ResponseBody
    public String products(){
        return "products";
    }

=======
package com.learning.BasicAttempts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
// hya class chya varti jr RequestMapping("/admin") lihila tr te tikda tasa reflect hota /admin/home -
// this is then used in context-mapping
public class TestController {
    // here GetMapping("/home") can also work
    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    // here GetMapping("/home") can also work
    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/products")
    @ResponseBody
    public String products(){
        return "products";
    }

>>>>>>> 42c98564d115e46ccdb32c6cdc29c55f4c7f0e8b
}