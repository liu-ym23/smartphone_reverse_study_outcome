package com.obric.search.api.schema.impl.bean;

import android.icu.text.PluralRules;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentTokenPosition.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J!\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0005HÆ\u0003J5\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032 \b\u0002\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R)\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/search/api/schema/impl/bean/DocumentTokenPosition;", "", "id", "", "columnsTokenPosition", "", "Lkotlin/Pair;", "", "(JLjava/util/List;)V", "getColumnsTokenPosition", "()Ljava/util/List;", "getId", "()J", "component1", "component2", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DocumentTokenPosition {
    private final List<List<Pair<Integer, Integer>>> columnsTokenPosition;
    private final long id;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentTokenPosition copy$default(DocumentTokenPosition r0, long r1, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.columnsTokenPosition;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.id;
    }

    public final List<List<Pair<Integer, Integer>>> component2() {
        return this.columnsTokenPosition;
    }

    public final DocumentTokenPosition copy(long r1, List<? extends List<Pair<Integer, Integer>>> r3) {
        Intrinsics.checkNotNullParameter(r3, "columnsTokenPosition");
        return new DocumentTokenPosition(r1, r3);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DocumentTokenPosition) == true) goto L8;
        return false;
    L8:
        DocumentTokenPosition r9 = (DocumentTokenPosition) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.columnsTokenPosition, r9.columnsTokenPosition) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.id) * 31) + this.columnsTokenPosition.hashCode();
    }

    public String toString() {
        return "DocumentTokenPosition(id=" + this.id + ", columnsTokenPosition=" + this.columnsTokenPosition + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocumentTokenPosition(long r2, List<? extends List<Pair<Integer, Integer>>> r4) {
        Intrinsics.checkNotNullParameter(r4, "columnsTokenPosition");
        this.id = r2;
        this.columnsTokenPosition = r4;
    }

    public final long getId() {
        return this.id;
    }

    public final List<List<Pair<Integer, Integer>>> getColumnsTokenPosition() {
        return this.columnsTokenPosition;
    }
}
