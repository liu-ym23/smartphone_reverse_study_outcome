package com.android.setupwizardlib.template;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.android.setupwizardlib.R;
import com.android.setupwizardlib.TemplateLayout;
import com.android.setupwizardlib.items.ItemAdapter;
import com.android.setupwizardlib.items.ItemGroup;
import com.android.setupwizardlib.items.ItemInflater;
import com.android.setupwizardlib.util.DrawableLayoutDirectionHelper;

/* JADX INFO: loaded from: classes.dex */
public class ListMixin implements Mixin {
    private Drawable defaultDivider;
    private Drawable divider;
    private int dividerInsetEnd;
    private int dividerInsetStart;
    private ListView listView;
    private final TemplateLayout templateLayout;

    public ListMixin(TemplateLayout r3, AttributeSet r4, int r5) {
        this.templateLayout = r3;
        Context r6 = r3.getContext();
        TypedArray r7 = r6.obtainStyledAttributes(r4, R.styleable.SuwListMixin, r5, 0);
        int r8 = r7.getResourceId(R.styleable.SuwListMixin_android_entries, 0);
        if (r8 == 0) goto L5;
        setAdapter(new ItemAdapter((ItemGroup) new ItemInflater(r6).inflate(r8)));
    L5:
        int r9 = r7.getDimensionPixelSize(R.styleable.SuwListMixin_suwDividerInset, -1);
        if (r9 == (-1)) goto L8;
        setDividerInset(r9);
    L9:
        r7.recycle();
        return;
    L8:
        setDividerInsets(r7.getDimensionPixelSize(R.styleable.SuwListMixin_suwDividerInsetStart, 0), r7.getDimensionPixelSize(R.styleable.SuwListMixin_suwDividerInsetEnd, 0));
        goto L9
    }

    public ListView getListView() {
        return getListViewInternal();
    }

    private ListView getListViewInternal() {
        if (this.listView != null) goto L8;
        View r0 = this.templateLayout.findManagedViewById(android.R.id.list);
        if ((r0 instanceof ListView) == false) goto L8;
        this.listView = (ListView) r0;
    L8:
        return this.listView;
    }

    public void onLayout() {
        if (this.divider != null) goto L6;
        updateDivider();
        return;
    }

    public ListAdapter getAdapter() {
        ListView r1 = getListViewInternal();
        if (r1 == null) goto L8;
        ListAdapter r2 = r1.getAdapter();
        if ((r2 instanceof HeaderViewListAdapter) == true) goto L7;
        return r2;
    L7:
        return ((HeaderViewListAdapter) r2).getWrappedAdapter();
    L8:
        return null;
    }

    public void setAdapter(ListAdapter r1) {
        ListView r0 = getListViewInternal();
        if (r0 == null) goto L6;
        r0.setAdapter(r1);
        return;
    }

    @Deprecated
    public void setDividerInset(int r2) {
        setDividerInsets(r2, 0);
    }

    public void setDividerInsets(int r1, int r2) {
        this.dividerInsetStart = r1;
        this.dividerInsetEnd = r2;
        updateDivider();
    }

    @Deprecated
    public int getDividerInset() {
        return getDividerInsetStart();
    }

    public int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    private void updateDivider() {
        ListView r0 = getListViewInternal();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.templateLayout.isLayoutDirectionResolved() == true) goto L8;
        return;
    L8:
        if (this.defaultDivider != null) goto L10;
        this.defaultDivider = r0.getDivider();
    L10:
        InsetDrawable r1 = DrawableLayoutDirectionHelper.createRelativeInsetDrawable(this.defaultDivider, this.dividerInsetStart, 0, this.dividerInsetEnd, 0, this.templateLayout);
        this.divider = r1;
        r0.setDivider(r1);
    }

    public Drawable getDivider() {
        return this.divider;
    }
}
