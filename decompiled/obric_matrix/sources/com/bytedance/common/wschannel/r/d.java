package com.bytedance.common.wschannel.r;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f3670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f3674e;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f3675g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f3676h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f3677i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f3678j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ a[] f3679k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f3680f;

        static {
            a r0 = new a("Default", 0, 0);
            f3675g = r0;
            a r1 = new a("TimeOut", 1, 1);
            f3676h = r1;
            a r3 = new a("Failed", 2, 2);
            f3677i = r3;
            a r5 = new a("Success", 3, 3);
            f3678j = r5;
            f3679k = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f3680f = r3;
        }

        public static a b(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return f3675g;
        L11:
            return f3678j;
        L13:
            return f3677i;
        L15:
            return f3676h;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f3679k.clone();
        }

        public int a() {
            return this.f3680f;
        }
    }

    public d(String r1, int r2, int r3, int r4, String r5) {
        this.f3670a = a.f3675g;
        this.f3671b = r1;
        this.f3672c = r2;
        this.f3673d = r4;
        this.f3674e = new JSONObject(r5);     // Catch: JSONException -> L5
        return;
    }

    public void a(a r1) {
        this.f3670a = r1;
    }

    public String toString() {
        return "UniqueId:" + this.f3671b + ", ChannelId:" + this.f3672c + ", methodId:" + this.f3673d + ", state:" + this.f3670a + ", logInfo:" + this.f3674e.toString();
    }
}
