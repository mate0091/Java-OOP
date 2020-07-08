import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class School
{
    private int nrOfClassRooms;
    public ArrayList<ClassRoom> rooms;
    public ArrayList<Student> students;

    public School(int nrOfClassRooms)
    {
        this.nrOfClassRooms = nrOfClassRooms;
        this.rooms = new ArrayList<ClassRoom>();
    }

    public void addClassRoom(String[] generated)
    {
        ClassRoom c = new ClassRoom(generated);

        rooms.add(c);
    }

    public void addStudent(String[] generated, ClassRoom toAdd)
    {
        Student c = new Student(generated, toAdd);

        students.add(c);
    }

    public void one() //populate with students and classrooms
    {
        addClassRoom(Provided.generateClassRoomInfo('E', 0));
        addClassRoom(Provided.generateClassRoomInfo('W', 0));
        addClassRoom(Provided.generateClassRoomInfo('E', 1));
        addClassRoom(Provided.generateClassRoomInfo('S', 0));
        addClassRoom(Provided.generateClassRoomInfo('W', 1));
        addClassRoom(Provided.generateClassRoomInfo('E', 2));
        addClassRoom(Provided.generateClassRoomInfo('N', 0));
        addClassRoom(Provided.generateClassRoomInfo('S', 1));
        addClassRoom(Provided.generateClassRoomInfo('N', 1));
        addClassRoom(Provided.generateClassRoomInfo('N', 2));

        for(ClassRoom i : rooms)
        {
            for(int j = 0; j < i.getNrOfStudents(); j++)
            {
                Student s = new Student(Provided.generatePersonInfo(), i);
                i.addStudent(s);
            }
        }

        for (ClassRoom i : rooms)
        {
            i.printInfo();
            System.out.println();
            i.printStudents();
            System.out.println();
        }
    }

    public void two()
    {
        //int r = ThreadLocalRandom.current().nextInt(0, 6);
        rooms.get(1).sendOnTrip(6);
        rooms.get(0).sendOnTrip(18);
        rooms.get(5).sendOnTrip(13);
    }


    public void three()
    {
        String ssn = rooms.get(0).students.get(0).getInfo()[0];
        //traverse all classrooms
        for(ClassRoom i : rooms)
        {
            for(int j = 0; j < rooms.size() - 1; j++)
            {
                if(i.students.get(j).info[0].compareTo(ssn) == 0)
                {
                    System.out.print("Student: ");
                    i.students.get(j).printInfo();
                    System.out.print("Classroom: ");
                    i.printInfo();
                    System.out.print(" leaves the school forever");
                    System.out.println();
                    i.removeStudent(j);
                }
            }
        }
    }

    public void five()
    {
        System.out.println("All the people in classroom 0: ");

        String code = rooms.get(0).getInfo()[0];

        for(int i = 0; i < rooms.size() - 1; i++)
        {
            if(rooms.get(i).getInfo()[0].compareTo(code) == 0)
            {
                rooms.get(i).printInfo();
                System.out.println();
                rooms.get(i).printStudents();
                System.out.println();
            }
        }
    }

    public void six()
    {
        System.out.println("All the people who went on a trip: ");

        for(ClassRoom i : rooms)
        {
            i.printStudentsOnTrip();
            System.out.println();
        }
    }

    public void eight()
    {
        String ssn = rooms.get(0).students.get(0).getInfo()[0];
        //traverse all classrooms
        for(ClassRoom i : rooms)
        {
            for(int j = 0; j < rooms.size() - 1; j++)
            {
                if(i.students.get(j).info[0].compareTo(ssn) == 0 && !i.students.get(j).isOnTrip())
                {
                    System.out.print("Student: ");
                    i.students.get(j).printInfo();
                    System.out.print("Classroom: ");
                    i.printInfo();
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        School school = new School(10);

        school.one();
        school.two();
        school.three();

        school.five();

        school.six();
        school.eight();
    }
}
