package com.github.reneranzinger.audiobook.wishlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AudiobookWishlistApplication
{
    private static final Logger logger = LoggerFactory
            .getLogger(AudiobookWishlistApplication.class);

    public static void main(String[] args)
    {
        logger.info("Starting AudiobookWishlistApplication::main");
        ConfigurableApplicationContext t_context = SpringApplication
                .run(AudiobookWishlistApplication.class, args);

        logger.info("Ending AudiobookWishlistApplication::main");
    }

}