package cz.msebera.android.httpclient.params;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface HttpParams {
    HttpParams copy();

    boolean getBooleanParameter(String r1, boolean r2);

    double getDoubleParameter(String r1, double r2);

    int getIntParameter(String r1, int r2);

    long getLongParameter(String r1, long r2);

    Object getParameter(String r1);

    boolean isParameterFalse(String r1);

    boolean isParameterTrue(String r1);

    boolean removeParameter(String r1);

    HttpParams setBooleanParameter(String r1, boolean r2);

    HttpParams setDoubleParameter(String r1, double r2);

    HttpParams setIntParameter(String r1, int r2);

    HttpParams setLongParameter(String r1, long r2);

    HttpParams setParameter(String r1, Object r2);
}
