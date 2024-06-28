package com.toniferr.spring6restmvc.mappers;

import com.toniferr.spring6restmvc.entities.Beer;
import com.toniferr.spring6restmvc.entities.BeerAudit;
import com.toniferr.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by toniferr.
 */
@Mapper
public interface BeerMapper {

    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "beerOrderLines", ignore = true)
    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);

    @Mapping(target = "createdDateAudit", ignore = true)
    @Mapping(target = "auditId", ignore = true)
    @Mapping(target = "auditEventType", ignore = true)
    @Mapping(target = "principalName", ignore = true)
    BeerAudit beerToBeerAudit(Beer beer);
}
