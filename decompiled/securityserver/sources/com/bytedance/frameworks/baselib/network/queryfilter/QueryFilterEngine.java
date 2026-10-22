package com.bytedance.frameworks.baselib.network.queryfilter;

import a.a;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class QueryFilterEngine {
    private static final String CIPHER_VERSION_HEADER = "x-tt-cipher-version";
    private static final String CIPHER_VERSION_VALUE = "1.0.0";
    private static final String ENCRYPT_INFO_HEADER = "x-tt-encrypt-info";
    private static final String KEY_ACTION_NAME = "action";
    private static final String KEY_ACTION_PARAM = "param";
    private static final String KEY_ACTION_PRIORITY = "act_priority";
    public static final String KEY_L0_PARAMS = "L0_params";
    public static final String KEY_QUERY_FILTER_CONFIG = "query_filter_actions";
    public static final String KEY_QUERY_FILTER_ENABLED = "query_filter_enabled";
    private static final String KEY_SET_REQ_PRIORITY = "set_req_priority";
    private static final String TAG = "QueryFilterEngine";
    private static volatile QueryFilterEngine sInstance;
    private boolean mEnableNewSpaceEncodeRule;
    private List<String> mL0ParamsList;
    private volatile String mLocalConfig;
    private boolean mOptRetrofitLog;
    private List<QueryFilterAction> mQueryFilterActions;
    private volatile boolean mQueryFilterEnabled;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType = null;

        static {
            int[] r0 = new int[RetrofitMetrics.EncryptType.values().length];
            $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType = r0;
            r0[RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType[RetrofitMetrics.EncryptType.ENCRYPT_BODY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType[RetrofitMetrics.EncryptType.ENCRYPT_QUERY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class SortActionByPriority implements Comparator<QueryFilterAction> {
        final /* synthetic */ QueryFilterEngine this$0;

        public SortActionByPriority(QueryFilterEngine r1) {
            this.this$0 = r1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(QueryFilterAction r1, QueryFilterAction r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(QueryFilterAction r1, QueryFilterAction r2) {
            return r1.getPriority() - r2.getPriority();
        }
    }

    private QueryFilterEngine() {
        this.mQueryFilterEnabled = false;
        this.mQueryFilterActions = new CopyOnWriteArrayList();
        this.mL0ParamsList = new CopyOnWriteArrayList();
        this.mEnableNewSpaceEncodeRule = false;
        this.mOptRetrofitLog = true;
    }

    private static void addRequestEncryptHeaders(List<Header> r4, RetrofitMetrics.EncryptType r5) {
        int r6 = AnonymousClass1.$SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType[r5.ordinal()];
        if (r6 != 1) goto L5;
        r4.add(new Header(CIPHER_VERSION_HEADER, CIPHER_VERSION_VALUE));
        r4.add(new Header(ENCRYPT_INFO_HEADER, "2"));
        return;
    L5:
        if (r6 != 2) goto L7;
        r4.add(new Header(CIPHER_VERSION_HEADER, CIPHER_VERSION_VALUE));
        r4.add(new Header(ENCRYPT_INFO_HEADER, "1"));
        return;
    L7:
        if (r6 != 3) goto L15;
        r4.add(new Header(CIPHER_VERSION_HEADER, CIPHER_VERSION_VALUE));
        r4.add(new Header(ENCRYPT_INFO_HEADER, "0"));
        return;
    }

    private JSONArray dispatchQueryActionInfo(List<QueryActionInfo> r10) {
        JSONArray r0 = new JSONArray();
        Iterator<QueryActionInfo> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L22;
        QueryActionInfo r1 = r11.next();
        long r2 = r1.getDispatchActionDuration();     // Catch: JSONException -> L13
        if (this.mOptRetrofitLog == false) goto L15;
        if (r1.isActionHit() == true) goto L15;
        if (r2 <= 0) goto L4;
    L15:
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L13
        r4.put(BaseHttpRequestInfo.KEY_HIT, r1.isActionHit());     // Catch: JSONException -> L13
        r4.put("priority", r1.getActionPriority());     // Catch: JSONException -> L13
        if (r2 <= 0) goto L18;
        r4.put("consume", r2);     // Catch: JSONException -> L13
    L18:
        r0.put(r4);     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.d(TAG, "action info: " + r0.toString());
    L24:
        return r0;
    }

    private boolean dispatchQueryMap(Request r5, Map<String, List<String>> r6) {
        ArrayList r0 = new ArrayList();
        boolean r1 = false;
        r5.setQueryFilterPriority(0);
        Iterator<QueryFilterAction> r2 = this.mQueryFilterActions.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r2.next().takeAction(r5, r6, r0) == false) goto L4;
        r1 = true;
        goto L4
    L9:
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "dispatchQueryMap hit: " + r1);
    L12:
        if (r5.getMetrics() == null) goto L14;
        r5.getMetrics().dispatchQueryActionInfo = dispatchQueryActionInfo(r0);
    L14:
        return r1;
    }

    public static QueryFilterEngine inst() {
        if (sInstance != null) goto L16;
        monitor-enter(QueryFilterEngine.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new QueryFilterEngine();     // Catch: Throwable -> L9
    L11:
        monitor-exit(QueryFilterEngine.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private void parseActionInfo(JSONObject r4, ArrayList<QueryFilterAction> r5) {
        String r3 = r4.getString(KEY_ACTION_NAME);
        int r0 = r4.getInt(KEY_ACTION_PRIORITY);
        if (r0 >= 0) goto L5;
        return;
    L5:
        JSONObject r1 = r4.getJSONObject(KEY_ACTION_PARAM);
        int r6 = r4.optInt(KEY_SET_REQ_PRIORITY, r0);
        if (r6 != (-1)) goto L8;
        r6 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L8:
        QueryFilterAction r7 = QueryFilterAction.createQueryFilterAction(r3, r0, r6, r1);
        if (r7 == null) goto L12;
        r5.add(r7);
        return;
    }

    public static void parseArrayListConfig(JSONArray r3, List<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r0 = 0;
    L14:
        if (r0 >= r3.length()) goto L21;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4.add(r1);     // Catch: JSONException -> L13
    L11:
        r0 = r0 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private synchronized void parseCommonParamsConfig(String r5) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.mLocalConfig) == false) goto L6;
    L15:
        ArrayList<QueryFilterAction> r0 = new ArrayList();     // Catch: Throwable -> L11
        JSONArray r1 = new JSONArray(r5);     // Catch: Throwable -> L11
        int r2 = 0;
    L17:
        if (r2 >= r1.length()) goto L19;
        parseActionInfo(r1.getJSONObject(r2), r0);     // Catch: Throwable -> L11
        r2 = r2 + 1;     // Catch: Throwable -> L11
        goto L17
    L19:
        Collections.sort(r0, new SortActionByPriority(this));     // Catch: Throwable -> L11
        this.mQueryFilterActions.clear();     // Catch: Throwable -> L11
        this.mQueryFilterActions.addAll(r0);     // Catch: Throwable -> L11
        this.mLocalConfig = r5;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L6:
        if (this.mLocalConfig.equals(r5) == false) goto L15;
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "Config is same with local config, do not parse.");     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);
    }

    private static void tryEncryptRequest(Request.Builder r7, Request r8, String r9) {
        if ((r8.getBody() instanceof AbsTypedOutput) == false) goto L7;
        boolean r0 = ((AbsTypedOutput) r8.getBody()).isBodyEncrypted();
        if (r0 == false) goto L9;
        Logger.i(TAG, "Request body has been encrypted before.");
    L9:
        if (r8.isQueryEncryptEnabled() == false) goto L11;
    L14:
        ArrayList r1 = new ArrayList();
        if (TextUtils.isEmpty(r9) == true) goto L18;
        r1.add(new Header("x-tt-encrypt-queries", r9));
    L18:
        if (r8.getHeaders() == null) goto L20;
        r1.addAll(r8.getHeaders());
    L20:
        RetrofitMetrics r10 = r8.getMetrics();
        if (r0 == false) goto L23;
    L29:
        RetrofitMetrics.EncryptType r2 = RetrofitMetrics.EncryptType.ENCRYPT_NONE;
        if (r0 == true) goto L32;
    L34:
        if (r0 == false) goto L37;
        r2 = RetrofitMetrics.EncryptType.ENCRYPT_BODY;
        addRequestEncryptHeaders(r1, r2);
    L39:
        if (r10 == null) goto L41;
        r10.setEncryptType(r2);
    L41:
        r7.headers(r1);
        return;
    L37:
        if (r8.isQueryEncryptEnabled() == false) goto L39;
        r2 = RetrofitMetrics.EncryptType.ENCRYPT_QUERY;
        addRequestEncryptHeaders(r1, r2);
        goto L39
    L32:
        if (r8.isQueryEncryptEnabled() == false) goto L34;
        r2 = RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY;
        addRequestEncryptHeaders(r1, r2);
        goto L39
    L23:
        if (r8.isBodyEncryptEnabled() == false) goto L29;
        TypedOutput r3 = r8.getBody();
        if ((r3 instanceof AbsTypedOutput) == false) goto L29;
        long r4 = System.currentTimeMillis();
        r0 = ((AbsTypedOutput) r3).interceptRequestBody();
        if (r10 == null) goto L29;
        r10.bodyEncryptDuration = System.currentTimeMillis() - r4;
        goto L29
    L11:
        if (r8.isBodyEncryptEnabled() == true) goto L14;
        if (r0 == true) goto L14;
        return;
    L7:
        r0 = false;
        goto L9
    }

    public void enableQueryFilterEngine(boolean r1) {
        this.mQueryFilterEnabled = r1;
    }

    public Request filterQuery(Request r8) {
        if (this.mQueryFilterEnabled == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "Query filter engine is not enabled");
    L7:
        return null;
    L9:
        if (r8.isPureRequest() == false) goto L11;
        return null;
    L11:
        String r1 = r8.getUrl();
        if (TextUtils.isEmpty(r1) == false) goto L55;
        return null;
    L55:
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L29
        Pair<String, String> r2 = UrlUtils.parseUrlWithValueList(r1, r3);     // Catch: Throwable -> L29
        if (r2 != null) goto L18;
        return null;
    L18:
        if (dispatchQueryMap(r8, r3) == true) goto L21;
        return null;
    L21:
        if (r8.isQueryEncryptEnabled() == true) goto L23;
    L31:
        String r7 = null;
    L32:
        UrlBuilder r0 = new UrlBuilder(((String) r2.first) + ((String) r2.second));     // Catch: Throwable -> L29
        if (r3.isEmpty() == true) goto L51;
        Iterator r4 = r3.entrySet().iterator();     // Catch: Throwable -> L29
    L36:
        if (r4.hasNext() == false) goto L51;
        Map.Entry r5 = (Map.Entry) r4.next();     // Catch: Throwable -> L29
        if (r5 == null) goto L36;
        if (r5.getKey() == null) goto L36;
        List r6 = (List) r5.getValue();     // Catch: Throwable -> L29
        if (r6 == null) goto L36;
        if (r6.isEmpty() == true) goto L36;
        Iterator r9 = r6.iterator();     // Catch: Throwable -> L29
    L49:
        if (r9.hasNext() == false) goto L36;
        r0.addParam((String) r5.getKey(), (String) r9.next());     // Catch: Throwable -> L29
    L51:
        Request.Builder r10 = r8.newBuilder();     // Catch: Throwable -> L29
        tryEncryptRequest(r10, r8, r7);     // Catch: Throwable -> L29
        r10.url(r0.build());     // Catch: Throwable -> L29
        return r10.build();
    L23:
        if (r3.containsKey("x-tt-encrypt-queries") == false) goto L31;
        List r11 = (List) r3.get("x-tt-encrypt-queries");     // Catch: Throwable -> L29
        if (r11 == null) goto L31;
        if (r11.size() <= 0) goto L31;
        r7 = (String) r11.get(0);     // Catch: Throwable -> L29
        r3.remove("x-tt-encrypt-queries");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public String filterUrlWithCommonParams(String r15) {
        if (this.mQueryFilterEnabled == true) goto L5;
    L49:
        return r15;
    L5:
        if (TextUtils.isEmpty(r15) == true) goto L49;
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L34
        Pair<String, String> r1 = UrlUtils.parseUrlWithValueList(r15, r0);     // Catch: Throwable -> L34
        if (r1 != null) goto L10;
    L43:
        return r15;
    L10:
        if (r0.isEmpty() == true) goto L43;
        if (dispatchQueryMap(new Request(HttpMethodContrants.GET, r15, null, null, 0, false, -1, false, null), r0) == true) goto L15;
        return r15;
    L15:
        UrlBuilder r2 = new UrlBuilder(((String) r1.first) + ((String) r1.second));     // Catch: Throwable -> L34
        if (r0.isEmpty() == true) goto L36;
        Iterator r3 = r0.entrySet().iterator();     // Catch: Throwable -> L34
    L19:
        if (r3.hasNext() == false) goto L36;
        Map.Entry r4 = (Map.Entry) r3.next();     // Catch: Throwable -> L34
        if (r4 == null) goto L19;
        if (r4.getKey() == null) goto L19;
        List r5 = (List) r4.getValue();     // Catch: Throwable -> L34
        if (r5 == null) goto L19;
        if (r5.isEmpty() == true) goto L19;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L34
    L32:
        if (r6.hasNext() == false) goto L19;
        r2.addParam((String) r4.getKey(), (String) r6.next());     // Catch: Throwable -> L34
    L36:
        String r7 = r2.build();     // Catch: Throwable -> L34
        String r16 = Uri.parse(r15).getEncodedFragment();     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r16) == true) goto L46;
        r7 = r7 + "#" + r16;     // Catch: Throwable -> L41
    L46:
        if (this.mEnableNewSpaceEncodeRule == true) goto L48;
        return r7;
    L48:
        return UrlUtils.replacePlusInEncodeUrl(r7);
    L41:
        th = move-exception;
        th = th;
        r15 = r7;
    L44:
        th.printStackTrace();
        r7 = r15;
    L34:
        th = th;
        goto L44
    }

    public boolean getEnableNewSpaceEncodeRule() {
        return this.mEnableNewSpaceEncodeRule;
    }

    public List<QueryFilterAction> getQueryFilterActionsForTesting() {
        return this.mQueryFilterActions;
    }

    public void onNetConfigChanged(String r3) {
        if (Logger.debug() == false) goto L6;
        StringBuilder r0 = a.u("onNetConfigChanged config: ", r3, " enabled: ");
        r0.append(this.mQueryFilterEnabled);
        Logger.d(TAG, r0.toString());
    L6:
        if (this.mQueryFilterEnabled == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L18;
        parseCommonParamsConfig(r3);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void parseL0ParamsString(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        this.mL0ParamsList.clear();
        JSONArray r0 = new JSONArray(r4);     // Catch: JSONException -> L11
        int r5 = 0;
    L8:
        if (r5 >= r0.length()) goto L17;
        String r1 = r0.getString(r5);     // Catch: JSONException -> L11
        this.mL0ParamsList.add(r1);     // Catch: JSONException -> L11
        r5 = r5 + 1;
        goto L8
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public Map<String, String> removeL0CommonParams(Map<String, String> r2) {
        if (r2 != null) goto L4;
    L10:
        return r2;
    L4:
        if (r2.isEmpty() == true) goto L10;
        Iterator<String> r1 = this.mL0ParamsList.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r2.remove(r1.next());
        goto L8
    }

    public void setEnableNewSpaceEncodeRule(boolean r1) {
        this.mEnableNewSpaceEncodeRule = r1;
    }

    public void setLocalCommonParamsConfig(String r5) {
        JSONObject r0 = new JSONObject(r5).getJSONObject("data");     // Catch: JSONException -> L9
        boolean r2 = false;
        int r1 = r0.optInt(KEY_QUERY_FILTER_ENABLED, 0);     // Catch: JSONException -> L9
        if (r1 <= 0) goto L5;
        r2 = true;
    L5:
        enableQueryFilterEngine(r2);     // Catch: JSONException -> L9
        parseL0ParamsString(r0.optString(KEY_L0_PARAMS, ""));     // Catch: JSONException -> L9
        if (r1 <= 0) goto L11;
        parseCommonParamsConfig(r0.getString(KEY_QUERY_FILTER_CONFIG));     // Catch: JSONException -> L9
        return;
    L11:
        return;
    L9:
        e = move-exception;
        Logger.e(TAG, "Local common params config is invalid: " + r5);
        throw e;
    }

    public void setOptRetrofitLog(boolean r1) {
        this.mOptRetrofitLog = r1;
    }
}
