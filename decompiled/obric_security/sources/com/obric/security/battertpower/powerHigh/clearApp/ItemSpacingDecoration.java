package com.obric.security.battertpower.powerHigh.clearApp;

import android.graphics.Rect;
import android.view.View;
import com.obric.oui.orecyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class ItemSpacingDecoration extends RecyclerView.ItemDecoration {
    private final int spacing;

    public ItemSpacingDecoration(int spacingDp, RecyclerView recyclerView) {
        this.spacing = (int) (spacingDp * recyclerView.getContext().getResources().getDisplayMetrics().density);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = this.spacing;
        if (parent.getChildAdapterPosition(view) != 0) goto L6;
        outRect.top = 0;
        return;
    }
}
