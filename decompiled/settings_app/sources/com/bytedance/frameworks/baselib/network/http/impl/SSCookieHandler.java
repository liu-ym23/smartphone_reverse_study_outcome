package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.config.InsecureRequestControlConfig;
import com.bytedance.frameworks.baselib.network.config.TTCookieConfig;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.io.IOException;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
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

    private static final enum ReqCookieSource extends Enum<ReqCookieSource> {
        private static final /* synthetic */ ReqCookieSource[] $VALUES = null;
        public static final ReqCookieSource APP_COOKIE_STORE = null;
        public static final ReqCookieSource BACKUP = null;
        public static final ReqCookieSource MAIN = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_BACKUP = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_MAIN = null;
        public static final ReqCookieSource UNKNOWN = null;

        private ReqCookieSource(String r1, int r2) {
            super(r1, r2);
        }

        public static ReqCookieSource valueOf(String r1) {
            return (ReqCookieSource) Enum.valueOf(ReqCookieSource.class, r1);
        }

        public static ReqCookieSource[] values() {
            return (ReqCookieSource[]) $VALUES.clone();
        }

        static {
            ReqCookieSource r0 = new ReqCookieSource(NetworkStackConstant.UNKNOWN_TYPE, 0);
            UNKNOWN = r0;
            ReqCookieSource r1 = new ReqCookieSource("APP_COOKIE_STORE", 1);
            APP_COOKIE_STORE = r1;
            ReqCookieSource r3 = new ReqCookieSource("SHARE_INTERCEPTOR_MAIN", 2);
            SHARE_INTERCEPTOR_MAIN = r3;
            ReqCookieSource r5 = new ReqCookieSource("SHARE_INTERCEPTOR_BACKUP", 3);
            SHARE_INTERCEPTOR_BACKUP = r5;
            ReqCookieSource r7 = new ReqCookieSource("MAIN", 4);
            MAIN = r7;
            ReqCookieSource r9 = new ReqCookieSource("BACKUP", 5);
            BACKUP = r9;
            $VALUES = new ReqCookieSource[]{r0, r1, r3, r5, r7, r9};
        }
    }

    static {
    }

    static /* synthetic */ CookieManagerWrap access$002(SSCookieHandler r0, CookieManagerWrap r1) {
        r0.mAppCookieMgr = r1;
        return r1;
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

    private void flushCookiesIfPathMatched(String r2, boolean r3) {
        if (r3 == false) goto L8;
        android.webkit.CookieManager.getInstance().flush();
        if (Logger.debug() == false) goto L25;
        Logger.d(TAG, "Force flush cookie: " + r2);
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
        Logger.d(TAG, "Path match flush cookie: " + r2);
        return;
    L27:
        return;
    L29:
        return;
    }

    @Deprecated
    public static void setDebugAppCookieStore(boolean r0) {
        sDebugAppCookieStore = r0;
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

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI r8, Map<String, List<String>> r9) throws IOException {
        android.webkit.CookieManager r2 = null;
        boolean r3 = false;
        String r4 = r8.toString();     // Catch: Throwable -> L33
        if (r9 != null) goto L90;
    L19:
        NetworkParams.AppCookieStore r5 = NetworkParams.getAppCookieStore();     // Catch: Throwable -> L31
        if (r5 == null) goto L36;
        Map<String, List<String>> r6 = r5.get(r8, r9);     // Catch: Throwable -> L31
        if (r6 == null) goto L36;
        if (r6.isEmpty() == true) goto L36;
        if (r6.containsKey("Cookie") == true) goto L30;
        if (r6.containsKey("X-SS-Cookie") == false) goto L36;
    L30:
        return getCookieResultMap(r3, r6, ReqCookieSource.APP_COOKIE_STORE);
    L36:
        if (r8 == null) goto L85;
        if (this.mCookieMgr == null) goto L85;
        NetworkParams.CookieShareInterceptor r7 = NetworkParams.getCookieShareInterceptor();     // Catch: Throwable -> L53
        if (r7 == null) goto L56;
        if (sDebugAppCookieStore == true) goto L46;
        r2 = this.mCookieMgr;     // Catch: Throwable -> L53
    L46:
        List<String> r10 = r7.getShareCookie(r2, this.mAppCookieMgr, r8);     // Catch: Throwable -> L53
        if (Lists.isEmpty(r10) == true) goto L56;
        ReqCookieSource r11 = ReqCookieSource.SHARE_INTERCEPTOR_MAIN;     // Catch: Throwable -> L53
        if (r10.remove(REQUEST_COOKIE_SOURCE_INTERCEPT_BACKUP_FLAG) == false) goto L51;
        r11 = ReqCookieSource.SHARE_INTERCEPTOR_BACKUP;     // Catch: Throwable -> L53
    L51:
        return getCookieResultMap(r3, getCookieMap(r10, r9), r11);
    L56:
        if (sDebugAppCookieStore == true) goto L67;
        String r12 = this.mCookieMgr.getCookie(r4);     // Catch: Exception -> L64
        if (StringUtils.isEmpty(r12) == true) goto L67;
        if (Logger.debug() == false) goto L62;
        Logger.v(TAG, "send cookie: " + r4 + HanziToPinyin.Token.SEPARATOR + r12);     // Catch: Exception -> L64
    L62:
        return getCookieResultMap(r3, getCookieMap(Collections.singletonList(r12), r9), ReqCookieSource.MAIN);
    L64:
        e = move-exception;
        e.printStackTrace();
    L67:
        if (this.mAppCookieMgr == null) goto L69;
        CookieManagerWrap r0 = this.mAppCookieMgr;     // Catch: Throwable -> L80
        if (r9 != null) goto L73;
        Map<String, List<String>> r13 = new LinkedHashMap();     // Catch: Throwable -> L80
    L74:
        Map<String, List<String>> r14 = r0.get(r8, r13);     // Catch: Throwable -> L80
        if (r14 == null) goto L83;
        if (r14.isEmpty() == true) goto L83;
        return getCookieResultMap(r3, getCookieMap(r14.get("Cookie"), r9), ReqCookieSource.BACKUP);
    L83:
        return Collections.emptyMap();
    L73:
        r13 = r9;
    L80:
        th = move-exception;
        th.printStackTrace();
        goto L83
    L69:
        return Collections.emptyMap();
    L53:
        th = move-exception;
        th.printStackTrace();
    L85:
        return Collections.emptyMap();
    L90:
        r3 = r9.containsKey(GET_REQUEST_COOKIE_SOURCE_FLAG);     // Catch: Throwable -> L31
        List<String> r15 = getHeaderListIgnoreCase(r9, X_HEADER_NO_COOKIE);     // Catch: Throwable -> L31
        if (r15 == null) goto L19;
        Iterator<String> r16 = r15.iterator();     // Catch: Throwable -> L31
    L9:
        if (r16.hasNext() == false) goto L19;
        String r17 = r16.next();     // Catch: Throwable -> L31
        if (r17 == null) goto L9;
        if (Boolean.parseBoolean(r17) == false) goto L9;
        if (Logger.debug() == false) goto L18;
        Logger.v(TAG, "X-SS-No-Cookie " + r4);     // Catch: Throwable -> L31
    L18:
        return Collections.emptyMap();
    L31:
        th = th;
    L35:
        th.printStackTrace();
    L33:
        th = th;
        r4 = null;
        goto L35
    }

    private void putV2(URI r14, Map<String, List<String>> r15) {
        if (r14 == null) goto L148;
        if (r15 != null) goto L5;
        return;
    L5:
        if (r15.isEmpty() == true) goto L150;
        List<String> r0 = getHeaderListIgnoreCase(r15, "Set-Cookie");
        if (USE_SS_COOKIE == false) goto L13;
        if (Lists.isEmpty(r0) == false) goto L13;
        r0 = getHeaderListIgnoreCase(r15, SS_SET_COOKIE);
    L13:
        if (Lists.isEmpty(r0) == false) goto L15;
        return;
    L15:
        NetworkParams.CookieShareInterceptor r1 = NetworkParams.getCookieShareInterceptor();
        String r2 = null;
        if (r1 == null) goto L18;
        List<String> r3 = r1.getShareCookieHostList(r14.getHost());
    L19:
        JSONObject r4 = createReportSetCookieLogV2();
        if (r4 == null) goto L27;
        putSetCookieLogV2(r4, "version", "v2");
        putSetCookieLogV2(r4, "url", r14.toString());
        if (r3 != null) goto L24;
        String r5 = "";
    L25:
        putSetCookieLogV2(r4, "shareHostList", r5);
        putSetCookieLogV2(r4, "responseHeaders", r15.toString());
        putSetCookieLogV2(r4, "setCookieList", r0.toString());
        goto L27
    L24:
        r5 = r3.toString();
    L27:
        if (InsecureRequestControlConfig.isDisableShareInsecureCookie() == true) goto L29;
    L117:
        NetworkParams.AppCookieStore r6 = NetworkParams.getAppCookieStore();     // Catch: Throwable -> L109
        if (r6 == null) goto L36;
        r6.put(r14, r15);     // Catch: Throwable -> L109
    L36:
        boolean r7 = true;
        if (this.mCookieMgr != null) goto L43;
        if (r4 != null) goto L41;
        r7 = false;
    L41:
        reportCookieSaveLog(r4, "mCookieMgr is null", r7);
        return;
    L43:
        final ConcurrentHashMap r8 = new ConcurrentHashMap();
        r8.put(r14, r0);
        List<String> r16 = r15.get(WEBVIEW_COOKIE);
        if (Lists.isEmpty(r16) == true) goto L46;
        r2 = r16.get(0);
    L46:
        Iterator<String> r17 = r0.iterator();
        boolean r9 = false;
    L48:
        if (r17.hasNext() == false) goto L113;
        String r10 = r17.next();
        if (StringUtils.isEmpty(r10) == true) goto L48;
        if (r10.toLowerCase().trim().contains("sessionid=") == false) goto L55;
        r9 = true;
    L55:
        this.mCookieMgr.setCookie(r14.toString(), r10);
        if (StringUtils.isEmpty(r2) == true) goto L60;
        syncWebviewCookie(r2, r10);     // Catch: Throwable -> L110
        goto L48
    L60:
        if (Lists.isEmpty(r3) == true) goto L48;
        if (isDomainMatch(r14, r10) == false) goto L48;
        Iterator<String> r11 = r3.iterator();
    L67:
        if (r11.hasNext() == false) goto L83;
        String r12 = r11.next();
        if (StringUtils.isEmpty(r12) == true) goto L67;
        if (r14.getHost().endsWith(r12) == true) goto L67;
        String r13 = this.pattern.matcher(r10).replaceFirst(r12);     // Catch: Throwable -> L111
        if (StringUtils.isEmpty(r13) == true) goto L67;
        String r18 = r14.getScheme() + "://" + r12 + LibrarianImpl.Constants.SEPARATOR;     // Catch: Throwable -> L111
        this.mCookieMgr.setCookie(r18, r13);     // Catch: Throwable -> L111
        URI r19 = URI.create(r18);     // Catch: Throwable -> L111
        List r110 = (List) r8.get(r19);     // Catch: Throwable -> L111
        if (r110 == null) goto L79;
        r110.add(r13);     // Catch: Throwable -> L111
        goto L67
    L79:
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L111
        r111.add(r13);     // Catch: Throwable -> L111
        r8.put(r19, r111);     // Catch: Throwable -> L111
        goto L67
    L83:
        if (Logger.debug() == false) goto L48;
        Logger.v(TAG, "receive cookie: " + r14 + "cookie:" + r10);
        goto L48
    L113:
        flushCookiesIfPathMatched(r14.getPath(), r9);     // Catch: Throwable -> L112
    L87:
        if (this.mAppCookieMgr != null) goto L94;
        if (r4 != null) goto L91;
        r7 = false;
    L91:
        reportCookieSaveLog(r4, "mAppCookieMgr is null", r7);
        return;
    L94:
        if (r8.isEmpty() == false) goto L100;
        if (r4 != null) goto L98;
        r7 = false;
    L98:
        reportCookieSaveLog(r4, "mAppCookieMgr saveCookieCache is empty", r7);
        return;
    L100:
        Runnable r112 = new SSCookieHandler$$ExternalSyntheticLambda0(this, r8);
        if (TTCookieConfig.isCookieBackupAsyncSaveEnabled() == false) goto L103;
        TTExecutors.getNormalExecutor().submit(r112);
    L104:
        if (r4 != null) goto L107;
        r7 = false;
    L107:
        reportCookieSaveLog(r4, "last return", r7);
        return;
    L103:
        r112.run();
        goto L104
    L29:
        if ("http".equalsIgnoreCase(r14.getScheme()) == false) goto L117;
        if (r3 == null) goto L32;
        r3.clear();
    L32:
        putSetCookieLogV2(r4, "disable_share_insecure_cookie", "1");
        goto L117
    L18:
        r3 = null;
        goto L19
    L150:
        return;
    }

    /* JADX INFO: renamed from: lambda$putV2$0$com-bytedance-frameworks-baselib-network-http-impl-SSCookieHandler, reason: not valid java name */
    /* synthetic */ void m889x7ee9d206(Map r4) {
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) r5.next();
        this.mAppCookieMgr.put((URI) r0.getKey(), (List) r0.getValue());     // Catch: Throwable -> L9
        goto L4
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r28, Map<String, List<String>> r29) throws IOException {
        if (TTCookieConfig.isCookieSaveV2Enabled() == false) goto L6;
        putV2(r28, r29);
        return;
    L6:
        NetworkParams.CookieShareInterceptor r0 = NetworkParams.getCookieShareInterceptor();
        if (r0 == null) goto L10;
        if (r28 == null) goto L10;
        List<String> r1 = r0.getShareCookieHostList(r28.getHost());
    L11:
        List<String> r4 = r1;
        JSONObject r5 = new JSONObject();
        String r8 = "Set-Cookie";
        if (r29 != null) goto L14;
    L18:
        boolean r10 = false;
    L20:
        String r11 = "";
        if (r4 != null) goto L198;
        String r12 = "";
    L24:
        r5.put("shareHostList", r12);     // Catch: JSONException -> L190
        if (r10 == false) goto L28;
        r5.put("responseHeaders", r29.toString());     // Catch: JSONException -> L190
    L28:
        if (r28 == null) goto L31;
        r11 = r28.toString();     // Catch: JSONException -> L190
    L31:
        r5.put("url", r11);     // Catch: JSONException -> L190
        if (r28 != null) goto L34;
    L211:
        NetworkParams.AppCookieStore r2 = NetworkParams.getAppCookieStore();     // Catch: Throwable -> L44
        if (r2 == null) goto L46;
        r2.put(r28, r29);     // Catch: Throwable -> L44
    L46:
        String r3 = WEBVIEW_COOKIE;
        if (r29 != null) goto L49;
    L51:
        boolean r13 = false;
    L53:
        if (sDebugAppCookieStore == true) goto L138;
        if (r28 == null) goto L136;
        if (r29 == null) goto L136;
        if (this.mCookieMgr == null) goto L136;
        String r14 = r28.toString();
        if (USE_SS_COOKIE == false) goto L62;
        String[] r15 = {SS_SET_COOKIE, "Set-Cookie"};
    L63:
        int r16 = r15.length;
        int r9 = 0;
        boolean r17 = false;
        boolean r18 = false;
    L64:
        if (r9 >= r16) goto L132;
        String r7 = r15[r9];
        List<String> r20 = r29.get(r7);
        if (r20 != null) goto L68;
    L71:
        String[] r21 = r15;
        List<String> r19 = r29.get(r7.toLowerCase());
        if (r19 != null) goto L74;
    L130:
        String r110 = r3;
        List<String> r25 = r4;
        boolean r24 = r13;
    L131:
        r9 = r9 + 1;
        r3 = r110;
        r15 = r21;
        r16 = r16;
        r8 = r8;
        r13 = r24;
        r4 = r25;
        goto L64
    L74:
        if (r19.isEmpty() == true) goto L130;
    L202:
        r5.put("cookieMgrList", r19.toString());     // Catch: JSONException -> L191
    L82:
        Iterator<String> r22 = r19.iterator();
    L84:
        if (r22.hasNext() == false) goto L129;
        String r111 = r22.next();
        Iterator<String> r112 = r22;
        if (r111.toLowerCase().trim().contains("sessionid=") == false) goto L88;
        r18 = true;
    L88:
        this.mCookieMgr.setCookie(r14, r111);
        if (r13 == false) goto L217;
        syncWebviewCookie(r29.get(r3).get(0), r111);
    L91:
        String r113 = r3;
        List<String> r26 = r4;
        boolean r27 = r13;
    L128:
        r22 = r112;
        r3 = r113;
        r13 = r27;
        r4 = r26;
        goto L84
    L217:
        if ((!Lists.isEmpty(r4)) == false) goto L91;
        if (isDomainMatch(r28, r111) == false) goto L91;
        Iterator<String> r23 = r4.iterator();     // Catch: Throwable -> L194
    L101:
        if (r23.hasNext() == false) goto L125;
        String r114 = r23.next();     // Catch: Throwable -> L194
        if (StringUtils.isEmpty(r114) == true) goto L101;
        String r115 = r3;
        if (r28.getHost().endsWith(r114) == false) goto L110;
        r3 = r115;
        goto L101
    L110:
        String r6 = this.pattern.matcher(r111).replaceFirst(r114);     // Catch: Throwable -> L193
        if (StringUtils.isEmpty(r6) == true) goto L121;
        Iterator<String> r210 = r23;
        boolean r211 = r13;
        r4 = r4;
        this.mCookieMgr.setCookie(new StringBuilder().append(r28.getScheme()).append("://").append(r114).append(LibrarianImpl.Constants.SEPARATOR).toString(), r6);     // Catch: Throwable -> L192
    L124:
        r3 = r115;
        r23 = r210;
        r13 = r211;
        r4 = r4;
    L119:
        r4 = r4;
    L122:
        r211 = r13;
    L121:
        r210 = r23;
    L123:
        r115 = r3;
    L125:
        r113 = r3;
        r26 = r4;
        r27 = r13;
        if (Logger.debug() == false) goto L128;
        Logger.v(TAG, "receive cookie: " + r14 + HanziToPinyin.Token.SEPARATOR + r7 + ": " + r111);
        goto L128
    L129:
        r110 = r3;
        r25 = r4;
        r24 = r13;
        r17 = true;
        goto L131
    L68:
        if (r20.isEmpty() == true) goto L71;
        r21 = r15;
        r19 = r20;
        goto L202
    L132:
        List<String> r212 = r4;
        String r213 = r8;
        boolean r214 = r13;
        if (r17 == true) goto L215;
    L139:
        if (r28 == null) goto L188;
        if (r29 == null) goto L188;
        if (this.mAppCookieMgr == null) goto L188;
        LinkedHashMap r30 = new LinkedHashMap();     // Catch: Throwable -> L184
        if (USE_SS_COOKIE == true) goto L147;
    L151:
        String r31 = r213;
    L152:
        r30.putAll(r29);     // Catch: Throwable -> L184
        this.mAppCookieMgr.put(r28, r30);     // Catch: Throwable -> L184
        if ((!Lists.isEmpty(r212)) == false) goto L182;
        if (r214 == true) goto L182;
        Iterator<String> r32 = r212.iterator();     // Catch: Throwable -> L184
    L158:
        if (r32.hasNext() == false) goto L186;
        String r33 = r32.next();     // Catch: Throwable -> L184
        if (StringUtils.isEmpty(r33) == true) goto L158;
        if (r28.getHost().endsWith(r33) == true) goto L158;
        List<String> r34 = r29.get(r31);     // Catch: Throwable -> L196
        if (r34 != null) goto L170;
        reportCookieSaveLog(r5, "cookieList is null", r10);     // Catch: Throwable -> L196
        return;
    L170:
        LinkedList r35 = new LinkedList();     // Catch: Throwable -> L196
        Iterator<String> r36 = r34.iterator();     // Catch: Throwable -> L196
    L172:
        if (r36.hasNext() == false) goto L180;
        String r116 = r36.next();     // Catch: Throwable -> L196
        if (isDomainMatch(r28, r116) == false) goto L172;
        String r117 = this.pattern.matcher(r116).replaceFirst(r33);     // Catch: Throwable -> L196 IllegalArgumentException -> L197
        if (StringUtils.isEmpty(r117) == true) goto L172;
        r35.add(r117);     // Catch: Throwable -> L196 IllegalArgumentException -> L197
        goto L172
    L180:
        r30.put(r31, r35);     // Catch: Throwable -> L196
        this.mAppCookieMgr.put(URI.create(r28.getScheme() + "://" + r33), r30);     // Catch: Throwable -> L196
    L186:
        reportCookieSaveLog(r5, "last return", r10);
        return;
    L182:
        reportCookieSaveLog(r5, "isInShareCookieList is false", r10);     // Catch: Throwable -> L184
        return;
    L147:
        if (r29.containsKey(SS_SET_COOKIE) == false) goto L151;
        r31 = r213;
        if (r29.containsKey(r31) == true) goto L152;
        r30.put(r31, r29.get(SS_SET_COOKIE));     // Catch: Throwable -> L184
    L184:
        th = move-exception;
        th.printStackTrace();
    L188:
        reportCookieSaveLog(r5, "uri responseHeaders or mAppCookieMgr is null", r10);
        return;
    L215:
        flushCookiesIfPathMatched(r28.getPath(), r18);     // Catch: Throwable -> L195
        goto L139
    L62:
        r15 = new String[]{"Set-Cookie"};
    L136:
        reportCookieSaveLog(r5, "uri responseHeaders or mCookieMgr is null", r10);
        return;
    L138:
        r212 = r4;
        r213 = "Set-Cookie";
        r214 = r13;
        goto L139
    L49:
        if (r29.containsKey(WEBVIEW_COOKIE) == false) goto L51;
        r13 = true;
    L44:
        th = move-exception;
        th.printStackTrace();
        goto L46
    L34:
        if ("http".equalsIgnoreCase(r28.getScheme()) == false) goto L211;
        if (InsecureRequestControlConfig.isDisableShareInsecureCookie() == false) goto L211;
        if (r4 == null) goto L39;
        r4.clear();     // Catch: JSONException -> L190
    L39:
        r5.put("disable_share_insecure_cookie", 1);     // Catch: JSONException -> L190
        goto L211
    L198:
        r12 = r4.toString();     // Catch: JSONException -> L190
        goto L24
    L14:
        if (r29.containsKey("Set-Cookie") == false) goto L16;
    L17:
        r10 = true;
        goto L20
    L16:
        if (r29.containsKey(SS_SET_COOKIE) == false) goto L18;
    L10:
        r1 = null;
        goto L11
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

    private static void putSetCookieLogV2(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(r3) == true) goto L15;
        r1.put(r2, r3);     // Catch: JSONException -> L10
        return;
    L16:
        return;
    }

    private boolean isDomainMatch(URI r3, String r4) {
        if (r3 != null) goto L5;
    L18:
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L18;
        String r5 = r3.getHost().toLowerCase();     // Catch: Throwable -> L16
        String r1 = "";
        Matcher r2 = this.pattern.matcher(r4);     // Catch: Throwable -> L16
        if (r2.find() == false) goto L11;
        r1 = r2.group().toLowerCase();     // Catch: Throwable -> L16
    L11:
        if (TextUtils.isEmpty(r1) == true) goto L21;
        if (r5.endsWith(r1) == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }

    private void syncWebviewCookie(String r3, String r4) {
        if (this.mCookieMgr != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        String r5 = shouldSyncWebviewCookie(r3, r4);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, " Sync cookies for WebView request, original url: " + r3);
    L13:
        this.mCookieMgr.setCookie(r3, r5);
        return;
    }

    private String shouldSyncWebviewCookie(String r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return null;
    L18:
        Matcher r3 = this.pattern.matcher(r5);     // Catch: IllegalArgumentException -> L17
        if (r3.find() == false) goto L8;
        String r0 = r3.group().toLowerCase();     // Catch: IllegalArgumentException -> L17
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L13;
        return r5;
    L13:
        if (checkDomainLevel(r0) == false) goto L20;
        return r3.replaceFirst(r4);
    L20:
        return null;
    L8:
        r0 = null;
    L21:
        return null;
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
}
