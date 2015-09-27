package gameMaker.util;

import java.awt.Component;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

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

                System.out.println("Image supported, adding to panel");
                
                if (transferImage != null) {
                
                	transferLabel = new JLabel(transferImage);
                	transferLabel.setBounds((int) dropPoint.getX(), (int) dropPoint.getY(), ySpace*2, ySpace);
                    panel.add(transferLabel);
                    panel.revalidate();
                    panel.repaint();
                    
                    System.out.println("Added");
                    
                    event.dropComplete(true);
                }
            } 
            else {
                event.rejectDrop();
            }
        } 
		catch (Exception e) {
            log.error("Error : ", e);
            event.rejectDrop();
        }
    }
}
