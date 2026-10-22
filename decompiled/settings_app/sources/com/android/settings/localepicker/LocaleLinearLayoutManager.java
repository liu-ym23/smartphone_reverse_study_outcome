package com.android.settings.localepicker;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class LocaleLinearLayoutManager extends LinearLayoutManager {
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat mActionMoveBottom;
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat mActionMoveDown;
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat mActionMoveTop;
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat mActionMoveUp;
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat mActionRemove;
    private final LocaleDragAndDropAdapter mAdapter;
    private final Context mContext;

    public LocaleLinearLayoutManager(Context r3, LocaleDragAndDropAdapter r4) {
        super(r3);
        this.mContext = r3;
        this.mAdapter = r4;
        this.mActionMoveUp = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.action_drag_move_up, r3.getString(R.string.action_drag_label_move_up));
        this.mActionMoveDown = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.action_drag_move_down, r3.getString(R.string.action_drag_label_move_down));
        this.mActionMoveTop = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.action_drag_move_top, r3.getString(R.string.action_drag_label_move_top));
        this.mActionMoveBottom = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.action_drag_move_bottom, r3.getString(R.string.action_drag_label_move_bottom));
        this.mActionRemove = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(R.id.action_drag_remove, r3.getString(R.string.action_drag_label_remove));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler r4, RecyclerView.State r5, View r6, AccessibilityNodeInfoCompat r7) {
        super.onInitializeAccessibilityNodeInfoForItem(r4, r5, r6, r7);
        int r8 = getItemCount();
        int r9 = getPosition(r6);
        int r1 = r9 + 1;
        r7.setContentDescription(r1 + ", " + ((LocaleDragCell) r6).getCheckbox().getContentDescription());
        if (this.mAdapter.isRemoveMode() == false) goto L5;
        return;
    L5:
        if (r9 <= 0) goto L7;
        r7.addAction(this.mActionMoveUp);
        r7.addAction(this.mActionMoveTop);
    L7:
        if (r1 >= r8) goto L10;
        r7.addAction(this.mActionMoveDown);
        r7.addAction(this.mActionMoveBottom);
    L10:
        if (r8 <= 1) goto L13;
        r7.addAction(this.mActionRemove);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean performAccessibilityActionForItem(RecyclerView.Recycler r5, RecyclerView.State r6, View r7, int r8, Bundle r9) {
        int r0 = getItemCount();
        int r1 = getPosition(r7);
        boolean r2 = true;
        switch(r8) {
            case 2131427484: goto L15;
            case 2131427485: goto L12;
            case 2131427486: goto L10;
            case 2131427487: goto L8;
            case 2131427488: goto L6;
            default: goto L5;
        };
    L6:
        if (r0 <= 1) goto L18;
        this.mAdapter.removeItem(r1);
    L19:
        if (r2 == false) goto L21;
        this.mAdapter.doTheUpdate();
    L21:
        return r2;
    L18:
        r2 = false;
        goto L19
    L8:
        if (r1 <= 0) goto L18;
        this.mAdapter.onItemMove(r1, r1 - 1);
        goto L19
    L10:
        if (r1 == 0) goto L18;
        this.mAdapter.onItemMove(r1, 0);
        goto L19
    L12:
        int r10 = r1 + 1;
        if (r10 >= r0) goto L18;
        this.mAdapter.onItemMove(r1, r10);
        goto L19
    L15:
        int r3 = r0 - 1;
        if (r1 == r3) goto L18;
        this.mAdapter.onItemMove(r1, r3);
        goto L19
    L5:
        return super.performAccessibilityActionForItem(r5, r6, r7, r8, r9);
    }
}
