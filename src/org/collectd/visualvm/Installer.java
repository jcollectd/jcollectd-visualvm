package org.collectd.visualvm;

import com.sun.tools.visualvm.application.type.ApplicationTypeFactory;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {
    
    private final static JcollectdApplicationTypeFactory INSTANCE = new JcollectdApplicationTypeFactory();

    @Override
    public void restored() {
        ApplicationTypeFactory.getDefault().registerProvider(INSTANCE);
    }

    @Override
    public void uninstalled() {
        ApplicationTypeFactory.getDefault().unregisterProvider(INSTANCE);
    }
}
