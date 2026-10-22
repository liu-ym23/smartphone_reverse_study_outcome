package obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.IntArray;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class QuickDeleteEditText extends EditText {
    private static final int DELETE_BUTTON_VIR_ID = 256;
    private static final String TAG = "QuickDeleteEditText";
    private OnDeleteIconClickListener mDeleteListener;
    private boolean mDrawIcon;
    private int mIconPaddingLeft;
    private int mIconPaddingRight;
    private int mIconPaddingTop;
    private boolean mIconVisible;
    private Drawable mQuickDeleteDrawable;
    private final TouchHelper mTouchHelper;

    public interface OnDeleteIconClickListener {
        void onDeleteIconClick();
    }

    protected class TouchHelper extends ExploreByTouchHelper {
        final /* synthetic */ QuickDeleteEditText this$0;

        public TouchHelper(final QuickDeleteEditText this$0, View host) {
            this.this$0 = this$0;
            super(host);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float x, float y) {
            if (QuickDeleteEditText.access$000(this.this$0) == false) goto L8;
            Rect r2 = QuickDeleteEditText.access$100(this.this$0).getBounds();
            if ((((int) x) + this.this$0.getScrollX()) < r2.left) goto L10;
            return 256;
        L10:
            return Integer.MIN_VALUE;
        L8:
            return Integer.MIN_VALUE;
        }

        protected void getVisibleVirtualViews(IntArray virtualViewIds) {
            if (QuickDeleteEditText.access$000(this.this$0) == false) goto L6;
            virtualViewIds.add(256);
            return;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> virtualViewIds) {
            if (QuickDeleteEditText.access$000(this.this$0) == false) goto L6;
            virtualViewIds.add(256);
            return;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int virtualViewId, AccessibilityEvent event) {
            event.setContentDescription(getItemDescription());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int virtualViewId, AccessibilityNodeInfoCompat node) {
            node.setContentDescription(getItemDescription());
            node.setBoundsInParent(QuickDeleteEditText.access$100(this.this$0).getBounds());
            node.addAction(16);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int virtualViewId, int action, Bundle arguments) {
            if (action == 16) goto L7;
            return false;
        L7:
            if (virtualViewId != 256) goto L11;
            this.this$0.setText("");
            QuickDeleteEditText.access$200(this.this$0);
            return true;
        L11:
            return true;
        }

        CharSequence getItemDescription() {
            return this.this$0.getContext().getString(R.string.quick_delete);
        }
    }

    static /* synthetic */ boolean access$000(QuickDeleteEditText r0) {
        return r0.mDrawIcon;
    }

    static /* synthetic */ Drawable access$100(QuickDeleteEditText r0) {
        return r0.mQuickDeleteDrawable;
    }

    static /* synthetic */ void access$200(QuickDeleteEditText r0) {
        r0.onDeleteIconClick();
    }

    public QuickDeleteEditText(Context context) {
        this(context, null);
    }

    public QuickDeleteEditText(Context context, AttributeSet attrs) {
        this(context, attrs, context.getResources().getIdentifier("editTextStyle", "attr", "android"));
    }

    public QuickDeleteEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public QuickDeleteEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mIconPaddingRight = 54;
        this.mIconPaddingLeft = 0;
        this.mIconPaddingTop = 0;
        this.mDrawIcon = false;
        this.mIconVisible = true;
        this.mQuickDeleteDrawable = context.getDrawable(R.drawable.quick_icon_delete);
        TouchHelper r1 = new TouchHelper(this, this);
        this.mTouchHelper = r1;
        ViewCompat.setAccessibilityDelegate(this, r1);
    }

    public void setDrawable(int id) {
        this.mQuickDeleteDrawable = getContext().getDrawable(id);     // Catch: Resources.NotFoundException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "setDrawable Fails, e=" + e);
    }

    public void setIconPaddingRight(int padding) {
        this.mIconPaddingRight = padding;
    }

    public void setIconPaddingLeft(int padding) {
        this.mIconPaddingLeft = padding;
    }

    public void setIconPaddingTop(int padding) {
        this.mIconPaddingTop = padding;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (getText().length() > 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        updateDrawableVisibility(r1);
        return;
    L5:
        if (isFocused() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (getText().length() > 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        updateDrawableVisibility(r1);
        return;
    L5:
        if (isFocused() == false) goto L7;
        r1 = true;
        goto L8
    }

    public void setIconVisible(boolean visible) {
        this.mIconVisible = visible;
        invalidate();
    }

    public void updateDrawableVisibility(boolean vis) {
        if (this.mQuickDeleteDrawable != null) goto L5;
        return;
    L5:
        if (this.mDrawIcon == vis) goto L9;
        this.mDrawIcon = vis;
        this.mTouchHelper.invalidateRoot();
        return;
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        int r0 = super.getCompoundPaddingRight();
        if (shouldDrawIcon() == true) goto L5;
        return r0;
    L5:
        return this.mQuickDeleteDrawable.getIntrinsicWidth() + Math.max(r0, this.mIconPaddingRight + this.mIconPaddingLeft);
    }

    public int getHorizontalOffsetForDrawables() {
        if (shouldDrawIcon() == true) goto L7;
        return 0;
    L7:
        return this.mQuickDeleteDrawable.getIntrinsicWidth();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (shouldDrawIcon() == true) goto L5;
        return;
    L5:
        int r1 = 0;
        if (getParent() != null) goto L16;
    L11:
        Drawable r0 = this.mQuickDeleteDrawable;
        if (r0 == null) goto L18;
        int r2 = r0.getIntrinsicHeight();
        int r3 = this.mQuickDeleteDrawable.getIntrinsicWidth();
        int r4 = ((getHeight() - r2) / 2) + this.mIconPaddingTop;
        int r5 = getScrollX() + ((getWidth() - r3) - (this.mIconPaddingRight - r1));
        int r6 = r3 + r5;
        Drawable r7 = this.mQuickDeleteDrawable;
        r7.setBounds(r5, r4, r6, r2 + r4);
        this.mQuickDeleteDrawable.draw(canvas);
        return;
    L18:
        return;
    L16:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ((View) getParent()).getLayoutParams();     // Catch: ClassCastException -> L15
        if (r8 == null) goto L11;
        r1 = r8.rightMargin;     // Catch: ClassCastException -> L15
        goto L11
    }

    private boolean shouldDrawIcon() {
        if (this.mIconVisible == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mDrawIcon == false) goto L9;
        if (this.mQuickDeleteDrawable == null) goto L9;
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (shouldDrawIcon() == false) goto L17;
        if ((((int) event.getX()) + getScrollX()) < this.mQuickDeleteDrawable.getBounds().left) goto L17;
        setPressed(false);
        int r8 = event.getAction();
        if (r8 != 0) goto L9;
    L14:
        int[] r9 = onCreateDrawableState(1);
        this.mQuickDeleteDrawable.setState(mergeDrawableStates(r9, new int[]{getResources().getIdentifier("state_pressed", "attr", "android")}));
    L15:
        return true;
    L9:
        if (r8 == 2) goto L14;
        this.mQuickDeleteDrawable.setState(getDrawableState());
        if (r8 != 1) goto L15;
        setText("");
        onDeleteIconClick();
    L17:
        return super.onTouchEvent(event);
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent event) {
        if (this.mTouchHelper.dispatchHoverEvent(event) == false) goto L7;
        return true;
    L7:
        return super.dispatchHoverEvent(event);
    }

    private void onDeleteIconClick() {
        OnDeleteIconClickListener r0 = this.mDeleteListener;
        if (r0 == null) goto L5;
        r0.onDeleteIconClick();
    L5:
        this.mTouchHelper.sendEventForVirtualView(0, 1);
    }

    public void setOnDeleteIconClickListener(OnDeleteIconClickListener listener) {
        this.mDeleteListener = listener;
    }
}
