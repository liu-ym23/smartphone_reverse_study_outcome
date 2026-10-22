package com.obric.oui.swipeaction;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import com.obric.oui.button.OIconButton;
import com.obric.oui.haptic.VibratorSmt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: OSwipeQuickDeleteHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001c\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0003FGHB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u00100\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0013H\u0016J\u0012\u00103\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u00104\u001a\u00020-H\u0016J\u0010\u0010\"\u001a\u00020-2\u0006\u00105\u001a\u00020\u0010H\u0016J\u0012\u00106\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00107\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016J \u00108\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0016H\u0016J\b\u0010;\u001a\u00020-H\u0002J\u0010\u0010<\u001a\u00020-2\b\u0010=\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010>\u001a\u00020-2\b\u0010=\u001a\u0004\u0018\u00010#J\u0010\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\u0013H\u0002J \u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u0013H\u0002J\b\u0010E\u001a\u00020-H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper;", "Lcom/obric/oui/swipeaction/OSwipeLayout$SwipeListener;", "Lcom/obric/oui/swipeaction/OSwipeLayout$QuickDeleteListener;", "swipeLayout", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "menuContainer", "Landroid/view/ViewGroup;", "(Lcom/obric/oui/swipeaction/OSwipeLayout;Landroid/view/ViewGroup;)V", "actionViews", "", "Landroid/view/View;", "animatorSet", "Landroid/animation/AnimatorSet;", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "isQuickDeleteState", "", "lastActionView", "lastCurrentOffset", "", "lastDragDistance", "lastItemOriginalBgColor", "", "Ljava/lang/Integer;", "lastItemOriginalMargin", "lastItemOriginalTint", "lastViewWidthProgress", "menuOriginalWidth", "onQuickDelete", "Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteListener;", "getOnQuickDelete", "()Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteListener;", "setOnQuickDelete", "(Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteListener;)V", "onQuickDeleteStateChanged", "Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteStateChangedListener;", "getOnQuickDeleteStateChanged", "()Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteStateChangedListener;", "setOnQuickDeleteStateChanged", "(Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteStateChangedListener;)V", "originalWidths", "", "othersAlphaProgress", "targetTransitionState", "captureOriginalState", "", "onClose", "layout", "onHandRelease", "xvel", "yvel", "onOpen", "onQuickDeleteAction", "isQuickDelete", "onStartClose", "onStartOpen", "onUpdate", "leftOffset", "topOffset", "resetButtons", "setOnQuickDeleteListener", "listener", "setOnQuickDeleteStateChangedListener", "startTransitionAnimation", "target", "updateViews", "currentOffset", "dragDistance", "progress", "updateViewsInternal", "Companion", "OnQuickDeleteListener", "OnQuickDeleteStateChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwipeQuickDeleteHelper implements OSwipeLayout.SwipeListener, OSwipeLayout.QuickDeleteListener {
    public static final Companion Companion = null;
    public static final String TAG = "OSwipeQuickDeleteHelper";
    private final List<View> actionViews;
    private AnimatorSet animatorSet;
    private final ArgbEvaluator argbEvaluator;
    private boolean isQuickDeleteState;
    private View lastActionView;
    private float lastCurrentOffset;
    private float lastDragDistance;
    private Integer lastItemOriginalBgColor;
    private Integer lastItemOriginalMargin;
    private Integer lastItemOriginalTint;
    private float lastViewWidthProgress;
    private final ViewGroup menuContainer;
    private int menuOriginalWidth;
    private OnQuickDeleteListener onQuickDelete;
    private OnQuickDeleteStateChangedListener onQuickDeleteStateChanged;
    private final Map<View, Integer> originalWidths;
    private float othersAlphaProgress;
    private final OSwipeLayout swipeLayout;
    private float targetTransitionState;

    /* JADX INFO: compiled from: OSwipeQuickDeleteHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSwipeQuickDeleteHelper.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteListener;", "", "onQuickDelete", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnQuickDeleteListener {
        void onQuickDelete();
    }

    /* JADX INFO: compiled from: OSwipeQuickDeleteHelper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeQuickDeleteHelper$OnQuickDeleteStateChangedListener;", "", "onQuickDeleteStateChanged", "", "isQuickDelete", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnQuickDeleteStateChangedListener {
        void onQuickDeleteStateChanged(boolean r1);
    }

    public static /* synthetic */ void $r8$lambda$1PEjTxIyfEqJiPDKMmzlhT74wmg(OSwipeQuickDeleteHelper r0, ValueAnimator r1) {
        m1406startTransitionAnimation$lambda4$lambda3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$24Y1BgPlJzEVw51BfcM4UdHOJdc(OSwipeQuickDeleteHelper r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        m1405_init_$lambda0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void $r8$lambda$uaq_TBVkwdBoZmxvgXALFEzh0vU(OSwipeQuickDeleteHelper r0, ValueAnimator r1) {
        m1407startTransitionAnimation$lambda6$lambda5(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
    public void onStartClose(OSwipeLayout r1) {
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
    public void onStartOpen(OSwipeLayout r1) {
    }

    public OSwipeQuickDeleteHelper(OSwipeLayout r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "swipeLayout");
        Intrinsics.checkNotNullParameter(r3, "menuContainer");
        this.swipeLayout = r2;
        this.menuContainer = r3;
        this.actionViews = new ArrayList();
        this.originalWidths = new LinkedHashMap();
        this.argbEvaluator = new ArgbEvaluator();
        r2.setShowMode(OSwipeLayout.ShowMode.LayDown);
        r2.removeQuickDeleteListeners();
        r2.addSwipeListener(this);
        r2.setQuickDeleteListener(this);
        r2.setQuickDeleteEnabled(true);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        if (r3.getWidth() <= 0) goto L5;
        captureOriginalState();
    L5:
        r3.addOnLayoutChangeListener(new OSwipeQuickDeleteHelper$$ExternalSyntheticLambda0(this));
    }

    public final OnQuickDeleteListener getOnQuickDelete() {
        return this.onQuickDelete;
    }

    public final void setOnQuickDelete(OnQuickDeleteListener r1) {
        this.onQuickDelete = r1;
    }

    public final OnQuickDeleteStateChangedListener getOnQuickDeleteStateChanged() {
        return this.onQuickDeleteStateChanged;
    }

    public final void setOnQuickDeleteStateChanged(OnQuickDeleteStateChangedListener r1) {
        this.onQuickDeleteStateChanged = r1;
    }

    public final void setOnQuickDeleteListener(OnQuickDeleteListener r1) {
        this.onQuickDelete = r1;
    }

    public final void setOnQuickDeleteStateChangedListener(OnQuickDeleteStateChangedListener r1) {
        this.onQuickDeleteStateChanged = r1;
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final void m1405_init_$lambda0(OSwipeQuickDeleteHelper r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r1.getWidth() > 0) goto L5;
        return;
    L5:
        if (r0.menuOriginalWidth != 0) goto L8;
        r0.captureOriginalState();
        return;
    L8:
        boolean r10 = false;
        if (r0.swipeLayout.getIsBeingDragged() == false) goto L11;
    L15:
        boolean r11 = false;
    L16:
        AnimatorSet r12 = r0.animatorSet;
        if (r12 != null) goto L20;
    L22:
        boolean r13 = !r10;
        boolean r14 = r0.swipeLayout.hasIsQuickDeleteTriggered();
        if (r11 == false) goto L29;
        if (r13 == false) goto L30;
        if (r14 == true) goto L31;
        r0.captureOriginalState();
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L20:
        if (r12.isRunning() != true) goto L22;
        r10 = true;
        goto L22
    L11:
        if (r0.swipeLayout.getOpenStatus() != OSwipeLayout.Status.Close) goto L13;
    L14:
        r11 = true;
        goto L16
    L13:
        if (r0.swipeLayout.getOpenStatus() != OSwipeLayout.Status.Open) goto L15;
        goto L14
    }

    private final void captureOriginalState() {
        int r0 = this.menuContainer.getWidth();
        List r1 = SequencesKt.toList(SequencesKt.filter(ViewGroupKt.getChildren(this.menuContainer), OSwipeQuickDeleteHelper$captureOriginalState$currentVisibleChildren$1.INSTANCE));
        if (r0 == this.menuOriginalWidth) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
    L25:
        if (r2 == true) goto L27;
        return;
    L27:
        this.menuOriginalWidth = r0;
        this.actionViews.clear();
        this.originalWidths.clear();
        Iterator r3 = r1.iterator();
    L29:
        if (r3.hasNext() == false) goto L32;
        View r4 = (View) r3.next();
        this.actionViews.add(r4);
        this.originalWidths.put(r4, Integer.valueOf(r4.getWidth()));
        goto L29
    L32:
        if ((!this.actionViews.isEmpty()) == false) goto L76;
        View r5 = (View) CollectionsKt.last(this.actionViews);
        this.lastActionView = r5;
        if (r5 == null) goto L76;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        Integer r7 = null;
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L39;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r6;
    L40:
        if (r8 != null) goto L42;
        int r9 = 0;
    L43:
        this.lastItemOriginalMargin = r9;
        if ((r5 instanceof ImageView) == false) goto L51;
        ColorStateList r10 = ((ImageView) r5).getImageTintList();
        if (r10 != null) goto L48;
        Integer r11 = null;
    L49:
        this.lastItemOriginalTint = r11;
        goto L51
    L48:
        r11 = Integer.valueOf(r10.getDefaultColor());
    L51:
        if (r5.getBackgroundTintList() == null) goto L58;
        ColorStateList r12 = r5.getBackgroundTintList();
        if (r12 == null) goto L56;
        r7 = Integer.valueOf(r12.getDefaultColor());
    L56:
        this.lastItemOriginalBgColor = r7;
        goto L76
    L58:
        if ((r5.getBackground() instanceof ColorDrawable) == false) goto L65;
        Drawable r13 = r5.getBackground();
        if (r13 == null) goto L63;
        this.lastItemOriginalBgColor = Integer.valueOf(((ColorDrawable) r13).getColor());
        goto L76
    L63:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L65:
        if ((r5.getBackground() instanceof GradientDrawable) == false) goto L75;
        Drawable r14 = r5.getBackground();
        if (r14 == null) goto L74;
        ColorStateList r15 = ((GradientDrawable) r14).getColor();
        if (r15 == null) goto L72;
        r7 = Integer.valueOf(r15.getDefaultColor());
    L72:
        this.lastItemOriginalBgColor = r7;
        goto L76
    L74:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L75:
        Log.e(TAG, Intrinsics.stringPlus("captureOriginalState : getLastItem bgColor failed: bg.class:", r5.getBackground().getClass().getName()));
        goto L76
    L42:
        r9 = Integer.valueOf(r8.getMarginStart());
        goto L43
    L39:
        r8 = null;
    L76:
        ViewGroup.LayoutParams r16 = this.menuContainer.getLayoutParams();
        if (r16 == null) goto L79;
        r16.width = this.menuOriginalWidth;
        this.menuContainer.setLayoutParams(r16);
    L79:
        int r17 = RangesKt.coerceAtLeast(this.swipeLayout.getWidth() - this.menuOriginalWidth, 0);
        int r18 = this.menuOriginalWidth;
        float r19 = r18 + (r17 * 0.4f);
        if (r18 <= 0) goto L82;
        float r20 = r19 / r18;
    L83:
        float r21 = RangesKt.coerceAtLeast(r20, 1.1f);
        this.swipeLayout.setQuickDeleteThreshold(r21);
        this.swipeLayout.setQuickDeleteMax(r21 + 0.5f);
        this.swipeLayout.setOverrideDragDistance(this.menuOriginalWidth);
        return;
    L82:
        r20 = 1.5f;
        goto L83
    L8:
        if (r1.size() == this.actionViews.size()) goto L10;
    L24:
        r2 = true;
        goto L25
    L10:
        if (r1.size() != this.originalWidths.size()) goto L24;
        int r22 = r1.size();
        int r23 = 0;
    L13:
        if (r23 >= r22) goto L25;
        int r24 = r23 + 1;
        if (Intrinsics.areEqual(r1.get(r23), this.actionViews.get(r23)) == false) goto L24;
        int r25 = ((View) r1.get(r23)).getWidth();
        Integer r26 = this.originalWidths.get(r1.get(r23));
        if (r26 != null) goto L20;
        int r27 = -1;
    L21:
        if (r25 != r27) goto L24;
        r23 = r24;
        goto L13
    L20:
        r27 = r26.intValue();
        goto L21
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
    public void onOpen(OSwipeLayout r1) {
        resetButtons();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
    public void onClose(OSwipeLayout r1) {
        resetButtons();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
    public void onUpdate(OSwipeLayout r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        if (r3.mOverrideDragDistance <= 0) goto L5;
        int r6 = r3.mOverrideDragDistance;
    L6:
        float r7 = r6;
        float r0 = 0.0f;
        if (r7 != 0.0f) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        float r8 = Math.abs(r4);
        float r2 = r8 / r7;
        this.lastCurrentOffset = r8;
        this.lastDragDistance = r7;
        if (r2 < r3.mQuickDeleteThreshold) goto L15;
        r0 = 1.0f;
    L15:
        startTransitionAnimation(r0);
        updateViews(r8, r7, r2);
        return;
    L9:
        r1 = false;
        goto L10
    L5:
        r6 = r3.getDragDistance();
        goto L6
    }

    private final void startTransitionAnimation(float r11) {
        if (this.targetTransitionState != r11) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.targetTransitionState = r11;
        AnimatorSet r1 = this.animatorSet;
        if (r1 == null) goto L12;
        r1.cancel();
    L12:
        this.animatorSet = new AnimatorSet();
        float r2 = 1.0f;
        if (r11 != 1.0f) goto L15;
        boolean r12 = true;
    L16:
        float[] r4 = new float[2];
        r4[0] = this.othersAlphaProgress;
        if (r12 == false) goto L19;
        float r6 = 1.0f;
    L20:
        r4[1] = r6;
        ValueAnimator r5 = ValueAnimator.ofFloat(r4);
        r5.setDuration(300);
        r5.setInterpolator(new DecelerateInterpolator());
        r5.addUpdateListener(new OSwipeQuickDeleteHelper$$ExternalSyntheticLambda1(this));
        float[] r8 = new float[2];
        r8[0] = this.lastViewWidthProgress;
        if (r12 == true) goto L24;
        r2 = 0.0f;
    L24:
        r8[1] = r2;
        ValueAnimator r13 = ValueAnimator.ofFloat(r8);
        r13.setDuration(300);
        r13.setInterpolator(new DecelerateInterpolator());
        r13.addUpdateListener(new OSwipeQuickDeleteHelper$$ExternalSyntheticLambda2(this));
        AnimatorSet r3 = this.animatorSet;
        if (r3 == null) goto L28;
        r3.playTogether(new Animator[]{r5, r13});
    L28:
        AnimatorSet r10 = this.animatorSet;
        if (r10 == null) goto L33;
        r10.start();
        return;
    L33:
        return;
    L19:
        r6 = 0.0f;
        goto L20
    L15:
        r12 = false;
        goto L16
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: startTransitionAnimation$lambda-4$lambda-3, reason: not valid java name */
    private static final void m1406startTransitionAnimation$lambda4$lambda3(OSwipeQuickDeleteHelper r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        r1.othersAlphaProgress = ((Float) r3).floatValue();
        r1.updateViewsInternal();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* JADX INFO: renamed from: startTransitionAnimation$lambda-6$lambda-5, reason: not valid java name */
    private static final void m1407startTransitionAnimation$lambda6$lambda5(OSwipeQuickDeleteHelper r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        r1.lastViewWidthProgress = ((Float) r3).floatValue();
        r1.updateViewsInternal();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void updateViewsInternal() {
        float r0 = this.lastDragDistance;
        if (r0 <= 0.0f) goto L6;
        float r1 = this.lastCurrentOffset;
        updateViews(r1, r0, r1 / r0);
        return;
    }

    private final void updateViews(float r9, float r10, float r11) {
        ViewGroup.MarginLayoutParams r1 = null;
        int r3 = 0;
        if (r11 > 1.0f) goto L43;
        float r12 = this.menuOriginalWidth - r9;
        Iterator<T> r13 = this.actionViews.iterator();
        int r14 = 0;
    L6:
        if (r13.hasNext() == false) goto L21;
        View r4 = (View) r13.next();
        Integer r5 = this.originalWidths.get(r4);
        if (r5 != null) goto L10;
        int r6 = r4.getWidth();
    L12:
        if (r4.getLayoutParams().width == r6) goto L14;
        r4.getLayoutParams().width = r6;
        r4.requestLayout();
    L14:
        r14 = r14 + r6;
        float r7 = r14 - r12;
        float r8 = 0.0f;
        if (r6 <= 0) goto L18;
        r8 = RangesKt.coerceIn(r7 / r6, 0.0f, 1.0f);
    L20:
        r4.setAlpha(r8);
        r4.setScaleX(r8);
        r4.setScaleY(r8);
        goto L6
    L18:
        if (r7 < 0.0f) goto L20;
        r8 = 1.0f;
        goto L20
    L10:
        r6 = r5.intValue();
        goto L12
    L21:
        View r15 = this.lastActionView;
        if (r15 == null) goto L36;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r1 = (ViewGroup.MarginLayoutParams) r16;
    L27:
        if (r1 == null) goto L36;
        if (this.lastItemOriginalMargin == null) goto L36;
        int r17 = r1.getMarginStart();
        Integer r18 = this.lastItemOriginalMargin;
        if (r18 != null) goto L34;
    L35:
        Integer r19 = this.lastItemOriginalMargin;
        Intrinsics.checkNotNull(r19);
        r1.setMarginStart(r19.intValue());
        r15.setLayoutParams(r1);
        goto L36
    L34:
        if (r17 != r18.intValue()) goto L35;
    L36:
        Iterator r20 = CollectionsKt.dropLast(this.actionViews, 1).iterator();
    L38:
        if (r20.hasNext() == false) goto L42;
        View r110 = (View) r20.next();
        if (r110.getVisibility() == 0) goto L38;
        r110.setVisibility(0);
        goto L38
    L42:
        this.menuContainer.requestLayout();
        return;
    L43:
        Iterator<T> r111 = this.actionViews.iterator();
    L45:
        if (r111.hasNext() == false) goto L52;
        View r21 = (View) r111.next();
        if (r21.getAlpha() != 1.0f) goto L49;
        boolean r22 = true;
    L50:
        if (r22 == true) goto L45;
        r21.setAlpha(1.0f);
        r21.setScaleX(1.0f);
        r21.setScaleY(1.0f);
        goto L45
    L49:
        r22 = false;
        goto L50
    L52:
        float r112 = RangesKt.coerceAtMost(r9 - r10, r10 * (this.swipeLayout.mQuickDeleteMax - 1.0f));
        View r113 = this.lastActionView;
        if (r113 != null) goto L55;
        return;
    L55:
        float r23 = 1.0f - this.othersAlphaProgress;
        Iterator r2 = CollectionsKt.dropLast(this.actionViews, 1).iterator();
    L57:
        if (r2.hasNext() == false) goto L65;
        View r24 = (View) r2.next();
        r24.setAlpha(r23);
        r24.setScaleX(r23);
        r24.setScaleY(r23);
        Integer r25 = this.originalWidths.get(r24);
        if (r25 != null) goto L61;
        int r26 = r24.getWidth();
    L62:
        int r27 = (int) (r26 * r23);
        if (r24.getLayoutParams().width == r27) goto L57;
        r24.getLayoutParams().width = r27;
        r24.requestLayout();
        goto L57
    L61:
        r26 = r25.intValue();
        goto L62
    L65:
        float r28 = this.lastViewWidthProgress;
        ViewGroup.LayoutParams r29 = r113.getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == false) goto L68;
        r1 = (ViewGroup.MarginLayoutParams) r29;
    L68:
        if (r1 == null) goto L76;
        Integer r30 = this.lastItemOriginalMargin;
        if (r30 == null) goto L73;
        r3 = r30.intValue();
    L73:
        int r0 = (int) (r3 * (1.0f - r28));
        if (r1.getMarginStart() == r0) goto L76;
        r1.setMarginStart(r0);
        r113.setLayoutParams(r1);
    L76:
        Integer r31 = this.originalWidths.get(r113);
        if (r31 != null) goto L79;
        int r32 = r113.getWidth();
    L80:
        int r114 = (int) (r32 + r112);
        int r33 = (int) (r114 + ((((int) (r9 - (this.menuContainer.getPaddingLeft() + this.menuContainer.getPaddingRight()))) - r114) * r28));
        if (r113.getLayoutParams().width == r33) goto L84;
        r113.getLayoutParams().width = r33;
        r113.requestLayout();
    L84:
        if ((r113 instanceof ImageView) == false) goto L106;
        if (this.lastItemOriginalTint == null) goto L106;
        Integer r34 = this.lastItemOriginalBgColor;
        if (r34 == null) goto L97;
        ArgbEvaluator r35 = this.argbEvaluator;
        Intrinsics.checkNotNull(r34);
        Integer r36 = this.lastItemOriginalTint;
        Intrinsics.checkNotNull(r36);
        Object r37 = r35.evaluate(r28, r34, r36);
        if (r37 == null) goto L96;
        int r38 = ((Integer) r37).intValue();
        ImageView r39 = (ImageView) r113;
        if (r39.getBackgroundTintList() == null) goto L94;
        r39.setBackgroundTintList(ColorStateList.valueOf(r38));
        goto L97
    L94:
        r113.setBackgroundColor(r38);
        goto L97
    L96:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L97:
        ArgbEvaluator r40 = this.argbEvaluator;
        Integer r41 = this.lastItemOriginalTint;
        Intrinsics.checkNotNull(r41);
        Object r42 = r40.evaluate(r28, r41, -1);
        if (r42 == null) goto L104;
        int r43 = ((Integer) r42).intValue();
        ImageView r44 = (ImageView) r113;
        if (r44.getImageTintList() == null) goto L102;
        r44.setImageTintList(ColorStateList.valueOf(r43));
        goto L106
    L102:
        r44.setColorFilter(r43);
        goto L106
    L104:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L106:
        if ((r113 instanceof OIconButton) == false) goto L129;
        ((OIconButton) r113).setAlignmentProgress(r28);
        return;
    L129:
        return;
    L79:
        r32 = r31.intValue();
        goto L80
    }

    private final void resetButtons() {
        this.othersAlphaProgress = 0.0f;
        this.lastViewWidthProgress = 0.0f;
        this.targetTransitionState = 0.0f;
        AnimatorSet r1 = this.animatorSet;
        if (r1 == null) goto L6;
        r1.cancel();
    L6:
        Iterator r2 = CollectionsKt.dropLast(this.actionViews, 1).iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        View r3 = (View) r2.next();
        Integer r4 = this.originalWidths.get(r3);
        if (r4 != null) goto L12;
        int r5 = r3.getWidth();
    L14:
        if (r3.getLayoutParams().width == r5) goto L16;
        r3.getLayoutParams().width = r5;
    L16:
        r3.setAlpha(1.0f);
        r3.setScaleX(1.0f);
        r3.setScaleY(1.0f);
        if (r3.getVisibility() == 0) goto L8;
        r3.setVisibility(0);
        goto L8
    L12:
        r5 = r4.intValue();
        goto L14
    L19:
        View r6 = this.lastActionView;
        if (r6 == null) goto L59;
        Integer r7 = this.originalWidths.get(r6);
        if (r7 != null) goto L25;
        int r8 = r6.getWidth();
    L27:
        if (r6.getLayoutParams().width == r8) goto L30;
        r6.getLayoutParams().width = r8;
    L30:
        if ((r6 instanceof OIconButton) == false) goto L32;
        ((OIconButton) r6).setAlignmentProgress(0.0f);
    L32:
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L35;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r0;
    L36:
        if (r9 == null) goto L46;
        if (this.lastItemOriginalMargin == null) goto L46;
        int r10 = r9.getMarginStart();
        Integer r11 = this.lastItemOriginalMargin;
        if (r11 != null) goto L43;
    L44:
        Integer r12 = this.lastItemOriginalMargin;
        Intrinsics.checkNotNull(r12);
        r9.setMarginStart(r12.intValue());
        r6.setLayoutParams(r9);
        goto L46
    L43:
        if (r10 != r11.intValue()) goto L44;
    L46:
        if ((r6 instanceof ImageView) == false) goto L59;
        if (this.lastItemOriginalTint == null) goto L54;
        ImageView r13 = (ImageView) r6;
        if (r13.getImageTintList() == null) goto L52;
        Integer r14 = this.lastItemOriginalTint;
        Intrinsics.checkNotNull(r14);
        r13.setImageTintList(ColorStateList.valueOf(r14.intValue()));
        goto L54
    L52:
        Integer r15 = this.lastItemOriginalTint;
        Intrinsics.checkNotNull(r15);
        r13.setColorFilter(r15.intValue());
    L54:
        if (this.lastItemOriginalBgColor == null) goto L59;
        ImageView r16 = (ImageView) r6;
        if (r16.getBackgroundTintList() == null) goto L58;
        Integer r17 = this.lastItemOriginalBgColor;
        Intrinsics.checkNotNull(r17);
        r16.setBackgroundTintList(ColorStateList.valueOf(r17.intValue()));
        goto L59
    L58:
        Integer r18 = this.lastItemOriginalBgColor;
        Intrinsics.checkNotNull(r18);
        r6.setBackgroundColor(r18.intValue());
        goto L59
    L35:
        r9 = null;
        goto L36
    L25:
        r8 = r7.intValue();
    L59:
        this.menuContainer.requestLayout();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.SwipeListener
    public void onHandRelease(OSwipeLayout r4, float r5, float r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        float r7 = r4.getResources().getDisplayMetrics().density;
        if (this.isQuickDeleteState == false) goto L7;
        return;
    L7:
        View r8 = this.lastActionView;
        boolean r0 = false;
        if (r8 == null) goto L17;
        Integer r9 = this.originalWidths.get(r8);
        if (r9 != null) goto L13;
        View r10 = this.lastActionView;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.getWidth();
    L15:
        if (Math.abs(this.lastCurrentOffset) < (this.menuOriginalWidth - r11)) goto L17;
        r0 = true;
        goto L17
    L13:
        r11 = r9.intValue();
    L17:
        if (r0 == false) goto L19;
        r4.setDragDistance((int) (this.menuOriginalWidth / r7));
        r4.open();
        return;
    L19:
        r4.close();
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.QuickDeleteListener
    public void onQuickDeleteStateChanged(boolean r2) {
        if (this.isQuickDeleteState != r2) goto L5;
        return;
    L5:
        this.isQuickDeleteState = r2;
        OnQuickDeleteStateChangedListener r0 = this.onQuickDeleteStateChanged;
        if (r0 == null) goto L10;
        r0.onQuickDeleteStateChanged(r2);
    L10:
        if (this.isQuickDeleteState == false) goto L13;
        VibratorSmt.vibrateEffectWithHapticPlayer(this.swipeLayout.getContext(), 3);
        return;
    }

    @Override // com.obric.oui.swipeaction.OSwipeLayout.QuickDeleteListener
    public void onQuickDeleteAction() {
        OnQuickDeleteListener r0 = this.onQuickDelete;
        if (r0 == null) goto L7;
        r0.onQuickDelete();
        return;
    }
}
