package com.obric.capabilitykit;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import h.a.m0;
import h.a.n0;
import h.a.p1;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0019\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/obric/capabilitykit/ActionDispatcher;", "", "()V", "TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getAppActionFailResult", "Lcom/obric/capabilitykit/common/IMAppAction;", "request", "code", "", NotificationCompat.CATEGORY_MESSAGE, "onActionReceived", "action", "(Lcom/obric/capabilitykit/common/IMAppAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final m0 f8095b = null;

    @kotlin.k0.j.a.f(c = "com.obric.capabilitykit.ActionDispatcher", f = "ActionDispatcher.kt", l = {28}, m = "onActionReceived")
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f8096f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f8097g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f8098h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f8099i;

        a(c r1, kotlin.k0.d<? super a> r2) {
            this.f8098h = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f8097g = r2;
            this.f8099i |= Integer.MIN_VALUE;
            return this.f8098h.c(null, this);
        }
    }

    static {
        f8094a = new c();
        ExecutorService r0 = Executors.newSingleThreadExecutor(com.obric.capabilitykit.a.f8093f);
        o.e(r0, "newSingleThreadExecutor …action-dispatcher\")\n    }");
        f8095b = n0.a(p1.b(r0));
    }

    private c() {
    }

    public static /* synthetic */ Thread b(Runnable r0) {
        return d(r0);
    }

    private static final Thread d(Runnable r2) {
        return new Thread(r2, "action-dispatcher");
    }

    public final m0 a() {
        return f8095b;
    }

    public final Object c(IMAppAction r31, kotlin.k0.d<? super IMAppAction> r32) {
        IMAppAction r0 = r31;
        if ((r32 instanceof a) == false) goto L7;
        a r2 = (a) r32;
        int r3 = r2.f8099i;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.f8099i = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f8097g;
        Object r4 = kotlin.k0.i.b.c();
        int r5 = r2.f8099i;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        r0 = (IMAppAction) r2.f8096f;
        w.b(r1);
    L17:
        BaseResult r6 = (BaseResult) r1;
        Gson r7 = new Gson();
        com.obric.capabilitykit.j.c.a r8 = com.obric.capabilitykit.j.c.f8150a;
        String r9 = r8.a().getString(i.f8143d);
        o.e(r9, "AppHost.application.getS…(R.string.action_success)");
        String r10 = r8.a().getString(i.f8141b);
        o.e(r10, "AppHost.application.getS…g(R.string.action_failed)");
        if (r6.getRet() != 0) goto L24;
        String r11 = r6.getDetails();
        if (r11 == null) goto L23;
        r9 = r11;
    L23:
        r6.setDetails(r9);
    L24:
        int r12 = r6.getRet();
        String r13 = r6.getDetails();
        if (r13 != null) goto L27;
        String r14 = r10;
    L28:
        String r20 = r7.v(new FeedbackResult(r12, r14, null, r6.getUiType(), r6.getReplyFor(), 4, null));
        if ((r6.getUiType() & 32) == 0) goto L31;
    L63:
        String r15 = UUID.randomUUID().toString();
        Long r16 = r6.getReplyId();
        if (r16 == null) goto L66;
        long r17 = r16.longValue();
    L67:
        Long r18 = r6.getQuestionId();
        Long r19 = r0.getMessageId();
        long r22 = r0.getActionId();
        long r24 = r0.getJobId();
        IMAppActionExt r21 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r23 = r6.getExt();
        String r25 = null;
        if ((r23 instanceof BaseResultExt) == false) goto L70;
        BaseResultExt r26 = (BaseResultExt) r23;
    L71:
        if (r26 == null) goto L73;
        r25 = r26.getResultDetailExtras();
    L73:
        r21.setActionDetailExtras(r25);
        return new IMAppAction(r19, r15, r17, r18, null, r20, null, r22, r24, 0, r21, 592, null);
    L70:
        r26 = null;
        goto L71
    L66:
        r17 = 0;
        goto L67
    L31:
        if ((r6.getUiType() & 64) != 0) goto L63;
        if ((r6.getUiType() & 128) != 0) goto L63;
        if ((r6.getUiType() & 512) != 0) goto L63;
        if ((r6.getUiType() & 1024) != 0) goto L63;
        if ((r6.getUiType() & 2048) != 0) goto L63;
        if ((r6.getUiType() & 4096) != 0) goto L63;
        if ((r6.getUiType() & 8192) != 0) goto L63;
        if ((r6.getUiType() & 16384) != 0) goto L63;
        if ((r6.getUiType() & 32768) != 0) goto L63;
        if ((r6.getUiType() & 524288) != 0) goto L63;
        if ((r6.getUiType() & 65536) != 0) goto L63;
        if ((r6.getUiType() & 131072) != 0) goto L63;
        if ((r6.getUiType() & 262144) != 0) goto L63;
        String r110 = UUID.randomUUID().toString();
        Long r27 = r6.getReplyId();
        if (r27 == null) goto L60;
        long r111 = r27.longValue();
    L62:
        return new IMAppAction(r0.getMessageId(), r110, r111, r6.getQuestionId(), null, r20, null, r0.getActionId(), r0.getJobId(), 0, r0.getExt(), 592, null);
    L60:
        r111 = 0;
        goto L62
    L27:
        r14 = r13;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        w.b(r1);
        d r28 = d.f8106a;
        r2.f8096f = r0;
        r2.f8099i = 1;
        r1 = r28.c(r0, r2);
        if (r1 != r4) goto L17;
        return r4;
    L7:
        r2 = new a(this, r32);
        goto L8
    }
}
