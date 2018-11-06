package com.zycdojar.jmcs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.awt.event.ActionEvent;

public class aaa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3046113244949422617L;
	public final static JTextArea txtrZycdojar = new JTextArea();
	public boolean isOpen;
	public static boolean ServerClose;
	private JPanel contentPane;
	private JTextField txtServer;
	private JTextField txtCommand;
	public static InputStream ServerOutput;
	public static OutputStream Command;
	public static Process server;
	public static String ServerDir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aaa frame = new aaa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public aaa() {
		setTitle("Zycdojar\u7684\u5F00\u670D\u5668-2018/11/06\u7248");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtServer = new JTextField();
		txtServer.setText("./.server/server.jar");
		txtServer.setColumns(10);
		
		JButton button = new JButton("\u5F00\u670D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrZycdojar.setText("");
				ServerClose=false;
				isOpen=true;
				ServerDir=txtServer.getText();
				new aab().start();
			}
		});
		
		JLabel lblServerdir = new JLabel("\u670D\u52A1\u5668\u6838\u5FC3");
		
		txtCommand = new JTextField();
		txtCommand.setText("say \u5F00\u670D\u5668\u662FZycdojar\u5236\u4F5C\u7684\uFF01");
		txtCommand.setColumns(10);
		
		JLabel label = new JLabel("\u547D\u4EE4");
		
		JButton button_1 = new JButton("\u53D1\u9001");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isOpen){
					PrintStream cmd = new PrintStream(Command);
					cmd.print(txtCommand.getText()+"\n");
				}else{
					JOptionPane.showMessageDialog(null, "服务器未开启", "警告", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton button_2 = new JButton("\u5173\u670D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServerClose=true;
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(lblServerdir))
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtCommand, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtServer, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCommand, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtServer, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblServerdir))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2))
					.addGap(6))
		);
		
		txtrZycdojar.setText("Zycdojar\u5236\u4F5C\uFF0C\u5F00\u6E90github.com/zycdojar/javmcs\n\u57FA\u4E8E\u672C\u8F6F\u4EF6\uFF08\u5305\u62EC\u672C\u8F6F\u4EF6\uFF09\u5FC5\u987B\u5F00\u6E90\u3002");
		scrollPane.setViewportView(txtrZycdojar);
		contentPane.setLayout(gl_contentPane);
	}
}
