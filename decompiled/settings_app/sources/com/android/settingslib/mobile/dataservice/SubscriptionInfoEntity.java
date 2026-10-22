package com.android.settingslib.mobile.dataservice;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SubscriptionInfoEntity {
    public int cardId;
    public int carrierId;
    public String carrierName;
    public String countryIso;
    public int dataRoaming;
    public String displayName;
    public String formattedPhoneNumber;
    public String groupUUID;
    public boolean isActiveDataSubscriptionId;
    public boolean isActiveSubscriptionId;
    public boolean isAvailableSubscription;
    public boolean isDefaultSubscriptionSelection;
    public boolean isEmbedded;
    public boolean isFirstRemovableSubscription;
    public boolean isOpportunistic;
    public boolean isSubscriptionVisible;
    public boolean isUsableSubscription;
    public boolean isValidSubscription;
    public String mcc;
    public String mnc;
    public int portIndex;
    public int simSlotIndex;
    public String subId;
    public int subscriptionType;
    public String uniqueName;

    public SubscriptionInfoEntity(String r3, int r4, int r5, String r6, String r7, int r8, String r9, String r10, String r11, boolean r12, int r13, int r14, boolean r15, String r16, int r17, String r18, boolean r19, String r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27) {
        this.subId = r3;
        this.simSlotIndex = r4;
        this.carrierId = r5;
        this.displayName = r6;
        this.carrierName = r7;
        this.dataRoaming = r8;
        this.mcc = r9;
        this.mnc = r10;
        this.countryIso = r11;
        this.isEmbedded = r12;
        this.cardId = r13;
        this.portIndex = r14;
        this.isOpportunistic = r15;
        this.groupUUID = r16;
        this.subscriptionType = r17;
        this.uniqueName = r18;
        this.isSubscriptionVisible = r19;
        this.formattedPhoneNumber = r20;
        this.isFirstRemovableSubscription = r21;
        this.isDefaultSubscriptionSelection = r22;
        this.isValidSubscription = r23;
        this.isUsableSubscription = r24;
        this.isActiveSubscriptionId = r25;
        this.isAvailableSubscription = r26;
        this.isActiveDataSubscriptionId = r27;
    }

    public int getSubId() {
        return Integer.valueOf(this.subId).intValue();
    }

    public CharSequence getUniqueDisplayName() {
        return this.uniqueName;
    }

    public boolean isActiveSubscription() {
        return this.isActiveSubscriptionId;
    }

    public boolean isSubscriptionVisible() {
        return this.isSubscriptionVisible;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.subId, Integer.valueOf(this.simSlotIndex), Integer.valueOf(this.carrierId), this.displayName, this.carrierName, Integer.valueOf(this.dataRoaming), this.mcc, this.mnc, this.countryIso, Boolean.valueOf(this.isEmbedded), Integer.valueOf(this.cardId), Integer.valueOf(this.portIndex), Boolean.valueOf(this.isOpportunistic), this.groupUUID, Integer.valueOf(this.subscriptionType), this.uniqueName, Boolean.valueOf(this.isSubscriptionVisible), this.formattedPhoneNumber, Boolean.valueOf(this.isFirstRemovableSubscription), Boolean.valueOf(this.isDefaultSubscriptionSelection), Boolean.valueOf(this.isValidSubscription), Boolean.valueOf(this.isUsableSubscription), Boolean.valueOf(this.isActiveSubscriptionId), Boolean.valueOf(this.isAvailableSubscription), Boolean.valueOf(this.isActiveDataSubscriptionId)});
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscriptionInfoEntity) == true) goto L8;
        return false;
    L8:
        SubscriptionInfoEntity r6 = (SubscriptionInfoEntity) r5;
        if (TextUtils.equals(this.subId, r6.subId) == false) goto L60;
        if (this.simSlotIndex != r6.simSlotIndex) goto L60;
        if (this.carrierId != r6.carrierId) goto L60;
        if (TextUtils.equals(this.displayName, r6.displayName) == false) goto L60;
        if (TextUtils.equals(this.carrierName, r6.carrierName) == false) goto L60;
        if (this.dataRoaming != r6.dataRoaming) goto L60;
        if (TextUtils.equals(this.mcc, r6.mcc) == false) goto L60;
        if (TextUtils.equals(this.mnc, r6.mnc) == false) goto L60;
        if (TextUtils.equals(this.countryIso, r6.countryIso) == false) goto L60;
        if (this.isEmbedded != r6.isEmbedded) goto L60;
        if (this.cardId != r6.cardId) goto L60;
        if (this.portIndex != r6.portIndex) goto L60;
        if (this.isOpportunistic != r6.isOpportunistic) goto L60;
        if (TextUtils.equals(this.groupUUID, r6.groupUUID) == false) goto L60;
        if (this.subscriptionType != r6.subscriptionType) goto L60;
        if (TextUtils.equals(this.uniqueName, r6.uniqueName) == false) goto L60;
        if (this.isSubscriptionVisible != r6.isSubscriptionVisible) goto L60;
        if (TextUtils.equals(this.formattedPhoneNumber, r6.formattedPhoneNumber) == false) goto L60;
        if (this.isFirstRemovableSubscription != r6.isFirstRemovableSubscription) goto L60;
        if (this.isDefaultSubscriptionSelection != r6.isDefaultSubscriptionSelection) goto L60;
        if (this.isValidSubscription != r6.isValidSubscription) goto L60;
        if (this.isUsableSubscription != r6.isUsableSubscription) goto L60;
        if (this.isActiveSubscriptionId != r6.isActiveSubscriptionId) goto L60;
        if (this.isAvailableSubscription != r6.isAvailableSubscription) goto L60;
        if (this.isActiveDataSubscriptionId != r6.isActiveDataSubscriptionId) goto L60;
        return true;
    L60:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(" {SubscriptionInfoEntity(subId = ");
        r0.append(this.subId).append(", simSlotIndex = ").append(this.simSlotIndex).append(", carrierId = ").append(this.carrierId).append(", displayName = ").append(this.displayName).append(", carrierName = ").append(this.carrierName).append(", dataRoaming = ").append(this.dataRoaming).append(", mcc = ").append(this.mcc).append(", mnc = ").append(this.mnc).append(", countryIso = ").append(this.countryIso).append(", isEmbedded = ").append(this.isEmbedded).append(", cardId = ").append(this.cardId).append(", portIndex = ").append(this.portIndex).append(", isOpportunistic = ").append(this.isOpportunistic).append(", groupUUID = ").append(this.groupUUID).append(", subscriptionType = ").append(this.subscriptionType).append(", uniqueName = ").append(this.uniqueName).append(", isSubscriptionVisible = ").append(this.isSubscriptionVisible).append(", formattedPhoneNumber = ").append(this.formattedPhoneNumber).append(", isFirstRemovableSubscription = ").append(this.isFirstRemovableSubscription).append(", isDefaultSubscriptionSelection = ").append(this.isDefaultSubscriptionSelection).append(", isValidSubscription = ").append(this.isValidSubscription).append(", isUsableSubscription = ").append(this.isUsableSubscription).append(", isActiveSubscriptionId = ").append(this.isActiveSubscriptionId).append(", isAvailableSubscription = ").append(this.isAvailableSubscription).append(", isActiveDataSubscriptionId = ").append(this.isActiveDataSubscriptionId).append(")}");
        return r0.toString();
    }
}
