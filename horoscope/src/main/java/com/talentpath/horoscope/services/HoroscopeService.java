package com.talentpath.horoscope.services;

import com.talentpath.horoscope.dao.HoroscopeDao;
import com.talentpath.horoscope.exceptions.HoroscopeDaoException;
import com.talentpath.horoscope.exceptions.NullArgumentException;
import com.talentpath.horoscope.models.HoroscopeReading;
import com.talentpath.horoscope.models.ReadingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.UnexpectedException;
import java.time.LocalDate;

@Component
public class HoroscopeService {

    @Autowired
    HoroscopeDao dao;

    public HoroscopeReading getReading(ReadingRequest request) throws NullArgumentException, HoroscopeDaoException {

        HoroscopeReading reading = new HoroscopeReading();

        reading.setName(request.getName());
        reading.setSign(getSignByDate(request.getBirthday()));
        reading.setMessage(dao.getMessage(reading.getSign(), LocalDate.now().getMonthValue()));

        return reading;
    }

    private String getSignByDate(LocalDate birthday) {
        Integer month = birthday.getMonthValue();
        Integer day = birthday.getDayOfMonth();

        if( (month == 3 && day >= 21) || (month == 4 && day <= 19) ) {
            return "Aries";
        } else if( (month == 4 && day >= 20) || (month == 5 && day <= 20) ) {
            return "Taurus";
        } else if( (month == 5 && day > 20) || (month == 6 && day <= 20) ) {
            return "Gemini";
        } else if( (month == 6 && day > 20) || (month == 7 && day < 23) ) {
            return "Cancer";
        } else if( (month == 7 && day >= 23) || (month == 8 && day < 23) ) {
            return "Leo";
        } else if( (month == 8 && day >= 23) || (month == 9 && day < 23) ) {
            return "Virgo";
        } else if( (month == 9 && day >= 23) || (month == 10 && day < 23) ) {
            return "Libra";
        } else if( (month == 10 && day >= 23) || (month == 11 && day < 22) ) {
            return "Scorpio";
        } else if( (month == 11 && day >= 22) || (month == 12 && day < 22) ) {
            return "Sagittarius";
        } else if( (month == 12 && day >= 22) || (month == 1 && day < 20) ) {
            return "Capricorn";
        } else if( (month == 1 && day >= 20) || (month == 2 && day < 19) ) {
            return "Aquarius";
        } else {
            return "Pisces";
        }
    }
}
