package com.crisp;

import java.util.Comparator;

public class RadishSproutsOnTopComparator implements Comparator<Radish> {

    @Override
    public int compare(Radish r1, Radish r2) {
        return Integer.compare(r1.getSproutsOnTop(), r2.getSproutsOnTop());
    }
}
