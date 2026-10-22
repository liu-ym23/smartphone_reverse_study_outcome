package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class PropertyValuesHolderUtils {
    static PropertyValuesHolder ofPointF(Property<?, PointF> r1, Path r2) {
        return PropertyValuesHolder.ofObject(r1, null, r2);
    }

    private PropertyValuesHolderUtils() {
    }
}
