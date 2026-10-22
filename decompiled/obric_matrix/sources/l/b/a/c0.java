package l.b.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class c0 extends a {
    public c0(int r2, f r3) {
        super(true, r2, x(r3));
    }

    private static byte[] x(f r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        int r1 = 0;
    L4:
        if (r1 == r4.f()) goto L11;
        r0.write(((n) r4.d(r1)).m("BER"));     // Catch: IOException -> L7
        r1 = r1 + 1;
    L7:
        e = move-exception;
        throw new s("malformed object: " + e, e);
    L11:
        return r0.toByteArray();
    }

    @Override // l.b.a.a, l.b.a.t
    void o(r r3, boolean r4) {
        if (this.f21506f == false) goto L5;
        int r0 = 96;
    L6:
        r3.o(r4, r0, this.f21507g, this.f21508h);
        return;
    L5:
        r0 = 64;
        goto L6
    }
}
