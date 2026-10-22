package com.bytedance.bdinstall.c1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public class j extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedPreferences f2715c;

    public j(Context r1, SharedPreferences r2) {
        if (r1 == null) goto L7;
        this.f2714b = r1;
        this.f2715c = r2;
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }

    private SharedPreferences n(String r2) {
        if (WsConstants.KEY_DEVICE_ID.equals(r2) == true) goto L12;
        if ("install_id".equals(r2) == true) goto L12;
        if ("bd_did".equals(r2) == true) goto L12;
        return com.bytedance.bdinstall.d1.h.a(this.f2714b);
    L12:
        return this.f2715c;
    }

    private String o(String r2) {
        return n(r2).getString(r2, null);
    }

    private void p(String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = n(r2).edit();
        r1.putString(r2, r3);
        r1.apply();
    }

    @Override // com.bytedance.bdinstall.c1.d, com.bytedance.bdinstall.c1.i
    public void a(String r1, String r2) {
        p(r1, r2);
    }

    @Override // com.bytedance.bdinstall.c1.d, com.bytedance.bdinstall.c1.i
    public String b(String r1) {
        return o(r1);
    }

    @Override // com.bytedance.bdinstall.c1.d
    protected void d(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        p(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.c1.d
    protected String[] e(String r1) {
        String r0 = o(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }
}
