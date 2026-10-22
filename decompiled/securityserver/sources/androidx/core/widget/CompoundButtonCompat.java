package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CompoundButtonCompat {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    private CompoundButtonCompat() {
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton r0) {
        return r0.getButtonDrawable();
    }

    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton r0) {
        return r0.getButtonTintList();
    }

    @Nullable
    public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton r0) {
        return r0.getButtonTintMode();
    }

    public static void setButtonTintList(@NonNull CompoundButton r0, @Nullable ColorStateList r1) {
        r0.setButtonTintList(r1);
    }

    public static void setButtonTintMode(@NonNull CompoundButton r0, @Nullable PorterDuff.Mode r1) {
        r0.setButtonTintMode(r1);
    }
}
