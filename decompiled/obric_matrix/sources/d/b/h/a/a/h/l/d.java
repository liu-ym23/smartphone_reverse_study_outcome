package d.b.h.a.a.h.l;

import d.b.h.a.a.h.s.l;
import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f13412l;

    public d(int r2, String r3, String r4, String r5) {
        StringBuilder r6 = new StringBuilder();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r6.append(r3);
        r6.append(" ");
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r6.append(r4);
        super(r6.toString());
        this.f13412l = r2;
    }

    public static String b(String r0) {
        URI r1 = l.l(r0);
        if (r1 != null) goto L5;
        return "";
    L5:
        return r1.getPath();
    }

    public int c() {
        return this.f13412l;
    }
}
