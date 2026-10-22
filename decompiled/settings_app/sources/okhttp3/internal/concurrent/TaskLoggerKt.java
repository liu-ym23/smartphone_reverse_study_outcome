package okhttp3.internal.concurrent;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.framwork.core.sdklib.DBHelper;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: TaskLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a5\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", DBHelper.TABLE_QUEUE, "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TaskLoggerKt {
    public static final /* synthetic */ void access$log(Task r0, TaskQueue r1, String r2) {
        log(r0, r1, r2);
    }

    public static final void taskLog(Task r2, TaskQueue r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "task");
        Intrinsics.checkNotNullParameter(r3, DBHelper.TABLE_QUEUE);
        Intrinsics.checkNotNullParameter(r4, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE) == false) goto L6;
        access$log(r2, r3, r4.invoke());
        return;
    }

    public static final <T> T logElapsed(Task r6, TaskQueue r7, Function0<? extends T> r8) {
        Intrinsics.checkNotNullParameter(r6, "task");
        Intrinsics.checkNotNullParameter(r7, DBHelper.TABLE_QUEUE);
        Intrinsics.checkNotNullParameter(r8, "block");
        boolean r0 = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (r0 == false) goto L5;
        long r1 = r7.getTaskRunner$okhttp().getBackend().nanoTime();
        access$log(r6, r7, "starting");
    L19:
        T r9 = r8.invoke();     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        if (r0 == false) goto L11;
        access$log(r6, r7, Intrinsics.stringPlus("finished run in ", formatDuration(r7.getTaskRunner$okhttp().getBackend().nanoTime() - r1)));
    L11:
        InlineMarker.finallyEnd(1);
        return r9;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (r0 == false) goto L17;
        access$log(r6, r7, Intrinsics.stringPlus("failed a run in ", formatDuration(r7.getTaskRunner$okhttp().getBackend().nanoTime() - r1)));
    L17:
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        r1 = -1;
        goto L19
    }

    private static final void log(Task r4, TaskQueue r5, String r6) {
        Logger r0 = TaskRunner.Companion.getLogger();
        StringBuilder r7 = new StringBuilder().append(r5.getName$okhttp()).append(TokenParser.SP);
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        String r8 = String.format("%-22s", Arrays.copyOf(new Object[]{r6}, 1));
        Intrinsics.checkNotNullExpressionValue(r8, "format(format, *args)");
        r0.fine(r7.append(r8).append(": ").append(r4.getName()).toString());
    }

    public static final String formatDuration(long r12) {
        if (r12 > (-999500000)) goto L6;
        String r13 = ((r12 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
    L18:
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        String r15 = String.format("%6s", Arrays.copyOf(new Object[]{r13}, 1));
        Intrinsics.checkNotNullExpressionValue(r15, "format(format, *args)");
        return r15;
    L6:
        if (r12 > (-999500)) goto L9;
        r13 = ((r12 - ((long) 500000)) / ((long) 1000000)) + " ms";
        goto L18
    L9:
        if (r12 > 0) goto L12;
        r13 = ((r12 - ((long) 500)) / ((long) 1000)) + " µs";
        goto L18
    L12:
        if (r12 >= 999500) goto L15;
        r13 = ((r12 + ((long) 500)) / ((long) 1000)) + " µs";
        goto L18
    L15:
        if (r12 >= 999500000) goto L17;
        r13 = ((r12 + ((long) 500000)) / ((long) 1000000)) + " ms";
        goto L18
    L17:
        r13 = ((r12 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        goto L18
    }
}
