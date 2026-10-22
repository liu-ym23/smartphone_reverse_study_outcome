package okhttp3.internal.concurrent;

import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.Arrays;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TaskLoggerKt {
    public static final /* synthetic */ void access$log(Task r0, TaskQueue r1, String r2) {
        log(r0, r1, r2);
    }

    @NotNull
    public static final String formatDuration(long r12) {
        if (r12 > (-999500000)) goto L6;
        String r13 = ((r12 - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
    L19:
        return String.format("%6s", Arrays.copyOf(new Object[]{r13}, 1));
    L6:
        if (r12 > (-999500)) goto L9;
        r13 = ((r12 - ((long) 500000)) / ((long) 1000000)) + " ms";
        goto L19
    L9:
        if (r12 > 0) goto L12;
        r13 = ((r12 - ((long) 500)) / ((long) 1000)) + " µs";
        goto L19
    L12:
        if (r12 >= 999500) goto L15;
        r13 = ((r12 + ((long) 500)) / ((long) 1000)) + " µs";
        goto L19
    L15:
        if (r12 >= 999500000) goto L17;
        r13 = ((r12 + ((long) 500000)) / ((long) 1000000)) + " ms";
        goto L19
    L17:
        r13 = ((r12 + ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        goto L19
    }

    private static final void log(Task r2, TaskQueue r3, String r4) {
        TaskRunner.Companion.getLogger().fine(r3.getName$okhttp() + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{r4}, 1)) + ": " + r2.getName());
    }

    public static final <T> T logElapsed(@NotNull Task r5, @NotNull TaskQueue r6, @NotNull Function0<? extends T> r7) {
        Intrinsics.f(r5, "task");
        Intrinsics.f(r6, DBHelper.TABLE_QUEUE);
        Intrinsics.f(r7, "block");
        boolean r0 = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (r0 == false) goto L5;
        long r1 = r6.getTaskRunner$okhttp().getBackend().nanoTime();
        access$log(r5, r6, "starting");
    L14:
        T r8 = (T) r7.invoke();
        if (r0 == false) goto L9;
        access$log(r5, r6, "finished run in " + formatDuration(r6.getTaskRunner$okhttp().getBackend().nanoTime() - r1));
    L9:
        return r8;
    L10:
        th = move-exception;
        if (r0 == false) goto L13;
        access$log(r5, r6, "failed a run in " + formatDuration(r6.getTaskRunner$okhttp().getBackend().nanoTime() - r1));
    L13:
        throw th;
    L5:
        r1 = -1;
        goto L14
    }

    public static final void taskLog(@NotNull Task r2, @NotNull TaskQueue r3, @NotNull Function0<String> r4) {
        Intrinsics.f(r2, "task");
        Intrinsics.f(r3, DBHelper.TABLE_QUEUE);
        Intrinsics.f(r4, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L6;
        access$log(r2, r3, (String) r4.invoke());
        return;
    }
}
