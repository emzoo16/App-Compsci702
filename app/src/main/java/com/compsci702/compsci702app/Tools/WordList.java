package com.compsci702.compsci702app.Tools;

import com.compsci702.compsci702app.Tools.DBHelper;

import java.util.ArrayList;

public class WordList {

    private ArrayList<String> wordList = new ArrayList<>();
    private DBHelper dbHelper;
    private int listLength;

    public WordList( int listLength){
        this.listLength = listLength;
        getWordListFromDatabase(this.listLength);
    }

    private ArrayList<String> getWordListFromDatabase(int listLength){
        //rb /Dummy data
        wordList.add("Word");
        wordList.add("Jumper");
        return wordList;
    }

    public String getWord(int i){ return wordList.get(i); }

}