package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public class ej {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f186a;
    public int b;

    public ej(String r1, int r2) {
        this.f186a = r1;
        this.b = r2;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        ej r5 = (ej) r4;
        String r1 = r5.f186a;
        if (r1 == null) goto L15;
        String r2 = this.f186a;
        if (r2 != null) goto L10;
        return false;
    L10:
        if (r1.equals(r2) == true) goto L12;
        return false;
    L12:
        if (r5.b != this.b) goto L18;
        return true;
    L18:
        return false;
    L15:
        return false;
    }

    public String toString() {
        if (this.b < 0) goto L7;
        return this.f186a + ":" + this.b;
    L7:
        return this.f186a;
    }
}
