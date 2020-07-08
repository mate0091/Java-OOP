public class Student
{
    public String[] info;
    private ClassRoom room;
    private boolean isOnTrip;

    public Student(String[] info, ClassRoom room)
    {
        this.info = info;
        this.room = room;
        this.isOnTrip = false;
    }

    public void sendOnTrip()
    {
        this.isOnTrip = true;
    }

    public void returnFromTrip()
    {
        this.isOnTrip = false;
    }

    public boolean isOnTrip() {
        return isOnTrip;
    }

    public String[] getInfo() {
        return info;
    }

    public void printInfo()
    {
        for(String i : info)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
