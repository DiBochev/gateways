package com.musalasoft.gateways.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.musalasoft.gateways.model.Gateway;


public interface GatewayRepository  extends JpaRepository<Gateway, Long> {

}
