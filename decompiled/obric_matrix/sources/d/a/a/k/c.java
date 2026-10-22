package d.a.a.k;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class c implements ParameterizedType {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Type[] f12540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Type f12541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Type f12542h;

    public c(Type[] r1, Type r2, Type r3) {
        this.f12540f = r1;
        this.f12541g = r2;
        this.f12542h = r3;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L29:
        return false;
    L8:
        if (c.class != r5.getClass()) goto L29;
        c r6 = (c) r5;
        if (Arrays.equals(this.f12540f, r6.f12540f) == true) goto L13;
        return false;
    L13:
        Type r2 = this.f12541g;
        if (r2 == null) goto L19;
        if (r2.equals(r6.f12541g) == false) goto L20;
    L21:
        Type r4 = this.f12542h;
        if (r4 == null) goto L25;
        return r4.equals(r6.f12542h);
    L25:
        if (r6.f12542h != null) goto L28;
        return true;
    L28:
        return false;
    L20:
        return false;
    L19:
        if (r6.f12541g == null) goto L21;
        goto L20
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f12540f;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f12541g;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f12542h;
    }

    public int hashCode() {
        Type[] r0 = this.f12540f;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = Arrays.hashCode(r0);
    L6:
        int r3 = r2 * 31;
        Type r4 = this.f12541g;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Type r7 = this.f12542h;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }
}
