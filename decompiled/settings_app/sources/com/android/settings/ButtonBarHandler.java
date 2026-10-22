package com.android.settings;

import android.widget.Button;

/* JADX INFO: loaded from: classes2.dex */
public interface ButtonBarHandler {
    Button getNextButton();

    boolean hasNextButton();

    void updateBottomLine(boolean r1);

    void updateNextButton(boolean r1);
}
