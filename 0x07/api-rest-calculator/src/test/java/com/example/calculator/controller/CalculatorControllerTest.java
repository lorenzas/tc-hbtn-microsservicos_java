package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        this.mvc
                .perform(get("/calculator/addNumbers?number1=5.0&number2=10.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("15.0"));
    }

    @Test
    void subNumbers() throws Exception {
        this.mvc
                .perform(get("/calculator/subNumbers?number1=10.0&number2=5.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void divideNumbers() throws Exception {
        this.mvc
                .perform(get("/calculator/divideNumbers?number1=15.0&number2=5.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    void factorial() throws Exception {
        this.mvc
                .perform(get("/calculator/factorial?factorial=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("120"));
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        this.mvc
                .perform(get("/calculator/calculeDayBetweenDate?localDate1=2000-05-10&localDate2=2000-05-30"))
                .andExpect(status().isOk())
                .andExpect(content().string("20"));
    }

    @Test
    void integerToBinary() throws Exception {
        this.mvc
                .perform(get("/calculator/integerToBinary?number1=20"))
                .andExpect(status().isOk())
                .andExpect(content().string("10100"));
    }

    @Test
    void integerToHexadecimal() throws Exception {
        this.mvc
                .perform(get("/calculator/integerToHexadecimal?number1=170"))
                .andExpect(status().isOk())
                .andExpect(content().string("AA"));
    }
}
