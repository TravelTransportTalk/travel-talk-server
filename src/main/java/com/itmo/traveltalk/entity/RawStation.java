package com.itmo.traveltalk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stations_raw")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RawStation {

    @Column(name = "country_title")
    String countryTitle;
    @Column(name = "region_title")
    String regionTitle;
    @Column(name = "settlement_title")
    String settlementTitle;

    @Id
    @Column(name = "station_yndx_code")
    String stationYndxCode;
    @Column(name = "station_type")
    String stationType;

    String title;
    @Column(name = "transport_type")
    String transportType;
}
