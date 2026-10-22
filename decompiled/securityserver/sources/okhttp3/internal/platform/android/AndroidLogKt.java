package okhttp3.internal.platform.android;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AndroidLogKt {
    public static final /* synthetic */ int access$getAndroidLevel$p(LogRecord r0) {
        return getAndroidLevel(r0);
    }

    private static final int getAndroidLevel(LogRecord r3) {
        int r0 = r3.getLevel().intValue();
        Level r1 = Level.INFO;
        if (r0 <= r1.intValue()) goto L6;
        return 5;
    L6:
        if (r3.getLevel().intValue() != r1.intValue()) goto L8;
        return 4;
    L8:
        return 3;
    }
}
