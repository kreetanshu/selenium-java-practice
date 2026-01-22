package javapractice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataParsingExamples {
    public static void main(String[] args) {
   
        List<Map<String, Object>> users = List.of(
            Map.of("id", 1, "name", "Alice", "role", "ADMIN"),
            Map.of("id", 2, "name", "Bob", "role", "USER"),
            Map.of("id", 3, "name", "Charlie", "role", "ADMIN")
         );

        //Get all user names whose role is "ADMIN".
        users.stream().forEach(p->{
            if(p.get("role").equals("ADMIN")){
                System.out.println(p.get("name"));
            }
        });

        //Count how many users exist per role.
        
        Map<Object, Long> roleCountMap = users.stream().collect(Collectors.groupingBy(u->u.get("role"),Collectors.counting()));
        System.out.println(roleCountMap);

        //Find user with highest id.
        Object userName = users.stream().max(Comparator.comparing(u-> (int)u.get("id"))).orElse(null).get("name");
        System.out.println(userName.toString());

    }

}
