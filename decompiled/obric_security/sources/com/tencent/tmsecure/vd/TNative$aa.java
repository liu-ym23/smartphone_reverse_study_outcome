package com.tencent.tmsecure.vd;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.SparseArray;
import java.lang.reflect.InvocationHandler;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class TNative$aa {

    public static class bb implements ServiceConnection {
        public bb() {
        }

        @Override // android.content.ServiceConnection
        public native void onServiceConnected(ComponentName r1, IBinder r2);

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }
    }

    public TNative$aa() {
    }

    public static native SparseArray<Object> a90_A43184BF099FF466(SparseArray<Object> r0, Context r1, Map<String, String> r2, Map<Integer, String> r3, int r4);

    public static native SparseArray<Object> b90_A43184BF099FF466(SparseArray<Object> r0, byte[] r1, Map<String, String> r2, int r3);

    public static native SparseArray<Object> c90_A43184BF099FF466(SparseArray<Object> r0, Context r1);

    public static native SparseArray<Object> d90_A43184BF099FF466(SparseArray<Object> r0, Context r1, int r2);

    public static native SparseArray<Object> e90_A43184BF099FF466(SparseArray<Object> r0, Context r1, Map<String, String> r2, int r3);

    public static native SparseArray<Object> f90_A43184BF099FF466(SparseArray<Object> r0, byte[] r1, int r2);

    public static native SparseArray<Object> g90_A43184BF099FF466(SparseArray<Object> r0, Context r1, Map<String, String> r2, int r3);

    public static native SparseArray<Object> h90_A43184BF099FF466(SparseArray<Object> r0, Context r1, Map<String, String> r2, int r3);

    public static native SparseArray<Object> i90_A43184BF099FF466(SparseArray<Object> r0, Context r1, Map<String, String> r2, Object r3, Object r4, Object r5);

    public static native String j90_A43184BF099FF466();

    public static native byte[] k90_A43184BF099FF466(byte[] r0);

    public static native void l90_A43184BF099FF466(InvocationHandler r0, AtomicReference<Object> r1, ClassLoader r2);

    public static native SparseArray<Object> m90_A43184BF099FF466(SparseArray<Object> r0, Context r1, Map<String, String> r2);
}
