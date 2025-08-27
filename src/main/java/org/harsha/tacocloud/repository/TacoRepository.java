package org.harsha.tacocloud.repository;

import java.util.List;
import org.harsha.tacocloud.entity.AppUser;
import org.harsha.tacocloud.entity.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {
  List<Taco> findByAppUserOrderByCreatedAtDesc(AppUser appUser);
}
