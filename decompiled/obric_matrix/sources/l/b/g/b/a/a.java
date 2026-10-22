package l.b.g.b.a;

import androidx.core.internal.view.SupportMenu;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f21981a;

    private a() {
        this.f21981a = new ByteArrayOutputStream();
    }

    public static a f() {
        return new a();
    }

    public a a(boolean r2) {
        this.f21981a.write(r2 ? 1 : 0);
        return this;
    }

    public byte[] b() {
        return this.f21981a.toByteArray();
    }

    public a c(l.b.h.c r2) {
        this.f21981a.write(r2.getEncoded());     // Catch: Exception -> L4
        return this;
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public a d(byte[] r2) {
        this.f21981a.write(r2);     // Catch: Exception -> L4
        return this;
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public a e(byte[][] r5) {
        int r0 = r5.length;     // Catch: Exception -> L7
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        byte[] r2 = r5[r1];     // Catch: Exception -> L7
        this.f21981a.write(r2);     // Catch: Exception -> L7
        r1 = r1 + 1;
        goto L3
    L6:
        return this;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public a g(int r2, int r3) {
    L3:
        if (this.f21981a.size() >= r3) goto L5;
        this.f21981a.write(r2);
        goto L3
    L5:
        return this;
    }

    public a h(int r3) {
        int r4 = r3 & SupportMenu.USER_MASK;
        this.f21981a.write((byte) (r4 >>> 8));
        this.f21981a.write((byte) r4);
        return this;
    }

    public a i(int r3) {
        this.f21981a.write((byte) (r3 >>> 24));
        this.f21981a.write((byte) (r3 >>> 16));
        this.f21981a.write((byte) (r3 >>> 8));
        this.f21981a.write((byte) r3);
        return this;
    }

    public a j(long r3) {
        i((int) (r3 >>> 32));
        i((int) r3);
        return this;
    }
}
