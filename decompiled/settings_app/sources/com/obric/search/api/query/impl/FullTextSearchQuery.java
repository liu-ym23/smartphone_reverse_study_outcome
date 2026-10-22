package com.obric.search.api.query.impl;

import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.utils.HanziToPinyin;
import com.obric.search.api.query.intf.IQuery;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.api.utils.PinyinUtil;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.storage.sqlite.fts5.SQLiteFts5Extension;
import com.obric.search.storage.sqlite.utils.AuxiliaryFuncUtils;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.streams.jdk8.StreamsKt;
import kotlin.text.StringsKt;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: FullTextSearchQuery.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000b\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000J\u0018\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/search/api/query/impl/FullTextSearchQuery;", "Lcom/obric/search/api/query/intf/IQuery;", "inputMatchClause", "", "(Ljava/lang/String;)V", "matchClause", "getMatchClause", "()Ljava/lang/String;", "matchClauseStringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "addColumnFilter", "colName", "", "isExcluded", "", "and", IndexDatabaseHelper.SavedQueriesColums.QUERY, "mergeQuery", "booleanOperator", "not", "or", "Companion", "Operator", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchQuery implements IQuery {
    public static final Companion Companion = null;
    public static final int DEFAULT_SPLIT_PINYIN_MAX_LEN = 20;
    private static final String SAME_PINYIN_CONTROL_SEQUENCE = "\t1\t";
    private static final String SYNONYM_PHRASE_CONTROL_SEQUENCE = "\t0\t";
    private static final String TAG = "FullTextSearchQuery";
    private final StringBuilder matchClauseStringBuilder;

    /* JADX INFO: compiled from: FullTextSearchQuery.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006J\u001c\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014J&\u0010\u0012\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0004J>\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00100\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u0014J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0014Jn\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060$2\u0006\u0010%\u001a\u00020\u00042\n\u0010&\u001a\u00060'j\u0002`(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00100\u00102\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00100\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0016\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006J\u0010\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0010\u00100\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0010\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/search/api/query/impl/FullTextSearchQuery$Companion;", "", "()V", "DEFAULT_SPLIT_PINYIN_MAX_LEN", "", "SAME_PINYIN_CONTROL_SEQUENCE", "", "SYNONYM_PHRASE_CONTROL_SEQUENCE", "TAG", "buildEndWithLetterOrDigitPhraseQuery", "Lcom/obric/search/api/query/impl/FullTextSearchQuery;", "content", "buildInitialTokenQuery", "phrase", "buildNearQuery", "phraseList", "", "n", "buildPhraseQuery", "isPrefixQuery", "", "operator", "Lcom/obric/search/api/query/impl/FullTextSearchQuery$Operator;", "buildPinyinQuery", "maxLen", "buildSamePinyinQuery", "excludedMap", "", "numberLimit", "isInitialTokenQuery", "buildSynonymPhraseQuery", "buildSynonymPhraseQueryForTest", "buildTokenizerSamePinyinQuery", "getAllSamePinyinPhrase", "", "result", "", "pos", "currentString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "codePoints", "pinyin", "parse", "tokenizer", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "input", "parseOTokenizer1", "parseOTokenizer2", "sqliteEscape", "keyWord", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: FullTextSearchQuery.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[FullTextSearchSchema.TOKENIZER.values().length];
                r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_3_FOR_TEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_4_FOR_TEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        private final String sqliteEscape(String r7) {
            return StringsKt.replace$default(r7, "\"", "\"\"", false, 4, null);
        }

        public static /* synthetic */ FullTextSearchQuery buildPhraseQuery$default(Companion r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.buildPhraseQuery(r1, r2);
        }

        public final FullTextSearchQuery buildPhraseQuery(String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "phrase");
            DefaultConstructorMarker r0 = null;
            if (r5 == false) goto L6;
            return new FullTextSearchQuery("\"" + sqliteEscape(StringsKt.trim(r4).toString()) + "\"*", r0);
        L6:
            return new FullTextSearchQuery("\"" + sqliteEscape(StringsKt.trim(r4).toString()) + '\"', r0);
        }

        public static /* synthetic */ FullTextSearchQuery buildPhraseQuery$default(Companion r0, List r1, Operator r2, boolean r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = false;
        L6:
            return r0.buildPhraseQuery(r1, r2, r3);
        }

        public final FullTextSearchQuery buildPhraseQuery(List<String> r5, Operator r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "phraseList");
            Intrinsics.checkNotNullParameter(r6, "operator");
            StringBuilder r4 = new StringBuilder();
            Iterator<T> r8 = r5.iterator();
            int r0 = 0;
        L4:
            if (r8.hasNext() == false) goto L16;
            Object r1 = r8.next();
            int r2 = r0 + 1;
            if (r0 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            String r3 = (String) r1;
            if (r0 <= 0) goto L12;
            r4.append(HanziToPinyin.Token.SEPARATOR + r6.name() + TokenParser.SP);
        L12:
            if (r7 == false) goto L14;
            r4.append("\"" + FullTextSearchQuery.Companion.sqliteEscape(StringsKt.trim(r3).toString()) + "\"*");
        L15:
            r0 = r2;
            goto L4
        L14:
            r4.append("\"" + FullTextSearchQuery.Companion.sqliteEscape(StringsKt.trim(r3).toString()) + '\"');
            goto L15
        L16:
            String r9 = r4.toString();
            Intrinsics.checkNotNullExpressionValue(r9, "sb.toString()");
            return new FullTextSearchQuery(r9, null);
        }

        public static /* synthetic */ FullTextSearchQuery buildSynonymPhraseQuery$default(Companion r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.buildSynonymPhraseQuery(r1, r2);
        }

        public final FullTextSearchQuery buildSynonymPhraseQuery(String r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r9, "phrase");
            String r11 = StringsKt.trim(r9).toString();
            List<String> r0 = SQLiteFts5Extension.INSTANCE.getSynonyms(r11);
            if (r0.isEmpty() == true) goto L5;
            DefaultConstructorMarker r3 = null;
            if (r10 == false) goto L19;
            StringBuilder r12 = new StringBuilder();
            Iterator<T> r1 = r0.iterator();
        L10:
            if (r1.hasNext() == false) goto L18;
            String r5 = (String) r1.next();
            if (r12.length() <= 0) goto L14;
            boolean r6 = true;
        L15:
            if (r6 == false) goto L17;
            r12.append(" OR ");
        L17:
            r12 = r12.append("\"" + FullTextSearchQuery.Companion.sqliteEscape(r5) + "\"*");
            Intrinsics.checkNotNullExpressionValue(r12, "sb.append(\"\\\"${sqliteEscape(w)}\\\"*\")");
            goto L10
        L14:
            r6 = false;
            goto L15
        L18:
            String r13 = r12.toString();
            Intrinsics.checkNotNullExpressionValue(r13, "sb.toString()");
            return new FullTextSearchQuery(r13, r3);
        L19:
            StringBuilder r14 = new StringBuilder();
            Iterator<T> r2 = r0.iterator();
        L21:
            if (r2.hasNext() == false) goto L29;
            String r7 = (String) r2.next();
            if (r14.length() <= 0) goto L25;
            boolean r8 = true;
        L26:
            if (r8 == false) goto L28;
            r14.append(" OR ");
        L28:
            r14 = r14.append("\"" + FullTextSearchQuery.Companion.sqliteEscape(r7) + '\"');
            Intrinsics.checkNotNullExpressionValue(r14, "sb.append(\"\\\"${sqliteEscape(w)}\\\"\")");
            goto L21
        L25:
            r8 = false;
            goto L26
        L29:
            String r15 = r14.toString();
            Intrinsics.checkNotNullExpressionValue(r15, "sb.toString()");
            return new FullTextSearchQuery(r15, r3);
        L5:
            return buildPhraseQuery(r11, r10);
        }

        public static /* synthetic */ FullTextSearchQuery buildSynonymPhraseQueryForTest$default(Companion r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.buildSynonymPhraseQueryForTest(r1, r2);
        }

        public final FullTextSearchQuery buildSynonymPhraseQueryForTest(String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "phrase");
            String r7 = StringsKt.trim(r5).toString();
            DefaultConstructorMarker r0 = null;
            if (r6 == false) goto L6;
            return new FullTextSearchQuery("\"" + sqliteEscape(r7) + "\"* OR \"\t0\t" + sqliteEscape(r7) + '\"', r0);
        L6:
            return new FullTextSearchQuery("\"" + sqliteEscape(r7) + "\" OR \"\t0\t" + sqliteEscape(r7) + '\"', r0);
        }

        public final FullTextSearchQuery buildNearQuery(List<String> r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "phraseList");
            StringBuilder r0 = new StringBuilder("\"" + sqliteEscape(r7.get(0)) + '\"');
            int r1 = r7.size();
            int r3 = 1;
        L3:
            if (r3 >= r1) goto L6;
            r0.append(" \"" + sqliteEscape(r7.get(r3)) + '\"');
            r3 = r3 + 1;
            goto L3
        L6:
            return new FullTextSearchQuery("NEAR(" + r0 + ", " + r8 + ')', null);
        }

        public final FullTextSearchQuery buildInitialTokenQuery(String r4) {
            Intrinsics.checkNotNullParameter(r4, "phrase");
            return new FullTextSearchQuery("^\"" + sqliteEscape(StringsKt.trim(r4).toString()) + '\"', null);
        }

        public final FullTextSearchQuery buildEndWithLetterOrDigitPhraseQuery(String r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            String r4 = StringsKt.trim(r3).toString();
            String r0 = r4;
            if (Character.isLowerCase(StringsKt.last(r0)) == true) goto L11;
            if (Character.isUpperCase(StringsKt.last(r0)) == true) goto L11;
            if (Character.isDigit(StringsKt.last(r0)) == true) goto L11;
            return buildPhraseQuery(r4, false);
        L11:
            return buildPhraseQuery(r4, true);
        }

        public static /* synthetic */ FullTextSearchQuery buildPinyinQuery$default(Companion r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = 20;
        L6:
            return r0.buildPinyinQuery(r1, r2);
        }

        public final FullTextSearchQuery buildPinyinQuery(String r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "content");
            String r8 = StringsKt.trim(r6).toString();
            if (r8.length() > r7) goto L5;
            int r0 = r8.length();
            boolean r1 = false;
            int r2 = 0;
        L7:
            if (r2 >= r0) goto L14;
            char r3 = r8.charAt(r2);
            if (Character.isLowerCase(r3) == true) goto L13;
            if (Character.isUpperCase(r3) == true) goto L13;
        L15:
            if (r1 == true) goto L19;
            return buildEndWithLetterOrDigitPhraseQuery(r8);
        L19:
            return new FullTextSearchQuery(AuxiliaryFuncUtils.INSTANCE.splitPinyinAuxiliaryFunc(r8, r7), null);
        L13:
            r2 = r2 + 1;
            goto L7
        L14:
            r1 = true;
            goto L15
        L5:
            return buildEndWithLetterOrDigitPhraseQuery(r8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FullTextSearchQuery buildSamePinyinQuery$default(Companion r0, String r1, Map r2, int r3, boolean r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r2 = MapsKt.emptyMap();
        L6:
            if ((r5 & 4) == 0) goto L9;
            r3 = 128;
        L9:
            if ((r5 & 8) == 0) goto L12;
            r4 = false;
        L12:
            return r0.buildSamePinyinQuery(r1, r2, r3, r4);
        }

        public final FullTextSearchQuery buildSamePinyinQuery(String r10, Map<Integer, ? extends List<String>> r11, int r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r10, "content");
            Intrinsics.checkNotNullParameter(r11, "excludedMap");
            IntStream r14 = r10.codePoints();
            Intrinsics.checkNotNullExpressionValue(r14, "content.codePoints()");
            List<Integer> r5 = StreamsKt.toList(r14);
            ArrayList r6 = new ArrayList();
            Iterator<Integer> r15 = r5.iterator();
        L4:
            if (r15.hasNext() == false) goto L6;
            r6.add(PinyinUtil.INSTANCE.getPinyinByUnicode(r15.next().intValue()));
            goto L4
        L6:
            ArrayList r16 = new ArrayList();
            getAllSamePinyinPhrase(r16, 0, new StringBuilder(), r5, r6, r11, r12);
            RuntimeLogger.INSTANCE.debug(FullTextSearchQuery.TAG, "result size is: " + r16.size());
            StringBuilder r9 = new StringBuilder();
            int r17 = r16.size();
            int r18 = 0;
        L7:
            if (r18 >= r17) goto L14;
            if (r18 == 0) goto L10;
            r9.append(" OR ");
        L10:
            if (r13 == false) goto L12;
            String r0 = "^\"" + r16.get(r18) + '\"';
        L13:
            r9.append(r0);
            r18 = r18 + 1;
            goto L7
        L12:
            r0 = r16.get(r18);
            goto L13
        L14:
            String r19 = r9.toString();
            Intrinsics.checkNotNullExpressionValue(r19, "query.toString()");
            return new FullTextSearchQuery(r19, null);
        }

        public static /* synthetic */ FullTextSearchQuery buildTokenizerSamePinyinQuery$default(Companion r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = false;
        L6:
            return r0.buildTokenizerSamePinyinQuery(r1, r2);
        }

        public final FullTextSearchQuery buildTokenizerSamePinyinQuery(String r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "content");
            String r7 = StringsKt.trim(r5).toString();
            DefaultConstructorMarker r0 = null;
            if (r6 == false) goto L7;
            return new FullTextSearchQuery("^\"\t1\t" + sqliteEscape(r7) + '\"', r0);
        L7:
            return new FullTextSearchQuery("\"\t1\t" + sqliteEscape(r7) + '\"', r0);
        }

        public final FullTextSearchQuery parse(FullTextSearchSchema.TOKENIZER r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tokenizer");
            Intrinsics.checkNotNullParameter(r3, "input");
            int r4 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
            if (r4 == 1) goto L15;
            if (r4 == 2) goto L15;
            if (r4 == 3) goto L16;
            if (r4 == 4) goto L16;
            throw new NoWhenBranchMatchedException();
        L16:
            return parseOTokenizer2(r3);
        L15:
            return parseOTokenizer1(r3);
        }

        private final FullTextSearchQuery parseOTokenizer1(String r10) {
            StringBuilder r0 = new StringBuilder();
            List r1 = StringsKt.split$default(r10, new char[]{TokenParser.SP}, false, 0, 6, null);
            Iterator r2 = r1.iterator();
            int r3 = 0;
        L4:
            if (r2.hasNext() == false) goto L23;
            String r4 = (String) r2.next();
            r3 = r3 + 1;
            String r5 = r4;
            if (r5.length() != 0) goto L8;
            boolean r6 = true;
        L9:
            if (r6 == true) goto L4;
            if (Character.isLowerCase(StringsKt.last(r5)) == false) goto L14;
        L19:
            r0.append("\"" + sqliteEscape(r4) + "\"*");
        L21:
            if (r3 == r1.size()) goto L4;
            r0.append(" OR ");
            goto L4
        L14:
            if (Character.isUpperCase(StringsKt.last(r5)) == true) goto L19;
            if (Character.isDigit(StringsKt.last(r5)) == true) goto L19;
            r0.append("\"" + sqliteEscape(r4) + '\"');
            goto L21
        L8:
            r6 = false;
            goto L9
        L23:
            String r11 = r0.toString();
            Intrinsics.checkNotNullExpressionValue(r11, "sb.toString()");
            return new FullTextSearchQuery(r11, null);
        }

        private final FullTextSearchQuery parseOTokenizer2(String r12) {
            StringBuilder r0 = new StringBuilder();
            List r1 = StringsKt.split$default(r12, new char[]{TokenParser.SP}, false, 0, 6, null);
            Iterator r2 = r1.iterator();
            int r3 = 0;
        L4:
            if (r2.hasNext() == false) goto L34;
            String r4 = (String) r2.next();
            r3 = r3 + 1;
            String r5 = r4;
            if (r5.length() != 0) goto L8;
            boolean r6 = true;
        L9:
            if (r6 == true) goto L4;
            int r7 = r4.length();
            int r8 = 0;
        L12:
            if (r8 >= r7) goto L19;
            char r9 = r4.charAt(r8);
            if (Character.isLowerCase(r9) == true) goto L18;
            if (Character.isUpperCase(r9) == true) goto L18;
            boolean r10 = false;
        L20:
            if (r10 == false) goto L23;
            r0.append(AuxiliaryFuncUtils.INSTANCE.splitPinyinAuxiliaryFunc(r4, 20));
        L32:
            if (r3 == r1.size()) goto L4;
            r0.append(" OR ");
            goto L4
        L23:
            if (Character.isLowerCase(StringsKt.last(r5)) == false) goto L25;
        L30:
            r0.append("\"" + sqliteEscape(r4) + "\"*");
            goto L32
        L25:
            if (Character.isUpperCase(StringsKt.last(r5)) == true) goto L30;
            if (Character.isDigit(StringsKt.last(r5)) == true) goto L30;
            r0.append("\"" + sqliteEscape(r4) + '\"');
        L18:
            r8 = r8 + 1;
            goto L12
        L19:
            r10 = true;
            goto L20
        L8:
            r6 = false;
            goto L9
        L34:
            String r13 = r0.toString();
            Intrinsics.checkNotNullExpressionValue(r13, "sb.toString()");
            return new FullTextSearchQuery(r13, null);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v4, types: [T, java.util.List] */
        private final void getAllSamePinyinPhrase(List<String> r21, int r22, StringBuilder r23, List<Integer> r24, List<? extends List<String>> r25, Map<Integer, ? extends List<String>> r26, int r27) {
            if (r21.size() < r27) goto L6;
            return;
        L6:
            if (r22 != r24.size()) goto L12;
            String r0 = r23.toString();
            Intrinsics.checkNotNullExpressionValue(r0, "currentString.toString()");
            r21.add(r0);
            if (r21.size() < r27) goto L46;
            RuntimeLogger.INSTANCE.debug(FullTextSearchQuery.TAG, "getAllSamePinyinPhrase number limit, return");
            return;
        L46:
            return;
        L12:
            if (r22 == 0) goto L14;
            r23.append('+');
        L14:
            Ref.ObjectRef r1 = new Ref.ObjectRef();
            r1.element = r25.get(r22);
            int r2 = r24.get(r22).intValue();
            List<String> r3 = r26.get(Integer.valueOf(r2));
            if (r3 != null) goto L17;
        L26:
            char r7 = '\"';
            String r6 = "\"";
            if (((List) r1.element).isEmpty() == false) goto L29;
            StringBuilder r4 = new StringBuilder("\"");
            char[] r5 = Character.toChars(r2);
            Intrinsics.checkNotNullExpressionValue(r5, "toChars(currentCodePoint)");
            String r8 = r4.append(sqliteEscape(new String(r5))).append('\"').toString();
            r23.append(r8);
            getAllSamePinyinPhrase(r21, r22 + 1, r23, r24, r25, r26, r27);
            r23.setLength(r23.length() - r8.length());
        L36:
            if (r22 == 0) goto L47;
            r23.setLength(r23.length() - 1);
            return;
        L47:
            return;
        L29:
            Iterator r16 = ((List) r1.element).iterator();
        L31:
            if (r16.hasNext() == false) goto L36;
            String r9 = r6 + sqliteEscape((String) r16.next()) + r7;
            r23.append(r9);
            String r18 = r6;
            char r19 = r7;
            getAllSamePinyinPhrase(r21, r22 + 1, r23, r24, r25, r26, r27);
            r23.setLength(r23.length() - r9.length());
            if (r21.size() >= r27) goto L34;
            r6 = r18;
            r7 = r19;
            goto L31
        L34:
            return;
        L17:
            if (r3.isEmpty() == true) goto L26;
            Iterable r10 = (Iterable) r1.element;
            ArrayList r11 = new ArrayList();
            Iterator r12 = r10.iterator();
        L21:
            if (r12.hasNext() == false) goto L25;
            Object r13 = r12.next();
            if ((!r3.contains((String) r13)) == false) goto L21;
            r11.add(r13);
            goto L21
        L25:
            r1.element = r11;
            goto L26
        }
    }

    /* JADX INFO: compiled from: FullTextSearchQuery.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/query/impl/FullTextSearchQuery$Operator;", "", "(Ljava/lang/String;I)V", "AND", "OR", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum Operator extends Enum<Operator> {
        private static final /* synthetic */ Operator[] $VALUES = null;
        public static final Operator AND = null;
        public static final Operator OR = null;

        private static final /* synthetic */ Operator[] $values() {
            return new Operator[]{AND, OR};
        }

        public static Operator valueOf(String r1) {
            return (Operator) Enum.valueOf(Operator.class, r1);
        }

        public static Operator[] values() {
            return (Operator[]) $VALUES.clone();
        }

        private Operator(String r1, int r2) {
            super(r1, r2);
        }

        static {
            AND = new Operator("AND", 0);
            OR = new Operator("OR", 1);
            $VALUES = $values();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ FullTextSearchQuery(String r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    private FullTextSearchQuery(String r2) {
        this.matchClauseStringBuilder = new StringBuilder(r2);
    }

    public final String getMatchClause() {
        String r1 = this.matchClauseStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(r1, "matchClauseStringBuilder.toString()");
        return r1;
    }

    private final FullTextSearchQuery mergeQuery(FullTextSearchQuery r4, String r5) {
        this.matchClauseStringBuilder.insert(0, '(');
        this.matchClauseStringBuilder.append(") " + r5 + " (" + r4.getMatchClause() + ')');
        return this;
    }

    public final FullTextSearchQuery not(FullTextSearchQuery r2) {
        Intrinsics.checkNotNullParameter(r2, IndexDatabaseHelper.SavedQueriesColums.QUERY);
        return mergeQuery(r2, "NOT");
    }

    public final FullTextSearchQuery and(FullTextSearchQuery r2) {
        Intrinsics.checkNotNullParameter(r2, IndexDatabaseHelper.SavedQueriesColums.QUERY);
        return mergeQuery(r2, "AND");
    }

    public final FullTextSearchQuery or(FullTextSearchQuery r2) {
        Intrinsics.checkNotNullParameter(r2, IndexDatabaseHelper.SavedQueriesColums.QUERY);
        return mergeQuery(r2, "OR");
    }

    public final FullTextSearchQuery addColumnFilter(List<String> r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "colName");
        int r2 = 1;
        if (r6.size() == 1) goto L5;
        if (r7 == false) goto L10;
        StringBuilder r8 = new StringBuilder("- {" + r6.get(0));
    L11:
        int r0 = r6.size();
    L12:
        if (r2 >= r0) goto L14;
        r8.append(HanziToPinyin.Token.SEPARATOR + r6.get(r2));
        r2 = r2 + 1;
        goto L12
    L14:
        r8.append("} : ");
    L15:
        r8.append("(");
        this.matchClauseStringBuilder.insert(0, r8);
        this.matchClauseStringBuilder.append(")");
        return this;
    L10:
        r8 = new StringBuilder(VectorFormat.DEFAULT_PREFIX + r6.get(0));
        goto L11
    L5:
        if (r7 == false) goto L7;
        r8 = new StringBuilder("- " + r6.get(0) + " : ");
        goto L15
    L7:
        r8 = new StringBuilder(r6.get(0) + " : ");
        goto L15
    }
}
