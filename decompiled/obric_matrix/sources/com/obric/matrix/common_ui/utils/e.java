package com.obric.matrix.common_ui.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u000e\u001a\u00020\u000f*\u00020\u00062#\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011\u001a-\u0010\u0016\u001a\u00020\u000f*\u00020\u00062!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f0\u0011\u001aP\u0010\u0017\u001a\u00020\u000f*\u00020\u00062!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f0\u00112!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f0\u0011\u001a-\u0010\u001a\u001a\u00020\u000f*\u00020\u00062!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f0\u0011\u001a\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0001\u001a>\u0010\u001e\u001a\u00020\u000f\"\b\b\u0000\u0010\u001f*\u00020\u0006*\u0004\u0018\u0001H\u001f2!\u0010 \u001a\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0002\u0010\"\u001a#\u0010\u001e\u001a\u00020\u000f\"\b\b\u0000\u0010\u001f*\u00020\u0006*\u0004\u0018\u0001H\u001f2\u0006\u0010#\u001a\u00020$¢\u0006\u0002\u0010%\u001a\n\u0010&\u001a\u00020\u000f*\u00020\u0006\u001a\n\u0010'\u001a\u00020\u000f*\u00020\u0006\u001a\n\u0010(\u001a\u00020\u000f*\u00020\u0006\u001a\n\u0010)\u001a\u00020**\u00020\u0006\u001a\f\u0010+\u001a\u00020**\u00020\u0006H\u0002\u001a\u0012\u0010,\u001a\u00020\u000f*\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\n\u0010.\u001a\u00020\u000f*\u00020\u0006\u001a\u001a\u0010/\u001a\u00020\u000f*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u000100\u001a\u001a\u00101\u001a\u00020\u000f*\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u000100\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"(\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\"(\u0010\u000b\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u00062"}, d2 = {"clickGapTagId", "", "lastClickTagId", "value", "", "clickGap", "Landroid/view/View;", "getClickGap", "(Landroid/view/View;)J", "setClickGap", "(Landroid/view/View;J)V", "lastClickTime", "getLastClickTime", "setLastClickTime", "applyImeInsetsAnimation", "", "callback", "Lkotlin/Function1;", "Landroidx/core/graphics/Insets;", "Lkotlin/ParameterName;", "name", "insets", "applyNavigationBarInsets", "applyStatusAndNavigationBarInsets", "statusCallback", "navigationCallback", "applyStatusBarInsets", "brief", "", "maxLen", "clickWithDebounce", "T", "onClick", "it", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "listener", "Landroid/view/View$OnClickListener;", "(Landroid/view/View;Landroid/view/View$OnClickListener;)V", "gone", "hideIme", "invisible", "isImeShowed", "", "isQuickClick", "showIme", "view", "visible", "watchOnImeInsetsAnimationEnd", "Lkotlin/Function0;", "watchOnImeInsetsAnimationEndOnce", "common_ui_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class e {
    public static final <T extends View> void a(final T r2, final l<? super T, f0> r3) {
        o.f(r3, "onClick");
        if (r2 != null) goto L5;
        return;
    L5:
        h(r2, 500);
        r2.setOnClickListener(new a(r2, r3));
    }

    private static final void b(View r0, l r1, View r2) {
        o.f(r1, "$onClick");
        if (f(r0) == true) goto L6;
        r1.invoke(r0);
        return;
    }

    private static final long c(View r2) {
        Object r3 = r2.getTag(123400001);
        if ((r3 instanceof Long) == false) goto L5;
        Long r4 = (Long) r3;
    L6:
        if (r4 != null) goto L10;
        return 500;
    L10:
        return r4.longValue();
    L5:
        r4 = null;
        goto L6
    }

    private static final long d(View r2) {
        Object r3 = r2.getTag(123400002);
        if ((r3 instanceof Long) == false) goto L5;
        Long r4 = (Long) r3;
    L6:
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.longValue();
    L5:
        r4 = null;
        goto L6
    }

    public static final void e(View r1) {
        o.f(r1, "<this>");
        r1.setVisibility(8);
    }

    private static final boolean f(View r6) {
        long r0 = System.currentTimeMillis();
        if ((r0 - d(r6)) >= c(r6)) goto L5;
        boolean r2 = true;
    L6:
        i(r6, r0);
        return r2;
    L5:
        r2 = false;
        goto L6
    }

    public static /* synthetic */ void g(View r0, l r1, View r2) {
        b(r0, r1, r2);
    }

    private static final void h(View r0, long r1) {
        r0.setTag(123400001, Long.valueOf(r1));
    }

    private static final void i(View r0, long r1) {
        r0.setTag(123400002, Long.valueOf(r1));
    }
}
