package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
public final class Duration implements Comparable<Duration> {
    public static final /* synthetic */ int b = 0;

    @Metadata
    public static final class Companion {
    }

    static {
        int r0 = DurationJvmKt.f358a;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Duration r1) {
        r1.getClass();
        return 0;
    }

    public final boolean equals(Object r1) {
        if ((r1 instanceof Duration) == true) goto L5;
        return false;
    L5:
        ((Duration) r1).getClass();
        return true;
    }

    public final int hashCode() {
        return (int) 0;
    }

    public final String toString() {
        return "0s";
    }
}
