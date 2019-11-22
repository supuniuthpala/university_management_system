public class Student {

    String name;
    int  age;
    String username;
    int password;
    String course;

    public void student(String name, int age,String username,int password,String course){

        this.name=name;
        this.age=age;
        this.username=username;
        this.password=password;
        this.course=course;

    }

    public String GetName() {

        return name;
    }

    public void SetName(String name){

        this.name=name;
    }

    public int GetAge(){

        return age;
    }

    public void SetAge(int age){

        this.age=age;
    }

    public String GetUsername() {

        return username;
    }

    public void SetUsername(String username){

        this.username=username;
    }

    public int GetPassword() {

        return password;
    }

    public void SetPassword(int password){

        this.password=password;
    }

    public String GetCourse() {

        return course;
    }

    public void SetCourse(String course){

        this.course=course;
    }

}

