package com.android.settings;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.FileProvider;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.android.settings.about.CertificationActivity;
import com.android.settings.about.IGooglePayLegalView;
import com.android.settings.base.BaseActivity;
import com.android.settings.servicemanager.IPlatform;
import com.android.settings.utils.ThreadUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class LawInfoActivity extends BaseActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<File> {
    private static final String ADD_WRITTEN_OFFER_FILE_NAME = "add_written_offer.html";
    private static final String ADD_WRITTEN_OFFER_FILE_NAME_NEW = "add_written_offer_new.html";
    private static final String CUSTOM_STYLE = "<style type=\"text/css\">\nhtml, body { margin: 0; padding: 0 20px; width: 100%; max-width: 100%; box-sizing: border-box; font-size: medium; }\nbody { font-family: sans-serif; word-break: break-word; }\n.same-license { background-color: #eeeeee; border-top: 20px solid white; padding: 10px; word-break: break-word; }\n.label { font-weight: bold; }\n.file-list { margin-left: 1em; color: blue; word-break: break-word; }\ntable { width: 100%; }\n.toc, .libraries, .files { width: 100%; word-break: break-word; }\nul, li, a, p, div, span { word-break: break-word; max-width: 100%; font-size: medium; }\npre { white-space: pre-wrap; font-family: monospace; font-size: medium; }\n* { max-width: 100%; word-break: break-word; }\n</style>";
    public static final String FILE_PROVIDER_AUTHORITY = "com.android.settings.files";
    private static final int LOADER_ID_LICENSE_HTML_LOADER = 0;
    private static final String TERMS_ACTION = "android.settings.TERMS";

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_LawInfoActivity_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<File> r1) {
    }

    public LawInfoActivity() {
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<File> r1, File r2) {
        onLoadFinished2(r1, r2);
    }

    public void com_android_settings_LawInfoActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.law_info_activity);
        LinearLayout r7 = (LinearLayout) findViewById(R.id.page_container);
        int r0 = r7.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        View r3 = r7.getChildAt(r2);
        if ((r3 instanceof OCardListItem) == false) goto L7;
        final OCardListItem r4 = (OCardListItem) r3;
        r4.setOnContentClickListener(new LawInfoActivity$$ExternalSyntheticLambda2(this, r4));
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new AnonymousClass1(this));
        View r8 = findViewById(R.id.item_google_legal_info);
        if (((IPlatform) ServiceManager.getService(IPlatform.class)).isGoogleLawEnable() == false) goto L11;
        r8.setVisibility(0);
    L12:
        LinearLayout r9 = (LinearLayout) findViewById(R.id.item_google);
        IGooglePayLegalView r1 = (IGooglePayLegalView) ServiceManager.getService(IGooglePayLegalView.class);
        if (r9 == null) goto L16;
        if (r1 == null) goto L16;
        r9.setVisibility(0);
        r1.createToParent(this, r9);
    L16:
        OSectionSupportiveText r10 = (OSectionSupportiveText) findViewById(R.id.tv_law_model);
        Configuration r5 = getResources().getConfiguration();
        String r11 = getString(R.string.law_info_model);
        if (r5.densityDpi != 640) goto L20;
        r10.setSectionDes(r11.replace("{0}", "\n"));
        return;
    L20:
        if (r5.fontScale <= 1.0f) goto L22;
        r10.setSectionDes(r11.replace("{0}", "\n"));
        return;
    L22:
        r10.setSectionDes(r11.replace("{0}", ""));
        return;
    L11:
        r8.setVisibility(8);
        goto L12
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-LawInfoActivity, reason: not valid java name */
    /* synthetic */ void m143lambda$onCreate$0$comandroidsettingsLawInfoActivity(OCardListItem r1, View r2) {
        onClick(r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        Intent r0 = new Intent();
        r0.putExtra("back_text_res_name", "about_item_title_law_info");
        r0.setComponent(new ComponentName(Constants.PKG_WALLPAPER_PROVIDER, "com.obric.wallpaper.LicenseActivity"));
        switch(r5.getId()) {
            case 2131429349: goto L25;
            case 2131429431: goto L24;
            case 2131429457: goto L22;
            case 2131429468: goto L21;
            case 2131429485: goto L19;
            case 2131429500: goto L18;
            case 2131429511: goto L16;
            case 2131429512: goto L14;
            case 2131429513: goto L9;
            case 2131429514: goto L7;
            case 2131429560: goto L5;
            default: goto L27;
        };
    L5:
        loadUrlWithExplorer(this, "https://os.oceancloudapi.com/agreement/os_user_agreement");
        return;
    L7:
        loadUrlWithExplorer(this, GrantUtil.URL_PRIVACY_POLICY);
        return;
    L9:
        File r6 = new File("/system/etc/NOTICE.html.gz");
        if (isFileValid(r6) == false) goto L12;
        showHtmlFromUri(Uri.fromFile(r6));
        return;
    L12:
        showHtmlFromDefaultXmlFiles();
        return;
    L14:
        loadUrlWithExplorer(this, getString(R.string.title_settings_app_other_law_url));
        return;
    L16:
        loadUrlWithExplorer(this, "https://os.oceancloudapi.com/agreement/opensourcelicenses");
        return;
    L18:
        r0.putExtra("extra_info_type", 5);
        goto L27
    L19:
        loadUrlWithExplorer(this, "https://os.oceancloudapi.com/agreement/os_privacy");
        return;
    L21:
        r0.putExtra("extra_info_type", 0);
        goto L27
    L22:
        Utils.startActivity(this, new Intent(this.mContext, CertificationActivity.class));
        return;
    L24:
        r0.putExtra("extra_info_type", 3);
        goto L27
    L25:
        goToTermActivity();
        return;
    L27:
        Utils.startActivity(this, r0, 0);
    }

    public static void loadUrlWithExplorer(Context r3, String r4) {
        if (r4 != null) goto L9;
        return;
    L9:
        Intent r0 = new Intent("android.intent.action.VIEW");     // Catch: ActivityNotFoundException -> L6
        r0.setPackage("com.obric.browser");     // Catch: ActivityNotFoundException -> L6
        r0.putExtra("create_new_tab", true);     // Catch: ActivityNotFoundException -> L6
        r0.addCategory("android.intent.category.BROWSABLE");     // Catch: ActivityNotFoundException -> L6
        r0.putExtra("support_dark_mode", true);     // Catch: ActivityNotFoundException -> L6
        r0.setData(Uri.parse(r4));     // Catch: ActivityNotFoundException -> L6
        r3.startActivity(r0);     // Catch: ActivityNotFoundException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public void loadHtmlWithExplorer(Context r5, Uri r6) {
        if (r6 != null) goto L9;
        return;
    L9:
        Intent r0 = new Intent("android.intent.action.VIEW");     // Catch: ActivityNotFoundException -> L6
        r0.setPackage("com.obric.browser");     // Catch: ActivityNotFoundException -> L6
        r0.putExtra("create_new_tab", true);     // Catch: ActivityNotFoundException -> L6
        r0.addCategory("android.intent.category.BROWSABLE");     // Catch: ActivityNotFoundException -> L6
        r0.putExtra("support_dark_mode", true);     // Catch: ActivityNotFoundException -> L6
        r0.putExtra("activity_title", "开放源代码协议");     // Catch: ActivityNotFoundException -> L6
        r0.setDataAndType(r6, "text/html");     // Catch: ActivityNotFoundException -> L6
        r0.addFlags(1);     // Catch: ActivityNotFoundException -> L6
        r5.startActivity(r0);     // Catch: ActivityNotFoundException -> L6
        getSupportLoaderManager().destroyLoader(0);     // Catch: ActivityNotFoundException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    private void goToTermActivity() {
        Utils.startActivity(this, new Intent(TERMS_ACTION));
    }

    private String getGoogleLegalInfoLink() {
        Locale r1 = Locale.getDefault();
        if (Locale.TRADITIONAL_CHINESE.equals(r1) == false) goto L7;
        return "http://www.google.com/intl/zh-TW/policies/";
    L7:
        if (Locale.SIMPLIFIED_CHINESE.equals(r1) == false) goto L10;
        return "https://www.google.com/intl/zh-CN/policies/";
    L10:
        return "http://www.google.com/intl/en/policies/";
    }

    private void showHtmlFromUri(Uri r4) {
        Intent r0 = new Intent("android.intent.action.VIEW");
        r0.setDataAndType(r4, "text/html");
        r0.putExtra("android.intent.extra.TITLE", getString(R.string.settings_license_activity_title));
        if ("content".equals(r4.getScheme()) == false) goto L5;
        r0.addFlags(129);
    L5:
        r0.addCategory("android.intent.category.DEFAULT");
        r0.setComponent(new ComponentName("com.android.htmlviewer", "com.android.htmlviewer.HTMLViewerActivity"));
        r0.setPackage("com.android.htmlviewer");
        startActivity(r0);     // Catch: ActivityNotFoundException -> L8
        finish();     // Catch: ActivityNotFoundException -> L8
        return;
    L8:
        e = move-exception;
        OLog.e(this.TAG, "Failed to find viewer", e);
    }

    boolean isFileValid(File r3) {
        if (r3.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (r3.length() == 0) goto L7;
        return true;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<File> onCreateLoader(int r1, Bundle r2) {
        return new LicenseHtmlLoaderCompat(this.mContext);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<File> r1, File r2) {
        showGeneratedHtmlFile(r2);
    }

    Uri getUriFromGeneratedHtmlFile(File r2) {
        return FileProvider.getUriForFile(this.mContext, "com.android.settings.files", r2);
    }

    private void showGeneratedHtmlFile(final File r2) {
        if (r2 == null) goto L4;
        ThreadUtils.postOnBackgroundThread(new LawInfoActivity$$ExternalSyntheticLambda0(this, r2));
        return;
    L4:
        OLog.e(this.TAG, "Failed to generate.");
        showErrorAndFinish();
    }

    /* JADX INFO: renamed from: lambda$showGeneratedHtmlFile$2$com-android-settings-LawInfoActivity, reason: not valid java name */
    /* synthetic */ void m145xfbddb239(File r2) {
        final File r3 = insertStringToFileHeader(r2);
        ThreadUtils.postOnMainThread(new LawInfoActivity$$ExternalSyntheticLambda1(this, r3));
    }

    /* JADX INFO: renamed from: lambda$showGeneratedHtmlFile$1$com-android-settings-LawInfoActivity, reason: not valid java name */
    /* synthetic */ void m144x9a8b159a(File r1) {
        loadHtmlWithExplorer(this, getUriFromGeneratedHtmlFile(r1));
    }

    private File insertStringToFileHeader(File r11) {
        File r0 = new File(r11.getParent(), ADD_WRITTEN_OFFER_FILE_NAME_NEW);
        if (isFileValid(r0) == false) goto L9;
        if (r0.lastModified() <= r11.lastModified()) goto L9;
        OLog.i(this.TAG, "insertStringToFileHeader file unchanged.");
        return r0;
    L9:
        if (r0.exists() == false) goto L11;
        r0.delete();
    L11:
        File r1 = new File(r11.getParent(), ADD_WRITTEN_OFFER_FILE_NAME);
        if (r1.exists() == false) goto L14;
        r1.delete();
    L14:
        String r2 = "<strong>" + getString(R.string.notice_written_offer_title) + "</strong>";
        String r3 = "<br><br>" + getString(R.string.notice_written_offer_content).replace("\n", "<br>");
        FileInputStream r4 = new FileInputStream(r11);     // Catch: IOException -> L53
        InputStreamReader r5 = new InputStreamReader(r4, StandardCharsets.UTF_8);     // Catch: Throwable -> L47
        FileOutputStream r7 = new FileOutputStream(r0);     // Catch: Throwable -> L41
        OutputStreamWriter r8 = new OutputStreamWriter(r7, StandardCharsets.UTF_8);     // Catch: Throwable -> L35
        r8.write("<br>");     // Catch: Throwable -> L29
        r8.write(r2);     // Catch: Throwable -> L29
        r8.write(r3);     // Catch: Throwable -> L29
        r8.write("<br><br>");     // Catch: Throwable -> L29
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L29
        char[] r9 = new char[8192];     // Catch: Throwable -> L29
    L20:
        int r10 = r5.read(r9);     // Catch: Throwable -> L29
        if (r10 == (-1)) goto L23;
        r6.append(r9, 0, r10);     // Catch: Throwable -> L29
        goto L20
    L23:
        r8.write(r6.toString().replace("</head>", "<style type=\"text/css\">\nhtml, body { margin: 0; padding: 0 20px; width: 100%; max-width: 100%; box-sizing: border-box; font-size: medium; }\nbody { font-family: sans-serif; word-break: break-word; }\n.same-license { background-color: #eeeeee; border-top: 20px solid white; padding: 10px; word-break: break-word; }\n.label { font-weight: bold; }\n.file-list { margin-left: 1em; color: blue; word-break: break-word; }\ntable { width: 100%; }\n.toc, .libraries, .files { width: 100%; word-break: break-word; }\nul, li, a, p, div, span { word-break: break-word; max-width: 100%; font-size: medium; }\npre { white-space: pre-wrap; font-family: monospace; font-size: medium; }\n* { max-width: 100%; word-break: break-word; }\n</style></head>"));     // Catch: Throwable -> L29
        r8.flush();     // Catch: Throwable -> L29
        r8.close();     // Catch: Throwable -> L35
        r7.close();     // Catch: Throwable -> L41
        r5.close();     // Catch: Throwable -> L47
        r4.close();     // Catch: IOException -> L53
        return r0;
    L29:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: Throwable -> L35
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r7.close();     // Catch: Throwable -> L38
    L40:
        throw th;     // Catch: Throwable -> L41
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L44
    L46:
        throw th;     // Catch: Throwable -> L47
    L44:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L50
    L52:
        throw th;     // Catch: IOException -> L53
    L50:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L53
    L53:
        e = move-exception;
        OLog.e(this.TAG, "Failed to insert header string.", e);
        r0.delete();
        return r11;
    }

    private void showErrorAndFinish() {
        finish();
    }

    private void showHtmlFromDefaultXmlFiles() {
        getSupportLoaderManager().initLoader(0, Bundle.EMPTY, this);
    }

    @Insert("onCreate")
    public static void com_android_settings_LawInfoActivity_com_obric_hook_lancet_PrivacyHook_onCreate(LawInfoActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LawInfoActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_LawInfoActivity__onCreate$___twin___(r4);
    }
}
