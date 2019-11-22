public class Lecturer {

    String LName;
    int  LAge;
    String Lusername;
    int Lpassword;
    String Lcourse;

    public void lecturer(String LName, int LAge,String Lusername,int Lpassword,String Lcourse){

        this.LName=LName;
        this.LAge=LAge;
        this.Lusername=Lusername;
        this.Lpassword=Lpassword;
        this.Lcourse=Lcourse;

    }

    public String GetLName(){
        return LName;
    }

    public void SetLName(String LName){
        this.LName=LName;
    }

    public int GetLAge(){
        return LAge;
    }

    public void SetLAge(int LAge){
        this.LAge=LAge;
    }

    public String GetLUsername() {

        return Lusername;
    }

    public void SetLUsername(String Lusername){

        this.Lusername=Lusername;
    }

    public int GetLPassword() {

        return Lpassword;
    }

    public void SetLPassword(int Lpassword){

        this.Lpassword=Lpassword;
    }

    public String GetLCourse() {

        return Lcourse;
    }

    public void SetLCourse(String Lcourse){

        this.Lcourse=Lcourse;
    }
}
