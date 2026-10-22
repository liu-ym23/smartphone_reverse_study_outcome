package com.qualcomm.qti.internal.nrNetworkService.hidl;

import android.hardware.radio.V1_0.SendSmsResult;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.qualcomm.qti.internal.telephony.QtiTelephonyComponentFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import org.codeaurora.internal.BearerAllocationStatus;
import org.codeaurora.internal.NrConfig;
import org.codeaurora.internal.NrConfigType;
import org.codeaurora.internal.NrIconType;
import org.codeaurora.internal.Status;
import org.codeaurora.internal.Token;
import vendor.qti.hardware.radio.qtiradio.V1_0.QtiRadioResponseInfo;
import vendor.qti.hardware.radio.qtiradio.V2_0.DcParam;
import vendor.qti.hardware.radio.qtiradio.V2_0.SignalStrength;
import vendor.qti.hardware.radio.qtiradio.V2_1.UpperLayerIndInfo;
import vendor.qti.hardware.radio.qtiradio.V2_2.IQtiRadioIndication;
import vendor.qti.hardware.radio.qtiradio.V2_5.IQtiRadioResponse;

/* JADX INFO: loaded from: classes4.dex */
public class QtiRadioHidlClient implements IHidlConnectionInterface {
    private static final String TAG = "QtiRadioHidlClient";
    private final int MAX_SLOTS;
    private final Token UNSOL;
    private IHidlConnectionCallback mCallback;
    private ConcurrentHashMap<Integer, Token> mInflightRequests;
    private volatile int mSerial;

    public class QtiRadioIndication extends IQtiRadioIndication.Stub {
        static final String TAG = "QtiRadioIndication";
        int mSlotId;
        final /* synthetic */ QtiRadioHidlClient this$0;

        public QtiRadioIndication(QtiRadioHidlClient r2, int r3) {
            this.this$0 = r2;
            Log.d(TAG, "[" + r3 + "]Constructor: ");
            this.mSlotId = r3;
        }

