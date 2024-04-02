package com.itmo.traveltalk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "user_id")
    private UUID id;

    private String nick;

    private String fullName;

    private String description;

    private String tgUsername;

    private Integer tgId;

    public User(String nick, String fullName, String description, String tgUsername, Integer tgId) {
        this.nick = nick;
        this.fullName = fullName;
        this.description = description;
        this.tgUsername = tgUsername;
        this.tgId = tgId;
    }
}

