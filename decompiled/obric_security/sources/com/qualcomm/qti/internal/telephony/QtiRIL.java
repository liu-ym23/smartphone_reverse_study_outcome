package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.hardware.radio.V1_0.IRadio;
import android.hardware.radio.V1_0.RadioResponseInfo;
import android.hardware.radio.V1_0.SendSmsResult;
import android.hidl.manager.V1_0.IServiceManager;
import android.hidl.manager.V1_0.IServiceNotification;
import android.os.AsyncResult;
import android.os.IHwBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.ImsiEncryptionInfo;
import android.telephony.NetworkScanRequest;
import android.telephony.Rlog;
import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.NetworkScanResult;
import com.android.internal.telephony.OperatorInfo;
import com.android.internal.telephony.RIL;
import com.android.internal.telephony.RILRequest;
import com.android.internal.telephony.RILUtils;
import com.android.internal.telephony.SmsResponse;
import java.util.concurrent.atomic.AtomicLong;
import org.codeaurora.internal.NrConfig;
import vendor.qti.hardware.radio.qtiradio.V1_0.IQtiRadio;
import vendor.qti.hardware.radio.qtiradio.V1_0.QtiRadioResponseInfo;
import vendor.qti.hardware.radio.qtiradio.V2_0.DcParam;
import vendor.qti.hardware.radio.qtiradio.V2_0.SignalStrength;
import vendor.qti.hardware.radio.qtiradio.V2_1.UpperLayerIndInfo;
import vendor.qti.hardware.radio.qtiradio.V2_2.IQtiRadioIndication;
import vendor.qti.hardware.radio.qtiradio.V2_5.IQtiRadioResponse;

/* JADX INFO: loaded from: classes4.dex */
public final class QtiRIL extends RIL {
    private static final int ACCESS_MODE_PLMN = 1;
    private static final String NETWORK_ACCESS_MODE = "access_mode";
    private static final String PROPERTY_CAG_SNPN = "persist.vendor.cag_snpn";
    static final String[] QTI_HIDL_SERVICE_NAME = null;
    static final String TAG = "QTIRILJ";
    private int mCagSnpnFeatureStatus;
    IQtiRadioIndication.Stub mClientRadioIndicationCb;
    IQtiRadioResponse.Stub mClientRadioResponseCb;
    final QtiRadioProxyDeathRecipient mDeathRecipient;
    private QtiCarrierInfoManager.QtiCarrierInfoResponse mQtiCarrierInfoResponse;
    int mQtiPhoneId;
    private IQtiRadio mQtiRadio;
    QtiRadioIndication mQtiRadioIndication;
    final AtomicLong mQtiRadioProxyCookie;
    QtiRadioResponse mQtiRadioResponse;
    private final QtiRadioServiceNotification mServiceNotification;

    public class QtiRadioIndication extends IQtiRadioIndication.Stub {
        static final String TAG = "QtiRadioIndication";
        int mSlotId;
        final /* synthetic */ QtiRIL this$0;

        public QtiRadioIndication(QtiRIL r2, int r3) {
            this.this$0 = r2;
            Rlog.d(TAG, "[" + r3 + "]Constructor: ");
            this.mSlotId = r3;
        }

