package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes.dex */
public class PackageManagerHelper {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("PackageManagerHelper");
    }

    private PackageManagerHelper() {
    }

    public static void setComponentEnabled(Context context, Class<?> klazz, boolean enabled) {
        String r0 = "enabled";
        PackageManager r2 = context.getPackageManager();     // Catch: Exception -> L13
        ComponentName r3 = new ComponentName(context, klazz.getName());     // Catch: Exception -> L13
        if (enabled == false) goto L6;
        int r4 = 1;
    L7:
        r2.setComponentEnabledSetting(r3, r4, 1);     // Catch: Exception -> L13
        Logger r5 = Logger.get();     // Catch: Exception -> L13
        String r6 = TAG;     // Catch: Exception -> L13
        StringBuilder r7 = new StringBuilder().append(klazz.getName()).append(" ");     // Catch: Exception -> L13
        if (enabled == false) goto L10;
        String r8 = "enabled";
    L11:
        r5.debug(r6, r7.append(r8).toString());     // Catch: Exception -> L13
        return;
    L10:
        r8 = "disabled";
        goto L11
    L6:
        r4 = 2;
    L13:
        e = move-exception;
        Logger r9 = Logger.get();
        String r10 = TAG;
        StringBuilder r11 = new StringBuilder().append(klazz.getName()).append("could not be ");
        if (enabled == true) goto L18;
        r0 = "disabled";
    L18:
        r9.debug(r10, r11.append(r0).toString(), e);
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> klazz) {
        return isComponentExplicitlyEnabled(context, klazz.getName());
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String className) {
        if (context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, className)) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
