package com.musalasoft.gateways.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Component
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "gateway")
public class Gateway {

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    @JsonProperty("id")
    private Long id;
    
    /**
     *    a unique serial number (string)
     */
    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;
    
    /**
     * human-readable name (string) 
     */
    @Column(name="name")
    @JsonProperty("name") 
    private String mName;
    
    /**
     * IPv4 address (to be validated)
     */
    @Column(name="ip")
    @JsonProperty("ip") 
    private String ip;

    /**
     * multiple associated peripheral devices
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "gatewayId", nullable = false)
    @JsonProperty("peripherals")
    private List<Peripheral> peripherals;

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return mName;
    }

    public String getIp() {
        return ip;
    }

    public List<Peripheral> getPeripherals() {
        return peripherals;
    }
    
}
