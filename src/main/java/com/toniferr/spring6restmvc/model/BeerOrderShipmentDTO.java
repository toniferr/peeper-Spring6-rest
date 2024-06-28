package com.toniferr.spring6restmvc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by toniferr.
 */
@Data
@Builder
public class BeerOrderShipmentDTO {

    private UUID id;

    private Long version;

    @NotBlank
    private String trackingNumber;

    private Timestamp createdDate;
    private Timestamp lastModifiedDate;
}
