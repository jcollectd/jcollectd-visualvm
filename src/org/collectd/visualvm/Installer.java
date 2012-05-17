/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.collectd.visualvm;

import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        JcollectdViewProvider.initialize();
    }

    @Override
    public void uninstalled() {
        JcollectdViewProvider.unregister();
    }
}
