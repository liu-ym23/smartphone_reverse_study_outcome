package com.obric.oui;

import android.content.res.Resources;
import android.icu.text.PluralRules;
import android.util.TypedValue;
import android.view.View;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: SearchAnimationHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ,\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/SearchAnimationHelper;", "", "()V", "playSearchBoxEnter", "", "searchBox", "Landroid/view/View;", "endPadding", "", "cancelBtn", PluralRules.KEYWORD_OTHER, "", "playSearchBoxExit", "initPadding", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchAnimationHelper {
    public SearchAnimationHelper() {
    }

    public final void playSearchBoxEnter(final View r12, final int r13, View r14, List<? extends View> r15) {
        Intrinsics.checkNotNullParameter(r12, "searchBox");
        Intrinsics.checkNotNullParameter(r14, "cancelBtn");
        Intrinsics.checkNotNullParameter(r15, PluralRules.KEYWORD_OTHER);
        ValueAnimatable.Builder.ofInt$default(new ValueAnimatable.Builder(), r13 + MathKt.roundToInt(TypedValue.applyDimension(1, 50, Resources.getSystem().getDisplayMetrics())), r13, AnimationSpecKt.springInt$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 8, null).onUpdate(new AnonymousClass1(r12)).onEnd(new AnonymousClass2(r12, r13)).build().start();
        ArrayList r11 = new ArrayList();
        SpreadBuilder r16 = new SpreadBuilder(3);
        r16.add(r12);
        r16.add(r14);
        r16.addSpread(r15.toArray(new View[0]));
        Iterator r17 = CollectionsKt.listOf(r16.toArray(new View[r16.size()])).iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        View r18 = (View) r17.next();
        r18.setAlpha(0.0f);
        r11.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r18, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r18.getAlpha()), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_IN_QUAD), null, 16, null));
        goto L4
    L6:
        Iterator r19 = r11.iterator();
    L8:
        if (r19.hasNext() == false) goto L10;
        PropertyAnimatable.start$default(((PropertyAnimatable.Builder) r19.next()).build(), null, null, 3, null);
        goto L8
    }

    public final void playSearchBoxExit(final View r23, int r24, View r25, List<? extends View> r26) {
        Intrinsics.checkNotNullParameter(r23, "searchBox");
        Intrinsics.checkNotNullParameter(r25, "cancelBtn");
        Intrinsics.checkNotNullParameter(r26, PluralRules.KEYWORD_OTHER);
        final int r3 = r24 + MathKt.roundToInt(TypedValue.applyDimension(1, 50, Resources.getSystem().getDisplayMetrics()));
        ValueAnimatable.Builder.ofInt$default(new ValueAnimatable.Builder(), r24, r3, AnimationSpecKt.springInt$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1, 0, 4, null), null, 8, null).onUpdate(new C02381(r23)).onEnd(new C02392(r23, r3)).build().start();
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        r5.add(r23);
        r5.add(r25);
        r5.addAll(r26);
        Iterator r0 = r5.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        View r1 = (View) r0.next();
        r1.setAlpha(1.0f);
        r4.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r1, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r1.getAlpha()), 0.2f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null, 16, null));
        goto L4
    L6:
        Iterator r2 = r4.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        PropertyAnimatable.start$default(((PropertyAnimatable.Builder) r2.next()).build(), null, null, 3, null);
        goto L8
    }
}
