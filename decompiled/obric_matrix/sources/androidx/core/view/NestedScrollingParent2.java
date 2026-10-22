package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View r1, int r2, int r3, @NonNull int[] r4, int r5);

    void onNestedScroll(@NonNull View r1, int r2, int r3, int r4, int r5, int r6);

    void onNestedScrollAccepted(@NonNull View r1, @NonNull View r2, int r3, int r4);

    boolean onStartNestedScroll(@NonNull View r1, @NonNull View r2, int r3, int r4);

    void onStopNestedScroll(@NonNull View r1, int r2);
}
