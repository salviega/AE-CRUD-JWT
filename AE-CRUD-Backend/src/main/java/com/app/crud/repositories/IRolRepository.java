package com.app.crud.repositories;

import com.app.crud.models.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<RolModel, Long> {
}
