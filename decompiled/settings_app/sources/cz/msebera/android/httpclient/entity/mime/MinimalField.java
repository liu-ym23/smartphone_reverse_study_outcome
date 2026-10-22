package cz.msebera.android.httpclient.entity.mime;

/* JADX INFO: loaded from: classes5.dex */
public class MinimalField {
    private final String name;
    private final String value;

    public MinimalField(String r1, String r2) {
        this.name = r1;
        this.value = r2;
    }

    public String getName() {
        return this.name;
    }

    public String getBody() {
        return this.value;
    }

    public String toString() {
        return this.name + ": " + this.value;
    }
}
