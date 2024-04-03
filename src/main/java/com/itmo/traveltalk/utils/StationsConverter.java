package com.itmo.traveltalk.utils;

import java.util.Set;

import com.itmo.traveltalk.dto.StationShort;
import com.itmo.traveltalk.entity.RawStation;

public class StationsConverter {

    private static final Set<String> FEDERAL_CITIES = Set.of(
            "Москва",
            "Санкт-Петербург"
    );

    public static StationShort convert(RawStation raw) {
        return new StationShort(
                raw.getStationYndxCode(),
                raw.getTransportType(),
                raw.getTitle(),
                raw.getTitle() + ", " + constructRegionTitle(raw)
        );
    }

    private static String constructRegionTitle(RawStation raw) {
        if (raw.getSettlementTitle() == null) {
            return raw.getRegionTitle();
        } else {
            if (FEDERAL_CITIES.contains(raw.getSettlementTitle())) {
                return raw.getSettlementTitle();
            } else {
                return raw.getSettlementTitle() + ", " + raw.getRegionTitle();
            }
        }
    }



    private StationsConverter() { }
}
