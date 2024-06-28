package com.toniferr.spring6restmvc.events;

import com.toniferr.spring6restmvc.entities.Beer;
import org.springframework.security.core.Authentication;

/**
 * Created by toniferr.
 */
public interface BeerEvent {

        Beer getBeer();

        Authentication getAuthentication();
}
