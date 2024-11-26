/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas;
import java.awt.*;
import java.awt.print.*;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class PrintTable {

    public void printToPDF(JTable table) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) g;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                
                // Gambar header laporan
                g.setFont(new Font("Arial", Font.BOLD, 14));
                g.drawString("Laporan Penjualan", 50, 50); // Header di dekat tepi kiri
                
                // Render JTable ke dalam Graphics
                TableModel model = table.getModel();
                int y = 80; // Awal posisi baris pertama
                int rowHeight = 20; // Tinggi baris
                
                // Array lebar kolom
                int[] columnWidths = {70, 70, 100, 80, 100, 100, 70, 120, 90};
                if (columnWidths.length != model.getColumnCount()) {
                    throw new IllegalArgumentException("Jumlah lebar kolom harus sama dengan jumlah kolom tabel.");
                }

                // Header kolom
                g.setFont(new Font("Arial", Font.BOLD, 10));
                int x = 20; // Margin horizontal di dekat tepi kiri
                
                for (int col = 0; col < model.getColumnCount(); col++) {
                    g.drawString(model.getColumnName(col), x, y);
                    x += columnWidths[col]; // Lebar sesuai array
                }

                // Baris data
                g.setFont(new Font("Arial", Font.PLAIN, 10));
                y += 20;
                for (int row = 0; row < model.getRowCount(); row++) {
                    x = 20; // Reset posisi horizontal setiap baris baru
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        g.drawString(model.getValueAt(row, col).toString(), x, y);
                        x += columnWidths[col]; // Lebar sesuai array
                    }
                    y += rowHeight; // Jarak antar baris
                }

                return PAGE_EXISTS;
            }
        });

        // Dialog untuk memilih printer virtual
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
