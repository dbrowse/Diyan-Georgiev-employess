public class Main {

    public static void main (String[] args) {

        EmployeeFileReader testReader = new EmployeeFileReader();

        testReader.readFile().forEach(System.out::println);

    }

}
