package ms.bd.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f22542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f22545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f22546f;

    static {
        String r0 = (String) m.a(16777217, 0, 0, "b4363c", new byte[]{87, 57, 85, 123, 5, 122, 77, 28, 116, 99});
    }

    x2() {
        this.f22541a = 0;
        this.f22542b = 0;
        this.f22543c = 0;
        this.f22544d = 0;
        this.f22545e = false;
        this.f22546f = false;
        g();
        String r0 = (String) m.a(16777217, 0, 0, "31c6c4", new byte[]{6, 60, 5, 123, 85, 45, 28, 25, 36, 99});
        String r1 = (String) m.a(16777217, 0, 0, "ec9e7f", new byte[]{71, 100, 94, 5, 1, 127, 97, 81, 40, 38, 96, 96, 94, 4, 27, 43, 38, 7, 123});
        if (this.f22546f == false) goto L6;
        this.f22544d = this.f22541a - this.f22542b;
        return;
    }

    private void g() {
        int r0 = b.f22318b;
        String r1 = (String) m.a(16777224, 0, 0, null, null);
        String r2 = (String) m.a(16777217, 0, 0, "87279f", new byte[]{6, 39, 72, 68, 15, 127, 58, 26, 35, 100, 38, 59, 71, 74, 1, 43, 123, 83, 112});
        if (TextUtils.isEmpty(r1) == false) goto L7;
        this.f22545e = true;
        Object r9 = m.a(16777217, 0, 0, "72c66d", new byte[]{22, 49, 2, 81, 12, 51, 55, 28, 60, 96, 47, 55, 80, 68, 8, 122, 56, 22, 54, 38, 41, 34, 80, 86, 1, 118, 116, 16, 61, 104, 32, 57, 23, 2, 30, 114, 39, 83, 60, 105, 50, 112, 3, 71, 29, 61});
    L5:
        String r10 = (String) r9;
        return;
    L7:
        String[] r3 = r1.split((String) m.a(16777217, 0, 0, "109ad1", new byte[]{28, 46}));
        if (r3.length == 3) goto L10;
        this.f22545e = true;
        r9 = m.a(16777217, 0, 0, "84ef59", new byte[]{10, 57, 24, 20, 3, 41, 123, 2, 53, 37, 105, 63, 24, 82, 30, 38, 62, 85, 35, 36, 38, 56, 17, 82, 12, 33, 41, 24, 53, 34, 103});
        goto L5
    L10:
        boolean r4 = false;
        this.f22541a = Integer.parseInt(r3[0]);
        this.f22542b = Integer.parseInt(r3[1]);
        int r5 = Integer.parseInt(r3[2]);
        this.f22543c = r5;
        int r6 = this.f22541a;
        if (r6 < 0) goto L18;
        int r7 = this.f22542b;
        if (r7 < 0) goto L18;
        if (r6 < r7) goto L18;
        if (r5 == 0) goto L18;
        boolean r8 = false;
    L19:
        if (r8 == false) goto L22;
        this.f22545e = true;
        r9 = m.a(16777217, 0, 0, "e40fba", new byte[]{87, 57, 77, 20, 84, 113, 38, 2, 96, 37, 52, 37, 70, 6, 29, 127, 104, 85, 117, 62, 113, 118, 84, 0, 82, 120, 97, 85, 118, 55, 109, 120});
        goto L5
    L22:
        if (this.f22542b != 0) goto L25;
        if (r6 != 0) goto L25;
        r4 = true;
    L25:
        if (r4 == false) goto L27;
        r9 = m.a(16777217, 0, 0, "396a25", new byte[]{1, 52, 75, 19, 4, 37, 112, 15, 102, 34, 98, 40, 64, 1, 77, 38, 57, 11, 102, 51, 46, 62, 65, 91});
        goto L5
    L27:
        this.f22546f = true;
        return;
    L18:
        r8 = true;
        goto L19
    }

    protected int a() {
        return this.f22542b;
    }

    protected int b() {
        return this.f22543c;
    }

    protected int c() {
        return this.f22544d;
    }

    protected boolean d() {
        return this.f22545e;
    }

    protected boolean e() {
        if (this.f22546f == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f22542b != this.f22541a) goto L7;
        return true;
    }

    protected boolean f() {
        return this.f22546f;
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, (String) m.a(16777217, 0, 0, "d3df63", new byte[]{112, 35, 5, 72, 76, 55, 123, 23, 59, 55, 119, 61, 18, 22, 83, 97, 116, 14, 112, 50, 57, 116, 19, 94, 76, 32}), new Object[]{Boolean.valueOf(this.f22545e), Boolean.valueOf(this.f22546f), Integer.valueOf(this.f22541a), Integer.valueOf(this.f22542b), Integer.valueOf(this.f22543c)});
    }
}
