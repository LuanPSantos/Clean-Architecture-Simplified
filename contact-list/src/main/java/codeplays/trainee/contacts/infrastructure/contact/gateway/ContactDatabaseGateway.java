package codeplays.trainee.contacts.infrastructure.contact.gateway;

import codeplays.trainee.contacts.entity.contact.gateway.ContactGateway;
import codeplays.trainee.contacts.entity.contact.model.Contact;
import codeplays.trainee.contacts.infrastructure.config.db.repository.ContactRepository;
import codeplays.trainee.contacts.infrastructure.config.db.schema.ContactSchema;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
public class ContactDatabaseGateway implements ContactGateway {

    private final ContactRepository contactRepository;

    public ContactDatabaseGateway(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void create(Contact contact) {
        contactRepository.save(new ContactSchema(null, contact.getName(), contact.getPhone()));
    }

    @Override
    public void update(Contact contact) {
        contactRepository.save(new ContactSchema(contact.getId(), contact.getName(), contact.getPhone()));
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository
                .findById(id)
                .map((schema) -> new Contact(
                        schema.getId(),
                        schema.getName(),
                        schema.getPhone()
                ));
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> searchByName(String name) {
        return contactRepository
                .searchByNameContaining(name)
                .stream()
                .map((schema) -> new Contact(
                        schema.getId(),
                        schema.getName(),
                        schema.getPhone()
                ))
                .collect(toList());
    }

}
