package com.bytedance.privacy.pcc.h.b;

import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.m;
import com.google.gson.o;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5427a;

    private a(String r1) {
        this.f5427a = r1;
    }

    public static a b(String r3) {
        m r4 = o.c(r3).c();
        int r0 = r4.v("code").a();
        if (r0 != 0) goto L7;
        return new a(o.c(new String(Base64.decode(r4.x("data").v(WsConstants.KEY_PAYLOAD).l(), 8), StandardCharsets.UTF_8)).c().v("nonce").l());
    L7:
        throw new Exception("unexpected server code=" + r0);
    }

    public String a() {
        return this.f5427a;
    }
}
