package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface TintAwareDrawable {
    void setTint(@ColorInt int r1);

    void setTintList(ColorStateList r1);

    void setTintMode(PorterDuff.Mode r1);
}
