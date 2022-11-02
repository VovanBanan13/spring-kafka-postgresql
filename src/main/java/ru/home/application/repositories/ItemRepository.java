package ru.home.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.application.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
