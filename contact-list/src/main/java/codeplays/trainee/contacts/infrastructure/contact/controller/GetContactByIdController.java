package codeplays.trainee.contacts.infrastructure.contact.controller;

import codeplays.trainee.contacts.entity.contact.exception.ContactNotFoundException;
import codeplays.trainee.contacts.entity.contact.model.Contact;
import codeplays.trainee.contacts.usecase.contact.GetContactByIdUseCase;
import codeplays.trainee.contacts.usecase.contact.GetContactByIdUseCase.Input;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetContactByIdController {

    private final GetContactByIdUseCase getContactByIdUseCase;

    public GetContactByIdController(GetContactByIdUseCase getContactByIdUseCase) {
        this.getContactByIdUseCase = getContactByIdUseCase;
    }

    @GetMapping("/contacts/{id}")
    public Response getContactById(@PathVariable Long id) throws ContactNotFoundException {
        var output = getContactByIdUseCase.execute(new Input(id));

        return new Response(output.contact());
    }

    public record Response(
            Contact contact
    ) { }
}
