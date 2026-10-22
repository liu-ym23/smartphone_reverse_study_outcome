package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.Utils;

/* JADX INFO: loaded from: classes3.dex */
final class OaidSp {
    private static final String KEY_OAID = "oaid";
    private static final String SP_FILE = "device_register_oaid_refine";
    private final SharedPreferences sp;

    OaidSp(Context r3) {
        this.sp = r3.getSharedPreferences(SP_FILE, 0);
    }

    void save(OaidModel r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.sp.edit().putString("oaid", r2.toJson().toString()).apply();
    }

    OaidModel fetch() {
        return OaidModel.create(this.sp.getString("oaid", ""));
    }

    public void clear() {
        Utils.removeSpValues(this.sp, new String[]{"oaid"});
    }
}
