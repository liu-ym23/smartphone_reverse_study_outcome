package ms.bd.c;

import android.text.TextUtils;
import android.view.Display;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x4 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static x4 f22548j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f22549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f22550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f22551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f22553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f22554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f22557i;

    private x4() {
        this.f22552d = 1;
    }

    public static Object a(Object r12, String r13) {
        Method r0 = Class.class.getDeclaredMethod((String) m.a(16777217, 0, 0, "ce3624", new byte[]{117, 98, 84, 102, 8, 32, 108, 69, 112, 99, 118, 65, 73, 71, 1, 39}), new Class[]{String.class});     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        Field r14 = (Field) r0.invoke(r12.getClass(), new Object[]{r13});     // Catch: Throwable -> L12
        if (r14 == null) goto L15;
        r14.setAccessible(true);     // Catch: Throwable -> L12
        return r14.get(r12);
    L15:
        return null;
    L10:
        return null;
    L16:
        return null;
    }

    public static x4 c() {
        if (f22548j != null) goto L6;
        f22548j = new x4();
    L6:
        return f22548j;
    }

    public String b(Display[] r34) {
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L35
        int r2 = r34.length;     // Catch: Exception -> L35
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L30;
        Display r5 = r34[r4];     // Catch: Exception -> L35
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L35
        Object r7 = a(r5, (String) m.a(16777217, 0, 0, "a953f1", new byte[]{125, 31, 79, 84, 73, 42, 99, 1, 77, 109, 118, 52}));     // Catch: Exception -> L35
        r6.append(a(r7, (String) m.a(16777217, 0, 0, "69fc02", new byte[]{40, 44, 27, 18, 29, 21, 52, 27, 60, 50, 32, 62, 59, 22, 2, 32})));     // Catch: Exception -> L35
        r6.append((String) m.a(16777217, 0, 0, "e4c518", new byte[]{56}));     // Catch: Exception -> L35
        r6.append(a(r7, (String) m.a(16777217, 0, 0, "943437", new byte[]{46, 58, 65, 71, 31})));     // Catch: Exception -> L35
        r6.append((String) m.a(16777217, 0, 0, "036d76", new byte[]{109}));     // Catch: Exception -> L35
        r6.append(a(r7, (String) m.a(16777217, 0, 0, "874339", new byte[]{39, 52, 74, 66})));     // Catch: Exception -> L35
        r6.append((String) m.a(16777217, 0, 0, "f75cd7", new byte[]{59}));     // Catch: Exception -> L35
        r6.append(a(r7, (String) m.a(16777217, 0, 0, "5069c3", new byte[]{48, 43, 85, 72})));     // Catch: Exception -> L35
        if (r1.toString().contains(r6.toString()) == true) goto L28;
        if (r1.length() > 0) goto L26;
    L27:
        r1.append(r6);     // Catch: Exception -> L35
        goto L28
    L26:
        r1.append((String) m.a(16777217, 0, 0, "4cb9c2", new byte[]{126}));     // Catch: Exception -> L35
    L28:
        r4 = r4 + 1;     // Catch: Exception -> L35
        goto L4
    L30:
        if (r1.length() <= 0) goto L33;
        return r1.toString();
    L33:
        return null;
    L41:
        return null;
    }

    public void d(int r5) {
        if (this.f22552d == r5) goto L5;
        this.f22553e = System.currentTimeMillis() / 1000;
    L5:
        this.f22552d = r5;
    }

    public void e(long r7) {
        this.f22549a = r7;
        this.f22554f = (String) m.a(16777217, 0, 0, "a8e8b9", new byte[]{113, 62, 18});
    }

    public void f(String r1) {
        this.f22556h = r1;
    }

    public void g(boolean r1) {
        this.f22557i = r1;
    }

    public String h(Display[] r18) {
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L21
        int r2 = r18.length;     // Catch: Exception -> L21
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L16;
        Object r5 = a(r18[r4], (String) m.a(16777217, 0, 0, "537677", new byte[]{41, 30, 83, 76, 13, 50, 6, 19, 101, 109, 37, 54, 65, 108, 9, 45, 51}));     // Catch: Exception -> L21
        if (r5 == null) goto L14;
        if (r1.toString().contains(r5.toString()) == true) goto L14;
        r1.append(r5);     // Catch: Exception -> L21
        r1.append((String) m.a(16777217, 0, 0, "8ba3fb", new byte[]{114}));     // Catch: Exception -> L21
    L14:
        r4 = r4 + 1;     // Catch: Exception -> L21
        goto L4
    L16:
        if (r1.length() <= 0) goto L19;
        return r1.toString();
    L19:
        return null;
    L28:
        return null;
    }

    public JSONObject i() {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L30
        r1.put((String) m.a(16777217, 0, 0, "06fb86", new byte[]{32, 32}), this.f22549a);     // Catch: Exception -> L30
        r1.put((String) m.a(16777217, 0, 0, "69153e", new byte[]{53, 47}), this.f22550b);     // Catch: Exception -> L30
        r1.put((String) m.a(16777217, 0, 0, "49a2bd", new byte[]{33, 54}), this.f22552d);     // Catch: Exception -> L30
        r1.put((String) m.a(16777217, 0, 0, "2d344f", new byte[]{39, 114}), this.f22553e);     // Catch: Exception -> L30
        r1.put((String) m.a(16777217, 0, 0, "950645", new byte[]{43, 54, 71}), this.f22557i ? 1 : 0);     // Catch: Exception -> L30
        r1.put((String) m.a(16777217, 0, 0, "91a00b", new byte[]{37, 55}), this.f22554f);     // Catch: Exception -> L30
        if (TextUtils.isEmpty(this.f22555g) == true) goto L20;
        r1.put((String) m.a(16777217, 0, 0, "5cc92f", new byte[]{52, 106}), this.f22555g);     // Catch: Exception -> L30
    L20:
        if (TextUtils.isEmpty(this.f22556h) == false) goto L22;
    L23:
        this.f22551c = System.currentTimeMillis();     // Catch: Exception -> L30
        r1.put((String) m.a(16777217, 0, 0, "f11a36", new byte[]{116, 39}), this.f22551c / 1000);     // Catch: Exception -> L30
        if (r1.length() <= 0) goto L28;
        return r1;
    L28:
        return null;
    L22:
        r1.put((String) m.a(16777217, 0, 0, "9c0326", new byte[]{44, 104}), this.f22556h);     // Catch: Exception -> L30
    L33:
        return null;
    }

    public void j(long r7) {
        this.f22550b = r7;
        this.f22554f = (String) m.a(16777217, 0, 0, "f3f5cd", new byte[]{101, 52, 24, 78, 74, 118});
    }

    public void k(String r1) {
        this.f22555g = r1;
    }

    public boolean l() {
        if (this.f22549a <= 0) goto L5;
        return true;
    L5:
        if (this.f22550b <= 0) goto L7;
        return true;
    L7:
        if (this.f22553e > 0) goto L14;
        return false;
    L14:
        return true;
    }
}
