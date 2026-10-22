package com.bytedance.sysoptimizer;

import android.content.Context;
import android.view.LayoutInflater;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LayoutInflaterAsyncCrashOptimizer {
    private static boolean hasFixed;

    public static final class FixLayoutInflaterAsyncHashMap<K, V> extends HashMap<K, V> {
        public FixLayoutInflaterAsyncHashMap() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public synchronized V put(K r1, V r2) {
            monitor-enter(this);
            V r3 = (V) super.put(r1, r2);
            monitor-exit(this);
            return r3;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public synchronized V remove(Object r1) {
            monitor-enter(this);
            V r2 = (V) super.remove(r1);
            monitor-exit(this);
            return r2;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public synchronized void clear() {
            monitor-enter(this);
            super.clear();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public LayoutInflaterAsyncCrashOptimizer() {
    }

    public static synchronized void fix(Context r3) {
        monitor-enter(LayoutInflaterAsyncCrashOptimizer.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (hasFixed == false) goto L9;
        monitor-exit(LayoutInflaterAsyncCrashOptimizer.class);
        return;
    L9:
        hasFixed = true;     // Catch: Throwable -> L16
        Field r1 = LayoutInflater.class.getDeclaredField("sConstructorMap");     // Catch: Exception -> L12 Throwable -> L16
        r1.setAccessible(true);     // Catch: Exception -> L12 Throwable -> L16
        r1.set(null, new FixLayoutInflaterAsyncHashMap());     // Catch: Exception -> L12 Throwable -> L16
    L14:
        monitor-exit(LayoutInflaterAsyncCrashOptimizer.class);
        return;
    L12:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "LayoutInflaterAsyncCrash reflect");     // Catch: Throwable -> L16
        goto L14
    }
}
