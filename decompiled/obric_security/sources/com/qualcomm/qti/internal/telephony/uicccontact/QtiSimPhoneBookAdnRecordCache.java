package com.qualcomm.qti.internal.telephony.uicccontact;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.telephony.Rlog;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.uicc.AdnRecord;
import com.android.internal.telephony.uicc.IccRefreshResponse;
import com.qualcomm.qti.internal.telephony.QtiRilInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes4.dex */
public class QtiSimPhoneBookAdnRecordCache extends Handler {
    private static final boolean DBG = true;
    static final int EVENT_INIT_ADN_DONE = 1;
    static final int EVENT_LOAD_ADN_RECORD_DONE = 3;
    static final int EVENT_LOAD_ALL_ADN_LIKE_DONE = 4;
    static final int EVENT_QUERY_ADN_RECORD_DONE = 2;
    static final int EVENT_SIM_REFRESH = 6;
    static final int EVENT_UPDATE_ADN_RECORD_DONE = 5;
    private static final String LOG_TAG = "QtiSimPhoneBookAdnRecordCache";
    private int mAddNumCount;
    private int mAdnCount;
    ArrayList<Message> mAdnLoadingWaiters;
    Message mAdnUpdatingWaiter;
    protected final CommandsInterface mCi;
    protected Context mContext;
    private int mEmailCount;
    private Object mLock;
    private int mMaxAnrLen;
    private int mMaxEmailLen;
    private int mMaxNameLen;
    private int mMaxNumberLen;
    protected int mPhoneId;
    private QtiRilInterface mQtiRilInterface;
    private int mRecCount;
    private boolean mRefreshAdnCache;
    private final ConcurrentSkipListMap<Integer, AdnRecord> mSimPbRecords;
    private String mTag;
    private int mValidAddNumCount;
    private int mValidAdnCount;
    private int mValidEmailCount;
    private final BroadcastReceiver sReceiver;

