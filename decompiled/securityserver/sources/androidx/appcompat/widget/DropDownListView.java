package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class DropDownListView extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private Field mIsChildViewEnabled;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding;
    private int mSelectionLeftPadding;
    private int mSelectionRightPadding;
    private int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect;

    public static class GateKeeperDrawable extends DrawableWrapper {
        private boolean mEnabled;

        public GateKeeperDrawable(Drawable r1) {
            super(r1);
            this.mEnabled = true;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas r2) {
            if (this.mEnabled == false) goto L6;
            super.draw(r2);
            return;
        }

        public void setEnabled(boolean r1) {
            this.mEnabled = r1;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float r2, float r3) {
            if (this.mEnabled == false) goto L6;
            super.setHotspot(r2, r3);
            return;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int r2, int r3, int r4, int r5) {
            if (this.mEnabled == false) goto L6;
            super.setHotspotBounds(r2, r3, r4, r5);
            return;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] r2) {
            if (this.mEnabled == true) goto L5;
            return false;
        L5:
            return super.setState(r2);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean r2, boolean r3) {
            if (this.mEnabled == true) goto L5;
            return false;
        L5:
            return super.setVisible(r2, r3);
        }
    }

    public class ResolveHoverRunnable implements Runnable {
        final /* synthetic */ DropDownListView this$0;

        public ResolveHoverRunnable(DropDownListView r1) {
            this.this$0 = r1;
        }

        public void cancel() {
            DropDownListView r0 = this.this$0;
            r0.mResolveHoverRunnable = null;
            r0.removeCallbacks(this);
        }

        public void post() {
            this.this$0.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView r1 = this.this$0;
            r1.mResolveHoverRunnable = null;
            r1.drawableStateChanged();
        }
    }

    public DropDownListView(@NonNull Context r3, boolean r4) {
        super(r3, null, R.attr.dropDownListViewStyle);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mHijackFocus = r4;
        setCacheColorHint(0);
        Field r5 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");     // Catch: NoSuchFieldException -> L5
        this.mIsChildViewEnabled = r5;     // Catch: NoSuchFieldException -> L5
        r5.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View r1 = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (r1 == null) goto L5;
        r1.setPressed(false);
    L5:
        ViewPropertyAnimatorCompat r0 = this.mClickAnimation;
        if (r0 == null) goto L9;
        r0.cancel();
        this.mClickAnimation = null;
        return;
    }

    private void clickPressedItem(View r3, int r4) {
        performItemClick(r3, r4, getItemIdAtPosition(r4));
    }

    private void drawSelectorCompat(Canvas r2) {
        if (this.mSelectorRect.isEmpty() == true) goto L8;
        Drawable r0 = getSelector();
        if (r0 == null) goto L9;
        r0.setBounds(this.mSelectorRect);
        r0.draw(r2);
        return;
    L9:
        return;
    }

    private void positionSelectorCompat(int r6, View r7) {
        Rect r0 = this.mSelectorRect;
        r0.set(r7.getLeft(), r7.getTop(), r7.getRight(), r7.getBottom());
        r0.left -= this.mSelectionLeftPadding;
        r0.top -= this.mSelectionTopPadding;
        r0.right += this.mSelectionRightPadding;
        r0.bottom += this.mSelectionBottomPadding;
        boolean r1 = this.mIsChildViewEnabled.getBoolean(this);     // Catch: IllegalAccessException -> L9
        if (r7.isEnabled() == r1) goto L14;
        this.mIsChildViewEnabled.set(this, Boolean.valueOf(!r1));     // Catch: IllegalAccessException -> L9
        if (r6 == (-1)) goto L15;
        refreshDrawableState();     // Catch: IllegalAccessException -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    private void positionSelectorLikeFocusCompat(int r5, View r6) {
        Drawable r0 = getSelector();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        r0.setVisible(false, false);
    L10:
        positionSelectorCompat(r5, r6);
        if (r3 == false) goto L18;
        Rect r7 = this.mSelectorRect;
        float r8 = r7.exactCenterX();
        float r9 = r7.exactCenterY();
        if (getVisibility() == 0) goto L16;
        r1 = false;
    L16:
        r0.setVisible(r1, false);
        DrawableCompat.setHotspot(r0, r8, r9);
        return;
    L18:
        return;
    L5:
        if (r5 == (-1)) goto L7;
        r3 = true;
        goto L8
    }

    private void positionSelectorLikeTouchCompat(int r1, View r2, float r3, float r4) {
        positionSelectorLikeFocusCompat(r1, r2);
        Drawable r0 = getSelector();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r1 == (-1)) goto L9;
        DrawableCompat.setHotspot(r0, r3, r4);
        return;
    }

    private void setPressedItem(View r5, int r6, float r7, float r8) {
        this.mDrawsInPressedState = true;
        drawableHotspotChanged(r7, r8);
        if (isPressed() == true) goto L5;
        setPressed(true);
    L5:
        layoutChildren();
        int r1 = this.mMotionPosition;
        if (r1 == (-1)) goto L13;
        View r2 = getChildAt(r1 - getFirstVisiblePosition());
        if (r2 == null) goto L13;
        if (r2 == r5) goto L13;
        if (r2.isPressed() == false) goto L13;
        r2.setPressed(false);
    L13:
        this.mMotionPosition = r6;
        r5.drawableHotspotChanged(r7 - r5.getLeft(), r8 - r5.getTop());
        if (r5.isPressed() == true) goto L16;
        r5.setPressed(true);
    L16:
        positionSelectorLikeTouchCompat(r6, r5, r7, r8);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void setSelectorEnabled(boolean r1) {
        GateKeeperDrawable r0 = this.mSelector;
        if (r0 == null) goto L6;
        r0.setEnabled(r1);
        return;
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable r0 = getSelector();
        if (r0 != null) goto L5;
        return;
    L5:
        if (touchModeDrawsInPressedStateCompat() == true) goto L7;
        return;
    L7:
        if (isPressed() == false) goto L12;
        r0.setState(getDrawableState());
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r1) {
        drawSelectorCompat(r1);
        super.dispatchDraw(r1);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.mResolveHoverRunnable == null) goto L5;
        return;
    L5:
        super.drawableStateChanged();
        setSelectorEnabled(true);
        updateSelectorStateCompat();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (this.mHijackFocus == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasFocus() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (this.mHijackFocus == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasWindowFocus() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (this.mHijackFocus == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isFocused() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if (this.mHijackFocus == false) goto L7;
        if (this.mListSelectionHidden == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isInTouchMode() == true) goto L8;
        return false;
    }

    public int lookForSelectablePosition(int r4, boolean r5) {
        ListAdapter r0 = getAdapter();
        if (r0 != null) goto L5;
    L29:
        return -1;
    L5:
        if (isInTouchMode() == true) goto L29;
        int r2 = r0.getCount();
        if (getAdapter().areAllItemsEnabled() == true) goto L25;
        if (r5 == false) goto L15;
        int r3 = Math.max(0, r4);
    L11:
        if (r3 >= r2) goto L20;
        if (r0.isEnabled(r3) == true) goto L20;
        r3 = r3 + 1;
    L20:
        if (r3 < 0) goto L24;
        if (r3 >= r2) goto L24;
        return r3;
    L24:
        return -1;
    L15:
        r3 = Math.min(r4, r2 - 1);
    L16:
        if (r3 < 0) goto L20;
        if (r0.isEnabled(r3) == true) goto L20;
        r3 = r3 - 1;
        goto L16
    L25:
        if (r4 < 0) goto L29;
        if (r4 >= r2) goto L29;
        return r4;
    }

    public int measureHeightOfChildrenCompat(int r11, int r12, int r13, int r14, int r15) {
        int r16 = getListPaddingTop();
        int r17 = getListPaddingBottom();
        int r0 = getDividerHeight();
        Drawable r1 = getDivider();
        ListAdapter r2 = getAdapter();
        if (r2 == null) goto L5;
        int r18 = r16 + r17;
        if (r0 <= 0) goto L10;
        if (r1 == null) goto L10;
    L11:
        int r3 = r2.getCount();
        int r4 = 0;
        int r5 = 0;
        int r7 = 0;
        View r6 = null;
    L12:
        if (r4 >= r3) goto L38;
        int r8 = r2.getItemViewType(r4);
        if (r8 == r5) goto L16;
        r6 = null;
        r5 = r8;
    L16:
        r6 = r2.getView(r4, r6, this);
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        if (r9 != null) goto L19;
        r9 = generateDefaultLayoutParams();
        r6.setLayoutParams(r9);
    L19:
        int r10 = r9.height;
        if (r10 <= 0) goto L22;
        int r19 = View.MeasureSpec.makeMeasureSpec(r10, BasicMeasure.EXACTLY);
    L23:
        r6.measure(r11, r19);
        r6.forceLayout();
        if (r4 <= 0) goto L26;
        r18 = r18 + r0;
    L26:
        r18 = r18 + r6.getMeasuredHeight();
        if (r18 >= r14) goto L28;
        if (r15 < 0) goto L37;
        if (r4 < r15) goto L37;
        r7 = r18;
    L37:
        r4 = r4 + 1;
        goto L12
    L28:
        if (r15 < 0) goto L44;
        if (r4 <= r15) goto L45;
        if (r7 <= 0) goto L46;
        if (r18 != r14) goto L33;
        return r14;
    L33:
        return r7;
    L46:
        return r14;
    L45:
        return r14;
    L44:
        return r14;
    L22:
        r19 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L23
    L38:
        return r18;
    L10:
        r0 = 0;
        goto L11
    L5:
        return r16 + r17;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    public boolean onForwardedEvent(MotionEvent r8, int r9) {
        int r0 = r8.getActionMasked();
        if (r0 != 1) goto L5;
        boolean r3 = false;
    L12:
        int r10 = r8.findPointerIndex(r9);
        if (r10 < 0) goto L9;
        int r4 = (int) r8.getX(r10);
        int r11 = (int) r8.getY(r10);
        int r5 = pointToPosition(r4, r11);
        if (r5 != (-1)) goto L18;
        boolean r12 = true;
    L21:
        if (r3 == false) goto L23;
        if (r12 == true) goto L23;
    L24:
        if (r3 == true) goto L26;
        ListViewAutoScrollHelper r7 = this.mScrollHelper;
        if (r7 == null) goto L32;
        r7.setEnabled(false);
    L32:
        return r3;
    L26:
        if (this.mScrollHelper != null) goto L28;
        this.mScrollHelper = new ListViewAutoScrollHelper(this);
    L28:
        this.mScrollHelper.setEnabled(true);
        this.mScrollHelper.onTouch(this, r8);
    L23:
        clearPressedItem();
        goto L24
    L18:
        View r6 = getChildAt(r5 - getFirstVisiblePosition());
        setPressedItem(r6, r5, r4, r11);
        if (r0 == 1) goto L20;
    L8:
        r3 = true;
        r12 = false;
        goto L21
    L20:
        clickPressedItem(r6, r5);
    L9:
        r12 = false;
        r3 = false;
        goto L21
    L5:
        if (r0 != 2) goto L7;
        r3 = true;
        goto L12
    L7:
        if (r0 == 3) goto L9;
        goto L8
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent r5) {
        int r0 = r5.getActionMasked();
        if (r0 == 10) goto L5;
    L7:
        boolean r1 = super.onHoverEvent(r5);
        if (r0 != 9) goto L10;
    L13:
        int r6 = pointToPosition((int) r5.getX(), (int) r5.getY());
        if (r6 != (-1)) goto L16;
    L21:
        return r1;
    L16:
        if (r6 == getSelectedItemPosition()) goto L21;
        View r2 = getChildAt(r6 - getFirstVisiblePosition());
        if (r2.isEnabled() == false) goto L20;
        setSelectionFromTop(r6, r2.getTop() - getTop());
    L20:
        updateSelectorStateCompat();
        goto L21
    L10:
        if (r0 == 7) goto L13;
        setSelection(-1);
        goto L21
    L5:
        if (this.mResolveHoverRunnable != null) goto L7;
        ResolveHoverRunnable r3 = new ResolveHoverRunnable(this);
        this.mResolveHoverRunnable = r3;
        r3.post();
        goto L7
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 0) goto L6;
        this.mMotionPosition = pointToPosition((int) r3.getX(), (int) r3.getY());
    L6:
        ResolveHoverRunnable r0 = this.mResolveHoverRunnable;
        if (r0 == null) goto L10;
        r0.cancel();
    L10:
        return super.onTouchEvent(r3);
    }

    public void setListSelectionHidden(boolean r1) {
        this.mListSelectionHidden = r1;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable r2) {
        if (r2 == null) goto L4;
        GateKeeperDrawable r0 = new GateKeeperDrawable(r2);
    L5:
        this.mSelector = r0;
        super.setSelector(r0);
        Rect r1 = new Rect();
        if (r2 == null) goto L8;
        r2.getPadding(r1);
    L8:
        this.mSelectionLeftPadding = r1.left;
        this.mSelectionTopPadding = r1.top;
        this.mSelectionRightPadding = r1.right;
        this.mSelectionBottomPadding = r1.bottom;
        return;
    L4:
        r0 = null;
        goto L5
    }
}
