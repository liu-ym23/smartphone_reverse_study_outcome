package com.ttnet.org.chromium.base;

import android.content.Context;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@MainDex
public class JNIUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ClassLoader sJniClassLoader;
    private static Boolean sSelectiveJniRegistrationEnabled;

    static {
    }

    public JNIUtils() {
    }

    public static void enableSelectiveJniRegistration() {
        sSelectiveJniRegistrationEnabled = Boolean.TRUE;
    }

    private static ClassLoader getClassLoader() {
        ClassLoader r0 = sJniClassLoader;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return JNIUtils.class.getClassLoader();
    }

    @CalledByNative
    public static ClassLoader getSplitClassLoader(String r2) {
        Context r0 = ContextUtils.getApplicationContext();
        if (TextUtils.isEmpty(r2) == true) goto L9;
        if (BundleUtils.isIsolatedSplitInstalled(r0, r2) == false) goto L9;
        return BundleUtils.createIsolatedSplitContext(r0, r2).getClassLoader();
    L9:
        return getClassLoader();
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled != null) goto L6;
        sSelectiveJniRegistrationEnabled = Boolean.FALSE;
    L6:
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }

    public static void setClassLoader(ClassLoader r0) {
        sJniClassLoader = r0;
    }

    public static <K, V> void splitMap(Map<K, V> r3, K[] r4, V[] r5) {
        int r0 = 0;
        Iterator<Map.Entry<K, V>> r6 = r3.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<K, V> r1 = r6.next();
        r4[r0] = r1.getKey();
        r5[r0] = r1.getValue();
        r0 = r0 + 1;
        goto L4
    }
}
