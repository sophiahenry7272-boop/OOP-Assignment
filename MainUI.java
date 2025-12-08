import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// ---------------------- DATA CLASSES --------------------------
class Vehicle {
    String owner, number, type;

    Vehicle(String owner, String number, String type) {
        this.owner = owner;
        this.number = number;
        this.type = type;
    }
}

class Service {
    String name;
    double cost;

    Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}

class ServiceRecord {
    Vehicle v;
    Service s;
    String date;

    ServiceRecord(Vehicle v, Service s, String date) {
        this.v = v;
        this.s = s;
        this.date = date;
    }
}

// ------------------------ MAIN UI -------------------------------
public class MainUI {

    ArrayList<ServiceRecord> records = new ArrayList<>();

    public static void main(String[] args) {
        new MainUI().createUI();
    }

    public void createUI() {
        JFrame frame = new JFrame("Vehicle Service Management");
        frame.setSize(650, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel l1 = new JLabel("Owner Name:");
        JLabel l2 = new JLabel("Vehicle Number:");
        JLabel l3 = new JLabel("Vehicle Type:");
        JLabel l4 = new JLabel("Service Name:");
        JLabel l5 = new JLabel("Service Cost:");
        JLabel l6 = new JLabel("Service Date (DD-MM-YYYY):");

        l1.setBounds(30, 30, 150, 25);
        l2.setBounds(30, 70, 150, 25);
        l3.setBounds(30, 110, 150, 25);
        l4.setBounds(30, 150, 150, 25);
        l5.setBounds(30, 190, 150, 25);
        l6.setBounds(30, 230, 200, 25);

        // Text fields
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();

        t1.setBounds(200, 30, 180, 25);
        t2.setBounds(200, 70, 180, 25);
        t3.setBounds(200, 110, 180, 25);
        t4.setBounds(200, 150, 180, 25);
        t5.setBounds(200, 190, 180, 25);
        t6.setBounds(200, 230, 180, 25);

        // Buttons
        JButton addBtn = new JButton("Add Record");
        JButton viewBtn = new JButton("View Records");

        addBtn.setBounds(30, 280, 150, 35);
        viewBtn.setBounds(230, 280, 150, 35);

        // Add record button action
        addBtn.addActionListener(e -> {
            try {
                String owner = t1.getText();
                String num = t2.getText();
                String type = t3.getText();
                String sName = t4.getText();
                double cost = Double.parseDouble(t5.getText());
                String date = t6.getText();

                Vehicle v = new Vehicle(owner, num, type);
                Service s = new Service(sName, cost);
                ServiceRecord r = new ServiceRecord(v, s, date);
                records.add(r);

                JOptionPane.showMessageDialog(frame, "Record Added Successfully!");

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        });

        // View records button action
        viewBtn.addActionListener(e -> showRecords());

        // Add components to frame
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);
        frame.add(t6);
        frame.add(addBtn);
        frame.add(viewBtn);

        frame.setVisible(true);
    }

    public void showRecords() {
        JFrame tableFrame = new JFrame("All Service Records");
        tableFrame.setSize(800, 400);

        String[] cols = { "Owner", "Number", "Type", "Service", "Cost", "Date" };
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        for (ServiceRecord r : records) {
            model.addRow(new Object[] {
                    r.v.owner,
                    r.v.number,
                    r.v.type,
                    r.s.name,
                    r.s.cost,
                    r.date
            });
        }

        JTable table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);

        tableFrame.add(sp);
        tableFrame.setVisible(true);
    }
}
