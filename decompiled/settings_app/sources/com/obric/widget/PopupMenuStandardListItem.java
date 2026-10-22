package com.obric.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class PopupMenuStandardListItem extends RelativeLayout {
    private ImageView mMenuIcon;
    private TextView mMenuSubtitle;
    private TextView mMenuTitle;
    private ImageView mSelectedIcon;

    public PopupMenuStandardListItem(Context r2) {
        this(r2, null);
    }

    public PopupMenuStandardListItem(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PopupMenuStandardListItem(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        View r4 = LayoutInflater.from(r1).inflate(R.layout.o_popup_menu_standard_list_item, this, true);
        this.mMenuIcon = (ImageView) r4.findViewById(R.id.menu_icon);
        this.mSelectedIcon = (ImageView) r4.findViewById(R.id.menu_selected);
        this.mMenuTitle = (TextView) r4.findViewById(R.id.menu_title);
        this.mMenuSubtitle = (TextView) r4.findViewById(R.id.subtitle);
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

    public void adjustMenuTitleMargin(boolean r4) {
        if (r4 == false) goto L4;
        int r5 = 0;
    L5:
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) this.mMenuTitle.getLayoutParams();
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.mMenuSubtitle.getLayoutParams();
        if (r0 == null) goto L8;
        r0.leftMargin = r5;
        this.mMenuTitle.setLayoutParams(r0);
    L8:
        if (r1 == null) goto L11;
        r1.leftMargin = r5;
        this.mMenuSubtitle.setLayoutParams(r1);
        return;
    L11:
        return;
    L4:
        r5 = getResources().getDimensionPixelSize(R.dimen.popup_list_title_left_margin);
        goto L5
    }

    public ImageView getIconView() {
        return this.mMenuIcon;
    }

    public void setMenuTitle(int r2) {
        setMenuTitle(getResources().getString(r2));
    }

    public void setMenuTitle(CharSequence r2) {
        this.mMenuTitle.setText(r2);
        adjustTitleTextSize();
    }

    public void setMenuSubtitle(CharSequence r3) {
        this.mMenuSubtitle.setVisibility(0);
        this.mMenuSubtitle.setText(r3);
        adjustTitleTextSize();
    }

    public void adjustTitleTextSize() {
        if (this.mMenuSubtitle.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        TextView r1 = this.mMenuTitle;
        if (r0 == false) goto L9;
        float r2 = 14.0f;
    L10:
        r1.setTextSize(r2);
        return;
    L9:
        r2 = 15.0f;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public void setChecked(boolean r1) {
        ImageView r0 = this.mSelectedIcon;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public boolean isChecked() {
        if (this.mSelectedIcon.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        r2.setClassName(PopupMenuStandardListItem.class.getName());
        r2.setCheckable(true);
        r2.setChecked(isChecked());
    }
}
