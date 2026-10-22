package com.android.setupwizardlib.template;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.setupwizardlib.DividerItemDecoration;
import com.android.setupwizardlib.R;
import com.android.setupwizardlib.TemplateLayout;
import com.android.setupwizardlib.items.ItemInflater;
import com.android.setupwizardlib.items.RecyclerItemAdapter;
import com.android.setupwizardlib.util.DrawableLayoutDirectionHelper;
import com.android.setupwizardlib.view.HeaderRecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerMixin implements Mixin {
    private Drawable defaultDivider;
    private Drawable divider;
    private DividerItemDecoration dividerDecoration;
    private int dividerInsetEnd;
    private int dividerInsetStart;
    private View header;
    private final RecyclerView recyclerView;
    private final TemplateLayout templateLayout;

    public RecyclerMixin(TemplateLayout r3, RecyclerView r4) {
        this.templateLayout = r3;
        this.dividerDecoration = new DividerItemDecoration(r3.getContext());
        this.recyclerView = r4;
        r4.setLayoutManager(new LinearLayoutManager(r3.getContext()));
        if ((r4 instanceof HeaderRecyclerView) == false) goto L5;
        this.header = ((HeaderRecyclerView) r4).getHeader();
    L5:
        r4.addItemDecoration(this.dividerDecoration);
    }

    public void parseAttributes(AttributeSet r4, int r5) {
        Context r0 = this.templateLayout.getContext();
        TypedArray r6 = r0.obtainStyledAttributes(r4, R.styleable.SuwRecyclerMixin, r5, 0);
        int r7 = r6.getResourceId(R.styleable.SuwRecyclerMixin_android_entries, 0);
        if (r7 == 0) goto L5;
        RecyclerItemAdapter r1 = new RecyclerItemAdapter(new ItemInflater(r0).inflate(r7));
        r1.setHasStableIds(r6.getBoolean(R.styleable.SuwRecyclerMixin_suwHasStableIds, false));
        setAdapter(r1);
    L5:
        int r8 = r6.getDimensionPixelSize(R.styleable.SuwRecyclerMixin_suwDividerInset, -1);
        if (r8 == (-1)) goto L8;
        setDividerInset(r8);
    L9:
        r6.recycle();
        return;
    L8:
        setDividerInsets(r6.getDimensionPixelSize(R.styleable.SuwRecyclerMixin_suwDividerInsetStart, 0), r6.getDimensionPixelSize(R.styleable.SuwRecyclerMixin_suwDividerInsetEnd, 0));
        goto L9
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public View getHeader() {
        return this.header;
    }

    public void onLayout() {
        if (this.divider != null) goto L6;
        updateDivider();
        return;
    }

    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter() {
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r1 = this.recyclerView.getAdapter();
        if ((r1 instanceof HeaderRecyclerView.HeaderAdapter) == true) goto L5;
        return r1;
    L5:
        return ((HeaderRecyclerView.HeaderAdapter) r1).getWrappedAdapter();
    }

    public void setAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r1) {
        this.recyclerView.setAdapter(r1);
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
        if (this.templateLayout.isLayoutDirectionResolved() == true) goto L5;
        return;
    L5:
        if (this.defaultDivider != null) goto L7;
        this.defaultDivider = this.dividerDecoration.getDivider();
    L7:
        InsetDrawable r0 = DrawableLayoutDirectionHelper.createRelativeInsetDrawable(this.defaultDivider, this.dividerInsetStart, 0, this.dividerInsetEnd, 0, this.templateLayout);
        this.divider = r0;
        this.dividerDecoration.setDivider(r0);
    }

    public Drawable getDivider() {
        return this.divider;
    }

    public void setDividerItemDecoration(DividerItemDecoration r3) {
        this.recyclerView.removeItemDecoration(this.dividerDecoration);
        this.dividerDecoration = r3;
        this.recyclerView.addItemDecoration(r3);
        updateDivider();
    }
}
