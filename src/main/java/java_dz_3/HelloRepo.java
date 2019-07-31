package java_dz_3;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@Data
public class HelloRepo {

    private final List<Message> greetings = new ArrayList<Message>() {
        {
            add(new Message("en", "Hello"));
            add(new Message("fr", "Bonjour"));
            add(new Message("it", "Ciao"));

        }
    };

    public List<Message> getGreetings() {
        return greetings;
    }
}