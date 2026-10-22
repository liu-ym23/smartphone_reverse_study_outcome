package com.obric.capabilitykit.corecommon;

import android.os.IInterface;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0014B#\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J0\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/corecommon/BinderExceptionHandlerProxy;", "T", "Landroid/os/IInterface;", "Ljava/lang/reflect/InvocationHandler;", TypedValues.AttributesType.S_TARGET, LocationMonitorConst.TAG, "", "targetClass", "Ljava/lang/Class;", "(Landroid/os/IInterface;Ljava/lang/String;Ljava/lang/Class;)V", "Landroid/os/IInterface;", "getDefaultReturnValue", "", "method", "Ljava/lang/reflect/Method;", "invoke", "proxy", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Companion", "capabilitykitcorecommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a<T extends IInterface> implements InvocationHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0217a f8101i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final T f8102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f8103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Class<T> f8104h;

    /* JADX INFO: renamed from: com.obric.capabilitykit.corecommon.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0001\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/corecommon/BinderExceptionHandlerProxy$Companion;", "", "()V", "createProxyInstance", "T", "Landroid/os/IInterface;", "api", LocationMonitorConst.TAG, "", "(Landroid/os/IInterface;Ljava/lang/String;)Landroid/os/IInterface;", "capabilitykitcorecommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0217a {
        private C0217a() {
        }

        public /* synthetic */ C0217a(g r1) {
            this();
        }
    }

    static {
        f8101i = new C0217a(null);
    }

    public a(T r2, String r3, Class<T> r4) {
        o.f(r2, TypedValues.AttributesType.S_TARGET);
        o.f(r3, LocationMonitorConst.TAG);
        o.f(r4, "targetClass");
        this.f8102f = r2;
        this.f8103g = r3;
        this.f8104h = r4;
    }

    private final Object a(Method r2) {
        Class<?> r1 = r2.getReturnType();
        if (o.a(r1, Boolean.TYPE) == false) goto L6;
        return Boolean.FALSE;
    L6:
        if (o.a(r1, Character.TYPE) == false) goto L9;
        return (char) 0;
    L9:
        if (o.a(r1, Byte.TYPE) == false) goto L12;
        return (byte) 0;
    L12:
        if (o.a(r1, Short.TYPE) == false) goto L15;
        return (short) 0;
    L15:
        if (o.a(r1, Integer.TYPE) == false) goto L18;
        return 0;
    L18:
        if (o.a(r1, Long.TYPE) == false) goto L21;
        return 0L;
    L21:
        if (o.a(r1, Float.TYPE) == false) goto L24;
        return Float.valueOf(0.0f);
    L24:
        if (o.a(r1, Double.TYPE) == false) goto L27;
        return Double.valueOf(0.0d);
    L27:
        if (o.a(r1, Void.class) == true) goto L39;
        return null;
    L39:
        return f0.f18324a;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r3, Method r4, Object[] r5) {
        o.f(r3, "proxy");
        o.f(r4, "method");
    L17:
        th = move-exception;
        Log.e(this.f8103g, "BinderExceptionHandlerProxy " + r4.getName() + " throw exception: " + kotlin.a.b(th));
        return a(r4);
    L4:
        if (o.a(r4.getDeclaringClass(), this.f8104h) == true) goto L10;
        T r6 = this.f8102f;     // Catch: Throwable -> L17
        if (r5 != null) goto L21;
        r5 = new Object[0];     // Catch: Throwable -> L17
    L21:
        return r4.invoke(r6, Arrays.copyOf(r5, r5.length));
    L10:
        if (this.f8102f.asBinder().isBinderAlive() == false) goto L15;
        T r7 = this.f8102f;     // Catch: Throwable -> L17
        if (r5 != null) goto L22;
        r5 = new Object[0];     // Catch: Throwable -> L17
    L22:
        return r4.invoke(r7, Arrays.copyOf(r5, r5.length));
    L15:
        Log.e(this.f8103g, "BinderExceptionHandlerProxy " + r4.getName() + " fail. Binder is already died.");     // Catch: Throwable -> L17
        return a(r4);
    }
}
