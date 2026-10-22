package wi;

import android.net.Uri;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.platform.web.c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static void a(JSONObject r5, bj.a r10) {
        int r11 = r10.c().ordinal();
        if (r11 != 0) goto L5;
        String r12 = "lynx";
    L13:
        r5.put("container_type", r12);
        r5.put("bridge_name", r10.f932a);
        String r13 = r10.f945r;
        Object r14 = "";
        if (r13 != null) goto L50;
        r13 = r10.d();
        if (r13 != null) goto L50;
        r13 = "";
    L50:
        Uri r15 = Uri.parse(r13);     // Catch: Exception -> L49
        if (r15.isHierarchical() == false) goto L22;
        r13 = r15.buildUpon().clearQuery().build().toString();     // Catch: Exception -> L49
    L22:
        r5.put("auth_url", r13);
        String r16 = r10.f945r;
        if (r16 != null) goto L27;
        r16 = r10.d();
        if (r16 != null) goto L27;
        r16 = "";
    L27:
        r5.put("origin_auth_url", r16);
        r5.put("auth_code", r10.f950x);
        r5.put("fe_id", r10.f942o);
        r5.put("fe_id_mapper", r10.f943p);
        r5.put("method_auth_type", r10.f951y);
        r5.put("auth_mode", r10.B);
        r5.put("auth_config_source", r10.f952z);
        String r17 = r10.d;
        if (r17 != null) goto L30;
    L32:
        if (r17 != null) goto L34;
        r17 = "unset";
    L34:
        r5.put("namespace", r17);
        r5.put("package_version", r10.f947u);
        if ((r10 instanceof c) == false) goto L38;
        r5.put("frame_url", ((c) r10).L);
    L38:
        if (r10.c() != PlatformType.f7287a) goto L41;
        r5.put("tasm_fe_id", r10.C);
    L43:
        JSONObject r18 = r10.E;
        if (r18 == null) goto L47;
        r14 = r18;
    L47:
        r5.put("request_trackings", r14);
        return;
    L41:
        if (r10.c() != PlatformType.f7288b) goto L43;
        r5.put("auth_url_type", r10.D);
        goto L43
    L30:
        if (Intrinsics.areEqual(r17, "") == false) goto L32;
        r17 = "host";
        goto L34
    L5:
        if (r11 != 1) goto L7;
        r12 = "webview";
        goto L13
    L7:
        if (r11 != 2) goto L10;
        r12 = "worker";
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
