package d.b.h.a.a.h.n;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a extends ObjectInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<String> f13468f;

    public a(InputStream r4, Class<?>... r5) {
        super(r4);
        this.f13468f = new HashSet();
        if (r5 == null) goto L7;
        int r6 = r5.length;
        int r0 = 0;
    L5:
        if (r0 >= r6) goto L9;
        Class<?> r1 = r5[r0];
        this.f13468f.add(r1.getName());
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass r3) {
        if (r3 == null) goto L13;
        if (r3.getName() == null) goto L13;
        String r0 = r3.getName();
        if (this.f13468f.contains(r0) == false) goto L11;
        return super.resolveClass(r3);
    L11:
        return Class.forName(r0, true, ClassLoader.getSystemClassLoader().getParent());
    L13:
        return super.resolveClass(r3);
    }
}
