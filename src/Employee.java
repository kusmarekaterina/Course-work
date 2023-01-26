import java.util.Objects;

public class Employee {
    private final FullName fullName;
    private int department;
    private float salary;
    public static int counter = 0;
    private int id;

    public Employee (FullName fullName, int department, float salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = counter++;
    }

    public FullName getFullName() {return fullName;}

    public int getDepartment() {return department;}

    public float getSalary() {return salary;}

    public int getId() {return id;}

    public static int getCounter() {return counter;}

    public void setDepartment(int department) {this.department = department;}

    public void setSalary(float salary) {this.salary = salary;}

    @Override
    public String toString() {
        return  "id: " + id +
                " Ф.И.О.: " + fullName +
                " Отдел: " + department +
                " Зарплата: " + salary +
                ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }

}
