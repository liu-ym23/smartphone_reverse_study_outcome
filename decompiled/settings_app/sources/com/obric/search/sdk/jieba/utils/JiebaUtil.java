package com.obric.search.sdk.jieba.utils;

import com.android.settings.utils.HanziToPinyin;
import com.obric.search.api.query.impl.FullTextSearchQuery;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.common.log.RuntimeLogger;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JiebaUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/search/sdk/jieba/utils/JiebaUtil;", "", "()V", "TAG", "", "buildJiebaFullTextSearchQuery", "Lcom/obric/search/api/query/impl/FullTextSearchQuery;", "tokenizer", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "rawQuery", "hmm", "", "loadDict", "", "tokenizeDocument", "", "text", "tokenizeQuery", "unloadDict", "jiebaExtension_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JiebaUtil {
    public static final JiebaUtil INSTANCE = null;
    private static final String TAG = "JiebaUtil";

    static {
        INSTANCE = new JiebaUtil();
    }

    private JiebaUtil() {
    }

    public static /* synthetic */ List tokenizeDocument$default(JiebaUtil r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.tokenizeDocument(r1, r2);
    }

    public final List<String> tokenizeDocument(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        JiebaUtil r2 = this;     // Catch: Throwable -> L7
        List<String> r5 = JiebaNativeHelper.INSTANCE.tokenizeDocument(r3, r4);     // Catch: Throwable -> L7
        if (r5 != null) goto L16;
        RuntimeLogger.INSTANCE.error(TAG, "tokenizeDocument error! tokenizeDocument return null!");     // Catch: Throwable -> L7
        return CollectionsKt.emptyList();
    L16:
        return r5;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Throwable r7 = Result.m1511exceptionOrNullimpl(Result.m1508constructorimpl(ResultKt.createFailure(th)));
        if (r7 == null) goto L13;
        RuntimeLogger.INSTANCE.error(TAG, "tokenizeDocument error! " + r7.getMessage());
        return CollectionsKt.emptyList();
    L13:
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ List tokenizeQuery$default(JiebaUtil r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.tokenizeQuery(r1, r2);
    }

    public final List<String> tokenizeQuery(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        JiebaUtil r2 = this;     // Catch: Throwable -> L7
        List<String> r5 = JiebaNativeHelper.INSTANCE.tokenizeQuery(r3, r4);     // Catch: Throwable -> L7
        if (r5 != null) goto L16;
        RuntimeLogger.INSTANCE.error(TAG, "tokenizeDocument error! tokenizeDocument return null!");     // Catch: Throwable -> L7
        return CollectionsKt.emptyList();
    L16:
        return r5;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Throwable r7 = Result.m1511exceptionOrNullimpl(Result.m1508constructorimpl(ResultKt.createFailure(th)));
        if (r7 == null) goto L13;
        RuntimeLogger.INSTANCE.error(TAG, "tokenizeDocument error! " + r7.getMessage());
        return CollectionsKt.emptyList();
    L13:
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ FullTextSearchQuery buildJiebaFullTextSearchQuery$default(JiebaUtil r0, FullTextSearchSchema.TOKENIZER r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        return r0.buildJiebaFullTextSearchQuery(r1, r2, r3);
    }

    public final FullTextSearchQuery buildJiebaFullTextSearchQuery(FullTextSearchSchema.TOKENIZER r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "tokenizer");
        Intrinsics.checkNotNullParameter(r12, "rawQuery");
        return FullTextSearchQuery.Companion.parse(r11, CollectionsKt.joinToString$default(tokenizeQuery(r12, r13), HanziToPinyin.Token.SEPARATOR, null, null, 0, null, null, 62, null));
    }

    public final void loadDict() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        JiebaUtil r3 = this;     // Catch: Throwable -> L4
        JiebaNativeHelper.INSTANCE.loadDict();     // Catch: Throwable -> L4
        Object r4 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L13;
        RuntimeLogger.INSTANCE.error(TAG, "loadDict error! " + r5.getMessage());
        return;
    L13:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void unloadDict() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        JiebaUtil r3 = this;     // Catch: Throwable -> L4
        JiebaNativeHelper.INSTANCE.unloadDict();     // Catch: Throwable -> L4
        Object r4 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L13;
        RuntimeLogger.INSTANCE.error(TAG, "unloadDict error! " + r5.getMessage());
        return;
    L13:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
