package com.galvanize.pi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cookie")
public class CookieHandler {

    @GetMapping("")
    public Object getCookie(@CookieValue(name = "afc") String cookie) {
        return cookie;
    }
}
