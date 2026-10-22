package com.obric.oui.chip;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OChip$onCheckedListener$1 extends Lambda implements Function2<OChip, Boolean, Unit> {
    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        ((Boolean) r2).booleanValue();
        Intrinsics.f((OChip) r1, "<anonymous parameter 0>");
        int r0 = OChip.l;
        throw null;
    }
}
