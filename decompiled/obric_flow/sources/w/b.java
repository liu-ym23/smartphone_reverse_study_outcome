package w;

import com.bytedance.ies.bullet.core.j;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f22655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File[] f22656c;
    public final File[] d;
    public boolean e;
    public j f;
    public final /* synthetic */ c g;

    public b(c r10, String r11) {
        this.g = r10;
        this.f22654a = r11;
        int r5 = r10.g;
        this.f22655b = new long[r5];
        this.f22656c = new File[r5];
        this.d = new File[r5];
        StringBuilder r12 = new StringBuilder(r11);
        r12.append('.');
        int r13 = r12.length();
        int r14 = 0;
    L4:
        if (r14 >= r10.g) goto L6;
        r12.append(r14);
        File[] r15 = this.f22656c;
        String r16 = r12.toString();
        File r17 = r10.f22657a;
        r15[r14] = new File(r17, r16);
        r12.append(".tmp");
        this.d[r14] = new File(r17, r12.toString());
        r12.setLength(r13);
        r14 = r14 + 1;
        goto L4
    }

    public final String a() {
        StringBuilder r5 = new StringBuilder();
        long[] r10 = this.f22655b;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        long r13 = r10[r12];
        r5.append(' ');
        r5.append(r13);
        r12 = r12 + 1;
        goto L3
    L6:
        return r5.toString();
    }
}
