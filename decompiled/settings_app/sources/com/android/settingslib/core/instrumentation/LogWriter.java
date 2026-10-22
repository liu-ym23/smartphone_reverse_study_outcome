package com.android.settingslib.core.instrumentation;

import android.content.Context;
import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public interface LogWriter {
    void action(int r1, int r2, int r3, String r4, int r5);

    void action(Context r1, int r2, int r3);

    void action(Context r1, int r2, String r3);

    void action(Context r1, int r2, boolean r3);

    void action(Context r1, int r2, Pair<Integer, Object>... r3);

    void changed(int r1, String r2, int r3);

    void clicked(int r1, String r2);

    void hidden(Context r1, int r2, int r3);

    void visible(Context r1, int r2, int r3, int r4);
}
