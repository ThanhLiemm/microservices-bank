package com.thanhliem.cards.repository;

import com.thanhliem.cards.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<Cards, Long> {
}
