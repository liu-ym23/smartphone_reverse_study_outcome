package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.bytedance.bdinstall.util.Singleton;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
final class OnePlusOaidImpl implements OaidApi {
    private final OaidApi mFallback;
    private Singleton<Boolean> support;

    static /* synthetic */ String access$000(OnePlusOaidImpl r0, Context r1) {
        return r0.getSign(r1);
    }

    OnePlusOaidImpl() {
        this(null);
    }

    OnePlusOaidImpl(OaidApi r2) {
        this.support = new AnonymousClass1(this);
        this.mFallback = r2;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Boolean r0 = this.support.get(new Object[]{r4});
        if (this.mFallback == null) goto L12;
        if (r0.booleanValue() == true) goto L12;
        return this.mFallback.support(r4);
    L12:
        return r0.booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(final Context r5) {
        if (this.mFallback != null) goto L5;
    L8:
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r0.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String r4 = (String) new ServiceBlockBinder(r5, r0, new AnonymousClass2(this, r5)).blockFetchResult();
        OaidApi.Result r6 = new OaidApi.Result();
        r6.oaid = r4;
        return r6;
    L5:
        if (this.support.get(new Object[0]).booleanValue() == true) goto L8;
        return this.mFallback.getOaid(r5);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        if (this.mFallback != null) goto L5;
        return "OnePlus/Oppo";
    L5:
        if (this.support.get(new Object[0]).booleanValue() == false) goto L7;
        return "OnePlus/Oppo";
    L7:
        return this.mFallback.getName();
    }

    private String getSign(Context r7) {
        PackageInfo r8 = r7.getPackageManager().getPackageInfo(r7.getPackageName(), 64);     // Catch: Exception -> L7
        if (r8 == null) goto L9;
        Signature[] r9 = r8.signatures;     // Catch: Exception -> L7
    L10:
        if (r9 != null) goto L12;
    L23:
        return null;
    L12:
        if (r9.length <= 0) goto L23;
        int r0 = 0;
        byte[] r10 = r9[0].toByteArray();
        MessageDigest r1 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L21
        if (r1 == null) goto L23;
        byte[] r11 = r1.digest(r10);     // Catch: Exception -> L21
        StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L21
        int r3 = r11.length;     // Catch: Exception -> L21
    L17:
        if (r0 >= r3) goto L19;
        r2.append(Integer.toHexString((r11[r0] & 255) | 256).substring(1, 3));     // Catch: Exception -> L21
        r0 = r0 + 1;     // Catch: Exception -> L21
        goto L17
    L19:
        return r2.toString();
    L21:
        e = move-exception;
        e.printStackTrace();
    L9:
        r9 = null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}
