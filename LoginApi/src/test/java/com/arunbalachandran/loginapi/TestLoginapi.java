package com.arunbalachandran.loginapi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.FileOutputStream;

public class TestLoginapi extends LoginapiApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testUser() throws Exception {
        // need to validate this
        UserProtos.User.Builder user = UserProtos.User.newBuilder();
        user.setName("arun");
        user.setEmail("balachandran.arun94@gmail.com");
        FileOutputStream output = new FileOutputStream("testfile.out");
        user.build().writeTo(output);
        output.close();
        // pass this output in to the POST request...
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/x-protobuf"));
    }

}
