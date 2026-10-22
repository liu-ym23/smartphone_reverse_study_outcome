package com.obric.search.api.schema.impl.bean;

import android.icu.text.PluralRules;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentIsFullMatch.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/search/api/schema/impl/bean/DocumentIsFullMatch;", "", "id", "", "isFullMatch", "", "", "(JLjava/util/List;)V", "getId", "()J", "()Ljava/util/List;", "component1", "component2", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DocumentIsFullMatch {
    private final long id;
    private final List<Boolean> isFullMatch;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentIsFullMatch copy$default(DocumentIsFullMatch r0, long r1, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.isFullMatch;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.id;
    }

    public final List<Boolean> component2() {
        return this.isFullMatch;
    }

    public final DocumentIsFullMatch copy(long r1, List<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "isFullMatch");
        return new DocumentIsFullMatch(r1, r3);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DocumentIsFullMatch) == true) goto L8;
        return false;
    L8:
        DocumentIsFullMatch r9 = (DocumentIsFullMatch) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isFullMatch, r9.isFullMatch) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.id) * 31) + this.isFullMatch.hashCode();
    }

    public String toString() {
        return "DocumentIsFullMatch(id=" + this.id + ", isFullMatch=" + this.isFullMatch + ')';
    }

    public DocumentIsFullMatch(long r2, List<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "isFullMatch");
        this.id = r2;
        this.isFullMatch = r4;
    }

    public final long getId() {
        return this.id;
    }

    public final List<Boolean> isFullMatch() {
        return this.isFullMatch;
    }
}
