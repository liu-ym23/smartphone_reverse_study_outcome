package cz.msebera.android.httpclient.client.utils;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class Punycode {
    private static final Idn impl = null;

    public Punycode() {
    }

    static {
        Idn r0 = new JdkIdn();     // Catch: Exception -> L4
    L5:
        impl = r0;
        return;
    L4:
        r0 = new Rfc3492Idn();
        goto L5
    }

    public static String toUnicode(String r1) {
        return impl.toUnicode(r1);
    }
}
