package com.bytedanceos.numberassistant;

import android.content.Context;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class CallerIdDetailUtils {
    public static final String BOOK_HOTEL_AIRLINE = "book hotel/airline";
    public static final String CAR_SERVICE = "car_service";
    public static final String CRANK = "crank";
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
    public static final String OTHERS = "others";
    public static final String PROMOTE_SALES = "promote sales";
    public static final String PUBLIC_SERVICES = "public services";
    public static final String RECRUITMENT = "recruitment";
    public static final String REPAIR = "repair";
    public static final String RING_ONCE = "ring_once";
    public static final int TYPE_CAR_SERVICE = 64;
    public static final int TYPE_CRANK = 2;
    public static final int TYPE_CRIME = 1024;
    public static final int TYPE_CUSTOMER_SERVICE = 8192;
    public static final int TYPE_DECORATION = 512;
    public static final int TYPE_DEFAULT = 1031;
    public static final int TYPE_EDUCATION = 2048;
    public static final int TYPE_ENTERPRISE = 4096;
    public static final int TYPE_EXPRESS = 16;
    public static final int TYPE_FRAUD = 1;
    public static final int TYPE_HOUSE_AGENT = 8;
    public static final int TYPE_INSURANCE = 16384;
    public static final int TYPE_PROMOTE_SALES = 4;
    public static final int TYPE_RECRUITMENT = 128;
    public static final int TYPE_RING_ONCE = 256;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_UNKNOWN_NUMBER = 32;

    private static String getClassifyFromType(int type) {
        if (type != 1) goto L5;
        return "fraud";
    L5:
        if (type == 2) goto L33;
        switch(type) {
            case 4: goto L31;
            case 8: goto L29;
            case 16: goto L27;
            case 64: goto L25;
            case 128: goto L23;
            case 256: goto L21;
            case 512: goto L19;
            case 1024: goto L17;
            case 2048: goto L15;
            case 4096: goto L13;
            case 8192: goto L11;
            case 16384: goto L9;
            default: goto L7;
        };
    L7:
        return null;
    L9:
        return "insurance";
    L11:
        return "customer_service";
    L13:
        return "enterprise";
    L15:
        return "education";
    L17:
        return "crime";
    L19:
        return "decoration";
    L21:
        return "ring_once";
    L23:
        return "recruitment";
    L25:
        return "car_service";
    L27:
        return "express";
    L29:
        return "house agent";
    L31:
        return "promote sales";
    L33:
        return "crank";
    }

    public CallerIdDetailUtils() {
    }

    public static int getTypeFromClassify(String classify) {
        if (classify != null) goto L6;
        return -1;
    L6:
        if ("crank".equals(classify) == false) goto L10;
        return 2;
    L10:
        if ("fraud".equals(classify) == false) goto L14;
        return 1;
    L14:
        if ("house agent".equals(classify) == false) goto L18;
        return 8;
    L18:
        if ("promote sales".equals(classify) == false) goto L22;
        return 4;
    L22:
        if ("express".equals(classify) == false) goto L26;
        return 16;
    L26:
        if ("car_service".equals(classify) == false) goto L30;
        return 64;
    L30:
        if ("recruitment".equals(classify) == false) goto L34;
        return 128;
    L34:
        if ("ring_once".equals(classify) == false) goto L38;
        return 256;
    L38:
        if ("decoration".equals(classify) == false) goto L42;
        return 512;
    L42:
        if ("crime".equals(classify) == false) goto L46;
        return 1024;
    L46:
        if ("education".equals(classify) == false) goto L50;
        return 2048;
    L50:
        if ("enterprise".equals(classify) == false) goto L54;
        return 4096;
    L54:
        if ("customer_service".equals(classify) == false) goto L58;
        return 8192;
    L58:
        if ("insurance".equals(classify) == false) goto L61;
        return 16384;
    L61:
        return -1;
    }

    public static String getClassifyName(Context context, int type) {
        String r3 = getClassifyFromType(type);
        if (context == null) goto L62;
        if (r3 == null) goto L62;
        if ("crank".equals(r3) == false) goto L11;
        return context.getString(R.string.cootek_classify_crank);
    L11:
        if ("fraud".equals(r3) == false) goto L15;
        return context.getString(R.string.cootek_classify_fraud);
    L15:
        if ("house agent".equals(r3) == false) goto L19;
        return context.getString(R.string.cootek_classify_house_agent);
    L19:
        if ("promote sales".equals(r3) == false) goto L23;
        return context.getString(R.string.cootek_classify_promote_sales);
    L23:
        if ("express".equals(r3) == false) goto L27;
        return context.getString(R.string.cootek_classify_express);
    L27:
        if ("car_service".equals(r3) == false) goto L31;
        return context.getString(R.string.cootek_classify_car_service);
    L31:
        if ("recruitment".equals(r3) == false) goto L35;
        return context.getString(R.string.cootek_classify_recruitment);
    L35:
        if ("ring_once".equals(r3) == false) goto L39;
        return context.getString(R.string.cootek_classify_ring_once);
    L39:
        if ("decoration".equals(r3) == false) goto L43;
        return context.getString(R.string.cootek_classify_decoration);
    L43:
        if ("crime".equals(r3) == false) goto L47;
        return context.getString(R.string.cootek_classify_crime);
    L47:
        if ("education".equals(r3) == false) goto L51;
        return context.getString(R.string.cootek_classify_education);
    L51:
        if ("enterprise".equals(r3) == false) goto L55;
        return context.getString(R.string.cootek_classify_enterprise);
    L55:
        if ("customer_service".equals(r3) == false) goto L59;
        return context.getString(R.string.cootek_classify_customer_service);
    L59:
        if ("insurance".equals(r3) == false) goto L62;
        return context.getString(R.string.cootek_classify_insurance);
    L62:
        return null;
    }
}
