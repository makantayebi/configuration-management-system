package com.makantayebi.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.makantayebi.cms.model.Config;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {

}
