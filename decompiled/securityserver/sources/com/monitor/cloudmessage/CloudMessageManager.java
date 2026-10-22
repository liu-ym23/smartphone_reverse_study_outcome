package com.monitor.cloudmessage;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.report.FileUploadServiceImpl;
import com.bytedance.apm.util.DecodeUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.UrlUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.Tools;
import com.bytedance.services.apm.api.HttpResponse;
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

/* JADX INFO: loaded from: classes.dex */
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

    public static /* synthetic */ void access$000(CloudMessageManager r0, CloudMessage r1) {
        r0.handleCloudMessageInternal(r1);
    }

    public static /* synthetic */ Context access$100() {
        return sContext;
    }

    private boolean addToObverserList(CloudMessageObserver r2) {
        if (this.mObverserList.contains(r2) == true) goto L6;
        this.mObverserList.add(r2);
        return true;
    L6:
        return false;
    }

    private void clearDataCache() {
        this.mExecutorService.execute(new AnonymousClass3(this));
    }

    public static File dumpFileDir(Context r3) {
        File r0 = new File(r3.getExternalFilesDir(null) + "/monitor");
        if (r0.exists() == true) goto L5;
        r0.mkdir();
    L5:
        return r0;
    }

    public static String getAid() {
        return sAid;
    }

    public static String[] getBlackListForCloudContrlInf() {
        return sBlackListForCloudContrlInf;
    }

    public static String getDumpFileDir() {
        return sDumpFileDir;
    }

    public static CloudMessageManager getInstance() {
        if (sInstance != null) goto L20;
        monitor-enter(CloudMessageManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance == null) goto L9;
    L15:
        monitor-exit(CloudMessageManager.class);     // Catch: Throwable -> L11
        goto L20
    L9:
        if (sIsInit == false) goto L14;
        sInstance = new CloudMessageManager();     // Catch: Throwable -> L11
        goto L15
    L14:
        throw new RuntimeException("call CloudMessageManager.init() first");     // Catch: Throwable -> L11
    L20:
        return sInstance;
    }

    public static String getUid() {
        return sUid;
    }

    public static String getUpdateVersionCode() {
        return sUpdateVersionCode;
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

    private void handleCloudMessageInternal(CloudMessage r3) {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d("cloudmessage", new String[]{"handleCloudMessageInternal cloudMessage=" + r3});
    L5:
        if (r3 != null) goto L8;
        return;
    L8:
        if (this.mCommandReiveObserver != null) goto L10;
        ICommandReceiveObserver r0 = null;
    L11:
        if (r0 == null) goto L13;
        r0.notifyCommandReceived(r3);
    L13:
        Iterator<IMessageHandler> r2 = this.mCloudControlHandler.iterator();
    L15:
        if (r2.hasNext() == false) goto L22;
        if (r2.next().handleCloudMessage(r3) == false) goto L15;
        return;
    L22:
        return;
    L10:
        r0 = this.mCommandReiveObserver.get();
        goto L11
    }

    public static void init(Context r1) {
        sIsInit = true;
        sContext = r1.getApplicationContext();
        getInstance();
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d("cloudmessage", new String[]{"CloudMessageManager Init."});
        return;
    }

    public static boolean isFetchDataWithSocket() {
        return sIsFetchDataWithSocket;
    }

    private boolean removeFromObverserList(CloudMessageObserver r2) {
        if (this.mObverserList.contains(r2) == false) goto L6;
        this.mObverserList.remove(r2);
        return true;
    L6:
        return false;
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

    public static void setAid(String r0) {
        sAid = r0;
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

    public static void setBlackListForCloudContrlInf(String[] r0) {
        sBlackListForCloudContrlInf = r0;
    }

    public static void setDumpFileDir(String r0) {
        sDumpFileDir = r0;
    }

    public static void setFetchDataWithSocket(boolean r0) {
        sIsFetchDataWithSocket = r0;
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

    public static void setPluginMessageComsumerSafely(IPluginConsumer r1) {
        if (sIsInit == false) goto L5;
        getInstance().setPluginMessageConsumer(r1);
        return;
    L5:
        sPluginConsumer = r1;
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

    public static void setUid(String r0) {
        sUid = r0;
    }

    public static void setUpdateVersionCode(String r0) {
        sUpdateVersionCode = r0;
    }

    public void fetchCommandImmediately() {
        sHost = FileUploadServiceImpl.sHost;
        long r5 = System.currentTimeMillis();
        if ((r5 - this.mLastFetchTime) >= 120000) goto L6;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately too fast. just ignore for this time."});
        return;
    L6:
        this.mLastFetchTime = r5;
        String r4 = UrlUtils.addParamsToURL("https://" + sHost + ReportConsts.FETCH_CLOUD_MESSAGE_PATH, ApmContext.getQueryParamsMap());     // Catch: Exception -> L10
        HashMap r6 = new HashMap();     // Catch: Exception -> L10
        r6.put("Content-Type", "application/json");     // Catch: Exception -> L10
        r6.put("Version-Code", "1");     // Catch: Exception -> L10
        r6.put("Accept", "application/json");     // Catch: Exception -> L10
        HttpResponse r1 = ApmContext.doPost(r4, Tools.safeGetBytes(new JSONObject().toString()), r6);     // Catch: Exception -> L10
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately: url=" + r4});     // Catch: Exception -> L10
    L12:
        if (r1 != null) goto L16;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately: res null"});     // Catch: Exception -> L10
        return;
    L16:
        if (r1.getStatusCode() != 200) goto L67;
        JSONObject r3 = new JSONObject(new String(r1.getResponseBytes()));     // Catch: Exception -> L10
        if (ApmContext.isDebugMode() == false) goto L20;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately: resultMsg=" + r3.toString()});     // Catch: Exception -> L10
    L20:
        Map<String, String> r2 = r1.getHeaders();     // Catch: Exception -> L10
        if (r2 != null) goto L23;
    L34:
        String r7 = null;
    L35:
        String r0 = r3.optString("data");     // Catch: Exception -> L10
        if (r0.isEmpty() == true) goto L42;
        if (TextUtils.isEmpty(r7) == true) goto L40;
        r3 = new JSONObject(DecodeUtils.decodeData(r0.getBytes(), r7));     // Catch: Exception -> L10
        goto L42
    L40:
        r3 = new JSONObject(new String(r0.getBytes()));     // Catch: Exception -> L10
    L42:
        if (ApmContext.isDebugMode() == false) goto L45;
        Logger.d("cloudmessage", new String[]{"fetchCommandImmediately resultMsg=" + r3});     // Catch: Exception -> L10
    L45:
        if (JsonUtils.isEmpty(r3) == false) goto L47;
        return;
    L47:
        JSONObject r8 = r3.optJSONObject(Constants.KEY_CONFIG);     // Catch: Exception -> L10
        if (JsonUtils.isEmpty(r8) == false) goto L50;
        return;
    L50:
        JSONArray r9 = r8.optJSONArray("cloud_commands");     // Catch: Exception -> L10
        if (r9 == null) goto L68;
        int r10 = 0;
    L54:
        if (r10 >= r9.length()) goto L69;
        handleCloudMessage(r9.optString(r10));     // Catch: Exception -> L10
        r10 = r10 + 1;
        goto L54
    L69:
        return;
    L68:
        return;
    L23:
        if (r2.isEmpty() == true) goto L34;
        r7 = r2.get("ran");     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r7) == false) goto L35;
        Iterator<Map.Entry<String, String>> r11 = r2.entrySet().iterator();     // Catch: Throwable -> L59
    L29:
        if (r11.hasNext() == false) goto L35;
        Map.Entry<String, String> r12 = r11.next();     // Catch: Throwable -> L59
        if ("ran".equalsIgnoreCase(r12.getKey()) == false) goto L29;
        r7 = r12.getValue();     // Catch: Throwable -> L59
        goto L35
    L67:
        return;
    L10:
        e = move-exception;
        Logger.printErrStackTrace("cloudmessage", e, new String[]{"fetchCommandImmediately error."});
    }

    public HashMap<String, String> getCommonParams() {
        return this.mCommonParams;
    }

    public Context getContext() {
        return sContext;
    }

    public Enumeration getObverserList() {
        return this.mObverserList.elements();
    }

    public void handleCloudMessage(final CloudMessage r3) {
        this.mExecutorService.execute(new AnonymousClass1(this, r3));
    }

    public void registerCloudMessageObverser(CloudMessageObserver r1) {
        if (r1 == null) goto L5;
        addToObverserList(r1);
        return;
    }

    public void setCommandReiveObserver(ICommandReceiveObserver r2) {
        if (r2 == null) goto L5;
        this.mCommandReiveObserver = new WeakReference(r2);
        return;
    }

    public void setCommonParams(HashMap<String, String> r1) {
        this.mCommonParams = r1;
    }

    public void unregisterCloudMessageObverser(CloudMessageObserver r1) {
        if (r1 == null) goto L5;
        removeFromObverserList(r1);
        return;
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
        if (TextUtils.isEmpty(r6) == false) goto L34;
        r6 = com.monitor.cloudmessage.utils.DecodeUtils.decodeData(r4);
    L34:
        JSONObject r7 = new JSONObject(r6).optJSONObject(Constants.KEY_CONFIG);     // Catch: JSONException -> L29
        if (r7 == null) goto L42;
        JSONArray r8 = r7.optJSONArray("cloud_commands");     // Catch: JSONException -> L29
        if (r8 == null) goto L43;
        int r9 = 0;
    L24:
        if (r9 >= r8.length()) goto L44;
        String r0 = r8.optString(r9);     // Catch: JSONException -> L29
        if (TextUtils.isEmpty(r0) == true) goto L31;
        handleCloudMessage(r0);     // Catch: JSONException -> L29
    L31:
        r9 = r9 + 1;
        goto L24
    L44:
        return;
    L43:
        return;
    L42:
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
        r6 = com.monitor.cloudmessage.utils.DecodeUtils.decodeData(r4, r5.get(r2));
        goto L16
    }
}
