import sun.util.resources.LocaleData;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


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

                        long days = dateFrom.until( dateTo, ChronoUnit.DAYS);

                        employee.setWorkedDays(days);

                        employeeList.add(employee);

                    }

                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employeeList;

    }


        private static DateTimeFormatter[] parseFormatters = Stream.of("M/yy", "M/y", "M/d/y", "M-d-y")
            .map(DateTimeFormatter::ofPattern)
            .toArray(DateTimeFormatter[]::new);

        public static YearMonth parseYearMonth(String input) {
            for (DateTimeFormatter formatter : parseFormatters) {
                try {
                    return YearMonth.parse(input, formatter);
                } catch (DateTimeParseException dtpe) {
                    // ignore, try next format
                }
            }
            throw new IllegalArgumentException("Could not parse " + input);
        }
    }


