/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.collectd.visualvm;

import com.sun.tools.visualvm.application.Application;
import com.sun.tools.visualvm.application.jvm.Jvm;
import com.sun.tools.visualvm.application.type.ApplicationType;
import com.sun.tools.visualvm.application.type.MainClassApplicationTypeFactory;
import java.util.regex.Pattern;

public class JcollectdApplicationTypeFactory extends MainClassApplicationTypeFactory {

    private static final Pattern pattern =
            Pattern.compile("jcollectd-[0-9]+\\.[0-9]+\\.[0-9][^.]*\\.jar", Pattern.CASE_INSENSITIVE);

    @Override
    public ApplicationType createApplicationTypeFor(Application app, Jvm jvm, String mainClass) {
        if (pattern.matcher(mainClass).matches()) {
            return new JcollectdApplicationType(app.getPid());
        }
        return null;
    }
}
