package d.b.j.e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    public a(i r4, d r5, long r6, int r8) {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r5.f13962a == false) goto L5;
        ByteOrder r7 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r7);
        long r9 = r6 + ((long) (r8 * 8));
        this.f13960a = r4.E(r0, r9);
        this.f13961b = r4.E(r0, r9 + 4);
        return;
    L5:
        r7 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
