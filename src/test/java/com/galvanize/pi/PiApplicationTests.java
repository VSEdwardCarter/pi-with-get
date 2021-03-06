package com.galvanize.pi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MathService.class)
//@SpringBootTest
@RunWith(SpringRunner.class)
class PiApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	void contextLoads() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");

		this.mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("3.141592653589793"));
	}

}