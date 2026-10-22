package com.obric.oui.sheet;

import android.view.View;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OInsetSheet$performEnterAnimation$1$anim$1 extends Lambda implements Function1<ViewPropertySpringAnimator<View>, Unit> {
    public static final OInsetSheet$performEnterAnimation$1$anim$1 b = null;

    static {
        b = new OInsetSheet$performEnterAnimation$1$anim$1(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        Intrinsics.f((ViewPropertySpringAnimator) r1, "it");
        return Unit.f330a;
    }
}
