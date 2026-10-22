package d.b.b.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.common.utility.i;
import d.b.b.o.f;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f12724b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f12725a;

    /* JADX INFO: renamed from: d.b.b.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0333a {
        void a(double r1, double r3, String r5, @Nullable d.b.w.a.a.c.a r6, i.a r7);
    }

    public interface b {
        boolean a();
    }

    public interface c {
        void a(double r1);
    }

    private a() {
        this.f12725a = new CopyOnWriteArraySet();
    }

    public static a c() {
        if (f12724b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12724b != null) goto L9;
        f12724b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12724b;
    }

    public CopyOnWriteArraySet<String> a() {
        return this.f12725a;
    }

    public String b() {
        String r1 = f.a(this.f12725a.toArray(), "#");
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return "";
    }
}
