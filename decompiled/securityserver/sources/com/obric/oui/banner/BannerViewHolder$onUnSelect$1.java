package com.obric.oui.banner;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final /* synthetic */ class BannerViewHolder$onUnSelect$1 extends PropertyReference0Impl {
    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public final Object get() {
        ContextScope r0 = ((BannerViewHolder) this.receiver).f174d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("selectScope");
        throw null;
    }
}
