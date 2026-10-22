package com.bytedance.android.sdk.bdticketguard.n1;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.i0.m0;

/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f875a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c[] f876a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Map<Integer, c> f877b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ a f878c = null;

        static {
            f878c = new a();
            int r2 = 0;
            c[] r0 = {d.f880b, g.f882b, b.f879b, e.f881b};
            f876a = r0;
            LinkedHashMap r3 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r0.length), 16));
            int r1 = r0.length;
        L3:
            if (r2 >= r1) goto L5;
            c r4 = r0[r2];
            r3.put(Integer.valueOf(r4.a()), r4);
            r2 = r2 + 1;
            goto L3
        L5:
            f877b = r3;
        }

        private a() {
        }

        public final c a(int r1) {
            return f877b.get(Integer.valueOf(r1));
        }

        public final f b(boolean r1) {
            if (r1 == false) goto L5;
            return g.f882b;
        L5:
            return b.f879b;
        }
    }

    public static final class b implements InterfaceC0031c, f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f879b = null;

        static {
            f879b = new b();
        }

        private b() {
        }

        @Override // com.bytedance.android.sdk.bdticketguard.n1.c
        public int a() {
            return -1;
        }

        public String toString() {
            return "FAILED";
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.n1.c$c, reason: collision with other inner class name */
    public interface InterfaceC0031c extends c {
    }

    public static final class d implements InterfaceC0031c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f880b = null;

        static {
            f880b = new d();
        }

        private d() {
        }

        @Override // com.bytedance.android.sdk.bdticketguard.n1.c
        public int a() {
            return 0;
        }

        public String toString() {
            return "NOT_STARTED";
        }
    }

    public static final class e implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f881b = null;

        static {
            f881b = new e();
        }

        private e() {
        }

        @Override // com.bytedance.android.sdk.bdticketguard.n1.c
        public int a() {
            return 2;
        }

        public String toString() {
            return "REQUEST_CERT";
        }
    }

    public interface f extends c {
    }

    public static final class g implements f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f882b = null;

        static {
            f882b = new g();
        }

        private g() {
        }

        @Override // com.bytedance.android.sdk.bdticketguard.n1.c
        public int a() {
            return 1;
        }

        public String toString() {
            return "SUCCESS";
        }
    }

    static {
        f875a = a.f878c;
    }

    int a();
}
