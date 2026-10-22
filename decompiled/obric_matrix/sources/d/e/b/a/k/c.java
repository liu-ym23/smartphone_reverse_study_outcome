package d.e.b.a.k;

import d.e.b.a.i;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f16627a;

    private c() {
        this.f16627a = new d(100);
    }

    public static b b() {
        return new c();
    }

    private static boolean c(CharSequence r0, Pattern r1, boolean r2) {
        Matcher r3 = r1.matcher(r0);
        if (r3.lookingAt() == true) goto L7;
        return false;
    L7:
        if (r3.matches() == false) goto L10;
        return true;
    L10:
        return r2;
    }

    @Override // d.e.b.a.k.b
    public boolean a(CharSequence r2, i r3, boolean r4) {
        String r5 = r3.b();
        if (r5.length() != 0) goto L7;
        return false;
    L7:
        return c(r2, this.f16627a.a(r5), r4);
    }
}
