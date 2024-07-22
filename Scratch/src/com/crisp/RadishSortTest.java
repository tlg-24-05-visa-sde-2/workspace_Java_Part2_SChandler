package com.crisp;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<Radish>();

        radishes.add(new Radish("red", 2.75, 0.0, 7));
        radishes.add(new Radish("pink", 1.1, 2.1, 2));
        radishes.add(new Radish("red", 0.7, 3.3, 0));
        radishes.add(new Radish("black", 1.9, 0.0, 0));

        System.out.println("Original list");
        dump(radishes);
        System.out.println();

        System.out.println("Sort by natural order (size)");
        dump(radishes);
        System.out.println();

        System.out.println("Sort by SproutsOnTop, via Comparator");
        radishes.sort(new RadishSproutsOnTopComparator());
        dump(radishes);
        System.out.println();
    }
    private static void dump(List<Radish> radishList) {
        for (Radish radish: radishList) {
            System.out.println(radish);    // toString() automatically called
        }

    }
}
