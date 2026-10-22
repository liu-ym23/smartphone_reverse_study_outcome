package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class LongVector extends BaseVector {
    public LongVector() {
    }

    public LongVector __assign(int r2, ByteBuffer r3) {
        __reset(r2, 8, r3);
        return this;
    }

    public long get(int r2) {
        return this.bb.getLong(__element(r2));
    }
}
