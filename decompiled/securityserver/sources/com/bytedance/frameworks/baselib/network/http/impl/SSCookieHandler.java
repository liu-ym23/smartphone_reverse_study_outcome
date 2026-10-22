package com.bytedance.frameworks.baselib.network.http.impl;

import a.a;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.config.InsecureRequestControlConfig;
import com.bytedance.frameworks.baselib.network.config.TTCookieConfig;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import java.lang.reflect.Method;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SSCookieHandler extends CookieManager {
    public static final String COOKIE = "Cookie";
    private static final String GET_REQUEST_COOKIE_SOURCE_FLAG = "x-tt-get-cookie-source";
    public static final String REQUEST_COOKIE_SOURCE_INTERCEPT_BACKUP_FLAG = "x-tt-cookie-backup-source=1";
    public static final String SET_COOKIE = "Set-Cookie";
    public static final String SS_COOKIE = "X-SS-Cookie";
    public static final String SS_SET_COOKIE = "X-SS-Set-Cookie";
    private static final String TAG = "SSCookieHandler";
    public static boolean USE_SS_COOKIE = false;
    public static final String WEBVIEW_COOKIE = "webview-origin-url";
    public static final String X_HEADER_NO_COOKIE = "X-SS-No-Cookie";
    private static final String event = "TTNET-COOKIE";
    private static boolean sDebugAppCookieStore = false;
    private volatile CookieManagerWrap mAppCookieMgr;
    private final ICookieEventHandler mCookieEventHandler;
    private final ArrayList<String> mCookieFlushPathList;
    private final android.webkit.CookieManager mCookieMgr;
    private final Pattern pattern;

    public interface ICookieEventHandler {
        boolean enableSetCookieLog();

        void onEvent(String r1, String r2, JSONObject r3);
    }

    public static final enum ReqCookieSource extends Enum<ReqCookieSource> {
        private static final /* synthetic */ ReqCookieSource[] $VALUES = null;
        public static final ReqCookieSource APP_COOKIE_STORE = null;
        public static final ReqCookieSource BACKUP = null;
        public static final ReqCookieSource MAIN = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_BACKUP = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_MAIN = null;
        public static final ReqCookieSource UNKNOWN = null;

        static {
            ReqCookieSource r0 = new ReqCookieSource(NetworkStackConstant.UNKNOWN_TYPE, 0);
            UNKNOWN = r0;
            ReqCookieSource r1 = new ReqCookieSource("APP_COOKIE_STORE", 1);
            APP_COOKIE_STORE = r1;
            ReqCookieSource r2 = new ReqCookieSource("SHARE_INTERCEPTOR_MAIN", 2);
            SHARE_INTERCEPTOR_MAIN = r2;
            ReqCookieSource r3 = new ReqCookieSource("SHARE_INTERCEPTOR_BACKUP", 3);
            SHARE_INTERCEPTOR_BACKUP = r3;
            ReqCookieSource r4 = new ReqCookieSource("MAIN", 4);
            MAIN = r4;
            ReqCookieSource r5 = new ReqCookieSource("BACKUP", 5);
            BACKUP = r5;
            $VALUES = new ReqCookieSource[]{r0, r1, r2, r3, r4, r5};
        }

        private ReqCookieSource(String r1, int r2) {
            super(r1, r2);
        }

        public static ReqCookieSource valueOf(String r1) {
            return (ReqCookieSource) Enum.valueOf(ReqCookieSource.class, r1);
        }

        public static ReqCookieSource[] values() {
            return (ReqCookieSource[]) $VALUES.clone();
        }
    }

    public SSCookieHandler(final Context r5, int r6, android.webkit.CookieManager r7, ArrayList<String> r8, ICookieEventHandler r9) {
        this.pattern = Pattern.compile("(?<=Domain=)([^;]*)", 2);
        if (TTCookieConfig.isCookieBackupDisabled() == true) goto L7;
        if (r6 <= 0) goto L6;
        TTExecutors.getScheduledThreadPool().schedule(new AnonymousClass1(this, r5), r6, TimeUnit.SECONDS);
        goto L7
    L6:
        this.mAppCookieMgr = new CookieManagerWrap(new PersistentCookieStore(r5), CookiePolicy.ACCEPT_ALL);
    L7:
        this.mCookieMgr = r7;
        this.mCookieFlushPathList = r8;
        this.mCookieEventHandler = r9;
        if (r9 != null) goto L10;
        return;
    L10:
        if (r9.enableSetCookieLog() == false) goto L19;
        JSONObject r10 = new JSONObject();
        r10.put("init", "success");     // Catch: JSONException -> L15
    L13:
        this.mCookieEventHandler.onEvent(event, "init", r10);
        return;
    }

    public static /* synthetic */ void a(SSCookieHandler r0, ConcurrentHashMap r1) {
        r0.lambda$putV2$0(r1);
    }

    public static /* synthetic */ CookieManagerWrap access$002(SSCookieHandler r0, CookieManagerWrap r1) {
        r0.mAppCookieMgr = r1;
        return r1;
    }

    private static boolean checkDomainLevel(String r7) {
        if (r7.length() >= 2) goto L5;
        return false;
    L5:
        int r3 = 1;
        int r4 = 0;
    L7:
        if (r3 >= r7.length()) goto L14;
        if (r7.charAt(r3) != '.') goto L13;
        r4 = r4 + 1;
        if (r4 >= 2) goto L14;
    L13:
        r3 = r3 + 1;
    L14:
        if (r4 >= 2) goto L16;
        return false;
    L16:
        return true;
    }

    private JSONObject createReportSetCookieLogV2() {
        ICookieEventHandler r0 = this.mCookieEventHandler;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.enableSetCookieLog() == true) goto L8;
        return null;
    L8:
        return new JSONObject();
    }

    private void flushCookiesIfPathMatched(String r2, boolean r3) {
        if (r3 == false) goto L8;
        android.webkit.CookieManager.getInstance().flush();
        if (Logger.debug() == false) goto L25;
        a.y("Force flush cookie: ", r2, TAG);
        return;
    L25:
        return;
    L8:
        ArrayList<String> r4 = this.mCookieFlushPathList;
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.isEmpty() == true) goto L28;
        Iterator<String> r1 = this.mCookieFlushPathList.iterator();
    L15:
        if (r1.hasNext() == false) goto L29;
        if (r2.equals(r1.next()) == false) goto L15;
        android.webkit.CookieManager.getInstance().flush();
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "Path match flush cookie: ".concat(r2));
        return;
    L27:
        return;
    L29:
        return;
    }

    private Map<String, List<String>> getCookieMap(List<String> r4, Map<String, List<String>> r5) {
        Map<String, List<String>> r0 = Collections.emptyMap();
        if (USE_SS_COOKIE == false) goto L20;
        LinkedHashMap r1 = new LinkedHashMap();
        if (r5 == null) goto L11;
        List<String> r2 = getHeaderListIgnoreCase(r5, "Cookie");
        if (r2 != null) goto L9;
    L10:
        r1.put("Cookie", r4);
    L13:
        if (r5 == null) goto L19;
        List<String> r3 = getHeaderListIgnoreCase(r5, "X-SS-Cookie");
        if (r3 != null) goto L17;
    L18:
        r1.put("X-SS-Cookie", r4);
        return r1;
    L17:
        if (r3.isEmpty() == true) goto L18;
        return r1;
    L19:
        r1.put("X-SS-Cookie", r4);
        return r1;
    L9:
        if (r2.isEmpty() == false) goto L13;
    L11:
        r1.put("Cookie", r4);
        goto L13
    L20:
        if (r5 == null) goto L27;
        List<String> r6 = getHeaderListIgnoreCase(r5, "Cookie");
        if (r6 == null) goto L32;
        if (r6.isEmpty() == true) goto L32;
        return r0;
    L32:
        return Collections.singletonMap("Cookie", r4);
    L27:
        return Collections.singletonMap("Cookie", r4);
    }

    private static Map<String, List<String>> getCookieResultMap(boolean r0, Map<String, List<String>> r1, ReqCookieSource r2) {
        if (r0 == true) goto L4;
        return r1;
    L4:
        if (r1 != null) goto L7;
        return null;
    L7:
        LinkedHashMap r3 = new LinkedHashMap(r1);
        r3.put(GET_REQUEST_COOKIE_SOURCE_FLAG, Collections.singletonList(String.valueOf(r2.ordinal())));
        return r3;
    }

    private List<String> getHeaderListIgnoreCase(Map<String, List<String>> r2, String r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L18;
        List<String> r1 = r2.get(r3);
        if (r1 == null) goto L13;
        if (r1.isEmpty() == true) goto L13;
        return r1;
    L13:
        return r2.get(r3.toLowerCase());
    L18:
        return null;
    }

    private boolean isDomainMatch(URI r3, String r4) {
        if (r3 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        String r5 = r3.getHost().toLowerCase();     // Catch: Throwable -> L10
        String r1 = "";
        Matcher r2 = this.pattern.matcher(r4);     // Catch: Throwable -> L10
        if (r2.find() == false) goto L13;
        r1 = r2.group().toLowerCase();     // Catch: Throwable -> L10
    L13:
        if (TextUtils.isEmpty(r1) == true) goto L22;
        if (r5.endsWith(r1) == false) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L19
    }

    private /* synthetic */ void lambda$putV2$0(Map r4) {
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) r5.next();
        this.mAppCookieMgr.put((URI) r0.getKey(), (List) r0.getValue());     // Catch: Throwable -> L9
        goto L4
    }

    private static void putSetCookieLogV2(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        r1.put(r2, r3);     // Catch: JSONException -> L10
        return;
    L16:
        return;
    }

    private void putToCookieManager(String r4, List<String> r5, Set<String> r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (CollectionUtils.isEmpty(r5) == true) goto L37;
        r6.add(r4);
        if (TTCookieConfig.isCookieBatchSaveEnabled() == true) goto L31;
    L13:
        boolean r7 = false;
    L14:
        NetworkParams.CookieUpdateListener r0 = NetworkParams.getCookieUpdateListener();
        if (r7 == false) goto L18;
        if (r0 != null) goto L18;
        return;
    L18:
        Iterator<String> r8 = r5.iterator();
    L20:
        if (r8.hasNext() == false) goto L38;
        String r1 = r8.next();
        if (r7 == true) goto L24;
        this.mCookieMgr.setCookie(r4, r1);
    L24:
        if (r0 == null) goto L20;
        r0.onCookieUpdate(r4, r1);     // Catch: Throwable -> L28
        goto L20
    L38:
        return;
    L31:
        Method r9 = this.mCookieMgr.getClass().getDeclaredMethod("setCookieList", new Class[]{String.class, List.class});     // Catch: Throwable -> L11
        r9.setAccessible(true);     // Catch: Throwable -> L11
        r7 = ((Boolean) r9.invoke(this.mCookieMgr, new Object[]{r4, r5})).booleanValue();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Logger.d(TAG, "Batch save cookie failed:" + th);
        goto L13
    }

    private void putV2(URI r17, Map<String, List<String>> r18) {
        if (r17 == null) goto L151;
        if (r18 != null) goto L6;
        return;
    L6:
        if (r18.isEmpty() == true) goto L153;
        List<String> r3 = getHeaderListIgnoreCase(r18, "Set-Cookie");
        if (USE_SS_COOKIE == false) goto L14;
        if (Lists.isEmpty(r3) == false) goto L14;
        r3 = getHeaderListIgnoreCase(r18, SS_SET_COOKIE);
    L14:
        if (Lists.isEmpty(r3) == false) goto L16;
        return;
    L16:
        NetworkParams.CookieShareInterceptor r4 = NetworkParams.getCookieShareInterceptor();
        String r5 = null;
        if (r4 == null) goto L19;
        List<String> r6 = r4.getShareCookieHostList(r17.getHost());
    L20:
        JSONObject r7 = createReportSetCookieLogV2();
        if (r7 == null) goto L28;
        putSetCookieLogV2(r7, RobotsPolicyContract.COL_VERSION, "v2");
        putSetCookieLogV2(r7, "url", r17.toString());
        if (r6 != null) goto L25;
        String r8 = "";
    L26:
        putSetCookieLogV2(r7, "shareHostList", r8);
        putSetCookieLogV2(r7, "responseHeaders", r18.toString());
        putSetCookieLogV2(r7, "setCookieList", r3.toString());
        goto L28
    L25:
        r8 = r6.toString();
    L28:
        if (InsecureRequestControlConfig.isDisableShareInsecureCookie() == true) goto L30;
    L130:
        NetworkParams.AppCookieStore r9 = NetworkParams.getAppCookieStore();     // Catch: Throwable -> L121
        if (r9 == null) goto L37;
        r9.put(r17, r18);     // Catch: Throwable -> L121
    L37:
        boolean r10 = false;
        if (this.mCookieMgr != null) goto L43;
        if (r7 == null) goto L41;
        r10 = true;
    L41:
        reportCookieSaveLog(r7, "mCookieMgr is null", r10);
        return;
    L43:
        HashSet r11 = new HashSet();
        List<String> r2 = r18.get(WEBVIEW_COOKIE);
        if (Lists.isEmpty(r2) == true) goto L47;
        r5 = r2.get(0);
    L47:
        if (TextUtils.isEmpty(r5) == false) goto L134;
    L49:
        ConcurrentHashMap r12 = new ConcurrentHashMap();
        r12.put(r17, r3);
        Iterator<String> r13 = r3.iterator();
        boolean r14 = false;
    L51:
        if (r13.hasNext() == false) goto L96;
        String r15 = r13.next();
        if (Logger.debug() == false) goto L56;
        Logger.v(TAG, "receive cookie: " + r17 + ", set-cookie:" + r15);
    L56:
        if (TextUtils.isEmpty(r15) == true) goto L51;
        String r16 = r15.toLowerCase().trim();
        if (r16.contains("sessionid=") == false) goto L61;
        r14 = true;
    L61:
        if (r14 == true) goto L70;
        if (TTCookieConfig.isEnableFlushCookieForRegion() == false) goto L70;
        if (r16.contains(StoreRegionManager.STORE_COUNTRY_CODE_COOKIE) == false) goto L67;
    L68:
        r14 = true;
        goto L70
    L67:
        if (r16.contains(StoreRegionManager.STORE_REGION_COOKIE) == true) goto L68;
    L70:
        if (TextUtils.isEmpty(r5) == false) goto L51;
        if (Lists.isEmpty(r6) == true) goto L51;
        if (isDomainMatch(r17, r15) == false) goto L51;
        Iterator<String> r19 = r6.iterator();
    L80:
        if (r19.hasNext() == false) goto L51;
        String r110 = r19.next();
        if (TextUtils.isEmpty(r110) == true) goto L80;
        if (r17.getHost().endsWith(r110) == true) goto L80;
        String r111 = this.pattern.matcher(r15).replaceFirst(r110);     // Catch: Throwable -> L123
        if (TextUtils.isEmpty(r111) == true) goto L80;
        URI r20 = URI.create(r17.getScheme() + "://" + r110 + LibrarianImpl.Constants.SEPARATOR);     // Catch: Throwable -> L123
        List r112 = (List) r12.get(r20);     // Catch: Throwable -> L123
        if (r112 != null) goto L93;
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L123
        r113.add(r111);     // Catch: Throwable -> L123
        r12.put(r20, r113);     // Catch: Throwable -> L123
        goto L80
    L93:
        r112.add(r111);     // Catch: Throwable -> L123
        goto L80
    L96:
        Iterator r21 = r12.entrySet().iterator();
    L98:
        if (r21.hasNext() == false) goto L100;
        Map.Entry r22 = (Map.Entry) r21.next();
        putToCookieManager(((URI) r22.getKey()).toString(), (List) r22.getValue(), r11);
        goto L98
    L100:
        NetworkParams.CookieUpdateListener r23 = NetworkParams.getCookieUpdateListener();
        if (r11.isEmpty() == true) goto L132;
        if (r23 == null) goto L132;
        r23.onCookieBatchUpdate(r11);     // Catch: Throwable -> L124
    L132:
        flushCookiesIfPathMatched(r17.getPath(), r14);     // Catch: Throwable -> L125
    L106:
        if (this.mAppCookieMgr != null) goto L112;
        if (r7 == null) goto L109;
        boolean r24 = true;
    L110:
        reportCookieSaveLog(r7, "mAppCookieMgr is null", r24);
        return;
    L109:
        r24 = false;
        goto L110
    L112:
        androidx.constraintlayout.motion.widget.a r1 = new androidx.constraintlayout.motion.widget.a(3, this, r12);
        if (TTCookieConfig.isCookieBackupAsyncSaveEnabled() == false) goto L115;
        TTExecutors.getNormalExecutor().submit(r1);
    L116:
        if (r7 == null) goto L118;
        boolean r25 = true;
    L119:
        reportCookieSaveLog(r7, "last return", r25);
        return;
    L118:
        r25 = false;
        goto L119
    L115:
        r1.run();
        goto L116
    L134:
        syncWebViewCookieV2(r5, r3, r11);     // Catch: Throwable -> L122
        goto L49
    L30:
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(r17.getScheme()) == false) goto L130;
        if (r6 == null) goto L33;
        r6.clear();
    L33:
        putSetCookieLogV2(r7, "disable_share_insecure_cookie", "1");
        goto L130
    L19:
        r6 = null;
        goto L20
    L153:
        return;
    }

    private void reportCookieSaveLog(JSONObject r2, String r3, boolean r4) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.mCookieEventHandler == null) goto L13;
        if (r4 == false) goto L14;
        r2.put("return", r3);     // Catch: JSONException -> L10
    L8:
        this.mCookieEventHandler.onEvent(event, "put", r2);
        return;
    L14:
        return;
    }

    @Deprecated
    public static void setDebugAppCookieStore(boolean r0) {
        sDebugAppCookieStore = r0;
    }

    private String shouldSyncWebviewCookie(String r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L17;
        return null;
    L17:
        Matcher r3 = this.pattern.matcher(r5);     // Catch: IllegalArgumentException -> L16
        if (r3.find() == false) goto L8;
        String r0 = r3.group().toLowerCase();     // Catch: IllegalArgumentException -> L16
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L13;
        return r5;
    L13:
        if (checkDomainLevel(r0) == false) goto L19;
        return r3.replaceFirst(r4);
    L19:
        return null;
    L8:
        r0 = null;
    L20:
        return null;
    }

    private void syncWebViewCookieV2(String r4, List<String> r5, Set<String> r6) {
        ArrayList r0 = new ArrayList();
        Iterator<String> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        String r1 = shouldSyncWebviewCookie(r4, r7.next());
        if (TextUtils.isEmpty(r1) == true) goto L4;
        r0.add(r1);
        goto L4
    L10:
        if (r0.isEmpty() == false) goto L13;
        return;
    L13:
        if (Logger.debug() == false) goto L15;
        a.y("Sync cookies list for WebView request, original url: ", r4, TAG);
    L15:
        putToCookieManager(r4, r0, r6);
    }

    private void syncWebviewCookie(String r3, String r4, Set<String> r5) {
        if (this.mCookieMgr != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        String r6 = shouldSyncWebviewCookie(r3, r4);
        if (TextUtils.isEmpty(r6) == false) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        a.y(" Sync cookies for WebView request, original url: ", r3, TAG);
    L13:
        putToCookieManager(r3, r6, r5);
        return;
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI r8, Map<String, List<String>> r9) {
        android.webkit.CookieManager r2 = null;
        boolean r3 = false;
        String r4 = r8.toString();     // Catch: Throwable -> L33
        if (r9 != null) goto L95;
    L21:
        NetworkParams.AppCookieStore r5 = NetworkParams.getAppCookieStore();     // Catch: Throwable -> L17
        if (r5 == null) goto L36;
        Map<String, List<String>> r6 = r5.get(r8, r9);     // Catch: Throwable -> L17
        if (r6 == null) goto L36;
        if (r6.isEmpty() == true) goto L36;
        if (r6.containsKey("Cookie") == true) goto L32;
        if (r6.containsKey("X-SS-Cookie") == false) goto L36;
    L32:
        return getCookieResultMap(r3, r6, ReqCookieSource.APP_COOKIE_STORE);
    L36:
        if (r8 == null) goto L88;
        if (this.mCookieMgr == null) goto L88;
        NetworkParams.CookieShareInterceptor r7 = NetworkParams.getCookieShareInterceptor();     // Catch: Throwable -> L51
        if (r7 == null) goto L57;
        if (sDebugAppCookieStore == true) goto L46;
        r2 = this.mCookieMgr;     // Catch: Throwable -> L51
    L46:
        List<String> r10 = r7.getShareCookie(r2, this.mAppCookieMgr, r8);     // Catch: Throwable -> L51
        if (Lists.isEmpty(r10) == true) goto L57;
        ReqCookieSource r11 = ReqCookieSource.SHARE_INTERCEPTOR_MAIN;     // Catch: Throwable -> L51
        if (r10.remove(REQUEST_COOKIE_SOURCE_INTERCEPT_BACKUP_FLAG) == false) goto L53;
        r11 = ReqCookieSource.SHARE_INTERCEPTOR_BACKUP;     // Catch: Throwable -> L51
    L53:
        return getCookieResultMap(r3, getCookieMap(r10, r9), r11);
    L57:
        if (sDebugAppCookieStore == true) goto L69;
        String r12 = this.mCookieMgr.getCookie(r4);     // Catch: Exception -> L63
        if (TextUtils.isEmpty(r12) == true) goto L69;
        if (Logger.debug() == false) goto L65;
        Logger.v(TAG, "send cookie: " + r4 + " " + r12);     // Catch: Exception -> L63
    L65:
        return getCookieResultMap(r3, getCookieMap(Collections.singletonList(r12), r9), ReqCookieSource.MAIN);
    L63:
        e = move-exception;
        e.printStackTrace();
    L69:
        if (this.mAppCookieMgr == null) goto L71;
        CookieManagerWrap r1 = this.mAppCookieMgr;     // Catch: Throwable -> L75
        if (r9 != null) goto L77;
        Map<String, List<String>> r13 = new LinkedHashMap();     // Catch: Throwable -> L75
    L78:
        Map<String, List<String>> r14 = r1.get(r8, r13);     // Catch: Throwable -> L75
        if (r14 == null) goto L86;
        if (r14.isEmpty() == true) goto L86;
        return getCookieResultMap(r3, getCookieMap(r14.get("Cookie"), r9), ReqCookieSource.BACKUP);
    L86:
        return Collections.emptyMap();
    L77:
        r13 = r9;
    L75:
        th = move-exception;
        th.printStackTrace();
        goto L86
    L71:
        return Collections.emptyMap();
    L51:
        th = move-exception;
        th.printStackTrace();
    L88:
        return Collections.emptyMap();
    L95:
        r3 = r9.containsKey(GET_REQUEST_COOKIE_SOURCE_FLAG);     // Catch: Throwable -> L17
        List<String> r15 = getHeaderListIgnoreCase(r9, X_HEADER_NO_COOKIE);     // Catch: Throwable -> L17
        if (r15 == null) goto L21;
        Iterator<String> r16 = r15.iterator();     // Catch: Throwable -> L17
    L9:
        if (r16.hasNext() == false) goto L21;
        String r17 = r16.next();     // Catch: Throwable -> L17
        if (r17 == null) goto L9;
        if (Boolean.parseBoolean(r17) == false) goto L9;
        if (Logger.debug() == false) goto L20;
        Logger.v(TAG, "X-SS-No-Cookie " + r4);     // Catch: Throwable -> L17
    L20:
        return Collections.emptyMap();
    L17:
        th = th;
    L35:
        th.printStackTrace();
    L33:
        th = th;
        r4 = null;
        goto L35
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r28, Map<String, List<String>> r29) {
        if (TTCookieConfig.isCookieSaveV2Enabled() == false) goto L6;
        putV2(r28, r29);
        return;
    L6:
        NetworkParams.CookieShareInterceptor r0 = NetworkParams.getCookieShareInterceptor();
        if (r0 == null) goto L11;
        if (r28 == null) goto L11;
        List<String> r1 = r0.getShareCookieHostList(r28.getHost());
    L10:
        List<String> r4 = r1;
        JSONObject r5 = new JSONObject();
        String r6 = SS_SET_COOKIE;
        int r8 = 0;
        if (r29 != null) goto L15;
    L19:
        boolean r10 = false;
    L21:
        Object r11 = "";
        if (r4 != null) goto L210;
        Object r12 = "";
    L25:
        r5.put("shareHostList", r12);     // Catch: JSONException -> L198
        if (r10 == false) goto L29;
        r5.put("responseHeaders", r29.toString());     // Catch: JSONException -> L198
    L29:
        if (r28 == null) goto L32;
        r11 = r28.toString();     // Catch: JSONException -> L198
    L32:
        r5.put("url", r11);     // Catch: JSONException -> L198
        if (r28 != null) goto L35;
    L216:
        NetworkParams.AppCookieStore r2 = NetworkParams.getAppCookieStore();     // Catch: Throwable -> L45
        if (r2 == null) goto L47;
        r2.put(r28, r29);     // Catch: Throwable -> L45
    L47:
        String r3 = WEBVIEW_COOKIE;
        if (r29 != null) goto L50;
    L52:
        boolean r13 = false;
    L54:
        if (sDebugAppCookieStore == true) goto L145;
        if (r28 == null) goto L143;
        if (r29 == null) goto L143;
        if (this.mCookieMgr == null) goto L143;
        HashSet r14 = new HashSet();
        String r15 = r28.toString();
        if (USE_SS_COOKIE == false) goto L63;
        String[] r16 = {SS_SET_COOKIE, "Set-Cookie"};
    L64:
        int r9 = r16.length;
        boolean r7 = false;
        boolean r19 = false;
    L65:
        if (r8 >= r9) goto L136;
        int r20 = r9;
        String r17 = r16[r8];
        List<String> r21 = r29.get(r17);
        if (r21 != null) goto L69;
    L70:
        String[] r22 = r16;
        List<String> r18 = r29.get(r17.toLowerCase());
        if (r18 != null) goto L75;
    L76:
        String r110 = r3;
        r6 = r6;
    L135:
        r8 = r8 + 1;
        r3 = r110;
        r9 = r20;
        r16 = r22;
        r6 = r6;
        r10 = r10;
        goto L65
    L75:
        if (r18.isEmpty() == true) goto L76;
    L214:
        r5.put("cookieMgrList", r18.toString());     // Catch: JSONException -> L199
    L83:
        Iterator<String> r23 = r18.iterator();
    L85:
        if (r23.hasNext() == false) goto L134;
        String r111 = r23.next();
        Iterator<String> r112 = r23;
        if (r111.toLowerCase().trim().contains("sessionid=") == false) goto L89;
        r7 = true;
    L89:
        if (r7 == false) goto L91;
    L97:
        putToCookieManager(r15, r111, r14);
        if (r13 == false) goto L231;
        syncWebviewCookie(r29.get(r3).get(0), r111, r14);
    L100:
        String r113 = r3;
        boolean r25 = r7;
    L133:
        r3 = r113;
        r23 = r112;
        r7 = r25;
        goto L85
    L231:
        if ((!Lists.isEmpty(r4)) == false) goto L100;
        if (isDomainMatch(r28, r111) == false) goto L100;
        Iterator<String> r24 = r4.iterator();     // Catch: Throwable -> L203
    L110:
        if (r24.hasNext() == false) goto L130;
        String r114 = r24.next();     // Catch: Throwable -> L203
        if (TextUtils.isEmpty(r114) == true) goto L110;
        String r115 = r3;
        if (r28.getHost().endsWith(r114) == false) goto L119;
        r3 = r115;
        goto L110
    L119:
        String r26 = this.pattern.matcher(r111).replaceFirst(r114);     // Catch: Throwable -> L202
        if (TextUtils.isEmpty(r26) == true) goto L126;
        Iterator<String> r27 = r24;
        StringBuilder r30 = new StringBuilder();     // Catch: Throwable -> L201
        boolean r210 = r7;
        r30.append(r28.getScheme());     // Catch: Throwable -> L200
        r30.append("://");     // Catch: Throwable -> L200
        r30.append(r114);     // Catch: Throwable -> L200
        r30.append(LibrarianImpl.Constants.SEPARATOR);     // Catch: Throwable -> L200
        putToCookieManager(r30.toString(), r26, r14);     // Catch: Throwable -> L200
    L129:
        r3 = r115;
        r24 = r27;
        r7 = r210;
    L127:
        r210 = r7;
    L126:
        r27 = r24;
    L128:
        r115 = r3;
    L130:
        r113 = r3;
        r25 = r7;
        if (Logger.debug() == false) goto L133;
        Logger.v(TAG, "receive cookie: " + r15 + " " + r17 + ": " + r111);
        goto L133
    L91:
        if (TTCookieConfig.isEnableFlushCookieForRegion() == false) goto L97;
        if (r111.toLowerCase().trim().contains(StoreRegionManager.STORE_COUNTRY_CODE_COOKIE) == false) goto L95;
    L96:
        r7 = true;
        goto L97
    L95:
        if (r111.toLowerCase().trim().contains(StoreRegionManager.STORE_REGION_COOKIE) == false) goto L97;
    L134:
        r110 = r3;
        r19 = true;
        goto L135
    L69:
        if (r21.isEmpty() == true) goto L70;
        r22 = r16;
        r18 = r21;
        goto L214
    L136:
        String r211 = r6;
        boolean r212 = r10;
        NetworkParams.CookieUpdateListener r31 = NetworkParams.getCookieUpdateListener();
        if (r14.isEmpty() == true) goto L140;
        if (r31 == null) goto L140;
        r31.onCookieBatchUpdate(r14);     // Catch: Throwable -> L204
    L140:
        if (r19 == true) goto L208;
    L142:
        boolean r32 = r212;
    L146:
        if (r28 == null) goto L196;
        if (r29 == null) goto L196;
        if (this.mAppCookieMgr == null) goto L196;
        LinkedHashMap r33 = new LinkedHashMap();     // Catch: Throwable -> L158
        if (USE_SS_COOKIE == false) goto L160;
        String r34 = r211;
        if (r29.containsKey(r34) == false) goto L160;
        Object r35 = "Set-Cookie";
        if (r29.containsKey(r35) == true) goto L161;
        r33.put(r35, r29.get(r34));     // Catch: Throwable -> L158
    L161:
        r33.putAll(r29);     // Catch: Throwable -> L158
        this.mAppCookieMgr.put(r28, r33);     // Catch: Throwable -> L158
        if ((!Lists.isEmpty(r4)) == false) goto L191;
        if (r13 == true) goto L191;
        Iterator<String> r36 = r4.iterator();     // Catch: Throwable -> L158
    L167:
        if (r36.hasNext() == false) goto L194;
        String r37 = r36.next();     // Catch: Throwable -> L158
        if (TextUtils.isEmpty(r37) == true) goto L167;
        if (r28.getHost().endsWith(r37) == true) goto L167;
        List<String> r38 = r29.get(r35);     // Catch: Throwable -> L206
        if (r38 != null) goto L179;
        reportCookieSaveLog(r5, "cookieList is null", r32);     // Catch: Throwable -> L206
        return;
    L179:
        LinkedList r116 = new LinkedList();     // Catch: Throwable -> L206
        Iterator<String> r39 = r38.iterator();     // Catch: Throwable -> L206
    L181:
        if (r39.hasNext() == false) goto L189;
        String r117 = r39.next();     // Catch: Throwable -> L206
        if (isDomainMatch(r28, r117) == false) goto L181;
        String r118 = this.pattern.matcher(r117).replaceFirst(r37);     // Catch: Throwable -> L206 IllegalArgumentException -> L207
        if (TextUtils.isEmpty(r118) == true) goto L181;
        r116.add(r118);     // Catch: Throwable -> L206 IllegalArgumentException -> L207
        goto L181
    L189:
        r33.put(r35, r116);     // Catch: Throwable -> L206
        this.mAppCookieMgr.put(URI.create(r28.getScheme() + "://" + r37), r33);     // Catch: Throwable -> L206
    L194:
        reportCookieSaveLog(r5, "last return", r32);
        return;
    L191:
        reportCookieSaveLog(r5, "isInShareCookieList is false", r32);     // Catch: Throwable -> L158
        return;
    L160:
        r35 = r7;
    L158:
        th = move-exception;
        th.printStackTrace();
    L196:
        reportCookieSaveLog(r5, "uri responseHeaders or mAppCookieMgr is null", r32);
        return;
    L208:
        flushCookiesIfPathMatched(r28.getPath(), r7);     // Catch: Throwable -> L205
        goto L142
    L63:
        r16 = new String[]{"Set-Cookie"};
    L143:
        reportCookieSaveLog(r5, "uri responseHeaders or mCookieMgr is null", r10);
        return;
    L145:
        r211 = SS_SET_COOKIE;
        r32 = r10;
        goto L146
    L50:
        if (r29.containsKey(WEBVIEW_COOKIE) == false) goto L52;
        r13 = true;
    L45:
        th = move-exception;
        th.printStackTrace();
        goto L47
    L35:
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(r28.getScheme()) == false) goto L216;
        if (InsecureRequestControlConfig.isDisableShareInsecureCookie() == false) goto L216;
        if (r4 == null) goto L40;
        r4.clear();     // Catch: JSONException -> L198
    L40:
        r5.put("disable_share_insecure_cookie", 1);     // Catch: JSONException -> L198
        goto L216
    L210:
        r12 = r4.toString();     // Catch: JSONException -> L198
        goto L25
    L15:
        if (r29.containsKey("Set-Cookie") == false) goto L17;
    L18:
        r10 = true;
        goto L21
    L17:
        if (r29.containsKey(SS_SET_COOKIE) == false) goto L19;
    L11:
        r1 = null;
        goto L10
    }

    private void putToCookieManager(String r2, String r3, Set<String> r4) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        r4.add(r2);
        this.mCookieMgr.setCookie(r2, r3);
        NetworkParams.CookieUpdateListener r1 = NetworkParams.getCookieUpdateListener();     // Catch: Throwable -> L12
        if (r1 == null) goto L16;
        r1.onCookieUpdate(r2, r3);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L18:
        return;
    }
}
