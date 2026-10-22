package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    private DrawableCompat() {
    }

    public static void applyTheme(@NonNull Drawable r0, @NonNull Resources.Theme r1) {
        r0.applyTheme(r1);
    }

    public static boolean canApplyTheme(@NonNull Drawable r0) {
        return r0.canApplyTheme();
    }

    public static void clearColorFilter(@NonNull Drawable r0) {
        r0.clearColorFilter();
    }

    public static int getAlpha(@NonNull Drawable r0) {
        return r0.getAlpha();
    }

    public static ColorFilter getColorFilter(@NonNull Drawable r0) {
        return r0.getColorFilter();
    }

    public static int getLayoutDirection(@NonNull Drawable r0) {
        return r0.getLayoutDirection();
    }

    public static void inflate(@NonNull Drawable r0, @NonNull Resources r1, @NonNull XmlPullParser r2, @NonNull AttributeSet r3, @Nullable Resources.Theme r4) {
        r0.inflate(r1, r2, r3, r4);
    }

    public static boolean isAutoMirrored(@NonNull Drawable r0) {
        return r0.isAutoMirrored();
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable r0) {
        r0.jumpToCurrentState();
    }

    public static void setAutoMirrored(@NonNull Drawable r0, boolean r1) {
        r0.setAutoMirrored(r1);
    }

    public static void setHotspot(@NonNull Drawable r0, float r1, float r2) {
        r0.setHotspot(r1, r2);
    }

    public static void setHotspotBounds(@NonNull Drawable r0, int r1, int r2, int r3, int r4) {
        r0.setHotspotBounds(r1, r2, r3, r4);
    }

    public static boolean setLayoutDirection(@NonNull Drawable r0, int r1) {
        return r0.setLayoutDirection(r1);
    }

    public static void setTint(@NonNull Drawable r0, @ColorInt int r1) {
        r0.setTint(r1);
    }

    public static void setTintList(@NonNull Drawable r0, @Nullable ColorStateList r1) {
        r0.setTintList(r1);
    }

    public static void setTintMode(@NonNull Drawable r0, @NonNull PorterDuff.Mode r1) {
        r0.setTintMode(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(@NonNull Drawable r1) {
        if ((r1 instanceof WrappedDrawable) == true) goto L5;
        return r1;
    L5:
        return (T) ((WrappedDrawable) r1).getWrappedDrawable();
    }

    public static Drawable wrap(@NonNull Drawable r0) {
        return r0;
    }
}
