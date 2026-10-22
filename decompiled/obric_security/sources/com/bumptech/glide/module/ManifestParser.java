package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context r1) {
        this.context = r1;
    }

    private ApplicationInfo getOurApplicationInfo() throws PackageManager.NameNotFoundException {
        return this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
    }

    public List<GlideModule> parse() {
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        Log.d(TAG, "Loading Glide modules");
    L5:
        ArrayList r3 = new ArrayList();
        ApplicationInfo r7 = getOurApplicationInfo();     // Catch: PackageManager.NameNotFoundException -> L29
        if (r7 == null) goto L26;
        if (r7.metaData == null) goto L26;
        if (Log.isLoggable(TAG, 2) == false) goto L14;
        Log.v(TAG, "Got app info metadata: " + r7.metaData);     // Catch: PackageManager.NameNotFoundException -> L29
    L14:
        Iterator<String> r0 = r7.metaData.keySet().iterator();     // Catch: PackageManager.NameNotFoundException -> L29
    L16:
        if (r0.hasNext() == false) goto L23;
        String r4 = r0.next();     // Catch: PackageManager.NameNotFoundException -> L29
        if (GLIDE_MODULE_VALUE.equals(r7.metaData.get(r4)) == false) goto L16;
        r3.add(parseModule(r4));     // Catch: PackageManager.NameNotFoundException -> L29
        if (Log.isLoggable(TAG, 3) == false) goto L16;
        Log.d(TAG, "Loaded Glide module: " + r4);     // Catch: PackageManager.NameNotFoundException -> L29
        goto L16
    L23:
        if (Log.isLoggable(TAG, 3) == false) goto L33;
        Log.d(TAG, "Finished loading Glide modules");     // Catch: PackageManager.NameNotFoundException -> L29
    L33:
        return r3;
    L26:
        if (Log.isLoggable(TAG, 3) == false) goto L28;
        Log.d(TAG, "Got null app info metadata");     // Catch: PackageManager.NameNotFoundException -> L29
    L28:
        return r3;
    L29:
        e = move-exception;
        if (Log.isLoggable(TAG, 6) == false) goto L33;
        Log.e(TAG, "Failed to parse glide modules", e);
        goto L33
    }

    private static GlideModule parseModule(String r3) {
        Class<?> r4 = Class.forName(r3);     // Catch: ClassNotFoundException -> L21
        Object r5 = r4.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: InvocationTargetException -> L6 NoSuchMethodException -> L8 IllegalAccessException -> L10 InstantiationException -> L12
    L16:
        if ((r5 instanceof GlideModule) == false) goto L20;
        return (GlideModule) r5;
    L20:
        throw new RuntimeException("Expected instanceof GlideModule, but found: " + r5);
    L10:
        e = move-exception;
        throwInstantiateGlideModuleException(r4, e);
    L14:
        r5 = null;
    L12:
        e = move-exception;
        throwInstantiateGlideModuleException(r4, e);
    L8:
        e = move-exception;
        throwInstantiateGlideModuleException(r4, e);
    L6:
        e = move-exception;
        throwInstantiateGlideModuleException(r4, e);
    L21:
        e = move-exception;
        throw new IllegalArgumentException("Unable to find GlideModule implementation", e);
    }

    private static void throwInstantiateGlideModuleException(Class<?> r3, Exception r4) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + r3, r4);
    }
}
