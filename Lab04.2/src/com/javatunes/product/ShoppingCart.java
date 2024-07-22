/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 * Thinking ahead, clients will create: ShoppingCart<Products>, ShoppingCart<MusicItem>, ShoppingCart<MediaPlayer>
 */
package com.javatunes.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ShoppingCart<T extends Product> {
    private final Collection<T> items = new ArrayList<>();  // diamond not used here just to emphasize the T

    public Collection<T> allItems() {
        return Collections.unmodifiableCollection(items);
    }

    public double total() {
        double result = 0.0;
        for (T item : items) {
            result = result + item.getPrice();
        }
        return result;
    }

    public int size() {
        return items.size();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }
}
