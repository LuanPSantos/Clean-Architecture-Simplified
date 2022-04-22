package codeplays.trainee.contacts.repository;

import codeplays.trainee.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT contact FROM Contact contact " +
            "WHERE contact.name LIKE CONCAT('%', ?1, '%')")
    List<Contact> findByNameContaining(String name);
}
