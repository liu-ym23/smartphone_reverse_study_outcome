package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Oaid {
    public static final String KEY_OAID_ID = "oaid";
    private static volatile Oaid sOaid;
    private final Context context;
    private final OaidApi mImpl;
    private OaidModel mModel;
    private Future<OaidModel> mOaidGetFuture;
    private Runnable mPendingNotifyTask;
    private final boolean maySupport;
    private final OaidSp oaidSp;
    private final AtomicBoolean sInitializing;

    static /* synthetic */ OaidModel access$000(Oaid r0) {
        return r0.resolveOaid();
    }

    static /* synthetic */ Context access$100(Oaid r0) {
        return r0.context;
    }

    static /* synthetic */ OaidModel access$200(Oaid r0) {
        return r0.mModel;
    }

    static /* synthetic */ boolean access$300(Oaid r0) {
        return r0.maySupport;
    }

    static /* synthetic */ Runnable access$402(Oaid r0, Runnable r1) {
        r0.mPendingNotifyTask = r1;
        return r1;
    }

    public static Oaid instance(Context r2) {
        if (sOaid != null) goto L15;
        monitor-enter(Oaid.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sOaid != null) goto L9;
        sOaid = new Oaid(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(Oaid.class);     // Catch: Throwable -> L11
    L15:
        return sOaid;
    }

    public static void resetSelf(Context r2) {
        monitor-enter(Oaid.class);
        sOaid = new Oaid(r2);     // Catch: Throwable -> L7
        monitor-exit(Oaid.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Oaid(Context r4) {
        this.sInitializing = new AtomicBoolean(false);
        Context r0 = r4.getApplicationContext();
        this.context = r0;
        OaidApi r2 = OaidFactory.createOaidImpl(r4);
        this.mImpl = r2;
        if (r2 == null) goto L5;
        this.maySupport = r2.support(r4);
    L6:
        this.oaidSp = new OaidSp(r0);
        return;
    L5:
        this.maySupport = false;
        goto L6
    }

    public void init() {
        if (this.sInitializing.compareAndSet(false, true) == false) goto L6;
        OaidMonitor.onInit();
        this.mOaidGetFuture = ExecutorUtil.submitToIOExecutor(new AnonymousClass1(this));
        return;
    }

    private OaidModel resolveOaid() {
        DrLog.d("Oaid#initOaid");
        OaidMonitor.onRealStartInit();
        DrLog.d("Oaid#initOaid exec");     // Catch: Throwable -> L14
        OaidModel r2 = this.oaidSp.fetch();     // Catch: Throwable -> L14
        DrLog.d("Oaid#initOaid fetch=" + r2);     // Catch: Throwable -> L14
        if (r2 == null) goto L6;
        this.mModel = r2;     // Catch: Throwable -> L14
    L6:
        OaidMonitor.onStartSystemCall();     // Catch: Throwable -> L14
        OaidModel r1 = callSysOaid(this.context, r2);     // Catch: Throwable -> L14
        OaidMonitor.onSystemCallFinished();     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        this.oaidSp.save(r1);     // Catch: Throwable -> L14
    L9:
        if (r1 == null) goto L11;
        this.mModel = r1;     // Catch: Throwable -> L14
    L11:
        DrLog.d("Oaid#initOaid oaidModel=" + r1);     // Catch: Throwable -> L14
        OaidMonitor.onOaidFinished();
        this.mPendingNotifyTask = new AnonymousClass2(this);
        trySendOaidGetEvent();
        return r1;
    L14:
        th = move-exception;
        OaidMonitor.onOaidFinished();
        this.mPendingNotifyTask = new AnonymousClass2(this);
        trySendOaidGetEvent();
        throw th;
    }

    private synchronized void trySendOaidGetEvent() {
        monitor-enter(this);
        Runnable r0 = this.mPendingNotifyTask;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.run();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void startNotify() {
        trySendOaidGetEvent();
    }

    public Map<String, String> getOaid(long r9) {
        Map<String, String> r3 = null;
        if (this.maySupport == true) goto L5;
        return null;
    L5:
        init();
        DrLog.v("Oaid#getOaid timeoutMills=" + r9);
        OaidModel r2 = this.mModel;
        if (r2 != null) goto L16;
        long r4 = SystemClock.elapsedRealtime();
        OaidModel r10 = this.mOaidGetFuture.get(r9, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
        DrLog.d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        r2 = r10;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
        DrLog.d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
    L13:
        th = move-exception;
        DrLog.d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        throw th;
    L16:
        if (r2 != null) goto L18;
        r2 = this.mModel;
    L18:
        if (r2 == null) goto L20;
        r3 = r2.toApiMap();
    L20:
        DrLog.v("Oaid#getOaid return apiMap=" + r3);
        return r3;
    }

    public String getOaidId() {
        init();
        OaidModel r2 = this.mModel;
        if (r2 == null) goto L5;
        String r3 = r2.oaid;
    L6:
        DrLog.v("Oaid#getOaidId sOaidId=" + r3);
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public boolean maySupport() {
        init();
        return this.maySupport;
    }

    private OaidModel callSysOaid(Context r12, OaidModel r13) {
        long r0 = SystemClock.elapsedRealtime();
        OaidApi r11 = this.mImpl;
        String r2 = null;
        if (r11 == null) goto L23;
        OaidApi.Result r14 = r11.getOaid(r12);
        if (r14 == null) goto L23;
        int r15 = 1;
        if (r13 == null) goto L9;
        r2 = r13.reqId;
        int r16 = r13.queryTimes.intValue() + 1;
    L11:
        if (TextUtils.isEmpty(r2) == false) goto L13;
        r2 = UUID.randomUUID().toString();
    L13:
        String r5 = r2;
        if (r16 <= 0) goto L17;
        r15 = r16;
    L17:
        long r3 = SystemClock.elapsedRealtime() - r0;
        if ((r14 instanceof HWOaidImpl.HWOaid) == false) goto L20;
        long r1 = ((HWOaidImpl.HWOaid) r14).versionCode;
    L22:
        return new OaidModel(r14.oaid, r5, Boolean.valueOf(r14.isTrackLimit), Long.valueOf(r3), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r15), Long.valueOf(r1));
    L20:
        r1 = 0;
        goto L22
    L9:
        r16 = -1;
    L23:
        return null;
    }

    static void safePutNonEmptyValue(JSONObject r1, String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r3 == null) goto L13;
        r1.put(r2, r3);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    static <K, V> void safePutNonNullValue(Map<K, V> r0, K r1, V r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        r0.put(r1, r2);
        return;
    L7:
        return;
    }

    static boolean isPackageExisted(Context r2, String r3) {
        if (r2.getPackageManager().getPackageInfo(r3, 128) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public String getImplName() {
        OaidApi r0 = this.mImpl;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getName();
    }

    public void clear() {
        this.oaidSp.clear();
    }
}
