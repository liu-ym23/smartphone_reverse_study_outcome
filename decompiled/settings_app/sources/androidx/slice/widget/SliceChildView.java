package androidx.slice.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceAction;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class SliceChildView extends FrameLayout {
    protected int mInsetBottom;
    protected int mInsetEnd;
    protected int mInsetStart;
    protected int mInsetTop;
    protected long mLastUpdated;
    protected SliceActionView.SliceActionLoadingListener mLoadingListener;
    protected int mMode;
    protected SliceView.OnSliceActionListener mObserver;
    protected boolean mShowLastUpdated;
    protected SliceStyle mSliceStyle;
    protected int mTintColor;

    public int getActualHeight() {
        return 0;
    }

    public Set<SliceItem> getLoadingActions() {
        return null;
    }

    public int getSmallHeight() {
        return 0;
    }

    public abstract void resetView();

    public void setActionLoading(SliceItem r1) {
    }

    public void setAllowTwoLines(boolean r1) {
    }

    public void setLoadingActions(Set<SliceItem> r1) {
    }

    public void setMaxSmallHeight(int r1) {
    }

    public void setSliceActions(List<SliceAction> r1) {
    }

    public void setSliceContent(ListContent r1) {
    }

    public void setSliceItem(SliceItem r1, boolean r2, int r3, int r4, SliceView.OnSliceActionListener r5) {
    }

    public SliceChildView(Context r3) {
        super(r3);
        this.mTintColor = -1;
        this.mLastUpdated = -1;
    }

    public SliceChildView(Context r1, AttributeSet r2) {
        this(r1);
    }

    public void setInsets(int r1, int r2, int r3, int r4) {
        this.mInsetStart = r1;
        this.mInsetTop = r2;
        this.mInsetEnd = r3;
        this.mInsetBottom = r4;
    }

    public void setMode(int r1) {
        this.mMode = r1;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setTint(int r1) {
        this.mTintColor = r1;
    }

    public void setShowLastUpdated(boolean r1) {
        this.mShowLastUpdated = r1;
    }

    public void setLastUpdated(long r1) {
        this.mLastUpdated = r1;
    }

    public void setSliceActionListener(SliceView.OnSliceActionListener r1) {
        this.mObserver = r1;
    }

    public void setSliceActionLoadingListener(SliceActionView.SliceActionLoadingListener r1) {
        this.mLoadingListener = r1;
    }

    public void setStyle(SliceStyle r1) {
        this.mSliceStyle = r1;
    }
}
