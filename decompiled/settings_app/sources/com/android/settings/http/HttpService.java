package com.android.settings.http;

import android.content.Context;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.obric.olog.OLog;
import com.obric.oui.material.MaterialConfigFormatNames;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: loaded from: classes2.dex */
public final class HttpService {
    private static volatile HttpService mInstance;
    private Context mContext;
    private AsyncHttpClient mHttpClient;

    private HttpService(Context r2) {
        this.mHttpClient = new AsyncHttpClient();
        this.mContext = r2.getApplicationContext();
    }

    public static HttpService getInstance(Context r2) {
        if (mInstance != null) goto L15;
        monitor-enter(HttpService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new HttpService(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(HttpService.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public String getCaptchaUrl() {
        RequestParams r2 = new RequestParams();
        r2.put(MaterialConfigFormatNames.WIDTH, 80);
        r2.put(MonthWeekEventsView.VIEW_PARAMS_HEIGHT, 30);
        String r3 = AsyncHttpClient.getUrlWithQueryString(true, Constants.urlCaptcha, r2);
        OLog.d("luliang", "getCaptchaUrl " + r3);
        return r3;
    }
}
