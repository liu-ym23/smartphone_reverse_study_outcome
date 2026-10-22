package com.ss.android.event;

/* JADX INFO: loaded from: classes2.dex */
public class NightModeChangeEvent {
    private boolean mChecked;

    public NightModeChangeEvent(boolean r1) {
        this.mChecked = r1;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean r1) {
        this.mChecked = r1;
    }
}
