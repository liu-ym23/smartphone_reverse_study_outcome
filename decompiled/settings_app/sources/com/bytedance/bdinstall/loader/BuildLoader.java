package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.util.RomUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class BuildLoader extends BaseLoader {
    private final Context mContext;

    BuildLoader(Context r3) {
        super(true, false);
        this.mContext = r3;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r2) throws JSONException, SecurityException {
        r2.put("os", "Android");
        r2.put("os_version", Build.VERSION.RELEASE);
        r2.put("os_api", Build.VERSION.SDK_INT);
        if (Build.BRAND.equals("Pico") == false) goto L5;
        String r1 = RomUtils.getProductName();
    L6:
        r2.put("device_model", r1);
        r2.put("device_brand", Build.BRAND);
        r2.put("device_manufacturer", Build.MANUFACTURER);
        r2.put(Api.KEY_CPU_ABI, Build.CPU_ABI);
        return true;
    L5:
        r1 = Build.MODEL;
        goto L6
    }
}
