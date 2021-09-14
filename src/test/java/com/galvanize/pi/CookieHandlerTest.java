package com.galvanize.pi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(CookieHandler.class)
//@SpringBootTest
@RunWith(SpringRunner.class)
class CookieHandlerTest {
    @Autowired
    MockMvc mvc;

    @Test
    void testCookies() throws Exception {
        this.mvc.perform(get("/cookie").cookie(new Cookie("afc", "swf")))
                .andExpect(status().isOk())
                .andExpect(content().string("swf"));
    }

}
