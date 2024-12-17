package com.pagoda.android.asm.privacy.compliance

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.pagoda.android.asm.privacy.compliance.ext.ComplianceConfig
import com.pagoda.android.asm.privacy.compliance.transform.MonitorTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

class PrivacyCompliancePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        ComplianceConfig extension = project.extensions.create('complianceConfig', ComplianceConfig)
        BaseExtension appExtension = project.extensions.findByType(BaseExtension.class)
        LibraryExtension
        def transform = new MonitorTransform(project)
        appExtension.registerTransform(transform)
        project.afterEvaluate {
            new CelledManager().init()
            extension.convertConfig()
            transform.setMonitorConfig(extension)
        }
    }
}