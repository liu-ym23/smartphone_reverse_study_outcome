package com.android.setupwizardlib.items;

import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerItemAdapter extends RecyclerView.Adapter<ItemViewHolder> implements ItemHierarchy.Observer {
    private static final String TAG = "RecyclerItemAdapter";
    public static final String TAG_NO_BACKGROUND = "noBackground";
    private final ItemHierarchy itemHierarchy;
    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        void onItemSelected(IItem r1);
    }

    static class PatchedLayerDrawable extends LayerDrawable {
        PatchedLayerDrawable(Drawable[] r1) {
            super(r1);
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public boolean getPadding(Rect r1) {
            if (super.getPadding(r1) == true) goto L5;
        L13:
            return false;
        L5:
            if (r1.left == 0) goto L7;
        L12:
            return true;
        L7:
            if (r1.top != 0) goto L12;
            if (r1.right != 0) goto L12;
            if (r1.bottom == 0) goto L13;
            goto L12
        }
    }

    static /* synthetic */ OnItemSelectedListener access$000(RecyclerItemAdapter r0) {
        return r0.listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((ItemViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public RecyclerItemAdapter(ItemHierarchy r1) {
        this.itemHierarchy = r1;
        r1.registerObserver(this);
    }

    public IItem getItem(int r1) {
        return this.itemHierarchy.getItemAt(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r3) {
        IItem r2 = getItem(r3);
        if ((r2 instanceof AbstractItem) == false) goto L8;
        int r4 = ((AbstractItem) r2).getId();
        if (r4 > 0) goto L7;
        return -1;
    L7:
        return r4;
    L8:
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemHierarchy.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ItemViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        View r8 = LayoutInflater.from(r6.getContext()).inflate(r7, r6, false);
        final ItemViewHolder r0 = new ItemViewHolder(r8);
        if (TAG_NO_BACKGROUND.equals(r8.getTag()) == true) goto L16;
        TypedArray r9 = r6.getContext().obtainStyledAttributes(R.styleable.SuwRecyclerItemAdapter);
        Drawable r2 = r9.getDrawable(R.styleable.SuwRecyclerItemAdapter_android_selectableItemBackground);
        if (r2 != null) goto L7;
        r2 = r9.getDrawable(R.styleable.SuwRecyclerItemAdapter_selectableItemBackground);
    L7:
        Drawable r3 = r8.getBackground();
        if (r3 != null) goto L10;
        r3 = r9.getDrawable(R.styleable.SuwRecyclerItemAdapter_android_colorBackground);
    L10:
        if (r2 == null) goto L14;
        if (r3 == null) goto L14;
        r8.setBackgroundDrawable(new PatchedLayerDrawable(new Drawable[]{r3, r2}));
    L15:
        r9.recycle();
    L14:
        Log.e(TAG, "Cannot resolve required attributes. selectableItemBackground=" + r2 + " background=" + r3);
    L16:
        r8.setOnClickListener(new AnonymousClass1(this, r0));
        return r0;
    }

    public void onBindViewHolder(ItemViewHolder r1, int r2) {
        IItem r0 = getItem(r2);
        r1.setEnabled(r0.isEnabled());
        r1.setItem(r0);
        r0.onBindView(r1.itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        return getItem(r1).getLayoutResource();
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onChanged(ItemHierarchy r1) {
        notifyDataSetChanged();
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeChanged(ItemHierarchy r1, int r2, int r3) {
        notifyItemRangeChanged(r2, r3);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeInserted(ItemHierarchy r1, int r2, int r3) {
        notifyItemRangeInserted(r2, r3);
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeMoved(ItemHierarchy r1, int r2, int r3, int r4) {
        if (r4 != 1) goto L5;
        notifyItemMoved(r2, r3);
        return;
    L5:
        Log.i(TAG, "onItemRangeMoved with more than one item");
        notifyDataSetChanged();
    }

    @Override // com.android.setupwizardlib.items.ItemHierarchy.Observer
    public void onItemRangeRemoved(ItemHierarchy r1, int r2, int r3) {
        notifyItemRangeRemoved(r2, r3);
    }

    public ItemHierarchy findItemById(int r1) {
        return this.itemHierarchy.findItemById(r1);
    }

    public ItemHierarchy getRootItemHierarchy() {
        return this.itemHierarchy;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener r1) {
        this.listener = r1;
    }
}
