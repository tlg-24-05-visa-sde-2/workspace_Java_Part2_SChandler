package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RadishSortTestLambda {
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
        radishes.sort(Comparator.comparingDouble(Radish::getSize));
        dump(radishes);
        System.out.println();

        System.out.println("Sort by SproutsOnTop, via lambda for the Comparator");
        radishes.sort((r1, r2) -> Integer.compare(r1.getSproutsOnTop(), r2.getSproutsOnTop()));
        dump(radishes);
        System.out.println();

        System.out.println("Sort by tailLength, via lambda for the Comparator");
        radishes.sort((r1, r2) -> Double.compare(r1.getTailLength(), r2.getTailLength()));
        dump(radishes);
        System.out.println();
    }

    private static void dump(List<Radish> radishList) {
        for (Radish radish: radishList) {
            System.out.println(radish);    // toString() automatically called
        }
    }
}
