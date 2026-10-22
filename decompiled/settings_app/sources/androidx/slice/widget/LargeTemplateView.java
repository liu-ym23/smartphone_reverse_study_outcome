package androidx.slice.widget;

import android.R;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LargeTemplateView extends SliceChildView {
    private final LargeSliceAdapter mAdapter;
    private ArrayList<SliceItem> mDisplayedItems;
    private int mDisplayedItemsHeight;
    private final View mForeground;
    private ListContent mListContent;
    private int[] mLoc;
    private int mMaxSmallHeight;
    private SliceView mParent;
    private final RecyclerView mRecyclerView;
    private boolean mScrollingEnabled;
    private boolean mShowActionSpinner;

    public LargeTemplateView(Context r4) {
        super(r4);
        this.mDisplayedItems = new ArrayList();
        this.mDisplayedItemsHeight = 0;
        this.mLoc = new int[2];
        RecyclerView r0 = new RecyclerView(getContext());
        this.mRecyclerView = r0;
        r0.setLayoutManager(new LinearLayoutManager(getContext()));
        LargeSliceAdapter r1 = new LargeSliceAdapter(r4);
        this.mAdapter = r1;
        r0.setAdapter(r1);
        addView(r0);
        View r5 = new View(getContext());
        this.mForeground = r5;
        r5.setBackground(SliceViewUtil.getDrawable(getContext(), R.attr.selectableItemBackground));
        addView(r5);
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        r3.width = -1;
        r3.height = -1;
        r5.setLayoutParams(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SliceView r0 = (SliceView) getParent();
        this.mParent = r0;
        this.mAdapter.setParents(r0, this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getSize(r4);
        if (this.mScrollingEnabled == false) goto L5;
    L9:
        super.onMeasure(r3, r4);
        return;
    L5:
        if (this.mDisplayedItems.size() <= 0) goto L9;
        if (this.mDisplayedItemsHeight == r0) goto L9;
        updateDisplayedItems(r0);
        goto L9
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setInsets(int r1, int r2, int r3, int r4) {
        super.setInsets(r1, r2, r3, r4);
        this.mAdapter.setInsets(r1, r2, r3, r4);
    }

    public void onForegroundActivated(MotionEvent r6) {
        SliceView r0 = this.mParent;
        if (r0 != null) goto L5;
    L8:
        this.mForeground.getLocationOnScreen(this.mLoc);
        this.mForeground.getBackground().setHotspot((int) (r6.getRawX() - this.mLoc[0]), (int) (r6.getRawY() - this.mLoc[1]));
        int r7 = r6.getActionMasked();
        if (r7 != 0) goto L12;
        this.mForeground.setPressed(true);
        return;
    L12:
        if (r7 == 3) goto L16;
        if (r7 == 1) goto L16;
        if (r7 == 2) goto L16;
        return;
    L16:
        this.mForeground.setPressed(false);
        return;
    L5:
        if (r0.isSliceViewClickable() == true) goto L8;
        this.mForeground.setPressed(false);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setMode(int r3) {
        if (this.mMode == r3) goto L10;
        this.mMode = r3;
        ListContent r4 = this.mListContent;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.isValid() == false) goto L12;
        updateDisplayedItems(this.mListContent.getLargeHeight(-1, this.mScrollingEnabled));
        return;
    L12:
        return;
    }

    @Override // androidx.slice.widget.SliceChildView
    public int getActualHeight() {
        return this.mDisplayedItemsHeight;
    }

    @Override // androidx.slice.widget.SliceChildView
    public int getSmallHeight() {
        ListContent r0 = this.mListContent;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.isValid() == true) goto L8;
        return 0;
    L8:
        return this.mListContent.getSmallHeight();
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setMaxSmallHeight(int r1) {
        this.mMaxSmallHeight = r1;
        this.mAdapter.setMaxSmallHeight(r1);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setActionLoading(SliceItem r2) {
        this.mAdapter.onSliceActionLoading(r2, 0);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setLoadingActions(Set<SliceItem> r1) {
        this.mAdapter.setLoadingActions(r1);
    }

    @Override // androidx.slice.widget.SliceChildView
    public Set<SliceItem> getLoadingActions() {
        return this.mAdapter.getLoadingActions();
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setTint(int r1) {
        super.setTint(r1);
        updateDisplayedItems(getMeasuredHeight());
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setSliceActionListener(SliceView.OnSliceActionListener r1) {
        this.mObserver = r1;
        LargeSliceAdapter r2 = this.mAdapter;
        if (r2 == null) goto L6;
        r2.setSliceObserver(this.mObserver);
        return;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setSliceActions(List<SliceAction> r1) {
        this.mAdapter.setSliceActions(r1);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setSliceContent(ListContent r3) {
        this.mListContent = r3;
        updateDisplayedItems(r3.getLargeHeight(-1, this.mScrollingEnabled));
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setStyle(SliceStyle r1) {
        super.setStyle(r1);
        this.mAdapter.setStyle(r1);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setShowLastUpdated(boolean r1) {
        super.setShowLastUpdated(r1);
        this.mAdapter.setShowLastUpdated(r1);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setLastUpdated(long r1) {
        super.setLastUpdated(r1);
        this.mAdapter.setLastUpdated(r1);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setAllowTwoLines(boolean r1) {
        this.mAdapter.setAllowTwoLines(r1);
    }

    public void setScrollable(boolean r3) {
        if (this.mScrollingEnabled == r3) goto L10;
        this.mScrollingEnabled = r3;
        ListContent r4 = this.mListContent;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.isValid() == false) goto L12;
        updateDisplayedItems(this.mListContent.getLargeHeight(-1, this.mScrollingEnabled));
        return;
    L12:
        return;
    }

    private void updateDisplayedItems(int r5) {
        ListContent r0 = this.mListContent;
        if (r0 != null) goto L5;
    L17:
        resetView();
        return;
    L5:
        if (r0.isValid() == false) goto L17;
        int r1 = getMode();
        if (r1 != 1) goto L11;
        this.mDisplayedItems = new ArrayList(Arrays.asList(new SliceItem[]{this.mListContent.getRowItems().get(0)}));
    L15:
        this.mDisplayedItemsHeight = this.mListContent.getListHeight(this.mDisplayedItems);
        this.mAdapter.setSliceItems(this.mDisplayedItems, this.mTintColor, r1);
        updateOverscroll();
        return;
    L11:
        if (this.mScrollingEnabled == true) goto L14;
        if (r5 == 0) goto L14;
        this.mDisplayedItems = this.mListContent.getItemsForNonScrollingList(r5);
    L14:
        this.mDisplayedItems = this.mListContent.getRowItems();
        goto L15
    }

    private void updateOverscroll() {
        int r2 = 1;
        if (this.mDisplayedItemsHeight <= getMeasuredHeight()) goto L5;
        boolean r0 = true;
    L6:
        RecyclerView r1 = this.mRecyclerView;
        if (this.mScrollingEnabled == false) goto L10;
        if (r0 == false) goto L10;
    L11:
        r1.setOverScrollMode(r2);
        return;
    L10:
        r2 = 2;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.slice.widget.SliceChildView
    public void resetView() {
        this.mDisplayedItemsHeight = 0;
        this.mDisplayedItems.clear();
        this.mAdapter.setSliceItems(null, -1, getMode());
        this.mListContent = null;
    }
}
