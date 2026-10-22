package com.android.settings.inputmethod;

import android.content.Context;
import androidx.preference.SwitchPreference;

/* JADX INFO: loaded from: classes2.dex */
class SwitchWithNoTextPreference extends SwitchPreference {
    private static final String EMPTY_TEXT = "";

    SwitchWithNoTextPreference(Context r1) {
        super(r1);
        setSwitchTextOn("");
        setSwitchTextOff("");
    }
}
