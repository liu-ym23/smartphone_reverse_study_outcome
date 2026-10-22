package tmsdk.common.tcc;

/* JADX INFO: loaded from: classes5.dex */
public class IPConfigSet {
    public String iDefaultIPNums;
    public String iIPnum;
    public String iMSelfdefIPNum;
    public String iMyNumLocation;
    public String iNotUseIPAreas;
    public String iNotUseIPNums;
    public String iSelfdefIPNum;
    public int iUseIPnumStyle;

    public IPConfigSet(int r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        this.iUseIPnumStyle = r1;
        this.iIPnum = r2;
        this.iMyNumLocation = r3;
        this.iNotUseIPAreas = r4;
        this.iNotUseIPNums = r5;
        this.iDefaultIPNums = r6;
        this.iSelfdefIPNum = r7;
        this.iMSelfdefIPNum = r8;
    }
}
