package com.galvanize.pi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathService.class)

@RunWith(SpringRunner.class)

class CalculateQueryStringsTest {
    @Autowired
    MockMvc mvc;

    @Test
    void testBasicMultiplicationThreeVariables() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate")
                .param("operation", "multiply")
                .param("x", "4")
                .param("y", "6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));
    }
    @Test
    void testBasicSubtractionThreeVariables() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate")
                .param("operation", "subtract")
                .param("x", "4")
                .param("y", "6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
    }

    @Test
    void testBasicAdditionThreeVariables() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate")
                .param("operation", "add")
                .param("x", "4")
                .param("y", "6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    void testBasicDivisionThreeVariables() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate")
                .param("operation", "divide")
                .param("x", "30")
                .param("y", "5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 5 = 6"));
    }

    @Test
    void testBasicMathDefaultsToAddition() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate")
                .param("x", "4")
                .param("y","6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    void testBasicMultiplicationPostThreeVariables() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum")
                .param("a", "4")
                .param("b", "5")
                .param("c", "6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }
}
