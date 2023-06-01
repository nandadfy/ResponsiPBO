import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewLomba extends JFrame{
    JLabel lJudul = new JLabel("Judul");
    JLabel lAlur = new JLabel("Alur");
    JLabel lOri = new JLabel("Orisinalitas");
    JLabel lPK = new JLabel("PemilihanKata");

    public JTextField txtJudul = new JTextField();
    public JTextField txtAlur = new JTextField();
    public JTextField txtOri = new JTextField();
    public JTextField txtPK=  new JTextField();
    

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Reset");
    public JButton btnSearch = new JButton("Search");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Judul", "Alur", "Orisinalitas", "PemilihanKata", "Nilai"};

    public ViewLomba() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        setTitle("DATA LOMBA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);

        add(lJudul);
        lJudul.setBounds(510, 20, 90, 20);
        add(txtJudul);
        txtJudul.setBounds(510, 40, 120, 20);

        add(lAlur);
        lAlur.setBounds(510, 60, 90, 20);
        add(txtAlur);
        txtAlur.setBounds(510, 80, 120, 20);

        add(lOri);
        lOri.setBounds(510, 100, 90, 20);
        add(txtOri);
        txtOri.setBounds(510, 120, 120, 20);

        add(lPK);
        lPK.setBounds(510, 140, 90, 20);
        add(txtPK);
        txtPK.setBounds(510, 160, 120, 20);

        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);

        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
        
        add(btnSearch);
        btnSearch.setBounds(510, 280, 90, 20);
    }

    public String getJudul(){
        return txtJudul.getText();
    }

    public String getAlur(){
        return txtAlur.getText();
    }

    public String getOrisinalitas(){
        return txtOri.getText();
    }

    public String getPemilihanKata(){
        return txtPK.getText();
    }

}

