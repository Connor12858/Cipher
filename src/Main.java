import java.util.Scanner;

public class Main {

    private final static Scanner in = new Scanner(System.in);
    public static String Title() {
        String s = "\n" +
                "                                                                                                                                                              \n" +
                "                                                                                                                                                              \n" +
                "        CCCCCCCCCCCCCRRRRRRRRRRRRRRRRR   YYYYYYY       YYYYYYYPPPPPPPPPPPPPPPPP   TTTTTTTTTTTTTTTTTTTTTTTIIIIIIIIII     OOOOOOOOO     NNNNNNNN        NNNNNNNN\n" +
                "     CCC::::::::::::CR::::::::::::::::R  Y:::::Y       Y:::::YP::::::::::::::::P  T:::::::::::::::::::::TI::::::::I   OO:::::::::OO   N:::::::N       N::::::N\n" +
                "   CC:::::::::::::::CR::::::RRRRRR:::::R Y:::::Y       Y:::::YP::::::PPPPPP:::::P T:::::::::::::::::::::TI::::::::I OO:::::::::::::OO N::::::::N      N::::::N\n" +
                "  C:::::CCCCCCCC::::CRR:::::R     R:::::RY::::::Y     Y::::::YPP:::::P     P:::::PT:::::TT:::::::TT:::::TII::::::IIO:::::::OOO:::::::ON:::::::::N     N::::::N\n" +
                " C:::::C       CCCCCC  R::::R     R:::::RYYY:::::Y   Y:::::YYY  P::::P     P:::::PTTTTTT  T:::::T  TTTTTT  I::::I  O::::::O   O::::::ON::::::::::N    N::::::N\n" +
                "C:::::C                R::::R     R:::::R   Y:::::Y Y:::::Y     P::::P     P:::::P        T:::::T          I::::I  O:::::O     O:::::ON:::::::::::N   N::::::N\n" +
                "C:::::C                R::::RRRRRR:::::R     Y:::::Y:::::Y      P::::PPPPPP:::::P         T:::::T          I::::I  O:::::O     O:::::ON:::::::N::::N  N::::::N\n" +
                "C:::::C                R:::::::::::::RR       Y:::::::::Y       P:::::::::::::PP          T:::::T          I::::I  O:::::O     O:::::ON::::::N N::::N N::::::N\n" +
                "C:::::C                R::::RRRRRR:::::R       Y:::::::Y        P::::PPPPPPPPP            T:::::T          I::::I  O:::::O     O:::::ON::::::N  N::::N:::::::N\n" +
                "C:::::C                R::::R     R:::::R       Y:::::Y         P::::P                    T:::::T          I::::I  O:::::O     O:::::ON::::::N   N:::::::::::N\n" +
                "C:::::C                R::::R     R:::::R       Y:::::Y         P::::P                    T:::::T          I::::I  O:::::O     O:::::ON::::::N    N::::::::::N\n" +
                " C:::::C       CCCCCC  R::::R     R:::::R       Y:::::Y         P::::P                    T:::::T          I::::I  O::::::O   O::::::ON::::::N     N:::::::::N\n" +
                "  C:::::CCCCCCCC::::CRR:::::R     R:::::R       Y:::::Y       PP::::::PP                TT:::::::TT      II::::::IIO:::::::OOO:::::::ON::::::N      N::::::::N\n" +
                "   CC:::::::::::::::CR::::::R     R:::::R    YYYY:::::YYYY    P::::::::P                T:::::::::T      I::::::::I OO:::::::::::::OO N::::::N       N:::::::N\n" +
                "     CCC::::::::::::CR::::::R     R:::::R    Y:::::::::::Y    P::::::::P                T:::::::::T      I::::::::I   OO:::::::::OO   N::::::N        N::::::N\n" +
                "        CCCCCCCCCCCCCRRRRRRRR     RRRRRRR    YYYYYYYYYYYYY    PPPPPPPPPP                TTTTTTTTTTT      IIIIIIIIII     OOOOOOOOO     NNNNNNNN         NNNNNNN\n\n" +
                "==============================================================================================================================================================\n" +
                "==============================================================================================================================================================";
        return s;
    }

    public static void main(String[] args) {
        Cryption.SetValues();

        Menu();
    }

    public static void Menu(){
        System.out.println(Title());

        System.out.println("\n1. Encrypt\n2. Decrypt\n\n99. Exit\n");
        System.out.print("Input: ");
        int input = in.nextInt();
        in.nextLine();
        String msg = "";
        switch (input) {
            case 1:
                while(msg.length() < 3  || msg.length() > 25){
                    System.out.print("Message: ");
                    msg = in.nextLine();
                }
                msg = Cryption.Encrypt(msg);
                //System.out.println(msg);
                Share.Menu(msg);
                break;
            case 2:
                System.out.print("Message: ");
                msg = in.nextLine();
                msg = Cryption.Decrypt(msg);
                System.out.println("Decrypted: " + msg);
                break;
            case 99:
                break;
            default:
                System.out.println("Wrong try again");
                in.nextLine();
                Menu();
                break;
        }
    }
    public static void Close(){
        System.exit(0);
    }

}