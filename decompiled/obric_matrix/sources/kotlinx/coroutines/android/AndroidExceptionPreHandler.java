package kotlinx.coroutines.android;

import android.os.Build;
import androidx.annotation.Keep;
import h.a.h0;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.k0.g;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AndroidExceptionPreHandler extends kotlin.k0.a implements h0 {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(h0.f17446c);
        this._preHandler = this;
    }

    private final Method preHandler() {
        Object r0 = this._preHandler;
        if (r0 != this) goto L5;
        Method r1 = null;
        boolean r3 = false;
        Method r2 = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);     // Catch: Throwable -> L16
        if (Modifier.isPublic(r2.getModifiers()) == false) goto L12;
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L12;
        r3 = true;
    L12:
        if (r3 == false) goto L14;
        r1 = r2;
    L14:
        this._preHandler = r1;
        return r1;
    L5:
        return (Method) r0;
    }

    @Override // h.a.h0
    public void handleException(g r3, Throwable r4) {
        int r5 = Build.VERSION.SDK_INT;
        if (26 <= r5) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L20;
        Method r2 = preHandler();
        Thread.UncaughtExceptionHandler r7 = null;
        if (r2 != null) goto L12;
        Object r8 = null;
    L14:
        if ((r8 instanceof Thread.UncaughtExceptionHandler) == false) goto L16;
        r7 = (Thread.UncaughtExceptionHandler) r8;
    L16:
        if (r7 == null) goto L21;
        r7.uncaughtException(Thread.currentThread(), r4);
        return;
    L21:
        return;
    L12:
        r8 = r2.invoke(null, new Object[0]);
        goto L14
    L20:
        return;
    L5:
        if (r5 >= 28) goto L7;
        r6 = true;
        goto L8
    }
}
