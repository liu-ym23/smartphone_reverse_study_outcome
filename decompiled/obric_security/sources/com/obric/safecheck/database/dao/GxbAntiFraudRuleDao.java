package com.obric.safecheck.database.dao;

import com.obric.safecheck.database.entity.GxbAntiFraudRuleItem;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: GxbAntiFraudRuleDao.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H'J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH'J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fH'J\u0016\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'¨\u0006\u0016"}, d2 = {"Lcom/obric/safecheck/database/dao/GxbAntiFraudRuleDao;", "", "deleteAll", "", "deleteByRuleNo", "", "ruleNo", "", "deleteByRuleNoIfVersionLE", "delVersion", "getAll", "", "Lcom/obric/safecheck/database/entity/GxbAntiFraudRuleItem;", "getByPacketName", "packetName", "getByPacketNames", "packetNames", "getByRuleNo", "insert", "item", "insertAll", "items", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface GxbAntiFraudRuleDao {
    void deleteAll();

    int deleteByRuleNo(String r1);

    int deleteByRuleNoIfVersionLE(String r1, String r2);

    List<GxbAntiFraudRuleItem> getAll();

    List<GxbAntiFraudRuleItem> getByPacketName(String r1);

    List<GxbAntiFraudRuleItem> getByPacketNames(List<String> r1);

    GxbAntiFraudRuleItem getByRuleNo(String r1);

    void insert(GxbAntiFraudRuleItem r1);

    void insertAll(List<GxbAntiFraudRuleItem> r1);
}
