package d.e.b.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i implements Externalizable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f16609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Integer> f16610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Integer> f16611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16612j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f16613k;

    public i() {
        this.f16609g = "";
        this.f16610h = new ArrayList();
        this.f16611i = new ArrayList();
        this.f16613k = "";
    }

    public String a() {
        return this.f16613k;
    }

    public String b() {
        return this.f16609g;
    }

    public int c(int r1) {
        return this.f16610h.get(r1).intValue();
    }

    public int d() {
        return this.f16610h.size();
    }

    public List<Integer> e() {
        return this.f16610h;
    }

    public int f() {
        return this.f16611i.size();
    }

    public List<Integer> g() {
        return this.f16611i;
    }

    public boolean h() {
        return this.f16612j;
    }

    public i i(String r2) {
        this.f16612j = true;
        this.f16613k = r2;
        return this;
    }

    public i j(String r2) {
        this.f16608f = true;
        this.f16609g = r2;
        return this;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r6) {
        if (r6.readBoolean() == false) goto L5;
        j(r6.readUTF());
    L5:
        int r0 = r6.readInt();
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        this.f16610h.add(Integer.valueOf(r6.readInt()));
        r2 = r2 + 1;
        goto L6
    L8:
        int r3 = r6.readInt();
    L9:
        if (r1 >= r3) goto L12;
        this.f16611i.add(Integer.valueOf(r6.readInt()));
        r1 = r1 + 1;
        goto L9
    L12:
        if (r6.readBoolean() == false) goto L17;
        i(r6.readUTF());
        return;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r5) {
        r5.writeBoolean(this.f16608f);
        if (this.f16608f == false) goto L5;
        r5.writeUTF(this.f16609g);
    L5:
        int r0 = d();
        r5.writeInt(r0);
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r5.writeInt(this.f16610h.get(r2).intValue());
        r2 = r2 + 1;
        goto L6
    L8:
        int r3 = f();
        r5.writeInt(r3);
    L9:
        if (r1 >= r3) goto L11;
        r5.writeInt(this.f16611i.get(r1).intValue());
        r1 = r1 + 1;
        goto L9
    L11:
        r5.writeBoolean(this.f16612j);
        if (this.f16612j == false) goto L17;
        r5.writeUTF(this.f16613k);
        return;
    }
}
