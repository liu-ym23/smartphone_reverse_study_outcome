package com.obric.safecheck.database.dao;

import com.obric.safecheck.database.entity.PkgSignItem;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PkgSignDao {
    void deleteAllPkgSignItems();

    int deleteDataBeforeDate(String targetDate);

    void deletePkgSignItemByPkg(String pkgName);

    List<PkgSignItem> getAllPkgSignItems();

    List<PkgSignItem> getPkgSignItemsByPkg(String pkgName);

    void insertAll(List<PkgSignItem> items);

    void insertAllPkgSignItems(List<PkgSignItem> items);

    void insertPkgSignItem(PkgSignItem item);

    List<PkgSignItem> queryDataBeforeDate(String targetDate);
}
