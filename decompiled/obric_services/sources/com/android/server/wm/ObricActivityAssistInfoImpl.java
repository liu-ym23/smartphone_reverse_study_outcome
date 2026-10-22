package com.android.server.wm;

/* JADX INFO: loaded from: classes.dex */
public class ObricActivityAssistInfoImpl implements IObricActivityAssistInfo {
    private ActivityAssistInfo mBase;
    private int mWindowMode;

    public ObricActivityAssistInfoImpl(ActivityAssistInfo base) {
        this.mBase = base;
    }

    public void setWindowMode(int mode) {
        this.mWindowMode = mode;
    }

    public int getWindowMode() {
        return this.mWindowMode;
    }
}
