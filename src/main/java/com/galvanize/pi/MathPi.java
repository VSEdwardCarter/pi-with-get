package com.galvanize.pi;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathPi {

    @GetMapping("/math/pi")
    public String getPi() {
        return "3.141592653589793";
    }
}
