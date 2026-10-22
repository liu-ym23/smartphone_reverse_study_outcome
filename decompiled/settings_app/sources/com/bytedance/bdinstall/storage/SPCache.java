package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SPCache extends Cache {
    private final Context mContext;
    private final SharedPreferences mSharedPref;

    public SPCache(Context r1, SharedPreferences r2) {
        if (r1 == null) goto L7;
        this.mContext = r1;
        this.mSharedPref = r2;
        return;
    L7:
        throw new IllegalArgumentException("context can't be null");
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String r1, String r2) {
        storeValue(r1, r2);
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String r1) {
        return getValue(r1);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected String[] getCachedStringArray(String r1) {
        String r0 = getValue(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected void cacheStringArray(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        storeValue(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    private String getValue(String r2) {
        return getSp(r2).getString(r2, null);
    }

    private void storeValue(String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = getSp(r2).edit();
        r1.putString(r2, r3);
        r1.apply();
    }

    private SharedPreferences getSp(String r2) {
        if ("device_id".equals(r2) == true) goto L12;
        if (Api.KEY_INSTALL_ID.equals(r2) == true) goto L12;
        if (Api.KEY_BD_DID.equals(r2) == true) goto L12;
        return LocalConstants.getCommonSp(this.mContext);
    L12:
        return this.mSharedPref;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r6.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        String r2 = r1.next();
        if (TextUtils.isEmpty(r2) == true) goto L6;
        SharedPreferences r3 = getSp(r2);
        SharedPreferences.Editor r4 = (SharedPreferences.Editor) r0.get(r3);
        if (r4 != null) goto L12;
        r4 = getSp(r2).edit();
        r0.put(r3, r4);
    L12:
        if (r3 == null) goto L6;
        if (r3.contains(r2) == false) goto L6;
        r4.remove(r2);
        goto L6
    L16:
        Iterator r5 = r0.entrySet().iterator();
    L18:
        if (r5.hasNext() == false) goto L20;
        ((SharedPreferences.Editor) ((Map.Entry) r5.next()).getValue()).apply();
        goto L18
    L20:
        super.clear(r6);
    }
}
