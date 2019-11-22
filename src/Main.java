import java.util.Scanner;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String name;
        int age;
        int course;
        String username;
        int password;
        int ans;
        int role;

        Connection connection = DataBaseConnection.getInstance().getConnection();
        Scanner input = new Scanner(System.in);

        Course cs = new Course();

        System.out.println("Select [1] Sign up, [2} sign in.");
        ans = input.nextInt();
        switch (ans) {
            case 1:
                System.out.println("Please select your registration role [1]Lecturer, [2]Student.");
                role = input.nextInt();
                switch (role) {
                    case 1:
                        System.out.println("Lecturer Registration Form");
                        System.out.println("Name:");
                        name = input.nextLine();
                        System.out.println("User name:");
                        username = input.nextLine();
                        System.out.println("Password:");
                        password = input.nextInt();
                        System.out.println("Age:");
                        age = input.nextInt();
                        System.out.println("Select the courses:");
                        System.out.println("[1] SENG1111_Introduction_to_Programming");
                        System.out.println("[2] SENG1112_Fundamantales_of_Engineering");
                        System.out.println("[3] SENG1113_Data_Structures_and_Algorithms");
                        course = input.nextInt();
                        Lecturer lec = new Lecturer();

                        switch (course) {
                            case 1:
                                cs.SetCourse(Subject.SENG1111_Introduction_to_Programming);
                                lec.SetLCourse(String.valueOf(Subject.SENG1111_Introduction_to_Programming));
                                break;
                            case 2:
                                cs.SetCourse(Subject.SENG1112_Fundamantales_of_Engineering);
                                lec.SetLCourse(String.valueOf(Subject.SENG1112_Fundamantales_of_Engineering));
                                break;
                            case 3:
                                cs.SetCourse(Subject.SENG1113_Data_Structures_and_Algorithms);
                                lec.SetLCourse(String.valueOf(Subject.SENG1113_Data_Structures_and_Algorithms));
                                break;
                            default:
                        }
                        lec.SetLAge(age);
                        lec.SetLName(name);
                        lec.SetLPassword(password);
                        lec.SetLUsername(username);
                        PreparedStatement stm = connection.prepareStatement("Insert Into Lecturer Values(?,?,?,?,?,?);");

                        stm.setObject(2, lec.GetLName());
                        stm.setObject(3, lec.GetLAge());
                        stm.setObject(4, lec.GetLUsername());
                        stm.setObject(5, lec.GetLPassword());
                        stm.setObject(6, lec.GetLCourse());

                        stm.executeUpdate();
                        System.out.println("You have successfully registered for following courses:");
                        System.out.println(cs.GetCourse());
                        break;

                    case 2:
                        System.out.println("Student Registration Form");
                        System.out.println("Name:");
                        name = input.nextLine();
                        System.out.println("User name:");
                        username = input.nextLine();
                        System.out.println("Password:");
                        password = input.nextInt();
                        System.out.println("Age:");
                        age = input.nextInt();
                        System.out.println("Select the courses:");
                        System.out.println("[1] SENG1111_Introduction_to_Programming");
                        System.out.println("[2] SENG1112_Fundamantales_of_Engineering");
                        System.out.println("[3] SENG1113_Data_Structures_and_Algorithms");
                        course = input.nextInt();
                        Student student = new Student();

                        switch (course) {
                            case 1:
                                cs.SetCourse(Subject.SENG1111_Introduction_to_Programming);
                                student.SetCourse(String.valueOf(Subject.SENG1111_Introduction_to_Programming));
                                break;
                            case 2:
                                cs.SetCourse(Subject.SENG1112_Fundamantales_of_Engineering);
                                student.SetCourse(String.valueOf(Subject.SENG1112_Fundamantales_of_Engineering));
                                break;
                            case 3:
                                cs.SetCourse(Subject.SENG1113_Data_Structures_and_Algorithms);
                                student.SetCourse(String.valueOf(Subject.SENG1113_Data_Structures_and_Algorithms));
                                break;
                            default:
                        }
                        student.SetAge(age);
                        student.SetName(name);
                        student.SetPassword(password);
                        student.SetUsername(username);
                        PreparedStatement stmt = connection.prepareStatement("Insert Into Student Values(?,?,?,?,?,?);");

                        stmt.setObject(2, student.GetName());
                        stmt.setObject(3, student.GetAge());
                        stmt.setObject(4, student.GetUsername());
                        stmt.setObject(5, student.GetPassword());
                        stmt.setObject(6, student.GetCourse());

                        stmt.executeUpdate();
                        System.out.println("You have successfully registered for following courses:");
                        System.out.println(cs.GetCourse());
                        break;
                    default:
                        System.out.println("Invalid role!!!");
                }

            case 2:
                System.out.println("Please select your registration role [1]Lecturer, [2]Student.");
                role = input.nextInt();
                switch (role) {
                    case 1:
                        System.out.println("Lecturer Login Form");

                        System.out.println("User Name:");
                        username = input.nextLine();
                        System.out.println("Password:");
                        password = input.nextInt();

                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from Lecturer where userName='" + username + "'and password='" + password + "';");
                        while (rs.next()) {
                            System.out.println("Hi " + rs.getString(2));
                            System.out.println("You have successfully registered for following courses:");
                            System.out.println(" " + rs.getString(6));
                        }
                        break;
                    case 2:
                        System.out.println("Student Login Form");

                        System.out.println("User Name:");
                        username = input.nextLine();
                        System.out.println("Password:");
                        password = input.nextInt();

                        Statement stm = connection.createStatement();
                        ResultSet resultSet = stm.executeQuery("select * from Student where userName='" + username + "'and password='" + password + "';");
                        while (resultSet.next()) {
                            System.out.println("Hi " + resultSet.getString(2));
                            System.out.println("You have successfully registered for following courses:");
                            System.out.println(" " + resultSet.getString(6));
                        }
                        break;
                    default:
                        System.out.println("Invalid choice!!!");
                }
        }

    }

    }
