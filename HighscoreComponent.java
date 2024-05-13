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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HighscoreComponent extends JComponent implements ActionListener {
	private JButton button;
	private JTextField input;
	private ScoreManager score;
	private DefaultListModel<String> data;
	
	public HighscoreComponent(ScoreManager score){
		
		this.score = score;
		
		data = new DefaultListModel<String>();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setFocusable(false);
		
		JLabel label = new JLabel("HighScore");
		add(label, BorderLayout.NORTH);
		
		JList<String> list = new JList<String>(data);
		list.setEnabled(false);
		list.setAlignmentX(LEFT_ALIGNMENT);
		add(list, BorderLayout.NORTH);
		
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.setAlignmentX(LEFT_ALIGNMENT);
		inputPanel.add(Box.createVerticalGlue());
		
		input = new JTextField();
		int inputMaxWidth = 120;
		int inputMaxHeight = 80;
		input.setMaximumSize(new Dimension(inputMaxWidth, inputMaxHeight));
		inputPanel.add(input);
		
		button = new JButton("Add");
		button.addActionListener(this);
		button.setAlignmentX(LEFT_ALIGNMENT);
		inputPanel.add(button);
		
		add(inputPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button) {
			newScore(score.getScore());
			button.setFocusable(false);
		}
	}
	
	public void newScore(int points){
		int maxChars = 3;
		if(input.getText().length() == maxChars) {
			data.addElement(data.getSize()+1 + ":" + input.getText() + "  " + points);
			input.setText("");
		}
	}
	
}
