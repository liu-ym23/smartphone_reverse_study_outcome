package com.google.zxing.client.result;

import cz.msebera.android.httpclient.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public final class VINParsedResult extends ParsedResult {
    private final String countryCode;
    private final int modelYear;
    private final char plantCode;
    private final String sequentialNumber;
    private final String vehicleAttributes;
    private final String vehicleDescriptorSection;
    private final String vehicleIdentifierSection;
    private final String vin;
    private final String worldManufacturerID;

    public VINParsedResult(String r2, String r3, String r4, String r5, String r6, String r7, int r8, char r9, String r10) {
        super(ParsedResultType.VIN);
        this.vin = r2;
        this.worldManufacturerID = r3;
        this.vehicleDescriptorSection = r4;
        this.vehicleIdentifierSection = r5;
        this.countryCode = r6;
        this.vehicleAttributes = r7;
        this.modelYear = r8;
        this.plantCode = r9;
        this.sequentialNumber = r10;
    }

    public String getVIN() {
        return this.vin;
    }

    public String getWorldManufacturerID() {
        return this.worldManufacturerID;
    }

    public String getVehicleDescriptorSection() {
        return this.vehicleDescriptorSection;
    }

    public String getVehicleIdentifierSection() {
        return this.vehicleIdentifierSection;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getVehicleAttributes() {
        return this.vehicleAttributes;
    }

    public int getModelYear() {
        return this.modelYear;
    }

    public char getPlantCode() {
        return this.plantCode;
    }

    public String getSequentialNumber() {
        return this.sequentialNumber;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(50);
        r0.append(this.worldManufacturerID).append(TokenParser.SP);
        r0.append(this.vehicleDescriptorSection).append(TokenParser.SP);
        r0.append(this.vehicleIdentifierSection).append('\n');
        String r1 = this.countryCode;
        if (r1 == null) goto L5;
        r0.append(r1).append(TokenParser.SP);
    L5:
        r0.append(this.modelYear).append(TokenParser.SP);
        r0.append(this.plantCode).append(TokenParser.SP);
        r0.append(this.sequentialNumber).append('\n');
        return r0.toString();
    }
}
