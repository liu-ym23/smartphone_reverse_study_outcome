package com.obric.ctaverify;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.obric.olog.OLog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.security.R;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class SendSmsVerificationActivity extends AppCompatActivity {
    public String callingAttributionTag;
    private String callingPackage;
    public int callingUid;
    public PendingIntent deliveryIntent;
    public String destAddr;
    public boolean hasValidityPeriod;
    public boolean isMultipartText;
    public long messageId;
    public PackageInfo packageInfo;
    boolean persistMessage;
    public String scAddr;
    public PendingIntent sentIntent;
    public String text;

    public SendSmsVerificationActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SEND_SMS();
        parseIntent(getIntent());
        new OAlertDialogBuilder(this).autoDismiss(false).title(getDialogTitle(), false).message(getSmsPreview()).positiveButton(getString(R.string.sms_send), new AnonymousClass2(this)).negativeButton(getString(R.string.btn_cancel), new AnonymousClass1(this)).show();
    }

    private void parseIntent(Intent intent) {
        this.callingPackage = intent.getStringExtra("callingPackage");
        PackageInfo r0 = getPackageManager().getPackageInfo(this.callingPackage, 0);     // Catch: Exception -> L5
        this.packageInfo = r0;     // Catch: Exception -> L5
        this.callingUid = intent.getIntExtra("callingUid", r0.applicationInfo.uid);     // Catch: Exception -> L5
        this.callingAttributionTag = intent.getStringExtra("callingAttributionTag");     // Catch: Exception -> L5
        this.destAddr = intent.getStringExtra("destAddr").trim();     // Catch: Exception -> L5
        this.scAddr = intent.getStringExtra("scAddr");     // Catch: Exception -> L5
        this.text = intent.getStringExtra("text");     // Catch: Exception -> L5
        this.messageId = intent.getLongExtra("messageId", 0);     // Catch: Exception -> L5
        this.persistMessage = intent.getBooleanExtra("persistMessage", true);     // Catch: Exception -> L5
        this.sentIntent = (PendingIntent) intent.getParcelableExtra("sentIntent");     // Catch: Exception -> L5
        this.deliveryIntent = (PendingIntent) intent.getParcelableExtra("deliveryIntent");     // Catch: Exception -> L5
        this.hasValidityPeriod = intent.getBooleanExtra("hasValidityPeriod", false);     // Catch: Exception -> L5
        this.isMultipartText = intent.getBooleanExtra("isMultipartText", false);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e("SendSmsVerificationActivity", "calling package not found!", e);
        finish();
    }

    public String getDialogTitle() {
        return getString(R.string.permission_sms_request, new Object[]{getCallAppName(this.callingPackage)});
    }

    private String getSmsPreview() {
        return getString(R.string.sms_preview, new Object[]{this.destAddr, this.text});
    }

    private String getCallAppName(String packageName) {
        PackageManager r2 = getPackageManager();
        return "「" + r2.getApplicationLabel(r2.getApplicationInfo(packageName, 0)).toString() + "」";
    L5:
        return "该应用";
    }

    public void ondClick() {
        reflection(SmsManager.getDefault(), Void.TYPE, "sendTextMessageInternal", new Class[]{String.class, String.class, String.class, PendingIntent.class, PendingIntent.class, Boolean.TYPE, String.class, String.class, Long.TYPE}, new Object[]{this.destAddr, this.scAddr, this.text, this.sentIntent, this.deliveryIntent, Boolean.valueOf(this.persistMessage), "com.obric.security", this.callingAttributionTag, Long.valueOf(this.messageId)});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static <T> T reflection(Object r0, Class<T> r1, String r2, Class<?>[] r3, Object... r4) {
        Method r5 = r0.getClass().getDeclaredMethod(r2, r3);     // Catch: NoSuchMethodException -> L12
        r5.setAccessible(true);
        return (T) r5.invoke(r0, r4);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void SEND_SMS() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.SEND_SMS") == 0) goto L6;
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.SEND_SMS"}, 2);
        return;
    }
}
