package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations;

    public abstract boolean animateAdd(RecyclerView.ViewHolder r1);

    public abstract boolean animateChange(RecyclerView.ViewHolder r1, RecyclerView.ViewHolder r2, int r3, int r4, int r5, int r6);

    public abstract boolean animateMove(RecyclerView.ViewHolder r1, int r2, int r3, int r4, int r5);

    public abstract boolean animateRemove(RecyclerView.ViewHolder r1);

    public void onAddFinished(RecyclerView.ViewHolder r1) {
    }

    public void onAddStarting(RecyclerView.ViewHolder r1) {
    }

    public void onChangeFinished(RecyclerView.ViewHolder r1, boolean r2) {
    }

    public void onChangeStarting(RecyclerView.ViewHolder r1, boolean r2) {
    }

    public void onMoveFinished(RecyclerView.ViewHolder r1) {
    }

    public void onMoveStarting(RecyclerView.ViewHolder r1) {
    }

    public void onRemoveFinished(RecyclerView.ViewHolder r1) {
    }

    public void onRemoveStarting(RecyclerView.ViewHolder r1) {
    }

    public SimpleItemAnimator() {
        this.mSupportsChangeAnimations = true;
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

    public void setSupportsChangeAnimations(boolean r1) {
        this.mSupportsChangeAnimations = r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder r1) {
        if (this.mSupportsChangeAnimations == true) goto L5;
    L8:
        return true;
    L5:
        if (r1.isInvalid() == true) goto L8;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateDisappearance(RecyclerView.ViewHolder r7, RecyclerView.ItemAnimator.ItemHolderInfo r8, RecyclerView.ItemAnimator.ItemHolderInfo r9) {
        int r2 = r8.left;
        int r3 = r8.top;
        View r10 = r7.itemView;
        if (r9 != null) goto L5;
        int r0 = r10.getLeft();
    L6:
        int r4 = r0;
        if (r9 != null) goto L9;
        int r11 = r10.getTop();
    L10:
        int r5 = r11;
        if (r7.isRemoved() == true) goto L17;
        if (r2 != r4) goto L14;
        if (r3 == r5) goto L17;
    L14:
        r10.layout(r4, r5, r10.getWidth() + r4, r10.getHeight() + r5);
        return animateMove(r7, r2, r3, r4, r5);
    L17:
        return animateRemove(r7);
    L9:
        r11 = r9.top;
        goto L10
    L5:
        r0 = r9.left;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateAppearance(RecyclerView.ViewHolder r9, RecyclerView.ItemAnimator.ItemHolderInfo r10, RecyclerView.ItemAnimator.ItemHolderInfo r11) {
        if (r10 == null) goto L10;
        if (r10.left != r11.left) goto L8;
        if (r10.top == r11.top) goto L10;
    L8:
        return animateMove(r9, r10.left, r10.top, r11.left, r11.top);
    L10:
        return animateAdd(r9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animatePersistence(RecyclerView.ViewHolder r7, RecyclerView.ItemAnimator.ItemHolderInfo r8, RecyclerView.ItemAnimator.ItemHolderInfo r9) {
        if (r8.left != r9.left) goto L10;
        if (r8.top != r9.top) goto L10;
        dispatchMoveFinished(r7);
        return false;
    L10:
        return animateMove(r7, r8.left, r8.top, r9.left, r9.top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder r8, RecyclerView.ViewHolder r9, RecyclerView.ItemAnimator.ItemHolderInfo r10, RecyclerView.ItemAnimator.ItemHolderInfo r11) {
        int r3 = r10.left;
        int r4 = r10.top;
        if (r9.shouldIgnore() == false) goto L5;
        int r12 = r10.left;
        int r6 = r10.top;
        int r5 = r12;
    L7:
        return animateChange(r8, r9, r3, r4, r5, r6);
    L5:
        int r13 = r11.left;
        r5 = r13;
        r6 = r11.top;
        goto L7
    }

    public final void dispatchRemoveFinished(RecyclerView.ViewHolder r1) {
        onRemoveFinished(r1);
        dispatchAnimationFinished(r1);
    }

    public final void dispatchMoveFinished(RecyclerView.ViewHolder r1) {
        onMoveFinished(r1);
        dispatchAnimationFinished(r1);
    }

    public final void dispatchAddFinished(RecyclerView.ViewHolder r1) {
        onAddFinished(r1);
        dispatchAnimationFinished(r1);
    }

    public final void dispatchChangeFinished(RecyclerView.ViewHolder r1, boolean r2) {
        onChangeFinished(r1, r2);
        dispatchAnimationFinished(r1);
    }

    public final void dispatchRemoveStarting(RecyclerView.ViewHolder r1) {
        onRemoveStarting(r1);
    }

    public final void dispatchMoveStarting(RecyclerView.ViewHolder r1) {
        onMoveStarting(r1);
    }

    public final void dispatchAddStarting(RecyclerView.ViewHolder r1) {
        onAddStarting(r1);
    }

    public final void dispatchChangeStarting(RecyclerView.ViewHolder r1, boolean r2) {
        onChangeStarting(r1, r2);
    }
}
