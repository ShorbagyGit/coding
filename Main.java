import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File myobj = new File("D:\\Gasser\\filetext.txt");

      Scanner filescan= new Scanner(myobj);
        String Z = filescan.nextLine();
        String Y = filescan.nextLine();
        String X = filescan.nextLine();
        String Q = filescan.nextLine();

        System.out.println(Z);
        System.out.println(Y);
        System.out.println(X);
        System.out.println(Q);
try {
    File myobj1 = new File("C:\\Users\\dell\\IdeaProjects\\filesys\\src\\out.txt");
    PrintWriter pw = new PrintWriter("C:\\Users\\dell\\IdeaProjects\\filesys\\src\\out.txt");
    String[] str = {"gasser","mohamed"}; // Array with predefined values

    System.out.println("this line before print command");
    pw.println("this is first line in out.txt file");
    for (String s : str)
    {
        pw.println(s);
    }
    pw.println("Hello this another message from the intellij ");
    pw.close();

    System.out.println("the line is saved to the file by file system");
} catch (FileNotFoundException e) {
    throw new RuntimeException(e);
}

    }
}