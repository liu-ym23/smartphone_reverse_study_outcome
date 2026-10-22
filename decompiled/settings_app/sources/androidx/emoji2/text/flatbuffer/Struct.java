package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Struct {
    protected ByteBuffer bb;
    protected int bb_pos;

    public Struct() {
    }

    protected void __reset(int r1, ByteBuffer r2) {
        this.bb = r2;
        if (r2 == null) goto L5;
        this.bb_pos = r1;
        return;
    L5:
        this.bb_pos = 0;
    }

    public void __reset() {
        __reset(0, null);
    }
}
