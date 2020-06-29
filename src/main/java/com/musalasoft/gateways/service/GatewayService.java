package com.musalasoft.gateways.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musalasoft.gateways.repository.GatewayRepository;
import com.musalasoft.gateways.model.Gateway;

@Service
public class GatewayService {

    private GatewayRepository gatewayRepository;
    
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    
    @Autowired
    public GatewayService(GatewayRepository gatewayDao) {
        gatewayRepository = gatewayDao;
    }
    
    public List<Gateway> getAllGateway() {
        return gatewayRepository.findAll();
    }
    
    public Optional<Gateway> getGatewayById(Long id) {
        return gatewayRepository.findById(id);
    }
    
    public void addGateway(Gateway gateway) throws ValidationException {
        validateGateway(gateway);
        gateway.setSerialNumber(UUID.randomUUID().toString());
        gatewayRepository.save(gateway);
    }
    
    public void deleteGateway(Long id) throws ValidationException {
        Optional<Gateway> entity = getGatewayById(id);
        if (!entity.isPresent()) {
            throw new ValidationException("No such element in the database.");
        }
        gatewayRepository.deleteById(id);
    }
    
    public void updateGateway(Gateway newGateway) throws ValidationException {
        if (newGateway.getId() == null) {
            throw new ValidationException("the id cannot be null");
        }
        validateGateway(newGateway);
        Optional<Gateway> entity = getGatewayById(newGateway.getId());
        if (!entity.isPresent()) {
            throw new ValidationException("No such element in the database.");
        }
        if (entity.get().getPeripherals().size() > 9) {
            throw new ValidationException("Peripheral devices are limited to 10 items per gateway.");
        }
        gatewayRepository.save(newGateway);
    }
    
    public static boolean validate(final String ip) {
        return PATTERN.matcher(ip).matches();
    }
    
    private boolean validateGateway(Gateway gateway) throws ValidationException {
        if (gateway.getPeripherals().size() > 9) {
            throw new ValidationException("Peripheral devices are limited to 10 items per gateway.");
        }
        if (!validate(gateway.getIp())) {
            throw new ValidationException("You should enter correct ip v4.");
        }
        return true;
    }

}
