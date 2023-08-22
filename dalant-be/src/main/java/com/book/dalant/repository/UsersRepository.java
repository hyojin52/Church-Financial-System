package com.book.dalant.repository;

import com.book.dalant.domain.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String>, JpaSpecificationExecutor<UsersEntity> {
}
