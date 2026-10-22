package com.bytedance.bdinstall.loader;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.util.RomUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class RomLoader extends BaseLoader {
    RomLoader() {
        super(true, false);
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r3) throws JSONException {
        StringBuilder r2 = new StringBuilder(16);
        if (RomUtils.isMiui() == false) goto L6;
        r2.append("MIUI-");
    L13:
        r2.append(Build.VERSION.INCREMENTAL);
        r3.put(Api.KEY_ROM, r2.toString());
        String r4 = RomUtils.getRomInfo();
        if (TextUtils.isEmpty(r4) == true) goto L18;
        r3.put("rom_version", r4);
        return true;
    L18:
        return true;
    L6:
        if (RomUtils.isFlyme() == false) goto L8;
        r2.append("FLYME-");
        goto L13
    L8:
        String r0 = RomUtils.getEmuiInfo();
        if (RomUtils.isHwOrHonor(r0) == false) goto L13;
        r2.append("EMUI-");
        if (TextUtils.isEmpty(r0) == true) goto L13;
        r2.append(r0).append("-");
        goto L13
    }
}
