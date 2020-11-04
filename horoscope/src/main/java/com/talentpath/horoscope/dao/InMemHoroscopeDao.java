package com.talentpath.horoscope.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile({"servicetesting", "inmemtesting"})
public class InMemHoroscopeDao implements HoroscopeDao {

    Map<String, String[]> allMessages = new HashMap<>();

    public InMemHoroscopeDao(){
        String[] geminiMessages = new String[12];
        geminiMessages[0] = "a";
        geminiMessages[1] = "b";
        geminiMessages[2] = "c";
        geminiMessages[3] = "d";
        geminiMessages[4] = "e";
        geminiMessages[5] = "f";
        geminiMessages[6] = "g";
        geminiMessages[7] = "h";
        geminiMessages[8] = "i";
        geminiMessages[9] = "j";
        geminiMessages[10] = "k";
        geminiMessages[11] = "l";

        allMessages.put("Gemini", geminiMessages);
        allMessages.put("Libra", geminiMessages);
        allMessages.put("Leo", geminiMessages);
        allMessages.put("Sagittarius", geminiMessages);
        allMessages.put("Taurus", geminiMessages);
        allMessages.put("Aries", geminiMessages);
        allMessages.put("Pisces", geminiMessages);
        allMessages.put("Capricorn", geminiMessages);
        allMessages.put("Virgo", geminiMessages);
        allMessages.put("Aquarius", geminiMessages);
        allMessages.put("Cancer", geminiMessages);
        allMessages.put("Scorpio", geminiMessages);

    }

    @Override
    public String getMessage(String sign, int monthValue) {

        String[] monthlyMessages = allMessages.get(sign);

        return monthlyMessages[monthValue-1];
    }
}
