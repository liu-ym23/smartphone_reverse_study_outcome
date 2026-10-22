package d.b.j.e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class l extends f {
    public l(i r4, d r5, int r6) {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r5.f13962a == false) goto L5;
        ByteOrder r1 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r1);
        this.f13972a = r4.E(r0, (r5.f13964c + ((long) (r6 * r5.f13967f))) + 28);
        return;
    L5:
        r1 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
