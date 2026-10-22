package com.obric.security.quickclear;

/* JADX INFO: loaded from: classes4.dex */
public class Score {
    public int memoryScore;
    public int otaScore;
    public int totalScore;
    public int trashScore;

    public Score() {
        this.otaScore = 0;
        this.totalScore = 100;
    }

    public int getCleanScore() {
        return this.trashScore + this.memoryScore;
    }
}
