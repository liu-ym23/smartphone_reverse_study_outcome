package com.obric.search.api.plugin.intf;

import android.content.Context;
import com.obric.search.api.schema.intf.ISearchEngineSchema;
import com.obric.search.api.schema.intf.ISearchEngineSchemaContext;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ISearchEnginePlugin.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/obric/search/api/plugin/intf/ISearchEnginePlugin;", "", "canHandle", "", "schema", "Lcom/obric/search/api/schema/intf/ISearchEngineSchema;", "getPluginName", "", "init", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "context", "Landroid/content/Context;", "config", "Lcom/obric/search/api/plugin/intf/ISearchEnginePluginConfig;", "schemaList", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ISearchEnginePlugin {
    boolean canHandle(ISearchEngineSchema r1);

    String getPluginName();

    ISearchEngineSchemaContext init(Context r1, ISearchEnginePluginConfig r2, List<? extends ISearchEngineSchema> r3);
}
