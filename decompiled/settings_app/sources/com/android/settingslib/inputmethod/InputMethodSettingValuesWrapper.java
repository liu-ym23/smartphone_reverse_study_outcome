package com.android.settingslib.inputmethod;

import android.content.ContentResolver;
import android.content.Context;
import android.util.SparseArray;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InputMethodSettingValuesWrapper {
    private static final String TAG = "InputMethodSettingValuesWrapper";
    private static SparseArray<InputMethodSettingValuesWrapper> sInstanceMap;
    private static final Object sInstanceMapLock = null;
    private final ContentResolver mContentResolver;
    private final InputMethodManager mImm;
    private final ArrayList<InputMethodInfo> mMethodList;

    static {
        sInstanceMapLock = new Object();
        sInstanceMap = new SparseArray();
    }

    public static InputMethodSettingValuesWrapper getInstance(Context r3) {
        int r0 = r3.getUserId();
        Object r1 = sInstanceMapLock;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sInstanceMap.size() != 0) goto L10;
        InputMethodSettingValuesWrapper r2 = new InputMethodSettingValuesWrapper(r3);     // Catch: Throwable -> L17
        sInstanceMap.put(r0, r2);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r2;
    L10:
        if (sInstanceMap.indexOfKey(r0) < 0) goto L14;
        InputMethodSettingValuesWrapper r4 = sInstanceMap.get(r0);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r4;
    L14:
        InputMethodSettingValuesWrapper r5 = new InputMethodSettingValuesWrapper(r3);     // Catch: Throwable -> L17
        sInstanceMap.put(r3.getUserId(), r5);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r5;
    }

    private InputMethodSettingValuesWrapper(Context r2) {
        this.mMethodList = new ArrayList();
        this.mContentResolver = r2.getContentResolver();
        this.mImm = (InputMethodManager) r2.getSystemService(InputMethodManager.class);
        refreshAllInputMethodAndSubtypes();
    }

    public void refreshAllInputMethodAndSubtypes() {
        this.mMethodList.clear();
        List r0 = this.mImm.getInputMethodListAsUser(this.mContentResolver.getUserId(), 1);
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L9;
        InputMethodInfo r2 = (InputMethodInfo) r0.get(r1);
        if (r2.isVirtualDeviceOnly() == true) goto L8;
        this.mMethodList.add(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    }

    public List<InputMethodInfo> getInputMethodList() {
        return new ArrayList(this.mMethodList);
    }

    public boolean isAlwaysCheckedIme(InputMethodInfo r4) {
        boolean r0 = isEnabledImi(r4);
        if (getEnabledInputMethodList().size() > 1) goto L6;
        if (r0 == false) goto L6;
        return true;
    L6:
        int r3 = getEnabledValidNonAuxAsciiCapableImeCount();
        if (r3 > 1) goto L15;
        if (r3 != 1) goto L11;
        if (r0 == false) goto L15;
    L11:
        if (r4.isSystem() == false) goto L15;
        if (InputMethodAndSubtypeUtil.isValidNonAuxAsciiCapableIme(r4) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private int getEnabledValidNonAuxAsciiCapableImeCount() {
        Iterator<InputMethodInfo> r2 = getEnabledInputMethodList().iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L8;
        if (InputMethodAndSubtypeUtil.isValidNonAuxAsciiCapableIme(r2.next()) == false) goto L4;
        r0 = r0 + 1;
        goto L4
    L8:
        if (r0 != 0) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "No \"enabledValidNonAuxAsciiCapableIme\"s found.");
    L10:
        return r0;
    }

    public boolean isEnabledImi(InputMethodInfo r3) {
        Iterator<InputMethodInfo> r2 = getEnabledInputMethodList().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r2.next().getId().equals(r3.getId()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private ArrayList<InputMethodInfo> getEnabledInputMethodList() {
        HashMap<String, HashSet<String>> r0 = InputMethodAndSubtypeUtil.getEnabledInputMethodsAndSubtypeList(this.mContentResolver);
        ArrayList<InputMethodInfo> r1 = new ArrayList();
        Iterator<InputMethodInfo> r5 = this.mMethodList.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        InputMethodInfo r2 = r5.next();
        if (r0.keySet().contains(r2.getId()) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        return r1;
    }
}
