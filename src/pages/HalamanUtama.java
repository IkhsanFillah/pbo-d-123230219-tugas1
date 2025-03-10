package pages;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class HalamanUtama extends JFrame implements ActionListener {
    private JLabel lblNamaDpn, lblNamaBelakang, lblJenisKelamin, lblStsSimpan, lblStsConvert;
    private JTextField txtNamaDpn, txtNamaBelakang;
    private JButton btnSimpan, btnConvertFile;
    private JTextArea ta;
    private JRadioButton rbtnLakilaki, rbtnPerempuan;
    private ArrayList<String> listData;
    private ButtonGroup grup;
    
    public HalamanUtama() {
        listData = new ArrayList<String>();
        
        setTitle("Halaman Input Data");
        lblNamaDpn = new JLabel("Nama Depan");
        lblNamaBelakang = new JLabel("Nama Belakang");
        lblJenisKelamin = new JLabel("Jenis Kelamin");
        txtNamaDpn = new JTextField(20);
        txtNamaBelakang = new JTextField(20);
        btnSimpan = new JButton("Simpan");
        btnConvertFile = new JButton("Convert to .txt file");
        ta = new JTextArea(30, 30);
        rbtnLakilaki = new JRadioButton("Laki-laki");
        rbtnPerempuan = new JRadioButton("Perempuan");
        lblStsSimpan = new JLabel("");
        lblStsConvert = new JLabel("");

        grup = new ButtonGroup();
        grup.add(rbtnLakilaki);
        grup.add(rbtnPerempuan);
        
        btnSimpan.addActionListener(this);
        btnConvertFile.addActionListener(this); 
        
        JScrollPane scrollPane = new JScrollPane(ta);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ta.setEditable(false); 

        setLayout(null);
        add(lblNamaDpn);
        add(lblNamaBelakang);
        add(lblJenisKelamin);
        add(txtNamaDpn);
        add(txtNamaBelakang);
        add(btnSimpan);
        add(btnConvertFile);
        add(scrollPane);
        add(rbtnLakilaki);
        add(rbtnPerempuan);
        add(lblStsSimpan);
        add(lblStsConvert);
        
        lblNamaDpn.setBounds(10, 10, 120, 20);
        txtNamaDpn.setBounds(10, 40, 150, 20);
        lblNamaBelakang.setBounds(180, 10, 120, 20);
        txtNamaBelakang.setBounds(180, 40, 150, 20);
        lblJenisKelamin.setBounds(10, 70, 120, 20);
        rbtnLakilaki.setBounds(70, 100, 100, 20);
        rbtnPerempuan.setBounds(190, 100, 120, 20);
        btnSimpan.setBounds(100, 140, 120, 20);
        lblStsSimpan.setBounds(10, 160, 200, 20); 
        scrollPane.setBounds(10, 190, 300, 150);
        btnConvertFile.setBounds(10, 350, 160, 20); 
        lblStsConvert.setBounds(10, 380, 300, 20); 

        setVisible(true);
        setSize(360, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSimpan) {
            String namaDpn = txtNamaDpn.getText();
            String namaBelakang = txtNamaBelakang.getText();
            String jenisKelamin = rbtnLakilaki.isSelected() ? "Laki-laki" : (rbtnPerempuan.isSelected() ? "Perempuan" : "");
            
            if (namaDpn.isEmpty() || namaBelakang.isEmpty() || jenisKelamin.isEmpty()) {
                lblStsSimpan.setText("Data tidak lengkap!");
                return;
            }
            
            String data = namaDpn + " " + namaBelakang + " | Gender: " + jenisKelamin;
            listData.add(data);
            ta.append(data + "\n");
            
            lblStsSimpan.setText("Data tersimpan");
            txtNamaDpn.setText("");
            txtNamaBelakang.setText("");
            grup.clearSelection(); 
        } else if (e.getSource() == btnConvertFile) {
            if (listData.isEmpty()) {
                lblStsConvert.setText("Tidak ada data tersedia");
                return;
            }
            
            try {
                FileWriter writer = new FileWriter("data_123230219.txt");
                for (String data : listData) {
                    writer.write(data + "\n");
                }
                writer.close();
                
                JOptionPane.showMessageDialog(this, 
                    "Data berhasil disimpan", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
                    
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Error menyimpan file: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}