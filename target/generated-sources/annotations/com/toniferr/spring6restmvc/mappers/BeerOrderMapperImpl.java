package com.toniferr.spring6restmvc.mappers;

import com.toniferr.spring6restmvc.entities.Beer;
import com.toniferr.spring6restmvc.entities.BeerOrder;
import com.toniferr.spring6restmvc.entities.BeerOrderLine;
import com.toniferr.spring6restmvc.entities.BeerOrderShipment;
import com.toniferr.spring6restmvc.entities.Customer;
import com.toniferr.spring6restmvc.model.BeerDTO;
import com.toniferr.spring6restmvc.model.BeerOrderDTO;
import com.toniferr.spring6restmvc.model.BeerOrderLineDTO;
import com.toniferr.spring6restmvc.model.BeerOrderShipmentDTO;
import com.toniferr.spring6restmvc.model.CustomerDTO;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-28T09:48:31+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BeerOrderMapperImpl implements BeerOrderMapper {

    @Override
    public BeerOrderShipment beerOrderShipmentDtoToBeerOrderShipment(BeerOrderShipmentDTO beerOrderShipmentDTO) {
        if ( beerOrderShipmentDTO == null ) {
            return null;
        }

        BeerOrderShipment.BeerOrderShipmentBuilder beerOrderShipment = BeerOrderShipment.builder();

        beerOrderShipment.id( beerOrderShipmentDTO.getId() );
        beerOrderShipment.version( beerOrderShipmentDTO.getVersion() );
        beerOrderShipment.trackingNumber( beerOrderShipmentDTO.getTrackingNumber() );
        beerOrderShipment.createdDate( beerOrderShipmentDTO.getCreatedDate() );
        beerOrderShipment.lastModifiedDate( beerOrderShipmentDTO.getLastModifiedDate() );

        return beerOrderShipment.build();
    }

    @Override
    public BeerOrderShipmentDTO beerOrderShipmentToBeerOrderShipmentDto(BeerOrderShipment beerOrderShipment) {
        if ( beerOrderShipment == null ) {
            return null;
        }

        BeerOrderShipmentDTO.BeerOrderShipmentDTOBuilder beerOrderShipmentDTO = BeerOrderShipmentDTO.builder();

        beerOrderShipmentDTO.id( beerOrderShipment.getId() );
        beerOrderShipmentDTO.version( beerOrderShipment.getVersion() );
        beerOrderShipmentDTO.trackingNumber( beerOrderShipment.getTrackingNumber() );
        beerOrderShipmentDTO.createdDate( beerOrderShipment.getCreatedDate() );
        beerOrderShipmentDTO.lastModifiedDate( beerOrderShipment.getLastModifiedDate() );

        return beerOrderShipmentDTO.build();
    }

    @Override
    public BeerOrderLine beerOrderLineDtoToBeerOrderLine(BeerOrderLineDTO beerOrderLineDTO) {
        if ( beerOrderLineDTO == null ) {
            return null;
        }

        BeerOrderLine.BeerOrderLineBuilder beerOrderLine = BeerOrderLine.builder();

        beerOrderLine.id( beerOrderLineDTO.getId() );
        beerOrderLine.version( beerOrderLineDTO.getVersion() );
        beerOrderLine.createdDate( beerOrderLineDTO.getCreatedDate() );
        beerOrderLine.lastModifiedDate( beerOrderLineDTO.getLastModifiedDate() );
        beerOrderLine.beer( beerDTOToBeer( beerOrderLineDTO.getBeer() ) );
        beerOrderLine.orderQuantity( beerOrderLineDTO.getOrderQuantity() );
        beerOrderLine.quantityAllocated( beerOrderLineDTO.getQuantityAllocated() );

        return beerOrderLine.build();
    }

    @Override
    public BeerOrderLineDTO beerOrderLineToBeerOrderLineDto(BeerOrderLine beerOrderLine) {
        if ( beerOrderLine == null ) {
            return null;
        }

        BeerOrderLineDTO.BeerOrderLineDTOBuilder beerOrderLineDTO = BeerOrderLineDTO.builder();

        beerOrderLineDTO.id( beerOrderLine.getId() );
        beerOrderLineDTO.version( beerOrderLine.getVersion() );
        beerOrderLineDTO.createdDate( beerOrderLine.getCreatedDate() );
        beerOrderLineDTO.lastModifiedDate( beerOrderLine.getLastModifiedDate() );
        beerOrderLineDTO.beer( beerToBeerDTO( beerOrderLine.getBeer() ) );
        beerOrderLineDTO.orderQuantity( beerOrderLine.getOrderQuantity() );
        beerOrderLineDTO.quantityAllocated( beerOrderLine.getQuantityAllocated() );

        return beerOrderLineDTO.build();
    }

    @Override
    public BeerOrder beerOrderDtoToBeerOrder(BeerOrderDTO beerOrder) {
        if ( beerOrder == null ) {
            return null;
        }

        BeerOrder.BeerOrderBuilder beerOrder1 = BeerOrder.builder();

        beerOrder1.id( beerOrder.getId() );
        beerOrder1.version( beerOrder.getVersion() );
        beerOrder1.createdDate( beerOrder.getCreatedDate() );
        beerOrder1.lastModifiedDate( beerOrder.getLastModifiedDate() );
        beerOrder1.customerRef( beerOrder.getCustomerRef() );
        beerOrder1.customer( customerDTOToCustomer( beerOrder.getCustomer() ) );
        beerOrder1.beerOrderLines( beerOrderLineDTOSetToBeerOrderLineSet( beerOrder.getBeerOrderLines() ) );
        beerOrder1.beerOrderShipment( beerOrderShipmentDtoToBeerOrderShipment( beerOrder.getBeerOrderShipment() ) );

        return beerOrder1.build();
    }

    @Override
    public BeerOrderDTO beerOrderToBeerOrderDto(BeerOrder beerOrder) {
        if ( beerOrder == null ) {
            return null;
        }

        BeerOrderDTO.BeerOrderDTOBuilder beerOrderDTO = BeerOrderDTO.builder();

        beerOrderDTO.id( beerOrder.getId() );
        beerOrderDTO.version( beerOrder.getVersion() );
        beerOrderDTO.createdDate( beerOrder.getCreatedDate() );
        beerOrderDTO.lastModifiedDate( beerOrder.getLastModifiedDate() );
        beerOrderDTO.customerRef( beerOrder.getCustomerRef() );
        beerOrderDTO.customer( customerToCustomerDTO( beerOrder.getCustomer() ) );
        beerOrderDTO.beerOrderLines( beerOrderLineSetToBeerOrderLineDTOSet( beerOrder.getBeerOrderLines() ) );
        beerOrderDTO.beerOrderShipment( beerOrderShipmentToBeerOrderShipmentDto( beerOrder.getBeerOrderShipment() ) );

        return beerOrderDTO.build();
    }

    protected Beer beerDTOToBeer(BeerDTO beerDTO) {
        if ( beerDTO == null ) {
            return null;
        }

        Beer.BeerBuilder beer = Beer.builder();

        beer.id( beerDTO.getId() );
        beer.version( beerDTO.getVersion() );
        beer.beerName( beerDTO.getBeerName() );
        beer.beerStyle( beerDTO.getBeerStyle() );
        beer.upc( beerDTO.getUpc() );
        beer.quantityOnHand( beerDTO.getQuantityOnHand() );
        beer.price( beerDTO.getPrice() );
        beer.createdDate( beerDTO.getCreatedDate() );
        beer.updateDate( beerDTO.getUpdateDate() );

        return beer.build();
    }

    protected BeerDTO beerToBeerDTO(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDTO.BeerDTOBuilder beerDTO = BeerDTO.builder();

        beerDTO.id( beer.getId() );
        beerDTO.version( beer.getVersion() );
        beerDTO.beerName( beer.getBeerName() );
        beerDTO.beerStyle( beer.getBeerStyle() );
        beerDTO.upc( beer.getUpc() );
        beerDTO.quantityOnHand( beer.getQuantityOnHand() );
        beerDTO.price( beer.getPrice() );
        beerDTO.createdDate( beer.getCreatedDate() );
        beerDTO.updateDate( beer.getUpdateDate() );

        return beerDTO.build();
    }

    protected Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( customerDTO.getId() );
        customer.name( customerDTO.getName() );
        customer.version( customerDTO.getVersion() );
        customer.createdDate( customerDTO.getCreatedDate() );
        customer.updateDate( customerDTO.getUpdateDate() );

        return customer.build();
    }

    protected Set<BeerOrderLine> beerOrderLineDTOSetToBeerOrderLineSet(Set<BeerOrderLineDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<BeerOrderLine> set1 = new LinkedHashSet<BeerOrderLine>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BeerOrderLineDTO beerOrderLineDTO : set ) {
            set1.add( beerOrderLineDtoToBeerOrderLine( beerOrderLineDTO ) );
        }

        return set1;
    }

    protected CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO.CustomerDTOBuilder customerDTO = CustomerDTO.builder();

        customerDTO.id( customer.getId() );
        customerDTO.name( customer.getName() );
        customerDTO.version( customer.getVersion() );
        customerDTO.createdDate( customer.getCreatedDate() );
        customerDTO.updateDate( customer.getUpdateDate() );

        return customerDTO.build();
    }

    protected Set<BeerOrderLineDTO> beerOrderLineSetToBeerOrderLineDTOSet(Set<BeerOrderLine> set) {
        if ( set == null ) {
            return null;
        }

        Set<BeerOrderLineDTO> set1 = new LinkedHashSet<BeerOrderLineDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BeerOrderLine beerOrderLine : set ) {
            set1.add( beerOrderLineToBeerOrderLineDto( beerOrderLine ) );
        }

        return set1;
    }
}
