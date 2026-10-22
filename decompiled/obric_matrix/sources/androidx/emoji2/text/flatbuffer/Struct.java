package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Struct {
    protected ByteBuffer bb;
    protected int bb_pos;

    public Struct() {
    }

    public void __reset() {
        __reset(0, null);
    }

    protected void __reset(int r1, ByteBuffer r2) {
        this.bb = r2;
        if (r2 != null) goto L6;
        r1 = 0;
    L6:
        this.bb_pos = r1;
    }
}
