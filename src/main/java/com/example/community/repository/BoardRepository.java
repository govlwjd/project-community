package com.example.community.repository;

import com.example.community.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    @Modifying
    @Query(value = "update BOARD b set b.hits=b.hits+1 where b.id=:id")
    void updateHits(@Param("id") Long id);
}
