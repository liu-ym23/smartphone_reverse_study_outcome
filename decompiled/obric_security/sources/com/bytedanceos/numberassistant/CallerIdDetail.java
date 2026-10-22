package com.bytedanceos.numberassistant;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class CallerIdDetail implements Parcelable {
    public static final String BOOK_HOTEL_AIRLINE = "book hotel/airline";
    public static final String CAR_SERVICE = "car_service";
    public static final String CRANK = "crank";
    public static final Parcelable.Creator<CallerIdDetail> CREATOR = null;
    public static final String CRIME = "crime";
    public static final String CUSTOMER_SERVICE = "customer_service";
    public static final String DECORATION = "decoration";
    public static final String EDUCATION = "education";
    public static final String ENTERPRISE = "enterprise";
    public static final String EXPRESS = "express";
    public static final String FINANCIAL_PRODUCTS = "financial products";
    public static final String FRAUD = "fraud";
    public static final String HEADHUNTING = "headhunting";
    public static final String HOUSE_AGENT = "house agent";
    public static final String INSURANCE = "insurance";
    public static final String MEAL_DELIVERY = "Meal Delivery";
    public static final String ON_SITE_PICK_UP = "On-Site Pick-Up";
    public static final String ORDER_TRACKING = "Order Tracking";
    public static final String OTHERS = "others";
    public static final String PACKAGE_DELIVERY = "Package Delivery";
    public static final String PICK_UP_NOTICE = "Pick-up Notice";
    public static final String PROMOTE_SALES = "promote sales";
    public static final String PUBLIC_SERVICES = "public services";
    public static final String RECRUITMENT = "recruitment";
    public static final String REPAIR = "repair";
    public static final String RING_ONCE = "ring_once";
    public static final int SOURCE_BASE = 100;
    public static final int SOURCE_MAX = 103;
    public static final int SOURCE_MEAL = 103;
    public static final int SOURCE_PACKAGE = 101;
    public static final int SOURCE_TAXI = 102;
    public static final String TAXI_BOOKING = "Taxi Booking";
    private final String mAttribute;
    private final String mClassify;
    private final boolean mIsVerified;
    private final boolean mIsVip;
    private final Uri mLogoUrl;
    private final int mMarkedCount;
    private final String mName;
    private final String mNumber;
    private final String mSlogan;
    private final int mSource;
    private final String mWarningMsg;

    public static final enum Source extends Enum<Source> {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final Source CUSTOMIZED = null;
        public static final Source EMPTY = null;
        public static final Source OFFLINE = null;
        public static final Source ONLINE = null;

        private static /* synthetic */ Source[] $values() {
            return new Source[]{EMPTY, OFFLINE, ONLINE, CUSTOMIZED};
        }

        static {
            EMPTY = new Source("EMPTY", 0);
            OFFLINE = new Source("OFFLINE", 1);
            ONLINE = new Source("ONLINE", 2);
            CUSTOMIZED = new Source("CUSTOMIZED", 3);
            $VALUES = $values();
        }

        private Source(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static Source valueOf(String name) {
            return (Source) Enum.valueOf(Source.class, name);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public String getName() {
        return this.mName;
    }

    public String getClassify() {
        return this.mClassify;
    }

    public String getClassifyName(Context context) {
        if (context == null) goto L111;
        String r1 = this.mClassify;
        if (r1 == null) goto L111;
        if ("others".equals(r1) == false) goto L12;
        return context.getString(R.string.cootek_classify_others);
    L12:
        if ("crank".equals(this.mClassify) == false) goto L16;
        return context.getString(R.string.cootek_classify_crank);
    L16:
        if ("fraud".equals(this.mClassify) == false) goto L20;
        return context.getString(R.string.cootek_classify_fraud);
    L20:
        if ("house agent".equals(this.mClassify) == false) goto L24;
        return context.getString(R.string.cootek_classify_house_agent);
    L24:
        if ("insurance".equals(this.mClassify) == false) goto L28;
        return context.getString(R.string.cootek_classify_insurance);
    L28:
        if ("financial products".equals(this.mClassify) == false) goto L32;
        return context.getString(R.string.cootek_classify_financial_products);
    L32:
        if ("headhunting".equals(this.mClassify) == false) goto L36;
        return context.getString(R.string.cootek_classify_headhunting);
    L36:
        if ("promote sales".equals(this.mClassify) == false) goto L40;
        return context.getString(R.string.cootek_classify_promote_sales);
    L40:
        if ("repair".equals(this.mClassify) == false) goto L44;
        return context.getString(R.string.cootek_classify_repair);
    L44:
        if ("book hotel/airline".equals(this.mClassify) == false) goto L48;
        return context.getString(R.string.cootek_classify_book_hotel_airline);
    L48:
        if ("public services".equals(this.mClassify) == false) goto L52;
        return context.getString(R.string.cootek_classify_public_service);
    L52:
        if ("express".equals(this.mClassify) == false) goto L56;
        return context.getString(R.string.cootek_classify_express);
    L56:
        if ("car_service".equals(this.mClassify) == false) goto L60;
        return context.getString(R.string.cootek_classify_car_service);
    L60:
        if ("recruitment".equals(this.mClassify) == false) goto L64;
        return context.getString(R.string.cootek_classify_recruitment);
    L64:
        if ("ring_once".equals(this.mClassify) == false) goto L68;
        return context.getString(R.string.cootek_classify_ring_once);
    L68:
        if ("decoration".equals(this.mClassify) == false) goto L72;
        return context.getString(R.string.cootek_classify_decoration);
    L72:
        if ("crime".equals(this.mClassify) == false) goto L76;
        return context.getString(R.string.cootek_classify_crime);
    L76:
        if ("education".equals(this.mClassify) == false) goto L80;
        return context.getString(R.string.cootek_classify_education);
    L80:
        if ("enterprise".equals(this.mClassify) == false) goto L84;
        return context.getString(R.string.cootek_classify_enterprise);
    L84:
        if ("customer_service".equals(this.mClassify) == false) goto L88;
        return context.getString(R.string.cootek_classify_customer_service);
    L88:
        if (PACKAGE_DELIVERY.equals(this.mClassify) == false) goto L92;
        return context.getString(R.string.xy_classify_package_delivery);
    L92:
        if (ON_SITE_PICK_UP.equals(this.mClassify) == false) goto L96;
        return context.getString(R.string.xy_classify_on_site_pick_up);
    L96:
        if (TAXI_BOOKING.equals(this.mClassify) == false) goto L100;
        return context.getString(R.string.xy_classify_taxi_booking);
    L100:
        if (MEAL_DELIVERY.equals(this.mClassify) == false) goto L104;
        return context.getString(R.string.xy_classify_meal_delivery);
    L104:
        if (ORDER_TRACKING.equals(this.mClassify) == false) goto L108;
        return context.getString(R.string.xy_classify_order_tracking);
    L108:
        if (PICK_UP_NOTICE.equals(this.mClassify) == false) goto L111;
        return context.getString(R.string.xy_classify_pick_up_notice);
    L111:
        return null;
    }

    public String getSourceName(Context context) {
        if (context == null) goto L19;
        int r2 = this.mSource;
        if (r2 == 0) goto L19;
        if (r2 != 101) goto L12;
        return context.getString(R.string.xy_source_package);
    L12:
        if (r2 != 102) goto L16;
        return context.getString(R.string.xy_source_taxi);
    L16:
        if (r2 != 103) goto L19;
        return context.getString(R.string.xy_source_meal);
    L19:
        return null;
    }

    public boolean isVip() {
        return this.mIsVip;
    }

    public boolean isVerified() {
        return this.mIsVerified;
    }

    public Uri getLogoUrl() {
        return this.mLogoUrl;
    }

    public String getSlogan() {
        return this.mSlogan;
    }

    public String getWarningMsg() {
        return this.mWarningMsg;
    }

    public int getMarkedCount() {
        return this.mMarkedCount;
    }

    public int getSource() {
        return this.mSource;
    }

    public String getAttribute() {
        return this.mAttribute;
    }

    public CallerIdDetail(String number, String name, String classify, boolean isVip, boolean isVerified, Uri logoUrl, String slogan, String warningMsg, int markedCount, int source, String attribute) {
        this.mNumber = number;
        this.mName = name;
        this.mClassify = classify;
        this.mIsVip = isVip;
        this.mIsVerified = isVerified;
        this.mLogoUrl = logoUrl;
        this.mSlogan = slogan;
        this.mWarningMsg = warningMsg;
        this.mMarkedCount = markedCount;
        this.mSource = source;
        this.mAttribute = attribute;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("number:");
        StringBuilder r1 = r0.append(this.mNumber).append(", name:").append(this.mName).append(", classify:").append(this.mClassify).append(", isVip:").append(this.mIsVip).append(", isVerified:").append(this.mIsVerified).append(", logoUrl:");
        Uri r2 = this.mLogoUrl;
        if (r2 == null) goto L5;
        String r3 = r2.toSafeString();
    L6:
        r1.append(r3).append(", slogan:").append(this.mSlogan).append(", warningMsg:").append(this.mWarningMsg).append(", markedCount:").append(this.mMarkedCount).append(", source:").append(this.mSource).append(", attribute:").append(this.mAttribute);
        return r0.toString();
    L5:
        r3 = "null";
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.mNumber);
        r2.writeString(this.mName);
        r2.writeString(this.mClassify);
        r2.writeInt(this.mIsVip ? 1 : 0);
        r2.writeInt(this.mIsVerified ? 1 : 0);
        r2.writeParcelable(this.mLogoUrl, 0);
        r2.writeString(this.mSlogan);
        r2.writeString(this.mWarningMsg);
        r2.writeInt(this.mMarkedCount);
        r2.writeInt(this.mSource);
        r2.writeString(this.mAttribute);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
