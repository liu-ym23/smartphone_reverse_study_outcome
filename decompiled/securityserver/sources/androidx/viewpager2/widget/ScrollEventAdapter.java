package androidx.viewpager2.widget;

import a.a;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private static final int NO_POSITION = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private ViewPager2.OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;

    @NonNull
    private final LinearLayoutManager mLayoutManager;

    @NonNull
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventValues mScrollValues;
    private int mTarget;

    @NonNull
    private final ViewPager2 mViewPager;

    public static final class ScrollEventValues {
        float mOffset;
        int mOffsetPx;
        int mPosition;

        public ScrollEventValues() {
        }

        public void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }
    }

    public ScrollEventAdapter(@NonNull ViewPager2 r1) {
        this.mViewPager = r1;
        RecyclerView r2 = r1.mRecyclerView;
        this.mRecyclerView = r2;
        this.mLayoutManager = (LinearLayoutManager) r2.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int r1, float r2, int r3) {
        ViewPager2.OnPageChangeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onPageScrolled(r1, r2, r3);
        return;
    }

    private void dispatchSelected(int r1) {
        ViewPager2.OnPageChangeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onPageSelected(r1);
        return;
    }

    private void dispatchStateChanged(int r3) {
        if (this.mAdapterState != 3) goto L8;
        if (this.mScrollState != 0) goto L8;
        return;
    L8:
        if (this.mScrollState != r3) goto L10;
        return;
    L10:
        this.mScrollState = r3;
        ViewPager2.OnPageChangeCallback r2 = this.mCallback;
        if (r2 == null) goto L14;
        r2.onPageScrollStateChanged(r3);
        return;
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int r2 = this.mAdapterState;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 4) goto L10;
        return false;
    L10:
        return true;
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    private void startDrag(boolean r3) {
        this.mFakeDragging = r3;
        if (r3 == false) goto L5;
        int r4 = 4;
    L6:
        this.mAdapterState = r4;
        int r5 = this.mTarget;
        if (r5 == (-1)) goto L10;
        this.mDragStartPosition = r5;
        this.mTarget = -1;
    L12:
        dispatchStateChanged(1);
        return;
    L10:
        if (this.mDragStartPosition != (-1)) goto L12;
        this.mDragStartPosition = getPosition();
        goto L12
    L5:
        r4 = 1;
        goto L6
    }

    private void updateScrollEventValues() {
        ScrollEventValues r0 = this.mScrollValues;
        int r1 = this.mLayoutManager.findFirstVisibleItemPosition();
        r0.mPosition = r1;
        if (r1 != (-1)) goto L6;
        r0.reset();
        return;
    L6:
        View r2 = this.mLayoutManager.findViewByPosition(r1);
        if (r2 != null) goto L10;
        r0.reset();
        return;
    L10:
        int r3 = this.mLayoutManager.getLeftDecorationWidth(r2);
        int r4 = this.mLayoutManager.getRightDecorationWidth(r2);
        int r5 = this.mLayoutManager.getTopDecorationHeight(r2);
        int r6 = this.mLayoutManager.getBottomDecorationHeight(r2);
        ViewGroup.LayoutParams r7 = r2.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        r3 = r3 + r8.leftMargin;
        r4 = r4 + r8.rightMargin;
        r5 = r5 + r8.topMargin;
        r6 = r6 + r8.bottomMargin;
    L13:
        int r9 = (r2.getHeight() + r5) + r6;
        int r10 = (r2.getWidth() + r3) + r4;
        if (this.mLayoutManager.getOrientation() != 0) goto L19;
        int r11 = (r2.getLeft() - r3) - this.mRecyclerView.getPaddingLeft();
        if (this.mViewPager.isRtl() == false) goto L18;
        r11 = -r11;
    L18:
        r9 = r10;
    L20:
        int r12 = -r11;
        r0.mOffsetPx = r12;
        if (r12 < 0) goto L23;
        if (r9 != 0) goto L30;
        float r13 = 0.0f;
    L31:
        r0.mOffset = r13;
        return;
    L30:
        r13 = r12 / r9;
        goto L31
    L23:
        if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations() == true) goto L25;
        Locale r14 = Locale.US;
        throw new IllegalStateException(a.e(r0.mOffsetPx, "Page can only be offset by a positive amount, not by "));
    L25:
        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
    L19:
        r11 = (r2.getTop() - r5) - this.mRecyclerView.getPaddingTop();
        goto L20
    }

    public double getRelativeScrollPosition() {
        updateScrollEventValues();
        ScrollEventValues r4 = this.mScrollValues;
        return ((double) r4.mPosition) + ((double) r4.mOffset);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isDragging() {
        if (this.mScrollState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public boolean isIdle() {
        if (this.mScrollState != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        startDrag(true);
    }

    public void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    public void notifyEndFakeDrag() {
        if (isDragging() == true) goto L5;
    L7:
        this.mFakeDragging = false;
        updateScrollEventValues();
        ScrollEventValues r1 = this.mScrollValues;
        if (r1.mOffsetPx != 0) goto L13;
        int r2 = r1.mPosition;
        if (r2 == this.mDragStartPosition) goto L12;
        dispatchSelected(r2);
    L12:
        dispatchStateChanged(0);
        resetState();
        return;
    L13:
        dispatchStateChanged(2);
        return;
    L5:
        if (this.mFakeDragging == true) goto L7;
    }

    public void notifyProgrammaticScroll(int r3, boolean r4) {
        if (r4 == false) goto L5;
        int r5 = 2;
    L6:
        this.mAdapterState = r5;
        boolean r6 = false;
        this.mFakeDragging = false;
        if (this.mTarget == r3) goto L9;
        r6 = true;
    L9:
        this.mTarget = r3;
        dispatchStateChanged(2);
        if (r6 == false) goto L13;
        dispatchSelected(r3);
        return;
    L13:
        return;
    L5:
        r5 = 3;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView r5, int r6) {
        if (this.mAdapterState == 1) goto L5;
    L6:
        if (r6 != 1) goto L10;
        startDrag(false);
        return;
    L10:
        if (isInAnyDraggingState() == false) goto L17;
        if (r6 != 2) goto L17;
        if (this.mScrollHappened == false) goto L44;
        dispatchStateChanged(2);
        this.mDispatchSelected = true;
        return;
    L44:
        return;
    L17:
        if (isInAnyDraggingState() == false) goto L31;
        if (r6 != 0) goto L31;
        updateScrollEventValues();
        if (this.mScrollHappened == true) goto L24;
        int r7 = this.mScrollValues.mPosition;
        if (r7 == (-1)) goto L29;
        dispatchScrolled(r7, 0.0f, 0);
    L29:
        dispatchStateChanged(0);
        resetState();
        goto L31
    L24:
        ScrollEventValues r8 = this.mScrollValues;
        if (r8.mOffsetPx != 0) goto L31;
        int r3 = this.mDragStartPosition;
        int r9 = r8.mPosition;
        if (r3 == r9) goto L29;
        dispatchSelected(r9);
    L31:
        if (this.mAdapterState != 2) goto L45;
        if (r6 == 0) goto L34;
        return;
    L34:
        if (this.mDataSetChangeHappened == false) goto L47;
        updateScrollEventValues();
        ScrollEventValues r10 = this.mScrollValues;
        if (r10.mOffsetPx != 0) goto L48;
        int r11 = this.mTarget;
        int r12 = r10.mPosition;
        if (r11 == r12) goto L42;
        if (r12 != (-1)) goto L41;
        r12 = 0;
    L41:
        dispatchSelected(r12);
    L42:
        dispatchStateChanged(0);
        resetState();
        return;
    L48:
        return;
    L47:
        return;
    L45:
        return;
    L5:
        if (this.mScrollState == 1) goto L10;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView r4, int r5, int r6) {
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected == false) goto L20;
        this.mDispatchSelected = false;
        if (r6 > 0) goto L12;
        if (r6 != 0) goto L15;
        if (r5 >= 0) goto L9;
        boolean r7 = true;
    L11:
        if (r7 != this.mViewPager.isRtl()) goto L15;
    L9:
        r7 = false;
    L15:
        int r8 = this.mScrollValues.mPosition;
    L16:
        this.mTarget = r8;
        if (this.mDragStartPosition == r8) goto L25;
        dispatchSelected(r8);
    L25:
        ScrollEventValues r9 = this.mScrollValues;
        int r10 = r9.mPosition;
        if (r10 != (-1)) goto L28;
        r10 = 0;
    L28:
        dispatchScrolled(r10, r9.mOffset, r9.mOffsetPx);
        ScrollEventValues r11 = this.mScrollValues;
        int r12 = r11.mPosition;
        int r0 = this.mTarget;
        if (r12 == r0) goto L32;
        if (r0 == (-1)) goto L32;
        return;
    L32:
        if (r11.mOffsetPx == 0) goto L34;
        return;
    L34:
        if (this.mScrollState == 1) goto L39;
        dispatchStateChanged(0);
        resetState();
        return;
    L39:
        return;
    L12:
        ScrollEventValues r13 = this.mScrollValues;
        if (r13.mOffsetPx == 0) goto L15;
        r8 = r13.mPosition + 1;
        goto L16
    L20:
        if (this.mAdapterState != 0) goto L25;
        int r14 = this.mScrollValues.mPosition;
        if (r14 != (-1)) goto L24;
        r14 = 0;
    L24:
        dispatchSelected(r14);
        goto L25
    }

    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback r1) {
        this.mCallback = r1;
    }
}
