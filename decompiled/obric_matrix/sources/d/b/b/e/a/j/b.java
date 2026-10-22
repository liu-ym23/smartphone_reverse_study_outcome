package d.b.b.e.a.j;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f12634a;

    public b(byte[] r1) {
        this.f12634a = r1;
    }

    public byte[] a() {
        return this.f12634a;
    }

    public String toString() {
        return new JSONObject(new String(this.f12634a)).toString();
    L4:
        return "";
    }
}
