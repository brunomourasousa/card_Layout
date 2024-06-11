package basic;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal_IMC_Swing implements ActionListener {

	private JTextField campoPeso;
	private JTextField campoAltura;
	private JLabel labelResultado;
	private JLabel labelImc;

	public static void main(String[] args) {

		new Cal_IMC_Swing();

	}

	public Cal_IMC_Swing() {
		// Criando o Frame
		JFrame frame = new JFrame("Calculadora IMC");
		frame.setSize(350, 200);

		// AWT -> JavaFX
		JPanel panel = new JPanel();

		// 4 Linhas, 2 Colunas, Tamanho, Tamanho
		panel.setLayout(new GridLayout(5, 2, 10, 10));

		// <label>
		JLabel labelPeso = new JLabel("Peso (Kg)");
		campoPeso = new JTextField();

		JLabel labelAltura = new JLabel("Altura (Mts)");
		campoAltura = new JTextField();

		JButton calcular = new JButton("Calcular");

		calcular.addActionListener(this);

		labelResultado = new JLabel("IMC: ");
		
		JLabel conclusao = new JLabel ("Conclusão: ");
		labelImc = new JLabel();

		// adiciona os componentes no panel
		panel.add(labelPeso);
		panel.add(campoPeso);
		panel.add(labelAltura);
		panel.add(campoAltura);
		panel.add(new JLabel(""));
		panel.add(calcular);
		panel.add(new JLabel(""));
		panel.add(labelResultado);
		panel.add(conclusao);
		panel.add(labelImc);
		// adiciona o painel ao frame
		frame.add(panel);
		// habilitando a visibilidade do frame
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// pegando e transformando de string para double
		double peso = Double.parseDouble(campoPeso.getText());
		double altura = Double.parseDouble(campoAltura.getText());

		// calcular o imc
		double imc = peso / (altura * altura);

		// exibindo resultado final
		labelResultado.setText(String.format("IMC: %.2f", imc));

		String resultado = "";
	
		if (imc < 18.5) {
			resultado = "Abaixo do peso";
		} else if (imc >= 18.6 && imc <= 24.9) {
			resultado = "Peso ideal  *Parabens!*";
		} else if (imc >= 25 && imc <= 29.9) {
			resultado = "Levemente acima do peso";
		} else if (imc >= 30 && imc <= 34.9) {
			resultado = "Obesidade grau |";
		} else if (imc >= 35 && imc <= 39.9) {
			resultado = "Obesidade grau ||(severa)";
		} else {
			resultado = "Obesidade grau ||(morbida)";
		}
		labelImc.setText(resultado);
		

	}

}
