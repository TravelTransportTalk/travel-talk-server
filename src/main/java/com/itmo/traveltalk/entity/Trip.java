package com.itmo.traveltalk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "trips")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "trip_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private Location from;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private Location to;

    private Date date;

    private OffsetTime time;

    private String code;

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User authorId;

    public Trip(Location from, Location to, Date date, OffsetTime time, String code, Transport transport, User authorId) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
        this.code = code;
        this.transport = transport;
        this.authorId = authorId;
    }
}
