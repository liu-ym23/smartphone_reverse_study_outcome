package com.android.settingslib.inputmethod;

import android.content.Context;
import androidx.preference.SwitchPreference;

/* JADX INFO: loaded from: classes.dex */
public class SwitchWithNoTextPreference extends SwitchPreference {
    private static final String EMPTY_TEXT = "";

    public SwitchWithNoTextPreference(Context r1) {
        super(r1);
        setSwitchTextOn("");
        setSwitchTextOff("");
    }
}
