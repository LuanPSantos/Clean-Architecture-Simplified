package codeplays.trainee.contacts.usecase.contact;

import codeplays.trainee.contacts.entity.contact.gateway.ContactGateway;
import codeplays.trainee.contacts.entity.contact.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchContactsUseCase {

    private final ContactGateway contactGateway;

    public SearchContactsUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    public Output execute(Input input) {
        var contacts = contactGateway.searchByName(input.nameFragment());

        return new Output(contacts);
    }

    public record Input(String nameFragment) { }

    public record Output(List<Contact> contacts) { }
}
