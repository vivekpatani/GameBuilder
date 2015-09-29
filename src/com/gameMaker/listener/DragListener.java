package com.gameMaker.listener;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JLabel;

public class DragListener implements DragGestureListener {
	
	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		JLabel label = (JLabel) event.getComponent();
		final Icon ico = label.getIcon();

		Transferable transferable = new Transferable() {
			@Override
			public DataFlavor[] getTransferDataFlavors() {
				return new DataFlavor[] { DataFlavor.imageFlavor };
			}

			@Override
			public boolean isDataFlavorSupported(DataFlavor flavor) {
				if (!isDataFlavorSupported(flavor)) {
					return false;
				}
				return true;
			}

			@Override
			public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
				return ico;
			}
		};
		event.startDrag(null, transferable);
	}
}
