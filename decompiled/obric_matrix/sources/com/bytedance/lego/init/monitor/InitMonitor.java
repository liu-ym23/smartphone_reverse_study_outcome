package com.bytedance.lego.init.monitor;

import a.b.a.a.j.c;
import a.b.a.a.j.e;
import a.b.a.a.n;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.e.m;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.services.apm.api.ILaunchTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bb\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u000eJ\u001f\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010\u001fJ%\u0010!\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J%\u0010!\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b!\u0010#J%\u0010!\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b!\u0010$J\u001d\u0010%\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b'\u0010&J\u001d\u0010(\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b*\u0010)J\u0015\u0010+\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u000b¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\b1\u0010,J\u001d\u00105\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u0015\u00105\u001a\u00020\u00062\u0006\u00103\u001a\u000202¢\u0006\u0004\b5\u00107J\r\u00108\u001a\u00020\u0006¢\u0006\u0004\b8\u0010\u001fJ%\u0010>\u001a\u00020\u00062\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u001d\u0010C\u001a\u00020\u00062\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020<¢\u0006\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u0010HR\u001f\u0010O\u001a\u0004\u0018\u00010J8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bP\u0010HR\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010FR(\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040S0R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010HR\u0016\u0010Z\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bZ\u0010HR\u0016\u0010[\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b[\u0010HR\u0016\u0010\\\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\\\u0010HR\u0016\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b]\u0010HR\u0016\u0010^\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010`\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u0010HR\u0016\u0010a\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u0010H¨\u0006c"}, d2 = {"Lcom/bytedance/lego/init/monitor/InitMonitor;", "", "", "key", "", "cosTime", "Lkotlin/f0;", "addDuration", "(Ljava/lang/String;J)V", "Lcom/bytedance/lego/init/e/l;", "taskInfo", "", "isMainThread", "getTaskTag", "(Lcom/bytedance/lego/init/e/l;Z)Ljava/lang/String;", "Lcom/bytedance/lego/init/e/m;", "getPeriodTaskTag", "(Lcom/bytedance/lego/init/e/m;Z)Ljava/lang/String;", "name", "getMonitorTag", "(Ljava/lang/String;Z)Ljava/lang/String;", "getTaskStartTag", "getTaskEndTag", "getMonitorStartTag", "getMonitorEndTag", "monitorTaskTimeout", "()Z", "delay", "sendStartUpTimeAsync", "(J)V", "sendStartUpTimeAsyncInternal", "()V", "onAttachBase", "monitorCosTime", "(Lcom/bytedance/lego/init/e/l;JZ)V", "(Lcom/bytedance/lego/init/e/m;JZ)V", "(Ljava/lang/String;JZ)V", "monitorTaskStart", "(Lcom/bytedance/lego/init/e/l;Z)V", "monitorTaskEnd", "monitorStart", "(Ljava/lang/String;Z)V", "monitorEnd", "monitor", "(Ljava/lang/String;)V", "needUploadTask", "onFeedFirstShown", "(Z)V", "taskId", "onTaskTimeout", "", "t", NotificationCompat.CATEGORY_MESSAGE, "ensureNotReachHere", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "(Ljava/lang/Throwable;)V", "sendStartUpTimeImmediately", "Lcom/bytedance/lego/init/monitor/Category;", "category", WsConstants.KEY_CONNECTION_TYPE, "Lorg/json/JSONObject;", "extraLog", "monitorEvent", "(Lcom/bytedance/lego/init/monitor/Category;Ljava/lang/String;Lorg/json/JSONObject;)V", "Lcom/bytedance/lego/init/monitor/LogType;", "logType", "logExtr", "monitorLog", "(Lcom/bytedance/lego/init/monitor/LogType;Lorg/json/JSONObject;)V", "alreadyUpload", "Z", "TASKDISPATCHER_INIT", "Ljava/lang/String;", "MONITOR_INIT", "Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService$delegate", "Lkotlin/h;", "getLaunchTraceService", "()Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService", "ALL_FEED_FIRST_SHOWN", "alreadyFeedShown", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/Pair;", "cosTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "timeoutTaskList", "Ljava/util/List;", "ASYNC", "MONITOR_INIT_EXCEPTION", "TASK_START_SUFFIX", "INIT_SCHEDULER", "MAIN", "onAttachBaseTime", "J", "TASK_END_SUFFIX", "WAIT_ASYNC_TASK_INIT", "<init>", "initscheduler_release"}, k = 1, mv = {1, 1, 15})
public final class InitMonitor {
    public static final /* synthetic */ l[] $$delegatedProperties = null;
    public static final String ALL_FEED_FIRST_SHOWN = "ALLFeedFirstShown";
    public static final String ASYNC = "Async:";
    public static final String INIT_SCHEDULER = "init-scheduler";
    public static final InitMonitor INSTANCE = null;
    public static final String MAIN = "Main:";
    public static final String MONITOR_INIT = "init_task_monitor";
    public static final String MONITOR_INIT_EXCEPTION = "init_task_exception_monitor";
    public static final String TASKDISPATCHER_INIT = "InitTaskDispatcher.init";
    public static final String TASK_END_SUFFIX = "##TASKEND";
    public static final String TASK_START_SUFFIX = "##TASKSTART";
    public static final String WAIT_ASYNC_TASK_INIT = "wait_async_task_init";
    public static volatile boolean alreadyFeedShown;
    public static volatile boolean alreadyUpload;
    public static final CopyOnWriteArrayList<Pair<String, Long>> cosTimeList = null;
    public static final h launchTraceService$delegate = null;
    public static long onAttachBaseTime;
    public static final List<String> timeoutTaskList = null;

