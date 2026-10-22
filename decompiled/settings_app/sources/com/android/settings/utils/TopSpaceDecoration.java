package com.android.settings.utils;

import android.graphics.Rect;
import android.view.View;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UIUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/settings/utils/TopSpaceDecoration;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ItemDecoration;", "verticalSpaceHeight", "", "(I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TopSpaceDecoration extends RecyclerView.ItemDecoration {
    private final int verticalSpaceHeight;

    public TopSpaceDecoration(int r1) {
        this.verticalSpaceHeight = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (r4.getChildAdapterPosition(r3) != 0) goto L5;
        r2.top = this.verticalSpaceHeight;
        return;
    L5:
        r2.top = 0;
    }
}
