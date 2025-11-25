package com.backstone.simple_note_application.note.hierarchy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("" +
            "SELECT c " +
            "FROM Category c " +
            "WHERE c.parent IS NULL")
    Category findrootCategory();
}
