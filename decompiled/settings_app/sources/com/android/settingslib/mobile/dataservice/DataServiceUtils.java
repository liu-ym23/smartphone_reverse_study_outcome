package com.android.settingslib.mobile.dataservice;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataServiceUtils {

    public static final class MobileNetworkInfoData {
        public static final String COLUMN_ACTIVE_NETWORK_IS_CELLULAR = "activeNetworkIsCellular";
        public static final String COLUMN_ID = "subId";
        public static final String COLUMN_IS_CDMA_OPTIONS = "isCdmaOptions";
        public static final String COLUMN_IS_CONTACT_DISCOVERY_ENABLED = "isContactDiscoveryEnabled";
        public static final String COLUMN_IS_CONTACT_DISCOVERY_VISIBLE = "isContactDiscoveryVisible";
        public static final String COLUMN_IS_DATA_ROAMING_ENABLED = "isDataRoamingEnabled";
        public static final String COLUMN_IS_GSM_OPTIONS = "isGsmOptions";
        public static final String COLUMN_IS_MOBILE_DATA_ENABLED = "isMobileDataEnabled";
        public static final String COLUMN_IS_TDSCDMA_SUPPORTED = "isTdscdmaSupported";
        public static final String COLUMN_IS_WORLD_MODE = "isWorldMode";
        public static final String COLUMN_SHOULD_DISPLAY_NETWORK_SELECT_OPTIONS = "shouldDisplayNetworkSelectOptions";
        public static final String COLUMN_SHOW_TOGGLE_FOR_PHYSICAL_SIM = "showToggleForPhysicalSim";
        public static final String TABLE_NAME = "MobileNetworkInfo";

        public MobileNetworkInfoData() {
        }
    }

    public static final class SubscriptionInfoData {
        public static final String COLUMN_CARD_ID = "cardId";
        public static final String COLUMN_CARRIER_ID = "carrierId";
        public static final String COLUMN_CARRIER_NAME = "carrierName";
        public static final String COLUMN_COUNTRY_ISO = "countryIso";
        public static final String COLUMN_DATA_ROAMING = "dataRoaming";
        public static final String COLUMN_DISPLAY_NAME = "displayName";
        public static final String COLUMN_FORMATTED_PHONE_NUMBER = "getFormattedPhoneNumber";
        public static final String COLUMN_GROUP_UUID = "groupUUID";
        public static final String COLUMN_ID = "sudId";
        public static final String COLUMN_IS_ACTIVE_DATA_SUBSCRIPTION = "isActiveDataSubscriptionId";
        public static final String COLUMN_IS_ACTIVE_SUBSCRIPTION_ID = "isActiveSubscription";
        public static final String COLUMN_IS_AVAILABLE_SUBSCRIPTION = "isAvailableSubscription";
        public static final String COLUMN_IS_DEFAULT_SUBSCRIPTION_SELECTION = "isDefaultSubscriptionSelection";
        public static final String COLUMN_IS_EMBEDDED = "isEmbedded";
        public static final String COLUMN_IS_FIRST_REMOVABLE_SUBSCRIPTION = "isFirstRemovableSubscription";
        public static final String COLUMN_IS_OPPORTUNISTIC = "isOpportunistic";
        public static final String COLUMN_IS_SUBSCRIPTION_VISIBLE = "isSubscriptionVisible";
        public static final String COLUMN_IS_USABLE_SUBSCRIPTION = "isUsableSubscription";
        public static final String COLUMN_IS_VALID_SUBSCRIPTION = "isValidSubscription";
        public static final String COLUMN_MCC = "mcc";
        public static final String COLUMN_MNC = "mnc";
        public static final String COLUMN_PORT_INDEX = "portIndex";
        public static final String COLUMN_SIM_SLOT_INDEX = "simSlotIndex";
        public static final String COLUMN_SUBSCRIPTION_TYPE = "subscriptionType";
        public static final String COLUMN_UNIQUE_NAME = "uniqueName";
        public static final String TABLE_NAME = "subscriptionInfo";

        public SubscriptionInfoData() {
        }
    }

    public static final class UiccInfoData {
        public static final String COLUMN_CARD_ID = "cardId";
        public static final String COLUMN_CARD_STATE = "cardState";
        public static final String COLUMN_ID = "sudId";
        public static final String COLUMN_IS_ACTIVE = "isActive";
        public static final String COLUMN_IS_EUICC = "isEuicc";
        public static final String COLUMN_IS_EXTENDED_APDU_SUPPORTED = "isExtendedApduSupported";
        public static final String COLUMN_IS_MULTIPLE_ENABLED_PROFILES_SUPPORTED = "isMultipleEnabledProfilesSupported";
        public static final String COLUMN_IS_REMOVABLE = "isRemovable";
        public static final String COLUMN_LOGICAL_SLOT_INDEX = "logicalSlotIndex";
        public static final String COLUMN_PHYSICAL_SLOT_INDEX = "physicalSlotIndex";
        public static final String COLUMN_PORT_INDEX = "portIndex";
        public static final String TABLE_NAME = "uiccInfo";

        public UiccInfoData() {
        }
    }

    public DataServiceUtils() {
    }

    public static <T> boolean shouldUpdateEntityList(List<T> r1, List<T> r2) {
        if (r1 == null) goto L8;
        if (r2.isEmpty() == false) goto L6;
        return true;
    L6:
        if (r2.equals(r1) == true) goto L8;
        return true;
    L8:
        if (r2.isEmpty() == true) goto L12;
        if (r1 != null) goto L16;
        return true;
    L16:
        return false;
    L12:
        return false;
    }
}
