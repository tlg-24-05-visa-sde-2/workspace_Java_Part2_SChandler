package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTest {

    public static void main(String[] args) {
        // testFindById();
        // testFindByKeyword();
        // testFindByCategory();
        // testSize();
        // testGetAll();
        testFindRockLessThan();
    }

    private static void testFindRockLessThan() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> cheapRockItems = catalog.findRockLessThan(12.0);
        dump(cheapRockItems);
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem item = catalog.findById(6L);  // autobox primitive long to Long object
        System.out.println(item);

        MusicItem notFound = catalog.findById(66L);
        System.out.println("Not found: " + notFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> items = catalog.findByKeyword("love");
        dump(items);
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        dump(items);
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        int size = catalog.size();
        System.out.println("Catalog size: " + size);
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> readOnlyItems = catalog.getAll(); // read-only view of the 18 items
        System.out.println(readOnlyItems);
    }

    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }
}
