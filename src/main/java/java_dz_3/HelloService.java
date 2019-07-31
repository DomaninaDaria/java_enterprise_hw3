package java_dz_3;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HelloService {
    private HelloRepo helloRepo;
    private final Random random = new Random();


    public String getGreeting(String language) {
        List<Message> greetings = helloRepo.getGreetings();
        if (language.equals("random")) {
            int index = random.nextInt(greetings.size());
            Message message = greetings.get(index);
            return message.getGreeting();
        }

        Optional<Message> languagee = greetings.stream()
                .filter(lang -> lang.getLanguage().equals(language))
                .findFirst();
        return languagee.map(lan -> lan.getGreeting())
                .orElseThrow(() -> new NotFoundException("\n\nAddress /" + language + " does NOT exist \n" +
                        "List of addresses : /"
                        + greetings.stream()
                        .map(message -> message.getLanguage())
                        .collect(Collectors.toList())
                        .toString()
                        + " or /random"));
    }
}