package com.intzi.swing_countdown;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class Test extends JFrame implements ActionListener{

	private JTextField numberField;
	private JButton startButton;


	// This is the correct way to make things threaded in Swing
	// A SwingWorker object is used
	// and the 'worker' code is but in the doInBackground method
	// we can worry more about the details later...
	public class CounterWorker extends SwingWorker<Void, Integer> {
		private Integer startVal;
		public JTextField outputField;
		public CounterWorker(Integer s,JTextField tf) {
			this.startVal = s;
			this.outputField = tf;
		}
		public Void doInBackground() {
			System.out.println("Do in background called");
			for(Integer i=this.startVal;i>=0;i--) {
				try {
					Thread.sleep(200);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				publish(i);
			}
			return null;
		}
		protected void process(List<Integer> vals) {
			System.out.println("Process called: "+vals.size());
			int len = vals.size();
			this.outputField.setText("" + vals.get(len-1));
		}
	}


	public Test() {
		this.setSize(500,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		numberField = new JTextField("50",20);
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		
		JPanel contentPanel = new JPanel();
		contentPanel.add(numberField);
		contentPanel.add(startButton);
		this.add(contentPanel);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		int startVal = Integer.parseInt(this.numberField.getText());
		// Create the new worker object and execute it
		new CounterWorker(startVal,this.numberField).execute();
	}	

}
