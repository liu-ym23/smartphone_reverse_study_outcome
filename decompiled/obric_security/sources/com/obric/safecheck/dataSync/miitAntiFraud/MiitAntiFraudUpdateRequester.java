package com.obric.safecheck.dataSync.miitAntiFraud;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.stream.JsonToken;
import com.obric.olog.OLog;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.dao.GxbAntiFraudRuleDao;
import com.obric.safecheck.database.entity.GxbAntiFraudRuleItem;
import com.obric.securitycenter.api.ApplicationContainer;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MiitAntiFraudUpdateRequester.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0002J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010#\u001a\u00020\r2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010&\u001a\u00020\u0012*\u00020\u00142\u0006\u0010'\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/MiitAntiFraudUpdateRequester;", "", "()V", "BATCH_SIZE", "", "DEFAULT_SINCE", "", "RULE_STATE_DELETE", "RULE_STATE_INSERT", "TAG", "gson", "Lcom/google/gson/Gson;", "appendRule", "", "dao", "Lcom/obric/safecheck/database/dao/GxbAntiFraudRuleDao;", "buffer", "", "Lcom/obric/safecheck/database/entity/GxbAntiFraudRuleItem;", "rule", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAntiFraudRule;", "version", "batch", "Lcom/obric/safecheck/dataSync/miitAntiFraud/BatchContext;", "downloadAndParseItem", "item", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateItem;", "flushBuffer", "obtainDao", "parseRulesFromEntry", "", "entry", "Ljava/util/zip/ZipEntry;", "entryStream", "Ljava/io/InputStream;", "requestUpdateList", "callerSince", "resolveSince", "toEntity", "ruleNo", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MiitAntiFraudUpdateRequester {
    private static final int BATCH_SIZE = 200;
    private static final String DEFAULT_SINCE = "2026-01-01";
    public static final MiitAntiFraudUpdateRequester INSTANCE = null;
    private static final int RULE_STATE_DELETE = 2;
    private static final int RULE_STATE_INSERT = 1;
    private static final String TAG = "MiitAntiFraudUpdateRequester";
    private static final Gson gson = null;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            r0[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
        }
    }

    @JvmStatic
    public static final void requestUpdateList() {
        requestUpdateList$default(null, 1, null);
    }

    static {
        INSTANCE = new MiitAntiFraudUpdateRequester();
        gson = new Gson();
    }

    private MiitAntiFraudUpdateRequester() {
    }

    public static final /* synthetic */ void access$downloadAndParseItem(MiitAntiFraudUpdateRequester r0, GxbUpdateItem r1, BatchContext r2) {
        r0.downloadAndParseItem(r1, r2);
    }

    public static final /* synthetic */ boolean access$parseRulesFromEntry(MiitAntiFraudUpdateRequester r0, GxbUpdateItem r1, ZipEntry r2, InputStream r3, BatchContext r4) {
        return r0.parseRulesFromEntry(r1, r2, r3, r4);
    }

    public static /* synthetic */ void requestUpdateList$default(String r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L5;
        r0 = null;
        String r3 = (String) null;
    L5:
        requestUpdateList(r0);
    }

    @JvmStatic
    public static final void requestUpdateList(String r3) {
        String r0 = INSTANCE.resolveSince(r3);
        OLog.d(TAG, "request update list, callerSince is " + r3 + ", resolved since is " + r0);
        GxbUpdateListRequester.getGxbUpdateList(r0, new C03111());
    }

    private final void downloadAndParseItem(final GxbUpdateItem r8, final BatchContext r9) {
        final String r7 = r8.getVersion();
        String r0 = r8.getDownloadUrl();
        String r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        OLog.e(TAG, "download skipped, downloadUrl is blank, fileName is " + r8.getFileName() + ", version is " + r7);
        r9.finish(r7, false);
        return;
    L13:
        OLog.d(TAG, "start downloading, fileName is " + r8.getFileName() + ", version is " + r7 + ", url is " + r0);
        final AtomicBoolean r3 = new AtomicBoolean(false);
        GxbZipStreamDownloader.download(r0, new AnonymousClass1(r8, r9, r3, r7));
        return;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0079 -> B:71:0x0157). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 4221. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    private final boolean parseRulesFromEntry(com.obric.safecheck.dataSync.miitAntiFraud.GxbUpdateItem r19, java.util.zip.ZipEntry r20, java.io.InputStream r21, com.obric.safecheck.dataSync.miitAntiFraud.BatchContext r22) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0039: CHECK_CAST (r9v1 ?? I:java.io.Closeable) = (java.io.Closeable) (r4v4 com.google.gson.stream.JsonReader) in method: com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudUpdateRequester.parseRulesFromEntry(com.obric.safecheck.dataSync.miitAntiFraud.GxbUpdateItem, java.util.zip.ZipEntry, java.io.InputStream, com.obric.safecheck.dataSync.miitAntiFraud.BatchContext):boolean, file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudUpdateRequester.parseRulesFromEntry(com.obric.safecheck.dataSync.miitAntiFraud.GxbUpdateItem, java.util.zip.ZipEntry, java.io.InputStream, com.obric.safecheck.dataSync.miitAntiFraud.BatchContext):boolean");
    }

    private final void appendRule(GxbAntiFraudRuleDao r5, List<GxbAntiFraudRuleItem> r6, GxbAntiFraudRule r7, String r8, BatchContext r9) {
        String r0 = r7.getRuleNo();
        String r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        OLog.e(TAG, "skip rule, ruleNo is blank, id is " + r7.getId());
        return;
    L13:
        int r3 = r7.getRuleState();
        if (r3 != 1) goto L16;
        GxbAntiFraudRuleItem r10 = toEntity(r7, r0);
        r10.setVersion(r8);
        Unit r11 = Unit.INSTANCE;
        r6.add(r10);
        if (r6.size() < 200) goto L25;
        flushBuffer(r5, r6);
        return;
    L25:
        return;
    L16:
        if (r3 == 2) goto L18;
        OLog.e(TAG, "skip rule, unknown ruleState=" + r7.getRuleState() + ", ruleNo=" + r0);
        return;
    L18:
        r9.addPendingDelete(r0, r8);
        return;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final void flushBuffer(GxbAntiFraudRuleDao r3, List<GxbAntiFraudRuleItem> r4) {
        if (r4.isEmpty() == false) goto L11;
        return;
    L11:
        r3.insertAll(r4);     // Catch: Throwable -> L7
    L9:
        r4.clear();
        return;
    L7:
        th = move-exception;
        OLog.e(TAG, "insert rules failed, size is " + r4.size(), th);
        goto L9
    }

    private final GxbAntiFraudRuleItem toEntity(GxbAntiFraudRule r19, String r20) {
        return new GxbAntiFraudRuleItem(r20, r19.getId(), r19.getAppMd5(), r19.getArea(), r19.getAreaType(), r19.getDisposeTime(), r19.getPacketName(), r19.getRuleState(), r19.getRuleType(), r19.getSignMd5(), r19.getSignSha1(), r19.getSignSha256(), null, 4096, null);
    }

    private final GxbAntiFraudRuleDao obtainDao() {
        Context r0 = ApplicationContainer.INSTANCE.getApplication();
        if (r0 != null) goto L7;
        return null;
    L7:
        return AntiFraudDatabase.getDatabase(r0).gxbAntiFraudRuleDao();
    }

    private final String resolveSince(String r5) {
        String r4 = null;
        String r0 = (String) null;
        Context r1 = ApplicationContainer.INSTANCE.getApplication();
        if (r1 == null) goto L5;
        r4 = new GxbUpdateVersionRecordSP(r1).getLatestVersion();
    L5:
        boolean r2 = false;
        if (r5 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r4 == null) goto L16;
        if ((!StringsKt.isBlank(r4)) == false) goto L16;
        r2 = true;
    L16:
        if (r3 == true) goto L20;
        if (r2 == true) goto L20;
        OLog.d(TAG, "resolveSince: both invalid, fallback to DEFAULT_SINCE=2026-01-01");
        return DEFAULT_SINCE;
    L20:
        if (r3 == true) goto L23;
        OLog.d(TAG, "resolveSince: callerSince invalid, use savedSince=" + r4);
        Intrinsics.checkNotNull(r4);
        return r4;
    L23:
        if (r2 == true) goto L26;
        OLog.d(TAG, "resolveSince: savedSince invalid, use callerSince=" + r5);
        Intrinsics.checkNotNull(r5);
        return r5;
    L26:
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNull(r4);
        if (r5.compareTo(r4) > 0) goto L29;
        String r6 = r5;
    L30:
        OLog.d(TAG, "resolveSince: callerSince=" + r5 + ", savedSince=" + r4 + ", resolved=" + r6);
        return r6;
    L29:
        r6 = r4;
        goto L30
    L8:
        if ((!StringsKt.isBlank(r5)) == false) goto L10;
        r3 = true;
        goto L11
    }
}
