package com.android.setupwizardlib;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.setupwizardlib.template.RecyclerMixin;

/* JADX INFO: loaded from: classes.dex */
public class GlifPreferenceLayout extends GlifRecyclerLayout {
    public GlifPreferenceLayout(Context r1) {
        super(r1);
    }

    public GlifPreferenceLayout(Context r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    public GlifPreferenceLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public GlifPreferenceLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.android.setupwizardlib.GlifRecyclerLayout, com.android.setupwizardlib.GlifLayout, com.android.setupwizardlib.TemplateLayout
    protected ViewGroup findContainer(int r1) {
        if (r1 != 0) goto L5;
        r1 = R.id.suw_layout_content;
    L5:
        return super.findContainer(r1);
    }

    public RecyclerView onCreateRecyclerView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return this.mRecyclerMixin.getRecyclerView();
    }

    @Override // com.android.setupwizardlib.GlifRecyclerLayout, com.android.setupwizardlib.GlifLayout, com.android.setupwizardlib.TemplateLayout
    protected View onInflateTemplate(LayoutInflater r1, int r2) {
        if (r2 != 0) goto L5;
        r2 = R.layout.suw_glif_preference_template;
    L5:
        return super.onInflateTemplate(r1, r2);
    }

    @Override // com.android.setupwizardlib.GlifRecyclerLayout, com.android.setupwizardlib.TemplateLayout
    protected void onTemplateInflated() {
        this.mRecyclerMixin = new RecyclerMixin(this, (RecyclerView) LayoutInflater.from(getContext()).inflate(R.layout.suw_glif_preference_recycler_view, this, false));
    }
}
