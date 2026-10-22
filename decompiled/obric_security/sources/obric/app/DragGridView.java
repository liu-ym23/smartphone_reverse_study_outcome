package obric.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public class DragGridView extends GridView {
    public static final int DRAGGING = 4;
    public static final int DROPPING = 2;
    private static final Float FLOAT_VIEW_SCALE = null;
    public static final int IDLE = 0;
    private static final int NO_CANCEL = 0;
    private static final int ON_INTERCEPT_TOUCH_EVENT = 2;
    private static final int ON_TOUCH_EVENT = 1;
    public static final int REMOVING = 1;
    public static final int STOPPED = 3;
    private boolean mBlockLayoutRequests;
    private int mBorder;
    View.OnClickListener mCancelCallBack;
    private final MotionEvent mCancelEvent;
    private int mCancelMethod;
    private int mDragDeltaX;
    private int mDragDeltaY;
    private boolean mDragEnabled;
    private DragListener mDragListener;
    public int mDragState;
    private boolean mDropOutOfBorder;
    private final Point mFloatLoc;
    private View mFloatView;
    private FloatViewAnimator mFloatViewAnimator;
    private int mFloatViewHeight;
    private FloatViewManager mFloatViewManager;
    private int mFloatViewMid;
    private boolean mGridViewIntercepted;
    private boolean mIgnoreTouchEvent;
    private boolean mInTouchEvent;
    private int mItemOffsetX;
    private int mItemOffsetY;
    private boolean mLastCallWasIntercept;
    private int mLastFloatViewMid;
    private int mSrcPos;
    private int mX;
    private int mY;

    public interface DragListener {
        void onCrossBorder(boolean into);

        void onPressedCancel();

        void onPressedDown();

        View onStartDrag(ImageView v);

        void onStopDrag(int src, boolean crossBorder, View.OnClickListener callback);
    }

    private class FloatViewAnimator {
        private int centerX;
        private int centerY;
        final /* synthetic */ DragGridView this$0;

        public FloatViewAnimator(final DragGridView this$0, boolean oneRow, int parentWidth) {
            this.this$0 = this$0;
            this.centerX = (parentWidth / 2) - 60;
            if (oneRow == false) goto L5;
            int r1 = 86;
        L6:
            this.centerY = r1;
            return;
        L5:
            r1 = 225;
            goto L6
        }

        public FloatViewAnimator(final DragGridView this$0, int centerX, int centerY) {
            this.this$0 = this$0;
            this.centerX = centerX;
            this.centerY = centerY;
        }

        public void setCenterXY(int centerX, int centerY) {
            this.centerX = centerX;
            this.centerY = centerY;
        }

        private Animator makeMoveAnimator(View v) {
            AnimatorSet r0 = new AnimatorSet();
            ObjectAnimator r1 = ObjectAnimator.ofFloat(v, View.X, new float[]{v.getX(), getTargetX()});
            ObjectAnimator r7 = ObjectAnimator.ofFloat(v, View.Y, new float[]{v.getY(), getTargetY()});
            r0.setInterpolator(new DecelerateInterpolator(1.5f));
            r0.setDuration(300);
            r0.play(r7).with(r1);
            return r0;
        }

        private Animator makeScaleAnimator(View v, float from, float to) {
            AnimatorSet r5 = new AnimatorSet();
            ObjectAnimator r0 = ObjectAnimator.ofFloat(v, View.SCALE_X, new float[]{from, to});
            ObjectAnimator r6 = ObjectAnimator.ofFloat(v, View.SCALE_Y, new float[]{from, to});
            r5.setInterpolator(new DecelerateInterpolator(1.5f));
            r5.setDuration(200);
            r5.play(r0).with(r6);
            return r5;
        }

        public void lift() {
            makeScaleAnimator(DragGridView.access$200(this.this$0), DragGridView.access$200(this.this$0).getScaleX(), DragGridView.access$300().floatValue()).start();
        }

        public void drop() {
            Animator r0 = makeMoveAnimator(DragGridView.access$200(this.this$0));
            Animator.AnimatorListener r1 = new AnonymousClass1(this);
            if (DragGridView.access$000(this.this$0) == false) goto L5;
            r0.addListener(r1);
            r0.start();
            return;
        L5:
            Animator r5 = makeScaleAnimator(DragGridView.access$200(this.this$0), DragGridView.access$200(this.this$0).getScaleX(), 1.0f);
            AnimatorSet r2 = new AnimatorSet();
            r2.playTogether(new Animator[]{r0, r5});
            r2.addListener(r1);
            r2.start();
        }

        int getTargetX() {
            if (DragGridView.access$000(this.this$0) == true) goto L7;
            return DragGridView.access$600(this.this$0).mItemX;
        L7:
            return this.centerX;
        }

        int getTargetY() {
            if (DragGridView.access$000(this.this$0) == true) goto L7;
            return DragGridView.access$600(this.this$0).mItemY;
        L7:
            return this.centerY;
        }
    }

    public class FloatViewManager implements View.OnTouchListener, GestureDetector.OnGestureListener {
        public static final int MISS = -1;
        public static final int ON_DOWN = 0;
        public static final int ON_DRAG = 1;
        public static final int ON_LONG_PRESS = 2;
        private int mCurrX;
        private int mCurrY;
        private GestureDetector mDetector;
        private DragGridView mDgv;
        private int mDragHandleId;
        private int mDragInitMode;
        private boolean mDragging;
        private int mHitPos;
        public int mItemX;
        public int mItemY;
        private int[] mTempLoc;
        final /* synthetic */ DragGridView this$0;

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent e) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        public FloatViewManager(final DragGridView this$0, DragGridView dslv) {
            this(this$0, dslv, 0, 0);
        }

        public FloatViewManager(final DragGridView this$0, DragGridView dslv, int dragHandleId, int dragInitMode) {
            this.this$0 = this$0;
            this.mDragInitMode = 0;
            this.mHitPos = -1;
            this.mTempLoc = new int[2];
            this.mDragging = false;
            this.mDgv = dslv;
            this.mDetector = new GestureDetector(dslv.getContext(), this);
            this.mDragHandleId = dragHandleId;
            this.mDragInitMode = dragInitMode;
        }

        public boolean startDrag(int position, int deltaX, int deltaY) {
            boolean r2 = this.mDgv.startDrag(position, deltaX, deltaY);
            this.mDragging = r2;
            return r2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent ev) {
            if (DragGridView.access$700(this.mDgv) == true) goto L5;
        L26:
            return false;
        L5:
            if (DragGridView.access$800(this.mDgv) == true) goto L26;
            GestureDetector r2 = this.mDetector;
            if (r2 == null) goto L26;
            if (ev == null) goto L26;
            r2.onTouchEvent(ev);
            int r3 = ev.getAction() & 255;
            if (r3 != 0) goto L14;
            this.mCurrX = (int) ev.getX();
            this.mCurrY = (int) ev.getY();
            goto L26
        L14:
            if (r3 != 1) goto L16;
        L18:
            this.mDragging = false;
            if (this.this$0.mDragState != 0) goto L26;
            if (this.mHitPos == (-1)) goto L26;
            if (DragGridView.access$900(this.this$0) == null) goto L26;
            DragGridView.access$900(this.this$0).onPressedCancel();
            goto L26
        L16:
            if (r3 == 3) goto L18;
            goto L18
        }

        public int startDragPosition(MotionEvent ev) {
            int r0 = (int) ev.getX();
            int r1 = (int) ev.getY();
            int r2 = this.mDgv.pointToPosition(r0, r1);
            int r3 = this.mDgv.getCount();
            if (r2 == (-1)) goto L21;
            if (r2 < 0) goto L21;
            if (r2 >= r3) goto L21;
            View r4 = this.mDgv.getChildAt(r2);
            int r5 = (int) ev.getRawX();
            int r9 = (int) ev.getRawY();
            int r6 = this.mDragHandleId;
            if (r6 != 0) goto L9;
            View r7 = null;
        L10:
            if (r7 == null) goto L21;
            r4.getLocationOnScreen(this.mTempLoc);
            int[] r8 = this.mTempLoc;
            int r10 = r8[0];
            if (r5 <= r10) goto L21;
            if (r9 <= r8[1]) goto L21;
            if (r5 >= (r10 + r4.getWidth())) goto L21;
            if (r9 >= (this.mTempLoc[1] + r4.getHeight())) goto L21;
            this.mItemX = (r4.getLeft() + r7.getLeft()) + DragGridView.access$1000(this.this$0);
            this.mItemY = (r4.getTop() + r7.getTop()) + DragGridView.access$1100(this.this$0);
            return r2;
        L9:
            r7 = r4.findViewById(r6);
        L21:
            return -1;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent ev) {
            int r0 = startDragPosition(ev);
            this.mHitPos = r0;
            if (r0 != (-1)) goto L5;
            return true;
        L5:
            if (this.mDragInitMode != 0) goto L8;
            startDrag(r0, ((int) ev.getX()) - this.mItemX, ((int) ev.getY()) - this.mItemY);
            return true;
        L8:
            if (DragGridView.access$900(this.this$0) == null) goto L14;
            DragGridView.access$900(this.this$0).onPressedDown();
            return true;
        L14:
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e) {
            if (this.mHitPos != (-1)) goto L5;
            return;
        L5:
            if (this.mDragInitMode != 2) goto L9;
            this.mDgv.performHapticFeedback(0);
            startDrag(this.mHitPos, this.mCurrX - this.mItemX, this.mCurrY - this.mItemY);
            return;
        }
    }

    static /* synthetic */ boolean access$000(DragGridView r0) {
        return r0.mDropOutOfBorder;
    }

    static /* synthetic */ boolean access$002(DragGridView r0, boolean r1) {
        r0.mDropOutOfBorder = r1;
        return r1;
    }

    static /* synthetic */ FloatViewAnimator access$100(DragGridView r0) {
        return r0.mFloatViewAnimator;
    }

    static /* synthetic */ int access$1000(DragGridView r0) {
        return r0.mItemOffsetX;
    }

    static /* synthetic */ int access$1100(DragGridView r0) {
        return r0.mItemOffsetY;
    }

    static /* synthetic */ View access$200(DragGridView r0) {
        return r0.mFloatView;
    }

    static /* synthetic */ Float access$300() {
        return FLOAT_VIEW_SCALE;
    }

    static /* synthetic */ void access$400(DragGridView r0, boolean r1, boolean r2) {
        r0.adjustDragItem(r1, r2);
    }

    static /* synthetic */ void access$500(DragGridView r0) {
        r0.dropFloatView();
    }

    static /* synthetic */ FloatViewManager access$600(DragGridView r0) {
        return r0.mFloatViewManager;
    }

    static /* synthetic */ boolean access$700(DragGridView r0) {
        return r0.mDragEnabled;
    }

    static /* synthetic */ boolean access$800(DragGridView r0) {
        return r0.mGridViewIntercepted;
    }

    static /* synthetic */ DragListener access$900(DragGridView r0) {
        return r0.mDragListener;
    }

    static {
        FLOAT_VIEW_SCALE = Float.valueOf(1.6f);
    }

    public DragGridView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.gridViewStyle);
    }

    public DragGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mFloatLoc = new Point();
        this.mBorder = Integer.MAX_VALUE;
        this.mDragEnabled = true;
        this.mDragState = 0;
        this.mLastCallWasIntercept = false;
        this.mInTouchEvent = false;
        this.mFloatViewManager = null;
        this.mCancelMethod = 0;
        this.mBlockLayoutRequests = false;
        this.mGridViewIntercepted = false;
        this.mIgnoreTouchEvent = false;
        this.mCancelCallBack = new AnonymousClass1(this);
        FloatViewManager r1 = new FloatViewManager(this, this, obric.widget.R.id.icon_image, 2);
        this.mFloatViewManager = r1;
        setOnTouchListener(r1);
        MotionEvent r2 = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mCancelEvent = r2;
        r2.recycle();
        this.mItemOffsetX = context.getResources().getDimensionPixelOffset(obric.widget.R.dimen.view_pager_margin_left);
        this.mItemOffsetY = context.getResources().getDimensionPixelOffset(obric.widget.R.dimen.view_pager_margin_top);
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mBlockLayoutRequests == true) goto L6;
        super.requestLayout();
        return;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        boolean r1 = false;
        if (this.mIgnoreTouchEvent == false) goto L7;
        this.mIgnoreTouchEvent = false;
        return false;
    L7:
        if (this.mDragEnabled == false) goto L9;
        boolean r0 = this.mLastCallWasIntercept;
        this.mLastCallWasIntercept = false;
        if (r0 == true) goto L13;
        saveTouchCoords(ev);
    L13:
        int r2 = this.mDragState;
        if (r2 != 4) goto L16;
        onDragTouchEvent(ev);
        return true;
    L16:
        if (r2 == 0) goto L18;
    L20:
        int r5 = ev.getAction() & 255;
        if (r5 != 1) goto L23;
    L26:
        doActionUpOrCancel();
    L28:
        return r1;
    L23:
        if (r5 == 3) goto L26;
        if (r1 == false) goto L28;
        this.mCancelMethod = 1;
        goto L28
    L18:
        if (super.onTouchEvent(ev) == false) goto L20;
        r1 = true;
        goto L20
    L9:
        return super.onTouchEvent(ev);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mDragEnabled == false) goto L5;
        saveTouchCoords(ev);
        this.mLastCallWasIntercept = true;
        int r1 = ev.getAction() & 255;
        if (r1 != 0) goto L14;
        if (this.mDragState == 0) goto L12;
        this.mIgnoreTouchEvent = true;
        return true;
    L12:
        this.mInTouchEvent = true;
    L14:
        if (this.mFloatView == null) goto L17;
        boolean r6 = true;
    L26:
        if (r1 == 1) goto L28;
        if (r1 == 3) goto L28;
    L29:
        return r6;
    L28:
        this.mInTouchEvent = false;
        goto L29
    L17:
        if (super.onInterceptTouchEvent(ev) == false) goto L19;
        this.mGridViewIntercepted = true;
        r6 = true;
    L20:
        if (r1 == 1) goto L25;
        if (r1 == 3) goto L25;
        if (r6 == false) goto L24;
        this.mCancelMethod = 1;
        goto L26
    L24:
        this.mCancelMethod = 2;
    L25:
        doActionUpOrCancel();
        goto L26
    L19:
        r6 = false;
        goto L20
    L5:
        return super.onInterceptTouchEvent(ev);
    }

    protected boolean onDragTouchEvent(MotionEvent ev) {
        int r0 = ev.getAction() & 255;
        if (r0 == 1) goto L15;
        if (r0 != 2) goto L7;
        continueDrag((int) ev.getX(), (int) ev.getY());
    L18:
        return true;
    L7:
        if (r0 != 3) goto L18;
        if (this.mDragState != 4) goto L12;
        stopDrag();
    L12:
        doActionUpOrCancel();
        goto L18
    L15:
        if (this.mDragState != 4) goto L17;
        stopDrag();
    L17:
        doActionUpOrCancel();
        goto L18
    }

    private void doActionUpOrCancel() {
        this.mCancelMethod = 0;
        this.mInTouchEvent = false;
        if (this.mDragState != 3) goto L5;
        this.mDragState = 0;
    L5:
        this.mGridViewIntercepted = false;
    }

    private void saveTouchCoords(MotionEvent ev) {
        this.mX = (int) ev.getX();
        this.mY = (int) ev.getY();
    }

    private void dropFloatView() {
        this.mDragState = 2;
        if (this.mDropOutOfBorder == true) goto L5;
        adjustDragItem(true, true);
        this.mSrcPos = -1;
        destroyFloatView();
    L7:
        if (this.mInTouchEvent == false) goto L9;
        this.mDragState = 3;
        return;
    L9:
        this.mDragState = 0;
        return;
    L5:
        adjustDragItem(false, true);
        goto L7
    }

    public boolean stopDrag() {
        boolean r1 = false;
        if (this.mFloatView != null) goto L5;
        return false;
    L5:
        if (this.mFloatViewMid < this.mBorder) goto L7;
        r1 = true;
    L7:
        this.mDropOutOfBorder = r1;
        DragListener r0 = this.mDragListener;
        if (r0 == null) goto L10;
        r0.onStopDrag(this.mSrcPos, r1, this.mCancelCallBack);
    L10:
        FloatViewAnimator r2 = this.mFloatViewAnimator;
        if (r2 == null) goto L13;
        r2.drop();
    L14:
        return true;
    L13:
        dropFloatView();
        goto L14
    }

    private void continueDrag(int x, int y) {
        Point r0 = this.mFloatLoc;
        r0.x = x - this.mDragDeltaX;
        Point r3 = this.mFloatLoc;
        r3.y = y - this.mDragDeltaY;
        doDragFloatView();
    }

    public boolean startDrag(int position, int deltaX, int deltaY) {
        if (this.mDragEnabled == true) goto L5;
        return false;
    L5:
        if (this.mInTouchEvent == true) goto L7;
        return false;
    L7:
        if (this.mFloatViewManager == null) goto L22;
        DragListener r0 = this.mDragListener;
        if (r0 == null) goto L12;
        View r1 = r0.onStartDrag((ImageView) getChildAt(position).findViewById(obric.widget.R.id.icon_image));
    L13:
        if (r1 != null) goto L15;
        return false;
    L15:
        if (startDrag(position, r1, deltaX, deltaY) == false) goto L21;
        return true;
    L21:
        return false;
    L12:
        r1 = null;
        goto L13
    L22:
        return false;
    }

    public boolean startDrag(int position, View floatView, int deltaX, int deltaY) {
        if (this.mDragState == 0) goto L5;
    L26:
        return false;
    L5:
        if (this.mFloatView != null) goto L26;
        if (floatView == null) goto L26;
        if (getParent() == null) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
    L11:
        this.mSrcPos = position;
        this.mDragState = 4;
        this.mDropOutOfBorder = false;
        this.mFloatView = floatView;
        this.mFloatViewHeight = floatView.getMeasuredHeight();
        this.mDragDeltaX = deltaX;
        this.mDragDeltaY = deltaY;
        this.mFloatLoc.x = this.mX - deltaX;
        this.mFloatLoc.y = this.mY - this.mDragDeltaY;
        this.mFloatView.setX(this.mFloatLoc.x);
        this.mFloatView.setY(this.mFloatLoc.y);
        if (this.mFloatView.getVisibility() == 0) goto L14;
        this.mFloatView.setVisibility(0);
    L14:
        FloatViewAnimator r4 = this.mFloatViewAnimator;
        if (r4 == null) goto L17;
        r4.lift();
    L17:
        adjustDragItem(false, false);
        int r5 = this.mCancelMethod;
        if (r5 != 1) goto L20;
        super.onTouchEvent(this.mCancelEvent);
    L24:
        requestLayout();
        return true;
    L20:
        if (r5 != 2) goto L24;
        super.onInterceptTouchEvent(this.mCancelEvent);
        goto L24
    }

    private void doDragFloatView() {
        this.mBlockLayoutRequests = true;
        updateFloatView();
        DragListener r1 = this.mDragListener;
        if (r1 == null) goto L15;
        int r3 = this.mLastFloatViewMid;
        int r4 = this.mFloatViewMid;
        if (r3 >= r4) goto L10;
        int r5 = this.mBorder;
        if (r3 >= r5) goto L15;
        if (r4 < r5) goto L15;
        r1.onCrossBorder(true);
        goto L15
    L10:
        if (r3 <= r4) goto L15;
        int r0 = this.mBorder;
        if (r3 < r0) goto L15;
        if (r4 >= r0) goto L15;
        r1.onCrossBorder(false);
    L15:
        invalidate();
        this.mBlockLayoutRequests = false;
    }

    private void updateFloatView() {
        int r0 = this.mFloatViewHeight / 2;
        int r1 = getPaddingTop() + ((int) ((FLOAT_VIEW_SCALE.floatValue() - 1.0f) * r0));
        if (this.mFloatLoc.y >= r1) goto L5;
        this.mFloatLoc.y = r1;
    L5:
        this.mLastFloatViewMid = this.mFloatViewMid;
        this.mFloatViewMid = this.mFloatLoc.y + r0;
        this.mFloatView.setX(this.mFloatLoc.x);
        this.mFloatView.setY(this.mFloatLoc.y);
    }

    private void destroyFloatView() {
        View r0 = this.mFloatView;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        ((ImageView) this.mFloatView).setImageDrawable(null);
        this.mFloatView.setScaleX(1.0f);
        this.mFloatView.setScaleY(1.0f);
        this.mFloatView = null;
        invalidate();
        return;
    }

    private void adjustDragItem(boolean iconVisible, boolean textEnabled) {
        View r1 = getChildAt(this.mSrcPos);
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r1.getTag() instanceof ResolverDialog.ViewHolder) == false) goto L13;
        ResolverDialog.ViewHolder r2 = (ResolverDialog.ViewHolder) r1.getTag();
        ImageView r0 = r2.icon;
        if (iconVisible == false) goto L9;
        int r3 = 0;
    L10:
        r0.setVisibility(r3);
        r2.text.setEnabled(textEnabled);
        return;
    L9:
        r3 = 4;
        goto L10
    }

    public void setDragListener(DragListener l) {
        this.mDragListener = l;
    }

    public void setDragEnabled(boolean enabled) {
        this.mDragEnabled = enabled;
    }

    public void setBorder(int border) {
        this.mBorder = border;
    }

    public void initFloatViewAnimator(boolean oneRow, int parentWidth) {
        this.mFloatViewAnimator = new FloatViewAnimator(this, oneRow, parentWidth);
    }

    public void initFloatViewAnimator(int centerX, int centerY) {
        this.mFloatViewAnimator = new FloatViewAnimator(this, centerX, centerY);
    }

    public void setCenterXY(int centerX, int centerY) {
        FloatViewAnimator r0 = this.mFloatViewAnimator;
        if (r0 == null) goto L6;
        r0.setCenterXY(centerX, centerY);
        return;
    }

    public void setItemOffset(int offsetX, int offsetY) {
        this.mItemOffsetX = offsetX;
        this.mItemOffsetY = offsetY;
    }
}
