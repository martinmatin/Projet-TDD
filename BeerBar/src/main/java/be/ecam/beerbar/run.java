package be.ecam.beerbar;

import java.util.Scanner;

/**
 * This is the runnable class of the project.
 */
public class run {
        
    private static final String MENU_MAIN = ""
            + "What do you want to do?       \n"
            + "(1) Manage stock              \n"
            + "(2) Select beer               \n"
            + "(3) See previous selection    \n"
            + "(0) Close                     \n"
            + "Enter your selection [0-3]: ";
 
    private static final String MENU_STOCK = ""
            + "What do you want to do?        \n"
            + "(1) Add beer                   \n"
            + "(2) Change qte or remove       \n"
            + "(3) See critic quantities      \n"
            + "Enter your selection [1-3]: ";

    private static final String MENU_BEER = ""
            + "What do you want to do?       \n"
            + "(1) By name                   \n"
            + "(2) By color                  \n"
            + "(3) By volume                 \n"
            + "Enter your selection [1-3]: ";
    
    private static final Stock STOCK = new Stock();
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        
        while (running) {

            System.out.print(MENU_MAIN);

            int selection = input_check(sc, 0, 3, MENU_MAIN);

            switch (selection) {
                case 1:
                    System.out.print(MENU_STOCK);
                    STOCK.manage();
                    break;

                case 2:
                    System.out.print(MENU_BEER);
                    STOCK.select();
                    break;

                case 3:
                    System.out.println("The last bottles ordered were:");
                    // not implemented
                    break;
                    
                default:
                    running = false;
                    break;
            }       
        
        }      
    }

    public static int input_check(Scanner sc, int lower, int upper, String errorStr) {
        int iinput = -1;
        String notice = errorStr != null ? errorStr : "Invalid input, please retry:";

        while (true) {
            try {
                iinput = Integer.parseInt(sc.nextLine());
                while (iinput < lower || iinput > upper) {
                    System.err.print(notice);
                    iinput = Integer.parseInt(sc.nextLine());
                }
                break;
            } catch(NumberFormatException e) {
                System.err.println(notice);
            }
        }

        return iinput;
    }
}
