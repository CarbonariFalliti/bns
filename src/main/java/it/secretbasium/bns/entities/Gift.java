package it.secretbasium.bns.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gifts")
public class Gift {
    @Id
    private String id;
    private String name;
    private byte review;
    




}
