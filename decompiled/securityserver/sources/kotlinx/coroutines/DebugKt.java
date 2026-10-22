package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DebugKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f370a = false;
    public static final boolean b = false;
    public static final AtomicLong c = null;

    static {
        String r0 = SystemPropsKt.c("kotlinx.coroutines.debug");
        boolean r1 = true;
        if (r0 == null) goto L15;
        int r3 = r0.hashCode();
        if (r3 == 0) goto L23;
        if (r3 == 3551) goto L20;
        if (r3 == 109935) goto L17;
        if (r3 != 3005871) goto L37;
        if (r0.equals("auto") == true) goto L15;
    L37:
        throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + r0 + '\'').toString());
    L17:
        if (r0.equals("off") == false) goto L37;
    L20:
        if (r0.equals("on") == false) goto L37;
    L24:
        boolean r2 = true;
    L25:
        f370a = r2;
        if (r2 == false) goto L33;
        String r4 = SystemPropsKt.c("kotlinx.coroutines.stacktrace.recovery");
        if (r4 == null) goto L30;
        boolean r5 = Boolean.parseBoolean(r4);
    L31:
        if (r5 == false) goto L33;
    L34:
        b = r1;
        c = new AtomicLong(0);
        return;
    L30:
        r5 = true;
    L33:
        r1 = false;
        goto L34
    L23:
        if (r0.equals("") == false) goto L37;
    L15:
        r2 = false;
        goto L25
    }
}
