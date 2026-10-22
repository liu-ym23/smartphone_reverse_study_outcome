package okio;

import android.security.bytedance.guard.BDSecurityGuardStub;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Pipe.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u0014J\r\u0010\u001f\u001a\u00020\u0014H\u0007¢\u0006\u0002\b,J\r\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\b-J&\u0010.\u001a\u00020**\u00020\u00142\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020*00¢\u0006\u0002\b1H\u0082\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u00020\u00148G¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\u0013\u0010#\u001a\u00020$8G¢\u0006\b\n\u0000\u001a\u0004\b#\u0010%R\u001a\u0010&\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000e¨\u00062"}, d2 = {"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", "", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "getMaxBufferSize$okio", "()J", "sink", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "fold", "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Pipe {
    private final Buffer buffer;
    private boolean canceled;
    private final Condition condition;
    private Sink foldedSink;
    private final ReentrantLock lock;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long r3) {
        this.maxBufferSize = r3;
        this.buffer = new Buffer();
        ReentrantLock r0 = new ReentrantLock();
        this.lock = r0;
        Condition r1 = r0.newCondition();
        Intrinsics.checkNotNullExpressionValue(r1, "lock.newCondition()");
        this.condition = r1;
        if (r3 < 1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        this.sink = new AnonymousClass1(this);
        this.source = new C04361(this);
        return;
    L10:
        throw new IllegalArgumentException(("maxBufferSize < 1: " + r3).toString());
    L5:
        r2 = false;
        goto L6
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final void setCanceled$okio(boolean r1) {
        this.canceled = r1;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final void setSinkClosed$okio(boolean r1) {
        this.sinkClosed = r1;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setSourceClosed$okio(boolean r1) {
        this.sourceClosed = r1;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final void setFoldedSink$okio(Sink r1) {
        this.foldedSink = r1;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }

    public final void fold(Sink r8) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "sink");
    L3:
        ReentrantLock r0 = this.lock;
        r0.lock();
    L35:
        th = move-exception;
        r0.unlock();
        throw th;
    L5:
        if (this.foldedSink != null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L34;
        if (this.canceled == true) goto L31;
        if (this.buffer.exhausted() == true) goto L13;
        boolean r2 = this.sinkClosed;     // Catch: Throwable -> L35
        Buffer r3 = new Buffer();     // Catch: Throwable -> L35
        Buffer r4 = this.buffer;     // Catch: Throwable -> L35
        r3.write(r4, r4.size());     // Catch: Throwable -> L35
        this.condition.signalAll();     // Catch: Throwable -> L35
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L35
        r0.unlock();
        r8.write(r3, r3.size());     // Catch: Throwable -> L23
        if (r2 == true) goto L20;
        r8.flush();     // Catch: Throwable -> L23
        goto L3
    L20:
        r8.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        ReentrantLock r6 = this.lock;
        r6.lock();
        this.sourceClosed = true;     // Catch: Throwable -> L28
        this.condition.signalAll();     // Catch: Throwable -> L28
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r6.unlock();
        throw th;
    L28:
        th = move-exception;
        r6.unlock();
        throw th;
    L13:
        this.sourceClosed = true;     // Catch: Throwable -> L35
        this.foldedSink = r8;     // Catch: Throwable -> L35
        r0.unlock();
        return;
    L31:
        this.foldedSink = r8;     // Catch: Throwable -> L35
        throw new IOException("canceled");     // Catch: Throwable -> L35
    L34:
        throw new IllegalStateException("sink already folded".toString());     // Catch: Throwable -> L35
    L7:
        r1 = false;
        goto L8
    }

    private final void forward(Sink r12, Function1<? super Sink, Unit> r13) {
        Timeout r0 = r12.timeout();
        Timeout r11 = sink().timeout();
        long r1 = r0.timeoutNanos();
        r0.timeout(Timeout.Companion.minTimeout(r11.timeoutNanos(), r0.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (r0.hasDeadline() == false) goto L19;
        long r5 = r0.deadlineNanoTime();
        if (r11.hasDeadline() == false) goto L35;
        r0.deadlineNanoTime(Math.min(r0.deadlineNanoTime(), r11.deadlineNanoTime()));
    L35:
        r13.invoke(r12);     // Catch: Throwable -> L12
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L11;
        r0.deadlineNanoTime(r5);
    L11:
        InlineMarker.finallyEnd(1);
        return;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L16;
        r0.deadlineNanoTime(r5);
    L16:
        InlineMarker.finallyEnd(1);
        throw th;
    L19:
        if (r11.hasDeadline() == false) goto L33;
        r0.deadlineNanoTime(r11.deadlineNanoTime());
    L33:
        r13.invoke(r12);     // Catch: Throwable -> L27
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L27
        InlineMarker.finallyStart(1);
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L25;
        r0.clearDeadline();
    L25:
        InlineMarker.finallyEnd(1);
        return;
    L27:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L31;
        r0.clearDeadline();
    L31:
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m3245deprecated_sink() {
        return this.sink;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "source", imports = {}))
    /* JADX INFO: renamed from: -deprecated_source, reason: not valid java name */
    public final Source m3246deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        ReentrantLock r0 = this.lock;
        r0.lock();
        this.canceled = true;     // Catch: Throwable -> L6
        this.buffer.clear();     // Catch: Throwable -> L6
        this.condition.signalAll();     // Catch: Throwable -> L6
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
