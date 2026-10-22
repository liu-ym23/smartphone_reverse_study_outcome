package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class BooleanVector extends BaseVector {
    public BooleanVector() {
    }

    public BooleanVector __assign(int r2, ByteBuffer r3) {
        __reset(r2, 1, r3);
        return this;
    }

    public boolean get(int r2) {
        if (this.bb.get(__element(r2)) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
