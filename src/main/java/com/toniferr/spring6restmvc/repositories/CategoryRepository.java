package com.toniferr.spring6restmvc.repositories;

import com.toniferr.spring6restmvc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by toniferr.
 */
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
