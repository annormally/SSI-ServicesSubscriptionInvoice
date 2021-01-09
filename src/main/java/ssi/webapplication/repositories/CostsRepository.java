package ssi.webapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssi.webapplication.entities.CostsEntity;

@Repository
public interface CostsRepository extends JpaRepository<CostsEntity, Integer> {
}
