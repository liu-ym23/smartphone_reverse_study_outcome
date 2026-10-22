package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    MenuItemImpl mItemData;
    MenuBuilder.ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    private class ActionMenuItemForwardingListener extends ForwardingListener {
        final /* synthetic */ ActionMenuItemView this$0;

        public ActionMenuItemForwardingListener(ActionMenuItemView r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            if (this.this$0.mPopupCallback != null) goto L5;
            return null;
        L5:
            return this.this$0.mPopupCallback.getPopup();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean onForwardingStarted() {
            if (this.this$0.mItemInvoker != null) goto L5;
            return false;
        L5:
            if (this.this$0.mItemInvoker.invokeItem(this.this$0.mItemData) == false) goto L13;
            ShowableListMenu r3 = getPopup();
            if (r3 != null) goto L9;
            return false;
        L9:
            if (r3.isShowing() == false) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        }
    }

    public static abstract class PopupCallback {
        public abstract ShowableListMenu getPopup();

        public PopupCallback() {
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r1) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r1) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r1, char r2) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context r2) {
        this(r2, null);
    }

    public ActionMenuItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ActionMenuItemView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        Resources r0 = r4.getResources();
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.ActionMenuItemView, r6, 0);
        this.mMinWidth = r7.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        r7.recycle();
        this.mMaxIconSize = (int) ((r0.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.mAllowTextWithIcon = shouldAllowTextWithIcon();
        updateTextButtonVisibility();
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    private boolean shouldAllowTextWithIcon() {
        Configuration r4 = getContext().getResources().getConfiguration();
        int r0 = r4.screenWidthDp;
        int r1 = r4.screenHeightDp;
        if (r0 < 480) goto L5;
    L11:
        return true;
    L5:
        if (r0 < 640) goto L8;
        if (r1 >= 480) goto L11;
    L8:
        if (r4.orientation == 2) goto L11;
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
        this.mSavedPaddingLeft = r1;
        super.setPadding(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r1, int r2) {
        this.mItemData = r1;
        setIcon(r1.getIcon());
        setTitle(r1.getTitleForItemView(this));
        setId(r1.getItemId());
        if (r1.isVisible() == false) goto L5;
        int r3 = 0;
    L6:
        setVisibility(r3);
        setEnabled(r1.isEnabled());
        if (r1.hasSubMenu() == true) goto L9;
        return;
    L9:
        if (this.mForwardingListener != null) goto L13;
        this.mForwardingListener = new ActionMenuItemForwardingListener(this);
        return;
    L13:
        return;
    L5:
        r3 = 8;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.mItemData.hasSubMenu() == false) goto L11;
        ForwardingListener r0 = this.mForwardingListener;
        if (r0 == null) goto L11;
        if (r0.onTouch(this, r2) == false) goto L11;
        return true;
    L11:
        return super.onTouchEvent(r2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        MenuBuilder.ItemInvoker r2 = this.mItemInvoker;
        if (r2 == null) goto L6;
        r2.invokeItem(this.mItemData);
        return;
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker r1) {
        this.mItemInvoker = r1;
    }

    public void setPopupCallback(PopupCallback r1) {
        this.mPopupCallback = r1;
    }

    public void setExpandedFormat(boolean r2) {
        if (this.mExpandedFormat == r2) goto L8;
        this.mExpandedFormat = r2;
        MenuItemImpl r1 = this.mItemData;
        if (r1 == null) goto L9;
        r1.actionFormatChanged();
        return;
    L9:
        return;
    }

    private void updateTextButtonVisibility() {
        boolean r1 = true;
        boolean r0 = !TextUtils.isEmpty(this.mTitle);
        if (this.mIcon != null) goto L5;
    L12:
        boolean r2 = r0 & r1;
        CharSequence r3 = null;
        if (r2 == false) goto L15;
        CharSequence r4 = this.mTitle;
    L16:
        setText(r4);
        CharSequence r5 = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty(r5) == false) goto L22;
        if (r2 == false) goto L20;
        CharSequence r6 = null;
    L21:
        setContentDescription(r6);
    L23:
        CharSequence r7 = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty(r7) == false) goto L29;
        if (r2 == true) goto L28;
        r3 = this.mItemData.getTitle();
    L28:
        TooltipCompat.setTooltipText(this, r3);
        return;
    L29:
        TooltipCompat.setTooltipText(this, r7);
        return;
    L20:
        r6 = this.mItemData.getTitle();
        goto L21
    L22:
        setContentDescription(r5);
        goto L23
    L15:
        r4 = null;
        goto L16
    L5:
        if (this.mItemData.showsTextAsAction() == true) goto L7;
    L11:
        r1 = false;
        goto L12
    L7:
        if (this.mAllowTextWithIcon == true) goto L12;
        if (this.mExpandedFormat == false) goto L11;
        goto L11
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r5) {
        this.mIcon = r5;
        if (r5 == null) goto L11;
        int r0 = r5.getIntrinsicWidth();
        int r1 = r5.getIntrinsicHeight();
        int r2 = this.mMaxIconSize;
        if (r0 <= r2) goto L7;
        r1 = (int) (r1 * (r2 / r0));
        r0 = r2;
    L7:
        if (r1 <= r2) goto L9;
        r0 = (int) (r0 * (r2 / r1));
    L10:
        r5.setBounds(0, 0, r0, r2);
        goto L11
    L9:
        r2 = r1;
    L11:
        setCompoundDrawables(r5, null, null, null);
        updateTextButtonVisibility();
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r1) {
        this.mTitle = r1;
        updateTextButtonVisibility();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        if (hasText() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mItemData.getIcon() != null) goto L7;
        return true;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int r6, int r7) {
        boolean r0 = hasText();
        if (r0 == false) goto L7;
        int r1 = this.mSavedPaddingLeft;
        if (r1 < 0) goto L7;
        super.setPadding(r1, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    L7:
        super.onMeasure(r6, r7);
        int r2 = View.MeasureSpec.getMode(r6);
        int r8 = View.MeasureSpec.getSize(r6);
        int r3 = getMeasuredWidth();
        if (r2 != Integer.MIN_VALUE) goto L10;
        int r9 = Math.min(r8, this.mMinWidth);
    L12:
        if (r2 != 1073741824) goto L14;
    L17:
        if (r0 == false) goto L19;
        return;
    L19:
        if (this.mIcon == null) goto L23;
        super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L23:
        return;
    L14:
        if (this.mMinWidth <= 0) goto L17;
        if (r3 >= r9) goto L17;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r9, 1073741824), r7);
        goto L17
    L10:
        r9 = this.mMinWidth;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable r1) {
        super.onRestoreInstanceState(null);
    }
}
