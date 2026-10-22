package kotlin;

import java.io.Serializable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@JvmInline
public final class Result<T> implements Serializable {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Failure implements Serializable {
        public final Throwable b;

        public Failure(Throwable r2) {
            Intrinsics.f(r2, "exception");
            this.b = r2;
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof Failure) == false) goto L7;
            Throwable r3 = ((Failure) r2).b;
            if (Intrinsics.a(this.b, r3) == false) goto L7;
            return true;
        L7:
            return false;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.b + ')';
        }
    }

    public static final Throwable a(Object r1) {
        if ((r1 instanceof Failure) == true) goto L7;
        return null;
    L7:
        return ((Failure) r1).b;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof Result) == true) goto L5;
        return false;
    L5:
        Result r3 = (Result) r2;
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        throw null;
    }
}
