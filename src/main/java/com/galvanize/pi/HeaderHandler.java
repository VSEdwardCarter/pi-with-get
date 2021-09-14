package com.galvanize.pi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/header")
public class HeaderHandler {

    @GetMapping("")
    public Object getHeader(@RequestHeader String host) {
        return host;
    }
}
