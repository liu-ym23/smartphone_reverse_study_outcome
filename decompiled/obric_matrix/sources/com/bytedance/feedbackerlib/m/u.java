package com.bytedance.feedbackerlib.m;

import android.graphics.Rect;
import android.graphics.Region;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f4321a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<c, Object> f4322b = null;

    static class a implements InvocationHandler {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f4323f;

        a(c r1) {
            this.f4323f = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r6, Method r7, Object[] r8) {
            if (r7 != null) goto L5;
        L34:
            return null;
        L5:
            if (TextUtils.isEmpty(r7.getName()) == true) goto L34;
            String r1 = r7.getName();
            r1.hashCode();
            boolean r3 = false;
            if (r1.equals("onComputeInternalInsets") == false) goto L10;
            if (r8 != null) goto L25;
        L33:
            return r7.invoke(this.f4323f, r8);
        L25:
            if (r8.length != 1) goto L33;
            Object r9 = r8[0];
            if (r9 == null) goto L33;
            b r10 = new b();
            b.a(r10, r9);
            this.f4323f.a(r10);
            b.b(r10, r9);
            return null;
        L10:
            if (r1.equals("equals") == false) goto L33;
            if (r8 == null) goto L22;
            if (r8.length != 1) goto L22;
            if (r6 != r8[0]) goto L20;
            r3 = true;
        L20:
            return Boolean.valueOf(r3);
        L22:
            return Boolean.FALSE;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f4324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f4325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Region f4326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4327d;

        public b() {
            this.f4324a = new Rect();
            this.f4325b = new Rect();
            this.f4326c = new Region();
        }

        static /* synthetic */ void a(b r0, Object r1) {
            r0.c(r1);
        }

        static /* synthetic */ void b(b r0, Object r1) {
            r0.f(r1);
        }

        private void c(@NonNull Object r5) {
            Rect r0 = (Rect) d.c(r5, "contentInsets");     // Catch: Throwable -> L4
            Rect r1 = (Rect) d.c(r5, "visibleInsets");     // Catch: Throwable -> L4
            Region r2 = (Region) d.c(r5, "touchableRegion");     // Catch: Throwable -> L4
            int r6 = ((Integer) d.c(r5, "mTouchableInsets")).intValue();     // Catch: Throwable -> L4
            this.f4324a.set(r0);     // Catch: Throwable -> L4
            this.f4325b.set(r1);     // Catch: Throwable -> L4
            this.f4326c.set(r2);     // Catch: Throwable -> L4
            this.f4327d = r6;     // Catch: Throwable -> L4
            return;
        L5:
            throw new RuntimeException("cannot read from internal insets info");
        }

        private void f(@NonNull Object r6) {
            Rect r1 = (Rect) d.c(r6, "contentInsets");     // Catch: Throwable -> L5
            Rect r2 = (Rect) d.c(r6, "visibleInsets");     // Catch: Throwable -> L5
            Region r3 = (Region) d.c(r6, "touchableRegion");     // Catch: Throwable -> L5
            ((Integer) d.c(r6, "mTouchableInsets")).intValue();     // Catch: Throwable -> L5
            r1.set(this.f4324a);     // Catch: Throwable -> L5
            r2.set(this.f4325b);     // Catch: Throwable -> L5
            r3.set(this.f4326c);     // Catch: Throwable -> L5
            d.e(r6, "mTouchableInsets", Integer.valueOf(this.f4327d));     // Catch: Throwable -> L5
            return;
        L6:
            throw new RuntimeException("cannot write to internal insets info");
        }

        public void d(int r1) {
            this.f4327d = r1;
        }

        public void e(Region r1) {
            if (r1 != null) goto L4;
            return;
        L4:
            this.f4326c.set(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L21:
            return false;
        L8:
            if (b.class != r5.getClass()) goto L21;
            b r6 = (b) r5;
            if (this.f4327d != r6.f4327d) goto L20;
            if (this.f4324a.equals(r6.f4324a) == false) goto L20;
            if (this.f4325b.equals(r6.f4325b) == false) goto L20;
            if (this.f4326c.equals(r6.f4326c) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return (((((this.f4324a.hashCode() * 31) + this.f4325b.hashCode()) * 31) + this.f4326c.hashCode()) * 31) + this.f4327d;
        }
    }

    public interface c {
        void a(b r1);
    }

    static {
        f4322b = new HashMap();
        f4321a = Class.forName("android.view.ViewTreeObserver$OnComputeInternalInsetsListener");     // Catch: Throwable -> L5
        return;
    L6:
        throw new RuntimeException("cannot load OnComputeInternalInsetsListener");
    }

    public u() {
    }

    public static void a(@NonNull ViewTreeObserver r5, @NonNull c r6) {
        if (r5 == null) goto L10;
        if (r6 == null) goto L13;
        Object r0 = Proxy.newProxyInstance(u.class.getClassLoader(), new Class[]{f4321a}, new a(r6));
        f4322b.put(r6, r0);
        k.d(r5, "addOnComputeInternalInsetsListener", new Object[]{r0});     // Catch: Throwable -> L8
        return;
    L9:
        throw new RuntimeException("cannot addOnComputeInternalInsetsListener");
    L13:
        return;
    }

    public static void b(@NonNull ViewTreeObserver r3, @NonNull c r4) {
        Object r5 = f4322b.get(r4);
        if (r5 != null) goto L9;
        return;
    L9:
        k.d(r3, "removeOnComputeInternalInsetsListener", new Object[]{r5});     // Catch: Throwable -> L7
        return;
    L8:
        throw new RuntimeException("cannot removeOnComputeInternalInsetsListener");
    }
}
