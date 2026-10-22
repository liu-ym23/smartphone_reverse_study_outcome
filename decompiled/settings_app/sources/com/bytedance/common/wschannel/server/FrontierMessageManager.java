package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.utils.WsAsyncIOTaskManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FrontierMessageManager {
    private static final String FRONTIER_MSGID_ACK_HEADER = "x_frontier_ack_msgid";
    private static final String FRONTIER_MSGID_HEADER = "x_frontier_msgid";
    private static final String FRONTIER_MSG_ACK_ENABLED_HEADER = "x_frontier_is_ack";
    private static final String FRONTIER_MSG_ACK_ENABLED_VALUE = "1";
    private static final String FRONTIER_QOS_ACK_ENABLED_HEADER = "x_frontier_qos_ack";
    private static final String FRONTIER_QOS_ACK_ENABLED_VALUE = "1";
    private static final String FRONTIER_QOS_HEADER = "x_frontier_qos";
    private static final String FRONTIER_QOS_VALUE = "2";
    private static final String FRONTIER_TTL_HEADER = "x_frontier_ttl";
    private static final String LOG_TYPE = "frontier_qos2";
    private static final String TAG = null;
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static final int WAIT_QOS_INIT_MAX_MILLS = 3000;
    private static Context sContext = null;
    private static IFrontierMessageDepend sFrontierMessageDepend = null;
    private static volatile FrontierPersistentBuffer sFrontierPersistentBuffer = null;
    private static final AtomicBoolean sLazyInitFinished = null;
    private static CountDownLatch sQoSInitFinishedCountDown = null;
    private static volatile boolean sQos2Enabled = false;
    private static Object sTTNetInitInstance;

    public interface IFrontierMessageDepend {
        void messageLogReport(String r1, JSONObject r2);
    }

    public FrontierMessageManager() {
    }

    static /* synthetic */ FrontierPersistentBuffer access$000() {
        return sFrontierPersistentBuffer;
    }

    static /* synthetic */ FrontierPersistentBuffer access$002(FrontierPersistentBuffer r0) {
        sFrontierPersistentBuffer = r0;
        return r0;
    }

    static /* synthetic */ Context access$100() {
        return sContext;
    }

    static {
        sLazyInitFinished = new AtomicBoolean(false);
        sQoSInitFinishedCountDown = new CountDownLatch(1);
        TAG = "FrontierMessageManager";
    }

    public static void enableQos2OnFrontierConnection(boolean r0, Context r1, IFrontierMessageDepend r2) {
        if (r1 == null) goto L6;
        sQos2Enabled = r0;
        sContext = r1;
        sFrontierMessageDepend = r2;
        return;
    L6:
        throw new IllegalArgumentException("Context must not be null.");
    }

    public static void reportFrontierMessageLog(JSONObject r8) {
        IFrontierMessageDepend r0 = sFrontierMessageDepend;
        if (r0 == null) goto L10;
        r0.messageLogReport(LOG_TYPE, r8);
    L10:
        Object r1 = sTTNetInitInstance;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        Reflect.on(r1).call("monitorLogSend", new Class[]{String.class, JSONObject.class}, new Object[]{LOG_TYPE, r8});     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    private static void tryWaitPersistentBufferInit() {
        if (sLazyInitFinished.get() == true) goto L11;
        sQoSInitFinishedCountDown.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        if (sQoSInitFinishedCountDown.getCount() != 1) goto L12;
        sQoSInitFinishedCountDown.countDown();     // Catch: Exception -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    static void setPersistentBufferInitFinished() {
        sLazyInitFinished.set(true);
        sQoSInitFinishedCountDown.countDown();
    }

    private static Map<String, String> covertMsgHeadersToMap(List<WsChannelMsg.MsgHeader> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L24;
        HashMap r0 = new HashMap();
        Iterator<WsChannelMsg.MsgHeader> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        WsChannelMsg.MsgHeader r1 = r4.next();
        if (TextUtils.isEmpty(r1.getKey()) == true) goto L8;
        if (TextUtils.isEmpty(r1.getValue()) == true) goto L8;
        r0.put(r1.getKey(), r1.getValue());
        goto L8
    L14:
        return r0;
    L24:
        return null;
    }

    private static boolean isValidMsgHeader(Map<String, String> r5) {
        if (r5.containsKey(FRONTIER_QOS_HEADER) == true) goto L5;
    L26:
        return false;
    L5:
        if (r5.containsKey("x_frontier_msgid") == false) goto L26;
        if (r5.containsKey(FRONTIER_TTL_HEADER) == false) goto L26;
        if (r5.get(FRONTIER_QOS_HEADER) == null) goto L26;
        if (r5.get(FRONTIER_QOS_HEADER).equals("2") == false) goto L26;
        String r0 = r5.get("x_frontier_msgid");
        if (TextUtils.isEmpty(r0) == true) goto L26;
        if (r0.getBytes("UTF-8").length != 32) goto L26;
        if (Long.valueOf(r5.get(FRONTIER_TTL_HEADER)).longValue() > 0) goto L24;
        return false;
    L24:
        return true;
    }

    private static boolean isValidAckMsgHeader(Map<String, String> r6) {
        if (r6.containsKey(FRONTIER_QOS_HEADER) == true) goto L5;
    L31:
        return false;
    L5:
        if (r6.containsKey(FRONTIER_QOS_ACK_ENABLED_HEADER) == false) goto L31;
        if (r6.containsKey(FRONTIER_MSG_ACK_ENABLED_HEADER) == false) goto L31;
        if (r6.containsKey(FRONTIER_MSGID_ACK_HEADER) == false) goto L31;
        if (r6.get(FRONTIER_QOS_HEADER) == null) goto L31;
        if (r6.get(FRONTIER_QOS_HEADER).equals("2") == false) goto L31;
        if (r6.get(FRONTIER_QOS_ACK_ENABLED_HEADER) == null) goto L31;
        if (r6.get(FRONTIER_QOS_ACK_ENABLED_HEADER).equals("1") == false) goto L31;
        if (r6.get(FRONTIER_MSG_ACK_ENABLED_HEADER) == null) goto L31;
        if (r6.get(FRONTIER_MSG_ACK_ENABLED_HEADER).equals("1") == false) goto L31;
        if (TextUtils.isEmpty(r6.get(FRONTIER_MSGID_ACK_HEADER)) == false) goto L29;
        return false;
    L29:
        return true;
    }

    private static String[] getAckMsgIdFromCurrentMessage(Map<String, String> r4) {
        if (r4.containsKey(FRONTIER_MSG_ACK_ENABLED_HEADER) == true) goto L5;
    L15:
        return null;
    L5:
        if (r4.containsKey(FRONTIER_MSGID_ACK_HEADER) == false) goto L15;
        if (r4.get(FRONTIER_MSG_ACK_ENABLED_HEADER).equals("1") == true) goto L11;
        return null;
    L11:
        if (TextUtils.isEmpty(r4.get(FRONTIER_MSGID_ACK_HEADER)) == false) goto L14;
        return null;
    L14:
        return r4.get(FRONTIER_MSGID_ACK_HEADER).split(",");
    }

    private static boolean isFrontierMsgHeader(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.equals(FRONTIER_QOS_HEADER) == false) goto L8;
    L15:
        return true;
    L8:
        if (r2.equals("x_frontier_msgid") == true) goto L15;
        if (r2.equals(FRONTIER_TTL_HEADER) == true) goto L15;
        if (r2.equals(FRONTIER_MSGID_ACK_HEADER) == true) goto L15;
        if (r2.equals(FRONTIER_MSG_ACK_ENABLED_HEADER) == true) goto L15;
        return false;
    }

    private static void removeFrontierHeaderForWsMsg(WsChannelMsg r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.getMsgHeaders() == null) goto L20;
        Iterator<WsChannelMsg.MsgHeader> r2 = r1.getMsgHeaders().iterator();
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.hasNext() == false) goto L21;
        if (isFrontierMsgHeader(r2.next().getKey()) == false) goto L10;
        r2.remove();
        goto L10
    L21:
        return;
    }

    private static void initTTNetInitInstance() {
        if (sTTNetInitInstance == null) goto L12;
        return;
    L12:
        sTTNetInitInstance = Class.forName(TTNET_INIT_CLASS).newInstance();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "Get TTNetInit instance success.");     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.e(TAG, "Get TTNetInit instance failed.");
        th.printStackTrace();
    }

    public static boolean shouldDropMessageByFilter(WsChannelMsg r7) {
        if (sQos2Enabled == true) goto L35;
        return false;
    L35:
        Map<String, String> r1 = covertMsgHeadersToMap(r7.getMsgHeaders());     // Catch: Throwable -> L32
        if (r1 != null) goto L8;
    L31:
        return false;
    L8:
        if (r1.isEmpty() == true) goto L31;
        boolean r3 = isValidAckMsgHeader(r1);     // Catch: Throwable -> L32
        boolean r4 = isValidMsgHeader(r1);     // Catch: Throwable -> L32
        if (r3 == true) goto L14;
        if (r4 == true) goto L14;
        return false;
    L14:
        AtomicBoolean r5 = sLazyInitFinished;     // Catch: Throwable -> L32
        if (r5.get() == true) goto L18;
        initTTNetInitInstance();     // Catch: Throwable -> L32
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass1());     // Catch: Throwable -> L32
        tryWaitPersistentBufferInit();     // Catch: Throwable -> L32
    L18:
        if (r5.get() == true) goto L21;
        return false;
    L21:
        if (sFrontierPersistentBuffer != null) goto L24;
        return false;
    L24:
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "origin wschannel msg:" + r7.toString());     // Catch: Throwable -> L32
    L26:
        if (r3 == false) goto L29;
        sFrontierPersistentBuffer.ackMessage(r1.get(FRONTIER_MSGID_ACK_HEADER).split(","));     // Catch: Throwable -> L32
        return true;
    L29:
        sFrontierPersistentBuffer.ackMessage(getAckMsgIdFromCurrentMessage(r1));     // Catch: Throwable -> L32
        removeFrontierHeaderForWsMsg(r7);     // Catch: Throwable -> L32
        return sFrontierPersistentBuffer.shouldDropMessageAndUpdateFile(r1.get("x_frontier_msgid"), Long.valueOf(r1.get(FRONTIER_TTL_HEADER)).longValue());
    L32:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean isQos2Enabled() {
        return sQos2Enabled;
    }
}
