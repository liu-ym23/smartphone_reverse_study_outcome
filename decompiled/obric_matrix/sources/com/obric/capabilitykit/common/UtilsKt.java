package com.obric.capabilitykit.common;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "capabilitykitcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UtilsKt {
    private static final h gson$delegate = null;

    static {
        gson$delegate = i.b(UtilsKt$gson$2.INSTANCE);
    }

    public static final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }
}
