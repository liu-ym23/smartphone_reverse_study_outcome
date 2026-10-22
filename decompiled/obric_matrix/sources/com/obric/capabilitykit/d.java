package com.obric.capabilitykit;

import android.app.KeyguardManager;
import android.content.Intent;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.j;
import com.google.gson.m;
import com.obric.capabilitykit.common.BaseFunction;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IMAppAction;
import h.a.b1;
import h.a.i2;
import h.a.m0;
import h.a.y2;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.d0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u0007J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/capabilitykit/ActionManager;", "", "()V", "ACTION_TOAST_DURATION", "", "REGISTERED_ACTIONS", "", "", "Lcom/obric/capabilitykit/common/BaseFunction;", "TAG", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "Lkotlin/Lazy;", "addTool", "", "action", "getTool", "name", "handleAction", "Lcom/obric/capabilitykit/common/BaseResult;", "Lcom/obric/capabilitykit/common/IMAppAction;", "(Lcom/obric/capabilitykit/common/IMAppAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTool", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, BaseFunction> f8107b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.h f8108c = null;

    @kotlin.k0.j.a.f(c = "com.obric.capabilitykit.ActionManager", f = "ActionManager.kt", l = {74, 79, 93}, m = "handleAction")
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f8109f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f8110g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f8111h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f8112i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f8113j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f8114k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ d f8115l;
        int m;

        a(d r1, kotlin.k0.d<? super a> r2) {
            this.f8115l = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f8114k = r2;
            this.m |= Integer.MIN_VALUE;
            return this.f8115l.c(null, this);
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.capabilitykit.ActionManager$handleAction$2", f = "ActionManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8116f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d0<BaseResult> f8117g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ DispatchContext f8118h;

        b(d0<BaseResult> r1, DispatchContext r2, kotlin.k0.d<? super b> r3) {
            this.f8117g = r1;
            this.f8118h = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
            return new b(this.f8117g, this.f8118h, r3);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((b) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r8) {
            kotlin.k0.i.b.c();
            if (this.f8116f != 0) goto L19;
            w.b(r8);
            this.f8117g.f18431f.getUiType();
            if ((this.f8117g.f18431f.getUiType() & 8) == 0) goto L17;
            d r9 = d.f8106a;
            if (d.a(r9).isKeyguardLocked() == false) goto L17;
            boolean r1 = false;
            Method r2 = KeyguardManager.class.getMethod("dismissKeyguardToLaunch", new Class[]{Intent.class});     // Catch: Exception -> L11
            r2.setAccessible(true);     // Catch: Exception -> L11
            Object r10 = r2.invoke(d.a(r9), new Object[]{null});     // Catch: Exception -> L11
            o.d(r10, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L11
            r1 = ((Boolean) r10).booleanValue();     // Catch: Exception -> L11
        L13:
            com.obric.capabilitykit.k.c.f8155a.a("ActionManager", "handleAction,dismissKeyguardToLaunch: " + r1);
            if (r1 == true) goto L17;
            this.f8117g.f18431f.setDetails(this.f8118h.getContext().getString(i.f8144e));
        L11:
            e = move-exception;
            com.obric.capabilitykit.k.c.f8155a.e("ActionManager", "handleAction,dismissKeyguardToLaunch failed", e);
        L17:
            return f0.f18324a;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.capabilitykit.ActionManager$handleAction$result$1", f = "ActionManager.kt", l = {80}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/BaseResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends l implements p<m0, kotlin.k0.d<? super BaseResult>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8119f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BaseFunction f8120g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d0<m> f8121h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ DispatchContext f8122i;

        c(BaseFunction r1, d0<m> r2, DispatchContext r3, kotlin.k0.d<? super c> r4) {
            this.f8120g = r1;
            this.f8121h = r2;
            this.f8122i = r3;
            super(2, r4);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r3, kotlin.k0.d<?> r4) {
            return new c(this.f8120g, this.f8121h, this.f8122i, r4);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super BaseResult> r2) {
            return ((c) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super BaseResult> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f8119f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w.b(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r5);
            BaseFunction r6 = this.f8120g;
            m r2 = this.f8121h.f18431f.c();
            o.e(r2, "params.asJsonObject");
            DispatchContext r3 = this.f8122i;
            this.f8119f = 1;
            r5 = r6.doAction(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.d$d, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/KeyguardManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class C0218d extends q implements kotlin.n0.c.a<KeyguardManager> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0218d f8123f = null;

        static {
            f8123f = new C0218d();
        }

        C0218d() {
            super(0);
        }

        public final KeyguardManager a() {
            Object r1 = com.obric.capabilitykit.j.c.f8150a.a().getSystemService("keyguard");
            o.d(r1, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ KeyguardManager invoke() {
            return a();
        }
    }

    static {
        f8106a = new d();
        f8107b = new LinkedHashMap();
        f8108c = kotlin.i.b(C0218d.f8123f);
    }

    private d() {
    }

    public static final /* synthetic */ KeyguardManager a(d r0) {
        return r0.b();
    }

    private final KeyguardManager b() {
        return (KeyguardManager) f8108c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, com.obric.capabilitykit.common.BaseResult] */
    /* JADX WARN: Type inference failed for: r4v24, types: [T, com.obric.capabilitykit.common.BaseResult] */
    /* JADX WARN: Type inference failed for: r9v13, types: [T, com.google.gson.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3, types: [T, com.google.gson.m] */
    /* JADX WARN: Type inference failed for: r9v6, types: [T, com.google.gson.m, java.lang.Object] */
    public final Object c(IMAppAction r25, kotlin.k0.d<? super BaseResult> r26) {
        IMAppAction r0 = r25;
        if ((r26 instanceof a) == false) goto L7;
        a r2 = (a) r26;
        int r3 = r2.m;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.m = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f8114k;
        Object r4 = kotlin.k0.i.b.c();
        int r5 = r2.m;
        if (r5 == 0) goto L17;
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        d0 r6 = (d0) r2.f8109f;
        w.b(r1);
    L54:
        return r6.f18431f;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d0 r7 = (d0) r2.f8113j;
        d0 r8 = (d0) r2.f8112i;
        BaseFunction r9 = (BaseFunction) r2.f8111h;
        DispatchContext r10 = (DispatchContext) r2.f8110g;
        IMAppAction r11 = (IMAppAction) r2.f8109f;
        w.b(r1);
        d0 r12 = r7;
        r0 = r11;
    L43:
        ?? r13 = (BaseResult) r1;
        IMAppAction r14 = r0;
        r6 = r8;
        r12.f18431f = r13;
        if (r6.f18431f != 0) goto L50;
        String r15 = com.obric.capabilitykit.j.c.f8150a.a().getString(i.f8140a);
        o.e(r15, "AppHost.application.getS…tring.action_exe_success)");
        r6.f18431f = new BaseResult(null, null, 0, r15, null, 0, null, null, 243, null);
    L50:
        ((BaseResult) r6.f18431f).setQuestionId(r14.getQuestionId());
        ((BaseResult) r6.f18431f).setReplyId(r14.getMessageId());
        ((BaseResult) r6.f18431f).setReplyFor(r9.getName());
        i2 r16 = b1.c();
        b r17 = new b(r6, r10, null);
        r2.f8109f = r6;
        r2.f8110g = null;
        r2.f8111h = null;
        r2.f8112i = null;
        r2.f8113j = null;
        r2.m = 3;
        if (h.a.h.e(r16, r17, r2) != r4) goto L54;
        return r4;
    L17:
        w.b(r1);
        com.obric.capabilitykit.k.c.f8155a.a("ActionManager", "handleAction questionId:" + r25.getQuestionId());
        String r18 = r25.getContent();
        if (r18 != null) goto L20;
    L23:
        boolean r19 = true;
    L24:
        if (r19 == false) goto L26;
        m r20 = new m();
    L27:
        d0 r21 = new d0();
        r21.f18431f = new m();
        j r22 = r20.v("Params");     // Catch: Exception -> L32
        if (r22.n() == true) goto L33;
        ?? r23 = com.obric.capabilitykit.corecommon.b.f8105a.c(r22.l()).c();     // Catch: Exception -> L32
        o.e(r23, "JsonParserExt.parseStrin…tr.asString).asJsonObject");     // Catch: Exception -> L32
        r21.f18431f = r23;     // Catch: Exception -> L32
    L33:
        String r24 = r20.v("OperationId").l();
        DispatchContext r27 = new DispatchContext(com.obric.capabilitykit.j.c.f8150a.a(), r25.getQuestionId());
        BaseFunction r28 = f8107b.get(r24);
        String r110 = r27.getContext().getString(i.f8142c);
        o.e(r110, "dispatchContext.context.…tring.action_not_support)");
        if (r28 == null) goto L36;
        r12 = new d0();
        if (r28.isBlock() == false) goto L44;
        m r29 = ((m) r21.f18431f).c();
        o.e(r29, "params.asJsonObject");
        r2.f8109f = r0;
        r2.f8110g = r27;
        r2.f8111h = r28;
        r2.f8112i = r12;
        r2.f8113j = r12;
        r2.m = 1;
        Object r30 = r28.doAction(r29, r27, r2);
        if (r30 != r4) goto L42;
        return r4;
    L42:
        r9 = r28;
        r1 = r30;
        r10 = r27;
        r8 = r12;
        goto L43
    L44:
        c r31 = new c(r28, r21, r27, null);
        r2.f8109f = r0;
        r2.f8110g = r27;
        r2.f8111h = r28;
        r2.f8112i = r12;
        r2.f8113j = r12;
        r2.m = 2;
        r30 = y2.c(WsConstants.EXIT_DELAY_TIME, r31, r2);
        if (r30 != r4) goto L42;
        return r4;
    L36:
        return new BaseResult(r25.getQuestionId(), r25.getMessageId(), 1, r110, null, 0, null, null, 224, null);
    L32:
        ?? r32 = com.obric.capabilitykit.corecommon.b.f8105a.c("{}").c();
        o.e(r32, "JsonParserExt.parseString(\"{}\").asJsonObject");
        r21.f18431f = r32;
        goto L33
    L26:
        r20 = com.obric.capabilitykit.corecommon.b.f8105a.c(r25.getContent()).c();
        goto L27
    L20:
        if (r18.length() == 0) goto L23;
        r19 = false;
    L7:
        r2 = new a(this, r26);
        goto L8
    }
}
