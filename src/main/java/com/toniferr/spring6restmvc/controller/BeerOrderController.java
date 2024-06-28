package com.toniferr.spring6restmvc.controller;

import com.toniferr.spring6restmvc.entities.BeerOrder;
import com.toniferr.spring6restmvc.model.BeerOrderCreateDTO;
import com.toniferr.spring6restmvc.model.BeerOrderDTO;
import com.toniferr.spring6restmvc.model.BeerOrderUpdateDTO;
import com.toniferr.spring6restmvc.services.BeerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

/**
 * Created by toniferr.
 */
@RestController
@RequiredArgsConstructor
public class BeerOrderController {

    public static final String BEER_ORDER_PATH = "/api/v1/beerorder";
    public static final String BEER_ORDER_PATH_ID = BEER_ORDER_PATH + "/{beerOrderId}";

    private final BeerOrderService beerOrderService;

    @DeleteMapping(BEER_ORDER_PATH_ID)
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID beerOrderId) {
        beerOrderService.deleteOrder(beerOrderId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(BEER_ORDER_PATH_ID)
    public ResponseEntity<BeerOrderDTO> updateOrder(@PathVariable UUID beerOrderId, @RequestBody BeerOrderUpdateDTO beerOrderUpdateDTO) {
        return ResponseEntity.ok(beerOrderService.updateOrder(beerOrderId, beerOrderUpdateDTO));
    }

    @PostMapping(BEER_ORDER_PATH)
    public ResponseEntity<Void> createOrder(@RequestBody BeerOrderCreateDTO beerOrderCreateDTO) {
       BeerOrder savedOrder =  beerOrderService.createOrder(beerOrderCreateDTO);

       return ResponseEntity.created(URI.create(BEER_ORDER_PATH + "/" + savedOrder.getId().toString())).build();
    }

    @GetMapping(BEER_ORDER_PATH_ID)
    public BeerOrderDTO getBeerOrderById(@PathVariable UUID beerOrderId) {
        return beerOrderService.getById(beerOrderId).orElseThrow(NotFoundException::new);
    }

    @GetMapping(BEER_ORDER_PATH)
    public Page<BeerOrderDTO> listOrders(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                         @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return beerOrderService.listOrders(pageNumber, pageSize);
    }
}














