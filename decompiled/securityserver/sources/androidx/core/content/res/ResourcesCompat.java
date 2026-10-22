package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ResourcesCompat {

    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";

    public static abstract class FontCallback {
        public FontCallback() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(final int r2, @Nullable Handler r3) {
            if (r3 != null) goto L4;
            r3 = new Handler(Looper.getMainLooper());
        L4:
            r3.post(new AnonymousClass2(this, r2));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(final Typeface r2, @Nullable Handler r3) {
            if (r3 != null) goto L4;
            r3 = new Handler(Looper.getMainLooper());
        L4:
            r3.post(new AnonymousClass1(this, r2));
        }

        public abstract void onFontRetrievalFailed(int r1);

        public abstract void onFontRetrieved(@NonNull Typeface r1);
    }

    public static final class ThemeCompat {

        @RequiresApi(23)
        public static class ImplApi23 {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = null;

            static {
                sRebaseMethodLock = new Object();
            }

            private ImplApi23() {
            }

            public static void rebase(@NonNull Resources.Theme r6) {
                Object r0 = sRebaseMethodLock;
                monitor-enter(r0);
            L10:
                th = move-exception;
                throw th;
            L6:
                if (sRebaseMethodFetched == false) goto L25;
            L15:
                Method r1 = sRebaseMethod;     // Catch: Throwable -> L10
                if (r1 != null) goto L29;
            L21:
                monitor-exit(r0);     // Catch: Throwable -> L10
                return;
            L29:
                r1.invoke(r6, null);     // Catch: Throwable -> L10 Throwable -> L19
            L19:
                e = move-exception;
                Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e);     // Catch: Throwable -> L10
                sRebaseMethod = null;     // Catch: Throwable -> L10
                goto L21
            L25:
                Method r3 = Resources.Theme.class.getDeclaredMethod("rebase", null);     // Catch: Throwable -> L10 NoSuchMethodException -> L12
                sRebaseMethod = r3;     // Catch: Throwable -> L10 NoSuchMethodException -> L12
                r3.setAccessible(true);     // Catch: Throwable -> L10 NoSuchMethodException -> L12
            L14:
                sRebaseMethodFetched = true;     // Catch: Throwable -> L10
                goto L15
            L12:
                e = move-exception;
                Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e);     // Catch: Throwable -> L10
                goto L14
            }
        }

        @RequiresApi(29)
        public static class ImplApi29 {
            private ImplApi29() {
            }

            public static void rebase(@NonNull Resources.Theme r0) {
                r0.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme r0) {
            ImplApi29.rebase(r0);
        }
    }

    private ResourcesCompat() {
    }

    @ColorInt
    public static int getColor(@NonNull Resources r0, @ColorRes int r1, @Nullable Resources.Theme r2) {
        return r0.getColor(r1, r2);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources r0, @ColorRes int r1, @Nullable Resources.Theme r2) {
        return r0.getColorStateList(r1, r2);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources r0, @DrawableRes int r1, @Nullable Resources.Theme r2) {
        return r0.getDrawable(r1, r2);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources r0, @DrawableRes int r1, int r2, @Nullable Resources.Theme r3) {
        return r0.getDrawableForDensity(r1, r2, r3);
    }

    public static float getFloat(@NonNull Resources r3, @DimenRes int r4) {
        TypedValue r0 = new TypedValue();
        r3.getValue(r4, r0, true);
        if (r0.type != 4) goto L7;
        return r0.getFloat();
    L7:
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(r4) + " type #0x" + Integer.toHexString(r0.type) + " is not valid");
    }

    @Nullable
    public static Typeface getFont(@NonNull Context r7, @FontRes int r8) {
        if (r7.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r7, r8, new TypedValue(), 0, null, null, false);
    }

    private static Typeface loadFont(@NonNull Context r8, int r9, TypedValue r10, int r11, @Nullable FontCallback r12, @Nullable Handler r13, boolean r14) {
        Resources r1 = r8.getResources();
        r1.getValue(r9, r10, true);
        Typeface r15 = loadFont(r8, r1, r10, r9, r11, r12, r13, r14);
        if (r15 != null) goto L8;
        if (r12 != null) goto L8;
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(r9) + " could not be retrieved.");
    L8:
        return r15;
    }

    public static void getFont(@NonNull Context r7, @FontRes int r8, @NonNull FontCallback r9, @Nullable Handler r10) {
        Preconditions.checkNotNull(r9);
        if (r7.isRestricted() == false) goto L6;
        r9.callbackFailAsync(-4, r10);
        return;
    L6:
        loadFont(r7, r8, new TypedValue(), 0, r9, r10, false);
    }

    private static Typeface loadFont(@NonNull Context r15, Resources r16, TypedValue r17, int r18, int r19, @Nullable FontCallback r20, @Nullable Handler r21, boolean r22) {
        CharSequence r2 = r17.string;
        if (r2 == null) goto L40;
        String r12 = r2.toString();
        if (r12.startsWith("res/") == true) goto L9;
        if (r20 == null) goto L8;
        r20.callbackFailAsync(-3, r21);
    L8:
        return null;
    L9:
        Typeface r1 = TypefaceCompat.findFromCache(r16, r18, r19);
        if (r1 == null) goto L41;
        if (r20 == null) goto L13;
        r20.callbackSuccessAsync(r1, r21);
    L13:
        return r1;
    L41:
    L21:
        e = move-exception;
        Log.e(TAG, "Failed to read xml resource ".concat(r12), e);
    L36:
        if (r20 == null) goto L38;
        r20.callbackFailAsync(-3, r21);
    L38:
        return null;
    L23:
        e = move-exception;
        Log.e(TAG, "Failed to parse xml resource ".concat(r12), e);
        goto L36
    L15:
        if (r12.toLowerCase().endsWith(".xml") == false) goto L28;
        FontResourcesParserCompat.FamilyResourceEntry r3 = FontResourcesParserCompat.parse(r16.getXml(r18), r16);     // Catch: IOException -> L21 XmlPullParserException -> L23
        if (r3 != null) goto L27;
        Log.e(TAG, "Failed to find font-family tag");     // Catch: IOException -> L21 XmlPullParserException -> L23
        if (r20 == null) goto L25;
        r20.callbackFailAsync(-3, r21);     // Catch: IOException -> L21 XmlPullParserException -> L23
    L25:
        return null;
    L27:
        return TypefaceCompat.createFromResourcesFamilyXml(r15, r3, r16, r18, r19, r20, r21, r22);
    L28:
        Typeface r0 = TypefaceCompat.createFromResourcesFontFile(r15, r16, r18, r12, r19);     // Catch: IOException -> L21 XmlPullParserException -> L23
        if (r20 == null) goto L33;
        if (r0 == null) goto L32;
        r20.callbackSuccessAsync(r0, r21);     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L33
    L32:
        r20.callbackFailAsync(-3, r21);     // Catch: IOException -> L21 XmlPullParserException -> L23
    L33:
        return r0;
    L40:
        throw new Resources.NotFoundException("Resource \"" + r16.getResourceName(r18) + "\" (" + Integer.toHexString(r18) + ") is not a Font: " + r17);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context r7, @FontRes int r8, TypedValue r9, int r10, @Nullable FontCallback r11) {
        if (r7.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r7, r8, r9, r10, r11, null, true);
    }
}
