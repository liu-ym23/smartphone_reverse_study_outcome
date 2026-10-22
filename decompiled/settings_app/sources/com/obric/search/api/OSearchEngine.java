package com.obric.search.api;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.search.api.config.MigrationConfig;
import com.obric.search.api.config.SQLCipherConfig;
import com.obric.search.api.config.SQLiteTrace;
import com.obric.search.api.document.intf.IDocument;
import com.obric.search.api.migration.AbstractMigration;
import com.obric.search.api.migration.MigrationContainer;
import com.obric.search.api.plugin.intf.ISearchEnginePlugin;
import com.obric.search.api.plugin.intf.ISearchEnginePluginConfig;
import com.obric.search.api.remove.intf.IRemoveSpec;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.api.schema.impl.FullTextSearchSchemaContext;
import com.obric.search.api.schema.impl.FullTextSearchSchemaExecutor;
import com.obric.search.api.schema.impl.NonContentLessFTSExecutor;
import com.obric.search.api.schema.impl.bean.DocumentIsFullMatch;
import com.obric.search.api.schema.impl.bean.DocumentTokenPosition;
import com.obric.search.api.schema.impl.bean.FullTextSearchDocumentInfo;
import com.obric.search.api.schema.intf.ISearchEngineSchema;
import com.obric.search.api.schema.intf.ISearchEngineSchemaContext;
import com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor;
import com.obric.search.api.search.impl.FullTextSearchInfoSpec;
import com.obric.search.api.search.impl.FullTextSearchSpec;
import com.obric.search.api.search.intf.ISearchSpec;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.storage.sqlite.SQLiteSearchEngine;
import com.obric.search.storage.sqlite.fts5.SQLiteFts5Extension;
import com.obric.search.storage.sqlite.schema.impl.SQLiteFts5Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: OSearchEngine.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 S2\u00020\u0001:\u0002RSB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0016J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010*\u001a\u00020+J \u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0\u00140!2\u0006\u0010*\u001a\u00020+J\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0!2\u0006\u0010*\u001a\u00020+J\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010!2\u0006\u0010*\u001a\u00020+J\u0010\u00102\u001a\u0004\u0018\u00010\u00192\u0006\u00103\u001a\u00020\bJ\u001c\u00104\u001a\b\u0012\u0004\u0012\u0002050!2\u0006\u0010*\u001a\u0002062\u0006\u00107\u001a\u000208J\\\u00109\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010:\u001a\u00020;2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BJ\u0014\u0010C\u001a\u00020\u000e2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020E0!JP\u0010F\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010:\u001a\u00020;2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020G0!2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BJ\u000e\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020NJ \u0010O\u001a\u00020\u001d2\u0018\u0010P\u001a\u0014\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0!0QR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/obric/search/api/OSearchEngine;", "", "()V", "callBack", "Lcom/obric/search/api/OSearchEngine$CallBack;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "fullTextSearchSchemaContext", "Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "", "isInitDone", "()Z", "isInitStart", "pluginList", "", "Lkotlin/Pair;", "Lcom/obric/search/api/plugin/intf/ISearchEnginePlugin;", "Lcom/obric/search/api/plugin/intf/ISearchEnginePluginConfig;", "schemaExecutorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaExecutor;", "sqliteSearchEngine", "Lcom/obric/search/storage/sqlite/SQLiteSearchEngine;", "addExecutor", "", "appContext", "Landroid/content/Context;", "schemaList", "", "Lcom/obric/search/api/schema/intf/ISearchEngineSchema;", "context", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "addPlugin", CloudControlInf.PLUGIN, "config", "getDocumentsId", "", "searchSpec", "Lcom/obric/search/api/search/intf/ISearchSpec;", "getDocumentsIdAndContentValues", "Landroid/content/ContentValues;", "getDocumentsIdAndIsFullMatch", "Lcom/obric/search/api/schema/impl/bean/DocumentIsFullMatch;", "getDocumentsIdAndTokenPosition", "Lcom/obric/search/api/schema/impl/bean/DocumentTokenPosition;", "getExecutor", "schemaName", "getFTSDocumentInfo", "Lcom/obric/search/api/schema/impl/bean/FullTextSearchDocumentInfo;", "Lcom/obric/search/api/search/impl/FullTextSearchSpec;", "infoSpec", "Lcom/obric/search/api/search/impl/FullTextSearchInfoSpec;", "init", "version", "", "synonymUri", "Landroid/net/Uri;", "passPhrase", "sqlCipherConfig", "Lcom/obric/search/api/config/SQLCipherConfig;", "migrationConfig", "Lcom/obric/search/api/config/MigrationConfig;", "putDocuments", "list", "Lcom/obric/search/api/document/intf/IDocument;", "reinitSqlite", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "removeDocuments", "removeSpec", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "setCallBack", "setSQLiteDatabaseTraceCallback", "sqliteTrace", "Lcom/obric/search/api/config/SQLiteTrace;", "setTokenizerSamePinyinConfig", "excludedMap", "", "CallBack", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OSearchEngine {
    public static final Companion Companion = null;
    public static final String DATABASE_NAME_PREFIX = "OSE_";
    private static final String TAG = "OSearchEngine";
    private volatile CallBack callBack;
    private final CoroutineScope coroutineScope;
    private String databaseName;
    private FullTextSearchSchemaContext fullTextSearchSchemaContext;
    private volatile boolean isInitDone;
    private volatile boolean isInitStart;
    private final List<Pair<ISearchEnginePlugin, ISearchEnginePluginConfig>> pluginList;
    private final ConcurrentHashMap<String, ISearchEngineSchemaExecutor> schemaExecutorMap;
    private SQLiteSearchEngine sqliteSearchEngine;

    /* JADX INFO: compiled from: OSearchEngine.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/search/api/OSearchEngine$CallBack;", "", "onInitDone", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface CallBack {
        void onInitDone();
    }

    /* JADX INFO: compiled from: OSearchEngine.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/search/api/OSearchEngine$Companion;", "", "()V", "DATABASE_NAME_PREFIX", "", "TAG", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.search.api.OSearchEngine$init$2, reason: invalid class name */
    /* JADX INFO: compiled from: OSearchEngine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.search.api.OSearchEngine$init$2", f = "OSearchEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ HashMap<ISearchEnginePlugin, List<ISearchEngineSchema>> $plugin2SchemaListMap;
        final /* synthetic */ long $startTime;
        final /* synthetic */ Uri $synonymUri;
        int label;
        final /* synthetic */ OSearchEngine this$0;

        AnonymousClass2(Uri r1, long r2, OSearchEngine r4, HashMap<ISearchEnginePlugin, List<ISearchEngineSchema>> r5, Context r6, Continuation<? super AnonymousClass2> r7) {
            this.$synonymUri = r1;
            this.$startTime = r2;
            this.this$0 = r4;
            this.$plugin2SchemaListMap = r5;
            this.$appContext = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass2(this.$synonymUri, this.$startTime, this.this$0, this.$plugin2SchemaListMap, this.$appContext, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L26;
            ResultKt.throwOnFailure(r10);
            Uri r11 = this.$synonymUri;
            if (r11 == null) goto L7;
            Context r0 = this.$appContext;
            long r1 = System.currentTimeMillis();
            SQLiteFts5Extension.INSTANCE.setSynonymAsset(r0, r11);
            RuntimeLogger.INSTANCE.info(OSearchEngine.TAG, "init setSynonymAsset time " + (System.currentTimeMillis() - r1));
        L7:
            RuntimeLogger.INSTANCE.info(OSearchEngine.TAG, "init main part done. time is " + (System.currentTimeMillis() - this.$startTime) + "ms.");
            Iterator r12 = OSearchEngine.access$getPluginList$p(this.this$0).iterator();
        L9:
            if (r12.hasNext() == false) goto L13;
            Pair r2 = (Pair) r12.next();
            List<ISearchEngineSchema> r3 = this.$plugin2SchemaListMap.get(r2.getFirst());
            if (r3 == null) goto L9;
            Context r4 = this.$appContext;
            OSearchEngine r5 = this.this$0;
            String r6 = ((ISearchEnginePlugin) r2.getFirst()).getPluginName();
            RuntimeLogger.INSTANCE.info(OSearchEngine.TAG, "init plugin " + r6 + " start.");
            OSearchEngine.access$addExecutor(r5, r4, r3, ((ISearchEnginePlugin) r2.getFirst()).init(r4, (ISearchEnginePluginConfig) r2.getSecond(), r3));
            RuntimeLogger.INSTANCE.info(OSearchEngine.TAG, "init plugin " + r6 + " done.");
            goto L9
        L13:
            RuntimeLogger.INSTANCE.info(OSearchEngine.TAG, "init all done. time is " + (System.currentTimeMillis() - this.$startTime) + "ms.");
            OSearchEngine.access$setInitDone$p(this.this$0, true);
            OSearchEngine r9 = this.this$0;
            monitor-enter(r9);
            CallBack r13 = OSearchEngine.access$getCallBack$p(r9);     // Catch: Throwable -> L22
            if (r13 == null) goto L18;
            r13.onInitDone();     // Catch: Throwable -> L22
        L18:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r9);
            return Unit.INSTANCE;
        L22:
            th = move-exception;
            throw th;
        L26:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OSearchEngine() {
        this.schemaExecutorMap = new ConcurrentHashMap();
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.databaseName = "";
        this.pluginList = new ArrayList();
    }

    public static final /* synthetic */ void access$addExecutor(OSearchEngine r0, Context r1, List r2, ISearchEngineSchemaContext r3) {
        r0.addExecutor(r1, r2, r3);
    }

    public static final /* synthetic */ CallBack access$getCallBack$p(OSearchEngine r0) {
        return r0.callBack;
    }

    public static final /* synthetic */ List access$getPluginList$p(OSearchEngine r0) {
        return r0.pluginList;
    }

    public static final /* synthetic */ void access$setInitDone$p(OSearchEngine r0, boolean r1) {
        r0.isInitDone = r1;
    }

    public final boolean isInitDone() {
        return this.isInitDone;
    }

    public final String getDatabaseName() {
        return this.databaseName;
    }

    public final synchronized void addPlugin(ISearchEnginePlugin r3, ISearchEnginePluginConfig r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, CloudControlInf.PLUGIN);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r4, "config");     // Catch: Throwable -> L6
        this.pluginList.add(new Pair(r3, r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void setCallBack(CallBack r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "callBack");     // Catch: Throwable -> L6
        this.callBack = r2;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void init$default(OSearchEngine r12, Context r13, String r14, int r15, List r16, Uri r17, String r18, SQLCipherConfig r19, MigrationConfig r20, int r21, Object r22) {
        if ((r21 & 16) == 0) goto L5;
        Uri r8 = null;
    L7:
        if ((r21 & 32) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r21 & 64) == 0) goto L13;
        SQLCipherConfig r10 = null;
    L15:
        if ((r21 & 128) == 0) goto L17;
        MigrationConfig r11 = null;
    L18:
        r12.init(r13, r14, r15, r16, r8, r9, r10, r11);
        return;
    L17:
        r11 = r20;
        goto L18
    L13:
        r10 = r19;
        goto L15
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    public final synchronized void init(Context r18, String r19, int r20, List<? extends ISearchEngineSchema> r21, Uri r22, String r23, SQLCipherConfig r24, MigrationConfig r25) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r18, "appContext");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r19, "databaseName");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r21, "schemaList");     // Catch: Throwable -> L38
        if (this.isInitStart == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L38
        this.isInitStart = true;     // Catch: Throwable -> L38
        HashMap r12 = new HashMap();     // Catch: Throwable -> L38
        Iterator<Pair<ISearchEnginePlugin, ISearchEnginePluginConfig>> r3 = this.pluginList.iterator();     // Catch: Throwable -> L38
    L10:
        if (r3.hasNext() == false) goto L12;
        r12.put(r3.next().getFirst(), new ArrayList());     // Catch: Throwable -> L38
        goto L10
    L12:
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L38
        Iterator<T> r2 = r21.iterator();     // Catch: Throwable -> L38
    L14:
        if (r2.hasNext() == false) goto L26;
        ISearchEngineSchema r4 = (ISearchEngineSchema) r2.next();     // Catch: Throwable -> L38
        if ((r4 instanceof FullTextSearchSchema) == true) goto L17;
        Iterator<Pair<ISearchEnginePlugin, ISearchEnginePluginConfig>> r5 = this.pluginList.iterator();     // Catch: Throwable -> L38
    L20:
        if (r5.hasNext() == false) goto L14;
        Pair<ISearchEnginePlugin, ISearchEnginePluginConfig> r6 = r5.next();     // Catch: Throwable -> L38
        if (r6.getFirst().canHandle(r4) == false) goto L20;
        List r7 = (List) r12.get(r6.getFirst());     // Catch: Throwable -> L38
        if (r7 == null) goto L14;
        r7.add(r4);     // Catch: Throwable -> L38
        goto L14
    L17:
        r13.add(r4);     // Catch: Throwable -> L38
        goto L14
    L26:
        ArrayList r8 = r13;     // Catch: Throwable -> L38
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));     // Catch: Throwable -> L38
        Iterator r11 = r8.iterator();     // Catch: Throwable -> L38
    L28:
        if (r11.hasNext() == false) goto L30;
        FullTextSearchSchema r14 = (FullTextSearchSchema) r11.next();     // Catch: Throwable -> L38
        r9.add(new SQLiteFts5Schema(r14.getSchemaName(), r14.getColumnList(), r14.getTokenizer(), r14.isContentLess()));     // Catch: Throwable -> L38
        goto L28
    L30:
        ArrayList r15 = r9;     // Catch: Throwable -> L38
        if (r25 == null) goto L34;
        List<AbstractMigration> r16 = r25.getMigrations();     // Catch: Throwable -> L38
        if (r16 == null) goto L34;
    L35:
        MigrationContainer r17 = new MigrationContainer(r16);     // Catch: Throwable -> L38
        this.databaseName = DATABASE_NAME_PREFIX + r19;     // Catch: Throwable -> L38
        SQLiteSearchEngine r110 = new SQLiteSearchEngine(r18, this.databaseName, r20, r15, r23, r24, r17);     // Catch: Throwable -> L38
        this.sqliteSearchEngine = r110;     // Catch: Throwable -> L38
        FullTextSearchSchemaContext r1 = new FullTextSearchSchemaContext(r110);     // Catch: Throwable -> L38
        this.fullTextSearchSchemaContext = r1;     // Catch: Throwable -> L38
        addExecutor(r18, r13, r1);     // Catch: Throwable -> L38
        BuildersKt.launch$default(this.coroutineScope, null, null, new AnonymousClass2(r22, r10, this, r12, r18, null), 3, null);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L34:
        r16 = CollectionsKt.emptyList();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void reinitSqlite$default(OSearchEngine r10, Context r11, String r12, int r13, List r14, String r15, SQLCipherConfig r16, MigrationConfig r17, int r18, Object r19) {
        if ((r18 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        SQLCipherConfig r8 = null;
    L11:
        if ((r18 & 64) == 0) goto L13;
        MigrationConfig r9 = null;
    L14:
        r10.reinitSqlite(r11, r12, r13, r14, r7, r8, r9);
        return;
    L13:
        r9 = r17;
        goto L14
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    public final synchronized void reinitSqlite(Context r15, String r16, int r17, List<FullTextSearchSchema> r18, String r19, SQLCipherConfig r20, MigrationConfig r21) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r15, "context");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r16, "databaseName");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r18, "schemaList");     // Catch: Throwable -> L23
        SQLiteSearchEngine r5 = this.sqliteSearchEngine;     // Catch: Throwable -> L23
        FullTextSearchSchemaContext r4 = this.fullTextSearchSchemaContext;     // Catch: Throwable -> L23
        if (r5 == null) goto L20;
        if (r4 == null) goto L20;
        this.databaseName = DATABASE_NAME_PREFIX + r16;     // Catch: Throwable -> L23
        if (r21 == null) goto L12;
        List<AbstractMigration> r0 = r21.getMigrations();     // Catch: Throwable -> L23
        if (r0 == null) goto L12;
    L13:
        MigrationContainer r12 = new MigrationContainer(r0);     // Catch: Throwable -> L23
        String r7 = this.databaseName;     // Catch: Throwable -> L23
        List<FullTextSearchSchema> r1 = r18;     // Catch: Throwable -> L23
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));     // Catch: Throwable -> L23
        Iterator<T> r2 = r1.iterator();     // Catch: Throwable -> L23
    L15:
        if (r2.hasNext() == false) goto L17;
        FullTextSearchSchema r6 = (FullTextSearchSchema) r2.next();     // Catch: Throwable -> L23
        r3.add(new SQLiteFts5Schema(r6.getSchemaName(), r6.getColumnList(), r6.getTokenizer(), r6.isContentLess()));     // Catch: Throwable -> L23
        goto L15
    L17:
        r5.recreateSqliteDatabaseManager(r15, r7, r17, r3, r19, r20, r12);     // Catch: Throwable -> L23
        Context r8 = r15.getApplicationContext();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r8, "context.applicationContext");     // Catch: Throwable -> L23
        addExecutor(r8, r18, r4);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L12:
        r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L23
    L20:
        RuntimeLogger.INSTANCE.error(TAG, "recreateSqliteDatabaseManager sqliteSearchEngine or fullTextSearchSchemaContext is null.");     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final boolean putDocuments(List<? extends IDocument> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        if (r3.isEmpty() == false) goto L6;
        return true;
    L6:
        ISearchEngineSchemaExecutor r2 = getExecutor(r3.get(0).getSchemaName());
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.putDocuments(r3);
    }

    public final boolean removeDocuments(IRemoveSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "removeSpec");
        ISearchEngineSchemaExecutor r1 = getExecutor(r2.getSchemaName());
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.removeDocuments(r2);
    }

    public final List<Long> getDocumentsId(ISearchSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "searchSpec");
        ISearchEngineSchemaExecutor r1 = getExecutor(r2.getSchemaName());
        if (r1 == null) goto L7;
        List<Long> r3 = r1.getDocumentsId(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return CollectionsKt.emptyList();
    }

    public final List<DocumentTokenPosition> getDocumentsIdAndTokenPosition(ISearchSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "searchSpec");
        ISearchEngineSchemaExecutor r1 = getExecutor(r2.getSchemaName());
        if (r1 != null) goto L5;
    L9:
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentsIdAndTokenPosition executor type error.");
        return CollectionsKt.emptyList();
    L5:
        if ((r1 instanceof FullTextSearchSchemaExecutor) == false) goto L9;
        return ((FullTextSearchSchemaExecutor) r1).getDocumentsTokenPosition(r2);
    }

    public final List<DocumentIsFullMatch> getDocumentsIdAndIsFullMatch(ISearchSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "searchSpec");
        ISearchEngineSchemaExecutor r1 = getExecutor(r2.getSchemaName());
        if (r1 != null) goto L5;
    L9:
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentsIdAndIsFullMatch executor type error.");
        return CollectionsKt.emptyList();
    L5:
        if ((r1 instanceof FullTextSearchSchemaExecutor) == false) goto L9;
        return ((FullTextSearchSchemaExecutor) r1).getDocumentsIdAndIsFullMatch(r2);
    }

    public final List<Pair<Long, ContentValues>> getDocumentsIdAndContentValues(ISearchSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "searchSpec");
        ISearchEngineSchemaExecutor r1 = getExecutor(r2.getSchemaName());
        if (r1 != null) goto L5;
    L9:
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentsIdAndContentValues executor type error.");
        return CollectionsKt.emptyList();
    L5:
        if ((r1 instanceof NonContentLessFTSExecutor) == false) goto L9;
        return ((NonContentLessFTSExecutor) r1).getDocumentsIdAndContentValues(r2);
    }

    public final List<FullTextSearchDocumentInfo> getFTSDocumentInfo(FullTextSearchSpec r2, FullTextSearchInfoSpec r3) {
        Intrinsics.checkNotNullParameter(r2, "searchSpec");
        Intrinsics.checkNotNullParameter(r3, "infoSpec");
        ISearchEngineSchemaExecutor r1 = getExecutor(r2.getSchemaName());
        if (r1 != null) goto L5;
    L9:
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentIdAndOtherInfo executor type error.");
        return CollectionsKt.emptyList();
    L5:
        if ((r1 instanceof FullTextSearchSchemaExecutor) == false) goto L9;
        return ((FullTextSearchSchemaExecutor) r1).getFTSDocumentInfo(r2, r3);
    }

    public final boolean setSQLiteDatabaseTraceCallback(SQLiteTrace r2) {
        Intrinsics.checkNotNullParameter(r2, "sqliteTrace");
        SQLiteSearchEngine r1 = this.sqliteSearchEngine;
        if (r1 == null) goto L5;
        r1.setSQLiteDatabaseTraceCallback(r2);
        Unit r3 = Unit.INSTANCE;
    L6:
        if (r3 != null) goto L9;
        return false;
    L9:
        return true;
    L5:
        r3 = null;
        goto L6
    }

    public final synchronized ISearchEngineSchemaExecutor getExecutor(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "schemaName");     // Catch: Throwable -> L6
        ISearchEngineSchemaExecutor r3 = this.schemaExecutorMap.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    private final void addExecutor(Context r4, List<? extends ISearchEngineSchema> r5, ISearchEngineSchemaContext r6) {
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ISearchEngineSchema r0 = (ISearchEngineSchema) r7.next();
        this.schemaExecutorMap.put(r0.getSchemaName(), r0.createExecutor(r4, r6));
        goto L4
    }

    public final void setTokenizerSamePinyinConfig(Map<Integer, ? extends List<String>> r1) {
        Intrinsics.checkNotNullParameter(r1, "excludedMap");
        SQLiteFts5Extension.INSTANCE.setTokenizerSamePinyinConfig(r1);
    }
}
