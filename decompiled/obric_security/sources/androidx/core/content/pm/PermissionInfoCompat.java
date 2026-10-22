package androidx.core.content.pm;

import android.content.pm.PermissionInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionInfoCompat {

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getProtection(PermissionInfo r0) {
            return r0.getProtection();
        }

        static int getProtectionFlags(PermissionInfo r0) {
            return r0.getProtectionFlags();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Protection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
    }

    public static int getProtection(PermissionInfo r0) {
        return Api28Impl.getProtection(r0);
    }

    public static int getProtectionFlags(PermissionInfo r0) {
        return Api28Impl.getProtectionFlags(r0);
    }
}
