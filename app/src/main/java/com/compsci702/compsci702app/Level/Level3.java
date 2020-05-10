package com.compsci702.compsci702app.Level;

import android.content.Context;

import com.compsci702.compsci702app.Tools.SentenceList;

public class Level3 extends Level{

    public Level3(Context context) {
        super(context);
        this.levelType = LevelType.LEVEL_3;
        this.levelText = "Level 3 of 3";
        this.levelDescription = "Unscramble 8 words within the minute to win this game";
        this.wordCountGoal = 8;
        this.levelNumber = 3;
        sentenceList = new SentenceList(wordCountGoal, context);
        targetSentence = sentenceList.getWord(currentWordCount);
    }
}
