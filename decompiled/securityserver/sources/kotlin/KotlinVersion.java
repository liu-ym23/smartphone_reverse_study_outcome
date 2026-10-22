package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final class KotlinVersion implements Comparable<KotlinVersion> {
    public final int b;
    public final int c;
    public final int e;
    public final int f;

    @Metadata
    public static final class Companion {
    }

    static {
        new KotlinVersion();
    }

    public KotlinVersion() {
        this.b = 1;
        this.c = 7;
        this.e = 10;
        if (new IntRange(0, 255, 1).b(1) == false) goto L11;
        if (new IntRange(0, 255, 1).b(7) == false) goto L11;
        if (new IntRange(0, 255, 1).b(10) == false) goto L11;
        this.f = 67338;
        return;
    L11:
        throw new IllegalArgumentException("Version components are out of range: 1.7.10".toString());
    }

    @Override // java.lang.Comparable
    public final int compareTo(KotlinVersion r2) {
        KotlinVersion r3 = r2;
        Intrinsics.f(r3, "other");
        return this.f - r3.f;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof KotlinVersion) == false) goto L8;
        KotlinVersion r4 = (KotlinVersion) r3;
    L10:
        if (r4 != null) goto L13;
        return false;
    L13:
        if (this.f != r4.f) goto L16;
        return true;
    L16:
        return false;
    L8:
        r4 = null;
        goto L10
    }

    public final int hashCode() {
        return this.f;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.b);
        r0.append('.');
        r0.append(this.c);
        r0.append('.');
        r0.append(this.e);
        return r0.toString();
    }
}
