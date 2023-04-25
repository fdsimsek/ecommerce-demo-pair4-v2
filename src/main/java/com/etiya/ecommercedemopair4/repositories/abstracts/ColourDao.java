package com.etiya.ecommercedemopair4.repositories.abstracts;

import com.etiya.ecommercedemopair4.entities.concretes.Colour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColourDao extends JpaRepository<Colour, Integer> {
}
