package com.makantayebi.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makantayebi.cms.model.Config;
import com.makantayebi.cms.repository.ConfigRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigService {

    @Autowired
    private ConfigRepository configRepository;

    public List<Config> findAll() {
        return configRepository.findAll();
    }

    public Optional<Config> get(Long id) {
        return configRepository.findById(id);
    }

    public Config save(Config config) {
        return configRepository.saveAndFlush(config);
    }

    public void delete(Long id) {
        configRepository.deleteById(id);
    }
}
