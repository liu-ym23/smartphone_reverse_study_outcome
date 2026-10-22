package androidx.appcompat.app;

import android.content.res.Resources;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class<?> sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    private ResourcesFlusher() {
    }

    public static void flush(@NonNull Resources r0) {
    }

    @RequiresApi(21)
    private static void flushLollipops(@NonNull Resources r4) {
        if (sDrawableCacheFieldFetched == false) goto L21;
    L10:
        Field r0 = sDrawableCacheField;
        if (r0 == null) goto L23;
        Map r5 = (Map) r0.get(r4);     // Catch: IllegalAccessException -> L14
    L16:
        if (r5 == null) goto L24;
        r5.clear();
        return;
    L24:
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        r5 = null;
        goto L16
    L23:
        return;
    L21:
        Field r2 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        sDrawableCacheField = r2;     // Catch: NoSuchFieldException -> L7
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sDrawableCacheFieldFetched = true;
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
        goto L9
    }

    @RequiresApi(23)
    private static void flushMarshmallows(@NonNull Resources r4) {
        if (sDrawableCacheFieldFetched == false) goto L23;
    L10:
        Field r0 = sDrawableCacheField;
        if (r0 != null) goto L21;
    L16:
        Object r5 = null;
    L17:
        if (r5 != null) goto L19;
        return;
    L19:
        flushThemedResourcesCache(r5);
        return;
    L21:
        r5 = r0.get(r4);     // Catch: IllegalAccessException -> L14
    L14:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        goto L16
    L23:
        Field r2 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        sDrawableCacheField = r2;     // Catch: NoSuchFieldException -> L7
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sDrawableCacheFieldFetched = true;
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
        goto L9
    }

    @RequiresApi(24)
    private static void flushNougats(@NonNull Resources r5) {
        if (sResourcesImplFieldFetched == false) goto L41;
    L9:
        Field r0 = sResourcesImplField;
        if (r0 != null) goto L12;
        return;
    L12:
        Object r3 = null;
        Object r6 = r0.get(r5);     // Catch: IllegalAccessException -> L15
    L17:
        if (r6 != null) goto L20;
        return;
    L20:
        if (sDrawableCacheFieldFetched == false) goto L35;
    L26:
        Field r1 = sDrawableCacheField;
        if (r1 != null) goto L39;
    L32:
        if (r3 == null) goto L43;
        flushThemedResourcesCache(r3);
        return;
    L43:
        return;
    L39:
        r3 = r1.get(r6);     // Catch: IllegalAccessException -> L30
    L30:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from ResourcesImpl#mDrawableCache", e);
        goto L32
    L35:
        Field r2 = r6.getClass().getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L23
        sDrawableCacheField = r2;     // Catch: NoSuchFieldException -> L23
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L25:
        sDrawableCacheFieldFetched = true;
    L23:
        e = move-exception;
        Log.e(TAG, "Could not retrieve ResourcesImpl#mDrawableCache field", e);
    L15:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mResourcesImpl", e);
        r6 = null;
        goto L17
    L41:
        Field r4 = Resources.class.getDeclaredField("mResourcesImpl");     // Catch: NoSuchFieldException -> L6
        sResourcesImplField = r4;     // Catch: NoSuchFieldException -> L6
        r4.setAccessible(true);     // Catch: NoSuchFieldException -> L6
    L8:
        sResourcesImplFieldFetched = true;
    L6:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mResourcesImpl field", e);
        goto L8
    }

    @RequiresApi(16)
    private static void flushThemedResourcesCache(@NonNull Object r4) {
        if (sThemedResourceCacheClazzFetched == false) goto L33;
    L9:
        Class<?> r0 = sThemedResourceCacheClazz;
        if (r0 != null) goto L13;
        return;
    L13:
        if (sThemedResourceCache_mUnthemedEntriesFieldFetched == false) goto L29;
    L19:
        Field r1 = sThemedResourceCache_mUnthemedEntriesField;
        if (r1 != null) goto L31;
        return;
    L31:
        LongSparseArray r5 = (LongSparseArray) r1.get(r4);     // Catch: IllegalAccessException -> L24
    L26:
        if (r5 == null) goto L35;
        r5.clear();
        return;
    L35:
        return;
    L24:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e);
        r5 = null;
        goto L26
    L29:
        Field r2 = r0.getDeclaredField("mUnthemedEntries");     // Catch: NoSuchFieldException -> L16
        sThemedResourceCache_mUnthemedEntriesField = r2;     // Catch: NoSuchFieldException -> L16
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L16
    L18:
        sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
    L16:
        e = move-exception;
        Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e);
        goto L18
    L33:
        sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");     // Catch: ClassNotFoundException -> L6
    L8:
        sThemedResourceCacheClazzFetched = true;
    L6:
        e = move-exception;
        Log.e(TAG, "Could not find ThemedResourceCache class", e);
        goto L8
    }
}
