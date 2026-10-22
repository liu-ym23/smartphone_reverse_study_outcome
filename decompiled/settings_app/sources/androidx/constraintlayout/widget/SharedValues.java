package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SharedValues {
    public static final int UNSET = -1;
    private SparseIntArray mValues;
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> mValuesListeners;

    public interface SharedValuesListener {
        void onNewValue(int key, int newValue, int oldValue);
    }

    public SharedValues() {
        this.mValues = new SparseIntArray();
        this.mValuesListeners = new HashMap();
    }

    public void addListener(int key, SharedValuesListener listener) {
        HashSet<WeakReference<SharedValuesListener>> r0 = this.mValuesListeners.get(Integer.valueOf(key));
        if (r0 != null) goto L5;
        r0 = new HashSet();
        this.mValuesListeners.put(Integer.valueOf(key), r0);
    L5:
        r0.add(new WeakReference(listener));
    }

    public void removeListener(int key, SharedValuesListener listener) {
        HashSet<WeakReference<SharedValuesListener>> r3 = this.mValuesListeners.get(Integer.valueOf(key));
        if (r3 != null) goto L5;
        return;
    L5:
        ArrayList r4 = new ArrayList();
        Iterator<WeakReference<SharedValuesListener>> r0 = r3.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        WeakReference<SharedValuesListener> r1 = r0.next();
        SharedValuesListener r2 = r1.get();
        if (r2 == null) goto L11;
        if (r2 != listener) goto L7;
    L11:
        r4.add(r1);
        goto L7
    L12:
        r3.removeAll(r4);
    }

    public void removeListener(SharedValuesListener listener) {
        Iterator<Integer> r0 = this.mValuesListeners.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        removeListener(r0.next().intValue(), listener);
        goto L4
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public int getValue(int key) {
        return this.mValues.get(key, -1);
    }

    public void fireNewValue(int key, int value) {
        int r0 = this.mValues.get(key, -1);
        if (r0 != value) goto L5;
        return;
    L5:
        this.mValues.put(key, value);
        HashSet<WeakReference<SharedValuesListener>> r4 = this.mValuesListeners.get(Integer.valueOf(key));
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
        r3.onNewValue(key, value, r0);
        goto L10
    L15:
        if (r2 == false) goto L35;
        ArrayList r5 = new ArrayList();
        Iterator<WeakReference<SharedValuesListener>> r6 = r4.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        WeakReference<SharedValuesListener> r7 = r6.next();
        if (r7.get() != null) goto L18;
        r5.add(r7);
        goto L18
    L22:
        r4.removeAll(r5);
        return;
    }
}
