package com.monitor.cloudmessage;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.report.FileUploadServiceImpl;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.UrlUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.Tools;
import com.bytedance.services.apm.api.HttpResponse;
import com.loopj.android.http.RequestParams;
import com.monitor.cloudmessage.callback.IABTestConsumer;
import com.monitor.cloudmessage.callback.IAlogConsumer;
import com.monitor.cloudmessage.callback.ICommandReceiveObserver;
import com.monitor.cloudmessage.callback.IMonitorLogConsumer;
import com.monitor.cloudmessage.callback.IPatchConsumer;
import com.monitor.cloudmessage.callback.IPluginConsumer;
import com.monitor.cloudmessage.callback.IRouteConsumer;
import com.monitor.cloudmessage.callback.ITemplateConsumer;
import com.monitor.cloudmessage.entity.CloudMessage;
import com.monitor.cloudmessage.handler.IMessageHandler;
import com.monitor.cloudmessage.handler.impl.ABTestMessageHandler;
import com.monitor.cloudmessage.handler.impl.AlogMessageHandler;
import com.monitor.cloudmessage.handler.impl.CacheMessageHandler;
import com.monitor.cloudmessage.handler.impl.DBMessageHandler;
import com.monitor.cloudmessage.handler.impl.DataClearMessageHandler;
import com.monitor.cloudmessage.handler.impl.FileUploadMessageHandler;
import com.monitor.cloudmessage.handler.impl.HeapOOMMessageHandler;
import com.monitor.cloudmessage.handler.impl.MonitorLogMessageHandler;
import com.monitor.cloudmessage.handler.impl.NetFlowMessageHandler;
import com.monitor.cloudmessage.handler.impl.NetworkMessageHandler;
import com.monitor.cloudmessage.handler.impl.ObversableMessageHandler;
import com.monitor.cloudmessage.handler.impl.PatchMessageHandler;
import com.monitor.cloudmessage.handler.impl.PermissionMessageHandler;
import com.monitor.cloudmessage.handler.impl.PluginMessageHandler;
import com.monitor.cloudmessage.handler.impl.RouteMessageHandler;
import com.monitor.cloudmessage.handler.impl.SPMessageHandler;
import com.monitor.cloudmessage.handler.impl.StatMessageHandler;
import com.monitor.cloudmessage.handler.impl.TemplateMessageHandler;
import com.monitor.cloudmessage.obversable.CloudMessageObserver;
import com.monitor.cloudmessage.utils.DecodeUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class CloudMessageManager {
    private static final long MIN_FETCH_INTERVAL_MS = 120000;
    private static IABTestConsumer sAbTestConsumer = null;
    private static volatile String sAid = "";
    private static IAlogConsumer sAlogConsumer = null;
    private static volatile String[] sBlackListForCloudContrlInf = null;
    private static volatile Context sContext = null;
    private static volatile String sDumpFileDir = "";
    private static String sHost = null;
    private static volatile CloudMessageManager sInstance = null;
    private static volatile boolean sIsFetchDataWithSocket = false;
    private static volatile boolean sIsInit = false;
    private static IMonitorLogConsumer sMonitorLogConsumer = null;
    private static IPatchConsumer sPatchConsumer = null;
    private static IPluginConsumer sPluginConsumer = null;
    private static IRouteConsumer sRouteConsumer = null;
    private static ITemplateConsumer sTemplateConsumer = null;
    private static volatile String sUid = "";
    private static volatile String sUpdateVersionCode = "";
    private List<IMessageHandler> mCloudControlHandler;
    private volatile WeakReference<ICommandReceiveObserver> mCommandReiveObserver;
    private volatile HashMap<String, String> mCommonParams;
    private final ExecutorService mExecutorService;
    private long mLastFetchTime;
    private Vector mObverserList;

    static {
    }

    static /* synthetic */ void access$000(CloudMessageManager r0, CloudMessage r1) {
        r0.handleCloudMessageInternal(r1);
    }

    static /* synthetic */ Context access$100() {
        return sContext;
    }

    public static void init(Context r1) {
        sIsInit = true;
        sContext = r1.getApplicationContext();
        getInstance();
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d("cloudmessage", new String[]{"CloudMessageManager Init."});
        return;
    }

    private CloudMessageManager() {
        this.mCommonParams = new HashMap();
        this.mCommandReiveObserver = null;
        this.mObverserList = new Vector(10);
        this.mExecutorService = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;
        ArrayList r0 = new ArrayList(20);
        r0.add(new FileUploadMessageHandler());
        r0.add(new CacheMessageHandler());
        r0.add(new StatMessageHandler());
        r0.add(new NetworkMessageHandler());
        r0.add(new RouteMessageHandler());
        r0.add(new TemplateMessageHandler());
        r0.add(new DBMessageHandler());
        r0.add(new SPMessageHandler());
        r0.add(new PermissionMessageHandler());
        r0.add(new MonitorLogMessageHandler());
        r0.add(new AlogMessageHandler());
        r0.add(new ABTestMessageHandler());
        r0.add(new PatchMessageHandler());
        r0.add(new PluginMessageHandler());
        r0.add(new HeapOOMMessageHandler());
        r0.add(new NetFlowMessageHandler());
        r0.add(new DataClearMessageHandler());
        r0.add(new ObversableMessageHandler());
        this.mCloudControlHandler = Collections.unmodifiableList(r0);
        handleCachedConsumer();
        clearDataCache();
        sDumpFileDir = dumpFileDir(sContext).getAbsolutePath() + "/dump.hprof";     // Catch: Exception -> L5
        return;
    }

    public static CloudMessageManager getInstance() {
        if (sInstance != null) goto L19;
        monitor-enter(CloudMessageManager.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (sInstance == null) goto L9;
    L13:
        monitor-exit(CloudMessageManager.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (sIsInit == false) goto L12;
        sInstance = new CloudMessageManager();     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("call CloudMessageManager.init() first");     // Catch: Throwable -> L15
    L19:
        return sInstance;
    }

    private void handleCachedConsumer() {
        IPluginConsumer r0 = sPluginConsumer;
        if (r0 == null) goto L5;
        setPluginMessageConsumer(r0);
        sPluginConsumer = null;
    L5:
        IPatchConsumer r1 = sPatchConsumer;
        if (r1 == null) goto L8;
        setPatchMessageConsumer(r1);
        sPatchConsumer = null;
    L8:
        IABTestConsumer r2 = sAbTestConsumer;
        if (r2 == null) goto L11;
        setABTestConsumer(r2);
        sAbTestConsumer = null;
    L11:
        IAlogConsumer r3 = sAlogConsumer;
        if (r3 == null) goto L14;
        setAlogConsumer(r3);
        sAlogConsumer = null;
    L14:
        IMonitorLogConsumer r4 = sMonitorLogConsumer;
        if (r4 == null) goto L17;
        setMonitorLogConsumer(r4);
        sMonitorLogConsumer = null;
    L17:
        IRouteConsumer r5 = sRouteConsumer;
        if (r5 == null) goto L20;
        setRouteConsumer(r5);
        sRouteConsumer = null;
    L20:
        ITemplateConsumer r6 = sTemplateConsumer;
        if (r6 == null) goto L24;
        setTemplateConsumer(r6);
        sTemplateConsumer = null;
        return;
    }

    public Context getContext() {
        return sContext;
    }

    public static boolean isFetchDataWithSocket() {
        return sIsFetchDataWithSocket;
    }

    public static void setFetchDataWithSocket(boolean r0) {
        sIsFetchDataWithSocket = r0;
    }

    public Enumeration getObverserList() {
        return this.mObverserList.elements();
    }

    public void registerCloudMessageObverser(CloudMessageObserver r1) {
        if (r1 == null) goto L5;
        addToObverserList(r1);
        return;
    }

    public void unregisterCloudMessageObverser(CloudMessageObserver r1) {
        if (r1 == null) goto L5;
        removeFromObverserList(r1);
        return;
    }

    private boolean addToObverserList(CloudMessageObserver r2) {
        if (this.mObverserList.contains(r2) == true) goto L6;
        this.mObverserList.add(r2);
        return true;
    L6:
        return false;
    }

    private boolean removeFromObverserList(CloudMessageObserver r2) {
        if (this.mObverserList.contains(r2) == false) goto L6;
        this.mObverserList.remove(r2);
        return true;
    L6:
        return false;
    }

    public void handleCloudMessage(final CloudMessage r3) {
        this.mExecutorService.execute(new AnonymousClass1(this, r3));
    }

    public void handleCloudMessage(final String r3) {
        this.mExecutorService.execute(new AnonymousClass2(this, r3));
    }

    public void handleCloudMessage(byte[] r4, Map<String, String> r5) {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("cloudmessage", new String[]{"handleCloudMessage payload and headers"});
    L5:
        if (r5 != null) goto L7;
    L14:
        String r6 = "";
    L16:
        if (TextUtils.isEmpty(r6) == false) goto L32;
        r6 = DecodeUtils.decodeData(r4);
    L32:
        JSONObject r7 = new JSONObject(r6).optJSONObject(Constants.KEY_CONFIG);     // Catch: JSONException -> L29
        if (r7 == null) goto L40;
        JSONArray r8 = r7.optJSONArray("cloud_commands");     // Catch: JSONException -> L29
        if (r8 == null) goto L41;
        int r9 = 0;
    L24:
        if (r9 >= r8.length()) goto L42;
        String r0 = r8.optString(r9);     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(r0) == true) goto L28;
        handleCloudMessage(r0);     // Catch: JSONException -> L29
    L28:
        r9 = r9 + 1;
        goto L24
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L29:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r5.size() <= 0) goto L14;
        Iterator<String> r1 = r5.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();
        if ("ran".equals(r2) == false) goto L10;
        r6 = DecodeUtils.decodeData(r4, r5.get(r2));
        goto L16
    }

    private void handleCloudMessageInternal(CloudMessage r4) {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("cloudmessage", new String[]{"handleCloudMessageInternal cloudMessage=" + r4});
    L5:
        if (r4 != null) goto L8;
        return;
    L8:
        if (this.mCommandReiveObserver != null) goto L10;
        ICommandReceiveObserver r0 = null;
    L11:
        if (r0 == null) goto L13;
        r0.notifyCommandReceived(r4);
    L13:
        Iterator<IMessageHandler> r3 = this.mCloudControlHandler.iterator();
    L15:
        if (r3.hasNext() == false) goto L22;
        if (r3.next().handleCloudMessage(r4) == false) goto L15;
        return;
    L22:
        return;
    L10:
        r0 = this.mCommandReiveObserver.get();
        goto L11
    }

    private void setTemplateConsumer(ITemplateConsumer r3) {
        if (r3 == null) goto L13;
        Iterator<IMessageHandler> r2 = this.mCloudControlHandler.iterator();
    L5:
        if (r2.hasNext() == false) goto L14;
        IMessageHandler r0 = r2.next();
        if ((r0 instanceof TemplateMessageHandler) == false) goto L5;
        ((TemplateMessageHandler) r0).setTemplateConsumer(r3);
        return;
    L14:
        return;
    }

    public static void setTemplateConsumerSafely(ITemplateConsumer r1) {
        if (sIsInit == false) goto L5;
        getInstance().setTemplateConsumer(r1);
        return;
    L5:
        sTemplateConsumer = r1;
    }

    private void setRouteConsumer(IRouteConsumer r3) {
        if (r3 == null) goto L13;
        Iterator<IMessageHandler> r2 = this.mCloudControlHandler.iterator();
    L5:
        if (r2.hasNext() == false) goto L14;
        IMessageHandler r0 = r2.next();
        if ((r0 instanceof RouteMessageHandler) == false) goto L5;
        ((RouteMessageHandler) r0).setRouteConsumer(r3);
        return;
    L14:
        return;
    }

    public static void setRouteConsumerSafely(IRouteConsumer r1) {
        if (sIsInit == false) goto L5;
        getInstance().setRouteConsumer(r1);
        return;
    L5:
        sRouteConsumer = r1;
    }

    private void setMonitorLogConsumer(IMonitorLogConsumer r3) {
        if (r3 == null) goto L13;
        Iterator<IMessageHandler> r2 = this.mCloudControlHandler.iterator();
    L5:
        if (r2.hasNext() == false) goto L14;
        IMessageHandler r0 = r2.next();
        if ((r0 instanceof MonitorLogMessageHandler) == false) goto L5;
        ((MonitorLogMessageHandler) r0).setMonitorLogConsumer(r3);
        return;
    L14:
        return;
    }

    public static void setMonitorLogConsumerSafely(IMonitorLogConsumer r1) {
        if (sIsInit == false) goto L5;
        getInstance().setMonitorLogConsumer(r1);
        return;
    L5:
        sMonitorLogConsumer = r1;
    }

    private void setAlogConsumer(IAlogConsumer r3) {
        if (r3 == null) goto L13;
        Iterator<IMessageHandler> r2 = this.mCloudControlHandler.iterator();
    L5:
        if (r2.hasNext() == false) goto L14;
        IMessageHandler r0 = r2.next();
        if ((r0 instanceof AlogMessageHandler) == false) goto L5;
        ((AlogMessageHandler) r0).setAlogConsumer(r3);
        return;
    L14:
        return;
    }

    public static void setAlogConsumerSafely(IAlogConsumer r1) {
        if (sIsInit == false) goto L5;
        getInstance().setAlogConsumer(r1);
        return;
    L5:
        sAlogConsumer = r1;
    }

    private void setABTestConsumer(IABTestConsumer r3) {
        if (r3 == null) goto L13;
        Iterator<IMessageHandler> r2 = this.mCloudControlHandler.iterator();
    L5:
        if (r2.hasNext() == false) goto L14;
        IMessageHandler r0 = r2.next();
        if ((r0 instanceof ABTestMessageHandler) == false) goto L5;
        ((ABTestMessageHandler) r0).setmAbTestConsumer(r3);
        return;
    L14:
        return;
    }

    public static void setABTestConsumerSafely(IABTestConsumer r1) {
        if (sIsInit == false) goto L5;
        getInstance().setABTestConsumer(r1);
        return;
    L5:
        sAbTestConsumer = r1;
    }

    private void setPatchMessageConsumer(IPatchConsumer r3) {
        if (r3 == null) goto L13;
        Iterator<IMessageHandler> r2 = this.mCloudControlHandler.iterator();
    L5:
        if (r2.hasNext() == false) goto L14;
        IMessageHandler r0 = r2.next();
        if ((r0 instanceof PatchMessageHandler) == false) goto L5;
        ((PatchMessageHandler) r0).setPatchConsumer(r3);
        return;
    L14:
        return;
    }

    public static void setPatchMessageConsumerSafely(IPatchConsumer r1) {
        if (sIsInit == false) goto L5;
        getInstance().setPatchMessageConsumer(r1);
        return;
    L5:
        sPatchConsumer = r1;
    }

    private void setPluginMessageConsumer(IPluginConsumer r3) {
        if (r3 == null) goto L13;
        Iterator<IMessageHandler> r2 = this.mCloudControlHandler.iterator();
    L5:
        if (r2.hasNext() == false) goto L14;
        IMessageHandler r0 = r2.next();
        if ((r0 instanceof PluginMessageHandler) == false) goto L5;
        ((PluginMessageHandler) r0).setPluginConsumer(r3);
        return;
    L14:
        return;
    }

    public static void setPluginMessageComsumerSafely(IPluginConsumer r1) {
        if (sIsInit == false) goto L5;
        getInstance().setPluginMessageConsumer(r1);
        return;
    L5:
        sPluginConsumer = r1;
    }

    public static String getUid() {
        return sUid;
    }

    public static void setUid(String r0) {
        sUid = r0;
    }

    public static String getAid() {
        return sAid;
    }

    public static void setAid(String r0) {
        sAid = r0;
    }

    public static String getUpdateVersionCode() {
        return sUpdateVersionCode;
    }

    public static void setUpdateVersionCode(String r0) {
        sUpdateVersionCode = r0;
    }

    public static String getDumpFileDir() {
        return sDumpFileDir;
    }

    public static void setDumpFileDir(String r0) {
        sDumpFileDir = r0;
    }

    public HashMap<String, String> getCommonParams() {
        return this.mCommonParams;
    }

    public void setCommonParams(HashMap<String, String> r1) {
        this.mCommonParams = r1;
    }

    public void setCommandReiveObserver(ICommandReceiveObserver r2) {
        if (r2 == null) goto L5;
        this.mCommandReiveObserver = new WeakReference(r2);
        return;
    }

    public static String[] getBlackListForCloudContrlInf() {
        return sBlackListForCloudContrlInf;
    }

    public static void setBlackListForCloudContrlInf(String[] r0) {
        sBlackListForCloudContrlInf = r0;
    }

    public static File dumpFileDir(Context r3) {
        File r0 = new File(r3.getExternalFilesDir(null) + "/monitor");
        if (r0.exists() == true) goto L5;
        r0.mkdir();
    L5:
        return r0;
    }

    private void clearDataCache() {
        this.mExecutorService.execute(new AnonymousClass3(this));
    }

    public void fetchCommandImmediately() {
        sHost = FileUploadServiceImpl.sHost;
        long r5 = System.currentTimeMillis();
        if ((r5 - this.mLastFetchTime) >= 120000) goto L6;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately too fast. just ignore for this time."});
        return;
    L6:
        this.mLastFetchTime = r5;
        String r4 = UrlUtils.addParamsToURL("https://" + sHost + ReportConsts.FETCH_CLOUD_MESSAGE_PATH, ApmContext.getQueryParamsMap());     // Catch: Exception -> L54
        HashMap r6 = new HashMap();     // Catch: Exception -> L54
        r6.put("Content-Type", RequestParams.APPLICATION_JSON);     // Catch: Exception -> L54
        r6.put("Version-Code", "1");     // Catch: Exception -> L54
        r6.put("Accept", RequestParams.APPLICATION_JSON);     // Catch: Exception -> L54
        HttpResponse r1 = ApmContext.doPost(r4, Tools.safeGetBytes(new JSONObject().toString()), r6);     // Catch: Exception -> L54
        int r7 = 0;
        if (ApmContext.isDebugMode() == false) goto L10;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately: url=" + r4});     // Catch: Exception -> L54
    L10:
        if (r1 != null) goto L14;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately: res null"});     // Catch: Exception -> L54
        return;
    L14:
        if (r1.getStatusCode() != 200) goto L65;
        JSONObject r3 = new JSONObject(new String(r1.getResponseBytes()));     // Catch: Exception -> L54
        if (ApmContext.isDebugMode() == false) goto L18;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately: resultMsg=" + r3.toString()});     // Catch: Exception -> L54
    L18:
        Map<String, String> r2 = r1.getHeaders();     // Catch: Exception -> L54
        if (r2 != null) goto L21;
    L32:
        String r8 = null;
    L33:
        String r0 = r3.optString("data");     // Catch: Exception -> L54
        if (r0.isEmpty() == true) goto L40;
        if (TextUtils.isEmpty(r8) == true) goto L38;
        r3 = new JSONObject(com.bytedance.apm.util.DecodeUtils.decodeData(r0.getBytes(), r8));     // Catch: Exception -> L54
        goto L40
    L38:
        r3 = new JSONObject(new String(r0.getBytes()));     // Catch: Exception -> L54
    L40:
        if (ApmContext.isDebugMode() == false) goto L43;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately resultMsg=" + r3});     // Catch: Exception -> L54
    L43:
        if (JsonUtils.isEmpty(r3) == false) goto L45;
        return;
    L45:
        JSONObject r9 = r3.optJSONObject(Constants.KEY_CONFIG);     // Catch: Exception -> L54
        if (JsonUtils.isEmpty(r9) == false) goto L48;
        return;
    L48:
        JSONArray r10 = r9.optJSONArray("cloud_commands");     // Catch: Exception -> L54
        if (r10 != null) goto L51;
        return;
    L51:
        if (r7 >= r10.length()) goto L67;
        handleCloudMessage(r10.optString(r7));     // Catch: Exception -> L54
        r7 = r7 + 1;
        goto L51
    L67:
        return;
    L21:
        if (r2.isEmpty() == true) goto L32;
        r8 = r2.get("ran");     // Catch: Exception -> L54
        if (TextUtils.isEmpty(r8) == false) goto L33;
        Iterator<Map.Entry<String, String>> r11 = r2.entrySet().iterator();     // Catch: Throwable -> L57
    L27:
        if (r11.hasNext() == false) goto L33;
        Map.Entry<String, String> r12 = r11.next();     // Catch: Throwable -> L57
        if ("ran".equalsIgnoreCase(r12.getKey()) == false) goto L27;
        r8 = r12.getValue();     // Catch: Throwable -> L57
        goto L33
    L65:
        return;
    L54:
        e = move-exception;
        Logger.printErrStackTrace("cloudmessage", e, new String[]{"fetchCommandImmediately error."});
    }
}
