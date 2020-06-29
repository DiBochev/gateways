package com.musalasoft.gateways.api;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.xml.bind.ValidationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musalasoft.gateways.model.Gateway;
import com.musalasoft.gateways.service.GatewayService;

@RequestMapping("api/v1/gateway")
@RestController
public class GatewayController {

    private final GatewayService mGatewayService;
    
    public GatewayController (GatewayService gatewayService) {
        mGatewayService = gatewayService;
    }
    
    @GetMapping
    public List<Gateway> getAllGateway() {
        return mGatewayService.getAllGateway();
    }
    
    ///api/v1/gateway/{id}
    @GetMapping(path = "{id}")
    public ResponseEntity<Gateway> getGatewayById(@PathVariable("id")Long id) {
        Optional<Gateway> tmp = mGatewayService.getGatewayById(id);
        if (tmp.isPresent()) {
            return ResponseEntity.ok(tmp.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<String> addGateway(@RequestBody Gateway gateway ) {
        try {
            gateway.setId(null); //do not update if exists record with that id
            mGatewayService.addGateway(gateway);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteGatewayById(@PathVariable("id") Long id) {
        try {
            mGatewayService.deleteGateway(id);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
    
    @PutMapping()
    public ResponseEntity<String> updateGateway(@RequestBody Gateway gatewayToUpdate) {
        try {
            mGatewayService.updateGateway(gatewayToUpdate);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
