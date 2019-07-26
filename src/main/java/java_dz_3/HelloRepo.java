package java_dz_3;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Data
public class HelloRepo {
public List<Map<String, String>> greetings = new ArrayList<Map<String,String>>(){{
   add(new HashMap<String, String>(){{ put("language", "en"); put("greeting", "Hello");}});
    add(new HashMap<String, String>(){{ put("language", "fr"); put("greeting", "HelloFR");}});
   add(new HashMap<String, String>(){{ put("language", "it"); put("greeting", "Hello IT");}});
}};

}
