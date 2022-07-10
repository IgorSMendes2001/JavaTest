package com.cd2tec.javatest.repository;

import com.cd2tec.javatest.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete,Long> {
}
