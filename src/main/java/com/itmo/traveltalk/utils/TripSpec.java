package com.itmo.traveltalk.utils;

import com.itmo.traveltalk.entity.RawStation;
import com.itmo.traveltalk.entity.Transport;
import com.itmo.traveltalk.entity.Trip;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class TripSpec {

    public static final String CODE = "code";
    public static final String FROM= "from";
    public static final String TO = "to";
    public static final String DATE = "date";
    public static final String TRANSPORT = "transport";

    private TripSpec() {
        //empty
    }

    public static Specification<Trip> filterBy(TripFilter tripFilter) {
        return Specification
                .where(hasCode(tripFilter.getCode()))
                .and(hasFrom(tripFilter.getFrom()))
                .and(hasTo(tripFilter.getTo()))
                .and(hasDate(tripFilter.getDate()))
                .and(hasTransport(tripFilter.getTransport()));
    }

    private static Specification<Trip> hasCode(String code) {
        return ((root, query, cb) -> code == null || code.isEmpty() ? cb.conjunction() : cb.equal(root.get(CODE), code));
    }

    private static Specification<Trip> hasFrom(RawStation from) {
        return ((root, query, cb) -> from == null ? cb.conjunction() : cb.equal(root.get(FROM), from));
    }

    private static Specification<Trip> hasTo(RawStation to) {
        return ((root, query, cb) -> to == null ? cb.conjunction() : cb.equal(root.get(TO), to));
    }

    private static Specification<Trip> hasDate(Date date) {
        return ((root, query, cb) -> date == null ? cb.conjunction() : cb.greaterThanOrEqualTo(root.get(DATE), date));
    }

    private static Specification<Trip> hasTransport(Transport transport) {
        return (root, query, cb) -> transport == null ? cb.conjunction() : cb.equal(root.get(TRANSPORT), transport);
    }

}