        public void on5gStatusChange(int r3) {
            Rlog.d(TAG, "on5gStatusChange: slotId = " + this.mSlotId);
            if (this.this$0.mClientRadioIndicationCb == null) goto L11;
            this.this$0.mClientRadioIndicationCb.on5gStatusChange(r3);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onNrDcParamChange(DcParam r3) {
            Rlog.d(TAG, "onNrDcParamChange: slotId = " + this.mSlotId);
            if (this.this$0.mClientRadioIndicationCb == null) goto L11;
            this.this$0.mClientRadioIndicationCb.onNrDcParamChange(r3);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onNrBearerAllocationChange_2_1(int r3) {
            Rlog.d(TAG, "onNrBearerAllocationChange_2_1: slotId = " + this.mSlotId);
            if (this.this$0.mClientRadioIndicationCb == null) goto L11;
            this.this$0.mClientRadioIndicationCb.onNrBearerAllocationChange_2_1(r3);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onNrBearerAllocationChange(int r3) {
            Rlog.d(TAG, "onNrBearerAllocationChange: slotId = " + this.mSlotId);
            if (this.this$0.mClientRadioIndicationCb == null) goto L11;
            this.this$0.mClientRadioIndicationCb.onNrBearerAllocationChange(r3);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onUpperLayerIndInfoChange(UpperLayerIndInfo r3) {
            Rlog.d(TAG, "onUpperLayerIndInfoChange: UpperLayerIndInfo = " + r3);
            if (this.this$0.mClientRadioIndicationCb == null) goto L11;
            this.this$0.mClientRadioIndicationCb.onUpperLayerIndInfoChange(r3);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void on5gConfigInfoChange(int r3) {
            Rlog.d(TAG, "on5gConfigInfoChange: ConfigType = " + r3);
            if (this.this$0.mClientRadioIndicationCb == null) goto L11;
            this.this$0.mClientRadioIndicationCb.on5gConfigInfoChange(r3);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onNrIconTypeChange(int r3) {
            Rlog.d(TAG, "onNrIconTypeChange: iconType = " + r3);
            if (this.this$0.mClientRadioIndicationCb == null) goto L11;
            this.this$0.mClientRadioIndicationCb.onNrIconTypeChange(r3);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onSignalStrengthChange(SignalStrength r3) {
            Rlog.d(TAG, "onSignalStrengthChange: slotId = " + this.mSlotId);
            if (this.this$0.mClientRadioIndicationCb == null) goto L11;
            this.this$0.mClientRadioIndicationCb.onSignalStrengthChange(r3);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void qtiRadioIndication(int r1) {
            Rlog.d(TAG, "qtiRadioIndication: NOP!!");
        }
    }

    final class QtiRadioProxyDeathRecipient implements IHwBinder.DeathRecipient {
        final /* synthetic */ QtiRIL this$0;

        QtiRadioProxyDeathRecipient(QtiRIL r1) {
            this.this$0 = r1;
        }

        public void serviceDied(long r1) {
            Rlog.d(QtiRIL.TAG, "serviceDied");
            QtiRIL.m679$$Nest$mresetServiceAndRequestList(this.this$0);
        }
    }

    public class QtiRadioResponse extends vendor.qti.hardware.radio.qtiradio.V2_6.IQtiRadioResponse.Stub {
        static final String QTI_RILJ_LOG_TAG = "QtiRadioResponse";
        QtiRIL mRil;
        final /* synthetic */ QtiRIL this$0;

        private int convertToQtiNetworkTypeBitMask(int r7) {
            if ((65536 & r7) == 0) goto L5;
            int r6 = (int) (((long) 0) | 32768);
        L7:
            if ((r7 & 2) == 0) goto L10;
            r6 = (int) (((long) r6) | 1);
        L10:
            if ((r7 & 4) == 0) goto L13;
            r6 = (int) (((long) r6) | 2);
        L13:
            if ((r7 & 16) == 0) goto L16;
            r6 = (int) (((long) r6) | 8);
        L16:
            if ((r7 & 32) == 0) goto L19;
            r6 = (int) (((long) r6) | 8);
        L19:
            if ((r7 & 64) == 0) goto L22;
            r6 = (int) (((long) r6) | 64);
        L22:
            if ((r7 & 128) == 0) goto L25;
            r6 = (int) (((long) r6) | 16);
        L25:
            if ((r7 & 256) == 0) goto L28;
            r6 = (int) (((long) r6) | 32);
        L28:
            if ((r7 & 4096) == 0) goto L31;
            r6 = (int) (((long) r6) | 2048);
        L31:
            if ((r7 & 8192) == 0) goto L34;
            r6 = (int) (((long) r6) | 8192);
        L34:
            if ((r7 & 1024) == 0) goto L37;
            r6 = (int) (((long) r6) | 256);
        L37:
            if ((r7 & 512) == 0) goto L40;
            r6 = (int) (((long) r6) | 128);
        L40:
            if ((r7 & 2048) == 0) goto L43;
            r6 = (int) (((long) r6) | 512);
        L43:
            if ((32768 & r7) == 0) goto L46;
            r6 = (int) (((long) r6) | 16384);
        L46:
            if ((r7 & 8) == 0) goto L49;
            r6 = (int) (((long) r6) | 4);
        L49:
            if ((131072 & r7) == 0) goto L52;
            r6 = (int) (((long) r6) | 65536);
        L52:
            if ((r7 & 16384) == 0) goto L55;
            r6 = (int) (((long) r6) | 4096);
        L55:
            if ((524288 & r7) == 0) goto L58;
            r6 = (int) (((long) r6) | 262144);
        L58:
            if ((1048576 & r7) == 0) goto L61;
            r6 = (int) (((long) r6) | 524288);
        L61:
            if ((r7 & 2097152) == 0) goto L63;
            r6 = (int) (((long) r6) | 1048576);
        L63:
            if (r6 != 0) goto L66;
            return 0;
        L66:
            return r6;
        L5:
            r6 = 0;
            goto L7
        }

        public QtiRadioResponse(QtiRIL r1, QtiRIL r2) {
            this.this$0 = r1;
            this.mRil = r2;
        }

        void sendMessageResponse(Message r1, Object r2) {
            if (r1 == null) goto L5;
            AsyncResult.forMessage(r1, r2, null);
            r1.sendToTarget();
            return;
        }

        RadioResponseInfo toRadioResponseInfo(QtiRadioResponseInfo r2) {
            RadioResponseInfo r1 = new RadioResponseInfo();
            r1.type = r2.type;
            r1.serial = r2.serial;
            r1.error = r2.error;
            return r1;
        }

        private void responseString(RadioResponseInfo r4, String r5) {
            Object r0 = this.mRil.qtiProcessResponse(r4);
            Message r1 = this.mRil.qtiGetMessageFromRequest(r0);
            if (r1 != null) goto L5;
            return;
        L5:
            if (r4.error != 0) goto L7;
            sendMessageResponse(r1, r5);
        L7:
            this.mRil.qtiProcessResponseDone(r0, r4, r5);
        }

        public void getAtrResponse(QtiRadioResponseInfo r3, String r4) {
            Rlog.d(QTI_RILJ_LOG_TAG, "getAtrResponse");
            responseString(toRadioResponseInfo(r3), r4);
        }

        public void onEnable5gResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "onEnable5gResponse: serial = " + r3 + " errorCode = " + r4 + " status = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onEnable5gResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onDisable5gResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "onDisable5gResponse: serial = " + r3 + " errorCode = " + r4 + " status = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onDisable5gResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onEnable5gOnlyResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "onEnable5gOnlyResponse: serial = " + r3 + " errorCode = " + r4 + " status = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onEnable5gOnlyResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void on5gStatusResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "on5gStatusResponse: serial = " + r3 + " errorCode = " + r4 + " enabled = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.on5gStatusResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onNrDcParamResponse(int r3, int r4, DcParam r5) {
            Rlog.d(QtiRIL.TAG, "onNrDcParamResponse: serial = " + r3 + " errorCode = " + r4 + " dcParam = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onNrDcParamResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onNrBearerAllocationResponse_2_1(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "onNrBearerAllocationResponse_2_1: serial = " + r3 + " errorCode = " + r4 + " bearerStatus = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onNrBearerAllocationResponse_2_1(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onNrBearerAllocationResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "onNrBearerAllocationResponse: serial = " + r3 + " errorCode = " + r4 + " bearerStatus = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onNrBearerAllocationResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onUpperLayerIndInfoResponse(int r3, int r4, UpperLayerIndInfo r5) {
            Rlog.d(QtiRIL.TAG, "UpperLayerIndInfoResponse: serial = " + r3 + " errorCode = " + r4 + " UpperLayerIndInfo = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onUpperLayerIndInfoResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void on5gConfigInfoResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "on5gConfigInfoResponse: serial = " + r3 + " errorCode = " + r4 + " ConfigType = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.on5gConfigInfoResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onSignalStrengthResponse(int r3, int r4, SignalStrength r5) {
            Rlog.d(QtiRIL.TAG, "onSignalStrengthResponse: serial = " + r3 + " errorCode = " + r4 + " signalStrength = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onSignalStrengthResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onNrIconTypeResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "onNrIconTypeResponse: serial = " + r3 + " errorCode = " + r4 + " iconType = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onNrIconTypeResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onEnableEndcResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "onEnableEndcResponse: serial = " + r3 + " errorCode = " + r4 + " status = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onEnableEndcResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onEndcStatusResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "onEndcStatusResponse: serial = " + r3 + " errorCode = " + r4 + " endcStatus = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onEndcStatusResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void setNrConfigResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "setNrConfigResponse: serial = " + r3 + " errorCode = " + r4 + " status = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.setNrConfigResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void onNrConfigResponse(int r3, int r4, int r5) {
            Rlog.d(QtiRIL.TAG, "onNrConfigResponse: serial = " + r3 + " errorCode = " + r4 + " nrConfig = " + r5);
            if (this.this$0.mClientRadioResponseCb == null) goto L11;
            this.this$0.mClientRadioResponseCb.onNrConfigResponse(r3, r4, r5);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public void setCarrierInfoForImsiEncryptionResponse(QtiRadioResponseInfo r2) {
            Rlog.d(QtiRIL.TAG, "setCarrierInfoForImsiEncryptionResponse: serial = " + r2.serial + " errorCode = " + r2.error);
        }

        private void responseSms(RadioResponseInfo r6, SendSmsResult r7) {
            Object r0 = this.mRil.qtiProcessResponse(r6);
            if (r0 == null) goto L9;
            Message r1 = this.mRil.qtiGetMessageFromRequest(r0);
            SmsResponse r2 = new SmsResponse(r7.messageRef, r7.ackPDU, r7.errorCode);
            if (r6.error != 0) goto L7;
            sendMessageResponse(r1, r2);
        L7:
            this.mRil.qtiProcessResponseDone(r0, r6, r2);
            return;
        }

        public void sendCdmaSmsResponse(QtiRadioResponseInfo r4, SendSmsResult r5) {
            Rlog.d(QtiRIL.TAG, "sendCdmaSmsResponse");
            RadioResponseInfo r0 = toRadioResponseInfo(r4);
            Rlog.d(QTI_RILJ_LOG_TAG, "[" + r4.serial + "] < RIL_REQUEST_CDMA_SEND_SMS ");
            responseSms(r0, r5);
        }

        public void getQtiRadioCapabilityResponse(RadioResponseInfo r4, int r5) {
            RILRequest r0 = this.mRil.processResponse(r4);
            Rlog.d(QtiRIL.TAG, "getQtiRadioCapabilityResponse:" + r5);
            if (r0 == null) goto L5;
            int r6 = convertToQtiNetworkTypeBitMask(r5);
        L7:
            if (r4.error != 0) goto L9;
            sendMessageResponse(r0.getResult(), Integer.valueOf(r6));
        L9:
            this.this$0.processResponseDone(r0, r4, Integer.valueOf(r6));
            return;
        L5:
            r6 = 0;
            goto L7
        }
    }

    final class QtiRadioServiceNotification extends IServiceNotification.Stub {
        final /* synthetic */ QtiRIL this$0;

        QtiRadioServiceNotification(QtiRIL r1) {
            this.this$0 = r1;
        }

        public void onRegistration(String r3, String r4, boolean r5) {
            Rlog.d(QtiRIL.TAG, "QtiRadio interface service started " + r3 + " " + r4 + " preexisting =" + r5);
            if (QtiRIL.m678$$Nest$misQtiRadioServiceConnected(this.this$0) == true) goto L6;
            QtiRIL.m677$$Nest$minitQtiRadio(this.this$0);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$minitQtiRadio, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m677$$Nest$minitQtiRadio(QtiRIL r0) {
        r0.initQtiRadio();
    }

    /* JADX INFO: renamed from: -$$Nest$misQtiRadioServiceConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m678$$Nest$misQtiRadioServiceConnected(QtiRIL r0) {
        return r0.isQtiRadioServiceConnected();
    }

    /* JADX INFO: renamed from: -$$Nest$mresetServiceAndRequestList, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m679$$Nest$mresetServiceAndRequestList(QtiRIL r0) {
        r0.resetServiceAndRequestList();
    }

    private String convertNullToEmptyString(String r1) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1;
    }

    static {
        QTI_HIDL_SERVICE_NAME = new String[]{"slot1", "slot2", "slot3"};
    }

    private void resetServiceAndRequestList() {
        resetProxyAndRequestList();
        this.mQtiRadio = null;
        this.mQtiRadioResponse = null;
        this.mQtiRadioIndication = null;
        this.mQtiRadioProxyCookie.incrementAndGet();
    }

    public void notifyNetworkScanResult(NetworkScanResult r3) {
        this.mRilNetworkScanResultRegistrants.notifyRegistrants(new AsyncResult(null, r3, null));
    }

    private boolean isQtiRadioServiceConnected() {
        if (this.mQtiRadio == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void registerForQtiRadioServiceNotification() {
    L7:
        e = move-exception;
        Rlog.e(TAG, "Failed to register for service start notifications. Exception " + e);
        return;
    L4:
        if (IServiceManager.getService().registerForNotifications("vendor.qti.hardware.radio.qtiradio@1.0::IQtiRadio", QTI_HIDL_SERVICE_NAME[this.mQtiPhoneId], this.mServiceNotification) == true) goto L12;
        Rlog.e(TAG, "Failed to register for service start notifications");     // Catch: RemoteException -> L7
        return;
    }

    private synchronized void initQtiRadio() {
        monitor-enter(this);
        IQtiRadio r2 = IQtiRadio.getService(QTI_HIDL_SERVICE_NAME[this.mQtiPhoneId]);     // Catch: Throwable -> L11 Exception -> L13
        this.mQtiRadio = r2;     // Catch: Throwable -> L11 Exception -> L13
        if (r2 != null) goto L9;
        Rlog.e(TAG, "initQtiRadio: mQtiRadio is null. Return");     // Catch: Throwable -> L11 Exception -> L13
        monitor-exit(this);
        return;
    L9:
        Rlog.d(TAG, "initQtiRadio: mQtiRadio" + this.mQtiRadio);     // Catch: Throwable -> L11 Exception -> L13
        this.mQtiRadio.linkToDeath(this.mDeathRecipient, this.mQtiRadioProxyCookie.incrementAndGet());     // Catch: Throwable -> L11 Exception -> L13
        this.mQtiRadioResponse = new QtiRadioResponse(this, this);     // Catch: Throwable -> L11 Exception -> L13
        this.mQtiRadioIndication = new QtiRadioIndication(this, this.mQtiPhoneId);     // Catch: Throwable -> L11 Exception -> L13
    L15:
        monitor-exit(this);
        return;
    L13:
        e = move-exception;
        Rlog.e(TAG, "initQtiRadio: Exception: " + e);     // Catch: Throwable -> L11
        resetServiceAndRequestList();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public QtiRIL(Context r2, int r3, int r4) {
        this(r2, r3, r4, null);
    }

    public QtiRIL(Context r1, int r2, int r3, Integer r4) {
        super(r1, r2, r3, r4);
        this.mQtiPhoneId = 0;
        this.mQtiRadioProxyCookie = new AtomicLong(0);
        this.mCagSnpnFeatureStatus = -1;
        this.mServiceNotification = new QtiRadioServiceNotification(this);
        this.mQtiPhoneId = r4.intValue();
        Rlog.d(TAG, "QtiRIL");
        this.mDeathRecipient = new QtiRadioProxyDeathRecipient(this);
        registerForQtiRadioServiceNotification();
    }

    public IQtiRadio getQtiRadioProxy(Message r5) {
        if (this.mIsCellularSupported == true) goto L9;
        Rlog.d(TAG, "getQtiRadioProxy: Not calling getService(): wifi-only");
        if (r5 == null) goto L7;
        AsyncResult.forMessage(r5, null, CommandException.fromRilErrno(1));
        r5.sendToTarget();
    L7:
        return null;
    L9:
        if (this.mQtiRadio != null) goto L14;
        Rlog.d(TAG, "getQtiRadioProxy: mRadioProxy == null");
        if (r5 == null) goto L14;
        AsyncResult.forMessage(r5, null, CommandException.fromRilErrno(1));
        r5.sendToTarget();
    L14:
        return this.mQtiRadio;
    }

    public void setImsiEncryptionResponseCallback(QtiCarrierInfoManager.QtiCarrierInfoResponse r1) {
        this.mQtiCarrierInfoResponse = r1;
    }

    public void enable5g(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.enable5g(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void disable5g(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.disable5g(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void enable5gOnly(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.enable5gOnly(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void query5gStatus(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.query5gStatus(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void queryNrDcParam(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.queryNrDcParam(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void queryNrBearerAllocation(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.queryNrBearerAllocation(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void queryNrSignalStrength(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_0.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.queryNrSignalStrength(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void queryUpperLayerIndInfo(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_1.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_1.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.queryUpperLayerIndInfo(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void queryNrIconType(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_2.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_2.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.queryNrIconType(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void query5gConfigInfo(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_1.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_1.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.query5gConfigInfo(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void setNrConfig(int r3, NrConfig r4) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_5.IQtiRadio r2 = vendor.qti.hardware.radio.qtiradio.V2_5.IQtiRadio.castFrom(this.mQtiRadio);
        if (r2 == null) goto L7;
        Rlog.d(TAG, "setNrConfig: serial = " + r3 + " config= " + r4.get());
        r2.setNrConfig(r3, r4.get());
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void queryNrConfig(int r3) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_5.IQtiRadio r2 = vendor.qti.hardware.radio.qtiradio.V2_5.IQtiRadio.castFrom(this.mQtiRadio);
        if (r2 == null) goto L7;
        Rlog.d(TAG, "queryNrConfig: serial = " + r3);
        r2.queryNrConfig(r3);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public int getPropertyValueInt(String r2, int r3) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio r1 = vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio.castFrom(this.mQtiRadio);
        if (r1 != null) goto L10;
        Rlog.e(TAG, "getPropertyValueInt HAL API not available");
        return SystemProperties.getInt(r2, r3);
    L10:
        return r1.getPropertyValueInt(r2, r3);
    L7:
        throw new RemoteException("API Error");
    }

    public boolean getPropertyValueBool(String r2, boolean r3) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio r1 = vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio.castFrom(this.mQtiRadio);
        if (r1 != null) goto L10;
        Rlog.e(TAG, "getPropertyValueBool HAL API not available");
        return SystemProperties.getBoolean(r2, r3);
    L10:
        return r1.getPropertyValueBool(r2, r3);
    L7:
        throw new RemoteException("API Error");
    }

    public String getPropertyValueString(String r2, String r3) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio r1 = vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio.castFrom(this.mQtiRadio);
        if (r1 != null) goto L10;
        Rlog.e(TAG, "getPropertyValueString HAL API not available");
        return SystemProperties.get(r2, r3);
    L10:
        return r1.getPropertyValueString(r2, r3);
    L7:
        throw new RemoteException("API Error");
    }

    public void enableEndc(int r1, boolean r2) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.enableEndc(r1, r2);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void queryEndcStatus(int r1) throws RemoteException {
        vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio r0 = vendor.qti.hardware.radio.qtiradio.V2_3.IQtiRadio.castFrom(this.mQtiRadio);
        if (r0 == null) goto L7;
        r0.queryEndcStatus(r1);
        return;
    L7:
        throw new RemoteException("API not available!");
    }

    public void setCarrierInfoForImsiEncryption(int r3, ImsiEncryptionInfo r4) {
        Rlog.d(TAG, "setCarrierInfoForImsiEncryption,  serial=" + r3);
        QtiPhoneUtils.getInstance().setCarrierInfoForImsiEncryption(this.mQtiPhoneId, r4, this.mQtiCarrierInfoResponse);
    }

    public void startNetworkScan(NetworkScanRequest r3, Message r4) {
        Rlog.d(TAG, "startNetworkScan");
        if (isCagSnpnEnabled() == false) goto L5;
        QtiPhoneUtils.getInstance().startNetworkScan(this.mQtiPhoneId, r3, r4);
        return;
    L5:
        super.startNetworkScan(r3, r4);
    }

    public void stopNetworkScan(Message r3) {
        Rlog.d(TAG, "stopNetworkScan");
        if (isCagSnpnEnabled() == false) goto L5;
        QtiPhoneUtils.getInstance().stopNetworkScan(this.mQtiPhoneId, r3);
        return;
    L5:
        super.stopNetworkScan(r3);
    }

    public void getEnhancedRadioCapability(Message r6) {
        Rlog.d(TAG, "getEnhancedRadioCapability,  response=" + r6);
        if (QtiPhoneUtils.getInstance().getQtiRadioCapability(this.mQtiPhoneId, r6) == true) goto L20;
        Rlog.d(TAG, "getEnhancedRadioCapability request failed");
        if (r6 == null) goto L20;
    L7:
        AsyncResult.forMessage(r6, null, CommandException.fromRilErrno(1));
        r6.sendToTarget();
    L20:
        return;
    L8:
        th = move-exception;
        Rlog.d(TAG, "getEnhancedRadioCapability request failed");
        if (r6 == null) goto L19;
        AsyncResult.forMessage(r6, null, CommandException.fromRilErrno(1));
        r6.sendToTarget();
    L19:
        throw th;
    L10:
        e = move-exception;
        Rlog.d(TAG, "getEnhancedRadioCapability, exception");     // Catch: Throwable -> L8
        e.printStackTrace();     // Catch: Throwable -> L8
        Rlog.d(TAG, "getEnhancedRadioCapability request failed");
        if (r6 == null) goto L20;
        goto L7
    }

    private String addRanToOperatorNumeric(String r1, int r2) {
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1 + "+" + r2;
    }

    public void setNetworkSelectionModeManual(String r4, int r5, Message r6) {
        if (getHalVersion().greaterOrEqual(RADIO_HAL_VERSION_1_5) == false) goto L5;
        super.setNetworkSelectionModeManual(r4, r5, r6);
        return;
    L5:
        IRadio r0 = getRadioProxy(r6);
        if (r0 == null) goto L16;
        RILRequest r7 = obtainRequest(47, r6, this.mRILDefaultWorkSource);
        String r8 = addRanToOperatorNumeric(r4, RILUtils.convertToHalRadioAccessNetworks(r5));     // Catch: Throwable -> L10
        Rlog.d(TAG, r7.serialString() + "> " + RILUtils.requestToString(r7.getRequest()) + " operatorNumeric = " + r8 + " [PHONE" + this.mQtiPhoneId + "]");     // Catch: Throwable -> L10
        r0.setNetworkSelectionModeManual(r7.getSerial(), r8);     // Catch: Throwable -> L10
        return;
    L10:
        e = move-exception;
        handleRadioProxyExceptionForRR(0, "setNetworkSelectionModeManual", e);
        return;
    }

    public void setNetworkSelectionModeManual(OperatorInfo r3, Message r4) {
        Rlog.d(TAG, "setNetworkSelectionModeManual");
        if (isCagSnpnEnabled() == false) goto L5;
        QtiPhoneUtils.getInstance().setNetworkSelectionModeManual(this.mQtiPhoneId, r3, r4);
        return;
    L5:
        setNetworkSelectionModeManual(r3.getOperatorNumeric(), r3.getRan(), r4);
    }

    public void setNetworkSelectionModeAutomatic(Message r3) {
        Rlog.d(TAG, "setNetworkSelectionModeAutomatic");
        if (isCagSnpnEnabled() == false) goto L5;
        QtiPhoneUtils.getInstance().setNetworkSelectionModeAutomatic(this.mQtiPhoneId, getAccessMode(), r3);
        return;
    L5:
        super.setNetworkSelectionModeAutomatic(r3);
    }

    public void sendCdmaSms(byte[] r2, Message r3) {
        if (canToggleUiccApplicationsEnablement() == false) goto L6;
        super.sendCdmaSms(r2, r3);
        return;
    L6:
        sendCdmaSms(r2, r3, false);
    }

    public void sendCdmaSMSExpectMore(byte[] r2, Message r3) {
        if (canToggleUiccApplicationsEnablement() == false) goto L6;
        super.sendCdmaSMSExpectMore(r2, r3);
        return;
    L6:
        sendCdmaSms(r2, r3, true);
    }

    private void sendCdmaSms(byte[] r4, Message r5, boolean r6) {
        Rlog.d(TAG, "sendCdmaSms,  expectMore=" + r6);
        if (QtiPhoneUtils.getInstance().sendCdmaSms(this.mQtiPhoneId, r4, r5, r6) == true) goto L6;
        Rlog.d(TAG, "fall back to default sendCdmaSms");
        super.sendCdmaSms(r4, r5);
        return;
    }

    Message qtiGetMessageFromRequest(Object r1) {
        return getMessageFromRequest(r1);
    }

    Object qtiProcessResponse(RadioResponseInfo r1) {
        return processResponse(r1);
    }

    void qtiProcessResponseDone(Object r1, RadioResponseInfo r2, Object r3) {
        processResponseDone(r1, r2, r3);
    }

    public void setCallbacks(IQtiRadioResponse.Stub r1, IQtiRadioIndication.Stub r2) {
        this.mClientRadioResponseCb = r1;
        this.mClientRadioIndicationCb = r2;
    }

    public boolean isCagSnpnEnabled() {
        if (this.mCagSnpnFeatureStatus != (-1)) goto L6;
        this.mCagSnpnFeatureStatus = QtiPhoneUtils.getInstance().getPropertyValueBool(PROPERTY_CAG_SNPN, false) ? 1 : 0;
        Rlog.d(TAG, "isCagSnpnEnable, mCagSnpnFeatureStatus = " + this.mCagSnpnFeatureStatus);
    L6:
        if (this.mCagSnpnFeatureStatus == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public int getAccessMode() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), NETWORK_ACCESS_MODE + this.mQtiPhoneId, 1);
    }
}
