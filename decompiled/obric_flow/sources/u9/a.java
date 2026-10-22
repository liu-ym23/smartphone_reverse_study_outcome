package u9;

import ai.i0;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements fi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HttpURLConnection f22266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f22267b;

    public a(c r5, HttpURLConnection r10) {
        this.f22267b = r5;
        this.f22266a = r10;
    }

    @Override // fi.i, fi.j
    public final String a() {
        return l.i(this.f22266a, "Content-Type");
    }

    @Override // fi.i
    public final InputStream c() {
        c r5 = this.f22267b;
        HttpURLConnection r10 = this.f22266a;
        InputStream r11 = r10.getInputStream();     // Catch: Exception -> L6
        r10.getHeaderFields();     // Catch: Exception -> L6
        i0 r12 = r5.f22272a;     // Catch: Exception -> L6
        sj.d r13 = s9.h.f21879a;     // Catch: Exception -> L6
        return new s9.c(r11, r5);
    L6:
        e = move-exception;
        s9.b r14 = r5.f22275h;
        String r15 = r10.getResponseMessage();
        StringBuilder r16 = new StringBuilder("reason = ");
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        r16.append(r15);
        r16.append("  exception = ");
        r16.append(e.getMessage());
        String r17 = r16.toString();
        throw new HttpResponseException(r10.getResponseCode(), r17);
    }
}
