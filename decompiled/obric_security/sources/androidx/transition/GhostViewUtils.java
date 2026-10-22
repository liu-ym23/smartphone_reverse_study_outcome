package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class GhostViewUtils {
    static GhostView addGhost(View r0, ViewGroup r1, Matrix r2) {
        return GhostViewPort.addGhost(r0, r1, r2);
    }

    static void removeGhost(View r0) {
        GhostViewPort.removeGhost(r0);
    }

    private GhostViewUtils() {
    }
}
