package com.bosonit.bean.validation.infrastructure.repository;

import com.bosonit.bean.validation.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
