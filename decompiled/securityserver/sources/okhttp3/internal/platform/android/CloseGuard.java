package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CloseGuard {
    public static final Companion Companion = null;
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CloseGuard get() {
            Method r4 = null;
            Class<?> r0 = Class.forName("dalvik.system.CloseGuard");     // Catch: Exception -> L5
            Method r1 = r0.getMethod("get", null);     // Catch: Exception -> L5
            Method r2 = r0.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L5
            Method r3 = r0.getMethod("warnIfOpen", null);     // Catch: Exception -> L5
            r4 = r1;
        L7:
            return new CloseGuard(r4, r2, r3);
        L5:
            r3 = null;
            r2 = null;
            goto L7
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CloseGuard(@Nullable Method r1, @Nullable Method r2, @Nullable Method r3) {
        this.getMethod = r1;
        this.openMethod = r2;
        this.warnIfOpenMethod = r3;
    }

    @Nullable
    public final Object createAndOpen(@NotNull String r3) {
        Intrinsics.f(r3, "closer");
        Method r0 = this.getMethod;
        if (r0 != null) goto L8;
    L6:
        return null;
    L8:
        Object r1 = r0.invoke(null, null);     // Catch: Exception -> L7
        Method r2 = this.openMethod;     // Catch: Exception -> L7
        Intrinsics.c(r2);     // Catch: Exception -> L7
        r2.invoke(r1, new Object[]{r3});     // Catch: Exception -> L7
        return r1;
    }

    public final boolean warnIfOpen(@Nullable Object r2) {
        if (r2 != null) goto L8;
    L5:
        return false;
    L8:
        Method r1 = this.warnIfOpenMethod;     // Catch: Exception -> L7
        Intrinsics.c(r1);     // Catch: Exception -> L7
        r1.invoke(r2, null);     // Catch: Exception -> L7
        return true;
    }
}
