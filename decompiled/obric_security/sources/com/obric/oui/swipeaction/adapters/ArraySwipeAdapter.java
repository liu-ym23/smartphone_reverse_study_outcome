package com.obric.oui.swipeaction.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.implments.SwipeItemMangerImpl;
import com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface;
import com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface;
import com.obric.oui.swipeaction.util.Attributes;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ArraySwipeAdapter<T> extends ArrayAdapter implements SwipeItemMangerInterface, SwipeAdapterInterface {
    private SwipeItemMangerImpl mItemManger;

    public ArraySwipeAdapter(Context r1, int r2) {
        super(r1, r2);
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    public ArraySwipeAdapter(Context r1, int r2, int r3) {
        super(r1, r2, r3);
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    public ArraySwipeAdapter(Context r1, int r2, T[] r3) {
        super(r1, r2, r3);
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    public ArraySwipeAdapter(Context r1, int r2, int r3, T[] r4) {
        super(r1, r2, r3, r4);
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    public ArraySwipeAdapter(Context r1, int r2, List<T> r3) {
        super(r1, r2, r3);
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    public ArraySwipeAdapter(Context r1, int r2, int r3, List<T> r4) {
        super(r1, r2, r3, r4);
        this.mItemManger = new SwipeItemMangerImpl(this);
    }

    @Override // com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface
    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int r1, View r2, ViewGroup r3) {
        View r4 = super.getView(r1, r2, r3);
        this.mItemManger.bind(r4, r1);
        return r4;
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
