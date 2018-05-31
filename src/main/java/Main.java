import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {

    public static void main (String[] args) {

        EmployeeFileReader testReader = new EmployeeFileReader();

        testReader.readFile().stream().sorted((e1, e2)-> Long.compare(e2.getWorkedDays(), e1.getWorkedDays())).
            limit(2).collect(Collectors.toList()).forEach(System.out::println);

        for (Employee employee : testReader.readFile()) {


        }

    }



}
