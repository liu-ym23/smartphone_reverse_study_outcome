package com.bytedance.frameworks.baselib.network.http.cronet.e;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4750a;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f4751f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f4752g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f4753h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f4754i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f4755j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f4756k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f4757l = null;
        public static final a m = null;
        private static final /* synthetic */ a[] n = null;

        static {
            a r0 = new a("SUCCESS", 0);
            f4751f = r0;
            a r1 = new a("INVALID_ORIGIN_URL", 1);
            f4752g = r1;
            a r3 = new a("CRONET_NOT_INIT", 2);
            f4753h = r3;
            a r5 = new a("TIMEOUT", 3);
            f4754i = r5;
            a r7 = new a("INVALID_FINAL_URL", 4);
            f4755j = r7;
            a r9 = new a("WRONG_FORMAT", 5);
            f4756k = r9;
            a r11 = new a("OKHTTP_DISPATCH_FAILED", 6);
            f4757l = r11;
            a r13 = new a("NOT_REACHED", 7);
            m = r13;
            n = new a[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) n.clone();
        }
    }

    static {
    }

    public l(String r1, a r2) {
        this.f4750a = r1;
    }

    public l(String r1, String r2, String r3, String r4, a r5, String r6) {
        this.f4750a = r2;
        TextUtils.isEmpty(r3);
        TextUtils.isEmpty(r4);
        TextUtils.isEmpty(r6);
    }

    public String a() {
        return this.f4750a;
    }
}
