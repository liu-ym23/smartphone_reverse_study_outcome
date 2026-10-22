package com.obric.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.android.settings.R;
import obric.InvokeApi;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PopupMenu {
    public static final int DIRECTION_BOTTOM = 1;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 3;
    public static final int DIRECTION_TOP = 0;
    protected View mAnchorView;
    private int mArrowHeight;
    private boolean mArrowVisible;
    private int mArrowWidth;
    private boolean mAutoAdjustPopupDirection;
    protected int mBgLeftRightShadowWidth;
    protected int mBgTopBottomShadowHeight;
    private boolean mClipToScreen;
    protected int mContentAreaWidth;
    protected Context mContext;
    private PopupWindow.OnDismissListener mDismissListener;
    private int mMenuPanelBgRoundCornerRadius;
    protected View mMenuPanelView;
    private boolean mMenuPopup;
    private int mMinDistance;
    protected PopupWindow mPopupWindow;
    private boolean mRequestFocusable;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean mShowAboveAnchor;

    protected void onArrowViewInflated(ImageView r1) {
    }

    protected abstract void prepareShow();

    public PopupMenu(Context r3) {
        this.mRequestFocusable = true;
        this.mArrowVisible = false;
        this.mClipToScreen = true;
        this.mMenuPopup = false;
        this.mAutoAdjustPopupDirection = false;
        this.mContext = r3;
        this.mPopupWindow = new PopupWindow(r3);
        Resources r0 = this.mContext.getResources();
        this.mBgLeftRightShadowWidth = r0.getDimensionPixelSize(R.dimen.popup_bg_left_right_shadow_width);
        this.mBgTopBottomShadowHeight = r0.getDimensionPixelSize(R.dimen.popup_bg_top_bottom_shadow_height);
        this.mMenuPanelBgRoundCornerRadius = r0.getDimensionPixelSize(R.dimen.oui_r_xl1__menu);
        this.mArrowWidth = r0.getDimensionPixelSize(R.dimen.menu_panel_bg_arrow_width);
        this.mArrowHeight = r0.getDimensionPixelSize(R.dimen.menu_panel_bg_arrow_height);
        this.mMinDistance = r0.getDimensionPixelSize(R.dimen.menu_panel_bg_min_distance);
        WindowManager r4 = (WindowManager) r3.getSystemService("window");
        if (r4 == null) goto L5;
        Point r1 = new Point();
        r4.getDefaultDisplay().getRealSize(r1);
        this.mScreenWidth = r1.x;
        this.mScreenHeight = r1.y;
        return;
    L5:
        DisplayMetrics r5 = this.mContext.getResources().getDisplayMetrics();
        this.mScreenWidth = r5.widthPixels;
        this.mScreenHeight = r5.heightPixels;
    }

    public void show(int r8, int r9, int r10, int r11, int r12) {
        show(r8, r9, r10, r11, r12, false);
    }

    public void show(int r12, int r13, int r14, int r15, int r16, boolean r17) {
        prepareShow();
        this.mPopupWindow.setWidth(getPopupWindowWidth());
        this.mPopupWindow.setHeight(-2);
        InvokeApi.xPopupWindow.setClipToScreenEnabled(this.mPopupWindow, true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setFocusable(this.mRequestFocusable);
        this.mPopupWindow.setBackgroundDrawable(this.mContext.getResources().getDrawable(android.R.color.transparent));
        this.mPopupWindow.setOnDismissListener(this.mDismissListener);
        this.mPopupWindow.update();
        int[] r0 = new int[2];
        this.mAnchorView.getLocationInWindow(r0);
        this.mPopupWindow.setAnimationStyle(getAnimationStyle());
        View r7 = createContentViewWithArrow(r12, r15, r16);
        if (this.mArrowVisible == true) goto L5;
        setArrowVisible(r7, false);
    L5:
        int r9 = r0[0] + r13;
        int r10 = r0[1] + r14;
        setArrowLocOnLayout(r7, r12, r15, r16, r17);
        this.mPopupWindow.setContentView(r7);
        if (this.mMenuPopup == false) goto L13;
        this.mMenuPanelView.measure(0, View.MeasureSpec.makeMeasureSpec(this.mScreenHeight, Integer.MIN_VALUE));
        int r1 = this.mMenuPanelView.getMeasuredHeight();
        if (this.mArrowVisible == false) goto L10;
        int r2 = this.mArrowHeight;
    L11:
        r10 = r10 - ((r1 + r2) + this.mAnchorView.getMeasuredHeight());
        goto L13
    L10:
        r2 = 0;
    L13:
        if (this.mClipToScreen == true) goto L27;
        this.mMenuPanelView.measure(0, View.MeasureSpec.makeMeasureSpec(this.mScreenHeight, Integer.MIN_VALUE));
        int r3 = this.mMinDistance;
        int r4 = this.mContext.getResources().getConfiguration().orientation;
        int r5 = (((this.mBgLeftRightShadowWidth + r9) + this.mContentAreaWidth) + r3) - this.mScreenWidth;
        int r6 = (((this.mBgTopBottomShadowHeight + r10) + this.mMenuPanelView.getMeasuredHeight()) + r3) - this.mScreenHeight;
        if (this.mAutoAdjustPopupDirection == false) goto L23;
        if (r5 <= 0) goto L18;
        r9 = Math.max(r9 - this.mContentAreaWidth, -(this.mBgLeftRightShadowWidth - this.mMinDistance));
    L18:
        int r8 = this.mContext.getResources().getDimensionPixelSize(InvokeApi.xComAndroidInternalR.getResId("dimen", "status_bar_height"));
        int r11 = r10 - this.mMenuPanelView.getMeasuredHeight();
        int r18 = this.mBgTopBottomShadowHeight;
        int r19 = this.mMinDistance;
        int r20 = (r11 + r18) - r19;
        if (r20 >= r8) goto L22;
        if (r6 <= 0) goto L27;
    L26:
        r10 = r10 - r6;
        goto L27
    L22:
        r10 = (r20 + r19) - r18;
        goto L27
    L23:
        if (r5 <= 0) goto L25;
        r9 = r9 - r5;
    L25:
        if (r6 > 0) goto L26;
    L27:
        this.mPopupWindow.showAtLocation(this.mAnchorView, 51, r9, r10);
    }

    public int getPopupWindowWidth() {
        return this.mContentAreaWidth + (this.mBgLeftRightShadowWidth * 2);
    }

    public int getLeftRightShadowWidth() {
        return this.mBgLeftRightShadowWidth;
    }

    public int getMenuPanelBgRoundCornerRadius() {
        return this.mMenuPanelBgRoundCornerRadius;
    }

    public void showCenter() {
        showCenter(0, 0);
    }

    public void showCenter(int r10, int r11) {
        show(0, (getAnchorView().getWidth() / 2) - (getPopupWindowWidth() / 2), r10, ((getPopupWindowWidth() / 2) - getLeftRightShadowWidth()) - getMenuPanelBgRoundCornerRadius(), r11, true);
    }

    public void setShowAboveAnchor(boolean r1) {
        this.mShowAboveAnchor = r1;
    }

    private int getAnimationStyle() {
        if (this.mShowAboveAnchor == false) goto L6;
        return InvokeApi.xComAndroidInternalR.getResId("style", "Animation_DropDownUp");
    L6:
        return InvokeApi.xComAndroidInternalR.getResId("style", "Animation_DropDownDown");
    }

    public boolean isShowing() {
        return this.mPopupWindow.isShowing();
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
        this.mPopupWindow.setContentView(null);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r1) {
        this.mDismissListener = r1;
    }

    protected View createContentViewWithArrow(int r8, int r9, int r10) {
        if (r8 == 0) goto L12;
        if (r8 == 1) goto L11;
        if (r8 == 2) goto L10;
        if (r8 != 3) goto L9;
        int r3 = R.layout.popup_menu_layout_for_right;
    L13:
        View r4 = LayoutInflater.from(this.mContext).inflate(r3, null);
        FrameLayout r5 = (FrameLayout) r4.findViewById(R.id.place_holder);
        ImageView r6 = (ImageView) r4.findViewById(R.id.arrow);
        onArrowViewInflated(r6);
        if (r8 == 0) goto L20;
        if (r8 == 1) goto L20;
        if (r8 == 2) goto L19;
        if (r8 == 3) goto L19;
    L21:
        if (r8 == 0) goto L29;
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L27;
        if (r8 != 3) goto L30;
        r5.addView(this.mMenuPanelView);
    L30:
        r5.setBackgroundResource(R.drawable.popup_menu_bg_shadow);
        this.mMenuPanelView.setOnClickListener(new AnonymousClass1(this));
        r5.setOnClickListener(new AnonymousClass2(this));
        return r4;
    L27:
        r5.addView(this.mMenuPanelView);
        goto L30
    L28:
        r5.addView(this.mMenuPanelView);
        goto L30
    L29:
        r5.addView(this.mMenuPanelView);
    L19:
        r6.setY((r10 + this.mBgTopBottomShadowHeight) + this.mMenuPanelBgRoundCornerRadius);
    L20:
        int r11 = this.mMenuPanelBgRoundCornerRadius;
        r6.setX(Math.min(r9 + r11, (this.mContentAreaWidth - r11) - this.mArrowWidth) + this.mBgLeftRightShadowWidth);
        goto L21
    L9:
        throw new IllegalArgumentException("unknown direction value:" + r8);
    L10:
        r3 = R.layout.popup_menu_layout_for_left;
        goto L13
    L11:
        setShowAboveAnchor(true);
        r3 = R.layout.popup_menu_layout_for_bottom;
        goto L13
    L12:
        r3 = R.layout.popup_menu_layout_for_top;
        goto L13
    }

    public void setAnchorView(View r1) {
        this.mAnchorView = r1;
    }

    public View getAnchorView() {
        return this.mAnchorView;
    }

    public void setContentAreaWidth(int r1) {
        this.mContentAreaWidth = r1;
    }

    public void setFocusable(boolean r1) {
        this.mRequestFocusable = r1;
    }

    private void setArrowVisible(View r1, boolean r2) {
        if (r1 != null) goto L15;
        return;
    L15:
        View r0 = r1.findViewById(R.id.arrow);     // Catch: Exception -> L11
        if (r0 == null) goto L14;
        if (r2 == false) goto L9;
        r0.setVisibility(0);     // Catch: Exception -> L11
        goto L14
    L9:
        r0.setVisibility(8);     // Catch: Exception -> L11
    L14:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public void setArrowInvisible() {
        this.mArrowVisible = false;
    }

    public PopupWindow getPopupWindow() {
        return this.mPopupWindow;
    }

    public void setClipToScreenEnabled(boolean r1) {
        this.mClipToScreen = r1;
    }

    public void setAutoAdjustPopupDirection(boolean r1) {
        this.mAutoAdjustPopupDirection = r1;
    }

    public void setMenuPopup(boolean r1) {
        this.mMenuPopup = r1;
    }

    private void setArrowLocOnLayout(View r1, int r2, int r3, int r4, boolean r5) {
        final ImageView r6 = (ImageView) r1.findViewById(R.id.arrow);
        if (r6 == null) goto L7;
        if (r5 == false) goto L8;
        r6.addOnLayoutChangeListener(new AnonymousClass3(this, r6));
        return;
    L8:
        return;
    }
}