    /* JADX INFO: renamed from: -$$Nest$mlog, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m759$$Nest$mlog(QtiSimPhoneBookAdnRecordCache r0, String r1) {
        r0.log(r1);
    }

    public QtiSimPhoneBookAdnRecordCache(Context r5, int r6, CommandsInterface r7) {
        this.mAdnCount = 0;
        this.mValidAdnCount = 0;
        this.mEmailCount = 0;
        this.mValidEmailCount = 0;
        this.mAddNumCount = 0;
        this.mValidAddNumCount = 0;
        this.mMaxNameLen = 0;
        this.mMaxNumberLen = 0;
        this.mMaxEmailLen = 0;
        this.mMaxAnrLen = 0;
        this.mRecCount = 0;
        this.mLock = new Object();
        this.mSimPbRecords = new ConcurrentSkipListMap();
        this.mRefreshAdnCache = false;
        this.mAdnLoadingWaiters = new ArrayList();
        this.mAdnUpdatingWaiter = null;
        BroadcastReceiver r1 = new AnonymousClass1(this);
        this.sReceiver = r1;
        this.mCi = r7;
        this.mPhoneId = r6;
        this.mContext = r5;
        this.mTag = "QtiSimPhoneBookAdnRecordCache[" + r6 + "]";
        QtiRilInterface r8 = QtiRilInterface.getInstance(r5);
        this.mQtiRilInterface = r8;
        r8.registerForAdnInitDone(this, 1, null);
        r7.registerForIccRefresh(this, 6, null);
        r5.registerReceiver(r1, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
    }

    public void reset() {
        this.mAdnLoadingWaiters.clear();
        clearUpdatingWriter();
        this.mSimPbRecords.clear();
        this.mRecCount = 0;
        this.mRefreshAdnCache = false;
    }

    private void clearUpdatingWriter() {
        sendErrorResponse(this.mAdnUpdatingWaiter, "QtiSimPhoneBookAdnRecordCache reset");
        this.mAdnUpdatingWaiter = null;
    }

    private void sendErrorResponse(Message r1, String r2) {
        if (r1 == null) goto L5;
        AsyncResult.forMessage(r1).exception = new RuntimeException(r2);
        r1.sendToTarget();
        return;
    }

    private void notifyAndClearWaiters() {
        ArrayList<Message> r0 = this.mAdnLoadingWaiters;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        Message r3 = this.mAdnLoadingWaiters.get(r2);
        if (r3 == null) goto L10;
        AsyncResult.forMessage(r3, getAdnRecords(), null);
        r3.sendToTarget();
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        this.mAdnLoadingWaiters.clear();
    }

    public List<AdnRecord> getAdnRecords() {
        return new ArrayList(this.mSimPbRecords.values());
    }

    public void queryAdnRecord() {
        this.mRecCount = 0;
        this.mAdnCount = 0;
        this.mValidAdnCount = 0;
        this.mEmailCount = 0;
        this.mAddNumCount = 0;
        this.mRefreshAdnCache = false;
        log("start to queryAdnRecord");
        this.mQtiRilInterface.registerForAdnRecordsInfo(this, 3, null);
        this.mQtiRilInterface.getAdnRecord(obtainMessage(2), this.mPhoneId);
        this.mLock.wait();     // Catch: InterruptedException -> L5
    L6:
        this.mQtiRilInterface.unregisterForAdnRecordsInfo(this);
        return;
    L5:
        Rlog.e(LOG_TAG, "Interrupted Exception in queryAdnRecord");
        goto L6
    }

    public void requestLoadAllAdnLike(Message r2) {
        if (this.mQtiRilInterface.isServiceReady() == true) goto L7;
        log("Oem hook service is not ready yet ");
        sendErrorResponse(r2, "Oem hook service is not ready yet");
        return;
    L7:
        if (this.mAdnLoadingWaiters.isEmpty() == true) goto L10;
        this.mAdnLoadingWaiters.add(r2);
        return;
    L10:
        this.mAdnLoadingWaiters.add(r2);
        Object r3 = this.mLock;
        monitor-enter(r3);
    L23:
        th = move-exception;
        throw th;
    L13:
        if (this.mSimPbRecords.isEmpty() == true) goto L20;
        log("ADN cache has already filled in");     // Catch: Throwable -> L23
        if (this.mRefreshAdnCache == false) goto L17;
        refreshAdnCache();     // Catch: Throwable -> L23
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L23
        return;
    L17:
        notifyAndClearWaiters();     // Catch: Throwable -> L23
        goto L18
    L20:
        queryAdnRecord();     // Catch: Throwable -> L23
        monitor-exit(r3);     // Catch: Throwable -> L23
    }

    public void updateSimPbAdnByRecordId(AdnRecord r5, int r6, Message r7) {
        if (this.mQtiRilInterface.isServiceReady() == true) goto L6;
        log("Oem hook service is not ready yet ");
        sendErrorResponse(r7, "Oem hook service is not ready yet");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L40:
        th = move-exception;
        throw th;
    L9:
        if (this.mSimPbRecords.isEmpty() == true) goto L13;
        log("ADN cache has already filled in");     // Catch: Throwable -> L40
        if (this.mRefreshAdnCache == false) goto L14;
        refreshAdnCache();     // Catch: Throwable -> L40
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L40
        if (r5 != null) goto L18;
        sendErrorResponse(r7, "invalid adn passed");
        return;
    L18:
        AdnRecord r1 = this.mSimPbRecords.get(Integer.valueOf(r6));
        if (r1 != null) goto L23;
        sendErrorResponse(r7, "index isn't found");
        return;
    L23:
        if (r1.isEmpty() == true) goto L25;
    L27:
        int r2 = r6;
    L28:
        QtiSimPhoneBookAdnRecord r3 = new QtiSimPhoneBookAdnRecord();
        r3.mRecordIndex = r6;
        r3.mAlphaTag = r5.getAlphaTag();
        r3.mNumber = r5.getNumber();
        if (r5.getEmails() == null) goto L32;
        r3.mEmails = r5.getEmails();
        r3.mEmailCount = r3.mEmails.length;
    L32:
        if (r5.getAdditionalNumbers() == null) goto L35;
        r3.mAdNumbers = r5.getAdditionalNumbers();
        r3.mAdNumCount = r3.mAdNumbers.length;
    L35:
        if (this.mAdnUpdatingWaiter == null) goto L38;
        sendErrorResponse(r7, "Have pending update for Sim PhoneBook Adn");
        return;
    L38:
        this.mAdnUpdatingWaiter = r7;
        log("recordId = " + r6 + " index = " + r2);
        this.mQtiRilInterface.updateAdnRecord(r3, obtainMessage(5, r2, 0, r5), this.mPhoneId);
        return;
    L25:
        if (r5.isEmpty() == true) goto L27;
        r2 = 0;
        goto L28
    L13:
        queryAdnRecord();     // Catch: Throwable -> L40
        goto L14
    }

    public void updateSimPbAdnBySearch(AdnRecord r7, AdnRecord r8, Message r9) {
        if (this.mQtiRilInterface.isServiceReady() == true) goto L6;
        log("Oem hook service is not ready yet ");
        sendErrorResponse(r9, "Oem hook service is not ready yet");
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L49:
        th = move-exception;
        throw th;
    L9:
        if (this.mSimPbRecords.isEmpty() == true) goto L13;
        log("ADN cache has already filled in");     // Catch: Throwable -> L49
        if (this.mRefreshAdnCache == false) goto L14;
        refreshAdnCache();     // Catch: Throwable -> L49
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L49
        if (r7.isEmpty() == true) goto L18;
    L20:
        Iterator<AdnRecord> r1 = this.mSimPbRecords.values().iterator();
    L22:
        if (r1.hasNext() == false) goto L26;
        AdnRecord r4 = r1.next();
        if (r4.isEqual(r7) == false) goto L22;
        int r3 = r4.getRecId();
        int r2 = r3;
    L27:
        if (r3 != (-1)) goto L30;
        sendErrorResponse(r9, "Sim PhoneBook Adn record don't exist for " + r7);
        return;
    L30:
        if (r3 == 0) goto L32;
    L35:
        if (r3 != 0) goto L37;
        r2 = 0;
    L37:
        QtiSimPhoneBookAdnRecord r10 = new QtiSimPhoneBookAdnRecord();
        r10.mRecordIndex = r2;
        r10.mAlphaTag = r8.getAlphaTag();
        r10.mNumber = r8.getNumber();
        if (r8.getEmails() == null) goto L41;
        r10.mEmails = r8.getEmails();
        r10.mEmailCount = r10.mEmails.length;
    L41:
        if (r8.getAdditionalNumbers() == null) goto L44;
        r10.mAdNumbers = r8.getAdditionalNumbers();
        r10.mAdNumCount = r10.mAdNumbers.length;
    L44:
        if (this.mAdnUpdatingWaiter == null) goto L47;
        sendErrorResponse(r9, "Have pending update for Sim PhoneBook Adn");
        return;
    L47:
        this.mAdnUpdatingWaiter = r9;
        this.mQtiRilInterface.updateAdnRecord(r10, obtainMessage(5, r3, 0, r8), this.mPhoneId);
        return;
    L32:
        if (this.mValidAdnCount != this.mAdnCount) goto L35;
        sendErrorResponse(r9, "Sim PhoneBook Adn record is full");
        return;
    L26:
        r2 = 1;
        r3 = -1;
        goto L27
    L18:
        if (r8.isEmpty() == true) goto L20;
        r2 = 1;
        r3 = 0;
        goto L27
    L13:
        queryAdnRecord();     // Catch: Throwable -> L49
        goto L14
    }

    @Override // android.os.Handler
    public void handleMessage(Message r14) {
        AsyncResult r0 = (AsyncResult) r14.obj;
        int r3 = 1;
        int r4 = 0;
        switch(r14.what) {
            case 1: goto L135;
            case 2: goto L112;
            case 3: goto L97;
            case 4: goto L89;
            case 5: goto L16;
            case 6: goto L5;
            default: goto L162;
        };
    L5:
        AsyncResult r15 = (AsyncResult) r14.obj;
        log("SIM REFRESH occurred");
        if (r15.exception != null) goto L15;
        IccRefreshResponse r16 = (IccRefreshResponse) r15.result;
        if (r16 != null) goto L11;
        log("IccRefreshResponse received is null");
        return;
    L11:
        if (r16.refreshResult != 0) goto L13;
    L14:
        invalidateAdnCache();
        return;
    L13:
        if (r16.refreshResult == 1) goto L14;
        return;
    L15:
        log("SIM refresh Exception: " + r15.exception);
        return;
    L16:
        log("Update ADN record done");
        if (r0.exception != null) goto L85;
        int r17 = r14.arg1;
        AdnRecord r1 = (AdnRecord) r0.userObj;
        int r2 = ((int[]) r0.result)[0];
        log("recordIndex = " + r2 + " index = " + r17);
        if (r17 != 0) goto L36;
        log("Record number for added ADN is " + r2);
        r1.setRecId(r2);
        this.mSimPbRecords.replace(Integer.valueOf(r2), r1);
        if (r1.getEmails() == null) goto L28;
        int r18 = this.mValidEmailCount + r1.getEmails().length;
        int r5 = this.mEmailCount;
        if (r18 <= r5) goto L26;
        r18 = r5;
    L26:
        this.mValidEmailCount = r18;
    L28:
        if (r1.getAdditionalNumbers() == null) goto L34;
        int r19 = this.mValidAddNumCount + r1.getAdditionalNumbers().length;
        int r6 = this.mAddNumCount;
        if (r19 <= r6) goto L33;
        r19 = r6;
    L33:
        this.mValidAddNumCount = r19;
    L34:
        this.mValidAdnCount++;
    L53:
        RuntimeException r110 = null;
    L86:
        Message r7 = this.mAdnUpdatingWaiter;
        if (r7 == null) goto L153;
        AsyncResult.forMessage(r7, null, r110);
        this.mAdnUpdatingWaiter.sendToTarget();
        this.mAdnUpdatingWaiter = null;
        return;
    L153:
        return;
    L36:
        if (r1.isEmpty() == false) goto L55;
        AdnRecord r111 = this.mSimPbRecords.get(Integer.valueOf(r2));
        int r8 = r111.getRecId();
        log("Record number for deleted ADN is " + r8);
        if (r2 == r8) goto L40;
        r110 = new RuntimeException("The index for deleted ADN record did not match");
        goto L86
    L40:
        if (r111.getEmails() == null) goto L47;
        int r9 = this.mValidEmailCount - r111.getEmails().length;
        if (r9 > 0) goto L45;
        r9 = 0;
    L45:
        this.mValidEmailCount = r9;
    L47:
        if (r111.getAdditionalNumbers() == null) goto L52;
        int r10 = this.mValidAddNumCount - r111.getAdditionalNumbers().length;
        if (r10 <= 0) goto L51;
        r4 = r10;
    L51:
        this.mValidAddNumCount = r4;
    L52:
        r1.setRecId(r2);
        this.mSimPbRecords.replace(Integer.valueOf(r2), r1);
        this.mValidAdnCount--;
        goto L53
    L55:
        AdnRecord r112 = this.mSimPbRecords.get(Integer.valueOf(r2));
        int r11 = r112.getRecId();
        log("Record number for changed ADN is " + r11);
        if (r2 == r11) goto L58;
        r110 = new RuntimeException("The index for changed ADN record did not match");
        goto L86
    L58:
        if (r112.getEmails() != null) goto L60;
        int r12 = 0;
    L62:
        if (r1.getEmails() != null) goto L64;
        int r13 = 0;
    L65:
        int r20 = this.mValidEmailCount;
        int r21 = (r20 - r12) + r13;
        if (r21 > 0) goto L68;
    L70:
        this.mValidEmailCount = r20;
        if (r112.getAdditionalNumbers() != null) goto L73;
        int r113 = 0;
    L75:
        if (r1.getAdditionalNumbers() == null) goto L78;
        r4 = r1.getAdditionalNumbers().length;
    L78:
        int r22 = this.mValidAddNumCount;
        int r114 = (r22 - r113) + r4;
        if (r114 > 0) goto L81;
    L83:
        this.mValidAddNumCount = r22;
        r1.setRecId(r2);
        this.mSimPbRecords.replace(Integer.valueOf(r2), r1);
        goto L53
    L81:
        if (r114 > this.mAddNumCount) goto L83;
        r22 = r114;
        goto L83
    L73:
        r113 = r112.getAdditionalNumbers().length;
        goto L75
    L68:
        if (r21 > this.mEmailCount) goto L70;
        r20 = r21;
        goto L70
    L64:
        r13 = r1.getEmails().length;
        goto L65
    L60:
        r12 = r112.getEmails().length;
        goto L62
    L85:
        r110 = new RuntimeException("Update adn record failed", r0.exception);
        goto L86
    L89:
        log("Loading all ADN records done");
        Object r115 = this.mLock;
        monitor-enter(r115);
        this.mLock.notify();     // Catch: Throwable -> L94
        monitor-exit(r115);     // Catch: Throwable -> L94
        notifyAndClearWaiters();
        return;
    L94:
        th = move-exception;
        throw th;
    L97:
        log("Loading ADN record done");
        if (r0.exception != null) goto L163;
        QtiSimPhoneBookAdnRecord[] r116 = (QtiSimPhoneBookAdnRecord[]) r0.result;
        if (r116 != null) goto L104;
        return;
    L104:
        if (r4 >= r116.length) goto L110;
        QtiSimPhoneBookAdnRecord r23 = r116[r4];
        if (r23 == null) goto L108;
        this.mSimPbRecords.replace(Integer.valueOf(r23.getRecordIndex()), new AdnRecord(28474, r116[r4].getRecordIndex(), r116[r4].getAlphaTag(), r116[r4].getNumber(), r116[r4].getEmails(), r116[r4].getAdNumbers()));
        this.mRecCount++;
    L108:
        r4 = r4 + 1;
        goto L104
    L110:
        if (this.mRecCount != this.mValidAdnCount) goto L156;
        sendMessage(obtainMessage(4));
        return;
    L156:
        return;
    L163:
        return;
    L112:
        log("Querying ADN record done");
        if (r0.exception == null) goto L126;
        Object r117 = this.mLock;
        monitor-enter(r117);
        this.mLock.notify();     // Catch: Throwable -> L123
        monitor-exit(r117);     // Catch: Throwable -> L123
        Iterator<Message> r118 = this.mAdnLoadingWaiters.iterator();
    L120:
        if (r118.hasNext() == false) goto L122;
        sendErrorResponse(r118.next(), "Query adn record failed" + r0.exception);
        goto L120
    L122:
        this.mAdnLoadingWaiters.clear();
        return;
    L123:
        th = move-exception;
        throw th;
    L126:
        this.mAdnCount = ((int[]) r0.result)[0];
        this.mValidAdnCount = ((int[]) r0.result)[1];
        this.mEmailCount = ((int[]) r0.result)[2];
        this.mValidEmailCount = ((int[]) r0.result)[3];
        this.mAddNumCount = ((int[]) r0.result)[4];
        this.mValidAddNumCount = ((int[]) r0.result)[5];
        this.mMaxNameLen = ((int[]) r0.result)[6];
        this.mMaxNumberLen = ((int[]) r0.result)[7];
        this.mMaxEmailLen = ((int[]) r0.result)[8];
        this.mMaxAnrLen = ((int[]) r0.result)[9];
        log("Max ADN count is: " + this.mAdnCount + ", Valid ADN count is: " + this.mValidAdnCount + ", Email count is: " + this.mEmailCount + ", Valid email count is: " + this.mValidEmailCount + ", Add number count is: " + this.mAddNumCount + ", Valid add number count is: " + this.mValidAddNumCount + ", Max name length is: " + this.mMaxNameLen + ", Max number length is: " + this.mMaxNumberLen + ", Max email length is: " + this.mMaxEmailLen + ", Valid anr length is: " + this.mMaxAnrLen);
    L128:
        if (r3 > this.mAdnCount) goto L130;
        this.mSimPbRecords.putIfAbsent(Integer.valueOf(r3), new AdnRecord(28474, r3, null, null, null, null));
        r3 = r3 + 1;
        goto L128
    L130:
        int r119 = this.mValidAdnCount;
        if (r119 != 0) goto L133;
    L134:
        sendMessage(obtainMessage(4));
        return;
    L133:
        if (this.mRecCount == r119) goto L134;
        return;
    L135:
        AsyncResult r120 = (AsyncResult) r14.obj;
        log("Initialized ADN done");
        if (r120.exception != null) goto L138;
        invalidateAdnCache();
        return;
    L138:
        log("Init ADN done Exception: " + r120.exception);
        return;
    }

    public int getAdnCount() {
        return this.mAdnCount;
    }

    public int getUsedAdnCount() {
        return this.mValidAdnCount;
    }

    public int getEmailCount() {
        return this.mEmailCount;
    }

    public int getUsedEmailCount() {
        return this.mValidEmailCount;
    }

    public int getAnrCount() {
        return this.mAddNumCount;
    }

    public int getUsedAnrCount() {
        return this.mValidAddNumCount;
    }

    public int getMaxNameLen() {
        return this.mMaxNameLen;
    }

    public int getMaxNumberLen() {
        return this.mMaxNumberLen;
    }

    public int getMaxEmailLen() {
        return this.mMaxEmailLen;
    }

    public int getMaxAnrLen() {
        return this.mMaxAnrLen;
    }

    private void log(String r1) {
        Rlog.d(this.mTag, r1);
    }

    public void invalidateAdnCache() {
        log("invalidateAdnCache");
        this.mRefreshAdnCache = true;
    }

    private void refreshAdnCache() {
        log("refreshAdnCache");
        this.mSimPbRecords.clear();
        queryAdnRecord();
    }

    public boolean getRefreshAdnCache() {
        return this.mRefreshAdnCache;
    }
}
