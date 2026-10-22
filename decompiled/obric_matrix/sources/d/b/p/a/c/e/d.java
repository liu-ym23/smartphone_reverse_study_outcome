package d.b.p.a.c.e;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f14225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static LinkedList<Runnable> f14226b;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Message f14227f;

        a(Message r1) {
            this.f14227f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14227f.sendToTarget();
        }
    }

    static class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r2) {
            if (r2.what != 1) goto L9;
            Log.d("LinkedListForWorks", "Hint the message MSG_RUN.");
            d.a();     // Catch: ConcurrentModificationException -> L7
        L7:
            e = move-exception;
            Log.d("QueuedWorkProxyAboveO", e.toString());
        L9:
            return true;
        }
    }

    static /* synthetic */ void a() {
        c();
    }

    private static void b(Handler r2) {
        if (r2 != null) goto L14;
        return;
    L14:
        Field r0 = d.b.p.a.h.a.a(Class.forName(Handler.class.getName()), "mCallback");     // Catch: ClassNotFoundException -> L9 IllegalAccessException -> L11
        if (r0 != null) goto L7;
        return;
    L7:
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 IllegalAccessException -> L11
        r0.set(r2, new b());     // Catch: ClassNotFoundException -> L9 IllegalAccessException -> L11
    L17:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    private static void c() {
        if (f14225a == null) goto L13;
        LinkedList<Runnable> r0 = f14226b;
        if (r0 == null) goto L16;
        LinkedList r1 = (LinkedList) r0.clone();
        f14226b.clear();
        f14225a.removeMessages(1);
        if (r1.size() <= 0) goto L15;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        ((Runnable) r2.next()).run();
        goto L11
    L17:
        return;
    L15:
        return;
    L16:
        return;
    }

    public static void d() {
        Handler r0 = f14225a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasMessages(1) == true) goto L7;
        Log.d("LinkedListForWorks", "Handler in QueuedWork has no MSG_RUN message,so we send one.");
        Message r1 = Message.obtain(f14225a);
        r1.what = 1;
        new Handler().post(new a(r1));
        return;
    L7:
        Log.d("LinkedListForWorks", "Handler in QueuedWork has MSG_RUN message,no need to send one.");
    }

    public static void e() {
        if (Build.VERSION.SDK_INT <= 29) goto L26;
        return;
    L26:
        Class<?> r1 = Class.forName("android.app.QueuedWork");     // Catch: Exception -> L22
        Field r2 = d.b.p.a.h.a.a(r1, "sFinishers");     // Catch: Exception -> L22
        if (r2 != null) goto L8;
        return;
    L8:
        r2.setAccessible(true);     // Catch: Exception -> L22
        LinkedList r5 = (LinkedList) r2.get(null);     // Catch: Exception -> L22
        if (r5 == null) goto L11;
        r2.set(null, new d.b.p.a.c.e.b(r5));     // Catch: Exception -> L22
    L11:
        Field r3 = d.b.p.a.h.a.a(r1, "sWork");     // Catch: Exception -> L22
        if (r3 != null) goto L14;
        return;
    L14:
        r3.setAccessible(true);     // Catch: Exception -> L22
        LinkedList r6 = (LinkedList) r3.get(null);     // Catch: Exception -> L22
        if (r6 == null) goto L17;
        c r7 = new c(r6);     // Catch: Exception -> L22
        f14226b = r7;     // Catch: Exception -> L22
        r3.set(null, r7);     // Catch: Exception -> L22
    L17:
        Method r4 = d.b.p.a.h.d.a(r1, "getHandler", new Class[0]);     // Catch: Exception -> L22
        if (r4 != null) goto L20;
        return;
    L20:
        r4.setAccessible(true);     // Catch: Exception -> L22
        Handler r8 = (Handler) r4.invoke(null, new Object[0]);     // Catch: Exception -> L22
        f14225a = r8;     // Catch: Exception -> L22
        b(r8);     // Catch: Exception -> L22
        Log.d("QueuedWkPyAOrEAndroid0", "Above android 0,replaceQueueWorkPendingWorkFinishers success.");     // Catch: Exception -> L22
    L24:
        Log.d("QueuedWkPyAOrEAndroid0", "end hook, time stamp = " + System.currentTimeMillis());
        return;
    L22:
        e = move-exception;
        Log.e("QueuedWkPyAOrEAndroid0", "Above android 0, hook sPendingWorkFinishers fail.", e);
        goto L24
    }
}
