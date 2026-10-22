package coil.util;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DebugLogger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcoil/util/DebugLogger;", "Lcoil/util/Logger;", "level", "", "(I)V", "value", "getLevel", "()I", "setLevel", "assertValidLevel", "", "log", "tag", "", "priority", "message", "throwable", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DebugLogger implements Logger {
    private int level;

    public DebugLogger() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public DebugLogger(int r1) {
        this.level = r1;
        assertValidLevel(r1);
    }

    public /* synthetic */ DebugLogger(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 3;
    L5:
        this(r1);
    }

    @Override // coil.util.Logger
    public int getLevel() {
        return this.level;
    }

    @Override // coil.util.Logger
    public void setLevel(int r1) {
        assertValidLevel(r1);
        this.level = r1;
    }

    @Override // coil.util.Logger
    public void log(String r2, int r3, String r4, Throwable r5) {
        if (r4 == null) goto L4;
        Log.println(r3, r2, r4);
    L4:
        if (r5 == null) goto L7;
        StringWriter r1 = new StringWriter();
        r5.printStackTrace(new PrintWriter(r1));
        Log.println(r3, r2, r1.toString());
        return;
    }

    private final void assertValidLevel(int r2) {
        boolean r0 = false;
        if (2 <= r2) goto L5;
    L7:
        if (r0 == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException(("Invalid log level: " + r2).toString());
    L5:
        if (r2 >= 8) goto L7;
        r0 = true;
        goto L7
    }
}
