package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxesNonTouch;
    private int mNestedScrollAxesTouch;

    public NestedScrollingParentHelper(@NonNull ViewGroup r1) {
    }

    public int getNestedScrollAxes() {
        int r0 = this.mNestedScrollAxesTouch;
        return this.mNestedScrollAxesNonTouch | r0;
    }

    public void onNestedScrollAccepted(@NonNull View r2, @NonNull View r3, int r4) {
        onNestedScrollAccepted(r2, r3, r4, 0);
    }

    public void onNestedScrollAccepted(@NonNull View r1, @NonNull View r2, int r3, int r4) {
        if (r4 != 1) goto L5;
        this.mNestedScrollAxesNonTouch = r3;
        return;
    L5:
        this.mNestedScrollAxesTouch = r3;
    }

    public void onStopNestedScroll(@NonNull View r2) {
        onStopNestedScroll(r2, 0);
    }

    public void onStopNestedScroll(@NonNull View r2, int r3) {
        if (r3 != 1) goto L5;
        this.mNestedScrollAxesNonTouch = 0;
        return;
    L5:
        this.mNestedScrollAxesTouch = 0;
    }
}
