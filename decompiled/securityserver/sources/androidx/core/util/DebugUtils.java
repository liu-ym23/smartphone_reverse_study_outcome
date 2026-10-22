package androidx.core.util;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(Object r2, StringBuilder r3) {
        if (r2 != null) goto L4;
        r3.append("null");
        return;
    L4:
        String r0 = r2.getClass().getSimpleName();
        if (r0.length() > 0) goto L9;
        r0 = r2.getClass().getName();
        int r1 = r0.lastIndexOf(46);
        if (r1 <= 0) goto L9;
        r0 = r0.substring(r1 + 1);
    L9:
        r3.append(r0);
        r3.append('{');
        r3.append(Integer.toHexString(System.identityHashCode(r2)));
    }
}
