import javax.swing.*; // Mengimpor library Swing untuk membuat tampilan GUI
import java.awt.*; // Mengimpor library AWT untuk layout dan warna
import java.awt.event.*; // Mengimpor library event untuk aksi tombol

public class formpendaftaran extends JFrame { // Membuat class formpendaftaran (huruf kecil, sesuai nama file)
    // Deklarasi field input yang akan digunakan untuk mengisi data mahasiswa
    JTextField tfNama, tfTanggalLahir, tfNoPendaftaran, tfNoTelp, tfEmail; // Untuk input teks satu baris
    JTextArea taAlamat; // Untuk input alamat (bisa lebih dari satu baris)

    public formpendaftaran() { // Konstruktor, dijalankan saat objek dibuat
        setTitle("Form Pendaftaran Mahasiswa Baru"); // Mengatur judulnya
        setSize(400, 400); // Mengatur ukuran form 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Jika form nya ditutup, maka akan berhenti
        setLocationRelativeTo(null); // Membuat agar form tersebut muncul di tengah layar

        Color pinkMuda = new Color(255, 228, 242); // Membuat warna pink muda untuk background
        Color pinkTua = new Color(233, 30, 99);    // Membuat warna pink tua untuk tombol dan border

        // Membuat panel utama yang akan menampung seluruh komponen
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // Panel utama dengan layout BorderLayout
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 40, 15)); // Memberi jarak di sekeliling panel utama
        mainPanel.setBackground(pinkMuda); // Mengatur warna background panel utama

        // Membuat panel form untuk input data
        JPanel formPanel = new JPanel(new GridBagLayout()); // Panel form dengan layout GridBagLayout
        formPanel.setBackground(pinkMuda); // Mengatur warna background form
        GridBagConstraints gbc = new GridBagConstraints(); // Membuat objek untuk mengatur posisi komponen
        gbc.insets = new Insets(5, 5, 5, 5); // Memberi jarak antar komponen
        gbc.anchor = GridBagConstraints.WEST; // Komponen rata kiri

        // Membuat label dan field untuk Nama Lengkap
        gbc.gridx = 0; gbc.gridy = 0; // Posisi kolom 0 baris 0
        formPanel.add(new JLabel("Nama Lengkap"), gbc); // Menambah label Nama Lengkap ke form
        tfNama = new JTextField(20); // Membuat field input nama
        gbc.gridx = 1; // Pindah ke kolom 1
        formPanel.add(tfNama, gbc); // Menambah field input nama ke form

        // Membuat label dan field untuk Tanggal Lahir
        gbc.gridx = 0; gbc.gridy++; // Kolom 0, baris berikutnya
        formPanel.add(new JLabel("Tanggal Lahir"), gbc); // Label Tanggal Lahir
        tfTanggalLahir = new JTextField(20); // Field input tanggal lahir
        gbc.gridx = 1;
        formPanel.add(tfTanggalLahir, gbc);

        // Membuat label dan field untuk Nomor Pendaftaran
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Nomor Pendaftaran"), gbc);
        tfNoPendaftaran = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(tfNoPendaftaran, gbc);

        // Membuat label dan field untuk No. Telp
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("No. Telp"), gbc);
        tfNoTelp = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(tfNoTelp, gbc);

        // Membuat label dan field untuk Alamat
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("Alamat"), gbc);
        taAlamat = new JTextArea(3, 20); // Field input alamat (bisa banyak baris)
        JScrollPane scrollAlamat = new JScrollPane(taAlamat); // Scroll untuk alamat
        gbc.gridx = 1;
        formPanel.add(scrollAlamat, gbc);

        // Membuat label dan field untuk E-mail
        gbc.gridx = 0; gbc.gridy++;
        formPanel.add(new JLabel("E-mail"), gbc);
        tfEmail = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(tfEmail, gbc);

        // Membuat panel untuk tombol submit
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Panel tombol dengan layout kanan
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Tanpa padding tambahan
        buttonPanel.setBackground(pinkMuda); // Warna background tombol panel
        JButton submitBtn = new JButton("Submit"); // Membuat tombol submit
        submitBtn.setBackground(pinkTua); // Warna tombol submit
        submitBtn.setForeground(Color.WHITE); // Warna teks tombol submit
        submitBtn.setFocusPainted(false); 
        buttonPanel.add(submitBtn); // Menambah tombol ke panel tombol

        // Menambahkan form dan tombol ke panel utama
        mainPanel.add(formPanel, BorderLayout.CENTER); 
        mainPanel.add(buttonPanel, BorderLayout.SOUTH); 
        add(mainPanel); // Menambah panel utama ke window

        // Membuat event saat tombol submit ditekan
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengatur warna dan efek tombol agar sesuai tema
                UIManager.put("OptionPane.background", new Color(255, 228, 242)); 
                UIManager.put("Panel.background", new Color(255, 228, 242));      
                UIManager.put("Button.background", new Color(233, 30, 99));       
                UIManager.put("Button.foreground", Color.WHITE);                  
                UIManager.put("Button.focus", new Color(233, 30, 99));            
                UIManager.put("Button.select", new Color(233, 30, 99));           

                // Mengecek jika ada kolom yang kosong
                if (tfNama.getText().isEmpty() || tfTanggalLahir.getText().isEmpty() ||
                    tfNoPendaftaran.getText().isEmpty() || tfNoTelp.getText().isEmpty() ||
                    taAlamat.getText().isEmpty() || tfEmail.getText().isEmpty()) {

                    // Menampilkan pesan peringatan jika ada kolom kosong
                    JOptionPane.showMessageDialog(
                        null,
                        "Semua kolom wajib diisi!", // Pesan peringatan
                        "Peringatan", // Judul dialog
                        JOptionPane.PLAIN_MESSAGE 
                    );
                } else {
                    // Menampilkan dialog konfirmasi jika semua kolom terisi
                    int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah anda yakin data yang Anda isi sudah benar?", // Pesan konfirmasi
                        "Konfirmasi", // Judul dialog
                        JOptionPane.YES_NO_OPTION, // Pilihan Yes/No
                        JOptionPane.PLAIN_MESSAGE 
                    );
                    // Jika user pilih Yes, maka tampilkan data
                    if (confirm == JOptionPane.YES_OPTION) {
                        tampilkanData(); // Memanggil method untuk menampilkan data
                    }
                }
            }
        });
    }

    // Method untuk menampilkan data mahasiswa yang sudah diisi
    private void tampilkanData() {
        JFrame dataFrame = new JFrame("Data Mahasiswa"); // Membuat tampilan baru untuk menampilkan data
        dataFrame.setSize(400, 270); // Mengatur ukuran tampilan data
        dataFrame.setLocationRelativeTo(null); // tampilan data muncul di tengah layar

        Color pinkTua = new Color(233, 30, 99); // Membuat warna pink tua untuk border

        // Membuat label judul di atas data
        JLabel judul = new JLabel("Data Mahasiswa"); // Label judul
        judul.setFont(new Font("SansSerif", Font.BOLD, 16)); // ukuran font judul
        judul.setForeground(new Color(233, 30, 99)); 
        judul.setHorizontalAlignment(SwingConstants.CENTER); 

        // Membuat panel untuk menampilkan data dengan border pink tua
        JPanel dataPanel = new JPanel(new GridLayout(6, 1, 0, 0)); 
        dataPanel.setBackground(Color.WHITE); 
        dataPanel.setBorder(BorderFactory.createLineBorder(pinkTua, 2)); 

        Font fontData = new Font("SansSerif", Font.PLAIN, 14); 

        // Menambahkan setiap baris data ke panel data
        dataPanel.add(makeDataRow("Nama", tfNama.getText(), fontData)); // Baris nama
        dataPanel.add(makeDataRow("Tanggal Lahir", tfTanggalLahir.getText(), fontData)); // Baris tanggal lahir
        dataPanel.add(makeDataRow("No.Pendaftaran", tfNoPendaftaran.getText(), fontData)); // Baris no pendaftaran
        dataPanel.add(makeDataRow("No.Telp", tfNoTelp.getText(), fontData)); // Baris no telp
        dataPanel.add(makeDataRow("Alamat", taAlamat.getText(), fontData)); // Baris alamat
        dataPanel.add(makeDataRow("E-mail", tfEmail.getText(), fontData)); // Baris email

        // Membuat panel wrapper untuk menampung judul dan data
        JPanel wrapper = new JPanel(new BorderLayout()); // Panel wrapper dengan BorderLayout
        wrapper.setBackground(new Color(240, 240, 240)); 
        wrapper.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
        wrapper.add(judul, BorderLayout.NORTH); // Menambahkan judul di atas

        // Membuat panel center agar dataPanel tidak terlalu mepet ke pinggir
        JPanel centerPanel = new JPanel(new GridBagLayout()); // Panel center dengan GridBagLayout
        centerPanel.setBackground(new Color(240, 240, 240)); // Background abu-abu muda
        centerPanel.add(dataPanel); // Menambahkan dataPanel ke centerPanel

        wrapper.add(centerPanel, BorderLayout.CENTER); // Menambahkan centerPanel ke wrapper

        dataFrame.add(wrapper); // Menambahkan wrapper ke window data
        dataFrame.getContentPane().setBackground(new Color(240, 240, 240)); // Background tampilan data
        dataFrame.setVisible(true); // Menampilkan tampilan data
    }

    // Method untuk membuat satu baris data
    private JPanel makeDataRow(String label, String value, Font font) {
        JPanel row = new JPanel(new BorderLayout()); 
        row.setBackground(Color.WHITE); 

        JLabel l = new JLabel(label + " :"); // Membuat label data (misal: Nama :)
        l.setFont(font); // Mengatur font label
        l.setPreferredSize(new Dimension(120, 20)); // Mengatur lebar label agar rata kiri dan sejajar

        JLabel v = new JLabel(value); // Membuat label untuk nilai data 
        v.setFont(font); // Mengatur font nilai

        row.add(l, BorderLayout.WEST); // Menambahkan label di kiri
        row.add(v, BorderLayout.CENTER); // Menambahkan nilai di tengah
        return row; // Mengembalikan panel baris data
    }

    public static void main(String[] args) { // Method utama untuk menjalankan form nya
        new formpendaftaran().setVisible(true); // Membuat objek Form Pendaftaran dan menampilkannya
    }
}