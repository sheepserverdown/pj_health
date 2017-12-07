import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class sign_form_modify extends JFrame {
	 JPanel contentPane;
	 JTextField txt1;
	 JTextField txt2;
	 JTextField txt3;
	 JTextField txt4;
	 JTextField txt5;
	 
	 String[] info;

	public sign_form_modify() {
		setResizable(false);
		setTitle("ȸ������ ������");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 242);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try{
			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //LookAndFeel Windows ��Ÿ�� ����
			SwingUtilities.updateComponentTreeUI(getContentPane()) ;
		}catch(Exception e){
			//bottomInfo.setText("ERROR : LookAndFeel setting failed");
		}
		
		try {
			File f = new File("Users.txt");
			BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
			
			String line = null;
			String[] splitedStr = null;
			while((line = reader.readLine()) != null) {
				splitedStr = null;
				splitedStr = line.split("\t");
				
				for(int i = 0; i < splitedStr.length; i++) {
					splitedStr[i] = splitedStr[i].trim();
					splitedStr[i] = info[i];
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		txt1.setText(info[0]);
		txt2.setText(info[1]);
		txt3.setText(info[2]);
		txt4.setText(info[3]);
		txt5.setText(info[4]);
		
		JLabel labelTop = new JLabel("ȸ�� ���� �����ϱ�");
		labelTop.setHorizontalAlignment(SwingConstants.CENTER);
		labelTop.setBounds(0, 0, 281, 18);
		contentPane.add(labelTop);
		
		JLabel label = new JLabel("�̸� :");
		label.setBounds(12, 28, 55, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("������� :");
		label_1.setBounds(12, 56, 64, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Ű :");
		label_2.setBounds(12, 84, 55, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("������ :");
		label_3.setBounds(12, 112, 55, 18);
		contentPane.add(label_3);
		
		JLabel label_5 = new JLabel("��Ÿ���� :");
		label_5.setBounds(12, 143, 104, 18);
		contentPane.add(label_5);
		
		txt1 = new JTextField();
		txt1.setBounds(79, 28, 202, 22);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(79, 54, 202, 22);
		contentPane.add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(79, 82, 202, 22);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(79, 110, 202, 22);
		contentPane.add(txt4);
		
		txt5 = new JTextField();
		txt5.setBounds(108, 142, 173, 22);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JButton button_Left = new JButton("����");
		button_Left.setBounds(41, 176, 98, 28);
		contentPane.add(button_Left);
		button_Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String St_txt1 = txt1.getText();
				String St_txt2 = txt2.getText();
				String St_txt3 = txt3.getText();
				String St_txt4 = txt4.getText();
				String St_txt5 = txt5.getText();
				
				String info = St_txt1 + "\t" + St_txt2 + "\t" + St_txt3 + "\t" + St_txt4 + "\t" + St_txt5;
				try {
				File f = new File("Users.txt");
					if(info.length() > 0) {
						BufferedWriter out = new BufferedWriter(new FileWriter("Users.txt"));
						out.write(info);
						out.close();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "���� �Ϸ�", "�˸�", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton button_Right = new JButton("�ʱ�ȭ");
		button_Right.setBounds(147, 176, 98, 28);
		contentPane.add(button_Right);
		button_Right.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				txt1.setText(null);
				txt2.setText(null);
				txt3.setText(null);
				txt4.setText(null);
				txt5.setText(null);			
				JOptionPane.showMessageDialog(null, "������ �ʱ�ȭ �Ͽ����ϴ�.", "�˸�", JOptionPane.INFORMATION_MESSAGE, null);
			}
		});
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new sign_form_modify();
			}
		});
	}
}