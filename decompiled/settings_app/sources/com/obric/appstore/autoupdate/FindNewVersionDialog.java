package com.obric.appstore.autoupdate;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.android.settings.search.Index;
import com.android.settings.utils.HanziToPinyin;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.alert.OViewStyleController;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Unit;
import obric.view.WindowManagerHelper;

/* JADX INFO: loaded from: classes4.dex */
public class FindNewVersionDialog {
    private static final String TAG = "FindNewVersionDialog";
    protected static char[] hexDigits;
    private boolean isFileExist;
    private Context mActivity;
    private String mAppName;
    private String mAppPkgName;
    private Bundle mBundle;
    private OAlertDialog mDialog;
    private int mModel;
    private boolean mUseMobile;

    public FindNewVersionDialog(Context r3, Bundle r4) {
        this.mAppPkgName = null;
        this.mModel = 0;
        this.mAppName = null;
        this.mUseMobile = false;
        this.isFileExist = false;
        this.mActivity = r3;
        this.mAppPkgName = r4.getString(ObricAutoUpdateUtils.INTENT_EXTRAS_PACKAGE);
        this.mModel = r4.getInt(ObricAutoUpdateUtils.INTENT_EXTRAS_MODEL);
        this.mBundle = r4;
        this.isFileExist = r4.getBoolean(ObricAutoUpdateUtils.INTENT_EXTRAS_FILE_EXIST);
        onCreate(r3);
    }

