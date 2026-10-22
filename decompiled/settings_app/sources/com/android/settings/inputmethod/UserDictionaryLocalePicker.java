package com.android.settings.inputmethod;

import com.android.internal.app.LocalePicker;

/* JADX INFO: loaded from: classes2.dex */
public class UserDictionaryLocalePicker extends LocalePicker {
    public UserDictionaryLocalePicker(UserDictionaryAddWordFragment r1) {
        setLocaleSelectionListener(r1);
    }
}
