import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
       List <BankAccount> bankAccounts = new ArrayList<>(List.of(new BankAccount(new Person("Jack", "Naumov",
               "g@gmail.com"), "637821371319", 70000 ),
               new BankAccount(new Person("Nick", "Starostin",
                       "a@gmail.com"), "36781927332", 1000000 )));

        System.out.println("emails:" + transform(bankAccounts, s -> s.getPerson().email));
        System.out.println(transform(bankAccounts, (s) -> s.getPerson().getlName() +" " + s.getPerson().getfName().charAt(0) + ".; IBAN: DE" + s.getIBAN() + "; " + s.getPerson().getEmail()));
        System.out.println("All owners of accounts: "  + transform(bankAccounts, s -> s.getPerson().getlName()+"  " + s.getPerson().getfName().charAt(0) + ".  "));

    }
    public static <T,R> List <R> transform (List<T> list, Function <T,R> function){
        //<T> iterator = list.iterator();
        //while (iterator.hasNext()) {
           // T str = iterator.next();
          List<R> result = new ArrayList<>();
           for (T element:list)  {
               result.add(function.apply(element));
           }
           return result;
        }
    }


