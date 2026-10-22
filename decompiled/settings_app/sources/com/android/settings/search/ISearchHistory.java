package com.android.settings.search;

import bytedanceos.app.settings.search.SearchResultItem;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ISearchHistory {
    void addItem(SearchResultItem r1);

    void clearAllItems();

    void getAllItems(Consumer<List<SearchResultItem>> r1);

    void isItemExist(SearchResultItem r1, Consumer<Boolean> r2);

    void removeItem(String r1);

    void updateItem(SearchResultItem r1);
}
