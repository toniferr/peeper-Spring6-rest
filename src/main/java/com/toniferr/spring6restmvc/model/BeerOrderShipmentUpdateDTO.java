package com.toniferr.spring6restmvc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by toniferr.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerOrderShipmentUpdateDTO {

    @NotBlank
    private String trackingNumber;
}
