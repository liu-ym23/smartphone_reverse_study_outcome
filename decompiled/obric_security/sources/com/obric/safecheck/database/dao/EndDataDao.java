package com.obric.safecheck.database.dao;

import com.obric.safecheck.database.entity.EndDataEntity;
import kotlin.Metadata;

/* JADX INFO: compiled from: EndDataDao.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/obric/safecheck/database/dao/EndDataDao;", "", "getEndData", "", "updateEndData", "", "endDataEntity", "Lcom/obric/safecheck/database/entity/EndDataEntity;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface EndDataDao {
    String getEndData();

    void updateEndData(EndDataEntity r1);
}
