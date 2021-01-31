public class Client extends Person {

    City city;
    Calendar date;
    CarType carType;

    Client()  { // Default Constructor
        // Fields
        Name="";
        Password="";
        city=null;
        date=null;
        carType=null;
    }

    Client(String name, String password){
        // Fields
        super.Name=name;
        super.Password=password;
        city=null;
        date=null;
        carType=null;
    }

    public void setInfo(int cityNo,int carTypeNo){ // Set city and cartype info's of client
        switch (cityNo) {
            case 1:
                this.city = City.Ankara;
                System.out.println(city + " is selected");
                break;
            case 2:
                this.city = City.Istanbul;
                System.out.println(city + " is selected");
                break;
            case 3:
                this.city = City.Balikesir;
                System.out.println(city + " is selected");
                break;
            case 4:
                this.city = City.Izmir;
                System.out.println(city + " is selected");
                break;
            case 5:
                this.city = City.Bursa;
                System.out.println(city + " is selected");
                break;
            case 6:
                this.city = City.Eskisehir;
                System.out.println(city + " is selected");
                break;

            default:
                System.out.println("Please enter valid value!!");
                break;

        }

        switch (carTypeNo) {
            case 1:
                this.carType = CarType.Renault;
                System.out.println(carType + " is selected");
                break;
            case 2:
                this.carType = CarType.Fiat;
                System.out.println(carType + " is selected");
                break;
            case 3:
                this.carType = CarType.Mercedes;
                System.out.println(carType + " is selected");
                break;
            case 4:
                this.carType = CarType.BMW;
                System.out.println(carType + " is selected");
                break;
            case 5:
                this.carType = CarType.Toyota;
                System.out.println(carType + " is selected");
                break;
            case 6:
                this.carType = CarType.Nissan;
                System.out.println(carType + " is selected");
                break;
            default:
                System.out.println("Please enter valid value!!");
                break;
        }
    }


    public void SetDate(int dateNo) { // Set date info's of client
        switch (dateNo) {
            case 1:
                this.date = Calendar.Monday;
                System.out.println(date + " is selected");
                break;
            case 2:
                this.date = Calendar.Tuesday;
                System.out.println(date + " is selected");
                break;
            case 3:
                this.date = Calendar.Wednesday;
                System.out.println(date + " is selected");
                break;
            case 4:
                this.date = Calendar.Thursday;
                System.out.println(date + " is selected");
                break;
            case 5:
                this.date = Calendar.Friday;
                System.out.println(date + " is selected");
                break;
            case 6:
                this.date = Calendar.Saturday;
                System.out.println(date + " is selected");
                break;
            case 7:
                this.date = Calendar.Sunday;
                System.out.println(carType + " is selected");
                break;
            default:
                System.out.println("Please enter valid value!!");
                break;
        }
    }
}
