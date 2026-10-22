package com.bytedanceos.securitycenter.scan;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: VirusDbScanDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/VirusDbScanDataSource;", "", "loadAllByPkg", "", "", "Lcom/bytedanceos/securitycenter/scan/VirusDbRecord;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface VirusDbScanDataSource {
    Map<String, VirusDbRecord> loadAllByPkg();
}
