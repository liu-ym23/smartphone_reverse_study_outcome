package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.android.setupwizardlib.DividerItemDecoration;
import com.android.setupwizardlib.R;

/* JADX INFO: loaded from: classes.dex */
public class HeaderRecyclerView extends RecyclerView {
    private View header;
    private int headerRes;

    public static class HeaderAdapter<CVH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int HEADER_VIEW_TYPE = Integer.MAX_VALUE;
        private final RecyclerView.Adapter<CVH> adapter;
        private View header;
        private final RecyclerView.AdapterDataObserver observer;

        static /* synthetic */ View access$000(HeaderAdapter r0) {
            return r0.header;
        }

        public HeaderAdapter(RecyclerView.Adapter<CVH> r2) {
            RecyclerView.AdapterDataObserver r0 = new AnonymousClass1(this);
            this.observer = r0;
            this.adapter = r2;
            r2.registerAdapterDataObserver(r0);
            setHasStableIds(r2.hasStableIds());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            if (r3 != Integer.MAX_VALUE) goto L7;
            FrameLayout r1 = new FrameLayout(r2.getContext());
            r1.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            return new HeaderViewHolder(r1);
        L7:
            return this.adapter.onCreateViewHolder(r2, r3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            View r0 = this.header;
            if (r0 == null) goto L6;
            r4 = r4 - 1;
        L6:
            if ((r3 instanceof HeaderViewHolder) == false) goto L14;
            if (r0 == null) goto L13;
            if (r0.getParent() == null) goto L11;
            ((ViewGroup) this.header.getParent()).removeView(this.header);
        L11:
            ((FrameLayout) r3.itemView).addView(this.header);
            return;
        L13:
            throw new IllegalStateException("HeaderViewHolder cannot find mHeader");
        L14:
            this.adapter.onBindViewHolder(r3, r4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r2) {
            if (this.header == null) goto L5;
            r2 = r2 - 1;
        L5:
            if (r2 >= 0) goto L9;
            return Integer.MAX_VALUE;
        L9:
            return this.adapter.getItemViewType(r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int r0 = this.adapter.getItemCount();
            if (this.header != null) goto L5;
            return r0;
        L5:
            return r0 + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int r2) {
            if (this.header == null) goto L5;
            r2 = r2 - 1;
        L5:
            if (r2 >= 0) goto L9;
            return Long.MAX_VALUE;
        L9:
            return this.adapter.getItemId(r2);
        }

        public void setHeader(View r1) {
            this.header = r1;
        }

        public RecyclerView.Adapter<CVH> getWrappedAdapter() {
            return this.adapter;
        }
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder implements DividerItemDecoration.DividedViewHolder {
        @Override // com.android.setupwizardlib.DividerItemDecoration.DividedViewHolder
        public boolean isDividerAllowedAbove() {
            return false;
        }

        @Override // com.android.setupwizardlib.DividerItemDecoration.DividedViewHolder
        public boolean isDividerAllowedBelow() {
            return false;
        }

        HeaderViewHolder(View r1) {
            super(r1);
        }
    }

    public HeaderRecyclerView(Context r2) {
        super(r2);
        init(null, 0);
    }

    public HeaderRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r2, 0);
    }

    public HeaderRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r2, r3);
    }

    private void init(AttributeSet r4, int r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(r4, R.styleable.SuwHeaderRecyclerView, r5, 0);
        this.headerRes = r6.getResourceId(R.styleable.SuwHeaderRecyclerView_suwHeader, 0);
        r6.recycle();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r3) {
        super.onInitializeAccessibilityEvent(r3);
        if (this.header == null) goto L5;
        int r2 = 1;
    L6:
        r3.setItemCount(r3.getItemCount() - r2);
        r3.setFromIndex(Math.max(r3.getFromIndex() - r2, 0));
        r3.setToIndex(Math.max(r3.getToIndex() - r2, 0));
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public View getHeader() {
        return this.header;
    }

    public void setHeader(View r1) {
        this.header = r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager r3) {
        super.setLayoutManager(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.header == null) goto L7;
        return;
    L7:
        if (this.headerRes == 0) goto L12;
        this.header = LayoutInflater.from(getContext()).inflate(this.headerRes, this, false);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter r2) {
        if (this.header == null) goto L6;
        if (r2 == null) goto L6;
        HeaderAdapter r0 = new HeaderAdapter(r2);
        r0.setHeader(this.header);
        r2 = r0;
    L6:
        super.setAdapter(r2);
    }
}
