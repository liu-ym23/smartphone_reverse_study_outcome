package ta;

import ai.j0;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.lynx.tasm.utils.j;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22113c;

    public a(String r5, String r10, long r11) {
        this.f22111a = r5;
        this.f22112b = r10;
        this.f22113c = r11;
    }

    public final void a() {
        JSONObject r5 = new JSONObject();
        if (TextUtils.isEmpty(null) == true) goto L6;
        r5.put("tt_trace_tag_id", null);
    L6:
        if (TextUtils.isEmpty(null) == true) goto L9;
        r5.put("x_response_cache", null);
    L9:
        if (TextUtils.isEmpty(null) == true) goto L12;
        r5.put("client_ip", null);
    L12:
        if (TextUtils.isEmpty(null) == true) goto L15;
        r5.put("client_ip_version", null);
    L15:
        if (TextUtils.isEmpty(null) == true) goto L17;
        r5.put("server_ip", null);
    L17:
        r5.put("http_status", 0);
        r5.put(WsConstants.ERROR_CODE, 0);
        r5.put("timing_dns", 0);
        r5.put("timing_connect", 0);
        r5.put("timing_send", 0);
        r5.put("timing_ssl", 0);
        r5.put("timing_wait", 0);
        r5.put("timing_proxy", 0);
        r5.put("timing_receive", 0);
        if (TextUtils.isEmpty(null) == true) goto L20;
        r5.put("timing_isSocketReused", null);
    L20:
        r5.put("timing_total", 0);
        if (TextUtils.isEmpty(null) == true) goto L23;
        r5.put("access", null);
    L23:
        r5.put("download_duration", 0);
        r5.put("cdn_domain", this.f22112b);
        r5.put("package_size", this.f22113c);
        r5.put("url", this.f22111a);
        j.g("geckosdk_cdn_stats", r5);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L12;
        a r10 = (a) r5;
        String r11 = r10.f22111a;
        if (Intrinsics.areEqual(this.f22111a, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f22112b, r10.f22112b) == true) goto L10;
        return false;
    L10:
        if (this.f22113c == r10.f22113c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f22111a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        String r13 = this.f22112b;
        if (r13 == null) goto L9;
        r5 = r13.hashCode();
    L9:
        long r14 = this.f22113c;
        return ((r12 + r5) * 31) + ((int) (r14 ^ (r14 >>> 32)));
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("HttpRequestInfo(url=");
        r5.append(this.f22111a);
        r5.append(", cdnDomain=");
        r5.append(this.f22112b);
        r5.append(", packageSize=");
        return j0.o(r5, this.f22113c, ")");
    }
}
