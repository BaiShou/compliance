package com.pagoda.android.asm.privacy.compliance.visitor


import com.pagoda.android.asm.privacy.compliance.entity.MethodCalledBean
import com.pagoda.android.asm.privacy.compliance.ext.ComplianceConfig
import com.pagoda.android.asm.privacy.compliance.visitor.base.MonitorDefaultMethodAdapter
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import com.pagoda.android.asm.privacy.compliance.config.BaseMethodCalled

class MonitorMethodCalledReplaceAdapter extends MonitorDefaultMethodAdapter {
    private int mAccess
    private ClassVisitor classVisitor
    private String mClassName
    private ComplianceConfig mComplianceConfig
    /**
     * Constructs a new {@link org.objectweb.asm.commons.AdviceAdapter}.
     *
     * @param mv @param access the method's access flags (see {@link org.objectweb.asm.Opcodes}).
     * @param name the method's name.
     * @param desc
     */
    MonitorMethodCalledReplaceAdapter(MethodVisitor mv, int access, String name, String desc, ClassVisitor classVisitor, String className, ComplianceConfig complianceConfig) {
        super(mv, access, name, desc)
        this.mAccess = access
        this.classVisitor = classVisitor
        this.mClassName = className
        this.mComplianceConfig = complianceConfig
    }

    @Override
    void visitMethodInsn(int opcodeAndSource, String owner, String name, String descriptor, boolean isInterface) {
        HashMap<String, MethodCalledBean> methodReplaceBeans = BaseMethodCalled.methodCalledBeans
        String desc = owner + name + descriptor
        if (!mComplianceConfig.whiteList.contains(mClassName) && methodReplaceBeans.containsKey(desc)) {
            println("调用方法的class:" + mClassName + ",方法的名字:" + name + ",方法的描述符：" + descriptor)
            MethodCalledBean bean = methodReplaceBeans.get(desc)
            try {
                super.visitMethodInsn(bean.newOpcode, bean.newMethodOwner, bean.newMethodName, bean.newMethodDescriptor.get(descriptor), false)
            } catch (Exception e) {
                println("--配置错误触发异常--${descriptor}->${bean.toString()}->${e.getMessage()}")
            }
        } else {
            super.visitMethodInsn(opcodeAndSource, owner, name, descriptor, isInterface)
        }
    }
}