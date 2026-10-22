package tmsdk.common;

/* JADX INFO: loaded from: classes5.dex */
public class SmsEntity {
    public String body;
    public String phonenum;

    public SmsEntity() {
    }

    public String toString() {
        return this.phonenum + "\t" + this.body;
    }
}
