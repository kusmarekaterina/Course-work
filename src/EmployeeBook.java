import java.util.Arrays;

public class EmployeeBook {
    private Employee [] employees = new Employee[10];
    private FullName [] fullNames = new FullName[10];

    public void createFullName() {
        fullNames = new FullName[]{
                new FullName("Иванов", "Иван", "Сергеевич"),
                new FullName("Сергеев", "Антон", "Иванович"),
        };
    }

    public void createEmployeeBook() {
        createFullName();
        employees = new Employee[]{

                new Employee(fullNames[0], 3, 50000),
                new Employee(fullNames[1], 5, 36700),
        };
    }

    public void printEmployees() {
        createEmployeeBook();
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public float findTotalSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary () {
        Employee minSalary = employees[0];
        float min = minSalary.getSalary();
        for (final Employee current : employees) {
            if (current != null && current.getSalary() < min) {
                min = current.getSalary();
                minSalary = current;
            }
        }
        return minSalary;
    }

    public Employee findEmployeeWithMaxSalary () {
        Employee maxSalary = employees[0];
        float max = maxSalary.getSalary();
        for (final Employee current : employees) {
            if (current != null && current.getSalary() > max) {
                max = current.getSalary();
                maxSalary = current;
            }
        }
        return maxSalary;
    }

    public float findAverageSalary() {
        return findTotalSalary() / Employee.getCounter();
    }

    public void printFullNames() {
        for (FullName fullName : fullNames) {
            if (fullName != null) {
                System.out.println(fullName);
            }
        }
    }

    public void indexSalary(int percent){
        for (Employee employee : employees) {
            if (employee != null) {
                float currentSalary = employee.getSalary();
                employee.setSalary(currentSalary * (percent / 100f + 1));
            }
        }
    }

    public Employee findEmployeeWithMinSalaryOfDepartment (int department) {
        Employee minSalaryOfTeam = employees[0];
        float min = minSalaryOfTeam.getSalary();
        for (final Employee current : employees) {
            if (current.getDepartment() != department) {
                continue;
            }
            if (current != null && current.getSalary() < min){
                min = current.getSalary();
                minSalaryOfTeam = current;
            }
        }
        return minSalaryOfTeam;
    }
    public Employee findEmployeeWithMaxSalaryOfDepartment (int department) {
        Employee maxSalaryOfTeam = employees[0];
        float max = maxSalaryOfTeam.getSalary();
        for (final Employee current : employees) {
            if (current.getDepartment() != department) {
                continue;
            }
            if (current != null && current.getSalary() > max) {
                max = current.getSalary();
                maxSalaryOfTeam = current;
            }
        }
        return maxSalaryOfTeam;
    }

    public float findTotalSalaryOfDepartment(int department) {
        int sumOfTeam = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sumOfTeam+=employee.getSalary();
            }
        }
        return sumOfTeam;
    }

    public float findAverageSalaryOfDepartment(int department) {
        int countOfTeam = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                countOfTeam++;
            }
        }
        return findTotalSalaryOfDepartment(department) / countOfTeam;
    }

    public void indexSalaryOfDepartment(int department, int percent){
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                float currentSalary = employee.getSalary();
                employee.setSalary(currentSalary * (percent / 100f + 1));
            }
        }
    }

    public void printDepartment(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println("id: " + employee.getId() + " Ф.И.О.: " + employee.getFullName() + " Зарплата: " + employee.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(int than){
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < than) {
                System.out.println("id: " + employee.getId() + " Ф.И.О.: " + employee.getFullName() + " Зарплата: " + employee.getSalary());
            }
        }
    }

    public void printEmployeesWithSalaryMoreThan(int than){
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > than) {
                System.out.println("id: " + employee.getId() + " Ф.И.О.: " + employee.getFullName() + " Зарплата: " + employee.getSalary());
            }
        }
    }

    public void createEmployee(FullName fullName, int department, float salary) {
        int index = findFreeIndex();
        if (index != -1) {
            employees[index] = new Employee(fullName,department,salary);
            return;
        } else {
            Employee [] employees2 = Arrays.copyOf(employees, employees.length * 2);
            index = employees.length;
            employees2[index] = new Employee(fullName,department,salary);
        }
    }

    public int findFreeIndex() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null){
               return i;
            }
        }
        return -1;
    }

    public void removeEmployee (FullName fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
               employees[i] = null;
            }
        }
    }

    public void changeEmployee (FullName fullName) {
        float newSalary = 61000;
        int newDepartment = 1;
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
            employee.setSalary(newSalary);
            employee.setDepartment(newDepartment);
            }
        }
    }

    public void getFullNamesByDepartment() {
        for (int d = 1; d <= 5; d++) {
            System.out.println("Отдел: " + d);
            for (Employee employee : employees) {
                if (employee.getDepartment() == d) {
                    System.out.println(" Ф.И.О.: " + employee.getFullName());
                }
            }
        }
    }

}
