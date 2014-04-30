package JTableTest;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Vector;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DBViewer extends JFrame
{
    public DBViewer(Vector data)
    {

        Vector columnNames = new Vector();

        columnNames.add("symbol");
        columnNames.add("quantity");
        columnNames.add("price");
        columnNames.add("total price");

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(600, 100));

        //Add the table to scroll pane.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this window.
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
