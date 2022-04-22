package codeplays.trainee.contacts.controller;

import codeplays.trainee.contacts.exception.ContactNotFoundException;
import codeplays.trainee.contacts.model.Contact;
import codeplays.trainee.contacts.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody Contact contact) {
        contactService.create(contact);
    }

    @GetMapping("/contacts/{id}")
    public Contact getContactById(@PathVariable Long id) throws ContactNotFoundException {
        return contactService.getById(id);
    }

    @PutMapping("/contacts")
    public void upsertContact(@RequestBody Contact contact) {
        contactService.upsert(contact);
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteById(id);
    }

    @GetMapping("/contacts")
    public List<Contact> findContacts(@RequestParam String name) {
        return contactService.findAllFiltering(name);
    }
}
