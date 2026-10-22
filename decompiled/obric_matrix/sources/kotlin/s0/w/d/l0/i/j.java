package kotlin.s0.w.d.l0.i;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f20358a = null;

    public interface a {
        int d();
    }

    public interface b<T extends a> {
        T a(int r1);
    }

    static {
        byte[] r0 = new byte[0];
        f20358a = r0;
        ByteBuffer.wrap(r0);
    }

    public static boolean a(byte[] r0) {
        return y.e(r0);
    }

    public static String b(byte[] r2) {
        return new String(r2, "UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }
}
