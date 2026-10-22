package com.qualcomm.qti.internal.telephony;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import android.os.RemoteException;
import android.telephony.Rlog;
import android.text.TextUtils;
import android.util.Log;
import com.qualcomm.qcrilhook.OemHookCallback;
import com.qualcomm.qcrilhook.QcRilHook;
import com.qualcomm.qcrilhook.QcRilHookCallback;
import com.qualcomm.qti.internal.telephony.uicccontact.QtiSimPhoneBookAdnRecord;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.codeaurora.internal.IDepersoResCallback;

/* JADX INFO: loaded from: classes4.dex */
public class QtiRilInterface implements BaseRilInterface {
    private static final String ACTION_ADN_INIT_DONE = "qualcomm.intent.action.ACTION_ADN_INIT_DONE";
    private static final String ACTION_ADN_RECORDS_IND = "qualcomm.intent.action.ACTION_ADN_RECORDS_IND";
    private static final int BYTE_SIZE = 1;
    private static final int INT_SIZE = 4;
    private static final String LOG_TAG = "QtiRilInterface";
    private static final char NULL_TERMINATOR = 0;
    private static final int NULL_TERMINATOR_LENGTH = 1;
    private static final int SHORT_SIZE = 2;
    private static QtiRilInterface sInstance;
    private RegistrantList mAdnInitDoneRegistrantList;
    private RegistrantList mAdnRecordsInfoRegistrantList;
    private BroadcastReceiver mBroadcastReceiver;
    private Context mContext;
    private boolean mIsServiceReady;
    private QcRilHook mQcRilHook;
    private QcRilHookCallback mQcrilHookCb;
    private RegistrantList mServiceReadyRegistrantList;

    protected class AdnOemHookCallback extends OemHookCallback {
        Message mAppMessage;
        int mRspLength;
        final /* synthetic */ QtiRilInterface this$0;

        public AdnOemHookCallback(QtiRilInterface r1, Message r2, int r3) {
            this.this$0 = r1;
            super(r2);
            this.mAppMessage = r2;
            this.mRspLength = r3;
        }

        public void onOemHookResponse(byte[] r4, int r5) throws RemoteException {
            if (r4 == null) goto L5;
            QtiRilInterface.m685$$Nest$mlogd(this.this$0, "AdnOemHookCallback: onOemHookResponse = " + r4.toString());
            AsyncResult.forMessage(this.mAppMessage, QtiRilInterface.m686$$Nest$mparseInts(this.this$0, r4, this.mRspLength), null);
        L6:
            this.mAppMessage.sendToTarget();
            return;
        L5:
            AsyncResult.forMessage(this.mAppMessage, null, new Exception("QCRIL_EVT_HOOK_GET_ADN_RECORD failed"));
            goto L6
        }

        public void onOemHookException(int r3) throws RemoteException {
            QtiRilInterface.m685$$Nest$mlogd(this.this$0, "AdnOemHookCallback: onOemHookException");
            AsyncResult.forMessage(this.mAppMessage, null, new Exception("com.android.internal.telephony.CommandException: MODEM_ERR"));
            this.mAppMessage.sendToTarget();
        }
    }

    private class DepersoCallback extends OemHookCallback {
        int ERROR;
        int SUCCESS;
        IDepersoResCallback depersoCallBack;
        final /* synthetic */ QtiRilInterface this$0;

        public DepersoCallback(QtiRilInterface r1, IDepersoResCallback r2, Message r3) {
            this.this$0 = r1;
            super(r3);
            this.SUCCESS = 0;
            this.ERROR = 1;
            this.depersoCallBack = r2;
        }

        public void onOemHookResponse(byte[] r2, int r3) throws RemoteException {
            if (r2 == null) goto L4;
            QtiRilInterface.m685$$Nest$mlogd(this.this$0, "DepersoResult SUCCESS");
            this.depersoCallBack.onDepersoResult(this.SUCCESS, r3);
            return;
        L4:
            QtiRilInterface.m685$$Nest$mlogd(this.this$0, "DepersoResult ERROR");
            this.depersoCallBack.onDepersoResult(this.ERROR, r3);
        }

