package com.pagoda.android.asm.privacy.compliance.utils

class MethodFieldUtils {

    enum StatusEnum {
        METHOD_STATE_NORMAL(0),
        METHOD_STATE_REPLACE(1)
        private int value

        StatusEnum(int value) {
            this.value = value
        }

        int getValue() {
            return value
        }
    }
    //描述符参考blog.csdn.net/Xxy605/article/details/123111982
    //desc
    static final String EMPTY_BYTE_ARRAY_DESC = "()[B"
    static final String NEW_EMPTY_BYTE_ARRAY_DESC = "(Ljava/net/NetworkInterface;)[B"
    static final String EMPTY_STRING_DESC = "()Ljava/lang/String;"
    static final String EMPTY_LIST_DESC = "()Ljava/util/List;"
    static final String NEW_EMPTY_LIST_DESC = "(Landroid/net/wifi/WifiManager;)Ljava/util/List;"
    static final String NEW_STRING_WIFI_INFO_DESC = "(Landroid/net/wifi/WifiInfo;)Ljava/lang/String;"
    static final String NEW_EMPTY_STRING_TELEPHONY_DESC = "(Landroid/telephony/TelephonyManager;)Ljava/lang/String;"
    static final String INT_STRING_DESC = "(I)Ljava/lang/String;"
    static final String NEW_INT_STRING_TELEPHONY_DESC = "(Landroid/telephony/TelephonyManager;I)Ljava/lang/String;"
    static String[] EMPTY_INT_RETURN_STRING_DESC = [EMPTY_STRING_DESC, INT_STRING_DESC]
    static final String EMPTY_WIFI_INFO_DESC = "()Landroid/net/wifi/WifiInfo;"
    static final String NEW_WIFI_INFO_WIFI_INFO_DESC = "(Landroid/net/wifi/WifiManager;)Landroid/net/wifi/WifiInfo;"
    static String[] EMPTY_RETURN_WIFI_INFO_DESC = [EMPTY_WIFI_INFO_DESC]
    static String[] EMPTY_RETURN_STRING_DESC = [EMPTY_STRING_DESC]
    static String[] EMPTY_RETURN_BYTE_ARRAY_DESC = [EMPTY_BYTE_ARRAY_DESC]
    static final String EMPTY_INT_DESC = "()I"
    static final String NEW_INT_WIFI_INFO_DESC = "(Landroid/net/wifi/WifiInfo;)I"
    static final String NEW_EMPTY_INT_NETWORK_INFO_DESC = "(Landroid/net/NetworkInfo;)I"
    static String[] EMPTY_RETURN_INT_DESC = [EMPTY_INT_DESC]
    static final String CONTENTRESOLVER_STRING_DESC = "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;"
    static String[] CONTENTRESOLVER_STRING_RETURN_STRING_DESC = [CONTENTRESOLVER_STRING_DESC]
    static String[] EMPTY_RETURN_LIST = [EMPTY_LIST_DESC]


}