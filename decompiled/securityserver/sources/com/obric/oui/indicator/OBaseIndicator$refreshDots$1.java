package com.obric.oui.indicator;

import com.obric.oui.common.util.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OBaseIndicator$refreshDots$1 implements Runnable {
    public final /* synthetic */ OBaseIndicator b;

    public OBaseIndicator$refreshDots$1(OBaseIndicator r1) {
        this.b = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OBaseIndicator r3 = this.b;
        if (r3.u != null) goto L18;
        r3.c();
        r3.d();
        OBaseIndicator.Pager r0 = r3.u;
        if (r0 != null) goto L8;
    L9:
        OBaseIndicator.Pager r1 = r3.getPager();
        if (r1 != null) goto L12;
    L14:
        ViewExtensionsKt.e(r3);
        return;
    L12:
        if (r1.getCount() != 1) goto L14;
        r3.setVisibility(4);
        return;
    L8:
        if (r0.d() == false) goto L9;
        OBaseIndicator.Pager r2 = r3.u;
        Intrinsics.c(r2);
        r2.b();
        OCarouselIndicator$buildOnPageChangedListener$1 r4 = r3.b();
        OBaseIndicator.Pager r5 = r3.u;
        Intrinsics.c(r5);
        r5.c(r4);
        OBaseIndicator.Pager r6 = r3.u;
        Intrinsics.c(r6);
        r6.a();
        r4.a();
        throw null;
    L18:
        throw null;
    }
}
