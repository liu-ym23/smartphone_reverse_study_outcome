package com.android.settingslib.inputmethod;

import android.content.Context;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import androidx.preference.Preference;
import java.text.Collator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class InputMethodSubtypePreference extends SwitchWithNoTextPreference {
    private final boolean mIsSystemLanguage;
    private final boolean mIsSystemLocale;

    public InputMethodSubtypePreference(Context r8, InputMethodSubtype r9, InputMethodInfo r10) {
        this(r8, r10.getId() + r9.hashCode(), InputMethodAndSubtypeUtil.getSubtypeLocaleNameAsSentence(r9, r8, r10), r9.getLocaleObject(), r8.getResources().getConfiguration().locale);
    }

    InputMethodSubtypePreference(Context r1, String r2, CharSequence r3, Locale r4, Locale r5) {
        super(r1);
        boolean r6 = false;
        setPersistent(false);
        setKey(r2);
        setTitle(r3);
        if (r4 != null) goto L5;
        this.mIsSystemLocale = false;
        this.mIsSystemLanguage = false;
        return;
    L5:
        boolean r7 = r4.equals(r5);
        this.mIsSystemLocale = r7;
        if (r7 == false) goto L8;
    L9:
        r6 = true;
    L10:
        this.mIsSystemLanguage = r6;
        return;
    L8:
        if (TextUtils.equals(r4.getLanguage(), r5.getLanguage()) == false) goto L10;
        goto L9
    }

    public int compareTo(Preference r7, Collator r8) {
        int r0 = 0;
        if (this != r7) goto L6;
        return 0;
    L6:
        if ((r7 instanceof InputMethodSubtypePreference) == false) goto L39;
        InputMethodSubtypePreference r1 = (InputMethodSubtypePreference) r7;
        boolean r2 = this.mIsSystemLocale;
        if (r2 == false) goto L13;
        if (r1.mIsSystemLocale == true) goto L13;
        return -1;
    L13:
        if (r2 == false) goto L15;
    L17:
        boolean r3 = this.mIsSystemLanguage;
        if (r3 == true) goto L20;
    L22:
        if (r3 == false) goto L24;
    L26:
        CharSequence r6 = getTitle();
        CharSequence r9 = r7.getTitle();
        boolean r4 = TextUtils.isEmpty(r6);
        boolean r5 = TextUtils.isEmpty(r9);
        if (r4 == true) goto L31;
        if (r5 == true) goto L31;
        return r8.compare(r6.toString(), r9.toString());
    L31:
        if (r4 == false) goto L33;
        int r10 = -1;
    L34:
        if (r5 == false) goto L37;
        r0 = -1;
    L37:
        return r10 - r0;
    L33:
        r10 = 0;
        goto L34
    L24:
        if (r1.mIsSystemLanguage == false) goto L26;
        return 1;
    L20:
        if (r1.mIsSystemLanguage == true) goto L22;
        return -1;
    L15:
        if (r1.mIsSystemLocale == false) goto L17;
        return 1;
    L39:
        return super.compareTo2(r7);
    }
}
