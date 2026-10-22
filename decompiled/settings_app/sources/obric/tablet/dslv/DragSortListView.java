package obric.tablet.dslv;

import android.R;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class DragSortListView extends ListView {
    public static final int DRAGGING = 4;
    public static final int DRAG_NEG_X = 2;
    public static final int DRAG_NEG_Y = 8;
    public static final int DRAG_POS_X = 1;
    public static final int DRAG_POS_Y = 4;
    public static final int DROPPING = 2;
    public static final int IDLE = 0;
    private static final int NO_CANCEL = 0;
    private static final int ON_INTERCEPT_TOUCH_EVENT = 2;
    private static final int ON_TOUCH_EVENT = 1;
    public static final int REMOVING = 1;
    public static final int STOPPED = 3;
    private static final int sCacheSize = 3;
    private AdapterWrapper mAdapterWrapper;
    private long mAdjustAnimDuration;
    private boolean mAdjustAnimate;
    private boolean mAnimate;
    private boolean mBlockLayoutRequests;
    private final MotionEvent mCancelEvent;
    private int mCancelMethod;
    private final HeightCache mChildHeightCache;
    private float mCurrFloatAlpha;
    private int mDownScrollStartY;
    private float mDownScrollStartYF;
    private int mDragDeltaX;
    private int mDragDeltaY;
    private float mDragDownScrollHeight;
    private float mDragDownScrollStartFrac;
    private boolean mDragEnabled;
    private int mDragFlags;
    private DragListener mDragListener;
    private final DragScroller mDragScroller;
    private int mDragStartY;
    public int mDragState;
    private float mDragUpScrollHeight;
    private float mDragUpScrollStartFrac;
    private DropAnimator mDropAnimator;
    private DropListener mDropListener;
    private int mFirstExpPos;
    private float mFloatAlpha;
    private final Point mFloatLoc;
    private int mFloatPos;
    private View mFloatView;
    private int mFloatViewHeight;
    private int mFloatViewHeightHalf;
    private boolean mFloatViewInvalidated;
    private FloatViewManager mFloatViewManager;
    private int mFloatViewMid;
    private boolean mFloatViewOnMeasured;
    private int mFromPosition;
    private boolean mIgnoreTouchEvent;
    private boolean mInTouchEvent;
    private int mItemHeightCollapsed;
    private boolean mLastCallWasIntercept;
    private int mLastX;
    private int mLastY;
    private LiftAnimator mLiftAnimator;
    private boolean mListViewIntercepted;
    private float mMaxScrollSpeed;
    private final DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private RemoveAnimator mRemoveAnimator;
    private RemoveListener mRemoveListener;
    private float mRemoveVelocityX;
    private View[] mSampleViewTypes;
    private DragScrollProfile mScrollProfile;
    private int mSecondExpPos;
    private float mSlideFrac;
    private float mSlideRegionFrac;
    private int mSrcPos;
    private final Point mTouchLoc;
    private int mUpScrollStartY;
    private float mUpScrollStartYF;
    private boolean mUseRemoveVelocity;
    private int mWidthMeasureSpec;
    private int mX;
    private int mY;

    private class AdapterWrapper extends BaseAdapter {
        private final ListAdapter mAdapter;
        final /* synthetic */ DragSortListView this$0;

        public AdapterWrapper(final DragSortListView r2, ListAdapter r3) {
            this.this$0 = r2;
            this.mAdapter = r3;
            r3.registerDataSetObserver(new AnonymousClass1(this, r2));
        }

        public ListAdapter getAdapter() {
            return this.mAdapter;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return this.mAdapter.getItemId(r1);
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.mAdapter.getItem(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mAdapter.getCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.mAdapter.areAllItemsEnabled();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return this.mAdapter.isEnabled(r1);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            return this.mAdapter.getItemViewType(r1);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.mAdapter.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.mAdapter.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.mAdapter.isEmpty();
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 == null) goto L8;
            DragSortItemView r7 = (DragSortItemView) r5;
            View r0 = r7.getChildAt(0);
            View r1 = this.mAdapter.getView(r4, r0, this.this$0);
            if (r1 == r0) goto L9;
            if (r0 == null) goto L7;
            r7.removeViewAt(0);
        L7:
            r7.addView(r1);
        L9:
            DragSortListView r3 = this.this$0;
            DragSortListView.access$100(r3, r4 + r3.getHeaderViewsCount(), r7, true);
            return r7;
        L8:
            View r8 = this.mAdapter.getView(r4, null, this.this$0);
            DragSortItemView r9 = new DragSortItemView(this.this$0.getContext());
            r9.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            r9.addView(r8);
            r7 = r9;
            goto L9
        }
    }

    public interface DragListener {
        void drag(int r1, int r2);
    }

    public interface DragScrollProfile {
        float getSpeed(float r1, long r2);
    }

    private class DragScroller implements Runnable {
        public static final int DOWN = 1;
        public static final int STOP = -1;
        public static final int UP = 0;
        private float dt;
        private int dy;
        private boolean mAbort;
        private long mCurrTime;
        private int mFirstFooter;
        private int mLastHeader;
        private long mPrevTime;
        private float mScrollSpeed;
        private boolean mScrolling;
        private int scrollDir;
        private long tStart;
        final /* synthetic */ DragSortListView this$0;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int getScrollDir() {
            if (this.mScrolling == true) goto L7;
            return -1;
        L7:
            return this.scrollDir;
        }

        public DragScroller(DragSortListView r1) {
            this.this$0 = r1;
            this.mScrolling = false;
        }

        public void startScrolling(int r3) {
            if (this.mScrolling == true) goto L6;
            this.mAbort = false;
            this.mScrolling = true;
            long r0 = SystemClock.uptimeMillis();
            this.tStart = r0;
            this.mPrevTime = r0;
            this.scrollDir = r3;
            this.this$0.post(this);
            return;
        }

        public void stopScrolling(boolean r1) {
            if (r1 == false) goto L4;
            this.this$0.removeCallbacks(this);
            this.mScrolling = false;
            return;
        L4:
            this.mAbort = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mAbort == false) goto L6;
            this.mScrolling = false;
            return;
        L6:
            int r0 = this.this$0.getFirstVisiblePosition();
            int r2 = this.this$0.getLastVisiblePosition();
            int r3 = this.this$0.getCount();
            int r4 = this.this$0.getPaddingTop();
            int r5 = (this.this$0.getHeight() - r4) - this.this$0.getPaddingBottom();
            int r6 = Math.min(DragSortListView.access$500(this.this$0), DragSortListView.access$2000(this.this$0) + DragSortListView.access$300(this.this$0));
            int r7 = Math.max(DragSortListView.access$500(this.this$0), DragSortListView.access$2000(this.this$0) - DragSortListView.access$300(this.this$0));
            if (this.scrollDir != 0) goto L18;
            View r8 = this.this$0.getChildAt(0);
            if (r8 != null) goto L12;
            this.mScrolling = false;
            return;
        L12:
            if (r0 == 0) goto L14;
        L17:
            this.mScrollSpeed = DragSortListView.access$2300(this.this$0).getSpeed((DragSortListView.access$2100(this.this$0) - r7) / DragSortListView.access$2200(this.this$0), this.mPrevTime);
        L29:
            long r9 = SystemClock.uptimeMillis();
            this.mCurrTime = r9;
            float r10 = r9 - this.mPrevTime;
            this.dt = r10;
            int r11 = Math.round(this.mScrollSpeed * r10);
            this.dy = r11;
            if (r11 < 0) goto L32;
            this.dy = Math.min(r5, r11);
            r2 = r0;
        L33:
            View r1 = this.this$0.getChildAt(r2 - r0);
            int r12 = r1.getTop() + this.dy;
            if (r2 != 0) goto L37;
            if (r12 <= r4) goto L37;
            r12 = r4;
        L37:
            DragSortListView.access$2602(this.this$0, true);
            this.this$0.setSelectionFromTop(r2, r12 - r4);
            this.this$0.layoutChildren();
            this.this$0.invalidate();
            DragSortListView.access$2602(this.this$0, false);
            DragSortListView.access$2700(this.this$0, r2, r1, false);
            this.mPrevTime = this.mCurrTime;
            this.this$0.post(this);
            return;
        L32:
            this.dy = Math.max(-r5, r11);
            goto L33
        L14:
            if (r8.getTop() != r4) goto L17;
            this.mScrolling = false;
            return;
        L18:
            View r13 = this.this$0.getChildAt(r2 - r0);
            if (r13 != null) goto L23;
            this.mScrolling = false;
            return;
        L23:
            if (r2 == (r3 - 1)) goto L25;
        L28:
            this.mScrollSpeed = -DragSortListView.access$2300(this.this$0).getSpeed((r6 - DragSortListView.access$2400(this.this$0)) / DragSortListView.access$2500(this.this$0), this.mPrevTime);
            goto L29
        L25:
            if (r13.getBottom() > (r5 + r4)) goto L28;
            this.mScrolling = false;
        }
    }

    public interface DragSortListener extends DropListener, DragListener, RemoveListener {
    }

    private class DropAnimator extends SmoothAnimator {
        private int mDropPos;
        private float mInitDeltaX;
        private float mInitDeltaY;
        private int srcPos;
        final /* synthetic */ DragSortListView this$0;

        public DropAnimator(DragSortListView r1, float r2, int r3) {
            this.this$0 = r1;
            super(r1, r2, r3);
        }

        @Override // obric.tablet.dslv.DragSortListView.SmoothAnimator
        public void onStart() {
            this.mDropPos = DragSortListView.access$700(this.this$0);
            this.srcPos = DragSortListView.access$800(this.this$0);
            this.this$0.mDragState = 2;
            this.mInitDeltaY = DragSortListView.access$400(this.this$0).y - getTargetY();
            this.mInitDeltaX = DragSortListView.access$400(this.this$0).x - this.this$0.getPaddingLeft();
        }

        private int getTargetY() {
            int r0 = this.this$0.getFirstVisiblePosition();
            int r1 = (DragSortListView.access$900(this.this$0) + this.this$0.getDividerHeight()) / 2;
            View r2 = this.this$0.getChildAt(this.mDropPos - r0);
            if (r2 == null) goto L10;
            int r3 = this.mDropPos;
            int r4 = this.srcPos;
            if (r3 == r4) goto L12;
            if (r3 >= r4) goto L14;
            return r2.getTop() - r1;
        L14:
            return (r2.getBottom() + r1) - DragSortListView.access$1000(this.this$0);
        L12:
            return r2.getTop();
        L10:
            cancel();
            DragSortListView.access$1100(this.this$0);
            return -1;
        }

        @Override // obric.tablet.dslv.DragSortListView.SmoothAnimator
        public void onUpdate(float r6, float r7) {
            int r0 = getTargetY();
            int r1 = this.this$0.getPaddingLeft();
            float r2 = DragSortListView.access$400(this.this$0).y - r0;
            float r3 = DragSortListView.access$400(this.this$0).x - r1;
            float r8 = 1.0f - r7;
            if (r8 >= Math.abs(r2 / this.mInitDeltaY)) goto L5;
        L6:
            DragSortListView.access$400(this.this$0).y = r0 + ((int) (this.mInitDeltaY * r8));
            DragSortListView.access$400(this.this$0).x = this.this$0.getPaddingLeft() + ((int) (this.mInitDeltaX * r8));
            if (DragSortListView.access$1200(this.this$0) != null) goto L9;
        L11:
            DragSortListView.access$600(this.this$0, true);
            return;
        L9:
            if (DragSortListView.access$1200(this.this$0).getBackground() == null) goto L11;
            DragSortListView.access$1200(this.this$0).getBackground().setAlpha((int) ((1.0f - r6) * 255.0f));
            goto L11
        L5:
            if (r8 < Math.abs(r3 / this.mInitDeltaX)) goto L6;
        }

        @Override // obric.tablet.dslv.DragSortListView.SmoothAnimator
        public void onStop() {
            DragSortListView.access$1100(this.this$0);
        }
    }

    public interface DropListener {
        void drop(int r1, int r2);
    }

    private class FixRemoveAnimator extends RemoveAnimator {
        final /* synthetic */ DragSortListView this$0;

        public FixRemoveAnimator(DragSortListView r1, float r2, int r3) {
            this.this$0 = r1;
            super(r1, r2, r3);
        }

        @Override // obric.tablet.dslv.DragSortListView.RemoveAnimator, obric.tablet.dslv.DragSortListView.SmoothAnimator
        public void onUpdate(float r2, float r3) {
            super.onUpdate(r2, r3);
            float r4 = 1.0f - r3;
            int r5 = this.this$0.getFirstVisiblePosition();
            DragSortListView r1 = this.this$0;
            View r6 = r1.getChildAt(DragSortListView.access$800(r1) - r5);
            if (r6 == null) goto L6;
            int r7 = Math.max((int) (r4 * r6.getHeight()), 1);
            ViewGroup.LayoutParams r8 = r6.getLayoutParams();
            r8.height = r7;
            r6.setLayoutParams(r8);
            return;
        }
    }

    public interface FloatViewManager {
        int getPaddingBottom();

        int getPaddingTop();

        View onCreateFloatView(int r1);

        void onDestroyFloatView(View r1);

        void onDragFloatView(View r1, Point r2, Point r3);
    }

    private class HeightCache {
        private final SparseIntArray mMap;
        private final int mMaxSize;
        private final ArrayList<Integer> mOrder;
        final /* synthetic */ DragSortListView this$0;

        public HeightCache(DragSortListView r1, int r2) {
            this.this$0 = r1;
            this.mMap = new SparseIntArray(r2);
            this.mOrder = new ArrayList(r2);
            this.mMaxSize = r2;
        }

        public void add(int r4, int r5) {
            int r0 = this.mMap.get(r4, -1);
            if (r0 == r5) goto L11;
            if (r0 == (-1)) goto L6;
            this.mOrder.remove(Integer.valueOf(r4));
        L9:
            this.mMap.put(r4, r5);
            this.mOrder.add(Integer.valueOf(r4));
            return;
        L6:
            if (this.mMap.size() != this.mMaxSize) goto L9;
            this.mMap.delete(this.mOrder.remove(0).intValue());
            goto L9
        }

        public int get(int r2) {
            return this.mMap.get(r2, -1);
        }

        public void clear() {
            this.mMap.clear();
            this.mOrder.clear();
        }
    }

    private class LiftAnimator extends SmoothAnimator {
        private float mFinalDragDeltaY;
        private float mInitDragDeltaY;
        final /* synthetic */ DragSortListView this$0;

        public LiftAnimator(DragSortListView r1, float r2, int r3) {
            this.this$0 = r1;
            super(r1, r2, r3);
        }

        @Override // obric.tablet.dslv.DragSortListView.SmoothAnimator
        public void onStart() {
            this.mInitDragDeltaY = DragSortListView.access$200(this.this$0);
            this.mFinalDragDeltaY = DragSortListView.access$300(this.this$0);
        }

        @Override // obric.tablet.dslv.DragSortListView.SmoothAnimator
        public void onUpdate(float r3, float r4) {
            if (this.this$0.mDragState == 4) goto L5;
            cancel();
            return;
        L5:
            DragSortListView.access$202(this.this$0, (int) ((this.mFinalDragDeltaY * r4) + ((1.0f - r4) * this.mInitDragDeltaY)));
            Point r5 = DragSortListView.access$400(this.this$0);
            r5.y = DragSortListView.access$500(this.this$0) - DragSortListView.access$200(this.this$0);
            DragSortListView.access$600(this.this$0, true);
        }
    }

    private class RemoveAnimator extends SmoothAnimator {
        private int mFirstChildHeight;
        private int mFirstPos;
        private float mFirstStartBlank;
        private float mFloatLocX;
        private int mSecondChildHeight;
        private int mSecondPos;
        private float mSecondStartBlank;
        private int srcPos;
        final /* synthetic */ DragSortListView this$0;

        public RemoveAnimator(DragSortListView r1, float r2, int r3) {
            this.this$0 = r1;
            super(r1, r2, r3);
            this.mFirstChildHeight = -1;
            this.mSecondChildHeight = -1;
        }

        @Override // obric.tablet.dslv.DragSortListView.SmoothAnimator
        public void onStart() {
            int r0 = -1;
            this.mFirstChildHeight = -1;
            this.mSecondChildHeight = -1;
            this.mFirstPos = DragSortListView.access$1300(this.this$0);
            this.mSecondPos = DragSortListView.access$1400(this.this$0);
            this.srcPos = DragSortListView.access$800(this.this$0);
            this.this$0.mDragState = 1;
            this.mFloatLocX = DragSortListView.access$400(this.this$0).x;
            if (DragSortListView.access$1500(this.this$0) == false) goto L21;
            float r1 = this.this$0.getWidth() * 2.0f;
            if (DragSortListView.access$1600(this.this$0) != 0.0f) goto L11;
            DragSortListView r3 = this.this$0;
            if (this.mFloatLocX < 0.0f) goto L10;
            r0 = 1;
        L10:
            DragSortListView.access$1602(r3, r0 * r1);
            return;
        L11:
            float r2 = r1 * 2.0f;
            if (DragSortListView.access$1600(this.this$0) >= 0.0f) goto L17;
            float r4 = -r2;
            if (DragSortListView.access$1600(this.this$0) <= r4) goto L17;
            DragSortListView.access$1602(this.this$0, r4);
            return;
        L17:
            if (DragSortListView.access$1600(this.this$0) > 0.0f) goto L19;
            return;
        L19:
            if (DragSortListView.access$1600(this.this$0) >= r2) goto L26;
            DragSortListView.access$1602(this.this$0, r2);
            return;
        L26:
            return;
        L21:
            DragSortListView.access$1700(this.this$0);
        }

        @Override // obric.tablet.dslv.DragSortListView.SmoothAnimator
        public void onUpdate(float r10, float r11) {
            float r12 = 1.0f - r11;
            int r13 = this.this$0.getFirstVisiblePosition();
            View r0 = this.this$0.getChildAt(this.mFirstPos - r13);
            if (DragSortListView.access$1500(this.this$0) == false) goto L18;
            float r1 = (SystemClock.uptimeMillis() - this.mStartTime) / 1000.0f;
            if (r1 != 0.0f) goto L7;
            return;
        L7:
            float r5 = DragSortListView.access$1600(this.this$0) * r1;
            int r6 = this.this$0.getWidth();
            DragSortListView r7 = this.this$0;
            if (DragSortListView.access$1600(r7) <= 0.0f) goto L10;
            int r4 = 1;
        L11:
            float r8 = r4 * r1;
            float r2 = r6;
            DragSortListView.access$1616(r7, r8 * r2);
            this.mFloatLocX += r5;
            DragSortListView.access$400(this.this$0).x = (int) this.mFloatLocX;
            float r9 = this.mFloatLocX;
            if (r9 >= r2) goto L18;
            if (r9 <= (-r6)) goto L18;
            this.mStartTime = SystemClock.uptimeMillis();
            DragSortListView.access$600(this.this$0, true);
            return;
        L10:
            r4 = -1;
        L18:
            if (r0 != null) goto L20;
        L23:
            int r3 = this.mSecondPos;
            if (r3 == this.mFirstPos) goto L32;
            View r14 = this.this$0.getChildAt(r3 - r13);
            if (r14 != null) goto L28;
            return;
        L28:
            if (this.mSecondChildHeight != (-1)) goto L30;
            this.mSecondChildHeight = DragSortListView.access$1800(this.this$0, this.mSecondPos, r14, false);
            this.mSecondStartBlank = r14.getHeight() - this.mSecondChildHeight;
        L30:
            int r15 = Math.max((int) (r12 * this.mSecondStartBlank), 1);
            ViewGroup.LayoutParams r16 = r14.getLayoutParams();
            r16.height = this.mSecondChildHeight + r15;
            r14.setLayoutParams(r16);
            return;
        L32:
            return;
        L20:
            if (this.mFirstChildHeight != (-1)) goto L22;
            this.mFirstChildHeight = DragSortListView.access$1800(this.this$0, this.mFirstPos, r0, false);
            this.mFirstStartBlank = r0.getHeight() - this.mFirstChildHeight;
        L22:
            int r17 = Math.max((int) (this.mFirstStartBlank * r12), 1);
            ViewGroup.LayoutParams r18 = r0.getLayoutParams();
            r18.height = this.mFirstChildHeight + r17;
            r0.setLayoutParams(r18);
            goto L23
        }

        @Override // obric.tablet.dslv.DragSortListView.SmoothAnimator
        public void onStop() {
            DragSortListView.access$1900(this.this$0);
        }
    }

    public interface RemoveListener {
        void remove(int r1);
    }

    private class SmoothAnimator implements Runnable {
        private final float mA;
        private final float mAlpha;
        private final float mB;
        private final float mC;
        private boolean mCanceled;
        private float mD;
        private final float mDurationF;
        protected long mStartTime;
        final /* synthetic */ DragSortListView this$0;

        public void onStart() {
        }

        public void onStop() {
        }

        public void onUpdate(float r1, float r2) {
        }

        public SmoothAnimator(DragSortListView r3, float r4, int r5) {
            this.this$0 = r3;
            this.mAlpha = r4;
            this.mDurationF = r5;
            float r6 = 1.0f / ((r4 * 2.0f) * (1.0f - r4));
            this.mD = r6;
            this.mA = r6;
            this.mB = r4 / ((r4 - 1.0f) * 2.0f);
            this.mC = 1.0f / (1.0f - r4);
        }

        public float transform(float r3) {
            float r0 = this.mAlpha;
            if (r3 >= r0) goto L7;
            return (this.mA * r3) * r3;
        L7:
            if (r3 < (1.0f - r0)) goto L9;
            float r4 = r3 - 1.0f;
            return 1.0f - ((this.mD * r4) * r4);
        L9:
            return this.mB + (this.mC * r3);
        }

        public void start() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.mCanceled = false;
            onStart();
            this.this$0.post(this);
        }

        public void cancel() {
            this.mCanceled = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            float r0 = (SystemClock.uptimeMillis() - this.mStartTime) / this.mDurationF;
            if (r0 < 1.0f) goto L8;
            onUpdate(1.0f, 1.0f);
            onStop();
            return;
        L8:
            onUpdate(r0, transform(r0));
            this.this$0.post(this);
        }
    }

    private static int rotate(int r1, int r2, int r3, int r4) {
        int r0 = r4 - r3;
        int r5 = r1 + r2;
        if (r5 < r3) goto L8;
        if (r5 >= r4) goto L7;
        return r5;
    L7:
        return r5 - r0;
    L8:
        return r5 + r0;
    }

    static /* synthetic */ float access$000(DragSortListView r0) {
        return r0.mMaxScrollSpeed;
    }

    static /* synthetic */ void access$100(DragSortListView r0, int r1, View r2, boolean r3) {
        r0.adjustItem(r1, r2, r3);
    }

    static /* synthetic */ int access$1000(DragSortListView r0) {
        return r0.mFloatViewHeight;
    }

    static /* synthetic */ void access$1100(DragSortListView r0) {
        r0.dropFloatView();
    }

    static /* synthetic */ View access$1200(DragSortListView r0) {
        return r0.mFloatView;
    }

    static /* synthetic */ int access$1300(DragSortListView r0) {
        return r0.mFirstExpPos;
    }

    static /* synthetic */ int access$1400(DragSortListView r0) {
        return r0.mSecondExpPos;
    }

    static /* synthetic */ boolean access$1500(DragSortListView r0) {
        return r0.mUseRemoveVelocity;
    }

    static /* synthetic */ float access$1600(DragSortListView r0) {
        return r0.mRemoveVelocityX;
    }

    static /* synthetic */ float access$1602(DragSortListView r0, float r1) {
        r0.mRemoveVelocityX = r1;
        return r1;
    }

    static /* synthetic */ float access$1616(DragSortListView r1, float r2) {
        float r0 = r1.mRemoveVelocityX + r2;
        r1.mRemoveVelocityX = r0;
        return r0;
    }

    static /* synthetic */ void access$1700(DragSortListView r0) {
        r0.destroyFloatView();
    }

    static /* synthetic */ int access$1800(DragSortListView r0, int r1, View r2, boolean r3) {
        return r0.getChildHeight(r1, r2, r3);
    }

    static /* synthetic */ void access$1900(DragSortListView r0) {
        r0.doRemoveItem();
    }

    static /* synthetic */ int access$200(DragSortListView r0) {
        return r0.mDragDeltaY;
    }

    static /* synthetic */ int access$2000(DragSortListView r0) {
        return r0.mFloatViewMid;
    }

    static /* synthetic */ int access$202(DragSortListView r0, int r1) {
        r0.mDragDeltaY = r1;
        return r1;
    }

    static /* synthetic */ float access$2100(DragSortListView r0) {
        return r0.mUpScrollStartYF;
    }

    static /* synthetic */ float access$2200(DragSortListView r0) {
        return r0.mDragUpScrollHeight;
    }

    static /* synthetic */ DragScrollProfile access$2300(DragSortListView r0) {
        return r0.mScrollProfile;
    }

    static /* synthetic */ float access$2400(DragSortListView r0) {
        return r0.mDownScrollStartYF;
    }

    static /* synthetic */ float access$2500(DragSortListView r0) {
        return r0.mDragDownScrollHeight;
    }

    static /* synthetic */ boolean access$2602(DragSortListView r0, boolean r1) {
        r0.mBlockLayoutRequests = r1;
        return r1;
    }

    static /* synthetic */ void access$2700(DragSortListView r0, int r1, View r2, boolean r3) {
        r0.doDragFloatView(r1, r2, r3);
    }

    static /* synthetic */ int access$300(DragSortListView r0) {
        return r0.mFloatViewHeightHalf;
    }

    static /* synthetic */ Point access$400(DragSortListView r0) {
        return r0.mFloatLoc;
    }

    static /* synthetic */ int access$500(DragSortListView r0) {
        return r0.mY;
    }

    static /* synthetic */ void access$600(DragSortListView r0, boolean r1) {
        r0.doDragFloatView(r1);
    }

    static /* synthetic */ int access$700(DragSortListView r0) {
        return r0.mFloatPos;
    }

    static /* synthetic */ int access$800(DragSortListView r0) {
        return r0.mSrcPos;
    }

    static /* synthetic */ int access$900(DragSortListView r0) {
        return r0.mItemHeightCollapsed;
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

    public DragSortListView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.listViewStyle);
    }

    public DragSortListView(Context r19, AttributeSet r20, int r21) {
        super(r19, r20, r21);
        this.mFloatLoc = new Point();
        this.mTouchLoc = new Point();
        this.mFloatViewOnMeasured = false;
        this.mFloatAlpha = 1.0f;
        this.mCurrFloatAlpha = 1.0f;
        this.mAnimate = false;
        this.mAdjustAnimate = false;
        this.mAdjustAnimDuration = 0;
        this.mDragEnabled = true;
        this.mDragState = 0;
        this.mItemHeightCollapsed = 1;
        this.mWidthMeasureSpec = 0;
        this.mSampleViewTypes = new View[1];
        this.mDragUpScrollStartFrac = 0.33333334f;
        this.mDragDownScrollStartFrac = 0.33333334f;
        this.mMaxScrollSpeed = 0.5f;
        this.mScrollProfile = new AnonymousClass1(this);
        this.mDragFlags = 0;
        this.mLastCallWasIntercept = false;
        this.mInTouchEvent = false;
        this.mFloatViewManager = null;
        this.mCancelMethod = 0;
        this.mSlideRegionFrac = 0.25f;
        this.mSlideFrac = 0.0f;
        this.mBlockLayoutRequests = false;
        this.mIgnoreTouchEvent = false;
        this.mChildHeightCache = new HeightCache(this, 3);
        this.mRemoveVelocityX = 0.0f;
        this.mListViewIntercepted = false;
        this.mFromPosition = -1;
        this.mFloatViewInvalidated = false;
        this.mDragScroller = new DragScroller(this);
        this.mRemoveAnimator = new FixRemoveAnimator(this, 0.5f, 150);
        this.mDropAnimator = new DropAnimator(this, 0.5f, 150);
        MotionEvent r1 = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mCancelEvent = r1;
        r1.recycle();
        this.mObserver = new AnonymousClass2(this);
    }

    public void setFloatAlpha(float r1) {
        this.mCurrFloatAlpha = r1;
    }

    public float getFloatAlpha() {
        return this.mCurrFloatAlpha;
    }

    public void setMaxScrollSpeed(float r1) {
        this.mMaxScrollSpeed = r1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter r2) {
        if (r2 == null) goto L12;
        this.mAdapterWrapper = new AdapterWrapper(this, r2);
        r2.registerDataSetObserver(this.mObserver);
        if ((r2 instanceof DropListener) == false) goto L7;
        setDropListener((DropListener) r2);
    L7:
        if ((r2 instanceof DragListener) == false) goto L10;
        setDragListener((DragListener) r2);
    L10:
        if ((r2 instanceof RemoveListener) == false) goto L13;
        setRemoveListener((RemoveListener) r2);
    L13:
        super.setAdapter(this.mAdapterWrapper);
        return;
    L12:
        this.mAdapterWrapper = null;
        goto L13
    }

    public ListAdapter getInputAdapter() {
        AdapterWrapper r0 = this.mAdapterWrapper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAdapter();
    }

    private void drawDivider(int r7, Canvas r8) {
        Drawable r0 = getDivider();
        int r1 = getDividerHeight();
        if (r0 == null) goto L13;
        if (r1 == 0) goto L14;
        ViewGroup r2 = (ViewGroup) getChildAt(r7 - getFirstVisiblePosition());
        if (r2 == null) goto L15;
        int r3 = getPaddingLeft();
        int r4 = getWidth() - getPaddingRight();
        int r5 = r2.getChildAt(0).getHeight();
        if (r7 <= this.mSrcPos) goto L10;
        int r6 = r2.getTop() + r5;
        int r9 = r1 + r6;
    L11:
        r8.save();
        r8.clipRect(r3, r6, r4, r9);
        r0.setBounds(r3, r6, r4, r9);
        r0.draw(r8);
        r8.restore();
        return;
    L10:
        int r10 = r2.getBottom() - r5;
        int r11 = r10 - r1;
        r9 = r10;
        r6 = r11;
        goto L11
    L15:
        return;
    L14:
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r13) {
        super.dispatchDraw(r13);
        if (this.mDragState == 0) goto L12;
        int r0 = this.mFirstExpPos;
        if (r0 == this.mSrcPos) goto L7;
        drawDivider(r0, r13);
    L7:
        int r1 = this.mSecondExpPos;
        if (r1 == this.mFirstExpPos) goto L12;
        if (r1 == this.mSrcPos) goto L12;
        drawDivider(r1, r13);
    L12:
        View r2 = this.mFloatView;
        if (r2 == null) goto L22;
        int r3 = r2.getWidth();
        int r4 = this.mFloatView.getHeight();
        int r5 = this.mFloatLoc.x;
        int r6 = getWidth();
        if (r5 >= 0) goto L17;
        r5 = -r5;
    L17:
        if (r5 >= r6) goto L19;
        float r7 = (r6 - r5) / r6;
        float r8 = r7 * r7;
    L20:
        int r10 = (int) ((this.mCurrFloatAlpha * 255.0f) * r8);
        r13.save();
        r13.translate(this.mFloatLoc.x, this.mFloatLoc.y - this.mFloatViewManager.getPaddingTop());
        r13.clipRect(0, 0, r3, r4);
        r13.saveLayerAlpha(0.0f, 0.0f, r3, r4, r10, 31);
        this.mFloatView.draw(r13);
        r13.restore();
        r13.restore();
        return;
    L19:
        r8 = 0.0f;
        goto L20
    }

    private int getItemHeight(int r2) {
        View r0 = getChildAt(r2 - getFirstVisiblePosition());
        if (r0 == null) goto L7;
        return r0.getHeight();
    L7:
        return calcItemHeight(r2, getChildHeight(r2));
    }

    private void printPosData() {
        OLog.d("mobeta", "mSrcPos=" + this.mSrcPos + " mFirstExpPos=" + this.mFirstExpPos + " mSecondExpPos=" + this.mSecondExpPos);
    }

    private int getShuffleEdge(int r8, int r9) {
        int r0 = getHeaderViewsCount();
        int r1 = getFooterViewsCount();
        if (r8 > r0) goto L5;
        return r9;
    L5:
        if (r8 >= (getCount() - r1)) goto L32;
        int r2 = getDividerHeight();
        int r3 = this.mFloatViewHeight - this.mItemHeightCollapsed;
        int r4 = getChildHeight(r8);
        int r5 = getItemHeight(r8);
        int r6 = this.mSecondExpPos;
        int r7 = this.mSrcPos;
        if (r6 > r7) goto L18;
        if (r8 == r6) goto L11;
    L15:
        if (r8 <= r6) goto L26;
        if (r8 > r7) goto L26;
    L17:
        r9 = r9 - r3;
    L26:
        if (r8 > r7) goto L29;
        return r9 + (((this.mFloatViewHeight - r2) - getChildHeight(r8 - 1)) / 2);
    L29:
        return r9 + (((r4 - r2) - this.mFloatViewHeight) / 2);
    L11:
        if (this.mFirstExpPos == r6) goto L15;
        if (r8 != r7) goto L14;
        r9 = r9 + r5;
        r3 = this.mFloatViewHeight;
        goto L17
    L14:
        r9 = r9 + (r5 - r4);
        goto L17
    L18:
        if (r8 > r7) goto L20;
    L22:
        if (r8 != r6) goto L26;
        if (this.mFirstExpPos == r6) goto L26;
        r9 = r9 + (r5 - r4);
        goto L26
    L20:
        if (r8 > this.mFirstExpPos) goto L22;
        r9 = r9 + r3;
        goto L26
    L32:
        return r9;
    }

    private boolean updatePositions() {
        this.mFromPosition = this.mFirstExpPos;
        int r0 = getFirstVisiblePosition();
        int r1 = this.mFirstExpPos;
        View r2 = getChildAt(r1 - r0);
        if (r2 != null) goto L5;
        r1 = (getChildCount() / 2) + r0;
        r2 = getChildAt(r1 - r0);
    L5:
        int r3 = r2.getTop();
        int r4 = r2.getHeight();
        int r5 = getShuffleEdge(r1, r3);
        int r6 = getDividerHeight();
        if (this.mFloatViewMid >= r5) goto L17;
    L7:
        if (r1 < 0) goto L16;
        r1 = r1 - 1;
        int r7 = getItemHeight(r1);
        if (r1 == 0) goto L10;
        r3 = r3 - (r7 + r6);
        int r8 = getShuffleEdge(r1, r3);
        if (this.mFloatViewMid >= r8) goto L14;
        r5 = r8;
        goto L7
    L14:
        int r9 = r5;
        r5 = r8;
    L26:
        int r10 = getHeaderViewsCount();
        int r11 = getFooterViewsCount();
        int r12 = this.mFirstExpPos;
        int r13 = this.mSecondExpPos;
        float r14 = this.mSlideFrac;
        if (this.mAnimate == false) goto L37;
        int r15 = Math.abs(r5 - r9);
        int r16 = this.mFloatViewMid;
        if (r16 >= r5) goto L31;
        int r17 = r5;
        r5 = r9;
        r9 = r17;
    L31:
        int r18 = (int) ((this.mSlideRegionFrac * 0.5f) * r15);
        int r19 = r5 + r18;
        int r110 = r9 - r18;
        if (r16 >= r19) goto L34;
        this.mFirstExpPos = r1 - 1;
        this.mSecondExpPos = r1;
        this.mSlideFrac = ((r19 - r16) * 0.5f) / r18;
    L39:
        if (this.mFirstExpPos >= r10) goto L42;
        this.mFirstExpPos = r10;
        this.mSecondExpPos = r10;
        r1 = r10;
    L45:
        if (this.mFirstExpPos == r12) goto L47;
    L52:
        boolean r20 = true;
    L53:
        int r21 = this.mFloatPos;
        if (r1 == r21) goto L60;
        DragListener r22 = this.mDragListener;
        if (r22 == null) goto L58;
        r22.drag(r21 - r10, r1 - r10);
    L58:
        this.mFloatPos = r1;
        return true;
    L60:
        return r20;
    L47:
        if (this.mSecondExpPos != r13) goto L52;
        if (Float.compare(this.mSlideFrac, r14) != 0) goto L52;
        r20 = false;
        goto L53
    L42:
        if (this.mSecondExpPos < (getCount() - r11)) goto L45;
        r1 = (getCount() - r11) - 1;
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1;
        goto L45
    L34:
        if (r16 >= r110) goto L36;
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1;
        goto L39
    L36:
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1 + 1;
        this.mSlideFrac = (((r9 - r16) / r18) + 1.0f) * 0.5f;
        goto L39
    L37:
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1;
        goto L39
    L10:
        int r23 = (r3 - r6) - r7;
    L11:
        int r111 = r5;
        r5 = r23;
        r9 = r111;
    L16:
        r9 = r5;
        goto L26
    L17:
        int r24 = getCount();
    L18:
        if (r1 >= r24) goto L16;
        if (r1 == (r24 - 1)) goto L21;
        r3 = r3 + (r4 + r6);
        int r25 = r1 + 1;
        int r26 = getItemHeight(r25);
        int r27 = getShuffleEdge(r25, r3);
        if (this.mFloatViewMid < r27) goto L24;
        r1 = r25;
        r4 = r26;
        r5 = r27;
        goto L18
    L24:
        r9 = r5;
        r5 = r27;
        goto L26
    L21:
        r23 = (r3 + r6) + r4;
        goto L11
    }

    @Override // android.view.View
    protected void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    public void removeItem(int r2) {
        this.mUseRemoveVelocity = false;
        removeItem(r2, 0.0f);
    }

    public void removeItem(int r4, float r5) {
        int r0 = this.mDragState;
        if (r0 == 0) goto L5;
        if (r0 == 4) goto L5;
        return;
    L5:
        if (r0 != 0) goto L9;
        int r1 = getHeaderViewsCount() + r4;
        this.mSrcPos = r1;
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1;
        this.mFloatPos = r1;
        View r2 = getChildAt(r1 - getFirstVisiblePosition());
        if (r2 == null) goto L9;
        r2.setVisibility(4);
    L9:
        this.mDragState = 1;
        this.mRemoveVelocityX = r5;
        if (this.mInTouchEvent == false) goto L18;
        int r6 = this.mCancelMethod;
        if (r6 != 1) goto L14;
        super.onTouchEvent(this.mCancelEvent);
        goto L18
    L14:
        if (r6 != 2) goto L18;
        super.onInterceptTouchEvent(this.mCancelEvent);
    L18:
        RemoveAnimator r7 = this.mRemoveAnimator;
        if (r7 == null) goto L21;
        r7.start();
        return;
    L21:
        doRemoveItem(r4);
    }

    public void moveItem(int r2, int r3) {
        if (this.mDropListener == null) goto L11;
        int r0 = getInputAdapter().getCount();
        if (r2 < 0) goto L12;
        if (r2 >= r0) goto L13;
        if (r3 < 0) goto L14;
        if (r3 >= r0) goto L15;
        this.mDropListener.drop(r2, r3);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    public void cancelDrag() {
        if (this.mDragState != 4) goto L13;
        this.mDragScroller.stopScrolling(true);
        this.mDragState = 2;
        if (this.mDropListener == null) goto L11;
        int r0 = this.mFloatPos;
        if (r0 < 0) goto L11;
        if (r0 >= getCount()) goto L11;
        int r1 = getHeaderViewsCount();
        this.mDropListener.drop(this.mSrcPos - r1, this.mFloatPos - r1);
    L11:
        destroyFloatView();
        clearPositions();
        adjustAllItems();
        this.mListViewIntercepted = false;
        this.mInTouchEvent = false;
        this.mDragState = 0;
        return;
    }

    private void clearPositions() {
        this.mSrcPos = -1;
        this.mFirstExpPos = -1;
        this.mSecondExpPos = -1;
        this.mFloatPos = -1;
    }

    private void dropFloatView() {
        this.mDragState = 2;
        if (this.mDropListener == null) goto L9;
        int r0 = this.mFloatPos;
        if (r0 < 0) goto L9;
        if (r0 >= getCount()) goto L9;
        int r1 = getHeaderViewsCount();
        this.mDropListener.drop(this.mSrcPos - r1, this.mFloatPos - r1);
    L9:
        adjustOnReorder();
        destroyFloatView();
        clearPositions();
        adjustAllItems();
        if (this.mInTouchEvent == false) goto L12;
        this.mDragState = 3;
        return;
    L12:
        this.mDragState = 0;
    }

    private void doRemoveItem() {
        doRemoveItem(this.mSrcPos - getHeaderViewsCount());
    }

    private void doRemoveItem(int r2) {
        this.mDragState = 1;
        RemoveListener r0 = this.mRemoveListener;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        destroyFloatView();
        adjustOnReorder();
        clearPositions();
        if (this.mInTouchEvent == false) goto L8;
        this.mDragState = 3;
        return;
    L8:
        this.mDragState = 0;
    }

    private void adjustOnReorder() {
        int r0 = getFirstVisiblePosition();
        if (r0 <= getCount()) goto L6;
        return;
    L6:
        if (this.mSrcPos >= r0) goto L12;
        int r1 = 0;
        View r2 = getChildAt(0);
        if (r2 == null) goto L10;
        r1 = r2.getTop();
    L10:
        setSelectionFromTop(r0 - 1, r1 - getPaddingTop());
        return;
    }

    public boolean stopDrag(boolean r2) {
        this.mUseRemoveVelocity = false;
        return stopDrag(r2, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean r2, float r3) {
        this.mUseRemoveVelocity = true;
        return stopDrag(r2, r3);
    }

    public boolean stopDrag(boolean r3, float r4) {
        if (this.mFloatView == null) goto L12;
        this.mDragScroller.stopScrolling(true);
        if (r3 == false) goto L7;
        removeItem(this.mSrcPos - getHeaderViewsCount(), r4);
    L11:
        return true;
    L7:
        DropAnimator r5 = this.mDropAnimator;
        if (r5 == null) goto L10;
        r5.start();
        goto L11
    L10:
        dropFloatView();
        goto L11
    L12:
        return false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        boolean r1 = false;
        if (this.mIgnoreTouchEvent == false) goto L7;
        this.mIgnoreTouchEvent = false;
        return false;
    L7:
        if (this.mDragEnabled == false) goto L9;
        boolean r0 = this.mLastCallWasIntercept;
        this.mLastCallWasIntercept = false;
        if (r0 == true) goto L13;
        saveTouchCoords(r5);
    L13:
        int r2 = this.mDragState;
        if (r2 != 4) goto L16;
        onDragTouchEvent(r5);
        return true;
    L16:
        if (r2 == 0) goto L18;
    L20:
        int r6 = r5.getAction() & 255;
        if (r6 != 1) goto L23;
    L26:
        doActionUpOrCancel();
    L28:
        return r1;
    L23:
        if (r6 == 3) goto L26;
        if (r1 == false) goto L28;
        this.mCancelMethod = 1;
        goto L28
    L18:
        if (super.onTouchEvent(r5) == false) goto L20;
        r1 = true;
        goto L20
    L9:
        return super.onTouchEvent(r5);
    }

    private void doActionUpOrCancel() {
        this.mCancelMethod = 0;
        this.mInTouchEvent = false;
        if (this.mDragState != 3) goto L5;
        this.mDragState = 0;
    L5:
        this.mCurrFloatAlpha = this.mFloatAlpha;
        this.mListViewIntercepted = false;
        this.mChildHeightCache.clear();
    }

    private void saveTouchCoords(MotionEvent r3) {
        int r0 = r3.getAction() & 255;
        if (r0 == 0) goto L5;
        this.mLastX = this.mX;
        this.mLastY = this.mY;
    L5:
        this.mX = (int) r3.getX();
        int r1 = (int) r3.getY();
        this.mY = r1;
        if (r0 != 0) goto L8;
        this.mLastX = this.mX;
        this.mLastY = r1;
    L8:
        this.mOffsetX = ((int) r3.getRawX()) - this.mX;
        this.mOffsetY = ((int) r3.getRawY()) - this.mY;
    }

    public boolean listViewIntercepted() {
        return this.mListViewIntercepted;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        if (this.mDragEnabled == false) goto L5;
        saveTouchCoords(r6);
        this.mLastCallWasIntercept = true;
        int r1 = r6.getAction() & 255;
        if (r1 != 0) goto L14;
        if (this.mDragState == 0) goto L12;
        this.mIgnoreTouchEvent = true;
        return true;
    L12:
        this.mInTouchEvent = true;
    L14:
        if (this.mFloatView == null) goto L17;
        boolean r7 = true;
    L26:
        if (r1 == 1) goto L28;
        if (r1 == 3) goto L28;
    L29:
        return r7;
    L28:
        this.mInTouchEvent = false;
        goto L29
    L17:
        if (super.onInterceptTouchEvent(r6) == false) goto L19;
        this.mListViewIntercepted = true;
        r7 = true;
    L20:
        if (r1 == 1) goto L25;
        if (r1 == 3) goto L25;
        if (r7 == false) goto L24;
        this.mCancelMethod = 1;
        goto L26
    L24:
        this.mCancelMethod = 2;
    L25:
        doActionUpOrCancel();
        goto L26
    L19:
        r7 = false;
        goto L20
    L5:
        return super.onInterceptTouchEvent(r6);
    }

    public void setDragScrollStart(float r1) {
        setDragScrollStarts(r1, r1);
    }

    public void setDragScrollStarts(float r3, float r4) {
        if (r4 <= 0.5f) goto L5;
        this.mDragDownScrollStartFrac = 0.5f;
    L7:
        if (r3 <= 0.5f) goto L9;
        this.mDragUpScrollStartFrac = 0.5f;
    L11:
        if (getHeight() == 0) goto L14;
        updateScrollStarts();
        return;
    L14:
        return;
    L9:
        this.mDragUpScrollStartFrac = r3;
        goto L11
    L5:
        this.mDragDownScrollStartFrac = r4;
        goto L7
    }

    private void continueDrag(int r6, int r7) {
        Point r0 = this.mFloatLoc;
        r0.x = r6 - this.mDragDeltaX;
        Point r8 = this.mFloatLoc;
        r8.y = r7 - this.mDragDeltaY;
        doDragFloatView(true);
        int r1 = Math.min(r7, this.mFloatViewMid + this.mFloatViewHeightHalf);
        int r9 = Math.max(r7, this.mFloatViewMid - this.mFloatViewHeightHalf);
        int r2 = this.mDragScroller.getScrollDir();
        int r3 = this.mLastY;
        if (r1 > r3) goto L5;
    L10:
        if (r9 >= r3) goto L18;
        if (r9 >= this.mUpScrollStartY) goto L18;
        if (r2 == 0) goto L18;
        if (r2 == (-1)) goto L16;
        this.mDragScroller.stopScrolling(true);
    L16:
        this.mDragScroller.startScrolling(0);
        return;
    L18:
        if (r9 >= this.mUpScrollStartY) goto L20;
        return;
    L20:
        if (r1 <= this.mDownScrollStartY) goto L22;
        return;
    L22:
        if (this.mDragScroller.isScrolling() == false) goto L29;
        this.mDragScroller.stopScrolling(true);
        return;
    L29:
        return;
    L5:
        if (r1 <= this.mDownScrollStartY) goto L10;
        if (r2 == 1) goto L10;
        if (r2 == (-1)) goto L9;
        this.mDragScroller.stopScrolling(true);
    L9:
        this.mDragScroller.startScrolling(1);
    }

    private void updateScrollStarts() {
        int r0 = getPaddingTop();
        int r1 = (getHeight() - r0) - getPaddingBottom();
        float r2 = r0;
        float r4 = r1;
        float r3 = (this.mDragUpScrollStartFrac * r4) + r2;
        this.mUpScrollStartYF = r3;
        float r5 = ((1.0f - this.mDragDownScrollStartFrac) * r4) + r2;
        this.mDownScrollStartYF = r5;
        this.mUpScrollStartY = (int) r3;
        this.mDownScrollStartY = (int) r5;
        this.mDragUpScrollHeight = r3 - r2;
        this.mDragDownScrollHeight = (r0 + r1) - r5;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateScrollStarts();
    }

    private void adjustAllItems() {
        int r0 = getFirstVisiblePosition();
        int r1 = getLastVisiblePosition();
        int r2 = Math.max(0, getHeaderViewsCount() - r0);
        int r3 = Math.min(r1 - r0, ((getCount() - 1) - getFooterViewsCount()) - r0);
    L3:
        if (r2 > r3) goto L8;
        View r4 = getChildAt(r2);
        if (r4 == null) goto L7;
        adjustItem(r0 + r2, r4, false);
    L7:
        r2 = r2 + 1;
        goto L3
    }

    private void adjustItem(int r3) {
        View r0 = getChildAt(r3 - getFirstVisiblePosition());
        if (r0 == null) goto L6;
        adjustItem(r3, r0, false);
        return;
    }

    private void adjustItem(int r9, View r10, boolean r11) {
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if (r9 != this.mSrcPos) goto L5;
    L9:
        int r12 = calcItemHeight(r9, r10, r11);
    L10:
        TranslateAnimation r2 = null;
        View r3 = null;
        r2 = null;
        if (r9 != this.mFirstExpPos) goto L13;
    L14:
        int r1 = this.mSrcPos;
        if (r9 >= r1) goto L26;
        ((DragSortItemView) r10).setGravity(80);
        if (r9 == this.mSecondExpPos) goto L19;
    L48:
        TranslateAnimation r4 = null;
    L49:
        if (r3 == null) goto L53;
        if (r4 == null) goto L53;
        r4.setDuration(this.mAdjustAnimDuration);
        r3.startAnimation(r4);
    L53:
        if (r12 == r0.height) goto L55;
        r0.height = r12;
        r10.setLayoutParams(r0);
    L55:
        int r13 = r10.getVisibility();
        if (r9 == this.mSrcPos) goto L58;
    L60:
        int r8 = 0;
    L61:
        if (r8 == r13) goto L64;
        r10.setVisibility(r8);
        return;
    L64:
        return;
    L58:
        if (this.mFloatView == null) goto L60;
        r8 = 4;
        goto L61
    L19:
        if (this.mAdjustAnimate == false) goto L48;
        if (this.mFromPosition <= this.mFirstExpPos) goto L24;
        TranslateAnimation r5 = new TranslateAnimation(0.0f, 0.0f, -this.mFloatViewHeight, 0.0f);
    L23:
        r4 = r5;
        r3 = r10;
        goto L49
    L24:
        r3 = getChildAt((r9 - getFirstVisiblePosition()) - 1);
        r4 = new TranslateAnimation(0.0f, 0.0f, this.mFloatViewHeight, 0.0f);
        goto L49
    L26:
        if (r9 <= r1) goto L36;
        ((DragSortItemView) r10).setGravity(48);
        if (r9 != this.mSecondExpPos) goto L48;
        if (this.mAdjustAnimate == false) goto L48;
        if (this.mFromPosition <= this.mFirstExpPos) goto L34;
        r3 = getChildAt((r9 - getFirstVisiblePosition()) + 1);
        r4 = new TranslateAnimation(0.0f, 0.0f, -this.mFloatViewHeight, 0.0f);
        goto L49
    L34:
        r5 = new TranslateAnimation(0.0f, 0.0f, this.mFloatViewHeight, 0.0f);
        goto L23
    L36:
        if (r0.height != this.mItemHeightCollapsed) goto L48;
        if (this.mAdjustAnimate == false) goto L48;
        if (this.mFromPosition <= this.mFirstExpPos) goto L44;
        View r6 = getChildAt((r9 - getFirstVisiblePosition()) + 1);
        if (r6 == null) goto L47;
        ((DragSortItemView) r6).setGravity(48);
        r2 = new TranslateAnimation(0.0f, 0.0f, -this.mFloatViewHeight, 0.0f);
    L47:
        TranslateAnimation r7 = r2;
        r3 = r6;
        r4 = r7;
        goto L49
    L44:
        r6 = getChildAt((r9 - getFirstVisiblePosition()) - 1);
        if (r6 == null) goto L47;
        ((DragSortItemView) r6).setGravity(80);
        r2 = new TranslateAnimation(0.0f, 0.0f, this.mFloatViewHeight, 0.0f);
        goto L47
    L13:
        if (r9 != this.mSecondExpPos) goto L48;
    L5:
        if (r9 == this.mFirstExpPos) goto L9;
        if (r9 == this.mSecondExpPos) goto L9;
        r12 = -2;
        goto L10
    }

    private int getChildHeight(int r5) {
        if (r5 != this.mSrcPos) goto L5;
        return 0;
    L5:
        View r0 = getChildAt(r5 - getFirstVisiblePosition());
        if (r0 != null) goto L8;
        int r1 = this.mChildHeightCache.get(r5);
        if (r1 == (-1)) goto L12;
        return r1;
    L12:
        ListAdapter r2 = getAdapter();
        int r3 = r2.getItemViewType(r5);
        int r4 = r2.getViewTypeCount();
        if (r4 == this.mSampleViewTypes.length) goto L16;
        this.mSampleViewTypes = new View[r4];
    L16:
        if (r3 < 0) goto L21;
        View r6 = this.mSampleViewTypes[r3];
        if (r6 != null) goto L20;
        View r7 = r2.getView(r5, null, this);
        this.mSampleViewTypes[r3] = r7;
    L22:
        int r8 = getChildHeight(r5, r7, true);
        this.mChildHeightCache.add(r5, r8);
        return r8;
    L20:
        r7 = r2.getView(r5, r6, this);
        goto L22
    L21:
        r7 = r2.getView(r5, null, this);
        goto L22
    L8:
        return getChildHeight(r5, r0, false);
    }

    private int getChildHeight(int r4, View r5, boolean r6) {
        if (r4 != this.mSrcPos) goto L6;
        return 0;
    L6:
        if (r4 >= getHeaderViewsCount()) goto L8;
    L11:
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if (r7 != null) goto L14;
    L17:
        int r8 = r5.getHeight();
        if (r8 == 0) goto L20;
        if (r6 == true) goto L20;
        return r8;
    L20:
        measureItem(r5);
        return r5.getMeasuredHeight();
    L14:
        if (r7.height <= 0) goto L17;
        return r7.height;
    L8:
        if (r4 >= (getCount() - getFooterViewsCount())) goto L11;
        r5 = ((ViewGroup) r5).getChildAt(0);
        goto L11
    }

    private int calcItemHeight(int r1, View r2, boolean r3) {
        return calcItemHeight(r1, getChildHeight(r1, r2, r3));
    }

    private int calcItemHeight(int r7, int r8) {
        getDividerHeight();
        if (this.mAnimate == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        int r1 = this.mFloatViewHeight;
        int r2 = this.mItemHeightCollapsed;
        int r3 = r1 - r2;
        int r4 = (int) (this.mSlideFrac * r3);
        int r5 = this.mSrcPos;
        if (r7 != r5) goto L20;
        if (r5 != this.mFirstExpPos) goto L16;
        if (r0 == false) goto L29;
        return r4 + r2;
    L29:
        return r1;
    L16:
        if (r5 != this.mSecondExpPos) goto L31;
        return r1 - r4;
    L31:
        return r2;
    L20:
        if (r7 != this.mFirstExpPos) goto L25;
        if (r0 == false) goto L33;
        return r8 + r4;
    L33:
        return r8 + r3;
    L25:
        if (r7 == this.mSecondExpPos) goto L27;
        return r8;
    L27:
        return (r8 + r3) - r4;
    L5:
        if (this.mFirstExpPos == this.mSecondExpPos) goto L7;
        r0 = true;
        goto L8
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mBlockLayoutRequests == true) goto L6;
        super.requestLayout();
        return;
    }

    private int adjustScroll(int r8, View r9, int r10, int r11) {
        int r0 = getChildHeight(r8);
        int r12 = r9.getHeight();
        int r1 = calcItemHeight(r8, r0);
        int r2 = this.mSrcPos;
        if (r8 == r2) goto L5;
        int r3 = r12 - r0;
        int r4 = r1 - r0;
    L6:
        int r5 = this.mFloatViewHeight;
        int r6 = this.mFirstExpPos;
        if (r2 == r6) goto L12;
        if (r2 == this.mSecondExpPos) goto L12;
        r5 = r5 - this.mItemHeightCollapsed;
    L12:
        if (r8 > r10) goto L15;
        if (r8 > r6) goto L29;
        return 0;
    L29:
        return 0 + (r5 - r4);
    L15:
        if (r8 != r11) goto L22;
        if (r8 > r6) goto L20;
        r3 = r3 - r5;
    L30:
        return 0 + r3;
    L20:
        if (r8 != this.mSecondExpPos) goto L30;
        return 0 + (r12 - r1);
    L22:
        if (r8 > r6) goto L25;
        return 0 - r5;
    L25:
        if (r8 == this.mSecondExpPos) goto L27;
        return 0;
    L27:
        return 0 - r4;
    L5:
        r3 = r12;
        r4 = r1;
        goto L6
    }

    private void measureItem(View r4) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new AbsListView.LayoutParams(-1, -2);
        r4.setLayoutParams(r0);
    L5:
        int r3 = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, getListPaddingLeft() + getListPaddingRight(), r0.width);
        if (r0.height <= 0) goto L8;
        int r1 = View.MeasureSpec.makeMeasureSpec(r0.height, 1073741824);
    L9:
        r4.measure(r3, r1);
        return;
    L8:
        r1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L9
    }

    private void measureFloatView() {
        View r0 = this.mFloatView;
        if (r0 == null) goto L6;
        measureItem(r0);
        int r1 = (this.mFloatView.getMeasuredHeight() - this.mFloatViewManager.getPaddingTop()) - this.mFloatViewManager.getPaddingBottom();
        this.mFloatViewHeight = r1;
        this.mFloatViewHeightHalf = r1 / 2;
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        View r3 = this.mFloatView;
        if (r3 != null) goto L5;
    L8:
        this.mWidthMeasureSpec = r1;
        return;
    L5:
        if (r3.isLayoutRequested() == false) goto L7;
        measureFloatView();
    L7:
        this.mFloatViewOnMeasured = true;
        goto L8
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        View r0 = this.mFloatView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isLayoutRequested() == true) goto L7;
    L9:
        View r1 = this.mFloatView;
        r1.layout(0, 0, r1.getMeasuredWidth(), this.mFloatView.getMeasuredHeight());
        this.mFloatViewOnMeasured = false;
        return;
    L7:
        if (this.mFloatViewOnMeasured == true) goto L9;
        measureFloatView();
        goto L9
    }

    protected boolean onDragTouchEvent(MotionEvent r5) {
        int r0 = r5.getAction() & 255;
        if (r0 == 1) goto L15;
        if (r0 != 2) goto L7;
        continueDrag((int) r5.getX(), (int) r5.getY());
    L18:
        return true;
    L7:
        if (r0 != 3) goto L18;
        if (this.mDragState != 4) goto L12;
        cancelDrag();
    L12:
        doActionUpOrCancel();
        goto L18
    L15:
        if (this.mDragState != 4) goto L17;
        stopDrag(false);
    L17:
        doActionUpOrCancel();
        goto L18
    }

    private void invalidateFloatView() {
        this.mFloatViewInvalidated = true;
    }

    public boolean startDrag(int r9, int r10, int r11, int r12) {
        if (this.mInTouchEvent == false) goto L13;
        FloatViewManager r0 = this.mFloatViewManager;
        if (r0 == null) goto L16;
        View r4 = r0.onCreateFloatView(r9);
        if (r4 != null) goto L10;
        return false;
    L10:
        if (startDrag(r9, r4, r10, r11, r12) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    L13:
        return false;
    }

    public boolean startDrag(int r4, View r5, int r6, int r7, int r8) {
        if (this.mDragState == 0) goto L5;
    L29:
        return false;
    L5:
        if (this.mInTouchEvent == false) goto L29;
        if (this.mFloatView != null) goto L29;
        if (r5 == null) goto L29;
        if (this.mDragEnabled == false) goto L29;
        if (getParent() == null) goto L15;
        getParent().requestDisallowInterceptTouchEvent(true);
    L15:
        int r9 = r4 + getHeaderViewsCount();
        this.mFirstExpPos = r9;
        this.mSecondExpPos = r9;
        this.mSrcPos = r9;
        this.mFloatPos = r9;
        this.mDragState = 4;
        this.mDragFlags = r6 | 0;
        this.mFloatView = r5;
        measureFloatView();
        this.mDragDeltaX = r7;
        this.mDragDeltaY = r8;
        this.mDragStartY = this.mY;
        Point r10 = this.mFloatLoc;
        r10.x = this.mX - r7;
        Point r11 = this.mFloatLoc;
        r11.y = this.mY - this.mDragDeltaY;
        View r12 = getChildAt(this.mSrcPos - getFirstVisiblePosition());
        if (r12 == null) goto L18;
        r12.setVisibility(4);
    L18:
        int r13 = this.mCancelMethod;
        if (r13 != 1) goto L21;
        super.onTouchEvent(this.mCancelEvent);
    L25:
        requestLayout();
        LiftAnimator r3 = this.mLiftAnimator;
        if (r3 == null) goto L28;
        r3.start();
    L28:
        return true;
    L21:
        if (r13 != 2) goto L25;
        super.onInterceptTouchEvent(this.mCancelEvent);
        goto L25
    }

    private void doDragFloatView(boolean r3) {
        int r0 = getFirstVisiblePosition() + (getChildCount() / 2);
        View r1 = getChildAt(getChildCount() / 2);
        if (r1 != null) goto L5;
        return;
    L5:
        doDragFloatView(r0, r1, r3);
    }

    private void doDragFloatView(int r4, View r5, boolean r6) {
        this.mBlockLayoutRequests = true;
        updateFloatView();
        int r0 = this.mFirstExpPos;
        int r1 = this.mSecondExpPos;
        boolean r2 = updatePositions();
        if (r2 == false) goto L5;
        adjustAllItems();
        int r3 = adjustScroll(r4, r5, r0, r1);
        setSelectionFromTop(r4, (r5.getTop() + r3) - getPaddingTop());
        layoutChildren();
    L5:
        if (r2 == true) goto L7;
        if (r6 == true) goto L7;
    L8:
        this.mBlockLayoutRequests = false;
        return;
    L7:
        invalidate();
        goto L8
    }

    private void updateFloatView() {
        if (this.mFloatViewManager == null) goto L7;
        this.mTouchLoc.set(this.mX, this.mY);
        if (this.mDragState == 2) goto L7;
        this.mFloatViewManager.onDragFloatView(this.mFloatView, this.mFloatLoc, this.mTouchLoc);
    L7:
        int r0 = this.mFloatLoc.x;
        int r2 = this.mFloatLoc.y;
        int r3 = getPaddingLeft();
        int r4 = this.mDragFlags;
        if ((r4 & 1) != 0) goto L12;
        if (r0 <= r3) goto L12;
        this.mFloatLoc.x = r3;
    L15:
        int r1 = getHeaderViewsCount();
        int r5 = getFooterViewsCount();
        int r6 = getFirstVisiblePosition();
        int r7 = getLastVisiblePosition();
        int r8 = getPaddingTop();
        if (r6 >= r1) goto L19;
        r8 = getChildAt((r1 - r6) - 1).getBottom();
    L19:
        if ((this.mDragFlags & 8) != 0) goto L23;
        int r9 = this.mSrcPos;
        if (r6 > r9) goto L23;
        r8 = Math.max(getChildAt(r9 - r6).getTop(), r8);
    L23:
        int r10 = getHeight() - getPaddingBottom();
        if (r7 < ((getCount() - r5) - 1)) goto L29;
        View r11 = getChildAt(((getCount() - r5) - 1) - r6);
        if (r11 == null) goto L29;
        r10 = Math.min(r11.getBottom(), r10);
    L29:
        if ((this.mDragFlags & 4) != 0) goto L33;
        int r12 = this.mSrcPos;
        if (r7 < r12) goto L33;
        r10 = Math.min(getChildAt(r12 - r6).getBottom(), r10);
    L33:
        int r13 = r10 - this.mFloatViewHeight;
        int r14 = r8 - this.mFloatView.getPaddingTop();
        if (r2 >= r14) goto L36;
        this.mFloatLoc.y = r14;
    L38:
        this.mFloatViewMid = this.mFloatLoc.y + this.mFloatViewHeightHalf;
        return;
    L36:
        if (r2 <= r13) goto L38;
        this.mFloatLoc.y = r13;
    L12:
        if ((2 & r4) != 0) goto L15;
        if (r0 >= r3) goto L15;
        this.mFloatLoc.x = r3;
        goto L15
    }

    private void destroyFloatView() {
        View r0 = this.mFloatView;
        if (r0 == null) goto L9;
        r0.setVisibility(8);
        FloatViewManager r1 = this.mFloatViewManager;
        if (r1 == null) goto L7;
        r1.onDestroyFloatView(this.mFloatView);
    L7:
        this.mFloatView = null;
        invalidate();
        return;
    }

    public void setFloatViewManager(FloatViewManager r1) {
        this.mFloatViewManager = r1;
    }

    public void setDragListener(DragListener r1) {
        this.mDragListener = r1;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void setDragEnabled(boolean r1) {
        this.mDragEnabled = r1;
    }

    public void setItemHeightCollapsed(int r1) {
        this.mItemHeightCollapsed = r1;
    }

    public void setDropListener(DropListener r1) {
        this.mDropListener = r1;
    }

    public void setRemoveListener(RemoveListener r1) {
        this.mRemoveListener = r1;
    }

    public void setDragSortListener(DragSortListener r1) {
        setDropListener(r1);
        setDragListener(r1);
        setRemoveListener(r1);
    }

    public void setDragScrollProfile(DragScrollProfile r1) {
        if (r1 == null) goto L5;
        this.mScrollProfile = r1;
        return;
    }

    public void moveCheckState(int r10, int r11) {
        SparseBooleanArray r0 = getCheckedItemPositions();
        if (r11 >= r10) goto L5;
        int r1 = r10;
        int r2 = r11;
    L6:
        int r3 = r1 + 1;
        int[] r4 = new int[r0.size()];
        int[] r5 = new int[r0.size()];
        int r6 = buildRunList(r0, r2, r3, r4, r5);
        if (r6 == 1) goto L9;
    L11:
        if (r10 >= r11) goto L15;
        int r12 = 0;
    L13:
        if (r12 == r6) goto L18;
        setItemChecked(rotate(r4[r12], -1, r2, r3), true);
        setItemChecked(rotate(r5[r12], -1, r2, r3), false);
        r12 = r12 + 1;
        goto L13
    L18:
        return;
    L15:
        int r13 = 0;
    L16:
        if (r13 == r6) goto L21;
        setItemChecked(r4[r13], false);
        setItemChecked(r5[r13], true);
        r13 = r13 + 1;
        goto L16
    L21:
        return;
    L9:
        if (r4[0] != r5[0]) goto L11;
        return;
    L5:
        r2 = r10;
        r1 = r11;
        goto L6
    }

    public void moveCheckState(int r9, int r10, SparseBooleanArray r11) {
        if (r10 >= r9) goto L4;
        int r8 = r9;
        int r0 = r10;
    L5:
        int r12 = r8 + 1;
        int[] r2 = new int[r11.size()];
        int[] r3 = new int[r11.size()];
        int r4 = buildRunList(r11, r0, r12, r2, r3);
        if (r4 == 1) goto L8;
    L10:
        if (r9 >= r10) goto L14;
        int r13 = 0;
    L12:
        if (r13 == r4) goto L17;
        r11.put(rotate(r2[r13], -1, r0, r12), true);
        r11.put(rotate(r3[r13], -1, r0, r12), false);
        r13 = r13 + 1;
        goto L12
    L17:
        return;
    L14:
        int r14 = 0;
    L15:
        if (r14 == r4) goto L20;
        r11.put(r2[r14], false);
        r11.put(r3[r14], true);
        r14 = r14 + 1;
        goto L15
    L20:
        return;
    L8:
        if (r2[0] != r3[0]) goto L10;
        return;
    L4:
        r0 = r9;
        r8 = r10;
        goto L5
    }

    public SparseBooleanArray moveCheckState(int r5, int r6, ArrayList<Integer> r7) {
        SparseBooleanArray r0 = new SparseBooleanArray();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r7.size()) goto L6;
        r0.put(r2, true);
        r2 = r2 + 1;
        goto L4
    L6:
        moveCheckState(r5, r6, r0);
        r7.clear();
        int r4 = r0.size();
    L7:
        if (r1 >= r4) goto L12;
        if (r0.get(r1) == false) goto L11;
        r7.add(Integer.valueOf(r1));
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        return r0;
    }

    public void removeCheckState(int r11) {
        SparseBooleanArray r0 = getCheckedItemPositions();
        if (r0.size() != 0) goto L5;
        return;
    L5:
        int[] r1 = new int[r0.size()];
        int[] r2 = new int[r0.size()];
        int r3 = r0.keyAt(r0.size() - 1) + 1;
        int r4 = buildRunList(r0, r11, r3, r1, r2);
        int r6 = 0;
    L6:
        if (r6 == r4) goto L14;
        int r7 = r1[r6];
        if (r7 == r11) goto L13;
        int r9 = r2[r6];
        if (r9 >= r7) goto L12;
        if (r9 > r11) goto L13;
    L12:
        setItemChecked(rotate(r7, -1, r11, r3), true);
    L13:
        setItemChecked(rotate(r2[r6], -1, r11, r3), false);
        r6 = r6 + 1;
        goto L6
    }

    private static int buildRunList(SparseBooleanArray r8, int r9, int r10, int[] r11, int[] r12) {
        int r0 = findFirstSetIndex(r8, r9, r10);
        if (r0 != (-1)) goto L5;
        return 0;
    L5:
        int r1 = r8.keyAt(r0);
        int r3 = r1 + 1;
        int r2 = r0 + 1;
        int r5 = 0;
    L7:
        if (r2 >= r8.size()) goto L17;
        int r6 = r8.keyAt(r2);
        if (r6 >= r10) goto L17;
        if (r8.valueAt(r2) == false) goto L16;
        if (r6 != r3) goto L15;
        r3 = r3 + 1;
        goto L16
    L15:
        r11[r5] = r1;
        r12[r5] = r3;
        r5 = r5 + 1;
        r3 = r6 + 1;
        r1 = r6;
    L16:
        r2 = r2 + 1;
    L17:
        if (r3 != r10) goto L19;
        r3 = r9;
    L19:
        r11[r5] = r1;
        r12[r5] = r3;
        int r7 = r5 + 1;
        if (r7 > 1) goto L22;
        return r7;
    L22:
        if (r11[0] != r9) goto L33;
        int r13 = r7 - 1;
        if (r12[r13] != r9) goto L34;
        r11[0] = r11[r13];
        return r7 - 1;
    L34:
        return r7;
    L33:
        return r7;
    }

    private static int findFirstSetIndex(SparseBooleanArray r2, int r3, int r4) {
        int r0 = r2.size();
        int r5 = insertionIndexForKey(r2, r3);
    L3:
        if (r5 >= r0) goto L9;
        if (r2.keyAt(r5) >= r4) goto L9;
        if (r2.valueAt(r5) == true) goto L9;
        r5 = r5 + 1;
    L9:
        if (r5 != r0) goto L11;
        return -1;
    L11:
        if (r2.keyAt(r5) >= r4) goto L19;
        return r5;
    L19:
        return -1;
    }

    private static int insertionIndexForKey(SparseBooleanArray r4, int r5) {
        int r0 = r4.size();
        int r1 = 0;
    L4:
        if ((r0 - r1) <= 0) goto L9;
        int r2 = (r1 + r0) >> 1;
        if (r4.keyAt(r2) < r5) goto L7;
        r0 = r2;
        goto L4
    L7:
        r1 = r2 + 1;
        goto L4
    L9:
        return r1;
    }
}
