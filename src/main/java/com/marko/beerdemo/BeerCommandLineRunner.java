package com.marko.beerdemo;

import com.marko.beerdemo.db.Beer;
import com.marko.beerdemo.db.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/*
 * For demonstration purposes.
 */

@Component
public class BeerCommandLineRunner implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerCommandLineRunner(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Lav", "Jelen", "Zajecarsko", "Amstel", "Niksicko", "Merak", "Lasko")
                .forEach(beerName -> beerRepository.save(new Beer(beerName,
                        "Beer is one of the oldest and most widely consumed alcoholic drinks in the world, " +
                                "and the third most popular drink overall after water and tea.")));
    }

}
