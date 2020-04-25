package networking;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class URLTest extends JFrame {
    private final HashMap<String, String> sites;
    private final JPanel selectionJPanel;
    private final JLabel listSelectionPrompt;
    private final JList<String> siteList;
    private final JEditorPane webView;
    private final JScrollPane scrollWebPane;
    private final JScrollPane listPane;

    public URLTest() throws HeadlessException, MalformedURLException {
        super("Testing Uniform Resource Locators");
//        setLayout(new GridLayout(2,1,5,5));
        setLayout(new BorderLayout());

//        Data structures
        sites = new HashMap<>();
        sites.put("rockwell","https://rockwellcollege.ie");
        sites.put("google", "https://google.com");
        sites.put("magicseaweed", "httpsmagicseawe:ed.com");
        sites.put("stackoverflow", "https://stackoverflow.com");
        sites.put("stackoverflow1", "https://stackoverflow.com");
        sites.put("stackoverflow2", "https://stackoverflow.com");
        sites.put("stackoverflow3", "https://stackoverflow.com");
        sites.put("stackoverflow4", "https://stackoverflow.com");
        sites.put("stackoverflow5", "https://stackoverflow.com");
        sites.put("stackoverflow6", "https://stackoverflow.com");
        sites.put("stackoverflow7", "https://stackoverflow.com");
        sites.put("stackoverflow8", "https://stackoverflow.com");
        sites.put("stackoverflo8", "https://stackoverflow.com");
        sites.put("stackoverflw", "https://stackoverflow.com");
        sites.put("stackoverlow", "https://stackoverflow.com");
        sites.put("stackoerflow", "https://stackoverflow.com");
        sites.put("stacoverflow", "https://stackoverflow.com");
        sites.put("stckoverflow", "https://stackoverflow.com");
        sites.put("sckoverflow", "https://stackoverflow.com");
        sites.put("stackoverfl0w", "https://stackoverflow.com");
        sites.put("staoverflow", "https://stackoverflow.com");
        sites.put("stacverflow", "https://stackoverflow.com");
        sites.put("stackerflow", "https://stackoverflow.com");

//        UI components
        listSelectionPrompt = new JLabel("Choose a site to Browse to:");
        siteList = new JList(sites.keySet().toArray());
        listPane = new JScrollPane(siteList);

        selectionJPanel = new JPanel(new GridLayout(2,1,5,5));
        selectionJPanel.add(listSelectionPrompt);
        selectionJPanel.add(listPane);
        webView = new JEditorPane();
        webView.setEditable(false);
        scrollWebPane = new JScrollPane(webView);

//        Event Listener
        siteList.addListSelectionListener(e -> {
            try {
                webView.setPage(new URL(sites.get(siteList.getSelectedValue())));
            } catch (MalformedURLException ex) {
                webView.setContentType("text/html");
                webView.setText("<html>Malformed URL</html>");
            } catch (IOException ex) {
                webView.setContentType("text/html");
                webView.setText("<html>Could not load</html>"); }
        });

//         Way without lambda function
//        siteList.addListSelectionListener(new ListSelectionListener() {
//                                              @Override
//                                              public void valueChanged(ListSelectionEvent e) {
//                                                  try {
//
//                                                      URL selectedURL = new URL(sites.get(siteList.getSelectedValue()).toString());
//                                                      webView.setPage(selectedURL);
//                                                  } catch (MalformedURLException ex) {
//                                                      ex.printStackTrace();
//                                                  } catch (IOException ex) {
//                                                      webView.setContentType("text/html");
//                                                      webView.setText("<html>Could not load</html>");
//                                                  }
//                                              }
//                                          });


//        Adding components to Frame
        add(selectionJPanel, BorderLayout.NORTH);
        add(scrollWebPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000,800));
        setVisible(true);
    }

    public static void main(String[] args) throws MalformedURLException {
        URLTest app = new URLTest();
    }
}
