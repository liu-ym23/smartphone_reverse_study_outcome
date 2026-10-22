package com.obric.capabilitykit.common.execution.eca;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0000H\u0016R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "", "()V", "paramName", "", "getParamName$annotations", "getParamName", "()Ljava/lang/String;", "setParamName", "(Ljava/lang/String;)V", "parent", "Lcom/obric/capabilitykit/common/execution/eca/ECAAction;", "getParent", "()Lcom/obric/capabilitykit/common/execution/eca/ECAAction;", "setParent", "(Lcom/obric/capabilitykit/common/execution/eca/ECAAction;)V", "getName", "getValue", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ECAInputParam {
    private String paramName;
    private ECAAction parent;

    public ECAInputParam() {
        this.paramName = "";
    }

    @Deprecated(message = "Not supposed to be accessed; use `getName()` instead.")
    public static /* synthetic */ void getParamName$annotations() {
    }

    public String getName() {
        return this.paramName;
    }

    public final String getParamName() {
        return this.paramName;
    }

    public final ECAAction getParent() {
        return this.parent;
    }

    public ECAInputParam getValue() {
        return this;
    }

    public final void setParamName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.paramName = r2;
    }

    public final void setParent(ECAAction r1) {
        this.parent = r1;
    }
}
