package com.android.settings.service.bean;

import android.icu.text.PluralRules;
import com.android.vcard.VCardConfig;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\bA\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010N\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003JÂ\u0002\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\u001b2\b\u0010[\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\\\u001a\u00020]HÖ\u0001J\t\u0010^\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010!R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010!R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010!R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010!R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010!¨\u0006_"}, d2 = {"Lcom/android/settings/service/bean/DeviceInfo;", "", "expireTime", "", "serverTime", "customerServiceName", "", "customerService", "customerServiceIcon", "forumName", "forum", "forumIcon", "wechatName", "wechatUrl", "wechatIcon", "doubaoCommunityName", "doubaoCommunityUrl", "doubaoCommunityIcon", "doubaoPhoneForumName", "doubaoPhoneForumUrl", "doubaoPhoneForumIcon", "rightExplanation", "weiboUrl", "weiboNotInstallUrl", "douyinUrl", "douyinNotInstallUrl", "hideWarrantyCard", "", "glbServiceEmail", "glbServiceName", "glbServiceIcon", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCustomerService", "()Ljava/lang/String;", "getCustomerServiceIcon", "getCustomerServiceName", "getDoubaoCommunityIcon", "getDoubaoCommunityName", "getDoubaoCommunityUrl", "getDoubaoPhoneForumIcon", "getDoubaoPhoneForumName", "getDoubaoPhoneForumUrl", "getDouyinNotInstallUrl", "getDouyinUrl", "getExpireTime", "()J", "getForum", "getForumIcon", "getForumName", "getGlbServiceEmail", "getGlbServiceIcon", "getGlbServiceName", "getHideWarrantyCard", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRightExplanation", "getServerTime", "getWechatIcon", "getWechatName", "getWechatUrl", "getWeiboNotInstallUrl", "getWeiboUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/android/settings/service/bean/DeviceInfo;", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceInfo {

    @SerializedName("customer_service")
    private final String customerService;

    @SerializedName("customer_service_icon")
    private final String customerServiceIcon;

    @SerializedName("customer_service_name")
    private final String customerServiceName;

    @SerializedName("doubao_community_icon")
    private final String doubaoCommunityIcon;

    @SerializedName("doubao_community_name")
    private final String doubaoCommunityName;

    @SerializedName("doubao_community_url")
    private final String doubaoCommunityUrl;

    @SerializedName("doubao_phone_forum_icon")
    private final String doubaoPhoneForumIcon;

    @SerializedName("doubao_phone_forum_name")
    private final String doubaoPhoneForumName;

    @SerializedName("doubao_phone_forum_url")
    private final String doubaoPhoneForumUrl;

    @SerializedName("douyin_not_install_url")
    private final String douyinNotInstallUrl;

    @SerializedName("douyin_url")
    private final String douyinUrl;

    @SerializedName(DowngradeInfo.FIELD_EXPIRE_TIME)
    private final long expireTime;

    @SerializedName("forum")
    private final String forum;

    @SerializedName("forum_icon")
    private final String forumIcon;

    @SerializedName("forum_name")
    private final String forumName;

    @SerializedName("glb_service_email")
    private final String glbServiceEmail;

    @SerializedName("glb_service_icon")
    private final String glbServiceIcon;

    @SerializedName("glb_service_name")
    private final String glbServiceName;

    @SerializedName("hide_warranty_card")
    private final Boolean hideWarrantyCard;

    @SerializedName("right_explanation")
    private final String rightExplanation;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName("wechat_icon")
    private final String wechatIcon;

    @SerializedName("wechat_name")
    private final String wechatName;

    @SerializedName("wechat_qr_code_url")
    private final String wechatUrl;

    @SerializedName("weibo_not_install_url")
    private final String weiboNotInstallUrl;

    @SerializedName("weibo_url")
    private final String weiboUrl;

    public static /* synthetic */ DeviceInfo copy$default(DeviceInfo r17, long r18, long r20, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, Boolean r42, String r43, String r44, String r45, int r46, Object r47) {
        if ((r46 & 1) == 0) goto L5;
        long r2 = r17.expireTime;
    L7:
        if ((r46 & 2) == 0) goto L9;
        long r4 = r17.serverTime;
    L11:
        if ((r46 & 4) == 0) goto L13;
        String r6 = r17.customerServiceName;
    L15:
        if ((r46 & 8) == 0) goto L17;
        String r7 = r17.customerService;
    L19:
        if ((r46 & 16) == 0) goto L21;
        String r8 = r17.customerServiceIcon;
    L23:
        if ((r46 & 32) == 0) goto L25;
        String r9 = r17.forumName;
    L27:
        if ((r46 & 64) == 0) goto L29;
        String r10 = r17.forum;
    L31:
        if ((r46 & 128) == 0) goto L33;
        String r11 = r17.forumIcon;
    L35:
        if ((r46 & 256) == 0) goto L37;
        String r12 = r17.wechatName;
    L39:
        if ((r46 & 512) == 0) goto L41;
        String r13 = r17.wechatUrl;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        String r14 = r17.wechatIcon;
    L47:
        if ((r46 & 2048) == 0) goto L49;
        String r15 = r17.doubaoCommunityName;
    L50:
        String r310 = r15;
        if ((r46 & 4096) == 0) goto L53;
        String r16 = r17.doubaoCommunityUrl;
    L54:
        String r311 = r16;
        if ((r46 & 8192) == 0) goto L57;
        String r19 = r17.doubaoCommunityIcon;
    L58:
        String r312 = r19;
        if ((r46 & 16384) == 0) goto L61;
        String r110 = r17.doubaoPhoneForumName;
    L62:
        String r313 = r110;
        if ((r46 & 32768) == 0) goto L65;
        String r111 = r17.doubaoPhoneForumUrl;
    L66:
        String r314 = r111;
        if ((r46 & 65536) == 0) goto L69;
        String r112 = r17.doubaoPhoneForumIcon;
    L70:
        String r315 = r112;
        if ((r46 & 131072) == 0) goto L73;
        String r113 = r17.rightExplanation;
    L74:
        String r316 = r113;
        if ((r46 & 262144) == 0) goto L77;
        String r114 = r17.weiboUrl;
    L78:
        String r317 = r114;
        if ((r46 & 524288) == 0) goto L81;
        String r115 = r17.weiboNotInstallUrl;
    L82:
        String r318 = r115;
        if ((r46 & 1048576) == 0) goto L85;
        String r116 = r17.douyinUrl;
    L86:
        String r48 = r116;
        if ((r46 & 2097152) == 0) goto L89;
        String r117 = r17.douyinNotInstallUrl;
    L90:
        String r49 = r117;
        if ((r46 & 4194304) == 0) goto L93;
        Boolean r118 = r17.hideWarrantyCard;
    L94:
        Boolean r410 = r118;
        if ((r46 & 8388608) == 0) goto L97;
        String r119 = r17.glbServiceEmail;
    L98:
        String r411 = r119;
        if ((r46 & 16777216) == 0) goto L101;
        String r120 = r17.glbServiceName;
    L103:
        if ((r46 & VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING) == 0) goto L105;
        String r1 = r17.glbServiceIcon;
    L107:
        return r17.copy(r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r48, r49, r410, r411, r120, r1);
    L105:
        r1 = r45;
        goto L107
    L101:
        r120 = r44;
        goto L103
    L97:
        r119 = r43;
        goto L98
    L93:
        r118 = r42;
        goto L94
    L89:
        r117 = r41;
        goto L90
    L85:
        r116 = r40;
        goto L86
    L81:
        r115 = r39;
        goto L82
    L77:
        r114 = r38;
        goto L78
    L73:
        r113 = r37;
        goto L74
    L69:
        r112 = r36;
        goto L70
    L65:
        r111 = r35;
        goto L66
    L61:
        r110 = r34;
        goto L62
    L57:
        r19 = r33;
        goto L58
    L53:
        r16 = r32;
        goto L54
    L49:
        r15 = r31;
        goto L50
    L45:
        r14 = r30;
        goto L47
    L41:
        r13 = r29;
        goto L43
    L37:
        r12 = r28;
        goto L39
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long component1() {
        return this.expireTime;
    }

    public final String component10() {
        return this.wechatUrl;
    }

    public final String component11() {
        return this.wechatIcon;
    }

    public final String component12() {
        return this.doubaoCommunityName;
    }

    public final String component13() {
        return this.doubaoCommunityUrl;
    }

    public final String component14() {
        return this.doubaoCommunityIcon;
    }

    public final String component15() {
        return this.doubaoPhoneForumName;
    }

    public final String component16() {
        return this.doubaoPhoneForumUrl;
    }

    public final String component17() {
        return this.doubaoPhoneForumIcon;
    }

    public final String component18() {
        return this.rightExplanation;
    }

    public final String component19() {
        return this.weiboUrl;
    }

    public final long component2() {
        return this.serverTime;
    }

    public final String component20() {
        return this.weiboNotInstallUrl;
    }

    public final String component21() {
        return this.douyinUrl;
    }

    public final String component22() {
        return this.douyinNotInstallUrl;
    }

    public final Boolean component23() {
        return this.hideWarrantyCard;
    }

    public final String component24() {
        return this.glbServiceEmail;
    }

    public final String component25() {
        return this.glbServiceName;
    }

    public final String component26() {
        return this.glbServiceIcon;
    }

    public final String component3() {
        return this.customerServiceName;
    }

    public final String component4() {
        return this.customerService;
    }

    public final String component5() {
        return this.customerServiceIcon;
    }

    public final String component6() {
        return this.forumName;
    }

    public final String component7() {
        return this.forum;
    }

    public final String component8() {
        return this.forumIcon;
    }

    public final String component9() {
        return this.wechatName;
    }

    public final DeviceInfo copy(long r31, long r33, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, Boolean r55, String r56, String r57, String r58) {
        return new DeviceInfo(r31, r33, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DeviceInfo) == true) goto L8;
        return false;
    L8:
        DeviceInfo r9 = (DeviceInfo) r8;
        if (this.expireTime == r9.expireTime) goto L12;
        return false;
    L12:
        if (this.serverTime == r9.serverTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.customerServiceName, r9.customerServiceName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.customerService, r9.customerService) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.customerServiceIcon, r9.customerServiceIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.forumName, r9.forumName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.forum, r9.forum) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.forumIcon, r9.forumIcon) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.wechatName, r9.wechatName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.wechatUrl, r9.wechatUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.wechatIcon, r9.wechatIcon) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.doubaoCommunityName, r9.doubaoCommunityName) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.doubaoCommunityUrl, r9.doubaoCommunityUrl) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.doubaoCommunityIcon, r9.doubaoCommunityIcon) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.doubaoPhoneForumName, r9.doubaoPhoneForumName) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.doubaoPhoneForumUrl, r9.doubaoPhoneForumUrl) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.doubaoPhoneForumIcon, r9.doubaoPhoneForumIcon) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.rightExplanation, r9.rightExplanation) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.weiboUrl, r9.weiboUrl) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.weiboNotInstallUrl, r9.weiboNotInstallUrl) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.douyinUrl, r9.douyinUrl) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.douyinNotInstallUrl, r9.douyinNotInstallUrl) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.hideWarrantyCard, r9.hideWarrantyCard) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.glbServiceEmail, r9.glbServiceEmail) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.glbServiceName, r9.glbServiceName) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.glbServiceIcon, r9.glbServiceIcon) == true) goto L86;
        return false;
    L86:
        return true;
    }

    public int hashCode() {
        int r0 = ((Long.hashCode(this.expireTime) * 31) + Long.hashCode(this.serverTime)) * 31;
        String r1 = this.customerServiceName;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.customerService;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.customerServiceIcon;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.forumName;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.forum;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.forumIcon;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.wechatName;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.wechatUrl;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.wechatIcon;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.doubaoCommunityName;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.doubaoCommunityUrl;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        String r35 = this.doubaoCommunityIcon;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        String r38 = this.doubaoPhoneForumName;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        String r41 = this.doubaoPhoneForumUrl;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        String r44 = this.doubaoPhoneForumIcon;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (r43 + r45) * 31;
        String r47 = this.rightExplanation;
        if (r47 != null) goto L65;
        int r48 = 0;
    L66:
        int r49 = (r46 + r48) * 31;
        String r50 = this.weiboUrl;
        if (r50 != null) goto L69;
        int r51 = 0;
    L70:
        int r52 = (r49 + r51) * 31;
        String r53 = this.weiboNotInstallUrl;
        if (r53 != null) goto L73;
        int r54 = 0;
    L74:
        int r55 = (r52 + r54) * 31;
        String r56 = this.douyinUrl;
        if (r56 != null) goto L77;
        int r57 = 0;
    L78:
        int r58 = (r55 + r57) * 31;
        String r59 = this.douyinNotInstallUrl;
        if (r59 != null) goto L81;
        int r60 = 0;
    L82:
        int r61 = (r58 + r60) * 31;
        Boolean r62 = this.hideWarrantyCard;
        if (r62 != null) goto L85;
        int r63 = 0;
    L86:
        int r64 = (r61 + r63) * 31;
        String r65 = this.glbServiceEmail;
        if (r65 != null) goto L89;
        int r66 = 0;
    L90:
        int r67 = (r64 + r66) * 31;
        String r68 = this.glbServiceName;
        if (r68 != null) goto L93;
        int r69 = 0;
    L94:
        int r70 = (r67 + r69) * 31;
        String r71 = this.glbServiceIcon;
        if (r71 == null) goto L99;
        r2 = r71.hashCode();
    L99:
        return r70 + r2;
    L93:
        r69 = r68.hashCode();
        goto L94
    L89:
        r66 = r65.hashCode();
        goto L90
    L85:
        r63 = r62.hashCode();
        goto L86
    L81:
        r60 = r59.hashCode();
        goto L82
    L77:
        r57 = r56.hashCode();
        goto L78
    L73:
        r54 = r53.hashCode();
        goto L74
    L69:
        r51 = r50.hashCode();
        goto L70
    L65:
        r48 = r47.hashCode();
        goto L66
    L61:
        r45 = r44.hashCode();
        goto L62
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("DeviceInfo(expireTime=");
        r0.append(this.expireTime).append(", serverTime=").append(this.serverTime).append(", customerServiceName=").append(this.customerServiceName).append(", customerService=").append(this.customerService).append(", customerServiceIcon=").append(this.customerServiceIcon).append(", forumName=").append(this.forumName).append(", forum=").append(this.forum).append(", forumIcon=").append(this.forumIcon).append(", wechatName=").append(this.wechatName).append(", wechatUrl=").append(this.wechatUrl).append(", wechatIcon=").append(this.wechatIcon).append(", doubaoCommunityName=");
        r0.append(this.doubaoCommunityName).append(", doubaoCommunityUrl=").append(this.doubaoCommunityUrl).append(", doubaoCommunityIcon=").append(this.doubaoCommunityIcon).append(", doubaoPhoneForumName=").append(this.doubaoPhoneForumName).append(", doubaoPhoneForumUrl=").append(this.doubaoPhoneForumUrl).append(", doubaoPhoneForumIcon=").append(this.doubaoPhoneForumIcon).append(", rightExplanation=").append(this.rightExplanation).append(", weiboUrl=").append(this.weiboUrl).append(", weiboNotInstallUrl=").append(this.weiboNotInstallUrl).append(", douyinUrl=").append(this.douyinUrl).append(", douyinNotInstallUrl=").append(this.douyinNotInstallUrl).append(", hideWarrantyCard=").append(this.hideWarrantyCard);
        r0.append(", glbServiceEmail=").append(this.glbServiceEmail).append(", glbServiceName=").append(this.glbServiceName).append(", glbServiceIcon=").append(this.glbServiceIcon).append(')');
        return r0.toString();
    }

    public DeviceInfo(long r4, long r6, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, Boolean r28, String r29, String r30, String r31) {
        this.expireTime = r4;
        this.serverTime = r6;
        this.customerServiceName = r8;
        this.customerService = r9;
        this.customerServiceIcon = r10;
        this.forumName = r11;
        this.forum = r12;
        this.forumIcon = r13;
        this.wechatName = r14;
        this.wechatUrl = r15;
        this.wechatIcon = r16;
        this.doubaoCommunityName = r17;
        this.doubaoCommunityUrl = r18;
        this.doubaoCommunityIcon = r19;
        this.doubaoPhoneForumName = r20;
        this.doubaoPhoneForumUrl = r21;
        this.doubaoPhoneForumIcon = r22;
        this.rightExplanation = r23;
        this.weiboUrl = r24;
        this.weiboNotInstallUrl = r25;
        this.douyinUrl = r26;
        this.douyinNotInstallUrl = r27;
        this.hideWarrantyCard = r28;
        this.glbServiceEmail = r29;
        this.glbServiceName = r30;
        this.glbServiceIcon = r31;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final String getCustomerServiceName() {
        return this.customerServiceName;
    }

    public final String getCustomerService() {
        return this.customerService;
    }

    public final String getCustomerServiceIcon() {
        return this.customerServiceIcon;
    }

    public final String getForumName() {
        return this.forumName;
    }

    public final String getForum() {
        return this.forum;
    }

    public final String getForumIcon() {
        return this.forumIcon;
    }

    public final String getWechatName() {
        return this.wechatName;
    }

    public final String getWechatUrl() {
        return this.wechatUrl;
    }

    public final String getWechatIcon() {
        return this.wechatIcon;
    }

    public final String getDoubaoCommunityName() {
        return this.doubaoCommunityName;
    }

    public final String getDoubaoCommunityUrl() {
        return this.doubaoCommunityUrl;
    }

    public final String getDoubaoCommunityIcon() {
        return this.doubaoCommunityIcon;
    }

    public final String getDoubaoPhoneForumName() {
        return this.doubaoPhoneForumName;
    }

    public final String getDoubaoPhoneForumUrl() {
        return this.doubaoPhoneForumUrl;
    }

    public final String getDoubaoPhoneForumIcon() {
        return this.doubaoPhoneForumIcon;
    }

    public final String getRightExplanation() {
        return this.rightExplanation;
    }

    public final String getWeiboUrl() {
        return this.weiboUrl;
    }

    public final String getWeiboNotInstallUrl() {
        return this.weiboNotInstallUrl;
    }

    public final String getDouyinUrl() {
        return this.douyinUrl;
    }

    public final String getDouyinNotInstallUrl() {
        return this.douyinNotInstallUrl;
    }

    public final Boolean getHideWarrantyCard() {
        return this.hideWarrantyCard;
    }

    public final String getGlbServiceEmail() {
        return this.glbServiceEmail;
    }

    public final String getGlbServiceName() {
        return this.glbServiceName;
    }

    public final String getGlbServiceIcon() {
        return this.glbServiceIcon;
    }
}
