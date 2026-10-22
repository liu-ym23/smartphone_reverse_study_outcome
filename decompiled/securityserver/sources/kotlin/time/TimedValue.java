package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@ExperimentalTime
public final class TimedValue<T> {
    public final boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof TimedValue) == true) goto L8;
        return false;
    L8:
        ((TimedValue) r3).getClass();
        if (Intrinsics.a(null, null) == true) goto L11;
        return false;
    L11:
        int r2 = Duration.b;
        return true;
    }

    public final int hashCode() {
        int r2 = Duration.b;
        return (int) 0;
    }

    public final String toString() {
        int r0 = Duration.b;
        return "TimedValue(value=null, duration=0s)";
    }
}
