package java_dz_3;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class HelloService {
    HelloRepo helloRepo;



    public String getGreeting(String language){
        List<Map<String, String>> greetings = helloRepo.greetings;
        if(language.equals("random")){
            int index = new Random().nextInt(greetings.size());
            Map<String, String> stringStringMap = greetings.get(index);
            return stringStringMap.get("greeting");
        }

            Optional<Map<String, String>> languagee  = greetings.stream()
                    .filter(lang -> lang.get("language").equals(language)).findFirst();
        if(languagee.isPresent())
            return languagee.get().get("greeting");
        else {
            throw new NotFoundException("WRONG ADDRESS");
        }
    }

}
