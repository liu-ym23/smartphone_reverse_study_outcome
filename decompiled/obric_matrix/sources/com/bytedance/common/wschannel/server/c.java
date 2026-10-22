package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0106c f3727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? extends com.bytedance.common.wschannel.client.a> f3728b;

    static /* synthetic */ class a {
    }

    private class b implements InterfaceC0106c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f3729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f3730b;

        b(c r1, Context r2) {
            this.f3730b = r1;
            this.f3729a = r2;
        }

        @Override // com.bytedance.common.wschannel.server.c.InterfaceC0106c
        public void a(Intent r4) {
            r4.setComponent(new ComponentName(this.f3729a, c.a(this.f3730b)));     // Catch: Throwable -> L4
            this.f3729a.startService(r4);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.bytedance.common.wschannel.server.c.InterfaceC0106c
        public void c() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.c$c, reason: collision with other inner class name */
    public interface InterfaceC0106c {
        void a(Intent r1);

        void c();
    }

    private class d implements InterfaceC0106c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f3731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Messenger f3732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LinkedBlockingDeque<Intent> f3733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ServiceConnection f3734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f3735e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f3736f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Runnable f3737g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Runnable f3738h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicInteger f3739i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ c f3740j;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f3741f;

            a(d r1) {
                this.f3741f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object r0 = d.b(this.f3741f);
                monitor-enter(r0);
                Logger.d("WsChannelSdk", "mBindServiceTimeoutRunnable run");     // Catch: Throwable -> L9
                if (d.d(this.f3741f) == false) goto L7;
                d.e(this.f3741f, false);     // Catch: Throwable -> L9
            L7:
                monitor-exit(r0);     // Catch: Throwable -> L9
                return;
            L9:
                th = move-exception;
                throw th;
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f3742f;

            b(d r1) {
                this.f3742f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                /*  JADX ERROR: Simple mode code generation failed
                    java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                    	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                    	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    this = this;
                    com.bytedance.common.wschannel.server.c$d r0 = r3.f3742f
                    java.lang.Object r0 = com.bytedance.common.wschannel.server.c.d.b(r0)
                    monitor-enter(r0)
                    com.bytedance.common.wschannel.server.c$d r1 = r3.f3742f     // Catch: java.lang.Throwable -> L33
                    android.content.ServiceConnection r1 = com.bytedance.common.wschannel.server.c.d.f(r1)     // Catch: java.lang.Throwable -> L33
                    if (r1 == 0) goto L37
                    com.bytedance.common.wschannel.server.c$d r1 = r3.f3742f     // Catch: java.lang.Throwable -> L33
                    android.content.Context r1 = com.bytedance.common.wschannel.server.c.d.h(r1)     // Catch: java.lang.Throwable -> L33
                    com.bytedance.common.wschannel.server.c$d r2 = r3.f3742f     // Catch: java.lang.Throwable -> L33
                    com.bytedance.common.wschannel.server.c r2 = r2.f3740j     // Catch: java.lang.Throwable -> L33
                    java.lang.Class r2 = com.bytedance.common.wschannel.server.c.a(r2)     // Catch: java.lang.Throwable -> L33
                    boolean r1 = com.bytedance.common.wschannel.u.c.l(r1, r2)     // Catch: java.lang.Throwable -> L33
                    if (r1 == 0) goto L37
                    com.bytedance.common.wschannel.server.c$d r1 = r3.f3742f     // Catch: java.lang.Throwable -> L33
                    android.content.Context r1 = com.bytedance.common.wschannel.server.c.d.h(r1)     // Catch: java.lang.Throwable -> L33
                    com.bytedance.common.wschannel.server.c$d r2 = r3.f3742f     // Catch: java.lang.Throwable -> L33
                    android.content.ServiceConnection r2 = com.bytedance.common.wschannel.server.c.d.f(r2)     // Catch: java.lang.Throwable -> L33
                    r1.unbindService(r2)     // Catch: java.lang.Throwable -> L33
                    goto L37
                L33:
                    r1 = move-exception
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L4b
                L37:
                    com.bytedance.common.wschannel.server.c$d r1 = r3.f3742f     // Catch: java.lang.Throwable -> L4b
                    r2 = 0
                    com.bytedance.common.wschannel.server.c.d.g(r1, r2)     // Catch: java.lang.Throwable -> L4b
                    com.bytedance.common.wschannel.server.c$d r3 = r3.f3742f     // Catch: java.lang.Throwable -> L4b
                    com.bytedance.common.wschannel.server.c.d.i(r3, r2)     // Catch: java.lang.Throwable -> L4b
                    java.lang.String r3 = "WsChannelSdk"
                    java.lang.String r1 = "mDisconnectRunnable timeout"
                    com.bytedance.common.utility.Logger.d(r3, r1)     // Catch: java.lang.Throwable -> L4b
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L4b
                    return
                L4b:
                    r3 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L4b
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.wschannel.server.c.d.b.run():void");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.c$d$c, reason: collision with other inner class name */
        private class ServiceConnectionC0107c implements ServiceConnection {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f3743f;

            private ServiceConnectionC0107c(d r1) {
                this.f3743f = r1;
            }

            /* synthetic */ ServiceConnectionC0107c(d r1, a r2) {
                this(r1);
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r4, IBinder r5) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceConnected name = " + r4.toString());
            L5:
                Object r0 = d.b(this.f3743f);
                monitor-enter(r0);
                d.k(this.f3743f);     // Catch: Throwable -> L20
                if (r4 == null) goto L18;
                if (r5 == null) goto L18;
                d.i(this.f3743f, new Messenger(r5));     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceConnected set service");     // Catch: Throwable -> L13
                d.l(this.f3743f);     // Catch: Throwable -> L13
            L15:
                Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");     // Catch: Throwable -> L20
                d.e(this.f3743f, false);     // Catch: Throwable -> L20
                monitor-exit(r0);     // Catch: Throwable -> L20
                return;
            L13:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L20
            L18:
                monitor-exit(r0);     // Catch: Throwable -> L20
                return;
            L20:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r4) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r4.toString());
            L5:
                Object r0 = d.b(this.f3743f);
                monitor-enter(r0);
                if (r4 != null) goto L10;
                monitor-exit(r0);     // Catch: Throwable -> L13
                return;
            L10:
                Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");     // Catch: Throwable -> L13
                d.i(this.f3743f, null);     // Catch: Throwable -> L13
                d.g(this.f3743f, null);     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");     // Catch: Throwable -> L13
                d.e(this.f3743f, false);     // Catch: Throwable -> L13
                d.j(this.f3743f);     // Catch: Throwable -> L13
                d.k(this.f3743f);     // Catch: Throwable -> L13
                monitor-exit(r0);     // Catch: Throwable -> L13
                return;
            L13:
                th = move-exception;
                throw th;
            }
        }

        d(c r2, Context r3) {
            this.f3740j = r2;
            this.f3733c = new LinkedBlockingDeque();
            this.f3735e = false;
            this.f3736f = new Object();
            this.f3737g = new a(this);
            this.f3738h = new b(this);
            this.f3739i = new AtomicInteger(0);
            this.f3731a = r3;
        }

        static /* synthetic */ Object b(d r0) {
            return r0.f3736f;
        }

        static /* synthetic */ boolean d(d r0) {
            return r0.f3735e;
        }

        static /* synthetic */ boolean e(d r0, boolean r1) {
            r0.f3735e = r1;
            return r1;
        }

        static /* synthetic */ ServiceConnection f(d r0) {
            return r0.f3734d;
        }

        static /* synthetic */ ServiceConnection g(d r0, ServiceConnection r1) {
            r0.f3734d = r1;
            return r1;
        }

        static /* synthetic */ Context h(d r0) {
            return r0.f3731a;
        }

        static /* synthetic */ Messenger i(d r0, Messenger r1) {
            r0.f3732b = r1;
            return r1;
        }

        static /* synthetic */ void j(d r0) {
            r0.p();
        }

        static /* synthetic */ void k(d r0) {
            r0.o();
        }

        static /* synthetic */ void l(d r0) {
            r0.n();
        }

        private void m() {
            if (Logger.debug() == false) goto L14;
            Logger.d("WsChannelSdk", "doBindService");
        L14:
            this.f3731a.startService(new Intent(this.f3731a, c.a(this.f3740j)));     // Catch: Throwable -> L11
        L12:
            this.f3734d = new ServiceConnectionC0107c(this, null);     // Catch: Throwable -> L8
            this.f3731a.bindService(new Intent(this.f3731a, c.a(this.f3740j)), this.f3734d, 1);     // Catch: Throwable -> L8
            r();     // Catch: Throwable -> L8
            this.f3735e = true;     // Catch: Throwable -> L8
            Logger.d("WsChannelSdk", "doBindService, set mBinding = true");     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            o();
            this.f3735e = false;
            Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
            th.printStackTrace();
        }

        private void n() {
        L17:
        L14:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (this.f3733c.peek() == null) goto L12;
            Intent r0 = this.f3733c.poll();     // Catch: Throwable -> L14
            if (r0 == null) goto L6;
            q(r0);     // Catch: Throwable -> L9 DeadObjectException -> L11
        L11:
            Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");     // Catch: Throwable -> L14
            this.f3732b = null;     // Catch: Throwable -> L14
            this.f3733c.offerFirst(r0);     // Catch: Throwable -> L14
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L14
            goto L17
        L6:
            return;
        L12:
            s();     // Catch: Throwable -> L14
        }

        private void o() {
            com.bytedance.common.wschannel.h.b().a().removeCallbacks(this.f3737g);
        }

        private void p() {
            com.bytedance.common.wschannel.h.b().a().removeCallbacks(this.f3738h);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        private void q(Intent r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            Logger.d("WsChannelSdk", "sendMsg msg = " + r4);
        L7:
            Messenger r3 = this.f3732b;
            Message r0 = new Message();
            r0.what = WsConstants.MSG_INTENT;
            r0.getData().putParcelable(WsConstants.DATA_INTENT, r4);
            if (r3 != null) goto L10;
            return;
        L10:
            r3.send(r0);
        }

        private void r() {
            o();
            com.bytedance.common.wschannel.h.b().a().postDelayed(this.f3737g, TimeUnit.SECONDS.toMillis(7));
        }

        private synchronized void s() {
            monitor-enter(this);
            p();     // Catch: Throwable -> L6
            com.bytedance.common.wschannel.h.b().a().postDelayed(this.f3738h, TimeUnit.SECONDS.toMillis(10));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.common.wschannel.server.c.InterfaceC0106c
        public void a(Intent r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            r4.putExtra(WsConstants.MSG_COUNT, this.f3739i.addAndGet(1));
        L7:
            Object r0 = this.f3736f;
            monitor-enter(r0);
            p();     // Catch: Throwable -> L19
            this.f3733c.offer(r4);     // Catch: Throwable -> L19
            if (this.f3732b == null) goto L12;
            n();     // Catch: Throwable -> L19
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L12:
            if (this.f3735e == false) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L15:
            m();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.common.wschannel.server.c.InterfaceC0106c
        public void c() {
            if (this.f3733c.size() > 0) goto L5;
            return;
        L5:
            if (this.f3732b != null) goto L21;
            Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
            Object r0 = this.f3736f;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L9:
            if (this.f3733c.size() > 0) goto L11;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L11:
            if (this.f3732b != null) goto L13;
            m();     // Catch: Throwable -> L15
            goto L13
        }
    }

    public c(Context r3, Class<? extends com.bytedance.common.wschannel.client.a> r4) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L7:
        InterfaceC0106c r0 = new b(this, r3);
    L8:
        this.f3727a = r0;
        this.f3728b = r4;
        return;
    L5:
        if (r3.getApplicationInfo().targetSdkVersion < 26) goto L7;
        r0 = new d(this, r3);
        goto L8
    }

    static /* synthetic */ Class a(c r0) {
        return r0.f3728b;
    }

    public void b(Intent r1) {
        this.f3727a.a(r1);
    }

    public void c() {
        this.f3727a.c();
    }
}
