package com.toniferr.spring6restmvc.bootstrap;

import com.toniferr.spring6restmvc.repositories.BeerOrderRepository;
import com.toniferr.spring6restmvc.repositories.BeerRepository;
import com.toniferr.spring6restmvc.repositories.CustomerRepository;
import com.toniferr.spring6restmvc.services.BeerCsvService;
import com.toniferr.spring6restmvc.services.impl.BeerCsvServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(BeerCsvServiceImpl.class) //porque @DataJpaTest solo inyecta de los repositorios y no fuera
class BootstrapDataTest {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerOrderRepository beerOrderRepository;

    @Autowired
    BeerCsvService csvService;

    BootstrapData bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapData(beerRepository, customerRepository, csvService, beerOrderRepository );
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(beerRepository.count()).isEqualTo(2413);
        assertThat(customerRepository.count()).isEqualTo(3);
    }
}





