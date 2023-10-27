package org.personal.gallery.javainternals.core;

class Employee implements Cloneable{
    int empID;
    Department department;

    public Employee(int empID, Department department) {
        this.empID = empID;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", department=" + department +
                '}';
    }

    @Override
    public Employee clone() {
        try {
            Employee clone = (Employee) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            // as it is shallow copy
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class Department {
    int dId;
    String name;

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", name='" + name + '\'' +
                '}';
    }

    public Department(int dId, String name) {
        this.dId = dId;
        this.name = name;
    }
}


public class DeepShallowCopyDemo {
    public static void main(String[] args) {

        System.out.println("Testing shallow copy....");
        shallowCopy();


        System.out.println("\n\n\n Testing deep copy....");
        deepCopy();
    }


    private static void shallowCopy() {


        Department department = new Department(1,"marketing");
        Employee employee = new Employee(1,department);

        Employee clonedEmployee = employee.clone();

        System.out.println("## scenario-1 ###");

        //by default for custom class equality defaults to referntial equality, if need to override equals() to compare and contrast actual values
        if(employee.equals(clonedEmployee))
            System.out.println("[referential equality] Both org and clones are equal");
        else
            System.out.println("[referential equality] Both org and clones are <<< not equal >>> ");

        System.out.println("[org] address : "+System.identityHashCode(employee));
        System.out.println("[cloned] address : "+System.identityHashCode(clonedEmployee));


        System.out.println("\n\n ## scenario-2 ###");


        System.out.println("memory address of org and cloned's mutable data member 'department' ");
        System.out.println(System.identityHashCode(employee.department)+","+System.identityHashCode(clonedEmployee.department));

        clonedEmployee.department.name = "finance";
        //the mutable fields of org and cloned are referencing the same object

        System.out.println("After updating mutable data member of cloned object.. which doesn't affect original too ");
        System.out.println("[org] => "+employee);
        System.out.println("[cloned] => "+clonedEmployee);

        System.out.println("\n\n ## scenario-3 ###");


        //note:: even we update department's id it will affect the both as they is part of the object reference
        System.out.println("After updating primitive data member of cloned object.. which in turn affect original too ");
        clonedEmployee.empID = 10;
        System.out.println("[org] => "+employee);
        System.out.println("[cloned] => "+clonedEmployee);
    }

    private static void deepCopy() {
        Department2 department2 = new Department2(1,"marketing");
        Employee2 employee2 = new Employee2(1,department2);

        Employee2 clonedEmployee2 = employee2.clone();

        System.out.println("## scenario-1 ###");

        //by default for custom class equality defaults to referntial equality, if need to override equals() to compare and contrast actual values
        if(employee2.equals(clonedEmployee2))
            System.out.println("[referential equality] Both org and clones are equal");
        else
            System.out.println("[referential equality] Both org and clones are <<< not equal >>> ");

        System.out.println("[org] address : "+System.identityHashCode(employee2));
        System.out.println("[cloned] address : "+System.identityHashCode(clonedEmployee2));


        System.out.println("\n\n ## scenario-2 ###");


        System.out.println("memory address of org and cloned's mutable data member 'department2' ");
        System.out.println(System.identityHashCode(employee2.department2)+","+System.identityHashCode(clonedEmployee2.department2));

        clonedEmployee2.department2.name = "finance";
        //the mutable fields of org and cloned are referencing the same object

        System.out.println("After updating mutable data member of cloned object.. which in turn doesn't affect original as we made deep independent copy ");
        System.out.println("[org] => "+employee2);
        System.out.println("[cloned] => "+clonedEmployee2);

        System.out.println("\n\n ## scenario-3 ###");


        //note:: even we update department2's id it will affect the both as they is part of the object reference
        System.out.println("After updating primitive data member of cloned object..");
        clonedEmployee2.empID = 10;
        System.out.println("[org] => "+employee2);
        System.out.println("[cloned] => "+clonedEmployee2);
    }


}

class Employee2 implements Cloneable{
    int empID;
    Department2 department2;

    public Employee2(int empID, Department2 department) {
        this.empID = empID;
        this.department2 = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", department=" + department2 +
                '}';
    }

    @Override
    public Employee2 clone() {
        try {
            Employee2 clone = (Employee2) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            // updated shallow copy of department within clone to deep copy by making mutable params also be cloneable
            clone.department2 = (Department2) clone.department2.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class Department2 implements Cloneable{
    int dId;
    String name;

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", name='" + name + '\'' +
                '}';
    }

    public Department2(int dId, String name) {
        this.dId = dId;
        this.name = name;
    }

    @Override
    public Department2 clone() {
        try {
            Department2 clone = (Department2) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

