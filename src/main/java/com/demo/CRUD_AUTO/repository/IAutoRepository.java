package com.demo.CRUD_AUTO.repository;

import com.demo.CRUD_AUTO.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutoRepository extends JpaRepository<Auto, Long> {
}


