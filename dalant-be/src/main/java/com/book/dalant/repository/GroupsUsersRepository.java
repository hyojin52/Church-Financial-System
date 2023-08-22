package com.book.dalant.repository;

import com.book.dalant.domain.GroupsUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsUsersRepository extends JpaRepository<GroupsUsersEntity, String>, JpaSpecificationExecutor<GroupsUsersEntity> {
}
