package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class ByteVector extends BaseVector {
    public ByteVector() {
    }

    public ByteVector __assign(int r2, ByteBuffer r3) {
        __reset(r2, 1, r3);
        return this;
    }

    public byte get(int r2) {
        return this.bb.get(__element(r2));
    }

    public int getAsUnsigned(int r1) {
        return get(r1) & UByte.MAX_VALUE;
    }
}
