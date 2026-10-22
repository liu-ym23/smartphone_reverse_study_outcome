package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class ForwardingTimeout extends Timeout {

    @NotNull
    private Timeout delegate;

    public ForwardingTimeout(@NotNull Timeout r2) {
        Intrinsics.f(r2, "delegate");
        this.delegate = r2;
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @JvmName
    @NotNull
    public final Timeout delegate() {
        return this.delegate;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    /* JADX INFO: renamed from: setDelegate, reason: collision with other method in class */
    public final /* synthetic */ void m195setDelegate(@NotNull Timeout r2) {
        Intrinsics.f(r2, "<set-?>");
        this.delegate = r2;
    }

    @Override // okio.Timeout
    public void throwIfReached() {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout timeout(long r2, @NotNull TimeUnit r4) {
        Intrinsics.f(r4, "unit");
        return this.delegate.timeout(r2, r4);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout deadlineNanoTime(long r1) {
        return this.delegate.deadlineNanoTime(r1);
    }

    @NotNull
    public final ForwardingTimeout setDelegate(@NotNull Timeout r2) {
        Intrinsics.f(r2, "delegate");
        this.delegate = r2;
        return this;
    }
}
