package com.senaaladag.paralelFinal;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Paralel extends Thread{
    public static final String PERSON_URL = "C:\\Users\\senaa\\Desktop\\paralelFinal\\Person.txt";
    public static final String SECRET_URL = "C:\\Users\\senaa\\Desktop\\paralelFinal\\Secret.txt";

    //1.VERİ
    public String userDataInformation() {
        Scanner klavye = new Scanner(System.in);
        String username, password, email;
        System.out.println("Username giriniz");
        username = klavye.nextLine();
        System.out.println("Password giriniz");
        password = klavye.nextLine();
        System.out.println("email giriniz");
        email = klavye.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(username).append(password).append(email);
        return stringBuilder.toString();
    }

    public void fileIouserDataInformation() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PERSON_URL, false))) {
            String userData = userDataInformation();
            bufferedWriter.write(userData);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /////////////////////////////////////////////////////////////////
    //2.VERİ
    public String userDataSecretInformation() {
        Scanner klavye = new Scanner(System.in);
        String secretInformation;
        System.out.println("secretInformation giriniz");
        secretInformation = klavye.nextLine();
        //secretInformation= JOptionPane.showInputDialog("secretInformation giriniz");
        return secretInformation;
    }

    public void fileIouserSecretInformation() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SECRET_URL, false))) {
            String userData = userDataSecretInformation();
            bufferedWriter.write(userData);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /////////////////////////////////////////////////////////////////
    // MultiThread
    public static void main(String[] args) throws InterruptedException {
        // 1.Thread
        Paralel paralel=new Paralel();
        paralel.fileIouserDataInformation();// fileIouserDataInformation

        // 2.Thread
        Paralel paralel2=new Paralel();
        paralel2.fileIouserSecretInformation();// fileIouserSecretInformation

        paralel.start();
        paralel.join();

        paralel2.start();
        paralel2.join();
    }

}