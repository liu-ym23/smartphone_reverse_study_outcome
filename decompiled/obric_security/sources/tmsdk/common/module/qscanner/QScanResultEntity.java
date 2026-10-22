package tmsdk.common.module.qscanner;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class QScanResultEntity {
    public String certMd5;
    public String certMd5Ex;
    public int desc_text_id;
    public int malwareid;
    public String officialCertMd5;
    public String officialPackName;
    public String packageName;
    public String path;
    public ArrayList<QScanResultPluginEntity> plugins;
    public int scanResult;
    public int size;
    public String softName;
    public String version;
    public int versionCode;
    public String virusDiscription;
    public String virusName;
    public String virusUrl;

    public QScanResultEntity() {
        this.desc_text_id = 0;
    }
}
