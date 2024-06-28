package com.toniferr.spring6restmvc.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

/**
 * Created by toniferr.
 */
@Data
@Builder
public class BeerOrderUpdateDTO {
    private String customerRef;

    @NotNull
    private UUID customerId;

    private Set<BeerOrderLineUpdateDTO> beerOrderLines;

    private BeerOrderShipmentUpdateDTO beerOrderShipment;
}
