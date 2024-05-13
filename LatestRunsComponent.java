import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class LatestRunsComponent extends JComponent implements ActionListener {
	private JLabel label;
	private DefaultListModel<String> data;
	private JList<String> list;
	private ScoreManager score;
	private int count;
	
	private boolean hasAddedScore;
	
	public LatestRunsComponent(ScoreManager score)
	{
		this.score = score;
		count = 0;
		
		setLayout(new BorderLayout());
		label = new JLabel("Latest Runs");
		label.setBackground(Color.pink);
		data = new DefaultListModel<String>();
		list = new JList<String>(data);
		add(list, BorderLayout.CENTER);
		add(label, BorderLayout.NORTH);
		list.setEnabled(false);
		this.setFocusable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
	
	public void newScore(int points)
	{
		if(count <= 2) {
			if(!hasAddedScore) {
				data.addElement((count+1) + ":" + "  " + Integer.toString(points));
				hasAddedScore = true;
				count++;
			}
		} else {
			data.clear();
			count = 0;
			data.addElement((count+1) + ":" + "  " + Integer.toString(points));
		}
	}
	
	public void setFlag_hasAddedScore(boolean x) {
		this.hasAddedScore = x;
	}
	
	public boolean getFlag_hasAddedScore() {
		return hasAddedScore;
	}
	
}
