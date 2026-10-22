package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi21 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor = null;
    private static final Method sNativeCreateFromTypeface = null;
    private static final Method sNativeCreateWeightAlias = null;
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock = null;

    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = null;

    static {
        Field r0 = null;
        Field r1 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Throwable -> L5
        Class r6 = Long.TYPE;     // Catch: Throwable -> L5
        Class r8 = Integer.TYPE;     // Catch: Throwable -> L5
        Method r2 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_METHOD, new Class[]{r6, r8});     // Catch: Throwable -> L5
        r2.setAccessible(true);     // Catch: Throwable -> L5
        Method r3 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_WEIGHT_ALIAS_METHOD, new Class[]{r6, r8});     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
        Constructor<Typeface> r4 = Typeface.class.getDeclaredConstructor(new Class[]{r6});     // Catch: Throwable -> L5
        r4.setAccessible(true);     // Catch: Throwable -> L5
        r0 = r1;
    L7:
        sNativeInstance = r0;
        sNativeCreateFromTypeface = r2;
        sNativeCreateWeightAlias = r3;
        sConstructor = r4;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r2 = null;
        r3 = null;
        r4 = null;
        goto L7
    }

    private WeightTypefaceApi21() {
    }

    @Nullable
    private static Typeface create(long r4) {
        return sConstructor.newInstance(new Object[]{Long.valueOf(r4)});
    L5:
        return null;
    }

    @Nullable
    static Typeface createWeightStyle(@NonNull Typeface r7, int r8, boolean r9) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r0 = (r8 << 1) | (r9 ? 1 : 0);
        Object r1 = sWeightCacheLock;
        monitor-enter(r1);
        long r2 = getNativeInstance(r7);     // Catch: Throwable -> L23
        LongSparseArray<SparseArray<Typeface>> r4 = sWeightTypefaceCache;     // Catch: Throwable -> L23
        SparseArray<Typeface> r5 = r4.get(r2);     // Catch: Throwable -> L23
        if (r5 != null) goto L11;
        r5 = new SparseArray(4);     // Catch: Throwable -> L23
        r4.put(r2, r5);     // Catch: Throwable -> L23
    L16:
        if (r9 != r7.isItalic()) goto L19;
        long r10 = nativeCreateWeightAlias(r2, r8);     // Catch: Throwable -> L23
    L18:
        Typeface r11 = create(r10);     // Catch: Throwable -> L23
        r5.put(r0 == true ? 1 : 0, r11);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        return r11;
    L19:
        r10 = nativeCreateFromTypefaceWithExactStyle(r2, r8, r9);     // Catch: Throwable -> L23
        goto L18
    L11:
        Typeface r6 = r5.get(r0 == true ? 1 : 0);     // Catch: Throwable -> L23
        if (r6 == null) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L23
        return r6;
    L23:
        th = move-exception;
        throw th;
    }

    private static long getNativeInstance(@NonNull Typeface r2) {
        return sNativeInstance.getLong(r2);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static boolean isPrivateApiAvailable() {
        if (sNativeInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateFromTypefaceWithExactStyle(long r4, int r6, boolean r7) {
        if (r7 == false) goto L5;
        int r8 = 2;
    L14:
        return ((Long) sNativeCreateWeightAlias.invoke(null, new Object[]{Long.valueOf(((Long) sNativeCreateFromTypeface.invoke(null, new Object[]{Long.valueOf(r4), Integer.valueOf(r8)})).longValue()), Integer.valueOf(r6)})).longValue();
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        r8 = 0;
        goto L14
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateWeightAlias(long r4, int r6) {
        return ((Long) sNativeCreateWeightAlias.invoke(null, new Object[]{Long.valueOf(r4), Integer.valueOf(r6)})).longValue();
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
