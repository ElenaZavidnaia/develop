package ru.my.bank.services;

import ru.my.bank.people.Client;

import java.util.*;

public class ClientDB {

    private Map<Client, Set<Long>> base;

    public Map<Client, Set<Long>> getClientBase() {

        base = new HashMap<>();

        //   base.put(new Client("Дмитрий", "Вольский", 5001, 111111111, "высокая", 1111), account);
        base.put(new Client("Дмитрий", "Вольский", 5001, 111111111, "высокая", 1111), new HashSet<>(Arrays.asList(10000056L, 123456789L)));
        base.put(new Client("Ольга", "Постникова", 5002, 111111112, "низкая", 0), new HashSet<>(0));
        base.put(new Client("Виталий", "Петрушин", 5003, 111111113, "низкая", 1112), new HashSet<>(0));
        base.put(new Client("Макар", "Карпович", 5004, 111111114, "высокая", 1113), new HashSet<>(0));
        base.put(new Client("Стефания", "Парина", 5005, 111111115, "высокая", 1114), new HashSet<>(0));
        base.put(new Client("Евгений", "Дорошенко", 5006, 111111116, "высокая", 0), new HashSet<>(0));
        base.put(new Client("Лидия", "Бирюкова", 5007, 111111117, "низкая", 0), new HashSet<>(0));
        base.put(new Client("Богдан", "Орловский", 5008, 111111118, "высокая", 1115), new HashSet<>(0));
        base.put(new Client("Ирина", "Лунина", 5009, 111111119, "высокая", 1116), new HashSet<>(0));
        base.put(new Client("Всеволод", "Левин", 5010, 111111110, "высокая", 1117), new HashSet<>(0));
/*
        client.add(new Client("Дмитрий", "Вольский", 0, 5001, 111111111, "высокая", 1111));
        client.add(new Client("Ольга", "Постникова", 10000056, 5002, 111111112, "низкая", 0));
        client.add(new Client("Виталий", "Петрушин", 123456789, 5003, 111111113, "низкая", 1112));
        client.add(new Client("Макар", "Карпович", 0, 5004, 111111114, "высокая", 1113));
        client.add(new Client("Стефания", "Парина", 0, 5005, 111111115, "высокая", 1114));
        client.add(new Client("Евгений", "Дорошенко", 1234567891, 5006, 111111116, "высокая", 0));
        client.add(new Client("Лидия", "Бирюкова", 1234567892, 5007, 111111117, "низкая", 0));
        client.add(new Client("Богдан", "Орловский", 0, 5008, 111111118, "высокая", 1115));
        client.add(new Client("Ирина", "Лунина", 1234567893, 5009, 111111119, "высокая", 1116));
        client.add(new Client("Всеволод", "Левин", 0, 5010, 111111110, "высокая", 1117));
*/
        return base;
    }

}
