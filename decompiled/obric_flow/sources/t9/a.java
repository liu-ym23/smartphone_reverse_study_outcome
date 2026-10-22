package t9;

import ai.j0;
import android.graphics.Bitmap;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.f;
import com.bytedance.sliver.c;
import com.bytedance.ttnet.diagnosis.IDiagnosisCallback;
import com.bytedance.ttnet.diagnosis.TTGameDiagnosisService;
import com.google.common.reflect.w;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.t;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.d;
import org.threeten.bp.temporal.i;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b0.a, com.bumptech.glide.load.engine.bitmap_recycle.a, f, c, bi.a, t, i, IDiagnosisCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f22110a;

    public static a i() {
        if (f22110a != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22110a != null) goto L11;
        f22110a = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f22110a;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public Bitmap a(int r5, int r10, Bitmap.Config r11) {
        return Bitmap.createBitmap(r5, r10, r11);
    }

    public void b(Bitmap r5) {
        r5.recycle();
    }

    @Override // b0.a
    public void c(z.c r5, w r10) {
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(d r5) {
        return ZoneOffset.from(r5);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public void e(int r5) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public void f() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public Bitmap g(int r5, int r10, Bitmap.Config r11) {
        return Bitmap.createBitmap(r5, r10, r11);
    }

    @Override // b0.a
    public File h(z.c r5) {
        return null;
    }

    @Override // okhttp3.t
    public List lookup(String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostname");
        return ArraysKt.toList(InetAddress.getAllByName(r5));
    L5:
        e = move-exception;
        UnknownHostException r10 = new UnknownHostException(j0.C("Broken system behaviour for dns lookup of ", r5));
        r10.initCause(e);
        throw r10;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisCallback
    public void onDiagnosisComplete(String r5) {
        if (Logger.debug() == false) goto L6;
        kotlin.collections.a.n("onDiagnosisComplete: ", r5, TTGameDiagnosisService.access$000());
        return;
    }
}
