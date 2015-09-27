package gameMaker.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccordionUI extends JPanel implements ActionListener {

	private AccordionUI accordionUI;

	private static final long serialVersionUID = -2760245005186933366L;

	private JPanel topPanel = new JPanel(new GridLayout(2, 2));

	private JPanel bottomPanel = new JPanel(new GridLayout(2, 2));

	private Map<String, BarInfo> bars = new LinkedHashMap<String, BarInfo>();

	private int visibleBar = 0;

	private JComponent visibleComponent = null;

	public AccordionUI() {
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(bottomPanel, BorderLayout.SOUTH);

	}

	public void addBar(String name, JComponent component) {
		BarInfo barInfo = new BarInfo(name, component);
		barInfo.getButton().addActionListener(this);
		this.bars.put(name, barInfo);
		render();
	}

	public void addBar(String name, Icon icon, JComponent component) {
		BarInfo barInfo = new BarInfo(name, icon, component);
		barInfo.getButton().addActionListener(this);
		this.bars.put(name, barInfo);
		render();
	}

	public void removeBar(String name) {
		this.bars.remove(name);
		render();
	}

	public int getVisibleBar() {
		return this.visibleBar;
	}

	public void setVisibleBar(int visibleBar) {
		if (visibleBar > 0 && visibleBar < this.bars.size() - 1) {
			this.visibleBar = visibleBar;
			render();
		}
	}

	public void render() {
		// Compute how many bars we are going to have where
		int totalBars = this.bars.size();
		int topBars = this.visibleBar + 1;
		int bottomBars = totalBars - topBars;

		// Get an iterator to walk through out bars with
		Iterator<String> itr = this.bars.keySet().iterator();

		// Render the top bars: remove all components, reset the GridLayout to
		// hold to correct number of bars, add the bars, and "validate" it to
		// cause it to re-layout its components
		this.topPanel.removeAll();
		GridLayout topLayout = (GridLayout) this.topPanel.getLayout();
		topLayout.setRows(topBars);
		BarInfo barInfo = null;
		for (int i = 0; i < topBars; i++) {
			String barName = (String) itr.next();
			barInfo = (BarInfo) this.bars.get(barName);
			this.topPanel.add(barInfo.getButton());
		}
		this.topPanel.validate();

		// Render the center component: remove the current component (if there
		// is one) and then put the visible component in the center of this
		// panel
		if (this.visibleComponent != null) {
			this.remove(this.visibleComponent);
		}
		this.visibleComponent = barInfo.getComponent();
		this.add(visibleComponent, BorderLayout.CENTER);

		// Render the bottom bars: remove all components, reset the GridLayout
		// to
		// hold to correct number of bars, add the bars, and "validate" it to
		// cause it to re-layout its components
		this.bottomPanel.removeAll();
		GridLayout bottomLayout = (GridLayout) this.bottomPanel.getLayout();
		bottomLayout.setRows(bottomBars);
		for (int i = 0; i < bottomBars; i++) {
			String barName = (String) itr.next();
			barInfo = (BarInfo) this.bars.get(barName);
			this.bottomPanel.add(barInfo.getButton());
		}
		this.bottomPanel.validate();

		// Validate all of our components: cause this container to re-layout its
		// subcomponents
		validate();
	}

	/**
	 * Invoked when one of our bars is selected
	 */
	public void actionPerformed(ActionEvent e) {
		int currentBar = 0;
		for (Iterator<String> i = this.bars.keySet().iterator(); i.hasNext();) {
			String barName = (String) i.next();
			BarInfo barInfo = (BarInfo) this.bars.get(barName);
			if (barInfo.getButton() == e.getSource()) {
				// Found the selected button
				this.visibleBar = currentBar;
				render();
				return;
			}
			currentBar++;
		}
	}

	/**
	 * Dummy Panel creator.Will not be required once we have Panels
	 * Implemented.Created it to have a running UI.
	 */
	public static JPanel getDummyPanel(String name) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel(name, JLabel.CENTER));
		return panel;
	}

	/**
	 * Debug test...
	 */

	public void acordionMaker() {

		this.addBar("Sprite Selector", getDummyPanel("Onexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxo"));
		this.addBar("Choose Event", getDummyPanel("Two"));
		this.addBar("Select Action", getDummyPanel("Three"));
		this.addBar("Fix Configuration", getDummyPanel("Four"));
		this.addBar("Five", getDummyPanel("Five"));
		this.addBar("Six", getDummyPanel("Five"));
		this.setVisibleBar(2);

	}

	class BarInfo {

		private String name;

		private JButton button;

		private JComponent component;

		public BarInfo(String name, JComponent component) {
			this.name = name;
			this.component = component;
			this.button = new JButton(name);
		}

		public BarInfo(String name, Icon icon, JComponent component) {
			this.name = name;
			this.component = component;
			this.button = new JButton(name, icon);
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public JButton getButton() {
			return this.button;
		}

		public JComponent getComponent() {
			return this.component;
		}

	}

	public JPanel getAccordionUI() {
		return accordionUI;
	}
}
