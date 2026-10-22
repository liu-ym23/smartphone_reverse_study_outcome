package com.bytedanceos.common;

import android.graphics.Canvas;
import android.view.View;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class GroupCardItemDecoration extends RecyclerView.ItemDecoration {
    private final int cardItemViewId;
    private final CardPositionDecider.HeaderIdProvider headerIdProvider;

    public GroupCardItemDecoration(int cardItemViewId, CardPositionDecider.HeaderIdProvider provider) {
        this.cardItemViewId = cardItemViewId;
        this.headerIdProvider = provider;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.Adapter r5 = parent.getAdapter();
        if (r5 != null) goto L5;
        return;
    L5:
        int r6 = r5.getItemCount();
        int r7 = parent.getChildCount();
        int r0 = 0;
    L6:
        if (r0 >= r7) goto L14;
        View r1 = parent.getChildAt(r0);
        int r2 = parent.getChildAdapterPosition(r1);
        if (r2 == (-1)) goto L13;
        int r3 = CardPositionDecider.compute(r2, r6, this.headerIdProvider);
        View r4 = r1.findViewById(this.cardItemViewId);
        if ((r4 instanceof OCardListItem) == false) goto L13;
        ((OCardListItem) r4).setCardPosition(r3);
    L13:
        r0 = r0 + 1;
        goto L6
    }
}
