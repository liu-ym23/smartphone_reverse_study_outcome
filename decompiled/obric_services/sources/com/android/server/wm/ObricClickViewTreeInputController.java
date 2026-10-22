package com.android.server.wm;

import android.app.clickviewtree.ClickViewTreeConstants;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.android.internal.os.BackgroundThread;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ObricClickViewTreeInputController {
    private static final float COORD_MATCH_EPSILON = 1.0f;
    private static final int FINGERPRINT_PART_COUNT = 6;
    private static final int JSON_LOG_CHUNK = 3000;
    private static final int MAX_PENDING_COUNT = 32;
    private static final long PENDING_TTL_MILLIS = 5000;
    private static final double RATE_BURST_TOKENS = 30.0d;
    private static final double RATE_TOKENS_PER_SEC = 15.0d;
    private static final String TAG = "ObricClickViewTreeInputController";
    private final Runnable mCleanupRunnable;
    private boolean mCleanupScheduled;
    private final Handler mHandler;
    private final Object mLock;
    private long mNextEventSeq;
    private final ArrayMap<String, PendingClick> mPendingByDownKey;
    private final ArrayMap<String, PendingClick> mPendingByMatchKey;
    private final ArrayDeque<PendingClick> mPendingOrder;
    private final SparseArray<RateBucket> mRateByUid;
    private final TimeoutListener mTimeoutListener;

    public static final class PendingClick {
        private final int mDisplayId;
        private final String mDownKey;
        private final float mDownRawX;
        private final float mDownRawY;
        private final String mEventId;
        private boolean mHasUp;
        private String mMatchKey;
        private final int mSource;
        private int mUpEventId;
        private float mUpRawX;
        private float mUpRawY;
        private long mUpdatedElapsedMillis;

        /* JADX INFO: renamed from: -$$Nest$fgetmDisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m45$$Nest$fgetmDisplayId(PendingClick r0) {
            return r0.mDisplayId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDownRawX, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m46$$Nest$fgetmDownRawX(PendingClick r0) {
            return r0.mDownRawX;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDownRawY, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m47$$Nest$fgetmDownRawY(PendingClick r0) {
            return r0.mDownRawY;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEventId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m48$$Nest$fgetmEventId(PendingClick r0) {
            return r0.mEventId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHasUp, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m49$$Nest$fgetmHasUp(PendingClick r0) {
            return r0.mHasUp;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSource, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m50$$Nest$fgetmSource(PendingClick r0) {
            return r0.mSource;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUpRawX, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m51$$Nest$fgetmUpRawX(PendingClick r0) {
            return r0.mUpRawX;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUpRawY, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m52$$Nest$fgetmUpRawY(PendingClick r0) {
            return r0.mUpRawY;
        }

        private PendingClick(String eventId, MotionEvent event, String downKey, long nowElapsed, boolean hasUp) {
            this.mUpEventId = -1;
            this.mEventId = eventId;
            this.mDownKey = downKey;
            this.mDisplayId = event.getDisplayId();
            this.mDownRawX = event.getRawX();
            this.mDownRawY = event.getRawY();
            this.mSource = event.getSource();
            this.mUpdatedElapsedMillis = nowElapsed;
            if (hasUp == false) goto L6;
            updateUp(event, nowElapsed);
            return;
        }

        static PendingClick forDown(String eventId, MotionEvent event, String downKey, long nowElapsed) {
            return new PendingClick(eventId, event, downKey, nowElapsed, false);
        }

        static PendingClick forUpOnly(String eventId, MotionEvent event, String downKey, long nowElapsed) {
            return new PendingClick(eventId, event, downKey, nowElapsed, true);
        }

        void updateUp(MotionEvent event, long nowElapsed) {
            this.mUpRawX = event.getRawX();
            this.mUpRawY = event.getRawY();
            this.mMatchKey = ObricClickViewTreeInputController.buildMatchKey(event);
            this.mUpEventId = event.getId();
            this.mUpdatedElapsedMillis = nowElapsed;
            this.mHasUp = true;
        }

        boolean matchesCoordinates(float rawX, float rawY) {
            if (this.mHasUp == true) goto L5;
        L9:
            return false;
        L5:
            if (Math.abs(this.mUpRawX - rawX) > ObricClickViewTreeInputController.COORD_MATCH_EPSILON) goto L9;
            if (Math.abs(this.mUpRawY - rawY) > ObricClickViewTreeInputController.COORD_MATCH_EPSILON) goto L9;
            return true;
        }

        String getDownKey() {
            return this.mDownKey;
        }

        String getMatchKey() {
            return this.mMatchKey;
        }

        int getUpEventId() {
            return this.mUpEventId;
        }

        long getUpdatedElapsedMillis() {
            return this.mUpdatedElapsedMillis;
        }

        boolean hasUp() {
            return this.mHasUp;
        }
    }

    private static final class RateBucket {
        private long mLastRefillElapsed;
        private double mTokens;

        /* JADX INFO: renamed from: -$$Nest$fgetmLastRefillElapsed, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m53$$Nest$fgetmLastRefillElapsed(RateBucket r2) {
            return r2.mLastRefillElapsed;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTokens, reason: not valid java name */
        static /* bridge */ /* synthetic */ double m54$$Nest$fgetmTokens(RateBucket r2) {
            return r2.mTokens;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmLastRefillElapsed, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m55$$Nest$fputmLastRefillElapsed(RateBucket r0, long r1) {
            r0.mLastRefillElapsed = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmTokens, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m56$$Nest$fputmTokens(RateBucket r0, double r1) {
            r0.mTokens = r1;
        }

        RateBucket(double tokens, long nowElapsed) {
            this.mTokens = tokens;
            this.mLastRefillElapsed = nowElapsed;
        }
    }

    public interface TimeoutListener {
        void onClickTimeout(int r1);
    }

    public static /* synthetic */ void $r8$lambda$oP1bnF1nwNmFEoW1pXZl7TWQ0E4(ObricClickViewTreeInputController r0) {
        r0.lambda$new$0();
    }

    private /* synthetic */ void lambda$new$0() {
        ArrayList<PendingClick> expired = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mCleanupScheduled = false;     // Catch: Throwable -> L9
        long nowElapsed = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        pruneLocked(nowElapsed, expired);     // Catch: Throwable -> L9
        pruneRateBucketsLocked(nowElapsed);     // Catch: Throwable -> L9
        scheduleCleanupLocked(nowElapsed);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        notifyPendingTimeouts(expired);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    ObricClickViewTreeInputController(TimeoutListener timeoutListener) {
        this.mLock = new Object();
        this.mPendingByDownKey = new ArrayMap();
        this.mPendingByMatchKey = new ArrayMap();
        this.mPendingOrder = new ArrayDeque();
        this.mRateByUid = new SparseArray();
        this.mHandler = BackgroundThread.getHandler();
        this.mCleanupRunnable = new ObricClickViewTreeInputController$$ExternalSyntheticLambda0(this);
        this.mTimeoutListener = timeoutListener;
    }

    public void onMotionEventCandidate(MotionEvent event) {
        int action = event.getActionMasked();
        if (action == 0) goto L8;
        if (action == 1) goto L8;
        return;
    L8:
        if (isPointerSource(event.getSource()) == true) goto L10;
        return;
    L10:
        long nowElapsed = SystemClock.elapsedRealtime();
        ArrayList<PendingClick> expired = new ArrayList();
        Object r4 = this.mLock;
        monitor-enter(r4);
        pruneLocked(nowElapsed, expired);     // Catch: Throwable -> L20
        if (action != 0) goto L15;
        recordDownLocked(event, nowElapsed);     // Catch: Throwable -> L20
    L16:
        scheduleCleanupLocked(nowElapsed);     // Catch: Throwable -> L20
        monitor-exit(r4);     // Catch: Throwable -> L20
        notifyPendingTimeouts(expired);
        return;
    L15:
        recordUpLocked(event, nowElapsed);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public int matchUpEventId(String fingerprint) {
        if (fingerprint != null) goto L5;
        return -1;
    L5:
        String[] parts = fingerprint.split("\\|", -1);
        if (parts.length == FINGERPRINT_PART_COUNT) goto L9;
        logDebug("ClickViewTree[SS_MATCH] matchedBy=none reason=malformed_fingerprint");
        return -1;
    L9:
        String matchKey = parts[0] + "|" + parts[1] + "|" + parts[2] + "|" + parts[5];
        float rawX = Float.parseFloat(parts[3]);     // Catch: NumberFormatException -> L31
        float rawY = Float.parseFloat(parts[4]);     // Catch: NumberFormatException -> L31
        ArrayList<PendingClick> expired = new ArrayList();
        Object r6 = this.mLock;
        monitor-enter(r6);
        long nowElapsed = SystemClock.elapsedRealtime();     // Catch: Throwable -> L28
        pruneLocked(nowElapsed, expired);     // Catch: Throwable -> L28
        PendingClick pending = this.mPendingByMatchKey.get(matchKey);     // Catch: Throwable -> L28
        if (pending != null) goto L16;
    L18:
        if (pending == null) goto L20;
        removeLocked(pending);     // Catch: Throwable -> L28
    L20:
        scheduleCleanupLocked(nowElapsed);     // Catch: Throwable -> L28
        monitor-exit(r6);     // Catch: Throwable -> L28
        logPendingDebug("consumeByMatchKey", pending, "matchKey=" + matchKey);
        notifyPendingTimeouts(expired);
        if (pending != null) goto L26;
        logDebug("ClickViewTree[SS_MATCH] matchedBy=none hasFingerprint=true");
        return -1;
    L26:
        int upEventId = pending.getUpEventId();
        logDebug("ClickViewTree[SS_MATCH] matchedBy=fingerprint upEventId=" + upEventId);
        return upEventId;
    L16:
        if (pending.matchesCoordinates(rawX, rawY) == true) goto L18;
        pending = null;
    L28:
        th = move-exception;
        throw th;
    L32:
        logDebug("ClickViewTree[SS_MATCH] matchedBy=none reason=malformed_fingerprint");
        return -1;
    }

    public boolean allowReport(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long nowElapsed = SystemClock.elapsedRealtime();     // Catch: Throwable -> L20
        RateBucket bucket = this.mRateByUid.get(uid);     // Catch: Throwable -> L20
        if (bucket != null) goto L7;
        bucket = new RateBucket(RATE_BURST_TOKENS, nowElapsed);     // Catch: Throwable -> L20
        this.mRateByUid.put(uid, bucket);     // Catch: Throwable -> L20
    L9:
        if (RateBucket.m54$$Nest$fgetmTokens(bucket) < 1.0d) goto L11;
        RateBucket.m56$$Nest$fputmTokens(bucket, RateBucket.m54$$Nest$fgetmTokens(bucket) - 1.0d);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return true;
    L11:
        if (Build.IS_DEBUGGABLE == false) goto L13;
        Slog.w(TAG, "ClickViewTree[SS_RATE] dropped report uid=" + uid);     // Catch: Throwable -> L20
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return false;
    L7:
        double refill = ((nowElapsed - RateBucket.m53$$Nest$fgetmLastRefillElapsed(bucket)) / 1000.0d) * RATE_TOKENS_PER_SEC;     // Catch: Throwable -> L20
        RateBucket.m56$$Nest$fputmTokens(bucket, Math.min(RATE_BURST_TOKENS, RateBucket.m54$$Nest$fgetmTokens(bucket) + refill));     // Catch: Throwable -> L20
        RateBucket.m55$$Nest$fputmLastRefillElapsed(bucket, nowElapsed);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private void recordDownLocked(MotionEvent event, long nowElapsed) {
        String downKey = buildDownKey(event);
        PendingClick previous = this.mPendingByDownKey.get(downKey);
        if (previous == null) goto L5;
        removeLocked(previous);
    L5:
        PendingClick pending = PendingClick.forDown(nextEventIdLocked(), event, downKey, nowElapsed);
        addLocked(pending);
        trimLocked();
        logPendingDebug("recordDown create", pending);
    }

    private void recordUpLocked(MotionEvent event, long nowElapsed) {
        String downKey = buildDownKey(event);
        PendingClick pending = this.mPendingByDownKey.get(downKey);
        if (pending != null) goto L5;
        pending = PendingClick.forUpOnly(nextEventIdLocked(), event, downKey, nowElapsed);
        addLocked(pending);
        boolean create = true;
    L9:
        trimLocked();
        if (create == false) goto L12;
        String r3 = "recordUp create";
    L13:
        logPendingDebug(r3, pending, "matchKey=" + pending.getMatchKey() + " upEventId=" + pending.getUpEventId());
        return;
    L12:
        r3 = "recordUp update";
        goto L13
    L5:
        boolean create2 = pending.hasUp();
        if (create2 == false) goto L8;
        this.mPendingByMatchKey.remove(pending.getMatchKey());
    L8:
        pending.updateUp(event, nowElapsed);
        this.mPendingByMatchKey.put(pending.getMatchKey(), pending);
        create = false;
        goto L9
    }

    private void addLocked(PendingClick pending) {
        this.mPendingByDownKey.put(pending.getDownKey(), pending);
        if (pending.hasUp() == false) goto L5;
        this.mPendingByMatchKey.put(pending.getMatchKey(), pending);
    L5:
        this.mPendingOrder.addLast(pending);
    }

    private void removeLocked(PendingClick pending) {
        this.mPendingByDownKey.remove(pending.getDownKey());
        this.mPendingByMatchKey.remove(pending.getMatchKey());
        this.mPendingOrder.remove(pending);
    }

    private void trimLocked() {
    L3:
        if (this.mPendingOrder.size() <= MAX_PENDING_COUNT) goto L5;
        removeLocked(this.mPendingOrder.peekFirst());
        goto L3
    }

    private void pruneLocked(long nowElapsed, ArrayList<PendingClick> expired) {
    L3:
        if (this.mPendingOrder.isEmpty() == true) goto L8;
        PendingClick pending = this.mPendingOrder.peekFirst();
        if ((nowElapsed - pending.getUpdatedElapsedMillis()) < PENDING_TTL_MILLIS) goto L6;
        removeLocked(pending);
        expired.add(pending);
        goto L3
    L6:
        return;
    }

    private void pruneRateBucketsLocked(long nowElapsed) {
        int i = this.mRateByUid.size() - 1;
    L3:
        if (i < 0) goto L8;
        RateBucket bucket = this.mRateByUid.valueAt(i);
        double refill = ((nowElapsed - RateBucket.m53$$Nest$fgetmLastRefillElapsed(bucket)) / 1000.0d) * RATE_TOKENS_PER_SEC;
        if ((RateBucket.m54$$Nest$fgetmTokens(bucket) + refill) < RATE_BURST_TOKENS) goto L7;
        this.mRateByUid.removeAt(i);
    L7:
        i = i - 1;
        goto L3
    }

    private void scheduleCleanupLocked(long nowElapsed) {
        if (this.mCleanupScheduled == false) goto L5;
        return;
    L5:
        if (this.mPendingOrder.isEmpty() == true) goto L10;
        PendingClick pending = this.mPendingOrder.peekFirst();
        long delayMillis = PENDING_TTL_MILLIS - (nowElapsed - pending.getUpdatedElapsedMillis());
        this.mCleanupScheduled = true;
        this.mHandler.postDelayed(this.mCleanupRunnable, Math.max(1, delayMillis));
        return;
    }

    private String nextEventIdLocked() {
        StringBuilder r0 = new StringBuilder().append("obric-click-");
        long r1 = this.mNextEventSeq + 1;
        this.mNextEventSeq = r1;
        return r0.append(r1).toString();
    }

    private void notifyPendingTimeouts(ArrayList<PendingClick> expired) {
        if (expired.isEmpty() == false) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= expired.size()) goto L14;
        PendingClick pending = expired.get(i);
        logPendingDebug("notify timeout", pending);
        handlePendingTimeout(pending);     // Catch: Exception -> L11
    L13:
        i = i + 1;
    L11:
        e = move-exception;
        logPendingWarning("notify timeout callback failed", pending, e);
        goto L13
    }

    private void handlePendingTimeout(PendingClick pending) {
        if (pending != null) goto L6;
        return;
    L6:
        if (this.mTimeoutListener == null) goto L11;
        if (pending.getUpEventId() == (-1)) goto L11;
        this.mTimeoutListener.onClickTimeout(pending.getUpEventId());
    L11:
        if (isDebugEnabled() == true) goto L26;
        return;
    L26:
        JSONObject event = new JSONObject();     // Catch: Exception -> L23
        event.put("eventId", PendingClick.m48$$Nest$fgetmEventId(pending));     // Catch: Exception -> L23
        event.put("displayId", PendingClick.m45$$Nest$fgetmDisplayId(pending));     // Catch: Exception -> L23
        if (PendingClick.m49$$Nest$fgetmHasUp(pending) == false) goto L16;
        double r3 = PendingClick.m51$$Nest$fgetmUpRawX(pending);     // Catch: Exception -> L23
    L17:
        event.put("x", r3);     // Catch: Exception -> L23
        if (PendingClick.m49$$Nest$fgetmHasUp(pending) == false) goto L20;
        double r4 = PendingClick.m52$$Nest$fgetmUpRawY(pending);     // Catch: Exception -> L23
    L21:
        event.put("y", r4);     // Catch: Exception -> L23
        event.put("source", ClickViewTreeConstants.formatSource(PendingClick.m50$$Nest$fgetmSource(pending)));     // Catch: Exception -> L23
        JSONObject record = new JSONObject();     // Catch: Exception -> L23
        record.put("event", event);     // Catch: Exception -> L23
        record.put("consumeReason", "NONE");     // Catch: Exception -> L23
        record.put("clickClassification", "UNKNOWN");     // Catch: Exception -> L23
        record.put("status", "APP_REPORT_TIMEOUT");     // Catch: Exception -> L23
        record.put("matchedBy", "none");     // Catch: Exception -> L23
        String timeoutRecord = record.toString();     // Catch: Exception -> L23
        logRecordSummary("timeout record", timeoutRecord, null, null, "none");     // Catch: Exception -> L23
        logRecord(timeoutRecord, false);     // Catch: Exception -> L23
        return;
    L20:
        r4 = PendingClick.m47$$Nest$fgetmDownRawY(pending);     // Catch: Exception -> L23
        goto L21
    L16:
        r3 = PendingClick.m46$$Nest$fgetmDownRawX(pending);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        Slog.w(TAG, "Failed to build click ViewTree timeout record", e);
    }

    public static boolean isPointerSource(int source) {
        if ((source & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static String buildDownKey(MotionEvent event) {
        return event.getDisplayId() + "|" + event.getDownTime() + "|" + event.getSource();
    }

    static String buildMatchKey(MotionEvent event) {
        return event.getDisplayId() + "|" + event.getDownTime() + "|" + event.getEventTime() + "|" + ClickViewTreeConstants.formatSource(event.getSource());
    }

    private static boolean isDebugEnabled() {
        if (Build.IS_DEBUGGABLE == true) goto L5;
        return false;
    L5:
        if (SystemProperties.getBoolean("persist.sys.obric.click_viewtree.debug", false) == false) goto L10;
        return true;
    L10:
        return false;
    }

    private static boolean isDebugJsonEnabled() {
        if (isDebugEnabled() == true) goto L5;
        return false;
    L5:
        if (SystemProperties.getBoolean("persist.sys.obric.click_viewtree.debug_json", false) == false) goto L10;
        return true;
    L10:
        return false;
    }

    private static void logDebug(String message) {
        if (isDebugEnabled() == false) goto L6;
        Slog.d(TAG, message);
        return;
    }

    public void logReportReceive(String eventId, String fingerprint, String clickClassification, boolean hasStructure) {
        logDebug("ClickViewTree[SS_RECV] eventId=" + eventId + " hasFingerprint=" + hasText(fingerprint) + " clickClassification=" + clickClassification + " hasStructure=" + hasStructure);
    }

    public void logImeForward(int upEventId, boolean imeReady) {
        if (upEventId != (-1)) goto L5;
        logDebug("ClickViewTree[SS_FORWARD] skipped reason=no_up_event_match");
        return;
    L5:
        if (imeReady == true) goto L7;
        logDebug("ClickViewTree[SS_FORWARD] skipped reason=imms_ext_not_ready upEventId=" + upEventId);
        return;
    L7:
        logDebug("ClickViewTree[SS_FORWARD] upEventId=" + upEventId);
    }

    private static void logRecord(String jsonRecord, boolean hasStructure) {
        logDebug("ClickViewTree[SS_TIMEOUT] jsonLength=" + getJsonLength(jsonRecord) + " hasStructure=" + hasStructure);
        logJson("timeout", jsonRecord);
    }

    private static void logJson(String action, String jsonRecord) {
        if (isDebugJsonEnabled() == true) goto L6;
        return;
    L6:
        if (jsonRecord != null) goto L9;
        Slog.d(TAG, "ClickViewTree[SS_JSON] action=" + action + " json=null");
        return;
    L9:
        String pretty = jsonRecord;
        pretty = new JSONObject(jsonRecord).toString(2);     // Catch: Exception -> L12
    L13:
        int total = pretty.length();
        int chunkCount = ((total + JSON_LOG_CHUNK) - 1) / JSON_LOG_CHUNK;
        int i = 0;
    L14:
        if (i >= chunkCount) goto L16;
        int start = i * JSON_LOG_CHUNK;
        int end = Math.min(start + JSON_LOG_CHUNK, total);
        Slog.d(TAG, "ClickViewTree[SS_JSON] action=" + action + " json[" + (i + 1) + "/" + chunkCount + "]=\n" + pretty.substring(start, end));
        i = i + 1;
        goto L14
    }

    private static void logRecordSummary(String action, String jsonRecord, String eventIdFallback, String fingerprint, String matchedByFallback) {
        if (isDebugEnabled() == true) goto L5;
        return;
    L5:
        String matchedBy = fallbackString(matchedByFallback, "unknown");
        String eventId = eventIdFallback;
        String status = "UNKNOWN";
        String classification = "UNKNOWN";
        String consumeReason = "UNKNOWN";
        JSONObject record = new JSONObject(jsonRecord);     // Catch: Exception -> L12
        JSONObject event = record.optJSONObject("event");     // Catch: Exception -> L12
        if (event == null) goto L10;
        eventId = optString(event, "eventId", eventId);     // Catch: Exception -> L12
        classification = optString(event, "clickClassification", "UNKNOWN");     // Catch: Exception -> L12
    L10:
        consumeReason = optString(record, "consumeReason", "UNKNOWN");     // Catch: Exception -> L12
        matchedBy = optString(record, "matchedBy", matchedBy);     // Catch: Exception -> L12
        status = optString(record, "status", "UNKNOWN");     // Catch: Exception -> L12
        String classification2 = optString(record, "clickClassification", classification);     // Catch: Exception -> L12
    L14:
        Slog.d(TAG, "ClickViewTree[SS_TIMEOUT] action=" + action + " matchedBy=" + matchedBy + " eventId=" + eventId + " hasFingerprint=" + hasText(fingerprint) + " status=" + status + " classification=" + classification2 + " consumeReason=" + consumeReason + " jsonLength=" + getJsonLength(jsonRecord));
        return;
    L13:
        classification2 = classification;
        goto L14
    }

    private static String optString(JSONObject object, String field, String fallback) {
        if (object != null) goto L4;
    L13:
        return fallback;
    L4:
        if (object.has(field) == false) goto L13;
        if (object.isNull(field) == true) goto L13;
        String value = object.optString(field, null);
        if (hasText(value) == false) goto L12;
        return value;
    L12:
        return fallback;
    }

    private static String fallbackString(String value, String fallback) {
        if (hasText(value) == false) goto L6;
        return value;
    L6:
        return fallback;
    }

    private static boolean hasText(String value) {
        if (value != null) goto L4;
    L6:
        return false;
    L4:
        if (value.isEmpty() == true) goto L6;
        return true;
    }

    private static int getJsonLength(String jsonRecord) {
        if (jsonRecord != null) goto L5;
        return 0;
    L5:
        return jsonRecord.length();
    }

    private static void logPendingDebug(String action, PendingClick pending) {
        logPendingDebug(action, pending, null);
    }

    private static void logPendingDebug(String action, PendingClick pending, String extra) {
        if (isDebugEnabled() == true) goto L5;
        return;
    L5:
        StringBuilder builder = new StringBuilder("ClickViewTree[SS_PENDING] ").append(action);
        if (extra == null) goto L8;
        builder.append(' ').append(extra);
    L8:
        builder.append(' ').append(buildPendingSummary(pending));
        Slog.d(TAG, builder.toString());
    }

    private static void logPendingWarning(String action, PendingClick pending, Exception e) {
        if (isDebugEnabled() == true) goto L5;
        return;
    L5:
        Slog.w(TAG, "ClickViewTree[SS_PENDING] " + action + " " + buildPendingSummary(pending), e);
    }

    private static String buildPendingSummary(PendingClick pending) {
        if (pending != null) goto L6;
        return "eventId=null displayId=-1 rawX=NaN rawY=NaN source=null";
    L6:
        if (PendingClick.m49$$Nest$fgetmHasUp(pending) == false) goto L8;
        float x = PendingClick.m51$$Nest$fgetmUpRawX(pending);
    L10:
        if (PendingClick.m49$$Nest$fgetmHasUp(pending) == false) goto L12;
        float y = PendingClick.m52$$Nest$fgetmUpRawY(pending);
    L14:
        return "eventId=" + PendingClick.m48$$Nest$fgetmEventId(pending) + " displayId=" + PendingClick.m45$$Nest$fgetmDisplayId(pending) + " rawX=" + x + " rawY=" + y + " source=" + ClickViewTreeConstants.formatSource(PendingClick.m50$$Nest$fgetmSource(pending));
    L12:
        y = PendingClick.m47$$Nest$fgetmDownRawY(pending);
        goto L14
    L8:
        x = PendingClick.m46$$Nest$fgetmDownRawX(pending);
        goto L10
    }
}
