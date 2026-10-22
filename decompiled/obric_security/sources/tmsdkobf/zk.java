package tmsdkobf;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zk {
    public static boolean a(AccessibilityServiceInfo r5) {
        ResolveInfo r6 = r5.getResolveInfo();
        if (r6 == null) goto L34;
        ServiceInfo r7 = r6.serviceInfo;
        if (r7 == null) goto L34;
        ApplicationInfo r8 = r7.applicationInfo;
        if (r8 == null) goto L34;
        if (r8.uid >= 10000) goto L13;
        return true;
    L13:
        if (TextUtils.isEmpty(r8.sourceDir) == false) goto L15;
    L17:
        Object r4 = null;
        Field r1 = ApplicationInfo.class.getDeclaredField("seInfo");     // Catch: Throwable -> L36
        if (r1 == null) goto L23;
        r1.setAccessible(true);     // Catch: Throwable -> L36
    L24:
        if (r1 == null) goto L28;
        r4 = r1.get(r8);     // Catch: Throwable -> L35
    L28:
        if ((r4 instanceof String) == false) goto L34;
        String r9 = (String) r4;
        if (r9.contains("partition=product") == false) goto L32;
    L33:
        return true;
    L32:
        if (r9.contains("partition=system_ext") == false) goto L34;
    L23:
        r1 = null;
        goto L24
    L15:
        if (r8.sourceDir.startsWith("/data/") == true) goto L17;
        return true;
    L34:
        return false;
    }

    public static void a(StringBuilder r2, AccessibilityServiceInfo r3) {
        r2.append(Integer.toHexString(r3.eventTypes));
        r2.append(":");
        r2.append(Integer.toHexString(r3.feedbackType));
        r2.append(":");
        r2.append(Integer.toHexString(r3.flags));
        r2.append(":");
        r2.append(Integer.toHexString(r3.getCapabilities()));
        r2.append(":");
        r2.append(r3.getId());
    }
}
