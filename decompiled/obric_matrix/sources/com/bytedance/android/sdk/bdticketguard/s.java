package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class s extends k0<d0> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f1063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f1064e;

    public s(String r9, boolean r10, d0 r11, List<? extends Pair<String, String>> r12) {
        kotlin.n0.d.o.g(r9, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.n0.d.o.g(r11, "providerRequestContent");
        kotlin.n0.d.o.g(r12, "responseHeaders");
        super(r11, r12, 0, 4, null);
        this.f1063d = r9;
        this.f1064e = r10;
    }

    public final boolean d() {
        return this.f1064e;
    }

    public final String e() {
        return this.f1063d;
    }
}
