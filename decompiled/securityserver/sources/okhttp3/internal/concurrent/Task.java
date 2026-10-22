package okhttp3.internal.concurrent;

import com.bytedance.framwork.core.sdklib.DBHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class Task {
    private final boolean cancelable;

    @NotNull
    private final String name;
    private long nextExecuteNanoTime;

    @Nullable
    private TaskQueue queue;

    public Task(@NotNull String r2, boolean r3) {
        Intrinsics.f(r2, "name");
        this.name = r2;
        this.cancelable = r3;
        this.nextExecuteNanoTime = -1;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    @Nullable
    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void initQueue$okhttp(@NotNull TaskQueue r2) {
        Intrinsics.f(r2, DBHelper.TABLE_QUEUE);
        TaskQueue r0 = this.queue;
        if (r0 != r2) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L12;
        this.queue = r2;
        return;
    L12:
        throw new IllegalStateException("task is in multiple queues".toString());
    L7:
        r1 = false;
        goto L8
    }

    public abstract long runOnce();

    public final void setNextExecuteNanoTime$okhttp(long r1) {
        this.nextExecuteNanoTime = r1;
    }

    public final void setQueue$okhttp(@Nullable TaskQueue r1) {
        this.queue = r1;
    }

    @NotNull
    public String toString() {
        return this.name;
    }

    public /* synthetic */ Task(String r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        this(r1, r2);
    }
}
