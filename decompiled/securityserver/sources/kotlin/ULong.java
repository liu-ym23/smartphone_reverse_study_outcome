package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
public final class ULong implements Comparable<ULong> {
    public final long b;

    @Metadata
    public static final class Companion {
    }

    public /* synthetic */ ULong(long r1) {
        this.b = r1;
    }

    public static String a(long r9) {
        if (r9 < 0) goto L5;
        CharsKt.c(10);
        String r10 = Long.toString(r9, 10);
        Intrinsics.e(r10, "toString(this, checkRadix(radix))");
        return r10;
    L5:
        long r5 = 10;
        long r3 = ((r9 >>> 1) / r5) << 1;
        long r11 = r9 - (r3 * r5);
        if (r11 < r5) goto L8;
        r11 = r11 - r5;
        r3 = r3 + 1;
    L8:
        CharsKt.c(10);
        String r0 = Long.toString(r3, 10);
        Intrinsics.e(r0, "toString(this, checkRadix(radix))");
        CharsKt.c(10);
        String r12 = Long.toString(r11, 10);
        Intrinsics.e(r12, "toString(this, checkRadix(radix))");
        return r0.concat(r12);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ULong r3) {
        long r0 = r3.b;
        return UnsignedKt.b(this.b, r0);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof ULong) == false) goto L10;
        long r2 = ((ULong) r5).b;
        if (this.b != r2) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        long r1 = this.b;
        return (int) (r1 ^ (r1 >>> 32));
    }

    public final String toString() {
        return a(this.b);
    }
}
