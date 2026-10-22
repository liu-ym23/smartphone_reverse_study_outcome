package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udfffd";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = null;

    static {
        sRectThreadLocal = new ThreadLocal();
    }

    private PaintCompat() {
    }

    public static boolean hasGlyph(@NonNull Paint r0, @NonNull String r1) {
        return r0.hasGlyph(r1);
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        ThreadLocal<Pair<Rect, Rect>> r0 = sRectThreadLocal;
        Pair<Rect, Rect> r1 = r0.get();
        if (r1 != null) goto L5;
        Pair<Rect, Rect> r2 = new Pair(new Rect(), new Rect());
        r0.set(r2);
        return r2;
    L5:
        r1.first.setEmpty();
        r1.second.setEmpty();
        return r1;
    }

    public static boolean setBlendMode(@NonNull Paint r0, @Nullable BlendModeCompat r1) {
        if (r1 == null) goto L4;
        BlendMode r2 = BlendModeUtils.obtainBlendModeFromCompat(r1);
    L5:
        r0.setBlendMode(r2);
        return true;
    L4:
        r2 = null;
        goto L5
    }
}
