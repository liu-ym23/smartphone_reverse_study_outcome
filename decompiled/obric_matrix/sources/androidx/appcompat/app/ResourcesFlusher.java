package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.DoNotInline;
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

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void clear(LongSparseArray r0) {
            r0.clear();
        }
    }

    private ResourcesFlusher() {
    }

    static void flush(@NonNull Resources r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L6;
        return;
    L6:
        if (r0 < 24) goto L9;
        flushNougats(r2);
        return;
    L9:
        if (r0 < 23) goto L12;
        flushMarshmallows(r2);
        return;
    L12:
        if (r0 < 21) goto L17;
        flushLollipops(r2);
        return;
    }

    @RequiresApi(21)
    private static void flushLollipops(@NonNull Resources r4) {
        if (sDrawableCacheFieldFetched == false) goto L20;
    L10:
        Field r0 = sDrawableCacheField;
        if (r0 == null) goto L24;
        Map r2 = null;
        r2 = (Map) r0.get(r4);     // Catch: IllegalAccessException -> L15
    L17:
        if (r2 == null) goto L25;
        r2.clear();
        return;
    L25:
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        goto L17
    L24:
        return;
    L20:
        Field r3 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        sDrawableCacheField = r3;     // Catch: NoSuchFieldException -> L7
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sDrawableCacheFieldFetched = true;
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
        goto L9
    }

    @RequiresApi(23)
    private static void flushMarshmallows(@NonNull Resources r4) {
        if (sDrawableCacheFieldFetched == false) goto L22;
    L10:
        Object r0 = null;
        Field r2 = sDrawableCacheField;
        if (r2 != null) goto L20;
    L16:
        if (r0 != null) goto L18;
        return;
    L18:
        flushThemedResourcesCache(r0);
        return;
    L20:
        r0 = r2.get(r4);     // Catch: IllegalAccessException -> L14
    L14:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        goto L16
    L22:
        Field r3 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        sDrawableCacheField = r3;     // Catch: NoSuchFieldException -> L7
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L7
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
        if (sThemedResourceCacheClazzFetched == false) goto L34;
    L9:
        Class<?> r0 = sThemedResourceCacheClazz;
        if (r0 != null) goto L13;
        return;
    L13:
        if (sThemedResourceCache_mUnthemedEntriesFieldFetched == false) goto L32;
    L19:
        Field r1 = sThemedResourceCache_mUnthemedEntriesField;
        if (r1 != null) goto L22;
        return;
    L22:
        LongSparseArray r2 = null;
        r2 = (LongSparseArray) r1.get(r4);     // Catch: IllegalAccessException -> L25
    L27:
        if (r2 == null) goto L36;
        Api16Impl.clear(r2);
        return;
    L36:
        return;
    L25:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e);
        goto L27
    L32:
        Field r3 = r0.getDeclaredField("mUnthemedEntries");     // Catch: NoSuchFieldException -> L16
        sThemedResourceCache_mUnthemedEntriesField = r3;     // Catch: NoSuchFieldException -> L16
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L16
    L18:
        sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
    L16:
        e = move-exception;
        Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e);
        goto L18
    L34:
        sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");     // Catch: ClassNotFoundException -> L6
    L8:
        sThemedResourceCacheClazzFetched = true;
    L6:
        e = move-exception;
        Log.e(TAG, "Could not find ThemedResourceCache class", e);
        goto L8
    }
}
