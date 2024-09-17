package com.example.Inventory_Service.repo;

import com.example.Inventory_Service.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
