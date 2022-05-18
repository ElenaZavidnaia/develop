package ru.my.bank.services;

import ru.my.bank.people.Client;

import java.io.*;
import java.util.*;

public class WorkWithFile {

    public static void WritingToFile(Map<Client, Set<Long>> clientBase) {

        File myFile = new File("ClientDB.txt");
        Iterator<Long> itrv;

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile)))) {

            for (Map.Entry<Client, Set<Long>> itr : clientBase.entrySet()) {
                writer.print(itr.getKey().toString());
                itrv = itr.getValue().iterator();
                do {
                    writer.print(itrv.next().toString());
                    if (itrv.hasNext()) {
                        writer.print(',');
                    }
                } while (itrv.hasNext());
                writer.println();
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Map<Client, Set<Long>> getClientBase() {

        HashSet<Long> setAccount = new HashSet<>();
        Map<Client, Set<Long>> base = new HashMap<>();

        File myFile = new File("ClientDB.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line = reader.readLine();

            while (line != null) {
                String[] data = line.split("; ", 0);
                String[] initials = data[0].split(" ", 2);
                String[] arrAccount = data[5].split(",", 0);

                try {
                    for (String arrA : arrAccount) {
                        setAccount.add(Long.parseLong(arrA));
                    }

                    HashSet<Long> setAccountForBase = new HashSet<>(setAccount);
                    //String lastName                         long passportNumber               long creditAgreementNumber
                    base.put(new Client(initials[0], initials[1], Integer.parseInt(data[1]), Long.parseLong(data[2]), data[3], Long.parseLong(data[4])), setAccountForBase);
                    //String firstName          int passportSeries                                  String creditworthiness
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe.getMessage());
                }
                setAccount.clear();
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return base;
    }
}