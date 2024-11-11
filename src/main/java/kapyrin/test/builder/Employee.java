package kapyrin.test.builder;

import java.util.Objects;

public class Employee {

    private String name;
    private String company;
    private boolean hasCar;//optional
    private boolean hasBike;//optional

    private Employee(EmployeeBuilder employeeBuilder) {
        name = employeeBuilder.name;
        company = employeeBuilder.company;
        hasCar = employeeBuilder.hasCar;
        hasBike = employeeBuilder.hasBike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return hasCar == employee.hasCar && hasBike == employee.hasBike && Objects.equals(name, employee.name) && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, hasCar, hasBike);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", hasCar=" + hasCar +
                ", hasBike=" + hasBike +
                '}';
    }

    public String getCompany() {
        return company;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public boolean isHasBike() {
        return hasBike;
    }

    public static class EmployeeBuilder {
        private String name;
        private String company;
        private boolean hasCar;//optional
        private boolean hasBike;//optional

        public EmployeeBuilder(String name, String company) {
            this.name = name;
            this.company = company;
        }

        public EmployeeBuilder setHasCar(boolean hasCar) {
            this.hasCar = hasCar;
            return this;
        }

        public EmployeeBuilder setHasBike(boolean hasBike) {
            this.hasBike = hasBike;
            return this;
        }

        //Build the Employee object
        public Employee build() {
            return new Employee(this);
        }
    }
}

class TestBuilder {
    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder("Vikram", "ABC").setHasBike(false).setHasBike(true).build();
        System.out.println(employee.toString());
        int i = 0;

        while (i < 5) {
            for (int j = 0; j < 30; j += 10) {
                if (i == 2) {
                    continue;
                } else {
                    break;
                }
            }
            System.out.println(i++);

        }
    }
}