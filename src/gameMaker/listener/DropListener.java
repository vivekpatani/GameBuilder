package gameMaker.listener;

import java.awt.Component;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import gameMaker.main.ControlView;
import gameMaker.util.Constants;

public class DropListener extends DropTargetAdapter implements Constants {

	private final static Logger log = Logger.getLogger(DropListener.class);
	
	private DropTarget dropTarget;
	private JPanel panel;
	
	private JLabel transferLabel;
	
	public DropListener (JPanel panel) {
		this.panel = panel;
		dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);
	}
	
	@Override
	public void drop (DropTargetDropEvent event) {
		try {
			DropTarget test = (DropTarget) event.getSource();
            Component component = (Component) test.getComponent();
            Point dropPoint = component.getMousePosition();
            Transferable tr = event.getTransferable();

            if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                ImageIcon transferImage = (ImageIcon) tr.getTransferData(DataFlavor.imageFlavor);

                log.info("Image supported, adding to panel");
                
                if (transferImage != null) {
                	
                	transferLabel = new JLabel(transferImage);
                	transferLabel.setBounds((int) dropPoint.getX(), (int) dropPoint.getY(), transferImage.getIconWidth(), transferImage.getIconHeight());
                    panel.add(transferLabel);
                    panel.revalidate();
                    panel.repaint();
                    
                    log.info("Added to panel");
                    
                    event.dropComplete(true);
                }
            } 
            else {
                event.rejectDrop();
            }
        } 
		catch (Exception e) {
            log.error ("Error : ", e);
            event.rejectDrop();
        }
    }
}
