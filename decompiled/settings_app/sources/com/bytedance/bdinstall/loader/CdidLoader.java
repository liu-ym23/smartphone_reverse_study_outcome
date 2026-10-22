package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.Cdid;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class CdidLoader extends BaseLoader {
    private final Context mContext;

    CdidLoader(Context r2) {
        super(true, true);
        this.mContext = r2;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r2) throws JSONException, SecurityException {
        String r1 = Cdid.get(this.mContext);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        r2.put(Cdid.KEY_CDID, r1);
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public void remove(JSONObject r1) {
        super.remove(r1);
        r1.remove(Cdid.KEY_CDID);
    }
}
