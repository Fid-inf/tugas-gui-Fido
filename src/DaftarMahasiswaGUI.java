import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DaftarMahasiswaGUI {
    private ArrayList<Mahasiswa> listMahasiswa;
    private JFrame frame;
    private JPanel panelInput, panelTombol, panelAtas;

    private JTextField txtNim, txtNama;
    private JButton btnTambah, btnHapusSemua;
    private JTextArea areaDaftar;
    private JLabel lblTotal;

    public DaftarMahasiswaGUI() {
        listMahasiswa = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        //TOP-LEVEL
        frame = new JFrame("Data Kehadiran / Daftar Mahasiswa");
        frame.setSize(420, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        //INTERMEDIATE
        panelInput = new JPanel(new GridLayout(2, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createTitledBorder("Input Data Mahasiswa"));

        panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        txtNim = new JTextField(15);
        txtNama = new JTextField(15);
        btnTambah = new JButton("Tambah ke List");
        btnHapusSemua = new JButton("Kosongkan List");

        areaDaftar = new JTextArea();
        areaDaftar.setEditable(false);
        areaDaftar.setFont(new Font("Monospaced", Font.PLAIN, 13));

        lblTotal = new JLabel("Total Mahasiswa: 0");
        lblTotal.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        panelInput.add(new JLabel("  NIM:"));
        panelInput.add(txtNim);
        panelInput.add(new JLabel("  Nama Lengkap:"));
        panelInput.add(txtNama);

        panelTombol.add(btnTambah);
        panelTombol.add(btnHapusSemua);

        frame.add(panelAtas, BorderLayout.NORTH);
        frame.add(new JScrollPane(areaDaftar), BorderLayout.CENTER);
        frame.add(lblTotal, BorderLayout.SOUTH);

        AksiHandler handler = new AksiHandler();
        btnTambah.addActionListener(handler);
        btnHapusSemua.addActionListener(handler);
        txtNama.addActionListener(handler); // Agar menekan Enter masukin nama dan nim
    }

    public void tampilkan() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void refreshDaftar() {
        areaDaftar.setText("");
        int nomor = 1;
        for (Mahasiswa mhs : listMahasiswa) {
            areaDaftar.append(nomor + ". " + mhs.toString() + "\n");
            nomor++;
        }
        lblTotal.setText("Total Mahasiswa: " + listMahasiswa.size());
    }

    private class AksiHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnHapusSemua) {
                listMahasiswa.clear();
                refreshDaftar();
                return;
            }

            String nim = txtNim.getText().trim();
            String nama = txtNama.getText().trim();

            if (nim.isEmpty() || nama.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "NIM dan Nama tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Mahasiswa mhsBaru = new Mahasiswa(nim, nama);
            listMahasiswa.add(mhsBaru);

            refreshDaftar();
            txtNim.setText("");
            txtNama.setText("");
            txtNim.requestFocus();
        }
    }
}