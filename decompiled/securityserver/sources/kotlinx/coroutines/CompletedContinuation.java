package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CompletedContinuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f362a;
    public final CancelHandler b;
    public final Function1 c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f363d;
    public final Throwable e;

    public CompletedContinuation(Object r1, CancelHandler r2, Function1 r3, Object r4, Throwable r5) {
        this.f362a = r1;
        this.b = r2;
        this.c = r3;
        this.f363d = r4;
        this.e = r5;
    }

    public static CompletedContinuation a(CompletedContinuation r6, CancelHandler r7, CancellationException r8, int r9) {
        Object r1 = r6.f362a;
        if ((r9 & 2) == 0) goto L5;
        r7 = r6.b;
    L5:
        CancelHandler r2 = r7;
        Function1 r3 = r6.c;
        Object r4 = r6.f363d;
        Throwable r10 = r8;
        if ((r9 & 16) == 0) goto L8;
        r10 = r6.e;
    L8:
        r6.getClass();
        return new CompletedContinuation(r1, r2, r3, r4, r10);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CompletedContinuation) == false) goto L16;
        CompletedContinuation r4 = (CompletedContinuation) r3;
        Object r0 = r4.f362a;
        if (Intrinsics.a(this.f362a, r0) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.a(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.a(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.f363d, r4.f363d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.a(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r0 = 0;
        Object r1 = this.f362a;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = r2 * 31;
        CancelHandler r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Function1 r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Object r10 = this.f363d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Throwable r13 = this.e;
        if (r13 == null) goto L22;
        r0 = r13.hashCode();
    L22:
        return r12 + r0;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f362a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.f363d + ", cancelCause=" + this.e + ")";
    }

    public /* synthetic */ CompletedContinuation(Object r9, CancelHandler r10, Function1 r11, Object r12, CancellationException r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        CancelHandler r4 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        Function1 r5 = null;
    L11:
        if ((r14 & 8) == 0) goto L13;
        Object r6 = null;
    L15:
        if ((r14 & 16) == 0) goto L17;
        CancellationException r7 = null;
    L18:
        this(r9, r4, r5, r6, r7);
        return;
    L17:
        r7 = r13;
        goto L18
    L13:
        r6 = r12;
        goto L15
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
