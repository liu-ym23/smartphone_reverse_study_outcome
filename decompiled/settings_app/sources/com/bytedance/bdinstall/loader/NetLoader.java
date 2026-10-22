package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.common.utility.NetworkUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class NetLoader extends BaseLoader {
    private final Context mApp;

    NetLoader(Context r2) {
        super(true, true);
        this.mApp = r2;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r2) throws JSONException {
        Utils.putStringIfNotEmpty(r2, Api.KEY_ACCESS, NetworkUtils.getNetworkAccessType(this.mApp));
        return true;
    }
}
