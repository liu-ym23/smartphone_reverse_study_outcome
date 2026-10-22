package com.obric.oui.indicator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBaseIndicator$setViewPager2$3 implements OBaseIndicator.Pager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OBaseIndicator$setViewPager2$3$addOnPageChangeListener$1 f234a;

    @Override // com.obric.oui.indicator.OBaseIndicator.Pager
    public final int a() {
        throw null;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.Pager
    public final void b() {
        if (this.f234a != null) goto L6;
        return;
    L6:
        throw null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.oui.indicator.OBaseIndicator$setViewPager2$3$addOnPageChangeListener$1] */
    @Override // com.obric.oui.indicator.OBaseIndicator.Pager
    public final void c(final OnPageChangeListenerHelper r2) {
        Intrinsics.f(r2, "onPageChangeListenerHelper");
        this.f234a = new OBaseIndicator$setViewPager2$3$addOnPageChangeListener$1(this, r2);
        throw null;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.Pager
    public final boolean d() {
        throw null;
    }

    @Override // com.obric.oui.indicator.OBaseIndicator.Pager
    public final int getCount() {
        throw null;
    }
}
