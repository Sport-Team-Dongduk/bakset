package com.mysite.basketproject;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class SimpleController {

    @GetMapping("/example")
    public String SomeAction(@RequestParam("tEst")String test) {
        log.info("test = " + test);
        String res = "";
        if (test.equals("1")) {
            res = "one";
        } else if (test.equals("2")) {
            res = "two";
        } else {
            res = "nothing";
        }
        return res;
    }

    @PostMapping("/example2")
    public String PostAction(HttpServletRequest request) {
        String dd = request.getParameter("demo");
        log.info("input = " + dd);
        String rs = "";
        if(dd.equals("3")) {
            rs = "three";
        } else if(dd.equals("4")) {
            rs = "four";
        } else {
            rs = "nope";
        }
        return rs;
    }

}
