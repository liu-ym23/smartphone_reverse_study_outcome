package com.obric.securitycenter.nodisturb.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: XmlUniversalUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.securitycenter.nodisturb.utils.FixedPathXmlUtils$Companion", f = "XmlUniversalUtils.kt", i = {}, l = {210}, m = "batchParseFixedPathFile", n = {}, s = {})
final class FixedPathXmlUtils$Companion$batchParseFixedPathFile$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FixedPathXmlUtils.Companion this$0;

    FixedPathXmlUtils$Companion$batchParseFixedPathFile$1(FixedPathXmlUtils.Companion r1, Continuation<? super FixedPathXmlUtils$Companion$batchParseFixedPathFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.batchParseFixedPathFile(null, null, null, 0, null, null, null, null, this);
    }
}
