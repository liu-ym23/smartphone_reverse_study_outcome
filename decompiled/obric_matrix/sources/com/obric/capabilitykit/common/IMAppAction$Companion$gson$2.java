package com.obric.capabilitykit.common;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.n0.c.a;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class IMAppAction$Companion$gson$2 extends q implements a<Gson> {
    public static final IMAppAction$Companion$gson$2 INSTANCE = null;

    static {
        INSTANCE = new IMAppAction$Companion$gson$2();
    }

    IMAppAction$Companion$gson$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.n0.c.a
    public final Gson invoke() {
        return new Gson();
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ Gson invoke() {
        return invoke();
    }
}
