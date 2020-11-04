package com.talentpath.horoscope.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Hit unexpected database exception")
public class HoroscopeDaoException extends Exception{

    public HoroscopeDaoException(String message) {
        super(message);
    }

    public HoroscopeDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
