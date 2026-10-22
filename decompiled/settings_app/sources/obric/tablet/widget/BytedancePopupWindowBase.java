package obric.tablet.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import bytedanceos.api.ViewSmt;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BytedancePopupWindowBase {
    private View mAnchorView;
    private boolean mAppOverlayType;
    private ImageView mArrowDown;
    private final int mArrowHeight;
    private ImageView mArrowUp;
    private int mArrowVerticalMargin;
    private final int mArrowVerticalMaxMargin;
    private final int mArrowWidth;
    private boolean mClippingEnabled;
    protected final Context mContext;
    private PopupWindow.OnDismissListener mDismissListener;
    private BytedancePopupWindowInterface.OnShowListener mOnShowListener;
    private RelativeLayout mPopupContentView;
    private PopupWindow mPopupWindow;
    private boolean mShowArrow;
    private int mWindowWidth;

    protected abstract void initContentView(ViewGroup r1);

    protected abstract void preShow();

    public void show(int r1, int r2) {
    }

    static /* synthetic */ View access$000(BytedancePopupWindowBase r0) {
        return r0.mAnchorView;
    }

    static /* synthetic */ void access$100(BytedancePopupWindowBase r0, PopupWindow r1, View r2, View r3) {
        r0.adjustArrowPosition(r1, r2, r3);
    }

    public BytedancePopupWindowBase(View r4) {
        this.mShowArrow = true;
        this.mAppOverlayType = true;
        this.mClippingEnabled = true;
        Context r0 = r4.getContext();
        this.mContext = r0;
        this.mAnchorView = r4;
        this.mWindowWidth = r0.getResources().getDimensionPixelSize(R.dimen.revone_global_popupwindow_width);
        int r5 = r0.getResources().getDimensionPixelSize(R.dimen.revone_arrow_default_margin);
        this.mArrowVerticalMaxMargin = r5;
        this.mArrowWidth = r0.getResources().getDimensionPixelSize(R.dimen.revone_arrow_width);
        this.mArrowHeight = r0.getResources().getDimensionPixelSize(R.dimen.revone_arrow_height);
        this.mArrowVerticalMargin = r5;
        this.mPopupContentView = initPopupWindowContent();
    }

    private PopupWindow createPopupWindow(final View r5) {
        r5.measure(0, 0);
        int r1 = r5.getMeasuredHeight();
        if (this.mShowArrow == false) goto L5;
        r1 = r1 + this.mArrowHeight;
    L5:
        final PopupWindow r2 = new PopupWindow(r5, this.mWindowWidth, r1, false);
        if (this.mShowArrow == false) goto L8;
        r5.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(this, r2, r5));
    L8:
        r2.setClippingEnabled(this.mClippingEnabled);
        r2.setOverlapAnchor(false);
        r2.setOutsideTouchable(true);
        r2.setTouchable(true);
        r2.setFocusable(true);
        r2.setBackgroundDrawable(this.mContext.getResources().getDrawable(android.R.color.transparent));
        r2.setContentView(r5);
        r2.setOnDismissListener(this.mDismissListener);
        r2.update();
        return r2;
    }

    private void adjustArrowPosition(PopupWindow r5, View r6, View r7) {
        if (r5.isAboveAnchor() == false) goto L5;
        this.mArrowUp.setVisibility(8);
        this.mArrowDown.setVisibility(0);
        ImageView r8 = this.mArrowDown;
    L6:
        int[] r2 = new int[2];
        r6.getLocationOnScreen(r2);
        int r3 = ((ViewSmt.getInstance().getRealLocationOnScreen(r7)[0] - r2[0]) + (r7.getWidth() / 2)) - (this.mArrowWidth / 2);
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) r8.getLayoutParams();
        if (r4.leftMargin == r3) goto L12;
        r4.leftMargin = r3;
        if (r6.isInLayout() == true) goto L13;
        r6.requestLayout();
        r6.invalidate();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        this.mArrowUp.setVisibility(0);
        this.mArrowDown.setVisibility(8);
        r8 = this.mArrowUp;
        goto L6
    }

    public void show() {
        show(0, 0);
    }

    private RelativeLayout initPopupWindowContent() {
        RelativeLayout r0 = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.revone_global_popupwindow, null);
        initContentView((ViewGroup) r0.findViewById(R.id.revone_popupwindow_content));
        this.mArrowUp = (ImageView) r0.findViewById(R.id.revone_popupwindow_dialog_arrow_up);
        this.mArrowDown = (ImageView) r0.findViewById(R.id.revone_popupwindow_dialog_arrow_down);
        return r0;
    }

    public void setOnShowListener(BytedancePopupWindowInterface.OnShowListener r1) {
        this.mOnShowListener = r1;
    }

    public boolean isShowing() {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isShowing();
    }

    public void dismiss() {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L8;
        r0.dismiss();
        this.mPopupWindow.setContentView(null);
        PopupWindow.OnDismissListener r2 = this.mDismissListener;
        if (r2 == null) goto L9;
        r2.onDismiss();
        return;
    L9:
        return;
    }

    public void setDismissListener(PopupWindow.OnDismissListener r1) {
        this.mDismissListener = r1;
    }

    public void setShowArrow(boolean r1) {
        this.mShowArrow = r1;
    }

    public void setVerticalMargin(int r2) {
        if (r2 >= 0) goto L4;
        this.mArrowVerticalMargin = 0;
    L4:
        int r0 = this.mArrowVerticalMaxMargin;
        if (r2 <= r0) goto L7;
        this.mArrowVerticalMargin = r0;
        return;
    L7:
        this.mArrowVerticalMargin = r2;
    }

    public void setWindowWidth(int r2) {
        if (r2 <= 0) goto L4;
        this.mWindowWidth = r2;
        return;
    L4:
        this.mWindowWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.revone_global_popupwindow_width);
    }

    public void setAppOverlayType(boolean r1) {
        this.mAppOverlayType = r1;
    }

    public void setClippingEnabled(boolean r1) {
        this.mClippingEnabled = r1;
    }
}
