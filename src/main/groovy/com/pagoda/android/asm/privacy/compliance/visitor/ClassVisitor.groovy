package com.pagoda.android.asm.privacy.compliance.visitor

import com.pagoda.android.asm.privacy.compliance.ext.ComplianceConfig
import com.pagoda.android.asm.privacy.compliance.utils.MethodFieldUtils
import com.pagoda.android.asm.privacy.compliance.utils.OpcodesUtils
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Type

class ClassVisitor extends org.objectweb.asm.ClassVisitor {
    private org.objectweb.asm.ClassVisitor classVisitor
    private String[] mInterfaces
    private String mClassName
    private ComplianceConfig mComplianceConfig

    ClassVisitor(org.objectweb.asm.ClassVisitor classVisitor, ComplianceConfig config) {
        super(OpcodesUtils.ASM_VERSION, classVisitor)
        this.classVisitor = classVisitor
        this.mComplianceConfig = config

    }
    /**
     * @param version 类版本
     * @param access 修饰符
     * @param name 类名
     * @param signature 泛型信息
     * @param superName 父类
     * @param interfaces 实现的接口
     */
    @Override
    void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.mInterfaces = interfaces
        this.mClassName = name
        super.visit(version, access, name, signature, superName, interfaces)
    }
    /**
     * 扫描类的方法进行调用
     * @param access 修饰符
     * @param name 方法名字
     * @param descriptor 方法签名
     * @param signature 泛型信息
     * @param exceptions 抛出的异常
     * @return
     */
    @Override
    MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
        if (mComplianceConfig.getStatusEnum() == MethodFieldUtils.StatusEnum.METHOD_STATE_REPLACE) {
            methodVisitor = new MonitorMethodCalledReplaceAdapter(methodVisitor, access, name, descriptor, classVisitor, mClassName, mComplianceConfig)
        }
        return methodVisitor
    }
}
