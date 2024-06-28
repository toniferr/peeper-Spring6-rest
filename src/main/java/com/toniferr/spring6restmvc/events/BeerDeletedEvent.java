package com.toniferr.spring6restmvc.events;

import com.toniferr.spring6restmvc.entities.Beer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;

/**
 * Created by toniferr.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class BeerDeletedEvent implements BeerEvent {
    private Beer beer;

    private Authentication authentication;
}
