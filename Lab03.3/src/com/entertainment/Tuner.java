/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc. They is no setter validation are not worth testing, there are no action methods included.
 */
package com.entertainment;

class Tuner {
    private int channel = 3;  // default channel for cable and satellite customers

    public int getChannel() {
        return this.channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}