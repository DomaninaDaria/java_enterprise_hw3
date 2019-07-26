package java_dz_3;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/greeting")
@AllArgsConstructor
public class HelloController {
      HelloService helloService ;

    @GetMapping("{language}")
    public    String getGreeting(@PathVariable  String language){

        return helloService.getGreeting(language);
    }

}





