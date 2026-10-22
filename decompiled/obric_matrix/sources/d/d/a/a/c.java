package d.d.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static l.a.b.c f16537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static i f16538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static List<h> f16539c;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        i f16540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<h> f16541b;

        private b(List<h> r2) {
            if (r2 == null) goto L5;
            this.f16541b = new ArrayList(r2);
        L5:
            this.f16540a = new d.d.a.a.b();
        }

        /* synthetic */ b(List r1, a r2) {
            this(r1);
        }

        List<h> a() {
            return this.f16541b;
        }

        i b() {
            return this.f16540a;
        }

        boolean c() {
            if (a() != null) goto L5;
        L7:
            return false;
        L5:
            if (b() == null) goto L7;
            return true;
        }
    }

    static {
    }

    private static short a(byte[] r2, byte[] r3, int r4) {
        int r1 = r4 % 8;
        short r5 = (short) (r3[r4] & 255);
        if ((r2[r4 / 8] & g.f16548a[r1]) != 0) goto L5;
        return r5;
    L5:
        return (short) (r5 | 256);
    }

    private static int b(char r3) {
        int r4 = r3 - 19968;
        if (r4 < 0) goto L8;
        if (r4 >= 7000) goto L8;
        return a(d.f16542a, d.f16543b, r4);
    L8:
        if (7000 > r4) goto L13;
        if (r4 >= 14000) goto L13;
        return a(e.f16544a, e.f16545b, r4 - 7000);
    L13:
        return a(f.f16546a, f.f16547b, r4 - 14000);
    }

    public static void c(b r1) {
        if (r1 != null) goto L7;
        i r2 = null;
        f16539c = null;
        f16537a = null;
    L4:
        f16538b = r2;
        return;
    L7:
        if (r1.c() == true) goto L9;
        return;
    L9:
        f16539c = Collections.unmodifiableList(r1.a());
        f16537a = j.a(r1.a());
        r2 = r1.b();
        goto L4
    }

    public static boolean d(char r1) {
        if (19968 > r1) goto L9;
        if (r1 > 40869) goto L9;
        if (b(r1) <= 0) goto L9;
    L10:
        return true;
    L9:
        if (12295 == r1) goto L10;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b e() {
        return new b(null, 0 == true ? 1 : 0);
    }

    public static String f(char r1) {
        if (d(r1) == false) goto L11;
        if (r1 != 12295) goto L9;
        return "LING";
    L9:
        return g.f16549b[b(r1)];
    L11:
        return String.valueOf(r1);
    }

    public static String g(String r3, String r4) {
        return d.d.a.a.a.b(r3, f16537a, f16539c, r4, f16538b);
    }
}
