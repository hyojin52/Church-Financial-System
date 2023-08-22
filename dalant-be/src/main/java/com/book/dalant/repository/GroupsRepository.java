package com.book.dalant.repository;

import com.book.dalant.domain.ChurchEntity;
import com.book.dalant.domain.GroupsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<GroupsEntity, String> {
  Page<GroupsEntity> findByChurch(ChurchEntity church, Pageable pageable);
}
