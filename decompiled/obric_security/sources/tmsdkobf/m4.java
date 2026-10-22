package tmsdkobf;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class m4 {
    public static final m4 b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k5 f345a;

    static {
        b = a(new Locale[0]);
    }

    public m4(k5 r1) {
        this.f345a = r1;
    }

    public static m4 a(Locale... r2) {
        return new m4(new n5(new LocaleList(r2)));
    }

    public static m4 a(String r4) {
        if (r4 == null) goto L12;
        if (r4.isEmpty() == true) goto L12;
        String[] r5 = r4.split(",", -1);
        int r0 = r5.length;
        Locale[] r1 = new Locale[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L10;
        r1[r2] = Locale.forLanguageTag(r5[r2]);
        r2 = r2 + 1;
        goto L7
    L10:
        return a(r1);
    L12:
        return b;
    }
}
