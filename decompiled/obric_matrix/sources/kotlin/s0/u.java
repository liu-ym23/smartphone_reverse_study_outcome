package kotlin.s0;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/reflect/WildcardTypeImpl;", "Ljava/lang/reflect/WildcardType;", "Lkotlin/reflect/TypeImpl;", "upperBound", "Ljava/lang/reflect/Type;", "lowerBound", "(Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)V", "equals", "", "other", "", "getLowerBounds", "", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "getUpperBounds", "hashCode", "", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class u implements WildcardType, Type {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f18495h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final u f18496i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Type f18497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Type f18498g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/WildcardTypeImpl$Companion;", "", "()V", "STAR", "Lkotlin/reflect/WildcardTypeImpl;", "getSTAR", "()Lkotlin/reflect/WildcardTypeImpl;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final u a() {
            return u.a();
        }
    }

    static {
        f18495h = new a(null);
        f18496i = new u(null, null);
    }

    public u(Type r1, Type r2) {
        this.f18497f = r1;
        this.f18498g = r2;
    }

    public static final /* synthetic */ u a() {
        return f18496i;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof WildcardType) == false) goto L9;
        WildcardType r4 = (WildcardType) r3;
        if (Arrays.equals(getUpperBounds(), r4.getUpperBounds()) == false) goto L9;
        if (Arrays.equals(getLowerBounds(), r4.getLowerBounds()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type r2 = this.f18498g;
        if (r2 != null) goto L6;
        return new Type[0];
    L6:
        return new Type[]{r2};
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        if (this.f18498g == null) goto L6;
        StringBuilder r0 = new StringBuilder();
        r0.append("? super ");
        Type r2 = this.f18498g;
    L5:
        r0.append(t.b(r2));
        return r0.toString();
    L6:
        Type r1 = this.f18497f;
        if (r1 != null) goto L9;
    L11:
        return "?";
    L9:
        if (kotlin.n0.d.o.a(r1, Object.class) == true) goto L11;
        r0 = new StringBuilder();
        r0.append("? extends ");
        r2 = this.f18497f;
        goto L5
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type[] r0 = new Type[1];
        Type r2 = this.f18497f;
        if (r2 != null) goto L5;
        r2 = Object.class;
    L5:
        r0[0] = r2;
        return r0;
    }

    public int hashCode() {
        int r0 = Arrays.hashCode(getUpperBounds());
        return Arrays.hashCode(getLowerBounds()) ^ r0;
    }

    public String toString() {
        return getTypeName();
    }
}
