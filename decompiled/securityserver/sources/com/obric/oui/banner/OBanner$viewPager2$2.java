package com.obric.oui.banner;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OBanner$viewPager2$2 extends Lambda implements Function0<ViewPager2> {
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ViewPager2 r1 = new ViewPager2(null);
        r1.setOffscreenPageLimit(1);
        return r1;
    }
}
