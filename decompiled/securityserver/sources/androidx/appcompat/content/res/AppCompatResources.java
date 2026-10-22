package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources {
    private static final String LOG_TAG = "AppCompatResources";
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = null;
    private static final Object sColorStateCacheLock = null;
    private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = null;

    public static class ColorStateListCacheEntry {
        final Configuration configuration;
        final ColorStateList value;

        public ColorStateListCacheEntry(@NonNull ColorStateList r1, @NonNull Configuration r2) {
            this.value = r1;
            this.configuration = r2;
        }
    }

    static {
        TL_TYPED_VALUE = new ThreadLocal();
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }

    private AppCompatResources() {
    }

    private static void addColorStateListToCache(@NonNull Context r3, @ColorRes int r4, @NonNull ColorStateList r5) {
        Object r0 = sColorStateCacheLock;
        monitor-enter(r0);
        WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> r1 = sColorStateCaches;     // Catch: Throwable -> L7
        SparseArray<ColorStateListCacheEntry> r2 = r1.get(r3);     // Catch: Throwable -> L7
        if (r2 != null) goto L9;
        r2 = new SparseArray();     // Catch: Throwable -> L7
        r1.put(r3, r2);     // Catch: Throwable -> L7
    L9:
        r2.append(r4, new ColorStateListCacheEntry(r5, r3.getResources().getConfiguration()));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Nullable
    private static ColorStateList getCachedColorStateList(@NonNull Context r4, @ColorRes int r5) {
        Object r0 = sColorStateCacheLock;
        monitor-enter(r0);
        SparseArray<ColorStateListCacheEntry> r1 = sColorStateCaches.get(r4);     // Catch: Throwable -> L15
        if (r1 != null) goto L7;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return null;
    L7:
        if (r1.size() <= 0) goto L18;
        ColorStateListCacheEntry r2 = r1.get(r5);     // Catch: Throwable -> L15
        if (r2 == null) goto L18;
        if (r2.configuration.equals(r4.getResources().getConfiguration()) == false) goto L17;
        ColorStateList r6 = r2.value;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r6;
    L17:
        r1.remove(r5);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public static ColorStateList getColorStateList(@NonNull Context r0, @ColorRes int r1) {
        return r0.getColorStateList(r1);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r1, @DrawableRes int r2) {
        return ResourceManagerInternal.get().getDrawable(r1, r2);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r0 = TL_TYPED_VALUE;
        TypedValue r1 = r0.get();
        if (r1 != null) goto L6;
        TypedValue r2 = new TypedValue();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Context r2, int r3) {
        if (isColorInt(r2, r3) == false) goto L5;
        return null;
    L5:
        Resources r0 = r2.getResources();
        XmlResourceParser r4 = r0.getXml(r3);
        return ColorStateListInflaterCompat.createFromXml(r0, r4, r2.getTheme());
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
        return null;
    }

    private static boolean isColorInt(@NonNull Context r2, @ColorRes int r3) {
        Resources r4 = r2.getResources();
        TypedValue r0 = getTypedValue();
        r4.getValue(r3, r0, true);
        int r5 = r0.type;
        if (r5 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r5 > 31) goto L7;
        return true;
    }
}
