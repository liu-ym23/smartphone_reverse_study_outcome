package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SsWsApp implements IWsApp, Parcelable {
    public static final Parcelable.Creator<SsWsApp> CREATOR = null;
    private String appKey;
    private int channelId;
    private String extra;
    private int fPid;
    private Map<String, String> headers;
    private int mAppId;
    private int mAppVersion;
    private String mDeviceId;
    boolean mDisableFallbackWs;
    private String mInstallId;
    int mMode;
    boolean mNewPrivateProtocolEnabled;
    private int mPlatform;
    String mPrivateProtocolUrl;
    List<Integer> mServiceIdList;
    private List<String> urls;

    public static class SsWsAppBuilder {
        private int channelId;
        private Map<String, String> headers;
        private int mAppId;
        private String mAppKey;
        private int mAppVersion;
        private String mDeviceId;
        boolean mDisableFallbackWS;
        private String mExtra;
        private int mFpid;
        private String mInstallId;
        int mMode;
        boolean mNewPrivateProtocolEnabled;
        private int mPlatform;
        String mPrivateProtocolUrl;
        List<Integer> mServiceIdList;
        private List<String> urls;

        public SsWsAppBuilder() {
            this.mServiceIdList = new ArrayList();
        }

        static /* synthetic */ Map access$000(SsWsAppBuilder r0) {
            return r0.headers;
        }

        public SsWsAppBuilder setAppId(int r1) {
            this.mAppId = r1;
            return this;
        }

        public SsWsAppBuilder setDeviceId(String r1) {
            this.mDeviceId = r1;
            return this;
        }

        public SsWsAppBuilder setInstallId(String r1) {
            this.mInstallId = r1;
            return this;
        }

        public SsWsAppBuilder setAppVersion(int r1) {
            this.mAppVersion = r1;
            return this;
        }

        public SsWsAppBuilder setPlatform(int r1) {
            this.mPlatform = r1;
            return this;
        }

        public SsWsAppBuilder setExtra(String r1) {
            this.mExtra = r1;
            return this;
        }

        public SsWsAppBuilder setFPID(int r1) {
            this.mFpid = r1;
            return this;
        }

        public SsWsAppBuilder setAppKey(String r1) {
            this.mAppKey = r1;
            return this;
        }

        public SsWsApp build() {
            return new SsWsApp(this.channelId, this.mAppId, this.mDeviceId, this.mInstallId, this.urls, this.mAppVersion, this.mPlatform, this.mFpid, this.mAppKey, this.mExtra, this.mNewPrivateProtocolEnabled, this.mServiceIdList, this.mPrivateProtocolUrl, this.mMode, this.mDisableFallbackWS, this, null);
        }

        public SsWsApp buildFromJson(JSONObject r1) {
            SsWsApp r0 = new SsWsApp();
            r0.parseFromJson(r1);
            return r0;
        }

        public SsWsAppBuilder setChannelId(int r1) {
            this.channelId = r1;
            return this;
        }

        public SsWsAppBuilder setConnectUrls(List<String> r1) {
            this.urls = r1;
            return this;
        }

        public SsWsAppBuilder setHeaders(Map<String, String> r1) {
            this.headers = r1;
            return this;
        }

        public SsWsAppBuilder enableNewPrivateProtocol(boolean r1) {
            this.mNewPrivateProtocolEnabled = r1;
            return this;
        }

        public SsWsAppBuilder setServiceIdList(List<Integer> r1) {
            this.mServiceIdList = r1;
            return this;
        }

        public SsWsAppBuilder setPrivateProtocolUrl(String r1) {
            this.mPrivateProtocolUrl = r1;
            return this;
        }

        public SsWsAppBuilder setTransportMode(int r1) {
            this.mMode = r1;
            return this;
        }

        public SsWsAppBuilder disableFallbackWS(boolean r1) {
            this.mDisableFallbackWS = r1;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ SsWsApp(int r1, int r2, String r3, String r4, List r5, int r6, int r7, int r8, String r9, String r10, boolean r11, List r12, String r13, int r14, boolean r15, SsWsAppBuilder r16, AnonymousClass1 r17) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getFPID() {
        return this.fPid;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<String> getConnectUrls() {
        return this.urls;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean newPrivateProtocolEnabled() {
        return this.mNewPrivateProtocolEnabled;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<Integer> getServiceIdList() {
        return this.mServiceIdList;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getPrivateProtocolUrl() {
        return this.mPrivateProtocolUrl;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getTransportMode() {
        return this.mMode;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean disableFallbackWSEnabled() {
        return this.mDisableFallbackWs;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getAppKey() {
        return this.appKey;
    }

    protected SsWsApp() {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
    }

    private SsWsApp(int r4, int r5, String r6, String r7, List<String> r8, int r9, int r10, int r11, String r12, String r13, boolean r14, List<Integer> r15, String r16, int r17, boolean r18, SsWsAppBuilder r19) {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
        this.mAppId = r5;
        this.channelId = r4;
        this.mDeviceId = r6;
        this.mInstallId = r7;
        if (r8 == null) goto L5;
        this.urls.addAll(r8);
    L5:
        this.mAppVersion = r9;
        this.mPlatform = r10;
        this.fPid = r11;
        this.appKey = r12;
        this.extra = r13;
        if (SsWsAppBuilder.access$000(r19) == null) goto L8;
        this.headers.putAll(SsWsAppBuilder.access$000(r19));
    L8:
        this.mNewPrivateProtocolEnabled = r14;
        this.mServiceIdList = r15;
        this.mPrivateProtocolUrl = r16;
        this.mMode = r17;
        this.mDisableFallbackWs = r18;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getChannelId() {
        return this.channelId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppId() {
        return this.mAppId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getDeviceId() {
        return this.mDeviceId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getInstallId() {
        return this.mInstallId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppVersion() {
        return this.mAppVersion;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getPlatform() {
        return this.mPlatform;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public JSONObject toJson() throws JSONException {
        JSONObject r0 = new JSONObject();
        r0.put(WsConstants.KEY_CHANNEL_ID, this.channelId);
        r0.put("app_id", this.mAppId);
        r0.put("device_id", this.mDeviceId);
        r0.put("install_id", this.mInstallId);
        JSONArray r1 = new JSONArray();
        List<String> r2 = this.urls;
        if (r2 == null) goto L8;
        Iterator<String> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r1.put(r3.next());
    L8:
        r0.put("headers", Utils.mapToJson(this.headers));
        r0.put("urls", r1);
        r0.put("app_version", this.mAppVersion);
        r0.put(WsConstants.KEY_PLATFORM, this.mPlatform);
        r0.put(WsConstants.KEY_FPID, this.fPid);
        r0.put("app_kay", this.appKey);
        r0.put(WsConstants.KEY_EXTRA, this.extra);
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, this.mNewPrivateProtocolEnabled);
        JSONArray r4 = new JSONArray();
        List<Integer> r5 = this.mServiceIdList;
        if (r5 == null) goto L14;
        Iterator<Integer> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r4.put(r6.next());
    L14:
        r0.put(WsConstants.KEY_SERVICE_ID_LIST, r4);
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, this.mPrivateProtocolUrl);
        r0.put(WsConstants.KEY_TRANSPORT_MODE, this.mMode);
        r0.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, this.mDisableFallbackWs);
        return r0;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public void parseFromJson(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        this.channelId = r7.optInt(WsConstants.KEY_CHANNEL_ID);
        this.mAppId = r7.optInt("app_id");
        this.mDeviceId = r7.optString("device_id");
        this.mInstallId = r7.optString("install_id");
        this.mAppVersion = r7.optInt("app_version");
        this.mPlatform = r7.optInt(WsConstants.KEY_PLATFORM);
        this.fPid = r7.optInt(WsConstants.KEY_FPID);
        this.appKey = r7.optString("app_kay");
        this.extra = r7.optString(WsConstants.KEY_EXTRA);
        JSONArray r0 = r7.optJSONArray("urls");
        this.urls.clear();
        int r1 = 0;
        if (r0 == null) goto L9;
        int r2 = r0.length();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        this.urls.add(r0.optString(r3));
        r3 = r3 + 1;
    L9:
        this.mNewPrivateProtocolEnabled = r7.optBoolean(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        JSONArray r4 = r7.optJSONArray(WsConstants.KEY_SERVICE_ID_LIST);
        this.mServiceIdList.clear();
        if (r4 == null) goto L14;
        int r5 = r4.length();
    L12:
        if (r1 >= r5) goto L14;
        this.mServiceIdList.add(Integer.valueOf(r4.optInt(r1)));
        r1 = r1 + 1;
    L14:
        this.mPrivateProtocolUrl = r7.optString(WsConstants.KEY_PRIVATE_PROTOCOL_URL);
        this.mMode = r7.optInt(WsConstants.KEY_TRANSPORT_MODE);
        this.mDisableFallbackWs = r7.optBoolean(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        this.headers.clear();
        this.headers.putAll(Utils.jsonToMap(r7.optJSONObject("headers")));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L68:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L68;
        SsWsApp r6 = (SsWsApp) r5;
        if (this.channelId == r6.channelId) goto L14;
        return false;
    L14:
        if (this.mAppId == r6.mAppId) goto L17;
        return false;
    L17:
        if (this.mAppVersion == r6.mAppVersion) goto L20;
        return false;
    L20:
        if (this.mPlatform == r6.mPlatform) goto L23;
        return false;
    L23:
        if (this.fPid == r6.fPid) goto L26;
        return false;
    L26:
        if (this.headers.equals(r6.headers) == true) goto L28;
        return false;
    L28:
        List<String> r2 = this.urls;
        if (r2 == null) goto L34;
        if (r2.equals(r6.urls) == false) goto L35;
    L36:
        String r3 = this.extra;
        if (r3 == null) goto L42;
        if (r3.equals(r6.extra) == false) goto L43;
    L44:
        String r4 = this.mDeviceId;
        if (r4 == null) goto L50;
        if (r4.equals(r6.mDeviceId) == false) goto L51;
    L52:
        String r7 = this.mInstallId;
        if (r7 == null) goto L58;
        if (r7.equals(r6.mInstallId) == false) goto L59;
    L60:
        String r8 = this.appKey;
        if (r8 == null) goto L64;
        return r8.equals(r6.appKey);
    L64:
        if (r6.appKey != null) goto L67;
        return true;
    L67:
        return false;
    L59:
        return false;
    L58:
        if (r6.mInstallId == null) goto L60;
    L51:
        return false;
    L50:
        if (r6.mDeviceId == null) goto L52;
    L43:
        return false;
    L42:
        if (r6.extra == null) goto L44;
    L35:
        return false;
    L34:
        if (r6.urls == null) goto L36;
        goto L35
    }

    public int hashCode() {
        int r0 = this.headers.hashCode() * 31;
        List<String> r1 = this.urls;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((r0 + r3) * 31) + this.channelId) * 31;
        String r5 = this.extra;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((r4 + r6) * 31) + this.mAppId) * 31;
        String r8 = this.mDeviceId;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.mInstallId;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (((((((r10 + r12) * 31) + this.mAppVersion) * 31) + this.mPlatform) * 31) + this.fPid) * 31;
        String r14 = this.appKey;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        return r13 + r2;
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.headers.size());
        Iterator<Map.Entry<String, String>> r5 = this.headers.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r0 = r5.next();
        r3.writeString(r0.getKey());
        r3.writeString(r0.getValue());
        goto L4
    L6:
        r3.writeStringList(this.urls);
        r3.writeInt(this.channelId);
        r3.writeString(this.extra);
        r3.writeInt(this.mAppId);
        r3.writeString(this.mDeviceId);
        r3.writeString(this.mInstallId);
        r3.writeInt(this.mAppVersion);
        r3.writeInt(this.mPlatform);
        r3.writeInt(this.fPid);
        r3.writeString(this.appKey);
        r3.writeByte(this.mNewPrivateProtocolEnabled ? 1 : 0);
        r3.writeInt(this.mServiceIdList.size());
        Iterator<Integer> r6 = this.mServiceIdList.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r3.writeInt(r6.next().intValue());
        goto L8
    L10:
        r3.writeString(this.mPrivateProtocolUrl);
        r3.writeInt(this.mMode);
        r3.writeByte(this.mDisableFallbackWs ? 1 : 0);
    }

    protected SsWsApp(Parcel r7) {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
        int r0 = r7.readInt();
        this.headers = new HashMap(r0);
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.headers.put(r7.readString(), r7.readString());
        r2 = r2 + 1;
        goto L3
    L5:
        this.urls = r7.createStringArrayList();
        this.channelId = r7.readInt();
        this.extra = r7.readString();
        this.mAppId = r7.readInt();
        this.mDeviceId = r7.readString();
        this.mInstallId = r7.readString();
        this.mAppVersion = r7.readInt();
        this.mPlatform = r7.readInt();
        this.fPid = r7.readInt();
        this.appKey = r7.readString();
        if (r7.readByte() == 0) goto L8;
        boolean r3 = true;
    L9:
        this.mNewPrivateProtocolEnabled = r3;
        int r4 = r7.readInt();
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L12;
        this.mServiceIdList.add(Integer.valueOf(r7.readInt()));
        r5 = r5 + 1;
        goto L10
    L12:
        this.mPrivateProtocolUrl = r7.readString();
        this.mMode = r7.readInt();
        if (r7.readByte() == 0) goto L15;
        r1 = true;
    L15:
        this.mDisableFallbackWs = r1;
        return;
    L8:
        r3 = false;
        goto L9
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
