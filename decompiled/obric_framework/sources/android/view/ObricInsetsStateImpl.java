package android.view;

import android.graphics.Insets;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class ObricInsetsStateImpl implements IObricInsetsState {
    static final int AUTO_IME_HEIGHT = 58;
    private static final String TAG = "AutoImeAnim";
    private static volatile int sOverrideImeBottom;
    private InsetsState mBase;

    static {
        sOverrideImeBottom = -1;
    }

    public ObricInsetsStateImpl(InsetsState base) {
        this.mBase = base;
    }

    public static void setAnimatingImeBottom(int bottom) {
        sOverrideImeBottom = bottom;
        Log.d(TAG, "ObricInsetsStateImpl: setAnimatingImeBottom=" + bottom);
    }

    public static void clearAnimatingImeBottom() {
        Log.d(TAG, "ObricInsetsStateImpl: clearAnimatingImeBottom (was=" + sOverrideImeBottom + ")");
        sOverrideImeBottom = -1;
    }

    public void adjustImeInsets(Insets[] typeInsetsMap, boolean[] typeVisibilityMap) {
        int override = sOverrideImeBottom;
        if (override < 0) goto L5;
        int bottom = override;
    L6:
        typeVisibilityMap[WindowInsets.Type.indexOf(8)] = true;
        Insets existing = typeInsetsMap[WindowInsets.Type.indexOf(8)];
        if (existing != null) goto L9;
        typeInsetsMap[WindowInsets.Type.indexOf(8)] = Insets.of(0, 0, 0, bottom);
        return;
    L9:
        typeInsetsMap[WindowInsets.Type.indexOf(8)] = Insets.max(existing, Insets.of(0, 0, 0, bottom));
        return;
    L5:
        bottom = AUTO_IME_HEIGHT;
        goto L6
    }
}
