package com.pagoda.android.asm.privacy.compliance.ext

import com.pagoda.android.asm.privacy.compliance.utils.MethodFieldUtils

class ComplianceConfig {
    /**
     * 是否启用插件
     */
    public boolean disablePlugin = false
    /**
     * 是否开启增量更新
     */
    public boolean isIncremental = false
    /**
     * 隐私方法方法的状态
     * @params 1 代表替换方法体
     * @params 0 不替换
     */
    public int methodStatus = 0
    /**
     * 白名单列表，处于白名单的方法不会根据{@link #methodStatus}被处理
     */
    public List<String> whiteList = []

    /***
     * hook代理方法类
     */
    public String delegateHookMethodClass

    private MethodFieldUtils.StatusEnum statusEnum = MethodFieldUtils.StatusEnum.METHOD_STATE_NORMAL

    public MethodFieldUtils.StatusEnum getStatusEnum() {
        return statusEnum
    }

    void convertConfig() {
        println("当前方法的Status:" + methodStatus)
        for (int i = 0; i < whiteList.size(); i++) {
            whiteList.set(i, whiteList.get(i).replace(".", "/"))
        }
        if (methodStatus == MethodFieldUtils.StatusEnum.METHOD_STATE_REPLACE.value) {
            statusEnum = MethodFieldUtils.StatusEnum.METHOD_STATE_REPLACE
        } else {
            statusEnum = MethodFieldUtils.StatusEnum.METHOD_STATE_NORMAL
        }
    }

    @Override
    String toString() {
        return "MonitorPlugin:\n\t是否开启增量更新:${!isIncremental},\n\t白名单是:${Arrays.toString(whiteList)}\n]"

    }
}