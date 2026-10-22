package w5;

import android.app.Activity;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.j;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends s6.a {
    public boolean f;
    public ArrayList g;

    @Override // s6.a, oj.c
    public final void c(Activity r5) {
        super.c(r5);
        boolean r10 = j.f3887a;     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    }

    @Override // s6.a
    public final void g(JSONObject r5) {
        boolean r10 = false;
        if (r5.optInt("temperature_enable_upload", 0) != 1) goto L5;
        r10 = true;
    L5:
        this.f = r10;
        r5.optInt("temperature_upload_interval", 60);
        if (this.f == true) goto L9;
        ActivityLifeObserver.getInstance().unregister(this);
        return;
    }

    @Override // s6.a
    public final boolean h() {
        return false;
    }

    @Override // s6.a
    public final long k() {
        return 0;
    }
}
