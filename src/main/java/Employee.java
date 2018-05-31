import java.time.LocalDate;

public class Employee {

    private Long empId;
    private Long projectId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Long workedDays;

    public Long getEmpId () {
        return empId;
    }

    public void setEmpId (Long empId) {
        this.empId = empId;
    }

    public Long getProjectId () {
        return projectId;
    }

    public void setProjectId (Long projectId) {
        this.projectId = projectId;
    }

    public LocalDate getDateFrom () {
        return dateFrom;
    }

    public void setDateFrom (LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo () {
        return dateTo;
    }

    public void setDateTo (LocalDate dateTo) {
        this.dateTo = dateTo;
    }


    public Long getWorkedDays () {
        return workedDays;
    }

    public void setWorkedDays (Long workedDays) {
        this.workedDays = workedDays;
    }

    @Override
    public String toString () {
        return "Employee{" +
            "empId=" + empId +
            ", projectId=" + projectId +
            ", dateFrom=" + dateFrom +
            ", dateTo=" + dateTo +
            ", workedDays=" + workedDays +
            '}';
    }
}
