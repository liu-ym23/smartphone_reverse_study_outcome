package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class AnimateLayoutChangeDetector {
    private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS = null;
    private LinearLayoutManager mLayoutManager;

    static {
        ViewGroup.MarginLayoutParams r0 = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = r0;
        r0.setMargins(0, 0, 0, 0);
    }

    public AnimateLayoutChangeDetector(@NonNull LinearLayoutManager r1) {
        this.mLayoutManager = r1;
    }

    private boolean arePagesLaidOutContiguously() {
        int r0 = this.mLayoutManager.getChildCount();
        if (r0 != 0) goto L6;
        return true;
    L6:
        if (this.mLayoutManager.getOrientation() != 0) goto L8;
        boolean r2 = true;
    L9:
        int[][] r4 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r0, 2});
        int r5 = 0;
    L10:
        if (r5 >= r0) goto L30;
        View r6 = this.mLayoutManager.getChildAt(r5);
        if (r6 == null) goto L29;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
    L17:
        int[] r9 = r4[r5];
        if (r2 == false) goto L21;
        int r10 = r6.getLeft();
        int r11 = r8.leftMargin;
    L22:
        r9[0] = r10 - r11;
        int[] r12 = r4[r5];
        if (r2 == false) goto L26;
        int r13 = r6.getRight();
        int r14 = r8.rightMargin;
    L27:
        r12[1] = r13 + r14;
        r5 = r5 + 1;
        goto L10
    L26:
        r13 = r6.getBottom();
        r14 = r8.bottomMargin;
        goto L27
    L21:
        r10 = r6.getTop();
        r11 = r8.topMargin;
        goto L22
    L16:
        r8 = ZERO_MARGIN_LAYOUT_PARAMS;
        goto L17
    L29:
        throw new IllegalStateException("null view contained in the view hierarchy");
    L30:
        Arrays.sort(r4, new AnonymousClass1(this));
        int r15 = 1;
    L31:
        if (r15 >= r0) goto L36;
        if (r4[r15 - 1][1] != r4[r15][0]) goto L34;
        r15 = r15 + 1;
        goto L31
    L34:
        return false;
    L36:
        int[] r16 = r4[0];
        int r3 = r16[1];
        int r17 = r16[0];
        int r18 = r3 - r17;
        if (r17 <= 0) goto L39;
    L42:
        return false;
    L39:
        if (r4[r0 - 1][1] < r18) goto L42;
        return true;
    L8:
        r2 = false;
        goto L9
    }

    private boolean hasRunningChangingLayoutTransition() {
        int r0 = this.mLayoutManager.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(r2)) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean mayHaveInterferingAnimations() {
        if (arePagesLaidOutContiguously() == false) goto L7;
        if (this.mLayoutManager.getChildCount() <= 1) goto L7;
    L9:
        return false;
    L7:
        if (hasRunningChangingLayoutTransition() == false) goto L9;
        return true;
    }

    private static boolean hasRunningChangingLayoutTransition(View r5) {
        if ((r5 instanceof ViewGroup) == false) goto L15;
        ViewGroup r6 = (ViewGroup) r5;
        LayoutTransition r0 = r6.getLayoutTransition();
        if (r0 != null) goto L7;
    L9:
        int r1 = r6.getChildCount();
        int r3 = 0;
    L10:
        if (r3 >= r1) goto L15;
        if (hasRunningChangingLayoutTransition(r6.getChildAt(r3)) == true) goto L13;
        r3 = r3 + 1;
        goto L10
    L13:
        return true;
    L7:
        if (r0.isChangingLayout() == false) goto L9;
        return true;
    L15:
        return false;
    }
}
