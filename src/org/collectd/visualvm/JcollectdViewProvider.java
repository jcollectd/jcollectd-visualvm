/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.collectd.visualvm;

import com.sun.tools.visualvm.application.Application;
import com.sun.tools.visualvm.core.ui.DataSourceView;
import com.sun.tools.visualvm.core.ui.DataSourceViewProvider;
import com.sun.tools.visualvm.core.ui.DataSourceViewsManager;

/**
 *
 * @author andrus
 */
public class JcollectdViewProvider extends DataSourceViewProvider<Application> {

    private static DataSourceViewProvider<Application> instance =  new JcollectdViewProvider();

    @Override
    public boolean supportsViewFor(Application application) {
        //Always shown:
        return true;
    }

    @Override
    public synchronized DataSourceView createView(final Application application) {
        return new JcollectdView(application);

    }
    
    static void initialize() {
        DataSourceViewsManager.sharedInstance().addViewProvider(instance, Application.class);
    }
    
    static void unregister() {
        DataSourceViewsManager.sharedInstance().removeViewProvider(instance);
    }
    
}