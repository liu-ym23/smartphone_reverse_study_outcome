package com.android.settings.stickylistheaders;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExpandableStickyListHeadersListView extends StickyListHeadersListView {
    public static final int ANIMATION_COLLAPSE = 1;
    public static final int ANIMATION_EXPAND = 0;
    IAnimationExecutor mDefaultAnimExecutor;
    ExpandableStickyListHeadersAdapter mExpandableStickyListHeadersAdapter;

    public interface IAnimationExecutor {
        void executeAnim(View r1, int r2);
    }

    @Override // com.android.settings.stickylistheaders.StickyListHeadersListView
    public /* bridge */ /* synthetic */ StickyListHeadersAdapter getAdapter() {
        return getAdapter();
    }

    public ExpandableStickyListHeadersListView(Context r1) {
        super(r1);
        this.mDefaultAnimExecutor = new AnonymousClass1(this);
    }

    public ExpandableStickyListHeadersListView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mDefaultAnimExecutor = new AnonymousClass1(this);
    }

    public ExpandableStickyListHeadersListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mDefaultAnimExecutor = new AnonymousClass1(this);
    }

    @Override // com.android.settings.stickylistheaders.StickyListHeadersListView
    public ExpandableStickyListHeadersAdapter getAdapter() {
        return this.mExpandableStickyListHeadersAdapter;
    }

    @Override // com.android.settings.stickylistheaders.StickyListHeadersListView
    public void setAdapter(StickyListHeadersAdapter r2) {
        ExpandableStickyListHeadersAdapter r0 = new ExpandableStickyListHeadersAdapter(r2);
        this.mExpandableStickyListHeadersAdapter = r0;
        super.setAdapter(r0);
    }

    public View findViewByItemId(long r1) {
        return this.mExpandableStickyListHeadersAdapter.findViewByItemId(r1);
    }

    public long findItemIdByView(View r1) {
        return this.mExpandableStickyListHeadersAdapter.findItemIdByView(r1);
    }

    public void expand(long r2) {
        if (this.mExpandableStickyListHeadersAdapter.isHeaderCollapsed(r2) == true) goto L5;
        return;
    L5:
        this.mExpandableStickyListHeadersAdapter.expand(r2);
        List<View> r3 = this.mExpandableStickyListHeadersAdapter.getItemViewsByHeaderId(r2);
        if (r3 != null) goto L8;
        return;
    L8:
        Iterator<View> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        animateView(r4.next(), 0);
        goto L10
    }

    public void collapse(long r2) {
        if (this.mExpandableStickyListHeadersAdapter.isHeaderCollapsed(r2) == false) goto L5;
        return;
    L5:
        this.mExpandableStickyListHeadersAdapter.collapse(r2);
        List<View> r3 = this.mExpandableStickyListHeadersAdapter.getItemViewsByHeaderId(r2);
        if (r3 != null) goto L8;
        return;
    L8:
        Iterator<View> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        animateView(r4.next(), 1);
        goto L10
    }

    public boolean isHeaderCollapsed(long r1) {
        return this.mExpandableStickyListHeadersAdapter.isHeaderCollapsed(r1);
    }

    public void setAnimExecutor(IAnimationExecutor r1) {
        this.mDefaultAnimExecutor = r1;
    }

    private void animateView(View r2, int r3) {
        if (r3 != 0) goto L7;
        if (r2.getVisibility() != 0) goto L7;
        return;
    L7:
        if (1 == r3) goto L9;
    L11:
        IAnimationExecutor r1 = this.mDefaultAnimExecutor;
        if (r1 == null) goto L15;
        r1.executeAnim(r2, r3);
        return;
    L15:
        return;
    L9:
        if (r2.getVisibility() == 0) goto L11;
    }
}
