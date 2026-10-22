package com.bytedanceos.securitycenter.scan;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ApkFileDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\b"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/ApkFileDataSource;", "", "getLocalApkPaths", "", "", "isCanceled", "Lkotlin/Function0;", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface ApkFileDataSource {
    List<String> getLocalApkPaths(Function0<Boolean> r1);
}
