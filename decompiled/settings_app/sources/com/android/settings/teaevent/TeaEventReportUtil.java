package com.android.settings.teaevent;

import android.content.Context;
import com.android.settings.search.SearchFragment;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaConfig;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.olog.Constants;
import com.obric.olog.OLog;
import com.obric.settingcommon.TrackerEventUpload;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: TeaEventReportUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\fH\u0002J&\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018J&\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/settings/teaevent/TeaEventReportUtil;", "", "()V", "TAG", "", "initialized", "", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "pendingEvents", "", "Lkotlin/Pair;", "Lorg/json/JSONObject;", "versionName", "init", "", "context", "Landroid/content/Context;", "versionCode", "", "onEvent", "eventName", "params", Constants.REPORT_FIELD, "", "reportEvent", "eventParams", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TeaEventReportUtil {
    public static final TeaEventReportUtil INSTANCE = null;
    private static final String TAG = "TeaEventReportUtil";
    private static volatile boolean initialized;
    private static final CoroutineScope ioScope = null;
    private static final List<Pair<String, JSONObject>> pendingEvents = null;
    private static String versionName;

    /* JADX INFO: renamed from: com.android.settings.teaevent.TeaEventReportUtil$onEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: TeaEventReportUtil.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.teaevent.TeaEventReportUtil$onEvent$1", f = "TeaEventReportUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $eventName;
        final /* synthetic */ JSONObject $params;
        int label;

        AnonymousClass1(String r1, JSONObject r2, Continuation<? super AnonymousClass1> r3) {
            this.$eventName = r1;
            this.$params = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$eventName, this.$params, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r5);
            OLog.d(TeaEventReportUtil.TAG, "onEvent, eventName: " + this.$eventName + ", params: " + this.$params);     // Catch: Exception -> L7
            MatrixTeaManager.Companion.getInstance().onEvent(this.$eventName, this.$params);     // Catch: Exception -> L7
        L10:
            return Unit.INSTANCE;
        L7:
            e = move-exception;
            OLog.e(TeaEventReportUtil.TAG, "onEvent, report failed, eventName: " + this.$eventName + ", params: " + this.$params + ", error: " + e);
            goto L10
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ void $r8$lambda$GEWdphfebLDdZDYzTHQdjzY4XuU(String r0, Map r1) {
        init$lambda$1(r0, r1);
    }

    private TeaEventReportUtil() {
    }

    @JvmStatic
    public static final void init(Context r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "versionName");
        OLog.i(TAG, "init 初始化了");
        MatrixTeaConfig r5 = new MatrixTeaConfig.Builder().setPackageName("com.android.settings").setVersionCode(r4).setIsBoe(false).setVersionName(r3).build();
        MatrixTeaManager.Companion.init(r2, r5);
        TeaEventReportUtil r6 = INSTANCE;
        versionName = r3;
        r6.init();
    }

    @JvmStatic
    public static final void reportEvent(String r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        OLog.i(TAG, "reportEvent " + r7 + TokenParser.SP + r8);     // Catch: Exception -> L11
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L11
        if (r8 == null) goto L9;
        Iterator<Map.Entry<String, ? extends Object>> r4 = r8.entrySet().iterator();     // Catch: Exception -> L11
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<String, ? extends Object> r5 = r4.next();     // Catch: Exception -> L11
        r3.put(r5.getKey(), r5.getValue());     // Catch: Exception -> L11
    L9:
        MatrixTeaManager.Companion.getInstance().onEvent(r7, r3);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        OLog.e(TAG, "reportEvent " + r7 + TokenParser.SP + r8 + " error", e);
    }

    static {
        INSTANCE = new TeaEventReportUtil();
        pendingEvents = new ArrayList();
        ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        versionName = "";
    }

    private final void init() {
        if (initialized == false) goto L6;
        OLog.w(TAG, "init, already initialized");
        return;
    L6:
        initialized = true;
        TrackerEventUpload.getInstance().setEventUpload(new TeaEventReportUtil$$ExternalSyntheticLambda0());
        StringBuilder r3 = new StringBuilder("init, pendingEvents size: ");
        List<Pair<String, JSONObject>> r1 = pendingEvents;
        OLog.i(TAG, r3.append(r1.size()).toString());
        Iterator<T> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        Pair r0 = (Pair) r4.next();
        INSTANCE.onEvent((String) r0.getFirst(), (JSONObject) r0.getSecond());
        goto L8
    L10:
        pendingEvents.clear();
    }

    private static final void init$lambda$1(String r2, Map r3) {
        if (r3 == null) goto L4;
        r3.put("page", SearchFragment.class.getName());
    L4:
        TeaEventReportUtil r0 = INSTANCE;
        Intrinsics.checkNotNull(r2);
        r0.report(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void report$default(TeaEventReportUtil r0, String r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.report(r1, r2);
    }

    public final void report(String r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        JSONObject r0 = new JSONObject();
        if (r6 == null) goto L14;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r7 = r6.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Map.Entry<String, ? extends Object> r2 = r7.next();
        if ((!StringsKt.isBlank(r2.getKey())) == false) goto L6;
        r1.put(r2.getKey(), r2.getValue());
        goto L6
    L10:
        Iterator r8 = r1.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) r8.next();
        r0.put((String) r3.getKey(), r3.getValue());
    L14:
        r0.put("app_version_name", versionName);
        onEvent(r5, r0);
    }

    static /* synthetic */ void onEvent$default(TeaEventReportUtil r0, String r1, JSONObject r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new JSONObject();
    L5:
        r0.onEvent(r1, r2);
    }

    private final void onEvent(String r7, JSONObject r8) {
        if (initialized == true) goto L6;
        pendingEvents.add(TuplesKt.to(r7, r8));
        return;
    L6:
        BuildersKt.launch$default(ioScope, null, null, new AnonymousClass1(r7, r8, null), 3, null);
    }
}
