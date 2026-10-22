package com.android.setupwizardlib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.setupwizardlib.template.RecyclerMixin;
import com.android.setupwizardlib.template.RecyclerViewScrollHandlingDelegate;
import com.android.setupwizardlib.template.RequireScrollMixin;

/* JADX INFO: loaded from: classes.dex */
public class GlifRecyclerLayout extends GlifLayout {
    protected RecyclerMixin mRecyclerMixin;

    public GlifRecyclerLayout(Context r2) {
        this(r2, 0, 0);
    }

    public GlifRecyclerLayout(Context r2, int r3) {
        this(r2, r3, 0);
    }

    public GlifRecyclerLayout(Context r1, int r2, int r3) {
        super(r1, r2, r3);
        init(null, 0);
    }

    public GlifRecyclerLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r2, 0);
    }

    public GlifRecyclerLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r2, r3);
    }

    private void init(AttributeSet r2, int r3) {
        this.mRecyclerMixin.parseAttributes(r2, r3);
        registerMixin(RecyclerMixin.class, this.mRecyclerMixin);
        RequireScrollMixin r4 = (RequireScrollMixin) getMixin(RequireScrollMixin.class);
        r4.setScrollHandlingDelegate(new RecyclerViewScrollHandlingDelegate(r4, getRecyclerView()));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        this.mRecyclerMixin.onLayout();
    }

    @Override // com.android.setupwizardlib.GlifLayout, com.android.setupwizardlib.TemplateLayout
    protected View onInflateTemplate(LayoutInflater r1, int r2) {
        if (r2 != 0) goto L5;
        r2 = R.layout.suw_glif_recycler_template;
    L5:
        return super.onInflateTemplate(r1, r2);
    }

    @Override // com.android.setupwizardlib.TemplateLayout
    protected void onTemplateInflated() {
        View r0 = findViewById(R.id.suw_recycler_view);
        if ((r0 instanceof RecyclerView) == false) goto L7;
        this.mRecyclerMixin = new RecyclerMixin(this, (RecyclerView) r0);
        return;
    L7:
        throw new IllegalStateException("GlifRecyclerLayout should use a template with recycler view");
    }

    @Override // com.android.setupwizardlib.GlifLayout, com.android.setupwizardlib.TemplateLayout
    protected ViewGroup findContainer(int r1) {
        if (r1 != 0) goto L5;
        r1 = R.id.suw_recycler_view;
    L5:
        return super.findContainer(r1);
    }

    @Override // com.android.setupwizardlib.TemplateLayout
    public <T extends View> T findManagedViewById(int r2) {
        View r0 = this.mRecyclerMixin.getHeader();
        if (r0 == null) goto L8;
        T r1 = (T) r0.findViewById(r2);
        if (r1 == null) goto L8;
        return r1;
    L8:
        return (T) super.findViewById(r2);
    }

    public void setDividerItemDecoration(DividerItemDecoration r1) {
        this.mRecyclerMixin.setDividerItemDecoration(r1);
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerMixin.getRecyclerView();
    }

    public void setAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r1) {
        this.mRecyclerMixin.setAdapter(r1);
    }

    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter() {
        return this.mRecyclerMixin.getAdapter();
    }

    @Deprecated
    public void setDividerInset(int r1) {
        this.mRecyclerMixin.setDividerInset(r1);
    }

    public void setDividerInsets(int r1, int r2) {
        this.mRecyclerMixin.setDividerInsets(r1, r2);
    }

    @Deprecated
    public int getDividerInset() {
        return this.mRecyclerMixin.getDividerInset();
    }

    public int getDividerInsetStart() {
        return this.mRecyclerMixin.getDividerInsetStart();
    }

    public int getDividerInsetEnd() {
        return this.mRecyclerMixin.getDividerInsetEnd();
    }

    public Drawable getDivider() {
        return this.mRecyclerMixin.getDivider();
    }
}
