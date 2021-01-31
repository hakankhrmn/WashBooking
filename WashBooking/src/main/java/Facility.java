import java.util.HashMap;
import java.util.Map;

public class Facility extends Person {
    private final String ConfirmMessage="Reservation is successfully";
    private final String ErrorMessage="Reservation is not successfully.Please select another date!";

    Facility(String name, String password){
        super.Name=name;
        super.Password=password;
    }
    static Map<Integer,Integer> availableDays;

    public void tickTheBusyDays(){ // Owner tick the busy days, for demo simulation program, days ticked automatically
        availableDays=new HashMap();
        for(int i=1;i<8;i++){
            availableDays.put(i,0);
            if((i==2)||(i==6)||(i==3)){
                availableDays.put(i,1);
            }
        }

    }
    public Map sendAvailableDays(){
        return availableDays;
    }

    public void getConfirmMessage() {
        System.out.println(ConfirmMessage);
    } // Reservation is succesfully

    public void getErrorMessage() {
        System.out.println(ErrorMessage);
    } // Reservation is not succesfully
}
