package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long r1) {
        this.allocatedUntil = r1;
        this.waitByteCount = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        this.maxByteCount = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r10 = r7.waitByteCount;
    L5:
        long r3 = r10;
        if ((r14 & 4) == 0) goto L8;
        r12 = r7.maxByteCount;
    L8:
        r7.bytesPerSecond(r8, r3, r12);
    }

    private final long bytesToNanos(long r3) {
        return (r3 * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long r3) {
        return (r3 * this.bytesPerSecond) / 1000000000;
    }

    private final void waitNanos(long r5) {
        long r2 = r5 / 1000000;
        wait(r2, (int) (r5 - (1000000 * r2)));
    }

    public final long byteCountOrWaitNanos$okio(long r10, long r12) {
        if (this.bytesPerSecond != 0) goto L5;
        return r12;
    L5:
        long r0 = Math.max(this.allocatedUntil - r10, 0);
        long r4 = this.maxByteCount - nanosToBytes(r0);
        if (r4 < r12) goto L9;
        this.allocatedUntil = (r10 + r0) + bytesToNanos(r12);
        return r12;
    L9:
        long r6 = this.waitByteCount;
        if (r4 < r6) goto L13;
        this.allocatedUntil = r10 + bytesToNanos(this.maxByteCount);
        return r4;
    L13:
        long r13 = Math.min(r6, r12);
        long r1 = r0 + bytesToNanos(r13 - this.maxByteCount);
        if (r1 != 0) goto L18;
        this.allocatedUntil = r10 + bytesToNanos(this.maxByteCount);
        return r13;
    L18:
        return -r1;
    }

    @JvmOverloads
    public final void bytesPerSecond(long r10) {
        bytesPerSecond$default(this, r10, 0, 0, 6, null);
    }

    @NotNull
    public final Sink sink(@NotNull final Sink r2) {
        Intrinsics.f(r2, "sink");
        return new AnonymousClass1(this, r2, r2);
    }

    @NotNull
    public final Source source(@NotNull final Source r2) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        return new C00491(this, r2, r2);
    }

    public final long take$okio(long r6) {
        if (r6 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L20;
        monitor-enter(this);
    L21:
        long r3 = byteCountOrWaitNanos$okio(System.nanoTime(), r6);     // Catch: Throwable -> L16
        if (r3 >= 0) goto L11;
        waitNanos(-r3);     // Catch: Throwable -> L16
        goto L21
    L11:
        monitor-exit(this);
        return r3;
    L16:
        th = move-exception;
        throw th;
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r2 = false;
        goto L6
    }

    @JvmOverloads
    public final void bytesPerSecond(long r10, long r12) {
        bytesPerSecond$default(this, r10, r12, 0, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long r6, long r8, long r10) {
        monitor-enter(this);
        boolean r3 = false;
        if (r6 < 0) goto L6;
        boolean r2 = true;
    L30:
        if (r2 == false) goto L27;
        if (r8 <= 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L25;
        if (r10 < r8) goto L16;
        r3 = true;
    L16:
        if (r3 == false) goto L23;
        this.bytesPerSecond = r6;     // Catch: Throwable -> L20
        this.waitByteCount = r8;     // Catch: Throwable -> L20
        this.maxByteCount = r10;     // Catch: Throwable -> L20
        notifyAll();     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L23:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L20
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L20
    L11:
        r0 = false;
        goto L12
    L27:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L6:
        r2 = false;
        goto L30
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
