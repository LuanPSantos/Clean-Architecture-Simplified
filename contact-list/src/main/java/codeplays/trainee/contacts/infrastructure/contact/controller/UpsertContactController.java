package codeplays.trainee.contacts.infrastructure.contact.controller;

import codeplays.trainee.contacts.entity.contact.model.Contact;
import codeplays.trainee.contacts.usecase.contact.UpsertContactUseCase;
import codeplays.trainee.contacts.usecase.contact.UpsertContactUseCase.Input;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpsertContactController {

    private final UpsertContactUseCase upsertContactUseCase;

    public UpsertContactController(UpsertContactUseCase upsertContactUseCase) {
        this.upsertContactUseCase = upsertContactUseCase;
    }

    @PutMapping("/contacts")
    public void upsertContact(@RequestBody Request request) {
        upsertContactUseCase.execute(new Input(
                request.contact().getId(),
                request.contact().getName(),
                request.contact().getPhone()
        ));
    }

    public record Request(
            Contact contact
    ) {
    }
}
