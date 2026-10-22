package com.android.settings.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.vcard.VCardConstants;
import com.bytedance.sremlib.LibUtil;
import com.bytedance.ttnet.TTNetInit;
import com.obric.olog.OLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HardwareDetailInfo implements Runnable {
    private static final boolean DBG = true;
    private static final String FINGERPRINT_GOODIX = "goodix";
    private static final String FINGERPRINT_OFILM = "ofilm";
    private static final String FINGERPRINT_PROPERTIES_ID = "vendor.boot.fingerprint.id";
    private static final String INVALID_VALUE = "__";
    private static final String NODE_ROOT = "/sys/hwinfo/";
    private static final String TAG = "HardwareDetailInfo";
    private static final int TIMEOUT = 5000;
    protected static final String V1 = "01";
    protected static final String V2 = "02";
    protected static final String V3 = "03";
    protected static final String V4 = "04";
    protected static final String V5 = "05";
    private Context mContext;

    /* JADX INFO: renamed from: com.android.settings.utils.HardwareDetailInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class AccSensor extends SensorFile {
        private static final String TYPE_1 = "bmi120";
        private static final String TYPE_1_B = "bmi160";
        private static final String TYPE_2 = "icm20600";
        private static final String TYPE_3 = "icm20690";
        private static final String TYPE_4 = "icm20607";
        private static final String TYPE_DELTA_A = "icm4x6xx";
        private static final String TYPE_DELTA_B = "bmi160";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected String getNodeCode() {
            return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected int getSensorType() {
            return 1;
        }

        private AccSensor(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ AccSensor(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOdinSensorName(String r3) {
            String r4 = r3.toLowerCase();
            OLog.d(HardwareDetailInfo.TAG, " parseSensorName is : " + r4);
            if (r4.contains(TYPE_1) == false) goto L5;
        L11:
            this.mValue = HardwareDetailInfo.V1;
            return;
        L5:
            if (r4.contains("bmi160") == true) goto L11;
            if (r4.contains(TYPE_2) == false) goto L10;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L10:
            OLog.d(HardwareDetailInfo.TAG, " parseSensorName match noone");
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOsbornSensorName(String r3) {
            String r4 = r3.toLowerCase();
            OLog.d(HardwareDetailInfo.TAG, " parseSensorName is : " + r4);
            if (r4.contains("bmi160") == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L6:
            if (r4.contains(TYPE_2) == false) goto L8;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L8:
            OLog.d(HardwareDetailInfo.TAG, " parseSensorName match noone");
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseTridentSensorName(String r2) {
            if (r2.toLowerCase().contains(TYPE_3) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOceanSensorName(String r2) {
            String r3 = r2.toLowerCase();
            if (r3.contains("bmi160") == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L6:
            if (r3.contains(TYPE_4) == false) goto L10;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseDeltaSensorName(String r2) {
            String r3 = r2.toLowerCase();
            if (r3.contains(TYPE_DELTA_A) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L6:
            if (r3.contains("bmi160") == false) goto L10;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }
    }

    private class BatteryNode extends NodeFile {
        private static final String TARGET_KEY = "BATTARY_MFR";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return VCardConstants.PARAM_ENCODING_B;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private BatteryNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ BatteryNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOdinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "ATL") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "SCUD") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOsbornContent(String r1, String r2, int r3) {
            parseOdinContent(r1, r2, r3);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseTridentContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "ATL") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "JIADE") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOceanContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "SCUD") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "ATL") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDeltaContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "SCUD") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "ATL") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }
    }

    private class BoardIDNode extends NodeFile {
        private static final String TARGET_KEY = "version_id";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return "I";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return "version_id";
        }

        private BoardIDNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ BoardIDNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOdinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, "version_id") == false) goto L13;
            String[] r5 = r3.split(":");
            if (r5 != null) goto L9;
            return;
        L9:
            if (r5.length != 3) goto L15;
            this.mValue = r5[2];
            return;
        L15:
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOsbornContent(String r1, String r2, int r3) {
            parseOdinContent(r1, r2, r3);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseTridentContent(String r1, String r2, int r3) {
            parseOdinContent(r1, r2, r3);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOceanContent(String r1, String r2, int r3) {
            parseOdinContent(r1, r2, r3);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDeltaContent(String r1, String r2, int r3) {
            parseOdinContent(r1, r2, r3);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDarwinContent(String r1, String r2, int r3) {
            parseOdinContent(r1, r2, r3);
        }
    }

    private class CPUNode extends NodeFile {
        private static final String TARGET_KEY = "CPU_TYPE";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return "C";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private CPUNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ CPUNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOdinContent(String r3, String r4, int r5) {
            OLog.d(HardwareDetailInfo.TAG, "CPUNode k :" + r3 + " v :" + r4 + " l :" + r5);
            if (r5 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r3, TARGET_KEY) == false) goto L14;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes here ");
            if (TextUtils.equals(r4, "MSM8953") == false) goto L10;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes A ");
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r4, "MSM8953Pro") == false) goto L16;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes B ");
            this.mValue = HardwareDetailInfo.V2;
            return;
        L16:
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOsbornContent(String r3, String r4, int r5) {
            OLog.d(HardwareDetailInfo.TAG, "CPUNode k :" + r3 + " v :" + r4 + " l :" + r5);
            if (r5 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r3, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r4, "sdm660") == false) goto L12;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes A ");
            this.mValue = HardwareDetailInfo.V1;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseTridentContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "sdm845") == false) goto L12;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes A ");
            this.mValue = HardwareDetailInfo.V1;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOceanContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "Qualcomm Technologies, Inc. SDM710 PM660 + PM660A MTP") == false) goto L10;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes A ");
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Qualcomm Technologies, Inc. SDM670 PM660 + PM660A MTP") == false) goto L16;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes B ");
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDeltaContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "SM8150P") == false) goto L10;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes A ");
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "SM8150") == false) goto L16;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes B ");
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDarwinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "SM8250") == false) goto L12;
            OLog.d(HardwareDetailInfo.TAG, "CPUNode goes A ");
            this.mValue = HardwareDetailInfo.V1;
            return;
        }
    }

    private class CamearInfoReader {
        private static final String EXE_FRONT = "c_read-front-camera-inf";
        private static final String EXE_REAR = "c_read-rear-camera-inf";
        private static final String FRONT_TYPE_SENSOR_NAME_A = "S5K3P3ST06-FGX9";
        private static final String FRONT_TYPE_SENSOR_NAME_B = "OV8856-GA4A";
        private static final String FRONT_TYPE_SENSOR_NAME_C = "S5K3P8SP";
        private static final String FRONT_TYPE_VENDOR_NAME_A = "Sunny";
        private static final String FRONT_TYPE_VENDOR_NAME_B = "Qtech";
        private static final String REAR_TYPE_V1_SENSOR_NAME = "S5K3L8XXM3";
        private static final String REAR_TYPE_V2_SENSOR_NAME = "OV-13855-GA5A";
        private static final String REAR_TYPE_V3_SENSOR_NAME = "IMX386";
        private static final String SENSOR_NAME_TAG = "Sensor name is";
        private static final String VENDOR_NAME_TAG = "Module vendor";
        private String mValueFront;
        private String mValueRear;
        final /* synthetic */ HardwareDetailInfo this$0;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v6, types: [byte[]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0079 -> B:96:0x00c5). Please report as a decompilation issue!!! */
        public CamearInfoReader(HardwareDetailInfo r14) {
            this.this$0 = r14;
            this.mValueFront = HardwareDetailInfo.INVALID_VALUE;
            this.mValueRear = HardwareDetailInfo.INVALID_VALUE;
            int r6 = 0;
            BufferedReader r7 = null;
            BufferedReader r9 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(HardwareDetailInfo.access$1600(r14, EXE_FRONT).getBytes())));     // Catch: Throwable -> L33 IOException -> L35
            int r8 = 0;
            int r10 = 0;
        L100:
            String r11 = r9.readLine();     // Catch: IOException -> L31 Throwable -> L86
            OLog.d(HardwareDetailInfo.TAG, "CamearInfoReader readline : " + r11);     // Catch: IOException -> L31 Throwable -> L86
            if (r11 == null) goto L7;
            if (r11.contains(SENSOR_NAME_TAG) == false) goto L22;
            if (r11.contains(":") == false) goto L22;
            String[] r12 = r11.split(":");     // Catch: IOException -> L31 Throwable -> L86
            if (r12 == null) goto L22;
            if (r12.length != 2) goto L22;
            r10 = parseFrontCameraSensor(r12[1]);     // Catch: IOException -> L31 Throwable -> L86
        L22:
            if (r11.contains(VENDOR_NAME_TAG) == false) goto L100;
            if (r11.contains(":") == false) goto L100;
            String[] r13 = r11.split(":");     // Catch: IOException -> L31 Throwable -> L86
            if (r13 == null) goto L100;
            if (r13.length != 2) goto L100;
            r8 = parseCameraVendor(r13[1]);     // Catch: IOException -> L31 Throwable -> L86
            goto L100
        L7:
            OLog.d(HardwareDetailInfo.TAG, "CamearInfoReader execute  end vendor: " + r8 + " sensor : " + r10);     // Catch: IOException -> L31 Throwable -> L86
            this.mValueFront = parseFrontCameraParamValue(r8, r10);     // Catch: IOException -> L31 Throwable -> L86
            r9.close();     // Catch: IOException -> L10
            HardwareDetailInfo r15 = r14;
        L96:
            r14 = HardwareDetailInfo.access$1600(r15, EXE_REAR).getBytes();     // Catch: Throwable -> L70 IOException -> L72
            BufferedReader r16 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r14)));     // Catch: Throwable -> L70 IOException -> L72
            int r17 = 0;
        L108:
            String r18 = r16.readLine();     // Catch: Throwable -> L66 IOException -> L68
            OLog.d(HardwareDetailInfo.TAG, "CamearInfoReader readline rear : " + r18);     // Catch: Throwable -> L66 IOException -> L68
            if (r18 == null) goto L44;
            if (r18.contains(SENSOR_NAME_TAG) == false) goto L57;
            if (r18.contains(":") == false) goto L57;
            String[] r19 = r18.split(":");     // Catch: Throwable -> L66 IOException -> L68
            if (r19 == null) goto L57;
            if (r19.length != 2) goto L57;
            r17 = parseRearSideCameraSensor(r19[1]);     // Catch: Throwable -> L66 IOException -> L68
        L57:
            if (r18.contains(VENDOR_NAME_TAG) == false) goto L108;
            if (r18.contains(":") == false) goto L108;
            String[] r20 = r18.split(":");     // Catch: Throwable -> L66 IOException -> L68
            if (r20 == null) goto L108;
            if (r20.length != 2) goto L108;
            r6 = parseCameraVendor(r20[1]);     // Catch: Throwable -> L66 IOException -> L68
            goto L108
        L44:
            this.mValueRear = parseRearSideCameraParamValue(r6, r17);     // Catch: Throwable -> L66 IOException -> L68
            r16.close();     // Catch: IOException -> L77
        L104:
            return;
        L68:
            e = e;
            r9 = r16;
        L73:
            e.printStackTrace();     // Catch: Throwable -> L70
            if (r9 == null) goto L133;
            r9.close();     // Catch: IOException -> L77
            goto L104
        L133:
            return;
        L66:
            th = th;
            r9 = r16;
        L80:
            if (r9 != null) goto L94;
        L85:
            throw th;
        L94:
            r9.close();     // Catch: IOException -> L83
        L83:
            e = move-exception;
            e.printStackTrace();
            goto L85
        L70:
            th = th;
        L72:
            e = e;
        L77:
            e = move-exception;
            e.printStackTrace();
            return;
        L31:
            IOException e = e;
        L37:
            e.printStackTrace();     // Catch: Throwable -> L86
            r15 = r14;
            if (r9 == null) goto L96;
            r9.close();     // Catch: IOException -> L10
            r15 = r14;
        L86:
            th = th;
            r7 = r9;
        L88:
            if (r7 != null) goto L102;
        L93:
            throw th;
        L102:
            r7.close();     // Catch: IOException -> L91
        L91:
            e = move-exception;
            e.printStackTrace();
            goto L93
        L10:
            e = move-exception;
            e.printStackTrace();
            r15 = r14;
        L35:
            e = move-exception;
            r9 = null;
            e = e;
        L33:
            th = th;
            goto L88
        }

        private int parseFrontCameraSensor(String r2) {
            if (r2.toLowerCase().contains(FRONT_TYPE_SENSOR_NAME_A.toLowerCase()) == false) goto L6;
            int r1 = 1;
        L10:
            if (r2.toLowerCase().contains(FRONT_TYPE_SENSOR_NAME_C.toLowerCase()) == false) goto L13;
            return 3;
        L13:
            return r1;
        L6:
            if (r2.toLowerCase().contains(FRONT_TYPE_SENSOR_NAME_B.toLowerCase()) == false) goto L8;
            r1 = 2;
            goto L10
        L8:
            r1 = 0;
            goto L10
        }

        private int parseRearSideCameraSensor(String r2) {
            if (r2.toLowerCase().contains(REAR_TYPE_V1_SENSOR_NAME.toLowerCase()) == false) goto L6;
            return 1;
        L6:
            if (r2.toLowerCase().contains(REAR_TYPE_V2_SENSOR_NAME.toLowerCase()) == false) goto L9;
            return 2;
        L9:
            if (r2.toLowerCase().contains(REAR_TYPE_V3_SENSOR_NAME.toLowerCase()) == false) goto L11;
            return 3;
        L11:
            return 0;
        }

        private int parseCameraVendor(String r2) {
            if (r2.toLowerCase().contains(FRONT_TYPE_VENDOR_NAME_A.toLowerCase()) == false) goto L6;
            return 1;
        L6:
            if (r2.toLowerCase().contains(FRONT_TYPE_VENDOR_NAME_B.toLowerCase()) == false) goto L8;
            return 2;
        L8:
            return 0;
        }

        private String parseFrontCameraParamValue(int r5, int r6) {
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.ODIN) == false) goto L19;
            if (r5 != 1) goto L7;
            if (r6 != 1) goto L7;
            return HardwareDetailInfo.V1;
        L7:
            if (r5 != 1) goto L10;
            if (r6 != 2) goto L10;
            return HardwareDetailInfo.V2;
        L10:
            if (r5 != 2) goto L14;
            if (r6 != 1) goto L14;
            return HardwareDetailInfo.V3;
        L14:
            if (r5 != 2) goto L27;
            if (r6 != 2) goto L29;
            return HardwareDetailInfo.V4;
        L29:
            return HardwareDetailInfo.INVALID_VALUE;
        L27:
            return HardwareDetailInfo.INVALID_VALUE;
        L19:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OSBORN) == true) goto L21;
            return HardwareDetailInfo.INVALID_VALUE;
        L21:
            if (r5 != 1) goto L24;
            if (r6 != 3) goto L24;
            return HardwareDetailInfo.V2;
        L24:
            if (r5 != 2) goto L31;
            if (r6 != 3) goto L32;
            return HardwareDetailInfo.V1;
        L32:
            return HardwareDetailInfo.INVALID_VALUE;
        L31:
            return HardwareDetailInfo.INVALID_VALUE;
        }

        private String parseRearSideCameraParamValue(int r5, int r6) {
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.ODIN) == false) goto L9;
            if (r6 != 1) goto L6;
            return HardwareDetailInfo.V1;
        L6:
            if (r6 != 2) goto L17;
            return HardwareDetailInfo.V2;
        L17:
            return HardwareDetailInfo.INVALID_VALUE;
        L9:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OSBORN) == true) goto L11;
            return HardwareDetailInfo.INVALID_VALUE;
        L11:
            if (r5 != 1) goto L14;
            if (r6 != 3) goto L14;
            return HardwareDetailInfo.V2;
        L14:
            if (r5 != 2) goto L20;
            if (r6 != 3) goto L21;
            return HardwareDetailInfo.V1;
        L21:
            return HardwareDetailInfo.INVALID_VALUE;
        L20:
            return HardwareDetailInfo.INVALID_VALUE;
        }

        public String readFront() {
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.ODIN) == false) goto L7;
            return "M" + this.mValueFront;
        L7:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OSBORN) == true) goto L9;
            return HardwareDetailInfo.INVALID_VALUE;
        L9:
            return "X" + this.mValueFront;
        }

        public String readRear() {
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.ODIN) == false) goto L7;
            return "N" + this.mValueRear;
        L7:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OSBORN) == true) goto L9;
            return HardwareDetailInfo.INVALID_VALUE;
        L9:
            return "Y" + this.mValueRear;
        }
    }

    private class CompassSensor extends SensorFile {
        private static final String TYPE_1 = "ak09911c";
        private static final String TYPE_1_B = "ak09911";
        private static final String TYPE_2 = "mmc3630kj";
        private static final String TYPE_3 = "ak0991x";
        private static final String TYPE_4 = "mmc5603";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected String getNodeCode() {
            return "O";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected int getSensorType() {
            return 2;
        }

        private CompassSensor(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ CompassSensor(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOdinSensorName(String r2) {
            String r3 = r2.toLowerCase();
            if (r3.contains(TYPE_1) == false) goto L5;
        L10:
            this.mValue = HardwareDetailInfo.V1;
            return;
        L5:
            if (r3.contains(TYPE_1_B) == true) goto L10;
            if (r3.contains(TYPE_2) == false) goto L12;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOsbornSensorName(String r2) {
            String r3 = r2.toLowerCase();
            if (r3.contains(TYPE_1) == false) goto L5;
        L13:
            this.mValue = HardwareDetailInfo.V1;
            return;
        L5:
            if (r3.contains(TYPE_1_B) == true) goto L13;
            if (r3.contains(TYPE_2) == false) goto L11;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L11:
            if (r3.contains(TYPE_3) == false) goto L16;
            this.mValue = HardwareDetailInfo.V3;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseTridentSensorName(String r2) {
            String r3 = r2.toLowerCase();
            if (r3.contains(TYPE_3) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L6:
            if (r3.contains(TYPE_4) == false) goto L10;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOceanSensorName(String r2) {
            String r3 = r2.toLowerCase();
            if (r3.contains(TYPE_3) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L6:
            if (r3.contains(TYPE_4) == false) goto L10;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseDeltaSensorName(String r2) {
            String r3 = r2.toLowerCase();
            if (r3.contains(TYPE_3) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L6:
            if (r3.contains(TYPE_4) == false) goto L10;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }
    }

    private class EMMCNode extends NodeFile {
        private static final String TARGET_KEY = "emmc_manufacturer";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return "E";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private EMMCNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ EMMCNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOdinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "Toshiba") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Micron") == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3, "Sandisk") == false) goto L16;
            this.mValue = HardwareDetailInfo.V3;
            return;
        L16:
            if (TextUtils.equals(r3, "Samsung") == false) goto L19;
            this.mValue = HardwareDetailInfo.V4;
            return;
        L19:
            if (TextUtils.equals(r3, "Hynix") == false) goto L28;
            this.mValue = HardwareDetailInfo.V5;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOsbornContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "Samsung") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Hynix") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }
    }

    private class FPNode extends NodeFile {
        private static final String TARGET_KEY = "FP_MFR";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return "F";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private FPNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ FPNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOdinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, HardwareDetailInfo.FINGERPRINT_GOODIX) == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "idex") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOsbornContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, HardwareDetailInfo.FINGERPRINT_GOODIX) == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "fpc") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseTridentContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, HardwareDetailInfo.FINGERPRINT_GOODIX) == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "fpc") == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3, "nvtfp") == false) goto L20;
            this.mValue = HardwareDetailInfo.V3;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOceanContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, HardwareDetailInfo.FINGERPRINT_GOODIX) == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "nvtfp") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDeltaContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, HardwareDetailInfo.FINGERPRINT_GOODIX) == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "nvtfp") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }
    }

    private class LCDNode extends NodeFile {
        private static final String TARGET_KEY = "LCD_MFR";
        private static final String TARGET_KEY_2 = "tp_version";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return ExifInterface.GPS_DIRECTION_TRUE;
        }

        private LCDNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ LCDNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            if (bytedanceos.util.DeviceType.isOneOf(new bytedanceos.util.DeviceType[]{bytedanceos.util.DeviceType.DELTA}) == false) goto L6;
            return TARGET_KEY_2;
        L6:
            return TARGET_KEY;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOdinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "ft8716") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "nt36672") == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3, "sharp") == false) goto L20;
            this.mValue = HardwareDetailInfo.V3;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOsbornContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "tianma") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, TTNetInit.DOMAIN_BOE_KEY) == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3, "txd") == false) goto L20;
            this.mValue = HardwareDetailInfo.V3;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseTridentContent(String r2, String r3, int r4) {
            super.parseTridentContent(r2, r3, r4);
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "synaptics td4762") == false) goto L12;
            this.mValue = HardwareDetailInfo.V1;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOceanContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "RM69298") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3.toLowerCase(), EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDeltaContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY_2) == false) goto L9;
            this.mValue = r3;
            return;
        }
    }

    private class LPDDRNode extends NodeFile {
        private static final String TARGET_KEY = "lpddr_manufacturer";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return "D";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private LPDDRNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ LPDDRNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOdinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "Micron") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Hynix") == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3, "Samsung") == false) goto L20;
            this.mValue = HardwareDetailInfo.V3;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOsbornContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "Samsung") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Hynix") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseTridentContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "Samsung") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Hynix") == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3, "Micron") == false) goto L20;
            this.mValue = HardwareDetailInfo.V3;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOceanContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "Samsung") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Hynix") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDeltaContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "Samsung") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Hynix") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDarwinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "Samsung") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Hynix") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }
    }

    private class LightSensor extends SensorFile {
        private static final String TYPE_1 = "TSL258X";
        private static final String TYPE_2 = "STK342X";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected String getNodeCode() {
            return "L";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected int getSensorType() {
            return 5;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseDeltaSensorName(String r1) {
        }

        private LightSensor(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ LightSensor(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseTridentSensorName(String r2) {
            if (r2.toLowerCase().contains(TYPE_1.toLowerCase()) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOceanSensorName(String r2) {
            if (r2.toLowerCase().contains(TYPE_2.toLowerCase()) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        }
    }

    private abstract class NodeFile {
        protected String mValue;
        final /* synthetic */ HardwareDetailInfo this$0;

        protected abstract String getNodeCode();

        protected abstract String getNodeName();

        protected void parseDarwinContent(String r1, String r2, int r3) {
        }

        protected void parseDeltaContent(String r1, String r2, int r3) {
        }

        protected void parseOceanContent(String r1, String r2, int r3) {
        }

        protected void parseOdinContent(String r1, String r2, int r3) {
        }

        protected void parseOsbornContent(String r1, String r2, int r3) {
        }

        protected void parseTridentContent(String r1, String r2, int r3) {
        }

        private NodeFile(HardwareDetailInfo r1) {
            this.this$0 = r1;
            this.mValue = HardwareDetailInfo.INVALID_VALUE;
        }

        /* synthetic */ NodeFile(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void parseContent(String r2, String r3, int r4) {
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.ODIN) == false) goto L6;
            parseOdinContent(r2, r3, r4);
            return;
        L6:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OSBORN) == false) goto L9;
            parseOsbornContent(r2, r3, r4);
            return;
        L9:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.TRIDENT) == false) goto L12;
            parseTridentContent(r2, r3, r4);
            return;
        L12:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OCEAN) == false) goto L15;
            parseOceanContent(r2, r3, r4);
            return;
        L15:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.DELTA) == false) goto L18;
            parseDeltaContent(r2, r3, r4);
            return;
        L18:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.DARWIN) == false) goto L26;
            parseDarwinContent(r2, r3, r4);
            return;
        }

        protected String read() {
            File r0 = new File(HardwareDetailInfo.NODE_ROOT + getNodeName());
            if (r0.exists() == false) goto L48;
            OLog.d(HardwareDetailInfo.TAG, " read NodeFile : " + r0);
            BufferedReader r1 = null;
            BufferedReader r3 = new BufferedReader(new FileReader(r0));     // Catch: Throwable -> L27 IOException -> L29 FileNotFoundException -> L34
            int r4 = 0;
        L58:
            String r5 = r3.readLine();     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L25
            if (r5 == null) goto L9;
            r4 = r4 + 1;
            if (r5.length() == 0) goto L58;
            String[] r6 = r5.split("=");     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L25
            String r7 = r6[0].trim();     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L25
            if (r6.length <= 1) goto L18;
            String r8 = r6[1].trim();     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L25
        L19:
            parseContent(r7, r8, r4);     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L25
            OLog.d(HardwareDetailInfo.TAG, " read end parseValue : " + this.mValue);     // Catch: Throwable -> L21 IOException -> L23 FileNotFoundException -> L25
            goto L58
        L18:
            r8 = null;
            goto L19
        L9:
            r3.close();     // Catch: IOException -> L39
        L49:
        L54:
            goto L48
        L25:
            e = e;
            r1 = r3;
        L35:
            e.printStackTrace();     // Catch: Throwable -> L27
            if (r1 == null) goto L54;
            r1.close();     // Catch: IOException -> L39
        L23:
            e = e;
            r1 = r3;
        L30:
            e.printStackTrace();     // Catch: Throwable -> L27
            if (r1 == null) goto L54;
            r1.close();     // Catch: IOException -> L39
        L21:
            th = th;
            r1 = r3;
        L41:
            if (r1 != null) goto L52;
        L46:
            throw th;
        L52:
            r1.close();     // Catch: IOException -> L44
        L44:
            e = move-exception;
            e.printStackTrace();
            goto L46
        L39:
            e = move-exception;
            e.printStackTrace();
        L34:
            e = e;
        L29:
            e = e;
        L27:
            th = th;
        L48:
            return getNodeCode() + this.mValue;
        }
    }

    private class ProximitySensor extends SensorFile {
        private static final String TYPE_1 = "STK3X1X";
        private static final String TYPE_2 = "LTR578";
        private static final String TYPE_3 = "STK342X";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected int getSensorType() {
            return 8;
        }

        private ProximitySensor(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ ProximitySensor(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected String getNodeCode() {
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.ODIN) == false) goto L7;
            return "L";
        L7:
            if (bytedanceos.util.DeviceType.isOneOf(new bytedanceos.util.DeviceType[]{bytedanceos.util.DeviceType.OSBORN, bytedanceos.util.DeviceType.OCEAN}) == false) goto L10;
            return "P";
        L10:
            return "";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOdinSensorName(String r2) {
            String r3 = r2.toLowerCase();
            if (r3.contains(TYPE_1.toLowerCase()) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L6:
            if (r3.contains(TYPE_2.toLowerCase()) == false) goto L10;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOsbornSensorName(String r2) {
            if (r2.toLowerCase().contains(TYPE_3.toLowerCase()) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.SensorFile
        protected void parseOceanSensorName(String r2) {
            if (r2.toLowerCase().contains(TYPE_3.toLowerCase()) == false) goto L6;
            this.mValue = HardwareDetailInfo.V1;
            return;
        }
    }

    private abstract class SensorFile {
        protected String mValue;
        final /* synthetic */ HardwareDetailInfo this$0;

        protected abstract String getNodeCode();

        protected abstract int getSensorType();

        protected void parseDeltaSensorName(String r1) {
        }

        protected void parseOceanSensorName(String r1) {
        }

        protected void parseOdinSensorName(String r1) {
        }

        protected void parseOsbornSensorName(String r1) {
        }

        protected void parseTridentSensorName(String r1) {
        }

        private SensorFile(HardwareDetailInfo r1) {
            this.this$0 = r1;
            this.mValue = HardwareDetailInfo.INVALID_VALUE;
        }

        /* synthetic */ SensorFile(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void parseSensorName(String r2) {
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.ODIN) == false) goto L6;
            parseOdinSensorName(r2);
            return;
        L6:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OSBORN) == false) goto L9;
            parseOsbornSensorName(r2);
            return;
        L9:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.TRIDENT) == false) goto L12;
            parseTridentSensorName(r2);
            return;
        L12:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OCEAN) == false) goto L15;
            parseOceanSensorName(r2);
            return;
        L15:
            if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.DELTA) == false) goto L22;
            parseDeltaSensorName(r2);
            return;
        }

        public String read() {
            SensorManager r0 = (SensorManager) HardwareDetailInfo.access$1700(this.this$0).getSystemService("sensor");
            if (r0 == null) goto L11;
            List<Sensor> r1 = r0.getSensorList(getSensorType());
            OLog.d(HardwareDetailInfo.TAG, " sensor list : " + r1.size());
            Iterator<Sensor> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L11;
            Sensor r3 = r2.next();
            OLog.d(HardwareDetailInfo.TAG, " sensor is : " + r3 + " with " + getSensorType() + " name : " + r3.getName() + " vensor : " + r3.getVendor());
            String r4 = r3.getName();
            if (TextUtils.isEmpty(r4) == true) goto L6;
            parseSensorName(r4);
        L11:
            return getNodeCode() + this.mValue;
        }
    }

    private class SpeakerNode extends NodeFile {
        private static final String TARGET_KEY = "SPEAKER_MFR";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return ExifInterface.LATITUDE_SOUTH;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private SpeakerNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ SpeakerNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOdinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "yucheng") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "aoyin") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }
    }

    private class TYPECNode extends NodeFile {
        private static final String TARGET_KEY = "TYPEC_MFR";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return "P";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private TYPECNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ TYPECNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOdinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "fairchild") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "pericom") == false) goto L16;
            this.mValue = HardwareDetailInfo.V2;
            return;
        }
    }

    private class UFSCapacityNode extends NodeFile {
        private static final String TARGET_KEY = "ufs_capacity";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return "F";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private UFSCapacityNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ UFSCapacityNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDeltaContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == false) goto L11;
            this.mValue = r3;
            if (this.mValue == null) goto L12;
            this.mValue = this.mValue.replace("GB", "");
            return;
        L12:
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDarwinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == false) goto L11;
            this.mValue = r3;
            if (this.mValue == null) goto L12;
            this.mValue = this.mValue.replace("GB", "");
            return;
        L12:
            return;
        }
    }

    private class UFSNode extends NodeFile {
        private static final String TARGET_KEY = "ufs_manufacturer";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return "U";
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private UFSNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ UFSNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOsbornContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "SAMSUNG") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "Skhynix") == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3.toLowerCase(), EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L20;
            this.mValue = HardwareDetailInfo.V3;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseTridentContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "SAMSUNG") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "SKhynix") == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3, "MICRON") == false) goto L16;
            this.mValue = HardwareDetailInfo.V3;
            return;
        L16:
            if (TextUtils.equals(r3.toLowerCase(), EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L24;
            this.mValue = HardwareDetailInfo.V4;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseOceanContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "SAMSUNG") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "SKhynix") == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3.toLowerCase(), EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L20;
            this.mValue = HardwareDetailInfo.V3;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDeltaContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "SAMSUNG") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "SKhynix") == false) goto L13;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L13:
            if (TextUtils.equals(r3, "WDC") == false) goto L15;
            this.mValue = HardwareDetailInfo.V3;
            return;
        L15:
            this.mValue = r3;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDarwinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == true) goto L7;
            return;
        L7:
            if (TextUtils.equals(r3, "SAMSUNG") == false) goto L10;
            this.mValue = HardwareDetailInfo.V1;
            return;
        L10:
            if (TextUtils.equals(r3, "SKhynix") == false) goto L12;
            this.mValue = HardwareDetailInfo.V2;
            return;
        L12:
            this.mValue = r3;
        }
    }

    private class UFSVersionNode extends NodeFile {
        private static final String TARGET_KEY = "ufs_version";
        final /* synthetic */ HardwareDetailInfo this$0;

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeCode() {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected String getNodeName() {
            return TARGET_KEY;
        }

        private UFSVersionNode(HardwareDetailInfo r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ UFSVersionNode(HardwareDetailInfo r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDeltaContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == false) goto L9;
            this.mValue = r3;
            return;
        }

        @Override // com.android.settings.utils.HardwareDetailInfo.NodeFile
        protected void parseDarwinContent(String r2, String r3, int r4) {
            if (r4 == 1) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, TARGET_KEY) == false) goto L9;
            this.mValue = r3;
            return;
        }
    }

    static /* synthetic */ String access$1600(HardwareDetailInfo r0, String r1) {
        return r0.tcpSendWithRetry(r1);
    }

    static /* synthetic */ Context access$1700(HardwareDetailInfo r0) {
        return r0.mContext;
    }

    public HardwareDetailInfo(Context r3) {
        OLog.d(TAG, "HardwareDetailInfo constructor ");
        this.mContext = r3.getApplicationContext();
    }

    public void writeContent(String r3) {
        OLog.d(TAG, " writeContent : " + r3);
        Settings.Global.putString(this.mContext.getContentResolver(), "hardware_detail_info", r3);
    }

    @Override // java.lang.Runnable
    public void run() {
        StringBuilder r0 = new StringBuilder();
        ArrayList r1 = new ArrayList();
        AnonymousClass1 r4 = null;
        if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.ODIN) == false) goto L6;
        r1.add(new BoardIDNode(this, r4));
        r1.add(new CPUNode(this, r4));
        r1.add(new EMMCNode(this, r4));
        r1.add(new LPDDRNode(this, r4));
        r1.add(new LCDNode(this, r4));
        r1.add(new BatteryNode(this, r4));
        r1.add(new FPNode(this, r4));
        r1.add(new TYPECNode(this, r4));
        r1.add(new SpeakerNode(this, r4));
    L20:
        Iterator r2 = r1.iterator();
    L22:
        if (r2.hasNext() == false) goto L30;
        String r3 = ((NodeFile) r2.next()).read();     // Catch: Exception -> L28
        if (r3 == null) goto L22;
        r0.append(r3);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L30:
        OLog.d(TAG, "HardwareDetail info 1 : " + r0.toString());
        if (bytedanceos.util.DeviceType.isOneOf(new bytedanceos.util.DeviceType[]{bytedanceos.util.DeviceType.DARWIN}) == true) goto L48;
        r0.append("-");
        ArrayList r5 = new ArrayList();
        r5.add(new AccSensor(this, r4));
        r5.add(new CompassSensor(this, r4));
        boolean r8 = bytedanceos.util.DeviceType.isOneOf(new bytedanceos.util.DeviceType[]{bytedanceos.util.DeviceType.TRIDENT, bytedanceos.util.DeviceType.OCEAN});
        boolean r9 = bytedanceos.util.DeviceType.isOneOf(new bytedanceos.util.DeviceType[]{bytedanceos.util.DeviceType.DELTA});
        if (r8 == false) goto L37;
        r5.add(new LightSensor(this, r4));
        if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OCEAN) == false) goto L39;
        r5.add(new ProximitySensor(this, r4));
    L39:
        Iterator r6 = r5.iterator();
    L41:
        if (r6.hasNext() == false) goto L45;
        String r7 = ((SensorFile) r6.next()).read();
        if (r7 == null) goto L41;
        r0.append(r7);
        goto L41
    L45:
        OLog.d(TAG, "HardwareDetail info 2 : " + r0.toString());
        if (bytedanceos.util.DeviceType.isOneOf(new bytedanceos.util.DeviceType[]{bytedanceos.util.DeviceType.ODIN, bytedanceos.util.DeviceType.OSBORN}) == false) goto L54;
        r0.append("-");
        CamearInfoReader r10 = new CamearInfoReader(this);
        String r11 = r10.readFront();
        String r12 = r10.readRear();
        OLog.d(TAG, "HardwareDetail info 3 : " + r11 + " ---- " + r12);
        r0.append(r11);
        r0.append(r12);
        OLog.d(TAG, "HardwareDetail info total : " + r0.toString());
    L54:
        writeContent(r0.toString());
        return;
    L37:
        if (r9 == true) goto L39;
        r5.add(new ProximitySensor(this, r4));
        goto L39
    L48:
        String r13 = SystemProperties.get(FINGERPRINT_PROPERTIES_ID);
        if (TextUtils.equals(r13, FINGERPRINT_GOODIX) == false) goto L52;
        r0.append("F01");
        goto L54
    L52:
        if (TextUtils.equals(r13, FINGERPRINT_OFILM) == false) goto L54;
        r0.append("F02");
        goto L54
    L6:
        if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OSBORN) == false) goto L9;
        r1.add(new BoardIDNode(this, r4));
        r1.add(new CPUNode(this, r4));
        r1.add(new EMMCNode(this, r4));
        r1.add(new LPDDRNode(this, r4));
        r1.add(new UFSNode(this, r4));
        r1.add(new LCDNode(this, r4));
        r1.add(new BatteryNode(this, r4));
        r1.add(new FPNode(this, r4));
        goto L20
    L9:
        if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.TRIDENT) == false) goto L12;
        r1.add(new BoardIDNode(this, r4));
        r1.add(new CPUNode(this, r4));
        r1.add(new LPDDRNode(this, r4));
        r1.add(new UFSNode(this, r4));
        r1.add(new LCDNode(this, r4));
        r1.add(new BatteryNode(this, r4));
        r1.add(new FPNode(this, r4));
        goto L20
    L12:
        if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.OCEAN) == false) goto L15;
        r1.add(new BoardIDNode(this, r4));
        r1.add(new CPUNode(this, r4));
        r1.add(new LPDDRNode(this, r4));
        r1.add(new UFSNode(this, r4));
        r1.add(new LCDNode(this, r4));
        r1.add(new BatteryNode(this, r4));
        r1.add(new FPNode(this, r4));
        goto L20
    L15:
        if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.DELTA) == false) goto L18;
        r1.add(new BoardIDNode(this, r4));
        r1.add(new CPUNode(this, r4));
        r1.add(new LPDDRNode(this, r4));
        r1.add(new UFSNode(this, r4));
        r1.add(new UFSVersionNode(this, r4));
        r1.add(new UFSCapacityNode(this, r4));
        r1.add(new LCDNode(this, r4));
        goto L20
    L18:
        if (bytedanceos.util.DeviceType.is(bytedanceos.util.DeviceType.DARWIN) == false) goto L56;
        r1.add(new BoardIDNode(this, r4));
        r1.add(new CPUNode(this, r4));
        r1.add(new LPDDRNode(this, r4));
        r1.add(new UFSNode(this, r4));
        goto L20
    L56:
        OLog.w(TAG, "no need collect hw info for device " + bytedanceos.util.DeviceType.THIS);
    }

    private String tcpSendWithRetry(String r3) {
        String r0 = tcpSend(r3);
        if ((!TextUtils.isEmpty(r0)) == true) goto L11;
        Thread.sleep(1000);     // Catch: InterruptedException -> L7
    L9:
        r0 = tcpSend(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        if ((!TextUtils.isEmpty(r0)) == true) goto L13;
        OLog.w(TAG, "exe command " + r3 + "return null");
    L13:
        return r0;
    }

    private String tcpSend(String r5) {
        OLog.d(TAG, "CamearInfoReader execute : " + r5 + "      start    ");
        String r4 = LibUtil.TCP_Send(r5, 5000, null);     // Catch: Exception -> L5
    L7:
        OLog.d(TAG, "CamearInfoReader execute : " + r5 + "      end    ");
        return r4;
    L5:
        e = move-exception;
        e.printStackTrace();
        OLog.w(TAG, "failed get front camera info, e = : " + e.getMessage());
        r4 = "";
        goto L7
    }

    public static boolean isValid(Context r3) {
        String r4 = Settings.Global.getString(r3.getContentResolver(), "hardware_detail_info");
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
        OLog.d(TAG, "invalid " + r4);
    L9:
        return r0;
    L5:
        if (r4.contains(INVALID_VALUE) == true) goto L7;
        r0 = true;
        goto L7
    }
}
