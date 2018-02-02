package com.example.demo;


import java.text.SimpleDateFormat;
import java.util.Date;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 35000)
    public void repeatEveryFive() {
        RestTemplate restTemplate = new RestTemplate();
        Prices prices = restTemplate.getForObject(
                "https://api.cryptonator.com/api/full/btc-usd",Prices.class);
        log.info(prices.toString());
    }

}
