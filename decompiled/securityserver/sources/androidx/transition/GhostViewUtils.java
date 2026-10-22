package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    @Nullable
    public static GhostView addGhost(@NonNull View r0, @NonNull ViewGroup r1, @Nullable Matrix r2) {
        return GhostViewPort.addGhost(r0, r1, r2);
    }

    public static void removeGhost(View r0) {
        GhostViewPort.removeGhost(r0);
    }
}
