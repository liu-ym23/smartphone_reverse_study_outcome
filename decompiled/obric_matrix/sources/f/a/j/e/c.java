package f.a.j.e;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static int a(int r1) {
        return 1 << (32 - Integer.numberOfLeadingZeros(r1 - 1));
    }
}
