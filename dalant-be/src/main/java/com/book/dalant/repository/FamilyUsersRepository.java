package com.book.dalant.repository;

import com.book.dalant.domain.FamilyUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface FamilyUsersRepository extends JpaRepository<FamilyUsersEntity, String>, JpaSpecificationExecutor<FamilyUsersEntity> {
}
