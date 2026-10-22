package com.obric.oui.push;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PushQueue$Companion$instance$2 extends Lambda implements Function0<PushQueue> {
    public static final PushQueue$Companion$instance$2 b = null;

    static {
        b = new PushQueue$Companion$instance$2(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new PushQueue();
    }
}
