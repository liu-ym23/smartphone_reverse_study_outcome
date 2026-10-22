package com.bytedance.bdlocation.init;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.callback.BDRestrictedMode;
import com.bytedance.bdlocation.event.IEventManager;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.log.Printer;
import com.bytedance.bdlocation.network.ICustomNetworkApi;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.bytedance.mpaas.app.a;
import com.obric.matrix.r.c.c;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Locale;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class LocationInitConfig {
    private static boolean mEnableH3 = true;
    private static int mH3Distance = 1;
    private static int mH3Resolution = 7;
    private static int mLatlngPrecision = 2;
    private boolean isPrivacyConfirmed;
    private long mAppBootTime;
    private String mAppId;
    private String mAppVersion;
    private BackgroundProvider mBackgroundProvider;
    private String mBaseUrl;
    private Map<String, Object> mBpeaCerts;
    private String mChannel;
    private Context mContext;
    private boolean mDebug;
    private String mDid;
    private boolean mEnableHARCollect;
    private IEventManager mEventManager;
    private Locale mLocale;
    private int mLocateType;
    private ICustomNetworkApi mNetworkApi;
    private long mOverseaUploadInterval;
    private long mOverseaUploadMaxCount;
    private long mOverseaUploadMaxDuration;
    private boolean mOverseas;
    private String mPackageName;
    private Printer mPrinter;
    private BDRestrictedMode mRestrictedMode;
    private String mUpdateVersionCode;
    private String mWorldView;

    public static class Builder {
        private static boolean mEnableH3 = true;
        private static int mH3Distance = 1;
        private static int mH3Resolution = 7;
        private static int mLatlngPrecision = 2;
        private long mAppBootTime;
        private String mAppId;
        private String mAppVersion;
        private BackgroundProvider mBackgroundProvider;
        private String mBaseUrl;
        private Map<String, Object> mBpeaCerts;
        private String mChannel;
        private Context mContext;
        private boolean mDebug;
        private String mDid;
        private boolean mEnableHARService;
        private IEventManager mEventManager;
        private boolean mIsPrivacyConfirmed;
        private Locale mLocale;
        private int mLocateType;
        private ICustomNetworkApi mNetworkApi;
        private long mOverseaUploadInterval;
        private long mOverseaUploadMaxCount;
        private long mOverseaUploadMaxDuration;
        private boolean mOverseas;
        private String mPackageName;
        private Printer mPrinter;
        private BDRestrictedMode mRestrictedMode;
        private String mUpdateVersionCode;
        private String mWorldView;

        static {
        }

        public Builder(Application r4) {
            this.mBaseUrl = "";
            this.mDid = "";
            this.mAppId = "";
            this.mChannel = "";
            this.mAppVersion = "";
            this.mUpdateVersionCode = "";
            this.mPackageName = "";
            this.mIsPrivacyConfirmed = false;
            this.mDebug = false;
            this.mOverseas = false;
            this.mLocateType = 3;
            this.mOverseaUploadInterval = TimeUtils.SECONDS_PER_HOUR;
            this.mOverseaUploadMaxDuration = TimeUtils.SECONDS_PER_DAY;
            this.mOverseaUploadMaxCount = 7;
            this.mEnableHARService = false;
            if (r4 == null) goto L10;
            Context r0 = INVOKEVIRTUAL_com_bytedance_bdlocation_init_LocationInitConfig$Builder_com_obric_matrix_SPLancet_hookGetApplicationContext(r4);
            Context r5 = r4;
            if (r0 == null) goto L7;
            r5 = r0;
        L7:
            this.mContext = r5;
            return;
        L10:
            throw new RuntimeException("context must not be null");
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context INVOKEVIRTUAL_com_bytedance_bdlocation_init_LocationInitConfig$Builder_com_obric_matrix_SPLancet_hookGetApplicationContext(Application r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return a.a();
        }

        public LocationInitConfig build() {
            LocationInitConfig r0 = new LocationInitConfig();
            r0.setBaseUrl(this.mBaseUrl);
            r0.setRestrictedMode(this.mRestrictedMode);
            r0.setCustomNetworkApi(this.mNetworkApi);
            r0.setDid(this.mDid);
            r0.setAppId(this.mAppId);
            r0.setChannel(this.mChannel);
            r0.setAppVersion(this.mAppVersion);
            r0.setUpdateVersionCode(this.mUpdateVersionCode);
            r0.setPackageName(this.mPackageName);
            r0.setContext(this.mContext);
            r0.setPrivacyConfirmed(this.mIsPrivacyConfirmed);
            r0.setDebug(this.mDebug);
            r0.setBpeaCerts(this.mBpeaCerts);
            r0.setWorldView(this.mWorldView);
            r0.setLocale(this.mLocale);
            r0.setALogPrinter(this.mPrinter);
            r0.setOverseas(this.mOverseas);
            r0.setBackgroundProvider(this.mBackgroundProvider);
            r0.setOverseaUploadInterval(this.mOverseaUploadInterval);
            r0.setOverseaUploadMaxDuration(this.mOverseaUploadMaxDuration);
            r0.setOverseaUploadMaxCount(this.mOverseaUploadMaxCount);
            r0.setEnableH3(mEnableH3);
            r0.setLatlngPrecision(mLatlngPrecision);
            r0.setH3Resolution(mH3Resolution);
            r0.setH3Distance(mH3Distance);
            r0.setEventManager(this.mEventManager);
            r0.setLocateType(this.mLocateType);
            r0.setEnableHARCollect(this.mEnableHARService);
            r0.setAppBootTime(this.mAppBootTime);
            return r0;
        }

        public int getLocateType() {
            return this.mLocateType;
        }

        public Builder isPrivacyConfirmed(boolean r1) {
            this.mIsPrivacyConfirmed = r1;
            return this;
        }

        public Builder setALogPrinter(Printer r1) {
            this.mPrinter = r1;
            return this;
        }

        public Builder setAppBootTime(long r3) {
            Logger.i("appBootTime:" + r3);
            this.mAppBootTime = r3;
            return this;
        }

        public Builder setAppId(String r1) {
            this.mAppId = r1;
            return this;
        }

        public Builder setAppVersion(String r1) {
            this.mAppVersion = r1;
            return this;
        }

        public Builder setBackgroundProvider(BackgroundProvider r1) {
            this.mBackgroundProvider = r1;
            return this;
        }

        public Builder setBaseUrl(String r1) {
            this.mBaseUrl = r1;
            return this;
        }

        public Builder setBpeaCerts(Map<String, Object> r1) {
            this.mBpeaCerts = r1;
            return this;
        }

        public Builder setChannel(String r1) {
            this.mChannel = r1;
            return this;
        }

        public Builder setCustomNetworkApi(ICustomNetworkApi r1) {
            this.mNetworkApi = r1;
            return this;
        }

        public Builder setDebug(boolean r1) {
            this.mDebug = r1;
            return this;
        }

        public Builder setDid(String r1) {
            this.mDid = r1;
            return this;
        }

        public Builder setEnableH3(boolean r1) {
            mEnableH3 = r1;
            return this;
        }

        public Builder setEnableHARCollect(boolean r1) {
            this.mEnableHARService = r1;
            return this;
        }

        public Builder setEventManager(IEventManager r1) {
            this.mEventManager = r1;
            return this;
        }

        public Builder setH3Distance(int r1) {
            mH3Distance = r1;
            return this;
        }

        public Builder setH3Resolution(int r1) {
            mH3Resolution = r1;
            return this;
        }

        public Builder setLatlngPrecision(int r1) {
            mLatlngPrecision = r1;
            return this;
        }

        public Builder setLocal(Locale r1) {
            this.mLocale = r1;
            return this;
        }

        public Builder setLocateType(int r1) {
            this.mLocateType = r1;
            return this;
        }

        public Builder setOverseaUploadInterval(long r1) {
            this.mOverseaUploadInterval = r1;
            return this;
        }

        public Builder setOverseaUploadMaxCount(long r1) {
            this.mOverseaUploadMaxCount = r1;
            return this;
        }

        public Builder setOverseaUploadMaxDuration(long r1) {
            this.mOverseaUploadMaxDuration = r1;
            return this;
        }

        public Builder setOverseas(boolean r1) {
            this.mOverseas = r1;
            return this;
        }

        public Builder setPackageName(String r1) {
            this.mPackageName = r1;
            return this;
        }

        public Builder setRestrictedMode(BDRestrictedMode r1) {
            this.mRestrictedMode = r1;
            return this;
        }

        public Builder setUpdateVersionCode(String r1) {
            this.mUpdateVersionCode = r1;
            return this;
        }

        public Builder setWorldView(String r1) {
            this.mWorldView = r1;
            return this;
        }
    }

    static {
    }

    public LocationInitConfig() {
        this.mDid = "";
        this.mAppId = "";
        this.mChannel = "";
        this.mAppVersion = "";
        this.mUpdateVersionCode = "";
        this.mPackageName = "";
        this.mBaseUrl = "";
        this.mDebug = false;
        this.mOverseas = false;
        this.mLocateType = 3;
        this.mOverseaUploadInterval = TimeUtils.SECONDS_PER_HOUR;
        this.mOverseaUploadMaxDuration = TimeUtils.SECONDS_PER_DAY;
        this.mOverseaUploadMaxCount = 7;
        this.isPrivacyConfirmed = false;
        this.mEnableHARCollect = false;
    }

    @Nullable
    public Printer getALogPrinter() {
        return this.mPrinter;
    }

    public long getAppBootTime() {
        return this.mAppBootTime;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    @Nullable
    public BackgroundProvider getBackgroundProvider() {
        return this.mBackgroundProvider;
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    @Nullable
    public Map<String, Object> getBpeaCerts() {
        return this.mBpeaCerts;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public ICustomNetworkApi getCustomNetworkApi() {
        return this.mNetworkApi;
    }

    public boolean getDebug() {
        return this.mDebug;
    }

    public String getDid() {
        return this.mDid;
    }

    @Nullable
    public IEventManager getEventManager() {
        return this.mEventManager;
    }

    public int getH3Distance() {
        return mH3Distance;
    }

    public int getH3Resolution() {
        return mH3Resolution;
    }

    public int getLatlngPrecision() {
        return mLatlngPrecision;
    }

    @Nullable
    public Locale getLocale() {
        return this.mLocale;
    }

    public int getLocateType() {
        return this.mLocateType;
    }

    public long getOverseaUploadInterval() {
        return this.mOverseaUploadInterval;
    }

    public long getOverseaUploadMaxCount() {
        return this.mOverseaUploadMaxCount;
    }

    public long getOverseaUploadMaxDuration() {
        return this.mOverseaUploadMaxDuration;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    @Nullable
    public BDRestrictedMode getRestrictedMode() {
        return this.mRestrictedMode;
    }

    public String getUpdateVersionCode() {
        return this.mUpdateVersionCode;
    }

    @Nullable
    public String getWorldView() {
        return this.mWorldView;
    }

    public boolean isEnableH3() {
        return mEnableH3;
    }

    public boolean isEnableHARCollect() {
        return this.mEnableHARCollect;
    }

    public boolean isOverseas() {
        return this.mOverseas;
    }

    public boolean isPrivacyConfirmed() {
        return this.isPrivacyConfirmed;
    }

    public void setALogPrinter(Printer r1) {
        this.mPrinter = r1;
    }

    public void setAppBootTime(long r1) {
        this.mAppBootTime = r1;
    }

    public void setAppId(String r1) {
        this.mAppId = r1;
    }

    public void setAppVersion(String r1) {
        this.mAppVersion = r1;
    }

    public void setBackgroundProvider(BackgroundProvider r1) {
        this.mBackgroundProvider = r1;
    }

    public void setBaseUrl(String r1) {
        this.mBaseUrl = r1;
    }

    public void setBpeaCerts(Map<String, Object> r1) {
        this.mBpeaCerts = r1;
    }

    public void setChannel(String r1) {
        this.mChannel = r1;
    }

    @Nullable
    public void setContext(Context r1) {
        this.mContext = r1;
    }

    public void setCustomNetworkApi(ICustomNetworkApi r1) {
        this.mNetworkApi = r1;
    }

    public void setDebug(boolean r1) {
        this.mDebug = r1;
    }

    public void setDid(String r1) {
        this.mDid = r1;
    }

    public void setEnableH3(boolean r1) {
        mEnableH3 = r1;
    }

    public void setEnableHARCollect(boolean r1) {
        this.mEnableHARCollect = r1;
    }

    public void setEventManager(IEventManager r1) {
        this.mEventManager = r1;
    }

    public void setH3Distance(int r1) {
        mH3Distance = r1;
    }

    public void setH3Resolution(int r1) {
        mH3Resolution = r1;
    }

    public void setLatlngPrecision(int r1) {
        mLatlngPrecision = r1;
    }

    public void setLocale(Locale r1) {
        this.mLocale = r1;
    }

    public void setLocateType(int r1) {
        this.mLocateType = r1;
    }

    public void setOverseaUploadInterval(long r1) {
        this.mOverseaUploadInterval = r1;
    }

    public void setOverseaUploadMaxCount(long r1) {
        this.mOverseaUploadMaxCount = r1;
    }

    public void setOverseaUploadMaxDuration(long r1) {
        this.mOverseaUploadMaxDuration = r1;
    }

    public void setOverseas(boolean r1) {
        this.mOverseas = r1;
    }

    public void setPackageName(String r1) {
        this.mPackageName = r1;
    }

    public void setPrivacyConfirmed(boolean r1) {
        this.isPrivacyConfirmed = r1;
    }

    public void setRestrictedMode(BDRestrictedMode r1) {
        this.mRestrictedMode = r1;
    }

    public void setUpdateVersionCode(String r1) {
        this.mUpdateVersionCode = r1;
    }

    public void setWorldView(String r1) {
        this.mWorldView = r1;
    }
}
