package com.makantayebi.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makantayebi.cms.model.Config;
import com.makantayebi.cms.service.ConfigService;

@RestController
@RequestMapping("/api/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @GetMapping
    public List<Config> getAllConfigs() {
        // TODO: change to get for the current user.
        List<Config> configs = configService.findAll();
        Config sample = new Config();
        sample.setId(1L);
        sample.setKey("Hardcoded Key");
        sample.setValue("Hardcoded Val");
        sample.setUser(null);
        configs.add(sample);
        return configs;
    }

    @PostMapping
    public ResponseEntity<Config> createConfig(@RequestBody Config config) {
        // TODO: add the user id?
        configService.save(config);
        return ResponseEntity.status(201).body(config);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long configId) {
        configService.delete(configId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Config> update(@PathVariable(value = "id") Long configId,
            @RequestBody Config config) {
        return configService.get(configId)
                .map(existingConfig -> {
                    existingConfig.setValue(config.getValue());
                    existingConfig.setKey(config.getKey());
                    existingConfig.setUser(config.getUser());
                    Config updatedConfig = configService.save(existingConfig);
                    return ResponseEntity.ok(updatedConfig);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
