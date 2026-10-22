package com.bytedance.feedbackerlib.matisse.internal.ui.adapter;

import android.database.Cursor;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class RecyclerViewCursorAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Cursor f4417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4418b;

    RecyclerViewCursorAdapter(Cursor r2) {
        setHasStableIds(true);
        f(r2);
    }

    private boolean d(Cursor r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.isClosed() == true) goto L6;
        return true;
    }

    protected abstract int c(int r1, Cursor r2);

    protected abstract void e(VH r1, Cursor r2);

    public void f(Cursor r2) {
        if (r2 != this.f4417a) goto L5;
        return;
    L5:
        if (r2 == null) goto L7;
        this.f4417a = r2;
        this.f4418b = r2.getColumnIndexOrThrow("_id");
        notifyDataSetChanged();
        return;
    L7:
        notifyItemRangeRemoved(0, getItemCount());
        this.f4417a = null;
        this.f4418b = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (d(this.f4417a) == true) goto L5;
        return 0;
    L5:
        return this.f4417a.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r3) {
        if (d(this.f4417a) == false) goto L11;
        if (this.f4417a.moveToPosition(r3) == false) goto L9;
        return this.f4417a.getLong(this.f4418b);
    L9:
        throw new IllegalStateException("Could not move cursor to position " + r3 + " when trying to get an item id");
    L11:
        throw new IllegalStateException("Cannot lookup item id when cursor is in invalid state.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r3) {
        if (this.f4417a.moveToPosition(r3) == false) goto L7;
        return c(r3, this.f4417a);
    L7:
        throw new IllegalStateException("Could not move cursor to position " + r3 + " when trying to get item view type.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH r2, int r3) {
        if (d(this.f4417a) == false) goto L11;
        if (this.f4417a.moveToPosition(r3) == false) goto L9;
        e(r2, this.f4417a);
        return;
    L9:
        throw new IllegalStateException("Could not move cursor to position " + r3 + " when trying to bind view holder");
    L11:
        throw new IllegalStateException("Cannot bind view holder when cursor is in invalid state.");
    }
}
