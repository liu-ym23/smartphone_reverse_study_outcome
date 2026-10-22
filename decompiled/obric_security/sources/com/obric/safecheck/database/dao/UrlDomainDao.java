package com.obric.safecheck.database.dao;

import com.obric.safecheck.database.entity.UrlDomainItem;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: UrlDomainDao.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0007H'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH'J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/database/dao/UrlDomainDao;", "", "deleteAll", "", "deleteDataBeforeDate", "", "targetDate", "", "getAllBlacklistedDomains", "", "Lcom/obric/safecheck/database/entity/UrlDomainItem;", "getByDomain", "domain", "insert", "items", "insertAll", "queryDataBeforeDate", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface UrlDomainDao {
    void deleteAll();

    int deleteDataBeforeDate(String r1);

    List<UrlDomainItem> getAllBlacklistedDomains();

    UrlDomainItem getByDomain(String r1);

    void insert(UrlDomainItem r1);

    void insertAll(List<UrlDomainItem> r1);

    List<UrlDomainItem> queryDataBeforeDate(String r1);
}
