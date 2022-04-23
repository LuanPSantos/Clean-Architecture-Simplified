package codeplays.trainee.contacts.infrastructure.contact.controller;

import codeplays.trainee.contacts.usecase.contact.CreateContactUseCase;
import codeplays.trainee.contacts.usecase.contact.CreateContactUseCase.Input;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateContactController {

    private final CreateContactUseCase createContactUseCase;

    public CreateContactController(CreateContactUseCase createContactUseCase) {
        this.createContactUseCase = createContactUseCase;
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody Request request) {
        createContactUseCase.execute(new Input(request.name(), request.phone()));
    }

    public record Request(
            String name,
            String phone
    ) { }
}
