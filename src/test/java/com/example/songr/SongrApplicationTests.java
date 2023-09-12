package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_HelloWorld_Route_index_page() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("<h1>Hello World</h1>")));
    }

    @Test
    public void test_Album_Post_Creation() throws Exception {
        mockMvc.perform(
                        post("/save")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                .param("title", "alf layla wa layla")
                                .param("artist", "om kolthoum")
                                .param("songCount", String.valueOf(14))
                                .param("length", String.valueOf(3))
                                .param("imageUrl", "https://i.ytimg.com/vi/ul4z6sLnXYY/maxresdefault.jpg")

                )
                .andExpect(redirectedUrl("/"))
                .andExpect(status().isFound());
    }


}
