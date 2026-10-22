package com.obric.capabilitykit.common;

import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/capabilitykit/common/FunctionMeta;", "", "name", "", "desc", "params", "", "Lcom/obric/capabilitykit/common/Parameter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDesc", "()Ljava/lang/String;", "getName", "getParams", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FunctionMeta {
    private final String desc;
    private final String name;
    private final List<Parameter> params;

    public FunctionMeta(String r2, String r3, List<Parameter> r4) {
        o.f(r2, "name");
        o.f(r3, "desc");
        o.f(r4, "params");
        this.name = r2;
        this.desc = r3;
        this.params = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FunctionMeta copy$default(FunctionMeta r0, String r1, String r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.desc;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.params;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.desc;
    }

    public final List<Parameter> component3() {
        return this.params;
    }

    public final FunctionMeta copy(String r1, String r2, List<Parameter> r3) {
        o.f(r1, "name");
        o.f(r2, "desc");
        o.f(r3, "params");
        return new FunctionMeta(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FunctionMeta) == true) goto L8;
        return false;
    L8:
        FunctionMeta r6 = (FunctionMeta) r5;
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (o.a(this.desc, r6.desc) == true) goto L15;
        return false;
    L15:
        if (o.a(this.params, r6.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Parameter> getParams() {
        return this.params;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.desc.hashCode()) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "FunctionMeta(name=" + this.name + ", desc=" + this.desc + ", params=" + this.params + ')';
    }
}
