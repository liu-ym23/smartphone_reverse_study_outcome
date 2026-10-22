package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatrixTeaManager {
    private static final long BIND_RETRY_INTERVAL = 5000;

    @NotNull
    public static final Companion Companion = null;

    @NotNull
    private static final String EVENT_APM_COLD_LAUNCH_FIRST_FRAME = "apm_event_coldlaunch_first_frame";

    @NotNull
    private static final String EVENT_APM_COLD_LAUNCH_FIRST_FRAME_TAIL = "apm_event_coldlaunch_first_frame_tail";

    @NotNull
    private static final String EVENT_APM_COLD_USER_COMPLETE = "apm_event_coldlaunch_user_complete";

    @NotNull
    private static final String EVENT_APM_FPS = "apm_event_fps";

    @NotNull
    private static final String EVENT_APM_HOT_LAUNCH = "apm_event_hotlaunch";

    @NotNull
    private static final String EVENT_APM_HOT_LAUNCH_TAIL = "apm_event_hotlaunch_tail";

    @NotNull
    private static final String EVENT_APM_MEMORY = "apm_event_memory";

    @NotNull
    private static final String EVENT_BUTTON_CLICK = "button_click";

    @NotNull
    private static final String EVENT_PAGE_SHOW = "page_show";

    @NotNull
    private static final String TAG = "MatrixTeaManager";

    @Nullable
    private static String did;

    @Nullable
    private static MatrixTeaManager instance;

    @NotNull
    private static final AtomicBoolean isInited = null;

    @Nullable
    private static String mUDid;

    @Nullable
    private static String myInstallId;

    @NotNull
    private final Handler backgroundHandler;

    @NotNull
    private final MatrixTeaConfig config;

    @NotNull
    private final MatrixTeaManager$connection$1 connection;

    @NotNull
    private final Context context;

    @NotNull
    private final MatrixTeaManager$deviceInfoCallback$1 deviceInfoCallback;

    @NotNull
    private final Handler handler;
    private boolean isBound;

    @NotNull
    private final CopyOnWriteArrayList<DeviceInfoListener> listeners;

    @NotNull
    private final CopyOnWriteArrayList<PendingEvent> pendingEvents;

    @NotNull
    private final MatrixTeaManager$retryRunnable$1 retryRunnable;

    @Nullable
    private IDataService service;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MatrixTeaManager getInstance() {
            if (MatrixTeaManager.access$getInstance$cp() == null) goto L7;
            MatrixTeaManager r1 = MatrixTeaManager.access$getInstance$cp();
            Intrinsics.c(r1);
            return r1;
        L7:
            throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }

        public final void init(@NotNull Context r3, @NotNull MatrixTeaConfig r4) {
            Intrinsics.f(r3, "context");
            Intrinsics.f(r4, "config");
            if (MatrixTeaManager.access$getInstance$cp() == null) goto L5;
        L16:
            MatrixTeaManager r2 = MatrixTeaManager.access$getInstance$cp();
            Intrinsics.c(r2);
            r2.bindService();
            return;
        L5:
            monitor-enter(MatrixTeaManager.class);
        L10:
            th = move-exception;
            throw th;
        L7:
            if (MatrixTeaManager.access$getInstance$cp() != null) goto L12;
            MatrixTeaManager.access$setInstance$cp(new MatrixTeaManager(r3, r4, null));     // Catch: Throwable -> L10
        L12:
            monitor-exit(MatrixTeaManager.class);
            goto L16
        }

        public final boolean isInited() {
            return MatrixTeaManager.access$isInited$cp().get();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public static final class PendingEvent {

        @NotNull
        private final String eventName;

        @NotNull
        private final JSONObject jsonObject;

        public PendingEvent(@NotNull String r2, @NotNull JSONObject r3) {
            Intrinsics.f(r2, "eventName");
            Intrinsics.f(r3, "jsonObject");
            this.eventName = r2;
            this.jsonObject = r3;
        }

        public static /* synthetic */ PendingEvent copy$default(PendingEvent r0, String r1, JSONObject r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.eventName;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.jsonObject;
        L9:
            return r0.copy(r1, r2);
        }

        @NotNull
        public final String component1() {
            return this.eventName;
        }

        @NotNull
        public final JSONObject component2() {
            return this.jsonObject;
        }

        @NotNull
        public final PendingEvent copy(@NotNull String r1, @NotNull JSONObject r2) {
            Intrinsics.f(r1, "eventName");
            Intrinsics.f(r2, "jsonObject");
            return new PendingEvent(r1, r2);
        }

        public boolean equals(@Nullable Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PendingEvent) == true) goto L8;
            return false;
        L8:
            PendingEvent r6 = (PendingEvent) r5;
            if (Intrinsics.a(this.eventName, r6.eventName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.a(this.jsonObject, r6.jsonObject) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @NotNull
        public final String getEventName() {
            return this.eventName;
        }

        @NotNull
        public final JSONObject getJsonObject() {
            return this.jsonObject;
        }

        public int hashCode() {
            int r0 = this.eventName.hashCode() * 31;
            return this.jsonObject.hashCode() + r0;
        }

        @NotNull
        public String toString() {
            return "PendingEvent(eventName=" + this.eventName + ", jsonObject=" + this.jsonObject + ')';
        }
    }

    static {
        Companion = new Companion(null);
        isInited = new AtomicBoolean(false);
    }

    public /* synthetic */ MatrixTeaManager(Context r1, MatrixTeaConfig r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public static /* synthetic */ void a(MatrixTeaManager r0, String r1, JSONObject r2, JSONObject r3) {
        m22onEventInternal$lambda8(r0, r1, r2, r3);
    }

    public static final /* synthetic */ MatrixTeaManager$deviceInfoCallback$1 access$getDeviceInfoCallback$p(MatrixTeaManager r0) {
        return r0.deviceInfoCallback;
    }

    public static final /* synthetic */ Handler access$getHandler$p(MatrixTeaManager r0) {
        return r0.handler;
    }

    public static final /* synthetic */ MatrixTeaManager access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getListeners$p(MatrixTeaManager r0) {
        return r0.listeners;
    }

    public static final /* synthetic */ IDataService access$getService$p(MatrixTeaManager r0) {
        return r0.service;
    }

    public static final /* synthetic */ boolean access$isBound$p(MatrixTeaManager r0) {
        return r0.isBound;
    }

    public static final /* synthetic */ AtomicBoolean access$isInited$cp() {
        return isInited;
    }

    public static final /* synthetic */ void access$processPendingEvents(MatrixTeaManager r0) {
        r0.processPendingEvents();
    }

    public static final /* synthetic */ void access$setBound$p(MatrixTeaManager r0, boolean r1) {
        r0.isBound = r1;
    }

    public static final /* synthetic */ void access$setDid$cp(String r0) {
        did = r0;
    }

    public static final /* synthetic */ void access$setInstance$cp(MatrixTeaManager r0) {
        instance = r0;
    }

    public static final /* synthetic */ void access$setMyInstallId$cp(String r0) {
        myInstallId = r0;
    }

    public static final /* synthetic */ void access$setService$p(MatrixTeaManager r0, IDataService r1) {
        r0.service = r1;
    }

    public static /* synthetic */ void b(MatrixTeaManager r0) {
        m23rebindService$lambda1(r0);
    }

    private final JSONObject copyJson(JSONObject r4) {
        LinkedList r3 = new LinkedList();
        Iterator<String> r0 = r4.keys();
    L4:
        if (r0.hasNext() == false) goto L23;
        String r1 = r0.next();
        Intrinsics.e(r1, "keysIterable.next()");
        r3.add(r1);
        goto L4
    L23:
        Object[] r5 = r3.toArray(new String[0]);     // Catch: Throwable -> L9
        if (r5 == null) goto L12;
        Object r2 = new JSONObject(r4, (String[]) r5);     // Catch: Throwable -> L9
    L14:
        Throwable r6 = Result.a(r2);
        if (r6 == null) goto L17;
        MLog.e(TAG, "copyJson error", r6);
    L17:
        Object r7 = r4;
        if ((r2 instanceof Result.Failure) == true) goto L22;
        r7 = r2;
    L22:
        return (JSONObject) r7;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r2 = ResultKt.a(th);
        goto L14
    }

    public static /* synthetic */ void onApmFpsEvent$default(MatrixTeaManager r0, String r1, float r2, JSONObject r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = "";
    L5:
        r0.onApmFpsEvent(r1, r2, r3);
    }

    public static /* synthetic */ void onButtonClickEvent$default(MatrixTeaManager r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.onButtonClickEvent(r1, r2);
    }

    private final void onEventInternal(final String r4, final JSONObject r5) {
        final JSONObject r0 = copyJson(r5);
        this.backgroundHandler.post(new a(this, r4, r0, r5));
    }

    /* JADX INFO: renamed from: onEventInternal$lambda-8, reason: not valid java name */
    private static final void m22onEventInternal$lambda8(MatrixTeaManager r1, String r2, JSONObject r3, JSONObject r4) {
        Intrinsics.f(r1, "this$0");
        Intrinsics.f(r2, "$eventName");
        Intrinsics.f(r3, "$copyJson");
        Intrinsics.f(r4, "$jsonObject");
        IDataService r0 = r1.service;     // Catch: Throwable -> L7
        if (r0 == null) goto L9;
        r0.onEvent(r2, r3.toString());     // Catch: Throwable -> L7
        Object r5 = Unit.f330a;     // Catch: Throwable -> L7
    L11:
        Throwable r6 = Result.a(r5);
        if (r6 == null) goto L17;
        r1.pendingEvents.add(new PendingEvent(r2, r4));
        MLog.e(TAG, "onEvent error", r6);
        return;
    L17:
        return;
    L9:
        r5 = null;
    L7:
        th = move-exception;
        r5 = ResultKt.a(th);
        goto L11
    }

    public static /* synthetic */ void onPageShowEvent$default(MatrixTeaManager r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        r0.onPageShowEvent(r1, r2, r3);
    }

    private final void processPendingEvents() {
        if (this.pendingEvents.isEmpty() == false) goto L6;
        MLog.i$default(TAG, "没有暂存的事件需要处理", null, 4, null);
        return;
    L6:
        MLog.i$default(TAG, "开始处理 " + this.pendingEvents.size() + " 个暂存事件", null, 4, null);
        CopyOnWriteArrayList<PendingEvent> r0 = this.pendingEvents;
        ArrayList r4 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        Object r5 = r1.next();
        PendingEvent r6 = (PendingEvent) r5;
        JSONObject r7 = new JSONObject(r6.getJsonObject().toString());     // Catch: Exception -> L12
        r7.put("app_package_name", this.config.getPkgName());     // Catch: Exception -> L12
        r7.put("app_version_code", this.config.getVersionCode());     // Catch: Exception -> L12
        r7.put("app_version_name", this.config.getVersionName());     // Catch: Exception -> L12
        r7.put("app_is_boe", this.config.isBoe() ? 1 : 0);     // Catch: Exception -> L12
        onEventInternal(r6.getEventName(), r7);     // Catch: Exception -> L12
        MLog.i$default(TAG, "成功发送暂存事件: " + r6.getEventName(), null, 4, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        MLog.e(TAG, "发送暂存事件 " + r6.getEventName() + " 失败", e);
        r4.add(r5);
        goto L8
    L14:
        this.pendingEvents.clear();
        this.pendingEvents.addAll(r4);
    }

    /* JADX INFO: renamed from: rebindService$lambda-1, reason: not valid java name */
    private static final void m23rebindService$lambda1(MatrixTeaManager r1) {
        Intrinsics.f(r1, "this$0");
        r1.bindService();
    }

    public final void addDeviceInfoListener(@NotNull DeviceInfoListener r6) {
        Intrinsics.f(r6, "listener");
        MLog.i$default(TAG, "addDeviceInfoListener " + r6, null, 4, null);
        if (this.listeners.contains(r6) == true) goto L5;
        this.listeners.add(r6);
        MLog.i$default(TAG, "addDeviceInfoListener不包含，添加进listeners中,当前size = " + this.listeners.size(), null, 4, null);
    L5:
        String r5 = did;
        if (r5 != null) goto L8;
    L11:
        String r7 = myInstallId;
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.length() == 0) goto L19;
        MLog.i$default(TAG, "注册deviceInfoListener时installId有值，立即回调 " + myInstallId, null, 4, null);
        String r8 = myInstallId;
        Intrinsics.c(r8);
        r6.onInstallIdLoaded(r8);
        return;
    L19:
        return;
    L8:
        if (r5.length() == 0) goto L11;
        MLog.i$default(TAG, "注册deviceInfoListener时did有值，立即回调 " + did, null, 4, null);
        String r9 = did;
        Intrinsics.c(r9);
        r6.onDeviceIdLoaded(r9);
        goto L11
    }

    public final void bindService() {
        if (isInited.compareAndSet(false, true) == true) goto L6;
        MLog.i("tea has inited");
        return;
    L6:
        bindServiceInternal();
        this.handler.postDelayed(this.retryRunnable, 5000);
    }

    public final void bindServiceInternal() {
        if (this.isBound == false) goto L6;
        MLog.i$default(TAG, "bindServiceInternal: service is already bound", null, 4, null);
        return;
    L6:
        Intent r0 = new Intent();
        r0.setAction("com.obric.matrix.dataanalysis.service");
        r0.setPackage("com.obric.matrix");
        this.context.bindService(r0, this.connection, 1);
    }

    @Nullable
    public final String getDeviceId() {
        String r0 = did;
        if (r0 == null) goto L10;
        if (r0.length() == 0) goto L10;
        MLog.i$default(TAG, "getDeviceId 有值，立即回调 " + did, null, 4, null);
        return did;
    L10:
        if (this.isBound == true) goto L23;
        MLog.e$default(TAG, "getDeviceId error,Service not bounded", null, 4, null);
        return null;
    L23:
        IDataService r4 = this.service;     // Catch: Exception -> L14
        if (r4 == null) goto L16;
        String r5 = r4.getDeviceId();     // Catch: Exception -> L14
    L17:
        did = r5;     // Catch: Exception -> L14
        return r5;
    L16:
        r5 = null;
    L14:
        e = move-exception;
        MLog.e(TAG, "getDeviceId error", e);
        return null;
    }

    @Nullable
    public final String getInstallId() {
        String r0 = myInstallId;
        if (r0 == null) goto L10;
        if (r0.length() == 0) goto L10;
        MLog.i$default(TAG, "getInstallId 有值，立即回调 " + myInstallId, null, 4, null);
        return myInstallId;
    L10:
        if (this.isBound == true) goto L23;
        MLog.e$default(TAG, "getInstallId error,Service not bounded", null, 4, null);
        return null;
    L23:
        IDataService r4 = this.service;     // Catch: Exception -> L14
        if (r4 == null) goto L16;
        String r5 = r4.getInstallId();     // Catch: Exception -> L14
    L17:
        myInstallId = r5;     // Catch: Exception -> L14
        return r5;
    L16:
        r5 = null;
    L14:
        e = move-exception;
        MLog.e(TAG, "getInstallId error", e);
        return null;
    }

    @Nullable
    public final String getOAID() {
        Object r2 = null;
        Bundle r5 = this.context.getContentResolver().call(Uri.parse("content://com.bytedance.securityserver.oaidprovider"), "get_oaid", null, null);     // Catch: Throwable -> L10
        if (r5 == null) goto L15;
        String r3 = r5.getString("oaid");     // Catch: Throwable -> L10
        if (r3 == null) goto L13;
        if (r3.length() == 0) goto L13;
        StringBuilder r6 = new StringBuilder("oaid not empty, return ");     // Catch: Throwable -> L10
        String r0 = r3.substring(0, 2);     // Catch: Throwable -> L10
        Intrinsics.e(r0, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: Throwable -> L10
        r6.append(r0);     // Catch: Throwable -> L10
        r6.append("****");     // Catch: Throwable -> L10
        String r1 = r3.substring(r3.length() - 2);     // Catch: Throwable -> L10
        Intrinsics.e(r1, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L10
        r6.append(r1);     // Catch: Throwable -> L10
        MLog.i(r6.toString());     // Catch: Throwable -> L10
        Object r4 = r3;
    L17:
        Throwable r7 = Result.a(r4);
        if (r7 == null) goto L21;
        MLog.e(TAG, "getOAID error", r7);
    L21:
        if ((r4 instanceof Result.Failure) == true) goto L25;
        r2 = r4;
    L25:
        return (String) r2;
    L13:
        throw new IllegalStateException(("get oaid failed, errorCode = " + r5.getString("errCode") + ", errorMsg = " + r5.getString("errMsg")).toString());     // Catch: Throwable -> L10
    L15:
        throw new IllegalStateException("provider return null".toString());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r4 = ResultKt.a(th);
        goto L17
    }

    @Nullable
    public final String getUDID() {
        String r2 = mUDid;
        Object r9 = null;
        if (r2 != null) goto L5;
    L32:
        Bundle r11 = this.context.getContentResolver().call(Uri.parse("content://com.bytedance.securityserver.udidprovider"), "get_udid", null, null);     // Catch: Throwable -> L16
        if (r11 == null) goto L21;
        String r3 = r11.getString("udid");     // Catch: Throwable -> L16
        if (r3 == null) goto L19;
        if (r3.length() == 0) goto L19;
        mUDid = r3;     // Catch: Throwable -> L16
        StringBuilder r12 = new StringBuilder("udid not empty, return ");     // Catch: Throwable -> L16
        String r0 = r3.substring(0, 2);     // Catch: Throwable -> L16
        Intrinsics.e(r0, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: Throwable -> L16
        r12.append(r0);     // Catch: Throwable -> L16
        r12.append("****");     // Catch: Throwable -> L16
        String r1 = r3.substring(r3.length() - 2);     // Catch: Throwable -> L16
        Intrinsics.e(r1, "this as java.lang.String).substring(startIndex)");     // Catch: Throwable -> L16
        r12.append(r1);     // Catch: Throwable -> L16
        MLog.i(r12.toString());     // Catch: Throwable -> L16
        Object r4 = r3;
    L23:
        Throwable r13 = Result.a(r4);
        if (r13 == null) goto L27;
        MLog.e(TAG, "getUDID error", r13);
    L27:
        if ((r4 instanceof Result.Failure) == true) goto L31;
        r9 = r4;
    L31:
        return (String) r9;
    L19:
        throw new IllegalStateException(("get udid failed, errorCode = " + r11.getString("errCode") + ", errorMsg = " + r11.getString("errMsg")).toString());     // Catch: Throwable -> L16
    L21:
        throw new IllegalStateException("provider return null".toString());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r4 = ResultKt.a(th);
        goto L23
    L5:
        if (r2.length() == 0) goto L32;
        StringBuilder r14 = new StringBuilder("getUDID 有值，立即回调 ");
        String r5 = r2.substring(0, 2);
        Intrinsics.e(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        r14.append(r5);
        r14.append("****");
        String r6 = r2.substring(r2.length() - 2);
        Intrinsics.e(r6, "this as java.lang.String).substring(startIndex)");
        r14.append(r6);
        MLog.i$default(TAG, r14.toString(), null, 4, null);
        return r2;
    }

    public final void onApmColdLaunchFirstFrameEvent(long r3) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        onEvent(EVENT_APM_COLD_LAUNCH_FIRST_FRAME, r0);
    }

    public final void onApmColdLaunchFirstFrameEventTail(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        onEvent(EVENT_APM_COLD_LAUNCH_FIRST_FRAME_TAIL, r0);
    }

    public final void onApmColdLaunchUserCompleteEvent(long r3, @NotNull JSONObject r5) {
        Intrinsics.f(r5, "extraInfo");
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        Iterator<String> r4 = r5.keys();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r6 = r4.next();
        r0.put(r6, r5.get(r6));
        goto L4
    L6:
        onEvent(EVENT_APM_COLD_USER_COMPLETE, r0);
    }

    public final void onApmFpsEvent(@NotNull String r2, float r3, @Nullable JSONObject r4) {
        Intrinsics.f(r2, "pageName");
        if (r4 != null) goto L5;
        r4 = new JSONObject();
    L5:
        r4.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r2);
        r4.put("fps", Float.valueOf(r3));
        onEvent(EVENT_APM_FPS, r4);
    }

    public final void onApmHotLaunchEvent(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        onEvent(EVENT_APM_HOT_LAUNCH, r0);
    }

    public final void onApmHotLaunchEventTail(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("duration", r3);
        onEvent(EVENT_APM_HOT_LAUNCH_TAIL, r0);
    }

    public final void onApmMemoryEvent(int r3, boolean r4) {
        JSONObject r0 = new JSONObject();
        r0.put("memory_size", r3);
        r0.put("type", !r4 ? 1 : 0);
        onEvent(EVENT_APM_MEMORY, r0);
    }

    public final void onButtonClickEvent(@NotNull String r3, @Nullable String r4) {
        Intrinsics.f(r3, "componentName");
        JSONObject r0 = new JSONObject();
        r0.put("click_for", r3);
        r0.put("scene", r4);
        onEvent(EVENT_BUTTON_CLICK, r0);
    }

    public final void onEvent(@NotNull String r7, @NotNull JSONObject r8) {
        Intrinsics.f(r7, "eventName");
        Intrinsics.f(r8, "jsonObject");
        String r2 = r8.toString();     // Catch: Throwable -> L19
        Intrinsics.e(r2, "jsonObject.toString()");     // Catch: Throwable -> L19
        byte[] r3 = r2.getBytes(Charsets.f354a);     // Catch: Throwable -> L19
        Intrinsics.e(r3, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L19
        int r4 = r3.length;     // Catch: Throwable -> L19
        if (r4 <= 204800) goto L9;
        MLog.e$default(TAG, "事件 " + r7 + " 数据大小 " + r4 + " 字节超过200KB限制，已丢弃", null, 4, null);
        return;
    L9:
        if (this.isBound == false) goto L24;
        r8.put("app_package_name", this.config.getPkgName());     // Catch: Exception -> L12
        r8.put("app_version_code", this.config.getVersionCode());     // Catch: Exception -> L12
        r8.put("app_version_name", this.config.getVersionName());     // Catch: Exception -> L12
        r8.put("app_is_boe", this.config.isBoe() ? 1 : 0);     // Catch: Exception -> L12
        onEventInternal(r7, r8);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        MLog.e(TAG, "onEvent error", e);
        return;
    L24:
        this.pendingEvents.add(new PendingEvent(r7, new JSONObject(r8.toString())));     // Catch: Exception -> L16
        MLog.i$default(TAG, "服务未绑定，暂存事件: " + r7 + " 成功，当前暂存数量: " + this.pendingEvents.size(), null, 4, null);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        MLog.e(TAG, "服务未绑定，暂存事件 " + r7 + " 失败", e);
        return;
    L19:
        th = move-exception;
        MLog.e(TAG, "计算事件大小失败，已丢弃事件 ".concat(r7), th);
    }

    public final void onPageShowEvent(@NotNull String r3, @Nullable String r4, int r5) {
        Intrinsics.f(r3, "pageName");
        JSONObject r0 = new JSONObject();
        r0.put("duration", r5);
        r0.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r3);
        r0.put("prev_page_name", r4);
        onEvent(EVENT_PAGE_SHOW, r0);
    }

    public final void rebindService() {
        this.isBound = false;     // Catch: Exception -> L5
        this.service = null;     // Catch: Exception -> L5
        this.handler.postDelayed(new androidx.constraintlayout.helper.widget.a(2, this), WsConstants.EXIT_DELAY_TIME);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e(TAG, "rebindService error", e);
    }

    public final void removeDeviceInfoListener(@NotNull DeviceInfoListener r4) {
        Intrinsics.f(r4, "listener");
        this.listeners.remove(r4);     // Catch: Exception -> L5
        MLog.i$default(TAG, "removeDeviceInfoListener " + r4 + ", size = " + this.listeners.size(), null, 4, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e(TAG, "removeDeviceInfoListener error", e);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$retryRunnable$1] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$deviceInfoCallback$1] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$connection$1] */
    private MatrixTeaManager(Context r1, MatrixTeaConfig r2) {
        this.context = r1;
        this.config = r2;
        this.listeners = new CopyOnWriteArrayList();
        this.handler = new Handler(Looper.getMainLooper());
        this.pendingEvents = new CopyOnWriteArrayList();
        this.retryRunnable = new MatrixTeaManager$retryRunnable$1(this);
        HandlerThread r3 = new HandlerThread("MatrixTeaBackgroundThread");
        r3.start();
        this.backgroundHandler = new Handler(r3.getLooper());
        this.deviceInfoCallback = new MatrixTeaManager$deviceInfoCallback$1(this);
        this.connection = new MatrixTeaManager$connection$1(this);
    }

    public final void onPageShowEvent(@NotNull String r3, long r4, @NotNull JSONObject r6) {
        Intrinsics.f(r3, "pageName");
        Intrinsics.f(r6, WsConstants.KEY_EXTRA);
        JSONObject r0 = new JSONObject();
        r0.put("duration", r4);
        r0.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r3);
        Iterator<String> r5 = r6.keys();
        Intrinsics.e(r5, "extra.keys()");
    L4:
        if (r5.hasNext() == false) goto L6;
        String r7 = r5.next();
        r0.put(r7, r6.get(r7));
        goto L4
    L6:
        onEvent(EVENT_PAGE_SHOW, r0);
    }
}
