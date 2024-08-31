package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTastiera {

    //libro pag. A120 e dintorni
    private static InputStreamReader input=new InputStreamReader(System.in);
    private static BufferedReader reader= new BufferedReader(input);


    //metodi per leggere vari tipi di input
    //numeri interi
    public static int leggiInt() {
        int app=0;
        boolean fatto=false;
        do {
            try {
                app=Integer.parseInt(reader.readLine());
                fatto=true;
            } catch (NumberFormatException e) {
                System.out.println("Formato dell'input non valido; riprova: ");
                //e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        while(!fatto);
        return app;
    }
    public static int leggiInt(String msg) {
        System.out.println(msg);
        return leggiInt();
    }

    //numeri con virgola
    public static double leggiDouble() {
        double app=0;
        boolean fatto=false;
        do {
            try {
                app=Double.parseDouble(reader.readLine());
                fatto=true;
            } catch (NumberFormatException e) {
                System.out.println("Formato dell'input non valido; riprova: ");
                //e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        while(!fatto);
        return app;
    }
    public static double leggiDouble(String msg) {
        System.out.println(msg);
        return leggiDouble();
    }

    //stringhe
    public static String leggiString() {
        String app="";
        try {
            app= reader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return app;
    }
    public static String leggiString(String msg) {
        System.out.println(msg);
        return leggiString();
    }

}