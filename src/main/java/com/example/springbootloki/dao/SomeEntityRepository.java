package com.example.springbootloki.dao;

import com.example.springbootloki.dom.model.SomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeEntityRepository extends JpaRepository<SomeEntity, Long> {

}
