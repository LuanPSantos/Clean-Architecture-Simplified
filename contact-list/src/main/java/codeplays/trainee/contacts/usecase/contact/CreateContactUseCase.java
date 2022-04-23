package codeplays.trainee.contacts.usecase.contact;

import codeplays.trainee.contacts.entity.contact.gateway.ContactGateway;
import codeplays.trainee.contacts.entity.contact.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class CreateContactUseCase {

    private final ContactGateway contactGateway;

    public CreateContactUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    public void execute(Input input) {
        contactGateway.create(new Contact(input.name(), input.phone()));
    }

    public record Input(String name, String phone) { }
}