        public void on5gStatusChange(int r5) {
            Log.d(TAG, "on5gStatusChange: slotId = " + this.mSlotId);
            if (QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0) != null) goto L5;
            return;
        L5:
            if (r5 != 1) goto L7;
            boolean r6 = true;
        L8:
            Log.d(TAG, "on5gStatusChange: enabled = " + r6);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).on5gStatus(this.mSlotId, QtiRadioHidlClient.m637$$Nest$fgetUNSOL(this.this$0), new Status(1), r6);
            return;
        L7:
            r6 = false;
            goto L8
        }

        public void onNrDcParamChange(DcParam r5) {
            Log.d(TAG, "onNrDcParamChange: slotId = " + this.mSlotId);
            org.codeaurora.internal.DcParam r6 = QtiRadioHidlClient.m640$$Nest$mconvertHidl2Aidl(this.this$0, r5);
            Log.d(TAG, "onNrDcParamChange: " + r6);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onNrDcParam(this.mSlotId, QtiRadioHidlClient.m637$$Nest$fgetUNSOL(this.this$0), new Status(1), r6);
        }

        public void onNrBearerAllocationChange_2_1(int r5) {
            Log.d(TAG, "onNrBearerAllocationChange: slotId = " + this.mSlotId);
            BearerAllocationStatus r6 = QtiRadioHidlClient.m644$$Nest$mconvertHidlBearerStatus2Aidl(this.this$0, r5);
            Log.d(TAG, "onNrBearerAllocationChange: bStatus = " + r6);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onAnyNrBearerAllocation(this.mSlotId, QtiRadioHidlClient.m637$$Nest$fgetUNSOL(this.this$0), new Status(1), r6);
        }

        public void onNrBearerAllocationChange(int r1) {
            onNrBearerAllocationChange_2_1(r1);
        }

        public void onSignalStrengthChange(SignalStrength r5) {
            Log.d(TAG, "onSignalStrengthChange: slotId = " + this.mSlotId);
            org.codeaurora.internal.SignalStrength r0 = QtiRadioHidlClient.m641$$Nest$mconvertHidl2Aidl(this.this$0, r5);
            Log.d(TAG, "onSignalStrengthChange: " + r5);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onSignalStrength(this.mSlotId, QtiRadioHidlClient.m637$$Nest$fgetUNSOL(this.this$0), new Status(1), r0);
        }

        public void onUpperLayerIndInfoChange(UpperLayerIndInfo r5) {
            Log.d(TAG, "onUpperLayerIndInfoChange: slotId = " + this.mSlotId);
            org.codeaurora.internal.UpperLayerIndInfo r6 = QtiRadioHidlClient.m643$$Nest$mconvertHidl2Aidl(this.this$0, r5);
            Log.d(TAG, "onUpperLayerIndInfoChange:  upperLayerInfo = " + r6);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onUpperLayerIndInfo(this.mSlotId, QtiRadioHidlClient.m637$$Nest$fgetUNSOL(this.this$0), new Status(1), r6);
        }

        public void on5gConfigInfoChange(int r5) {
            Log.d(TAG, "on5gConfigInfoChange: slotId = " + this.mSlotId);
            NrConfigType r6 = QtiRadioHidlClient.m645$$Nest$mconvertHidlConfigType2Aidl(this.this$0, r5);
            Log.d(TAG, "on5gConfigInfoChange:  5gConfigType = " + r6);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).on5gConfigInfo(this.mSlotId, QtiRadioHidlClient.m637$$Nest$fgetUNSOL(this.this$0), new Status(1), r6);
        }

        public void onNrIconTypeChange(int r5) {
            Log.d(TAG, "onNrIconTypeChange: slotId = " + this.mSlotId);
            NrIconType r6 = QtiRadioHidlClient.m647$$Nest$mconvertHidlNrIconType2Aidl(this.this$0, r5);
            Log.d(TAG, "onNrIconTypeChange:  NrIconType = " + r6);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onNrIconType(this.mSlotId, QtiRadioHidlClient.m637$$Nest$fgetUNSOL(this.this$0), new Status(1), r6);
        }

        public void qtiRadioIndication(int r1) {
            Log.d(TAG, "qtiRadioIndication: NOP!!");
        }
    }

    public class QtiRadioResponse extends IQtiRadioResponse.Stub {
        static final String TAG = "QtiRadioResponse";
        int mSlotId;
        final /* synthetic */ QtiRadioHidlClient this$0;

        public QtiRadioResponse(QtiRadioHidlClient r2, int r3) {
            this.this$0 = r2;
            Log.d(TAG, "[" + r3 + "] Constructor: ");
            this.mSlotId = r3;
        }

        public void setCarrierInfoForImsiEncryptionResponse(QtiRadioResponseInfo r1) {
            Log.d(TAG, "ignore the response");
        }

        public void onEnable5gResponse(int r5, int r6, int r7) {
            Log.d(TAG, "onEnable5gResponse: serial = " + r5 + " errorCode = " + r6 + " status = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r8 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            boolean r1 = QtiRadioHidlClient.m648$$Nest$misEnableOrDisableSucess(this.this$0, r6);
            Log.d(TAG, "onEnable5gResponse: enabled = " + r1);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).on5gStatus(this.mSlotId, r8, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r1);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onEnable5gResponse: No previous request found for serial = " + r5);
        }

        public void onDisable5gResponse(int r5, int r6, int r7) {
            Log.d(TAG, "onDisable5gResponse: serial = " + r5 + " errorCode = " + r6 + " status = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r8 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            boolean r1 = QtiRadioHidlClient.m648$$Nest$misEnableOrDisableSucess(this.this$0, r6);
            Log.d(TAG, "onDisable5gResponse: enabled = " + (!r1));
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).on5gStatus(this.mSlotId, r8, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), !r1);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onDisable5gResponse: No previous request found for serial = " + r5);
        }

        public void onEnable5gOnlyResponse(int r5, int r6, int r7) {
            Log.d(TAG, "onEnable5gOnlyResponse: serial = " + r5 + " errorCode = " + r6 + " status = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r8 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            boolean r1 = QtiRadioHidlClient.m648$$Nest$misEnableOrDisableSucess(this.this$0, r6);
            Log.d(TAG, "onEnable5gOnlyResponse: enabled = " + r1);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).on5gStatus(this.mSlotId, r8, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r1);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onEnable5gOnlyResponse: No previous request found for serial = " + r5);
        }

        public void on5gStatusResponse(int r5, int r6, int r7) {
            Log.d(TAG, "on5gStatusResponse: serial = " + r5 + " errorCode = " + r6 + " enabled = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L9;
            Token r0 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            boolean r2 = true;
            if (r7 == 1) goto L8;
            r2 = false;
        L8:
            Log.d(TAG, "on5gStatusResponse: enabled = " + r2);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).on5gStatus(this.mSlotId, r0, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r2);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L9:
            Log.d(TAG, "on5gStatusResponse: No previous request found for serial = " + r5);
        }

        public void onNrDcParamResponse(int r5, int r6, DcParam r7) {
            Log.d(TAG, "onNrDcParamResponse: serial = " + r5 + " errorCode = " + r6 + " dcParam = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r0 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            org.codeaurora.internal.DcParam r8 = QtiRadioHidlClient.m640$$Nest$mconvertHidl2Aidl(this.this$0, r7);
            Log.d(TAG, "onNrDcParamResponse:  " + r8);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onNrDcParam(this.mSlotId, r0, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r8);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onNrDcParamResponse: No previous request found for serial = " + r5);
        }

        public void onNrBearerAllocationResponse_2_1(int r5, int r6, int r7) {
            Log.d(TAG, "onNrBearerAllocationResponse: serial = " + r5 + " errorCode = " + r6 + " bearerStatus = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r0 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            BearerAllocationStatus r8 = QtiRadioHidlClient.m644$$Nest$mconvertHidlBearerStatus2Aidl(this.this$0, r7);
            Log.d(TAG, "onNrBearerAllocationResponse:  allocated = " + r8);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onAnyNrBearerAllocation(this.mSlotId, r0, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r8);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onNrBearerAllocationResponse: No previous request found for serial = " + r5);
        }

        public void onNrBearerAllocationResponse(int r3, int r4, int r5) {
            Log.d(TAG, "onNrBearerAllocationResponse: serial = " + r3 + " errorCode = " + r4 + " bearerStatus = " + r5);
            onNrBearerAllocationResponse_2_1(r3, r4, r5);
        }

        public void onUpperLayerIndInfoResponse(int r5, int r6, UpperLayerIndInfo r7) {
            Log.d(TAG, "onUpperLayerIndInfoResponse: serial = " + r5 + " errorCode = " + r6 + " UpperLayerIndInfo = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r0 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            org.codeaurora.internal.UpperLayerIndInfo r8 = QtiRadioHidlClient.m643$$Nest$mconvertHidl2Aidl(this.this$0, r7);
            Log.d(TAG, "onUpperLayerIndInfoResponse:  upperLayerInfo = " + r8);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onUpperLayerIndInfo(this.mSlotId, r0, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r8);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onUpperLayerIndInfoResponse: No previous request found for serial = " + r5);
        }

        public void on5gConfigInfoResponse(int r5, int r6, int r7) {
            Log.d(TAG, "on5gConfigInfoResponse: serial = " + r5 + " errorCode = " + r6 + " ConfigType = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r0 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            NrConfigType r8 = QtiRadioHidlClient.m645$$Nest$mconvertHidlConfigType2Aidl(this.this$0, r7);
            Log.d(TAG, "on5gConfigInfoResponse:  NrConfigType = " + r8);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).on5gConfigInfo(this.mSlotId, r0, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r8);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "on5gConfigInfoResponse: No previous request found for serial = " + r5);
        }

        public void onNrIconTypeResponse(int r5, int r6, int r7) {
            Log.d(TAG, "onNrIconTypeResponse: serial = " + r5 + " errorCode = " + r6 + " iconType = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r0 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            NrIconType r8 = QtiRadioHidlClient.m647$$Nest$mconvertHidlNrIconType2Aidl(this.this$0, r7);
            Log.d(TAG, "onNrIconTypeResponse:  NrIconType = " + r8);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onNrIconType(this.mSlotId, r0, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r8);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onNrIconTypeResponse: No previous request found for serial = " + r5);
        }

        public void onSignalStrengthResponse(int r5, int r6, SignalStrength r7) {
            Log.d(TAG, "onSignalStrengthResponse: serial = " + r5 + " errorCode = " + r6 + " signalStrength = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r0 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            org.codeaurora.internal.SignalStrength r8 = QtiRadioHidlClient.m641$$Nest$mconvertHidl2Aidl(this.this$0, r7);
            Log.d(TAG, "onSignalStrengthResponse:  " + r8);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onSignalStrength(this.mSlotId, r0, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r8);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onSignalStrengthResponse: No previous request found for serial = " + r5);
        }

        public void onEnableEndcResponse(int r5, int r6, int r7) {
            Log.d(TAG, "onEnableEndcResponse: serial = " + r5 + " errorCode = " + r6 + " status = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            Token r0 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            Log.d(TAG, "onEnableEndcResponse: status = " + r7);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onEnableEndc(this.mSlotId, r0, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6));
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onEnableEndcResponse: No previous request found for serial = " + r5);
        }

        public void onEndcStatusResponse(int r5, int r6, int r7) {
            Log.d(TAG, "onEndcStatusResponse: serial = " + r5 + " errorCode = " + r6 + " enabled = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L9;
            Token r0 = (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5));
            boolean r2 = true;
            if (r7 == 1) goto L8;
            r2 = false;
        L8:
            Log.d(TAG, "onEndcStatusResponse: enabled = " + r2);
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onEndcStatus(this.mSlotId, r0, QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), r2);
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L9:
            Log.d(TAG, "onEndcStatusResponse: No previous request found for serial = " + r5);
        }

        public void getAtrResponse(QtiRadioResponseInfo r1, String r2) {
            Log.d(TAG, "getAtrResponse: NOP!!");
        }

        public void sendCdmaSmsResponse(QtiRadioResponseInfo r1, SendSmsResult r2) {
            Log.d(TAG, "sendCdmaSmsResponse: NOP!!");
        }

        public void setNrConfigResponse(int r4, int r5, int r6) {
            Log.d(TAG, "setNrConfigResponse: serial = " + r4 + " errorCode = " + r5 + " status = " + r6);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r4)) == false) goto L5;
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).setNrConfigStatus(this.mSlotId, (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r4)), QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r5));
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r4));
            return;
        L5:
            Log.d(TAG, "setNrConfigResponse: No previous request found for serial = " + r4);
        }

        public void onNrConfigResponse(int r5, int r6, int r7) {
            Log.d(TAG, "onNrConfigResponse: serial = " + r5 + " errorCode = " + r6 + " nrConfig = " + r7);
            if (QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).containsKey(Integer.valueOf(r5)) == false) goto L5;
            QtiRadioHidlClient.m638$$Nest$fgetmCallback(this.this$0).onNrConfigStatus(this.mSlotId, (Token) QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).get(Integer.valueOf(r5)), QtiRadioHidlClient.m642$$Nest$mconvertHidl2Aidl(this.this$0, r6), QtiRadioHidlClient.m646$$Nest$mconvertHidlNrConfig2Aidl(this.this$0, r7));
            QtiRadioHidlClient.m639$$Nest$fgetmInflightRequests(this.this$0).remove(Integer.valueOf(r5));
            return;
        L5:
            Log.d(TAG, "onNrConfigResponse: No previous request found for serial = " + r5);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetUNSOL, reason: not valid java name */
    static /* bridge */ /* synthetic */ Token m637$$Nest$fgetUNSOL(QtiRadioHidlClient r0) {
        return r0.UNSOL;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IHidlConnectionCallback m638$$Nest$fgetmCallback(QtiRadioHidlClient r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInflightRequests, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConcurrentHashMap m639$$Nest$fgetmInflightRequests(QtiRadioHidlClient r0) {
        return r0.mInflightRequests;
    }

    /* JADX INFO: renamed from: -$$Nest$mconvertHidl2Aidl, reason: not valid java name */
    static /* bridge */ /* synthetic */ org.codeaurora.internal.DcParam m640$$Nest$mconvertHidl2Aidl(QtiRadioHidlClient r0, DcParam r1) {
        return r0.convertHidl2Aidl(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mconvertHidl2Aidl, reason: not valid java name */
    static /* bridge */ /* synthetic */ org.codeaurora.internal.SignalStrength m641$$Nest$mconvertHidl2Aidl(QtiRadioHidlClient r0, SignalStrength r1) {
        return r0.convertHidl2Aidl(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mconvertHidl2Aidl, reason: not valid java name */
    static /* bridge */ /* synthetic */ Status m642$$Nest$mconvertHidl2Aidl(QtiRadioHidlClient r0, int r1) {
        return r0.convertHidl2Aidl(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mconvertHidl2Aidl, reason: not valid java name */
    static /* bridge */ /* synthetic */ org.codeaurora.internal.UpperLayerIndInfo m643$$Nest$mconvertHidl2Aidl(QtiRadioHidlClient r0, UpperLayerIndInfo r1) {
        return r0.convertHidl2Aidl(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mconvertHidlBearerStatus2Aidl, reason: not valid java name */
    static /* bridge */ /* synthetic */ BearerAllocationStatus m644$$Nest$mconvertHidlBearerStatus2Aidl(QtiRadioHidlClient r0, int r1) {
        return r0.convertHidlBearerStatus2Aidl(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mconvertHidlConfigType2Aidl, reason: not valid java name */
    static /* bridge */ /* synthetic */ NrConfigType m645$$Nest$mconvertHidlConfigType2Aidl(QtiRadioHidlClient r0, int r1) {
        return r0.convertHidlConfigType2Aidl(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mconvertHidlNrConfig2Aidl, reason: not valid java name */
    static /* bridge */ /* synthetic */ NrConfig m646$$Nest$mconvertHidlNrConfig2Aidl(QtiRadioHidlClient r0, int r1) {
        return r0.convertHidlNrConfig2Aidl(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mconvertHidlNrIconType2Aidl, reason: not valid java name */
    static /* bridge */ /* synthetic */ NrIconType m647$$Nest$mconvertHidlNrIconType2Aidl(QtiRadioHidlClient r0, int r1) {
        return r0.convertHidlNrIconType2Aidl(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misEnableOrDisableSucess, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m648$$Nest$misEnableOrDisableSucess(QtiRadioHidlClient r0, int r1) {
        return r0.isEnableOrDisableSucess(r1);
    }

    private boolean isEnableOrDisableSucess(int r1) {
        if (r1 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    private int getPhoneCount() {
        return TelephonyManager.getDefault().getPhoneCount();
    }

    private org.codeaurora.internal.DcParam convertHidl2Aidl(DcParam r2) {
        return new org.codeaurora.internal.DcParam(r2.endc, r2.dcnr);
    }

    private org.codeaurora.internal.UpperLayerIndInfo convertHidl2Aidl(UpperLayerIndInfo r2) {
        return new org.codeaurora.internal.UpperLayerIndInfo(r2.plmnInfoList, r2.upplerLayerInd);
    }

    private NrConfigType convertHidlConfigType2Aidl(int r1) {
        return new NrConfigType(r1);
    }

    private NrIconType convertHidlNrIconType2Aidl(int r1) {
        return new NrIconType(r1);
    }

    private NrConfig convertHidlNrConfig2Aidl(int r1) {
        return new NrConfig(r1);
    }

    private org.codeaurora.internal.SignalStrength convertHidl2Aidl(SignalStrength r2) {
        return new org.codeaurora.internal.SignalStrength(r2.rsrp, r2.snr);
    }

    private Status convertHidl2Aidl(int r1) {
        if (r1 != 0) goto L5;
        int r2 = 1;
    L7:
        return new Status(r2);
    L5:
        r2 = 0;
        goto L7
    }

    private BearerAllocationStatus convertHidlBearerStatus2Aidl(int r1) {
        return new BearerAllocationStatus(r1);
    }

    private QtiTelephonyComponentFactory getQtiTelephonyComponentFactory() {
        return QtiTelephonyComponentFactory.getInstance();
    }

    private void setCallbacks(int r4) {
        QtiTelephonyComponentFactory r0 = getQtiTelephonyComponentFactory();
        Log.d(TAG, "ril[" + r4 + "]: " + r0.getRil(r4));
        r0.getRil(r4).setCallbacks(new QtiRadioResponse(this, r4), new QtiRadioIndication(this, r4));
    }

    private void register() {
        Log.d(TAG, "Register");
        int r0 = getPhoneCount();
        Log.d(TAG, "Phone count = " + r0);
        IntStream.range(0, r0).forEach(new QtiRadioHidlClient$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$register$0$com-qualcomm-qti-internal-nrNetworkService-hidl-QtiRadioHidlClient, reason: not valid java name */
    /* synthetic */ void m649xaf73ec66(int r1) {
        setCallbacks(r1);
    }

    public QtiRadioHidlClient() {
        this.MAX_SLOTS = 2;
        this.mSerial = -1;
        this.UNSOL = new Token(-1);
        this.mInflightRequests = new ConcurrentHashMap();
        Log.d(TAG, "constructor");
        register();
    }

    private Token getNextToken() {
        int r1 = this.mSerial + 1;
        this.mSerial = r1;
        return new Token(r1);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void enable5g(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "enable5g: slotId = " + r6 + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).enable5g(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "enable5g: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void disable5g(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "disable5g: slotId = " + r6 + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).disable5g(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "disable5g: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void enable5gOnly(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "enable5gOnly: slotId = " + r6 + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).enable5gOnly(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "enable5gOnly: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void query5gStatus(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "query5gStatus: slotId = " + r6 + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).query5gStatus(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "query5gStatus: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrDcParam(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "queryNrDcParam: slotId = " + r6 + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).queryNrDcParam(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "queryNrDcParam: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrBearerAllocation(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "queryNrBearerAllocation: slotId = " + r6 + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).queryNrBearerAllocation(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "queryNrBearerAllocation: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrSignalStrength(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "queryNrSignalStrength: slotId = " + r6 + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).queryNrSignalStrength(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "queryNrSignalStrength: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryUpperLayerIndInfo(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "queryUpperLayerIndInfo: slotId = " + r6 + " token " + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).queryUpperLayerIndInfo(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "queryUpperLayerIndInfo: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void query5gConfigInfo(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "query5gConfigInfo: slotId = " + r6 + " token " + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).query5gConfigInfo(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "query5gConfigInfo: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrIconType(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "queryNrIconType: slotId = " + r6 + " token " + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).queryNrIconType(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "queryNrIconType: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void enableEndc(int r6, boolean r7, Token r8) throws RemoteException {
        Log.d(TAG, "enableEndc: slotId = " + r6 + " token " + r8);
        int r0 = r8.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r8);
        getQtiTelephonyComponentFactory().getRil(r6).enableEndc(r0, r7);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r8);
        Log.d(TAG, "enableEndc: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryEndcStatus(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "queryEndcStatus: slotId = " + r6 + " token " + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).queryEndcStatus(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "queryEndcStatus: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void setNrConfig(int r6, NrConfig r7, Token r8) throws RemoteException {
        Log.d(TAG, "setNrConfig: slotId = " + r6 + " config = " + r7 + " token = " + r8);
        int r0 = r8.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r8);
        getQtiTelephonyComponentFactory().getRil(r6).setNrConfig(r0, r7);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r8);
        Log.d(TAG, "setNrConfig: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrConfig(int r6, Token r7) throws RemoteException {
        Log.d(TAG, "queryNrConfig: slotId = " + r6 + " token = " + r7);
        int r0 = r7.get();
        this.mInflightRequests.put(Integer.valueOf(r0), r7);
        getQtiTelephonyComponentFactory().getRil(r6).queryNrConfig(r0);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.mInflightRequests.remove(Integer.valueOf(r0), r7);
        Log.d(TAG, "queryNrConfig: slotId = " + r6 + " Exception = " + e);
        e.printStackTrace();
        throw e;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public Token generateNextToken() {
        return getNextToken();
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void registerCallback(IHidlConnectionCallback r3) {
        Log.d(TAG, "registerCallback: callback = " + r3);
        this.mCallback = r3;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void unRegisterCallback(IHidlConnectionCallback r3) {
        Log.d(TAG, "unRegisterCallback: callback = " + r3);
        if (this.mCallback != r3) goto L6;
        this.mCallback = null;
        return;
    }
}
