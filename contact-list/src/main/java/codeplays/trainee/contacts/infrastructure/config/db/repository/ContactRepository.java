package codeplays.trainee.contacts.infrastructure.config.db.repository;

import codeplays.trainee.contacts.infrastructure.config.db.schema.ContactSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContactSchema, Long> {

    @Query("SELECT contact FROM ContactSchema contact " +
            "WHERE contact.name LIKE CONCAT('%', ?1, '%')")
    List<ContactSchema> searchByNameContaining(String name);
}
