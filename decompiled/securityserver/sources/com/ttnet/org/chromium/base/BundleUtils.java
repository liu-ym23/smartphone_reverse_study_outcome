package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.build.BuildConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BundleUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LOADED_SPLITS_KEY = "split_compat_loaded_splits";
    private static final String TAG = "BundleUtils";
    private static final SimpleArrayMap<String, ClassLoader> sCachedClassLoaders = null;
    private static final Map<String, ClassLoader> sInflationClassLoaders = null;
    private static Boolean sIsBundle;
    private static SplitCompatClassLoader sSplitCompatClassLoaderInstance;
    private static final Object sSplitLock = null;
    private static ArrayList<String> sSplitsToRestore;

    public static class SplitCompatClassLoader extends ClassLoader {
        public SplitCompatClassLoader() {
            super(ContextUtils.getApplicationContext().getClassLoader());
        }

        private Class<?> checkSplitsClassLoaders(String r2) {
            Iterator r1 = BundleUtils.access$000().values().iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            return ((ClassLoader) r1.next()).loadClass(r2);
        L8:
            return null;
        }

        private void restoreSplitsClassLoaders() {
            Iterator r2 = BundleUtils.access$100().iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            String r0 = (String) r2.next();
            if (BundleUtils.access$000().containsKey(r0) == true) goto L4;
            BundleUtils.registerSplitClassLoaderForInflation(r0);
            goto L4
        L8:
            BundleUtils.access$102(null);
        }

        @Override // java.lang.ClassLoader
        public Class<?> findClass(String r2) {
            Class<?> r0 = checkSplitsClassLoaders(r2);
            if (r0 == null) goto L6;
            return r0;
        L6:
            if (BundleUtils.access$100() == null) goto L13;
            if (r2.startsWith("android.") == true) goto L13;
            restoreSplitsClassLoaders();
            Class<?> r1 = checkSplitsClassLoaders(r2);
            if (r1 == null) goto L13;
            return r1;
        L13:
            throw new ClassNotFoundException(r2);
        }
    }

    static {
        sSplitLock = new Object();
        sCachedClassLoaders = new SimpleArrayMap();
        sInflationClassLoaders = Collections.synchronizedMap(new ArrayMap());
    }

    public BundleUtils() {
    }

    public static /* synthetic */ Map access$000() {
        return sInflationClassLoaders;
    }

    public static /* synthetic */ ArrayList access$100() {
        return sSplitsToRestore;
    }

    public static /* synthetic */ ArrayList access$102(ArrayList r0) {
        sSplitsToRestore = r0;
        return r0;
    }

    public static boolean canLoadClass(ClassLoader r1, String r2) {
        Class.forName(r2, false, r1);     // Catch: ClassNotFoundException -> L6
        return true;
    L6:
        return false;
    }

    public static void checkContextClassLoader(Context r3, Activity r4) {
        ClassLoader r0 = r4.getClass().getClassLoader();
        if (r0 == r3.getClassLoader()) goto L6;
        Log.w(TAG, "Mismatched ClassLoaders between Activity and context (fixing): %s", new Object[]{r4.getClass()});
        replaceClassLoader(r3, r0);
        return;
    }

    public static Context createContextForInflation(final Context r1, String r2) {
        if (isIsolatedSplitInstalled(r1, r2) == true) goto L5;
        return r1;
    L5:
        final ClassLoader r3 = registerSplitClassLoaderForInflation(r2);
        return new AnonymousClass1(r1, r3);
    }

    public static Context createIsolatedSplitContext(Context r0, String r1) {
        return r0;
    }

    @Nullable
    @CalledByNative
    public static String getNativeLibraryPath(String r0, String r1) {
        return "";
    }

    @Nullable
    private static String getSplitApkLibraryPath(String r3, String r4) {
        ApplicationInfo r0 = ContextUtils.getApplicationContext().getApplicationInfo();
        String[] r1 = ApiHelperForO.getSplitNames(r0);
        if (r1 != null) goto L5;
        return null;
    L5:
        int r5 = Arrays.binarySearch(r1, r4);
        if (r5 >= 0) goto L13;
        return null;
    L13:
        return r0.splitSourceDirs[r5] + "!/lib/" + ((String) r0.getClass().getField("primaryCpuAbi").get(r0)) + LibrarianImpl.Constants.SEPARATOR + System.mapLibraryName(r3);
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static ClassLoader getSplitCompatClassLoader() {
        if (sSplitCompatClassLoaderInstance != null) goto L6;
        sSplitCompatClassLoaderInstance = new SplitCompatClassLoader();
    L6:
        return sSplitCompatClassLoaderInstance;
    }

    public static Object getSplitContextLock() {
        return sSplitLock;
    }

    private static boolean isApplicationContext(Context r1) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L9;
        if ((r1 instanceof Application) == true) goto L6;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isBundle() {
        if (BuildConfig.BUNDLES_SUPPORTED == true) goto L7;
        return false;
    L7:
        return sIsBundle.booleanValue();
    }

    @CalledByNative
    public static boolean isBundleForNative() {
        return isBundle();
    }

    public static boolean isIsolatedSplitInstalled(Context r0, String r1) {
        String[] r2 = ApiHelperForO.getSplitNames(r0.getApplicationInfo());
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.asList(r2).contains(r1) == false) goto L7;
        return true;
    }

    public static boolean isolatedSplitsEnabled() {
        return BuildConfig.ISOLATED_SPLITS_ENABLED;
    }

    public static Object newInstance(Context r2, String r3) {
        Context r0 = ContextUtils.getApplicationContext();
        if (r0 != null) goto L5;
    L12:
        return r2.getClassLoader().loadClass(r3).newInstance();
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if (canLoadClass(r0.getClassLoader(), r3) == false) goto L12;
        r2 = r0;
        goto L12
    }

    public static ClassLoader registerSplitClassLoaderForInflation(String r2) {
        Map<String, ClassLoader> r0 = sInflationClassLoaders;
        ClassLoader r1 = r0.get(r2);
        if (r1 != null) goto L6;
        ClassLoader r3 = createIsolatedSplitContext(ContextUtils.getApplicationContext(), r2).getClassLoader();
        r0.put(r2, r3);
        return r3;
    L6:
        return r1;
    }

    public static void replaceClassLoader(Context r2, ClassLoader r3) {
    L3:
        if ((r2 instanceof ContextWrapper) == false) goto L10;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L3
    L10:
        Field r0 = r2.getClass().getDeclaredField("mClassLoader");     // Catch: ReflectiveOperationException -> L7
        r0.setAccessible(true);     // Catch: ReflectiveOperationException -> L7
        r0.set(r2, r3);     // Catch: ReflectiveOperationException -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("Error setting ClassLoader.", e);
    }

    public static void restoreLoadedSplits(Bundle r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        sSplitsToRestore = r1.getStringArrayList(LOADED_SPLITS_KEY);
    }

    public static void saveLoadedSplits(Bundle r2) {
        r2.putStringArrayList(LOADED_SPLITS_KEY, new ArrayList(sInflationClassLoaders.keySet()));
    }

    public static void setIsBundle(boolean r0) {
        sIsBundle = Boolean.valueOf(r0);
    }

    @Nullable
    public static String getNativeLibraryPath(String r1) {
        return getNativeLibraryPath(r1, "");
    }
}
