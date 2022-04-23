package codeplays.trainee.contacts.usecase.contact;

import codeplays.trainee.contacts.entity.contact.exception.ContactNotFoundException;
import codeplays.trainee.contacts.entity.contact.gateway.ContactGateway;
import codeplays.trainee.contacts.entity.contact.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class GetContactByIdUseCase {

    private final ContactGateway contactGateway;

    public GetContactByIdUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    public Output execute(Input input) throws ContactNotFoundException {
        var contact = contactGateway
                .findById(input.id())
                .orElseThrow(ContactNotFoundException::new);

        return new Output(contact);
    }

    public record Input(Long id) { }

    public record Output(Contact contact) { }
}
