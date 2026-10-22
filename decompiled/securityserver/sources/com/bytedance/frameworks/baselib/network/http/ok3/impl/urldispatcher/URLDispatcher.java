package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import a.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.frameworks.baselib.network.http.util.NetworklibUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.ttnet.tnc.TNCManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class URLDispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "URLDispatcher";
    private static final String TNC_SP_NAME = "ttnet_tnc_config";
    private static volatile URLDispatcher mInstance;
    private static AtomicBoolean mLocalConfigLoaded;
    private Context mContext;
    private List<DelayTypedAction> mDelayActions;
    private final ReentrantReadWriteLock mDelayActionslock;
    private AtomicLong mDispatchActionEpoch;
    private List<URLDispatchAction> mDispatchActions;
    private final ReentrantReadWriteLock mDispatchActionslock;
    private AtomicBoolean mDispatcherEnabled;
    private ConcurrentMap<String, String> mHostReplaceMap;
    private String mTncAbTest;
    private String mTncEtag;
    private AtomicInteger mTncUpdateSource;
    private AtomicLong mTncUpdateTime;

    public static class ActionComparator implements Comparator<BaseDispatchAction> {
        public ActionComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(BaseDispatchAction r1, BaseDispatchAction r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(BaseDispatchAction r1, BaseDispatchAction r2) {
            return r1.getPriority() - r2.getPriority();
        }
    }

    static {
        mLocalConfigLoaded = new AtomicBoolean(false);
    }

    public URLDispatcher() {
        this.mContext = null;
        this.mDispatcherEnabled = new AtomicBoolean(true);
        this.mDispatchActionEpoch = new AtomicLong(0);
        this.mDispatchActions = new ArrayList();
        this.mDispatchActionslock = new ReentrantReadWriteLock();
        this.mDelayActions = new ArrayList();
        this.mDelayActionslock = new ReentrantReadWriteLock();
        this.mTncUpdateSource = new AtomicInteger(0);
        this.mTncUpdateTime = new AtomicLong(0);
        this.mHostReplaceMap = new ConcurrentHashMap();
    }

    private DispatchResult doDispatch(URLRequest r12) {
        String r0 = r12.getOriginUrl();
        DispatchResult r1 = new DispatchResult();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        r3.add(0, r0);
        this.mDispatchActionslock.readLock().lock();
        Iterator<URLDispatchAction> r5 = this.mDispatchActions.iterator();
        String r6 = r0;
    L4:
        if (r5.hasNext() == false) goto L15;
        URLDispatchAction r7 = r5.next();
        if (Logger.debug() == false) goto L8;
        String r8 = TAG;
        Logger.d(r8, "action url = " + r3);
        Logger.d(r8, "current action priority is " + r7.getPriority());
    L8:
        BaseDispatchAction.DispatchResultEnum r9 = r7.takeAction(r12, r6, r3, r2);
        String r10 = (String) r3.get(0);
        if (r9 == BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP) goto L11;
        r6 = r10;
        goto L4
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "the url has been dropped by urldispatcher, skip follow-up actions");
    L13:
        r1.mDropCode = r7.getTcTypedDropCode();
    L15:
        String r13 = (String) r3.get(0);
        this.mDispatchActionslock.readLock().unlock();
        ArrayList r11 = new ArrayList();
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L23
        r4.put("origin_url", r0);     // Catch: JSONException -> L23
        r4.put("dispatched_url", r13);     // Catch: JSONException -> L23
        JSONArray r14 = new JSONArray();     // Catch: JSONException -> L23
        Iterator r15 = r2.iterator();     // Catch: JSONException -> L23
    L18:
        if (r15.hasNext() == false) goto L25;
        DispatchActionInfo r16 = (DispatchActionInfo) r15.next();     // Catch: JSONException -> L23
        if (r16.mActionHit == false) goto L18;
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L23
        r11.add(Long.valueOf(r16.mRuleid));     // Catch: JSONException -> L23
        r17.put("rule_id", r16.mRuleid);     // Catch: JSONException -> L23
        r17.put("service_name", r16.mServiceName);     // Catch: JSONException -> L23
        r17.put("priority", r16.mPriority);     // Catch: JSONException -> L23
        r14.put(r17);     // Catch: JSONException -> L23
        goto L18
    L25:
        r4.put("action_info_list", r14);     // Catch: JSONException -> L23
        JSONObject r18 = new JSONObject();     // Catch: JSONException -> L23
        r18.put("dispatch", r4);     // Catch: JSONException -> L23
        new JSONObject().put("dispatchersdk", r18);     // Catch: JSONException -> L23
    L28:
        r1.mActionRuleIdList = r11;
        r1.mDispatchedURL = r13;
        r1.mDispatchActionChain = r2;
        return r1;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    public static URLDispatcher inst() {
        if (mInstance != null) goto L16;
        monitor-enter(URLDispatcher.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L11;
        mInstance = new URLDispatcher();     // Catch: Throwable -> L9
    L11:
        monitor-exit(URLDispatcher.class);     // Catch: Throwable -> L9
    L16:
        return mInstance;
    }

    private void parseAction(JSONObject r20) {
        String r3 = r20.optString("action");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        int r5 = r20.optInt("act_priority", -1);
        if (r5 >= 0) goto L8;
        return;
    L8:
        JSONObject r4 = r20.optJSONObject("param");
        if (r4 != null) goto L11;
        return;
    L11:
        String r2 = r20.optString("lifecycle");
        int r7 = 0;
        if ("".equals(r2) == false) goto L15;
        long r8 = 0;
    L14:
        long r11 = r8;
    L21:
        long r13 = r20.optInt("rule_id");
        String r6 = r20.optString("sign");
        ArrayList r15 = new ArrayList();
        JSONArray r9 = r20.optJSONArray("request_method");
        if (r9 != null) goto L24;
    L29:
        long r10 = r8;
        long r12 = r11;
        BaseDispatchAction r1 = BaseDispatchAction.factory(r3, r4, r5, r10, r12, r13, r6, this.mDispatchActionEpoch.get(), r15, r20.optInt("set_req_priority", r5));
        if ((r1 instanceof URLDispatchAction) == false) goto L36;
        this.mDispatchActions.add((URLDispatchAction) r1);
        return;
    L36:
        return;
    L24:
        if (r7 >= r9.length()) goto L29;
        String r14 = r9.optString(r7);
        if (TextUtils.isEmpty(r14) == true) goto L28;
        r15.add(r14);
    L28:
        r7 = r7 + 1;
        goto L24
    L15:
        ArrayList r16 = new ArrayList();
        if (NetworklibUtils.splitUTCTimeSegmentToList(r2, r16) == true) goto L18;
    L20:
        r8 = -1;
        goto L14
    L18:
        if (r16.size() != 2) goto L20;
        long r17 = ((Long) r16.get(0)).longValue();
        r11 = ((Long) r16.get(1)).longValue();
        r8 = r17;
        goto L21
    }

    private void parseDelayAction(JSONObject r19) {
        int r6 = r19.optInt("act_priority", -1);
        if (r6 >= 0) goto L5;
        return;
    L5:
        JSONObject r5 = r19.optJSONObject("param");
        if (r5 != null) goto L8;
        return;
    L8:
        String r1 = r19.optString("lifecycle");
        if ("".equals(r1) == false) goto L12;
        long r2 = 0;
    L11:
        long r7 = r2;
        long r9 = r7;
    L18:
        BaseDispatchAction r3 = BaseDispatchAction.factory("delay", r5, r6, r7, r9, 0, "", this.mDispatchActionEpoch.get(), null, 0);
        if ((r3 instanceof DelayTypedAction) == false) goto L22;
        this.mDelayActions.add((DelayTypedAction) r3);
        return;
    L22:
        return;
    L12:
        ArrayList r4 = new ArrayList();
        if (NetworklibUtils.splitUTCTimeSegmentToList(r1, r4) == true) goto L15;
    L17:
        r2 = -1;
        goto L11
    L15:
        if (r4.size() != 2) goto L17;
        r7 = ((Long) r4.get(0)).longValue();
        r9 = ((Long) r4.get(1)).longValue();
        goto L18
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getDelayResult(String r8, String r9) {
        if (Logger.debug() == false) goto L6;
        a.y("getDelayResultForUrl: ", r8, TAG);
    L6:
        if (UrlUtils.isValidUrl(r8) == false) goto L8;
        this.mDelayActionslock.readLock().lock();
        ArrayList r0 = new ArrayList();
        r0.add(0, 0);
        Iterator<DelayTypedAction> r2 = this.mDelayActions.iterator();
    L13:
        if (r2.hasNext() == false) goto L22;
        DelayTypedAction r3 = r2.next();
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "current action priority is " + r3.getPriority());
    L18:
        if (r3.takeDelayAction(r8, r9, r0) != BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) goto L13;
        if (Logger.debug() == false) goto L22;
        Logger.d(TAG, "the url has been delayed by delay action, skip follow-up actions");
    L22:
        this.mDelayActionslock.readLock().unlock();
        return ((Integer) r0.get(0)).intValue();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "illegal url");
    L10:
        return 0;
    }

    public DispatchResult getDispatchResultForUrl(URLRequest r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "getDispatchResultForUrl: " + r4.getOriginUrl());
    L6:
        if (UrlUtils.isValidUrl(r4.getOriginUrl()) == true) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "illegal url");
    L10:
        return null;
    L12:
        if (this.mDispatcherEnabled.get() == true) goto L18;
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "dispatch is unabled by tnc");
    L16:
        return null;
    L18:
        return doDispatch(r4);
    }

    public long getEpoch() {
        return this.mDispatchActionEpoch.get();
    }

    public ConcurrentMap<String, String> getHostReplaceMap() {
        return this.mHostReplaceMap;
    }

    public String getTncAbTest() {
        return this.mTncAbTest;
    }

    public String getTncEtag() {
        return this.mTncEtag;
    }

    public int getTncUpdateSource() {
        return this.mTncUpdateSource.get();
    }

    public long getTncUpdateTime() {
        return this.mTncUpdateTime.get();
    }

    public String handleHostMapping(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L50:
        return r5;
    L5:
        if (r5.contains("/network/get_network") == true) goto L50;
        if (r5.contains("/get_domains/v5") == true) goto L50;
        if (r5.contains("/ies/speed") == true) goto L50;
        String r0 = null;
        URL r1 = new URL(r5);     // Catch: Throwable -> L17
        String r2 = r1.getProtocol();     // Catch: Throwable -> L17
        r0 = r1.getHost();     // Catch: Throwable -> L15
    L21:
        if (TextUtils.isEmpty(r2) == true) goto L50;
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(r2) == true) goto L27;
        if ("https".equals(r2) == false) goto L50;
    L27:
        if (TextUtils.isEmpty(r0) == true) goto L50;
        ConcurrentMap<String, String> r3 = this.mHostReplaceMap;
        if (r3 == null) goto L48;
        if (r3.containsKey(r0) == false) goto L48;
        String r4 = this.mHostReplaceMap.get(r0);
        if (TextUtils.isEmpty(r4) == false) goto L38;
        return r5;
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.d(TAG, "handleHostMapping, match, origin: ".concat(r5));
    L40:
        String r6 = a.B(r2, "://", r0);
        String r7 = a.B(r2, "://", r4);
        if (r5.startsWith(r6) == false) goto L44;
        r5 = r5.replaceFirst(r6, r7);
    L44:
        if (Logger.debug() == false) goto L46;
        a.y("handleHostMapping, target: ", r5, TAG);
    L46:
        return r5;
    L48:
        if (Logger.debug() == false) goto L50;
        a.y("handleHostMapping, nomatch: ", r0, TAG);
    L15:
        th = th;
    L19:
        th.printStackTrace();
    L17:
        th = th;
        r2 = null;
        goto L19
    }

    public boolean isDispatchActionsEmpty() {
        return this.mDispatchActions.isEmpty();
    }

    public boolean isDispatchDelayEnabled() {
        return !this.mDelayActions.isEmpty();
    }

    public void loadLocalConfig(Context r11) {
        if (ProcessUtils.isMainProcessByProcessFlag(r11) == true) goto L5;
        return;
    L5:
        if (mLocalConfigLoaded.get() == true) goto L25;
        SharedPreferences r10 = r11.getSharedPreferences("ttnet_tnc_config", 0);
        boolean r12 = r10.getBoolean("is_full_config", false);
        String r0 = r10.getString(TNCManager.TNC_CONFIG_STR, null);
        String r6 = r10.getString(TNCManager.TNC_ETAG_NAME, null);
        String r7 = r10.getString(TNCManager.TNC_ABTEST_NAME, null);
    L15:
        e = move-exception;
        e.printStackTrace();
    L20:
        mLocalConfigLoaded.set(true);
        return;
    L8:
        if (TextUtils.isEmpty(r0) == true) goto L20;
        JSONObject r13 = new JSONObject(r0);     // Catch: JSONException -> L15
        if (r12 == false) goto L14;
        JSONObject r14 = r13.optJSONObject("data");     // Catch: JSONException -> L15
        if (r14 == null) goto L14;
        r13 = r14;
    L14:
        JSONObject r4 = r13;
        inst().onServerConfigChanged(r4, 0, r6, r7, System.currentTimeMillis());     // Catch: JSONException -> L15
        goto L20
    }

    public void onServerConfigChanged(JSONObject r6, int r7, String r8, String r9, long r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "URLDispatcher::onServerConfigChanged, tnc source is " + r7 + "etag is " + r8);
    L5:
        this.mTncUpdateSource.set(r7);
        this.mTncEtag = r8;
        this.mTncAbTest = r9;
        this.mTncUpdateTime.set(r10);
        int r11 = r6.optInt("ignore_retrofit_slash_enabled_v2", -1);
        int r12 = 0;
        boolean r13 = true;
        if (r11 < (-1)) goto L11;
        if (r11 != 1) goto L9;
        boolean r14 = true;
    L10:
        TTConfigManager.setIgnoreSlashEnabledV2(r14);
        goto L11
    L9:
        r14 = false;
    L11:
        JSONArray r15 = r6.optJSONArray("request_delay_actions");
        this.mDelayActionslock.writeLock().lock();     // Catch: Throwable -> L20
        this.mDelayActions.clear();     // Catch: Throwable -> L20
        if (r15 == null) goto L24;
        int r16 = 0;
    L16:
        if (r16 >= r15.length()) goto L24;
        JSONObject r2 = r15.optJSONObject(r16);     // Catch: Throwable -> L20
        if (r2 == null) goto L22;
        parseDelayAction(r2);     // Catch: Throwable -> L20
    L22:
        r16 = r16 + 1;     // Catch: Throwable -> L20
    L24:
        if (this.mDelayActions.isEmpty() == true) goto L26;
        Collections.sort(this.mDelayActions, new ActionComparator());     // Catch: Throwable -> L20
    L26:
        this.mDelayActionslock.writeLock().unlock();
        if (Logger.debug() == false) goto L29;
        Logger.d(TAG, "parse delay actions completed, actions size is " + this.mDelayActions.size());
    L29:
        int r17 = r6.optInt("ttnet_url_dispatcher_enabled", -1);
        if (r17 < 0) goto L36;
        AtomicBoolean r18 = this.mDispatcherEnabled;
        if (r17 == 1) goto L35;
        r13 = false;
    L35:
        r18.set(r13);
    L36:
        long r19 = r6.optInt("ttnet_dispatch_actions_epoch", -1);
        if (r19 == this.mDispatchActionEpoch.get()) goto L39;
        this.mDispatchActionEpoch.set(r19);
        JSONArray r20 = r6.optJSONArray("ttnet_dispatch_actions");
        if (r20 != null) goto L69;
        return;
    L69:
        this.mDispatchActionslock.writeLock().lock();     // Catch: Throwable -> L51
        this.mDispatchActions.clear();     // Catch: Throwable -> L51
    L47:
        if (r12 >= r20.length()) goto L55;
        JSONObject r21 = r20.optJSONObject(r12);     // Catch: Throwable -> L51
        if (r21 == null) goto L53;
        parseAction(r21);     // Catch: Throwable -> L51
    L53:
        r12 = r12 + 1;     // Catch: Throwable -> L51
        goto L47
    L55:
        if (this.mDispatchActions.isEmpty() == true) goto L57;
        Collections.sort(this.mDispatchActions, new ActionComparator());     // Catch: Throwable -> L51
    L57:
        this.mDispatchActionslock.writeLock().unlock();
        if (Logger.debug() == false) goto L80;
        Logger.d(TAG, "parse dispatch actions completed, actions size is " + this.mDispatchActions.size());
        return;
    L80:
        return;
    L51:
        th = move-exception;
        this.mDispatchActionslock.writeLock().unlock();
        if (Logger.debug() == false) goto L64;
        Logger.d(TAG, "parse dispatch actions completed, actions size is " + this.mDispatchActions.size());
    L64:
        throw th;
    L39:
        if (Logger.debug() == false) goto L79;
        Logger.d(TAG, "dispatch action epoch not changed");
        return;
    L79:
        return;
    L20:
        th = move-exception;
        this.mDelayActionslock.writeLock().unlock();
        if (Logger.debug() == false) goto L68;
        Logger.d(TAG, "parse delay actions completed, actions size is " + this.mDelayActions.size());
    L68:
        throw th;
    }

    public void setContext(Context r1) {
        this.mContext = r1;
    }

    public void setTncAbTest(String r1) {
        this.mTncAbTest = r1;
    }
}
