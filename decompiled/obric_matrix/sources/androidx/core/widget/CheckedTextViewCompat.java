package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CheckedTextViewCompat {
    private static final String TAG = "CheckedTextViewCompat";

    private static class Api14Impl {
        private static Field sCheckMarkDrawableField;
        private static boolean sResolved;

        private Api14Impl() {
        }

        @Nullable
        static Drawable getCheckMarkDrawable(@NonNull CheckedTextView r4) {
            if (sResolved == false) goto L17;
        L10:
            Field r0 = sCheckMarkDrawableField;
            if (r0 != null) goto L19;
        L16:
            return null;
        L19:
            return (Drawable) r0.get(r4);
        L14:
            e = move-exception;
            Log.i(CheckedTextViewCompat.TAG, "Failed to get check mark drawable via reflection", e);
            sCheckMarkDrawableField = null;
            goto L16
        L17:
            Field r2 = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");     // Catch: NoSuchFieldException -> L7
            sCheckMarkDrawableField = r2;     // Catch: NoSuchFieldException -> L7
            r2.setAccessible(true);     // Catch: NoSuchFieldException -> L7
        L9:
            sResolved = true;
        L7:
            e = move-exception;
            Log.i(CheckedTextViewCompat.TAG, "Failed to retrieve mCheckMarkDrawable field", e);
            goto L9
        }
    }

    @RequiresApi(16)
    private static class Api16Impl {
        private Api16Impl() {
        }

        @Nullable
        static Drawable getCheckMarkDrawable(@NonNull CheckedTextView r0) {
            return r0.getCheckMarkDrawable();
        }
    }

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @Nullable
        static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView r0) {
            return r0.getCheckMarkTintList();
        }

        @Nullable
        static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView r0) {
            return r0.getCheckMarkTintMode();
        }

        static void setCheckMarkTintList(@NonNull CheckedTextView r0, @Nullable ColorStateList r1) {
            r0.setCheckMarkTintList(r1);
        }

        static void setCheckMarkTintMode(@NonNull CheckedTextView r0, @Nullable PorterDuff.Mode r1) {
            r0.setCheckMarkTintMode(r1);
        }
    }

    private CheckedTextViewCompat() {
    }

    @Nullable
    public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getCheckMarkDrawable(r2);
    L7:
        return Api14Impl.getCheckMarkDrawable(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getCheckMarkTintList(r2);
    L7:
        if ((r2 instanceof TintableCheckedTextView) == true) goto L9;
        return null;
    L9:
        return ((TintableCheckedTextView) r2).getSupportCheckMarkTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getCheckMarkTintMode(r2);
    L7:
        if ((r2 instanceof TintableCheckedTextView) == true) goto L9;
        return null;
    L9:
        return ((TintableCheckedTextView) r2).getSupportCheckMarkTintMode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCheckMarkTintList(@NonNull CheckedTextView r2, @Nullable ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setCheckMarkTintList(r2, r3);
        return;
    L6:
        if ((r2 instanceof TintableCheckedTextView) == false) goto L10;
        ((TintableCheckedTextView) r2).setSupportCheckMarkTintList(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCheckMarkTintMode(@NonNull CheckedTextView r2, @Nullable PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setCheckMarkTintMode(r2, r3);
        return;
    L6:
        if ((r2 instanceof TintableCheckedTextView) == false) goto L10;
        ((TintableCheckedTextView) r2).setSupportCheckMarkTintMode(r3);
        return;
    }
}
