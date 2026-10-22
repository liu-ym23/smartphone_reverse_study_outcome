package com.obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class PopupMenuLongPressedListItem extends RelativeLayout {
    private ImageView mIcon;
    private MenuItemImpl mItemData;
    private TextView mTitleText;

    public PopupMenuLongPressedListItem(Context r3) {
        super(r3);
        init(r3, null, 0);
    }

    public PopupMenuLongPressedListItem(Context r2, AttributeSet r3) {
        super(r2, r3);
        init(r2, r3, 0);
    }

    public PopupMenuLongPressedListItem(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1, null, 0);
    }

    private void init(Context r1, AttributeSet r2, int r3) {
        LayoutInflater.from(r1).inflate(R.layout.o_popup_menu_long_pressed_list_item, this, true);
        this.mIcon = (ImageView) findViewById(R.id.menu_icon);
        this.mTitleText = (TextView) findViewById(R.id.menu_title);
    }

    public void initialize(MenuItemImpl r2, int r3) {
        this.mItemData = r2;
        this.mTitleText.setText(r2.getTitle());
        this.mIcon.setImageDrawable(r2.getIcon());
        if (r2.isVisible() == false) goto L5;
        int r4 = 0;
    L6:
        setVisibility(r4);
        setEnabled(r2.isEnabled());
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }
}
