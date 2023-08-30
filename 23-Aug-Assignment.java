public class Employee {
    int empId;
    String name;
    int salary;
    public Employee(int empId, String name, int salary) {
        this.empId=empId;
        this.name=name;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}


public class Address {

    String street;
    String city;
    String state;
    public Address( String street, String city, String state) {
        this.city=city;
        this.state=state;
        this.street=street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

public class HashMapDisplay {
    public static void main(String[] args) {
        
        //HAshMAp of email and password
        HashMap<String, String> map = new HashMap<>();
        map.put("chaithra@gmail.com","password1");
        map.put("sihi@gmail.com","password2");
        map.put("ramya@gmail.com","password3");

        for(Entry<String,String> k:map.entrySet()){
            System.out.println(k.getKey() + " "+k.getValue());
        }
        //HashMap of Employee and Address
        HashMap<Employee,Address> map2=new HashMap<>();
        map2.put(new Employee(101,"Ajay",1000),new Address("MG street","Banglore","Karnataka"));
        map2.put(new Employee(102,"bob",1200),new Address("MG street","tumkur","Karnataka"));

        Set<Entry<Employee,Address>> eSet= map2.entrySet();
        for(Entry<Employee,Address> e:eSet){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println();
        }

    }
}
