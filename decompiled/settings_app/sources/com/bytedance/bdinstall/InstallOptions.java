package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class InstallOptions {
    private static final String DEFAULT_SP_NAME = "applog_stats";
    private final IAbContext abContext;
    private Account account;
    private final IExtraParams activeExtraParam;
    private final IAdIdConfig adidConfig;
    private final int aid;
    private final String appLanguage;
    private final String appName;
    private final String appRegion;
    private final JSONObject appTrack;
    private final IAppTraitCallback appTraitCallback;
    private final boolean autoActive;
    private final String channel;
    private final boolean checkPermissionBeforeCallSensitiveApi;
    private final Map<String, Object> commonHeaders;
    private final Context context;
    private final ICustomExtraHeader customHeaders;
    private final boolean debuggable;
    private final boolean deleteSharedStorage;
    private final boolean enableListenNetChange;
    private final boolean enableOneKeyMigrateDetect;
    private final boolean encryptAndCompress;
    private final IEncryptor encryptor;
    private final IEventDepend eventDepend;
    private final String googleAid;
    private final boolean isAnonymous;
    private final boolean isDirectActive;
    private final boolean isLocalTest;
    private final boolean isMigrating;
    private final ILogger logger;
    private final AppVersionCompat mAppVersionCompat;
    private final boolean needSharedStorage;
    private final INetworkClient networkClient;
    private final IParamFilter paramFilter;
    private final PreInstallChannelCallback preInstallChannelCallback;
    private final String releaseBuild;
    private final boolean reportPhoneDetailInfo;
    private final boolean silenceInBackground;
    private SharedPreferences sp;
    private final String spFileName;
    private final ISstInfoProvider sstInfoProvider;
    private final boolean touristMode;
    private final String tweakedChannel;
    private final String userAgent;
    private final String zijiePackage;

    InstallOptions(Builder r2) {
        this.sp = null;
        this.context = r2.context;
        this.aid = r2.aid;
        if (r2.networkClient == null) goto L5;
        INetworkClient r0 = r2.networkClient;
    L6:
        this.networkClient = r0;
        if (TextUtils.isEmpty(r2.spFileName) == false) goto L9;
        String r1 = DEFAULT_SP_NAME;
    L10:
        this.spFileName = r1;
        this.zijiePackage = r2.zijiePackage;
        this.appName = r2.appName;
        this.channel = r2.channel;
        this.tweakedChannel = r2.tweakedChannel;
        this.releaseBuild = r2.releaseBuild;
        this.abContext = r2.abContext;
        this.userAgent = r2.userAgent;
        this.googleAid = r2.googleAid;
        this.appLanguage = r2.appLanguage;
        this.appRegion = r2.appRegion;
        this.appTrack = r2.appTrack;
        this.commonHeaders = r2.customInfo;
        this.customHeaders = r2.customHeaders;
        this.encryptAndCompress = r2.encryptAndCompress;
        this.isLocalTest = r2.isLocalTest;
        this.autoActive = r2.autoActive;
        this.silenceInBackground = r2.silenceInBackground;
        this.reportPhoneDetailInfo = r2.reportPhoneDetailInfo;
        this.eventDepend = r2.eventDepend;
        this.isAnonymous = r2.isAnonymous;
        this.preInstallChannelCallback = r2.preInstallChannelCallback;
        this.mAppVersionCompat = new AppVersionCompat(r2);
        this.account = r2.account;
        this.debuggable = r2.debuggable;
        this.logger = r2.logger;
        if (r2.encryptor == null) goto L13;
        IEncryptor r3 = r2.encryptor;
    L14:
        this.encryptor = r3;
        this.isMigrating = r2.isMigrating;
        this.sstInfoProvider = r2.sstInfoProvider;
        this.touristMode = r2.touristMode;
        this.appTraitCallback = r2.appTraitCallback;
        this.needSharedStorage = r2.needSharedStorage;
        this.deleteSharedStorage = r2.deleteSharedStorage;
        this.paramFilter = r2.paramFilter;
        this.adidConfig = r2.adidConfig;
        this.activeExtraParam = r2.activeExtraParam;
        this.enableOneKeyMigrateDetect = r2.enableOneKeyMigrateDetect;
        this.enableListenNetChange = r2.enableListenNetChange;
        this.checkPermissionBeforeCallSensitiveApi = r2.checkPermissionBeforeCallSensitiveApi;
        this.isDirectActive = r2.isDirectActive;
        return;
    L13:
        r3 = new IEncryptor.DefaultEncryptor();
        goto L14
    L9:
        r1 = r2.spFileName;
        goto L10
    L5:
        r0 = new DefaultClient();
        goto L6
    }

    public int getAid() {
        return this.aid;
    }

    public INetworkClient getNetworkClient() {
        return this.networkClient;
    }

    public Context getContext() {
        return this.context;
    }

    public String getZijiePackage() {
        return this.zijiePackage;
    }

    public String getVersion() {
        return this.mAppVersionCompat.getVersion();
    }

    public String getVersionMinor() {
        return this.mAppVersionCompat.getVersionMinor();
    }

    public long getVersionCode() {
        return this.mAppVersionCompat.getVersionCode();
    }

    public long getUpdateVersionCode() {
        return this.mAppVersionCompat.getUpdateVersionCode();
    }

    public long getManifestVersionCode() {
        return this.mAppVersionCompat.getManifestVersionCode();
    }

    public String getAppName() {
        return this.appName;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getTweakedChannel() {
        return this.tweakedChannel;
    }

    public String getReleaseBuild() {
        return this.releaseBuild;
    }

    public IAbContext getAbContext() {
        return this.abContext;
    }

    public String getUserAgent() {
        if (TextUtils.isEmpty(this.userAgent) == true) goto L7;
        return this.userAgent;
    L7:
        return LocalConstants.getCommonSp(this.context).getString(Api.KEY_USER_AGENT, null);
    }

    public String getGoogleAid() {
        return this.googleAid;
    }

    public String getAppLanguage() {
        if (TextUtils.isEmpty(this.appLanguage) == true) goto L7;
        return this.appLanguage;
    L7:
        return LocalConstants.getCommonSp(this.context).getString(Api.KEY_APP_LANGUAGE, null);
    }

    public String getAppRegion() {
        if (TextUtils.isEmpty(this.appRegion) == true) goto L7;
        return this.appRegion;
    L7:
        return LocalConstants.getCommonSp(this.context).getString(Api.KEY_APP_REGION, null);
    }

    public JSONObject getAppTrack() {
        JSONObject r0 = this.appTrack;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r2 = LocalConstants.getCommonSp(this.context).getString(Api.KEY_APP_TRACK, null);
        if (r2 != null) goto L11;
    L9:
        return null;
    L11:
        return new JSONObject(r2);
    }

    public Map<String, Object> getCommonHeader() {
        return this.commonHeaders;
    }

    public String getAbVersion() {
        IAbContext r0 = this.abContext;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAbVersion();
    }

    public SharedPreferences getSp() {
        if (this.sp != null) goto L6;
        this.sp = this.context.getSharedPreferences(this.spFileName, 0);
    L6:
        return this.sp;
    }

    public String getAppLanguageFromSp() {
        return getSp().getString(Api.KEY_APP_LANGUAGE, null);
    }

    public String getAppRegionFromSp() {
        return getSp().getString(Api.KEY_APP_REGION, null);
    }

    public boolean isSilenceInBackground() {
        return this.silenceInBackground;
    }

    public boolean reportPhoneDetailInfo() {
        return this.reportPhoneDetailInfo;
    }

    public Map<String, Object> getCustomHeader() {
        ICustomExtraHeader r0 = this.customHeaders;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getExtraParams();
    }

    public boolean encryptAndCompress() {
        if (isDebuggable() == true) goto L5;
        return true;
    L5:
        return this.encryptAndCompress;
    }

    public boolean isLocalTest() {
        return this.isLocalTest;
    }

    public boolean isAutoActive() {
        return this.autoActive;
    }

    public IEventDepend getEventDepend() {
        return this.eventDepend;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public PreInstallChannelCallback getPreInstallChannelCallback() {
        return this.preInstallChannelCallback;
    }

    public Account getAccount() {
        return this.account;
    }

    void setAccount(Account r1) {
        this.account = r1;
    }

    public boolean isDebuggable() {
        return this.debuggable;
    }

    public boolean isDirectActive() {
        return this.isDirectActive;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    IEncryptor getEncryptor() {
        return this.encryptor;
    }

    public String getUserUniqueId(Context r4) {
        String r3 = LocalConstants.getCommonSp(r4).getString(Api.KEY_USER_UNIQUE_ID, null);
        if (TextUtils.isEmpty(r3) == true) goto L5;
        return r3;
    L5:
        return r4.getSharedPreferences("header_custom", 0).getString(Api.KEY_USER_UNIQUE_ID, null);
    }

    public void saveConfigAfterRegister(SharedPreferences.Editor r3) {
        String r0 = getAppLanguage();
        String r2 = getAppRegion();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        r3.putString(Api.KEY_APP_LANGUAGE, r0);
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r3.putString(Api.KEY_APP_REGION, r2);
        return;
    }

    public ISstInfoProvider getSstInfoProvider() {
        return this.sstInfoProvider;
    }

    public boolean isTouristMode() {
        return this.touristMode;
    }

    public IAppTraitCallback getAppTraitCallback() {
        return this.appTraitCallback;
    }

    public boolean isNeedSharedStorage() {
        return this.needSharedStorage;
    }

    public boolean deleteSharedStorage() {
        return this.deleteSharedStorage;
    }

    public IAdIdConfig getAdIdConfig() {
        return this.adidConfig;
    }

    public IParamFilter getParamFilter() {
        return this.paramFilter;
    }

    public IExtraParams getActiveParam() {
        return this.activeExtraParam;
    }

    public boolean enableOneKeyMigrateDetect() {
        return this.enableOneKeyMigrateDetect;
    }

    public boolean isEnableListenNetChange() {
        return this.enableListenNetChange;
    }

    public boolean isCheckPermissionBeforeCallSensitiveApi() {
        return this.checkPermissionBeforeCallSensitiveApi;
    }
}
