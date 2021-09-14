package com.galvanize.pi;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/math")
public class MathService {

    @GetMapping("/pi")
    public Object getPi(WebRequest wr) throws IOException {
        final HttpHeaders headers = new HttpHeaders();

        switch (wr.getHeader("content-type")) { // Switching based on the WebRequest Header value for Content-Type
            case "application/json":
                headers.setContentType(MediaType.APPLICATION_JSON);
                return "{\"PI\": \"3.141592653589793\"}";
            case "image/png":
                headers.setContentType(MediaType.IMAGE_PNG);
                return new ResponseEntity<byte[]>(Files.readAllBytes(Paths.get("/Users/t2186523/Documents/pi.png")), headers, HttpStatus.OK);
            default:
                return "3.141592653589793";
        }
    }

    @GetMapping("/calculate")
    public Object calculateVolume(WebRequest wr, @RequestParam Optional<String> operation, @RequestParam int x, @RequestParam int y) {
        final HttpHeaders headers = new HttpHeaders();
        if (operation.isEmpty()) return x + " + " + y + " = " + (x + y);
        return switch (operation.get()) {
            case "subtract"->x + " - " + y + " = " + (x - y);
            case "multiply"->x + " * " + y + " = " + (x * y);
            case "divide"->x + " / " + y + " = " + (x / y);
            default->x + " + " + y + " = " + (x + y);
        };
    }

    @PostMapping("/sum")
    public Object sum(WebRequest wr, @RequestParam Map<String, String> params) {
        final HttpHeaders headers = new HttpHeaders();
        String response = "";
        int total = 0;

        for (Map.Entry<String, String> val: params.entrySet()) {
            total += Integer.parseInt(val.getValue());
        }

        response += String.join(" + ", params.values());
        return response += " = " + total;
    }

    @RequestMapping("/volume/{x}/{y}/{z}")
    public Object volume(WebRequest wr, @PathVariable String x, @PathVariable String y, @PathVariable String z) {
        return "The volume of a " + x + "x" + y + "x" + z + " rectangle is " + (Integer.parseInt(x) * Integer.parseInt(y) * Integer.parseInt(z));
    }
}
