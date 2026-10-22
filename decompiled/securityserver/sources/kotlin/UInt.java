package kotlin;

import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
public final class UInt implements Comparable<UInt> {
    public final int b;

    @Metadata
    public static final class Companion {
    }

    public /* synthetic */ UInt(int r1) {
        this.b = r1;
    }

    public static String a(int r4) {
        return String.valueOf(((long) r4) & 4294967295L);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UInt r1) {
        int r2 = r1.b;
        return UnsignedKt.a(this.b, r2);
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof UInt) == false) goto L10;
        int r4 = ((UInt) r3).b;
        if (this.b != r4) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        return a(this.b);
    }
}
