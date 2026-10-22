package com.bytedance.mobsec.metasec.ml;

import ms.bd.c.i0;

/* JADX INFO: loaded from: classes.dex */
public final class b extends i0 {
    private final i0 r;

    public static class a extends i0.a<a> {

        /* JADX INFO: renamed from: com.bytedance.mobsec.metasec.ml.b$a$a, reason: collision with other inner class name */
        public interface InterfaceC0161a {
            String a();
        }

        /* JADX INFO: renamed from: com.bytedance.mobsec.metasec.ml.b$a$b, reason: collision with other inner class name */
        public interface InterfaceC0162b {
            boolean a(String r1);
        }

        public interface c {
            String a();
        }

        public a(String r1, String r2) {
            super(r1, r2);
        }

        public b g() {
            c();
            return new b(this, null);
        }

        public a h(int r1) {
            d(r1);
            return this;
        }

        public a i(String r1) {
            e(r1);
            return this;
        }

        public a j(String r1) {
            f(r1);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.mobsec.metasec.ml.b$b, reason: collision with other inner class name */
    static /* synthetic */ class C0163b {
    }

    private b(i0 r1) {
        this.r = r1;
    }

    /* synthetic */ b(i0 r1, C0163b r2) {
        this(r1);
    }

    i0 c() {
        return this.r;
    }
}
