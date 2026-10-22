package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.intf.IParamFilter;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Builder {
    IAbContext abContext;
    Account account;
    IExtraParams activeExtraParam;
    IAdIdConfig adidConfig;
    int aid;
    String appLanguage;
    String appName;
    String appRegion;
    JSONObject appTrack;
    IAppTraitCallback appTraitCallback;
    boolean autoActive;
    String channel;
    boolean checkPermissionBeforeCallSensitiveApi;
    Context context;
    ICustomExtraHeader customHeaders;
    Map<String, Object> customInfo;
    boolean debuggable;
    boolean deleteSharedStorage;
    boolean enableListenNetChange;
    boolean enableOneKeyMigrateDetect;
    boolean encryptAndCompress;
    IEncryptor encryptor;
    IEventDepend eventDepend;
    String googleAid;
    boolean isAnonymous;
    boolean isDirectActive;
    boolean isLocalTest;
    boolean isMigrating;
    ILogger logger;
    long manifestVersionCode;
    boolean needSharedStorage;
    INetworkClient networkClient;
    IParamFilter paramFilter;
    PreInstallChannelCallback preInstallChannelCallback;
    String releaseBuild;
    boolean reportPhoneDetailInfo;
    boolean silenceInBackground;
    String spFileName;
    ISstInfoProvider sstInfoProvider;
    boolean touristMode;
    String tweakedChannel;
    long updateVersionCode;
    String userAgent;
    String version;
    long versionCode;
    String versionMinor;
    String zijiePackage;

    @Deprecated
    public Builder setAntiCheatingEnable(boolean r1) {
        return this;
    }

    public Builder() {
        this.deleteSharedStorage = true;
        this.needSharedStorage = false;
        this.reportPhoneDetailInfo = true;
        this.debuggable = false;
        this.isMigrating = true;
        this.adidConfig = new IAdIdConfig.AdIdConfig();
        this.enableOneKeyMigrateDetect = true;
        this.enableListenNetChange = true;
        this.checkPermissionBeforeCallSensitiveApi = false;
    }

    public Builder(Context r4, int r5, String r6, boolean r7) {
        this.deleteSharedStorage = true;
        this.needSharedStorage = false;
        this.reportPhoneDetailInfo = true;
        this.debuggable = false;
        this.isMigrating = true;
        this.adidConfig = new IAdIdConfig.AdIdConfig();
        this.enableOneKeyMigrateDetect = true;
        this.enableListenNetChange = true;
        this.checkPermissionBeforeCallSensitiveApi = false;
        this.context = r4;
        this.aid = r5;
        this.appName = r6;
        this.autoActive = r7;
    }

    public Builder setContext(Context r1) {
        this.context = r1;
        return this;
    }

    public Builder setAid(int r1) {
        this.aid = r1;
        return this;
    }

    public Builder setAppName(String r1) {
        this.appName = r1;
        return this;
    }

    public Builder setAutoActive(boolean r1) {
        this.autoActive = r1;
        return this;
    }

    public Builder setNetworkClient(INetworkClient r1) {
        this.networkClient = r1;
        return this;
    }

    public Builder setBDTrackerDepend(IEventDepend r1) {
        this.eventDepend = r1;
        return this;
    }

    public Builder setChannel(String r1) {
        this.channel = r1;
        return this;
    }

    public Builder setAnonymous(boolean r1) {
        this.isAnonymous = r1;
        return this;
    }

    public Builder setUpdateVersionName(String r1) {
        this.versionMinor = r1;
        return this;
    }

    public Builder setUpdateVersionCode(long r1) {
        this.updateVersionCode = r1;
        return this;
    }

    public Builder setReleaseBuild(String r1) {
        this.releaseBuild = r1;
        return this;
    }

    public Builder setAbContext(IAbContext r1) {
        this.abContext = r1;
        return this;
    }

    public Builder setDebug(boolean r1) {
        this.debuggable = r1;
        return this;
    }

    public Builder setUserAgent(String r1) {
        this.userAgent = r1;
        return this;
    }

    public Builder setAccount(Account r1) {
        this.account = r1;
        return this;
    }

    public Builder setVersionName(String r1) {
        this.version = r1;
        return this;
    }

    public Builder setVersionCode(long r1) {
        this.versionCode = r1;
        return this;
    }

    public Builder setManifestVersionCode(long r1) {
        this.manifestVersionCode = r1;
        return this;
    }

    public Builder setPreInstallChannelCallback(PreInstallChannelCallback r1) {
        this.preInstallChannelCallback = r1;
        return this;
    }

    public Builder isAb(boolean r1) {
        this.isMigrating = r1;
        return this;
    }

    @Deprecated
    public Builder setTweakedChannel(String r1) {
        this.tweakedChannel = r1;
        return this;
    }

    public Builder isMainProcess(boolean r1) {
        Utils.setIsMainProcess(r1);
        return this;
    }

    public Builder setAppLanguage(String r1) {
        this.appLanguage = r1;
        return this;
    }

    public Builder setAppRegion(String r1) {
        this.appRegion = r1;
        return this;
    }

    public Builder setAppTrack(JSONObject r1) {
        this.appTrack = r1;
        return this;
    }

    public Builder setSpFileName(String r1) {
        this.spFileName = r1;
        return this;
    }

    public Builder setZijiePackage(String r1) {
        this.zijiePackage = r1;
        return this;
    }

    public Builder setEncryptor(IEncryptor r1) {
        this.encryptor = r1;
        return this;
    }

    public Builder setGoogleAid(String r1) {
        this.googleAid = r1;
        return this;
    }

    public Builder setCustomInfo(Map<String, Object> r1) {
        this.customInfo = r1;
        return this;
    }

    public Builder setCustomHeaders(ICustomExtraHeader r1) {
        this.customHeaders = r1;
        return this;
    }

    public Builder setEncryptAndCompress(boolean r1) {
        this.encryptAndCompress = r1;
        return this;
    }

    public Builder setIsLocalTest(boolean r1) {
        this.isLocalTest = r1;
        return this;
    }

    public Builder setSilenceInBackground(boolean r1) {
        this.silenceInBackground = r1;
        return this;
    }

    public Builder setReportPhoneDetailInfo(boolean r1) {
        this.reportPhoneDetailInfo = r1;
        return this;
    }

    public Builder setDirectActive(boolean r1) {
        this.isDirectActive = r1;
        return this;
    }

    public Builder setLogger(ILogger r1) {
        this.logger = r1;
        return this;
    }

    public Builder setSSTInfoProvider(ISstInfoProvider r1) {
        this.sstInfoProvider = r1;
        return this;
    }

    public Builder setAppTraitCallback(IAppTraitCallback r1) {
        this.appTraitCallback = r1;
        return this;
    }

    public Builder setTouristMode(boolean r1) {
        this.touristMode = r1;
        return this;
    }

    public Builder needSharedStorage(boolean r1) {
        this.needSharedStorage = r1;
        return this;
    }

    public Builder needDeleteShardStorage(boolean r1) {
        this.deleteSharedStorage = r1;
        return this;
    }

    public Builder setParamFilter(IParamFilter r1) {
        this.paramFilter = r1;
        return this;
    }

    public Builder setAdIdConfig(IAdIdConfig r1) {
        if (r1 == null) goto L4;
        this.adidConfig = r1;
    L4:
        return this;
    }

    public Builder setActiveExtraParam(IExtraParams r1) {
        this.activeExtraParam = r1;
        return this;
    }

    public Builder enableOneKeyMigrateDetect(boolean r1) {
        this.enableOneKeyMigrateDetect = r1;
        return this;
    }

    public Builder enableListenNetChange(boolean r1) {
        this.enableListenNetChange = r1;
        return this;
    }

    public Builder checkPermissionBeforeCallSensitiveApi(boolean r1) {
        this.checkPermissionBeforeCallSensitiveApi = r1;
        return this;
    }

    public InstallOptions build() {
        if (this.context != null) goto L5;
    L29:
        StringBuilder r1 = new StringBuilder("parameters error:");
        if (this.context != null) goto L32;
        boolean r2 = true;
    L34:
        throw new IllegalArgumentException(r1.append(r2).append(", ").append(this.aid).append(", ").append(this.channel).toString());
    L32:
        r2 = false;
        goto L34
    L5:
        if (this.aid <= 0) goto L29;
        if (TextUtils.isEmpty(this.channel) == true) goto L29;
        if (TextUtils.isEmpty(this.appName) == true) goto L28;
        if (DrLog.debug() == true) goto L23;
        if (this.networkClient == null) goto L21;
        if (this.eventDepend != null) goto L23;
        throw new IllegalArgumentException("please set event depend");
    L21:
        throw new IllegalArgumentException("please set network client");
    L23:
        if (TextUtils.isEmpty(this.tweakedChannel) == false) goto L26;
        this.tweakedChannel = this.channel;
    L26:
        return new InstallOptions(this);
    L28:
        throw new IllegalArgumentException("appName is empty");
    }
}
