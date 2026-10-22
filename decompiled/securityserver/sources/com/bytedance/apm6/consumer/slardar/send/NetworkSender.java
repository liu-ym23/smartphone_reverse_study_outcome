package com.bytedance.apm6.consumer.slardar.send;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.ZstdDictManager;
import com.bytedance.apm.doctor.DoctorConstants;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.apm6.service.http.HttpRequest;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NetworkSender {
    private static final String HEADER_LEVEL = "Content-Encoding-Level";
    private static final int LEVEL = 15;
    private static final int MIN_COMPRESS_LEN = 128;
    private static final String RESPONSE_DELAY = "delay";
    private static final String RESPONSE_DOWNGRADE_RULE = "downgrade_rule";
    private static final String RESPONSE_MESSAGE = "message";
    private static final String RESPONSE_MESSAGE_DROP_DATA = "drop data";
    private static final String RESPONSE_MESSAGE_SUCCESS = "success";
    private static final String RESPONSE_REDIRECT = "redirect";
    private static final String TT_LOG_ID = "x-tt-logid";
    private static volatile int compressType;
    private static HashMap<UploadLogInfo, NetworkSender> map;
    private int channelPosition;
    private String lastChannelUrl;
    private volatile boolean moreChannelSwitch;
    private Boolean preNetworkError;
    private String redirectHost;
    private List<String> urls;
    private IZstdDict zstdDict;
    private IZstdCompress zstdService;

    static {
        map = new HashMap();
    }

    private NetworkSender(UploadLogInfo r2) {
        this.lastChannelUrl = null;
        this.urls = r2.getUrls();
    }

    private byte[] compress(byte[] r3) {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r0 = null;
        GZIPOutputStream r1 = new GZIPOutputStream(r2);     // Catch: Throwable -> L9 IOException -> L11
        r1.write(r3);     // Catch: Throwable -> L7 IOException -> L16
        IOUtils.closeQuietly(r1);
        return r2.toByteArray();
    L7:
        th = th;
        r0 = r1;
    L12:
        IOUtils.closeQuietly(r0);
        throw th;
    L14:
        IOUtils.closeQuietly(r1);
        return null;
    L11:
        r1 = null;
    L9:
        th = th;
        goto L12
    }

    private HttpRequest createRequest(String r9, byte[] r10, boolean r11) {
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap(ApmContext.getUrlParams());
        r0.put("Accept-Encoding", "gzip");
        byte[] r5 = null;
        if (r10.length > 128) goto L5;
    L36:
        if (r5 != null) goto L38;
        r5 = r10;
    L38:
        r0.put("Content-Type", "application/json; charset=utf-8");
        if (LogReportController.getInstance().isEncrypt() == false) goto L53;
        r5 = encrypt(r5);
        if (r5 == null) goto L52;
        r1.put("tt_data", "a");
        String r12 = UrlUtils.addParamsToURL(r9, r1);
        r0.put("Content-Type", "application/octet-stream;tt-data=a");
        if (ApmBaseContext.isDebugMode() == false) goto L45;
        Logger.d(Constants.TAG, "before encrypt url:" + r12);
    L45:
        LinkedList r13 = new LinkedList();
        String r8 = tryEncryptRequest(r12, r13);
        if (TextUtils.isEmpty(r8) == true) goto L49;
        r12 = r8;
    L49:
        if (ApmBaseContext.isDebugMode() == false) goto L51;
        Logger.d(Constants.TAG, "after encrypt url:" + r12);
    L51:
        r0.putAll(ListUtils.listToMap(r13));
    L54:
        r0.put("Version-Code", "1");
        if (r5 == null) goto L59;
        r10 = r5;
    L59:
        return new HttpRequest(r12, r0, r10);
    L52:
        r12 = UrlUtils.addParamsToURL(r9, r1);
        goto L54
    L53:
        r12 = UrlUtils.addParamsToURL(r9, r1);
        goto L54
    L5:
        if (r11 == false) goto L7;
    L32:
        if (r5 != null) goto L36;
        r5 = compress(r10);
        if (r5 == null) goto L36;
        r0.put("Content-Encoding", "gzip");
        goto L36
    L7:
        if (this.zstdService != null) goto L10;
        this.zstdService = (IZstdCompress) ServiceManager.getService(IZstdCompress.class);
    L10:
        if (compressType != 1) goto L17;
        IZstdCompress r14 = this.zstdService;
        if (r14 == null) goto L17;
        r5 = r14.compress(r10, 15);
        if (r5 == null) goto L32;
        r0.put("Content-Encoding", NetConst.TYPE_ZSTD);
        r0.put(HEADER_LEVEL, String.valueOf(15));
    L17:
        if (compressType != 2) goto L32;
        if (this.zstdService == null) goto L32;
        if (this.zstdDict != null) goto L23;
        this.zstdDict = (IZstdDict) ServiceManager.getService(IZstdDict.class);
    L23:
        IZstdDict r15 = this.zstdDict;
        if (r15 == null) goto L26;
        r5 = this.zstdService.compress(r10, r15, 15);
    L26:
        if (r5 == null) goto L32;
        r0.put("Content-Encoding", NetConst.TYPE_ZSTD_DICT);
        r0.put(HEADER_LEVEL, String.valueOf(15));
        IZstdDict r16 = this.zstdDict;
        if ((r16 instanceof ZstdDictManager) == false) goto L32;
        String r17 = ((ZstdDictManager) r16).getDictVersion();
        if (TextUtils.isEmpty(r17) == true) goto L32;
        r0.put(ZstdDictManager.DICT_VERSION_HEADER_KEY, r17);
        r1.put(ZstdDictManager.DICT_VERSION_HEADER_KEY, r17);
        goto L32
    }

    private String decodeData(byte[] r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L16;
        return "";
    L16:
        SecretKeySpec r2 = new SecretKeySpec(r4.getBytes(), "AES");     // Catch: Throwable -> L9
        Cipher r5 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Throwable -> L9
        r5.init(2, r2);     // Catch: Throwable -> L9
        String r6 = new String(r5.doFinal(Base64.decode(r3, 0)));     // Catch: Throwable -> L9
        int r7 = r6.indexOf("$");     // Catch: Throwable -> L9
        if (r7 == (-1)) goto L11;
        return r6.substring(0, r7);
    L11:
        return r6;
    L9:
        th = move-exception;
        if (ApmBaseContext.isDebugMode() == false) goto L15;
        Logger.e(Constants.TAG, "decodeData", th);
    L15:
        return "";
    }

    private byte[] encrypt(byte[] r1) {
        IEncrypt r0 = (IEncrypt) ServiceManager.getService(IEncrypt.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.encrypt(r1);
    }

    private JSONObject getData(HttpResponse r8) {
        JSONObject r3 = new JSONObject(new String(r8.getResponseBytes()));     // Catch: Exception -> L25
        Map<String, String> r9 = r8.getHeaders();     // Catch: Exception -> L25
        if (r9 != null) goto L6;
    L11:
        String r4 = null;
    L26:
        String r10 = r3.optString("data");     // Catch: Throwable -> L23
        boolean r6 = true;
        if (r10.isEmpty() == false) goto L15;
    L18:
        handleResponse(r3);     // Catch: Throwable -> L23
        if (r6 == true) goto L22;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L23
        r7.put("message", "success");     // Catch: Throwable -> L23
        return r7;
    L22:
        return r3;
    L15:
        if (TextUtils.isEmpty(r4) == true) goto L17;
        String r11 = decodeData(r10.getBytes(), r4);     // Catch: Throwable -> L23
        r3 = new JSONObject(r11);     // Catch: Throwable -> L23
        r6 = true ^ TextUtils.isEmpty(r11);     // Catch: Throwable -> L23
        goto L18
    L17:
        r3 = new JSONObject(new String(r10.getBytes()));     // Catch: Throwable -> L23
    L23:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L25
        r12.put("message", "success");     // Catch: Exception -> L25
        return r12;
    L6:
        if (r9.isEmpty() == true) goto L11;
        r4 = r9.get("ran");     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r4) == false) goto L26;
        r4 = r9.get(CommonConsts.KEY_DECODE_RAN);     // Catch: Exception -> L25
    L25:
        return null;
    }

    public static NetworkSender getInstance(UploadLogInfo r2) {
        if (map.containsKey(r2) == true) goto L5;
        map.put(r2, new NetworkSender(r2));
        return map.get(r2);
    L5:
        return map.get(r2);
    }

    private String getReportUrl() {
        List<String> r1 = this.urls;
        if (TextUtils.isEmpty(this.redirectHost) == true) goto L13;
        if (r1 != null) goto L7;
    L11:
        return null;
    L7:
        if (r1.size() <= 0) goto L11;
        return "https://" + this.redirectHost + new URL(r1.get(0)).getPath();
    L13:
        if (TextUtils.isEmpty(this.lastChannelUrl) == true) goto L17;
        return this.lastChannelUrl;
    L17:
        if (this.moreChannelSwitch == false) goto L19;
        this.channelPosition++;
    L19:
        int r0 = r1.size();
        int r2 = this.channelPosition;
        if (r0 <= r2) goto L23;
        if (r2 < 0) goto L23;
        return r1.get(r2);
    L23:
        this.channelPosition = 0;
        return r1.get(0);
    }

    private void handleResponse(JSONObject r1) {
        if (JsonUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        JSONObject r0 = r1.optJSONObject(Constants.KEY_CONFIG);
        if (JsonUtils.isEmpty(r0) == false) goto L8;
        return;
    L8:
        SlardarResponseService r2 = (SlardarResponseService) ServiceManager.getService(SlardarResponseService.class);
        if (r2 == null) goto L12;
        r2.onResponse(r0);
        return;
    }

    public static void restart() {
        map.clear();
    }

    public static void setCompressType(int r0) {
        compressType = r0;
    }

    private String tryEncryptRequest(String r1, List<Pair<String, String>> r2) {
        EncryptService r0 = (EncryptService) ServiceManager.getService(EncryptService.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.tryEncryptRequest(r1, r2);
    }

    private void updateZstdHost(String r2) {
        if (this.zstdDict != null) goto L6;
        this.zstdDict = (IZstdDict) ServiceManager.getService(IZstdDict.class);
    L6:
        if (this.zstdDict == null) goto L12;
        URL r0 = new URL(r2);     // Catch: MalformedURLException -> L9
        this.zstdDict.setDomain(r0.getHost());     // Catch: MalformedURLException -> L9
        return;
    L13:
        return;
    }

    public boolean sendLog(byte[] r15) {
        if (r15 != null) goto L5;
    L90:
        return true;
    L5:
        if (r15.length == 0) goto L90;
        String r5 = getReportUrl();     // Catch: Throwable -> L11
        updateZstdHost(r5);     // Catch: Throwable -> L11
        HttpRequest r6 = createRequest(r5, r15, false);     // Catch: Throwable -> L11
        if (ApmBaseContext.isDebugMode() == false) goto L13;
        Logger.d(Constants.TAG, "sendLog createRequest: origin Bytes=" + r15.length + " compressed Bytes=" + r6.data.length + " url=" + r6.url + " headers=" + r6.headerMap + " body:" + new String(r15));     // Catch: Throwable -> L11
    L13:
        HttpResponse r2 = ApmContext.doPost(r6.url, r6.headerMap, r6.data);     // Catch: Throwable -> L11
        if (ApmBaseContext.isDebugMode() == false) goto L20;
        String r7 = Constants.TAG;     // Catch: Throwable -> L11
        StringBuilder r8 = new StringBuilder("http result:");     // Catch: Throwable -> L11
        if (r2 != null) goto L18;
        Object r1 = -1;     // Catch: Throwable -> L11
    L19:
        r8.append(r1);     // Catch: Throwable -> L11
        Logger.d(r7, r8.toString());     // Catch: Throwable -> L11
        goto L20
    L18:
        r1 = r2.getStatusCode() + " header:" + r2.getHeaders();     // Catch: Throwable -> L11
    L20:
        this.redirectHost = null;     // Catch: Throwable -> L11
        this.lastChannelUrl = null;     // Catch: Throwable -> L11
        if (r2 != null) goto L23;
    L81:
        this.moreChannelSwitch = true;     // Catch: Throwable -> L11
        Boolean r16 = this.preNetworkError;     // Catch: Throwable -> L11
        if (r16 != null) goto L84;
    L86:
        this.preNetworkError = Boolean.TRUE;     // Catch: Throwable -> L11
        return false;
    L84:
        if (r16.booleanValue() == false) goto L86;
        LogReportController.getInstance().shortBackOff();     // Catch: Throwable -> L11
        goto L86
    L23:
        if (r2.getStatusCode() <= 0) goto L81;
        this.moreChannelSwitch = false;     // Catch: Throwable -> L11
        if (500 <= r2.getStatusCode()) goto L28;
    L36:
        JSONObject r3 = getData(r2);     // Catch: Throwable -> L11
        if (r3 != null) goto L39;
    L79:
        this.preNetworkError = Boolean.TRUE;     // Catch: Throwable -> L11
        return false;
    L39:
        if (r2.getStatusCode() != 200) goto L79;
        String r9 = r3.optString("message");     // Catch: Throwable -> L11
        String r10 = r3.optString("redirect");     // Catch: Throwable -> L11
        long r11 = r3.optLong("delay");     // Catch: Throwable -> L11
        if ("success".equals(r9) == false) goto L44;
        LogReportController.getInstance().restore();     // Catch: Throwable -> L11
        this.lastChannelUrl = r5;     // Catch: Throwable -> L11
        this.preNetworkError = Boolean.FALSE;     // Catch: Throwable -> L11
        boolean r0 = true;
        boolean r12 = false;
    L94:
    L60:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
    L66:
        JSONObject r17 = r3.optJSONObject(RESPONSE_DOWNGRADE_RULE);     // Catch: Throwable -> L11
        if (r17 == null) goto L69;
        DowngradeController.getInstance().setDowngradeInfo(DowngradeInfo.parse(r17), true);     // Catch: Throwable -> L11
    L69:
        this.redirectHost = r10;     // Catch: Throwable -> L11
        if (r11 <= 0) goto L72;
        LogReportController.getInstance().delayReport(r11);     // Catch: Throwable -> L11
    L72:
        if (r12 == false) goto L77;
        LogReportController.getInstance().dropData();     // Catch: Throwable -> L11
        if (r2.getHeaders() == null) goto L76;
        DropDataMonitor.getInstance().setServerLogId(r2.getHeaders().get("x-tt-logid"));     // Catch: Throwable -> L11
    L76:
        DropDataMonitor.getInstance().setServerTimeStamp(System.currentTimeMillis());     // Catch: Throwable -> L11
    L78:
        return r0;
    L77:
        LogReportController.getInstance().recoveryFromDropData();     // Catch: Throwable -> L11
        goto L78
    L49:
        if (ApmBaseContext.isDebugMode() == false) goto L66;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L60
        r13.put(DoctorConstants.RESPONSE_DATA_URL, r6.url);     // Catch: Throwable -> L60
        if (r2.getHeaders() == null) goto L63;
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L60
        Iterator<Map.Entry<String, String>> r18 = r2.getHeaders().entrySet().iterator();     // Catch: Throwable -> L60
    L54:
        if (r18.hasNext() == false) goto L62;
        Map.Entry<String, String> r19 = r18.next();     // Catch: Throwable -> L60
        if (r19.getKey() == null) goto L54;
        r14.put(r19.getKey(), r19.getValue());     // Catch: Throwable -> L91
        goto L54
    L62:
        r13.put(DoctorConstants.RESPONSE_DATA_HEADERS, r14);     // Catch: Throwable -> L60
    L63:
        r13.put(DoctorConstants.RESPONSE_DATA_BODY_TEXT, r3);     // Catch: Throwable -> L60
        DoctorDataUtil.sendResponseEvent(r15, r13);     // Catch: Throwable -> L60
    L44:
        this.preNetworkError = Boolean.TRUE;     // Catch: Throwable -> L11
        r12 = "drop data".equals(r9);     // Catch: Throwable -> L11
        if (ApmBaseContext.isDebugMode() == false) goto L47;
        Logger.d(Constants.TAG, "responseMessage:" + r9);     // Catch: Throwable -> L11
    L47:
        r0 = false;
        goto L94
    L28:
        if (r2.getStatusCode() > 600) goto L36;
        Boolean r110 = this.preNetworkError;     // Catch: Throwable -> L11
        if (r110 != null) goto L32;
    L34:
        this.preNetworkError = Boolean.TRUE;     // Catch: Throwable -> L11
        return false;
    L32:
        if (r110.booleanValue() == false) goto L34;
        LogReportController.getInstance().longBackOff();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Logger.e(Constants.TAG, "sendLog failed.", th);
        return false;
    }
}
