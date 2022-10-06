import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCount {
public static void main(String[] args) {
      String s = "the cat is in the bag";
      String[] wordArr = s.split(" ");
      Map<String, Long> countMap = Arrays.asList(wordArr).stream().filter(Objects::nonNull).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      Map<String, Long> resultMap = countMap.entrySet()
              .stream()
              .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
      resultMap.forEach((k,v) -> System.out.println(v+" "+k));
}
}
