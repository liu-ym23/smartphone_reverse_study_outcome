package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
public final class UByte implements Comparable<UByte> {
    public final byte b;

    @Metadata
    public static final class Companion {
    }

    public /* synthetic */ UByte(byte r1) {
        this.b = r1;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(UByte r1) {
        byte r2 = r1.b;
        return Intrinsics.h(this.b & 255, r2 & 255);
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof UByte) == false) goto L10;
        byte r4 = ((UByte) r3).b;
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
        return String.valueOf(this.b & 255);
    }
}
