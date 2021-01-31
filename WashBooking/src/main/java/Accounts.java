import java.util.ArrayList;
import java.util.List;


public class Accounts {
    List<Person> AccountList;

    Accounts(){
        AccountList = new ArrayList();
    }  // Store accounts in AccountList ArrayList

    public void Register(Person account){ // Register user and add data's to the list
        AccountList.add(account);
        System.out.println("*** Succesfully Registered ***");
    }

    public Person Login(String name, String Password){ // Checks data's if there is equals or not with accountlist

        for (Person account: AccountList) {
            if ((account.Name.equals(name))&&(account.Password.equals(Password))){
                System.out.println("Logging in is successfull");
                return account;
            }else if((account.Name.equals(name)) && (!account.Password.equals(Password))){
                System.out.println("Wrong password. Please try again  ");
            }else if((!account.Name.equals(name)) && (account.Password.equals(Password))) {
                System.out.println("Wrong user name. Please try again  ");
            }

        }
        return null;
    }

}
