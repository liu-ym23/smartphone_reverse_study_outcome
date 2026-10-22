package com.android.settings.inputmethod;

import android.content.Context;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.inputmethod.InputMethodUtils;
import java.text.Collator;
import java.util.Locale;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
class InputMethodSubtypePreference extends SettingItemSwitch {
    private final boolean mIsSystemLanguage;
    private final boolean mIsSystemLocale;

    InputMethodSubtypePreference(Context r3, InputMethodSubtype r4, InputMethodInfo r5) {
        super(r3);
        setTag(r5.getId() + r4.hashCode());
        setTitle(InputMethodAndSubtypeUtil.getSubtypeLocaleNameAsSentence(r4, r3, r5));
        String r6 = r4.getLocale();
        boolean r0 = false;
        if (TextUtils.isEmpty(r6) == false) goto L5;
        this.mIsSystemLocale = false;
        this.mIsSystemLanguage = false;
        return;
    L5:
        Locale r7 = r3.getResources().getConfiguration().locale;
        boolean r8 = r6.equals(r7.toString());
        this.mIsSystemLocale = r8;
        if (r8 == false) goto L8;
    L9:
        r0 = true;
    L10:
        this.mIsSystemLanguage = r0;
        return;
    L8:
        if (InputMethodUtils.getLanguageFromLocaleString(r6).equals(r7.getLanguage()) == false) goto L10;
        goto L9
    }

    int compareTo(SettingItemSwitch r6, Collator r7) {
        if (this != r6) goto L6;
        return 0;
    L6:
        if ((r6 instanceof InputMethodSubtypePreference) == false) goto L30;
        InputMethodSubtypePreference r1 = (InputMethodSubtypePreference) r6;
        CharSequence r2 = getTitle();
        CharSequence r8 = r6.getTitle();
        if (TextUtils.equals(r2, r8) == false) goto L11;
        return 0;
    L11:
        if (this.mIsSystemLocale == false) goto L14;
        return -1;
    L14:
        if (r1.mIsSystemLocale == false) goto L17;
        return 1;
    L17:
        if (this.mIsSystemLanguage == false) goto L20;
        return -1;
    L20:
        if (r1.mIsSystemLanguage == false) goto L23;
        return 1;
    L23:
        if (TextUtils.isEmpty(r2) == false) goto L26;
        return 1;
    L26:
        if (TextUtils.isEmpty(r8) == false) goto L29;
        return -1;
    L29:
        return r7.compare(r2.toString(), r8.toString());
    L30:
        return 0;
    }
}
