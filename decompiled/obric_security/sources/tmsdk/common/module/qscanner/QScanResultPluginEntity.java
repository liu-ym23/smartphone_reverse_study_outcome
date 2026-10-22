package tmsdk.common.module.qscanner;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class QScanResultPluginEntity {
    public ArrayList<String> banIps;
    public ArrayList<String> banUrls;
    public String name;
    public int type;

    public QScanResultPluginEntity() {
        this.type = 0;
        this.banUrls = null;
        this.banIps = null;
        this.name = null;
    }
}
