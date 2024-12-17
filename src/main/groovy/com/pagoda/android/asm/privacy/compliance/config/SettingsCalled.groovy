package com.pagoda.android.asm.privacy.compliance.config

import com.pagoda.android.asm.privacy.compliance.entity.MethodCalledBean
import com.pagoda.android.asm.privacy.compliance.utils.MethodFieldUtils

/**
 * 系统类Settings配置
 */
class SettingsCalled extends BaseMethodCalled {
    private static String SETTINGS_SECURE_CLASS = 'android/provider/Settings$Secure'
    private static String GET_STRING_METHOD_NAME = "getString"

    @Override
    public void initConfig() {

        /**
         * 获取AndroidId
         */
        HashMap<String, String> androidIdMap = new HashMap<>()
        androidIdMap.put(MethodFieldUtils.CONTENTRESOLVER_STRING_DESC, MethodFieldUtils.CONTENTRESOLVER_STRING_DESC)
        MethodCalledBean androidId = new MethodCalledBean(
            SETTINGS_SECURE_CLASS,
            GET_STRING_METHOD_NAME,
            MethodFieldUtils.CONTENTRESOLVER_STRING_RETURN_STRING_DESC,
            NEW_METHOD_OWNER,
            GET_STRING_METHOD_NAME,
            STATIC_OPCODE,
            androidIdMap
        )
        addMethodCalledBean(androidId)

    }
}