package tmsdk.common;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExtraInfoFetcher {
    public ExtraInfoFetcher() {
    }

    public abstract String getImeiHash();

    public String getImsiHash() {
        return "";
    }

    public String getMacHash() {
        return "";
    }
}
