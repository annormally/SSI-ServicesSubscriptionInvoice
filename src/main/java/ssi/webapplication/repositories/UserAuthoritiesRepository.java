package ssi.webapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssi.webapplication.entities.AuthoritiesEntity;

@Repository
public interface UserAuthoritiesRepository extends JpaRepository<AuthoritiesEntity, Integer> {
}
