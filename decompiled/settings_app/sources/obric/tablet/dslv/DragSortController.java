package obric.tablet.dslv;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes5.dex */
public class DragSortController extends SimpleFloatViewManager implements View.OnTouchListener, GestureDetector.OnGestureListener {
    public static final int CLICK_REMOVE = 0;
    public static final int FLING_REMOVE = 1;
    public static final int MISS = -1;
    public static final int ON_DOWN = 0;
    public static final int ON_DRAG = 1;
    public static final int ON_LONG_PRESS = 2;
    private boolean mCanDrag;
    private int mClickRemoveHitPos;
    private int mClickRemoveId;
    private int mCurrX;
    private int mCurrY;
    private GestureDetector mDetector;
    private int mDragHandleId;
    private int mDragInitMode;
    private boolean mDragging;
    private DragSortListView mDslv;
    private int mFlingHandleId;
    private int mFlingHitPos;
    private GestureDetector mFlingRemoveDetector;
    private GestureDetector.OnGestureListener mFlingRemoveListener;
    private float mFlingSpeed;
    private int mHitPos;
    private int mItemX;
    private int mItemY;
    private int mPositionX;
    private boolean mRemoveEnabled;
    private int mRemoveMode;
    private boolean mSortEnabled;
    private int[] mTempLoc;
    private int mTouchSlop;

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent r1) {
    }

    static /* synthetic */ boolean access$000(DragSortController r0) {
        return r0.mRemoveEnabled;
    }

    static /* synthetic */ DragSortListView access$100(DragSortController r0) {
        return r0.mDslv;
    }

    static /* synthetic */ float access$200(DragSortController r0) {
        return r0.mFlingSpeed;
    }

    static /* synthetic */ int access$300(DragSortController r0) {
        return r0.mPositionX;
    }

    public DragSortController(DragSortListView r3) {
        this(r3, 0, 0, 1);
    }

    public DragSortController(DragSortListView r7, int r8, int r9, int r10) {
        this(r7, r8, r9, r10, 0);
    }

    public DragSortController(DragSortListView r8, int r9, int r10, int r11, int r12) {
        this(r8, r9, r10, r11, r12, 0);
    }

    public DragSortController(DragSortListView r5, int r6, int r7, int r8, int r9, int r10) {
        super(r5);
        this.mDragInitMode = 0;
        this.mSortEnabled = true;
        this.mRemoveEnabled = false;
        this.mHitPos = -1;
        this.mFlingHitPos = -1;
        this.mClickRemoveHitPos = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.mFlingSpeed = 500.0f;
        this.mFlingRemoveListener = new AnonymousClass1(this);
        this.mDslv = r5;
        this.mDetector = new GestureDetector(r5.getContext(), this);
        GestureDetector r1 = new GestureDetector(r5.getContext(), this.mFlingRemoveListener);
        this.mFlingRemoveDetector = r1;
        r1.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(r5.getContext()).getScaledTouchSlop();
        this.mDragHandleId = r6;
        this.mClickRemoveId = r9;
        this.mFlingHandleId = r10;
        setRemoveMode(r8);
        setDragInitMode(r7);
    }

    public int getDragInitMode() {
        return this.mDragInitMode;
    }

    public void setDragInitMode(int r1) {
        this.mDragInitMode = r1;
    }

    public void setSortEnabled(boolean r1) {
        this.mSortEnabled = r1;
    }

    public boolean isSortEnabled() {
        return this.mSortEnabled;
    }

    public void setRemoveMode(int r1) {
        this.mRemoveMode = r1;
    }

    public int getRemoveMode() {
        return this.mRemoveMode;
    }

    public void setRemoveEnabled(boolean r1) {
        this.mRemoveEnabled = r1;
    }

    public boolean isRemoveEnabled() {
        return this.mRemoveEnabled;
    }

    public void setDragHandleId(int r1) {
        this.mDragHandleId = r1;
    }

    public void setFlingHandleId(int r1) {
        this.mFlingHandleId = r1;
    }

    public void setClickRemoveId(int r1) {
        this.mClickRemoveId = r1;
    }

    public boolean startDrag(int r3, int r4, int r5) {
        if (this.mSortEnabled == false) goto L5;
        int r0 = 12;
    L7:
        if (this.mRemoveEnabled == false) goto L10;
        r0 = (r0 | 1) | 2;
    L10:
        return startDrag(r3, r0, r4, r5);
    L5:
        r0 = 0;
        goto L7
    }

    public boolean startDrag(int r3, int r4, int r5, int r6) {
        DragSortListView r0 = this.mDslv;
        boolean r7 = r0.startDrag(r3 - r0.getHeaderViewsCount(), r4, r5, r6);
        this.mDragging = r7;
        return r7;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r3, MotionEvent r4) {
        if (this.mDslv.isDragEnabled() == true) goto L5;
    L35:
        return false;
    L5:
        if (this.mDslv.listViewIntercepted() == true) goto L35;
        GestureDetector r5 = this.mDetector;
        if (r5 == null) goto L35;
        if (r4 == null) goto L35;
        r5.onTouchEvent(r4);
        if (this.mRemoveEnabled == true) goto L14;
    L18:
        int r6 = r4.getAction() & 255;
        if (r6 == 0) goto L34;
        if (r6 == 1) goto L25;
        if (r6 != 3) goto L35;
    L33:
        this.mDragging = false;
        goto L35
    L25:
        if (this.mRemoveEnabled == false) goto L33;
        int r7 = this.mPositionX;
        if (r7 >= 0) goto L31;
        r7 = -r7;
    L31:
        if (r7 <= (this.mDslv.getWidth() / 2)) goto L33;
        this.mDslv.stopDragWithVelocity(true, 0.0f);
        goto L33
    L34:
        this.mCurrX = (int) r4.getX();
        this.mCurrY = (int) r4.getY();
        goto L35
    L14:
        if (this.mDragging == false) goto L18;
        if (this.mRemoveMode != 1) goto L18;
        this.mFlingRemoveDetector.onTouchEvent(r4);
        goto L18
    }

    @Override // obric.tablet.dslv.SimpleFloatViewManager, obric.tablet.dslv.DragSortListView.FloatViewManager
    public void onDragFloatView(View r1, Point r2, Point r3) {
        if (this.mRemoveEnabled == false) goto L6;
        this.mPositionX = r2.x;
        return;
    }

    public int startDragPosition(MotionEvent r1) {
        return dragHandleHitPosition(r1);
    }

    public int startFlingPosition(MotionEvent r3) {
        if (this.mRemoveMode == 1) goto L7;
        return -1;
    L7:
        return flingHandleHitPosition(r3);
    }

    public int dragHandleHitPosition(MotionEvent r2) {
        return viewIdHitPosition(r2, this.mDragHandleId);
    }

    public int flingHandleHitPosition(MotionEvent r2) {
        return viewIdHitPosition(r2, this.mFlingHandleId);
    }

    public int viewIdHitPosition(MotionEvent r8, int r9) {
        int r0 = (int) r8.getX();
        int r1 = (int) r8.getY();
        int r2 = this.mDslv.pointToPosition(r0, r1);
        int r3 = this.mDslv.getHeaderViewsCount();
        int r4 = this.mDslv.getFooterViewsCount();
        int r5 = this.mDslv.getCount();
        if (r2 == (-1)) goto L22;
        if (r2 < r3) goto L22;
        if (r2 >= (r5 - r4)) goto L22;
        DragSortListView r6 = this.mDslv;
        View r7 = r6.getChildAt(r2 - r6.getFirstVisiblePosition());
        int r10 = (int) r8.getRawX();
        int r11 = (int) r8.getRawY();
        if (r9 != 0) goto L10;
        View r12 = r7;
    L11:
        if (r12 == null) goto L22;
        r12.getLocationOnScreen(this.mTempLoc);
        int[] r13 = this.mTempLoc;
        int r14 = r13[0];
        if (r10 <= r14) goto L22;
        if (r11 <= r13[1]) goto L22;
        if (r10 >= (r14 + r12.getWidth())) goto L22;
        if (r11 >= (this.mTempLoc[1] + r12.getHeight())) goto L22;
        this.mItemX = r7.getLeft();
        this.mItemY = r7.getTop();
        return r2;
    L10:
        r12 = r7.findViewById(r9);
    L22:
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r5) {
        if (this.mRemoveEnabled == true) goto L5;
    L7:
        int r0 = startDragPosition(r5);
        this.mHitPos = r0;
        if (r0 != (-1)) goto L10;
    L12:
        this.mCanDrag = true;
        this.mPositionX = 0;
        this.mFlingHitPos = startFlingPosition(r5);
        return true;
    L10:
        if (this.mDragInitMode != 0) goto L12;
        startDrag(r0, ((int) r5.getX()) - this.mItemX, ((int) r5.getY()) - this.mItemY);
        goto L12
    L5:
        if (this.mRemoveMode != 0) goto L7;
        this.mClickRemoveHitPos = viewIdHitPosition(r5, this.mClickRemoveId);
        goto L7
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r7, MotionEvent r8, float r9, float r10) {
        if (r7 == null) goto L39;
        if (r8 == null) goto L39;
        int r11 = (int) r7.getX();
        int r12 = (int) r7.getY();
        int r0 = (int) r8.getX();
        int r13 = (int) r8.getY();
        int r1 = r0 - this.mItemX;
        int r2 = r13 - this.mItemY;
        if (this.mCanDrag == false) goto L39;
        if (this.mDragging == true) goto L39;
        int r3 = this.mHitPos;
        if (r3 == (-1)) goto L13;
    L14:
        if (r3 == (-1)) goto L30;
        if (this.mDragInitMode != 1) goto L23;
        if (Math.abs(r13 - r12) <= this.mTouchSlop) goto L23;
        if (this.mSortEnabled == false) goto L23;
        startDrag(this.mHitPos, r1, r2);
    L23:
        if (this.mDragInitMode != 1) goto L39;
        if (Math.abs(r0 - r11) <= this.mTouchSlop) goto L39;
        if (this.mRemoveEnabled == false) goto L39;
        startDrag(this.mFlingHitPos, r1, r2);
        goto L39
    L30:
        if (this.mFlingHitPos == (-1)) goto L39;
        if (Math.abs(r0 - r11) <= this.mTouchSlop) goto L37;
        if (this.mRemoveEnabled == false) goto L37;
        startDrag(this.mFlingHitPos, r1, r2);
    L37:
        if (Math.abs(r13 - r12) <= this.mTouchSlop) goto L39;
        this.mCanDrag = false;
        goto L39
    L13:
        if (this.mFlingHitPos != (-1)) goto L14;
    L39:
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r4) {
        if (this.mHitPos != (-1)) goto L5;
        return;
    L5:
        if (this.mDragInitMode != 2) goto L9;
        this.mDslv.performHapticFeedback(0);
        startDrag(this.mHitPos, this.mCurrX - this.mItemX, this.mCurrY - this.mItemY);
        return;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r2) {
        if (this.mRemoveEnabled == true) goto L5;
        return true;
    L5:
        if (this.mRemoveMode != 0) goto L12;
        int r3 = this.mClickRemoveHitPos;
        if (r3 == (-1)) goto L13;
        DragSortListView r1 = this.mDslv;
        r1.removeItem(r3 - r1.getHeaderViewsCount());
        return true;
    L13:
        return true;
    L12:
        return true;
    }
}