        public void onOemHookException(int r3) throws RemoteException {
            QtiRilInterface.m685$$Nest$mlogd(this.this$0, "DepersoResult ERROR");
            this.depersoCallBack.onDepersoResult(this.ERROR, r3);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdnInitDoneRegistrantList, reason: not valid java name */
    static /* bridge */ /* synthetic */ RegistrantList m680$$Nest$fgetmAdnInitDoneRegistrantList(QtiRilInterface r0) {
        return r0.mAdnInitDoneRegistrantList;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdnRecordsInfoRegistrantList, reason: not valid java name */
    static /* bridge */ /* synthetic */ RegistrantList m681$$Nest$fgetmAdnRecordsInfoRegistrantList(QtiRilInterface r0) {
        return r0.mAdnRecordsInfoRegistrantList;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsServiceReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m682$$Nest$fgetmIsServiceReady(QtiRilInterface r0) {
        return r0.mIsServiceReady;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceReadyRegistrantList, reason: not valid java name */
    static /* bridge */ /* synthetic */ RegistrantList m683$$Nest$fgetmServiceReadyRegistrantList(QtiRilInterface r0) {
        return r0.mServiceReadyRegistrantList;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsServiceReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m684$$Nest$fputmIsServiceReady(QtiRilInterface r0, boolean r1) {
        r0.mIsServiceReady = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mlogd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m685$$Nest$mlogd(QtiRilInterface r0, String r1) {
        r0.logd(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mparseInts, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m686$$Nest$mparseInts(QtiRilInterface r0, byte[] r1, int r2) {
        return r0.parseInts(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mresponseAdnRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m687$$Nest$mresponseAdnRecords(QtiRilInterface r0, byte[] r1) {
        return r0.responseAdnRecords(r1);
    }

    static {
    }

    public static synchronized QtiRilInterface getInstance(Context r3) {
        monitor-enter(QtiRilInterface.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new QtiRilInterface(r3);     // Catch: Throwable -> L11
    L8:
        QtiRilInterface r4 = sInstance;     // Catch: Throwable -> L11
        monitor-exit(QtiRilInterface.class);
        return r4;
    L7:
        Log.d(LOG_TAG, "instance = " + sInstance);     // Catch: Throwable -> L11
        goto L8
    }

    private QtiRilInterface(Context r5) {
        this.mIsServiceReady = false;
        this.mQcrilHookCb = new AnonymousClass1(this);
        this.mBroadcastReceiver = new AnonymousClass2(this);
        logd(" in constructor ");
        if (r5 == null) goto L12;
        this.mContext = r5.getApplicationContext();
        this.mServiceReadyRegistrantList = new RegistrantList();
        this.mAdnInitDoneRegistrantList = new RegistrantList();
        this.mAdnRecordsInfoRegistrantList = new RegistrantList();
        this.mQcRilHook = new QcRilHook(r5, this.mQcrilHookCb);     // Catch: SecurityException -> L7
    L9:
        IntentFilter r0 = new IntentFilter();
        r0.addAction(ACTION_ADN_INIT_DONE);
        r0.addAction(ACTION_ADN_RECORDS_IND);
        r5.registerReceiver(this.mBroadcastReceiver, r0);
        return;
    L7:
        e = move-exception;
        loge("SecurityException during QcRilHook init: " + e);
        this.mIsServiceReady = false;
        goto L9
    L12:
        throw new IllegalArgumentException("Context is null");
    }

    public QtiUiccCardProvisioner.UiccProvisionStatus getUiccProvisionPreference(int r6) {
        QtiUiccCardProvisioner.UiccProvisionStatus r0 = new QtiUiccCardProvisioner.UiccProvisionStatus();
        org.codeaurora.telephony.utils.AsyncResult r1 = this.mQcRilHook.sendQcRilHookMsg(524378, new byte[0], r6);
        if (r1.exception == null) goto L5;
    L7:
        logi("get pref, phoneId " + r6 + " " + r0 + " exception " + r1.exception);
        return r0;
    L5:
        if (r1.result == null) goto L7;
        ByteBuffer r2 = ByteBuffer.wrap((byte[]) r1.result);
        r2.order(ByteOrder.nativeOrder());
        logd("Data received: " + r2.toString());
        r0.setUserPreference(r2.getInt());
        r0.setCurrentState(r2.getInt());
        goto L7
    }

    public String getUiccIccId(int r5) {
        byte[] r0 = new byte[4];
        QcRilHook.createBufferWithNativeByteOrder(r0).putInt(r5);
        org.codeaurora.telephony.utils.AsyncResult r1 = this.mQcRilHook.sendQcRilHookMsg(524380, r0, r5);
        if (r1.exception == null) goto L5;
    L7:
        String r2 = null;
    L8:
        logi("getUiccIccId iccId[" + r5 + "] = " + r2 + " exception: " + r1.exception);
        return r2;
    L5:
        if (r1.result == null) goto L7;
        r2 = new String((byte[]) r1.result);
        goto L8
    }

    public int getMaxDataAllowed() {
        org.codeaurora.telephony.utils.AsyncResult r0 = this.mQcRilHook.sendQcRilHookMsg(524381);
        if (r0.exception == null) goto L5;
    L7:
        byte r1 = 0;
    L8:
        logi("getMaxDataAllowed maxData = " + r1 + " exception: " + r0.exception);
        return r1;
    L5:
        if (r0.result == null) goto L7;
        r1 = ByteBuffer.wrap((byte[]) r0.result).get();
        goto L8
    }

    public boolean getLpluslSupportStatus() {
        org.codeaurora.telephony.utils.AsyncResult r0 = this.mQcRilHook.sendQcRilHookMsg(524382);
        boolean r2 = false;
        if (r0.exception == null) goto L5;
    L9:
        logi("getLpluslSupportStatus: " + r2 + " exception: " + r0.exception);
        return r2;
    L5:
        if (r0.result == null) goto L9;
        if ((ByteBuffer.wrap((byte[]) r0.result).get() & 1) != 1) goto L9;
        r2 = true;
        goto L9
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public void sendPhoneStatus(int r3, int r4) {
        byte[] r0 = new byte[1];
        QcRilHook.createBufferWithNativeByteOrder(r0).put((byte) r3);
        this.mQcRilHook.sendQcRilHookMsg(524314, r0, r4);
    }

    public boolean setUiccProvisionPreference(int r5, int r6) {
        byte[] r0 = new byte[8];
        ByteBuffer r1 = QcRilHook.createBufferWithNativeByteOrder(r0);
        r1.putInt(r5);
        r1.putInt(r6);
        org.codeaurora.telephony.utils.AsyncResult r2 = this.mQcRilHook.sendQcRilHookMsg(524379, r0, r6);
        if (r2.exception != null) goto L5;
        boolean r3 = true;
    L6:
        logi("set provision userPref " + r5 + " phoneId " + r6 + " exception: " + r2.exception);
        return r3;
    L5:
        r3 = false;
        goto L6
    }

    private int[] parseInts(byte[] r5, int r6) {
        ByteBuffer r7 = ByteBuffer.wrap(r5);
        r7.order(ByteOrder.nativeOrder());
        logi("numInts: " + r6);
        int[] r0 = new int[r6];
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        r0[r1] = r7.getInt();
        logi("response[i]: " + r0[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public void getAdnRecord(Message r4, int r5) {
        byte[] r0 = new byte[4];
        QcRilHook.createBufferWithNativeByteOrder(r0).putInt(r5);
        AdnOemHookCallback r1 = new AdnOemHookCallback(this, r4, 10);
        this.mQcRilHook.sendQcRilHookMsgAsync(524509, r0, r1, r5);
        logi("getAdnRecord()");
    }

    public void updateAdnRecord(QtiSimPhoneBookAdnRecord r10, Message r11, int r12) {
        int r0 = r10.getNumEmails();
        int r1 = r10.getNumAdNumbers();
        String r2 = r10.getAlphaTag();
        String r3 = r10.getNumber();
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r4 = 0;
    L6:
        int r5 = r4 + 10;
        if (TextUtils.isEmpty(r3) == false) goto L9;
        int r7 = 0;
    L10:
        int r6 = r5 + r7;
        int r8 = 0;
    L11:
        if (r8 >= r0) goto L13;
        r6 = (r6 + 2) + (r10.getEmails()[r8].getBytes().length + 1);
        r8 = r8 + 1;
        goto L11
    L13:
        int r9 = 0;
    L14:
        if (r9 >= r1) goto L16;
        r6 = (r6 + 2) + (r10.getAdNumbers()[r9].getBytes().length + 1);
        r9 = r9 + 1;
        goto L14
    L16:
        byte[] r13 = new byte[r6];
        ByteBuffer r14 = QcRilHook.createBufferWithNativeByteOrder(r13);
        AdnOemHookCallback r15 = new AdnOemHookCallback(this, r11, 1);
        r14.putShort((short) r10.getRecordIndex());
        if (TextUtils.isEmpty(r2) == true) goto L23;
        r14.putShort((short) r2.getBytes().length);
        r14.put(r2.getBytes("UTF-8"));     // Catch: UnsupportedEncodingException -> L21
        r14.put((byte) 0);     // Catch: UnsupportedEncodingException -> L21
    L25:
        if (TextUtils.isEmpty(r3) == true) goto L31;
        r14.putShort((short) r3.getBytes().length);
        r14.put(QtiSimPhoneBookAdnRecord.ConvertToRecordNumber(r3).getBytes("UTF-8"));     // Catch: UnsupportedEncodingException -> L29
        r14.put((byte) 0);     // Catch: UnsupportedEncodingException -> L29
    L32:
        r14.putShort((short) r0);
        int r16 = 0;
    L33:
        if (r16 >= r0) goto L39;
        r14.putShort((short) r10.getEmails()[r16].getBytes().length);
        r14.put(r10.getEmails()[r16].getBytes("UTF-8"));     // Catch: UnsupportedEncodingException -> L37
        r14.put((byte) 0);     // Catch: UnsupportedEncodingException -> L37
        r16 = r16 + 1;
    L37:
        loge("Unsupport UTF-8 to parse email");
        return;
    L39:
        r14.putShort((short) r1);
        int r17 = 0;
    L40:
        if (r17 >= r1) goto L46;
        r14.putShort((short) r10.getAdNumbers()[r17].getBytes().length);
        r14.put(QtiSimPhoneBookAdnRecord.ConvertToRecordNumber(r10.getAdNumbers()[r17]).getBytes("UTF-8"));     // Catch: UnsupportedEncodingException -> L44
        r14.put((byte) 0);     // Catch: UnsupportedEncodingException -> L44
        r17 = r17 + 1;
    L44:
        loge("Unsupport UTF-8 to parse anr");
        return;
    L46:
        this.mQcRilHook.sendQcRilHookMsgAsync(524510, r13, r15, r12);
        logi("updateAdnRecord() with " + r10.toString());
        return;
    L29:
        loge("Unsupport UTF-8 to parse number");
        return;
    L31:
        r14.putShort(0);
    L21:
        loge("Unsupport UTF-8 to parse name");
        return;
    L23:
        r14.putShort(0);
        goto L25
    L9:
        r7 = r3.getBytes().length + 1;
        goto L10
    L5:
        r4 = r2.getBytes().length + 1;
        goto L6
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public boolean isServiceReady() {
        return this.mIsServiceReady;
    }

    public void registerForUnsol(Handler r1, int r2, Object r3) {
        QcRilHook.register(r1, r2, r3);
    }

    public void unRegisterForUnsol(Handler r1) {
        QcRilHook.unregister(r1);
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public void registerForServiceReadyEvent(Handler r2, int r3, Object r4) {
        Registrant r0 = new Registrant(r2, r3, r4);
        this.mServiceReadyRegistrantList.add(r0);
        if (isServiceReady() == false) goto L6;
        r0.notifyRegistrant(new AsyncResult(null, Boolean.valueOf(this.mIsServiceReady), null));
        return;
    }

    public void registerForAdnInitDone(Handler r2, int r3, Object r4) {
        Registrant r0 = new Registrant(r2, r3, r4);
        this.mAdnInitDoneRegistrantList.add(r0);
    }

    public void registerForAdnRecordsInfo(Handler r2, int r3, Object r4) {
        Registrant r0 = new Registrant(r2, r3, r4);
        this.mAdnRecordsInfoRegistrantList.add(r0);
    }

    public void qcRilSendDDSInfo(int r1, int r2, int r3) {
        this.mQcRilHook.qcRilSendDDSInfo(r1, r2, r3);
    }

    public boolean performIncrementalScan(int r3) {
        logd("performIncrementalScan, slotId: " + r3);
        return this.mQcRilHook.qcRilPerformIncrManualScan(r3);
    }

    public boolean abortIncrementalScan(int r3) {
        logd("abortIncrementalScan, slotId: " + r3);
        return this.mQcRilHook.qcRilAbortNetworkScan(r3);
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public void unRegisterForServiceReadyEvent(Handler r1) {
        this.mServiceReadyRegistrantList.remove(r1);
    }

    public void unregisterForAdnInitDone(Handler r1) {
        this.mAdnInitDoneRegistrantList.remove(r1);
    }

    public void unregisterForAdnRecordsInfo(Handler r1) {
        this.mAdnRecordsInfoRegistrantList.remove(r1);
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public boolean setLocalCallHold(int r1, boolean r2) {
        return this.mQcRilHook.setLocalCallHold(r1, r2);
    }

    private Object responseAdnRecords(byte[] r11) {
        ByteBuffer r12 = ByteBuffer.wrap(r11);
        r12.order(ByteOrder.nativeOrder());
        int r0 = r12.getShort();
        QtiSimPhoneBookAdnRecord[] r1 = new QtiSimPhoneBookAdnRecord[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L39;
        QtiSimPhoneBookAdnRecord r4 = new QtiSimPhoneBookAdnRecord();
        r1[r3] = r4;
        r4.mRecordIndex = r12.getShort();
        int r5 = r12.getShort();
        if (r5 <= 0) goto L10;
        byte[] r6 = new byte[r5];
        r12.get(r6);
        r1[r3].mAlphaTag = new String(r6, "UTF-8");     // Catch: UnsupportedEncodingException -> L9
    L9:
        loge("Unsupport UTF-8 to parse name");
    L10:
        int r7 = r12.getShort();
        if (r7 <= 0) goto L16;
        byte[] r8 = new byte[r7];
        r12.get(r8);
        r1[r3].mNumber = QtiSimPhoneBookAdnRecord.ConvertToPhoneNumber(new String(r8, "UTF-8"));     // Catch: UnsupportedEncodingException -> L15
    L15:
        loge("Unsupport UTF-8 to parse number");
    L16:
        int r9 = r12.getShort();
        if (r9 <= 0) goto L27;
        r1[r3].mEmailCount = r9;
        r1[r3].mEmails = new String[r9];
        int r10 = 0;
    L19:
        if (r10 >= r9) goto L27;
        int r13 = r12.getShort();
        if (r13 <= 0) goto L26;
        byte[] r14 = new byte[r13];
        r12.get(r14);
        r1[r3].mEmails[r10] = new String(r14, "UTF-8");     // Catch: UnsupportedEncodingException -> L25
    L25:
        loge("Unsupport UTF-8 to parse email");
    L26:
        r10 = r10 + 1;
    L27:
        int r15 = r12.getShort();
        if (r15 <= 0) goto L38;
        r1[r3].mAdNumCount = r15;
        r1[r3].mAdNumbers = new String[r15];
        int r16 = 0;
    L30:
        if (r16 >= r15) goto L38;
        int r17 = r12.getShort();
        if (r17 <= 0) goto L37;
        byte[] r18 = new byte[r17];
        r12.get(r18);
        r1[r3].mAdNumbers[r16] = QtiSimPhoneBookAdnRecord.ConvertToPhoneNumber(new String(r18, "UTF-8"));     // Catch: UnsupportedEncodingException -> L36
    L36:
        loge("Unsupport UTF-8 to parse anr");
    L37:
        r16 = r16 + 1;
    L38:
        r3 = r3 + 1;
    L39:
        logd(Arrays.toString(r1));
        return r1;
    }

    private void logd(String r1) {
        Rlog.d(LOG_TAG, r1);
    }

    private void logi(String r1) {
        Rlog.i(LOG_TAG, r1);
    }

    private void loge(String r1) {
        Rlog.e(LOG_TAG, r1);
    }
}
