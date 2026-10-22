package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class AppTraitLoader extends BaseLoader {
    private final Context mContext;
    private final InstallOptions mOptions;

    AppTraitLoader(Context r3, InstallOptions r4) {
        super(true, false);
        this.mContext = r3;
        this.mOptions = r4;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r4) throws JSONException, SecurityException {
        IAppTraitCallback r0 = this.mOptions.getAppTraitCallback();
        DrLog.d("IAppTraitCallback = " + r0);
        if (r0 == null) goto L7;
        String r3 = r0.get(this.mContext);
        DrLog.d("IAppTraitCallback.get = " + r3);
        r4.put("app_trait", r3);
        return true;
    L7:
        return true;
    }
}
