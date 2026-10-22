package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ResourcesCompat {

    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock = null;

    @GuardedBy("sColorStateCacheLock")
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = null;
    private static final ThreadLocal<TypedValue> sTempTypedValue = null;

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static Drawable getDrawableForDensity(Resources r0, int r1, int r2) {
            return r0.getDrawableForDensity(r1, r2);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Drawable getDrawable(Resources r0, int r1, Resources.Theme r2) {
            return r0.getDrawable(r1, r2);
        }

        @DoNotInline
        static Drawable getDrawableForDensity(Resources r0, int r1, int r2, Resources.Theme r3) {
            return r0.getDrawableForDensity(r1, r2, r3);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getColor(Resources r0, int r1, Resources.Theme r2) {
            return r0.getColor(r1, r2);
        }

        @NonNull
        @DoNotInline
        static ColorStateList getColorStateList(@NonNull Resources r0, @ColorRes int r1, @Nullable Resources.Theme r2) {
            return r0.getColorStateList(r1, r2);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static float getFloat(@NonNull Resources r0, @DimenRes int r1) {
            return r0.getFloat(r1);
        }
    }

    private static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        ColorStateListCacheEntry(@NonNull ColorStateList r1, @NonNull Configuration r2, @Nullable Resources.Theme r3) {
            this.mValue = r1;
            this.mConfiguration = r2;
            if (r3 != null) goto L5;
            int r4 = 0;
        L6:
            this.mThemeHash = r4;
            return;
        L5:
            r4 = r3.hashCode();
            goto L6
        }
    }

    private static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        ColorStateListCacheKey(@NonNull Resources r1, @Nullable Resources.Theme r2) {
            this.mResources = r1;
            this.mTheme = r2;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (ColorStateListCacheKey.class != r5.getClass()) goto L17;
            ColorStateListCacheKey r6 = (ColorStateListCacheKey) r5;
            if (this.mResources.equals(r6.mResources) == false) goto L16;
            if (ObjectsCompat.equals(this.mTheme, r6.mTheme) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mResources, this.mTheme});
        }
    }

    public static abstract class FontCallback {
        public FontCallback() {
        }

        private /* synthetic */ void a(int r1) {
            onFontRetrievalFailed(r1);
        }

        private /* synthetic */ void c(Typeface r1) {
            onFontRetrieved(r1);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler r1) {
            if (r1 == null) goto L4;
            return r1;
        L4:
            return new Handler(Looper.getMainLooper());
        }

        public /* synthetic */ void b(int r1) {
            a(r1);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(final int r2, @Nullable Handler r3) {
            getHandler(r3).post(new a(this, r2));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(@NonNull final Typeface r2, @Nullable Handler r3) {
            getHandler(r3).post(new b(this, r2));
        }

        public /* synthetic */ void d(Typeface r1) {
            c(r1);
        }

        public abstract void onFontRetrievalFailed(int r1);

        public abstract void onFontRetrieved(@NonNull Typeface r1);
    }

    public static final class ThemeCompat {

        @RequiresApi(23)
        static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = null;

            static {
                sRebaseMethodLock = new Object();
            }

            private Api23Impl() {
            }

            @SuppressLint({"BanUncheckedReflection"})
            static void rebase(@NonNull Resources.Theme r6) {
                Object r0 = sRebaseMethodLock;
                monitor-enter(r0);
            L21:
                th = move-exception;
                throw th;
            L6:
                if (sRebaseMethodFetched == false) goto L24;
            L13:
                Method r1 = sRebaseMethod;     // Catch: Throwable -> L21
                if (r1 != null) goto L26;
            L19:
                monitor-exit(r0);     // Catch: Throwable -> L21
                return;
            L26:
                r1.invoke(r6, new Object[0]);     // Catch: Throwable -> L17 Throwable -> L21
            L17:
                e = move-exception;
                Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e);     // Catch: Throwable -> L21
                sRebaseMethod = null;     // Catch: Throwable -> L21
                goto L19
            L24:
                Method r3 = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);     // Catch: NoSuchMethodException -> L10 Throwable -> L21
                sRebaseMethod = r3;     // Catch: NoSuchMethodException -> L10 Throwable -> L21
                r3.setAccessible(true);     // Catch: NoSuchMethodException -> L10 Throwable -> L21
            L12:
                sRebaseMethodFetched = true;     // Catch: Throwable -> L21
                goto L13
            L10:
                e = move-exception;
                Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e);     // Catch: Throwable -> L21
                goto L12
            }
        }

        @RequiresApi(29)
        static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            static void rebase(@NonNull Resources.Theme r0) {
                r0.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme r2) {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 29) goto L6;
            Api29Impl.rebase(r2);
            return;
        L6:
            if (r0 < 23) goto L10;
            Api23Impl.rebase(r2);
            return;
        }
    }

    static {
        sTempTypedValue = new ThreadLocal();
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }

    private ResourcesCompat() {
    }

    private static void addColorStateListToCache(@NonNull ColorStateListCacheKey r3, @ColorRes int r4, @NonNull ColorStateList r5, @Nullable Resources.Theme r6) {
        Object r0 = sColorStateCacheLock;
        monitor-enter(r0);
        WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> r1 = sColorStateCaches;     // Catch: Throwable -> L10
        SparseArray<ColorStateListCacheEntry> r2 = r1.get(r3);     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = new SparseArray();     // Catch: Throwable -> L10
        r1.put(r3, r2);     // Catch: Throwable -> L10
    L7:
        r2.append(r4, new ColorStateListCacheEntry(r5, r3.mResources.getConfiguration(), r6));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void clearCachesForTheme(@NonNull Resources.Theme r3) {
        Object r0 = sColorStateCacheLock;
        monitor-enter(r0);
        Iterator<ColorStateListCacheKey> r1 = sColorStateCaches.keySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L12;
        ColorStateListCacheKey r2 = r1.next();     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        if (r3.equals(r2.mTheme) == false) goto L6;
        r1.remove();     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Nullable
    private static ColorStateList getCachedColorStateList(@NonNull ColorStateListCacheKey r5, @ColorRes int r6) {
        Object r0 = sColorStateCacheLock;
        monitor-enter(r0);
        SparseArray<ColorStateListCacheEntry> r1 = sColorStateCaches.get(r5);     // Catch: Throwable -> L26
        if (r1 != null) goto L7;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L26
        return null;
    L7:
        if (r1.size() <= 0) goto L23;
        ColorStateListCacheEntry r2 = r1.get(r6);     // Catch: Throwable -> L26
        if (r2 == null) goto L23;
        if (r2.mConfiguration.equals(r5.mResources.getConfiguration()) == false) goto L22;
        Resources.Theme r7 = r5.mTheme;     // Catch: Throwable -> L26
        if (r7 == null) goto L15;
    L16:
        if (r7 == null) goto L22;
        if (r2.mThemeHash != r7.hashCode()) goto L22;
    L19:
        ColorStateList r8 = r2.mValue;     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r8;
    L15:
        if (r2.mThemeHash == 0) goto L19;
    L22:
        r1.remove(r6);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context r8, @FontRes int r9) {
        if (r8.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r8, r9, new TypedValue(), 0, null, null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources r2, @ColorRes int r3, @Nullable Resources.Theme r4) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getColor(r2, r3, r4);
    L7:
        return r2.getColor(r3);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources r2, @ColorRes int r3, @Nullable Resources.Theme r4) {
        ColorStateListCacheKey r0 = new ColorStateListCacheKey(r2, r4);
        ColorStateList r1 = getCachedColorStateList(r0, r3);
        if (r1 == null) goto L5;
        return r1;
    L5:
        ColorStateList r5 = inflateColorStateList(r2, r3, r4);
        if (r5 == null) goto L10;
        addColorStateListToCache(r0, r3, r5, r4);
        return r5;
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        return Api23Impl.getColorStateList(r2, r3, r4);
    L14:
        return r2.getColorStateList(r3);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources r2, @DrawableRes int r3, @Nullable Resources.Theme r4) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getDrawable(r2, r3, r4);
    L7:
        return r2.getDrawable(r3);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources r2, @DrawableRes int r3, int r4, @Nullable Resources.Theme r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L7;
        return Api21Impl.getDrawableForDensity(r2, r3, r4, r5);
    L7:
        if (r0 < 15) goto L11;
        return Api15Impl.getDrawableForDensity(r2, r3, r4);
    L11:
        return r2.getDrawable(r3);
    }

    public static float getFloat(@NonNull Resources r3, @DimenRes int r4) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        TypedValue r0 = getTypedValue();
        r3.getValue(r4, r0, true);
        if (r0.type != 4) goto L11;
        return r0.getFloat();
    L11:
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(r4) + " type #0x" + Integer.toHexString(r0.type) + " is not valid");
    L5:
        return Api29Impl.getFloat(r3, r4);
    }

    @Nullable
    public static Typeface getFont(@NonNull Context r8, @FontRes int r9) {
        if (r8.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r8, r9, new TypedValue(), 0, null, null, false, false);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context r8, @FontRes int r9, @NonNull TypedValue r10, int r11, @Nullable FontCallback r12) {
        if (r8.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r8, r9, r10, r11, r12, null, true, false);
    }

    public static void getFont(@NonNull Context r8, @FontRes int r9, @NonNull FontCallback r10, @Nullable Handler r11) {
        Preconditions.checkNotNull(r10);
        if (r8.isRestricted() == false) goto L6;
        r10.callbackFailAsync(-4, r11);
        return;
    L6:
        loadFont(r8, r9, new TypedValue(), 0, r10, r11, false, false);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r0 = sTempTypedValue;
        TypedValue r1 = r0.get();
        if (r1 != null) goto L6;
        TypedValue r2 = new TypedValue();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Resources r2, int r3, @Nullable Resources.Theme r4) {
        if (isColorInt(r2, r3) == false) goto L11;
        return null;
    L11:
        return ColorStateListInflaterCompat.createFromXml(r2, r2.getXml(r3), r4);
    L8:
        e = move-exception;
        Log.w(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
        return null;
    }

    private static boolean isColorInt(@NonNull Resources r2, @ColorRes int r3) {
        TypedValue r0 = getTypedValue();
        r2.getValue(r3, r0, true);
        int r4 = r0.type;
        if (r4 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r4 > 31) goto L7;
        return true;
    }

    private static Typeface loadFont(@NonNull Context r10, int r11, @NonNull TypedValue r12, int r13, @Nullable FontCallback r14, @Nullable Handler r15, boolean r16, boolean r17) {
        Resources r1 = r10.getResources();
        r1.getValue(r11, r12, true);
        Typeface r0 = loadFont(r10, r1, r12, r11, r13, r14, r15, r16, r17);
        if (r0 != null) goto L9;
        if (r14 != null) goto L9;
        if (r17 == true) goto L9;
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(r11) + " could not be retrieved.");
    L9:
        return r0;
    }

    private static Typeface loadFont(@NonNull Context r17, Resources r18, @NonNull TypedValue r19, int r20, int r21, @Nullable FontCallback r22, @Nullable Handler r23, boolean r24, boolean r25) {
        CharSequence r2 = r19.string;
        if (r2 == null) goto L41;
        String r14 = r2.toString();
        if (r14.startsWith("res/") == true) goto L9;
        if (r22 == null) goto L8;
        r22.callbackFailAsync(-3, r23);
    L8:
        return null;
    L9:
        Typeface r3 = TypefaceCompat.findFromCache(r18, r20, r14, r19.assetCookie, r21);
        if (r3 == null) goto L14;
        if (r22 == null) goto L13;
        r22.callbackSuccessAsync(r3, r23);
    L13:
        return r3;
    L14:
        if (r25 == false) goto L42;
        return null;
    L42:
    L32:
        e = e;
        StringBuilder r1 = new StringBuilder();
        String r4 = "Failed to read xml resource ";
    L36:
        r1.append(r4);
        r1.append(r14);
        Log.e(TAG, r1.toString(), e);
        if (r22 == null) goto L39;
        r22.callbackFailAsync(-3, r23);
    L39:
        return null;
    L34:
        e = e;
        r1 = new StringBuilder();
        r4 = "Failed to parse xml resource ";
        goto L36
    L17:
        if (r14.toLowerCase().endsWith(".xml") == false) goto L26;
        FontResourcesParserCompat.FamilyResourceEntry r5 = FontResourcesParserCompat.parse(r18.getXml(r20), r18);     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r5 != null) goto L25;
        Log.e(TAG, "Failed to find font-family tag");     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r22 == null) goto L23;
        r22.callbackFailAsync(-3, r23);     // Catch: IOException -> L32 XmlPullParserException -> L34
    L23:
        return null;
    L25:
        return TypefaceCompat.createFromResourcesFamilyXml(r17, r5, r18, r20, r14, r19.assetCookie, r21, r22, r23, r24);
    L26:
        Typeface r0 = TypefaceCompat.createFromResourcesFontFile(r17, r18, r20, r14, r19.assetCookie, r21);     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r22 == null) goto L31;
        if (r0 == null) goto L30;
        r22.callbackSuccessAsync(r0, r23);     // Catch: IOException -> L32 XmlPullParserException -> L34
        goto L31
    L30:
        r22.callbackFailAsync(-3, r23);     // Catch: IOException -> L32 XmlPullParserException -> L34
    L31:
        return r0;
    L41:
        throw new Resources.NotFoundException("Resource \"" + r18.getResourceName(r20) + "\" (" + Integer.toHexString(r20) + ") is not a Font: " + r19);
    }
}
