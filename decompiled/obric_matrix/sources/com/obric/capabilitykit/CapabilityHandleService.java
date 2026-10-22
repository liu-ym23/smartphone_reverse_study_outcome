package com.obric.capabilitykit;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.obric.capabilitykit.common.ICapabilityActionHandler;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.UtilsKt;
import h.a.m0;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/CapabilityHandleService;", "Landroid/app/Service;", "()V", "binder", "Lcom/obric/capabilitykit/CapabilityHandleService$CapabilityHandleBinder;", "timer", "Ljava/util/Timer;", "timerRunning", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "", "resetTimer", "startTimer", "CapabilityHandleBinder", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CapabilityHandleService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f8086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Timer f8087g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8088h;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/CapabilityHandleService$CapabilityHandleBinder;", "Lcom/obric/capabilitykit/common/ICapabilityActionHandler$Stub;", "(Lcom/obric/capabilitykit/CapabilityHandleService;)V", "getVersion", "", "handleAction", "", "s", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class a extends ICapabilityActionHandler.Stub {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CapabilityHandleService f8089f;

        /* JADX INFO: renamed from: com.obric.capabilitykit.CapabilityHandleService$a$a, reason: collision with other inner class name */
        @kotlin.k0.j.a.f(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleAction$1$1$1", f = "CapabilityHandleService.kt", l = {38}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0216a extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f8090f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ IMAppAction f8091g;

            C0216a(IMAppAction r1, kotlin.k0.d<? super C0216a> r2) {
                this.f8091g = r1;
                super(2, r2);
            }

            @Override // kotlin.k0.j.a.a
            public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
                return new C0216a(this.f8091g, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
                return ((C0216a) create(r1, r2)).invokeSuspend(f0.f18324a);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
                return invoke2(r1, r2);
            }

            @Override // kotlin.k0.j.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = kotlin.k0.i.b.c();
                int r1 = this.f8090f;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                w.b(r8);
            L13:
                IMAppAction r9 = (IMAppAction) r8;
                com.obric.capabilitykit.k.c.f8155a.b("CapabilityHandleService", "sendActionExecuteResult: " + this.f8091g.getQuestionId() + ' ' + r9.getContent());
                f.f8133a.h(r9);
            L15:
                return f0.f18324a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                w.b(r8);
                if (this.f8091g.getReplyId() != 0) goto L15;
                c r10 = c.f8094a;
                IMAppAction r2 = this.f8091g;
                o.e(r2, "action");
                this.f8090f = 1;
                r8 = r10.c(r2, this);
                if (r8 != r0) goto L13;
                return r0;
            }
        }

        public a(CapabilityHandleService r1) {
            this.f8089f = r1;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int getVersion() {
            return 1;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleAction(String r9) {
            CapabilityHandleService r8 = this.f8089f;
            v.a r2 = v.f21457g;     // Catch: Throwable -> L9
            com.obric.capabilitykit.k.c r3 = com.obric.capabilitykit.k.c.f8155a;     // Catch: Throwable -> L9
            r3.a("CapabilityHandleService", "doAction: " + r9);     // Catch: Throwable -> L9
            CapabilityHandleService.a(r8);     // Catch: Throwable -> L9
            IMAppAction r10 = (IMAppAction) UtilsKt.getGson().m(r9, IMAppAction.class);     // Catch: Throwable -> L9
            if (r10 == null) goto L6;
            o.e(r10, "action");     // Catch: Throwable -> L9
            r3.b("CapabilityHandleService", "doAction questionId:" + r10.getQuestionId());     // Catch: Throwable -> L9
            h.a.h.b(c.f8094a.a(), null, null, new C0216a(r10, null), 3, null);     // Catch: Throwable -> L9
        L6:
            if (r10 == null) goto L16;
            return true;
        L16:
            return false;
        L9:
            th = move-exception;
            v.a r11 = v.f21457g;
            Object r12 = w.a(th);
            v.b(r12);
            Throwable r13 = v.d(r12);
            if (r13 == null) goto L13;
            com.obric.capabilitykit.k.c.f8155a.b("CapabilityHandleService", "handleAction fail: " + kotlin.a.b(r13));
        L13:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/CapabilityHandleService$startTimer$1$1", "Ljava/util/TimerTask;", "run", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends TimerTask {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CapabilityHandleService f8092f;

        b(CapabilityHandleService r1) {
            this.f8092f = r1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f8092f.stopSelf();
            com.obric.capabilitykit.k.c.f8155a.b("CapabilityHandleService", "stop service");
        }
    }

    static {
    }

    public CapabilityHandleService() {
        this.f8086f = new a(this);
    }

    public static final /* synthetic */ void a(CapabilityHandleService r0) {
        r0.b();
    }

    private final void b() {
        Timer r0 = this.f8087g;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.f8087g = null;
        this.f8088h = false;
        c();
    }

    private final void c() {
        if (this.f8088h == true) goto L6;
        Timer r0 = new Timer();
        r0.schedule(new b(this), 300000);
        this.f8087g = r0;
        this.f8088h = true;
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r3) {
        o.f(r3, "intent");
        com.obric.capabilitykit.k.c.f8155a.b("CapabilityHandleService", "onBind");
        c();
        return this.f8086f;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.obric.capabilitykit.k.c.f8155a.b("CapabilityHandleService", "onDestroy");
    }
}
