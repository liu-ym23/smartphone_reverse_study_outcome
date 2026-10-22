package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o2 implements p2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f22441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f22442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i0 f22443c;

    o2(i0 r2, Context r3, long r4) {
        Objects.requireNonNull(r3, "context could not be null");
        this.f22443c = r2;
        this.f22442b = r3.getApplicationContext();
        this.f22441a = r4;
    }

    @Override // ms.bd.c.p2.a
    public void a(String r7) {
        if (this.f22441a == (-1)) goto L14;
        if (TextUtils.isEmpty(r7) == false) goto L7;
        return;
    L7:
        if (r7.contains("content") == false) goto L9;
        r7 = new JSONObject(r7).getString("content");     // Catch: Exception -> L11
    L9:
        long r2 = this.f22441a;     // Catch: Exception -> L11
        Context r5 = this.f22442b;     // Catch: Exception -> L11
        int r6 = b.f22318b;     // Catch: Exception -> L11
        m.a(33554447, 0, r2, r7, r5);     // Catch: Exception -> L11
        return;
    L16:
        return;
    }

    @Override // ms.bd.c.p2.a
    public void b(String r8) {
        this.f22443c.f22377e = r8;
        long r3 = this.f22441a;
        if (r3 == (-1)) goto L6;
        Context r6 = this.f22442b;
        int r7 = b.f22318b;
        m.a(33554435, 0, r3, r8, r6);
        return;
    }

    @Override // ms.bd.c.p2.a
    public void c(String r8) {
        if (this.f22441a != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L9;
        long r3 = this.f22441a;
        Context r6 = this.f22442b;
        int r7 = b.f22318b;
        m.a(InputDeviceCompat.SOURCE_HDMI, 0, r3, r8, r6);
        return;
    }

    @Override // ms.bd.c.p2.a
    public void d(String r8) {
        this.f22443c.f22378f = r8;
        long r3 = this.f22441a;
        if (r3 == (-1)) goto L6;
        Context r6 = this.f22442b;
        int r7 = b.f22318b;
        m.a(33554436, 0, r3, r8, r6);
        return;
    }

    @Override // ms.bd.c.p2.a
    public void e(String r8) {
        this.f22443c.f22375c = r8;
        long r3 = this.f22441a;
        if (r3 == (-1)) goto L6;
        Context r6 = this.f22442b;
        int r7 = b.f22318b;
        m.a(33554434, 0, r3, r8, r6);
        return;
    }
}
