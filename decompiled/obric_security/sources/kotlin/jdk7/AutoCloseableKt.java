package kotlin.jdk7;

import androidx.exifinterface.media.ExifInterface;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoCloseable.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aH\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"closeFinally", "", "Ljava/lang/AutoCloseable;", "cause", "", "use", "R", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 8, 0}, pn = "kotlin", xi = 48)
public final class AutoCloseableKt {
    private static final <T extends AutoCloseable, R> R use(T r2, Function1<? super T, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        R r4 = r3.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        closeFinally(r2, null);
        InlineMarker.finallyEnd(1);
        return r4;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        closeFinally(r2, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void closeFinally(AutoCloseable r0, Throwable r1) {
        if (r0 == null) goto L12;
        if (r1 != null) goto L10;
        r0.close();
        return;
    L10:
        r0.close();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ExceptionsKt.addSuppressed(r1, th);
        return;
    }
}
