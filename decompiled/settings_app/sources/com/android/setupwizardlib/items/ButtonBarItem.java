package com.android.setupwizardlib.items;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.android.setupwizardlib.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarItem extends AbstractItem implements ItemInflater.ItemParent {
    private final ArrayList<ButtonItem> buttons;
    private boolean visible;

    @Override // com.android.setupwizardlib.items.IItem
    public boolean isEnabled() {
        return false;
    }

    public ButtonBarItem() {
        this.buttons = new ArrayList();
        this.visible = true;
    }

    public ButtonBarItem(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.buttons = new ArrayList();
        this.visible = true;
    }

    @Override // com.android.setupwizardlib.items.AbstractItem, com.android.setupwizardlib.items.ItemHierarchy
    public int getCount() {
        return isVisible() ? 1 : 0;
    }

    @Override // com.android.setupwizardlib.items.IItem
    public int getLayoutResource() {
        return R.layout.suw_items_button_bar;
    }

    public void setVisible(boolean r1) {
        this.visible = r1;
    }

    public boolean isVisible() {
        return this.visible;
    }

    @Override // com.android.setupwizardlib.items.AbstractItemHierarchy
    public int getViewId() {
        return getId();
    }

    @Override // com.android.setupwizardlib.items.IItem
    public void onBindView(View r4) {
        LinearLayout r0 = (LinearLayout) r4;
        r0.removeAllViews();
        Iterator<ButtonItem> r1 = this.buttons.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addView(r1.next().createButton(r0));
        goto L4
    L6:
        r4.setId(getViewId());
    }

    @Override // com.android.setupwizardlib.items.ItemInflater.ItemParent
    public void addChild(ItemHierarchy r2) {
        if ((r2 instanceof ButtonItem) == false) goto L7;
        this.buttons.add((ButtonItem) r2);
        return;
    L7:
        throw new UnsupportedOperationException("Cannot add non-button item to Button Bar");
    }

    @Override // com.android.setupwizardlib.items.AbstractItem, com.android.setupwizardlib.items.ItemHierarchy
    public ItemHierarchy findItemById(int r2) {
        if (getId() != r2) goto L5;
        return this;
    L5:
        Iterator<ButtonItem> r1 = this.buttons.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        ItemHierarchy r0 = r1.next().findItemById(r2);
        if (r0 == null) goto L7;
        return r0;
    L11:
        return null;
    }
}
