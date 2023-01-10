package ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Article;
import metier.Fromage;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class Details extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = -9193769167863505289L;
	private JPanel contentPane;
	private JButton btnAjoutPanier;
	private JButton btnAnnuler;
	private JSpinner spinnerQuantiteFromage;
	private List<Article> article;
	private JComboBox<?> comboBoxFormatFromage;
	private Fromage fromage;
	/**
	 * Create the frame.
	 */
	public Details(Fromage fromage) {
		this.fromage = fromage;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelQuantiteValidation = new JPanel();
		contentPane.add(panelQuantiteValidation, BorderLayout.EAST);
		panelQuantiteValidation.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panelQuantiteFromage_1 = new JPanel();
		panelQuantiteValidation.add(panelQuantiteFromage_1);
		
		JPanel panel = new JPanel();
		panelQuantiteValidation.add(panel);
		
		JLabel labelQuantite = new JLabel("Quantité : ");
		panel.add(labelQuantite);
		spinnerQuantiteFromage = new JSpinner();
		panel.add(spinnerQuantiteFromage);
		spinnerQuantiteFromage.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		((DefaultEditor)spinnerQuantiteFromage.getEditor()).getTextField().setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panelQuantiteValidation.add(panel_1);
		panel_1.setLayout(new CardLayout(7, 30));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		panel_1.add(separator, "name_59892826513600");
		
		JPanel panelValidation = new JPanel();
		panelQuantiteValidation.add(panelValidation);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelValidation.add(btnAnnuler);
		
		btnAjoutPanier = new JButton("Ajouter au panier\r\n");
		btnAjoutPanier.setBackground(Color.DARK_GRAY);
		btnAjoutPanier.setForeground(Color.WHITE);
		btnAjoutPanier.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAjoutPanier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelValidation.add(btnAjoutPanier);
		constructeurBtnAjoutPanier();
		constructeurBtnAnnuler();
		
		JPanel panelDescriptionEtChoix = new JPanel();
		contentPane.add(panelDescriptionEtChoix, BorderLayout.CENTER);
		panelDescriptionEtChoix.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDescriptionFromage = new JPanel();
		panelDescriptionEtChoix.add(panelDescriptionFromage, BorderLayout.CENTER);
		panelDescriptionFromage.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPaneDescriptionFromage = new JTextPane();
		textPaneDescriptionFromage.setEditable(false);
		textPaneDescriptionFromage.setText(fromage.désignation +"\n"+ fromage.getDescription());
		panelDescriptionFromage.add(textPaneDescriptionFromage, BorderLayout.CENTER);
		
		JPanel panelQuantiteFromage = new JPanel();
		FlowLayout fl_panelQuantiteFromage = (FlowLayout) panelQuantiteFromage.getLayout();
		fl_panelQuantiteFromage.setAlignment(FlowLayout.RIGHT);
		panelDescriptionEtChoix.add(panelQuantiteFromage, BorderLayout.SOUTH);
		
		comboBoxFormatFromage = new JComboBox<>(formatVente(fromage).toArray());
		constructeurSpinnerQuantiteFromage();
		
		JLabel labelPoids = new JLabel("Poids : ");
		panelQuantiteFromage_1.add(labelPoids);
		
		panelQuantiteFromage_1.add(comboBoxFormatFromage);
		
		comboBoxFormatFromage.getActionListeners()[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		
	
	}
		
	private List<String> formatVente(Fromage fromage){
			
			List<String> diffFormatVente = new LinkedList<String>();
			for (Article a : fromage.getArticles() ) {
				diffFormatVente.add(a.getClé() +"    " + a.getPrixTTC()+ " €");
			}
			return diffFormatVente;
	} 
	
	
	private void constructeurBtnAjoutPanier() {
		btnAjoutPanier.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			article = new LinkedList<Article>();
			article = fromage.getArticles();
			Accueil.getPanier().addPanier(article.get(comboBoxFormatFromage.getSelectedIndex()),(int) spinnerQuantiteFromage.getValue());
			Accueil.updateAffichagePanier();
			dispose();
		}
		});
	}
	private void constructeurBtnAnnuler() {
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	private void constructeurSpinnerQuantiteFromage(){
		comboBoxFormatFromage.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			article = new LinkedList<Article>();
			article = fromage.getArticles();
			spinnerQuantiteFromage.setModel(new SpinnerNumberModel(0,0,article.get(comboBoxFormatFromage.getSelectedIndex()).getQuantitéEnStock(),1));
		}
	});
	}
}
