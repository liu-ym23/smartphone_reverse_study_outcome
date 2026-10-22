package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes4.dex */
public final class GeoParsedResult extends ParsedResult {
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final String query;

    GeoParsedResult(double r2, double r4, double r6, String r8) {
        super(ParsedResultType.GEO);
        this.latitude = r2;
        this.longitude = r4;
        this.altitude = r6;
        this.query = r8;
    }

    public String getGeoURI() {
        StringBuilder r0 = new StringBuilder("geo:");
        r0.append(this.latitude);
        r0.append(',');
        r0.append(this.longitude);
        if (this.altitude <= 0.0d) goto L6;
        r0.append(',');
        r0.append(this.altitude);
    L6:
        if (this.query == null) goto L9;
        r0.append('?');
        r0.append(this.query);
    L9:
        return r0.toString();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public String getQuery() {
        return this.query;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(20);
        r0.append(this.latitude);
        r0.append(", ");
        r0.append(this.longitude);
        if (this.altitude <= 0.0d) goto L6;
        r0.append(", ");
        r0.append(this.altitude);
        r0.append('m');
    L6:
        if (this.query == null) goto L9;
        r0.append(" (");
        r0.append(this.query);
        r0.append(')');
    L9:
        return r0.toString();
    }
}
