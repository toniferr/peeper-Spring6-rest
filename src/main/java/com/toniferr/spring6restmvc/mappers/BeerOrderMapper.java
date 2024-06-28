package com.toniferr.spring6restmvc.mappers;

import com.toniferr.spring6restmvc.entities.BeerOrder;
import com.toniferr.spring6restmvc.entities.BeerOrderLine;
import com.toniferr.spring6restmvc.entities.BeerOrderShipment;
import com.toniferr.spring6restmvc.model.BeerOrderDTO;
import com.toniferr.spring6restmvc.model.BeerOrderLineDTO;
import com.toniferr.spring6restmvc.model.BeerOrderShipmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by toniferr.
 */
@Mapper
public interface BeerOrderMapper {

    @Mapping(target = "beerOrder", ignore = true)
    BeerOrderShipment beerOrderShipmentDtoToBeerOrderShipment(BeerOrderShipmentDTO beerOrderShipmentDTO);

    BeerOrderShipmentDTO beerOrderShipmentToBeerOrderShipmentDto(BeerOrderShipment beerOrderShipment);

    @Mapping(target = "beerOrder", ignore = true)
    BeerOrderLine beerOrderLineDtoToBeerOrderLine(BeerOrderLineDTO beerOrderLineDTO);

    BeerOrderLineDTO beerOrderLineToBeerOrderLineDto(BeerOrderLine beerOrderLine);

    BeerOrder beerOrderDtoToBeerOrder(BeerOrderDTO beerOrder);

    BeerOrderDTO beerOrderToBeerOrderDto(BeerOrder beerOrder);
}
