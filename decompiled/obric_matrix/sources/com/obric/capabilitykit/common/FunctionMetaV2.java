package com.obric.capabilitykit.common;

import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/FunctionMetaV2;", "", "name", "", "desc", "params", "", "Lcom/obric/capabilitykit/common/Parameter;", "register2cloud", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getDesc", "()Ljava/lang/String;", "getName", "getParams", "()Ljava/util/List;", "getRegister2cloud", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FunctionMetaV2 {
    private final String desc;
    private final String name;
    private final List<Parameter> params;
    private final boolean register2cloud;

    public FunctionMetaV2(String r2, String r3, List<Parameter> r4, boolean r5) {
        o.f(r2, "name");
        o.f(r3, "desc");
        o.f(r4, "params");
        this.name = r2;
        this.desc = r3;
        this.params = r4;
        this.register2cloud = r5;
    }

    public /* synthetic */ FunctionMetaV2(String r1, String r2, List r3, boolean r4, int r5, g r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FunctionMetaV2 copy$default(FunctionMetaV2 r0, String r1, String r2, List r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.name;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.desc;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.params;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.register2cloud;
    L15:
        return r0.copy(r1, r2, r3, r4);
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

    public final boolean component4() {
        return this.register2cloud;
    }

    public final FunctionMetaV2 copy(String r1, String r2, List<Parameter> r3, boolean r4) {
        o.f(r1, "name");
        o.f(r2, "desc");
        o.f(r3, "params");
        return new FunctionMetaV2(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FunctionMetaV2) == true) goto L8;
        return false;
    L8:
        FunctionMetaV2 r6 = (FunctionMetaV2) r5;
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (o.a(this.desc, r6.desc) == true) goto L15;
        return false;
    L15:
        if (o.a(this.params, r6.params) == true) goto L18;
        return false;
    L18:
        if (this.register2cloud == r6.register2cloud) goto L20;
        return false;
    L20:
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

    public final boolean getRegister2cloud() {
        return this.register2cloud;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((((this.name.hashCode() * 31) + this.desc.hashCode()) * 31) + this.params.hashCode()) * 31;
        boolean r2 = this.register2cloud;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public String toString() {
        return "FunctionMetaV2(name=" + this.name + ", desc=" + this.desc + ", params=" + this.params + ", register2cloud=" + this.register2cloud + ')';
    }
}
