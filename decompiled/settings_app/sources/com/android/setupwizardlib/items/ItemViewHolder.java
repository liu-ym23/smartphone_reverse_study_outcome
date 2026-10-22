package com.android.setupwizardlib.items;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.setupwizardlib.DividerItemDecoration;

/* JADX INFO: loaded from: classes.dex */
class ItemViewHolder extends RecyclerView.ViewHolder implements DividerItemDecoration.DividedViewHolder {
    private boolean isEnabled;
    private IItem item;

    ItemViewHolder(View r1) {
        super(r1);
    }

    @Override // com.android.setupwizardlib.DividerItemDecoration.DividedViewHolder
    public boolean isDividerAllowedAbove() {
        return this.isEnabled;
    }

    @Override // com.android.setupwizardlib.DividerItemDecoration.DividedViewHolder
    public boolean isDividerAllowedBelow() {
        return this.isEnabled;
    }

    public void setEnabled(boolean r2) {
        this.isEnabled = r2;
        this.itemView.setClickable(r2);
        this.itemView.setEnabled(r2);
        this.itemView.setFocusable(r2);
    }

    public void setItem(IItem r1) {
        this.item = r1;
    }

    public IItem getItem() {
        return this.item;
    }
}
