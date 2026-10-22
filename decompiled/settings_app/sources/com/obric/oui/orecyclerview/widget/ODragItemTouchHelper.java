package com.obric.oui.orecyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.android.settings.revone.TabletDpiSettingsFragment;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.style.scene.drag.RubberBandHelper;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ODragItemTouchHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper;", "Lcom/obric/oui/orecyclerview/widget/ItemTouchHelper;", "adapter", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "callback", "Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;)V", "callbackImpl", "Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$CallbackImpl;", "getCallbackImpl", "()Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$CallbackImpl;", "registerDragHandle", "", "viewHolder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "handle", "Landroid/view/View;", "setDragScale", "scale", "", "setLongPressDragEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "", "unregisterDragHandle", "Callback", "CallbackImpl", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODragItemTouchHelper extends ItemTouchHelper {

    /* JADX INFO: compiled from: ODragItemTouchHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;", "", "onCheckCanDrag", "", "viewHolder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onDragging", "", "offset", "onEndDrag", "onPositionChange", "fromPosition", "toPosition", "onStartDrag", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Callback {
        boolean onCheckCanDrag(RecyclerView.ViewHolder r1, int r2);

        void onDragging(RecyclerView.ViewHolder r1, int r2);

        void onEndDrag(RecyclerView.ViewHolder r1);

        boolean onPositionChange(RecyclerView.ViewHolder r1, int r2, int r3);

        void onStartDrag(RecyclerView.ViewHolder r1);
    }

    /* JADX INFO: compiled from: ODragItemTouchHelper.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\rH\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0016\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\rH\u0002J\u0012\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u001bH\u0002J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J@\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\r2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u0016H\u0016J \u00104\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020\r2\u0006\u00105\u001a\u00020\rH\u0016J\b\u00106\u001a\u00020\u0016H\u0016J\u001a\u00107\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u00102\u001a\u00020\u0011H\u0016J\u0018\u00108\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u00109\u001a\u00020\u0011H\u0016J\u000e\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u000fJ\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u0016J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\rH\u0002J\u0012\u0010?\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$CallbackImpl;", "Lcom/obric/oui/orecyclerview/widget/ItemTouchHelper$Callback;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "adapter", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "callback", "Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;Lcom/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback;)V", "cachedRootLoc", "", "cachedRvLoc", "cachedViewLoc", "currentDragViewHolder", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "dragScale", "", "dragStartY", "", "dropAnimators", "Ljava/util/WeakHashMap;", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "isLongPressDragEnabled", "", "lastTouchBottom", "Ljava/lang/Float;", "lastTouchTop", "mirrorViews", "Landroid/view/View;", "pickUpAnimators", "recoverRatios", "animateDrop", "", "viewHolder", "mirrorView", "animatePickUp", "clearView", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "createMirrorView", "dp2px", TabletDpiSettingsFragment.UNIT, "findAdapterForViewHolder", "getCurrentCoordinate", "view", "getMovementFlags", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onPreDraw", "onSelectedChanged", "onSwiped", MaterialConfigFormatNames.DIRECTION, "setDragScale", "scale", "setLongPressDragEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "startTrackingDragPosition", "stopTrackingDragPosition", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class CallbackImpl extends ItemTouchHelper.Callback implements ViewTreeObserver.OnPreDrawListener {
        private final RecyclerView.Adapter<?> adapter;
        private final int[] cachedRootLoc;
        private final int[] cachedRvLoc;
        private final int[] cachedViewLoc;
        private final Callback callback;
        private RecyclerView.ViewHolder currentDragViewHolder;
        private float dragScale;
        private int dragStartY;
        private final WeakHashMap<RecyclerView.ViewHolder, AnimationManager> dropAnimators;
        private boolean isLongPressDragEnabled;
        private Float lastTouchBottom;
        private Float lastTouchTop;
        private final WeakHashMap<RecyclerView.ViewHolder, View> mirrorViews;
        private final WeakHashMap<RecyclerView.ViewHolder, AnimationManager> pickUpAnimators;
        private final WeakHashMap<RecyclerView.ViewHolder, Float> recoverRatios;

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "viewHolder");
        }

        public static final /* synthetic */ float access$getDragScale$p(CallbackImpl r0) {
            return r0.dragScale;
        }

        public static final /* synthetic */ WeakHashMap access$getMirrorViews$p(CallbackImpl r0) {
            return r0.mirrorViews;
        }

        public CallbackImpl(RecyclerView.Adapter<?> r2, Callback r3) {
            Intrinsics.checkNotNullParameter(r2, "adapter");
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.adapter = r2;
            this.callback = r3;
            this.dragScale = 1.05f;
            this.cachedRvLoc = new int[2];
            this.cachedRootLoc = new int[2];
            this.cachedViewLoc = new int[2];
            this.recoverRatios = new WeakHashMap();
            this.pickUpAnimators = new WeakHashMap();
            this.dropAnimators = new WeakHashMap();
            this.mirrorViews = new WeakHashMap();
        }

        public final void setDragScale(float r1) {
            this.dragScale = r1;
        }

        public final void setLongPressDragEnabled(boolean r1) {
            this.isLongPressDragEnabled = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return this.isLongPressDragEnabled;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView r2, RecyclerView.ViewHolder r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            Intrinsics.checkNotNullParameter(r3, "viewHolder");
            if (findAdapterForViewHolder(r3) != null) goto L7;
            return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
        L7:
            if (this.callback.onCheckCanDrag(r3, r3.getAbsoluteAdapterPosition()) == false) goto L9;
            int r1 = 3;
        L11:
            return ItemTouchHelper.Callback.makeMovementFlags(r1, 0);
        L9:
            r1 = 0;
            goto L11
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder r4, int r5) {
            super.onSelectedChanged(r4, r5);
            if (r5 != 0) goto L5;
            stopTrackingDragPosition(this.currentDragViewHolder);
            return;
        L5:
            if (r5 != 2) goto L34;
            if (r4 == null) goto L35;
            AnimationManager r6 = this.pickUpAnimators.get(r4);
            ViewGroup r2 = null;
            if (r6 == null) goto L13;
            AnimationManager.cancelAnimation$default(r6, false, 1, null);
        L13:
            AnimationManager r7 = this.dropAnimators.get(r4);
            if (r7 == null) goto L17;
            AnimationManager.cancelAnimation$default(r7, false, 1, null);
        L17:
            View r8 = this.mirrorViews.get(r4);
            if (r8 == null) goto L26;
            ViewParent r0 = r8.getParent();
            if ((r0 instanceof ViewGroup) == false) goto L23;
            r2 = (ViewGroup) r0;
        L23:
            if (r2 == null) goto L26;
            r2.removeView(r8);
        L26:
            this.mirrorViews.remove(r4);
            createMirrorView(r4);
            View r9 = this.mirrorViews.get(r4);
            if (r9 == null) goto L30;
            animatePickUp(r4, r9);
        L30:
            startTrackingDragPosition(r4);
            this.callback.onStartDrag(r4);
            return;
        L35:
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas r16, RecyclerView r17, RecyclerView.ViewHolder r18, float r19, float r20, int r21, boolean r22) {
            Intrinsics.checkNotNullParameter(r16, "c");
            Intrinsics.checkNotNullParameter(r17, "recyclerView");
            Intrinsics.checkNotNullParameter(r18, "viewHolder");
            if (r21 != 2) goto L41;
            float r1 = r18.itemView.getTop() + r20;
            float r5 = r18.itemView.getBottom() + r20;
            View r7 = null;
            if (r22 == false) goto L26;
            float r8 = dp2px(40);
            float r9 = r17.getPaddingTop();
            float r10 = r17.getPaddingBottom();
            float r11 = r17.getHeight();
            if (r1 >= r9) goto L13;
            float r12 = r9 - r8;
            Float r13 = this.lastTouchTop;
            if (r13 != null) goto L11;
            float r14 = r9;
        L12:
            float r2 = RubberBandHelper.Companion.getRealValue(r9, r12, r14, r1);
            float r15 = r2 - r18.itemView.getTop();
            this.lastTouchTop = Float.valueOf(r2);
        L14:
            float r110 = r11 - r10;
            if (r5 <= r110) goto L21;
            float r23 = r8 + r110;
            Float r3 = this.lastTouchBottom;
            if (r3 != null) goto L19;
            float r4 = r110;
        L20:
            float r6 = RubberBandHelper.Companion.getRealValue(r110, r23, r4, r5);
            r15 = r6 - r18.itemView.getBottom();
            this.lastTouchBottom = Float.valueOf(r6);
        L23:
            if (Math.abs(r20) <= 0.001f) goto L25;
            this.recoverRatios.put(r18, Float.valueOf(r15 / r20));
        L30:
            View r24 = this.mirrorViews.get(r18);
            if (r24 == null) goto L40;
            r17.getLocationOnScreen(this.cachedRvLoc);
            Object r25 = r24.getParent();
            if ((r25 instanceof View) == false) goto L36;
            r7 = (View) r25;
        L36:
            if (r7 == null) goto L39;
            r7.getLocationOnScreen(this.cachedRootLoc);
        L39:
            float r26 = (this.cachedRvLoc[0] + r18.itemView.getLeft()) + r19;
            float r27 = (this.cachedRvLoc[1] + r18.itemView.getTop()) + r15;
            r24.setX(r26 - this.cachedRootLoc[0]);
            r24.setY(r27 - this.cachedRootLoc[1]);
        L40:
            float r28 = r15;
        L42:
            super.onChildDraw(r16, r17, r18, r19, r28, r21, r22);
            return;
        L25:
            this.recoverRatios.remove(r18);
            goto L30
        L19:
            r4 = r3.floatValue();
            goto L20
        L21:
            this.lastTouchBottom = null;
            goto L23
        L11:
            r14 = r13.floatValue();
            goto L12
        L13:
            this.lastTouchTop = null;
            r15 = r20;
            goto L14
        L26:
            Float r29 = this.recoverRatios.get(r18);
            if (r29 != null) goto L29;
            r29 = Float.valueOf(1.0f);
        L29:
            r15 = r29.floatValue() * r20;
            goto L30
        L41:
            r28 = r20;
            goto L42
        }

        private final float dp2px(int r1) {
            return r1 * Resources.getSystem().getDisplayMetrics().density;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView r2, RecyclerView.ViewHolder r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            Intrinsics.checkNotNullParameter(r3, "viewHolder");
            super.clearView(r2, r3);
            View r4 = this.mirrorViews.get(r3);
            if (r4 == null) goto L5;
            animateDrop(r3, r4);
        L6:
            this.callback.onEndDrag(r3);
            this.recoverRatios.remove(r3);
            return;
        L5:
            r3.itemView.setVisibility(0);
            goto L6
        }

        private final void animatePickUp(RecyclerView.ViewHolder r14, final View r15) {
            View r0 = r14.itemView;
            Intrinsics.checkNotNullExpressionValue(r0, "viewHolder.itemView");
            r0.setScaleX(this.dragScale);
            r0.setScaleY(this.dragScale);
            r0.setVisibility(4);
            Float r10 = Float.valueOf(1.0f);
            r15.setAlpha(1.0f);
            r15.setScaleX(1.0f);
            r15.setScaleY(1.0f);
            this.pickUpAnimators.put(r14, PropertyAnimatable.start$default(PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r15, 0.0f, 1, null), AnimationProperty.FloatProperty.SCALE_X, r10, this.dragScale, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), null, 16, null), AnimationProperty.FloatProperty.SCALE_Y, r10, this.dragScale, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), null, 16, null).onEnd(new ODragItemTouchHelper$CallbackImpl$animatePickUp$1(r15, this)).build(), null, null, 3, null));
        }

        private final void animateDrop(final RecyclerView.ViewHolder r26, final View r27) {
            final View r3 = r26.itemView;
            Intrinsics.checkNotNullExpressionValue(r3, "viewHolder.itemView");
            r3.setScaleX(this.dragScale);
            r3.setScaleY(this.dragScale);
            r3.setAlpha(1.0f);
            r3.setVisibility(0);
            r27.setAlpha(0.0f);
            r27.setScaleX(this.dragScale);
            r27.setScaleY(this.dragScale);
            this.dropAnimators.put(r26, PropertyAnimatable.start$default(PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r3, 0.0f, 1, null), AnimationProperty.FloatProperty.SCALE_X, Float.valueOf(this.dragScale), 1.0f, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), null, 16, null), AnimationProperty.FloatProperty.SCALE_Y, Float.valueOf(this.dragScale), 1.0f, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), null, 16, null).onEnd(new ODragItemTouchHelper$CallbackImpl$animateDrop$1(r3, r27, this, r26)).build(), null, null, 3, null));
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.oui.orecyclerview.widget.ODragItemTouchHelper$CallbackImpl$createMirrorView$mirrorGroup$1, java.lang.Object] */
        private final void createMirrorView(RecyclerView.ViewHolder r9) {
            final View r0 = r9.itemView;
            Intrinsics.checkNotNullExpressionValue(r0, "viewHolder.itemView");
            final Context r1 = r0.getContext();
            ?? r2 = new ODragItemTouchHelper$CallbackImpl$createMirrorView$mirrorGroup$1(r0, r1);
            r2.setClipChildren(false);
            r2.setClipToPadding(false);
            ViewGroup r3 = (ViewGroup) r0.getRootView().findViewById(R.id.content);
            if (r3 != null) goto L8;
            View r4 = r0.getRootView();
            if ((r4 instanceof ViewGroup) == false) goto L7;
            r3 = (ViewGroup) r4;
            goto L8
        L7:
            r3 = null;
        L8:
            if (r3 == null) goto L12;
            r3.setClipChildren(false);
            r3.setClipToPadding(false);
            r3.addView((View) r2, new ViewGroup.LayoutParams(r0.getWidth(), r0.getHeight()));
            int[] r5 = new int[2];
            r0.getLocationOnScreen(r5);
            int[] r6 = new int[2];
            r3.getLocationOnScreen(r6);
            r2.setX(r5[0] - r6[0]);
            r2.setY(r5[1] - r6[1]);
            this.mirrorViews.put(r9, r2);
            return;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            RecyclerView.ViewHolder r0 = this.currentDragViewHolder;
            if (r0 == null) goto L8;
            int r2 = getCurrentCoordinate(r0.itemView)[1];
            int r3 = Math.abs(r2 - this.dragStartY);
            if (r2 != 0) goto L7;
            this.callback.onDragging(r0, 0);
            goto L8
        L7:
            this.callback.onDragging(r0, r3);
        L8:
            return true;
        }

        private final void startTrackingDragPosition(RecyclerView.ViewHolder r3) {
            this.currentDragViewHolder = r3;
            this.dragStartY = getCurrentCoordinate(r3.itemView)[1];
            r3.itemView.getViewTreeObserver().addOnPreDrawListener(this);
        }

        private final void stopTrackingDragPosition(RecyclerView.ViewHolder r2) {
            if (r2 == null) goto L11;
            View r3 = r2.itemView;
            if (r3 == null) goto L11;
            ViewTreeObserver r4 = r3.getViewTreeObserver();
            if (r4 == null) goto L11;
            r4.removeOnPreDrawListener(this);
        L11:
            this.currentDragViewHolder = null;
        }

        private final int[] getCurrentCoordinate(View r2) {
            if (r2 == null) goto L6;
            r2.getLocationOnScreen(this.cachedViewLoc);
        L6:
            return this.cachedViewLoc;
        }

        private final RecyclerView.Adapter<?> findAdapterForViewHolder(RecyclerView.ViewHolder r4) {
            RecyclerView.Adapter<?> r0 = this.adapter;
            if ((r0 instanceof ConcatAdapter) == false) goto L15;
            int r5 = r4.getAbsoluteAdapterPosition();
            if (r5 == (-1)) goto L13;
            Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r3 = ((ConcatAdapter) this.adapter).getAdapters().iterator();
            int r1 = 0;
        L8:
            if (r3.hasNext() == false) goto L18;
            RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r2 = r3.next();
            if (r5 < (r2.getItemCount() + r1)) goto L11;
            r1 = r1 + r2.getItemCount();
            goto L8
        L11:
            return r2;
        L18:
            return null;
        L13:
            return null;
        L15:
            return r0;
        }

        @Override // com.obric.oui.orecyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView r2, RecyclerView.ViewHolder r3, RecyclerView.ViewHolder r4) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            Intrinsics.checkNotNullParameter(r3, "viewHolder");
            Intrinsics.checkNotNullParameter(r4, "target");
            if (Intrinsics.areEqual(findAdapterForViewHolder(r3), findAdapterForViewHolder(r4)) == true) goto L6;
            return false;
        L6:
            int r5 = r3.getAbsoluteAdapterPosition();
            int r6 = r4.getAbsoluteAdapterPosition();
            if (this.callback.onPositionChange(r3, r5, r6) == false) goto L14;
            View r1 = this.mirrorViews.get(r3);
            if (r1 == null) goto L15;
            r1.invalidate();
            return true;
        L15:
            return true;
        L14:
            return true;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$aSxDyLpzoqk6HJ3XUuvKFzMqcls(ODragItemTouchHelper r0, RecyclerView.ViewHolder r1, View r2, MotionEvent r3) {
        return m1258registerDragHandle$lambda0(r0, r1, r2, r3);
    }

    public ODragItemTouchHelper(RecyclerView.Adapter<?> r2, Callback r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(new CallbackImpl(r2, r3));
    }

    private final CallbackImpl getCallbackImpl() {
        return (CallbackImpl) this.mCallback;
    }

    public final void setLongPressDragEnabled(boolean r1) {
        getCallbackImpl().setLongPressDragEnabled(r1);
    }

    public final void setDragScale(float r1) {
        getCallbackImpl().setDragScale(r1);
    }

    public final void registerDragHandle(final RecyclerView.ViewHolder r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "handle");
        r3.setOnTouchListener(new ODragItemTouchHelper$$ExternalSyntheticLambda0(this, r2));
    }

    /* JADX INFO: renamed from: registerDragHandle$lambda-0, reason: not valid java name */
    private static final boolean m1258registerDragHandle$lambda0(ODragItemTouchHelper r0, RecyclerView.ViewHolder r1, View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$viewHolder");
        if (r3.getActionMasked() != 0) goto L7;
        r0.startDrag(r1);
        return true;
    L7:
        return true;
    }

    public final void unregisterDragHandle(View r1) {
        Intrinsics.checkNotNullParameter(r1, "handle");
        r1.setOnTouchListener(null);
    }
}
