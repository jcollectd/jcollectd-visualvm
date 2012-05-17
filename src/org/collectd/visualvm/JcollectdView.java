/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.collectd.visualvm;

import com.sun.tools.visualvm.application.Application;
import com.sun.tools.visualvm.core.ui.DataSourceView;
import com.sun.tools.visualvm.core.ui.components.DataViewComponent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import org.openide.util.ImageUtilities;

/**
 *
 * @author andrus
 */
public class JcollectdView extends DataSourceView {

    private DataViewComponent dvc;
    //Reusing an image from the sources:
    private static final String IMAGE_PATH = "com/sun/tools/visualvm/application/views/resources/monitor.png"; // NOI18N

    public JcollectdView(Application application) {
        super(application, "JCollectd Monitor", new ImageIcon(ImageUtilities.loadImage(IMAGE_PATH, true)).getImage(), 60, false);
    }

    @Override
    protected DataViewComponent createComponent() {

        //Data area for master view:
        JEditorPane generalDataArea = new JEditorPane();
        generalDataArea.setBorder(BorderFactory.createEmptyBorder(14, 8, 14, 8));

        //Panel, which we'll reuse in all four of our detail views for this sample:
        JPanel panel = new JPanel();

        //Master view:
        DataViewComponent.MasterView masterView = new DataViewComponent.MasterView
                ("JCollectd Monitor", "Blah balh blah-blah ...", generalDataArea);

        //Configuration of master view:
        DataViewComponent.MasterViewConfiguration masterConfiguration = 
                new DataViewComponent.MasterViewConfiguration(false);

        //Add the master view and configuration view to the component:
        dvc = new DataViewComponent(masterView, masterConfiguration);

        //Add configuration details to the component, which are the show/hide checkboxes at the top:
        dvc.configureDetailsArea(new DataViewComponent.DetailsAreaConfiguration(
                "Cpu", true), DataViewComponent.TOP_LEFT);
        dvc.configureDetailsArea(new DataViewComponent.DetailsAreaConfiguration(
                "Memory", true), DataViewComponent.TOP_RIGHT);
        dvc.configureDetailsArea(new DataViewComponent.DetailsAreaConfiguration(
                "Details", true), DataViewComponent.BOTTOM_LEFT);
        dvc.configureDetailsArea(new DataViewComponent.DetailsAreaConfiguration(
                "Processes", true), DataViewComponent.BOTTOM_RIGHT);

        //Add detail views to the component:
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Cpu", null, 10, panel, null), DataViewComponent.TOP_LEFT);
        
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Memory", null, 10, panel, null), DataViewComponent.TOP_RIGHT);
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Memory I/O", null, 10, panel, null), DataViewComponent.TOP_RIGHT);
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Swap", null, 10, panel, null), DataViewComponent.TOP_RIGHT);
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Swap I/0", null, 10, panel, null), DataViewComponent.TOP_RIGHT);
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Disk", null, 10, panel, null), DataViewComponent.TOP_RIGHT);
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Disc I/O", null, 10, panel, null), DataViewComponent.TOP_RIGHT);
        
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Network", null, 10, panel, null), DataViewComponent.BOTTOM_LEFT);
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Processes", null, 10, panel, null), DataViewComponent.BOTTOM_RIGHT);
        dvc.addDetailsView(new DataViewComponent.DetailsView(
                "Fork rate", null, 10, panel, null), DataViewComponent.BOTTOM_RIGHT);

        return dvc;

    }
    
}
