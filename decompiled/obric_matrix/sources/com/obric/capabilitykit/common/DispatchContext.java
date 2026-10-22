package com.obric.capabilitykit.common;

import android.content.Context;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/obric/capabilitykit/common/DispatchContext;", "", "context", "Landroid/content/Context;", "questionId", "", "(Landroid/content/Context;Ljava/lang/Long;)V", "getContext", "()Landroid/content/Context;", "getQuestionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Landroid/content/Context;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/DispatchContext;", "equals", "", "other", "hashCode", "", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DispatchContext {
    private final Context context;
    private final Long questionId;

    public DispatchContext(Context r2, Long r3) {
        o.f(r2, "context");
        this.context = r2;
        this.questionId = r3;
    }

    public static /* synthetic */ DispatchContext copy$default(DispatchContext r0, Context r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.context;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.questionId;
    L9:
        return r0.copy(r1, r2);
    }

    public final Context component1() {
        return this.context;
    }

    public final Long component2() {
        return this.questionId;
    }

    public final DispatchContext copy(Context r1, Long r2) {
        o.f(r1, "context");
        return new DispatchContext(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DispatchContext) == true) goto L8;
        return false;
    L8:
        DispatchContext r6 = (DispatchContext) r5;
        if (o.a(this.context, r6.context) == true) goto L12;
        return false;
    L12:
        if (o.a(this.questionId, r6.questionId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public int hashCode() {
        int r0 = this.context.hashCode() * 31;
        Long r1 = this.questionId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DispatchContext(context=" + this.context + ", questionId=" + this.questionId + ')';
    }
}
