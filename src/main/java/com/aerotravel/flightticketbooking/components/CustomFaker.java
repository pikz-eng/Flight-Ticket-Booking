package com.aerotravel.flightticketbooking.components;

import com.aerotravel.flightticketbooking.model.Airport;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomFaker {

    Faker faker;

    @Autowired
    public CustomFaker(Faker faker) {
        this.faker = faker;
    }


    public List<Airport> createAirports() {
        Faker faker = new Faker();
        List<Airport> airports = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Airport airport = new Airport();
            airport.setAirportName(faker.name().firstName());
            airport.setAirportCode(faker.name().lastName());
            airport.setCity(faker.name().lastName());
            airport.setCountry(faker.name().lastName());
            airport.setState(faker.name().lastName());



            airports.add(airport);
        }
        return airports;
    }


}
