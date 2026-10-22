package obric.common.ttnet;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.ttnet.ITTNetDepend;
import com.bytedance.ttnet.TTNetInit;
import com.ss.android.common.ApiConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class TTNetDependent implements ITTNetDepend {
    private static final String TTNET_SP_NAME = "tt_net_sp";
    private final Context appContext;
    private final SharedPreferences sharedPreferences;

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int checkHttpRequestException(Throwable r1, String[] r2) {
        return 0;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String executeGet(int r1, String r2) {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getApiIHostPrefix() {
        return "ib";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getAppId() {
        return 123;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getCdnHostSuffix() {
        return ".pstatp.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public ArrayList<String> getCookieFlushPathList() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getHostSuffix() {
        return ".snssdk.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getShareCookieMainDomain() {
        return ".snssdk.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isCronetPluginInstalled() {
        return false;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isPrivateApiAccessEnabled() {
        return false;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void mobOnEvent(Context r1, String r2, String r3, JSONObject r4) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void monitorLogSend(String r1, JSONObject r2) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onAppConfigUpdated(Context r1, JSONObject r2) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onColdStartFinish() {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onNetConfigUpdate(JSONObject r1, boolean r2) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onShareCookieConfigUpdated(String r1) {
    }

    public TTNetDependent(Context r3) {
        this.appContext = r3;
        this.sharedPreferences = getContext().getSharedPreferences(TTNET_SP_NAME, 0);
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Context getContext() {
        return this.appContext;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getProviderString(Context r1, String r2, String r3) {
        return this.sharedPreferences.getString(r2, r3);
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getProviderInt(Context r1, String r2, int r3) {
        return this.sharedPreferences.getInt(r2, r3);
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void saveMapToProvider(Context r3, Map<String, ?> r4) {
        SharedPreferences.Editor r2 = this.sharedPreferences.edit();     // Catch: Throwable -> L24
        if (r4 == null) goto L44;
        Iterator<Map.Entry<String, ?>> r5 = r4.entrySet().iterator();     // Catch: Throwable -> L24
    L6:
        if (r5.hasNext() == false) goto L22;
        Map.Entry<String, ?> r6 = r5.next();     // Catch: Throwable -> L24
        Object r0 = r6.getValue();     // Catch: Throwable -> L24
        if ((r0 instanceof Integer) == true) goto L9;
        if ((r0 instanceof Long) == true) goto L12;
        if ((r0 instanceof Float) == true) goto L15;
        if ((r0 instanceof Boolean) == true) goto L18;
        if ((r0 instanceof String) == false) goto L6;
        r2.putString(r6.getKey(), (String) r0);     // Catch: Throwable -> L24
        goto L6
    L18:
        r2.putBoolean(r6.getKey(), ((Boolean) r0).booleanValue());     // Catch: Throwable -> L24
        goto L6
    L15:
        r2.putFloat(r6.getKey(), ((Float) r0).floatValue());     // Catch: Throwable -> L24
        goto L6
    L12:
        r2.putLong(r6.getKey(), ((Long) r0).longValue());     // Catch: Throwable -> L24
        goto L6
    L9:
        r2.putInt(r6.getKey(), ((Integer) r0).intValue());     // Catch: Throwable -> L24
        goto L6
    L22:
        r2.commit();     // Catch: Throwable -> L24
        return;
    L44:
        return;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String[] getConfigServers() {
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com"};
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map<String, String> getHostReverseMap() {
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("ib.snssdk.com", "ib");
        r2.put("security.snssdk.com", "security");
        r2.put("isub.snssdk.com", "isub");
        r2.put("ichannel.snssdk.com", "ichannel");
        r2.put(ApiConstants.API_HOST_LOG, "log");
        r2.put(ApiConstants.API_HOST_MON, "mon");
        return r2;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map<String, String> getTTNetServiceDomainMap() {
        HashMap r3 = new HashMap();
        r3.put(TTNetInit.DOMAIN_HTTPDNS_KEY, "34.102.215.99");
        r3.put(TTNetInit.DOMAIN_NETLOG_KEY, "ttnet-sg.byteoversea.com");
        r3.put(TTNetInit.DOMAIN_HTTPDNS_KEY, "dig.bdurl.net");
        r3.put(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r3.put(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org");
        return r3;
    }
}
