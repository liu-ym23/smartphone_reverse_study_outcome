package com.obric.safecheck.test;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.apm.alog.AlogMonitor;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.olog.OLog;
import com.obric.safecheck.R;
import com.obric.safecheck.dataSync.AntiFraudApiClient;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAppInstallableRequester;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.dao.PhoneDao;
import com.obric.safecheck.database.dao.PkgSignDao;
import com.obric.safecheck.database.dao.UrlDomainDao;
import com.obric.safecheck.database.entity.PhoneItem;
import com.obric.safecheck.database.entity.PkgSignItem;
import com.obric.safecheck.database.entity.UrlDomainItem;
import com.obric.safecheck.parser.DirectoryParser;
import com.obric.safecheck.service.ApkAnalyzer;
import com.obric.safecheck.service.BlacklistRecordSP;
import com.obric.safecheck.service.SafaCheckService;
import com.obric.safecheck.util.serviceutil.EncryptPhoneToMd5Kt;
import com.obric.security.safecheckapi.ApkInfo;
import com.obric.security.safecheckapi.CheckResult;
import com.obric.security.safecheckapi.ISecurityCheckCallback;
import com.obric.security.safecheckapi.ISecurityCheckService;
import com.ss.android.message.log.PushLog;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: compiled from: TestSafeCheckActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010G\u001a\u00020HH\u0002J\u0012\u0010I\u001a\u0004\u0018\u00010#2\u0006\u0010J\u001a\u00020KH\u0002J\u001c\u0010L\u001a\u00020H2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020H0NH\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020#H\u0002J\b\u0010R\u001a\u00020HH\u0002J\b\u0010S\u001a\u00020HH\u0002J\b\u0010T\u001a\u00020HH\u0002J\u0012\u0010U\u001a\u00020H2\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J\b\u0010X\u001a\u00020HH\u0014J\u0010\u0010Y\u001a\u00020H2\u0006\u0010Z\u001a\u00020#H\u0002J\u0010\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020#H\u0002J\b\u0010]\u001a\u00020HH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010$\u001a\n \u0016*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\b\u001a\u0004\b&\u0010'R\u000e\u0010)\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R#\u0010+\u001a\n \u0016*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b-\u0010.R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\b\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R#\u0010?\u001a\n \u0016*\u0004\u0018\u00010@0@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\b\u001a\u0004\bA\u0010BR\u000e\u0010D\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/obric/safecheck/test/TestSafeCheckActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "apkAnalyzer", "Lcom/obric/safecheck/service/ApkAnalyzer;", "getApkAnalyzer", "()Lcom/obric/safecheck/service/ApkAnalyzer;", "apkAnalyzer$delegate", "Lkotlin/Lazy;", "apkBlackPathTv", "Landroid/widget/EditText;", "apkPathTv", "apkRiskTv", "apkTimeTv", "blackPhoneTv", "btnCheckApk", "Landroid/widget/Button;", "btnCheckApkWithInfo", "btnCheckPhone", "btnCheckUrl", "database", "Lcom/obric/safecheck/database/AntiFraudDatabase;", "kotlin.jvm.PlatformType", "getDatabase", "()Lcom/obric/safecheck/database/AntiFraudDatabase;", "database$delegate", "deleteBtn", "deleteTimeTv", "endTimeBtn", "fetchBtn", "fetchTimeTv", "insertApkDbBtn", "insertPhoneDbBtn", "insertUrlDbBtn", "lastApkInfoText", "", "phoneDao", "Lcom/obric/safecheck/database/dao/PhoneDao;", "getPhoneDao", "()Lcom/obric/safecheck/database/dao/PhoneDao;", "phoneDao$delegate", "phoneTimeTv", "phoneTv", "pkgSignDao", "Lcom/obric/safecheck/database/dao/PkgSignDao;", "getPkgSignDao", "()Lcom/obric/safecheck/database/dao/PkgSignDao;", "pkgSignDao$delegate", "securityService", "Lcom/obric/security/safecheckapi/ISecurityCheckService;", "serviceConnection", "com/obric/safecheck/test/TestSafeCheckActivity$serviceConnection$1", "Lcom/obric/safecheck/test/TestSafeCheckActivity$serviceConnection$1;", CloudControlInf.SP, "Lcom/obric/safecheck/service/BlacklistRecordSP;", "getSp", "()Lcom/obric/safecheck/service/BlacklistRecordSP;", "sp$delegate", "testApkPathTv", "testApkPkgTv", "testPhoneInputTv", "testUrlInputTv", "urlBlackPathTv", "urlDomainDao", "Lcom/obric/safecheck/database/dao/UrlDomainDao;", "getUrlDomainDao", "()Lcom/obric/safecheck/database/dao/UrlDomainDao;", "urlDomainDao$delegate", "urlPathTv", "urlRiskTv", "urlTimeTv", "bindSafaCheckService", "", "calculateFileMD5", "file", "Ljava/io/File;", "callService", "action", "Lkotlin/Function1;", "createCallback", "Lcom/obric/security/safecheckapi/ISecurityCheckCallback;", PushLog.KEY_TAG, "initApkInfoViews", "initGxbInsertRuleViews", "initSafeCheckTestViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showResultDialog", "message", "showToast", NotificationCompat.CATEGORY_MESSAGE, "testGxbAppInstallable", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TestSafeCheckActivity extends FragmentActivity {
    private final Lazy apkAnalyzer$delegate;
    private EditText apkBlackPathTv;
    private EditText apkPathTv;
    private EditText apkRiskTv;
    private EditText apkTimeTv;
    private EditText blackPhoneTv;
    private Button btnCheckApk;
    private Button btnCheckApkWithInfo;
    private Button btnCheckPhone;
    private Button btnCheckUrl;
    private final Lazy database$delegate;
    private Button deleteBtn;
    private EditText deleteTimeTv;
    private Button endTimeBtn;
    private Button fetchBtn;
    private EditText fetchTimeTv;
    private Button insertApkDbBtn;
    private Button insertPhoneDbBtn;
    private Button insertUrlDbBtn;
    private String lastApkInfoText;
    private final Lazy phoneDao$delegate;
    private EditText phoneTimeTv;
    private EditText phoneTv;
    private final Lazy pkgSignDao$delegate;
    private ISecurityCheckService securityService;
    private final TestSafeCheckActivity$serviceConnection$1 serviceConnection;
    private final Lazy sp$delegate;
    private EditText testApkPathTv;
    private EditText testApkPkgTv;
    private EditText testPhoneInputTv;
    private EditText testUrlInputTv;
    private EditText urlBlackPathTv;
    private final Lazy urlDomainDao$delegate;
    private EditText urlPathTv;
    private EditText urlRiskTv;
    private EditText urlTimeTv;

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$createCallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/safecheck/test/TestSafeCheckActivity$createCallback$1", "Lcom/obric/security/safecheckapi/ISecurityCheckCallback$Stub;", "onCheckResult", "", "result", "", "Lcom/obric/security/safecheckapi/CheckResult;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends ISecurityCheckCallback.Stub {
        final /* synthetic */ String $tag;
        final /* synthetic */ TestSafeCheckActivity this$0;

        AnonymousClass1(TestSafeCheckActivity r1, String r2) {
            this.this$0 = r1;
            this.$tag = r2;
        }

        @Override // com.obric.security.safecheckapi.ISecurityCheckCallback
        public void onCheckResult(final List<CheckResult> r3) {
            this.this$0.runOnUiThread(new TestSafeCheckActivity$createCallback$1$onCheckResult$1(this, r3));
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$onCreate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 3})
    static final class ViewOnClickListenerC03341 implements View.OnClickListener {
        final /* synthetic */ TestSafeCheckActivity this$0;

        ViewOnClickListenerC03341(TestSafeCheckActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Toast.makeText(this.this$0, "endTime: " + DirectoryParser.INSTANCE.getEndData(), 0).show();
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$onCreate$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 3})
    static final class ViewOnClickListenerC03352 implements View.OnClickListener {
        final /* synthetic */ TestSafeCheckActivity this$0;

        ViewOnClickListenerC03352(TestSafeCheckActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.this$0.startActivity(new Intent(this.this$0, GxbAntiFraudRulesActivity.class));
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$onCreate$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 3})
    static final class ViewOnClickListenerC03363 implements View.OnClickListener {
        final /* synthetic */ TestSafeCheckActivity this$0;

        ViewOnClickListenerC03363(TestSafeCheckActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            TestSafeCheckActivity.access$testGxbAppInstallable(this.this$0);
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$onCreate$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 3})
    static final class ViewOnClickListenerC03374 implements View.OnClickListener {
        final /* synthetic */ TestSafeCheckActivity this$0;

        ViewOnClickListenerC03374(TestSafeCheckActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = StringsKt.trim(TestSafeCheckActivity.access$getFetchTimeTv$p(this.this$0).getText().toString()).toString();
            if (r4.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            Toast.makeText(this.this$0, "请输入拉取时间", 0).show();
            return;
        L9:
            AntiFraudApiClient.getInstance().getAntiFraudDataByDateTimeAsync(r4);
            Toast.makeText(this.this$0, "数据拉取中...,请过滤日志 _AntiFraud ", 0).show();
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$onCreate$5, reason: invalid class name */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ TestSafeCheckActivity this$0;

        AnonymousClass5(TestSafeCheckActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            String r8 = StringsKt.trim(TestSafeCheckActivity.access$getPhoneTv$p(this.this$0).getText().toString()).toString();
            String r0 = StringsKt.trim(TestSafeCheckActivity.access$getBlackPhoneTv$p(this.this$0).getText().toString()).toString();
            String r1 = StringsKt.trim(TestSafeCheckActivity.access$getPhoneTimeTv$p(this.this$0).getText().toString()).toString();
            if (r1.length() != 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L9;
            r1 = TestSafeCheckActivity.access$getSp$p(this.this$0).getCurrentDateString();
        L9:
            if (r8.length() <= 0) goto L11;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L16;
            TestSafeCheckActivity.access$getPhoneDao$p(this.this$0).insert(new PhoneItem(EncryptPhoneToMd5Kt.calculateMD5(r8), r1, false));
            Toast.makeText(this.this$0, "手机号插入数据库成功", 0).show();
        L16:
            if (r0.length() <= 0) goto L18;
            boolean r9 = true;
        L19:
            if (r9 == false) goto L22;
            TestSafeCheckActivity.access$getPhoneDao$p(this.this$0).insert(new PhoneItem(EncryptPhoneToMd5Kt.calculateMD5(r0), r1, true));
            Toast.makeText(this.this$0, "手机号插入数据库成功", 0).show();
            return;
        L22:
            return;
        L18:
            r9 = false;
            goto L19
        L11:
            r3 = false;
            goto L13
        L5:
            r2 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$onCreate$6, reason: invalid class name */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ TestSafeCheckActivity this$0;

        AnonymousClass6(TestSafeCheckActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            String r12 = StringsKt.trim(TestSafeCheckActivity.access$getApkPathTv$p(this.this$0).getText().toString()).toString();
            String r0 = StringsKt.trim(TestSafeCheckActivity.access$getApkBlackPathTv$p(this.this$0).getText().toString()).toString();
            String r1 = StringsKt.trim(TestSafeCheckActivity.access$getApkTimeTv$p(this.this$0).getText().toString()).toString();
            boolean r3 = true;
            if (r1.length() != 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L9;
            r1 = TestSafeCheckActivity.access$getSp$p(this.this$0).getCurrentDateString();
        L9:
            if (r12.length() <= 0) goto L11;
            boolean r4 = true;
        L12:
            String r7 = "";
            if (r4 == false) goto L49;
            ApkInfo r13 = TestSafeCheckActivity.access$getApkAnalyzer$p(this.this$0).getApkInfo(r12);
            PkgSignItem r5 = new PkgSignItem();
            if (r13 == null) goto L18;
            String r8 = r13.getSignatureMd5();
            if (r8 == null) goto L18;
        L19:
            r5.setUmd5(r8);
            if (r13 == null) goto L23;
            String r9 = r13.getPackageName();
            if (r9 == null) goto L23;
        L24:
            r5.setPkg(r9);
            if (r13 == null) goto L28;
            String r10 = r13.getSignatureMd5();
            if (r10 == null) goto L28;
        L29:
            r5.setTmd5(r10);
            if (r13 == null) goto L33;
            String r14 = r13.getSignatureSha1();
            if (r14 == null) goto L33;
        L34:
            r5.setTsha1(r14);
            if (r13 == null) goto L38;
            String r15 = r13.getSignatureSha256();
            if (r15 == null) goto L38;
        L39:
            r5.setTsha256(r15);
            r5.setBlacklist(false);
            r5.setTimestamp(r1);
            String r16 = StringsKt.trim(TestSafeCheckActivity.access$getApkRiskTv$p(this.this$0).getText().toString()).toString();
            if (r16.length() <= 0) goto L42;
            boolean r17 = true;
        L43:
            if (r17 == false) goto L45;
            r5.setRiskLevel(r16);
        L45:
            if (r13 == null) goto L47;
            TestSafeCheckActivity.access$getPkgSignDao$p(this.this$0).insertPkgSignItem(r5);
            Toast.makeText(this.this$0, "apk信息插入数据库成功", 0).show();
            goto L49
        L47:
            Toast.makeText(this.this$0, "apk信息插入数据库失败", 0).show();
            goto L49
        L42:
            r17 = false;
        L38:
            r15 = "";
        L33:
            r14 = "";
        L28:
            r10 = "";
        L23:
            r9 = "";
        L18:
            r8 = "";
        L49:
            if (r0.length() <= 0) goto L51;
            boolean r18 = true;
        L52:
            if (r18 == false) goto L89;
            ApkInfo r19 = TestSafeCheckActivity.access$getApkAnalyzer$p(this.this$0).getApkInfo(r0);
            PkgSignItem r6 = new PkgSignItem();
            if (r19 == null) goto L57;
            String r20 = r19.getSignatureMd5();
            if (r20 == null) goto L57;
        L58:
            r6.setUmd5(r20);
            if (r19 == null) goto L62;
            String r21 = r19.getPackageName();
            if (r21 == null) goto L62;
        L63:
            r6.setPkg(r21);
            if (r19 == null) goto L67;
            String r22 = r19.getSignatureMd5();
            if (r22 == null) goto L67;
        L68:
            r6.setTmd5(r22);
            if (r19 == null) goto L72;
            String r23 = r19.getSignatureSha1();
            if (r23 == null) goto L72;
        L73:
            r6.setTsha1(r23);
            if (r19 == null) goto L79;
            String r24 = r19.getSignatureSha256();
            if (r24 == null) goto L79;
            r7 = r24;
        L79:
            r6.setTsha256(r7);
            r6.setBlacklist(true);
            r6.setTimestamp(r1);
            String r25 = StringsKt.trim(TestSafeCheckActivity.access$getApkRiskTv$p(this.this$0).getText().toString()).toString();
            if (r25.length() > 0) goto L83;
            r3 = false;
        L83:
            if (r3 == false) goto L85;
            r6.setRiskLevel(r25);
        L85:
            if (r19 == null) goto L87;
            TestSafeCheckActivity.access$getPkgSignDao$p(this.this$0).insertPkgSignItem(r6);
            Toast.makeText(this.this$0, "apk信息插入数据库成功", 0).show();
            return;
        L87:
            Toast.makeText(this.this$0, "apk信息插入数据库失败", 0).show();
            return;
        L72:
            r23 = "";
        L67:
            r22 = "";
        L62:
            r21 = "";
        L57:
            r20 = "";
            goto L58
        L89:
            return;
        L51:
            r18 = false;
            goto L52
        L11:
            r4 = false;
            goto L12
        L5:
            r2 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$onCreate$7, reason: invalid class name */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass7 implements View.OnClickListener {
        final /* synthetic */ TestSafeCheckActivity this$0;

        AnonymousClass7(TestSafeCheckActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = StringsKt.trim(TestSafeCheckActivity.access$getDeleteTimeTv$p(this.this$0).getText().toString()).toString();
            if (r4.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            TestSafeCheckActivity.access$getPkgSignDao$p(this.this$0).deleteDataBeforeDate(r4);
            TestSafeCheckActivity.access$getPhoneDao$p(this.this$0).deleteDataBeforeDate(r4);
            TestSafeCheckActivity.access$getUrlDomainDao$p(this.this$0).deleteDataBeforeDate(r4);
            Toast.makeText(this.this$0, "删除成功", 0).show();
            return;
        L8:
            Toast.makeText(this.this$0, "请输入时间", 0).show();
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$onCreate$8, reason: invalid class name */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass8 implements View.OnClickListener {
        final /* synthetic */ TestSafeCheckActivity this$0;

        AnonymousClass8(TestSafeCheckActivity r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r15) {
            String r16 = StringsKt.trim(TestSafeCheckActivity.access$getUrlPathTv$p(this.this$0).getText().toString()).toString();
            String r0 = StringsKt.trim(TestSafeCheckActivity.access$getUrlBlackPathTv$p(this.this$0).getText().toString()).toString();
            String r1 = StringsKt.trim(TestSafeCheckActivity.access$getUrlTimeTv$p(this.this$0).getText().toString()).toString();
            if (r1.length() != 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L9;
            r1 = TestSafeCheckActivity.access$getSp$p(this.this$0).getCurrentDateString();
        L9:
            if (r16.length() <= 0) goto L11;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L16;
            UrlDomainItem r4 = new UrlDomainItem(null, null, null, false, 15, null);
            r4.setDomainOrigin(r16);
            r4.setTimestamp(r1);
            r4.setBlacklist(false);
            r4.setDomain(r4.getDomainOrigin() + "_" + r4.getTimestamp());
            TestSafeCheckActivity.access$getUrlDomainDao$p(this.this$0).insert(r4);
            Toast.makeText(this.this$0, "url信息插入数据库成功", 0).show();
        L16:
            if (r0.length() <= 0) goto L18;
            boolean r17 = true;
        L19:
            if (r17 == false) goto L22;
            UrlDomainItem r18 = new UrlDomainItem(null, null, null, false, 15, null);
            r18.setDomainOrigin(r0);
            r18.setTimestamp(r1);
            r18.setBlacklist(true);
            r18.setDomain(r18.getDomainOrigin() + "_" + r18.getTimestamp());
            TestSafeCheckActivity.access$getUrlDomainDao$p(this.this$0).insert(r18);
            Toast.makeText(this.this$0, "url信息插入数据库成功", 0).show();
            return;
        L22:
            return;
        L18:
            r17 = false;
            goto L19
        L11:
            r3 = false;
            goto L13
        L5:
            r2 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.test.TestSafeCheckActivity$testGxbAppInstallable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TestSafeCheckActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\n\u001a\u00020\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\fH\u0016¨\u0006\u000f"}, d2 = {"com/obric/safecheck/test/TestSafeCheckActivity$testGxbAppInstallable$1", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$Callback;", "onFailure", "", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "throwable", "", "onSuccess", "data", "", "", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableRule;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C03381 implements GxbAppInstallableRequester.Callback {
        final /* synthetic */ TestSafeCheckActivity this$0;

        C03381(TestSafeCheckActivity r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.safecheck.dataSync.miitAntiFraud.GxbAppInstallableRequester.Callback
        public void onSuccess(final Map<String, ? extends List<GxbAppInstallableRequester.GxbAppInstallableRule>> r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            this.this$0.runOnUiThread(new TestSafeCheckActivity$testGxbAppInstallable$1$onSuccess$1(this, r3));
        }

        @Override // com.obric.safecheck.dataSync.miitAntiFraud.GxbAppInstallableRequester.Callback
        public void onFailure(final int r3, final String r4, final Throwable r5) {
            this.this$0.runOnUiThread(new TestSafeCheckActivity$testGxbAppInstallable$1$onFailure$1(this, r3, r4, r5));
        }
    }

    private final ApkAnalyzer getApkAnalyzer() {
        return (ApkAnalyzer) this.apkAnalyzer$delegate.getValue();
    }

    private final AntiFraudDatabase getDatabase() {
        return (AntiFraudDatabase) this.database$delegate.getValue();
    }

    private final PhoneDao getPhoneDao() {
        return (PhoneDao) this.phoneDao$delegate.getValue();
    }

    private final PkgSignDao getPkgSignDao() {
        return (PkgSignDao) this.pkgSignDao$delegate.getValue();
    }

    private final BlacklistRecordSP getSp() {
        return (BlacklistRecordSP) this.sp$delegate.getValue();
    }

    private final UrlDomainDao getUrlDomainDao() {
        return (UrlDomainDao) this.urlDomainDao$delegate.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.safecheck.test.TestSafeCheckActivity$serviceConnection$1] */
    public TestSafeCheckActivity() {
        this.serviceConnection = new TestSafeCheckActivity$serviceConnection$1(this);
        this.sp$delegate = LazyKt.lazy(new TestSafeCheckActivity$sp$2(this));
        this.database$delegate = LazyKt.lazy(new TestSafeCheckActivity$database$2(this));
        this.pkgSignDao$delegate = LazyKt.lazy(new TestSafeCheckActivity$pkgSignDao$2(this));
        this.phoneDao$delegate = LazyKt.lazy(new TestSafeCheckActivity$phoneDao$2(this));
        this.urlDomainDao$delegate = LazyKt.lazy(new TestSafeCheckActivity$urlDomainDao$2(this));
        this.apkAnalyzer$delegate = LazyKt.lazy(new TestSafeCheckActivity$apkAnalyzer$2(this));
        this.lastApkInfoText = "";
    }

    public static final /* synthetic */ String access$calculateFileMD5(TestSafeCheckActivity r0, File r1) {
        return r0.calculateFileMD5(r1);
    }

    public static final /* synthetic */ void access$callService(TestSafeCheckActivity r0, Function1 r1) {
        r0.callService(r1);
    }

    public static final /* synthetic */ ISecurityCheckCallback access$createCallback(TestSafeCheckActivity r0, String r1) {
        return r0.createCallback(r1);
    }

    public static final /* synthetic */ ApkAnalyzer access$getApkAnalyzer$p(TestSafeCheckActivity r0) {
        return r0.getApkAnalyzer();
    }

    public static final /* synthetic */ EditText access$getApkBlackPathTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.apkBlackPathTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("apkBlackPathTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getApkPathTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.apkPathTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("apkPathTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getApkRiskTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.apkRiskTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("apkRiskTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getApkTimeTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.apkTimeTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("apkTimeTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getBlackPhoneTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.blackPhoneTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("blackPhoneTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ AntiFraudDatabase access$getDatabase$p(TestSafeCheckActivity r0) {
        return r0.getDatabase();
    }

    public static final /* synthetic */ EditText access$getDeleteTimeTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.deleteTimeTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("deleteTimeTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getFetchTimeTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.fetchTimeTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fetchTimeTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ String access$getLastApkInfoText$p(TestSafeCheckActivity r0) {
        return r0.lastApkInfoText;
    }

    public static final /* synthetic */ PhoneDao access$getPhoneDao$p(TestSafeCheckActivity r0) {
        return r0.getPhoneDao();
    }

    public static final /* synthetic */ EditText access$getPhoneTimeTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.phoneTimeTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneTimeTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getPhoneTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.phoneTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("phoneTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ PkgSignDao access$getPkgSignDao$p(TestSafeCheckActivity r0) {
        return r0.getPkgSignDao();
    }

    public static final /* synthetic */ ISecurityCheckService access$getSecurityService$p(TestSafeCheckActivity r0) {
        return r0.securityService;
    }

    public static final /* synthetic */ BlacklistRecordSP access$getSp$p(TestSafeCheckActivity r0) {
        return r0.getSp();
    }

    public static final /* synthetic */ EditText access$getTestApkPathTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.testApkPathTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("testApkPathTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getTestApkPkgTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.testApkPkgTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("testApkPkgTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getTestPhoneInputTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.testPhoneInputTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("testPhoneInputTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getTestUrlInputTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.testUrlInputTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("testUrlInputTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getUrlBlackPathTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.urlBlackPathTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("urlBlackPathTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ UrlDomainDao access$getUrlDomainDao$p(TestSafeCheckActivity r0) {
        return r0.getUrlDomainDao();
    }

    public static final /* synthetic */ EditText access$getUrlPathTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.urlPathTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("urlPathTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ EditText access$getUrlTimeTv$p(TestSafeCheckActivity r1) {
        EditText r2 = r1.urlTimeTv;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("urlTimeTv");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$setApkBlackPathTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.apkBlackPathTv = r1;
    }

    public static final /* synthetic */ void access$setApkPathTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.apkPathTv = r1;
    }

    public static final /* synthetic */ void access$setApkRiskTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.apkRiskTv = r1;
    }

    public static final /* synthetic */ void access$setApkTimeTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.apkTimeTv = r1;
    }

    public static final /* synthetic */ void access$setBlackPhoneTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.blackPhoneTv = r1;
    }

    public static final /* synthetic */ void access$setDeleteTimeTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.deleteTimeTv = r1;
    }

    public static final /* synthetic */ void access$setFetchTimeTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.fetchTimeTv = r1;
    }

    public static final /* synthetic */ void access$setLastApkInfoText$p(TestSafeCheckActivity r0, String r1) {
        r0.lastApkInfoText = r1;
    }

    public static final /* synthetic */ void access$setPhoneTimeTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.phoneTimeTv = r1;
    }

    public static final /* synthetic */ void access$setPhoneTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.phoneTv = r1;
    }

    public static final /* synthetic */ void access$setSecurityService$p(TestSafeCheckActivity r0, ISecurityCheckService r1) {
        r0.securityService = r1;
    }

    public static final /* synthetic */ void access$setTestApkPathTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.testApkPathTv = r1;
    }

    public static final /* synthetic */ void access$setTestApkPkgTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.testApkPkgTv = r1;
    }

    public static final /* synthetic */ void access$setTestPhoneInputTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.testPhoneInputTv = r1;
    }

    public static final /* synthetic */ void access$setTestUrlInputTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.testUrlInputTv = r1;
    }

    public static final /* synthetic */ void access$setUrlBlackPathTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.urlBlackPathTv = r1;
    }

    public static final /* synthetic */ void access$setUrlPathTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.urlPathTv = r1;
    }

    public static final /* synthetic */ void access$setUrlTimeTv$p(TestSafeCheckActivity r0, EditText r1) {
        r0.urlTimeTv = r1;
    }

    public static final /* synthetic */ void access$showResultDialog(TestSafeCheckActivity r0, String r1) {
        r0.showResultDialog(r1);
    }

    public static final /* synthetic */ void access$showToast(TestSafeCheckActivity r0, String r1) {
        r0.showToast(r1);
    }

    public static final /* synthetic */ void access$testGxbAppInstallable(TestSafeCheckActivity r0) {
        r0.testGxbAppInstallable();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        int r2 = getApplicationInfo().flags;
        finish();
    }

    private final void initGxbInsertRuleViews() {
        final EditText r0 = (EditText) findViewById(R.id.gxb_insert_apk_path);
        final EditText r1 = (EditText) findViewById(R.id.gxb_insert_rule_no);
        final EditText r2 = (EditText) findViewById(R.id.gxb_insert_rule_type);
        ((Button) findViewById(R.id.btn_gxb_insert_rule)).setOnClickListener(new ViewOnClickListenerC03311(this, r0, r1, r2));
    }

    private final void initApkInfoViews() {
        final EditText r0 = (EditText) findViewById(R.id.apk_info_path);
        Button r1 = (Button) findViewById(R.id.btn_show_apk_info);
        final TextView r2 = (TextView) findViewById(R.id.tv_apk_info_result);
        Button r3 = (Button) findViewById(R.id.btn_copy_apk_info);
        r1.setOnClickListener(new ViewOnClickListenerC03301(this, r0, r2));
        r3.setOnClickListener(new AnonymousClass2(this));
    }

    private final String calculateFileMD5(File r7) {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L22
        FileInputStream r1 = new FileInputStream(r7);     // Catch: Throwable -> L22
        FileInputStream r8 = r1;     // Catch: Throwable -> L17
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L17
    L5:
        int r3 = r8.read(r2);     // Catch: Throwable -> L17
        int r4 = 0;
        if (r3 <= 0) goto L8;
        r0.update(r2, 0, r3);     // Catch: Throwable -> L17
        goto L5
    L8:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L22
        byte[] r10 = r0.digest();     // Catch: Throwable -> L22
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L22
        int r6 = r10.length;     // Catch: Throwable -> L22
    L10:
        if (r4 >= r6) goto L15;
        String r11 = Integer.toHexString(r10[r4] & UByte.MAX_VALUE);     // Catch: Throwable -> L22
        if (r11.length() != 1) goto L14;
        r5.append(DeepCleanSAFEngine.DetailPath.KEY);     // Catch: Throwable -> L22
    L14:
        r5.append(r11);     // Catch: Throwable -> L22
        r4 = r4 + 1;     // Catch: Throwable -> L22
        goto L10
    L15:
        String r12 = r5.toString();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r12, "sb.toString()");     // Catch: Throwable -> L22
        String r13 = r12.toUpperCase();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).toUpperCase()");     // Catch: Throwable -> L22
        return r13;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        OLog.e("TestSafeCheck", "calc file md5 failed", th);
        return null;
    }

    private final void initSafeCheckTestViews() {
        View r0 = findViewById(R.id.test_apk_path);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.test_apk_path)");
        this.testApkPathTv = (EditText) r0;
        View r1 = findViewById(R.id.test_apk_pkg);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.test_apk_pkg)");
        this.testApkPkgTv = (EditText) r1;
        View r2 = findViewById(R.id.test_url_input);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.test_url_input)");
        this.testUrlInputTv = (EditText) r2;
        View r3 = findViewById(R.id.test_phone_input);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.test_phone_input)");
        this.testPhoneInputTv = (EditText) r3;
        View r4 = findViewById(R.id.btn_check_apk);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.btn_check_apk)");
        this.btnCheckApk = (Button) r4;
        View r5 = findViewById(R.id.btn_check_apk_with_info);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.btn_check_apk_with_info)");
        this.btnCheckApkWithInfo = (Button) r5;
        View r6 = findViewById(R.id.btn_check_url);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.btn_check_url)");
        this.btnCheckUrl = (Button) r6;
        View r7 = findViewById(R.id.btn_check_phone);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.btn_check_phone)");
        this.btnCheckPhone = (Button) r7;
        Button r8 = this.btnCheckApk;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCheckApk");
    L5:
        r8.setOnClickListener(new ViewOnClickListenerC03321(this));
        Button r9 = this.btnCheckApkWithInfo;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnCheckApkWithInfo");
    L8:
        r9.setOnClickListener(new ViewOnClickListenerC03332(this));
        Button r10 = this.btnCheckUrl;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("btnCheckUrl");
    L11:
        r10.setOnClickListener(new AnonymousClass3(this));
        Button r11 = this.btnCheckPhone;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("btnCheckPhone");
    L14:
        r11.setOnClickListener(new AnonymousClass4(this));
    }

    private final void bindSafaCheckService() {
        bindService(new Intent(this, SafaCheckService.class), this.serviceConnection, 1);
    }

    private final void callService(Function1<? super ISecurityCheckService, Unit> r3) {
        ISecurityCheckService r0 = this.securityService;
        if (r0 != null) goto L11;
        showResultDialog("[错误] SafaCheckService 未连接，请稍后重试");
        bindSafaCheckService();
        return;
    L11:
        r3.invoke(r0);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        showResultDialog("[异常] " + e.getMessage());
    }

    private final ISecurityCheckCallback createCallback(String r2) {
        return new AnonymousClass1(this, r2);
    }

    private final void showResultDialog(String r2) {
        new AlertDialog.Builder(this).setTitle("检查结果").setMessage(r2).setPositiveButton("确定", null).show();
    }

    private final void showToast(String r2) {
        Toast.makeText(this, r2, 0).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this.serviceConnection);     // Catch: Exception -> L5
        return;
    }

    private final void testGxbAppInstallable() {
        View r0 = findViewById(R.id.gxb_installable_pkg);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById<EditText>(R.id.gxb_installable_pkg)");
        String r2 = StringsKt.trim(((EditText) r0).getText().toString()).toString();
        boolean r1 = true;
        if (r2.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        showToast("请输入包名");
        return;
    L9:
        View r4 = findViewById(R.id.gxb_installable_app_md5);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById<EditText>(R….gxb_installable_app_md5)");
        String r5 = StringsKt.trim(((EditText) r4).getText().toString()).toString();
        View r6 = findViewById(R.id.gxb_installable_sign_md5);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById<EditText>(R…gxb_installable_sign_md5)");
        String r7 = StringsKt.trim(((EditText) r6).getText().toString()).toString();
        View r8 = findViewById(R.id.gxb_installable_sign_sha1);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById<EditText>(R…xb_installable_sign_sha1)");
        String r9 = StringsKt.trim(((EditText) r8).getText().toString()).toString();
        View r10 = findViewById(R.id.gxb_installable_sign_sha256);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById<EditText>(R…_installable_sign_sha256)");
        String r11 = StringsKt.trim(((EditText) r10).getText().toString()).toString();
        String r12 = r5;
        if (r12.length() != 0) goto L12;
        boolean r13 = true;
    L13:
        String r14 = null;
        if (r13 == false) goto L16;
        r12 = null;
    L16:
        String r15 = r12;
        String r16 = r7;
        if (r16.length() != 0) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L22;
        r16 = null;
    L22:
        String r18 = r16;
        String r19 = r9;
        if (r19.length() != 0) goto L25;
        boolean r20 = true;
    L26:
        if (r20 == false) goto L28;
        r19 = null;
    L28:
        String r21 = r19;
        String r22 = r11;
        if (r22.length() == 0) goto L32;
        r1 = false;
    L32:
        if (r1 == true) goto L35;
        r14 = r22;
    L35:
        GxbAppInstallableRequester.GxbAppCheckItem r23 = new GxbAppInstallableRequester.GxbAppCheckItem(r2, r15, r18, r21, r14);
        showToast("请求中...");
        GxbAppInstallableRequester.checkInstallable(r23, new C03381(this));
        return;
    L25:
        r20 = false;
        goto L26
    L19:
        r17 = false;
        goto L20
    L12:
        r13 = false;
        goto L13
    L5:
        r3 = false;
        goto L6
    }
}
