package com.bytedance.bdinstall;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class SubpSyncManager {
    private static final String EVENT_INSTALL_INFO_CHANGE = "install_info_change";
    static final String F_NAME_MULTI_PROCESS = "ug_install_op_pref";
    private static final Singleton<SubpSyncManager> INSTANCE = null;
    private static final String KEY_EVENT_KEY = "key";
    private static final String KEY_EVENT_VALUE = "value";
    private static final Map<String, String> sCacheValues = null;
    private static final Map<String, List<OnUpdateListener>> sListeners = null;
    private final Context mContext;
    private AtomicBoolean mHasObserve;

    public interface OnUpdateListener {
        void onUpdate(String r1);
    }

    /* synthetic */ SubpSyncManager(Context r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Context access$100(SubpSyncManager r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$200(SubpSyncManager r0, Uri r1) {
        r0.notifyWithUri(r1);
    }

    static {
        sCacheValues = new ConcurrentHashMap();
        sListeners = new ConcurrentHashMap();
        INSTANCE = new AnonymousClass1();
    }

    private SubpSyncManager(Context r3) {
        this.mHasObserve = new AtomicBoolean(false);
        this.mContext = r3;
    }

    static SubpSyncManager inst(Context r3) {
        return INSTANCE.get(new Object[]{r3});
    }

    void sendSubpEvent(String r4, String r5) {
        this.mContext.getSharedPreferences(F_NAME_MULTI_PROCESS, 0).edit().putString(r4, r5).commit();     // Catch: Exception -> L7
        Uri r0 = BDInstallProvider.getContentUri(this.mContext, EVENT_INSTALL_INFO_CHANGE);     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        final Uri r6 = r0.buildUpon().appendQueryParameter("key", r4).appendQueryParameter("value", r5).build();     // Catch: Exception -> L7
        final int[] r7 = new int[1];     // Catch: Exception -> L7
        new AnonymousClass2(this, r6, r7).run();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        DrLog.e("sendSubpEvent error", e);
    }

    void observer(String r4, OnUpdateListener r5) {
        observer();
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        putToListenerCache(r4, r5);     // Catch: Throwable -> L16
        Map<String, String> r0 = sCacheValues;     // Catch: Throwable -> L16
        if (r0.containsKey(r4) == false) goto L11;
        tryNotify(r0.get(r4), r5);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L11:
        String r6 = this.mContext.getSharedPreferences(F_NAME_MULTI_PROCESS, 0).getString(r4, null);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r6) == true) goto L14;
        tryNotify(r6, r5);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void putToListenerCache(String r2, OnUpdateListener r3) {
        Map<String, List<OnUpdateListener>> r1 = sListeners;
        List<OnUpdateListener> r0 = r1.get(r2);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        r1.put(r2, r0);
    L5:
        r0.add(r3);
    }

    private void tryNotify(String r1, OnUpdateListener r2) {
        if (r2 == null) goto L5;
        r2.onUpdate(r1);
        return;
    }

    private void notifyWithUri(Uri r3) {
        monitor-enter(this);
        String r0 = r3.getQueryParameter("key");     // Catch: Throwable -> L17
        String r4 = r3.getQueryParameter("value");     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r0) == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L7:
        sCacheValues.put(r0, r4);     // Catch: Throwable -> L17
        List<OnUpdateListener> r1 = sListeners.get(r0);     // Catch: Throwable -> L17
        if (r1 == null) goto L15;
        Iterator<OnUpdateListener> r2 = r1.iterator();     // Catch: Throwable -> L17
    L11:
        if (r2.hasNext() == false) goto L15;
        OnUpdateListener r5 = r2.next();     // Catch: Throwable -> L17
        if (r5 == null) goto L11;
        r5.onUpdate(r4);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void observer() {
        if (this.mHasObserve.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Uri r0 = BDInstallProvider.getContentUri(this.mContext, EVENT_INSTALL_INFO_CHANGE);
        if (r0 != null) goto L8;
        return;
    L8:
        ContentResolver r1 = this.mContext.getContentResolver();
        final Handler r4 = ExecutorUtil.getHandler();
        r1.registerContentObserver(r0, true, new AnonymousClass3(this, r4));
    }
}
