package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes.dex */
public class PagerSnapHelper extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;

    @Nullable
    private OrientationHelper mHorizontalHelper;

    @Nullable
    private OrientationHelper mVerticalHelper;

    public PagerSnapHelper() {
    }

    private int distanceToCenter(@NonNull RecyclerView.LayoutManager r1, @NonNull View r2, OrientationHelper r3) {
        int r0 = r3.getDecoratedStart(r2);
        int r4 = (r3.getDecoratedMeasurement(r2) / 2) + r0;
        int r5 = r3.getStartAfterPadding();
        return r4 - ((r3.getTotalSpace() / 2) + r5);
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager r8, OrientationHelper r9) {
        int r7 = r8.getChildCount();
        View r0 = null;
        if (r7 != 0) goto L5;
        return null;
    L5:
        int r1 = r9.getStartAfterPadding();
        int r2 = (r9.getTotalSpace() / 2) + r1;
        int r3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int r4 = 0;
    L6:
        if (r4 >= r7) goto L11;
        View r5 = r8.getChildAt(r4);
        int r6 = r9.getDecoratedStart(r5);
        int r10 = Math.abs(((r9.getDecoratedMeasurement(r5) / 2) + r6) - r2);
        if (r10 >= r3) goto L10;
        r0 = r5;
        r3 = r10;
    L10:
        r4 = r4 + 1;
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

    @Nullable
    private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager r2) {
        if (r2.canScrollVertically() == false) goto L7;
        return getVerticalHelper(r2);
    L7:
        if (r2.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return getHorizontalHelper(r2);
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

    private boolean isForwardFling(RecyclerView.LayoutManager r2, int r3, int r4) {
        if (r2.canScrollHorizontally() == false) goto L7;
        if (r3 > 0) goto L6;
        return false;
    L6:
        return true;
    L7:
        if (r4 > 0) goto L9;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView.LayoutManager r4) {
        int r3 = r4.getItemCount();
        if ((r4 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == false) goto L12;
        PointF r5 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) r4).computeScrollVectorForPosition(r3 - 1);
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.x < 0.0f) goto L11;
        if (r5.y < 0.0f) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
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
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager r2) {
        if ((r2 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L6;
        return null;
    L6:
        final Context r0 = this.mRecyclerView.getContext();
        return new AnonymousClass1(this, r0);
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager r2) {
        if (r2.canScrollVertically() == false) goto L7;
        return findCenterView(r2, getVerticalHelper(r2));
    L7:
        if (r2.canScrollHorizontally() == true) goto L9;
        return null;
    L9:
        return findCenterView(r2, getHorizontalHelper(r2));
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager r12, int r13, int r14) {
        int r0 = r12.getItemCount();
        if (r0 != 0) goto L5;
        return -1;
    L5:
        OrientationHelper r2 = getOrientationHelper(r12);
        if (r2 != null) goto L8;
        return -1;
    L8:
        int r3 = r12.getChildCount();
        View r4 = null;
        int r8 = 0;
        int r7 = Integer.MAX_VALUE;
        int r6 = Integer.MIN_VALUE;
        View r5 = null;
    L9:
        if (r8 >= r3) goto L21;
        View r9 = r12.getChildAt(r8);
        if (r9 == null) goto L20;
        int r10 = distanceToCenter(r12, r9, r2);
        if (r10 > 0) goto L17;
        if (r10 <= r6) goto L17;
        r5 = r9;
        r6 = r10;
    L17:
        if (r10 < 0) goto L20;
        if (r10 >= r7) goto L20;
        r4 = r9;
        r7 = r10;
    L20:
        r8 = r8 + 1;
        goto L9
    L21:
        boolean r15 = isForwardFling(r12, r13, r14);
        if (r15 == false) goto L26;
        if (r4 == null) goto L26;
        return r12.getPosition(r4);
    L26:
        if (r15 == true) goto L30;
        if (r5 == null) goto L30;
        return r12.getPosition(r5);
    L30:
        if (r15 == false) goto L32;
        r4 = r5;
    L32:
        if (r4 != null) goto L34;
        return -1;
    L34:
        int r16 = r12.getPosition(r4);
        if (isReverseLayout(r12) != r15) goto L37;
        int r11 = -1;
    L38:
        int r17 = r16 + r11;
        if (r17 < 0) goto L43;
        if (r17 >= r0) goto L43;
        return r17;
    L43:
        return -1;
    L37:
        r11 = 1;
        goto L38
    }
}
