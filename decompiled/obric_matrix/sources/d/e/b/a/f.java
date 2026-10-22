package d.e.b.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Externalizable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f16593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f16594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f16596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f16597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f16598l;
    private String m;

    public f() {
        this.f16592f = "";
        this.f16593g = "";
        this.f16594h = new ArrayList();
        this.f16596j = "";
        this.f16597k = false;
        this.m = "";
    }

    public int a() {
        return this.f16594h.size();
    }

    @Deprecated
    public int b() {
        return a();
    }

    public f c(String r2) {
        this.f16598l = true;
        this.m = r2;
        return this;
    }

    public f d(String r1) {
        this.f16593g = r1;
        return this;
    }

    public f e(String r2) {
        this.f16595i = true;
        this.f16596j = r2;
        return this;
    }

    public f f(boolean r1) {
        this.f16597k = r1;
        return this;
    }

    public f g(String r1) {
        this.f16592f = r1;
        return this;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r5) {
        g(r5.readUTF());
        d(r5.readUTF());
        int r0 = r5.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        this.f16594h.add(r5.readUTF());
        r1 = r1 + 1;
        goto L3
    L6:
        if (r5.readBoolean() == false) goto L9;
        e(r5.readUTF());
    L9:
        if (r5.readBoolean() == false) goto L11;
        c(r5.readUTF());
    L11:
        f(r5.readBoolean());
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r4) {
        r4.writeUTF(this.f16592f);
        r4.writeUTF(this.f16593g);
        int r0 = b();
        r4.writeInt(r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.writeUTF(this.f16594h.get(r1));
        r1 = r1 + 1;
        goto L3
    L5:
        r4.writeBoolean(this.f16595i);
        if (this.f16595i == false) goto L8;
        r4.writeUTF(this.f16596j);
    L8:
        r4.writeBoolean(this.f16598l);
        if (this.f16598l == false) goto L11;
        r4.writeUTF(this.m);
    L11:
        r4.writeBoolean(this.f16597k);
    }
}
