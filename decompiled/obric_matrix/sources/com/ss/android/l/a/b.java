package com.ss.android.l.a;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11994a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f11995b;

    static class a implements g {
        a() {
        }

        @Override // com.ss.android.l.a.g
        public void d(String r1, String r2, Throwable r3) {
            if (r3 != null) goto L4;
            Log.d(r1, r2);
            return;
        L4:
            Log.d(r1, r2, r3);
        }
    }

    static {
        f11995b = new a();
    }

    public static void a(String r2, String r3) {
        f11995b.d(r2, r3, null);
    }
}
