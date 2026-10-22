package kotlin.io;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class CloseableKt {
    public static final void a(Closeable r0, Throwable r1) {
        if (r0 == null) goto L12;
        if (r1 != null) goto L10;
        r0.close();
        return;
    L10:
        r0.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        kotlin.ExceptionsKt.a(r1, th);
        return;
    }
}
