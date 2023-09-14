package com.example.tennisplayers.service;

import com.example.tennisplayers.model.TennisPlayerData;
import com.example.tennisplayers.model.TennisPlayersData;
import com.example.tennisplayers.model.TennisPlayersStats;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.*;

public class TennisPlayersService {
    private final TennisPlayersData tennisPlayersData;

    public TennisPlayersService() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource classPathResource = new ClassPathResource("headtohead.json");
        tennisPlayersData = objectMapper.readValue(classPathResource.getInputStream(), TennisPlayersData.class);
    }

    public TennisPlayersData getData() {
        return tennisPlayersData;
    }

    public TennisPlayerData getPlayerData(Long id) {
        for (TennisPlayerData tennisPlayerData : tennisPlayersData.getPlayers()) {
            if (tennisPlayerData.getId() == id) {
                return tennisPlayerData;
            }
        }

        return null;
    }

    public TennisPlayersStats getStats() {
        TennisPlayersStats stats = new TennisPlayersStats();

        // Calculating best country by ratio

        Map<String, List<Float>> countryRatiosMap = new HashMap();
        for (TennisPlayerData tennisPlayerData : tennisPlayersData.getPlayers()) {
            float playerRatio = (float) tennisPlayerData.getData().getLast().stream().mapToInt(Integer::intValue).sum() / tennisPlayerData.getData().getLast().size();
            String country = tennisPlayerData.getCountry().getCode();
            if (countryRatiosMap.containsKey(country)) {
                List<Float> ratioList = new ArrayList<Float>(countryRatiosMap.get(country));
                ratioList.add(playerRatio);
                countryRatiosMap.replace(country, ratioList);
            }

            else {
                countryRatiosMap.put(country, List.of(playerRatio));
            }
        }

        Map<String, Float> countryRatiosMapFlat = new HashMap<>();

        for (Map.Entry<String, List<Float>> entry : countryRatiosMap.entrySet()) {
            countryRatiosMapFlat.put(entry.getKey(), entry.getValue().stream().reduce(0f, Float::sum) / entry.getValue().size());
        }

        stats.setBestRatioCountry(Collections.max(countryRatiosMapFlat.entrySet(), Map.Entry.comparingByValue()).getKey());

        // Calculating average IMC

        float imc = 0f;
        List<Float> heights = new ArrayList<>();

        for (TennisPlayerData tennisPlayerData : tennisPlayersData.getPlayers()) {
            float height = (float) tennisPlayerData.getData().getHeight() / 100;
            int weight = tennisPlayerData.getData().getWeight() / 1000;

            imc += (float) weight / (height * height);
            heights.add(height);
        }

        imc /= tennisPlayersData.getPlayers().size();

        stats.setAverageIMC(imc);

        // Calculating median height

        Collections.sort(heights);
        float medianHeight;

        if (heights.size() % 2 == 0) {
            medianHeight = (heights.get(heights.size() / 2) + heights.get(heights.size() / 2 + 1)) / 2;
        }

        else {
            medianHeight = (heights.get((heights.size() + 1) / 2));
        }

        stats.setMedianHeight(medianHeight);

        return stats;
    }
}
