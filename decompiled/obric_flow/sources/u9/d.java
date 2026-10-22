package u9;

import ai.i0;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements fi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HttpURLConnection f22292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f22293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f22294c;

    public d(e r5, HttpURLConnection r10, boolean r11) {
        this.f22294c = r5;
        this.f22292a = r10;
        this.f22293b = r11;
    }

    @Override // fi.i, fi.j
    public final String a() {
        return l.i(this.f22292a, "Content-Type");
    }

    @Override // fi.i
    public final InputStream c() {
        e r5 = this.f22294c;
        HttpURLConnection r10 = this.f22292a;
        InputStream r11 = r10.getInputStream();     // Catch: Exception -> L9
        r10.getHeaderFields();     // Catch: Exception -> L9
        boolean r12 = this.f22293b;     // Catch: Exception -> L9
        i0 r13 = r5.f;     // Catch: Exception -> L9
        if (r12 == false) goto L6;
        r11 = new GZIPInputStream(r11);     // Catch: Exception -> L9
    L8:
        return new s9.c(r11, r5);
    L6:
        sj.d r14 = s9.h.f21879a;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        s9.b r15 = r5.f22298b;
        String r16 = r10.getResponseMessage();
        StringBuilder r17 = new StringBuilder("reason = ");
        if (r16 != null) goto L13;
        r16 = "";
    L13:
        r17.append(r16);
        r17.append("  exception = ");
        r17.append(e.getMessage());
        String r18 = r17.toString();
        throw new HttpResponseException(r10.getResponseCode(), r18);
    }
}
