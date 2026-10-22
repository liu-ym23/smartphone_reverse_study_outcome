package com.bytedanceos.clearmemory;

import android.app.ActivityManagerNative;
import android.content.Context;
import android.provider.Settings;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InputMethodSettingValuesWrapper {
    private static final String TAG = "InputMethodSettingValuesWrapper";
    private static volatile InputMethodSettingValuesWrapper sInstance;
    private Context mContext;
    private final InputMethodManager mImm;
    private final ArrayList<InputMethodInfo> mMethodList;
    private final HashMap<String, InputMethodInfo> mMethodMap;

    static {
    }

    public static InputMethodSettingValuesWrapper getInstance(Context context) {
        if (sInstance != null) goto L15;
        String r0 = TAG;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new InputMethodSettingValuesWrapper(context.getApplicationContext());     // Catch: Throwable -> L11
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

    private InputMethodSettingValuesWrapper(Context context) {
        this.mMethodList = new ArrayList();
        this.mMethodMap = new HashMap();
        this.mContext = context.getApplicationContext();
        InputMethodManager r2 = (InputMethodManager) context.getSystemService("input_method");
        this.mImm = r2;
        if (r2 == null) goto L6;
        refreshAllInputMethodAndSubtypes();
        return;
    }

    void refreshAllInputMethodAndSubtypes() {
        HashMap<String, InputMethodInfo> r0 = this.mMethodMap;
        monitor-enter(r0);
        this.mMethodList.clear();     // Catch: Throwable -> L10
        this.mMethodMap.clear();     // Catch: Throwable -> L10
        List<InputMethodInfo> r1 = this.mImm.getInputMethodList();     // Catch: Throwable -> L10
        this.mMethodList.addAll(r1);     // Catch: Throwable -> L10
        Iterator<InputMethodInfo> r2 = r1.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        InputMethodInfo r3 = r2.next();     // Catch: Throwable -> L10
        this.mMethodMap.put(r3.getId(), r3);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public InputMethodInfo getCurrentInputMethodInfo() {
        HashMap<String, InputMethodInfo> r0 = this.mMethodMap;
        monitor-enter(r0);
        String r1 = Settings.Secure.getString(this.mContext.getContentResolver(), "default_input_method");     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        InputMethodInfo r3 = this.mMethodMap.get(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }
}
