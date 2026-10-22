package d.b.s.a.a0.d;

import java.util.Iterator;
import kotlin.i0.j0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final /* synthetic */ String a(long r0) {
        return b(r0);
    }

    private static final String b(long r4) {
        String r5 = String.valueOf(r4);
        StringBuilder r6 = new StringBuilder();
        int r1 = 0;
        Iterator<Integer> r0 = kotlin.r0.e.j(r5.length() - 1, 0).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        int r2 = ((j0) r0).nextInt();
        if (r1 == 0) goto L10;
        if ((r1 % 3) != 0) goto L10;
        r6.append(',');
    L10:
        r6.append(r5.charAt(r2));
        r1 = r1 + 1;
        goto L4
    L11:
        String r7 = r6.reverse().toString();
        o.b(r7, "sb.reverse().toString()");
        return r7;
    }
}
