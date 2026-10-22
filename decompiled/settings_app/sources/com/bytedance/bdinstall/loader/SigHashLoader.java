package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.util.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class SigHashLoader extends BaseLoader {
    private final Context mApp;

    SigHashLoader(Context r3) {
        super(true, false);
        this.mApp = r3;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r4) throws JSONException {
        String r1 = null;
        PackageInfo r3 = this.mApp.getPackageManager().getPackageInfo(this.mApp.getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r3 != null) goto L9;
    L15:
        if (r1 == null) goto L21;
        r4.put(Api.KEY_SIG_HASH, r1);
        return true;
    L21:
        return true;
    L9:
        if (r3.signatures == null) goto L15;
        if (r3.signatures.length <= 0) goto L15;
        Signature r5 = r3.signatures[0];
        if (r5 == null) goto L15;
        r1 = DigestUtils.md5Hex(r5.toByteArray());
    L5:
        e = move-exception;
        DrLog.ysnp(e);
        r3 = null;
        goto L7
    }
}
