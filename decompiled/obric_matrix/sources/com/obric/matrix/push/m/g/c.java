package com.obric.matrix.push.m.g;

import android.graphics.Bitmap;
import android.util.LruCache;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/push/base/img/BitmapLruCache;", "", "()V", "mbitmapLruCache", "com/obric/matrix/push/base/img/BitmapLruCache$mbitmapLruCache$2$1", "getMbitmapLruCache", "()Lcom/obric/matrix/push/base/img/BitmapLruCache$mbitmapLruCache$2$1;", "mbitmapLruCache$delegate", "Lkotlin/Lazy;", "get", "Landroid/graphics/Bitmap;", "uri", "", "put", "", "bitmap", "Companion", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.h f9685a;

    @Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/obric/matrix/push/base/img/BitmapLruCache$mbitmapLruCache$2$1", "invoke", "()Lcom/obric/matrix/push/base/img/BitmapLruCache$mbitmapLruCache$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<C0270a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9686f = null;

        /* JADX INFO: renamed from: com.obric.matrix.push.m.g.c$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¨\u0006\b"}, d2 = {"com/obric/matrix/push/base/img/BitmapLruCache$mbitmapLruCache$2$1", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "sizeOf", "", "key", "value", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class C0270a extends LruCache<String, Bitmap> {
            C0270a() {
                super(4096);
            }

            protected int a(String r1, Bitmap r2) {
                o.f(r1, "key");
                o.f(r2, "value");
                int r0 = r2.getAllocationByteCount();     // Catch: Throwable -> L5
            L7:
                return kotlin.r0.e.c(r0 / 1024, 1);
            L5:
                r0 = r2.getByteCount();
                goto L7
            }

            @Override // android.util.LruCache
            public /* bridge */ /* synthetic */ int sizeOf(String r1, Bitmap r2) {
                return a(r1, r2);
            }
        }

        static {
            f9686f = new a();
        }

        a() {
            super(0);
        }

        public final C0270a a() {
            return new C0270a();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ C0270a invoke() {
            return a();
        }
    }

    static {
    }

    public c() {
        this.f9685a = kotlin.i.b(a.f9686f);
    }

    private final a.C0270a b() {
        return (a.C0270a) this.f9685a.getValue();
    }

    public final synchronized Bitmap a(String r2) {
        monitor-enter(this);
        o.f(r2, "uri");     // Catch: Throwable -> L6
        Bitmap r3 = b().get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(String r2, Bitmap r3) {
        monitor-enter(this);
        o.f(r2, "uri");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        b().put(r2, r3);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
