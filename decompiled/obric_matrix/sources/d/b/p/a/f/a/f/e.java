package d.b.p.a.f.a.f;

import android.content.Context;
import d.b.p.a.d.h;

/* JADX INFO: loaded from: classes.dex */
public class e extends d.b.p.a.f.a.e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f14295b;

    public interface a {
        boolean clear();
    }

    public e(a r2) {
        super("SettingClearHandler");
        this.f14295b = r2;
    }

    @Override // d.b.p.a.f.a.e.a
    public void b(Context r2) {
        if (this.f14295b == null) goto L6;
        h.c("LaunchSafePlugin", a() + "method is called.");
        this.f14295b.clear();
        return;
    }
}
