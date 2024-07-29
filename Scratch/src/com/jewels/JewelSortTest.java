package com.jewels;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class JewelSortTest {

    public static void main(String[] args) {
        List<String> jewels = new ArrayList<>();
        jewels.add("opal");
        jewels.add("emerald");
        jewels.add("onyx");
        jewels.add("sapphire");
        jewels.add("diamond");
        jewels.add("malachite");

        jewels.sort(null);  // Null Means Natural or Alpha Order
        dump(jewels);
        System.out.println();

        jewels.sort((jewel1, jewel2) -> Integer.compare(jewel1.length(), jewel2.length()));
        dump(jewels);
        System.out.println();
    }

    private static void dump(List<String> jewelList) {
        for (String jewel : jewelList) {
            System.out.println(jewel);
        }
    }
}
