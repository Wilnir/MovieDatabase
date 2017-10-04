/*----------------------------------------------------
MovieDatabase

A first test to make a movie database with a GUI

TO DO:
Add tooltips
Add "set" thread
Auto menubar (osx/windows)

22-09-2017
 -----------------------------------------------------*/

package com.company;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MainProgramGUI {
    private static JFrame frame;
    private JPanel rootPanel;
    private JList<Movie> movieJList;
    private JButton AddMovieJButton;
    private JButton EditMovieJButton;
    private JButton DelMovieJButton;
    private JTextPane movieDataPane;


    public MainProgramGUI() {

        // Create ArrayLists for actors and directors
        ArrayList<Actor> actorList = new ArrayList<Actor>();
        ArrayList<Director> directorList = new ArrayList<Director>();

        // Creating som persons and putting them in the lists. / Just to test
        Actor IanZiering = new Actor("Ian", "Ziering", 1962, true);
        Director AnthonyFerrante = new Director("Anthony", "Ferrante", 1964, true);
        actorList.add(IanZiering);
        directorList.add(AnthonyFerrante);

        // Create a list of movies using the DefaultListModel
        DefaultListModel<Movie> movieListModel = new DefaultListModel<Movie>();
        movieListModel.addElement(new Movie("Sharknado", 2013, 1.26, 3.3, IanZiering, AnthonyFerrante));
        movieListModel.addElement(new Movie("Sharknado 2: The Second One", 2014, 1.35, 4.1, IanZiering, AnthonyFerrante));
        movieListModel.addElement(new Movie("Sharknado 3: Oh Hell No!", 2015, 1.33, 4.2, IanZiering, AnthonyFerrante));
        movieListModel.addElement(new Movie("Sharknado 4: The 4th Awakens", 2016, 1.35, 4.0, IanZiering, AnthonyFerrante));
        movieListModel.addElement(new Movie("Sharknado 5: Global Swarming", 2017, 1.30, 4.3, IanZiering, AnthonyFerrante));

        // Setup for the movie JList
        movieJList.setCellRenderer(new MovieCellRenderer());
        movieJList.setModel(movieListModel);
        movieJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Get movie form JList selection
        movieJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Check that selection is completed
                if (!e.getValueIsAdjusting()) {
                    if (movieJList.getSelectedIndex() == -1) {
                        movieDataPane.setText("Select a movie from the list.");
                        DelMovieJButton.setEnabled(false);
                    } else
                        movieDataPane.setText(movieJList.getSelectedValue().toString());
                        DelMovieJButton.setEnabled(true);
                }

                }
        });

        // Remove movie from list with remove button.
        DelMovieJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = movieJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    movieListModel.remove(selectedIndex);
                }
            }

        });



    }


    public static void main(String[] args) {
        // Setup for the main window
        EventQueue.invokeLater(() -> {
            frame = new JFrame("MainWindow");
            frame.setContentPane(new MainProgramGUI().rootPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(800, 600));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }
}
