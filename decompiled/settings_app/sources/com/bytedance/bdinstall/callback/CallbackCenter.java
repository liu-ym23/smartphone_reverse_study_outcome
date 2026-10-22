package com.bytedance.bdinstall.callback;

import android.os.Looper;
import com.bytedance.bdinstall.ExecutorUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CallbackCenter {
    public static final ConcurrentHashMap<CallbackWrapper, Object> CALLBACK_WRAPPERS = null;
    private static final ConcurrentHashMap<Type, ValueHolder> OBSERVERS_MAP = null;
    private static final Object VALUE = null;
    private static final Object sLock = null;

    private static class ValueHolder {
        ConcurrentHashMap<Callback, Object> callbacks;
        Object value;

        private ValueHolder() {
            this.callbacks = new ConcurrentHashMap();
        }

        /* synthetic */ ValueHolder(AnonymousClass1 r1) {
            this();
        }

        void remove(Callback r1) {
            this.callbacks.remove(r1);
        }

        public boolean isEmpty() {
            return this.callbacks.isEmpty();
        }

        Set<Callback> keySet() {
            return this.callbacks.keySet();
        }

        public void put(Callback r1, Object r2) {
            this.callbacks.put(r1, r2);
        }
    }

    public CallbackCenter() {
    }

    static {
        sLock = new Object();
        VALUE = new Object();
        OBSERVERS_MAP = new ConcurrentHashMap();
        CALLBACK_WRAPPERS = new ConcurrentHashMap();
    }

    public static <EVENT> void register(Callback<EVENT> r1) {
        register(false, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <EVENT> void register(boolean r5, Callback<EVENT> r6) {
        if (r6 != 0) goto L4;
        return;
    L4:
        Type r0 = ((ParameterizedType) r6.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        Object r1 = sLock;
        monitor-enter(r1);
        ConcurrentHashMap<Type, ValueHolder> r2 = OBSERVERS_MAP;     // Catch: Throwable -> L18
        ValueHolder r3 = r2.get(r0);     // Catch: Throwable -> L18
        if (r3 != null) goto L9;
        r3 = new ValueHolder(null);     // Catch: Throwable -> L18
        r2.put(r0, r3);     // Catch: Throwable -> L18
    L9:
        Object r4 = VALUE;     // Catch: Throwable -> L18
        r3.put(r6, r4);     // Catch: Throwable -> L18
        if ((r6 instanceof CallbackWrapper) == false) goto L12;
        CALLBACK_WRAPPERS.put((CallbackWrapper) r6, r4);     // Catch: Throwable -> L18
    L12:
        if (r5 == true) goto L14;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L14:
        if (r3.value == null) goto L16;
        callbackWhenRegister(r6, r3, r3.value);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private static <EVENT> void callbackWhenRegister(final Callback<EVENT> r1, final ValueHolder r2, final Object r3) {
        ExecutorUtil.runOnHandlerThread(new AnonymousClass1(r2, r1, r3));
    }

    public static <EVENT> void unregister(Callback<EVENT> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Type r0 = ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        Object r1 = sLock;
        monitor-enter(r1);
        ValueHolder r2 = OBSERVERS_MAP.get(r0);     // Catch: Throwable -> L11
        if (r2 == null) goto L9;
        r2.remove(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void unregister(Object r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Object r0 = sLock;
        monitor-enter(r0);
        Iterator<CallbackWrapper> r1 = CALLBACK_WRAPPERS.keySet().iterator();     // Catch: Throwable -> L17
    L8:
        if (r1.hasNext() == false) goto L12;
        CallbackWrapper r2 = r1.next();     // Catch: Throwable -> L17
        if (r2.getListener() != r4) goto L8;
    L13:
        if (r2 == null) goto L15;
        unregister(r2);     // Catch: Throwable -> L17
        CALLBACK_WRAPPERS.remove(r2);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L12:
        r2 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public static <Event> void postEvent(final Event r4) {
        if (Looper.myLooper() == ExecutorUtil.getLooper()) goto L6;
        ExecutorUtil.runOnHandlerThread(new AnonymousClass2(r4));
        return;
    L6:
        Object r0 = sLock;
        monitor-enter(r0);
        ConcurrentHashMap<Type, ValueHolder> r1 = OBSERVERS_MAP;     // Catch: Throwable -> L19
        ValueHolder r2 = r1.get(r4.getClass());     // Catch: Throwable -> L19
        if (r2 != null) goto L11;
        r2 = new ValueHolder(null);     // Catch: Throwable -> L19
        r1.put(r4.getClass(), r2);     // Catch: Throwable -> L19
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L19
        r2.value = r4;
        Iterator<Callback> r3 = r2.keySet().iterator();
    L14:
        if (r3.hasNext() == false) goto L18;
        Callback r5 = r3.next();
        if (r5 == null) goto L14;
        r5.onCall(r4);
        goto L14
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
