package ssi.webapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssi.webapplication.entities.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
}
