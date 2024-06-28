package com.toniferr.spring6restmvc.services;

import com.toniferr.spring6restmvc.entities.BeerOrder;
import com.toniferr.spring6restmvc.model.BeerOrderCreateDTO;
import com.toniferr.spring6restmvc.model.BeerOrderDTO;
import com.toniferr.spring6restmvc.model.BeerOrderUpdateDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by toniferr.
 */
public interface BeerOrderService {

    Optional<BeerOrderDTO> getById(UUID beerOrderId);

    Page<BeerOrderDTO> listOrders(Integer pageNumber, Integer pageSize);

    BeerOrder createOrder(BeerOrderCreateDTO beerOrderCreateDTO);

    BeerOrderDTO updateOrder(UUID beerOrderId, BeerOrderUpdateDTO beerOrderUpdateDTO);

    void deleteOrder(UUID beerOrderId);
}
