package client.paroles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Fenetre extends JFrame {
	private JTextArea textArea;
	public Fenetre() {
		super();
		build();
	}
	private void build() {
		setTitle("99 shooters sans alcool");
		setSize(400,150);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}
	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);
		textArea = new JTextArea("");
		panel.add(textArea);
		JButton bouton = new JButton(new ParolesAction(this,"Play"));
		panel.add(bouton);
		JButton bouton2 = new JButton("Reset");
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("effacez avant de relancer!");
				}
		});
		panel.add(bouton2);
		return panel;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public static class ParolesAction extends AbstractAction {
		private Fenetre fenetre;

	public ParolesAction(Fenetre fenetre, String texte) {
			super(texte);
			this.fenetre = fenetre;}
	
	public void actionPerformed(ActionEvent e) {
			String nombreString  = fenetre.getTextArea().getText();
			int nombre = Integer.parseInt(nombreString);{
				
				String newline=System.getProperty("line.separator");
				
				if(nombre >= 3 && nombre <=99)
					fenetre.getTextArea().setText(""+nombre+" shooters sans alcool sur le mur,"+newline+""+nombre+" shooters sans alcool."+newline+"Bois en un et au suivant! "+(nombre-1)+""+newline+"shooters sans alcool sur le mur.");
				else if(nombre == 2)
					fenetre.getTextArea().setText(""+nombre+" shooters sans alcool sur le mur,"+newline+""+nombre+" shooters sans alcool."+newline+"Bois en un et au suivant! "+(nombre-1)+""+newline+"shooter sans alcool sur le mur.");
				else if(nombre == 1)
					fenetre.getTextArea().setText(""+nombre+" shooter sans alcool sur le mur,"+nombre+""+newline+"shooter sans alcool."+newline+"Bois en un et au suivant! Plus de"+newline+"shooters sans alcool sur le mur.");
				else if(nombre == 0) 
					fenetre.getTextArea().setText("Plus de shooters sans alcool sur le"+newline+"mur, plus de shooters sans alcool."+newline+"Vas au supermarché pour en"+newline+"acheter, 99 shooters sans alcool sur le mur.");
			}
	}
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fenetre fenetre = new Fenetre();
				fenetre.setVisible(true);
			}
		});
	}
}
