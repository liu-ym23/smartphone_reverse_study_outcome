package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View r1, float r2, float r3, boolean r4);

    boolean onNestedPreFling(@NonNull View r1, float r2, float r3);

    void onNestedPreScroll(@NonNull View r1, int r2, int r3, @NonNull int[] r4);

    void onNestedScroll(@NonNull View r1, int r2, int r3, int r4, int r5);

    void onNestedScrollAccepted(@NonNull View r1, @NonNull View r2, int r3);

    boolean onStartNestedScroll(@NonNull View r1, @NonNull View r2, int r3);

    void onStopNestedScroll(@NonNull View r1);
}
