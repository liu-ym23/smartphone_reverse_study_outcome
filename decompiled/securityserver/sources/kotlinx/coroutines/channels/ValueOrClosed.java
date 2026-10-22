package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public final class ValueOrClosed<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f388a;

    @Metadata
    public static final class Closed {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f389a;

        public Closed(Throwable r1) {
            this.f389a = r1;
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof Closed) == false) goto L7;
            Throwable r3 = ((Closed) r2).f389a;
            if (Intrinsics.a(this.f389a, r3) == false) goto L7;
            return true;
        L7:
            return false;
        }

        public final int hashCode() {
            Throwable r0 = this.f389a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Closed(" + this.f389a + ')';
        }
    }

    @Metadata
    public static final class Companion {
    }

    public /* synthetic */ ValueOrClosed(Object r1) {
        this.f388a = r1;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof ValueOrClosed) == false) goto L7;
        Object r3 = ((ValueOrClosed) r2).f388a;
        if (Intrinsics.a(this.f388a, r3) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        Object r0 = this.f388a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        Object r2 = this.f388a;
        if ((r2 instanceof Closed) == false) goto L6;
        return r2.toString();
    L6:
        return "Value(" + r2 + ')';
    }
}
