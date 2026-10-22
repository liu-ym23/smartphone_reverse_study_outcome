package com.obric.oui.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class SharedValues {
    public static final int UNSET = -1;
    private SparseIntArray mValues;
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> mValuesListeners;

    public interface SharedValuesListener {
        void onNewValue(int r1, int r2, int r3);
    }

    public SharedValues() {
        this.mValues = new SparseIntArray();
        this.mValuesListeners = new HashMap();
    }

    public void addListener(int r3, SharedValuesListener r4) {
        HashSet<WeakReference<SharedValuesListener>> r0 = this.mValuesListeners.get(Integer.valueOf(r3));
        if (r0 != null) goto L5;
        r0 = new HashSet();
        this.mValuesListeners.put(Integer.valueOf(r3), r0);
    L5:
        r0.add(new WeakReference(r4));
    }

    public void removeListener(int r4, SharedValuesListener r5) {
        HashSet<WeakReference<SharedValuesListener>> r3 = this.mValuesListeners.get(Integer.valueOf(r4));
        if (r3 != null) goto L5;
        return;
    L5:
        ArrayList r6 = new ArrayList();
        Iterator<WeakReference<SharedValuesListener>> r0 = r3.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        WeakReference<SharedValuesListener> r1 = r0.next();
        SharedValuesListener r2 = r1.get();
        if (r2 == null) goto L11;
        if (r2 != r5) goto L7;
    L11:
        r6.add(r1);
        goto L7
    L12:
        r3.removeAll(r6);
    }

    public void removeListener(SharedValuesListener r3) {
        Iterator<Integer> r0 = this.mValuesListeners.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        removeListener(r0.next().intValue(), r3);
        goto L4
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public int getValue(int r2) {
        return this.mValues.get(r2, -1);
    }

    public void fireNewValue(int r5, int r6) {
        int r0 = this.mValues.get(r5, -1);
        if (r0 != r6) goto L5;
        return;
    L5:
        this.mValues.put(r5, r6);
        HashSet<WeakReference<SharedValuesListener>> r4 = this.mValuesListeners.get(Integer.valueOf(r5));
        if (r4 != null) goto L8;
        return;
    L8:
        Iterator<WeakReference<SharedValuesListener>> r1 = r4.iterator();
        boolean r2 = false;
    L10:
        if (r1.hasNext() == false) goto L15;
        SharedValuesListener r3 = r1.next().get();
        if (r3 != null) goto L13;
        r2 = true;
        goto L10
    L13:
        r3.onNewValue(r5, r6, r0);
        goto L10
    L15:
        if (r2 == false) goto L35;
        ArrayList r7 = new ArrayList();
        Iterator<WeakReference<SharedValuesListener>> r8 = r4.iterator();
    L18:
        if (r8.hasNext() == false) goto L22;
        WeakReference<SharedValuesListener> r9 = r8.next();
        if (r9.get() != null) goto L18;
        r7.add(r9);
        goto L18
    L22:
        r4.removeAll(r7);
        return;
    }
}
