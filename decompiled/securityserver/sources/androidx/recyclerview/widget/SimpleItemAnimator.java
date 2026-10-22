package androidx.recyclerview.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {
    private static final boolean DEBUG = false;
    private static final String TAG = "SimpleItemAnimator";
    boolean mSupportsChangeAnimations;

    public SimpleItemAnimator() {
        this.mSupportsChangeAnimations = true;
    }

    public abstract boolean animateAdd(RecyclerView.ViewHolder r1);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateAppearance(@NonNull RecyclerView.ViewHolder r7, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r8, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r9) {
        if (r8 == null) goto L10;
        int r2 = r8.left;
        int r4 = r9.left;
        if (r2 != r4) goto L8;
        if (r8.top == r9.top) goto L10;
    L8:
        return animateMove(r7, r2, r8.top, r4, r9.top);
    L10:
        return animateAdd(r7);
    }

    public abstract boolean animateChange(RecyclerView.ViewHolder r1, RecyclerView.ViewHolder r2, int r3, int r4, int r5, int r6);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateChange(@NonNull RecyclerView.ViewHolder r8, @NonNull RecyclerView.ViewHolder r9, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r10, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r11) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder r7, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r8, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo r9) {
        int r2 = r8.left;
        int r3 = r8.top;
        View r10 = r7.itemView;
        if (r9 != null) goto L6;
        int r0 = r10.getLeft();
    L5:
        int r4 = r0;
        if (r9 != null) goto L10;
        int r11 = r10.getTop();
    L9:
        int r5 = r11;
        if (r7.isRemoved() == true) goto L18;
        if (r2 != r4) goto L15;
        if (r3 == r5) goto L18;
    L15:
        r10.layout(r4, r5, r10.getWidth() + r4, r10.getHeight() + r5);
        return animateMove(r7, r2, r3, r4, r5);
    L18:
        return animateRemove(r7);
    L10:
        r11 = r9.top;
        goto L9
    L6:
        r0 = r9.left;
        goto L5
    }

    public abstract boolean animateMove(RecyclerView.ViewHolder r1, int r2, int r3, int r4, int r5);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean animatePersistence(@NonNull RecyclerView.ViewHolder r7, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r8, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo r9) {
        int r2 = r8.left;
        int r4 = r9.left;
        if (r2 != r4) goto L10;
        if (r8.top != r9.top) goto L10;
        dispatchMoveFinished(r7);
        return false;
    L10:
        return animateMove(r7, r2, r8.top, r4, r9.top);
    }

    public abstract boolean animateRemove(RecyclerView.ViewHolder r1);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder r1) {
        if (this.mSupportsChangeAnimations == true) goto L5;
    L8:
        return true;
    L5:
        if (r1.isInvalid() == true) goto L8;
        return false;
    }

    public final void dispatchAddFinished(RecyclerView.ViewHolder r1) {
        onAddFinished(r1);
        dispatchAnimationFinished(r1);
    }

    public final void dispatchAddStarting(RecyclerView.ViewHolder r1) {
        onAddStarting(r1);
    }

    public final void dispatchChangeFinished(RecyclerView.ViewHolder r1, boolean r2) {
        onChangeFinished(r1, r2);
        dispatchAnimationFinished(r1);
    }

    public final void dispatchChangeStarting(RecyclerView.ViewHolder r1, boolean r2) {
        onChangeStarting(r1, r2);
    }

    public final void dispatchMoveFinished(RecyclerView.ViewHolder r1) {
        onMoveFinished(r1);
        dispatchAnimationFinished(r1);
    }

    public final void dispatchMoveStarting(RecyclerView.ViewHolder r1) {
        onMoveStarting(r1);
    }

    public final void dispatchRemoveFinished(RecyclerView.ViewHolder r1) {
        onRemoveFinished(r1);
        dispatchAnimationFinished(r1);
    }

    public final void dispatchRemoveStarting(RecyclerView.ViewHolder r1) {
        onRemoveStarting(r1);
    }

    public boolean getSupportsChangeAnimations() {
        return this.mSupportsChangeAnimations;
    }

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

    public void setSupportsChangeAnimations(boolean r1) {
        this.mSupportsChangeAnimations = r1;
    }
}
