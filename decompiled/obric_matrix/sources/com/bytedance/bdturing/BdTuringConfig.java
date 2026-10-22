package com.bytedance.bdturing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.bytedance.ttnet.TTNetInit;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BdTuringConfig {
    public static final int DEFAULT_EVENT_COUNT = 6000;
    private static final int MAX_LOCAL_PARAMS = 2;
    private static final int OS_TYPE = 0;
    private static final String TAG = "BdTuringConfig";
    private f bdTuringDepend;
    private d eventClient;
    private com.bytedance.bdturing.ttnet.b httpClient;
    private String mAppId;
    private com.bytedance.bdturing.a mAppInfoProvider;
    private String mAppKey;
    private String mAppName;
    private String mAppVersion;
    private String mAppVersionCode;
    private boolean mBypassBdTuring;
    private int mChallengeCode;
    private String mChannel;
    private Context mContext;
    private final com.bytedance.bdturing.x.c mContextHolder;
    private JSONObject mDOWNSMSTheme;
    private String mDeviceBrand;
    private String mDeviceId;
    private String mDeviceModel;
    private JSONObject mECAFTheme;
    private JSONObject mEMAILTheme;
    private int mEmailDigits;
    private boolean mEnableTTNetProcessor;
    private boolean mFullScreen;
    private JSONObject mIDENTIFYTheme;
    private JSONObject mIMGTheme;
    private JSONObject mINFOVERIFYTheme;
    private com.bytedance.bdturing.identityverify.a mIdentityVerifyDepend;
    private boolean mInjectHeader;
    private String mInstallId;
    private String mLanguage;
    private String mLocale;
    private boolean mMaskCancel;
    private String mOpenUdid;
    private String mOsName;
    private String mOsVersion;
    private JSONObject mPASSWORDTheme;
    private JSONObject mQATheme;
    private c mRegionType;
    private String mRiskInfo;
    private JSONObject mSMARTERTheme;
    private JSONObject mSMSTheme;
    private JSONObject mSMSVOICETheme;
    private String mScene;
    private String mSdkVersion;
    private com.bytedance.bdturing.v.f mServiceInterceptor;
    private String mSessionId;
    private boolean mShowToastSuccess;
    private int mSmsDigits;
    private com.bytedance.bdturing.w.c mThemeConfig;
    private ConcurrentHashMap<Integer, JSONObject> mThemeMap;
    private JSONObject mUPSMSTheme;
    private JSONObject mVOICETheme;
    private HashMap<Integer, Pair<String, String>> testConfig;
    private String ticket;
    private com.bytedance.bdturing.twiceverify.b twiceVerifyDepend;

    static /* synthetic */ class a {
    }

    public static class b {
        private com.bytedance.bdturing.x.c A;
        private com.bytedance.bdturing.a B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f2998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f3000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f3001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f3002e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f3003f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f3004g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f3005h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Context f3006i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f3007j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f3008k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f3009l;
        private boolean m;
        private boolean n;
        private d o;
        private com.bytedance.bdturing.ttnet.b p;
        private com.bytedance.bdturing.twiceverify.b q;
        private String r;
        private String s;
        private f t;
        private int u;
        private int v;
        private com.bytedance.bdturing.v.f w;
        private boolean x;
        private boolean y;
        private com.bytedance.bdturing.identityverify.a z;

        public b() {
            this.f2998a = c.f3010g;
            this.f3003f = "";
            this.f3005h = "";
            this.m = true;
            this.n = true;
            this.x = true;
            this.y = false;
            this.u = 6;
            this.v = 4;
        }

        static /* synthetic */ String A(b r0) {
            return r0.r;
        }

        static /* synthetic */ d B(b r0) {
            return r0.o;
        }

        @Nullable
        private Application J(Context r3) {
            if (r3 != null) goto L5;
        L16:
            return null;
        L5:
            if ((r3 instanceof Application) == false) goto L9;
            return (Application) r3;
        L9:
            if ((r3 instanceof Activity) == false) goto L13;
            return ((Activity) r3).getApplication();
        L13:
            if ((r3 instanceof ContextWrapper) == false) goto L16;
            return J(((ContextWrapper) r3).getBaseContext());
        }

        private void K(Context r2) {
            if (r2 == null) goto L7;
            Application r3 = J(r2);
            if (r3 == null) goto L8;
            this.A = new com.bytedance.bdturing.x.c(r3);
            return;
        L8:
            return;
        }

        static /* synthetic */ c a(b r0) {
            return r0.f2998a;
        }

        static /* synthetic */ String b(b r0) {
            return r0.f2999b;
        }

        static /* synthetic */ com.bytedance.bdturing.ttnet.b c(b r0) {
            return r0.p;
        }

        static /* synthetic */ com.bytedance.bdturing.twiceverify.b d(b r0) {
            return r0.q;
        }

        static /* synthetic */ int e(b r0) {
            return r0.v;
        }

        static /* synthetic */ int f(b r0) {
            return r0.u;
        }

        static /* synthetic */ f g(b r0) {
            return r0.t;
        }

        static /* synthetic */ String h(b r0) {
            return r0.f3007j;
        }

        static /* synthetic */ String i(b r0) {
            return r0.f3008k;
        }

        static /* synthetic */ String j(b r0) {
            return r0.f3009l;
        }

        static /* synthetic */ String k(b r0) {
            return r0.s;
        }

        static /* synthetic */ Context l(b r0) {
            return r0.f3006i;
        }

        static /* synthetic */ String m(b r0) {
            return r0.f3000c;
        }

        static /* synthetic */ boolean n(b r0) {
            return r0.m;
        }

        static /* synthetic */ boolean o(b r0) {
            return r0.n;
        }

        static /* synthetic */ com.bytedance.bdturing.v.f p(b r0) {
            return r0.w;
        }

        static /* synthetic */ boolean q(b r0) {
            return r0.x;
        }

        static /* synthetic */ boolean r(b r0) {
            return r0.y;
        }

        static /* synthetic */ com.bytedance.bdturing.x.c s(b r0) {
            return r0.A;
        }

        static /* synthetic */ com.bytedance.bdturing.a t(b r0) {
            return r0.B;
        }

        static /* synthetic */ com.bytedance.bdturing.identityverify.a u(b r0) {
            return r0.z;
        }

        static /* synthetic */ String v(b r0) {
            return r0.f3001d;
        }

        static /* synthetic */ String w(b r0) {
            return r0.f3002e;
        }

        static /* synthetic */ String x(b r0) {
            return r0.f3003f;
        }

        static /* synthetic */ String y(b r0) {
            return r0.f3004g;
        }

        static /* synthetic */ String z(b r0) {
            return r0.f3005h;
        }

        public b C(String r1) {
            this.f2999b = r1;
            return this;
        }

        public b D(String r1) {
            this.f3001d = r1;
            return this;
        }

        public b E(String r1) {
            this.f3004g = r1;
            return this;
        }

        public b F(String r1) {
            this.f3005h = r1;
            return this;
        }

        public BdTuringConfig G(Context r2) {
            this.f3006i = r2;
            K(r2);
            return new BdTuringConfig(this, null);
        }

        public b H(String r1) {
            this.f3002e = r1;
            return this;
        }

        public b I(d r1) {
            this.o = r1;
            return this;
        }

        public b L(String r1) {
            this.f3000c = r1;
            return this;
        }

        public b M(int r1) {
            this.v = r1;
            return this;
        }

        public b N(com.bytedance.bdturing.twiceverify.b r1) {
            this.q = r1;
            return this;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f3010g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f3011h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f3012i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final c f3013j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final c f3014k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final /* synthetic */ c[] f3015l = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f3016f;

        static {
            c r0 = new c("REGION_CN", 0, "cn");
            f3010g = r0;
            c r1 = new c("REGION_SINGAPOER", 1, "sg");
            f3011h = r1;
            c r3 = new c("REGION_USA_EAST", 2, "va");
            f3012i = r3;
            c r5 = new c("REGION_INDIA", 3, "in");
            f3013j = r5;
            c r7 = new c("REGION_BOE", 4, TTNetInit.DOMAIN_BOE_KEY);
            f3014k = r7;
            f3015l = new c[]{r0, r1, r3, r5, r7};
        }

        private c(String r1, int r2, String r3) {
            super(r1, r2);
            this.f3016f = r3;
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f3015l.clone();
        }

        public String a() {
            return this.f3016f;
        }
    }

    private BdTuringConfig(b r10) {
        this.mSdkVersion = "3.2.0.cn";
        this.mAppVersionCode = "";
        this.mOsName = "android";
        this.mOsVersion = "" + Build.VERSION.SDK_INT;
        String r1 = Build.BRAND;
        this.mDeviceBrand = r1;
        String r2 = Build.MODEL;
        this.mDeviceModel = r2;
        this.testConfig = new HashMap();
        this.mQATheme = null;
        this.mSMSTheme = null;
        this.mIMGTheme = null;
        this.mIDENTIFYTheme = null;
        this.mSMARTERTheme = null;
        this.mUPSMSTheme = null;
        this.mDOWNSMSTheme = null;
        this.mPASSWORDTheme = null;
        this.mECAFTheme = null;
        this.mINFOVERIFYTheme = null;
        this.mEMAILTheme = null;
        this.mVOICETheme = null;
        this.mSMSVOICETheme = null;
        this.mThemeMap = new ConcurrentHashMap();
        this.ticket = null;
        this.mRiskInfo = null;
        this.mFullScreen = true;
        this.mScene = null;
        this.mShowToastSuccess = false;
        this.bdTuringDepend = null;
        this.mRegionType = b.a(r10);
        this.mAppId = b.b(r10);
        this.mLanguage = b.m(r10);
        this.mAppName = b.v(r10);
        this.mChannel = b.w(r10);
        this.mAppKey = b.x(r10);
        this.mAppVersion = b.y(r10);
        this.mAppVersionCode = b.z(r10);
        Locale r3 = Locale.getDefault();
        if (TextUtils.isEmpty(b.A(r10)) == false) goto L5;
        String r4 = r3.toString();
    L6:
        this.mLocale = r4;
        this.eventClient = b.B(r10);
        this.httpClient = b.c(r10);
        this.twiceVerifyDepend = b.d(r10);
        this.mSmsDigits = b.e(r10);
        this.mEmailDigits = b.f(r10);
        this.bdTuringDepend = b.g(r10);
        if (TextUtils.isEmpty(b.A(r10)) == false) goto L21;
        String r5 = this.mLocale;
        if (r5 == null) goto L21;
        String[] r6 = r5.split("_");
        if (r6 == null) goto L21;
        if (r6.length <= 2) goto L21;
        this.mLocale = r6[0] + "_" + r6[1];
    L21:
        this.mDeviceBrand = URLEncoder.encode(r1, "utf-8");     // Catch: UnsupportedEncodingException -> L17
        this.mDeviceModel = URLEncoder.encode(r2, "utf-8");     // Catch: UnsupportedEncodingException -> L17
    L19:
        this.mInstallId = b.h(r10);
        this.mDeviceId = b.i(r10);
        this.mSessionId = b.j(r10);
        this.mOpenUdid = b.k(r10);
        this.mContext = b.l(r10);
        this.mMaskCancel = b.n(r10);
        this.mInjectHeader = b.o(r10);
        this.mServiceInterceptor = b.p(r10);
        this.mEnableTTNetProcessor = b.q(r10);
        this.mBypassBdTuring = b.r(r10);
        this.mContextHolder = b.s(r10);
        b.t(r10);
        this.mIdentityVerifyDepend = b.u(r10);
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L5:
        r4 = b.A(r10);
        goto L6
    }

    /* synthetic */ BdTuringConfig(b r1, a r2) {
        this(r1);
    }

    public void enableTTNetProcessor(boolean r1) {
        this.mEnableTTNetProcessor = r1;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public com.bytedance.bdturing.a getAppInfoProvider() {
        return this.mAppInfoProvider;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getAppVersionCode() {
        if (TextUtils.isEmpty(this.mAppVersionCode) == false) goto L7;
        return "";
    L7:
        return this.mAppVersionCode;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    @Deprecated
    public int getChallengeCode() {
        return this.mChallengeCode;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public com.bytedance.bdturing.x.c getContextHolder() {
        return this.mContextHolder;
    }

    @Deprecated
    public String getDeviceBrand() {
        return this.mDeviceBrand;
    }

    public String getDeviceId() {
        String r0 = this.mDeviceId;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        com.bytedance.bdturing.a r2 = this.mAppInfoProvider;
        if (r2 == null) goto L7;
        String r3 = r2.a();
    L9:
        return r3;
    L7:
        r3 = "";
        goto L9
    L10:
        return r0;
    }

    @Deprecated
    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    public int getEmailDigits() {
        return this.mEmailDigits;
    }

    public d getEventClient() {
        return this.eventClient;
    }

    @Deprecated
    public boolean getFullScreen() {
        return this.mFullScreen;
    }

    public com.bytedance.bdturing.ttnet.b getHttpClient() {
        return this.httpClient;
    }

    public com.bytedance.bdturing.identityverify.a getIdentityVerifyDepend() {
        if (this.mIdentityVerifyDepend != null) goto L9;
        this.mIdentityVerifyDepend = (com.bytedance.bdturing.identityverify.a) Class.forName("com.bytedance.bdturing.identity_verify_adapter.DefaultIdentityVerifyDepend").newInstance();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        return this.mIdentityVerifyDepend;
    }

    public boolean getInjectHeader() {
        return this.mInjectHeader;
    }

    public String getInstallId() {
        String r0 = this.mInstallId;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        com.bytedance.bdturing.a r2 = this.mAppInfoProvider;
        if (r2 == null) goto L7;
        String r3 = r2.b();
    L9:
        return r3;
    L7:
        r3 = "";
        goto L9
    L10:
        return r0;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public String getLocale() {
        String r2 = this.mLocale;
    L10:
        if (r2 != null) goto L13;
        return "";
    L13:
        return r2;
    L8:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = Locale.getDefault().toString();     // Catch: Throwable -> L8 Exception -> L10
    L6:
        if (r2 != null) goto L13;
        return "";
    }

    @Deprecated
    public boolean getMaskCancel() {
        return this.mMaskCancel;
    }

    public String getOpenUdid() {
        String r0 = this.mOpenUdid;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        com.bytedance.bdturing.a r2 = this.mAppInfoProvider;
        if (r2 == null) goto L7;
        String r3 = r2.c();
    L9:
        return r3;
    L7:
        r3 = "";
        goto L9
    L10:
        return r0;
    }

    @Deprecated
    public String getOsName() {
        return this.mOsName;
    }

    @Deprecated
    public int getOsType() {
        return 0;
    }

    @Deprecated
    public String getOsVersion() {
        return this.mOsVersion;
    }

    public c getRegionType() {
        return this.mRegionType;
    }

    @Deprecated
    public String getRiskInfo() {
        return this.mRiskInfo;
    }

    @Deprecated
    public String getScene() {
        return this.mScene;
    }

    @Deprecated
    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public com.bytedance.bdturing.v.f getServiceInterceptor() {
        return this.mServiceInterceptor;
    }

    public String getSessionId() {
        String r0 = this.mSessionId;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        com.bytedance.bdturing.a r2 = this.mAppInfoProvider;
        if (r2 == null) goto L7;
        String r3 = r2.d();
    L9:
        return r3;
    L7:
        r3 = "";
        goto L9
    L10:
        return r0;
    }

    @Deprecated
    public boolean getShowToastSuccess() {
        return this.mShowToastSuccess;
    }

    public int getSmsDigits() {
        return this.mSmsDigits;
    }

    public Pair<String, String> getTestConfig(int r1) {
        return this.testConfig.get(Integer.valueOf(r1));
    }

    @Nullable
    public JSONObject getTheme(int r1) {
        return this.mThemeMap.get(Integer.valueOf(r1));
    }

    @Nullable
    public com.bytedance.bdturing.w.c getThemeConfig() {
        return this.mThemeConfig;
    }

    @Deprecated
    public String getTicket() {
        return this.ticket;
    }

    @Nullable
    public Activity getTopActivity() {
        f r0 = this.bdTuringDepend;
        if (r0 != null) goto L5;
        com.bytedance.bdturing.x.c r1 = this.mContextHolder;
        if (r1 == null) goto L12;
        WeakReference<Activity> r2 = r1.f3258a;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.get();
    L12:
        return null;
    L5:
        return r0.a();
    }

    public com.bytedance.bdturing.twiceverify.b getTwiceVerifyDepend() {
        return this.twiceVerifyDepend;
    }

    public boolean isBypassBdTuring() {
        return this.mBypassBdTuring;
    }

    public boolean isTTNetProcessorEnable() {
        return this.mEnableTTNetProcessor;
    }

    public BdTuringConfig removeTestConfig(int r2) {
        this.testConfig.remove(Integer.valueOf(r2));
        return this;
    }

    public BdTuringConfig setAppId(String r1) {
        this.mAppId = r1;
        return this;
    }

    public BdTuringConfig setAppInfoProvider(com.bytedance.bdturing.a r1) {
        return this;
    }

    public BdTuringConfig setBypassBdTuring(boolean r1) {
        this.mBypassBdTuring = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setChallengeCode(int r1) {
        this.mChallengeCode = r1;
        return this;
    }

    public BdTuringConfig setDeviceId(String r1) {
        this.mDeviceId = r1;
        return this;
    }

    public BdTuringConfig setEmailDigits(int r1) {
        this.mEmailDigits = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setFullScreen(boolean r1) {
        this.mFullScreen = r1;
        return this;
    }

    public void setHttpClient(com.bytedance.bdturing.ttnet.b r1) {
        this.httpClient = r1;
    }

    public BdTuringConfig setIBdturingDepend(f r1) {
        this.bdTuringDepend = r1;
        return this;
    }

    public void setIdentityVerifyDepend(com.bytedance.bdturing.identityverify.a r1) {
        this.mIdentityVerifyDepend = r1;
    }

    public BdTuringConfig setInstallId(String r1) {
        this.mInstallId = r1;
        return this;
    }

    public BdTuringConfig setLanguage(String r1) {
        this.mLanguage = r1;
        return this;
    }

    public BdTuringConfig setLocale(String r1) {
        this.mLocale = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setMaskCancel(boolean r1) {
        this.mMaskCancel = r1;
        return this;
    }

    public BdTuringConfig setOpenUdid(String r1) {
        this.mOpenUdid = r1;
        return this;
    }

    public BdTuringConfig setRegionType(c r1) {
        this.mRegionType = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setRiskInfo(String r1) {
        this.mRiskInfo = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setScene(String r1) {
        this.mScene = r1;
        return this;
    }

    public BdTuringConfig setServiceInterceptor(com.bytedance.bdturing.v.f r1) {
        this.mServiceInterceptor = r1;
        return this;
    }

    public BdTuringConfig setSessionId(String r1) {
        this.mSessionId = r1;
        return this;
    }

    @Deprecated
    public BdTuringConfig setShowToastSuccess(boolean r1) {
        this.mShowToastSuccess = r1;
        return this;
    }

    public BdTuringConfig setSmsDigits(int r1) {
        this.mSmsDigits = r1;
        return this;
    }

    public BdTuringConfig setTestConfig(int r3, String r4, String r5) {
        this.testConfig.put(Integer.valueOf(r3), new Pair(r4, r5));
        return this;
    }

    public BdTuringConfig setTheme(JSONObject r2, int r3) {
        if (r2 != null) goto L9;
        return this;
    L9:
        this.mThemeMap.put(Integer.valueOf(r3), r2);     // Catch: Exception -> L6
    L8:
        return this;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void setThemeConfig(com.bytedance.bdturing.w.c r1) {
    }

    @Deprecated
    public BdTuringConfig setTicket(String r1) {
        this.ticket = r1;
        return this;
    }
}
