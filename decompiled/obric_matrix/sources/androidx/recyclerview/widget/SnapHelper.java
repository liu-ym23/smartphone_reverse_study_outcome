package androidx.recyclerview.widget;

import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public SnapHelper() {
        this.mScrollListener = new AnonymousClass1(this);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() {
        if (this.mRecyclerView.getOnFlingListener() != null) goto L7;
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener(this);
        return;
    L7:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean snapFromFling(@NonNull RecyclerView.LayoutManager r3, int r4, int r5) {
        if ((r3 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L5;
        return false;
    L5:
        RecyclerView.SmoothScroller r0 = createScroller(r3);
        if (r0 != null) goto L8;
        return false;
    L8:
        int r2 = findTargetSnapPosition(r3, r4, r5);
        if (r2 != (-1)) goto L11;
        return false;
    L11:
        r0.setTargetPosition(r2);
        r3.startSmoothScroll(r0);
        return true;
    }

    public void attachToRecyclerView(@Nullable RecyclerView r3) {
        RecyclerView r0 = this.mRecyclerView;
        if (r0 != r3) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        destroyCallbacks();
    L7:
        this.mRecyclerView = r3;
        if (r3 == null) goto L11;
        setupCallbacks();
        this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
        snapToTargetExistingView();
        return;
    }

    @Nullable
    public abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager r1, @NonNull View r2);

    public int[] calculateScrollDistance(int r11, int r12) {
        this.mGravityScroller.fling(0, 0, r11, r12, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    @Nullable
    protected RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager r1) {
        return createSnapScroller(r1);
    }

    @Nullable
    @Deprecated
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager r2) {
        if ((r2 instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) == true) goto L6;
        return null;
    L6:
        final Context r0 = this.mRecyclerView.getContext();
        return new AnonymousClass2(this, r0);
    }

    @Nullable
    public abstract View findSnapView(RecyclerView.LayoutManager r1);

    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager r1, int r2, int r3);

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int r5, int r6) {
        RecyclerView.LayoutManager r0 = this.mRecyclerView.getLayoutManager();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.mRecyclerView.getAdapter() != null) goto L8;
        return false;
    L8:
        int r2 = this.mRecyclerView.getMinFlingVelocity();
        if (Math.abs(r6) > r2) goto L13;
        if (Math.abs(r5) > r2) goto L13;
        return false;
    L13:
        if (snapFromFling(r0, r5, r6) == false) goto L17;
        return true;
    L17:
        return false;
    }

    void snapToTargetExistingView() {
        RecyclerView r0 = this.mRecyclerView;
        if (r0 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        if (r1 != null) goto L8;
        return;
    L8:
        View r2 = findSnapView(r1);
        if (r2 != null) goto L11;
        return;
    L11:
        int[] r3 = calculateDistanceToFinalSnap(r1, r2);
        if (r3[0] == 0) goto L14;
    L15:
        this.mRecyclerView.smoothScrollBy(r3[0], r3[1]);
        return;
    L14:
        if (r3[1] != 0) goto L15;
    }
}
