package codeplays.trainee.contacts.entity.contact.gateway;

import codeplays.trainee.contacts.entity.contact.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactGateway {
    void create(Contact contact);
    void update(Contact contact);
    void delete(Long id);

    Optional<Contact> findById(Long id);
    List<Contact> searchByName(String nameFragment);
}
