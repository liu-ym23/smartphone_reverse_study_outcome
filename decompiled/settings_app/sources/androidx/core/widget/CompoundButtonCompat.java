package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CompoundButtonCompat {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    static class Api21Impl {
        private Api21Impl() {
        }

        static void setButtonTintList(CompoundButton r0, ColorStateList r1) {
            r0.setButtonTintList(r1);
        }

        static ColorStateList getButtonTintList(CompoundButton r0) {
            return r0.getButtonTintList();
        }

        static void setButtonTintMode(CompoundButton r0, PorterDuff.Mode r1) {
            r0.setButtonTintMode(r1);
        }

        static PorterDuff.Mode getButtonTintMode(CompoundButton r0) {
            return r0.getButtonTintMode();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static Drawable getButtonDrawable(CompoundButton r0) {
            return r0.getButtonDrawable();
        }
    }

    private CompoundButtonCompat() {
    }

    public static void setButtonTintList(CompoundButton r0, ColorStateList r1) {
        Api21Impl.setButtonTintList(r0, r1);
    }

    public static ColorStateList getButtonTintList(CompoundButton r0) {
        return Api21Impl.getButtonTintList(r0);
    }

    public static void setButtonTintMode(CompoundButton r0, PorterDuff.Mode r1) {
        Api21Impl.setButtonTintMode(r0, r1);
    }

    public static PorterDuff.Mode getButtonTintMode(CompoundButton r0) {
        return Api21Impl.getButtonTintMode(r0);
    }

    public static Drawable getButtonDrawable(CompoundButton r0) {
        return Api23Impl.getButtonDrawable(r0);
    }
}
