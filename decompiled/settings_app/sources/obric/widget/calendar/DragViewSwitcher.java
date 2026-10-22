package obric.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ViewSwitcher;

/* JADX INFO: loaded from: classes5.dex */
public class DragViewSwitcher extends ViewSwitcher implements GestureDetector.OnGestureListener, View.OnTouchListener {
    public static final int X_CHANGE = 1;
    public static final int Y_CHANGE = 2;
    public final int POINTERS_PROTECTED_DISTANCE;
    private Context mContext;
    private GestureDetector mDetector;
    private boolean mIsScroll;
    private DragViewSwitcherListener mListener;

    public interface DragViewSwitcherListener {
        boolean prepareNextView(int changeKind);

        boolean preparePreviouseView(int changeKind);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    public DragViewSwitcher(Context context) {
        super(context);
        this.mIsScroll = false;
        this.POINTERS_PROTECTED_DISTANCE = 20;
        this.mContext = context;
    }

    public void addDragViewSwitcherActor(DragViewSwitcherListener listener) {
        this.mDetector = new GestureDetector(this.mContext, this);
        this.mListener = listener;
        setFocusable(true);
        setClickable(true);
        setLongClickable(true);
        this.mDetector.setIsLongpressEnabled(true);
        setOnTouchListener(this);
    }

    public DragViewSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsScroll = false;
        this.POINTERS_PROTECTED_DISTANCE = 20;
        this.mContext = context;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e) {
        WindowManager r2 = (WindowManager) this.mContext.getSystemService("window");
        this.mIsScroll = false;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        this.mIsScroll = true;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.mIsScroll = true;
        if (Math.abs(e1.getX() - e2.getX()) <= Math.abs(e1.getY() - e2.getY())) goto L5;
        boolean r6 = false;
    L7:
        if (r6 == false) goto L13;
        if ((e1.getY() - e2.getY()) >= 0.0f) goto L11;
        boolean r3 = this.mListener.preparePreviouseView(2);
    L16:
        if (r3 == false) goto L18;
        showNext();
    L18:
        return true;
    L11:
        r3 = this.mListener.prepareNextView(2);
        goto L16
    L13:
        if ((e1.getX() - e2.getX()) >= 0.0f) goto L15;
        r3 = this.mListener.preparePreviouseView(1);
        goto L16
    L15:
        r3 = this.mListener.prepareNextView(1);
        goto L16
    L5:
        r6 = true;
        goto L7
    }

    public void onMultiTouchFling(MotionEvent e1, MotionEvent e2) {
        if (e1 == null) goto L26;
        if (e2 == null) goto L28;
        boolean r2 = false;
        if (Math.abs(e1.getX(1) - e2.getX(1)) <= Math.abs(e1.getY(1) - e2.getY(1))) goto L8;
        boolean r1 = false;
    L10:
        if (r1 == false) goto L18;
        if ((e2.getY(1) - e1.getY(1)) <= 20.0f) goto L15;
        r2 = this.mListener.preparePreviouseView(2);
    L23:
        if (r2 == false) goto L27;
        showNext();
        return;
    L27:
        return;
    L15:
        if ((e1.getY(1) - e2.getY(1)) <= 20.0f) goto L23;
        r2 = this.mListener.prepareNextView(2);
        goto L23
    L18:
        if ((e2.getX(1) - e1.getX(1)) <= 20.0f) goto L21;
        r2 = this.mListener.preparePreviouseView(1);
        goto L23
    L21:
        if ((e1.getX(1) - e2.getX(1)) <= 20.0f) goto L23;
        r2 = this.mListener.prepareNextView(1);
        goto L23
    L8:
        r1 = true;
        goto L10
    L28:
        return;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return this.mDetector.onTouchEvent(event);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if ((ev.getAction() & 255) != 0) goto L5;
        MotionEvent r3 = MotionEvent.obtain(ev);
        r3.setDownTime(SystemClock.uptimeMillis());
        this.mDetector.onTouchEvent(r3);
    L7:
        return this.mIsScroll;
    L5:
        this.mDetector.onTouchEvent(ev);
        goto L7
    }
}
