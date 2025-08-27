package org.harsha.tacocloud.repository;

import org.harsha.tacocloud.entity.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoOrderRepository extends JpaRepository<TacoOrder, Long> {}
