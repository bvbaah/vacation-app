package com.example.demo.dao;

import com.example.demo.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

// All repository interfaces are supposed to read port 8080 through @CrossOrigin but it is not required to nottate that
@CrossOrigin
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
