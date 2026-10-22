package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CompoundButtonCompat {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ColorStateList getButtonTintList(CompoundButton r0) {
            return r0.getButtonTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getButtonTintMode(CompoundButton r0) {
            return r0.getButtonTintMode();
        }

        @DoNotInline
        static void setButtonTintList(CompoundButton r0, ColorStateList r1) {
            r0.setButtonTintList(r1);
        }

        @DoNotInline
        static void setButtonTintMode(CompoundButton r0, PorterDuff.Mode r1) {
            r0.setButtonTintMode(r1);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Drawable getButtonDrawable(CompoundButton r0) {
            return r0.getButtonDrawable();
        }
    }

    private CompoundButtonCompat() {
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton r4) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getButtonDrawable(r4);
    L7:
        if (sButtonDrawableFieldFetched == false) goto L23;
    L14:
        Field r0 = sButtonDrawableField;
        if (r0 != null) goto L21;
    L20:
        return null;
    L21:
        return (Drawable) r0.get(r4);
    L18:
        e = move-exception;
        Log.i(TAG, "Failed to get button drawable via reflection", e);
        sButtonDrawableField = null;
        goto L20
    L23:
        Field r2 = CompoundButton.class.getDeclaredField("mButtonDrawable");     // Catch: NoSuchFieldException -> L11
        sButtonDrawableField = r2;     // Catch: NoSuchFieldException -> L11
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L11
    L13:
        sButtonDrawableFieldFetched = true;
    L11:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve mButtonDrawable field", e);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getButtonTintList(r2);
    L7:
        if ((r2 instanceof TintableCompoundButton) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundButton) r2).getSupportButtonTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getButtonTintMode(r2);
    L7:
        if ((r2 instanceof TintableCompoundButton) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundButton) r2).getSupportButtonTintMode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setButtonTintList(@NonNull CompoundButton r2, @Nullable ColorStateList r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setButtonTintList(r2, r3);
        return;
    L6:
        if ((r2 instanceof TintableCompoundButton) == false) goto L10;
        ((TintableCompoundButton) r2).setSupportButtonTintList(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setButtonTintMode(@NonNull CompoundButton r2, @Nullable PorterDuff.Mode r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setButtonTintMode(r2, r3);
        return;
    L6:
        if ((r2 instanceof TintableCompoundButton) == false) goto L10;
        ((TintableCompoundButton) r2).setSupportButtonTintMode(r3);
        return;
    }
}
