package h.a;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0081\b\u001a\b\u0010\u0016\u001a\u00020\u0013H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0003\"\u000e\u0010\u0011\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f17556a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f17557b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f17558c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLong f17559d = null;

    static {
        String r0 = h.a.f3.g0.d("kotlinx.coroutines.debug");
        boolean r1 = false;
        if (r0 == null) goto L26;
        int r3 = r0.hashCode();
        if (r3 == 0) goto L22;
        if (r3 == 3551) goto L19;
        if (r3 == 109935) goto L16;
        if (r3 != 3005871) goto L25;
        if (r0.equals("auto") == true) goto L26;
    L25:
        throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + r0 + '\'').toString());
    L16:
        if (r0.equals("off") == false) goto L25;
        boolean r2 = false;
    L27:
        f17557b = r2;
        if (r2 == true) goto L30;
    L32:
        f17558c = r1;
        f17559d = new AtomicLong(0);
        return;
    L30:
        if (h.a.f3.g0.e("kotlinx.coroutines.stacktrace.recovery", true) == false) goto L32;
        r1 = true;
        goto L32
    L19:
        if (r0.equals("on") == false) goto L25;
    L23:
        r2 = true;
        goto L27
    L22:
        if (r0.equals("") == false) goto L25;
    L26:
        r2 = a();
        goto L27
    }

    public static final boolean a() {
        return f17556a;
    }

    public static final AtomicLong b() {
        return f17559d;
    }

    public static final boolean c() {
        return f17557b;
    }

    public static final boolean d() {
        return f17558c;
    }
}
