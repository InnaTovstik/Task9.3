package com.company;
//3. Пользователь вводит с клавиатуры любые строки.
// Нужно посчитать сколько раз какая строка была введена.
// Вывести 2 строки, которые вводились чаще остальных.

import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> sortMap = createSortMap();
        printMax(sortMap);
    }

    private static Map<String, Integer> createSortMap() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Print string and press Enter. Press Enter to finish");
        String str;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            str = buffer.readLine();
            if (str.equals("")) {
                break;
            }
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        return sortByValue(map);
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        ComparatorMap mComp = new ComparatorMap();
        list.sort(mComp);
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static void printMax(Map<String, Integer> map) {
        System.out.println(map);
        int mapLength = map.size();
        if (mapLength != 0) {
            Set<Entry<String, Integer>> mapValues = map.entrySet();
            Entry<String, Integer>[] entries = new Entry[mapLength];
            mapValues.toArray(entries);
            System.out.println("Две строки, которые встречались чаще всего: ");
            System.out.print("Key:" + entries[0].getKey());
            System.out.println(" Value:" + entries[0].getValue());
            System.out.print("Key:" + entries[1].getKey());
            System.out.println(" Value:" + entries[1].getValue());
        }
        else{
            System.out.println("Нет введенных строк!!!");
        }
    }
}
