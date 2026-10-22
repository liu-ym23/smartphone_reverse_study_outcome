package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public final class ShortVector extends BaseVector {
    public ShortVector() {
    }

    public ShortVector __assign(int r2, ByteBuffer r3) {
        __reset(r2, 2, r3);
        return this;
    }

    public short get(int r2) {
        return this.bb.getShort(__element(r2));
    }

    public int getAsUnsigned(int r1) {
        return get(r1) & UShort.MAX_VALUE;
    }
}
