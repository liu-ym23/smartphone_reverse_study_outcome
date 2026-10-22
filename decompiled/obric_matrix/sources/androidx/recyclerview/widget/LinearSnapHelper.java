package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class LinearSnapHelper extends SnapHelper {
    private static final float INVALID_DISTANCE = 1.0f;

    @Nullable
    private OrientationHelper mHorizontalHelper;

    @Nullable
    private OrientationHelper mVerticalHelper;

    public LinearSnapHelper() {
    }

    private float computeDistancePerChild(RecyclerView.LayoutManager r10, OrientationHelper r11) {
        int r9 = r10.getChildCount();
        if (r9 != 0) goto L5;
        return 1.0f;
    L5:
        int r1 = 0;
        View r2 = null;
        int r5 = Integer.MIN_VALUE;
        int r4 = Integer.MAX_VALUE;
        View r3 = null;
    L6:
        if (r1 >= r9) goto L15;
        View r6 = r10.getChildAt(r1);
        int r7 = r10.getPosition(r6);
        if (r7 == (-1)) goto L14;
        if (r7 >= r4) goto L12;
        r2 = r6;
        r4 = r7;
    L12:
        if (r7 <= r5) goto L14;
        r3 = r6;
        r5 = r7;
    L14:
        r1 = r1 + 1;
        goto L6
    L15:
        if (r2 == null) goto L23;
        if (r3 == null) goto L23;
        int r12 = Math.max(r11.getDecoratedEnd(r2), r11.getDecoratedEnd(r3)) - Math.min(r11.getDecoratedStart(r2), r11.getDecoratedStart(r3));
        if (r12 != 0) goto L22;
        return 1.0f;
    L22:
        return (r12 * 1.0f) / ((r5 - r4) + 1);
    L23:
        return 1.0f;
    }

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager r1, @NonNull View r2, OrientationHelper r3) {
        return (r3.getDecoratedStart(r2) + (r3.getDecoratedMeasurement(r2) / 2)) - (r3.getStartAfterPadding() + (r3.getTotalSpace() / 2));
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager r2, OrientationHelper r3, int r4, int r5) {
        int[] r6 = calculateScrollDistance(r4, r5);
        float r1 = computeDistancePerChild(r2, r3);
        if (r1 > 0.0f) goto L6;
        return 0;
    L6:
        if (Math.abs(r6[0]) <= Math.abs(r6[1])) goto L8;
        int r7 = r6[0];
    L10:
        return Math.round(r7 / r1);
    L8:
        r7 = r6[1];
        goto L10
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager r8, OrientationHelper r9) {
        int r7 = r8.getChildCount();
        View r0 = null;
        if (r7 != 0) goto L5;
        return null;
    L5:
        int r1 = r9.getStartAfterPadding() + (r9.getTotalSpace() / 2);
        int r2 = Integer.MAX_VALUE;
        int r3 = 0;
    L6:
        if (r3 >= r7) goto L11;
        View r4 = r8.getChildAt(r3);
        int r5 = Math.abs((r9.getDecoratedStart(r4) + (r9.getDecoratedMeasurement(r4) / 2)) - r1);
        if (r5 >= r2) goto L10;
        r0 = r4;
        r2 = r5;
    L10:
        r3 = r3 + 1;
        goto L6
    L11:
        return r0;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager r2) {
        OrientationHelper r0 = this.mHorizontalHelper;
        if (r0 != null) goto L5;
    L6:
        this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(r2);
    L8:
        return this.mHorizontalHelper;
    L5:
        if (r0.mLayoutManager == r2) goto L8;
        goto L6
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager r2) {
        OrientationHelper r0 = this.mVerticalHelper;
        if (r0 != null) goto L5;
    L6:
        this.mVerticalHelper = OrientationHelper.createVerticalHelper(r2);
    L8:
        return this.mVerticalHelper;
    L5:
        if (r0.mLayoutManager == r2) goto L8;
        goto L6
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager r5, @NonNull View r6) {
        int[] r0 = new int[2];
        if (r5.canScrollHorizontally() == false) goto L5;
        r0[0] = distanceToCenter(r5, r6, getHorizontalHelper(r5));
    L7:
        if (r5.canScrollVertically() == false) goto L9;
        r0[1] = distanceToCenter(r5, r6, getVerticalHelper(r5));
    L10:
        return r0;
    L9:
        r0[1] = 0;
        goto L10
    L5:
        r0[0] = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager r2) {
        if (r2.canScrollVertically() == false) goto L8;
        OrientationHelper r0 = getVerticalHelper(r2);
    L6:
        return findCenterView(r2, r0);
    L8:
        if (r2.canScrollHorizontally() == false) goto L10;
        r0 = getHorizontalHelper(r2);
        goto L6
    L10:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r9, int r10, int r11) {
        if ((r9 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return -1;
    L5:
        int r0 = r9.getItemCount();
        if (r0 != 0) goto L8;
        return -1;
    L8:
        View r2 = findSnapView(r9);
        if (r2 != null) goto L11;
        return -1;
    L11:
        int r3 = r9.getPosition(r2);
        if (r3 != (-1)) goto L14;
        return -1;
    L14:
        int r4 = r0 - 1;
        PointF r5 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r9).computeScrollVectorForPosition(r4);
        if (r5 != null) goto L17;
        return -1;
    L17:
        int r7 = 0;
        if (r9.canScrollHorizontally() == false) goto L22;
        int r12 = estimateNextPositionDiffForFling(r9, getHorizontalHelper(r9), r10, 0);
        if (r5.x >= 0.0f) goto L24;
        r12 = -r12;
    L24:
        if (r9.canScrollVertically() == false) goto L28;
        int r8 = estimateNextPositionDiffForFling(r9, getVerticalHelper(r9), 0, r11);
        if (r5.y >= 0.0f) goto L30;
        r8 = -r8;
    L30:
        if (r9.canScrollVertically() == false) goto L32;
        r12 = r8;
    L32:
        if (r12 != 0) goto L34;
        return -1;
    L34:
        int r6 = r3 + r12;
        if (r6 < 0) goto L38;
        r7 = r6;
    L38:
        if (r7 < r0) goto L41;
        return r4;
    L41:
        return r7;
    L28:
        r8 = 0;
        goto L30
    L22:
        r12 = 0;
        goto L24
    }
}
