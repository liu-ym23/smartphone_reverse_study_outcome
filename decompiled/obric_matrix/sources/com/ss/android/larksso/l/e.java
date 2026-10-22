package com.ss.android.larksso.l;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<b> f12077f;

    public static class a implements Serializable {

        /* JADX INFO: renamed from: com.ss.android.larksso.l.e$a$a, reason: collision with other inner class name */
        public static class C0315a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f12078a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f12079b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private String f12080c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private String f12081d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private String f12082e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private String f12083f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private String f12084g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private String f12085h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private String f12086i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f12087j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private String f12088k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private String f12089l;
            private boolean m;
            private String n;
            private String o;
            private String p;

            public C0315a() {
                this.f12087j = false;
            }

            public String a() {
                StringBuilder r0 = new StringBuilder(256);
                r0.append(this.f12078a);
                r0.append(": ");
                r0.append(this.f12079b);
                if (this.f12080c == null) goto L6;
                r0.append(" c_point=");
                r0.append(this.f12080c);
            L6:
                if (this.f12081d == null) goto L9;
                r0.append(" cp_id=");
                r0.append(this.f12081d);
            L9:
                if (this.f12082e == null) goto L12;
                r0.append(" rid=");
                r0.append(this.f12082e);
            L12:
                if (this.f12084g == null) goto L15;
                r0.append(" env=");
                r0.append(this.f12084g);
            L15:
                if (this.f12085h == null) goto L18;
                r0.append(" unit=");
                r0.append(this.f12085h);
            L18:
                if (this.f12086i == null) goto L20;
                r0.append(" brand=");
                r0.append(this.f12086i);
            L20:
                r0.append(" redirect=");
                r0.append(this.f12087j);
                if (this.f12088k == null) goto L24;
                r0.append(" network=");
                r0.append(this.f12088k);
            L24:
                if (this.f12089l == null) goto L27;
                r0.append(" aos_process_port=");
                r0.append(this.f12089l);
            L27:
                if (this.m == false) goto L30;
                r0.append(" h5_log=true");
            L30:
                if (this.f12083f == null) goto L33;
                r0.append(" trace_id=");
                r0.append(this.f12083f);
            L33:
                if (this.n == null) goto L36;
                r0.append(" install_id=");
                r0.append(this.n);
            L36:
                if (this.o == null) goto L39;
                r0.append(" app_type=");
                r0.append(this.o);
            L39:
                if (this.p == null) goto L42;
                r0.append(" app_env=");
                r0.append(this.p);
            L42:
                return r0.toString();
            }

            public C0315a b(String r1) {
                this.f12089l = r1;
                return this;
            }

            public C0315a c(String r1) {
                this.p = r1;
                return this;
            }

            public C0315a d(String r1) {
                this.o = r1;
                return this;
            }

            public C0315a e(String r1) {
                this.f12079b = r1;
                return this;
            }

            public C0315a f(String r1) {
                this.f12084g = r1;
                return this;
            }

            public C0315a g(boolean r1) {
                this.m = r1;
                return this;
            }

            public C0315a h(String r1) {
                this.f12088k = r1;
                return this;
            }

            public C0315a i(String r1) {
                this.f12082e = r1;
                return this;
            }

            public C0315a j(long r1) {
                this.f12078a = r1;
                return this;
            }
        }

        public a() {
        }

        public static C0315a a() {
            return new C0315a();
        }
    }

    public static class b implements Serializable {
        public b() {
        }
    }

    public static class c implements Serializable {
        public c() {
        }
    }

    public e() {
    }
}
