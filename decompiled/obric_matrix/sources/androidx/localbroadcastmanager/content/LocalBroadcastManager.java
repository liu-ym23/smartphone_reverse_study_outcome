package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = null;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers;

    private static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent r1, ArrayList<ReceiverRecord> r2) {
            this.intent = r1;
            this.receivers = r2;
        }
    }

    private static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter r1, BroadcastReceiver r2) {
            this.filter = r1;
            this.receiver = r2;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(128);
            r0.append("Receiver{");
            r0.append(this.receiver);
            r0.append(" filter=");
            r0.append(this.filter);
            if (this.dead == false) goto L5;
            r0.append(" DEAD");
        L5:
            r0.append("}");
            return r0.toString();
        }
    }

    static {
        mLock = new Object();
    }

    private LocalBroadcastManager(Context r2) {
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = r2;
        final Looper r3 = r2.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r3);
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context r2) {
        Object r0 = mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L7;
        mInstance = new LocalBroadcastManager(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        LocalBroadcastManager r3 = mInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    }

    void executePendingBroadcasts() {
    L2:
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r0 = this.mReceivers;
        monitor-enter(r0);
        int r1 = this.mPendingBroadcasts.size();     // Catch: Throwable -> L19
        if (r1 <= 0) goto L6;
        BroadcastRecord[] r2 = new BroadcastRecord[r1];     // Catch: Throwable -> L19
        this.mPendingBroadcasts.toArray(r2);     // Catch: Throwable -> L19
        this.mPendingBroadcasts.clear();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L2;
        BroadcastRecord r4 = r2[r3];
        int r5 = r4.receivers.size();
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L18;
        ReceiverRecord r7 = r4.receivers.get(r6);
        if (r7.dead == true) goto L17;
        r7.receiver.onReceive(this.mAppContext, r4.intent);
    L17:
        r6 = r6 + 1;
        goto L13
    L18:
        r3 = r3 + 1;
        goto L11
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public void registerReceiver(@NonNull BroadcastReceiver r7, @NonNull IntentFilter r8) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r0 = this.mReceivers;
        monitor-enter(r0);
        ReceiverRecord r1 = new ReceiverRecord(r8, r7);     // Catch: Throwable -> L16
        ArrayList<ReceiverRecord> r2 = this.mReceivers.get(r7);     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
        r2 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mReceivers.put(r7, r2);     // Catch: Throwable -> L16
    L7:
        r2.add(r1);     // Catch: Throwable -> L16
        int r9 = 0;
    L9:
        if (r9 >= r8.countActions()) goto L14;
        String r3 = r8.getAction(r9);     // Catch: Throwable -> L16
        ArrayList<ReceiverRecord> r4 = this.mActions.get(r3);     // Catch: Throwable -> L16
        if (r4 != null) goto L13;
        r4 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mActions.put(r3, r4);     // Catch: Throwable -> L16
    L13:
        r4.add(r1);     // Catch: Throwable -> L16
        r9 = r9 + 1;     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public boolean sendBroadcast(@NonNull Intent r22) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r2 = this.mReceivers;
        monitor-enter(r2);
        String r10 = r22.getAction();     // Catch: Throwable -> L64
        String r11 = r22.resolveTypeIfNeeded(this.mAppContext.getContentResolver());     // Catch: Throwable -> L64
        Uri r12 = r22.getData();     // Catch: Throwable -> L64
        String r13 = r22.getScheme();     // Catch: Throwable -> L64
        Set<String> r14 = r22.getCategories();     // Catch: Throwable -> L64
        if ((r22.getFlags() & 8) == 0) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == false) goto L10;
        Log.v(TAG, "Resolving type " + r11 + " scheme " + r13 + " of intent " + r22);     // Catch: Throwable -> L64
    L10:
        ArrayList<ReceiverRecord> r8 = this.mActions.get(r22.getAction());     // Catch: Throwable -> L64
        if (r8 == null) goto L61;
        if (r16 == false) goto L14;
        Log.v(TAG, "Action list: " + r8);     // Catch: Throwable -> L64
    L14:
        ArrayList r7 = null;
        int r6 = 0;
    L16:
        if (r6 >= r8.size()) goto L50;
        ReceiverRecord r5 = r8.get(r6);     // Catch: Throwable -> L64
        if (r16 == false) goto L21;
        Log.v(TAG, "Matching against filter " + r5.filter);     // Catch: Throwable -> L64
    L21:
        if (r5.broadcasting == false) goto L25;
        if (r16 == false) goto L24;
        Log.v(TAG, "  Filter's target already added");     // Catch: Throwable -> L64
    L24:
        int r17 = r6;
        ArrayList<ReceiverRecord> r19 = r8;
        String r18 = r10;
        String r20 = r11;
        ArrayList r15 = r7;
    L48:
        r7 = r15;
    L49:
        r6 = r17 + 1;     // Catch: Throwable -> L64
        r10 = r18;
        r8 = r19;
        r11 = r20;
        goto L16
    L25:
        r17 = r6;
        r18 = r10;
        r15 = r7;
        r19 = r8;
        r20 = r11;
        int r3 = r5.filter.match(r10, r11, r13, r12, r14, TAG);     // Catch: Throwable -> L64
        if (r3 < 0) goto L33;
        if (r16 == false) goto L29;
        Log.v(TAG, "  Filter matched!  match=0x" + Integer.toHexString(r3));     // Catch: Throwable -> L64
    L29:
        if (r15 != null) goto L31;
        r7 = new ArrayList();     // Catch: Throwable -> L64
    L32:
        r7.add(r5);     // Catch: Throwable -> L64
        r5.broadcasting = true;     // Catch: Throwable -> L64
        goto L49
    L31:
        r7 = r15;
        goto L32
    L33:
        if (r16 == false) goto L48;
        if (r3 != (-4)) goto L37;
        String r4 = "category";
    L47:
        Log.v(TAG, "  Filter did not match: " + r4);     // Catch: Throwable -> L64
        goto L48
    L37:
        if (r3 != (-3)) goto L39;
        r4 = "action";
        goto L47
    L39:
        if (r3 != (-2)) goto L41;
        r4 = "data";
        goto L47
    L41:
        if (r3 == (-1)) goto L43;
        r4 = "unknown reason";
        goto L47
    L43:
        r4 = WsConstants.KEY_CONNECTION_TYPE;
        goto L47
    L50:
        ArrayList r110 = r7;
        if (r110 == null) goto L61;
        int r9 = 0;
    L54:
        if (r9 >= r110.size()) goto L56;
        ((ReceiverRecord) r110.get(r9)).broadcasting = false;     // Catch: Throwable -> L64
        r9 = r9 + 1;     // Catch: Throwable -> L64
        goto L54
    L56:
        this.mPendingBroadcasts.add(new BroadcastRecord(r22, r110));     // Catch: Throwable -> L64
        if (this.mHandler.hasMessages(1) == true) goto L59;
        this.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L64
    L59:
        monitor-exit(r2);     // Catch: Throwable -> L64
        return true;
    L61:
        monitor-exit(r2);     // Catch: Throwable -> L64
        return false;
    L7:
        r16 = false;
    L64:
        th = move-exception;
        throw th;
    }

    public void sendBroadcastSync(@NonNull Intent r1) {
        if (sendBroadcast(r1) == false) goto L6;
        executePendingBroadcasts();
        return;
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver r12) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r0 = this.mReceivers;
        monitor-enter(r0);
        ArrayList<ReceiverRecord> r1 = this.mReceivers.remove(r12);     // Catch: Throwable -> L28
        if (r1 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L8:
        int r2 = r1.size() - 1;     // Catch: Throwable -> L28
    L9:
        if (r2 < 0) goto L26;
        ReceiverRecord r4 = r1.get(r2);     // Catch: Throwable -> L28
        r4.dead = true;     // Catch: Throwable -> L28
        int r5 = 0;
    L12:
        if (r5 >= r4.filter.countActions()) goto L25;
        String r6 = r4.filter.getAction(r5);     // Catch: Throwable -> L28
        ArrayList<ReceiverRecord> r7 = this.mActions.get(r6);     // Catch: Throwable -> L28
        if (r7 == null) goto L24;
        int r8 = r7.size() - 1;     // Catch: Throwable -> L28
    L16:
        if (r8 < 0) goto L22;
        ReceiverRecord r9 = r7.get(r8);     // Catch: Throwable -> L28
        if (r9.receiver != r12) goto L20;
        r9.dead = true;     // Catch: Throwable -> L28
        r7.remove(r8);     // Catch: Throwable -> L28
    L20:
        r8 = r8 - 1;     // Catch: Throwable -> L28
        goto L16
    L22:
        if (r7.size() > 0) goto L24;
        this.mActions.remove(r6);     // Catch: Throwable -> L28
    L24:
        r5 = r5 + 1;     // Catch: Throwable -> L28
        goto L12
    L25:
        r2 = r2 - 1;     // Catch: Throwable -> L28
        goto L9
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }
}
