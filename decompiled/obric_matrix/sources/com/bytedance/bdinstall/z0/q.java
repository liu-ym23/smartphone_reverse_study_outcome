package com.bytedance.bdinstall.z0;

import android.content.Context;
import com.bytedance.bdinstall.v0;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class q extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2938e;

    q(Context r2) {
        super(true, true);
        this.f2938e = r2;
    }

    @Override // com.bytedance.bdinstall.z0.d
    protected boolean a(JSONObject r3) {
        v0.l(r3, "language", this.f2938e.getResources().getConfiguration().locale.getLanguage());
        int r2 = TimeZone.getDefault().getRawOffset() / 3600000;
        if (r2 >= (-12)) goto L6;
        r2 = -12;
    L6:
        if (r2 <= 12) goto L8;
        r2 = 12;
    L8:
        r3.put("timezone", r2);
        v0.l(r3, "region", Locale.getDefault().getCountry());
        TimeZone r4 = Calendar.getInstance().getTimeZone();
        v0.l(r3, "tz_name", r4.getID());
        r3.put("tz_offset", r4.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }
}
