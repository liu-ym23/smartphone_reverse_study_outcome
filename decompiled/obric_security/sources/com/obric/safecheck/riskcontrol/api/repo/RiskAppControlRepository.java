package com.obric.safecheck.riskcontrol.api.repo;

import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskAppControlRecord;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: RiskAppControlRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH&J\"\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tH&¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/riskcontrol/api/repo/RiskAppControlRepository;", "", "delete", "", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", "get", "Lcom/obric/safecheck/riskcontrol/api/model/RiskAppControlRecord;", "listAll", "", "listControlled", "releaseControlFlags", "flags", "upsert", "record", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface RiskAppControlRepository {
    void delete(String r1, int r2);

    RiskAppControlRecord get(String r1, int r2);

    List<RiskAppControlRecord> listAll();

    List<RiskAppControlRecord> listControlled();

    RiskAppControlRecord releaseControlFlags(String r1, int r2, int r3);

    void upsert(RiskAppControlRecord r1);
}
