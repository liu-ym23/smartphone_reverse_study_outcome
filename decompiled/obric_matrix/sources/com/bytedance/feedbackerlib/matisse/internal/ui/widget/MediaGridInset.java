package com.bytedance.feedbackerlib.matisse.internal.ui.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class MediaGridInset extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4444c;

    public MediaGridInset(int r1, int r2, boolean r3) {
        this.f4442a = r1;
        this.f4443b = r2;
        this.f4444c = r3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        int r6 = r4.getChildAdapterPosition(r3);
        int r7 = this.f4442a;
        int r8 = r6 % r7;
        boolean r0 = this.f4444c;
        int r1 = this.f4443b;
        if (r0 == false) goto L8;
        r2.left = r1 - ((r8 * r1) / r7);
        r2.right = ((r8 + 1) * r1) / r7;
        if (r6 >= r7) goto L7;
        r2.top = r1;
    L7:
        r2.bottom = r1;
        return;
    L8:
        r2.left = (r8 * r1) / r7;
        r2.right = r1 - (((r8 + 1) * r1) / r7);
        if (r6 < r7) goto L13;
        r2.top = r1;
        return;
    }
}
