package Inheritance;

public class UnderGraduate extends Student{
    public UnderGraduate(int id,String name,String address,int age,double grade)
    {
        super.setId(id);
        super.setName(name);
        super.setAddress(address);
        super.setAge(age);
        super.setGrade(grade);
    }
    @Override
    public boolean isPassed(double grade) 
    {
        if(grade>70)
            return true;
        else 
            return false;
    }
}
