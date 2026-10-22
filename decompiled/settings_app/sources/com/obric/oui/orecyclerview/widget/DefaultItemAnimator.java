package com.obric.oui.orecyclerview.widget;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.obric.oui.orecyclerview.base.SmoothInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    private static TimeInterpolator sVisibilityInterpolator;
    ArrayList<RecyclerView.ViewHolder> mAddAnimations;
    ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList;
    ArrayList<RecyclerView.ViewHolder> mChangeAnimations;
    ArrayList<ArrayList<ChangeInfo>> mChangesList;
    ArrayList<RecyclerView.ViewHolder> mMoveAnimations;
    ArrayList<ArrayList<MoveInfo>> mMovesList;
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions;
    private ArrayList<ChangeInfo> mPendingChanges;
    private ArrayList<MoveInfo> mPendingMoves;
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals;
    ArrayList<RecyclerView.ViewHolder> mRemoveAnimations;

    private static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(RecyclerView.ViewHolder r1, RecyclerView.ViewHolder r2) {
            this.oldHolder = r1;
            this.newHolder = r2;
        }

        ChangeInfo(RecyclerView.ViewHolder r1, RecyclerView.ViewHolder r2, int r3, int r4, int r5, int r6) {
            this(r1, r2);
            this.fromX = r3;
            this.fromY = r4;
            this.toX = r5;
            this.toY = r6;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }
    }

    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(RecyclerView.ViewHolder r1, int r2, int r3, int r4, int r5) {
            this.holder = r1;
            this.fromX = r2;
            this.fromY = r3;
            this.toX = r4;
            this.toY = r5;
        }
    }

    public DefaultItemAnimator() {
        this.mPendingRemovals = new ArrayList();
        this.mPendingAdditions = new ArrayList();
        this.mPendingMoves = new ArrayList();
        this.mPendingChanges = new ArrayList();
        this.mAdditionsList = new ArrayList();
        this.mMovesList = new ArrayList();
        this.mChangesList = new ArrayList();
        this.mAddAnimations = new ArrayList();
        this.mMoveAnimations = new ArrayList();
        this.mRemoveAnimations = new ArrayList();
        this.mChangeAnimations = new ArrayList();
    }

    static /* synthetic */ TimeInterpolator access$000() {
        return sDefaultInterpolator;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean r0 = !this.mPendingRemovals.isEmpty();
        boolean r1 = !this.mPendingMoves.isEmpty();
        boolean r2 = !this.mPendingChanges.isEmpty();
        boolean r3 = !this.mPendingAdditions.isEmpty();
        if (r0 == true) goto L8;
        if (r1 == true) goto L8;
        if (r3 == true) goto L8;
        if (r2 == true) goto L8;
        return;
    L8:
        Iterator<RecyclerView.ViewHolder> r4 = this.mPendingRemovals.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        animateRemoveImpl(r4.next());
        goto L10
    L12:
        this.mPendingRemovals.clear();
        if (r1 == false) goto L18;
        final ArrayList<MoveInfo> r5 = new ArrayList();
        r5.addAll(this.mPendingMoves);
        this.mMovesList.add(r5);
        this.mPendingMoves.clear();
        Runnable r6 = new AnonymousClass1(this, r5);
        if (r0 == false) goto L17;
        ViewCompat.postOnAnimationDelayed(r5.get(0).holder.itemView, r6, getRemoveDuration());
        goto L18
    L17:
        r6.run();
    L18:
        if (r2 == false) goto L23;
        final ArrayList<ChangeInfo> r7 = new ArrayList();
        r7.addAll(this.mPendingChanges);
        this.mChangesList.add(r7);
        this.mPendingChanges.clear();
        Runnable r8 = new AnonymousClass2(this, r7);
        if (r0 == false) goto L22;
        ViewCompat.postOnAnimationDelayed(r7.get(0).oldHolder.itemView, r8, getRemoveDuration());
        goto L23
    L22:
        r8.run();
    L23:
        if (r3 == false) goto L42;
        final ArrayList<RecyclerView.ViewHolder> r9 = new ArrayList();
        r9.addAll(this.mPendingAdditions);
        this.mAdditionsList.add(r9);
        this.mPendingAdditions.clear();
        Runnable r10 = new AnonymousClass3(this, r9);
        if (r0 == true) goto L30;
        if (r1 == true) goto L30;
        if (r2 == true) goto L30;
        r10.run();
        return;
    L30:
        long r11 = 0;
        if (r0 == false) goto L33;
        long r12 = getRemoveDuration();
    L34:
        if (r1 == false) goto L36;
        long r13 = getMoveDuration();
    L37:
        if (r2 == false) goto L39;
        r11 = getChangeDuration();
    L39:
        ViewCompat.postOnAnimationDelayed(r9.get(0).itemView, r10, r12 + Math.max(r13, r11));
        return;
    L36:
        r13 = 0;
        goto L37
    L33:
        r12 = 0;
        goto L34
    }

    @Override // com.obric.oui.orecyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder r1) {
        resetAnimation(r1);
        this.mPendingRemovals.add(r1);
        return true;
    }

    private void animateRemoveImpl(final RecyclerView.ViewHolder r5) {
        final View r0 = r5.itemView;
        final ViewPropertyAnimator r1 = r0.animate();
        this.mRemoveAnimations.add(r5);
        r1.setDuration(getRemoveDuration()).alpha(0.0f).setInterpolator(sVisibilityInterpolator).setListener(new AnonymousClass4(this, r5, r0, r1)).start();
    }

    @Override // com.obric.oui.orecyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder r3) {
        resetAnimation(r3);
        r3.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(r3);
        return true;
    }

    void animateAddImpl(final RecyclerView.ViewHolder r6) {
        final View r0 = r6.itemView;
        final ViewPropertyAnimator r1 = r0.animate();
        this.mAddAnimations.add(r6);
        r1.alpha(1.0f).setDuration(getAddDuration()).setInterpolator(sVisibilityInterpolator).setListener(new AnonymousClass5(this, r6, r0, r1)).start();
    }

    @Override // com.obric.oui.orecyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder r9, int r10, int r11, int r12, int r13) {
        View r0 = r9.itemView;
        int r4 = r10 + ((int) r9.itemView.getTranslationX());
        int r5 = r11 + ((int) r9.itemView.getTranslationY());
        resetAnimation(r9);
        int r14 = r12 - r4;
        int r15 = r13 - r5;
        if (r14 != 0) goto L7;
        if (r15 != 0) goto L7;
        dispatchMoveFinished(r9);
        return false;
    L7:
        if (r14 == 0) goto L9;
        r0.setTranslationX(-r14);
    L9:
        if (r15 == 0) goto L11;
        r0.setTranslationY(-r15);
    L11:
        this.mPendingMoves.add(new MoveInfo(r9, r4, r5, r12, r13));
        return true;
    }

    void animateMoveImpl(final RecyclerView.ViewHolder r8, int r9, int r10, int r11, int r12) {
        final View r4 = r8.itemView;
        final int r3 = r11 - r9;
        final int r5 = r12 - r10;
        if (r3 == 0) goto L5;
        r4.animate().translationX(0.0f);
    L5:
        if (r5 == 0) goto L7;
        r4.animate().translationY(0.0f);
    L7:
        final ViewPropertyAnimator r6 = r4.animate();
        this.mMoveAnimations.add(r8);
        r6.setDuration(getMoveDuration()).setListener(new AnonymousClass6(this, r8, r3, r4, r5, r6)).start();
    }

    @Override // com.obric.oui.orecyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder r9, RecyclerView.ViewHolder r10, int r11, int r12, int r13, int r14) {
        if (r9 == r10) goto L4;
        float r0 = r9.itemView.getTranslationX();
        float r1 = r9.itemView.getTranslationY();
        float r2 = r9.itemView.getAlpha();
        resetAnimation(r9);
        int r3 = (int) ((r13 - r11) - r0);
        int r4 = (int) ((r14 - r12) - r1);
        r9.itemView.setTranslationX(r0);
        r9.itemView.setTranslationY(r1);
        r9.itemView.setAlpha(r2);
        if (r10 == null) goto L8;
        resetAnimation(r10);
        r10.itemView.setTranslationX(-r3);
        r10.itemView.setTranslationY(-r4);
        r10.itemView.setAlpha(0.0f);
    L8:
        this.mPendingChanges.add(new ChangeInfo(r9, r10, r11, r12, r13, r14));
        return true;
    L4:
        return animateMove(r9, r11, r12, r13, r14);
    }

    void animateChangeImpl(final ChangeInfo r7) {
        RecyclerView.ViewHolder r0 = r7.oldHolder;
        final View r1 = null;
        if (r0 != null) goto L5;
        final View r2 = null;
    L6:
        RecyclerView.ViewHolder r3 = r7.newHolder;
        if (r3 == null) goto L10;
        r1 = r3.itemView;
    L10:
        if (r2 == null) goto L12;
        final ViewPropertyAnimator r4 = r2.animate().setDuration(getChangeDuration());
        this.mChangeAnimations.add(r7.oldHolder);
        r4.translationX(r7.toX - r7.fromX);
        r4.translationY(r7.toY - r7.fromY);
        r4.alpha(0.0f).setListener(new AnonymousClass7(this, r7, r4, r2)).start();
    L12:
        if (r1 == null) goto L15;
        final ViewPropertyAnimator r5 = r1.animate();
        this.mChangeAnimations.add(r7.newHolder);
        r5.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnonymousClass8(this, r7, r5, r1)).start();
        return;
    L15:
        return;
    L5:
        r2 = r0.itemView;
        goto L6
    }

    private void endChangeAnimation(List<ChangeInfo> r4, RecyclerView.ViewHolder r5) {
        int r0 = r4.size() - 1;
    L3:
        if (r0 < 0) goto L12;
        ChangeInfo r1 = r4.get(r0);
        if (endChangeAnimationIfNecessary(r1, r5) == false) goto L11;
        if (r1.oldHolder != null) goto L11;
        if (r1.newHolder != null) goto L11;
        r4.remove(r1);
    L11:
        r0 = r0 - 1;
        goto L3
    }

    private void endChangeAnimationIfNecessary(ChangeInfo r2) {
        if (r2.oldHolder == null) goto L6;
        endChangeAnimationIfNecessary(r2, r2.oldHolder);
    L6:
        if (r2.newHolder == null) goto L9;
        endChangeAnimationIfNecessary(r2, r2.newHolder);
        return;
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo r5, RecyclerView.ViewHolder r6) {
        boolean r3 = false;
        if (r5.newHolder != r6) goto L6;
        r5.newHolder = null;
    L8:
        r6.itemView.setAlpha(1.0f);
        r6.itemView.setTranslationX(0.0f);
        r6.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(r6, r3);
        return true;
    L6:
        if (r5.oldHolder != r6) goto L10;
        r5.oldHolder = null;
        r3 = true;
        goto L8
    L10:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder r8) {
        View r0 = r8.itemView;
        r0.animate().cancel();
        int r1 = this.mPendingMoves.size();
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L9;
        if (this.mPendingMoves.get(r1).holder != r8) goto L3;
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        dispatchMoveFinished(r8);
        this.mPendingMoves.remove(r1);
        goto L3
    L9:
        endChangeAnimation(this.mPendingChanges, r8);
        if (this.mPendingRemovals.remove(r8) == false) goto L13;
        r0.setAlpha(1.0f);
        dispatchRemoveFinished(r8);
    L13:
        if (this.mPendingAdditions.remove(r8) == false) goto L15;
        r0.setAlpha(1.0f);
        dispatchAddFinished(r8);
    L15:
        int r2 = this.mChangesList.size() - 1;
    L16:
        if (r2 < 0) goto L21;
        ArrayList<ChangeInfo> r4 = this.mChangesList.get(r2);
        endChangeAnimation(r4, r8);
        if (r4.isEmpty() == false) goto L20;
        this.mChangesList.remove(r2);
    L20:
        r2 = r2 - 1;
        goto L16
    L21:
        int r3 = this.mMovesList.size() - 1;
    L22:
        if (r3 < 0) goto L32;
        ArrayList<MoveInfo> r5 = this.mMovesList.get(r3);
        int r6 = r5.size() - 1;
    L24:
        if (r6 < 0) goto L31;
        if (r5.get(r6).holder == r8) goto L27;
        r6 = r6 - 1;
        goto L24
    L27:
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        dispatchMoveFinished(r8);
        r5.remove(r6);
        if (r5.isEmpty() == false) goto L31;
        this.mMovesList.remove(r3);
    L31:
        r3 = r3 - 1;
        goto L22
    L32:
        int r7 = this.mAdditionsList.size() - 1;
    L33:
        if (r7 < 0) goto L40;
        ArrayList<RecyclerView.ViewHolder> r9 = this.mAdditionsList.get(r7);
        if (r9.remove(r8) == false) goto L39;
        r0.setAlpha(1.0f);
        dispatchAddFinished(r8);
        if (r9.isEmpty() == false) goto L39;
        this.mAdditionsList.remove(r7);
    L39:
        r7 = r7 - 1;
        goto L33
    L40:
        this.mRemoveAnimations.remove(r8);
        this.mAddAnimations.remove(r8);
        this.mChangeAnimations.remove(r8);
        this.mMoveAnimations.remove(r8);
        dispatchFinishedWhenDone();
    }

    private void resetAnimation(RecyclerView.ViewHolder r3) {
        if (sDefaultInterpolator != null) goto L6;
        sDefaultInterpolator = new SmoothInterpolator();
    L6:
        if (sVisibilityInterpolator != null) goto L8;
        sVisibilityInterpolator = new LinearInterpolator();
    L8:
        r3.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (this.mPendingAdditions.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.mPendingChanges.isEmpty() == false) goto L26;
        if (this.mPendingMoves.isEmpty() == false) goto L26;
        if (this.mPendingRemovals.isEmpty() == false) goto L26;
        if (this.mMoveAnimations.isEmpty() == false) goto L26;
        if (this.mRemoveAnimations.isEmpty() == false) goto L26;
        if (this.mAddAnimations.isEmpty() == false) goto L26;
        if (this.mChangeAnimations.isEmpty() == false) goto L26;
        if (this.mMovesList.isEmpty() == false) goto L26;
        if (this.mAdditionsList.isEmpty() == false) goto L26;
        if (this.mChangesList.isEmpty() == false) goto L26;
        return false;
    }

    void dispatchFinishedWhenDone() {
        if (isRunning() == true) goto L6;
        dispatchAnimationsFinished();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int r0 = this.mPendingMoves.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        MoveInfo r2 = this.mPendingMoves.get(r0);
        View r3 = r2.holder.itemView;
        r3.setTranslationY(0.0f);
        r3.setTranslationX(0.0f);
        dispatchMoveFinished(r2.holder);
        this.mPendingMoves.remove(r0);
        goto L3
    L6:
        int r1 = this.mPendingRemovals.size() - 1;
    L7:
        if (r1 < 0) goto L9;
        dispatchRemoveFinished(this.mPendingRemovals.get(r1));
        this.mPendingRemovals.remove(r1);
        r1 = r1 - 1;
        goto L7
    L9:
        int r4 = this.mPendingAdditions.size();
    L10:
        r4 = r4 - 1;
        if (r4 < 0) goto L13;
        RecyclerView.ViewHolder r5 = this.mPendingAdditions.get(r4);
        r5.itemView.setAlpha(1.0f);
        dispatchAddFinished(r5);
        this.mPendingAdditions.remove(r4);
        goto L10
    L13:
        int r6 = this.mPendingChanges.size() - 1;
    L14:
        if (r6 < 0) goto L16;
        endChangeAnimationIfNecessary(this.mPendingChanges.get(r6));
        r6 = r6 - 1;
        goto L14
    L16:
        this.mPendingChanges.clear();
        if (isRunning() == true) goto L19;
        return;
    L19:
        int r7 = this.mMovesList.size() - 1;
    L20:
        if (r7 < 0) goto L28;
        ArrayList<MoveInfo> r8 = this.mMovesList.get(r7);
        int r9 = r8.size() - 1;
    L22:
        if (r9 < 0) goto L27;
        MoveInfo r10 = r8.get(r9);
        View r11 = r10.holder.itemView;
        r11.setTranslationY(0.0f);
        r11.setTranslationX(0.0f);
        dispatchMoveFinished(r10.holder);
        r8.remove(r9);
        if (r8.isEmpty() == false) goto L26;
        this.mMovesList.remove(r8);
    L26:
        r9 = r9 - 1;
        goto L22
    L27:
        r7 = r7 - 1;
        goto L20
    L28:
        int r12 = this.mAdditionsList.size() - 1;
    L29:
        if (r12 < 0) goto L37;
        ArrayList<RecyclerView.ViewHolder> r13 = this.mAdditionsList.get(r12);
        int r14 = r13.size() - 1;
    L31:
        if (r14 < 0) goto L36;
        RecyclerView.ViewHolder r15 = r13.get(r14);
        r15.itemView.setAlpha(1.0f);
        dispatchAddFinished(r15);
        r13.remove(r14);
        if (r13.isEmpty() == false) goto L35;
        this.mAdditionsList.remove(r13);
    L35:
        r14 = r14 - 1;
        goto L31
    L36:
        r12 = r12 - 1;
        goto L29
    L37:
        int r16 = this.mChangesList.size() - 1;
    L38:
        if (r16 < 0) goto L46;
        ArrayList<ChangeInfo> r17 = this.mChangesList.get(r16);
        int r18 = r17.size() - 1;
    L40:
        if (r18 < 0) goto L45;
        endChangeAnimationIfNecessary(r17.get(r18));
        if (r17.isEmpty() == false) goto L44;
        this.mChangesList.remove(r17);
    L44:
        r18 = r18 - 1;
        goto L40
    L45:
        r16 = r16 - 1;
        goto L38
    L46:
        cancelAll(this.mRemoveAnimations);
        cancelAll(this.mMoveAnimations);
        cancelAll(this.mAddAnimations);
        cancelAll(this.mChangeAnimations);
        dispatchAnimationsFinished();
    }

    void cancelAll(List<RecyclerView.ViewHolder> r2) {
        int r1 = r2.size() - 1;
    L3:
        if (r1 < 0) goto L5;
        r2.get(r1).itemView.animate().cancel();
        r1 = r1 - 1;
        goto L3
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder r2, List<Object> r3) {
        if (r3.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.canReuseUpdatedViewHolder(r2, r3) == true) goto L8;
        return false;
    }
}
