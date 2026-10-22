package d.e.b.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Externalizable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<g> f16607f;

    public h() {
        this.f16607f = new ArrayList();
    }

    public int a() {
        return this.f16607f.size();
    }

    public List<g> b() {
        return this.f16607f;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r5) {
        int r0 = r5.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        g r2 = new g();
        r2.readExternal(r5);
        this.f16607f.add(r2);
        r1 = r1 + 1;
        goto L3
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r4) {
        int r0 = a();
        r4.writeInt(r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.f16607f.get(r1).writeExternal(r4);
        r1 = r1 + 1;
        goto L3
    }
}
