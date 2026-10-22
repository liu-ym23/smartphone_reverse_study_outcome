package wc;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes2.dex */
public class f implements k, dc.a, bi.a, ko.g, pt.g, de.d, i, zp.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22835a;

    public /* synthetic */ f(int r5) {
        this.f22835a = r5;
    }

    public static void g(String r5) {
        Log.d("librarian", r5);
    }

    @Override // dc.a
    public void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(r5, LogLevel.d, "XResourceLoader");
    }

    @Override // pt.g
    public void accept(Object r5) {
    }

    @Override // dc.a
    public void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(r5, LogLevel.f5953a, "XResourceLoader");
    }

    @Override // dc.a
    public void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(r5, LogLevel.f5955c, "XResourceLoader");
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        switch(this.f22835a) {
            case 13: goto L7;
            default: goto L5;
        };
    L5:
        return org.threeten.bp.chrono.i.from(r5);
    L7:
        return DayOfWeek.from(r5);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.k
    public void e() {
    }

    public boolean f(String r5) {
        return true;
    }

    @Override // bi.a
    public bi.b get() {
        return new r9.c(17);
    }

    public String toString() {
        switch(this.f22835a) {
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        return "EmptyConsumer";
    L5:
        return super.toString();
    }

    @Override // dc.a
    public void a(String r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r10, "tr");
        com.bytedance.ies.bullet.service.base.b.g(r5, "XResourceLoader", r10);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.k
    public void a(Bitmap r5, com.bumptech.glide.load.engine.bitmap_recycle.a r10) {
    }
}
