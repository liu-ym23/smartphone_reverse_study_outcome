package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class IntVector extends BaseVector {
    public IntVector() {
    }

    public IntVector __assign(int r2, ByteBuffer r3) {
        __reset(r2, 4, r3);
        return this;
    }

    public int get(int r2) {
        return this.bb.getInt(__element(r2));
    }

    public long getAsUnsigned(int r3) {
        return ((long) get(r3)) & 4294967295L;
    }
}
