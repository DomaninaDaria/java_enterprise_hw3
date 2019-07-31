package java_dz_3;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaDz3ApplicationTests {

    @Autowired
    HelloService helloService;


    @Test
    public void checkRandom() {
        final int valueOfObj = 200;
        ArrayList<String> greetings = new ArrayList<String>(Collections.nCopies(valueOfObj, ""));
        ListIterator<String> listIterator = greetings.listIterator();

        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(helloService.getGreeting("random"));
        }


        List<Long> quantityOfEveryGreeting = new ArrayList<Long>(greetings.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .values());

        System.out.println(quantityOfEveryGreeting.toString());

        boolean result = quantityOfEveryGreeting.stream()
                .allMatch(i -> i < valueOfObj / quantityOfEveryGreeting.size() * 2 &&
                        i > valueOfObj / quantityOfEveryGreeting.size() / 3);
        Assert.assertTrue(result);
    }
}