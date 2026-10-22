package com.qualcomm.qti.internal.telephony.data;

import android.net.LinkProperties;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RegistrantList;
import android.os.RemoteException;
import android.telephony.data.DataCallResponse;
import android.telephony.data.DataProfile;
import android.telephony.data.NetworkSliceInfo;
import android.telephony.data.TrafficDescriptor;
import android.util.Pair;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.data.DataServiceManager;
import com.android.telephony.Rlog;
import com.qualcomm.qti.internal.telephony.QtiPhoneUtils;
import com.qualcomm.qti.internal.telephony.QtiTelephonyComponentFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class QtiDataServiceManager extends DataServiceManager {
    public static final String DATA_CALL_RESPONSE = "data_call_response";
    private static final int DEFAULT_PHONE_INDEX = 0;
    private static final int EVENT_GET_QOS_PARAMETERS_DONE = 101;
    private static final int EVENT_MODEM_RESET = 104;
    private static final int EVENT_QOS_PARAMETERS_CHANGED = 102;
    private static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 103;
    private static final int EVENT_RADIO_UNAVAILABLE = 105;
    private static final String PROPERTY_FETCH_QOS_PARAMETERS = "persist.vendor.radio.fetchqos";
    private boolean mIsFetchQosPropertyEnabled;
    private final RegistrantList mQosParametersChangedRegistrants;
    Map<Integer, FrameworkQosParameters> mQosParamsbyCid;

    public class QtiCellularDataServiceCallback extends DataServiceManager.DataServiceCallbackWrapper {
        final /* synthetic */ QtiDataServiceManager this$0;

        public /* bridge */ /* synthetic */ String getTag() {
            return super.getTag();
        }

        public /* bridge */ /* synthetic */ void onApnUnthrottled(String r1) {
            super.onApnUnthrottled(r1);
        }

        public /* bridge */ /* synthetic */ void onDataCallListChanged(List r1) {
            super.onDataCallListChanged(r1);
        }

        public /* bridge */ /* synthetic */ void onDataProfileUnthrottled(DataProfile r1) {
            super.onDataProfileUnthrottled(r1);
        }

        public /* bridge */ /* synthetic */ void onDeactivateDataCallComplete(int r1) {
            super.onDeactivateDataCallComplete(r1);
        }

        public /* bridge */ /* synthetic */ void onHandoverCancelled(int r1) {
            super.onHandoverCancelled(r1);
        }

        public /* bridge */ /* synthetic */ void onHandoverStarted(int r1) {
            super.onHandoverStarted(r1);
        }

        public /* bridge */ /* synthetic */ void onRequestDataCallListComplete(int r1, List r2) {
            super.onRequestDataCallListComplete(r1, r2);
        }

        public /* bridge */ /* synthetic */ void onSetDataProfileComplete(int r1) {
            super.onSetDataProfileComplete(r1);
        }

        public /* bridge */ /* synthetic */ void onSetInitialAttachApnComplete(int r1) {
            super.onSetInitialAttachApnComplete(r1);
        }

        QtiCellularDataServiceCallback(QtiDataServiceManager r1, String r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        public void onSetupDataCallComplete(int r6, DataCallResponse r7) {
            QtiDataServiceManager.access$000(this.this$0, "QtiDataServiceManager: onSetupDataCallComplete, resultCode = " + r6 + ", response = " + r7);
            this.this$0.removeMessages(2, this);
            Message r0 = (Message) QtiDataServiceManager.access$100(this.this$0).remove(asBinder());
            if (r0 == null) goto L13;
            r0.getData().putParcelable(QtiDataServiceManager.DATA_CALL_RESPONSE, r7);
            boolean r2 = true;
            if (r0.arg1 == 1) goto L8;
            r2 = false;
        L8:
            QtiDataServiceManager.access$200(this.this$0, "response isIms: " + r2);
            if (this.this$0.shouldFetchQosParameters() == false) goto L12;
            if (r2 == false) goto L12;
            QtiDataServiceManager.m731$$Nest$mrequestQosParameters(this.this$0, r7.getId(), r6, r0);
            return;
        L12:
            QtiDataServiceManager.access$300(this.this$0, r0, r6);
            return;
        L13:
            QtiDataServiceManager.access$400(this.this$0, "Unable to find the message for setup data call response.");
        }

        public void onQosParametersChanged(int r4, FrameworkQosParameters r5) {
            if (r5 != null) goto L5;
            QtiDataServiceManager.access$500(this.this$0, "onQosParametersChanged, qosParams is null");
            return;
        L5:
            QtiDataServiceManager.access$600(this.this$0, "onQosParametersChanged, cid: " + r4 + ", qosParams: " + r5);
            QtiDataServiceManager r3 = this.this$0;
            r3.sendMessage(r3.obtainMessage(102, r4, -1, r5));
        }
    }

    public static /* synthetic */ void $r8$lambda$oOvAxXvXtyh7Bbxk2z4iAorU_zs(QtiDataServiceManager r0) {
        r0.onQtiPhoneReady();
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestQosParameters, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m731$$Nest$mrequestQosParameters(QtiDataServiceManager r0, int r1, int r2, Message r3) {
        r0.requestQosParameters(r1, r2, r3);
    }

    static /* synthetic */ void access$000(QtiDataServiceManager r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ Map access$100(QtiDataServiceManager r0) {
        return r0.mMessageMap;
    }

    static /* synthetic */ void access$200(QtiDataServiceManager r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$300(QtiDataServiceManager r0, Message r1, int r2) {
        r0.sendCompleteMessage(r1, r2);
    }

    static /* synthetic */ void access$400(QtiDataServiceManager r0, String r1) {
        r0.loge(r1);
    }

    static /* synthetic */ void access$500(QtiDataServiceManager r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$600(QtiDataServiceManager r0, String r1) {
        r0.log(r1);
    }

    public QtiDataServiceManager(Phone r1, Looper r2, int r3) {
        super(r1, r2, r3);
        this.mQosParametersChangedRegistrants = new RegistrantList();
        this.mIsFetchQosPropertyEnabled = false;
        this.mQosParamsbyCid = new HashMap();
        this.mTag = "Qti" + this.mTag;
        updateQosPropertyValue();
        if (shouldFetchQosParameters() == false) goto L6;
        registerReceivers();
        registerListenerForQtiPhoneReady();
        return;
    }

    private void updateQosPropertyValue() {
        this.mIsFetchQosPropertyEnabled = QtiTelephonyComponentFactory.getInstance().getRil(0).getPropertyValueBool(PROPERTY_FETCH_QOS_PARAMETERS, false);     // Catch: Throwable -> L5
        log("mIsFetchQosPropertyEnabled: " + this.mIsFetchQosPropertyEnabled);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        loge("Exception while reading Qos property: " + e);
    }

    boolean shouldFetchQosParameters() {
        if (this.mIsFetchQosPropertyEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (getTransportType() != 1) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void registerReceivers() {
        log("Register modem events");
        this.mPhone.mCi.registerForOffOrNotAvailable(this, 103, null);
        this.mPhone.mCi.registerForModemReset(this, 104, null);
        this.mPhone.mCi.registerForNotAvailable(this, 105, null);
    }

    void registerListenerForQtiPhoneReady() {
        log("registerListenerForQtiPhoneReady");
        QtiPhoneUtils.addOnQtiPhoneReadyListener(new QtiDataServiceManager$$ExternalSyntheticLambda0(this));
    }

    private void onQtiPhoneReady() {
        log("onQtiPhoneReady");
        registerQosCallback();
    }

    private void registerQosCallback() {
        log("Registering QoS callback");     // Catch: RuntimeException -> L4
        QtiPhoneUtils r0 = QtiPhoneUtils.getInstance();     // Catch: RuntimeException -> L4
        QtiCellularDataServiceCallback r1 = new QtiCellularDataServiceCallback(this, "onQosParametersChanged");     // Catch: RuntimeException -> L4
        r0.registerDataServiceCallbackForQos(this.mPhone.getPhoneId(), r1);     // Catch: RuntimeException -> L4
        return;
    L4:
        loge("registerQosCallback: Error connecting to qti phone.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v14 */
    public void setupDataCall(int r18, DataProfile r19, boolean r20, boolean r21, int r22, LinkProperties r23, int r24, NetworkSliceInfo r25, TrafficDescriptor r26, boolean r27, Message r28) {
        log("setupDataCall from QtiDataServiceManager");
        if (this.mBound == true) goto L6;
        loge("setupDataCall: Data service not bound.");
        sendCompleteMessage(r28, 4);
        return;
    L6:
        QtiCellularDataServiceCallback r2 = new QtiCellularDataServiceCallback(this, "setupDataCall");
        if (r28 == null) goto L21;
        if (shouldFetchQosParameters() == true) goto L11;
    L15:
        this.mMessageMap.put(r2.asBinder(), r28);
        goto L21
    L11:
        if ((r19.getSupportedApnTypesBitmask() & 64) == 0) goto L13;
        ?? r4 = 1;
    L14:
        r28.arg1 = r4;
        log("setupDataCall request, apnmask: " + r19.getSupportedApnTypesBitmask() + ", isIms: " + r4);
        goto L15
    L13:
        r4 = 0;
    L21:
        sendMessageDelayed(obtainMessage(2, r2), 600000);     // Catch: RemoteException -> L19
        this.mIDataService.setupDataCall(this.mPhone.getPhoneId(), r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r2);     // Catch: RemoteException -> L19
        return;
    L19:
        loge("setupDataCall: Cannot invoke setupDataCall on data service.");
        this.mMessageMap.remove(r2.asBinder());
        sendCompleteMessage(r28, 4);
    }

    public void handleMessage(Message r2) {
        switch(r2.what) {
            case 101: goto L7;
            case 102: goto L6;
            case 103: goto L5;
            case 104: goto L5;
            case 105: goto L5;
            default: goto L4;
        };
    L4:
        super.handleMessage(r2);
        return;
    L5:
        resetQosParamsCache(r2.what);
        return;
    L6:
        log("EVENT_QOS_PARAMETERS_CHANGED");
        onQosParametersChanged(r2);
        return;
    L7:
        log("EVENT_GET_QOS_PARAMETERS_DONE");
        onGetQosParametersResponse(r2);
    }

    private void requestQosParameters(int r4, int r5, Message r6) {
        log("Request QoS params for cid: " + r4);
        QtiPhoneUtils.getInstance().getQosParameters(this.mPhone.getPhoneId(), r4, obtainMessage(101, r4, r5, r6));     // Catch: RemoteException -> L5 RuntimeException -> L8
        return;
    L5:
        e = move-exception;
        Rlog.e(this.mTag, "requestQosParameters, caught error while connecting to qtiphone.", e);
        sendCompleteMessage(r6, r5);
        return;
    L8:
        e = move-exception;
        Rlog.e(this.mTag, "requestQosParameters, caught error while fetching parameters." + e);
        sendCompleteMessage(r6, r5);
    }

    private void onGetQosParametersResponse(Message r6) {
        AsyncResult r0 = (AsyncResult) r6.obj;
        if (r0 != null) goto L5;
        return;
    L5:
        Message r1 = (Message) r0.userObj;
        if (r1 != null) goto L8;
    L18:
        loge("Unable to find the message for setup data call response.");
        return;
    L8:
        if (r1.getData() == null) goto L18;
        int r7 = r6.arg2;
        if (r0.exception == null) goto L13;
        Rlog.e(this.mTag, "onGetQosParametersResponse, caught exception.", r0.exception);
        sendCompleteMessage(r1, r7);
    L13:
        FrameworkQosParameters r2 = (FrameworkQosParameters) r0.result;
        if (r2 != null) goto L16;
        sendCompleteMessage(r1, r7);
    L16:
        DataCallResponse r3 = (DataCallResponse) r1.getData().getParcelable(DATA_CALL_RESPONSE);
        addToQosParamsMap(r3.getId(), r2);
        DataCallResponse r4 = appendQosParamsToDataCallResponse(r3, r2);
        r1.getData().putParcelable(DATA_CALL_RESPONSE, r4);
        sendCompleteMessage(r1, r7);
    }

    DataCallResponse appendQosParamsToDataCallResponse(DataCallResponse r3, FrameworkQosParameters r4) {
        if (r3 == null) goto L7;
        if (r4 == null) goto L7;
        log("appendQosParamsToDataCallResponse:, DataCallResponse: " + r3 + ", QoS parameters: " + r4);
        return new DataCallResponse.Builder().setCause(r3.getCause()).setRetryDurationMillis(r3.getRetryDurationMillis()).setId(r3.getId()).setLinkStatus(r3.getLinkStatus()).setProtocolType(r3.getProtocolType()).setInterfaceName(r3.getInterfaceName()).setAddresses(r3.getAddresses()).setDnsAddresses(r3.getDnsAddresses()).setGatewayAddresses(r3.getGatewayAddresses()).setPcscfAddresses(r3.getPcscfAddresses()).setMtu(r3.getMtu()).setMtuV4(r3.getMtuV4()).setMtuV6(r3.getMtuV6()).setHandoverFailureMode(r3.getHandoverFailureMode()).setPduSessionId(r3.getPduSessionId()).setDefaultQos(r4.getDefaultQos()).setQosBearerSessions(r4.getQosBearerSessions()).setSliceInfo(r3.getSliceInfo()).setTrafficDescriptors(r3.getTrafficDescriptors()).build();
    L7:
        return r3;
    }

    public DataCallResponse appendQosParamsToDataCallResponseIfNeeded(int r3, DataProfile r4, DataCallResponse r5) {
        if (r4 == null) goto L11;
        if (r5 == null) goto L11;
        if (shouldFetchQosParameters() == false) goto L11;
        if ((r4.getSupportedApnTypesBitmask() & 64) == 0) goto L11;
        log("appendQosParamsToDataCallResponseIfNeeded:, cid: " + r3 + ", DataProfile: " + r4 + ", DataCallResponse: " + r5);
        return appendQosParamsToDataCallResponse(r5, getQosParamsFromMap(r3));
    L11:
        return r5;
    }

    private void onQosParametersChanged(Message r4) {
        int r0 = r4.arg1;
        FrameworkQosParameters r5 = (FrameworkQosParameters) r4.obj;
        this.mQosParametersChangedRegistrants.notifyRegistrants(new AsyncResult(null, new Pair(Integer.valueOf(r0), r5), null));
    }

    void addToQosParamsMap(int r4, FrameworkQosParameters r5) {
        Map<Integer, FrameworkQosParameters> r0 = this.mQosParamsbyCid;
        monitor-enter(r0);
        this.mQosParamsbyCid.put(Integer.valueOf(r4), r5);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        StringBuilder r6 = new StringBuilder("Added QosParameters for cid ").append(r4).append(" into the map. QoS parameters: ");
        Object r7 = r5;
        if (r5 != null) goto L9;
        r7 = "null";
    L9:
        log(r6.append(r7).toString());
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void removeFromQosParamsMap(int r6) {
        Map<Integer, FrameworkQosParameters> r2 = this.mQosParamsbyCid;
        monitor-enter(r2);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mQosParamsbyCid.containsKey(Integer.valueOf(r6)) == false) goto L7;
        this.mQosParamsbyCid.remove(Integer.valueOf(r6));     // Catch: Throwable -> L10
        log("Removed QosParameters for cid " + r6 + " from map");     // Catch: Throwable -> L10
    L8:
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L7:
        log("QosParameters for cid " + r6 + " not present in map");     // Catch: Throwable -> L10
        goto L8
    }

    FrameworkQosParameters getQosParamsFromMap(int r5) {
        Map<Integer, FrameworkQosParameters> r1 = this.mQosParamsbyCid;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mQosParamsbyCid.containsKey(Integer.valueOf(r5)) == true) goto L10;
        log("No QosParameters available for cid " + r5 + " in the map.");     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return null;
    L10:
        FrameworkQosParameters r4 = this.mQosParamsbyCid.get(Integer.valueOf(r5));     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r4;
    }

    private void resetQosParamsCache(int r3) {
        log("Resetting QoS parameters cache due to " + messageToString(r3));
        Map<Integer, FrameworkQosParameters> r4 = this.mQosParamsbyCid;
        monitor-enter(r4);
        this.mQosParamsbyCid.clear();     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private String messageToString(int r1) {
        switch(r1) {
            case 103: goto L9;
            case 104: goto L7;
            case 105: goto L5;
            default: goto L4;
        };
    L5:
        return "EVENT_RADIO_UNAVAILABLE";
    L7:
        return "EVENT_MODEM_RESET";
    L9:
        return "EVENT_RADIO_OFF_OR_NOT_AVAILABLE";
    L4:
        return Integer.toString(r1);
    }

    public void registerForQosParametersChanged(Handler r2, int r3) {
        if (r2 == null) goto L5;
        this.mQosParametersChangedRegistrants.addUnique(r2, r3, null);
        return;
    }

    public void unregisterForQosParametersChanged(Handler r1) {
        if (r1 == null) goto L5;
        this.mQosParametersChangedRegistrants.remove(r1);
        return;
    }
}
