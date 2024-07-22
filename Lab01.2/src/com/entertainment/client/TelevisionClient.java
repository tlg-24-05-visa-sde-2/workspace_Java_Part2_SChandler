package com.entertainment.client;

import com.entertainment.Television;

import java.util.LinkedHashSet;
import java.util.Set;

public class TelevisionClient {
    public static void main(String[] args) {

        // examine behavior of == and equals()
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 52);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        System.out.println("tvA == tvB: " + (tvA == tvB)); // definitely false
        System.out.println("tvA.equals(tvB):" + tvA.equals(tvB)); // this is true
        System.out.println();

        // System.out.println(tvA.hashCode());
       // System.out.println(tvB.hashCode());

        Set<Television> tvs = new LinkedHashSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("The size of the Set is " + tvs.size());
        System.out.println();

        for (Television tv : tvs) {
            System.out.println(tv); // toString() automatically called
        }
    }
}
