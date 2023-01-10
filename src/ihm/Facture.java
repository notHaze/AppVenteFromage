package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import metier.Client;

public class Facture extends JDialog {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3669137199440499639L;
	private JButton btnQuitter;

	public Facture(Client client, int transport) {
		setBounds(100, 100, 654, 500);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnQuitter = new JButton("Quitter");
				constructeurBoutonQuitter();
				btnQuitter.setActionCommand("OK");
				buttonPane.add(btnQuitter);
				getRootPane().setDefaultButton(btnQuitter);
			}
		}
		{
			JScrollPane scrollPaneFacture = new JScrollPane();
			getContentPane().add(scrollPaneFacture, BorderLayout.CENTER);
			{
				JTextPane ContenuFacture = new JTextPane();
				ContenuFacture.setEditable(false);
				ContenuFacture.setText("Merci de votre commande sur notre site !\n\n"+
						Accueil.getPanier().toString(transport)+"\n"+client.toString()+"\n\n"
						+"En espérant vous revoir bientôt !");
				scrollPaneFacture.setViewportView(ContenuFacture);
			}
		}
	}
	
	private void constructeurBoutonQuitter() {
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
