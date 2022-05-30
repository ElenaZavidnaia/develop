package ru.my.bank;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import ru.my.bank.bank.Bank;
import ru.my.bank.builders.Builder;
import ru.my.bank.people.Client;
import ru.my.bank.people.CreditExpert;
import ru.my.bank.services.*;


public class BankApp {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        // write your code here

        int clientOption = 0, passportSeries;
        long passportNumber;
        boolean active = false;
        DebitCard debitCard;
        Credit credit;
        CreditExpert creditExpert;
        BankAccount bankAccount = new BankAccount();

        Scanner scanner = new Scanner(System.in);
        Client newClient = null;

        while (!active) {
            try {
                newClient = Builder.buildClient(scanner);
                active = true;
            } catch (MyExceptions e) {
                System.out.println(e);
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Не верно введены данные");
            }
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection connection = getConnection()) {

                System.out.println("Connection successfull");
                insertNewClient(connection, newClient);

                Bank officeBank = Builder.buildBank("СберБанк", "просп.имени 50 лет Октября, 58, Саратов, Россия", "Пётр", "Сергеев", "кредитный эксперт");

                creditExpert = officeBank.getBankEmployee().getCreditExpert();

                Map<Client, Set<Long>> clientBase = WorkWithFile.getClientBase();

                do {
                    System.out.println(" ");
                    System.out.println("1: Открыть банковский счёт");
                    System.out.println("2: Оформить кредит");
                    System.out.println("3: Оформить дебетовую карту");
                    System.out.println("4: Выход");

                    System.out.println("Выберите вариант");
                    try {
                        clientOption = Integer.parseInt(scanner.nextLine());
                    } catch (NoSuchElementException nsee) {
                        System.out.println(nsee.getMessage());
                    }
                    selectOperation(clientOption, creditExpert, bankAccount, scanner, newClient, clientBase);
                }
                while (clientOption != 4);

                scanner.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Connection failed");
        }
    }

    private static void selectOperation(int clientOption, CreditExpert creditExpert, BankAccount bankAccount, Scanner scanner, Client newClient, Map<Client, Set<Long>> clientBase) {
        DebitCard debitCard;
        Credit credit;
        switch (clientOption) {
            case 1 -> {
                System.out.println("1: Открыть банковский счёт");
                Set<Long> accountNumber = new HashSet<>();
                accountNumber = bankAccount.openBankAccount(newClient, clientBase, scanner);

                System.out.println(newClient.getFirstName() + " " + newClient.getLastName());
                Iterator<Long> itr = clientBase.get(newClient).iterator();
                do {
                    System.out.println("Номер счёта :№" + itr.next().toString());
                } while (itr.hasNext());

                WorkWithFile.WritingToFile(clientBase);
            }
            case 2 -> {
                System.out.println("2: Оформить кредит");
                credit = new Credit("потребительский", 3000000, (byte) 5, (byte) 6);
                if (creditExpert.creditOpen(newClient.getCreditworthiness()) &&
                        (credit.getLimit() > 2000000) && (credit.getPeriod() > 10) && (credit.getPeriod() < 3))
                    System.out.println("Кредит можно оформить");
                else System.out.println("Кредит оформить нельзя");
            }
            case 3 -> {
                System.out.println("3: Оформить дебетовую карту");
                debitCard = new DebitCard();
                debitCard.setOwner(newClient.getFirstName() + " " + newClient.getLastName());
                System.out.println(debitCard.getOwner());
            }
            case 4 -> System.out.println("4: Выход");
        }
    }

    private static void insertNewClient(Connection connection, Client newClient) throws SQLException {
        String kv4 = "'";
        String commandSQL = "INSERT INTO clients VALUES (" +
                kv4 + newClient.getFirstName() + kv4 + "," +
                kv4 + newClient.getLastName() + kv4 + "," +
                kv4 + newClient.getPassportSeries() + kv4 + "," +
                kv4 + newClient.getPassportNumber() + kv4 + "," +
                kv4 + newClient.getCreditworthiness() + kv4 + "," +
                kv4 + newClient.getCreditAgreementNumber() + kv4 + ");";
        Statement statement = connection.createStatement();
        statement.executeUpdate(commandSQL);
    }

    private static Connection getConnection() throws SQLException, IOException {
        Properties properties = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("src/main/resources/database.properties"))) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, user, password);
    }
}