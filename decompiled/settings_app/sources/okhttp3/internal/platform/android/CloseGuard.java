package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloseGuard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/platform/android/CloseGuard;", "", "getMethod", "Ljava/lang/reflect/Method;", "openMethod", "warnIfOpenMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "createAndOpen", "closer", "", "warnIfOpen", "", "closeGuardInstance", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CloseGuard {
    public static final Companion Companion = null;
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    /* JADX INFO: compiled from: CloseGuard.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/android/CloseGuard$Companion;", "", "()V", "get", "Lokhttp3/internal/platform/android/CloseGuard;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final CloseGuard get() {
            Class<?> r5 = Class.forName("dalvik.system.CloseGuard");     // Catch: Exception -> L4
            Method r0 = r5.getMethod("get", new Class[0]);     // Catch: Exception -> L4
            Method r2 = r5.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L4
            Method r6 = r5.getMethod("warnIfOpen", new Class[0]);     // Catch: Exception -> L4
        L6:
            return new CloseGuard(r0, r2, r6);
        L4:
            r0 = null;
            r6 = null;
            r2 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CloseGuard(Method r1, Method r2, Method r3) {
        this.getMethod = r1;
        this.openMethod = r2;
        this.warnIfOpenMethod = r3;
    }

    public final Object createAndOpen(String r5) {
        Intrinsics.checkNotNullParameter(r5, "closer");
        Method r0 = this.getMethod;
        if (r0 != null) goto L9;
    L7:
        return null;
    L9:
        Object r1 = r0.invoke(null, new Object[0]);     // Catch: Exception -> L8
        Method r4 = this.openMethod;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L8
        r4.invoke(r1, new Object[]{r5});     // Catch: Exception -> L8
        return r1;
    }

    public final boolean warnIfOpen(Object r3) {
        if (r3 == null) goto L10;
        Method r2 = this.warnIfOpenMethod;     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L7
        r2.invoke(r3, new Object[0]);     // Catch: Exception -> L7
        return true;
    L11:
        return false;
    L10:
        return false;
    }
}
