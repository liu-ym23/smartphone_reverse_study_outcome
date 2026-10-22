package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int getAlpha(Drawable r0) {
            return r0.getAlpha();
        }

        @DoNotInline
        static Drawable getChild(DrawableContainer.DrawableContainerState r0, int r1) {
            return r0.getChild(r1);
        }

        @DoNotInline
        static Drawable getDrawable(InsetDrawable r0) {
            return r0.getDrawable();
        }

        @DoNotInline
        static boolean isAutoMirrored(Drawable r0) {
            return r0.isAutoMirrored();
        }

        @DoNotInline
        static void setAutoMirrored(Drawable r0, boolean r1) {
            r0.setAutoMirrored(r1);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void applyTheme(Drawable r0, Resources.Theme r1) {
            r0.applyTheme(r1);
        }

        @DoNotInline
        static boolean canApplyTheme(Drawable r0) {
            return r0.canApplyTheme();
        }

        @DoNotInline
        static ColorFilter getColorFilter(Drawable r0) {
            return r0.getColorFilter();
        }

        @DoNotInline
        static void inflate(Drawable r0, Resources r1, XmlPullParser r2, AttributeSet r3, Resources.Theme r4) {
            r0.inflate(r1, r2, r3, r4);
        }

        @DoNotInline
        static void setHotspot(Drawable r0, float r1, float r2) {
            r0.setHotspot(r1, r2);
        }

        @DoNotInline
        static void setHotspotBounds(Drawable r0, int r1, int r2, int r3, int r4) {
            r0.setHotspotBounds(r1, r2, r3, r4);
        }

        @DoNotInline
        static void setTint(Drawable r0, int r1) {
            r0.setTint(r1);
        }

        @DoNotInline
        static void setTintList(Drawable r0, ColorStateList r1) {
            r0.setTintList(r1);
        }

        @DoNotInline
        static void setTintMode(Drawable r0, PorterDuff.Mode r1) {
            r0.setTintMode(r1);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getLayoutDirection(Drawable r0) {
            return r0.getLayoutDirection();
        }

        @DoNotInline
        static boolean setLayoutDirection(Drawable r0, int r1) {
            return r0.setLayoutDirection(r1);
        }
    }

    private DrawableCompat() {
    }

    public static void applyTheme(@NonNull Drawable r2, @NonNull Resources.Theme r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.applyTheme(r2, r3);
        return;
    }

    public static boolean canApplyTheme(@NonNull Drawable r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return Api21Impl.canApplyTheme(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clearColorFilter(@NonNull Drawable r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L6;
    L4:
        r3.clearColorFilter();
        return;
    L6:
        if (r0 < 21) goto L4;
        r3.clearColorFilter();
        if ((r3 instanceof InsetDrawable) == false) goto L12;
        Drawable r4 = Api19Impl.getDrawable((InsetDrawable) r3);
    L10:
        clearColorFilter(r4);
        return;
    L12:
        if ((r3 instanceof WrappedDrawable) == false) goto L15;
        r4 = ((WrappedDrawable) r3).getWrappedDrawable();
        goto L10
    L15:
        if ((r3 instanceof DrawableContainer) == false) goto L29;
        DrawableContainer.DrawableContainerState r5 = (DrawableContainer.DrawableContainerState) ((DrawableContainer) r3).getConstantState();
        if (r5 == null) goto L30;
        int r1 = 0;
        int r2 = r5.getChildCount();
    L19:
        if (r1 >= r2) goto L31;
        Drawable r6 = Api19Impl.getChild(r5, r1);
        if (r6 == null) goto L23;
        clearColorFilter(r6);
    L23:
        r1 = r1 + 1;
        goto L19
    L31:
        return;
    L30:
        return;
    }

    public static int getAlpha(@NonNull Drawable r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return Api19Impl.getAlpha(r2);
    }

    @Nullable
    public static ColorFilter getColorFilter(@NonNull Drawable r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return Api21Impl.getColorFilter(r2);
    }

    public static int getLayoutDirection(@NonNull Drawable r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L7;
        return Api23Impl.getLayoutDirection(r6);
    L7:
        if (r0 >= 17) goto L9;
    L22:
        return 0;
    L9:
        if (sGetLayoutDirectionMethodFetched == false) goto L25;
    L16:
        Method r1 = sGetLayoutDirectionMethod;
        if (r1 == null) goto L22;
        return ((Integer) r1.invoke(r6, new Object[0])).intValue();
    L20:
        e = move-exception;
        Log.i(TAG, "Failed to invoke getLayoutDirection() via reflection", e);
        sGetLayoutDirectionMethod = null;
        goto L22
    L25:
        Method r3 = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);     // Catch: NoSuchMethodException -> L13
        sGetLayoutDirectionMethod = r3;     // Catch: NoSuchMethodException -> L13
        r3.setAccessible(true);     // Catch: NoSuchMethodException -> L13
    L15:
        sGetLayoutDirectionMethodFetched = true;
    L13:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve getLayoutDirection() method", e);
        goto L15
    }

    public static void inflate(@NonNull Drawable r2, @NonNull Resources r3, @NonNull XmlPullParser r4, @NonNull AttributeSet r5, @Nullable Resources.Theme r6) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.inflate(r2, r3, r4, r5, r6);
        return;
    L5:
        r2.inflate(r3, r4, r5);
    }

    public static boolean isAutoMirrored(@NonNull Drawable r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.isAutoMirrored(r2);
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable r0) {
        r0.jumpToCurrentState();
    }

    public static void setAutoMirrored(@NonNull Drawable r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.setAutoMirrored(r2, r3);
        return;
    }

    public static void setHotspot(@NonNull Drawable r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setHotspot(r2, r3, r4);
        return;
    }

    public static void setHotspotBounds(@NonNull Drawable r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setHotspotBounds(r2, r3, r4, r5, r6);
        return;
    }

    public static boolean setLayoutDirection(@NonNull Drawable r7, int r8) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L7;
        return Api23Impl.setLayoutDirection(r7, r8);
    L7:
        if (r0 >= 17) goto L9;
    L21:
        return false;
    L9:
        if (sSetLayoutDirectionMethodFetched == false) goto L22;
    L15:
        Method r1 = sSetLayoutDirectionMethod;
        if (r1 == null) goto L21;
        r1.invoke(r7, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L19
        return true;
    L19:
        e = move-exception;
        Log.i(TAG, "Failed to invoke setLayoutDirection(int) via reflection", e);
        sSetLayoutDirectionMethod = null;
        goto L21
    L22:
        Method r2 = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L12
        sSetLayoutDirectionMethod = r2;     // Catch: NoSuchMethodException -> L12
        r2.setAccessible(true);     // Catch: NoSuchMethodException -> L12
    L14:
        sSetLayoutDirectionMethodFetched = true;
    L12:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve setLayoutDirection(int) method", e);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTint(@NonNull Drawable r2, @ColorInt int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTint(r2, r3);
        return;
    L6:
        if ((r2 instanceof TintAwareDrawable) == false) goto L10;
        ((TintAwareDrawable) r2).setTint(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTintList(@NonNull Drawable r2, @Nullable ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTintList(r2, r3);
        return;
    L6:
        if ((r2 instanceof TintAwareDrawable) == false) goto L10;
        ((TintAwareDrawable) r2).setTintList(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTintMode(@NonNull Drawable r2, @Nullable PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTintMode(r2, r3);
        return;
    L6:
        if ((r2 instanceof TintAwareDrawable) == false) goto L10;
        ((TintAwareDrawable) r2).setTintMode(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(@NonNull Drawable r1) {
        if ((r1 instanceof WrappedDrawable) == true) goto L5;
        return r1;
    L5:
        return (T) ((WrappedDrawable) r1).getWrappedDrawable();
    }

    @NonNull
    public static Drawable wrap(@NonNull Drawable r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L6;
        return r2;
    L6:
        if (r0 < 21) goto L13;
        if ((r2 instanceof TintAwareDrawable) == false) goto L10;
        return r2;
    L10:
        return new WrappedDrawableApi21(r2);
    L13:
        if ((r2 instanceof TintAwareDrawable) == false) goto L15;
        return r2;
    L15:
        return new WrappedDrawableApi14(r2);
    }
}
