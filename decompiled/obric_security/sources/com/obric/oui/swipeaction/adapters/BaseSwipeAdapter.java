package com.obric.oui.swipeaction.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.implments.SwipeItemMangerImpl;
import com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface;
import com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface;
import com.obric.oui.swipeaction.util.Attributes;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseSwipeAdapter extends BaseAdapter implements SwipeItemMangerInterface, SwipeAdapterInterface {
    protected SwipeItemMangerImpl mItemManger;

    public abstract void fillValues(int r1, View r2);

    public abstract View generateView(int r1, ViewGroup r2);

    @Override // com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface
    public abstract int getSwipeLayoutResourceId(int r1);

    public BaseSwipeAdapter() {
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface
    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final View getView(int r1, View r2, ViewGroup r3) {
        if (r2 != null) goto L4;
        r2 = generateView(r1, r3);
    L4:
        this.mItemManger.bind(r2, r1);
        fillValues(r1, r2);
        return r2;
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void openItem(int r1) {
        this.mItemManger.openItem(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void closeItem(int r1) {
        this.mItemManger.closeItem(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void closeAllExcept(OSwipeLayout r1) {
        this.mItemManger.closeAllExcept(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void closeAllItems() {
        this.mItemManger.closeAllItems();
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public List<Integer> getOpenItems() {
        return this.mItemManger.getOpenItems();
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public List<OSwipeLayout> getOpenLayouts() {
        return this.mItemManger.getOpenLayouts();
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void removeShownLayouts(OSwipeLayout r1) {
        this.mItemManger.removeShownLayouts(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public boolean isOpen(int r1) {
        return this.mItemManger.isOpen(r1);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public Attributes.Mode getMode() {
        return this.mItemManger.getMode();
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface
    public void setMode(Attributes.Mode r1) {
        this.mItemManger.setMode(r1);
    }
}
