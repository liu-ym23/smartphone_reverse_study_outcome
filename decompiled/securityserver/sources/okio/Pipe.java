package okio;

import a.a;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Pipe {

    @NotNull
    private final Buffer buffer;
    private boolean canceled;

    @Nullable
    private Sink foldedSink;
    private final long maxBufferSize;

    @NotNull
    private final Sink sink;
    private boolean sinkClosed;

    @NotNull
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long r3) {
        this.maxBufferSize = r3;
        this.buffer = new Buffer();
        if (r3 < 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.sink = new AnonymousClass1(this);
        this.source = new C00481(this);
        return;
    L10:
        throw new IllegalArgumentException(a.h("maxBufferSize < 1: ", r3).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final /* synthetic */ void access$forward(Pipe r0, Sink r1, Function1 r2) {
        r0.forward(r1, r2);
    }

    private final void forward(Sink r11, Function1<? super Sink, Unit> r12) {
        Timeout r0 = r11.timeout();
        Timeout r10 = sink().timeout();
        long r1 = r0.timeoutNanos();
        long r3 = Timeout.Companion.minTimeout(r10.timeoutNanos(), r0.timeoutNanos());
        TimeUnit r5 = TimeUnit.NANOSECONDS;
        r0.timeout(r3, r5);
        if (r0.hasDeadline() == false) goto L17;
        long r4 = r0.deadlineNanoTime();
        if (r10.hasDeadline() == false) goto L29;
        r0.deadlineNanoTime(Math.min(r0.deadlineNanoTime(), r10.deadlineNanoTime()));
    L29:
        r12.invoke(r11);     // Catch: Throwable -> L11
        r0.timeout(r1, r5);
        if (r10.hasDeadline() == false) goto L33;
        r0.deadlineNanoTime(r4);
        return;
    L33:
        return;
    L11:
        th = move-exception;
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r10.hasDeadline() == false) goto L15;
        r0.deadlineNanoTime(r4);
    L15:
        throw th;
    L17:
        if (r10.hasDeadline() == false) goto L31;
        r0.deadlineNanoTime(r10.deadlineNanoTime());
    L31:
        r12.invoke(r11);     // Catch: Throwable -> L24
        r0.timeout(r1, r5);
        if (r10.hasDeadline() == false) goto L35;
        r0.clearDeadline();
        return;
    L35:
        return;
    L24:
        th = move-exception;
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r10.hasDeadline() == false) goto L28;
        r0.clearDeadline();
    L28:
        throw th;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m199deprecated_sink() {
        return this.sink;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_source, reason: not valid java name */
    public final Source m200deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        Buffer r0 = this.buffer;
        monitor-enter(r0);
        this.canceled = true;     // Catch: Throwable -> L10
        this.buffer.clear();     // Catch: Throwable -> L10
        Buffer r2 = this.buffer;     // Catch: Throwable -> L10
        if (r2 == null) goto L13;
        r2.notifyAll();     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void fold(@NotNull Sink r8) {
        Intrinsics.f(r8, "sink");
    L3:
        Buffer r0 = this.buffer;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L6:
        if (this.foldedSink != null) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L48;
        if (this.canceled == true) goto L45;
        if (this.buffer.exhausted() == true) goto L14;
        boolean r2 = this.sinkClosed;     // Catch: Throwable -> L17
        Buffer r3 = new Buffer();     // Catch: Throwable -> L17
        Buffer r4 = this.buffer;     // Catch: Throwable -> L17
        r3.write(r4, r4.size());     // Catch: Throwable -> L17
        Buffer r5 = this.buffer;     // Catch: Throwable -> L17
        if (r5 == null) goto L44;
        r5.notifyAll();     // Catch: Throwable -> L17
        monitor-exit(r0);
        r8.write(r3, r3.size());     // Catch: Throwable -> L26
        if (r2 == true) goto L25;
        r8.flush();     // Catch: Throwable -> L26
        goto L3
    L25:
        r8.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        monitor-enter(this.buffer);
        this.sourceClosed = true;     // Catch: Throwable -> L36
        Buffer r7 = this.buffer;     // Catch: Throwable -> L36
        if (r7 == null) goto L35;
        r7.notifyAll();     // Catch: Throwable -> L36
        throw th;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L17
    L14:
        this.sourceClosed = true;     // Catch: Throwable -> L17
        this.foldedSink = r8;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L45:
        this.foldedSink = r8;     // Catch: Throwable -> L17
        throw new IOException("canceled");     // Catch: Throwable -> L17
    L48:
        throw new IllegalStateException("sink already folded".toString());     // Catch: Throwable -> L17
    L8:
        r1 = false;
        goto L9
    }

    @NotNull
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    @Nullable
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean r1) {
        this.canceled = r1;
    }

    public final void setFoldedSink$okio(@Nullable Sink r1) {
        this.foldedSink = r1;
    }

    public final void setSinkClosed$okio(boolean r1) {
        this.sinkClosed = r1;
    }

    public final void setSourceClosed$okio(boolean r1) {
        this.sourceClosed = r1;
    }

    @JvmName
    @NotNull
    public final Sink sink() {
        return this.sink;
    }

    @JvmName
    @NotNull
    public final Source source() {
        return this.source;
    }
}
