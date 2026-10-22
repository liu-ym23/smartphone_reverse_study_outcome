package com.bytedance.bdturing.ttnet;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTNetHttpClient implements b {
    private Context context;

    public TTNetHttpClient(Context r2) {
        this.context = null;
        this.context = r2;
    }

    @Override // com.bytedance.bdturing.ttnet.b
    public byte[] get(String r1, Map<String, String> r2) {
        d.b(this.context, r1, r2);
        return c.d(r1, null, null, r2);
    }

    @Override // com.bytedance.bdturing.ttnet.b
    public byte[] post(String r1, Map<String, String> r2, byte[] r3) {
        d.b(this.context, r1, r2);
        return c.e(r1, null, null, r3, r2);
    }
}
