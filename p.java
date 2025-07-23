package employeeplayrollsystem;

import java.util.*;

abstract class Employee{
    private  String name;
    private int id;

    public Employee(String name , int id){
        this.name = name;
        this.id = id;
    }

    public String getname(){
        return name;
    }

    public int getid(){
        return id;
    }

    public abstract  double calculatesalary();

    @Override
    public String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculatesalary()+"]";
    }
}


class Fulltimeemployee extends Employee{
    private double monthlysalary;

    public Fulltimeemployee(String name,int id,double monthlysalary){
        super(name, id);
        this.monthlysalary = monthlysalary;
    }

    @Override
    public double calculatesalary(){
        return monthlysalary;
    }

}


class parttimeemployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public  parttimeemployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
     @Override
     public double calculatesalary(){
        return hoursWorked*hourlyRate;
     }

}

class payrollsystem{
    private ArrayList<Employee> employeeList;

    public payrollsystem(){
        employeeList = new ArrayList<>(); 
    }

    public void addemployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeemployee(int id){
        Employee employeetoremove = null;

        for(Employee employee :employeeList){
            if(employee.getid()==id){
                employeetoremove = employee;
                break; 
            }
        }
        if(employeetoremove!=null){
            employeeList.remove(employeetoremove);
        }
    }

    public void displayemployees(){
        for(Employee employee :employeeList){
            System.err.println(employee);
        }
}
}

public class p {
    public static void main(String args[]){
        payrollsystem payrolls = new payrollsystem(); 
        Fulltimeemployee emp1 = new Fulltimeemployee("Vikas", 1,70000.0);
        parttimeemployee emp2 = new parttimeemployee("Rohit", 2,40, 100);

        payrolls.addemployee(emp1);
        payrolls.addemployee(emp2);
        System.out.println("Initial Employee Details:");
        payrolls.displayemployees();
        System.out.println();
        System.out.println("Removng Employees");
        payrolls.removeemployee(2);
        System.out.println();
        System.out.println("Remaining Employees Details");
        System.out.println();
        payrolls.displayemployees();
    }
}
