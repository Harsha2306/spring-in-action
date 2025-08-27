package org.harsha.tacocloud.repository;

import org.harsha.tacocloud.entity.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {}
