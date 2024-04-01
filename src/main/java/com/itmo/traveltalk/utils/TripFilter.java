package com.itmo.traveltalk.utils;

import com.itmo.traveltalk.entity.Location;
import com.itmo.traveltalk.entity.Transport;

import java.util.Date;

public class TripFilter {

    private Location from;

    private Location to;

    private Date date;

    private String code;

    private Transport transport;

    private TripFilter(){}

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public Transport getTransport() {
        return transport;
    }

    public static Builder newBuilder() {
        return new TripFilter().new Builder();
    }

    public class Builder {

        private Builder(){}

        public Builder setFrom(Location from) {
            TripFilter.this.from = from;
            return this;
        };

        public Builder setTo(Location to) {
            TripFilter.this.to = to;
            return this;
        };

        public Builder setDate(Date date) {
            TripFilter.this.date = date;
            return this;
        };

        public Builder setCode(String code) {
            TripFilter.this.code = code;
            return this;
        };

        public Builder setTransport(Transport transport) {
            TripFilter.this.transport= transport;
            return this;
        };

        public TripFilter build() {
            return TripFilter.this;
        }

    }

}
