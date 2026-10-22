package y;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import d0.g;
import io.reactivex.internal.observers.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.connection.RealCall;
import okhttp3.j;
import okhttp3.n0;
import okhttp3.s0;
import okhttp3.w0;
import q0.c;

/* JADX INFO: loaded from: classes.dex */
public final class a implements e, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f23222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f23223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f23224c;
    public w0 d;
    public d e;
    public volatile RealCall f;

    public a(OkHttpClient r5, g r10) {
        this.f23222a = r5;
        this.f23223b = r10;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        c r5 = this.f23224c;     // Catch: IOException -> L10
        if (r5 == null) goto L5;
        r5.close();     // Catch: IOException -> L10
    L5:
        w0 r10 = this.d;
        if (r10 == null) goto L8;
        r10.close();
    L8:
        this.e = null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        RealCall r5 = this.f;
        if (r5 == null) goto L6;
        r5.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource d() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(Priority r5, d r10) {
        n0 r11 = new n0();
        r11.g(this.f23223b.d());
        Iterator r12 = this.f23223b.f16545b.b().entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry r13 = (Map.Entry) r12.next();
        r11.a((String) r13.getKey(), (String) r13.getValue());
        goto L4
    L6:
        Request r14 = r11.b();
        this.e = r10;
        this.f = this.f23222a.a(r14);
        this.f.enqueue(this);
    }

    @Override // okhttp3.j
    public final void onFailure(Call r5, IOException r10) {
        if (Log.isLoggable("OkHttpFetcher", 3) == false) goto L5;
        Log.d("OkHttpFetcher", "OkHttp failed to obtain result", r10);
    L5:
        this.e.a(r10);
    }

    @Override // okhttp3.j
    public final void onResponse(Call r5, s0 r10) {
        this.d = r10.f20748h;
        if (r10.e() == false) goto L5;
        w0 r11 = this.d;
        h.h(r11, "Argument must not be null");
        long r12 = r11.contentLength();
        c r13 = new c(this.d.byteStream(), r12);
        this.f23224c = r13;
        this.e.f(r13);
        return;
    L5:
        this.e.a(new HttpException(r10.d, r10.e));
    }
}
