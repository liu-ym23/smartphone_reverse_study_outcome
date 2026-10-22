package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
public final class UShort implements Comparable<UShort> {
    public final short b;

    @Metadata
    public static final class Companion {
    }

    public /* synthetic */ UShort(short r1) {
        this.b = r1;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UShort r2) {
        short r3 = r2.b;
        return Intrinsics.h(this.b & 65535, r3 & 65535);
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof UShort) == false) goto L10;
        short r4 = ((UShort) r3).b;
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
        return String.valueOf(this.b & 65535);
    }
}
