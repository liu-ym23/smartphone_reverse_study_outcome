package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String r1) {
        this.mPropertyName = r1;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> r2) {
        final String r1 = r2.getName();
        return new AnonymousClass1(r1, r2);
    }

    public abstract float getValue(T r1);

    public abstract void setValue(T r1, float r2);
}
