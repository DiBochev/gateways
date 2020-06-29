package com.musalasoft.gateways.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "peripheral")
public class Peripheral {

    
    /**
     *   a UID (number)
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    @JsonProperty("UID")
    private Long id;

    
    /**
     * vendor (string), 
     */
    @Column(name="vendor")
    @JsonProperty("vendor") 
    private String vendor;
    
    /**
     * date created
     */
    @Temporal(value = TemporalType.DATE)
    @Column(name="date")
    @JsonProperty("date")
    private Date date;
    
    /**
     * status - online/offline
     */
    @Column(name="is_online")
    @JsonProperty("isOnline")
    private boolean isOnline;

    public Long getId() {
        return id;
    }
    
    public String getVendor() {
        return vendor;
    }

    public Date getDate() {
        return date;
    }

    public boolean isIsOnline() {
        return isOnline;
    }
}
