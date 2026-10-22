package d.b.s.a.l0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final Collection<String> f14859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final Collection<String> f14860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final Collection<String> f14861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private final Collection<String> f14862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f14863e;

    public m(@Nullable Collection<String> r1, boolean r2) {
        this.f14863e = r2;
        if (r1 != null) goto L5;
        r1 = new HashSet();
    L5:
        this.f14862d = r1;
        if (r2 == false) goto L8;
        this.f14859a = new HashSet();
        this.f14860b = new HashSet();
        Collection<String> r3 = new HashSet();
    L9:
        this.f14861c = r3;
        if (r1.isEmpty() == true) goto L13;
        this.f14860b.addAll(r1);
        this.f14861c.addAll(this.f14860b);
        return;
    L13:
        return;
    L8:
        this.f14859a = new CopyOnWriteArraySet();
        this.f14860b = new CopyOnWriteArraySet();
        r3 = new CopyOnWriteArraySet();
        goto L9
    }

    private static HashSet<String> c(JSONArray r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        HashSet<String> r0 = new HashSet();
        int r1 = 0;
    L7:
        if (r1 >= r4.length()) goto L12;
        String r2 = r4.optString(r1, "");
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r0.add(r2);
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        return r0;
    }

    private void d(Collection<String> r2) {
        this.f14859a.addAll(r2);
        g();
    }

    private void e() {
        this.f14861c.clear();
        this.f14861c.addAll(this.f14859a);
        this.f14861c.addAll(this.f14860b);
    }

    private void f(JSONArray r2) {
        this.f14860b.clear();
        HashSet<String> r3 = c(r2);
        if (r3 != null) goto L5;
        this.f14860b.addAll(this.f14862d);
    L6:
        g();
        return;
    L5:
        this.f14860b.addAll(r3);
        goto L6
    }

    private void g() {
        if (this.f14863e == false) goto L11;
        monitor-enter(this);
        e();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        e();
    }

    public void a(Collection<String> r2) {
        if (this.f14863e == false) goto L11;
        monitor-enter(this);
        d(r2);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        d(r2);
    }

    public Collection<String> b() {
        return this.f14861c;
    }

    public void h(JSONArray r2) {
        if (this.f14863e == false) goto L11;
        monitor-enter(this);
        f(r2);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        f(r2);
    }
}
