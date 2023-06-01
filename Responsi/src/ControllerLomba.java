import java.awt.event.*;
import javax.swing.*;

public class ControllerLomba {
    ModelLomba ModelLomba;
    ViewLomba ViewLomba;
    public String data;
    public ControllerLomba(ModelLomba ModelLomba, ViewLomba ViewLomba){
        this.ModelLomba = ModelLomba;
        this.ViewLomba = ViewLomba;

        if (ModelLomba.getBanyakData()!=0) {
            String dataLomba[][] = ModelLomba.readLomba();
            ViewLomba.tabel.setModel((new JTable(dataLomba, ViewLomba.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        ViewLomba.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Judul = ViewLomba.getJudul();
                double Alur = Double.parseDouble(ViewLomba.getAlur());
                double Orisinalitas = Double.parseDouble(ViewLomba.getOrisinalitas());
                double PemilihanKata = Double.parseDouble(ViewLomba.getPemilihanKata());
                double Nilai = (Alur+Orisinalitas+PemilihanKata)/3;
                ModelLomba.insertLomba(Judul, Alur, Orisinalitas, PemilihanKata, Nilai);

                String dataLomba[][] = ModelLomba.readLomba();
                ViewLomba.tabel.setModel((new JTable(dataLomba, ViewLomba.namaKolom)).getModel());
            }
        });

        ViewLomba.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String Judul = ViewLomba.getJudul();
                double Alur = Double.parseDouble(ViewLomba.getAlur());
                double Orisinalitas = Double.parseDouble(ViewLomba.getOrisinalitas());
                double PemilihanKata = Double.parseDouble(ViewLomba.getPemilihanKata());
                double Nilai = (Alur+Orisinalitas+PemilihanKata)/3;
                ModelLomba.updateLomba(Judul, Alur, Orisinalitas, PemilihanKata, Nilai);

                String dataLomba[][] = ModelLomba.readLomba();
                ViewLomba.tabel.setModel((new JTable(dataLomba, ViewLomba.namaKolom)).getModel());
            }
        });

        ViewLomba.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                ViewLomba.txtJudul.setText("");
                ViewLomba.txtAlur.setText("");
                ViewLomba.txtOri.setText("");
                ViewLomba.txtPK.setText("");
            }
        });


        ViewLomba.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = ViewLomba.tabel.getSelectedRow();
                data = ViewLomba.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[4];
                dataUpdate[0] = ViewLomba.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = ViewLomba.tabel.getValueAt(baris, 1).toString();
                System.out.println(data);
            }
        });

        ViewLomba.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    ModelLomba.deleteLomba(data);
                    String dataLomba[][] = ModelLomba.readLomba();
                    ViewLomba.tabel.setModel((new JTable(dataLomba, ViewLomba.namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });

    }
}
