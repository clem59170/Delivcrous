package com.example.delivcrous.repository;

import com.example.delivcrous.model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PanierRepository extends JpaRepository<Panier, Long> {
}
