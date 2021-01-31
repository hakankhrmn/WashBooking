import java.util.ArrayList;
import java.util.List;

public class Technic extends Person{
    List<String> reportlist; // Store reports in Arraylist

    Technic(String name, String password){
        super.Name=name;
        super.Password=password;
        reportlist = new ArrayList();
    }

    void getReports() // Displays the reports
    {
        System.out.println("List of reports");
        if (reportlist.size() == 0)
            System.out.println("There is not any report");
        else
            System.out.println(reportlist);
    }
    void solveReports(int num){ // Solve the reports
        System.out.println(" ' " + reportlist.get(num-1) +  " '  is solved...");
    }
}