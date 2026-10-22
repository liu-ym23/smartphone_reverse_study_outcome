package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final class PackageReference implements ClassBasedDeclarationContainer {
    public final Class b;

    public PackageReference(Class r2) {
        Intrinsics.f(r2, "jClass");
        this.b = r2;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class a() {
        return this.b;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof PackageReference) == false) goto L7;
        Class r3 = ((PackageReference) r2).b;
        if (Intrinsics.a(this.b, r3) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b.toString() + " (Kotlin reflection is not available)";
    }
}
