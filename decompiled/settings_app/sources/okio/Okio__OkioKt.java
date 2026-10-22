package okio;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Okio.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0006\u001aA\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"blackholeSink", "Lokio/Sink;", "blackhole", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "use", "R", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Closeable;", "Lokio/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "okio/Okio")
final /* synthetic */ class Okio__OkioKt {
    public static final BufferedSource buffer(Source r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new RealBufferedSource(r1);
    }

    public static final BufferedSink buffer(Sink r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new RealBufferedSink(r1);
    }

    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final <T extends Closeable, R> R use(T r3, Function1<? super T, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        Throwable th = null;
        R r5 = r4.invoke(r3);     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        if (r3 != null) goto L24;
    L9:
        InlineMarker.finallyEnd(1);
    L18:
        if (th != null) goto L21;
        Intrinsics.checkNotNull(r5);
        return r5;
    L21:
        throw th;
    L24:
        r3.close();     // Catch: Throwable -> L8
    L8:
        th = th;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r3 != null) goto L22;
    L17:
        InlineMarker.finallyEnd(1);
        th = th;
        r5 = null;
        goto L18
    L22:
        r3.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L17
    }
}
