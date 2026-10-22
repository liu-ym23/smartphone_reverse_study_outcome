package tmsdk.common.tcc;

/* JADX INFO: loaded from: classes5.dex */
public interface IDeepCleanEngine {
    void cancel();

    String getDetailRule(String r1);

    boolean init();

    void onDirectoryChange(String r1, int r2);

    void onFoundComRubbish(String r1, String r2, long r3);

    void onFoundEmptyDir(String r1, long r2);

    void onFoundKeySoftRubbish(String r1, String[] r2, long r3);

    void onFoundSoftRubbish(String r1, String r2, String r3, long r4);

    void onProcessChange(int r1);

    void onVisit(String r1, boolean r2, long r3, long r5, long r7, long r9);

    void release();

    void scanPath(String r1, String r2);

    void setComRubRule(String[] r1);

    void setOtherFilterRule(String[] r1);

    void setRootPaths(String[] r1);

    void setUninstallFilterSuffix(String[] r1);

    void setWhitePaths(String[] r1);
}
