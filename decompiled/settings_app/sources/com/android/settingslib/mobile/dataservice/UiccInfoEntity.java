package com.android.settingslib.mobile.dataservice;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class UiccInfoEntity {
    public int cardId;
    public int cardState;
    public boolean isActive;
    public boolean isEuicc;
    public boolean isMultipleEnabledProfilesSupported;
    public boolean isRemovable;
    public int logicalSlotIndex;
    public String physicalSlotIndex;
    public int portIndex;
    public String subId;

    public UiccInfoEntity(String r1, String r2, int r3, int r4, boolean r5, boolean r6, int r7, boolean r8, boolean r9, int r10) {
        this.subId = r1;
        this.physicalSlotIndex = r2;
        this.logicalSlotIndex = r3;
        this.cardId = r4;
        this.isEuicc = r5;
        this.isMultipleEnabledProfilesSupported = r6;
        this.cardState = r7;
        this.isRemovable = r8;
        this.isActive = r9;
        this.portIndex = r10;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.subId.hashCode()) * 31) + this.physicalSlotIndex.hashCode()) * 31) + this.logicalSlotIndex) * 31) + this.cardId) * 31) + Boolean.hashCode(this.isEuicc)) * 31) + Boolean.hashCode(this.isMultipleEnabledProfilesSupported)) * 31) + this.cardState) * 31) + Boolean.hashCode(this.isRemovable)) * 31) + Boolean.hashCode(this.isActive)) * 31) + this.portIndex;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UiccInfoEntity) == true) goto L8;
        return false;
    L8:
        UiccInfoEntity r6 = (UiccInfoEntity) r5;
        if (TextUtils.equals(this.subId, r6.subId) == false) goto L30;
        if (TextUtils.equals(this.physicalSlotIndex, r6.physicalSlotIndex) == false) goto L30;
        if (this.logicalSlotIndex != r6.logicalSlotIndex) goto L30;
        if (this.cardId != r6.cardId) goto L30;
        if (this.isEuicc != r6.isEuicc) goto L30;
        if (this.isMultipleEnabledProfilesSupported != r6.isMultipleEnabledProfilesSupported) goto L30;
        if (this.cardState != r6.cardState) goto L30;
        if (this.isRemovable != r6.isRemovable) goto L30;
        if (this.isActive != r6.isActive) goto L30;
        if (this.portIndex != r6.portIndex) goto L30;
        return true;
    L30:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(" {UiccInfoEntity(subId = ");
        r0.append(this.subId).append(", logicalSlotIndex = ").append(this.physicalSlotIndex).append(", logicalSlotIndex = ").append(this.logicalSlotIndex).append(", cardId = ").append(this.cardId).append(", isEuicc = ").append(this.isEuicc).append(", isMultipleEnabledProfilesSupported = ").append(this.isMultipleEnabledProfilesSupported).append(", cardState = ").append(this.cardState).append(", isRemovable = ").append(this.isRemovable).append(", isActive = ").append(this.isActive).append(", portIndex = ").append(this.portIndex).append(")}");
        return r0.toString();
    }
}
