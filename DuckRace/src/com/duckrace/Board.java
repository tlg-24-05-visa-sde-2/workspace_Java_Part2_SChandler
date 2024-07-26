package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 *
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 *
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board implements Serializable{
    private static final String DATA_FILE_PATH = "data/board.dat";
    private static final String CONF_FILE_PATH = "conf/student-ids.csv";

    /*
     *  If data/board.dat exists, the application has been run before, at least once.
     *  Therefore, re-create the Board obj from that binary file.
     *
     *  If file is not there, this is the very first time the app has been run.
     *  Therefore, create and return new Board.
     */
    public static Board getInstance() {
        Board board = null;

        if(Files.exists(Path.of(DATA_FILE_PATH))){
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
                board = (Board) in.readObject();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            board = new Board();
        }
        return board;
    }

    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    //private ctor - prevent instantiation from outside - only getInstance() can do this
    private Board(){

    }

    /*
     * updates the board by making a duckracer win()
     *
     * this could mean fetching an existing duckracer from racermap,
     * or we might need to create a new duckRacer() put() it in the map
     * and then make it win()
     *
     * either way it needs to win()
     */

    public void update(int id, Reward reward){
        DuckRacer racer = null;

        if(racerMap.containsKey(id)){
            racer = racerMap.get(id);
        }
        else{
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);
        save();
    }

    // TODO render the data as we see it in the real application
    public void show(){
        /*
         * maybe an if else here
         * if(racerMap.isEmpty())
         *      there are currently no results to show
         * else
         *      do the work below
         */

        Collection<DuckRacer> racers = racerMap.values();

        String header = """
                
                Duck Race Results
                =================
                
                id  name        wins    rewards
                --  ----        ----    -------""";

        System.out.println(header);
        for(DuckRacer racer : racers){
            System.out.printf("%s   %s      %s      %s\n", racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
        }
    }

    private void save() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))){
            out.writeObject(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    void dumpStudentIdMap(){
        System.out.println(studentIdMap);
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> map = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(CONF_FILE_PATH));
            for(String line : lines){
                String[] tokens = line.split(",");
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                map.put(id, name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}