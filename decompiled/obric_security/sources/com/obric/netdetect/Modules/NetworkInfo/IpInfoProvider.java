package com.obric.netdetect.Modules.NetworkInfo;

import android.content.Context;
import android.net.Network;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.obric.netdetect.Utils.NetDetectLog;
import com.obric.netdetect.Utils.URLUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class IpInfoProvider {
    private static final String PARSEURL = "https://ipinfo.io/json";
    private static final String TAG = "IpInfoProvider";
    private final Context mContext;
    private final Network mNetwork;

    public IpInfoProvider(Context r1, Network r2) {
        this.mContext = r1;
        this.mNetwork = r2;
    }

    public NetworkInfoResult.IpInfo getIpInfo() {
        URL r0 = URLUtils.makeURL(PARSEURL);
        if (r0 != null) goto L16;
        NetDetectLog.e(TAG, "url is invalid: https://ipinfo.io/json");
        return null;
    L16:
        HttpURLConnection r10 = (HttpURLConnection) this.mNetwork.openConnection(r0);     // Catch: Throwable -> L13
        r10.setRequestMethod(HttpMethodContrants.GET);     // Catch: Throwable -> L13
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r10.getInputStream()));     // Catch: Throwable -> L13
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L13
    L7:
        String r2 = r1.readLine();     // Catch: Throwable -> L13
        if (r2 == null) goto L10;
        r11.append(r2);     // Catch: Throwable -> L13
        goto L7
    L10:
        r1.close();     // Catch: Throwable -> L13
        JSONObject r3 = new JSONObject(r11.toString());     // Catch: Throwable -> L13
        return new NetworkInfoResult.IpInfo(r3.getString("ip"), r3.getString("country"), r3.getString(CommonKey.KEY_REGION), r3.getString("city"), r3.getString("loc"), r3.getString("org"), r3.getString("postal"), r3.getString("timezone"));
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
