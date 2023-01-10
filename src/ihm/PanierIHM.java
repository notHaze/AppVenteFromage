package ihm;


import javax.swing.JFrame;


public class PanierIHM extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4023705241027355685L;

	/**
	 * Create the frame.
	 */
	public PanierIHM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 451);
		setContentPane(new PanelPanier(this));
		this.repaint();
		this.validate();
		
	}

}
