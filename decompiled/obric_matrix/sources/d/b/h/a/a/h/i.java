package d.b.h.a.a.h;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f13399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13400d;

    public i(boolean r2) {
        this.f13398b = true;
        this.f13397a = r2;
    }

    public i(boolean r2, Map<String, String> r3) {
        this.f13398b = true;
        this.f13397a = r2;
        this.f13399c = r3;
    }

    public Map<String, String> a() {
        return this.f13399c;
    }

    public String b() {
        return this.f13400d;
    }

    public boolean c() {
        return this.f13398b;
    }

    public boolean d() {
        return this.f13397a;
    }

    public void e(Map<String, String> r1) {
        this.f13399c = r1;
    }

    void f(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.f13400d = r2;
    }
}
