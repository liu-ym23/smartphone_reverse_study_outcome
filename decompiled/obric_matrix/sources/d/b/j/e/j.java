package d.b.j.e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class j extends e {
    public j(i r6, d r7, long r8) {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r7.f13962a == false) goto L5;
        ByteOrder r1 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r1);
        long r2 = r7.f13963b + (r8 * ((long) r7.f13965d));
        this.f13968a = r6.E(r0, r2);
        this.f13969b = r6.E(r0, 4 + r2);
        this.f13970c = r6.E(r0, 8 + r2);
        this.f13971d = r6.E(r0, r2 + 20);
        return;
    L5:
        r1 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
