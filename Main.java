import java.util.ArrayList;

abstract class Employee{
private String name;
private int id;

Employee(String name,int id){
    this.name=name;
    this.id=id;

}

public String getName(){
    return name;
}
public int getId(){
    return id;
}
public abstract double CalculateSalary();

@Override
public String toString(){
    return "Employee[name="+name+",id="+id+",Salary="+CalculateSalary()+"]";
}

}

class FulltimeEmployee extends Employee{
    private double monthlySalary;
    FulltimeEmployee(String name,int id,double monthlySalary){
        super(name, id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double CalculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name, id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    public double CalculateSalary(){
        return hoursWorked*hourlyRate;
    }
}
class payrollSystem{
     private ArrayList<Employee> employeeList;
     payrollSystem(){
        employeeList=new ArrayList<>();
     }
   public void addEmployee(Employee employee){
    employeeList.add(employee);
   }
   public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
            }
            if(employeeToRemove !=null){
                employeeList.remove(employeeToRemove);
        }
   }

   public void DisplayEmployees(){
    for(Employee employee:employeeList){
        System.out.println(employee);
    }
   }
}
public class Main {

    public static void main(String[] args) {
      payrollSystem payroll=new payrollSystem();
      FulltimeEmployee emp1=new FulltimeEmployee("vikas",1,68000);
      PartTimeEmployee pte1=new PartTimeEmployee("Saksham",11,36,120);

      payroll.addEmployee(emp1);
      payroll.addEmployee(pte1);
      System.out.println("INITIAL EMPLOYEE DETAILS...!");
      payroll.DisplayEmployees();
      System.out.println("Removing employees");
      payroll.removeEmployee(01);
      System.out.println(" Remaining Employee...");
      payroll.DisplayEmployees();

    }
}