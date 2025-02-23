package com.makantayebi.cms.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.makantayebi.cms.model.Config;
import com.makantayebi.cms.service.ConfigService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConfigController.class)
public class ConfigControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ConfigService configService; // Use @MockitoBean to mock the service layer

    // Test Create Config
    @Test
    public void testCreateConfig() throws Exception {
        Config config = new Config();
        config.setId(1L);
        config.setKey("the key");
        config.setValue("the value");
        Mockito.when(configService.save(Mockito.any(Config.class))).thenReturn(config);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/config")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"key\":\"the key\", \"value\":\"the value\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.key").value("the key"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.value").value("the value"));
    }

    // TODO: cover all of the CRUD with testing.
}
