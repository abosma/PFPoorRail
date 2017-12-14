package controller;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.IItem;
import Model.RichRail;
import Model.Train;

public class ChangeObserver extends Observer {

	// private Graphics _graphics;
	private JPanel drawPanel;

	public ChangeObserver(RichRail rr, JPanel panel) {
		this.rr = rr;
		this.rr.attach(this);
		this.drawPanel = panel;
	}

	@Override
	public void update() {
		drawPanel.removeAll();
		if (RichRail.getInstance().getAllItems() != null) {
			ArrayList<IItem> items = RichRail.getInstance().getAllItems();
			for (IItem item : items) {
				System.out.println(item.getName());
				JLabel labeltrainimage = new JLabel(new ImageIcon(item.getImage()));
				drawPanel.add(labeltrainimage);

				if (((Train) item).getWagons().isEmpty()) {
				} else {
					for (IItem i : ((Train) item).getWagons()) {
						JLabel labelwagonimage = new JLabel(new ImageIcon(i.getImage()));
						drawPanel.add(labelwagonimage);
					}
				}
			}
		} else {
			return;
		}
	}
}
