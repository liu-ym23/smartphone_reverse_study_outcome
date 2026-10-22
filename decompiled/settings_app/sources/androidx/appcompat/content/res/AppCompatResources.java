package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatResources {
    private AppCompatResources() {
    }

    public static ColorStateList getColorStateList(Context r0, int r1) {
        return ContextCompat.getColorStateList(r0, r1);
    }

    public static Drawable getDrawable(Context r1, int r2) {
        return ResourceManagerInternal.get().getDrawable(r1, r2);
    }
}
