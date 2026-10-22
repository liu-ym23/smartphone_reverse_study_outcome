package kotlin.s0.w.d.l0.j;

import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static final String a(kotlin.s0.w.d.l0.g.d r1) {
        o.f(r1, "<this>");
        List<kotlin.s0.w.d.l0.g.f> r2 = r1.h();
        o.e(r2, "pathSegments()");
        return c(r2);
    }

    public static final String b(kotlin.s0.w.d.l0.g.f r3) {
        o.f(r3, "<this>");
        if (d(r3) == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        String r4 = r3.b();
        o.e(r4, "asString()");
        r0.append('`' + r4);
        r0.append('`');
        return r0.toString();
    L5:
        String r5 = r3.b();
        o.e(r5, "asString()");
        return r5;
    }

    public static final String c(List<kotlin.s0.w.d.l0.g.f> r3) {
        o.f(r3, "pathSegments");
        StringBuilder r0 = new StringBuilder();
        Iterator<kotlin.s0.w.d.l0.g.f> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        kotlin.s0.w.d.l0.g.f r1 = r4.next();
        if (r0.length() <= 0) goto L8;
        r0.append(".");
    L8:
        r0.append(b(r1));
        goto L4
    L9:
        String r5 = r0.toString();
        o.e(r5, "StringBuilder().apply(builderAction).toString()");
        return r5;
    }

    private static final boolean d(kotlin.s0.w.d.l0.g.f r5) {
        String r6 = r5.b();
        o.e(r6, "asString()");
        if (i.f20490a.contains(r6) == true) goto L19;
        int r0 = 0;
    L6:
        if (r0 >= r6.length()) goto L16;
        char r3 = r6.charAt(r0);
        if (Character.isLetterOrDigit(r3) == false) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L14;
        r0 = r0 + 1;
        goto L6
    L14:
        boolean r7 = true;
    L17:
        if (r7 == true) goto L19;
        return false;
    L10:
        if (r3 == '_') goto L12;
        r4 = true;
        goto L13
    L16:
        r7 = false;
    L19:
        return true;
    }
}
