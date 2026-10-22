package com.android.settingslib.mobile.dataservice;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class MobileNetworkInfoEntity {
    public boolean activeNetworkIsCellular;
    public boolean isCdmaOptions;
    public boolean isContactDiscoveryEnabled;
    public boolean isContactDiscoveryVisible;
    public boolean isDataRoamingEnabled;
    public boolean isGsmOptions;
    public boolean isMobileDataEnabled;
    public boolean isTdscdmaSupported;
    public boolean isWorldMode;
    public boolean shouldDisplayNetworkSelectOptions;
    public boolean showToggleForPhysicalSim;
    public String subId;

    public MobileNetworkInfoEntity(String r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12) {
        this.subId = r1;
        this.isContactDiscoveryEnabled = r2;
        this.isContactDiscoveryVisible = r3;
        this.isMobileDataEnabled = r4;
        this.isCdmaOptions = r5;
        this.isGsmOptions = r6;
        this.isWorldMode = r7;
        this.shouldDisplayNetworkSelectOptions = r8;
        this.isTdscdmaSupported = r9;
        this.activeNetworkIsCellular = r10;
        this.showToggleForPhysicalSim = r11;
        this.isDataRoamingEnabled = r12;
    }

    public int hashCode() {
        return ((((((((((((((((((((((527 + this.subId.hashCode()) * 31) + Boolean.hashCode(this.isContactDiscoveryEnabled)) * 31) + Boolean.hashCode(this.isContactDiscoveryVisible)) * 31) + Boolean.hashCode(this.isMobileDataEnabled)) * 31) + Boolean.hashCode(this.isCdmaOptions)) * 31) + Boolean.hashCode(this.isGsmOptions)) * 31) + Boolean.hashCode(this.isWorldMode)) * 31) + Boolean.hashCode(this.shouldDisplayNetworkSelectOptions)) * 31) + Boolean.hashCode(this.isTdscdmaSupported)) * 31) + Boolean.hashCode(this.activeNetworkIsCellular)) * 31) + Boolean.hashCode(this.showToggleForPhysicalSim)) * 31) + Boolean.hashCode(this.isDataRoamingEnabled);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MobileNetworkInfoEntity) == true) goto L8;
        return false;
    L8:
        MobileNetworkInfoEntity r6 = (MobileNetworkInfoEntity) r5;
        if (TextUtils.equals(this.subId, r6.subId) == false) goto L34;
        if (this.isContactDiscoveryEnabled != r6.isContactDiscoveryEnabled) goto L34;
        if (this.isContactDiscoveryVisible != r6.isContactDiscoveryVisible) goto L34;
        if (this.isMobileDataEnabled != r6.isMobileDataEnabled) goto L34;
        if (this.isCdmaOptions != r6.isCdmaOptions) goto L34;
        if (this.isGsmOptions != r6.isGsmOptions) goto L34;
        if (this.isWorldMode != r6.isWorldMode) goto L34;
        if (this.shouldDisplayNetworkSelectOptions != r6.shouldDisplayNetworkSelectOptions) goto L34;
        if (this.isTdscdmaSupported != r6.isTdscdmaSupported) goto L34;
        if (this.activeNetworkIsCellular != r6.activeNetworkIsCellular) goto L34;
        if (this.showToggleForPhysicalSim != r6.showToggleForPhysicalSim) goto L34;
        if (this.isDataRoamingEnabled != r6.isDataRoamingEnabled) goto L34;
        return true;
    L34:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(" {MobileNetworkInfoEntity(subId = ");
        r0.append(this.subId).append(", isContactDiscoveryEnabled = ").append(this.isContactDiscoveryEnabled).append(", isContactDiscoveryVisible = ").append(this.isContactDiscoveryVisible).append(", isMobileDataEnabled = ").append(this.isMobileDataEnabled).append(", isCdmaOptions = ").append(this.isCdmaOptions).append(", isGsmOptions = ").append(this.isGsmOptions).append(", isWorldMode = ").append(this.isWorldMode).append(", shouldDisplayNetworkSelectOptions = ").append(this.shouldDisplayNetworkSelectOptions).append(", isTdscdmaSupported = ").append(this.isTdscdmaSupported).append(", activeNetworkIsCellular = ").append(this.activeNetworkIsCellular).append(", showToggleForPhysicalSim = ").append(this.showToggleForPhysicalSim).append(", isDataRoamingEnabled = ").append(this.isDataRoamingEnabled).append(")}");
        return r0.toString();
    }
}
