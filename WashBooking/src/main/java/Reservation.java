public class Reservation {
    City City;
    CarType Cartype;
    Calendar Date;
    String ClientName;

    Reservation(){
        this.City=null;
        this.Cartype=null;
        this.Date=null;
        this.ClientName="";
    }

    public  void makeReservation(Client client){ // Make reservation, synchronize data's with client object
        this.City= client.city;
        this.Cartype=client.carType;
        this.Date= client.date;
        this.ClientName=client.Name;
    }
    public  void getReservation(){ // Display the reservation info's
        System.out.println("______________________________________");
        System.out.println("\nReservation Information");
        System.out.println("Client Name: "+ClientName);
        System.out.println("Client Car Type: "+Cartype.toString());
        System.out.println("Client City: "+City.toString());
        System.out.println("Reservation Date: "+Date);
        System.out.println("______________________________________");
    }
}
