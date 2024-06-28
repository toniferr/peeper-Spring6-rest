package com.toniferr.spring6restmvc.mappers;

import com.toniferr.spring6restmvc.entities.Customer;
import com.toniferr.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * Created by toniferr.
 */
@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);

}
