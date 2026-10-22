package tmsdk.common.tcc;

/* JADX INFO: loaded from: classes5.dex */
public class RuleFileHeader {
    public String md5str;
    public int time;
    public int version;

    public RuleFileHeader(int r1, int r2, String r3) {
        this.version = r1;
        this.time = r2;
        this.md5str = r3;
    }
}
