package com.android.setupwizardlib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.android.setupwizardlib.template.ListMixin;
import com.android.setupwizardlib.template.ListViewScrollHandlingDelegate;
import com.android.setupwizardlib.template.RequireScrollMixin;

/* JADX INFO: loaded from: classes.dex */
public class SetupWizardListLayout extends SetupWizardLayout {
    private ListMixin listMixin;

    public SetupWizardListLayout(Context r2) {
        this(r2, 0, 0);
    }

    public SetupWizardListLayout(Context r2, int r3) {
        this(r2, r3, 0);
    }

    public SetupWizardListLayout(Context r1, int r2, int r3) {
        super(r1, r2, r3);
        init(null, 0);
    }

    public SetupWizardListLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r2, 0);
    }

    public SetupWizardListLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r2, r3);
    }

    private void init(AttributeSet r2, int r3) {
        ListMixin r0 = new ListMixin(this, r2, r3);
        this.listMixin = r0;
        registerMixin(ListMixin.class, r0);
        RequireScrollMixin r4 = (RequireScrollMixin) getMixin(RequireScrollMixin.class);
        r4.setScrollHandlingDelegate(new ListViewScrollHandlingDelegate(r4, getListView()));
    }

    @Override // com.android.setupwizardlib.SetupWizardLayout, com.android.setupwizardlib.TemplateLayout
    protected View onInflateTemplate(LayoutInflater r1, int r2) {
        if (r2 != 0) goto L5;
        r2 = R.layout.suw_list_template;
    L5:
        return super.onInflateTemplate(r1, r2);
    }

    @Override // com.android.setupwizardlib.SetupWizardLayout, com.android.setupwizardlib.TemplateLayout
    protected ViewGroup findContainer(int r1) {
        if (r1 != 0) goto L5;
        r1 = android.R.id.list;
    L5:
        return super.findContainer(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        this.listMixin.onLayout();
    }

    public ListView getListView() {
        return this.listMixin.getListView();
    }

    public void setAdapter(ListAdapter r1) {
        this.listMixin.setAdapter(r1);
    }

    public ListAdapter getAdapter() {
        return this.listMixin.getAdapter();
    }

    @Deprecated
    public void setDividerInset(int r1) {
        this.listMixin.setDividerInset(r1);
    }

    public void setDividerInsets(int r1, int r2) {
        this.listMixin.setDividerInsets(r1, r2);
    }

    @Deprecated
    public int getDividerInset() {
        return this.listMixin.getDividerInset();
    }

    public int getDividerInsetStart() {
        return this.listMixin.getDividerInsetStart();
    }

    public int getDividerInsetEnd() {
        return this.listMixin.getDividerInsetEnd();
    }

    public Drawable getDivider() {
        return this.listMixin.getDivider();
    }
}
