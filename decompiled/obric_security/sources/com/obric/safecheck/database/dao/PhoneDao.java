package com.obric.safecheck.database.dao;

import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.safecheck.database.entity.PhoneItem;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PhoneDao.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0005H'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH'J\u0016\u0010\u000e\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0010"}, d2 = {"Lcom/obric/safecheck/database/dao/PhoneDao;", "", "deleteDataBeforeDate", "", "targetDate", "", "getAllBlacklistedPhones", "", "Lcom/obric/safecheck/database/entity/PhoneItem;", "getPhoneItemByNumber", AccountConst.KEY_PHONE_NUMBER, "insert", "", "phoneItems", "insertAll", "queryDataBeforeDate", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface PhoneDao {
    int deleteDataBeforeDate(String r1);

    List<PhoneItem> getAllBlacklistedPhones();

    PhoneItem getPhoneItemByNumber(String r1);

    void insert(PhoneItem r1);

    void insertAll(List<PhoneItem> r1);

    List<PhoneItem> queryDataBeforeDate(String r1);
}
