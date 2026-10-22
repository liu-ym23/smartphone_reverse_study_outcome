package ms.bd.c;

import androidx.annotation.NonNull;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class w2 implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f22531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f22532g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f22533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f22534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f22535j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f22536k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f22537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f22538b;

        public a() {
        }

        @NonNull
        public String toString() {
            return String.format(Locale.US, (String) m.a(16777217, 0, 0, "6639a9", new byte[]{98, 122, 17, 75, 18, 107, 123, 70, 100}), new Object[]{Float.valueOf(this.f22537a), Float.valueOf(this.f22538b)});
        }
    }

    static {
        String r0 = (String) m.a(16777217, 0, 0, "3c3c7e", new byte[0]);
    }

    public w2() {
        this.f22535j = new a();
    }

    @NonNull
    public w2 a() {
        return (w2) super.clone();
    L5:
        throw new AssertionError();
    }

    @NonNull
    public Object clone() {
        return (w2) super.clone();
    L5:
        throw new AssertionError();
    }

    @NonNull
    public String toString() {
        this.f22535j.getClass();
        Locale r0 = Locale.US;
        String r1 = (String) m.a(16777217, 0, 0, "0bf3a3", new byte[]{100, 100, 89, 2, 90, 104, 118, 71, 123, 38, 37, 44, 80, 84});
        Object[] r2 = new Object[5];
        r2[0] = Long.valueOf(this.f22531f);
        r2[1] = Long.valueOf(this.f22532g);
        r2[2] = Long.valueOf(this.f22533h);
        long r3 = this.f22534i;
        long r5 = 0;
        if (r3 == 0) goto L6;
        r5 = this.f22536k - r3;
    L6:
        r2[3] = Long.valueOf(r5);
        r2[4] = this.f22535j;
        return String.format(r0, r1, r2);
    }
}
