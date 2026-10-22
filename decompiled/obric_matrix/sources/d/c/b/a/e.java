package d.c.b.a;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static String a(d r1) {
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if ((r1 instanceof g) == false) goto L7;
        return c(((g) r1).b().get(0));
    L7:
        return c(r1);
    }

    public static List<String> b(d r3) {
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if ((r3 instanceof g) == false) goto L8;
        List<d> r4 = ((g) r3).b();     // Catch: UnsupportedEncodingException -> L10
        ArrayList r0 = new ArrayList(r4.size());     // Catch: UnsupportedEncodingException -> L10
        int r1 = 0;
    L6:
        if (r1 >= r4.size()) goto L15;
        r0.add(c(r4.get(r1)));     // Catch: UnsupportedEncodingException -> L10
        r1 = r1 + 1;     // Catch: UnsupportedEncodingException -> L10
        goto L6
    L15:
        return r0;
    L8:
        ArrayList r2 = new ArrayList(1);     // Catch: UnsupportedEncodingException -> L10
        r2.add(c(r3));     // Catch: UnsupportedEncodingException -> L10
        return r2;
    }

    private static String c(d r1) {
        return d.c.c.k.c.a(r1.a().getBytes("UTF-8"));
    }
}
