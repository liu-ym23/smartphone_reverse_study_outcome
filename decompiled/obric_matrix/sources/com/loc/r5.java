package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public final class r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q5.e f7743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7744b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7745a = null;

        static {
            int[] r0 = new int[q5.e.values().length];
            f7745a = r0;
            r0[q5.e.f7676h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f7745a[q5.e.f7677i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f7745a[q5.e.f7678j.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f7745a[q5.e.f7679k.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f7745a[q5.e.f7680l.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f7745a[q5.e.m.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f7745a[q5.e.n.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f7745a[q5.e.o.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f7745a[q5.e.f7675g.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    r5(q5.e r3, t5 r4) {
        this.f7743a = r3;
        switch(a.f7745a[r3.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String r5 = "";
    L14:
        this.f7744b = r5;
        return;
    L5:
        r5 = String.format("设置隐私政策成功", new Object[0]);
        goto L14
    L6:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n参数非法，context 或 sdkInfo为空", new Object[0]);
        goto L14
    L7:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能使用前请确保已经正确设置apiKey，如有疑问请在高德开放平台官网中搜索【INVALID_USER_KEY】相关内容进行解决。", new Object[]{r4.a()});
        goto L14
    L8:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已取得用户同意", new Object[]{r4.a()});
        goto L14
    L9:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否取得用户同意", new Object[]{r4.a()});
        goto L14
    L10:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已经包含高德开平隐私权政策", new Object[]{r4.a()});
        goto L14
    L11:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否包含高德开平隐私权政策", new Object[]{r4.a()});
        goto L14
    L12:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已弹窗告知用户", new Object[]{r4.a()});
        goto L14
    L13:
        r5 = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请设置隐私权政策是否弹窗告知用户", new Object[]{r4.a()});
        goto L14
    }
}
