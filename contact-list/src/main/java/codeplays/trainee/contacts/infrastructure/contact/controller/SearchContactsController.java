package codeplays.trainee.contacts.infrastructure.contact.controller;

import codeplays.trainee.contacts.entity.contact.model.Contact;
import codeplays.trainee.contacts.usecase.contact.SearchContactsUseCase;
import codeplays.trainee.contacts.usecase.contact.SearchContactsUseCase.Input;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchContactsController {

    private final SearchContactsUseCase searchContactsUseCase;

    public SearchContactsController(SearchContactsUseCase searchContactsUseCase) {
        this.searchContactsUseCase = searchContactsUseCase;
    }

    @GetMapping("/contacts")
    public Response searchContacts(@RequestParam String name) {
        var output = searchContactsUseCase.execute(new Input(name));

        return new Response(output.contacts());
    }

    public record Response(
            List<Contact> contacts
    ) { }
}
