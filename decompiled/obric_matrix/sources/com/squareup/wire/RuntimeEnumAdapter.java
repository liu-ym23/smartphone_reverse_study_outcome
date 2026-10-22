package com.squareup.wire;

import com.squareup.wire.WireEnum;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.a;
import kotlin.n0.d.o;
import kotlin.s0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/squareup/wire/RuntimeEnumAdapter;", "Lcom/squareup/wire/WireEnum;", "E", "Lcom/squareup/wire/EnumAdapter;", "Ljava/lang/reflect/Method;", "getFromValueMethod", "()Ljava/lang/reflect/Method;", "", "value", "fromValue", "(I)Lcom/squareup/wire/WireEnum;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "fromValueMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "javaType", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {
    private Method fromValueMethod;
    private final Class<E> javaType;

    public RuntimeEnumAdapter(Class<E> r2) {
        o.g(r2, "javaType");
        super(a.e(r2));
        this.javaType = r2;
    }

    private final Method getFromValueMethod() {
        Method r0 = this.fromValueMethod;
        if (r0 != null) goto L7;
        Method r1 = this.javaType.getMethod("fromValue", new Class[]{Integer.TYPE});
        this.fromValueMethod = r1;
        o.b(r1, "javaType.getMethod(\"from…romValueMethod = it\n    }");
        return r1;
    L7:
        return r0;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof RuntimeEnumAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(((RuntimeEnumAdapter) r2).getType(), getType()) == false) goto L7;
        return true;
    }

    @Override // com.squareup.wire.EnumAdapter
    protected E fromValue(int r3) {
        Object r2 = getFromValueMethod().invoke(null, new Object[]{Integer.valueOf(r3)});
        if (r2 == null) goto L7;
        return (E) r2;
    L7:
        throw new b0("null cannot be cast to non-null type E");
    }

    public int hashCode() {
        d<?> r0 = getType();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }
}