    private void onCreate(Context r7) {
        Pair<String, Drawable> r0 = loadLableAndIcon();
        if (r0 != null) goto L5;
    L14:
        Log.e(TAG, "loadLableAndIcon:pair is null. appPkgName = " + this.mAppPkgName);
        return;
    L5:
        if (r0.first == null) goto L14;
        if (r0.second == null) goto L14;
        this.mAppName = r0.first;
        OAlertDialogBuilder r8 = new OAlertDialogBuilder(r7).icon(r0.second).imageSize(OUnitExtensionKt.dp2px(56), OUnitExtensionKt.dp2px(56)).title(this.mActivity.getString(R.string.auto_update_title) + HanziToPinyin.Token.SEPARATOR + getVersionName(), false).body(new OViewStyleController(new FindNewVersionDialog$$ExternalSyntheticLambda0(this))).positiveButton(R.string.auto_update_ok, new FindNewVersionDialog$$ExternalSyntheticLambda1(this)).neutralButton(secondaryBtnStringID(), new FindNewVersionDialog$$ExternalSyntheticLambda2(this));
        if (shouldShowIgnoreBtn() == false) goto L12;
        r8.negativeButton(R.string.obric_auto_update_ignore, new FindNewVersionDialog$$ExternalSyntheticLambda3(this));
    L12:
        OAlertDialog r9 = r8.createDialog();
        this.mDialog = r9;
        r9.setCanceledOnTouchOutside(true);
        this.mDialog.setCancelable(false);
        Log.d(TAG, "onCreate:" + this.mAppPkgName + Index.ENTRIES_SEPARATOR + this.mModel);
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-obric-appstore-autoupdate-FindNewVersionDialog, reason: not valid java name */
    /* synthetic */ Unit m985x88e0061(FrameLayout r1) {
        r1.addView(genContentView());
        return null;
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-obric-appstore-autoupdate-FindNewVersionDialog, reason: not valid java name */
    /* synthetic */ void m986x36669ac0(DialogInterface r1, int r2) {
        onClickUpdate();
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-obric-appstore-autoupdate-FindNewVersionDialog, reason: not valid java name */
    /* synthetic */ void m987x643f351f(DialogInterface r1, int r2) {
        onClickSecondaryBtn();
    }

    /* JADX INFO: renamed from: lambda$onCreate$3$com-obric-appstore-autoupdate-FindNewVersionDialog, reason: not valid java name */
    /* synthetic */ void m988x9217cf7e(DialogInterface r1, int r2) {
        onClickIgnore();
    }

    private View genContentView() {
        View r0 = LayoutInflater.from(this.mActivity).inflate(R.layout.obric_auto_update_2, null);
        ((MaxScrollView) r0.findViewById(R.id.scrollView)).setMaxHeight(OUnitExtensionKt.dp2px(500));
        TextView r1 = (TextView) r0.findViewById(R.id.app_update_log);
        String r2 = this.mBundle.getString(ObricAutoUpdateUtils.INTENT_EXTRAS_LOG);
        if (TextUtils.isEmpty(r2) == true) goto L5;
        r1.setText(r2);
    L6:
        TextView r3 = (TextView) r0.findViewById(R.id.app_update_tip);
        if (this.isFileExist == false) goto L9;
        r3.setText(this.mActivity.getString(R.string.auto_install_tips));
    L10:
        return r0;
    L9:
        r3.setText(getTips());
        goto L10
    L5:
        Log.d(TAG, "no updateLog");
        goto L6
    }

    private String getVersionName() {
        return this.mBundle.getString(ObricAutoUpdateUtils.INTENT_EXTRAS_VERSION_NAME);
    }

    private void onClickUpdate() {
        if (this.isFileExist == false) goto L7;
        ObricAutoUpdateUtils.getInstance().installApp(this.mActivity, this.mAppName, this.mBundle);
        closePanel();
        return;
    L7:
        if (this.mModel != 2) goto L9;
        new UpdateProgressDialog(this.mActivity, this.mAppPkgName, this.mModel).showDelay(300);
    L9:
        ObricAutoUpdateUtils.getInstance().startDownload(this.mActivity, this.mAppName, this.mUseMobile, this.mBundle);
        closePanel();
    }

    private void onClickSecondaryBtn() {
        if (this.mModel != 2) goto L5;
        Process.killProcess(Process.myPid());
    L6:
        closePanel();
        return;
    L5:
        ObricAutoUpdateUtils.getInstance().delayUpdate(this.mActivity, this.mAppPkgName, -1);
        goto L6
    }

    private int secondaryBtnStringID() {
        if (this.mModel != 2) goto L7;
        return android.R.string.cancel;
    L7:
        return R.string.auto_update_cancel;
    }

    private void onClickIgnore() {
        int r0 = this.mBundle.getInt(ObricAutoUpdateUtils.INTENT_EXTRAS_VERSION_CODE);
        ObricAutoUpdateUtils.getInstance().delayUpdate(this.mActivity, this.mAppPkgName, r0);
        closePanel();
    }

    private boolean shouldShowIgnoreBtn() {
        if (this.isFileExist == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mModel == 2) goto L7;
        return true;
    }

    private void closePanel() {
        OAlertDialog r0 = this.mDialog;     // Catch: Exception -> L6
        if (r0 == null) goto L9;
        r0.dismiss();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    private String getTips() {
        NetworkInfo r0 = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r0 != null) goto L5;
        Log.d(TAG, "networkInfo is null");
    L10:
        String r1 = Formatter.formatFileSize(this.mActivity, this.mBundle.getLong(ObricAutoUpdateUtils.INTENT_EXTRAS_SIZE));
        if (this.mUseMobile == false) goto L19;
        if (this.mModel != 2) goto L17;
        return this.mActivity.getString(R.string.auto_update_tip_mobile_force, new Object[]{r1});
    L17:
        return this.mActivity.getString(R.string.auto_update_tip_mobile, new Object[]{r1});
    L19:
        if (this.mModel != 2) goto L23;
        return this.mActivity.getString(R.string.auto_update_tip_wifi_force, new Object[]{r1});
    L23:
        return this.mActivity.getString(R.string.auto_update_tip_wifi, new Object[]{r1});
    L5:
        if (r0.getType() != 0) goto L7;
        boolean r2 = true;
    L8:
        this.mUseMobile = r2;
        goto L10
    L7:
        r2 = false;
        goto L8
    }

    private Pair<String, Drawable> loadLableAndIcon() {
        Drawable r1 = null;
        PackageManager r2 = this.mActivity.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L19
        ApplicationInfo r5 = r2.getApplicationInfo(this.mAppPkgName, 0);     // Catch: PackageManager.NameNotFoundException -> L19
        if (r5 != null) goto L7;
        Log.d(TAG, "ApplicationInfo is null.");     // Catch: PackageManager.NameNotFoundException -> L19
        return null;
    L7:
        String r3 = r5.loadLabel(r2).toString();     // Catch: PackageManager.NameNotFoundException -> L19
        if (r3 != null) goto L25;
        Log.d(TAG, "getLogoDrawable:name is null");     // Catch: PackageManager.NameNotFoundException -> L19
        r3 = null;
    L25:
        Drawable r6 = r5.loadIcon(r2);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r6 == null) goto L15;
        r1 = r6;
    L23:
        return new Pair(r3, r1);
    L15:
        Log.d(TAG, "getLogoDrawable:drawable is null");     // Catch: PackageManager.NameNotFoundException -> L17
    L17:
        e = e;
    L21:
        Log.d(TAG, "getLogoDrawable:" + e.getMessage());
    L19:
        e = e;
        r3 = null;
        goto L21
    }

    public void show() {
    L7:
        e = move-exception;
        Log.e(TAG, "show: ", e);
        return;
    L3:
        if ((this.mActivity instanceof Activity) == true) goto L5;
        this.mDialog.getWindow().setType(WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY);     // Catch: Exception -> L7
    L5:
        this.mDialog.show();     // Catch: Exception -> L7
    }

    public String getFileMD5String(File r5) throws IOException {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L9
        FileInputStream r1 = new FileInputStream(r5);
        byte[] r6 = new byte[1024];
    L4:
        int r2 = r1.read(r6);
        if (r2 <= 0) goto L7;
        r0.update(r6, 0, r2);
        goto L4
    L7:
        r1.close();
        byte[] r7 = r0.digest();
        return bufferToHex(r7, 0, r7.length);
    L9:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private String bufferToHex(byte[] r3, int r4, int r5) {
        StringBuffer r0 = new StringBuffer(r5 * 2);
        int r6 = r5 + r4;
    L3:
        if (r4 >= r6) goto L6;
        appendHexPair(r3[r4], r0);
        r4 = r4 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    private void appendHexPair(byte r2, StringBuffer r3) {
        char[] r1 = hexDigits;
        char r0 = r1[(r2 & 240) >> 4];
        char r4 = r1[r2 & 15];
        r3.append(r0);
        r3.append(r4);
    }

    static {
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }
}
