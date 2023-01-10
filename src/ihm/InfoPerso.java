package ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Client;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;

public class InfoPerso extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7949394295634870266L;
	private JTextField textFieldNomClient;
	private JTextField textFieldPrenomClient;
	private JTextField textFieldAdresse1Client;
	private JTextField textFieldAdresse2Client;
	private JTextField textFieldCodePostalClient;
	private JTextField textFieldVille;
	private JTextField textFieldTelephoneClient;
	private JTextField textFieldMailClient;
	private AbstractButton btnValidation;
	private Client client;
	private AbstractButton btnAnnulation;
	
	private JFrame frame;
	private JLabel erreurLabel;

	/**
	 * Create the frame.
	 */
	public InfoPerso(JFrame frame, int transport) {
		this.frame=frame;
		setBorder(new EmptyBorder(6, 9, 0, 0));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelEntete = new JPanel();
		panelEntete.setBorder(new EmptyBorder(20, 8, 0, 8));
		add(panelEntete, BorderLayout.NORTH);
		panelEntete.setLayout(new GridLayout(2, 2, 10, 20));
		
		JLabel labelValidation = new JLabel("Validation du panier");
		labelValidation.setForeground(Color.LIGHT_GRAY);
		labelValidation.setHorizontalAlignment(SwingConstants.CENTER);
		labelValidation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelEntete.add(labelValidation);
		
		JLabel labelCoordonnees = new JLabel("Coordonnées");
		labelCoordonnees.setHorizontalAlignment(SwingConstants.CENTER);
		labelCoordonnees.setForeground(Color.BLACK);
		labelCoordonnees.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelEntete.add(labelCoordonnees);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		panelEntete.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		panelEntete.add(separator_1);
		
		JPanel panelValidation = new JPanel();
		FlowLayout fl_panelValidation = (FlowLayout) panelValidation.getLayout();
		fl_panelValidation.setAlignment(FlowLayout.RIGHT);
		this.add(panelValidation, BorderLayout.SOUTH);
		
		btnValidation = new JButton("Valider");
		btnValidation.setBackground(Color.DARK_GRAY);
		btnValidation.setForeground(Color.WHITE);
		constructeurBoutonValider(transport);
		panelValidation.add(btnValidation);
		
		btnAnnulation = new JButton("Annuler");
		constructeurBoutonAnnuler();
		panelValidation.add(btnAnnulation);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(new EmptyBorder(5, 0, 5, 0));
		this.add(panelCentral);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWidths = new int[]{110, 313, 0};
		gbl_panelCentral.rowHeights = new int[]{222, 0, 0, 0, 0};
		gbl_panelCentral.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCentral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCentral.setLayout(gbl_panelCentral);
		
		JPanel panelTexte = new JPanel();
		GridBagConstraints gbc_panelTexte = new GridBagConstraints();
		gbc_panelTexte.fill = GridBagConstraints.BOTH;
		gbc_panelTexte.insets = new Insets(0, 0, 5, 5);
		gbc_panelTexte.gridx = 0;
		gbc_panelTexte.gridy = 0;
		panelCentral.add(panelTexte, gbc_panelTexte);
		panelTexte.setLayout(new GridLayout(8, 0, 0, 0));
		
		JLabel lblNomClient = new JLabel("Nom  ");
		lblNomClient.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTexte.add(lblNomClient);
		
		JLabel lblPrenomClient = new JLabel("Prénom  ");
		lblPrenomClient.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTexte.add(lblPrenomClient);
		
		JLabel lblAdresse1Client = new JLabel("Adresse  ");
		lblAdresse1Client.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTexte.add(lblAdresse1Client);
		
		JLabel lblAdresse2Client = new JLabel("Adresse complémentaire *  ");
		lblAdresse2Client.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTexte.add(lblAdresse2Client);
		
		JLabel lblCodePostal = new JLabel("Code Postal  ");
		lblCodePostal.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTexte.add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville  ");
		lblVille.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTexte.add(lblVille);
		
		JLabel lblTéléphoneClient = new JLabel("Téléphone  ");
		lblTéléphoneClient.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTexte.add(lblTéléphoneClient);
		
		JLabel lblMailClient = new JLabel("Mail  ");
		lblMailClient.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTexte.add(lblMailClient);
		
		JPanel panelChampDeSaisie = new JPanel();
		GridBagConstraints gbc_panelChampDeSaisie = new GridBagConstraints();
		gbc_panelChampDeSaisie.insets = new Insets(0, 0, 5, 0);
		gbc_panelChampDeSaisie.fill = GridBagConstraints.BOTH;
		gbc_panelChampDeSaisie.gridx = 1;
		gbc_panelChampDeSaisie.gridy = 0;
		panelCentral.add(panelChampDeSaisie, gbc_panelChampDeSaisie);
		panelChampDeSaisie.setLayout(new GridLayout(8, 0, 0, 0));
		
		textFieldNomClient = new JTextField();
		panelChampDeSaisie.add(textFieldNomClient);
		textFieldNomClient.setColumns(10);
		
		textFieldPrenomClient = new JTextField();
		panelChampDeSaisie.add(textFieldPrenomClient);
		textFieldPrenomClient.setColumns(10);
		
		textFieldAdresse1Client = new JTextField();
		panelChampDeSaisie.add(textFieldAdresse1Client);
		textFieldAdresse1Client.setColumns(10);
		
		textFieldAdresse2Client = new JTextField();
		panelChampDeSaisie.add(textFieldAdresse2Client);
		textFieldAdresse2Client.setColumns(10);
		
		textFieldCodePostalClient = new JTextField();
		panelChampDeSaisie.add(textFieldCodePostalClient);
		textFieldCodePostalClient.setColumns(10);
		
		textFieldVille = new JTextField();
		panelChampDeSaisie.add(textFieldVille);
		textFieldVille.setColumns(10);
		
		textFieldTelephoneClient = new JTextField();
		panelChampDeSaisie.add(textFieldTelephoneClient);
		textFieldTelephoneClient.setColumns(10);
		
		textFieldMailClient = new JTextField();
		panelChampDeSaisie.add(textFieldMailClient);
		textFieldMailClient.setColumns(10);
		
		erreurLabel = new JLabel("");
		erreurLabel.setForeground(Color.RED);
		GridBagConstraints gbc_erreurLabel = new GridBagConstraints();
		gbc_erreurLabel.insets = new Insets(0, 0, 5, 0);
		gbc_erreurLabel.gridx = 1;
		gbc_erreurLabel.gridy = 1;
		panelCentral.add(erreurLabel, gbc_erreurLabel);
		
		JLabel indications = new JLabel("(* facultatif)");
		indications.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_indications = new GridBagConstraints();
		gbc_indications.insets = new Insets(0, 0, 5, 5);
		gbc_indications.gridx = 0;
		gbc_indications.gridy = 2;
		panelCentral.add(indications, gbc_indications);
		
		
	}
	
	private void constructeurBoutonValider(int transport) {
		btnValidation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client = new Client(textFieldNomClient.getText(), textFieldPrenomClient.getText(), textFieldCodePostalClient.getText(),
						textFieldAdresse1Client.getText(), textFieldVille.getText(), textFieldTelephoneClient.getText(),
						textFieldMailClient.getText(), textFieldAdresse2Client.getText());
				verificationSaisie(transport);
				
				
			}
		});
	}
	
	private void constructeurBoutonAnnuler() {
		btnAnnulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setContentPane(new PanelPanier(frame));
				frame.repaint();
				frame.validate();
			}
		});
	}
	
	private void verificationSaisie(int transport) {
		boolean correct = true;
		//Check code postal
		boolean success = true;
		try {
			Integer.parseInt(textFieldCodePostalClient.getText());
		} catch (NumberFormatException e) {
			textFieldCodePostalClient.setBackground(Color.red);
			correct = false;
			success = false;
		} 
		if(success) {
			textFieldCodePostalClient.setBackground(Color.white);
		}
		
		//Check Telephone
		success = true;
		try {
			Integer.parseInt(textFieldTelephoneClient.getText());
		} catch (NumberFormatException e) {
			textFieldTelephoneClient.setBackground(Color.red);
			correct = false;
			success = false;
		}
		if(success) {
			textFieldTelephoneClient.setBackground(Color.white);
		}
		
		//Checl mail
		if ((textFieldMailClient.getText().indexOf("@")==-1) || (textFieldMailClient.getText().indexOf(".")==-1)){
			textFieldMailClient.setBackground(Color.red);
			correct = false;
		} else {
			textFieldMailClient.setBackground(Color.white);
		}
		
		//Check Nom rempli
		if (textFieldNomClient.getText().equals("")) {
			textFieldNomClient.setBackground(Color.red);
			correct=false;
		} else {
			textFieldNomClient.setBackground(Color.white);
		}
		
		//Check prenom rempli
		if (textFieldPrenomClient.getText().equals("")) {
			textFieldPrenomClient.setBackground(Color.red);
			correct = false;
		} else {
			textFieldPrenomClient.setBackground(Color.white);
		}
		
		//Check ville rempli
		if (textFieldVille.getText().equals("")) {
			textFieldVille.setBackground(Color.red);
			correct = false;
		} else {
			textFieldVille.setBackground(Color.white);
		}
		
		//Check adresse 1 rempli
		if (textFieldAdresse1Client.getText().equals("")) {
			textFieldAdresse1Client.setBackground(Color.red);
			correct = false;
		} else {
			textFieldAdresse1Client.setBackground(Color.white);
		}
		
		if (correct) {
			Facture facture = new Facture(client, transport);
			facture.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
			facture.setVisible(true);
		} else {
			erreurLabel.setText("Erreur de saisie");
		}
			
	}

}
