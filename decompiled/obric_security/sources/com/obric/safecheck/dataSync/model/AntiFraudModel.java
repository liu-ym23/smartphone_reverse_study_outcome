package com.obric.safecheck.dataSync.model;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import com.google.gson.annotations.SerializedName;
import com.obric.matrix.sdk.network.BaseResponseModel;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AntiFraudModel {

    public static class AntiFraudFile {

        @SerializedName("download_url")
        public String downloadURL;

        @SerializedName("end_day")
        public String endDay;

        @SerializedName("file_name")
        public String fileName;

        @SerializedName(Utils.INTENT_KEY_INDEX)
        public long index;

        @SerializedName("md5")
        public String md5;

        @SerializedName(PerfConsts.PERF_DISK_FILE_SIZE)
        public String size;

        @SerializedName("start_day")
        public String startDay;

        public AntiFraudFile() {
        }
    }

    public static class GetAntiFraudDataByDateTimeReq {

        @SerializedName("date_time")
        public String dateTime;

        public GetAntiFraudDataByDateTimeReq() {
        }
    }

    public static class GetAntiFraudDataByDateTimeResp extends BaseResponseModel {

        @SerializedName(AlogMonitor.ALOG_RESULT_CODE)
        public long code;

        @SerializedName("file_list")
        public List<AntiFraudFile> fileList;

        @SerializedName("message")
        public String message;

        public GetAntiFraudDataByDateTimeResp() {
        }
    }

    public AntiFraudModel() {
    }
}