    static final class a extends q implements kotlin.n0.c.a<ILaunchTrace> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f4909f = null;

        static {
            f4909f = new a();
        }

        public a() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public ILaunchTrace invoke() {
            o.g(ILaunchTrace.class, "clazz");
            n r0 = a.b.a.a.h.f29a;
            if (r0 == null) goto L5;
            Object r1 = ((a.b.a.a.h) r0).a(ILaunchTrace.class);
        L7:
            return (ILaunchTrace) r1;
        L5:
            r1 = d.a(ILaunchTrace.class);
            goto L7
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f4910f = null;

        static final class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f4911f = null;

            static {
                f4911f = new a();
            }

            public a() {
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public final void run() {
                InitMonitor.access$sendStartUpTimeAsyncInternal(InitMonitor.INSTANCE);     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                InitMonitor r0 = InitMonitor.INSTANCE;
                a.b.a.a.j.a r1 = a.b.a.a.j.a.m;
                String r2 = e.getClass().getName();
                o.b(r2, "e.javaClass.name");
                JSONObject r3 = new JSONObject();
                JSONObject r4 = new JSONObject();
                r4.put("exception_detail", Log.getStackTraceString(e));
                r3.put("exception_detail", r4);
                r0.monitorEvent(r1, r2, r3);
            }
        }

        static {
            f4910f = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r1 = a.f4911f;
            ThreadPoolExecutor r0 = InitScheduler.INSTANCE.getExecutorServiceOrNull$initscheduler_release();
            if (r0 != null) goto L5;
        L7:
            InitMonitor r2 = InitMonitor.INSTANCE;
            new Thread(r1).start();
            f0 r3 = f0.f18324a;
            return;
        L5:
            if (r0.submit(r1) == null) goto L7;
        }
    }

    static {
        $$delegatedProperties = new l[]{e0.g(new y(e0.b(InitMonitor.class), "launchTraceService", "getLaunchTraceService()Lcom/bytedance/services/apm/api/ILaunchTrace;"))};
        INSTANCE = new InitMonitor();
        cosTimeList = new CopyOnWriteArrayList();
        timeoutTaskList = new ArrayList();
        launchTraceService$delegate = i.b(a.f4909f);
        ALL_FEED_FIRST_SHOWN = "ALLFeedFirstShown";
        INIT_SCHEDULER = "init-scheduler";
    }

    public InitMonitor() {
    }

    public static final /* synthetic */ void access$sendStartUpTimeAsyncInternal(InitMonitor r0) {
        r0.sendStartUpTimeAsyncInternal();
    }

