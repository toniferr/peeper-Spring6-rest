package com.toniferr.spring6restmvc.listeners;

import com.toniferr.spring6restmvc.events.*;
import com.toniferr.spring6restmvc.events.*;
import com.toniferr.spring6restmvc.mappers.BeerMapper;
import com.toniferr.spring6restmvc.repositories.BeerAuditRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by toniferr.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class BeerCreatedListener {

    private final BeerMapper beerMapper;
    private final BeerAuditRepository beerAuditRepository;

    @Async //el evento se maneja en otro hilo diferente
    @EventListener
    public void listen(BeerEvent event) {

        val beerAudit = beerMapper.beerToBeerAudit(event.getBeer());

        String eventType = null;

        switch (event) {
            case BeerCreatedEvent beerCreatedEvent -> eventType = "BEER_CREATED";
            case BeerPatchedEvent beerPatchedEvent -> eventType = "BEER_PATCHED";
            case BeerUpdatedEvent beerUpdatedEvent -> eventType = "BEER_UPDATED";
            case BeerDeletedEvent beerDeletedEvent -> eventType = "BEER_DELETED";
            default -> eventType = "UNKNOWN";
        }

        beerAudit.setAuditEventType(eventType);

        if (event.getAuthentication() != null && event.getAuthentication().getName() != null) {
            beerAudit.setPrincipalName(event.getAuthentication().getName());
        }

        val savedBeerAudit = beerAuditRepository.save(beerAudit);
        log.debug("Beer Audit Saved: " + eventType + savedBeerAudit.getId());

    }
}
