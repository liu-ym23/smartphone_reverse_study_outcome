package d.c.c.d;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f15380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a f15381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f15382d;

        private static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f15383a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f15384b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            a f15385c;

            private a() {
            }

            /* synthetic */ a(a r1) {
                this();
            }
        }

        private b(String r3) {
            a r0 = new a(null);
            this.f15380b = r0;
            this.f15381c = r0;
            this.f15382d = false;
            i.g(r3);
            this.f15379a = r3;
        }

        /* synthetic */ b(String r1, a r2) {
            this(r1);
        }

        private a d() {
            a r0 = new a(null);
            this.f15381c.f15385c = r0;
            this.f15381c = r0;
            return r0;
        }

        private b e(String r2, Object r3) {
            a r0 = d();
            r0.f15384b = r3;
            i.g(r2);
            r0.f15383a = r2;
            return this;
        }

        public b a(String r1, int r2) {
            e(r1, String.valueOf(r2));
            return this;
        }

        public b b(String r1, Object r2) {
            e(r1, r2);
            return this;
        }

        public b c(String r1, boolean r2) {
            e(r1, String.valueOf(r2));
            return this;
        }

        public String toString() {
            boolean r0 = this.f15382d;
            StringBuilder r1 = new StringBuilder(32);
            r1.append(this.f15379a);
            r1.append('{');
            a r4 = this.f15380b.f15385c;
            String r2 = "";
        L3:
            if (r4 == null) goto L12;
            if (r0 == true) goto L6;
        L7:
            r1.append(r2);
            String r3 = r4.f15383a;
            if (r3 == null) goto L10;
            r1.append(r3);
            r1.append('=');
        L10:
            r1.append(r4.f15384b);
            r2 = ", ";
        L11:
            r4 = r4.f15385c;
            goto L3
        L6:
            if (r4.f15384b == null) goto L11;
        L12:
            r1.append('}');
            return r1.toString();
        }
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static int b(Object... r0) {
        return Arrays.hashCode(r0);
    }

    private static String c(Class<?> r2) {
        String r3 = r2.getName().replaceAll("\\$[0-9]+", "\\$");
        int r0 = r3.lastIndexOf(36);
        if (r0 != (-1)) goto L6;
        r0 = r3.lastIndexOf(46);
    L6:
        return r3.substring(r0 + 1);
    }

    public static b d(Object r2) {
        return new b(c(r2.getClass()), null);
    }
}
