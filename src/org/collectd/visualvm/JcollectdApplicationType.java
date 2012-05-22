/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.collectd.visualvm;

import com.sun.tools.visualvm.application.type.ApplicationType;
import java.awt.Image;
import org.openide.util.ImageUtilities;

public class JcollectdApplicationType extends ApplicationType {

    protected final int appPID;

    public JcollectdApplicationType(int pid) {
        appPID = pid;
    }

    @Override
    public String getName() {
        return "Jcollectd";
    }

    @Override
    public String getVersion() {
        return "0.1";
    }

    @Override
    public String getDescription() {
        return "Application type for Jcollectd";
    }

    @Override
    public Image getIcon() {
        return ImageUtilities.loadImage("org/collectd/visualvm/resources/collectd.png");
    }
}
