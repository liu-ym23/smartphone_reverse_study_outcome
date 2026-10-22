package tmsdkobf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class l4 implements k5 {
    public static final Locale[] b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale[] f323a;

    static {
        b = new Locale[0];
    }

    public l4(Locale... r8) {
        if (r8.length != 0) goto L5;
        this.f323a = b;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        StringBuilder r2 = new StringBuilder();
        int r4 = 0;
    L7:
        if (r4 >= r8.length) goto L19;
        Locale r5 = r8[r4];
        if (r5 == null) goto L18;
        if (r1.contains(r5) == true) goto L16;
        Locale r6 = (Locale) r5.clone();
        r0.add(r6);
        a(r2, r6);
        if (r4 >= (r8.length - 1)) goto L15;
        r2.append(',');
    L15:
        r1.add(r6);
    L16:
        r4 = r4 + 1;
        goto L7
    L18:
        throw new NullPointerException("list[" + r4 + "] is null");
    L19:
        this.f323a = (Locale[]) r0.toArray(new Locale[0]);
    }

    @Override // tmsdkobf.k5
    public Locale a(int r2) {
        if (r2 < 0) goto L6;
        Locale[] r1 = this.f323a;
        if (r2 >= r1.length) goto L6;
        return r1[r2];
    L6:
        return null;
    }

    @Override // tmsdkobf.k5
    public int a() {
        return this.f323a.length;
    }

    public static void a(StringBuilder r1, Locale r2) {
        r1.append(r2.getLanguage());
        String r0 = r2.getCountry();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L9;
        r1.append('-');
        r1.append(r2.getCountry());
        return;
    }
}
