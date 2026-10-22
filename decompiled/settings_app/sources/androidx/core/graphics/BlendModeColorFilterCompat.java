package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;

/* JADX INFO: loaded from: classes.dex */
public class BlendModeColorFilterCompat {

    static class Api29Impl {
        private Api29Impl() {
        }

        static ColorFilter createBlendModeColorFilter(int r1, Object r2) {
            return new BlendModeColorFilter(r1, (BlendMode) r2);
        }
    }

    public static ColorFilter createBlendModeColorFilterCompat(int r0, BlendModeCompat r1) {
        Object r2 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return Api29Impl.createBlendModeColorFilter(r0, r2);
    }

    private BlendModeColorFilterCompat() {
    }
}
