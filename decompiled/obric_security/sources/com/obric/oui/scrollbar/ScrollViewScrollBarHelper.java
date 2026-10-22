package com.obric.oui.scrollbar;

import android.view.View;
import android.widget.ScrollView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ScrollViewScrollBarHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ3\u0010\n\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0014\b\u0004\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000eH\u0082\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/scrollbar/ScrollViewScrollBarHelper;", "", "()V", "TAG", "", "adjustScrollBarVisibilityDynamic", "", "Landroid/widget/ScrollView;", "maxScreens", "", "updateScrollBarIfNeeded", "lastState", "", "onStateChanged", "Lkotlin/Function1;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScrollViewScrollBarHelper {
    public static final ScrollViewScrollBarHelper INSTANCE = null;
    private static final String TAG = "ScrollViewScrollBarHelper";

    /* JADX INFO: renamed from: $r8$lambda$N2O5RLGi1DJ0VuDdhSbd-qE9UYQ, reason: not valid java name */
    public static /* synthetic */ void m492$r8$lambda$N2O5RLGi1DJ0VuDdhSbdqE9UYQ(ScrollView r0, float r1, Ref.BooleanRef r2, View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        m495adjustScrollBarVisibilityDynamic$lambda5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ void $r8$lambda$OxusrYuyi64TFemsTbCgRwn11Ik(ScrollView r0, float r1, Ref.BooleanRef r2, View r3, int r4, int r5, int r6, int r7) {
        m494adjustScrollBarVisibilityDynamic$lambda3(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$i8S8i8NLgu0H9nHieYwTv_pEc_E(ScrollView r0, float r1, Ref.BooleanRef r2) {
        m493adjustScrollBarVisibilityDynamic$lambda1(r0, r1, r2);
    }

    static {
        INSTANCE = new ScrollViewScrollBarHelper();
    }

    private ScrollViewScrollBarHelper() {
    }

    public static /* synthetic */ void adjustScrollBarVisibilityDynamic$default(ScrollViewScrollBarHelper r0, ScrollView r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = 3.0f;
    L5:
        r0.adjustScrollBarVisibilityDynamic(r1, r2);
    }

    public final void adjustScrollBarVisibilityDynamic(final ScrollView r4, final float r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4.setVerticalScrollBarEnabled(false);
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        r4.getViewTreeObserver().addOnGlobalLayoutListener(new ScrollViewScrollBarHelper$$ExternalSyntheticLambda0(r4, r5, r0));
        r4.setOnScrollChangeListener(new ScrollViewScrollBarHelper$$ExternalSyntheticLambda1(r4, r5, r0));
        View r3 = r4.getChildAt(0);
        if (r3 == null) goto L7;
        r3.addOnLayoutChangeListener(new ScrollViewScrollBarHelper$$ExternalSyntheticLambda2(r4, r5, r0));
        return;
    }

    /* JADX INFO: renamed from: adjustScrollBarVisibilityDynamic$lambda-1, reason: not valid java name */
    private static final void m493adjustScrollBarVisibilityDynamic$lambda1(final ScrollView r2, final float r3, final Ref.BooleanRef r4) {
        Intrinsics.checkNotNullParameter(r2, "$this_adjustScrollBarVisibilityDynamic");
        Intrinsics.checkNotNullParameter(r4, "$lastScrollBarState");
        final boolean r0 = r4.element;
        r2.post(new ScrollViewScrollBarHelper$adjustScrollBarVisibilityDynamic$lambda1$$inlined$updateScrollBarIfNeeded$1(r2, r3, r0, r4));
    }

    /* JADX INFO: renamed from: adjustScrollBarVisibilityDynamic$lambda-3, reason: not valid java name */
    private static final void m494adjustScrollBarVisibilityDynamic$lambda3(final ScrollView r0, final float r1, final Ref.BooleanRef r2, View r3, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r0, "$this_adjustScrollBarVisibilityDynamic");
        Intrinsics.checkNotNullParameter(r2, "$lastScrollBarState");
        final boolean r8 = r2.element;
        r0.post(new ScrollViewScrollBarHelper$adjustScrollBarVisibilityDynamic$lambda3$$inlined$updateScrollBarIfNeeded$1(r0, r1, r8, r2));
    }

    /* JADX INFO: renamed from: adjustScrollBarVisibilityDynamic$lambda-5, reason: not valid java name */
    private static final void m495adjustScrollBarVisibilityDynamic$lambda5(final ScrollView r0, final float r1, final Ref.BooleanRef r2, View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r0, "$this_adjustScrollBarVisibilityDynamic");
        Intrinsics.checkNotNullParameter(r2, "$lastScrollBarState");
        final boolean r12 = r2.element;
        r0.post(new ScrollViewScrollBarHelper$adjustScrollBarVisibilityDynamic$lambda5$$inlined$updateScrollBarIfNeeded$1(r0, r1, r12, r2));
    }

    private final void updateScrollBarIfNeeded(final ScrollView r1, final float r2, final boolean r3, final Function1<? super Boolean, Unit> r4) {
        r1.post(new AnonymousClass1(r1, r2, r3, r4));
    }
}
