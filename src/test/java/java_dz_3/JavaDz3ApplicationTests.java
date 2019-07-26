package java_dz_3;


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
	private HelloService helloService;


	@Test
	public void checkRandom() {
		final int valueOfObj = 15;
		ArrayList<String> greetings = new ArrayList<>();
		for(int i = 0; i< valueOfObj; i++){
		String	random =  helloService.getGreeting("random");
			greetings.add(random);
		}

		Map<String, Long> collect = greetings.stream().collect(Collectors.groupingBy(s -> s ,
				Collectors.counting()));
		System.out.println(collect.toString());
		List<Long> collect1 = new ArrayList<>(collect.values());
		for(int i = 0; i< collect.size()-1; i++){
			assert (Math.abs(collect1.get(i) - collect1.get(i+1)) <= valueOfObj/collect.size( ) );

		}

	}

}
