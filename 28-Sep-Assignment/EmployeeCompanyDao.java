package org.example.DAOassignment;

import org.example.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeCompanyDao {
    private static String url = "jdbc:mysql://localhost:3306/demo";

    public boolean addEmployee(Employee emp) {
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "chaithra");
             PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?,?)")) {
            pst.setInt(1, emp.getEmp_no());
            pst.setString(2, emp.getName());
            pst.setDouble(3, emp.getEmp_sal());
            pst.setString(4, emp.getDepartment());
            pst.setString(5, emp.getManager_name());
            count = pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count == 1;
    }

    public ArrayList<Employee> displayAllEmployeeDetails() {
        ArrayList<Employee> elist = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, "root", "chaithra");
             PreparedStatement pst = con.prepareStatement("select * from employee")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next())
                elist.add(new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return elist;
    }

    public Employee displayEmployeeDetailsById(int empId) {
        Employee emp = null;
        try (Connection con = DriverManager.getConnection(url, "root", "chaithra");
             PreparedStatement pst = con.prepareStatement("select * from employee where emp_no = ?")) {
            pst.setInt(1, empId);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                emp = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return emp;
    }

    public boolean modifyEmployee(Employee emp) {
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "chaithra");
             PreparedStatement pst = con.prepareStatement("update employee set emp_sal=?,department=?,manager_name=? where emp_no=?")) {
            pst.setDouble(1, emp.getEmp_sal());
            pst.setString(2, emp.getDepartment());
            pst.setString(3, emp.getManager_name());
            pst.setInt(4, emp.getEmp_no());
            count = pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count == 1;
    }
    public boolean deleteEmployeeByEmployeeId(int empid)
    {
        int count = 0;
        try(Connection con = DriverManager.getConnection(url,"root","chaithra");
            PreparedStatement pst = con.prepareStatement("delete from employee where emp_no = ?"))
        {
            pst.setInt(1,empid);
            count = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return count == 1;

    }
}
class Company{
    EmployeeCompanyDao e=new EmployeeCompanyDao();
    public void addEmployeeDetails(Employee emp){
        if( e.addEmployee(emp))
            System.out.println("recorded added succesfully");
        else
            System.out.println("insertion failed");
    }

    public void displayAllEmployeeDetails(){
        // display all employess
        ArrayList<Employee> list=e.displayAllEmployeeDetails();
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i).toString());
    }
    public void  displayEmployeeDetailsById(int empId){
        // print employee details else display failure msg
       Employee emp= e.displayEmployeeDetailsById(empId);
       if(emp!=null)
           System.out.println(emp.toString());
            else
                System.out.println("Employee Details not found");
    }
    public void modifyEmployeeDetails(Employee emp){
        //display msg whether modified or not
        if (e.modifyEmployee(emp)) {
            System.out.println("modified inserted succesfully");
        } else System.out.println("modification failed");
    }

    public void deleteEmployeeDetails(int empId){
        //display msg whether modified or not
        if (e.deleteEmployeeByEmployeeId(empId)) {
            System.out.println("deleted inserted succesfully");
        } else System.out.println("Deletion failed");
    }
}
