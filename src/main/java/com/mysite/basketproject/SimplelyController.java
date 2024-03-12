/*
package com.mysite.basketproject;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class SimplelyController {

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
*/
