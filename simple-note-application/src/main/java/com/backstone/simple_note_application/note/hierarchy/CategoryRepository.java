package com.backstone.simple_note_application.note.hierarchy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(
            "SELECT c " +
            "FROM Category c " +
            "WHERE c.parent IS NULL AND c.username = :username")
    Category findrootCategory(@Param("username") String username);
}
