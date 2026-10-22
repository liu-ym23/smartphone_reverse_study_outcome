package com.obric.oui.banner;

import androidx.viewpager2.widget.CompositePageTransformer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OBanner$compositePageTransformer$2 extends Lambda implements Function0<CompositePageTransformer> {
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        CompositePageTransformer r1 = new CompositePageTransformer();
        r1.addTransformer(new OFadingPageTransformer());
        return r1;
    }
}
