package swtkal.swing.elements.termin;
// Achtung: Klasse im Wesentlichen unveraendert aus Calendarium uebernommen

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.EventListenerList;

import swtkal.domain.Termin;
import swtkal.swing.ListenerForActions;
import swtkal.swing.elements.ButtonPanel;

class AllgemeinPanel extends ListenerForActions implements ItemListener {
    // graphical Representation
    JPanel gui = new JPanel();

    JFrame parentFrame;

    // Beginn- , Endedatum
    DatePanel[] datePanel = new DatePanel[2];

    // weitere Attribute
    JTextField kurzText;
    JTextField ort;
    JTextField hyperlink;

    JTextArea langText;

    JCheckBox serienFlag;

    // Buttons
    ButtonPanel buttons;

    // Events
    private EventListenerList mItemListenerList;

    AllgemeinPanel(JFrame f) {
        parentFrame = f;
        mItemListenerList = new EventListenerList();

        gui.setLayout(new BorderLayout());
    }

    JPanel getGUI() {
        return gui;
    }

    // Beschreibung // Beschreibung // Beschreibung // Beschreibung //
    // Beschreibung //
    JPanel createBeschreibung() {
        JPanel beschreibung = new JPanel();
        beschreibung.setLayout(new BoxLayout(beschreibung, BoxLayout.Y_AXIS));
        beschreibung.setBorder(new TitledBorder("Beschreibung"));

        JPanel zeile1 = new JPanel();
        zeile1.setLayout(new BoxLayout(zeile1, BoxLayout.X_AXIS));
        zeile1.setBorder(new EmptyBorder(0, 5, 5, 5));

        JPanel zeile2 = new JPanel();
        zeile2.setLayout(new BoxLayout(zeile2, BoxLayout.X_AXIS));
        zeile2.setBorder(new EmptyBorder(0, 5, 5, 5));

        JPanel zeile3 = new JPanel();
        zeile3.setLayout(new BoxLayout(zeile3, BoxLayout.X_AXIS));
        zeile3.setBorder(new EmptyBorder(0, 5, 5, 5));

        JPanel zeile4 = new JPanel();
        zeile4.setLayout(new BoxLayout(zeile4, BoxLayout.X_AXIS));
        zeile4.setBorder(new EmptyBorder(0, 5, 5, 5));

        kurzText = new JTextField();
        kurzText.setPreferredSize(new Dimension(192, 20));

        ort = new JTextField("derzeit ungenutzt");
        ort.setFocusAccelerator('o');
        ort.setEnabled(false);

        hyperlink = new JTextField("derzeit ungenutzt");
        hyperlink.setFocusAccelerator('h');
        hyperlink.setEnabled(false);

        JLabel l2 = new JLabel("Ort:");
        l2.setPreferredSize(new Dimension(60, 20));
        l2.setDisplayedMnemonic('o');
        l2.setEnabled(false);

        JLabel l3 = new JLabel("Hyperlink:");
        l3.setPreferredSize(new Dimension(60, 20));
        l3.setDisplayedMnemonic('h');
        l3.setEnabled(false);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 1));
        textPanel.setPreferredSize(new Dimension(500, 120));
        langText = new JTextArea();
        langText.setBorder(new BevelBorder(BevelBorder.LOWERED));
        textPanel.add(langText);

        zeile1.add(kurzText);
        zeile1.add(Box.createRigidArea(new Dimension(20, 0)));

        zeile2.add(textPanel);

        zeile3.add(l2);
        zeile3.add(ort);

        zeile4.add(l3);
        zeile4.add(hyperlink);

        beschreibung.add(zeile1);
        beschreibung.add(zeile2);
        beschreibung.add(zeile3);
        beschreibung.add(zeile4);

        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add("Center", beschreibung);

        return pane;
    }

    // ItemListener // ItemListener // ItemListener // ItemListener //
    // ItemListener //
    public void addItemListener(ItemListener listener) {
        mItemListenerList.add(ItemListener.class, listener);
    }

    public void removeItemListener(ItemListener listener) {
        mItemListenerList.remove(ItemListener.class, listener);
    }

    public void fill(Termin t){
        // Wait for implementation
    }

    public void getAttribute(){
        // Do nothing because why not
    }

    protected void fireItemEvent(ItemEvent e) {
        Object[] listeners = mItemListenerList.getListenerList();

        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ItemListener.class) {
                ((ItemListener) listeners[i + 1]).itemStateChanged(e);
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {
        fireItemEvent(e);
    }
}
