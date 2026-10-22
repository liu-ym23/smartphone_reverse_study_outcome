package k;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final byte[] a(String r1) {
        kotlin.n0.d.o.g(r1, "$this$asUtf8ToByteArray");
        byte[] r2 = r1.getBytes(kotlin.u0.d.f21429a);
        kotlin.n0.d.o.b(r2, "(this as java.lang.String).getBytes(charset)");
        return r2;
    }

    public static final String b(byte[] r2) {
        kotlin.n0.d.o.g(r2, "$this$toUtf8String");
        return new String(r2, kotlin.u0.d.f21429a);
    }
}
