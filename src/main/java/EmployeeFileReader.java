import sun.util.resources.LocaleData;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class EmployeeFileReader {

    protected List<Employee> readFile () {


        List<Employee> employeeList = new ArrayList<>();


            try (InputStream in = getClass().getResourceAsStream("/data.txt")) {

                try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                    for(String line; (line = br.readLine()) != null; ) {
                       String[] s = line.split(", ");

                       Employee employee = new Employee();

                       employee.setEmpId(Long.valueOf(s[0]));
                       employee.setProjectId(Long.valueOf(s[1]));

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate dateFrom = LocalDate.parse(s[2], formatter);


                        LocalDate dateTo = LocalDate.now();
                        if(!s[3].equals("NULL") ){

                           dateTo = LocalDate.parse(s[3], formatter);


                        }

                        employee.setDateFrom(dateFrom);
                        employee.setDateTo(dateTo);

                        employeeList.add(employee);

                    }

                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}
