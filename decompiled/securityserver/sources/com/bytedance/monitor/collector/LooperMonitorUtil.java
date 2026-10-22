package com.bytedance.monitor.collector;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import com.bytedance.monitor.util.unsafe.UnsafeProxy;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class LooperMonitorUtil {
    public static Message mainMessages;
    private static ProxyFrameHandler proxyFrameHandler;
    private static ProxyH proxyH;
    private static Handler sFrameHandler;
    private static Handler sHandler;

    public static class ProxyFrameHandler extends Handler {
        public ProxyFrameHandler() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message r2) {
            if (r2.getCallback() == null) goto L5;
            super.dispatchMessage(r2);
            return;
        L5:
            super.dispatchMessage(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message r1) {
            LooperMonitorUtil.access$000().handleMessage(r1);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r1, long r2) {
            return super.sendMessageAtTime(r1, r2);
        }
    }

    public static class ProxyH extends Handler {
        public ProxyH() {
        }

        public String codeToString(int r1) {
            return Integer.toString(r1);
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message r1) {
            super.dispatchMessage(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            LooperMonitorUtil.access$100().handleMessage(r1);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(@NonNull Message r1, long r2) {
            return super.sendMessageAtTime(r1, r2);
        }
    }

    static {
        proxyH = new ProxyH();
        proxyFrameHandler = new ProxyFrameHandler();
        mainMessages = Message.obtain();
    }

    public LooperMonitorUtil() {
    }

    public static /* synthetic */ Handler access$000() {
        return sFrameHandler;
    }

    public static /* synthetic */ Handler access$100() {
        return sHandler;
    }

    public static void init() {
        Class<?> r0 = Class.forName("android.app.ActivityThread");     // Catch: Exception -> L4
        Method r1 = r0.getDeclaredMethod("currentActivityThread", null);     // Catch: Exception -> L4
        r1.setAccessible(true);     // Catch: Exception -> L4
        Object r2 = r1.invoke(null, null);     // Catch: Exception -> L4
        Field r3 = r0.getDeclaredField("mH");     // Catch: Exception -> L4
        r3.setAccessible(true);     // Catch: Exception -> L4
        sHandler = (Handler) r3.get(r2);     // Catch: Exception -> L4
        UnsafeProxy.putObject(r2, UnsafeProxy.objectFieldOffset(r3), proxyH);     // Catch: Exception -> L4
        Choreographer r4 = Choreographer.getInstance();     // Catch: Exception -> L4
        Class<?> r5 = r4.getClass();     // Catch: Exception -> L4
        Method r6 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Exception -> L4
        Field r7 = (Field) r6.invoke(r5, new Object[]{"mHandler"});     // Catch: Exception -> L4
        r7.setAccessible(true);     // Catch: Exception -> L4
        sFrameHandler = (Handler) r7.get(r4);     // Catch: Exception -> L4
        UnsafeProxy.putObject(r4, UnsafeProxy.objectFieldOffset(r7), proxyFrameHandler);     // Catch: Exception -> L4
        Looper r8 = Looper.getMainLooper();     // Catch: Exception -> L4
        Field r9 = (Field) r6.invoke(r8.getClass(), new Object[]{"mQueue"});     // Catch: Exception -> L4
        r9.setAccessible(true);     // Catch: Exception -> L4
        MessageQueue r10 = (MessageQueue) r9.get(r8);     // Catch: Exception -> L4
        Field r11 = (Field) r6.invoke(r10.getClass(), new Object[]{"mMessages"});     // Catch: Exception -> L4
        r11.setAccessible(true);     // Catch: Exception -> L4
        mainMessages = (Message) r11.get(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        EnsureManager.getEnsureImpl().ensureNotReachHere(e, "LooperMonitorUtil init error");
    }
}
