package codeplays.trainee.contacts.service;

import codeplays.trainee.contacts.exception.ContactNotFoundException;
import codeplays.trainee.contacts.model.Contact;
import codeplays.trainee.contacts.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void create(Contact contact) {
        contactRepository.save(contact);
    }

    public Contact getById(Long id) throws ContactNotFoundException {
        return contactRepository
                .findById(id)
                .orElseThrow(ContactNotFoundException::new);
    }

    public void upsert(Contact contact) {
        contactRepository
                .findById(contact.getId())
                .ifPresentOrElse(
                        (savedContact) -> {
                            savedContact.updateName(contact.getName());
                            savedContact.updatePhone(contact.getPhone());

                            contactRepository.save(savedContact);
                        },
                        () -> create(contact));
    }

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> findAllFiltering(String name) {
        return contactRepository.findByNameContaining(name);
    }
}
