package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CronetProvider {
    private static final String GMS_CORE_CRONET_PROVIDER_CLASS = "com.google.android.gms.net.GmsCoreCronetProvider";
    private static final String JAVA_CRONET_PROVIDER_CLASS = "com.ttnet.org.chromium.net.impl.JavaCronetProvider";
    private static final String NATIVE_CRONET_PROVIDER_CLASS = "com.ttnet.org.chromium.net.impl.NativeCronetProvider";
    private static final String PLAY_SERVICES_CRONET_PROVIDER_CLASS = "com.google.android.gms.net.PlayServicesCronetProvider";
    public static final String PROVIDER_NAME_APP_PACKAGED = "App-Packaged-Cronet-Provider";
    public static final String PROVIDER_NAME_FALLBACK = "Fallback-Cronet-Provider";
    private static final String RES_KEY_CRONET_IMPL_CLASS = "CronetProviderClassName";
    private static final String TAG = "CronetProvider";
    protected final Context mContext;

    static {
    }

    public abstract CronetEngine.Builder createBuilder(boolean r1);

    public abstract String getName();

    public abstract String getVersion();

    public abstract boolean isEnabled();

    protected CronetProvider(Context r1) {
        if (r1 == null) goto L7;
        this.mContext = r1;
        return;
    L7:
        throw new IllegalArgumentException("Context must not be null");
    }

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + getName() + ", version=" + getVersion() + ", enabled=" + isEnabled() + "]";
    }

    public static List<CronetProvider> getAllProviders(Context r2, boolean r3) {
        LinkedHashSet r0 = new LinkedHashSet();
        if (r3 == true) goto L5;
        addCronetProviderFromResourceFile(r2, r0);
        addCronetProviderImplByClassName(r2, PLAY_SERVICES_CRONET_PROVIDER_CLASS, r0, false);
        addCronetProviderImplByClassName(r2, GMS_CORE_CRONET_PROVIDER_CLASS, r0, false);
        addCronetProviderImplByClassName(r2, JAVA_CRONET_PROVIDER_CLASS, r0, false);
    L5:
        addCronetProviderImplByClassName(r2, NATIVE_CRONET_PROVIDER_CLASS, r0, false);
        return Collections.unmodifiableList(new ArrayList(r0));
    }

    private static boolean addCronetProviderImplByClassName(Context r5, String r6, Set<CronetProvider> r7, boolean r8) {
        r7.add((CronetProvider) r5.getClassLoader().loadClass(r6).asSubclass(CronetProvider.class).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r5}));     // Catch: ClassNotFoundException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 InvocationTargetException -> L11 InstantiationException -> L13
        return true;
    L5:
        e = move-exception;
        logReflectiveOperationException(r6, r8, e);
    L15:
        return false;
    L7:
        e = move-exception;
        logReflectiveOperationException(r6, r8, e);
    L13:
        e = move-exception;
        logReflectiveOperationException(r6, r8, e);
    L9:
        e = move-exception;
        logReflectiveOperationException(r6, r8, e);
    L11:
        e = move-exception;
        logReflectiveOperationException(r6, r8, e);
        goto L15
    }

    private static void logReflectiveOperationException(String r2, boolean r3, Exception r4) {
        if (r3 == false) goto L4;
        Log.e(TAG, "Unable to load provider class: " + r2, r4);
        return;
    L4:
        String r5 = TAG;
        if (Log.isLoggable(r5, 3) == false) goto L9;
        Log.d(r5, "Tried to load " + r2 + " provider class but it wasn't included in the app classpath");
        return;
    }

    private static boolean addCronetProviderFromResourceFile(Context r4, Set<CronetProvider> r5) {
        int r0 = r4.getResources().getIdentifier(RES_KEY_CRONET_IMPL_CLASS, "string", r4.getPackageName());
        boolean r1 = false;
        if (r0 != 0) goto L5;
        return false;
    L5:
        String r2 = r4.getResources().getString(r0);
        if (r2 != null) goto L8;
    L19:
        return r1;
    L8:
        if (r2.equals(PLAY_SERVICES_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r2.equals(GMS_CORE_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r2.equals(JAVA_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r2.equals(NATIVE_CRONET_PROVIDER_CLASS) == true) goto L19;
        r1 = true;
        if (addCronetProviderImplByClassName(r4, r2, r5, true) == true) goto L19;
        Log.e(TAG, "Unable to instantiate Cronet implementation class " + r2 + " that is listed as in the app string resource file under CronetProviderClassName key");
        goto L19
    }
}
