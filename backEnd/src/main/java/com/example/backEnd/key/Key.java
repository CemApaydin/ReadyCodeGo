package com.example.backEnd.key;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Random;
import java.util.Set;

@Entity
@Table(name="key")
@Data
@CrossOrigin
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keyID;
    private String keyType;
    private String key;

    public Key (String key) {
       this.keyType = null;
       this.key = key;

    }
    public Key () {
        keyType = null;
        key = null;

    }
    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }
    public Long getKeyID() {
        return keyID;
    }

    public void setKeyID(Long keyID) {
        this.keyID = keyID;
    }
    public String generateToken()
    {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@.-*!";
        StringBuilder key = new StringBuilder();
        Random rnd = new Random();
        while (key.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            key.append(chars.charAt(index));
        }
        String newKey = key.toString();
        return newKey;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
