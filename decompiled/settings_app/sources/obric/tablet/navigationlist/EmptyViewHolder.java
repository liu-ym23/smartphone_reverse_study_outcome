package obric.tablet.navigationlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes5.dex */
public class EmptyViewHolder extends ViewHolder {
    private int mBgResId;
    private int mHeight;
    private int mId;

    @Override // obric.tablet.navigationlist.ViewHolder
    public int getType() {
        return 3;
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public void onItemClicked(View r1) {
    }

    public EmptyViewHolder() {
        this.mId = -1;
    }

    public EmptyViewHolder(int r1, int r2) {
        this.mId = r1;
        this.mHeight = r2;
    }

    public void setBgResId(int r1) {
        this.mBgResId = r1;
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public void bindView(int r3, View r4) {
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, this.mHeight));
        int r2 = this.mBgResId;
        if (r2 <= 0) goto L5;
        r4.setBackgroundResource(r2);
        return;
    L5:
        r4.setBackground(null);
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public View createView(LayoutInflater r1, ViewGroup r2) {
        return new View(r1.getContext());
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public int getId() {
        return this.mId;
    }
}
