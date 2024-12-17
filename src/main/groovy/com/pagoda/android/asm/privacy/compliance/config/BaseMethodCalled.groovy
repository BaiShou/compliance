package com.pagoda.android.asm.privacy.compliance.config

import com.pagoda.android.asm.privacy.compliance.entity.MethodCalledBean
import org.objectweb.asm.Opcodes;

/**
 * created by wanggang
 * <p>
 * on 2022/8/2
 *
 * @author wanggang
 */
abstract class BaseMethodCalled {
    public final static HashMap<String, MethodCalledBean> methodCalledBeans = new HashMap<>()

    protected static final String NEW_METHOD_OWNER = "com/pagoda/android/privacy_compliance/ReplaceMethodUtils"
    protected static final int STATIC_OPCODE = Opcodes.INVOKESTATIC

    protected static void addMethodCalledBean(MethodCalledBean methodCalledBean) {
        for (String desc : methodCalledBean.getMethodDescriptor()) {
            methodCalledBeans.put(methodCalledBean.getMethodOwner() + methodCalledBean.getMethodName() + desc, methodCalledBean)
        }
    }

    /**
     * 初始化方法的配置
     */
    public abstract void initConfig()


}
