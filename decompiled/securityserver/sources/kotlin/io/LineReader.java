package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LineReader {
    static {
        Intrinsics.e(ByteBuffer.wrap(new byte[32]), "wrap(bytes)");
        Intrinsics.e(CharBuffer.wrap(new char[32]), "wrap(chars)");
    }
}
