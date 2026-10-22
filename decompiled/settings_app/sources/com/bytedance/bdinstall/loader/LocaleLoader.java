package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.sremlib.LibUtil;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class LocaleLoader extends BaseLoader {
    private final Context mApp;

    LocaleLoader(Context r2) {
        super(true, true);
        this.mApp = r2;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r3) throws JSONException {
        Utils.putStringIfNotEmpty(r3, Api.KEY_LANGUAGE, this.mApp.getResources().getConfiguration().locale.getLanguage());
        int r2 = TimeZone.getDefault().getRawOffset() / LibUtil.HOUR;
        if (r2 >= (-12)) goto L6;
        r2 = -12;
    L6:
        if (r2 <= 12) goto L8;
        r2 = 12;
    L8:
        r3.put(Api.KEY_TIMEZONE, r2);
        Utils.putStringIfNotEmpty(r3, "region", Locale.getDefault().getCountry());
        TimeZone r4 = Calendar.getInstance().getTimeZone();
        Utils.putStringIfNotEmpty(r3, Api.KEY_TZ_NAME, r4.getID());
        r3.put(Api.KEY_TZ_OFFSET, r4.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }
}
