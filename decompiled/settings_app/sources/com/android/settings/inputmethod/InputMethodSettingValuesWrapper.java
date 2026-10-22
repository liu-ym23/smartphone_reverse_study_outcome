package com.android.settings.inputmethod;

import android.app.ActivityManagerNative;
import android.content.Context;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.inputmethod.InputMethodUtils;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class InputMethodSettingValuesWrapper {
    private static final Locale ENGLISH_LOCALE = null;
    private static final String TAG = "InputMethodSettingValuesWrapper";
    private static volatile InputMethodSettingValuesWrapper sInstance;
    private final HashSet<InputMethodInfo> mAsciiCapableEnabledImis;
    private final InputMethodManager mImm;
    private final ArrayList<InputMethodInfo> mMethodList;
    private final HashMap<String, InputMethodInfo> mMethodMap;
    private final InputMethodUtils.InputMethodSettings mSettings;

    static {
        ENGLISH_LOCALE = new Locale("en");
    }

    public static InputMethodSettingValuesWrapper getInstance(Context r2) {
        if (sInstance != null) goto L15;
        String r0 = TAG;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new InputMethodSettingValuesWrapper(r2.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static int getDefaultCurrentUserId() {
        return ActivityManagerNative.getDefault().getCurrentUser().id;
    L4:
        e = move-exception;
        Slog.w(TAG, "Couldn't get current user ID; guessing it's 0", e);
        return 0;
    }

    private InputMethodSettingValuesWrapper(Context r9) {
        ArrayList<InputMethodInfo> r4 = new ArrayList();
        this.mMethodList = r4;
        HashMap<String, InputMethodInfo> r3 = new HashMap();
        this.mMethodMap = r3;
        this.mAsciiCapableEnabledImis = new HashSet();
        this.mSettings = new InputMethodUtils.InputMethodSettings(r9.getResources(), r9.getContentResolver(), r3, r4, getDefaultCurrentUserId(), false);
        this.mImm = (InputMethodManager) r9.getSystemService("input_method");
        refreshAllInputMethodAndSubtypes();
    }

    void refreshAllInputMethodAndSubtypes() {
        HashMap<String, InputMethodInfo> r0 = this.mMethodMap;
        monitor-enter(r0);
        this.mMethodList.clear();     // Catch: Throwable -> L11
        this.mMethodMap.clear();     // Catch: Throwable -> L11
        List<InputMethodInfo> r1 = this.mImm.getInputMethodList();     // Catch: Throwable -> L11
        this.mMethodList.addAll(r1);     // Catch: Throwable -> L11
        Iterator<InputMethodInfo> r2 = r1.iterator();     // Catch: Throwable -> L11
    L6:
        if (r2.hasNext() == false) goto L8;
        InputMethodInfo r3 = r2.next();     // Catch: Throwable -> L11
        this.mMethodMap.put(r3.getId(), r3);     // Catch: Throwable -> L11
        goto L6
    L8:
        updateAsciiCapableEnabledImis();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void updateAsciiCapableEnabledImis() {
        HashMap<String, InputMethodInfo> r0 = this.mMethodMap;
        monitor-enter(r0);
        this.mAsciiCapableEnabledImis.clear();     // Catch: Throwable -> L17
        Iterator<InputMethodInfo> r1 = this.mSettings.getEnabledInputMethodListLocked().iterator();     // Catch: Throwable -> L17
    L6:
        if (r1.hasNext() == false) goto L15;
        InputMethodInfo r2 = r1.next();     // Catch: Throwable -> L17
        int r3 = r2.getSubtypeCount();     // Catch: Throwable -> L17
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L6;
        InputMethodSubtype r5 = r2.getSubtypeAt(r4);     // Catch: Throwable -> L17
        if ("keyboard".equalsIgnoreCase(r5.getMode()) == false) goto L14;
        if (r5.isAsciiCapable() == false) goto L14;
        this.mAsciiCapableEnabledImis.add(r2);     // Catch: Throwable -> L17
    L14:
        r4 = r4 + 1;     // Catch: Throwable -> L17
        goto L8
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    List<InputMethodInfo> getInputMethodList() {
        HashMap<String, InputMethodInfo> r0 = this.mMethodMap;
        monitor-enter(r0);
        ArrayList<InputMethodInfo> r1 = this.mMethodList;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    CharSequence getCurrentInputMethodName(Context r4) {
        HashMap<String, InputMethodInfo> r1 = this.mMethodMap;
        monitor-enter(r1);
        InputMethodInfo r2 = getCurrentInputMethodInfo();     // Catch: Throwable -> L12
        if (r2 != null) goto L9;
        OLog.w(TAG, "Invalid selected imi: " + this.mSettings.getSelectedInputMethod());     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return "";
    L9:
        CharSequence r3 = InputMethodUtils.getImeAndSubtypeDisplayName(r4, r2, this.mImm.getCurrentInputMethodSubtype());     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    public InputMethodInfo getCurrentInputMethodInfo() {
        HashMap<String, InputMethodInfo> r1 = this.mMethodMap;
        monitor-enter(r1);
        String r2 = this.mSettings.getSelectedInputMethod();     // Catch: Throwable -> L7
        OLog.d(TAG, "getCurrentInputMethodInfo key is :" + r2);     // Catch: Throwable -> L7
        InputMethodInfo r5 = this.mMethodMap.get(r2);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAlwaysCheckedIme(InputMethodInfo r5, Context r6) {
        if (r5.getId().equals("com.android.inputmethod.latin/.LatinIME") == false) goto L6;
        return true;
    L6:
        if (r5.getId().equals("com.bytedance.android.doubaoime/.ImeService") == false) goto L8;
        return true;
    L8:
        boolean r0 = isEnabledImi(r5);
        HashMap<String, InputMethodInfo> r2 = this.mMethodMap;
        monitor-enter(r2);
    L27:
        th = move-exception;
        throw th;
    L11:
        if (this.mSettings.getEnabledInputMethodListLocked().size() > 1) goto L15;
        if (r0 == false) goto L15;
        monitor-exit(r2);     // Catch: Throwable -> L27
        return true;
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L27
        int r3 = getEnabledValidSystemNonAuxAsciiCapableImeCount(r6);
        if (r3 <= 1) goto L19;
        return false;
    L19:
        if (r3 != 1) goto L23;
        if (r0 == true) goto L23;
        return false;
    L23:
        if (InputMethodUtils.isSystemIme(r5) == true) goto L26;
        return false;
    L26:
        return isValidSystemNonAuxAsciiCapableIme(r5, r6);
    }

    private int getEnabledValidSystemNonAuxAsciiCapableImeCount(Context r4) {
        HashMap<String, InputMethodInfo> r0 = this.mMethodMap;
        monitor-enter(r0);
        ArrayList<InputMethodInfo> r1 = this.mSettings.getEnabledInputMethodListLocked();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Iterator<InputMethodInfo> r2 = r1.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L12;
        if (isValidSystemNonAuxAsciiCapableIme(r2.next(), r4) == false) goto L8;
        r3 = r3 + 1;
        goto L8
    L12:
        if (r3 != 0) goto L14;
        OLog.w(TAG, "No \"enabledValidSystemNonAuxAsciiCapableIme\"s found.");
    L14:
        return r3;
    L15:
        th = move-exception;
        throw th;
    }

    boolean isEnabledImi(InputMethodInfo r3) {
        HashMap<String, InputMethodInfo> r0 = this.mMethodMap;
        monitor-enter(r0);
        ArrayList<InputMethodInfo> r2 = this.mSettings.getEnabledInputMethodListLocked();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Iterator<InputMethodInfo> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        if (r4.next().getId().equals(r3.getId()) == false) goto L8;
        return true;
    L13:
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    boolean isValidSystemNonAuxAsciiCapableIme(InputMethodInfo r9, Context r10) {
        if (r9.isAuxiliaryIme() == false) goto L6;
        return false;
    L6:
        if (InputMethodUtils.isSystemImeThatHasSubtypeOf(r9, r10, true, r10.getResources().getConfiguration().locale, false, InputMethodUtils.SUBTYPE_MODE_ANY) == false) goto L10;
        return true;
    L10:
        if (this.mAsciiCapableEnabledImis.isEmpty() == false) goto L14;
        OLog.w(TAG, "ascii capable subtype enabled imi not found. Fall back to English Keyboard subtype.");
        return InputMethodUtils.containsSubtypeOf(r9, Locale.ENGLISH, false, "keyboard");
    L14:
        return this.mAsciiCapableEnabledImis.contains(r9);
    }
}
