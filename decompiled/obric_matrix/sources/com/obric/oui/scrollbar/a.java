package com.obric.oui.scrollbar;

import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11343a = null;

    static {
        f11343a = new a();
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0, RecyclerView r1, float r2, String r3) {
        r0.c(r1, r2, r3);
    }

    public static final /* synthetic */ void b(a r0, RecyclerView r1, float r2, int r3) {
        r0.d(r1, r2, r3);
    }

    private final void c(RecyclerView r10, float r11, String r12) {
        RecyclerView.LayoutManager r9 = r10.getLayoutManager();
        if ((r9 instanceof LinearLayoutManager) == true) goto L5;
        r9 = null;
    L5:
        LinearLayoutManager r13 = (LinearLayoutManager) r9;
        if (r13 == null) goto L22;
        int r0 = r13.findFirstVisibleItemPosition();
        int r14 = r13.findLastVisibleItemPosition();
        boolean r2 = true;
        int r1 = (r14 - r0) + 1;
        RecyclerView.Adapter r3 = r10.getAdapter();
        if (r3 == null) goto L10;
        int r4 = r3.getItemCount();
    L12:
        if (r1 <= 0) goto L15;
        if (r4 <= 0) goto L15;
        float r7 = r4 / r1;
    L17:
        if (r7 >= r11) goto L20;
        r2 = false;
    L20:
        r10.setVerticalScrollBarEnabled(r2);
        Log.d("RecyclerViewScrollBarHelper", "updateScrollBarVisibilityByItemCount, scene: " + r12 + ", isVerticalScrollBarEnabled: " + r10.isVerticalScrollBarEnabled() + ", estimatedScreens: " + r7 + ", totalItemCount: " + r4 + ", visibleItemCount: " + r1 + ", firstVisibleItemPosition: " + r0 + ", lastVisibleItemPosition: " + r14);
        return;
    L15:
        Log.e("RecyclerViewScrollBarHelper", "updateScrollBarVisibilityByItemCount, error! totalItemCount: " + r4 + ", visibleItemCount: " + r1);
        r7 = 0.0f;
        goto L17
    L10:
        r4 = 0;
        goto L12
    }

    private final void d(RecyclerView r3, float r4, int r5) {
        int r2 = r3.computeVerticalScrollExtent();
        if (r2 <= 0) goto L6;
        if (r5 <= 0) goto L6;
        float r0 = r5 / r2;
    L8:
        if (r0 < r4) goto L10;
        boolean r6 = true;
    L12:
        if (r3.isVerticalScrollBarEnabled() == r6) goto L14;
        r3.setVerticalScrollBarEnabled(r6);
    L14:
        Log.d("RecyclerViewScrollBarHelper", "updateScrollBarWithStableHeight, isVerticalScrollBarEnabled: " + r3.isVerticalScrollBarEnabled() + ", contentScreens: " + r0 + ", contentHeight: " + r5 + ", visibleHeight: " + r2);
        return;
    L10:
        r6 = false;
    L6:
        r0 = 0.0f;
        goto L8
    }
}
