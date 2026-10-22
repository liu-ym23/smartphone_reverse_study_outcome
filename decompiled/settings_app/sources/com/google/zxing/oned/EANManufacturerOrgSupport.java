package com.google.zxing.oned;

import com.android.settings.TNTColorProfilesFragment;
import com.bytedance.privacy.utils.PrivacyConst;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.toast.OPopupNotice;
import com.obric.oui.utils.AnimTokens;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class EANManufacturerOrgSupport {
    private final List<String> countryIdentifiers;
    private final List<int[]> ranges;

    EANManufacturerOrgSupport() {
        this.ranges = new ArrayList();
        this.countryIdentifiers = new ArrayList();
    }

    String lookupCountryIdentifier(String r8) {
        initIfNeeded();
        int r9 = Integer.parseInt(r8.substring(0, 3));
        int r0 = this.ranges.size();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L16;
        int[] r4 = this.ranges.get(r2);
        int r5 = r4[0];
        if (r9 < r5) goto L7;
        if (r4.length == 1) goto L12;
        r5 = r4[1];
    L12:
        if (r9 <= r5) goto L14;
        r2 = r2 + 1;
        goto L4
    L14:
        return this.countryIdentifiers.get(r2);
    L7:
        return null;
    L16:
        return null;
    }

    private void add(int[] r2, String r3) {
        this.ranges.add(r2);
        this.countryIdentifiers.add(r3);
    }

    private synchronized void initIfNeeded() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.ranges.isEmpty() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        add(new int[]{0, 19}, "US/CA");     // Catch: Throwable -> L11
        add(new int[]{30, 39}, "US");     // Catch: Throwable -> L11
        add(new int[]{60, 139}, "US/CA");     // Catch: Throwable -> L11
        add(new int[]{300, 379}, "FR");     // Catch: Throwable -> L11
        add(new int[]{380}, "BG");     // Catch: Throwable -> L11
        add(new int[]{383}, "SI");     // Catch: Throwable -> L11
        add(new int[]{385}, "HR");     // Catch: Throwable -> L11
        add(new int[]{387}, "BA");     // Catch: Throwable -> L11
        add(new int[]{400, AbstractDialog.HORIZONTAL_MAX_WIDTH}, "DE");     // Catch: Throwable -> L11
        add(new int[]{AnimTokens.OUI_ANIMATION_DURATION_LONG_1, 459}, "JP");     // Catch: Throwable -> L11
        add(new int[]{OPopupNotice.DUX_BOTTOM_NOTICE_SMALL_WINDOW_WIDTH_IN_DP, 469}, "RU");     // Catch: Throwable -> L11
        add(new int[]{471}, "TW");     // Catch: Throwable -> L11
        add(new int[]{474}, "EE");     // Catch: Throwable -> L11
        add(new int[]{475}, "LV");     // Catch: Throwable -> L11
        add(new int[]{476}, "AZ");     // Catch: Throwable -> L11
        add(new int[]{477}, "LT");     // Catch: Throwable -> L11
        add(new int[]{478}, "UZ");     // Catch: Throwable -> L11
        add(new int[]{479}, "LK");     // Catch: Throwable -> L11
        add(new int[]{480}, "PH");     // Catch: Throwable -> L11
        add(new int[]{481}, "BY");     // Catch: Throwable -> L11
        add(new int[]{482}, "UA");     // Catch: Throwable -> L11
        add(new int[]{484}, "MD");     // Catch: Throwable -> L11
        add(new int[]{485}, "AM");     // Catch: Throwable -> L11
        add(new int[]{486}, "GE");     // Catch: Throwable -> L11
        add(new int[]{487}, "KZ");     // Catch: Throwable -> L11
        add(new int[]{489}, "HK");     // Catch: Throwable -> L11
        add(new int[]{490, 499}, "JP");     // Catch: Throwable -> L11
        add(new int[]{500, 509}, "GB");     // Catch: Throwable -> L11
        add(new int[]{520}, "GR");     // Catch: Throwable -> L11
        add(new int[]{528}, ExpandedProductParsedResult.POUND);     // Catch: Throwable -> L11
        add(new int[]{529}, "CY");     // Catch: Throwable -> L11
        add(new int[]{531}, "MK");     // Catch: Throwable -> L11
        add(new int[]{535}, "MT");     // Catch: Throwable -> L11
        add(new int[]{539}, "IE");     // Catch: Throwable -> L11
        add(new int[]{TNTColorProfilesFragment.PROGRESS_MAX, 549}, "BE/LU");     // Catch: Throwable -> L11
        add(new int[]{560}, "PT");     // Catch: Throwable -> L11
        add(new int[]{569}, "IS");     // Catch: Throwable -> L11
        add(new int[]{570, 579}, "DK");     // Catch: Throwable -> L11
        add(new int[]{590}, "PL");     // Catch: Throwable -> L11
        add(new int[]{594}, "RO");     // Catch: Throwable -> L11
        add(new int[]{599}, "HU");     // Catch: Throwable -> L11
        add(new int[]{600, 601}, "ZA");     // Catch: Throwable -> L11
        add(new int[]{603}, "GH");     // Catch: Throwable -> L11
        add(new int[]{608}, "BH");     // Catch: Throwable -> L11
        add(new int[]{609}, "MU");     // Catch: Throwable -> L11
        add(new int[]{611}, "MA");     // Catch: Throwable -> L11
        add(new int[]{613}, "DZ");     // Catch: Throwable -> L11
        add(new int[]{616}, "KE");     // Catch: Throwable -> L11
        add(new int[]{618}, "CI");     // Catch: Throwable -> L11
        add(new int[]{619}, "TN");     // Catch: Throwable -> L11
        add(new int[]{621}, "SY");     // Catch: Throwable -> L11
        add(new int[]{622}, "EG");     // Catch: Throwable -> L11
        add(new int[]{624}, "LY");     // Catch: Throwable -> L11
        add(new int[]{625}, "JO");     // Catch: Throwable -> L11
        add(new int[]{626}, "IR");     // Catch: Throwable -> L11
        add(new int[]{627}, "KW");     // Catch: Throwable -> L11
        add(new int[]{628}, "SA");     // Catch: Throwable -> L11
        add(new int[]{629}, "AE");     // Catch: Throwable -> L11
        add(new int[]{640, 649}, "FI");     // Catch: Throwable -> L11
        add(new int[]{690, 695}, "CN");     // Catch: Throwable -> L11
        add(new int[]{700, 709}, "NO");     // Catch: Throwable -> L11
        add(new int[]{729}, "IL");     // Catch: Throwable -> L11
        add(new int[]{730, 739}, "SE");     // Catch: Throwable -> L11
        add(new int[]{740}, "GT");     // Catch: Throwable -> L11
        add(new int[]{741}, "SV");     // Catch: Throwable -> L11
        add(new int[]{742}, "HN");     // Catch: Throwable -> L11
        add(new int[]{743}, "NI");     // Catch: Throwable -> L11
        add(new int[]{744}, "CR");     // Catch: Throwable -> L11
        add(new int[]{745}, "PA");     // Catch: Throwable -> L11
        add(new int[]{746}, "DO");     // Catch: Throwable -> L11
        add(new int[]{750}, "MX");     // Catch: Throwable -> L11
        add(new int[]{754, 755}, "CA");     // Catch: Throwable -> L11
        add(new int[]{759}, "VE");     // Catch: Throwable -> L11
        add(new int[]{760, 769}, "CH");     // Catch: Throwable -> L11
        add(new int[]{770}, "CO");     // Catch: Throwable -> L11
        add(new int[]{773}, "UY");     // Catch: Throwable -> L11
        add(new int[]{775}, "PE");     // Catch: Throwable -> L11
        add(new int[]{777}, "BO");     // Catch: Throwable -> L11
        add(new int[]{779}, "AR");     // Catch: Throwable -> L11
        add(new int[]{780}, "CL");     // Catch: Throwable -> L11
        add(new int[]{784}, "PY");     // Catch: Throwable -> L11
        add(new int[]{785}, "PE");     // Catch: Throwable -> L11
        add(new int[]{786}, PrivacyConst.ALGORITHM_EC);     // Catch: Throwable -> L11
        add(new int[]{789, 790}, "BR");     // Catch: Throwable -> L11
        add(new int[]{800, 839}, "IT");     // Catch: Throwable -> L11
        add(new int[]{840, 849}, "ES");     // Catch: Throwable -> L11
        add(new int[]{850}, "CU");     // Catch: Throwable -> L11
        add(new int[]{858}, "SK");     // Catch: Throwable -> L11
        add(new int[]{859}, "CZ");     // Catch: Throwable -> L11
        add(new int[]{860}, "YU");     // Catch: Throwable -> L11
        add(new int[]{865}, "MN");     // Catch: Throwable -> L11
        add(new int[]{867}, "KP");     // Catch: Throwable -> L11
        add(new int[]{868, 869}, "TR");     // Catch: Throwable -> L11
        add(new int[]{870, 879}, "NL");     // Catch: Throwable -> L11
        add(new int[]{880}, "KR");     // Catch: Throwable -> L11
        add(new int[]{885}, "TH");     // Catch: Throwable -> L11
        add(new int[]{888}, "SG");     // Catch: Throwable -> L11
        add(new int[]{890}, "IN");     // Catch: Throwable -> L11
        add(new int[]{893}, "VN");     // Catch: Throwable -> L11
        add(new int[]{896}, "PK");     // Catch: Throwable -> L11
        add(new int[]{899}, "ID");     // Catch: Throwable -> L11
        add(new int[]{900, 919}, "AT");     // Catch: Throwable -> L11
        add(new int[]{930, 939}, "AU");     // Catch: Throwable -> L11
        add(new int[]{940, 949}, "AZ");     // Catch: Throwable -> L11
        add(new int[]{955}, "MY");     // Catch: Throwable -> L11
        add(new int[]{958}, "MO");     // Catch: Throwable -> L11
        monitor-exit(this);
    }
}
