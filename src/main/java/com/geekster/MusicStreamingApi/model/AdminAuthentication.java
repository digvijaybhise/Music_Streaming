package com.geekster.MusicStreamingApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdminAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authenticationId;
    private String token;
    private LocalDateTime tokenCreationDate;

    @OneToOne
    private Admin admin;

    public AdminAuthentication(Admin admin) {
        this.token = UUID.randomUUID().toString();
        this.tokenCreationDate = LocalDateTime.now();
        this.admin = admin;
    }
}
