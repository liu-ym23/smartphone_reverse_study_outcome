package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.google.gson.y.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/common/Plugin;", "", "packageName", "", "functions", "", "Lcom/obric/capabilitykit/common/Tool;", "(Ljava/lang/String;Ljava/util/List;)V", "getFunctions", "()Ljava/util/List;", "getPackageName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Plugin {
    private final List<Tool> functions;

    @c("package")
    private final String packageName;

    public Plugin(String r2, List<Tool> r3) {
        o.f(r2, "packageName");
        o.f(r3, "functions");
        this.packageName = r2;
        this.functions = r3;
    }

    public /* synthetic */ Plugin(String r1, List r2, int r3, g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new ArrayList();
    L5:
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Plugin copy$default(Plugin r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.functions;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.packageName;
    }

    public final List<Tool> component2() {
        return this.functions;
    }

    public final Plugin copy(String r1, List<Tool> r2) {
        o.f(r1, "packageName");
        o.f(r2, "functions");
        return new Plugin(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Plugin) == true) goto L8;
        return false;
    L8:
        Plugin r6 = (Plugin) r5;
        if (o.a(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.functions, r6.functions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<Tool> getFunctions() {
        return this.functions;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (this.packageName.hashCode() * 31) + this.functions.hashCode();
    }

    public String toString() {
        return "Plugin(packageName=" + this.packageName + ", functions=" + this.functions + ')';
    }
}
