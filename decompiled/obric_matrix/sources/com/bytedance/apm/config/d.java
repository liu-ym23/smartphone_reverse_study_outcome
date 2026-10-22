package com.bytedance.apm.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f1428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f1429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f1430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1431f;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private JSONObject f1434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONObject f1435d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private JSONObject f1436e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1437f;

        private b() {
        }

        /* synthetic */ b(a r1) {
            this();
        }

        static /* synthetic */ String a(b r0) {
            return r0.f1432a;
        }

        static /* synthetic */ int b(b r0) {
            return r0.f1433b;
        }

        static /* synthetic */ JSONObject c(b r0) {
            return r0.f1434c;
        }

        static /* synthetic */ JSONObject d(b r0) {
            return r0.f1435d;
        }

        static /* synthetic */ JSONObject e(b r0) {
            return r0.f1436e;
        }

        static /* synthetic */ boolean f(b r0) {
            return r0.f1437f;
        }

        public d g() {
            return new d(this);
        }

        public b h(boolean r1) {
            this.f1437f = r1;
            return this;
        }

        public b i(JSONObject r1) {
            this.f1434c = r1;
            return this;
        }

        public b j(JSONObject r1) {
            this.f1436e = r1;
            return this;
        }

        public b k(JSONObject r1) {
            this.f1435d = r1;
            return this;
        }

        public b l(String r1) {
            this.f1432a = r1;
            return this;
        }

        public b m(int r1) {
            this.f1433b = r1;
            return this;
        }
    }

    public d(b r2) {
        this.f1426a = b.a(r2);
        this.f1427b = b.b(r2);
        this.f1428c = b.c(r2);
        this.f1429d = b.d(r2);
        this.f1430e = b.e(r2);
        this.f1431f = b.f(r2);
    }

    public static b a() {
        return new b(null);
    }

    public JSONObject b() {
        return this.f1428c;
    }

    public JSONObject c() {
        return this.f1430e;
    }

    public JSONObject d() {
        return this.f1429d;
    }

    public String e() {
        return this.f1426a;
    }

    public int f() {
        return this.f1427b;
    }

    public boolean g() {
        return this.f1431f;
    }
}
