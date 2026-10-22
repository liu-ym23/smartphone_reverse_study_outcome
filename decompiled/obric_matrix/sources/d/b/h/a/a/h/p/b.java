package d.b.h.a.a.h.p;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class b implements Externalizable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f13697h;

    public b(String r1) {
        f(r1);
    }

    private static boolean d(char r1) {
        if (r1 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r1 >= 127) goto L9;
        if ("()<>@,;:/[]?=\\\"".indexOf(r1) >= 0) goto L9;
        return true;
    }

    private boolean e(String r4) {
        int r3 = r4.length();
        if (r3 <= 0) goto L12;
        int r1 = 0;
    L5:
        if (r1 >= r3) goto L10;
        if (d(r4.charAt(r1)) == false) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return false;
    L10:
        return true;
    L12:
        return false;
    }

    private void f(String r5) {
        int r0 = r5.indexOf(47);
        int r1 = r5.indexOf(59);
        if (r0 >= 0) goto L8;
        if (r1 >= 0) goto L8;
        throw new d("Unable to find a sub type.");
    L8:
        if (r0 >= 0) goto L14;
        if (r1 < 0) goto L14;
        throw new d("Unable to find a sub type.");
    L14:
        if (r0 < 0) goto L17;
        if (r1 >= 0) goto L17;
        String r2 = r5.substring(0, r0).trim();
        Locale r3 = Locale.ENGLISH;
        this.f13695f = r2.toLowerCase(r3);
        this.f13696g = r5.substring(r0 + 1).trim().toLowerCase(r3);
        this.f13697h = new c();
    L20:
        if (e(this.f13695f) == false) goto L27;
        if (e(this.f13696g) == false) goto L25;
        return;
    L25:
        throw new d("Sub type is invalid.");
    L27:
        throw new d("Primary type is invalid.");
    L17:
        if (r0 >= r1) goto L29;
        String r4 = r5.substring(0, r0).trim();
        Locale r6 = Locale.ENGLISH;
        this.f13695f = r4.toLowerCase(r6);
        this.f13696g = r5.substring(r0 + 1, r1).trim().toLowerCase(r6);
        this.f13697h = new c(r5.substring(r1));
        goto L20
    L29:
        throw new d("Unable to find a sub type.");
    }

    public String a() {
        return this.f13695f + "/" + this.f13696g;
    }

    public String b(String r1) {
        return this.f13697h.a(r1);
    }

    public String c() {
        return this.f13695f;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r1) {
        f(r1.readUTF());     // Catch: d -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.toString());
    }

    public String toString() {
        return a() + this.f13697h.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r1) {
        r1.writeUTF(toString());
        r1.flush();
    }
}
