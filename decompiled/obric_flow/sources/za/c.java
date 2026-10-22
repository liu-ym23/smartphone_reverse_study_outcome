package za;

import com.bytedance.framwork.core.sdkmonitor.e;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f23425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f23426b;

    public c() {
        this.f23426b = new AtomicBoolean(false);
    }

    public final void a(String r5, JSONObject r10, JSONObject r11, JSONObject r12) {
        if (this.f23426b.get() == false) goto L10;
        e r13 = this.f23425a;
        if (r13 != null) goto L7;
        return;
    L7:
        r13.p(r5, r10, r11, r12);
        return;
    L10:
        throw new IllegalStateException("Please init MonitorManager first");
    }
}
