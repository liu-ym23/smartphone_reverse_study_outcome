package com.android.settings.settingitemsprovider;

import com.obric.olog.OLog;
import com.obric.search.api.OSearchEngine;
import com.obric.search.sdk.embedding.OSearchEngineExtKt;
import com.obric.search.sdk.embedding.search.EmbeddingSearchSpec;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchEngineHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/android/settings/settingitemsprovider/SearchEngineHelp;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getDocumentsIdAndDistanceAndStatus", "", "Lkotlin/Pair;", "", "", "searchSpec", "Lcom/obric/search/sdk/embedding/search/EmbeddingSearchSpec;", "mOSearchEngine", "Lcom/obric/search/api/OSearchEngine;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SearchEngineHelp {
    public static final Companion Companion = null;
    private static final Lazy<SearchEngineHelp> instance$delegate = null;
    private final String TAG;

    /* JADX INFO: compiled from: SearchEngineHelp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/android/settings/settingitemsprovider/SearchEngineHelp$Companion;", "", "()V", "instance", "Lcom/android/settings/settingitemsprovider/SearchEngineHelp;", "getInstance", "()Lcom/android/settings/settingitemsprovider/SearchEngineHelp;", "instance$delegate", "Lkotlin/Lazy;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final SearchEngineHelp getInstance() {
            return (SearchEngineHelp) SearchEngineHelp.access$getInstance$delegate$cp().getValue();
        }
    }

    public /* synthetic */ SearchEngineHelp(DefaultConstructorMarker r1) {
        this();
    }

    private SearchEngineHelp() {
        this.TAG = SearchEngine.TAG;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    public final String getTAG() {
        return this.TAG;
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(SearchEngineHelp$Companion$instance$2.INSTANCE);
    }

    public final List<Pair<Long, Double>> getDocumentsIdAndDistanceAndStatus(EmbeddingSearchSpec r2, OSearchEngine r3) {
        Intrinsics.checkNotNullParameter(r2, "searchSpec");
        Intrinsics.checkNotNullParameter(r3, "mOSearchEngine");
        Object r4 = OSearchEngineExtKt.getDocumentsIdAndDistanceAndStatus(r3, r2);
        if (Result.m1515isSuccessimpl(r4) == true) goto L5;
        OLog.e(this.TAG, "getDocumentsIdAndDistanceAndStatus failed", Result.m1511exceptionOrNullimpl(r4));
        return CollectionsKt.emptyList();
    L5:
        if (Result.m1514isFailureimpl(r4) == false) goto L7;
        r4 = null;
    L7:
        List<Pair<Long, Double>> r5 = (List) r4;
        if (r5 == null) goto L10;
        return r5;
    L10:
        return CollectionsKt.emptyList();
    }
}
