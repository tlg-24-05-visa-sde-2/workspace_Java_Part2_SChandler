/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
    private ShoppingCart<Product> productCart;
    private ShoppingCart<MusicItem> musicCart;
    private ShoppingCart<MediaPlayer> mediaCart;

    @Before
    public void init() {
        productCart = new ShoppingCart<Product>();
        productCart.addItem(new MusicItem("CD-501"));
        productCart.addItem(new MediaPlayer("MP3-LP150"));

        musicCart = new ShoppingCart<MusicItem>();
        musicCart.addItem(new MusicItem("CD-521"));
        musicCart.addItem(new MusicItem("CD-514"));

        mediaCart = new ShoppingCart<MediaPlayer>();
        mediaCart.addItem(new MediaPlayer("AAC-PL233"));
    }

    /**
     * TODO: create new Order for each cart above and pass cart to processOrder().
     *  For example, create three Order objects: "order-1", "order-2", "order-3."
     *  order-1 is for the contents of productCart,
     *  order-2 is for the contents of musicCart,
     *  order-3 is for the contents of mediaCart.
     */


    @Test
    public void testProcessCart() {
        Order order1 = new Order("order-1");
        order1.processCart(productCart);        // You are passing ShoppingCart<Product>
        System.out.println();

        Order order2 = new Order("order-2");        //ShoppingCart<MusicItem>
        order2.processCart(musicCart);
        System.out.println();

        Order order3 = new Order("order-3");
        order3.processCart(mediaCart);              // ShoppingCart<MediaPlayer>
        System.out.println();

    }
}