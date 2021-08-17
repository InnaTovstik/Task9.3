package com.company;
//3. Пользователь вводит с клавиатуры любые строки.
// Нужно посчитать сколько раз какая строка была введена.
// Вывести 2 строки, которые вводились чаще остальных.

import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = mapCreate();
        System.out.println(map);
        TreeSet t = searchMaxStrings(map);
        for (Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if( t.tailSet(t.size()).contains(value) || t.subSet(t.size()-1,t.size()).contains(value)){
                System.out.println("key: " + key + ", value: " + value);
            }
        }
    }

    private static TreeSet searchMaxStrings(Map<String, Integer> map) {
        Collection<Integer> values = map.values();
        TreeSet sortedSet = new TreeSet(values);
        sortedSet.addAll(values);
        return sortedSet;
    }

    private static Map<String, Integer> mapCreate() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            String str = readText();
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        return map;
    }

    private static String readText() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}