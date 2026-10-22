package com.obric.search.api.utils;

import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.api.schema.impl.bean.DocumentTokenPosition;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.storage.sqlite.fts5.SQLiteFts5Extension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentsUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"TAG", "", "getOTokenizerColumnHighlightPosition", "", "Lkotlin/Pair;", "", "columnIndex", "columnContent", "tokenPosition", "Lcom/obric/search/api/schema/impl/bean/DocumentTokenPosition;", "tokenizer", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DocumentsUtilKt {
    private static final String TAG = "DocumentsUtil";

    public static final List<Pair<Integer, Integer>> getOTokenizerColumnHighlightPosition(int r4, String r5, DocumentTokenPosition r6, FullTextSearchSchema.TOKENIZER r7) {
        Intrinsics.checkNotNullParameter(r5, "columnContent");
        Intrinsics.checkNotNullParameter(r6, "tokenPosition");
        Intrinsics.checkNotNullParameter(r7, "tokenizer");
        boolean r1 = false;
        if (r4 < 0) goto L8;
        if (r4 >= r6.getColumnsTokenPosition().size()) goto L8;
        r1 = true;
    L8:
        if (r1 == true) goto L11;
        RuntimeLogger.INSTANCE.error(TAG, "columnIndex error!");
        return CollectionsKt.emptyList();
    L11:
        List<Triple<String, Integer, Integer>> r8 = SQLiteFts5Extension.INSTANCE.getOTokenizerResult(r7.getTypeCode(), r5);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L18
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<Pair<Integer, Integer>> r11 = r6.getColumnsTokenPosition().get(r4).iterator();     // Catch: Throwable -> L18
    L14:
        if (r11.hasNext() == false) goto L16;
        Pair<Integer, Integer> r12 = r11.next();     // Catch: Throwable -> L18
        r10.add(new Pair(r8.get(r12.getFirst().intValue()).getSecond(), Integer.valueOf(r8.get(r12.getSecond().intValue()).getThird().intValue() - 1)));     // Catch: Throwable -> L18
        goto L14
    L16:
        Object r13 = Result.m1508constructorimpl(r10);     // Catch: Throwable -> L18
    L20:
        Throwable r14 = Result.m1511exceptionOrNullimpl(r13);
        if (r14 == null) goto L25;
        RuntimeLogger.INSTANCE.error(TAG, "getColumnHighlightPosition error\n" + ExceptionsKt.stackTraceToString(r14));
        r13 = CollectionsKt.emptyList();
    L25:
        return (List) r13;
    L18:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}
