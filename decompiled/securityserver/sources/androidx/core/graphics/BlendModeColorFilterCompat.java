package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class BlendModeColorFilterCompat {
    private BlendModeColorFilterCompat() {
    }

    @Nullable
    public static ColorFilter createBlendModeColorFilterCompat(int r1, @NonNull BlendModeCompat r2) {
        BlendMode r3 = BlendModeUtils.obtainBlendModeFromCompat(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new BlendModeColorFilter(r1, r3);
    }
}
