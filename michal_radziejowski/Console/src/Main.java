import java.io.Console;
//trzeba otwierac przez cmd
class Main{
    public static void main(String args[]){

        Console b=System.console();
        System.out.println("Podaj swoje imie: ");
        String n=b.readLine();
        System.out.println("Witaj "+n);


        Console c=System.console();
        System.out.println("Podaj hasło: ");
        char[] ch=c.readPassword();
        String pass=String.valueOf(ch);
        System.out.println("Twoje hasło to: "+pass);
    }
}