    private final synchronized void addDuration(String r3, long r4) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (alreadyFeedShown == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        cosTimeList.add(new Pair(r3, Long.valueOf(r4)));     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private final ILaunchTrace getLaunchTraceService() {
        h r2 = launchTraceService$delegate;
        l r0 = $$delegatedProperties[0];
        return (ILaunchTrace) r2.getValue();
    }

    private final String getMonitorEndTag(String r2, boolean r3) {
        if (r3 == false) goto L7;
        StringBuilder r4 = new StringBuilder();
        String r0 = MAIN;
    L5:
        r4.append(r0);
        r4.append(r2);
        r4.append(TASK_END_SUFFIX);
        return r4.toString();
    L7:
        r4 = new StringBuilder();
        r0 = ASYNC;
        goto L5
    }

    private final String getMonitorStartTag(String r2, boolean r3) {
        if (r3 == false) goto L7;
        StringBuilder r4 = new StringBuilder();
        String r0 = MAIN;
    L5:
        r4.append(r0);
        r4.append(r2);
        r4.append(TASK_START_SUFFIX);
        return r4.toString();
    L7:
        r4 = new StringBuilder();
        r0 = ASYNC;
        goto L5
    }

    private final String getMonitorTag(String r1, boolean r2) {
        if (r2 == false) goto L7;
        StringBuilder r0 = new StringBuilder();
        String r3 = MAIN;
    L5:
        r0.append(r3);
        r0.append(r1);
        return r0.toString();
    L7:
        r0 = new StringBuilder();
        r3 = ASYNC;
        goto L5
    }

    private final String getPeriodTaskTag(m r1, boolean r2) {
        if (r2 == false) goto L6;
        String r0 = MAIN;
    L4:
        StringBuilder r3 = b.a.a.a.a.e(r0);
        r3.append(r1.c());
        return r3.toString();
    L6:
        r0 = ASYNC;
        goto L4
    }

    private final String getTaskEndTag(com.bytedance.lego.init.e.l r1, boolean r2) {
        if (r2 == false) goto L7;
        String r3 = MAIN;
    L6:
        return b.a.a.a.a.d(b.a.a.a.a.e(r3), r1.f4899f, TASK_END_SUFFIX);
    L7:
        r3 = ASYNC;
        goto L6
    }

    private final String getTaskStartTag(com.bytedance.lego.init.e.l r1, boolean r2) {
        if (r2 == false) goto L7;
        String r3 = MAIN;
    L6:
        return b.a.a.a.a.d(b.a.a.a.a.e(r3), r1.f4899f, TASK_START_SUFFIX);
    L7:
        r3 = ASYNC;
        goto L6
    }

    private final String getTaskTag(com.bytedance.lego.init.e.l r1, boolean r2) {
        if (r2 == false) goto L6;
        String r0 = "Main:Task-";
    L4:
        StringBuilder r3 = b.a.a.a.a.e(r0);
        r3.append(r1.f4899f);
        return r3.toString();
    L6:
        r0 = "Async:Task-";
        goto L4
    }

    private final boolean monitorTaskTimeout() {
        List<String> r3 = timeoutTaskList;     // Catch: Exception -> L16
        if (r3.isEmpty() == false) goto L6;
        return false;
    L6:
        Iterator<T> r4 = r3.iterator();     // Catch: Exception -> L16
    L8:
        if (r4.hasNext() == false) goto L14;
        String r5 = (String) r4.next();     // Catch: Exception -> L16
        InitMonitor r6 = INSTANCE;     // Catch: Exception -> L16
        a.b.a.a.j.a r7 = a.b.a.a.j.a.f36l;     // Catch: Exception -> L16
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L16
        InitScheduler r9 = InitScheduler.INSTANCE;     // Catch: Exception -> L16
        r8.append(r9.getConfig$initscheduler_release().getTimeout());     // Catch: Exception -> L16
        r8.append(':');     // Catch: Exception -> L16
        r8.append(r5);     // Catch: Exception -> L16
        r6.monitorEvent(r7, r8.toString(), new JSONObject());     // Catch: Exception -> L16
        a.b.a.a.l.b r10 = a.b.a.a.l.b.f72a;     // Catch: Exception -> L16
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L16
        r11.append("TaskTimeout: ");     // Catch: Exception -> L16
        r11.append(r5);     // Catch: Exception -> L16
        r11.append(", ");     // Catch: Exception -> L16
        r11.append(r9.getConfig$initscheduler_release().getTimeout());     // Catch: Exception -> L16
        a.b.a.a.l.b.a(r10, null, r11.toString(), 1);     // Catch: Exception -> L16
        goto L8
    L14:
        sendStartUpTimeAsyncInternal();     // Catch: Exception -> L16
        return true;
    L16:
        e = move-exception;
        e.printStackTrace();
        a.b.a.a.l.b r12 = a.b.a.a.l.b.f72a;
        String r13 = Log.getStackTraceString(e);
        o.b(r13, "Log.getStackTraceString(e)");
        a.b.a.a.l.b.c(r12, null, r13, 1);
        return false;
    }

    private final void sendStartUpTimeAsync(long r2) {
        new Handler(Looper.getMainLooper()).postDelayed(b.f4910f, r2);
    }

    private final synchronized void sendStartUpTimeAsyncInternal() {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L4:
        if (alreadyUpload == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r0 = 1;
        alreadyUpload = true;     // Catch: Throwable -> L40
        o.g(IApmAgent.class, "clazz");     // Catch: Throwable -> L40
        n r2 = a.b.a.a.h.f29a;     // Catch: Throwable -> L40
        if (r2 == null) goto L13;
        if (r2 == null) goto L12;
        Object r1 = ((a.b.a.a.h) r2).a(IApmAgent.class);     // Catch: Throwable -> L40
    L14:
        IApmAgent r3 = (IApmAgent) r1;     // Catch: Throwable -> L40
        if (r3 == null) goto L38;
        alreadyFeedShown = true;     // Catch: Throwable -> L40
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L40
        Iterator<T> r5 = cosTimeList.iterator();     // Catch: Exception -> L24 Throwable -> L40
    L19:
        if (r5.hasNext() == false) goto L26;
        Pair r6 = (Pair) r5.next();     // Catch: Exception -> L24 Throwable -> L40
        String r7 = (String) r6.first;     // Catch: Exception -> L24 Throwable -> L40
        Object r8 = r6.second;     // Catch: Exception -> L24 Throwable -> L40
        o.b(r8, "it.second");     // Catch: Exception -> L24 Throwable -> L40
        r4.put(r7, ((Number) r8).longValue());     // Catch: Exception -> L24 Throwable -> L40
    L26:
        String r9 = r4.toString();     // Catch: Throwable -> L40
        o.b(r9, "metric.toString()");     // Catch: Throwable -> L40
        o.g("sendStartUpTimeAsync", "classname");     // Catch: Throwable -> L40
        o.g(r9, "message");     // Catch: Throwable -> L40
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L35;
        String r10 = b.a.a.a.a.b("sendStartUpTimeAsync", ' ', r9);     // Catch: Throwable -> L40
        int r11 = r10.length();     // Catch: Throwable -> L40
        int r12 = 0;
        int r13 = 3072;
    L30:
        int r14 = r12;
        r12 = r13;
        if (r0 > 100) goto L35;
        if (r11 <= r12) goto L34;
        r13 = b.a.a.a.a.a(r10, r14, r12, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r0), r12, 3072);     // Catch: Throwable -> L40
        r0 = r0 + 1;     // Catch: Throwable -> L40
        goto L30
    L34:
        b.a.a.a.a.f(r10, r14, r11, "(this as java.lang.Strin…ing(startIndex, endIndex)", b.a.a.a.a.c("#inittask#", r0));     // Catch: Throwable -> L40
    L35:
        a.b.a.a.d.u.f();     // Catch: Throwable -> L40
        r3.monitorEvent(MONITOR_INIT, new JSONObject(), r4, new JSONObject());     // Catch: Throwable -> L40
        cosTimeList.clear();     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L40
        goto L26
    L38:
        monitor-exit(this);
        return;
    L12:
        r1 = null;
        goto L14
    L13:
        r1 = d.a(IApmAgent.class);     // Catch: Throwable -> L40
        goto L14
    }

    public final void ensureNotReachHere(Throwable r2) {
        o.g(r2, "t");
        o.g(IEnsure.class, "clazz");
        n r0 = a.b.a.a.h.f29a;
        if (r0 == null) goto L7;
        if (r0 == null) goto L6;
        Object r1 = ((a.b.a.a.h) r0).a(IEnsure.class);
    L8:
        IEnsure r3 = (IEnsure) r1;
        if (r3 == null) goto L12;
        r3.ensureNotReachHere(r2);
        return;
    L12:
        return;
    L6:
        r1 = null;
        goto L8
    L7:
        r1 = d.a(IEnsure.class);
        goto L8
    }

    public final void ensureNotReachHere(Throwable r4, String r5) {
        o.g(r4, "t");
        o.g(r5, NotificationCompat.CATEGORY_MESSAGE);
        o.g(IEnsure.class, "clazz");
        n r1 = a.b.a.a.h.f29a;
        Object r2 = null;
        if (r1 == null) goto L7;
        if (r1 == null) goto L6;
        Object r3 = ((a.b.a.a.h) r1).a(IEnsure.class);
    L8:
        IEnsure r6 = (IEnsure) r3;
        if (r6 == null) goto L11;
        r6.ensureNotReachHere(r4, r5);
    L11:
        o.g(IApmAgent.class, "clazz");
        n r0 = a.b.a.a.h.f29a;
        if (r0 == null) goto L15;
        if (r0 == null) goto L16;
        r2 = ((a.b.a.a.h) r0).a(IApmAgent.class);
    L16:
        IApmAgent r7 = (IApmAgent) r2;
        if (r7 == null) goto L20;
        JSONObject r8 = new JSONObject();
        r8.put("EnsureNotReachHere", r5);
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        r10.put("detail", Log.getStackTraceString(r4));
        r7.monitorEvent(MONITOR_INIT_EXCEPTION, r8, r9, r10);
        return;
    L20:
        return;
    L15:
        r2 = d.a(IApmAgent.class);
        goto L16
    L6:
        r3 = null;
        goto L8
    L7:
        r3 = d.a(IEnsure.class);
        goto L8
    }

    public final void monitor(String r5) {
        o.g(r5, "name");
        addDuration(r5, System.currentTimeMillis() - onAttachBaseTime);
    }

    public final void monitorCosTime(com.bytedance.lego.init.e.l r2, long r3, boolean r5) {
        o.g(r2, "taskInfo");
        addDuration(getTaskTag(r2, r5), r3);
    }

    public final void monitorCosTime(m r2, long r3, boolean r5) {
        o.g(r2, "taskInfo");
        addDuration(getPeriodTaskTag(r2, r5), r3);
    }

    public final void monitorCosTime(String r2, long r3, boolean r5) {
        o.g(r2, "name");
        addDuration(getMonitorTag(r2, r5), r3);
    }

    public final void monitorEnd(String r5, boolean r6) {
        o.g(r5, "name");
        addDuration(getMonitorEndTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.endSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitorEvent(a.b.a.a.j.a r5, String r6, JSONObject r7) {
        o.g(r5, "category");
        o.g(r6, WsConstants.KEY_CONNECTION_TYPE);
        o.g(r7, "extraLog");
        o.g(IApmAgent.class, "clazz");
        n r0 = a.b.a.a.h.f29a;
        if (r0 == null) goto L7;
        if (r0 == null) goto L6;
        Object r4 = ((a.b.a.a.h) r0).a(IApmAgent.class);
    L8:
        IApmAgent r8 = (IApmAgent) r4;
        if (r8 == null) goto L19;
        JSONObject r1 = new JSONObject();
        r1.put(r5.f37f, r6);     // Catch: Exception -> L13
    L15:
        r7.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
        r7.put("isUIThread", o.a(Looper.getMainLooper(), Looper.myLooper()));
        r8.monitorEvent(MONITOR_INIT, r1, new JSONObject(), r7);
        a.b.a.a.l.b.a(a.b.a.a.l.b.f72a, null, r5.name() + ' ' + r6 + ' ' + r7.toString(), 1);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L19:
        return;
    L6:
        r4 = null;
        goto L8
    L7:
        r4 = d.a(IApmAgent.class);
        goto L8
    }

    public final void monitorLog(e r3, JSONObject r4) {
        o.g(r3, "logType");
        o.g(r4, "logExtr");
        o.g(IApmAgent.class, "clazz");
        n r0 = a.b.a.a.h.f29a;
        if (r0 == null) goto L7;
        if (r0 == null) goto L6;
        Object r2 = ((a.b.a.a.h) r0).a(IApmAgent.class);
    L8:
        IApmAgent r5 = (IApmAgent) r2;
        if (r5 == null) goto L12;
        r5.monitorLog(r3.name(), r4);
        a.b.a.a.l.b.a(a.b.a.a.l.b.f72a, null, r3.name() + " " + r4.toString(), 1);
        return;
    L12:
        return;
    L6:
        r2 = null;
        goto L8
    L7:
        r2 = d.a(IApmAgent.class);
        goto L8
    }

    public final void monitorStart(String r5, boolean r6) {
        o.g(r5, "name");
        addDuration(getMonitorStartTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.startSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitorTaskEnd(com.bytedance.lego.init.e.l r5, boolean r6) {
        o.g(r5, "taskInfo");
        addDuration(getTaskEndTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.endSpan(r5.f4900g, r5.f4899f);
        return;
    }

    public final void monitorTaskStart(com.bytedance.lego.init.e.l r5, boolean r6) {
        o.g(r5, "taskInfo");
        addDuration(getTaskStartTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.startSpan(r5.f4900g, r5.f4899f);
        return;
    }

    public final void onAttachBase() {
        onAttachBaseTime = System.currentTimeMillis();
        c.f43c.a();
        ILaunchTrace r2 = getLaunchTraceService();
        if (r2 == null) goto L6;
        r2.startTrace();
        return;
    }

    public final void onFeedFirstShown(boolean r9) {
        long r0 = System.currentTimeMillis() - onAttachBaseTime;     // Catch: Exception -> L28
        boolean r2 = false;
        if (r0 > LocationInfoConst.HALF_MINUTES) goto L5;
        r2 = monitorTaskTimeout();     // Catch: Exception -> L28
    L5:
        if (r9 == true) goto L11;
        ILaunchTrace r10 = getLaunchTraceService();     // Catch: Exception -> L28
        if (r10 == null) goto L9;
        r10.cancelTrace();     // Catch: Exception -> L28
    L9:
        cosTimeList.clear();     // Catch: Exception -> L28
        return;
    L11:
        ILaunchTrace r11 = getLaunchTraceService();     // Catch: Exception -> L28
        if (r11 == null) goto L20;
        Activity r5 = InitScheduler.getMainActivity$initscheduler_release();     // Catch: Exception -> L28
        if (r5 == null) goto L18;
        Class<?> r6 = r5.getClass();     // Catch: Exception -> L28
        if (r6 == null) goto L18;
        String r7 = r6.getName();     // Catch: Exception -> L28
    L19:
        r11.endTrace(2, r7, 20000);     // Catch: Exception -> L28
    L18:
        r7 = null;
    L20:
        addDuration(ALL_FEED_FIRST_SHOWN, r0);     // Catch: Exception -> L28
        a.b.a.a.l.b r12 = a.b.a.a.l.b.f72a;     // Catch: Exception -> L28
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L28
        r4.append("onFeedFirstShown: cos ");     // Catch: Exception -> L28
        r4.append(r0);     // Catch: Exception -> L28
        r4.append(" ms.");     // Catch: Exception -> L28
        a.b.a.a.l.b.a(r12, null, r4.toString(), 1);     // Catch: Exception -> L28
        if (r2 == true) goto L32;
        sendStartUpTimeAsync(CoroutineLiveDataKt.DEFAULT_TIMEOUT);     // Catch: Exception -> L28
        return;
    L32:
        return;
    L28:
        e = move-exception;
        ensureNotReachHere(e, "ON_FEED_FIRST_SHOW_EXCEPTION");
        a.b.a.a.j.a r1 = a.b.a.a.j.a.m;
        String r3 = e.getClass().getName();
        o.b(r3, "e.javaClass.name");
        JSONObject r8 = new JSONObject();
        JSONObject r13 = new JSONObject();
        r13.put("exception_detail", Log.getStackTraceString(e));
        r8.put("exception_detail", r13);
        monitorEvent(r1, r3, r8);
    }

    public final void onTaskTimeout(String r3) {
        o.g(r3, "taskId");
        timeoutTaskList.add(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        a.b.a.a.l.b r4 = a.b.a.a.l.b.f72a;
        String r2 = Log.getStackTraceString(e);
        o.b(r2, "Log.getStackTraceString(e)");
        a.b.a.a.l.b.c(r4, null, r2, 1);
    }

    public final synchronized void sendStartUpTimeImmediately() {
        monitor-enter(this);
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L50 Exception -> L52
        r2.put("curTime", System.currentTimeMillis() - onAttachBaseTime);     // Catch: Throwable -> L50 Exception -> L52
        Iterator<T> r3 = cosTimeList.iterator();     // Catch: Throwable -> L50 Exception -> L52
    L8:
        if (r3.hasNext() == false) goto L14;
        Pair r4 = (Pair) r3.next();     // Catch: Throwable -> L50 Exception -> L52
        String r5 = (String) r4.first;     // Catch: Throwable -> L50 Exception -> L52
        Object r6 = r4.second;     // Catch: Throwable -> L50 Exception -> L52
        o.b(r6, "it.second");     // Catch: Throwable -> L50 Exception -> L52
        r2.put(r5, ((Number) r6).longValue());     // Catch: Throwable -> L50 Exception -> L52
        goto L8
    L14:
        String r7 = r2.toString();     // Catch: Throwable -> L50 Exception -> L52
        o.b(r7, "metric.toString()");     // Catch: Throwable -> L50 Exception -> L52
        o.g("sendStartUpTimeImmediately", "classname");     // Catch: Throwable -> L50 Exception -> L52
        o.g(r7, "message");     // Catch: Throwable -> L50 Exception -> L52
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == false) goto L39;
        String r8 = "sendStartUpTimeImmediately " + r7;     // Catch: Throwable -> L50 Exception -> L52
        int r9 = r8.length();     // Catch: Throwable -> L50 Exception -> L52
        int r10 = 0;
        int r11 = 3072;
        int r12 = 1;
    L24:
        int r13 = r11;
        int r14 = r10;
        r10 = r13;
        if (r12 > 100) goto L39;
        if (r9 <= r10) goto L32;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L50 Exception -> L52
        r15.append("#inittask#");     // Catch: Throwable -> L50 Exception -> L52
        r15.append(r12);     // Catch: Throwable -> L50 Exception -> L52
        String r16 = r15.toString();     // Catch: Throwable -> L50 Exception -> L52
        String r17 = r8.substring(r14, r10);     // Catch: Throwable -> L50 Exception -> L52
        o.b(r17, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Throwable -> L50 Exception -> L52
        Log.d(r16, r17);     // Catch: Throwable -> L50 Exception -> L52
        r11 = r10 + 3072;     // Catch: Throwable -> L50 Exception -> L52
        r12 = r12 + 1;     // Catch: Throwable -> L50 Exception -> L52
        goto L24
    L32:
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L50 Exception -> L52
        r18.append("#inittask#");     // Catch: Throwable -> L50 Exception -> L52
        r18.append(r12);     // Catch: Throwable -> L50 Exception -> L52
        String r19 = r18.toString();     // Catch: Throwable -> L50 Exception -> L52
        String r20 = r8.substring(r14, r9);     // Catch: Throwable -> L50 Exception -> L52
        o.b(r20, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: Throwable -> L50 Exception -> L52
        Log.d(r19, r20);     // Catch: Throwable -> L50 Exception -> L52
    L39:
        o.g(IApmAgent.class, "clazz");     // Catch: Throwable -> L50 Exception -> L52
        n r21 = a.b.a.a.h.f29a;     // Catch: Throwable -> L50 Exception -> L52
        if (r21 == null) goto L44;
        if (r21 == null) goto L43;
        Object r22 = ((a.b.a.a.h) r21).a(IApmAgent.class);     // Catch: Throwable -> L50 Exception -> L52
    L45:
        IApmAgent r23 = (IApmAgent) r22;     // Catch: Throwable -> L50 Exception -> L52
        if (r23 != null) goto L48;
    L54:
        monitor-exit(this);
        return;
    L48:
        r23.monitorEvent(MONITOR_INIT, new JSONObject(), r2, new JSONObject());     // Catch: Throwable -> L50 Exception -> L52
    L43:
        r22 = null;
        goto L45
    L44:
        r22 = d.a(IApmAgent.class);     // Catch: Throwable -> L50 Exception -> L52
    L52:
        e = move-exception;
        a.b.a.a.l.b r24 = a.b.a.a.l.b.f72a;     // Catch: Throwable -> L50
        String r25 = Log.getStackTraceString(e);     // Catch: Throwable -> L50
        o.b(r25, "Log.getStackTraceString(e)");     // Catch: Throwable -> L50
        a.b.a.a.l.b.a(r24, null, r25, 1);     // Catch: Throwable -> L50
        a.b.a.a.j.a r0 = a.b.a.a.j.a.m;     // Catch: Throwable -> L50
        StringBuilder r1 = b.a.a.a.a.e("sendStartUpTimeImmediately");     // Catch: Throwable -> L50
        r1.append(e.getClass().getName());     // Catch: Throwable -> L50
        String r26 = r1.toString();     // Catch: Throwable -> L50
        JSONObject r27 = new JSONObject();     // Catch: Throwable -> L50
        JSONObject r28 = new JSONObject();     // Catch: Throwable -> L50
        r28.put("exception_detail", Log.getStackTraceString(e));     // Catch: Throwable -> L50
        r27.put("exception_detail", r28);     // Catch: Throwable -> L50
        monitorEvent(r0, r26, r27);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    }
}
