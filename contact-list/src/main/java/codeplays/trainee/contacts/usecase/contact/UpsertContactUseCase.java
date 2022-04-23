package codeplays.trainee.contacts.usecase.contact;

import codeplays.trainee.contacts.entity.contact.gateway.ContactGateway;
import codeplays.trainee.contacts.entity.contact.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class UpsertContactUseCase {

    private final ContactGateway contactGateway;

    public UpsertContactUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    public void execute(Input input) {
        contactGateway
                .findById(input.id())
                .ifPresentOrElse(
                        (contact) -> {
                            contact.updateName(input.name());
                            contact.updatePhone(input.phone());

                            contactGateway.update(contact);
                        },
                        () -> contactGateway.create(new Contact(input.name(), input.phone())));
    }

    public record Input(Long id, String name, String phone) { }
}
