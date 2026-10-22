package k.c0;

import k.e;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f18242a = null;

    static {
        f18242a = k.b.a("0123456789abcdef");
    }

    public static final byte[] a() {
        return f18242a;
    }

    public static final String b(e r6, long r7) {
        o.g(r6, "$this$readUtf8Line");
        if (r7 <= 0) goto L7;
        long r3 = r7 - 1;
        if (r6.O(r3) != ((byte) 13)) goto L7;
        String r8 = r6.m(r3);
        r6.skip(2);
        return r8;
    L7:
        String r9 = r6.m(r7);
        r6.skip(1);
        return r9;
    }
}
