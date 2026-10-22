package com.obric.securitycenter.api;

import android.os.Handler;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: TrackUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005*\u0001\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\u0006\u0010!\u001a\u00020\u001bJ\b\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0002J2\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020#H\u0007J\b\u0010*\u001a\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/securitycenter/api/TrackUtils;", "", "()V", "FLUSH_BATCH_SIZE", "", "MAX_PENDING_EVENTS", "TAG", "", "deviceInfoListener", "com/obric/securitycenter/api/TrackUtils$deviceInfoListener$1", "Lcom/obric/securitycenter/api/TrackUtils$deviceInfoListener$1;", "didReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "flushScheduled", "listenerRegistered", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "pendingCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "pendingQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/obric/securitycenter/api/TrackUtils$PendingEvent;", "enqueuePendingEvent", "", "eventName", "jsonObject", "Lorg/json/JSONObject;", "ensureListenerRegistered", "flushPendingEvents", "init", "isDeviceIdReady", "", "isValidDeviceId", "deviceId", "trackEvent", "eventParams", "", "needDid", "triggerFlush", "trimOldestPendingEvents", "PendingEvent", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TrackUtils {
    private static final int FLUSH_BATCH_SIZE = 30;
    public static final TrackUtils INSTANCE = null;
    private static final int MAX_PENDING_EVENTS = 200;
    private static final String TAG = "TrackUtils";
    private static final TrackUtils$deviceInfoListener$1 deviceInfoListener = null;
    private static final AtomicBoolean didReady = null;
    private static final AtomicBoolean flushScheduled = null;
    private static final AtomicBoolean listenerRegistered = null;
    private static final Lazy mainHandler$delegate = null;
    private static final AtomicInteger pendingCount = null;
    private static final ConcurrentLinkedQueue<PendingEvent> pendingQueue = null;

    /* JADX INFO: compiled from: TrackUtils.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/securitycenter/api/TrackUtils$PendingEvent;", "", "eventName", "", "jsonObject", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getEventName", "()Ljava/lang/String;", "getJsonObject", "()Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class PendingEvent {
        private final String eventName;
        private final JSONObject jsonObject;

        public static /* synthetic */ PendingEvent copy$default(PendingEvent r0, String r1, JSONObject r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.eventName;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.jsonObject;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.eventName;
        }

        public final JSONObject component2() {
            return this.jsonObject;
        }

        public final PendingEvent copy(String r1, JSONObject r2) {
            Intrinsics.checkNotNullParameter(r1, "eventName");
            Intrinsics.checkNotNullParameter(r2, "jsonObject");
            return new PendingEvent(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PendingEvent) == true) goto L8;
            return false;
        L8:
            PendingEvent r6 = (PendingEvent) r5;
            if (Intrinsics.areEqual(this.eventName, r6.eventName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.jsonObject, r6.jsonObject) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.eventName.hashCode() * 31) + this.jsonObject.hashCode();
        }

        public String toString() {
            return "PendingEvent(eventName=" + this.eventName + ", jsonObject=" + this.jsonObject + ")";
        }

        public PendingEvent(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "jsonObject");
            this.eventName = r2;
            this.jsonObject = r3;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final JSONObject getJsonObject() {
            return this.jsonObject;
        }
    }

    public static /* synthetic */ void $r8$lambda$c6nnbExwcwpgxxQmULRZ_bOrzE8() {
        triggerFlush$lambda$1();
    }

    public final void trackEvent(String r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        trackEvent$default(this, r8, r9, false, 4, null);
    }

    private TrackUtils() {
    }

    public static final /* synthetic */ AtomicBoolean access$getDidReady$p() {
        return didReady;
    }

    public static final /* synthetic */ boolean access$isValidDeviceId(TrackUtils r0, String r1) {
        return r0.isValidDeviceId(r1);
    }

    public static final /* synthetic */ void access$triggerFlush(TrackUtils r0) {
        r0.triggerFlush();
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.securitycenter.api.TrackUtils$deviceInfoListener$1] */
    static {
        INSTANCE = new TrackUtils();
        mainHandler$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TrackUtils$mainHandler$2.INSTANCE);
        pendingQueue = new ConcurrentLinkedQueue();
        pendingCount = new AtomicInteger(0);
        listenerRegistered = new AtomicBoolean(false);
        didReady = new AtomicBoolean(false);
        flushScheduled = new AtomicBoolean(false);
        deviceInfoListener = new TrackUtils$deviceInfoListener$1();
    }

    private final Handler getMainHandler() {
        return (Handler) mainHandler$delegate.getValue();
    }

    public final void init() {
        ensureListenerRegistered();
    }

    public static /* synthetic */ void trackEvent$default(TrackUtils r0, String r1, Map r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.trackEvent(r1, r2, r3);
    }

    public final void trackEvent(String r6, Map<String, ? extends Object> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        OLog.d(TAG, "trackEvent: " + r6);
        if (r8 == false) goto L5;
        ensureListenerRegistered();
    L5:
        JSONObject r0 = new JSONObject();
        if (r7 == null) goto L31;
        Iterator<Map.Entry<String, ? extends Object>> r9 = r7.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L31;
        Map.Entry<String, ? extends Object> r1 = r9.next();
        String r2 = r1.getKey();
        Object r3 = r1.getValue();
        if ((r3 instanceof String) == true) goto L12;
        if ((r3 instanceof Integer) == true) goto L15;
        if ((r3 instanceof Long) == true) goto L18;
        if ((r3 instanceof Boolean) == true) goto L21;
        if ((r3 instanceof Double) == true) goto L24;
        if ((r3 instanceof Float) == true) goto L27;
        if (r3 == null) goto L29;
        r0.put(r2, r3.toString());
        goto L9
    L29:
        r0.put(r2, JSONObject.NULL);
        goto L9
    L27:
        r0.put(r2, ((Number) r3).floatValue());
        goto L9
    L24:
        r0.put(r2, ((Number) r3).doubleValue());
        goto L9
    L21:
        r0.put(r2, ((Boolean) r3).booleanValue());
        goto L9
    L18:
        r0.put(r2, ((Number) r3).longValue());
        goto L9
    L15:
        r0.put(r2, ((Number) r3).intValue());
        goto L9
    L12:
        r0.put(r2, r3);
    L31:
        if (r8 == true) goto L33;
    L37:
        MatrixTeaManager.Companion.getInstance().onEvent(r6, r0);
        return;
    L33:
        if (isDeviceIdReady() == true) goto L37;
        if (r8 == false) goto L63;
        enqueuePendingEvent(r6, r0);
        return;
    }

    private final void ensureListenerRegistered() {
        if (listenerRegistered.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        MatrixTeaManager.Companion.getInstance().addDeviceInfoListener(deviceInfoListener);
        if (isDeviceIdReady() == false) goto L9;
        triggerFlush();
        return;
    }

    private final void enqueuePendingEvent(String r3, JSONObject r4) {
        pendingQueue.offer(new PendingEvent(r3, r4));
        if (pendingCount.incrementAndGet() <= 200) goto L6;
        trimOldestPendingEvents();
        return;
    }

    private final void trimOldestPendingEvents() {
    L2:
        AtomicInteger r2 = pendingCount;
        if (r2.get() <= 200) goto L8;
        if (pendingQueue.poll() == null) goto L11;
        r2.decrementAndGet();
        goto L2
    L11:
        return;
    }

    private final void triggerFlush() {
        if (flushScheduled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        getMainHandler().post(new TrackUtils$$ExternalSyntheticLambda0());
    }

    private static final void triggerFlush$lambda$1() {
        INSTANCE.flushPendingEvents();
    }

    private final void flushPendingEvents() {
        int r1 = 0;
        flushScheduled.set(false);
        if (isDeviceIdReady() == true) goto L6;
        return;
    L6:
        if (r1 >= 30) goto L12;
        PendingEvent r0 = pendingQueue.poll();
        if (r0 == null) goto L12;
        pendingCount.decrementAndGet();
        MatrixTeaManager.Companion.getInstance().onEvent(r0.getEventName(), r0.getJsonObject());
        r1 = r1 + 1;
    L12:
        if ((!pendingQueue.isEmpty()) == true) goto L14;
        return;
    L14:
        if (isDeviceIdReady() == false) goto L20;
        triggerFlush();
        return;
    }

    private final boolean isDeviceIdReady() {
        AtomicBoolean r0 = didReady;
        if (r0.get() == false) goto L5;
        return true;
    L5:
        boolean r3 = isValidDeviceId(MatrixTeaManager.Companion.getInstance().getDeviceId());
        if (r3 == false) goto L8;
        r0.set(true);
    L8:
        return r3;
    }

    private final boolean isValidDeviceId(String r3) {
        String r2 = r3;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r3, "0") == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r3, "-1") == false) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r4 = false;
        goto L9
    }
}
