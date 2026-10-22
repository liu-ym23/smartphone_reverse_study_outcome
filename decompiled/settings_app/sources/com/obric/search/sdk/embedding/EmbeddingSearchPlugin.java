package com.obric.search.sdk.embedding;

import android.content.Context;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.search.api.plugin.intf.ISearchEnginePlugin;
import com.obric.search.api.plugin.intf.ISearchEnginePluginConfig;
import com.obric.search.api.schema.intf.ISearchEngineSchema;
import com.obric.search.api.schema.intf.ISearchEngineSchemaContext;
import com.obric.search.sdk.embedding.shema.EmbeddingSearchSchema;
import com.obric.search.sdk.embedding.shema.EmbeddingSearchSchemaContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingSearchPlugin.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/search/sdk/embedding/EmbeddingSearchPlugin;", "Lcom/obric/search/api/plugin/intf/ISearchEnginePlugin;", "()V", "canHandle", "", "schema", "Lcom/obric/search/api/schema/intf/ISearchEngineSchema;", "getPluginName", "", "init", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "context", "Landroid/content/Context;", "config", "Lcom/obric/search/api/plugin/intf/ISearchEnginePluginConfig;", "schemaList", "", "Companion", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmbeddingSearchPlugin implements ISearchEnginePlugin {
    public static final Companion Companion = null;
    private static final String TAG = "EmbeddingSearchPlugin";

    /* JADX INFO: compiled from: EmbeddingSearchPlugin.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/sdk/embedding/EmbeddingSearchPlugin$Companion;", "", "()V", "TAG", "", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.search.api.plugin.intf.ISearchEnginePlugin
    public String getPluginName() {
        return TAG;
    }

    public EmbeddingSearchPlugin() {
    }

    @Override // com.obric.search.api.plugin.intf.ISearchEnginePlugin
    public ISearchEngineSchemaContext init(Context r1, ISearchEnginePluginConfig r2, List<? extends ISearchEngineSchema> r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "schemaList");
        EmbeddingSearchPluginConfig r4 = (EmbeddingSearchPluginConfig) r2;
        return new EmbeddingSearchSchemaContext(AIKernelManager.INSTANCE);
    }

    @Override // com.obric.search.api.plugin.intf.ISearchEnginePlugin
    public boolean canHandle(ISearchEngineSchema r1) {
        Intrinsics.checkNotNullParameter(r1, "schema");
        return r1 instanceof EmbeddingSearchSchema;
    }
}
