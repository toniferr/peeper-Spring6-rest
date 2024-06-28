package com.toniferr.spring6restmvc.repositories;

import com.toniferr.spring6restmvc.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by toniferr.
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
