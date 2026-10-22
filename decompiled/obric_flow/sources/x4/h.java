package x4;

import com.bytedance.common.wschannel.WsConstants;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends sj.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22975c;
    public String d;
    public long e;
    public String f;
    public JSONObject g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final JSONObject f22976h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f22977i;

    public h() {
        this.f22973a = null;
        StringBuilder r5 = new StringBuilder();
        r5.append(System.currentTimeMillis());
        r5.append('-');
        r5.append(UUID.randomUUID());
        this.f22974b = r5.toString();
        this.f22975c = null;
        this.d = null;
        this.e = 0;
        this.f22976h = new JSONObject();
    }

    @Override // sj.g
    public void m(JSONObject r5) {
        qo.a.t("navigation_id", this.f22974b, r5);
        qo.a.t("url", this.f22973a, r5);
        qo.a.t("container_type", this.f22975c, r5);
        qo.a.t("native_page", this.d, r5);
        qo.a.t(WsConstants.KEY_SDK_VERSION, "9.0.0", r5);
        android.support.v4.media.c r10 = fj.a.f16916b;     // Catch: Throwable -> L17
        if (r10 == null) goto L9;
        if (r10.e(com.bytedance.android.monitorV2.settings.d.class) == null) goto L9;
        boolean r11 = ((com.bytedance.android.monitorV2.settings.d) fj.a.f16916b.e(com.bytedance.android.monitorV2.settings.d.class)).d();     // Catch: Throwable -> L17
    L10:
        if (r11 == false) goto L12;
        qo.a.t("virtual_aid", this.f, r5);
    L12:
        qo.a.j(this.g, "context", r5);
        qo.a.t(WsConstants.KEY_SDK_VERSION, "9.0.0", r5);
        JSONObject r12 = this.f22976h;
        qo.a.j(r12, "debug_context", r5);
        Boolean r13 = this.f22977i;
        if (r13 == null) goto L15;
        qo.a.j(r13, "container_reuse", r5);
    L15:
        qo.a.t("monitor_package", "monitorV2", r12);
        return;
    L9:
        r11 = true;
        goto L10
    }

    public final void s(String r5, Object r10) {
        if (this.g != null) goto L5;
        this.g = new JSONObject();
    L5:
        JSONObject r11 = this.g;
        qo.a.t(r5, String.valueOf(r10), r11);
    }
}
