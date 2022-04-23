package codeplays.trainee.contacts.usecase.contact;

import codeplays.trainee.contacts.entity.contact.gateway.ContactGateway;
import org.springframework.stereotype.Service;

@Service
public class DeleteContactUseCase {

    private final ContactGateway contactGateway;

    public DeleteContactUseCase(ContactGateway contactGateway) {
        this.contactGateway = contactGateway;
    }

    public void execute(Input input) {
        contactGateway.delete(input.id());
    }

    public record Input(Long id) { }
}
