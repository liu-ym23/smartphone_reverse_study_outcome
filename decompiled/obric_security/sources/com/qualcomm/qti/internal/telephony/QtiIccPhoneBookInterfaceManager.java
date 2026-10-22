package com.qualcomm.qti.internal.telephony;

import android.content.ContentValues;
import android.os.Message;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.android.internal.telephony.IccCardConstants;
import com.android.internal.telephony.IccPhoneBookInterfaceManager;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.uicc.AdnCapacity;
import com.android.internal.telephony.uicc.AdnRecord;
import com.android.internal.telephony.uicc.UiccController;
import com.android.internal.telephony.uicc.UiccProfile;
import com.qualcomm.qti.internal.telephony.uicccontact.QtiSimPhoneBookAdnRecordCache;
import com.ss.android.message.log.PushLog;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QtiIccPhoneBookInterfaceManager extends IccPhoneBookInterfaceManager {
    private static final boolean DBG = true;
    private static final String LOG_TAG = "QtiIccPhoneBookInterfaceManager";
    private int mPhoneId;
    private QtiSimPhoneBookAdnRecordCache mSimPbAdnCache;

    public QtiIccPhoneBookInterfaceManager(Phone r4) {
        super(r4);
        this.mPhoneId = r4.getPhoneId();
        if (isSimPhoneBookEnabled() == true) goto L5;
        return;
    L5:
        if (this.mSimPbAdnCache != null) goto L9;
        this.mSimPbAdnCache = new QtiSimPhoneBookAdnRecordCache(r4.getContext(), r4.getPhoneId(), r4.mCi);
        return;
    }

    private boolean isSimPhoneBookEnabled() {
        if (SystemProperties.getBoolean("persist.vendor.radio.sim_contacts_from_iccio", false) == true) goto L6;
        return true;
    L6:
        return false;
    }

    public List<AdnRecord> getAdnRecordsInEf(int r5) {
        if (this.mPhone.getContext().checkCallingOrSelfPermission("android.permission.READ_CONTACTS") != 0) goto L27;
        int r6 = updateEfForIccType(r5);
        logd("getAdnRecordsInEF: efid=0x" + Integer.toHexString(r6).toUpperCase());
        checkThread();
        IccPhoneBookInterfaceManager.Request r0 = new IccPhoneBookInterfaceManager.Request();
        monitor-enter(r0);
        Message r1 = this.mBaseHandler.obtainMessage(2, r0);     // Catch: Throwable -> L23
        if (isSimPhoneBookEnabled() == false) goto L17;
        if (r6 != 20272) goto L11;
    L12:
        QtiSimPhoneBookAdnRecordCache r7 = this.mSimPbAdnCache;     // Catch: Throwable -> L23
        if (r7 == null) goto L15;
        r7.requestLoadAllAdnLike(r1);     // Catch: Throwable -> L23
        waitForResult(r0);     // Catch: Throwable -> L23
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return (List) r0.mResult;
    L15:
        loge("Failure while trying to load from SIM due to uninit  sim pb adncache");     // Catch: Throwable -> L23
        goto L20
    L11:
        if (r6 == 28474) goto L12;
    L17:
        if (this.mAdnCache == null) goto L19;
        this.mAdnCache.requestLoadAllAdnLike(r6, this.mAdnCache.extensionEfForEf(r6), r1);     // Catch: Throwable -> L23
        waitForResult(r0);     // Catch: Throwable -> L23
        goto L20
    L19:
        loge("Failure while trying to load from SIM due to uninitialised adncache");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L27:
        throw new SecurityException("Requires android.permission.READ_CONTACTS permission");
    }

    public boolean updateAdnRecordsInEfBySearchForSubscriber(int r19, ContentValues r20, String r21) {
        if (this.mPhone.getContext().checkCallingOrSelfPermission("android.permission.WRITE_CONTACTS") != 0) goto L43;
        String r2 = r20.getAsString(PushLog.KEY_TAG);
        String r7 = r20.getAsString("newTag");
        String r3 = r20.getAsString("number");
        String r8 = r20.getAsString("newNumber");
        String r4 = r20.getAsString("emails");
        String r5 = r20.getAsString("newEmails");
        String r6 = r20.getAsString("anrs");
        String r9 = r20.getAsString("newAnrs");
        String[] r11 = null;
        if (TextUtils.isEmpty(r4) == false) goto L7;
        String[] r10 = null;
    L9:
        if (TextUtils.isEmpty(r5) == false) goto L11;
        String[] r12 = null;
    L13:
        if (TextUtils.isEmpty(r6) == false) goto L15;
        String[] r13 = null;
    L17:
        if (TextUtils.isEmpty(r9) == true) goto L20;
        r11 = getAnrStringArray(r9);
    L20:
        int r14 = updateEfForIccType(r19);
        logd("updateAdnRecordsWithContentValuesInEfBySearch: efid=" + r14 + ", values = " + r20 + ", pin2=" + r21);
        checkThread();
        IccPhoneBookInterfaceManager.Request r1 = new IccPhoneBookInterfaceManager.Request();
        monitor-enter(r1);
        Message r15 = this.mBaseHandler.obtainMessage(3, r1);     // Catch: Throwable -> L39
        AdnRecord r16 = new AdnRecord(r2, r3, r10, r13);     // Catch: Throwable -> L39
        if (isSimPhoneBookEnabled() == true) goto L25;
    L32:
        AdnRecord r17 = new AdnRecord(r7, r8, r12, r11);     // Catch: Throwable -> L39
        if (this.mAdnCache == null) goto L35;
        this.mAdnCache.updateAdnBySearch(r14, r16, r17, r21, r15);     // Catch: Throwable -> L39
        waitForResult(r1);     // Catch: Throwable -> L39
    L36:
        monitor-exit(r1);     // Catch: Throwable -> L39
        return ((Boolean) r1.mResult).booleanValue();
    L35:
        loge("Failure while trying to update by search due to uninitialised adncache");     // Catch: Throwable -> L39
        goto L36
    L25:
        if (r14 != 20272) goto L27;
    L28:
        AdnRecord r18 = new AdnRecord(28474, 0, r7, r8, r12, r11);     // Catch: Throwable -> L39
        QtiSimPhoneBookAdnRecordCache r22 = this.mSimPbAdnCache;     // Catch: Throwable -> L39
        if (r22 == null) goto L31;
        r22.updateSimPbAdnBySearch(r16, r18, r15);     // Catch: Throwable -> L39
        waitForResult(r1);     // Catch: Throwable -> L39
        goto L36
    L31:
        loge("Failure while trying to update by search due to uninit sim pb adncache");     // Catch: Throwable -> L39
        goto L36
    L27:
        if (r14 != 28474) goto L32;
    L39:
        th = move-exception;
        throw th;
    L15:
        r13 = getAnrStringArray(r6);
        goto L17
    L11:
        r12 = getStringArray(r5);
        goto L13
    L7:
        r10 = getStringArray(r4);
        goto L9
    L43:
        throw new SecurityException("Requires android.permission.WRITE_CONTACTS permission");
    }

    public boolean updateAdnRecordsInEfByIndex(int r15, ContentValues r16, int r17, String r18) {
        if (this.mPhone.getContext().checkCallingOrSelfPermission("android.permission.WRITE_CONTACTS") != 0) goto L35;
        logd("updateAdnRecordsInEfByIndex: efid=" + r15 + ", values = " + r16 + " index=" + r17 + ", pin2=" + r18);
        String r8 = r16.getAsString("newTag");
        String r9 = r16.getAsString("newNumber");
        String r2 = r16.getAsString("newEmails");
        String r1 = r16.getAsString("newAnrs");
        if (TextUtils.isEmpty(r2) == false) goto L7;
        String[] r10 = null;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L11;
        String[] r11 = null;
    L12:
        int r3 = updateEfForIccType(r15);
        checkThread();
        IccPhoneBookInterfaceManager.Request r12 = new IccPhoneBookInterfaceManager.Request();
        monitor-enter(r12);
        Message r13 = this.mBaseHandler.obtainMessage(3, r12);     // Catch: Throwable -> L31
        if (isSimPhoneBookEnabled() == true) goto L17;
    L24:
        AdnRecord r4 = new AdnRecord(r8, r9, r10, r11);     // Catch: Throwable -> L31
        if (this.mAdnCache == null) goto L27;
        this.mAdnCache.updateAdnByIndex(r3, r4, r17, r18, r13);     // Catch: Throwable -> L31
        waitForResult(r12);     // Catch: Throwable -> L31
    L28:
        monitor-exit(r12);     // Catch: Throwable -> L31
        return ((Boolean) r12.mResult).booleanValue();
    L27:
        loge("Failure while trying to update by index due to uninitialised adncache");     // Catch: Throwable -> L31
        goto L28
    L17:
        if (r3 != 20272) goto L19;
    L20:
        AdnRecord r5 = new AdnRecord(28474, 0, r8, r9, r10, r11);     // Catch: Throwable -> L31
        QtiSimPhoneBookAdnRecordCache r6 = this.mSimPbAdnCache;     // Catch: Throwable -> L31
        if (r6 == null) goto L23;
        r6.updateSimPbAdnByRecordId(r5, r17, r13);     // Catch: Throwable -> L31
        waitForResult(r12);     // Catch: Throwable -> L31
        goto L28
    L23:
        loge("Failure while trying to update by index due to uninit sim pb adncache");     // Catch: Throwable -> L31
        goto L28
    L19:
        if (r3 != 28474) goto L24;
    L31:
        th = move-exception;
        throw th;
    L11:
        r11 = getAnrStringArray(r1);
        goto L12
    L7:
        r10 = getStringArray(r2);
        goto L9
    L35:
        throw new SecurityException("Requires android.permission.WRITE_CONTACTS permission");
    }

    public AdnCapacity getAdnRecordsCapacity() {
        AdnCapacity r12 = new AdnCapacity(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        if (isSimPhoneBookEnabled() == true) goto L5;
    L18:
        logd("getAdnRecordsCapacity on slot " + this.mPhoneId + ": max adn=" + r12.getMaxAdnCount() + ", used adn=" + r12.getUsedAdnCount() + ", max email=" + r12.getMaxEmailCount() + ", used email=" + r12.getUsedEmailCount() + ", max anr=" + r12.getMaxAnrCount() + ", used anr=" + r12.getUsedAnrCount() + ", max name length =" + r12.getMaxNameLength() + ", max number length =" + r12.getMaxNumberLength() + ", max email length =" + r12.getMaxEmailLength() + ", max anr length =" + r12.getMaxAnrLength());
        return r12;
    L5:
        if (this.mSimPbAdnCache == null) goto L17;
        UiccProfile r1 = UiccController.getInstance().getUiccProfileForPhone(this.mPhoneId);
        if (r1 != null) goto L10;
        logd("uicc profile is null, sim card may have error.");
        return r12;
    L10:
        IccCardConstants.State r2 = r1.getState();
        if (r2 != IccCardConstants.State.READY) goto L13;
    L16:
        r12 = new AdnCapacity(this.mSimPbAdnCache.getAdnCount(), this.mSimPbAdnCache.getUsedAdnCount(), this.mSimPbAdnCache.getEmailCount(), this.mSimPbAdnCache.getUsedEmailCount(), this.mSimPbAdnCache.getAnrCount(), this.mSimPbAdnCache.getUsedAnrCount(), this.mSimPbAdnCache.getMaxNameLen(), this.mSimPbAdnCache.getMaxNumberLen(), this.mSimPbAdnCache.getMaxEmailLen(), this.mSimPbAdnCache.getMaxAnrLen());
        goto L18
    L13:
        if (r2 == IccCardConstants.State.LOADED) goto L16;
        logd("sim state is not ready when getAdnRecordsCapacity.");
        goto L18
    L17:
        loge("mAdnCache is NULL when getAdnRecordsCapacity.");
        goto L18
    }
}
