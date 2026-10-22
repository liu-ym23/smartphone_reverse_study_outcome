package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.bytedance.bdinstall.Api;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AppKeyLoader extends BaseLoader {
    private Context mContext;

    AppKeyLoader(Context r3) {
        super(true, false);
        this.mContext = r3;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r3) throws JSONException, SecurityException {
        String r0 = this.mContext.getPackageName();
        Bundle r2 = this.mContext.getPackageManager().getApplicationInfo(r0, 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L7
        if (r2 == null) goto L13;
        r3.put(Api.KEY_APPKEY, r2.getString("UMENG_APPKEY"));     // Catch: PackageManager.NameNotFoundException -> L7
        return true;
    L13:
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }
}
