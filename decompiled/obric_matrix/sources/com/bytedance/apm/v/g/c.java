package com.bytedance.apm.v.g;

import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2114a = false;

    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable r1) {
            Thread r0 = new Thread(r1);
            r0.setName("launch_sleep_detector");
            return r0;
        }
    }

    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f2115f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f2116g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f2117h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f2118i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ b[] f2119j = null;

        static {
            b r0 = new b("NONE", 0);
            f2115f = r0;
            b r1 = new b("SLEEP", 1);
            f2116g = r1;
            b r3 = new b("NOT_SLEEP", 2);
            f2117h = r3;
            b r5 = new b("DISK_SLEEP", 3);
            f2118i = r5;
            f2119j = new b[]{r0, r1, r3, r5};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f2119j.clone();
        }
    }

    static {
        b r0 = b.f2115f;
        Executors.newSingleThreadExecutor(new a());
    }

    public static void a() {
        if (f2114a == true) goto L5;
        return;
    L5:
        f2114a = false;
        b r0 = b.f2115f;
    }
}
