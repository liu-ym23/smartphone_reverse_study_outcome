package com.obric.capabilitykit.search;

import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/search/IAppSearchCallback;", "", "onCompleted", "", "onError", AccountConst.KEY_ERROR_CODE, "", AccountConst.KEY_ERROR_MSG, "", "onSearchResult", "result", "Lcom/obric/capabilitykit/entity/search/InAppSearchResult;", "onSearchResultWithoutEntity", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IAppSearchCallback {
    void onCompleted();

    void onError(int r1, String r2);

    void onSearchResult(InAppSearchResult r1);

    void onSearchResultWithoutEntity(InAppSearchResultWithoutEntity r1);
}
