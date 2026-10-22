package javax.obex;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ObexPacket {
    public int mHeaderId;
    public int mLength;
    public byte[] mPayload;

    private ObexPacket(int r2, int r3) {
        this.mPayload = null;
        this.mHeaderId = r2;
        this.mLength = r3;
    }

    public static ObexPacket read(InputStream r1) throws IOException {
        return read(r1.read(), r1);
    }

    public static ObexPacket read(int r4, InputStream r5) throws IOException {
        int r0 = (r5.read() << 8) + r5.read();
        ObexPacket r1 = new ObexPacket(r4, r0);
        if (r0 <= 3) goto L7;
        int r2 = r0 - 3;
        byte[] r6 = new byte[r2];
        int r3 = r5.read(r6);
    L5:
        if (r3 == r2) goto L8;
        r3 = r3 + r5.read(r6, r3, r2 - r3);
    L8:
        r1.mPayload = r6;
        return r1;
    L7:
        r6 = null;
        goto L8
    }
}
