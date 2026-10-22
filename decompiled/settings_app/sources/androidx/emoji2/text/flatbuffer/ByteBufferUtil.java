package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferUtil {
    public ByteBufferUtil() {
    }

    public static int getSizePrefix(ByteBuffer r1) {
        return r1.getInt(r1.position());
    }

    public static ByteBuffer removeSizePrefix(ByteBuffer r1) {
        ByteBuffer r2 = r1.duplicate();
        r2.position(r2.position() + 4);
        return r2;
    }
}
