package com.obric.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class PopupMenuRemovableListItem extends RelativeLayout {
    private FrameLayout mCloseIcon;
    private ImageView mMenuIcon;
    private TextView mMenuTitle;

    public PopupMenuRemovableListItem(Context r2) {
        this(r2, null);
    }

    public PopupMenuRemovableListItem(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PopupMenuRemovableListItem(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        View r4 = LayoutInflater.from(r1).inflate(R.layout.o_popup_menu_removable_list_item, this, true);
        this.mMenuIcon = (ImageView) r4.findViewById(R.id.menu_icon);
        this.mMenuTitle = (TextView) r4.findViewById(R.id.menu_title);
        this.mCloseIcon = (FrameLayout) r4.findViewById(R.id.menu_closed);
    }

    public void setMenuIcon(int r2) {
        setMenuIcon(getResources().getDrawable(r2));
    }

    public void setMenuIcon(Drawable r4) {
        this.mMenuIcon.setImageDrawable(r4);
        ImageView r0 = this.mMenuIcon;
        boolean r1 = false;
        if (r4 == null) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        if (r4 == null) goto L9;
        r1 = true;
    L9:
        adjustMenuTitleMargin(r1);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void adjustMenuTitleMargin(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 0;
    L5:
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mMenuTitle.getLayoutParams();
        if (r0 == null) goto L9;
        r0.leftMargin = r3;
        this.mMenuTitle.setLayoutParams(r0);
        return;
    L9:
        return;
    L4:
        r3 = getResources().getDimensionPixelSize(R.dimen.popup_list_title_left_margin);
        goto L5
    }

    public ImageView getIconView() {
        return this.mMenuIcon;
    }

    public void setMenuTitle(int r2) {
        setMenuTitle(getResources().getString(r2));
    }

    public void setMenuTitle(CharSequence r1) {
        this.mMenuTitle.setText(r1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
        super.onInitializeAccessibilityNodeInfo(r1);
        r1.setClassName(PopupMenuStandardListItem.class.getName());
        r1.setCheckable(true);
    }

    public void setOnCloseIconClickListener(View.OnClickListener r1) {
        this.mCloseIcon.setOnClickListener(r1);
    }

    public View getCloseIconView() {
        return this.mCloseIcon;
    }

    public void setCloseIconVisibility(int r1) {
        this.mCloseIcon.setVisibility(r1);
    }
}
