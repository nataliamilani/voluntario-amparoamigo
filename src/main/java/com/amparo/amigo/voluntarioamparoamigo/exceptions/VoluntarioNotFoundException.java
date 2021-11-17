package com.amparo.amigo.voluntarioamparoamigo.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class VoluntarioNotFoundException extends RuntimeException {

    public VoluntarioNotFoundException(String msg){ super(msg); }
}
