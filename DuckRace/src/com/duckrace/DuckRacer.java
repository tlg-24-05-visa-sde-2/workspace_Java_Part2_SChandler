package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class DuckRacer implements Serializable {
    private final int id;
    private final String name;
    private final Collection<Reward> rewards = new ArrayList<>();

    public DuckRacer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void win(Reward reward){
        rewards.add(reward);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // "derived" property - its derived from the size of the collection
    public int getWins(){
        return rewards.size();
    }

    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
    }

    @Override
    public String toString(){
        return String.format("%s: id = %s, name = %s, wins = %s, rewards = %s", getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}