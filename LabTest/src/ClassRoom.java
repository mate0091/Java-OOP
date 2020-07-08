import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ClassRoom
{
    private String[] info;
    private int nrOfStudents;

    public ArrayList<Student> students;

    public ClassRoom(String[] info)
    {
        this.info = info;

        this.nrOfStudents = Integer.parseInt(this.info[1]);

        this.students = new ArrayList<Student>();
    }

    public String[] getInfo() {
        return info;
    }

    public void addStudent(Student s)
    {
        if(students.size() == nrOfStudents) return;

        students.add(s);
    }

    public void removeStudent(int index)
    {
        students.remove(index);
    }

    public void printStudents()
    {
        System.out.println();
        for (Student i : students)
        {
            if(i.isOnTrip() != true)
            {
                i.printInfo();
            }
            System.out.println();
        }
    }

    public void printStudentsOnTrip()
    {
        for (Student i : students)
        {
            if(i.isOnTrip() == true)
            {
                System.out.println();
                i.printInfo();
            }
            //System.out.println();
        }
    }

    public void printInfo()
    {
        for(String i : info)
        {
            System.out.print(i + " ");
        }
    }

    public int getNrOfStudents() {
        return nrOfStudents;
    }

    public void sendOnTrip(int index)
    {
        students.get(index).sendOnTrip();
    }
}
