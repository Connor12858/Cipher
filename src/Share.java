import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.Scanner;

public class Share {
    private static final Scanner in = new Scanner(System.in);

    public static void Menu(String msg) {
        System.out.println("\n1. Twitter\n2. Reddit\n3. Clipboard\n");
        System.out.print("Input: ");
        int input = in.nextInt();
        in.nextLine();

        switch (input){
            case 1:
                Twitter(msg);
                break;
            case 2:
                Reddit(msg);
                break;
            case 3:
                Clipboard(msg);
                break;
            default:
                System.out.println("Wrong input");
                in.nextLine();
                break;
        }
    }

    private static void Twitter(String msg) {
        String[] impropers = new String[]{"`", "{", "}", "%", "\\"};
        for(String improper: impropers){
            if(msg.contains(improper)){
                String[] msgA =  msg.split(" ");
                msg = "";
                for(int i = 4; i < msgA.length; i++){
                    msg = msg.concat(msgA[i] + " ");
                }

                msg = Cryption.Encrypt(msg);
                Twitter(msg);
                Main.Menu();
            }
        }
        msg = msg.replaceAll(" ", "%20");

        System.out.println("Fixed up msg");
        try {
            String url = "https://twitter.com/intent/tweet?text=" + msg;
            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome " + url});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Reddit(String msg){
        String[] impropers = new String[]{"#", "+", "}", "{"};
        for(String improper: impropers){
            if(msg.contains(improper)){
                String[] msgA =  msg.split(" ");
                msg = "";
                for(int i = 4; i < msgA.length; i++){
                    msg = msg.concat(msgA[i] + " ");
                }

                msg = Cryption.Encrypt(msg);
                Reddit(msg);
                Main.Menu();
            }
        }
        msg = msg.replaceAll(" ", "%20");

        try {
            String url = "https://www.reddit.com/submit?text=" + msg;
            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome " + url});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Clipboard(String msg){
        StringSelection selection = new StringSelection(msg);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

}
