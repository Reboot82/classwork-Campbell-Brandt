package com.talentpath.horoscope.controllers;

import com.talentpath.horoscope.exceptions.HoroscopeDaoException;
import com.talentpath.horoscope.exceptions.NullArgumentException;
import com.talentpath.horoscope.models.HoroscopeReading;
import com.talentpath.horoscope.models.ReadingRequest;
import com.talentpath.horoscope.services.HoroscopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class HoroscopeController {
    @Autowired
    HoroscopeService service;

    @GetMapping("/reading")
    public HoroscopeReading getReading(String name, String birthday) throws NullArgumentException, HoroscopeDaoException {
        ReadingRequest request = new ReadingRequest();
        request.setName(name);
        request.setBirthday(LocalDate.parse(birthday));

        return service.getReading(request);
    }

}
