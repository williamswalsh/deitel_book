package networking;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class URLTest2 extends JFrame {
    private final ArrayList<String> sites;
    private final JPanel selectionJPanel;
    private final JLabel listSelectionPrompt;
    private final JList<String> siteList;
    private final JEditorPane webView;
    private final JScrollPane scrollWebPane;
    private final JScrollPane listPane;

    public URLTest2() throws HeadlessException, MalformedURLException {
        super("Testing Uniform Resource Locators");
//        setLayout(new GridLayout(2,1,5,5));
        setLayout(new BorderLayout());

//        Data structures
        sites = new ArrayList<>();

        sites.add("https://deitel.com");
        sites.add("https://deitel.com/python-for-programmers-book");
        sites.add("https://deitel.com/java-for-programmers-course");
        sites.add("https://deitel.com/terms-of-use");
        sites.add("https://deitel.com/python-data-science-and-ai-for-programmers-course");
        sites.add("https://deitel.com/python-for-programmers-course");
        sites.add("https://deitel.com/pythonforprogrammers_toc");
        sites.add("https://deitel.com/category");
        sites.add("https://deitel.com/category/general");
        sites.add("https://deitel.com/category/programming-languages");
        sites.add("https://deitel.com/category/programming-languages/java");
        sites.add("https://deitel.com/category/getting-started");
        sites.add("https://deitel.com/data-science-and-ai-for-python-programmers-course");
        sites.add("https://deitel.com/webinars");
        sites.add("https://deitel.com/privacy-policy");
        sites.add("https://deitel.com/faq");
        sites.add("https://deitel.com/c-plus-plus-how-to-program-10-e");
        sites.add("https://deitel.com/affiliate-disclosure");
        sites.add("https://deitel.com/training");
        sites.add("https://deitel.com/training/self-paced-video-training");
        sites.add("https://deitel.com/author");
        sites.add("https://deitel.com/author/pdeitel");
        sites.add("https://deitel.com/about");
        sites.add("https://deitel.com/books");
        sites.add("https://deitel.com/blog");
        sites.add("https://deitel.com/2020");
        sites.add("https://deitel.com/2020/01");
        sites.add("https://deitel.com/2020/01/28");
        sites.add("https://deitel.com/2020/01/28/welcome-to-the-new-deitel-com");
        sites.add("https://deitel.com/2020/01/28/are-you-just-getting-started-in-java-programming");
        sites.add("https://deitel.com/java-how-to-program-11-e-late-objects-version");
        sites.add("https://deitel.com/pythonforprogrammers_preface");
        sites.add("https://deitel.com/on-site-courses");
        sites.add("https://deitel.com/c-how-to-program-8-e");
        sites.add("https://deitel.com/contact-us");
        sites.add("https://deitel.com/internet-and-world-wide-web-how-to-program-5-e");
        sites.add("https://deitel.com/visual-basic-2012-how-to-program");
        sites.add("https://deitel.com/visual-c-how-to-program-6-e");
        sites.add("https://deitel.com/c-sharp-6-for-programmers");
        sites.add("https://deitel.com/intro-to-python-for-computer-science-and-data-science");
        sites.add("https://deitel.com/java-9-for-programmers");
        sites.add("https://deitel.com/wp-content");
        sites.add("https://deitel.com/wp-content/cache");
        sites.add("https://deitel.com/wp-content/cache/min");
        sites.add("https://deitel.com/wp-content/cache/min/1");
        sites.add("https://deitel.com/wp-content/cache/min/1/f16b6ac3dabafc758d555fba3f9a4c2b.css.tmp.tmp");
        sites.add("https://deitel.com/other-books");
        sites.add("https://deitel.com/java-how-to-program-11-e-early-objects-version");

//        UI components
        listSelectionPrompt = new JLabel("Choose a site to Browse to:");
        siteList = new JList(sites.toArray());
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
                webView.setPage(new URL(siteList.getSelectedValue()));
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
        URLTest2 app = new URLTest2();
    }
}
