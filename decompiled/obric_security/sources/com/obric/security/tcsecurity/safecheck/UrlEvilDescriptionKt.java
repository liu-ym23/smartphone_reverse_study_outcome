package com.obric.security.tcsecurity.safecheck;

import kotlin.Metadata;

/* JADX INFO: compiled from: UrlEvilDescription.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"EVIL_CHEAT1", "", "EVIL_CHEAT2", "EVIL_DEFAULT", "EVIL_FAULTSALES", "EVIL_ILLEGALCONTENT", "EVIL_LOTTERYWEB", "EVIL_MALICEFILE", "EVIL_NO_NETWORK", "EVIL_RISKWED", "EVIL_SEXYWEB", "getEvilDescription", "", "evilType", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class UrlEvilDescriptionKt {
    public static final int EVIL_CHEAT1 = 1;
    public static final int EVIL_CHEAT2 = 2;
    public static final int EVIL_DEFAULT = 0;
    public static final int EVIL_FAULTSALES = 3;
    public static final int EVIL_ILLEGALCONTENT = 8;
    public static final int EVIL_LOTTERYWEB = 5;
    public static final int EVIL_MALICEFILE = 4;
    public static final int EVIL_NO_NETWORK = -1;
    public static final int EVIL_RISKWED = 7;
    public static final int EVIL_SEXYWEB = 6;

    public static final String getEvilDescription(int r0) {
        switch(r0) {
            case -1: goto L13;
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            case 8: goto L4;
            default: goto L3;
        };
    L3:
        return "未知类型";
    L4:
        return "非法内容";
    L5:
        return "垃圾信息";
    L6:
        return "色情内容";
    L7:
        return "博彩网站";
    L8:
        return "恶意程序";
    L9:
        return "虚假广告";
    L10:
        return "信息欺诈";
    L11:
        return "钓鱼欺诈";
    L12:
        return "非恶意网址";
    L13:
        return "无网络";
    }
}
