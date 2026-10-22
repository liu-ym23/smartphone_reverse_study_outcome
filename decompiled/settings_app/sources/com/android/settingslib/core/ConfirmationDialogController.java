package com.android.settingslib.core;

import androidx.preference.Preference;

/* JADX INFO: loaded from: classes.dex */
public interface ConfirmationDialogController {
    void dismissConfirmationDialog();

    String getPreferenceKey();

    boolean isConfirmationDialogShowing();

    void showConfirmationDialog(Preference r1);
}
